package com.sdk.base.framework.d;

import android.content.Context;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.l;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b extends com.sdk.base.framework.b.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ a f38534a;

    public b(a aVar) {
        this.f38534a = aVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 java.lang.Object)] */
    @Override // com.sdk.base.framework.b.b
    public final void a(int i, Object obj) {
        a aVar = this.f38534a;
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        aVar.a(i, 302002, sb.toString());
        Context context = this.f38534a.f38528a;
        com.sdk.base.framework.f.g.a.a();
    }

    @Override // com.sdk.base.framework.b.b
    public final void a(l<String> lVar) {
        int i;
        String str;
        boolean z;
        String str2;
        boolean z2;
        try {
            JSONObject jSONObject = new JSONObject(lVar == null ? "" : lVar.b());
            int optInt = jSONObject.optInt("code");
            try {
                String optString = jSONObject.optString("msg");
                int optInt2 = jSONObject.optInt("status");
                String optString2 = jSONObject.optString("obj");
                String optString3 = jSONObject.optString("seq");
                if (!c.a(optString).booleanValue() || !c.a(optString3).booleanValue() || !c.a(optString2).booleanValue()) {
                    this.f38534a.a(optInt, optString, optInt2, optString2, optString3);
                    Context context = this.f38534a.f38528a;
                    com.sdk.base.framework.f.g.a.a();
                    return;
                }
                this.f38534a.a(1, "服务端数据格式出错", 302003, null, com.sdk.base.framework.f.f.a.b().a());
                str2 = a.f38526d;
                z2 = a.f38527e;
                c.b(str2, "返回数据为空", Boolean.valueOf(z2));
            } catch (Throwable th) {
                th = th;
                i = optInt;
                com.sdk.base.framework.f.f.a.c(th.toString());
                this.f38534a.a(i, "服务端数据格式出错", 302003, null, com.sdk.base.framework.f.f.a.b().a());
                str = a.f38526d;
                z = a.f38527e;
                c.b(str, "返回数据解析异常：" + th.toString(), Boolean.valueOf(z));
            }
        } catch (Throwable th2) {
            th = th2;
            i = 1;
        }
    }
}
