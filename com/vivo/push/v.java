package com.vivo.push;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f37578a;

    /* renamed from: b  reason: collision with root package name */
    public int f37579b;

    /* renamed from: c  reason: collision with root package name */
    public y f37580c;

    public v(y yVar) {
        this.f37579b = -1;
        this.f37580c = yVar;
        int b2 = yVar.b();
        this.f37579b = b2;
        if (b2 >= 0) {
            this.f37578a = p.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f37579b;
    }

    public abstract void a(y yVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f37578a;
        if (context != null && !(this.f37580c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f37580c);
        }
        a(this.f37580c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(StringUtil.ARRAY_START);
        y yVar = this.f37580c;
        sb.append(yVar == null ? "[null]" : yVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
