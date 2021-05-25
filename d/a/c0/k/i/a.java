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
    public static volatile a f39450e;

    /* renamed from: a  reason: collision with root package name */
    public long f39451a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f39452b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c0.p.c f39453c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c0.p.c f39454d;

    /* renamed from: d.a.c0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0508a extends d.a.c0.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f39455a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f39456b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f39457c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f39458d;

        public C0508a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f39455a = mVar;
            this.f39456b = z;
            this.f39457c = context;
            this.f39458d = bundle;
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f39455a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f39455a.g(0, d.a.c0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f39456b) {
                a.this.c(this.f39457c, this.f39458d, this.f39455a);
            } else {
                a.this.e(this.f39457c, this.f39455a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f39460e;

        public b(m mVar) {
            this.f39460e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f39453c.q();
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("1");
            d.a.c0.k.h.d.b(bVar);
            this.f39460e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f39463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f39464g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f39462e = context;
            this.f39463f = bundle;
            this.f39464g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f39453c.q();
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("2");
            d.a.c0.k.h.d.b(bVar);
            a.this.d(this.f39462e, this.f39463f, this.f39464g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f39454d == null || !a.this.f39454d.u()) {
                return;
            }
            a.this.f39454d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f39467a;

        public e(a aVar, m mVar) {
            this.f39467a = mVar;
        }

        @Override // d.a.c0.p.c.b
        public void onDismiss() {
            this.f39467a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f39450e == null) {
            synchronized (a.class) {
                if (f39450e == null) {
                    f39450e = new a();
                }
            }
        }
        return f39450e;
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
        this.f39453c = cVar;
        cVar.y(false);
        this.f39453c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f39453c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.a.c0.k.h.d.b(new d.a.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f39452b = d.a.c0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f39451a = System.currentTimeMillis();
        d.a.c0.k.b.b.j().g(bundle, new C0508a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.a.c0.p.c cVar = new d.a.c0.p.c(inflate, -1, -1, true);
        this.f39454d = cVar;
        cVar.y(false);
        this.f39454d.C(false);
        this.f39454d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f39454d.h(new e(this, mVar));
        this.f39454d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.a.c0.k.k.a.c(this.f39452b);
        try {
            if (this.f39451a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f39451a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.a.c0.k.h.b bVar = new d.a.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.a.c0.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.a.c0.n.d.f39496d) {
                e2.printStackTrace();
            }
        } finally {
            this.f39451a = 0L;
        }
    }
}
