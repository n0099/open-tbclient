package com.github.anrwatchdog;

import android.os.Looper;
import com.github.anrwatchdog.ANRError$$;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes14.dex */
public class ANRError extends Error {
    private static final long serialVersionUID = 1;
    public final long duration;

    private ANRError(ANRError$$._Thread _thread, long j) {
        super("Application Not Responding for at least " + j + " ms.", _thread);
        this.duration = j;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ANRError New(long j, String str, boolean z) {
        final Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new Comparator<Thread>() { // from class: com.github.anrwatchdog.ANRError.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Thread thread2, Thread thread3) {
                if (thread2 == thread3) {
                    return 0;
                }
                if (thread2 == thread) {
                    return 1;
                }
                if (thread3 == thread) {
                    return -1;
                }
                return thread3.getName().compareTo(thread2.getName());
            }
        });
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        ANRError$$._Thread _thread = null;
        for (Map.Entry entry2 : treeMap.entrySet()) {
            ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue());
            aNRError$$.getClass();
            _thread = new ANRError$$._Thread(_thread);
        }
        return new ANRError(_thread, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ANRError NewMainOnly(long j) {
        Thread thread = Looper.getMainLooper().getThread();
        ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(thread), thread.getStackTrace());
        aNRError$$.getClass();
        return new ANRError(new ANRError$$._Thread(null), j);
    }

    private static String getThreadTitle(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }
}
