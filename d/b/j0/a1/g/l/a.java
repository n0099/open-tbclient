package d.b.j0.a1.g.l;

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
import d.b.c.e.m.e;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class a extends d.b.j0.x.b<d.b.j0.a1.g.l.b> {
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public final TbPageContext<?> m;
    public View n;
    public TextView o;
    public int p;
    public String q;
    public d.b.j0.a1.g.l.b r;

    /* renamed from: d.b.j0.a1.g.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1179a implements View.OnClickListener {
        public View$OnClickListenerC1179a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.i() == null) {
                return;
            }
            a.this.i().a(view, a.this.r);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f53256e;

        public b(ViewGroup.LayoutParams layoutParams) {
            this.f53256e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.o.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f53256e.height = (int) ((((Float) valueAnimator.getAnimatedValue()).floatValue() * (a.u - a.v)) + a.v);
            a.this.n.setLayoutParams(this.f53256e);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.B();
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
        View m = m();
        this.n = m;
        TextView textView = (TextView) m.findViewById(R.id.read_progress_bar_time);
        this.o = textView;
        int i = t;
        textView.setPadding(0, i, 0, i - s);
        this.q = this.m.getResources().getString(R.string.home_read_here);
        this.n.setOnClickListener(new View$OnClickListenerC1179a());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: A */
    public void n(d.b.j0.a1.g.l.b bVar) {
        if (bVar == null || this.n.getLayoutParams() == null) {
            return;
        }
        if (!bVar.f53261f) {
            this.n.getLayoutParams().height = v;
            this.n.requestLayout();
            this.o.setAlpha(0.0f);
        }
        if (this.n.getLayoutParams().height != u) {
            bVar.f53261f = true;
            e.a().postDelayed(new c(), 1600L);
        }
        String formatTimeShort = StringHelper.getFormatTimeShort(bVar.f53260e);
        TextView textView = this.o;
        textView.setText(formatTimeShort + this.q);
        o(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void B() {
        ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
        if (layoutParams == null || layoutParams.height == u) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(layoutParams));
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.card_read_progress_bar;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.p != i) {
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0304);
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_card_refresh16, SkinManager.getColor(R.color.CAM_X0304), WebPManager.ResourceStateType.NORMAL);
            pureDrawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds42), UtilHelper.getDimenPixelSize(R.dimen.tbds42));
            this.o.setCompoundDrawables(pureDrawable, null, null, null);
        }
        this.p = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
