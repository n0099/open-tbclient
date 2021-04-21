package d.b.h0.a.t.c.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.h0.a.i2.k0;
import d.b.h0.a.q1.b.b.g;
import d.b.h0.a.t.b.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.b.h0.a.t.c.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0836a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.a.r1.e f46716e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f46717f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f46718g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f46719h;

            /* renamed from: d.b.h0.a.t.c.f.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0837a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0837a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0836a runnableC0836a = RunnableC0836a.this;
                        b.this.c(runnableC0836a.f46718g, new d.b.h0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.h0.a.t.b.d.f46650c) {
                            e2.printStackTrace();
                        }
                        RunnableC0836a runnableC0836a2 = RunnableC0836a.this;
                        b.this.c(runnableC0836a2.f46718g, new d.b.h0.a.t.e.b(201));
                    }
                }
            }

            /* renamed from: d.b.h0.a.t.c.f.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0838b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0838b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0836a runnableC0836a = RunnableC0836a.this;
                        b.this.c(runnableC0836a.f46718g, new d.b.h0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.b.h0.a.t.b.d.f46650c) {
                            e2.printStackTrace();
                        }
                        RunnableC0836a runnableC0836a2 = RunnableC0836a.this;
                        b.this.c(runnableC0836a2.f46718g, new d.b.h0.a.t.e.b(201));
                    }
                }
            }

            public RunnableC0836a(d.b.h0.a.r1.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f46716e = eVar;
                this.f46717f = jSONObject;
                this.f46718g = str;
                this.f46719h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f46716e.n() == null || this.f46716e.n().isFinishing() || this.f46716e.n().isDestroyed()) {
                    return;
                }
                g.a aVar = new g.a(b.this.h());
                aVar.V(this.f46717f.optString("title"));
                aVar.y(this.f46717f.optString("content"));
                aVar.n(new d.b.h0.a.j2.g.a());
                aVar.m(false);
                if (this.f46717f.optBoolean("showCancel", true)) {
                    aVar.F(this.f46717f.optString("cancelColor"), d.b.h0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f46717f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.h().getString(d.b.h0.a.h.aiapps_cancel);
                    }
                    aVar.D(optString, new DialogInterface$OnClickListenerC0837a());
                }
                aVar.R(this.f46717f.optString("confirmColor"), d.b.h0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f46719h, new DialogInterface$OnClickListenerC0838b());
                aVar.X();
            }
        }

        public a() {
        }

        @Override // d.b.h0.a.t.b.d.b
        public d.b.h0.a.t.e.b a(d.b.h0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.h().getString(d.b.h0.a.h.aiapps_ok);
            }
            k0.X(new RunnableC0836a(eVar, jSONObject, str, optString));
            return new d.b.h0.a.t.e.b(0);
        }
    }

    public b(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.h0.a.t.e.b t(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-Modal", "start show modal");
        }
        return i(str, true, new a());
    }
}
