package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.crash.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public JSONObject a = new JSONObject();

    private void a(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (Throwable th) {
            b.b(th);
        }
    }

    public final void a(String str) {
        a(c.g, (Object) str);
    }

    public final void a(String str, int i) {
        a(str, Integer.valueOf(i));
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() > 100) {
            b.a("ExceptionCollector", "string value to long ,max is 100");
        } else {
            a(str, (Object) str2);
        }
    }

    public final String toString() {
        return this.a.toString();
    }
}
