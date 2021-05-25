package com.sdk.mobile.b;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.framework.f.g.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ int f35741a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f35742b;

    public b(a aVar, int i2) {
        this.f35742b = aVar;
        this.f35741a = i2;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        this.f35742b.a(i2, i3, str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0055 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.String] */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        Context context;
        Context context2;
        Context context3;
        context = this.f35742b.f35723d;
        com.sdk.base.framework.f.i.b.b(context);
        if (i2 == 0) {
            context2 = this.f35742b.f35723d;
            com.sdk.base.framework.a.a.a.a(context2, this.f35741a, com.sdk.base.framework.a.a.a.a(t, str2), g.f35697a.a());
            try {
                context3 = this.f35742b.f35723d;
                t = com.sdk.base.framework.f.k.a.a(context3, String.valueOf((Object) t));
                if (t == 0) {
                    this.f35742b.a(1, "SDK解密异常", 302001, t, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(String.valueOf((Object) t));
                if (this.f35741a == 1) {
                    jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    t = jSONObject.toString();
                }
            } catch (Exception unused) {
            }
        }
        this.f35742b.a(i2, str, i3, t, str2);
    }
}
