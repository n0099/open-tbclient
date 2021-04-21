package com.sdk.mobile.b;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.framework.f.g.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ int f38982a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f38983b;

    public b(a aVar, int i) {
        this.f38983b = aVar;
        this.f38982a = i;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        this.f38983b.a(i, i2, str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0055 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        Context context;
        Context context2;
        Context context3;
        context = this.f38983b.f38964d;
        com.sdk.base.framework.f.i.b.b(context);
        if (i == 0) {
            context2 = this.f38983b.f38964d;
            com.sdk.base.framework.a.a.a.a(context2, this.f38982a, com.sdk.base.framework.a.a.a.a(t, str2), g.f38938a.a());
            try {
                context3 = this.f38983b.f38964d;
                t = com.sdk.base.framework.f.k.a.a(context3, String.valueOf((Object) t));
                if (t == 0) {
                    this.f38983b.a(1, "SDK解密异常", 302001, t, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(String.valueOf((Object) t));
                if (this.f38982a == 1) {
                    jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    t = jSONObject.toString();
                }
            } catch (Exception unused) {
            }
        }
        this.f38983b.a(i, str, i2, t, str2);
    }
}
