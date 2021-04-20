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
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.b.g0.a.t.c.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0816a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.g0.a.r1.e f46387e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f46388f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f46389g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f46390h;

            /* renamed from: d.b.g0.a.t.c.f.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0817a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0817a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0816a runnableC0816a = RunnableC0816a.this;
                        b.this.c(runnableC0816a.f46389g, new d.b.g0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.g0.a.t.b.d.f46321c) {
                            e2.printStackTrace();
                        }
                        RunnableC0816a runnableC0816a2 = RunnableC0816a.this;
                        b.this.c(runnableC0816a2.f46389g, new d.b.g0.a.t.e.b(201));
                    }
                }
            }

            /* renamed from: d.b.g0.a.t.c.f.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0818b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0818b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0816a runnableC0816a = RunnableC0816a.this;
                        b.this.c(runnableC0816a.f46389g, new d.b.g0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.g0.a.t.b.d.f46321c) {
                            e2.printStackTrace();
                        }
                        RunnableC0816a runnableC0816a2 = RunnableC0816a.this;
                        b.this.c(runnableC0816a2.f46389g, new d.b.g0.a.t.e.b(201));
                    }
                }
            }

            public RunnableC0816a(d.b.g0.a.r1.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f46387e = eVar;
                this.f46388f = jSONObject;
                this.f46389g = str;
                this.f46390h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f46387e.n() == null || this.f46387e.n().isFinishing() || this.f46387e.n().isDestroyed()) {
                    return;
                }
                g.a aVar = new g.a(b.this.h());
                aVar.V(this.f46388f.optString("title"));
                aVar.y(this.f46388f.optString("content"));
                aVar.n(new d.b.g0.a.j2.g.a());
                aVar.m(false);
                if (this.f46388f.optBoolean("showCancel", true)) {
                    aVar.F(this.f46388f.optString("cancelColor"), d.b.g0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f46388f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.h().getString(d.b.g0.a.h.aiapps_cancel);
                    }
                    aVar.D(optString, new DialogInterface$OnClickListenerC0817a());
                }
                aVar.R(this.f46388f.optString("confirmColor"), d.b.g0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f46390h, new DialogInterface$OnClickListenerC0818b());
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
            k0.X(new RunnableC0816a(eVar, jSONObject, str, optString));
            return new d.b.g0.a.t.e.b(0);
        }
    }

    public b(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b t(String str) {
        if (d.b.g0.a.t.b.d.f46321c) {
            Log.d("Api-Modal", "start show modal");
        }
        return i(str, true, new a());
    }
}
