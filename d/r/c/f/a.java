package d.r.c.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import com.yy.open.activity.AssistActivity;
import com.yy.open.activity.BridgeActivity;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f68154c;

    /* renamed from: d  reason: collision with root package name */
    public String f68155d;

    /* renamed from: e  reason: collision with root package name */
    public d.r.c.g.a f68156e = d.r.c.g.a.b();

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<c> f68152a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public Handler f68153b = new Handler(Looper.getMainLooper());

    /* renamed from: d.r.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1906a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f68157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.r.c.b f68158f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f68159g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f68160h;

        public RunnableC1906a(int i2, d.r.c.b bVar, Intent intent, long j) {
            this.f68157e = i2;
            this.f68158f = bVar;
            this.f68159g = intent;
            this.f68160h = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i2;
            try {
                if (this.f68157e == 0) {
                    this.f68158f.onCancel();
                    return;
                }
                String stringExtra = this.f68159g.getStringExtra("resjson");
                a.this.f68156e.a(stringExtra);
                JSONObject jSONObject = new JSONObject(stringExtra);
                if (jSONObject.has("resCode") && jSONObject.has("resMsg")) {
                    String optString = jSONObject.optString("resMsg");
                    int optInt = jSONObject.optInt("resCode");
                    if (optInt != 1000006 && optInt != 1290001) {
                        optInt = this.f68157e;
                        a.this.f(this.f68159g, this.f68158f, this.f68160h, optInt, optString);
                        return;
                    }
                    Log.e("chenqiang", "resCode:" + optInt);
                    a.this.f(this.f68159g, this.f68158f, this.f68160h, optInt, optString);
                    return;
                }
                Log.e("chenqiang", "please update yy new version！");
                if (jSONObject.has("openid") && jSONObject.has("access_code")) {
                    i2 = this.f68157e;
                    str = "success";
                } else {
                    str = "handleAuthLoginResult--default error!";
                    i2 = 444222199;
                }
                a.this.f(this.f68159g, this.f68158f, this.f68160h, i2, str);
            } catch (Exception unused) {
                this.f68158f.onError(new d.r.c.d(444222105, d.h(444222105)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.r.c.b f68162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.r.c.d f68163f;

        public b(a aVar, d.r.c.b bVar, d.r.c.d dVar) {
            this.f68162e = bVar;
            this.f68163f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f68162e.onError(this.f68163f);
        }
    }

    /* loaded from: classes7.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public d.r.c.b f68164a;

        /* renamed from: b  reason: collision with root package name */
        public long f68165b = System.currentTimeMillis();

        public c(a aVar, d.r.c.b bVar) {
            this.f68164a = bVar;
        }
    }

    public a(Context context, String str) {
        this.f68154c = context;
        this.f68155d = str;
    }

    public final void c(Activity activity, String str, d.r.c.b bVar) {
        if (d.r.c.f.c.d(activity, BridgeActivity.class) && d.r.c.f.c.d(activity, AssistActivity.class)) {
            int a2 = d.a(activity);
            if (a2 != 0) {
                try {
                    this.f68152a.put(62345, new c(this, bVar));
                    String c2 = d.c(this.f68154c, this.f68155d, str, true);
                    Intent intent = new Intent(activity, AssistActivity.class);
                    intent.putExtra("type", AssistActivity.TYPE_WEB);
                    intent.putExtra("url", c2);
                    activity.startActivityForResult(intent, 62345);
                    return;
                } catch (Exception unused) {
                    g(new d.r.c.d(a2), bVar);
                    return;
                }
            }
            Intent e2 = d.e(activity);
            this.f68152a.put(62345, new c(this, bVar));
            Bundle d2 = d.d(activity, this.f68155d);
            e2.putExtra("action", "action_login");
            e2.putExtra("bundle", d2);
            i(activity, e2, 62345);
            return;
        }
        g(new d.r.c.d(3), bVar);
    }

    public final boolean d(int i2, int i3, Intent intent, d.r.c.b bVar) {
        long currentTimeMillis;
        d.r.c.b bVar2;
        if (i2 == 62345 || i2 == 62347) {
            c cVar = this.f68152a.get(i2);
            if (cVar != null) {
                currentTimeMillis = cVar.f68165b;
                bVar2 = cVar.f68164a;
                this.f68152a.remove(i2);
            } else {
                currentTimeMillis = System.currentTimeMillis();
                bVar2 = bVar;
            }
            if (i2 == 62345) {
                e(i3, intent, bVar2, currentTimeMillis);
                return true;
            } else if (i2 == 62347) {
                h(i3, intent, bVar2, currentTimeMillis);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public final void e(int i2, Intent intent, d.r.c.b bVar, long j) {
        this.f68153b.postDelayed(new RunnableC1906a(i2, bVar, intent, j), 10L);
    }

    public final void f(Intent intent, d.r.c.b bVar, long j, int i2, String str) {
        switch (i2) {
            case 1000006:
                bVar.onError(new d.r.c.d(1000006, str));
                return;
            case 1290001:
                bVar.onError(new d.r.c.d(1290001, str));
                return;
            case 444111001:
                try {
                    String stringExtra = intent.getStringExtra("resjson");
                    this.f68156e.a(stringExtra);
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    jSONObject.optString("openid");
                    jSONObject.optString("uid");
                    jSONObject.optString("access_code");
                    bVar.onComplete(jSONObject);
                    return;
                } catch (Exception unused) {
                    bVar.onError(new d.r.c.d(444222105, d.h(444222105)));
                    return;
                }
            case 444111002:
                bVar.onCancel();
                return;
            case 444111003:
                try {
                    JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("resjson"));
                    if ("1".equals(jSONObject2.optString("appType"))) {
                        jSONObject2.optString("uid");
                    } else {
                        jSONObject2.optString("openid");
                    }
                    bVar.onComplete(jSONObject2);
                    return;
                } catch (Exception unused2) {
                    bVar.onError(new d.r.c.d(444222105, d.h(444222105)));
                    return;
                }
            case 444222000:
                bVar.onError(new d.r.c.d(444222000, str));
                return;
            case 444222001:
                bVar.onError(new d.r.c.d(444222001, str));
                return;
            case 444222002:
                bVar.onError(new d.r.c.d(444222002, str));
                return;
            case 444222003:
                bVar.onError(new d.r.c.d(444222003, str));
                return;
            case 444222104:
                bVar.onError(new d.r.c.d(444222104, str));
                return;
            case 444222105:
                bVar.onError(new d.r.c.d(444222105, str));
                return;
            case 444222106:
                try {
                    new JSONObject(intent.getStringExtra("resjson"));
                    bVar.onError(new d.r.c.d(444222106, str));
                    return;
                } catch (Exception unused3) {
                    bVar.onError(new d.r.c.d(444222105, d.h(444222105)));
                    return;
                }
            case 444222108:
                try {
                    bVar.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                    return;
                } catch (Exception unused4) {
                    bVar.onError(new d.r.c.d(444222105, d.h(444222105)));
                    return;
                }
            case 444222110:
                try {
                    new JSONObject(intent.getStringExtra("resjson"));
                    bVar.onError(new d.r.c.d(444222110, str));
                    return;
                } catch (Exception unused5) {
                    bVar.onError(new d.r.c.d(444222105, d.h(444222105)));
                    return;
                }
            default:
                Log.e("chenqiang", "default  error");
                bVar.onError(new d.r.c.d(i2, d.h(i2)));
                return;
        }
    }

    public final void g(d.r.c.d dVar, d.r.c.b bVar) {
        if (bVar != null) {
            this.f68153b.postDelayed(new b(this, bVar, dVar), 50L);
        }
    }

    public final void h(int i2, Intent intent, d.r.c.b bVar, long j) {
    }

    public final void i(Activity activity, Intent intent, int i2) {
        intent.putExtra("request_code", i2);
        Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
        intent2.putExtra("intent", intent);
        activity.startActivityForResult(intent2, i2);
    }
}
