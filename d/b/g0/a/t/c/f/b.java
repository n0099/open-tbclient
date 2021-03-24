package d.b.g0.a.t.c.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.g0.a.i2.k0;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.t.b.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements d.b {

        /* renamed from: d.b.g0.a.t.c.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0803a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.r1.e f45994e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f45995f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f45996g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f45997h;

            /* renamed from: d.b.g0.a.t.c.f.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class DialogInterface$OnClickListenerC0804a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0804a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0803a runnableC0803a = RunnableC0803a.this;
                        b.this.c(runnableC0803a.f45996g, new d.b.g0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.g0.a.t.b.d.f45928c) {
                            e2.printStackTrace();
                        }
                        RunnableC0803a runnableC0803a2 = RunnableC0803a.this;
                        b.this.c(runnableC0803a2.f45996g, new d.b.g0.a.t.e.b(201));
                    }
                }
            }

            /* renamed from: d.b.g0.a.t.c.f.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class DialogInterface$OnClickListenerC0805b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0805b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0803a runnableC0803a = RunnableC0803a.this;
                        b.this.c(runnableC0803a.f45996g, new d.b.g0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.g0.a.t.b.d.f45928c) {
                            e2.printStackTrace();
                        }
                        RunnableC0803a runnableC0803a2 = RunnableC0803a.this;
                        b.this.c(runnableC0803a2.f45996g, new d.b.g0.a.t.e.b(201));
                    }
                }
            }

            public RunnableC0803a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f45994e = eVar;
                this.f45995f = jSONObject;
                this.f45996g = str;
                this.f45997h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f45994e.n() == null || this.f45994e.n().isFinishing() || this.f45994e.n().isDestroyed()) {
                    return;
                }
                g.a aVar = new g.a(b.this.h());
                aVar.V(this.f45995f.optString("title"));
                aVar.y(this.f45995f.optString("content"));
                aVar.n(new d.b.g0.a.j2.g.a());
                aVar.m(false);
                if (this.f45995f.optBoolean("showCancel", true)) {
                    aVar.F(this.f45995f.optString("cancelColor"), d.b.g0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f45995f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.h().getString(d.b.g0.a.h.aiapps_cancel);
                    }
                    aVar.D(optString, new DialogInterface$OnClickListenerC0804a());
                }
                aVar.R(this.f45995f.optString("confirmColor"), d.b.g0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f45997h, new DialogInterface$OnClickListenerC0805b());
                aVar.X();
            }
        }

        public a() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.h().getString(d.b.g0.a.h.aiapps_ok);
            }
            k0.X(new RunnableC0803a(eVar, jSONObject, str, optString));
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public b(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b t(String str) {
        if (d.b.g0.a.t.b.d.f45928c) {
            Log.d("Api-Modal", "start show modal");
        }
        return i(str, true, new a());
    }
}
