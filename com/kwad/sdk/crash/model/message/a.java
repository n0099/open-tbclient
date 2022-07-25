package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.e.b;
import com.kwad.sdk.crash.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public JSONObject ahA = new JSONObject();

    private void put(String str, Object obj) {
        try {
            this.ahA.put(str, obj);
        } catch (Throwable th) {
            b.printStackTraceOnly(th);
        }
    }

    public final void cY(String str) {
        put(c.ahb, str);
    }

    public final void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    public final void putString(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() > 100) {
            b.d("ExceptionCollector", "string value to long ,max is 100");
        } else {
            put(str, str2);
        }
    }

    public final String toString() {
        return this.ahA.toString();
    }
}
