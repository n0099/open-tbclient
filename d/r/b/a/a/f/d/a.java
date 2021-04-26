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
    public static String f66977a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f66978b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f66979c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f66980d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f66981e = "";

    /* renamed from: f  reason: collision with root package name */
    public static String f66982f = "";

    /* renamed from: g  reason: collision with root package name */
    public static String f66983g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f66984h = "";

    /* renamed from: i  reason: collision with root package name */
    public static List<JSONObject> f66985i = new LinkedList();
    public static int j = 30;
    public static int k = 30;
    public static int l = 5;
    public static volatile boolean m = false;

    /* renamed from: d.r.b.a.a.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1832a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66986e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66987f;

        public RunnableC1832a(String str, String str2) {
            this.f66986e = str;
            this.f66987f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tag", this.f66986e);
                jSONObject.put("uid", a.f66977a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, a.f66978b);
                jSONObject.put("device", a.f66979c);
                jSONObject.put(IAdRequestParam.OS, a.f66980d);
                jSONObject.put("appName", a.f66981e);
                jSONObject.put("clientVer", a.f66982f);
                jSONObject.put(CommandMessage.SDK_VERSION, a.f66984h);
                jSONObject.put("deviceId", a.f66983g);
                jSONObject.put("timestamp", System.currentTimeMillis());
                jSONObject.put(TbConfig.TMP_LOG_DIR_NAME, this.f66987f);
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
        public final /* synthetic */ d.r.b.a.a.f.d.c f66988e;

        public c(d.r.b.a.a.f.d.c cVar) {
            this.f66988e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", "yylive-lpfmmobileturnover");
                jSONObject.put("region", "cn-shenzhen");
                jSONObject.put("logStore", "turnover");
                jSONObject.put("content", this.f66988e.f66991b);
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
                        if (this.f66988e.f66992c.get() > 3) {
                            r3 = false;
                        }
                        Log.d("CloudLogUtil", "sendLog->2 isRetry=" + r3 + " retryCount=" + this.f66988e.f66992c);
                        if (r3) {
                            a.d(this.f66988e);
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            r3 = this.f66988e.f66992c.get() <= 3;
            Log.d("CloudLogUtil", "sendLog->1 isRetry=" + r3 + " retryCount=" + this.f66988e.f66992c);
            if (r3) {
                a.d(this.f66988e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.b.a.a.f.d.c f66989e;

        public d(d.r.b.a.a.f.d.c cVar) {
            this.f66989e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.f66989e);
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (a.class) {
            Log.d("CloudLogUtil", "addLogContent startLogLoop:" + m);
            f.a().c().execute(new RunnableC1832a(str, str2));
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
                f66985i.add(jSONObject);
            }
            if (f66985i.size() < j && (!z || f66985i.size() <= 0)) {
                z2 = false;
                Log.d("CloudLogUtil", "addLogContent waiting size:" + f66985i.size() + " upload:" + z2 + " force:" + z);
                if (z2) {
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    for (JSONObject jSONObject2 : f66985i) {
                        jSONArray.put(jSONObject2);
                        arrayList.add(jSONObject2);
                    }
                    f66985i.clear();
                    d.r.b.a.a.f.d.c cVar = new d.r.b.a.a.f.d.c();
                    cVar.f66991b = jSONArray;
                    cVar.f66990a = arrayList;
                    e(cVar);
                }
            }
            z2 = true;
            Log.d("CloudLogUtil", "addLogContent waiting size:" + f66985i.size() + " upload:" + z2 + " force:" + z);
            if (z2) {
            }
        }
    }

    public static synchronized void c(d.r.b.a.a.f.d.c cVar) {
        synchronized (a.class) {
            if (cVar != null) {
                if (cVar.f66990a != null && cVar.f66991b != null) {
                    int andIncrement = cVar.f66992c.getAndIncrement();
                    Log.d("CloudLogUtil", "doRetrySendLog retryTime:" + andIncrement);
                    e(cVar);
                }
            }
        }
    }

    public static synchronized void d(d.r.b.a.a.f.d.c cVar) {
        synchronized (a.class) {
            Log.d("CloudLogUtil", "delayToRetrySendLog");
            if (cVar != null && cVar.f66990a != null && cVar.f66991b != null) {
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
