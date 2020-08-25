package com.sdk.base.framework.d;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.sdk.base.framework.a.k;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c extends com.sdk.base.framework.b.b<String> {
    private /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 java.lang.Object)] */
    @Override // com.sdk.base.framework.b.b
    public final void a(int i, Object obj) {
        this.a.a(i, CmdConfigSocket.CMD_SUBPB_FLOOR, new StringBuilder().append(obj).toString());
        com.sdk.base.framework.f.h.a.a(this.a.a);
    }

    @Override // com.sdk.base.framework.b.b
    public final void a(k<String> kVar) {
        Throwable th;
        String str;
        boolean z;
        JSONObject jSONObject;
        int optInt;
        String str2;
        boolean z2;
        int i = 1;
        try {
            jSONObject = new JSONObject(kVar == null ? "" : kVar.b());
            optInt = jSONObject.optInt("code");
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            String optString = jSONObject.optString("msg");
            int optInt2 = jSONObject.optInt("status");
            String optString2 = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            String optString3 = jSONObject.optString("seq");
            if (!com.sdk.base.framework.a.a.c.a(optString).booleanValue() || !com.sdk.base.framework.a.a.c.a(optString3).booleanValue() || !com.sdk.base.framework.a.a.c.a(optString2).booleanValue()) {
                this.a.a(optInt, optString, optInt2, optString2, optString3);
                com.sdk.base.framework.f.h.a.a(this.a.a);
                return;
            }
            this.a.a(1, "服务端数据格式出错", 302003, null, com.sdk.base.framework.f.g.a.b().a());
            str2 = a.d;
            z2 = a.e;
            com.sdk.base.framework.a.a.c.b(str2, "返回数据为空", Boolean.valueOf(z2));
        } catch (Throwable th3) {
            i = optInt;
            th = th3;
            com.sdk.base.framework.f.g.a.c(th.toString());
            this.a.a(i, "服务端数据格式出错", 302003, null, com.sdk.base.framework.f.g.a.b().a());
            str = a.d;
            z = a.e;
            com.sdk.base.framework.a.a.c.b(str, "返回数据解析异常：" + th.toString(), Boolean.valueOf(z));
        }
    }
}
