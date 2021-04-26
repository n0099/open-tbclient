package d.a.h0.a.t.c.f;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.a.h0.a.i2.k0;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.t.b.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.t.b.d {

    /* loaded from: classes2.dex */
    public class a implements d.b {

        /* renamed from: d.a.h0.a.t.c.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0775a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.h0.a.r1.e f44091e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ JSONObject f44092f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ String f44093g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ String f44094h;

            /* renamed from: d.a.h0.a.t.c.f.b$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0776a implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0776a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", QueryResponse.Options.CANCEL);
                        RunnableC0775a runnableC0775a = RunnableC0775a.this;
                        b.this.c(runnableC0775a.f44093g, new d.a.h0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.h0.a.t.b.d.f44021c) {
                            e2.printStackTrace();
                        }
                        RunnableC0775a runnableC0775a2 = RunnableC0775a.this;
                        b.this.c(runnableC0775a2.f44093g, new d.a.h0.a.t.e.b(201));
                    }
                }
            }

            /* renamed from: d.a.h0.a.t.c.f.b$a$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class DialogInterface$OnClickListenerC0777b implements DialogInterface.OnClickListener {
                public DialogInterface$OnClickListenerC0777b() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "confirm");
                        RunnableC0775a runnableC0775a = RunnableC0775a.this;
                        b.this.c(runnableC0775a.f44093g, new d.a.h0.a.t.e.b(0, jSONObject));
                    } catch (JSONException e2) {
                        if (d.a.h0.a.t.b.d.f44021c) {
                            e2.printStackTrace();
                        }
                        RunnableC0775a runnableC0775a2 = RunnableC0775a.this;
                        b.this.c(runnableC0775a2.f44093g, new d.a.h0.a.t.e.b(201));
                    }
                }
            }

            public RunnableC0775a(d.a.h0.a.r1.e eVar, JSONObject jSONObject, String str, String str2) {
                this.f44091e = eVar;
                this.f44092f = jSONObject;
                this.f44093g = str;
                this.f44094h = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f44091e.v() == null || this.f44091e.v().isFinishing() || this.f44091e.v().isDestroyed()) {
                    return;
                }
                g.a aVar = new g.a(b.this.h());
                aVar.V(this.f44092f.optString("title"));
                aVar.y(this.f44092f.optString("content"));
                aVar.n(new d.a.h0.a.j2.g.a());
                aVar.m(false);
                if (this.f44092f.optBoolean("showCancel", true)) {
                    aVar.F(this.f44092f.optString("cancelColor"), d.a.h0.a.c.aiapps_modal_cancel_color);
                    String optString = this.f44092f.optString("cancelText");
                    if (TextUtils.isEmpty(optString)) {
                        optString = b.this.h().getString(d.a.h0.a.h.aiapps_cancel);
                    }
                    aVar.D(optString, new DialogInterface$OnClickListenerC0776a());
                }
                aVar.R(this.f44092f.optString("confirmColor"), d.a.h0.a.c.aiapps_modal_confirm_color);
                aVar.P(this.f44094h, new DialogInterface$OnClickListenerC0777b());
                aVar.X();
            }
        }

        public a() {
        }

        @Override // d.a.h0.a.t.b.d.b
        public d.a.h0.a.t.e.b a(d.a.h0.a.r1.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("confirmText");
            if (TextUtils.isEmpty(optString)) {
                optString = b.this.h().getString(d.a.h0.a.h.aiapps_ok);
            }
            k0.X(new RunnableC0775a(eVar, jSONObject, str, optString));
            return new d.a.h0.a.t.e.b(0);
        }
    }

    public b(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.a.h0.a.t.e.b t(String str) {
        if (d.a.h0.a.t.b.d.f44021c) {
            Log.d("Api-Modal", "start show modal");
        }
        return i(str, true, new a());
    }
}
