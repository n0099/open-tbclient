package d.a.i0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.i0.a.u.c.d;
import d.a.i0.a.v2.q0;
import d.a.i0.a.z1.b.b.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.i0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0830a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.a.a2.e f44743e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f44744f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f44745g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f44746h;

            /* renamed from: d.a.i0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0831a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0831a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0830a runnableC0830a = RunnableC0830a.this;
                        b.this.d(runnableC0830a.f44745g, new d.a.i0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.i0.a.u.c.d.f44636c) {
                            e2.printStackTrace();
                        }
                        RunnableC0830a runnableC0830a2 = RunnableC0830a.this;
                        b.this.d(runnableC0830a2.f44745g, new d.a.i0.a.u.h.b(201));
                    }
                }
            }

            /* renamed from: d.a.i0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0832b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0832b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0830a runnableC0830a = RunnableC0830a.this;
                        b.this.d(runnableC0830a.f44745g, new d.a.i0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.i0.a.u.c.d.f44636c) {
                            e2.printStackTrace();
                        }
                        RunnableC0830a runnableC0830a2 = RunnableC0830a.this;
                        b.this.d(runnableC0830a2.f44745g, new d.a.i0.a.u.h.b(201));
                    }
                }
            }

            public RunnableC0830a(d.a.i0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f44743e = eVar;
                this.f44744f = jSONObject;
                this.f44745g = str;
                this.f44746h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f44743e.x() == null || this.f44743e.x().isFinishing() || this.f44743e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(b.this.i());
                aVar.V(this.f44744f.optString("title"));
                aVar.x(this.f44744f.optString("content"));
                aVar.n(new d.a.i0.a.w2.h.a());
                aVar.m(false);
                if (this.f44744f.optBoolean("showCancel", true)) {
                    aVar.E(this.f44744f.optString("cancelColor"), d.a.i0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f44744f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.i().getString(d.a.i0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0831a());
                }
                aVar.R(this.f44744f.optString("confirmColor"), d.a.i0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f44746h, new DialogInterface$OnClickListenerC0832b());
                aVar.X();
            }
        }

        public a() {
        }

        @Override // d.a.i0.a.u.c.d.b
        public d.a.i0.a.u.h.b a(d.a.i0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.i().getString(d.a.i0.a.h.aiapps_confirm);
            }
            q0.b0(new RunnableC0830a(eVar, jSONObject, str, optString));
            return new d.a.i0.a.u.h.b(0);
        }
    }

    public b(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b u(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-Modal", "start show modal");
        }
        return j(str, true, new a());
    }
}
