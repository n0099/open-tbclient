package io.reactivex.observers;
/* loaded from: classes7.dex */
public enum BaseTestConsumer$TestWaitStrategy implements Runnable {
    SPIN { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.1
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
        }
    },
    YIELD { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.2
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            Thread.yield();
        }
    },
    SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.3
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(1);
        }
    },
    SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.4
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(10);
        }
    },
    SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.5
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(100);
        }
    },
    SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.6
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(1000);
        }
    };

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.lang.Runnable
    public abstract void run();
}
