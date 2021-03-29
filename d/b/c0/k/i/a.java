package d.b.c0.k.i;

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
import d.b.c0.f;
import d.b.c0.g;
import d.b.c0.h;
import d.b.c0.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f42634e;

    /* renamed from: a  reason: collision with root package name */
    public long f42635a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f42636b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c0.p.c f42637c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c0.p.c f42638d;

    /* renamed from: d.b.c0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0567a extends d.b.c0.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42639a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42640b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f42641c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f42642d;

        public C0567a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f42639a = mVar;
            this.f42640b = z;
            this.f42641c = context;
            this.f42642d = bundle;
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f42639a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f42639a.g(0, d.b.c0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f42640b) {
                a.this.c(this.f42641c, this.f42642d, this.f42639a);
            } else {
                a.this.e(this.f42641c, this.f42639a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f42644e;

        public b(m mVar) {
            this.f42644e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f42637c.q();
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("1");
            d.b.c0.k.h.d.b(bVar);
            this.f42644e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f42647f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f42648g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f42646e = context;
            this.f42647f = bundle;
            this.f42648g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f42637c.q();
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("2");
            d.b.c0.k.h.d.b(bVar);
            a.this.d(this.f42646e, this.f42647f, this.f42648g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f42638d == null || !a.this.f42638d.u()) {
                return;
            }
            a.this.f42638d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42651a;

        public e(a aVar, m mVar) {
            this.f42651a = mVar;
        }

        @Override // d.b.c0.p.c.b
        public void onDismiss() {
            this.f42651a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f42634e == null) {
            synchronized (a.class) {
                if (f42634e == null) {
                    f42634e = new a();
                }
            }
        }
        return f42634e;
    }

    public final View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
        d.b.c0.p.c cVar = new d.b.c0.p.c(inflate, -1, -1, true);
        this.f42637c = cVar;
        cVar.y(false);
        this.f42637c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f42637c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.b.c0.k.h.d.b(new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f42636b = d.b.c0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f42635a = System.currentTimeMillis();
        d.b.c0.k.b.b.j().g(bundle, new C0567a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.b.c0.p.c cVar = new d.b.c0.p.c(inflate, -1, -1, true);
        this.f42638d = cVar;
        cVar.y(false);
        this.f42638d.C(false);
        this.f42638d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f42638d.h(new e(this, mVar));
        this.f42638d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.b.c0.k.k.a.c(this.f42636b);
        try {
            if (this.f42635a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f42635a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.b.c0.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.b.c0.n.d.f42680d) {
                e2.printStackTrace();
            }
        } finally {
            this.f42635a = 0L;
        }
    }
}
