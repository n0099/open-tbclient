package d.a.m0.a.u.e.g;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.m0.a.u.c.d;
import d.a.m0.a.v2.q0;
import d.a.m0.a.z1.b.b.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.m0.a.u.e.g.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0900a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.m0.a.a2.e f48701e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f48702f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f48703g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f48704h;

            /* renamed from: d.a.m0.a.u.e.g.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0901a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0901a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0900a runnableC0900a = RunnableC0900a.this;
                        b.this.d(runnableC0900a.f48703g, new d.a.m0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.m0.a.u.c.d.f48594c) {
                            e2.printStackTrace();
                        }
                        RunnableC0900a runnableC0900a2 = RunnableC0900a.this;
                        b.this.d(runnableC0900a2.f48703g, new d.a.m0.a.u.h.b(201));
                    }
                }
            }

            /* renamed from: d.a.m0.a.u.e.g.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0902b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0902b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0900a runnableC0900a = RunnableC0900a.this;
                        b.this.d(runnableC0900a.f48703g, new d.a.m0.a.u.h.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.m0.a.u.c.d.f48594c) {
                            e2.printStackTrace();
                        }
                        RunnableC0900a runnableC0900a2 = RunnableC0900a.this;
                        b.this.d(runnableC0900a2.f48703g, new d.a.m0.a.u.h.b(201));
                    }
                }
            }

            public RunnableC0900a(d.a.m0.a.a2.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f48701e = eVar;
                this.f48702f = jSONObject;
                this.f48703g = str;
                this.f48704h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f48701e.x() == null || this.f48701e.x().isFinishing() || this.f48701e.x().isDestroyed()) {
                    return;
                }
                h.a aVar = new h.a(b.this.i());
                aVar.V(this.f48702f.optString("title"));
                aVar.x(this.f48702f.optString("content"));
                aVar.n(new d.a.m0.a.w2.h.a());
                aVar.m(false);
                if (this.f48702f.optBoolean("showCancel", true)) {
                    aVar.E(this.f48702f.optString("cancelColor"), d.a.m0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f48702f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.i().getString(d.a.m0.a.h.aiapps_cancel);
                    }
                    aVar.C(optString, new DialogInterface$OnClickListenerC0901a());
                }
                aVar.R(this.f48702f.optString("confirmColor"), d.a.m0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f48704h, new DialogInterface$OnClickListenerC0902b());
                aVar.X();
            }
        }

        public a() {
        }

        @Override // d.a.m0.a.u.c.d.b
        public d.a.m0.a.u.h.b a(d.a.m0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.i().getString(d.a.m0.a.h.aiapps_confirm);
            }
            q0.b0(new RunnableC0900a(eVar, jSONObject, str, optString));
            return new d.a.m0.a.u.h.b(0);
        }
    }

    public b(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b u(String str) {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-Modal", "start show modal");
        }
        return j(str, true, new a());
    }
}
