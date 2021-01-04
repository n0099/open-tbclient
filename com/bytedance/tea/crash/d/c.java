package com.bytedance.tea.crash.d;

import android.content.Context;
import com.bytedance.tea.crash.e.a.e;
import com.bytedance.tea.crash.g.d;
/* loaded from: classes4.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f7931a;

    @Override // com.bytedance.tea.crash.d.b
    public void a(long j, Thread thread, Throwable th) {
        com.bytedance.tea.crash.c.a a2 = com.bytedance.tea.crash.c.a.a(j, this.f7931a, thread, th);
        d.a(this.f7931a, com.bytedance.tea.crash.c.JAVA.a(), Thread.currentThread().getName());
        com.bytedance.tea.crash.upload.a.esJ().a(e.esz().a(com.bytedance.tea.crash.c.JAVA, a2).a());
    }

    @Override // com.bytedance.tea.crash.d.b
    public boolean a(Throwable th) {
        return true;
    }

    public c(Context context) {
        this.f7931a = context;
    }
}
