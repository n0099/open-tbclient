package d.b.a0.k.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.widget.m;
import d.b.a0.k.h.d;
import d.b.a0.n.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f42022a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.a0.o.a.c f42023b;

    /* loaded from: classes2.dex */
    public class a extends d.b.a0.k.a.a<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42024a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f42025b;

        public a(m mVar, String str) {
            this.f42024a = mVar;
            this.f42025b = str;
        }

        @Override // d.b.a0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            m mVar = this.f42024a;
            mVar.m("pay_platform error msg is " + message, null);
            d.b.a0.k.h.b bVar = new d.b.a0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U());
            d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            d.b.a0.k.h.a.g("8");
            this.f42024a.J();
            b.this.c(map, this.f42025b, this.f42024a);
        }
    }

    /* renamed from: d.b.a0.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0557b implements d.b.a0.o.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f42027a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f42028b;

        public C0557b(b bVar, String str, m mVar) {
            this.f42027a = str;
            this.f42028b = mVar;
        }

        @Override // d.b.a0.o.a.a
        public void onResult(int i, String str) {
            d.b.a0.n.d.e("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.f42028b.g(i, d.b.a0.n.b.a(i, this.f42027a, str));
        }
    }

    public b(Activity activity, d.b.a0.o.a.c cVar) {
        this.f42022a = activity;
        this.f42023b = cVar;
    }

    public void a(Bundle bundle, String str, m mVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        d.b.a0.k.b.b.j().h(bundle, new a(mVar, str));
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
        d.b.a0.o.a.b bVar = new d.b.a0.o.a.b();
        bVar.f42053b = d(map);
        bVar.f42052a = str;
        String str2 = map.get("payOrderNo");
        d.f41996d = str2;
        if (this.f42023b != null) {
            d.b.a0.k.h.a.a();
            this.f42023b.a(this.f42022a, bVar, new C0557b(this, str2, mVar));
            d.b.a0.n.d.e("WalletChannel->thirdPay setIsPreparePaying()");
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
