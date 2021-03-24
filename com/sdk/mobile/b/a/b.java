package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.framework.f.g.g;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ int f38590a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f38591b;

    public b(a aVar, int i) {
        this.f38591b = aVar;
        this.f38590a = i;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i, int i2, String str) {
        this.f38591b.a(i, i2, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i, String str, int i2, T t, String str2) {
        Context context;
        String str3;
        Boolean bool;
        Context context2;
        Context context3;
        context = this.f38591b.f38586d;
        com.sdk.base.framework.f.i.b.b(context);
        String str4 = t;
        if (i == 0) {
            try {
                context2 = this.f38591b.f38586d;
                com.sdk.base.framework.a.a.a.a(context2, this.f38590a, com.sdk.base.framework.a.a.a.a(t, str2), g.f38554b.a());
                context3 = this.f38591b.f38586d;
                String a2 = com.sdk.base.framework.f.k.a.a(context3, String.valueOf(t));
                if (a2 == null) {
                    this.f38591b.a(1, "SDK解密异常", 302001, a2, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(String.valueOf(a2));
                str4 = a2;
                if (this.f38590a == 1) {
                    jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    str4 = jSONObject.toString();
                }
            } catch (Exception e2) {
                str3 = a.f38583a;
                String exc = e2.toString();
                bool = a.f38584b;
                com.sdk.base.framework.a.a.c.b(str3, exc, bool);
                str4 = t;
            }
        }
        this.f38591b.a(i, str, i2, str4, str2);
    }
}
