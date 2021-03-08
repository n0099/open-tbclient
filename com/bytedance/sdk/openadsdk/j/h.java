package com.bytedance.sdk.openadsdk.j;

import androidx.annotation.NonNull;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f4871a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final String c;
    private final int d;

    public h(int i, @NonNull String str) {
        this.d = i;
        this.f4871a = new ThreadGroup("tt_pangle_group_" + str);
        this.c = "tt_pangle_thread_" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f4871a, runnable, this.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.b.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (this.d == 1) {
            thread.setPriority(1);
        } else if (thread.getPriority() != 5) {
            thread.setPriority(3);
        } else {
            thread.setPriority(5);
        }
        return thread;
    }
}
