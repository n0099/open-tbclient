package d.b.h0.r.s;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class i implements View.OnClickListener {
    public static final int r = R.drawable.shape_new_complete_toast_bg;

    /* renamed from: e  reason: collision with root package name */
    public Context f51418e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f51419f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51420g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51421h;
    public TbImageView i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n = 1.0f;
    public int o = 3000;
    public Runnable p;
    public d.b.h0.a.b0.a q;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f();
        }
    }

    public i(Context context) {
        if (context == null) {
            return;
        }
        this.f51418e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f51419f = viewGroup;
        this.f51420g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f51419f.findViewById(R.id.toast_btn);
        this.f51421h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f51419f.findViewById(R.id.toast_bg);
        this.i = tbImageView;
        tbImageView.setDefaultBgResource(r);
        this.i.setDrawCorner(true);
        this.i.setConrers(15);
        this.i.setRadius(d.b.c.e.p.l.g(context, R.dimen.tbds20));
        this.m = d.b.c.e.p.l.g(context, R.dimen.tbds176);
        this.l = d.b.c.e.p.l.g(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f51419f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.j = (WindowManager) this.f51418e.getSystemService("window");
        h();
        this.p = new a();
    }

    public static i i(Context context, d.b.h0.a.b0.a aVar) {
        i iVar = new i(context);
        iVar.a(aVar);
        return iVar;
    }

    public final i a(d.b.h0.a.b0.a aVar) {
        if (this.f51418e == null) {
            return this;
        }
        if (aVar == null) {
            c();
            return this;
        }
        this.q = aVar;
        if (d.b.c.e.p.k.isEmpty(aVar.f49907e)) {
            this.f51420g.setText(this.f51418e.getResources().getString(R.string.task_already_finish));
        } else {
            this.f51420g.setText(aVar.f49907e);
        }
        if (d.b.c.e.p.k.isEmpty(aVar.f49908f)) {
            this.f51421h.setText(this.f51418e.getResources().getString(R.string.back));
        } else {
            this.f51421h.setText(aVar.f49908f);
        }
        if (d.b.c.e.p.k.isEmpty(aVar.p)) {
            SkinManager.setViewTextColor(this.f51420g, R.color.CAM_X0302, 1);
        } else {
            this.f51420g.setTextColor(d.b.i0.j1.o.k.b.b(aVar.p));
        }
        if (d.b.c.e.p.k.isEmpty(aVar.q)) {
            SkinManager.setViewTextColor(this.f51421h, R.color.CAM_X0101, 1);
        } else {
            this.f51421h.setTextColor(d.b.i0.j1.o.k.b.b(aVar.q));
        }
        if (!d.b.c.e.p.k.isEmpty(aVar.o)) {
            this.f51421h.setBackgroundDrawable(b(aVar.o));
        }
        if (!d.b.c.e.p.k.isEmpty(aVar.j)) {
            this.i.W(aVar.j, 10, false);
        }
        int i = aVar.i;
        if (i > 3) {
            this.o = i * 1000;
        }
        this.n = (float) aVar.n;
        j();
        return this;
    }

    public final StateListDrawable b(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f51418e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(d.b.c.e.p.l.g(this.f51418e, R.dimen.tbds10));
        gradientDrawable.setColor(d.b.i0.j1.o.k.b.b(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public final i c() {
        this.f51420g.setText(this.f51418e.getResources().getString(R.string.task_already_finish));
        this.f51421h.setText(this.f51418e.getResources().getString(R.string.back));
        SkinManager.setViewTextColor(this.f51420g, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f51421h, R.color.CAM_X0101, 1);
        j();
        return this;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        if (d.b.c.e.p.k.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(e2, new String[]{str});
    }

    public final TbPageContext e(Activity activity) {
        if (activity instanceof BaseActivity) {
            return ((BaseActivity) activity).getPageContext();
        }
        if (activity instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) activity).getPageContext();
        }
        return null;
    }

    public void f() {
        if (this.f51418e != null) {
            if (this.f51419f.getWindowToken() != null) {
                this.j.removeView(this.f51419f);
            }
            d.b.c.e.m.e.a().removeCallbacks(this.p);
        }
        this.f51418e = null;
    }

    public final void h() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = d.b.c.e.p.l.k(this.f51418e) - (this.l * 2);
        this.k.height = d.b.c.e.p.l.g(this.f51418e, R.dimen.tbds196);
        WindowManager.LayoutParams layoutParams2 = this.k;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.new_complete_task_toast;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
    }

    public final void j() {
        WindowManager.LayoutParams layoutParams = this.k;
        layoutParams.y = this.m;
        layoutParams.alpha = this.n;
    }

    public i k() {
        if (this.f51418e != null) {
            this.j.addView(this.f51419f, this.k);
            d.b.c.e.m.e.a().removeCallbacks(this.p);
            d.b.c.e.m.e.a().postDelayed(this.p, this.o);
            if (this.q != null) {
                TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.f49903a).param("obj_type", this.q.f49904b));
            }
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.h0.a.b0.a aVar = this.q;
        if (aVar == null) {
            return;
        }
        int i = aVar.f49906d;
        if (i == d.b.h0.a.b0.a.H) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !d.b.c.e.p.k.isEmpty(this.q.k)) {
                d(this.q.k);
            }
        } else if (i == d.b.h0.a.b0.a.I && !d.b.c.e.p.k.isEmpty(aVar.k)) {
            d(this.q.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.f49903a).param("obj_type", this.q.f49904b));
    }
}
