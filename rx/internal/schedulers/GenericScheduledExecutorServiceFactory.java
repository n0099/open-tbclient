package rx.internal.schedulers;

import com.baidu.tieba.dcc;
import com.baidu.tieba.h8c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;
/* loaded from: classes2.dex */
public enum GenericScheduledExecutorServiceFactory {
    ;
    
    public static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    public static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);

    public static ScheduledExecutorService create() {
        h8c<? extends ScheduledExecutorService> a = dcc.a();
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
