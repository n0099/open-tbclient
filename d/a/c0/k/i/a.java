package d.a.c0.k.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.poly.widget.m;
import com.baidu.tbadk.core.util.TbEnum;
import d.a.c0.f;
import d.a.c0.g;
import d.a.c0.h;
import d.a.c0.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f43131e;

    /* renamed from: a  reason: collision with root package name */
    public long f43132a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f43133b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c0.p.c f43134c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c0.p.c f43135d;

    /* renamed from: d.a.c0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0564a extends d.a.c0.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f43136a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f43137b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f43138c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f43139d;

        public C0564a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f43136a = mVar;
            this.f43137b = z;
            this.f43138c = context;
            this.f43139d = bundle;
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f43136a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f43136a.g(0, d.a.c0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f43137b) {
                a.this.c(this.f43138c, this.f43139d, this.f43136a);
            } else {
                a.this.e(this.f43138c, this.f43136a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f43141e;

        public b(m mVar) {
            this.f43141e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f43134c.q();
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b("103");
            bVar.c("1");
            d.a.c0.k.h.d.b(bVar);
            this.f43141e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f43143e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f43144f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f43145g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f43143e = context;
            this.f43144f = bundle;
            this.f43145g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f43134c.q();
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b("103");
            bVar.c("2");
            d.a.c0.k.h.d.b(bVar);
            a.this.d(this.f43143e, this.f43144f, this.f43145g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f43135d == null || !a.this.f43135d.u()) {
                return;
            }
            a.this.f43135d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f43148a;

        public e(a aVar, m mVar) {
            this.f43148a = mVar;
        }

        @Override // d.a.c0.p.c.b
        public void onDismiss() {
            this.f43148a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f43131e == null) {
            synchronized (a.class) {
                if (f43131e == null) {
                    f43131e = new a();
                }
            }
        }
        return f43131e;
    }

    public final View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
        d.a.c0.p.c cVar = new d.a.c0.p.c(inflate, -1, -1, true);
        this.f43134c = cVar;
        cVar.y(false);
        this.f43134c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f43134c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.a.c0.k.h.d.b(new d.a.c0.k.h.b("102"));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f43133b = d.a.c0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f43132a = System.currentTimeMillis();
        d.a.c0.k.b.b.j().g(bundle, new C0564a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.a.c0.p.c cVar = new d.a.c0.p.c(inflate, -1, -1, true);
        this.f43135d = cVar;
        cVar.y(false);
        this.f43135d.C(false);
        this.f43135d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f43135d.h(new e(this, mVar));
        this.f43135d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.a.c0.k.k.a.c(this.f43133b);
        try {
            if (this.f43132a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f43132a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.a.c0.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.a.c0.n.d.f43177d) {
                e2.printStackTrace();
            }
        } finally {
            this.f43132a = 0L;
        }
    }
}
