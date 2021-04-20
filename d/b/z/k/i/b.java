package d.b.z.k.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.widget.m;
import d.b.z.k.h.d;
import d.b.z.n.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f65720a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.z.o.a.c f65721b;

    /* loaded from: classes2.dex */
    public class a extends d.b.z.k.a.a<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f65722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65723b;

        public a(m mVar, String str) {
            this.f65722a = mVar;
            this.f65723b = str;
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            m mVar = this.f65722a;
            mVar.m("pay_platform error msg is " + message, null);
            d.b.z.k.h.b bVar = new d.b.z.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U());
            d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.z.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            d.b.z.k.h.a.g("8");
            this.f65722a.J();
            b.this.c(map, this.f65723b, this.f65722a);
        }
    }

    /* renamed from: d.b.z.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1805b implements d.b.z.o.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f65725a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f65726b;

        public C1805b(b bVar, String str, m mVar) {
            this.f65725a = str;
            this.f65726b = mVar;
        }

        @Override // d.b.z.o.a.a
        public void onResult(int i, String str) {
            d.b.z.n.d.e("WalletChannel->thirdPay onResult statusCode = " + i + " msg = " + str);
            this.f65726b.g(i, d.b.z.n.b.a(i, this.f65725a, str));
        }
    }

    public b(Activity activity, d.b.z.o.a.c cVar) {
        this.f65720a = activity;
        this.f65721b = cVar;
    }

    public void a(Bundle bundle, String str, m mVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        d.b.z.k.b.b.j().h(bundle, new a(mVar, str));
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
        d.b.z.o.a.b bVar = new d.b.z.o.a.b();
        bVar.f65751b = d(map);
        bVar.f65750a = str;
        String str2 = map.get("payOrderNo");
        d.f65694d = str2;
        if (this.f65721b != null) {
            d.b.z.k.h.a.a();
            this.f65721b.a(this.f65720a, bVar, new C1805b(this, str2, mVar));
            d.b.z.n.d.e("WalletChannel->thirdPay setIsPreparePaying()");
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
