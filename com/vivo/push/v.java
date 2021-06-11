package com.vivo.push;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes7.dex */
public abstract class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f40431a;

    /* renamed from: b  reason: collision with root package name */
    public int f40432b;

    /* renamed from: c  reason: collision with root package name */
    public y f40433c;

    public v(y yVar) {
        this.f40432b = -1;
        this.f40433c = yVar;
        int b2 = yVar.b();
        this.f40432b = b2;
        if (b2 >= 0) {
            this.f40431a = p.a().h();
            return;
        }
        throw new IllegalArgumentException("PushTask need a > 0 task id.");
    }

    public final int a() {
        return this.f40432b;
    }

    public abstract void a(y yVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f40431a;
        if (context != null && !(this.f40433c instanceof com.vivo.push.b.p)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f40433c);
        }
        a(this.f40433c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(StringUtil.ARRAY_START);
        y yVar = this.f40433c;
        sb.append(yVar == null ? "[null]" : yVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
