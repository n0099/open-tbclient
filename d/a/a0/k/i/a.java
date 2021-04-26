package d.a.a0.k.i;

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
import d.a.a0.f;
import d.a.a0.g;
import d.a.a0.h;
import d.a.a0.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f39185e;

    /* renamed from: a  reason: collision with root package name */
    public long f39186a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f39187b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.a0.p.c f39188c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.a0.p.c f39189d;

    /* renamed from: d.a.a0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0495a extends d.a.a0.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f39190a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f39191b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f39192c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f39193d;

        public C0495a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f39190a = mVar;
            this.f39191b = z;
            this.f39192c = context;
            this.f39193d = bundle;
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f39190a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f39190a.g(0, d.a.a0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f39191b) {
                a.this.c(this.f39192c, this.f39193d, this.f39190a);
            } else {
                a.this.e(this.f39192c, this.f39190a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f39195e;

        public b(m mVar) {
            this.f39195e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f39188c.q();
            d.a.a0.k.h.b bVar = new d.a.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("1");
            d.a.a0.k.h.d.b(bVar);
            this.f39195e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f39197e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f39198f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f39199g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f39197e = context;
            this.f39198f = bundle;
            this.f39199g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f39188c.q();
            d.a.a0.k.h.b bVar = new d.a.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("2");
            d.a.a0.k.h.d.b(bVar);
            a.this.d(this.f39197e, this.f39198f, this.f39199g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f39189d == null || !a.this.f39189d.u()) {
                return;
            }
            a.this.f39189d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f39202a;

        public e(a aVar, m mVar) {
            this.f39202a = mVar;
        }

        @Override // d.a.a0.p.c.b
        public void onDismiss() {
            this.f39202a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f39185e == null) {
            synchronized (a.class) {
                if (f39185e == null) {
                    f39185e = new a();
                }
            }
        }
        return f39185e;
    }

    public final View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
        d.a.a0.p.c cVar = new d.a.a0.p.c(inflate, -1, -1, true);
        this.f39188c = cVar;
        cVar.y(false);
        this.f39188c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f39188c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.a.a0.k.h.d.b(new d.a.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f39187b = d.a.a0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f39186a = System.currentTimeMillis();
        d.a.a0.k.b.b.j().g(bundle, new C0495a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.a.a0.p.c cVar = new d.a.a0.p.c(inflate, -1, -1, true);
        this.f39189d = cVar;
        cVar.y(false);
        this.f39189d.C(false);
        this.f39189d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f39189d.h(new e(this, mVar));
        this.f39189d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.a.a0.k.k.a.c(this.f39187b);
        try {
            if (this.f39186a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f39186a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.a.a0.k.h.b bVar = new d.a.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.a.a0.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.a.a0.n.d.f39231d) {
                e2.printStackTrace();
            }
        } finally {
            this.f39186a = 0L;
        }
    }
}
