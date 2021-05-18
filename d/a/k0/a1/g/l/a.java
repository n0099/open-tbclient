package d.a.k0.a1.g.l;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a extends d.a.k0.x.b<d.a.k0.a1.g.l.b> {
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public final TbPageContext<?> m;
    public View n;
    public TextView o;
    public int p;
    public String q;
    public d.a.k0.a1.g.l.b r;

    /* renamed from: d.a.k0.a1.g.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1190a implements View.OnClickListener {
        public View$OnClickListenerC1190a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.h() == null) {
                return;
            }
            a.this.h().a(view, a.this.r);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f51673e;

        public b(ViewGroup.LayoutParams layoutParams) {
            this.f51673e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.o.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f51673e.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.u - a.v)) + a.v);
            a.this.n.setLayoutParams(this.f51673e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.z();
        }
    }

    static {
        UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
        s = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        t = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        u = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds105);
        v = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
    }

    public a(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.p = 3;
        this.m = tbPageContext;
        View l = l();
        this.n = l;
        TextView textView = (TextView) l.findViewById(R.id.read_progress_bar_time);
        this.o = textView;
        int i2 = t;
        textView.setPadding(0, i2, 0, i2 - s);
        this.q = this.m.getResources().getString(R.string.home_read_here);
        this.n.setOnClickListener(new View$OnClickListenerC1190a());
    }

    @Override // d.a.k0.x.b
    public int g() {
        return R.layout.card_read_progress_bar;
    }

    @Override // d.a.k0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.p != i2) {
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0304);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            this.o.setCompoundDrawables(pureDrawable, null, null, null);
        }
        this.p = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.x.b
    /* renamed from: y */
    public void m(d.a.k0.a1.g.l.b bVar) {
        if (bVar == null || this.n.getLayoutParams() == null) {
            return;
        }
        if (!bVar.f51678f) {
            this.n.getLayoutParams().height = v;
            this.n.requestLayout();
            this.o.setAlpha(0.0f);
        }
        if (this.n.getLayoutParams().height != u) {
            bVar.f51678f = true;
            e.a().postDelayed(new c(), 1600L);
        }
        String formatTimeShort = StringHelper.getFormatTimeShort(bVar.f51677e);
        TextView textView = this.o;
        textView.setText(formatTimeShort + this.q);
        n(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void z() {
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        if (layoutParams == null || layoutParams.height == u) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(layoutParams));
        ofFloat.setDuration(400L);
        ofFloat.start();
    }
}
