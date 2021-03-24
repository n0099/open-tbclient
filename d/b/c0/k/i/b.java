package d.b.c0.k.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.widget.m;
import d.b.c0.k.h.d;
import d.b.c0.n.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f42651a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c0.o.a.c f42652b;

    /* loaded from: classes2.dex */
    public class a extends d.b.c0.k.a.a<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42653a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42654b;

        public a(m mVar, String str) {
            this.f42653a = mVar;
            this.f42654b = str;
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            m mVar = this.f42653a;
            mVar.m("pay_platform error msg is " + message, null);
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U());
            d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            d.b.c0.k.h.a.g("8");
            this.f42653a.J();
            b.this.c(map, this.f42654b, this.f42653a);
        }
    }

    /* renamed from: d.b.c0.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0567b implements d.b.c0.o.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42656a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f42657b;

        public C0567b(b bVar, String str, m mVar) {
            this.f42656a = str;
            this.f42657b = mVar;
        }

        @Override // d.b.c0.o.a.a
        public void onResult(int i, String str) {
            d.b.c0.n.d.e("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.f42657b.g(i, d.b.c0.n.b.a(i, this.f42656a, str));
        }
    }

    public b(Activity activity, d.b.c0.o.a.c cVar) {
        this.f42651a = activity;
        this.f42652b = cVar;
    }

    public void a(Bundle bundle, String str, m mVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        d.b.c0.k.b.b.j().h(bundle, new a(mVar, str));
    }

    public void b(Map<String, String> map, String str, m mVar) {
        try {
            a(e.b(map), str, mVar);
        } catch (Throwable th) {
            String message = th.getMessage();
            mVar.m("third pay error msg is " + message, null);
        }
    }

    public void c(Map<String, String> map, String str, m mVar) {
        d.b.c0.o.a.b bVar = new d.b.c0.o.a.b();
        bVar.f42682b = d(map);
        bVar.f42681a = str;
        String str2 = map.get("payOrderNo");
        d.f42625d = str2;
        if (this.f42652b != null) {
            d.b.c0.k.h.a.a();
            this.f42652b.a(this.f42651a, bVar, new C0567b(this, str2, mVar));
            d.b.c0.n.d.e("WalletChannel->thirdPay setIsPreparePaying()");
            mVar.setIsPreparePaying(false);
        }
    }

    public JSONObject d(Map<String, String> map) {
        if (TextUtils.isEmpty(map.get("payInfo"))) {
            return null;
        }
        try {
            return new JSONObject(new String(Base64.decode(map.get("payInfo"), 0)));
        } catch (JSONException unused) {
            return null;
        }
    }
}
