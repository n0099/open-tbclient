package com.vivo.push;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f36752a;

    /* renamed from: b  reason: collision with root package name */
    public int f36753b;

    /* renamed from: c  reason: collision with root package name */
    public y f36754c;

    public v(y yVar) {
        this.f36753b = -1;
        this.f36754c = yVar;
        int b2 = yVar.b();
        this.f36753b = b2;
        if (b2 >= 0) {
            this.f36752a = p.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f36753b;
    }

    public abstract void a(y yVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f36752a;
        if (context != null && !(this.f36754c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f36754c);
        }
        a(this.f36754c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(StringUtil.ARRAY_START);
        y yVar = this.f36754c;
        sb.append(yVar == null ? "[null]" : yVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
