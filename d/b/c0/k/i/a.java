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
    public static volatile a f42633e;

    /* renamed from: a  reason: collision with root package name */
    public long f42634a;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.poly.a.l.c f42635b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c0.p.c f42636c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c0.p.c f42637d;

    /* renamed from: d.b.c0.k.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0566a extends d.b.c0.k.a.a<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f42639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f42640c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f42641d;

        public C0566a(m mVar, boolean z, Context context, Bundle bundle) {
            this.f42638a = mVar;
            this.f42639b = z;
            this.f42640c = context;
            this.f42641d = bundle;
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            a.this.j("2", str);
            m mVar = this.f42638a;
            mVar.m("get trade state failed : " + str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c0.k.a.a
        /* renamed from: c */
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.j("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.f42638a.g(0, d.b.c0.n.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.f42639b) {
                a.this.c(this.f42640c, this.f42641d, this.f42638a);
            } else {
                a.this.e(this.f42640c, this.f42638a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f42643e;

        public b(m mVar) {
            this.f42643e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f42636c.q();
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("1");
            d.b.c0.k.h.d.b(bVar);
            this.f42643e.g(3, "pay failed , click choose window");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f42645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f42646f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f42647g;

        public c(Context context, Bundle bundle, m mVar) {
            this.f42645e = context;
            this.f42646f = bundle;
            this.f42647g = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f42636c.q();
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            bVar.c("2");
            d.b.c0.k.h.d.b(bVar);
            a.this.d(this.f42645e, this.f42646f, this.f42647g, false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f42637d == null || !a.this.f42637d.u()) {
                return;
            }
            a.this.f42637d.q();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f42650a;

        public e(a aVar, m mVar) {
            this.f42650a = mVar;
        }

        @Override // d.b.c0.p.c.b
        public void onDismiss() {
            this.f42650a.g(3, "pay failed , click error window");
        }
    }

    public static a k() {
        if (f42633e == null) {
            synchronized (a.class) {
                if (f42633e == null) {
                    f42633e = new a();
                }
            }
        }
        return f42633e;
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
        this.f42636c = cVar;
        cVar.y(false);
        this.f42636c.C(false);
        ((TextView) inflate.findViewById(f.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(f.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.f42636c.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        d.b.c0.k.h.d.b(new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    public void d(Context context, Bundle bundle, m mVar, boolean z) {
        if (context == null || bundle == null || mVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f42635b = d.b.c0.k.k.a.a((ViewGroup) a((Activity) context), layoutParams, null, -1L);
        this.f42634a = System.currentTimeMillis();
        d.b.c0.k.b.b.j().g(bundle, new C0566a(mVar, z, context, bundle));
    }

    public final void e(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), g.default_pop_window, null);
        ((TextView) inflate.findViewById(f.pop_title)).setText(h.pay_failed);
        ((TextView) inflate.findViewById(f.pop_tips)).setText(h.pay_failed_sub_text);
        d.b.c0.p.c cVar = new d.b.c0.p.c(inflate, -1, -1, true);
        this.f42637d = cVar;
        cVar.y(false);
        this.f42637d.C(false);
        this.f42637d.x(new ColorDrawable(0));
        ((TextView) inflate.findViewById(f.pop_button)).setOnClickListener(new d());
        this.f42637d.h(new e(this, mVar));
        this.f42637d.E(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }

    public final void j(String str, String str2) {
        d.b.c0.k.k.a.c(this.f42635b);
        try {
            if (this.f42634a == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("rt", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("msg", str2);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - this.f42634a);
            if (valueOf.longValue() >= 0) {
                jSONObject.put("du", String.valueOf(valueOf));
            }
            d.b.c0.k.h.b bVar = new d.b.c0.k.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN);
            bVar.b(jSONObject);
            d.b.c0.k.h.d.b(bVar);
        } catch (JSONException e2) {
            if (d.b.c0.n.d.f42679d) {
                e2.printStackTrace();
            }
        } finally {
            this.f42634a = 0L;
        }
    }
}
