package org.chromium.base.task;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.BuildConfig;
import org.chromium.base.task.AsyncTask;
import org.chromium.base.task.ChromeThreadPoolExecutor;
/* loaded from: classes2.dex */
public class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE;
    public static final int RUNNABLE_WARNING_COUNT = 32;
    public static final BlockingQueue<Runnable> sPoolWorkQueue;
    public static final ThreadFactory sThreadFactory;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    public ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    /* renamed from: org.chromium.base.task.ChromeThreadPoolExecutor$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements ThreadFactory {
        public final AtomicInteger mCount = new AtomicInteger(1);

        public static /* synthetic */ void a(Runnable runnable) {
            Process.setThreadPriority(10);
            runnable.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Runnable runnable2 = new Runnable() { // from class: com.baidu.tieba.ukb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        ChromeThreadPoolExecutor.AnonymousClass1.a(runnable);
                    }
                }
            };
            return new Thread(runnable2, "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    @VisibleForTesting
    public ChromeThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        allowCoreThreadTimeOut(true);
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() > 32) {
                sb.append(entry.getKey());
                sb.append(WebvttCueParser.CHAR_SPACE);
            }
        }
        if (sb.length() == 0) {
            return "NO CLASSES FOUND";
        }
        return sb.toString();
    }

    public static String getClassName(Runnable runnable) {
        Class cls;
        Class cls2 = runnable.getClass();
        try {
        } catch (IllegalAccessException e) {
            if (BuildConfig.DCHECK_IS_ON) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchFieldException e2) {
            if (BuildConfig.DCHECK_IS_ON) {
                throw new RuntimeException(e2);
            }
        }
        if (cls2 == AsyncTask.NamedFutureTask.class) {
            cls = ((AsyncTask.NamedFutureTask) runnable).getBlamedClass();
        } else {
            if (cls2.getEnclosingClass() == android.os.AsyncTask.class) {
                Field declaredField = cls2.getDeclaredField("this$0");
                declaredField.setAccessible(true);
                cls = declaredField.get(runnable).getClass();
            }
            return cls2.getName();
        }
        cls2 = cls;
        return cls2.getName();
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
        int i;
        HashMap hashMap = new HashMap();
        for (Runnable runnable : (Runnable[]) getQueue().toArray(new Runnable[0])) {
            String className = getClassName(runnable);
            if (hashMap.containsKey(className)) {
                i = ((Integer) hashMap.get(className)).intValue();
            } else {
                i = 0;
            }
            hashMap.put(className, Integer.valueOf(i + 1));
        }
        return hashMap;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (RejectedExecutionException e) {
            Map<String, Integer> numberOfClassNameOccurrencesInQueue = getNumberOfClassNameOccurrencesInQueue();
            throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(numberOfClassNameOccurrencesInQueue), e);
        }
    }
}
