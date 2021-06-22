package com.vivo.push;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f40534a;

    /* renamed from: b  reason: collision with root package name */
    public int f40535b;

    /* renamed from: c  reason: collision with root package name */
    public y f40536c;

    public v(y yVar) {
        this.f40535b = -1;
        this.f40536c = yVar;
        int b2 = yVar.b();
        this.f40535b = b2;
        if (b2 >= 0) {
            this.f40534a = p.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f40535b;
    }

    public abstract void a(y yVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f40534a;
        if (context != null && !(this.f40536c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f40536c);
        }
        a(this.f40536c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(StringUtil.ARRAY_START);
        y yVar = this.f40536c;
        sb.append(yVar == null ? "[null]" : yVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
