package com.bytedance.tea.crash.d;

import android.content.Context;
import com.bytedance.tea.crash.e.a.e;
import com.bytedance.tea.crash.g.d;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private Context f5166a;

    @Override // com.bytedance.tea.crash.d.b
    public void a(long j, Thread thread, Throwable th) {
        com.bytedance.tea.crash.c.a a2 = com.bytedance.tea.crash.c.a.a(j, this.f5166a, thread, th);
        d.a(this.f5166a, com.bytedance.tea.crash.c.JAVA.a(), Thread.currentThread().getName());
        com.bytedance.tea.crash.upload.a.erA().a(e.erp().a(com.bytedance.tea.crash.c.JAVA, a2).a());
    }

    @Override // com.bytedance.tea.crash.d.b
    public boolean a(Throwable th) {
        return true;
    }

    public c(Context context) {
        this.f5166a = context;
    }
}
