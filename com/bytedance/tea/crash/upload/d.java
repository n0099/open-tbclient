package com.bytedance.tea.crash.upload;

import android.content.Context;
import com.bytedance.tea.crash.g.i;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;
/* loaded from: classes6.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f7680a;

    private d(Context context) {
        this.f7680a = context;
    }

    public static void a(Context context, int i) {
        try {
            if (!h.erd().d().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception e) {
        }
        com.bytedance.tea.crash.e.h.b().postDelayed(new d(context), i);
    }

    public static void a(Context context) {
        a(context, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new com.bytedance.tea.crash.e.d(this.f7680a).a(i.b(this.f7680a));
        } catch (Throwable th) {
            try {
                j.b(th);
            } finally {
                com.bytedance.tea.crash.f.c.a(com.bytedance.tea.crash.e.h.b(), this.f7680a).a();
            }
        }
    }
}
