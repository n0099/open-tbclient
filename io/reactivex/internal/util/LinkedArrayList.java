package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class LinkedArrayList {
    public final int capacityHint;
    public Object[] head;
    public int indexInTail;
    public volatile int size;
    public Object[] tail;

    public LinkedArrayList(int i2) {
        this.capacityHint = i2;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            Object[] objArr = new Object[this.capacityHint + 1];
            this.head = objArr;
            this.tail = objArr;
            objArr[0] = obj;
            this.indexInTail = 1;
            this.size = 1;
            return;
        }
        int i2 = this.indexInTail;
        int i3 = this.capacityHint;
        if (i2 == i3) {
            Object[] objArr2 = new Object[i3 + 1];
            objArr2[0] = obj;
            this.tail[i3] = objArr2;
            this.tail = objArr2;
            this.indexInTail = 1;
            this.size++;
            return;
        }
        this.tail[i2] = obj;
        this.indexInTail = i2 + 1;
        this.size++;
    }

    public Object[] head() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i2 = this.capacityHint;
        int i3 = this.size;
        ArrayList arrayList = new ArrayList(i3 + 1);
        Object[] head = head();
        int i4 = 0;
        while (true) {
            int i5 = 0;
            while (i4 < i3) {
                arrayList.add(head[i5]);
                i4++;
                i5++;
                if (i5 == i2) {
                    break;
                }
            }
            return arrayList.toString();
            head = head[i2];
        }
    }
}
