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
        public class RunnableC0841a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.l0.a.a2.e f44919e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f44920f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f44921g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f44922h;

            /* renamed from: d.a.l0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0842a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0842a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0841a runnableC0841a = RunnableC0841a.this;
                        b.this.d(runnableC0841a.f44921g, new d.a.l0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.l0.a.u.c.d.f44812c) {
                            e2.printStackTrace();
                        }
                        RunnableC0841a runnableC0841a2 = RunnableC0841a.this;
                        b.this.d(runnableC0841a2.f44921g, new d.a.l0.a.u.h.b(201));
                    }
                }
            }

            /* renamed from: d.a.l0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0843b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0843b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0841a runnableC0841a = RunnableC0841a.this;
                        b.this.d(runnableC0841a.f44921g, new d.a.l0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.l0.a.u.c.d.f44812c) {
                            e2.printStackTrace();
                        }
                        RunnableC0841a runnableC0841a2 = RunnableC0841a.this;
                        b.this.d(runnableC0841a2.f44921g, new d.a.l0.a.u.h.b(201));
                    }
                }
            }

            public RunnableC0841a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f44919e = eVar;
                this.f44920f = jSONObject;
                this.f44921g = str;
                this.f44922h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f44919e.x() == null || this.f44919e.x().isFinishing() || this.f44919e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(b.this.i());
                aVar.V(this.f44920f.optString("title"));
                aVar.x(this.f44920f.optString("content"));
                aVar.n(new d.a.l0.a.w2.h.a());
                aVar.m(false);
                if (this.f44920f.optBoolean("showCancel", true)) {
                    aVar.E(this.f44920f.optString("cancelColor"), d.a.l0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f44920f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.i().getString(d.a.l0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0842a());
                }
                aVar.R(this.f44920f.optString("confirmColor"), d.a.l0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f44922h, new DialogInterface$OnClickListenerC0843b());
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
            q0.b0(new RunnableC0841a(eVar, jSONObject, str, optString));
            return new d.a.l0.a.u.h.b(0);
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.l0.a.u.h.b u(String str) {
        if (d.a.l0.a.u.c.d.f44812c) {
            Log.d("Api-Modal", "start show modal");
        }
        return j(str, true, new a());
    }
}
