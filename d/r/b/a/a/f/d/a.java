package d.r.b.a.a.f.d;

import android.util.Log;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.heytap.mcssdk.mode.CommandMessage;
import d.r.b.a.a.f.h.f;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f67663a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f67664b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f67665c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f67666d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f67667e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f67668f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f67669g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f67670h = "";

    /* renamed from: i  reason: collision with root package name */
    public static List<JSONObject> f67671i = new LinkedList();
    public static int j = 30;
    public static int k = 30;
    public static int l = 5;
    public static volatile boolean m = false;

    /* renamed from: d.r.b.a.a.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1896a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f67672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67673f;

        public RunnableC1896a(String str, String str2) {
            this.f67672e = str;
            this.f67673f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tag", this.f67672e);
                jSONObject.put("uid", a.f67663a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, a.f67664b);
                jSONObject.put("device", a.f67665c);
                jSONObject.put(IAdRequestParam.OS, a.f67666d);
                jSONObject.put("appName", a.f67667e);
                jSONObject.put("clientVer", a.f67668f);
                jSONObject.put(CommandMessage.SDK_VERSION, a.f67670h);
                jSONObject.put("deviceId", a.f67669g);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbConfig.TMP_LOG_DIR_NAME, this.f67673f);
                a.b(jSONObject, false);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Log.d("CloudLogUtil", "do logLoop force send log");
            a.b(null, true);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.d.c f67674e;

        public c(d.r.b.a.a.f.d.c cVar) {
            this.f67674e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", "yylive-lpfmmobileturnover");
                jSONObject.put("region", "cn-shenzhen");
                jSONObject.put("logStore", "turnover");
                jSONObject.put("content", this.f67674e.f67677b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            String a2 = d.r.b.a.a.f.d.b.a("https://cloud-log.yy.com/api/log/put", jSONObject.toString());
            Log.d("CloudLogUtil", "sendLog res=" + a2);
            if (a2 != null && !a2.isEmpty()) {
                try {
                    int i2 = new JSONObject(a2).getInt("code");
                    Log.d("CloudLogUtil", "sendLog code=" + i2);
                    if (i2 != 1000) {
                        if (this.f67674e.f67678c.get() > 3) {
                            r3 = false;
                        }
                        Log.d("CloudLogUtil", "sendLog->2 isRetry=" + r3 + " retryCount=" + this.f67674e.f67678c);
                        if (r3) {
                            a.d(this.f67674e);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            r3 = this.f67674e.f67678c.get() <= 3;
            Log.d("CloudLogUtil", "sendLog->1 isRetry=" + r3 + " retryCount=" + this.f67674e.f67678c);
            if (r3) {
                a.d(this.f67674e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.d.c f67675e;

        public d(d.r.b.a.a.f.d.c cVar) {
            this.f67675e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.f67675e);
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (a.class) {
            Log.d("CloudLogUtil", "addLogContent startLogLoop:" + m);
            f.a().c().execute(new RunnableC1896a(str, str2));
            f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[Catch: all -> 0x0086, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:9:0x0016, B:14:0x0022, B:16:0x0050, B:17:0x0060, B:19:0x0066, B:20:0x0073), top: B:26:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void b(JSONObject jSONObject, boolean z) {
        boolean z2;
        synchronized (a.class) {
            if (jSONObject != null) {
                f67671i.add(jSONObject);
            }
            if (f67671i.size() < j && (!z || f67671i.size() <= 0)) {
                z2 = false;
                Log.d("CloudLogUtil", "addLogContent waiting size:" + f67671i.size() + " upload:" + z2 + " force:" + z);
                if (z2) {
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    for (JSONObject jSONObject2 : f67671i) {
                        jSONArray.put(jSONObject2);
                        arrayList.add(jSONObject2);
                    }
                    f67671i.clear();
                    d.r.b.a.a.f.d.c cVar = new d.r.b.a.a.f.d.c();
                    cVar.f67677b = jSONArray;
                    cVar.f67676a = arrayList;
                    e(cVar);
                }
            }
            z2 = true;
            Log.d("CloudLogUtil", "addLogContent waiting size:" + f67671i.size() + " upload:" + z2 + " force:" + z);
            if (z2) {
            }
        }
    }

    public static synchronized void c(d.r.b.a.a.f.d.c cVar) {
        synchronized (a.class) {
            if (cVar != null) {
                if (cVar.f67676a != null && cVar.f67677b != null) {
                    int andIncrement = cVar.f67678c.getAndIncrement();
                    Log.d("CloudLogUtil", "doRetrySendLog retryTime:" + andIncrement);
                    e(cVar);
                }
            }
        }
    }

    public static synchronized void d(d.r.b.a.a.f.d.c cVar) {
        synchronized (a.class) {
            Log.d("CloudLogUtil", "delayToRetrySendLog");
            if (cVar != null && cVar.f67676a != null && cVar.f67677b != null) {
                f.a().c().schedule(new d(cVar), 5L, TimeUnit.SECONDS);
            }
        }
    }

    public static synchronized void e(d.r.b.a.a.f.d.c cVar) {
        synchronized (a.class) {
            f.a().c().execute(new c(cVar));
        }
    }

    public static synchronized void f() {
        synchronized (a.class) {
            if (m) {
                return;
            }
            m = true;
            Log.d("CloudLogUtil", "addLogContent startLogLoop()");
            f.a().c().scheduleAtFixedRate(new b(), l, k, TimeUnit.SECONDS);
        }
    }
}
