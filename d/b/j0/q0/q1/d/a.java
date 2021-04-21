package d.b.j0.q0.q1.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.r.u.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f60445a;

    /* renamed from: b  reason: collision with root package name */
    public View f60446b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f60447c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f60448d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f60449e;

    /* renamed from: f  reason: collision with root package name */
    public final int f60450f = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);

    public a(Context context) {
        this.f60445a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        if (bdTypeRecyclerView == null || (relativeLayout = this.f60447c) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        bdTypeRecyclerView.s(this.f60447c);
    }

    public final void b(Context context) {
        if (this.f60446b != null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_unaudited, (ViewGroup) null);
        this.f60446b = inflate;
        this.f60447c = (RelativeLayout) inflate.findViewById(R.id.unaudited);
        this.f60448d = (EMTextView) this.f60446b.findViewById(R.id.unaudited_title);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.forum_rules_unaudited_alert));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.a(l.g(context, R.dimen.tbds0));
        eMRichTextAnyIconSpan.c(l.g(context, R.dimen.M_W_X002));
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.f60448d.setText(spannableStringBuilder);
        this.f60449e = (EMTextView) this.f60446b.findViewById(R.id.unaudited_content);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i) {
        DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.f60450f);
        int i2 = R.color.CAM_X0212;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i2, i2).build(), DrawableSelector.make().setShape(0).radius(this.f60450f).defaultColor("#4D000000").build()});
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(255);
            }
        } else if (layerDrawable.getDrawable(1) != null) {
            layerDrawable.getDrawable(1).setAlpha(0);
        }
        this.f60447c.setBackgroundDrawable(layerDrawable);
        c.d(this.f60448d).q(R.color.CAM_X0109);
        c.d(this.f60449e).q(R.color.CAM_X0109);
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        if (bdTypeRecyclerView == null || (relativeLayout = this.f60447c) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f60447c);
    }

    public void e(String str) {
        EMTextView eMTextView = this.f60449e;
        if (eMTextView != null) {
            eMTextView.setText(str);
        }
    }
}
