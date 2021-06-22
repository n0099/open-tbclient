package com.sdk.mobile.b.a;

import android.content.Context;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.framework.f.g.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b implements com.sdk.base.framework.b.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ int f39511a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f39512b;

    public b(a aVar, int i2) {
        this.f39512b = aVar;
        this.f39511a = i2;
    }

    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, int i3, String str) {
        this.f39512b.a(i2, i3, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sdk.base.framework.b.a
    public final void a(int i2, String str, int i3, T t, String str2) {
        Context context;
        String str3;
        Boolean bool;
        Context context2;
        Context context3;
        context = this.f39512b.f39507d;
        com.sdk.base.framework.f.i.b.b(context);
        String str4 = t;
        if (i2 == 0) {
            try {
                context2 = this.f39512b.f39507d;
                com.sdk.base.framework.a.a.a.a(context2, this.f39511a, com.sdk.base.framework.a.a.a.a(t, str2), g.f39475b.a());
                context3 = this.f39512b.f39507d;
                String a2 = com.sdk.base.framework.f.k.a.a(context3, String.valueOf(t));
                if (a2 == null) {
                    this.f39512b.a(1, "SDK解密异常", 302001, a2, str2);
                    return;
                }
                JSONObject jSONObject = new JSONObject(String.valueOf(a2));
                str4 = a2;
                if (this.f39511a == 1) {
                    jSONObject.remove(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                    str4 = jSONObject.toString();
                }
            } catch (Exception e2) {
                str3 = a.f39504a;
                String exc = e2.toString();
                bool = a.f39505b;
                com.sdk.base.framework.a.a.c.b(str3, exc, bool);
                str4 = t;
            }
        }
        this.f39512b.a(i2, str, i3, str4, str2);
    }
}
