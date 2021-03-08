package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f7663a;
    private /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.b = aVar;
        this.f7663a = str;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        this.b.a(i, i2, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        String str3;
        Context context;
        if (i == 0 && com.sdk.base.framework.a.a.c.a(this.f7663a).booleanValue()) {
            context = this.b.d;
            str3 = com.sdk.base.framework.f.l.a.a(context, String.valueOf(t));
            if (str3 == null) {
                this.b.a(1, "SDK解密异常", CmdConfigSocket.CMD_PB_PAGE, str3, str2);
                return;
            }
        } else {
            str3 = t;
        }
        this.b.a(i, str, i2, str3, str2);
    }
}
