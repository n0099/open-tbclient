package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public JSONObject aFm = new JSONObject();

    public final String toString() {
        return this.aFm.toString();
    }

    private void put(String str, Object obj) {
        try {
            this.aFm.put(str, obj);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    public final void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    public final void putString(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.length() <= 100) {
            put(str, str2);
        } else {
            c.d("AdExceptionCollector", "string value to long ,max is 100");
        }
    }

    public final void eU(String str) {
        put(d.aEF, str);
    }
}
