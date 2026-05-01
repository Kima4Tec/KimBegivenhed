```mermaid
flowchart TD

A[App starter - MainActivity] --> B[Opret event liste]
B --> C[Vis RecyclerView]

C --> D[EventAdapter]
D --> E[Create ViewHolder]
D --> F[Bind data til view]
F --> G[Vis navn og dato]

G --> H[Bruger interaktion]

H -->|Klik Details| I[Start DetailsActivity]
I --> J[Modtag Intent data]
J --> K[Vis event detaljer]
K --> L[Klik Åbn browser]
L --> M[Åbn URL i browser]

H -->|Klik Tilmeld| N[Vis dialog]
N --> O[Vis Toast besked]

H -->|Søg| P[filter events]
P --> Q[Opdater filtered list]
Q --> R[notifyDataSetChanged]
R --> C

H -->|Tilføj event| S[Start AddEventActivity]
S --> T[Indtast data + vælg dato]
T --> U[Returner data med setResult]
U --> V[Modtag via ActivityResultLauncher]
V --> W[Tilføj til liste]
W --> Q
```




<img width="387" height="832" alt="Forside" src="https://github.com/user-attachments/assets/b0d18a8b-8c75-49b2-8448-53fe4ffd1374" />

<img width="398" height="837" alt="Detaljeside" src="https://github.com/user-attachments/assets/5d5adb06-c5cb-44d9-bf36-179816b95711" />

<img width="398" height="833" alt="EventOpret" src="https://github.com/user-attachments/assets/1c2bb641-d72e-4e5a-b900-bd223aea97a8" />

<img width="393" height="842" alt="EventMedDatePicker" src="https://github.com/user-attachments/assets/4ce5835d-7e77-4133-8329-fcd3a16e9df9" />

<img width="397" height="837" alt="Dialogside" src="https://github.com/user-attachments/assets/f29e3ec3-3b7f-42e9-8b7d-df78bcd2ce71" />

<img width="387" height="835" alt="Tilmeldt" src="https://github.com/user-attachments/assets/e0098e0d-cb76-485e-bd8c-f13aa290e603" />

