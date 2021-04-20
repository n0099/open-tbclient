package d.c.d.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import d.c.d.b.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {
    public static String a(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo b2 = l.b.b(context, i);
        if (b2 == null || Process.myPid() != b2.pid) {
            return null;
        }
        return b.a(b2);
    }

    public static JSONObject b(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", l.n.b(stackTrace));
        return jSONObject;
    }
}
