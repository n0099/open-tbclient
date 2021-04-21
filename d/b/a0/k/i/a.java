package d.b.a0.k.i;

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
import d.b.a0.f;
import d.b.a0.g;
import d.b.a0.h;
import d.b.a0.p.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f42004e;

    /* renamed from: a  reason: collision with root package name */
    public long f42005a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f42006b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.a0.p.c f42007c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.a0.p.c f42008d;

    /* renamed from: d.b.a0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0556a extends d.b.a0.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42009a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42010b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f42011c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f42012d;

        public C0556a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f42009a = mVar;
            this.f42010b = z;
            this.f42011c = context;
            this.f42012d = bundle;
        }

        @Override // d.b.a0.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f42009a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f42009a.g(0, d.b.a0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f42010b) {
                a.this.c(this.f42011c, this.f42012d, this.f42009a);
            } else {
                a.this.e(this.f42011c, this.f42009a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f42014e;

        public b(m mVar) {
            this.f42014e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f42007c.q();
            d.b.a0.k.h.b bVar = new d.b.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("1");
            d.b.a0.k.h.d.b(bVar);
            this.f42014e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42016e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f42017f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f42018g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f42016e = context;
            this.f42017f = bundle;
            this.f42018g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f42007c.q();
            d.b.a0.k.h.b bVar = new d.b.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("2");
            d.b.a0.k.h.d.b(bVar);
            a.this.d(this.f42016e, this.f42017f, this.f42018g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f42008d == null || !a.this.f42008d.u()) {
                return;
            }
            a.this.f42008d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42021a;

        public e(a aVar, m mVar) {
            this.f42021a = mVar;
        }

        @Override // d.b.a0.p.c.b
        public void onDismiss() {
            this.f42021a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f42004e == null) {
            synchronized (a.class) {
                if (f42004e == null) {
                    f42004e = new a();
                }
            }
        }
        return f42004e;
    }

    public final View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    public final void c(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.pay_confirm, null);
        d.b.a0.p.c cVar = new d.b.a0.p.c(inflate, -1, -1, true);
        this.f42007c = cVar;
        cVar.y(false);
        this.f42007c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f42007c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.b.a0.k.h.d.b(new d.b.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f42006b = d.b.a0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f42005a = System.currentTimeMillis();
        d.b.a0.k.b.b.j().g(bundle, new C0556a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.b.a0.p.c cVar = new d.b.a0.p.c(inflate, -1, -1, true);
        this.f42008d = cVar;
        cVar.y(false);
        this.f42008d.C(false);
        this.f42008d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f42008d.h(new e(this, mVar));
        this.f42008d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.b.a0.k.k.a.c(this.f42006b);
        try {
            if (this.f42005a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f42005a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.b.a0.k.h.b bVar = new d.b.a0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.b.a0.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.b.a0.n.d.f42050d) {
                e2.printStackTrace();
            }
        } finally {
            this.f42005a = 0L;
        }
    }
}
