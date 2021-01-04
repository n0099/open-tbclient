package com.sdk.mobile.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class d implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f13183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f13183a = aVar;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        this.f13183a.a(i, i2, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        String str3;
        Context context;
        if (i == 0) {
            context = this.f13183a.d;
            str3 = com.sdk.base.framework.f.l.a.a(context, String.valueOf(t));
            if (str3 == null) {
                this.f13183a.a(1, "SDK解密异常", CmdConfigSocket.CMD_PB_PAGE, str3, str2);
                return;
            }
        } else {
            str3 = t;
        }
        this.f13183a.a(i, str, i2, str3, str2);
    }
}
