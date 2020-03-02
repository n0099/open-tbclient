package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public enum GenericScheduledExecutorServiceFactory {
    ;
    
    static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);

    static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }

    public static ScheduledExecutorService create() {
        rx.functions.e<? extends ScheduledExecutorService> dOW = rx.c.c.dOW();
        return dOW == null ? createDefault() : dOW.call();
    }

    static ScheduledExecutorService createDefault() {
        return Executors.newScheduledThreadPool(1, threadFactory());
    }
}
