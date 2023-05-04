package rx.internal.schedulers;

import com.baidu.tieba.a6b;
import com.baidu.tieba.s9b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes9.dex */
public enum GenericScheduledExecutorServiceFactory {
    ;
    
    public static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    public static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);

    public static ScheduledExecutorService create() {
        a6b<? extends ScheduledExecutorService> a = s9b.a();
        if (a == null) {
            return createDefault();
        }
        return a.call();
    }

    public static ScheduledExecutorService createDefault() {
        return Executors.newScheduledThreadPool(1, threadFactory());
    }

    public static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }
}
