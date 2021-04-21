package d.b.a0.k.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.router.RouterCallback;
import d.b.a0.h;
import d.b.a0.k.a.e;
import d.b.a0.k.a.f;
import d.b.a0.n.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static String f41932b = "payChannel";

    /* renamed from: c  reason: collision with root package name */
    public static String f41933c = "payType";

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f41934d;

    /* renamed from: a  reason: collision with root package name */
    public e f41935a;

    /* loaded from: classes2.dex */
    public class a extends d.b.a0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.k.a.a f41936a;

        public a(b bVar, d.b.a0.k.a.a aVar) {
            this.f41936a = aVar;
        }

        @Override // d.b.a0.k.a.a
        public void b(Throwable th, String str) {
            d.b.a0.k.h.a.f("7");
            this.f41936a.b(th, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(RouterCallback.KEY_ERROR_CODE, -1);
                int optInt2 = jSONObject.optInt("errno", -1);
                if (optInt == 0 && optInt2 == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        d.b.a0.k.h.a.d("7", optInt2 + "", jSONObject.optString("msg"));
                        d.b.a0.k.a.a aVar = this.f41936a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("msg = ");
                        sb.append(jSONObject.optString("msg"));
                        aVar.b(new com.baidu.poly.a.i.b(sb.toString()), "data is empty");
                    } else {
                        this.f41936a.a(optJSONObject);
                    }
                } else {
                    d.b.a0.k.h.a.d("7", optInt2 + "", jSONObject.optString("errmsg"));
                    d.b.a0.k.a.a aVar2 = this.f41936a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("errmsg = ");
                    sb2.append(jSONObject.optString("errmsg"));
                    com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("errno is ");
                    sb3.append(optInt2);
                    aVar2.b(bVar, sb3.toString());
                }
            } catch (JSONException e2) {
                d.b.a0.k.h.a.d("7", null, null);
                this.f41936a.b(e2, "error");
            }
        }
    }

    /* renamed from: d.b.a0.k.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0551b extends d.b.a0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.k.a.a f41937a;

        public C0551b(d.b.a0.k.a.a aVar) {
            this.f41937a = aVar;
        }

        @Override // d.b.a0.k.a.a
        public void b(Throwable th, String str) {
            d.b.a0.k.h.a.f("8");
            this.f41937a.b(th, g.a().getResources().getString(h.common_error_tips));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.f41937a.a(b.this.i(jSONObject.optJSONObject("data")));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(optInt);
                    sb.append("");
                    d.b.a0.k.h.a.d("8", sb.toString(), jSONObject.optString("msg"));
                    d.b.a0.k.a.a aVar = this.f41937a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("msg = ");
                    sb2.append(jSONObject.optString("msg"));
                    aVar.b(new com.baidu.poly.a.i.b(sb2.toString()), jSONObject.optString("msg"));
                }
            } catch (Throwable th) {
                d.b.a0.k.h.a.d("8", null, null);
                this.f41937a.b(th, g.a().getResources().getString(h.common_error_tips));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.a0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.k.a.a f41939a;

        public c(d.b.a0.k.a.a aVar) {
            this.f41939a = aVar;
        }

        @Override // d.b.a0.k.a.a
        public void b(Throwable th, String str) {
            d.b.a0.k.h.a.f("8");
            this.f41939a.b(th, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.f41939a.a(b.this.i(jSONObject.optJSONObject("data")));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(optInt);
                    sb.append("");
                    d.b.a0.k.h.a.d("8", sb.toString(), jSONObject.optString("msg"));
                    d.b.a0.k.a.a aVar = this.f41939a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("msg = ");
                    sb2.append(jSONObject.optString("msg"));
                    com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("errno is ");
                    sb3.append(optInt);
                    aVar.b(bVar, sb3.toString());
                }
            } catch (Throwable th) {
                d.b.a0.k.h.a.d("8", null, null);
                this.f41939a.b(th, "error");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.a0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.k.a.a f41941a;

        public d(b bVar, d.b.a0.k.a.a aVar) {
            this.f41941a = aVar;
        }

        @Override // d.b.a0.k.a.a
        public void b(Throwable th, String str) {
            this.f41941a.b(th, str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno", -1);
                if (optInt == 0) {
                    this.f41941a.a(jSONObject.optJSONObject("data"));
                } else {
                    d.b.a0.k.a.a aVar = this.f41941a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("msg = ");
                    sb.append(jSONObject.optString("msg"));
                    com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("errno is ");
                    sb2.append(optInt);
                    aVar.b(bVar, sb2.toString());
                }
            } catch (Throwable th) {
                this.f41941a.b(th, "error");
            }
        }
    }

    public b(e eVar) {
        this.f41935a = eVar;
    }

    public static b j() {
        if (f41934d == null) {
            synchronized (b.class) {
                if (f41934d == null) {
                    f41934d = new b(new f());
                }
            }
        }
        return f41934d;
    }

    public d.b.a0.k.a.b a(Bundle bundle, d.b.a0.k.a.c cVar) {
        d.b.a0.k.a.b bVar = new d.b.a0.k.a.b();
        f(bVar, bundle);
        bVar.e(f41933c, "android");
        e(bundle, bVar, cVar);
        return bVar;
    }

    public void c(Bundle bundle, d.b.a0.k.a.a<JSONObject> aVar) {
        d.b.a0.k.a.c k = k();
        Set<String> keySet = bundle.keySet();
        d.b.a0.k.a.b bVar = new d.b.a0.k.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.e(str, bundle.get(str).toString());
            }
        }
        e(bundle, bVar, k);
        this.f41935a.a(d.b.a0.k.b.d.d(), k, bVar, new a(this, aVar));
    }

    public void d(Bundle bundle, d.b.a0.k.a.a<Map<String, String>> aVar, String str) {
        d.b.a0.k.a.c k = k();
        Set<String> keySet = bundle.keySet();
        d.b.a0.k.a.b bVar = new d.b.a0.k.a.b();
        for (String str2 : keySet) {
            if (bundle.get(str2) instanceof String) {
                bVar.e(str2, bundle.get(str2).toString());
            }
        }
        bVar.e(f41932b, str);
        e(bundle, bVar, k);
        this.f41935a.a(d.b.a0.k.b.d.f(), k, bVar, new C0551b(aVar));
    }

    public final void e(Bundle bundle, d.b.a0.k.a.b bVar, d.b.a0.k.a.c cVar) {
        String string = bundle.getString("bduss");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String b2 = cVar.b("Cookie");
        String str = "BDUSS=" + string;
        if (b2 == null) {
            cVar.e("Cookie", str);
            return;
        }
        cVar.e("Cookie", b2 + "; " + str);
    }

    public final void f(d.b.a0.k.a.b bVar, Bundle bundle) {
        if (bundle == null || bVar == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            bVar.e(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = bVar.c().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void g(Bundle bundle, d.b.a0.k.a.a<JSONObject> aVar) {
        d.b.a0.k.a.c k = k();
        Set<String> keySet = bundle.keySet();
        d.b.a0.k.a.b bVar = new d.b.a0.k.a.b();
        for (String str : keySet) {
            if (bundle.get(str) instanceof String) {
                bVar.e(str, bundle.get(str).toString());
            }
        }
        this.f41935a.a(d.b.a0.k.b.d.h(), k, bVar, new d(this, aVar));
    }

    public void h(Bundle bundle, d.b.a0.k.a.a<Map<String, String>> aVar) {
        d.b.a0.k.a.c k = k();
        d.b.a0.k.a.b a2 = a(bundle, k);
        this.f41935a.a(d.b.a0.k.b.d.g(), k, a2, new c(aVar));
    }

    public final Map<String, String> i(JSONObject jSONObject) {
        Map<String, String> a2 = d.b.a0.n.e.a();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    a2.put(next, jSONObject.optString(next));
                }
            }
        }
        return a2;
    }

    public final d.b.a0.k.a.c k() {
        return new d.b.a0.k.a.c();
    }
}
