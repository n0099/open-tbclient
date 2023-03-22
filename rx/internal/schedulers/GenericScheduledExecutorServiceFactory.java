package rx.internal.schedulers;

import com.baidu.tieba.fsa;
import com.baidu.tieba.vva;
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
        fsa<? extends ScheduledExecutorService> a = vva.a();
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
