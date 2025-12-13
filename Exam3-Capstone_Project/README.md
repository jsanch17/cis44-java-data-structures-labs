
# Capstone Project – Option C: The Intelligent Cache (LRU)

## 1. Problem Statement
We need a cache that provides instant access to frequently used data while managing limited memory. The cache must support:
- `get(key)`: Return value if key exists.
- `put(key, value)`: Insert/update; evict least recently used (LRU) item when capacity is exceeded.

## 2. Chosen Data Structures
- **HashMap<K, Node<K,V>>** — O(1) average-time key lookup to find the node representing the entry.
- **Doubly Linked List** — O(1) operations to move nodes to the front (marking "recently used") and remove nodes from the tail (eviction of least-recently used).

### Trade-offs
- **Array / Dynamic Array**: Fast indexed access, but not ideal for frequent mid-structure reordering (moving recently used items) in O(1); also not O(1) lookup by arbitrary keys.
- **Linked List only**: Good for O(1) insertion/removal, but lookup would be O(n) without a hash.
- **HashMap + Doubly Linked List (LRU pattern)**: Best of both—O(1) average-time lookup and O(1) reordering.

## 3. Big-O Justification
- `get(key)`: **O(1)** average (hash map lookup), plus **O(1)** list move-to-front.
- `put(key, value)`:
  - Update existing key: **O(1)** (hash lookup + list move-to-front).
  - Insert new key:
    - If below capacity: **O(1)** (hash insert + list add-front).
    - If at capacity: **O(1)** (remove tail + delete from hash + add-front).
- Space: **O(capacity)** for map + list nodes.

## 4. Constraints & Assumptions
- Fixed positive capacity (> 0).
- Keys/values are generic but implemented with `int` for simplicity.
- Thread-safety is **not** required for this assignment.
- Eviction policy: strictly **LRU** (least recently used).

## 5. UML Diagram (High-Level)
