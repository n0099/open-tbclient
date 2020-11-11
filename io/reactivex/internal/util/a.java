package io.reactivex.internal.util;

import io.reactivex.c.j;
import io.reactivex.u;
/* loaded from: classes17.dex */
public class a<T> {
    final int capacity;
    int offset;
    final Object[] pQu;
    Object[] pQv;

    /* renamed from: io.reactivex.internal.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC1075a<T> extends j<T> {
        @Override // io.reactivex.c.j
        boolean test(T t);
    }

    public a(int i) {
        this.capacity = i;
        this.pQu = new Object[i + 1];
        this.pQv = this.pQu;
    }

    public void add(T t) {
        int i = this.capacity;
        int i2 = this.offset;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.pQv[i] = objArr;
            this.pQv = objArr;
            i2 = 0;
        }
        this.pQv[i2] = t;
        this.offset = i2 + 1;
    }

    public void bO(T t) {
        this.pQu[0] = t;
    }

    public void a(InterfaceC1075a<? super T> interfaceC1075a) {
        int i;
        Object[] objArr = this.pQu;
        int i2 = this.capacity;
        for (Object[] objArr2 = objArr; objArr2 != null; objArr2 = objArr2[i2]) {
            while (i < i2) {
                Object obj = objArr2[i];
                i = (obj == null || interfaceC1075a.test(obj)) ? 0 : i + 1;
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
        Object[] objArr = this.pQu;
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
    public <U> boolean b(u<? super U> uVar) {
        Object[] objArr = this.pQu;
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
