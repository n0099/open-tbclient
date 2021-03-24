package d.m.b.a;

import android.content.Context;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.pgl.sys.ces.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f66284a = 504;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f66285b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f66286c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66287d = "";

    /* renamed from: e  reason: collision with root package name */
    public static Context f66288e;

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IXAdRequestInfo.OS, "Android");
            jSONObject.put("version", "1.0.5");
            if (f66287d == null || f66287d.length() <= 0) {
                jSONObject.put("token_id", a.meta(303, f66288e, null));
            } else {
                jSONObject.put("token_id", f66287d);
            }
            jSONObject.put("code", f66284a);
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable unused) {
            d.m.a.b.d.a("Call onEvent Error");
            return "";
        }
    }

    public static void b(Context context, String str, d.m.b.a.a.a aVar) {
        if (f66288e == null) {
            f66288e = context;
        }
        int i = f66284a;
        if (i == 102 || i == 202 || i == 200) {
            return;
        }
        System.currentTimeMillis();
        f66286c = str;
        f66284a = 102;
        Thread thread = new Thread(new d(context, aVar));
        thread.setName("CZL-3");
        thread.start();
    }
}
