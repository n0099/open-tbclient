package d.a.a0.k.i;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.poly.widget.m;
import d.a.a0.k.h.d;
import d.a.a0.n.e;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Activity f39203a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.a0.o.a.c f39204b;

    /* loaded from: classes2.dex */
    public class a extends d.a.a0.k.a.a<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f39205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f39206b;

        public a(m mVar, String str) {
            this.f39205a = mVar;
            this.f39206b = str;
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            m mVar = this.f39205a;
            mVar.m("pay_platform error msg is " + message, null);
            d.a.a0.k.h.b bVar = new d.a.a0.k.h.b("1");
            bVar.c(new com.baidu.poly.a.i.a("pay_platform error --> " + str, th).U());
            d.b(bVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.k.a.a
        /* renamed from: c */
        public void a(Map<String, String> map) {
            d.a.a0.k.h.a.g("8");
            this.f39205a.I();
            b.this.c(map, this.f39206b, this.f39205a);
        }
    }

    /* renamed from: d.a.a0.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0496b implements d.a.a0.o.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f39208a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ m f39209b;

        public C0496b(b bVar, String str, m mVar) {
            this.f39208a = str;
            this.f39209b = mVar;
        }

        @Override // d.a.a0.o.a.a
        public void onResult(int i2, String str) {
            d.a.a0.n.d.e("WalletChannel->thirdPay onResult statusCode = " + i2 + " msg = " + str);
            this.f39209b.g(i2, d.a.a0.n.b.a(i2, this.f39208a, str));
        }
    }

    public b(Activity activity, d.a.a0.o.a.c cVar) {
        this.f39203a = activity;
        this.f39204b = cVar;
    }

    public void a(Bundle bundle, String str, m mVar) {
        bundle.putString("reqData", "{\"payChannel\": \"" + str + "\"}");
        d.a.a0.k.b.b.j().h(bundle, new a(mVar, str));
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
        d.a.a0.o.a.b bVar = new d.a.a0.o.a.b();
        bVar.f39234b = d(map);
        bVar.f39233a = str;
        String str2 = map.get("payOrderNo");
        d.f39177d = str2;
        if (this.f39204b != null) {
            d.a.a0.k.h.a.a();
            this.f39204b.a(this.f39203a, bVar, new C0496b(this, str2, mVar));
            d.a.a0.n.d.e("WalletChannel->thirdPay setIsPreparePaying()");
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
