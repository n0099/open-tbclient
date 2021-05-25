package com.github.anrwatchdog;

import android.os.Looper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.github.anrwatchdog.ANRError$$;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class ANRError extends Error {
    public static final long serialVersionUID = 1;
    public final long duration;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<Thread> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Thread f30749e;

        public a(Thread thread) {
            this.f30749e = thread;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Thread thread, Thread thread2) {
            if (thread == thread2) {
                return 0;
            }
            Thread thread3 = this.f30749e;
            if (thread == thread3) {
                return 1;
            }
            if (thread2 == thread3) {
                return -1;
            }
            return thread2.getName().compareTo(thread.getName());
        }
    }

    public ANRError(ANRError$$._Thread _thread, long j) {
        super("Application Not Responding for at least " + j + " ms.", _thread);
        this.duration = j;
    }

    public static ANRError New(long j, String str, boolean z) {
        Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new a(thread));
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
            ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue(), null);
            aNRError$$.getClass();
            _thread = new ANRError$$._Thread(aNRError$$, _thread, null);
        }
        return new ANRError(_thread, j);
    }

    public static ANRError NewMainOnly(long j) {
        Thread thread = Looper.getMainLooper().getThread();
        ANRError$$ aNRError$$ = new ANRError$$(getThreadTitle(thread), thread.getStackTrace(), null);
        aNRError$$.getClass();
        return new ANRError(new ANRError$$._Thread(aNRError$$, null, null), j);
    }

    public static String getThreadTitle(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
