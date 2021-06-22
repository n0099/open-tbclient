package d.a.c0.k.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.widget.m;
import d.a.c0.k.h.d;
import d.a.c0.n.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f43252a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c0.o.a.c f43253b;

    /* loaded from: classes2.dex */
    public class a extends d.a.c0.k.a.a<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f43254a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43255b;

        public a(m mVar, String str) {
            this.f43254a = mVar;
            this.f43255b = str;
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            m mVar = this.f43254a;
            mVar.m("pay_platform error msg is " + message, null);
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U());
            d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            d.a.c0.k.h.a.g("8");
            this.f43254a.I();
            b.this.c(map, this.f43255b, this.f43254a);
        }
    }

    /* renamed from: d.a.c0.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0568b implements d.a.c0.o.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43257a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f43258b;

        public C0568b(b bVar, String str, m mVar) {
            this.f43257a = str;
            this.f43258b = mVar;
        }

        @Override // d.a.c0.o.a.a
        public void onResult(int i2, String str) {
            d.a.c0.n.d.e("WalletChannel->thirdPay onResult statusCode = " + i2 + " msg = " + str);
            this.f43258b.g(i2, d.a.c0.n.b.a(i2, this.f43257a, str));
        }
    }

    public b(Activity activity, d.a.c0.o.a.c cVar) {
        this.f43252a = activity;
        this.f43253b = cVar;
    }

    public void a(Bundle bundle, String str, m mVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        d.a.c0.k.b.b.j().h(bundle, new a(mVar, str));
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
        d.a.c0.o.a.b bVar = new d.a.c0.o.a.b();
        bVar.f43283b = d(map);
        bVar.f43282a = str;
        String str2 = map.get("payOrderNo");
        d.f43226d = str2;
        if (this.f43253b != null) {
            d.a.c0.k.h.a.a();
            this.f43253b.a(this.f43252a, bVar, new C0568b(this, str2, mVar));
            d.a.c0.n.d.e("WalletChannel->thirdPay setIsPreparePaying()");
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
