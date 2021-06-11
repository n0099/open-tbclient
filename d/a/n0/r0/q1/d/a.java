package d.a.n0.r0.q1.d;

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
import d.a.c.e.p.l;
import d.a.m0.r.u.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f63114a;

    /* renamed from: b  reason: collision with root package name */
    public View f63115b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f63116c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f63117d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f63118e;

    /* renamed from: f  reason: collision with root package name */
    public final int f63119f = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);

    public a(Context context) {
        this.f63114a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        if (bdTypeRecyclerView == null || (relativeLayout = this.f63116c) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        bdTypeRecyclerView.s(this.f63116c);
    }

    public final void b(Context context) {
        if (this.f63115b != null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_unaudited, (ViewGroup) null);
        this.f63115b = inflate;
        this.f63116c = (RelativeLayout) inflate.findViewById(R.id.unaudited);
        this.f63117d = (EMTextView) this.f63115b.findViewById(R.id.unaudited_title);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.forum_rules_unaudited_alert));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.a(l.g(context, R.dimen.tbds0));
        eMRichTextAnyIconSpan.c(l.g(context, R.dimen.M_W_X002));
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.f63117d.setText(spannableStringBuilder);
        this.f63118e = (EMTextView) this.f63115b.findViewById(R.id.unaudited_content);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i2) {
        DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.f63119f);
        int i3 = R.color.CAM_X0212;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i3, i3).build(), DrawableSelector.make().setShape(0).radius(this.f63119f).defaultColor("#4D000000").build()});
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(255);
            }
        } else if (layerDrawable.getDrawable(1) != null) {
            layerDrawable.getDrawable(1).setAlpha(0);
        }
        this.f63116c.setBackgroundDrawable(layerDrawable);
        c.d(this.f63117d).s(R.color.CAM_X0109);
        c.d(this.f63118e).s(R.color.CAM_X0109);
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        if (bdTypeRecyclerView == null || (relativeLayout = this.f63116c) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f63116c);
    }

    public void e(String str) {
        EMTextView eMTextView = this.f63118e;
        if (eMTextView != null) {
            eMTextView.setText(str);
        }
    }
}
