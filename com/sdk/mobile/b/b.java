package com.sdk.mobile.b;

import android.content.Context;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f12883a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f12884b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, int i) {
        this.f12884b = aVar;
        this.f12883a = i;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        this.f12884b.a(i, i2, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        Context context;
        String str3;
        Context context2;
        Context context3;
        context = this.f12884b.d;
        com.sdk.base.framework.f.j.b.b(context);
        if (i == 0) {
            context2 = this.f12884b.d;
            com.sdk.base.framework.a.a.a.a(context2, this.f12883a, com.sdk.base.framework.a.a.a.a(t, str2));
            try {
                context3 = this.f12884b.d;
                str3 = com.sdk.base.framework.f.l.a.a(context3, String.valueOf(t));
                try {
                    if (str3 == null) {
                        this.f12884b.a(1, "SDK解密异常", CmdConfigSocket.CMD_PB_PAGE, str3, str2);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(String.valueOf(str3));
                    if (this.f12883a == 1) {
                        jSONObject.remove("fakeMobile");
                        str3 = jSONObject.toString();
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                str3 = t;
            }
        } else {
            str3 = t;
        }
        this.f12884b.a(i, str, i2, str3, str2);
    }
}
