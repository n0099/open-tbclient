package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.crash.c;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f33818a = new JSONObject();

    private void a(String str, Object obj) {
        try {
            this.f33818a.put(str, obj);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.b(th);
        }
    }

    public void a(String str) {
        a(c.f33789g, (Object) str);
    }

    public void a(String str, int i2) {
        a(str, Integer.valueOf(i2));
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() > 100) {
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "string value to long ,max is 100");
        } else {
            a(str, (Object) str2);
        }
    }

    public String toString() {
        return this.f33818a.toString();
    }
}
