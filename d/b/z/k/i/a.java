package d.b.z.k.i;

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
import d.b.z.f;
import d.b.z.g;
import d.b.z.h;
import d.b.z.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f65702e;

    /* renamed from: a  reason: collision with root package name */
    public long f65703a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f65704b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.z.p.c f65705c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.z.p.c f65706d;

    /* renamed from: d.b.z.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1804a extends d.b.z.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f65707a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f65708b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f65709c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f65710d;

        public C1804a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f65707a = mVar;
            this.f65708b = z;
            this.f65709c = context;
            this.f65710d = bundle;
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f65707a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.z.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f65707a.g(0, d.b.z.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f65708b) {
                a.this.c(this.f65709c, this.f65710d, this.f65707a);
            } else {
                a.this.e(this.f65709c, this.f65707a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f65712e;

        public b(m mVar) {
            this.f65712e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f65705c.q();
            d.b.z.k.h.b bVar = new d.b.z.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("1");
            d.b.z.k.h.d.b(bVar);
            this.f65712e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f65714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f65715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f65716g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f65714e = context;
            this.f65715f = bundle;
            this.f65716g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f65705c.q();
            d.b.z.k.h.b bVar = new d.b.z.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("2");
            d.b.z.k.h.d.b(bVar);
            a.this.d(this.f65714e, this.f65715f, this.f65716g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f65706d == null || !a.this.f65706d.u()) {
                return;
            }
            a.this.f65706d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f65719a;

        public e(a aVar, m mVar) {
            this.f65719a = mVar;
        }

        @Override // d.b.z.p.c.b
        public void onDismiss() {
            this.f65719a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f65702e == null) {
            synchronized (a.class) {
                if (f65702e == null) {
                    f65702e = new a();
                }
            }
        }
        return f65702e;
    }

    public final View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
        d.b.z.p.c cVar = new d.b.z.p.c(inflate, -1, -1, true);
        this.f65705c = cVar;
        cVar.y(false);
        this.f65705c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f65705c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.b.z.k.h.d.b(new d.b.z.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f65704b = d.b.z.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f65703a = System.currentTimeMillis();
        d.b.z.k.b.b.j().g(bundle, new C1804a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.b.z.p.c cVar = new d.b.z.p.c(inflate, -1, -1, true);
        this.f65706d = cVar;
        cVar.y(false);
        this.f65706d.C(false);
        this.f65706d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f65706d.h(new e(this, mVar));
        this.f65706d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.b.z.k.k.a.c(this.f65704b);
        try {
            if (this.f65703a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f65703a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.b.z.k.h.b bVar = new d.b.z.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.b.z.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.b.z.n.d.f65748d) {
                e2.printStackTrace();
            }
        } finally {
            this.f65703a = 0L;
        }
    }
}
