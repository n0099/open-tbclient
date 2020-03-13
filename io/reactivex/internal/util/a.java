package io.reactivex.internal.util;

import io.reactivex.c.j;
import io.reactivex.u;
/* loaded from: classes7.dex */
public class a<T> {
    final int capacity;
    final Object[] nAm;
    Object[] nAn;
    int offset;

    /* renamed from: io.reactivex.internal.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0767a<T> extends j<T> {
        @Override // io.reactivex.c.j
        boolean test(T t);
    }

    public a(int i) {
        this.capacity = i;
        this.nAm = new Object[i + 1];
        this.nAn = this.nAm;
    }

    public void add(T t) {
        int i = this.capacity;
        int i2 = this.offset;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.nAn[i] = objArr;
            this.nAn = objArr;
            i2 = 0;
        }
        this.nAn[i2] = t;
        this.offset = i2 + 1;
    }

    public void bM(T t) {
        this.nAm[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x000e, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(InterfaceC0767a<? super T> interfaceC0767a) {
        Object[] objArr = this.nAm;
        int i = this.capacity;
        for (Object[] objArr2 = objArr; objArr2 != null; objArr2 = objArr2[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr2[i2];
                if (obj == null) {
                    break;
                } else if (interfaceC0767a.test(obj)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x000f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean b(org.a.c<? super U> cVar) {
        Object[] objArr = this.nAm;
        int i = this.capacity;
        for (Object[] objArr2 = objArr; objArr2 != null; objArr2 = objArr2[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = objArr2[i2];
                if (objArr3 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr3, cVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x000f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean d(u<? super U> uVar) {
        Object[] objArr = this.nAm;
        int i = this.capacity;
        for (Object[] objArr2 = objArr; objArr2 != null; objArr2 = objArr2[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = objArr2[i2];
                if (objArr3 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr3, uVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
