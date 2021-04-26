package io.reactivex.observers;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import io.reactivex.Notification;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> implements Disposable {
    public boolean checkSubscriptionOnce;
    public long completions;
    public int establishedFusionMode;
    public int initialFusionMode;
    public Thread lastThread;
    public CharSequence tag;
    public boolean timeout;
    public final List<T> values = new VolatileSizeArrayList();
    public final List<Throwable> errors = new VolatileSizeArrayList();
    public final CountDownLatch done = new CountDownLatch(1);

    /* loaded from: classes7.dex */
    public enum TestWaitStrategy implements Runnable {
        SPIN { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.1
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
            }
        },
        YIELD { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.2
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                Thread.yield();
            }
        },
        SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.3
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1);
            }
        },
        SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.4
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(10);
            }
        },
        SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.5
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(100);
            }
        },
        SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer.TestWaitStrategy.6
            @Override // io.reactivex.observers.BaseTestConsumer.TestWaitStrategy, java.lang.Runnable
            public void run() {
                TestWaitStrategy.sleep(1000);
            }
        };

        public static void sleep(int i2) {
            try {
                Thread.sleep(i2);
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // java.lang.Runnable
        public abstract void run();
    }

    public static String valueAndClass(Object obj) {
        if (obj != null) {
            return obj + " (class: " + obj.getClass().getSimpleName() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return StringUtil.NULL_STRING;
    }

    public final U assertComplete() {
        long j = this.completions;
        if (j != 0) {
            if (j <= 1) {
                return this;
            }
            throw fail("Multiple completions: " + j);
        }
        throw fail("Not completed");
    }

    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    public final U assertError(Throwable th) {
        return assertError(Functions.equalsWith(th));
    }

    public final U assertErrorMessage(String str) {
        int size = this.errors.size();
        if (size != 0) {
            if (size == 1) {
                String message = this.errors.get(0).getMessage();
                if (ObjectHelper.equals(str, message)) {
                    return this;
                }
                throw fail("Error message differs; Expected: " + str + ", Actual: " + message);
            }
            throw fail("Multiple errors");
        }
        throw fail("No errors");
    }

    public final U assertFailure(Class<? extends Throwable> cls, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    public final U assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertErrorMessage(str).assertNotComplete();
    }

    public final U assertNever(T t) {
        int size = this.values.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (ObjectHelper.equals(this.values.get(i2), t)) {
                throw fail("Value at position " + i2 + " is equal to " + valueAndClass(t) + "; Expected them to be different");
            }
        }
        return this;
    }

    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    public final U assertNoTimeout() {
        if (this.timeout) {
            throw fail("Timeout?!");
        }
        return this;
    }

    public final U assertNoValues() {
        return assertValueCount(0);
    }

    public final U assertNotComplete() {
        long j = this.completions;
        int i2 = (j > 1L ? 1 : (j == 1L ? 0 : -1));
        if (i2 != 0) {
            if (i2 <= 0) {
                return this;
            }
            throw fail("Multiple completions: " + j);
        }
        throw fail("Completed!");
    }

    public abstract U assertNotSubscribed();

    public final U assertNotTerminated() {
        if (this.done.getCount() != 0) {
            return this;
        }
        throw fail("Subscriber terminated!");
    }

    public final U assertResult(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    public abstract U assertSubscribed();

    public final U assertTerminated() {
        if (this.done.getCount() == 0) {
            long j = this.completions;
            if (j <= 1) {
                int size = this.errors.size();
                if (size > 1) {
                    throw fail("Terminated with multiple errors: " + size);
                } else if (j == 0 || size == 0) {
                    return this;
                } else {
                    throw fail("Terminated with multiple completions and errors: " + j);
                }
            }
            throw fail("Terminated with multiple completions: " + j);
        }
        throw fail("Subscriber still running!");
    }

    public final U assertTimeout() {
        if (this.timeout) {
            return this;
        }
        throw fail("No timeout?!");
    }

    public final U assertValue(T t) {
        if (this.values.size() == 1) {
            T t2 = this.values.get(0);
            if (ObjectHelper.equals(t, t2)) {
                return this;
            }
            throw fail("Expected: " + valueAndClass(t) + ", Actual: " + valueAndClass(t2));
        }
        throw fail("Expected: " + valueAndClass(t) + ", Actual: " + this.values);
    }

    @Experimental
    public final U assertValueAt(int i2, T t) {
        int size = this.values.size();
        if (size != 0) {
            if (i2 < size) {
                T t2 = this.values.get(i2);
                if (ObjectHelper.equals(t, t2)) {
                    return this;
                }
                throw fail("Expected: " + valueAndClass(t) + ", Actual: " + valueAndClass(t2));
            }
            throw fail("Invalid index: " + i2);
        }
        throw fail("No values");
    }

    public final U assertValueCount(int i2) {
        int size = this.values.size();
        if (size == i2) {
            return this;
        }
        throw fail("Value counts differ; Expected: " + i2 + ", Actual: " + size);
    }

    public final U assertValueSequence(Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i2 = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (!ObjectHelper.equals(next, next2)) {
                throw fail("Values at position " + i2 + " differ; Expected: " + valueAndClass(next) + ", Actual: " + valueAndClass(next2));
            }
            i2++;
        }
        if (hasNext2) {
            throw fail("More values received than expected (" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        } else if (hasNext) {
            throw fail("Fewer values received than expected (" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            return this;
        }
    }

    public final U assertValueSet(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            assertNoValues();
            return this;
        }
        for (T t : this.values) {
            if (!collection.contains(t)) {
                throw fail("Value not in the expected collection: " + valueAndClass(t));
            }
        }
        return this;
    }

    public final U assertValues(T... tArr) {
        int size = this.values.size();
        if (size != tArr.length) {
            throw fail("Value count differs; Expected: " + tArr.length + " " + Arrays.toString(tArr) + ", Actual: " + size + " " + this.values);
        }
        for (int i2 = 0; i2 < size; i2++) {
            T t = this.values.get(i2);
            T t2 = tArr[i2];
            if (!ObjectHelper.equals(t2, t)) {
                throw fail("Values at position " + i2 + " differ; Expected: " + valueAndClass(t2) + ", Actual: " + valueAndClass(t));
            }
        }
        return this;
    }

    @Experimental
    public final U assertValuesOnly(T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    public final U await() throws InterruptedException {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    public final U awaitCount(int i2) {
        return awaitCount(i2, TestWaitStrategy.SLEEP_10MS, 5000L);
    }

    public final U awaitDone(long j, TimeUnit timeUnit) {
        try {
            if (!this.done.await(j, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e2) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e2);
        }
    }

    public final boolean awaitTerminalEvent() {
        try {
            await();
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U clearTimeout() {
        this.timeout = false;
        return this;
    }

    public final long completions() {
        return this.completions;
    }

    public final int errorCount() {
        return this.errors.size();
    }

    public final List<Throwable> errors() {
        return this.errors;
    }

    public final AssertionError fail(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (");
        sb.append("latch = ");
        sb.append(this.done.getCount());
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("values = ");
        sb.append(this.values.size());
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("errors = ");
        sb.append(this.errors.size());
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append("completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    public final List<List<Object>> getEvents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(values());
        arrayList.add(errors());
        ArrayList arrayList2 = new ArrayList();
        for (long j = 0; j < this.completions; j++) {
            arrayList2.add(Notification.createOnComplete());
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean isTerminated() {
        return this.done.getCount() == 0;
    }

    public final boolean isTimeout() {
        return this.timeout;
    }

    public final Thread lastThread() {
        return this.lastThread;
    }

    public final int valueCount() {
        return this.values.size();
    }

    public final List<T> values() {
        return this.values;
    }

    public final U withTag(CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    public final U assertError(Class<? extends Throwable> cls) {
        return assertError(Functions.isInstanceOf(cls));
    }

    public final U awaitCount(int i2, Runnable runnable) {
        return awaitCount(i2, runnable, 5000L);
    }

    public final U assertError(Predicate<Throwable> predicate) {
        int size = this.errors.size();
        if (size != 0) {
            boolean z = false;
            Iterator<Throwable> it = this.errors.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    if (predicate.test(it.next())) {
                        z = true;
                        break;
                    }
                } catch (Exception e2) {
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            if (z) {
                if (size == 1) {
                    return this;
                }
                throw fail("Error present but other errors as well");
            }
            throw fail("Error not present");
        }
        throw fail("No errors");
    }

    public final boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z = this.done.getCount() == 0 || this.done.await(j, timeUnit);
        this.timeout = !z;
        return z;
    }

    public final U awaitCount(int i2, Runnable runnable, long j) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (j > 0 && System.currentTimeMillis() - currentTimeMillis >= j) {
                this.timeout = true;
                break;
            } else if (this.done.getCount() == 0 || this.values.size() >= i2) {
                break;
            } else {
                runnable.run();
            }
        }
        return this;
    }

    public final boolean awaitTerminalEvent(long j, TimeUnit timeUnit) {
        try {
            return await(j, timeUnit);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final U assertFailure(Predicate<Throwable> predicate, T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(predicate).assertNotComplete();
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: T, ? super T */
    public final U assertNever(Predicate<? super T> predicate) {
        int size = this.values.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                if (predicate.test((T) this.values.get(i2))) {
                    throw fail("Value at position " + i2 + " matches predicate " + predicate.toString() + ", which was not expected.");
                }
            } catch (Exception e2) {
                throw ExceptionHelper.wrapOrThrow(e2);
            }
        }
        return this;
    }

    public final U assertValue(Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("Value present but other values as well");
    }

    public final U assertValueAt(int i2, Predicate<T> predicate) {
        if (this.values.size() != 0) {
            if (i2 < this.values.size()) {
                try {
                    if (predicate.test(this.values.get(i2))) {
                        return this;
                    }
                    throw fail("Value not present");
                } catch (Exception e2) {
                    throw ExceptionHelper.wrapOrThrow(e2);
                }
            }
            throw fail("Invalid index: " + i2);
        }
        throw fail("No values");
    }
}
