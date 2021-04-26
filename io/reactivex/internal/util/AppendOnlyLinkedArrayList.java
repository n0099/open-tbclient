package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;
/* loaded from: classes7.dex */
public class AppendOnlyLinkedArrayList<T> {
    public final int capacity;
    public final Object[] head;
    public int offset;
    public Object[] tail;

    /* loaded from: classes7.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i2) {
        this.capacity = i2;
        Object[] objArr = new Object[i2 + 1];
        this.head = objArr;
        this.tail = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.head;
        int i2 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, subscriber)) {
                    return true;
                }
            }
            objArr = objArr[i2];
        }
    }

    public void add(T t) {
        int i2 = this.capacity;
        int i3 = this.offset;
        if (i3 == i2) {
            Object[] objArr = new Object[i2 + 1];
            this.tail[i2] = objArr;
            this.tail = objArr;
            i3 = 0;
        }
        this.tail[i3] = t;
        this.offset = i3 + 1;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i2;
        int i3 = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = objArr[i3]) {
            while (i2 < i3) {
                Object obj = objArr[i2];
                i2 = (obj == null || nonThrowingPredicate.test(obj)) ? 0 : i2 + 1;
            }
        }
    }

    public void setFirst(T t) {
        this.head[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.head;
        int i2 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
            objArr = objArr[i2];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objArr = this.head;
        int i2 = this.capacity;
        while (true) {
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = objArr[i3];
                if (obj == null || biPredicate.test(s, obj)) {
                    return;
                }
            }
            objArr = objArr[i2];
        }
    }
}
