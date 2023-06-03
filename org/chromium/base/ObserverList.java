package org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes2.dex */
public class ObserverList<E> implements Iterable<E> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public int mCount;
    public int mIterationDepth;
    public boolean mNeedsCompact;
    public final List<E> mObservers = new ArrayList();

    /* loaded from: classes2.dex */
    public interface RewindableIterator<E> extends Iterator<E> {
        void rewind();
    }

    /* loaded from: classes2.dex */
    public class ObserverListIterator implements RewindableIterator<E> {
        public int mIndex;
        public boolean mIsExhausted;
        public int mListEndMarker;

        public ObserverListIterator() {
            ObserverList.this.incrementIterationDepth();
            this.mListEndMarker = ObserverList.this.capacity();
        }

        private void compactListIfNeeded() {
            if (!this.mIsExhausted) {
                this.mIsExhausted = true;
                ObserverList.this.decrementIterationDepthAndCompactIfNeeded();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.mIndex;
            while (i < this.mListEndMarker && ObserverList.this.getObserverAt(i) == null) {
                i++;
            }
            if (i < this.mListEndMarker) {
                return true;
            }
            compactListIfNeeded();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            while (true) {
                int i = this.mIndex;
                if (i >= this.mListEndMarker || ObserverList.this.getObserverAt(i) != null) {
                    break;
                }
                this.mIndex++;
            }
            int i2 = this.mIndex;
            if (i2 < this.mListEndMarker) {
                ObserverList observerList = ObserverList.this;
                this.mIndex = i2 + 1;
                return (E) observerList.getObserverAt(i2);
            }
            compactListIfNeeded();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.chromium.base.ObserverList.RewindableIterator
        public void rewind() {
            compactListIfNeeded();
            ObserverList.this.incrementIterationDepth();
            this.mListEndMarker = ObserverList.this.capacity();
            this.mIsExhausted = false;
            this.mIndex = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int capacity() {
        return this.mObservers.size();
    }

    private void compact() {
        for (int size = this.mObservers.size() - 1; size >= 0; size--) {
            if (this.mObservers.get(size) == null) {
                this.mObservers.remove(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementIterationDepthAndCompactIfNeeded() {
        int i = this.mIterationDepth - 1;
        this.mIterationDepth = i;
        if (i > 0 || !this.mNeedsCompact) {
            return;
        }
        this.mNeedsCompact = false;
        compact();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void incrementIterationDepth() {
        this.mIterationDepth++;
    }

    public void clear() {
        boolean z;
        this.mCount = 0;
        if (this.mIterationDepth == 0) {
            this.mObservers.clear();
            return;
        }
        int size = this.mObservers.size();
        boolean z2 = this.mNeedsCompact;
        if (size != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mNeedsCompact = z2 | z;
        for (int i = 0; i < size; i++) {
            this.mObservers.set(i, null);
        }
    }

    public boolean isEmpty() {
        if (this.mCount == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new ObserverListIterator();
    }

    public RewindableIterator<E> rewindableIterator() {
        return new ObserverListIterator();
    }

    public int size() {
        return this.mCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E getObserverAt(int i) {
        return this.mObservers.get(i);
    }

    public boolean addObserver(E e) {
        if (e != null && !this.mObservers.contains(e)) {
            this.mObservers.add(e);
            this.mCount++;
            return true;
        }
        return false;
    }

    public boolean hasObserver(E e) {
        return this.mObservers.contains(e);
    }

    public boolean removeObserver(E e) {
        int indexOf;
        if (e == null || (indexOf = this.mObservers.indexOf(e)) == -1) {
            return false;
        }
        if (this.mIterationDepth == 0) {
            this.mObservers.remove(indexOf);
        } else {
            this.mNeedsCompact = true;
            this.mObservers.set(indexOf, null);
        }
        this.mCount--;
        return true;
    }
}
