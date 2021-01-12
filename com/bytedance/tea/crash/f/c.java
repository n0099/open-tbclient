package com.bytedance.tea.crash.f;

import android.content.Context;
import android.os.Handler;
import com.bytedance.tea.crash.g.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f7657a = new ArrayList(3);

    private c(Handler handler, Context context) {
        this.f7657a.add(new b(handler, 0L, 15000L));
    }

    public static c a(Handler handler, Context context) {
        return new c(handler, context);
    }

    public void a() {
        j.a("[ScheduleTaskManager] execute, task size=" + this.f7657a.size());
        for (a aVar : this.f7657a) {
            try {
                aVar.a();
            } catch (Throwable th) {
            }
        }
    }
}
