package d.a.n0.r.s;

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
    public Context f54044e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f54045f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54046g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54047h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f54048i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n = 1.0f;
    public int o = 3000;
    public Runnable p;
    public d.a.n0.a.e0.a q;

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
        this.f54044e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f54045f = viewGroup;
        this.f54046g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f54045f.findViewById(R.id.toast_btn);
        this.f54047h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f54045f.findViewById(R.id.toast_bg);
        this.f54048i = tbImageView;
        tbImageView.setDefaultBgResource(r);
        this.f54048i.setDrawCorner(true);
        this.f54048i.setConrers(15);
        this.f54048i.setRadius(d.a.c.e.p.l.g(context, R.dimen.tbds20));
        this.m = d.a.c.e.p.l.g(context, R.dimen.tbds176);
        this.l = d.a.c.e.p.l.g(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f54045f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.j = (WindowManager) this.f54044e.getSystemService("window");
        h();
        this.p = new a();
    }

    public static i i(Context context, d.a.n0.a.e0.a aVar) {
        i iVar = new i(context);
        iVar.a(aVar);
        return iVar;
    }

    public final i a(d.a.n0.a.e0.a aVar) {
        if (this.f54044e == null) {
            return this;
        }
        if (aVar == null) {
            c();
            return this;
        }
        this.q = aVar;
        if (d.a.c.e.p.k.isEmpty(aVar.f52468e)) {
            this.f54046g.setText(this.f54044e.getResources().getString(R.string.task_already_finish));
        } else {
            this.f54046g.setText(aVar.f52468e);
        }
        if (d.a.c.e.p.k.isEmpty(aVar.f52469f)) {
            this.f54047h.setText(this.f54044e.getResources().getString(R.string.back));
        } else {
            this.f54047h.setText(aVar.f52469f);
        }
        if (d.a.c.e.p.k.isEmpty(aVar.p)) {
            SkinManager.setViewTextColor(this.f54046g, R.color.CAM_X0302, 1);
        } else {
            this.f54046g.setTextColor(d.a.o0.k1.o.k.b.b(aVar.p));
        }
        if (d.a.c.e.p.k.isEmpty(aVar.q)) {
            SkinManager.setViewTextColor(this.f54047h, R.color.CAM_X0101, 1);
        } else {
            this.f54047h.setTextColor(d.a.o0.k1.o.k.b.b(aVar.q));
        }
        if (!d.a.c.e.p.k.isEmpty(aVar.o)) {
            this.f54047h.setBackgroundDrawable(b(aVar.o));
        }
        if (!d.a.c.e.p.k.isEmpty(aVar.j)) {
            this.f54048i.U(aVar.j, 10, false);
        }
        int i2 = aVar.f52472i;
        if (i2 > 3) {
            this.o = i2 * 1000;
        }
        this.n = (float) aVar.n;
        j();
        return this;
    }

    public final StateListDrawable b(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f54044e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(d.a.c.e.p.l.g(this.f54044e, R.dimen.tbds10));
        gradientDrawable.setColor(d.a.o0.k1.o.k.b.b(str));
        stateListDrawable.addState(new int[]{16842919}, drawable);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public final i c() {
        this.f54046g.setText(this.f54044e.getResources().getString(R.string.task_already_finish));
        this.f54047h.setText(this.f54044e.getResources().getString(R.string.back));
        SkinManager.setViewTextColor(this.f54046g, R.color.CAM_X0302, 1);
        SkinManager.setViewTextColor(this.f54047h, R.color.CAM_X0101, 1);
        j();
        return this;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        if (d.a.c.e.p.k.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
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
        if (this.f54044e != null) {
            if (this.f54045f.getWindowToken() != null) {
                this.j.removeView(this.f54045f);
            }
            d.a.c.e.m.e.a().removeCallbacks(this.p);
        }
        this.f54044e = null;
    }

    public final void h() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = d.a.c.e.p.l.k(this.f54044e) - (this.l * 2);
        this.k.height = d.a.c.e.p.l.g(this.f54044e, R.dimen.tbds196);
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
        if (this.f54044e != null) {
            this.j.addView(this.f54045f, this.k);
            d.a.c.e.m.e.a().removeCallbacks(this.p);
            d.a.c.e.m.e.a().postDelayed(this.p, this.o);
            if (this.q != null) {
                TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.f52464a).param("obj_type", this.q.f52465b));
            }
        }
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.n0.a.e0.a aVar = this.q;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f52467d;
        if (i2 == d.a.n0.a.e0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !d.a.c.e.p.k.isEmpty(this.q.k)) {
                d(this.q.k);
            }
        } else if (i2 == d.a.n0.a.e0.a.E && !d.a.c.e.p.k.isEmpty(aVar.k)) {
            d(this.q.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.f52464a).param("obj_type", this.q.f52465b));
    }
}
