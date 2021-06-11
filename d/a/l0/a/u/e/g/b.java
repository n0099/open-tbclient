package d.a.l0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.l0.a.u.c.d;
import d.a.l0.a.v2.q0;
import d.a.l0.a.z1.b.b.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.l0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0897a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.a2.e f48593e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f48594f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f48595g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f48596h;

            /* renamed from: d.a.l0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0898a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0898a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0897a runnableC0897a = RunnableC0897a.this;
                        b.this.d(runnableC0897a.f48595g, new d.a.l0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.l0.a.u.c.d.f48486c) {
                            e2.printStackTrace();
                        }
                        RunnableC0897a runnableC0897a2 = RunnableC0897a.this;
                        b.this.d(runnableC0897a2.f48595g, new d.a.l0.a.u.h.b(201));
                    }
                }
            }

            /* renamed from: d.a.l0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0899b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0899b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0897a runnableC0897a = RunnableC0897a.this;
                        b.this.d(runnableC0897a.f48595g, new d.a.l0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.l0.a.u.c.d.f48486c) {
                            e2.printStackTrace();
                        }
                        RunnableC0897a runnableC0897a2 = RunnableC0897a.this;
                        b.this.d(runnableC0897a2.f48595g, new d.a.l0.a.u.h.b(201));
                    }
                }
            }

            public RunnableC0897a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f48593e = eVar;
                this.f48594f = jSONObject;
                this.f48595g = str;
                this.f48596h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f48593e.x() == null || this.f48593e.x().isFinishing() || this.f48593e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(b.this.i());
                aVar.V(this.f48594f.optString("title"));
                aVar.x(this.f48594f.optString("content"));
                aVar.n(new d.a.l0.a.w2.h.a());
                aVar.m(false);
                if (this.f48594f.optBoolean("showCancel", true)) {
                    aVar.E(this.f48594f.optString("cancelColor"), d.a.l0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f48594f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.i().getString(d.a.l0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0898a());
                }
                aVar.R(this.f48594f.optString("confirmColor"), d.a.l0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f48596h, new DialogInterface$OnClickListenerC0899b());
                aVar.X();
            }
        }

        public a() {
        }

        @Override // d.a.l0.a.u.c.d.b
        public d.a.l0.a.u.h.b a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.i().getString(d.a.l0.a.h.aiapps_confirm);
            }
            q0.b0(new RunnableC0897a(eVar, jSONObject, str, optString));
            return new d.a.l0.a.u.h.b(0);
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b u(String str) {
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-Modal", "start show modal");
        }
        return j(str, true, new a());
    }
}
