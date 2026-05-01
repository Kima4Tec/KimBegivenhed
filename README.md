## Flowchart

```mermaid
flowchart TD
A[App starter - MainActivity] --> B[Opret eventList]
B --> C[Vis RecyclerView]

C --> D[EventAdapter]
D --> E[onCreateViewHolder]
D --> F[onBindViewHolder]
F --> G[Vis navn og dato]

G --> H[Bruger interaktion]

H -->|Klik på Details| I[Start DetailsActivity]
I --> J[Modtag data via Intent]
J --> K[Vis billede, navn, dato, beskrivelse]
K --> L[Klik 'Åbn browser']
L --> M[Åbn URL i browser]

H -->|Klik på Tilmeld| N[Vis AlertDialog]
N --> O[Vis Toast: Tilmeldt]

H -->|Søg| P[filterEvents()]
P --> Q[Opdater filteredList]
Q --> R[notifyDataSetChanged]
R --> C

H -->|Tilføj event| S[Start AddEventActivity]
S --> T[Bruger indtaster data + vælger dato]
T --> U[Send data tilbage med setResult]
U --> V[Modtag via ActivityResultLauncher]
V --> W[Tilføj til eventList]
W --> Q
```




<img width="400" height="845" alt="Forside" src="https://github.com/user-attachments/assets/a33a4335-e99e-487e-98db-55fa677b9bd4" />

<img width="398" height="837" alt="Detaljeside" src="https://github.com/user-attachments/assets/5d5adb06-c5cb-44d9-bf36-179816b95711" />

<img width="398" height="833" alt="EventOpret" src="https://github.com/user-attachments/assets/1c2bb641-d72e-4e5a-b900-bd223aea97a8" />

<img width="393" height="842" alt="EventMedDatePicker" src="https://github.com/user-attachments/assets/4ce5835d-7e77-4133-8329-fcd3a16e9df9" />

<img width="397" height="837" alt="Dialogside" src="https://github.com/user-attachments/assets/f29e3ec3-3b7f-42e9-8b7d-df78bcd2ce71" />

<img width="387" height="835" alt="Tilmeldt" src="https://github.com/user-attachments/assets/e0098e0d-cb76-485e-bd8c-f13aa290e603" />

