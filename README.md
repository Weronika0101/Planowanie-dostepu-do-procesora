# Planowanie-dostepu-do-procesora

Program symuluje działanie algorytmów planowania dostępu do procesora dla zgłaszających się procesów.Jest możliwość sterowania parametrami symulacji ( ilość procesów do wygererowania, kwant czasu ).  Zbadano średni czas oczekiwania procesów dla różnych algorytmów planowania:
- FCFS („First Come First Served”)
- SJF z wywłaszczaniem i bez („Shortest Job First”)
- rotacyjnego z możliwością wyboru kwantu czasu („Round Robin”)
## FCFS (First Come First Served)
- przydział czasu w kolejności zgłaszania się procesów
- najprostsza implementacja (kolejka FIFO)
- brak wywłaszczania
- kłopotliwy w systemach z podziałem czasu
- efekt: krótkie procesy są wstrzymywane przez długie
- zalety: sprawiedliwy, niski narzut systemowy
- wady: długi sredni czas oczekiwania i wariancja czasu oczekiwania, nieakceptowalny w
systemach z podziałem czasu
## SJF (Shortest Job First)
- Algorytm wiąże z każdym procesem długość jego najbliższej fazy procesora. Procesor jest
przydzielany najkrótszemu.
- Przy równych fazach procesora mamy FCFS
- SJF jest optymalny (dowód: umieszczenie krótkiego przed długim bardziej zmniejsza czas
oczekiwania krótkiego niż zwiększa długiego)
- SJF może być:
    - niewywłaszczający
    - wywłaszczający (gdy dł. fazy nowego jest krótsza niż to, co zostało aktualnie wykonywanemu procesowi)
## PLANOWANIE ROTACYJNE (Round Robin - RR, pol. karuzelowe) 
- ustala się kwant czasu (~10-100 ms)
- kolejka procesów jest traktowana jak cykliczna FIFO
- algorytm przegląda kolejkę i kolejno przydziela każdemu kwant czasu (jeśli proces się w nim nie
zakończy – wraca do kolejki, a długość jego fazy procesora zmniejsza się o kwant czasu).
- algorytm jest wywłaszczający
- gdy jest N procesów a kwant czasu wynosi Q, max. czas oczekiwania może wynieść (N-1)Q
- efekty:
    - gdy Q rośnie nieograniczenie; planowanie rotacyjne  FCFS
    - gdy Q zmierza do 0 zachodzi dzielenie procesora – każdy proces dysponuje procesorem o
prędkości 1/N rzeczywistego.
- Aspekty wydajnościowe:
    - wskazany jest długi kwant czasu w porównaniu z przełączaniem kontekstu (wpp zła
wydajność)
    - reguła doświadczalna: kwant czasu powinien być dłuższy niż 80% faz procesora dla
optymalnej wydajności.
