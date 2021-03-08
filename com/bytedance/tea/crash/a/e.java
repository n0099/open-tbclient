package com.bytedance.tea.crash.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.bytedance.tea.crash.g.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static JSONObject a(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", m.a(stackTrace));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo V = com.bytedance.tea.crash.g.a.V(context, i);
        if (V == null || Process.myPid() != V.pid) {
            return null;
        }
        return b.a(V);
    }
}
