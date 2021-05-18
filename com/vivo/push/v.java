package com.vivo.push;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f36823a;

    /* renamed from: b  reason: collision with root package name */
    public int f36824b;

    /* renamed from: c  reason: collision with root package name */
    public y f36825c;

    public v(y yVar) {
        this.f36824b = -1;
        this.f36825c = yVar;
        int b2 = yVar.b();
        this.f36824b = b2;
        if (b2 >= 0) {
            this.f36823a = p.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f36824b;
    }

    public abstract void a(y yVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f36823a;
        if (context != null && !(this.f36825c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f36825c);
        }
        a(this.f36825c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(StringUtil.ARRAY_START);
        y yVar = this.f36825c;
        sb.append(yVar == null ? "[null]" : yVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
