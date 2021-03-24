package d.b.i0.p0.q1.d;

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
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f58361a;

    /* renamed from: b  reason: collision with root package name */
    public View f58362b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f58363c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f58364d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f58365e;

    /* renamed from: f  reason: collision with root package name */
    public final int f58366f = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);

    public a(Context context) {
        this.f58361a = context;
        b(context);
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        if (bdTypeRecyclerView == null || (relativeLayout = this.f58363c) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
        bdTypeRecyclerView.s(this.f58363c);
    }

    public final void b(Context context) {
        if (this.f58362b != null) {
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.forum_rules_unaudited, (ViewGroup) null);
        this.f58362b = inflate;
        this.f58363c = (RelativeLayout) inflate.findViewById(R.id.unaudited);
        this.f58364d = (EMTextView) this.f58362b.findViewById(R.id.unaudited_title);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(context.getResources().getString(R.string.forum_rules_unaudited_alert));
        EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_pure_barrules_careful12, R.color.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
        eMRichTextAnyIconSpan.a(l.g(context, R.dimen.tbds0));
        eMRichTextAnyIconSpan.c(l.g(context, R.dimen.M_W_X002));
        spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
        this.f58364d.setText(spannableStringBuilder);
        this.f58365e = (EMTextView) this.f58362b.findViewById(R.id.unaudited_content);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public void c(int i) {
        DrawableSelector radius = DrawableSelector.make().setShape(0).radius(this.f58366f);
        int i2 = R.color.CAM_X0212;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{radius.gradientLinear(DrawableSelector.TL_BR, i2, i2).build(), DrawableSelector.make().setShape(0).radius(this.f58366f).defaultColor("#4D000000").build()});
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(255);
            }
        } else if (layerDrawable.getDrawable(1) != null) {
            layerDrawable.getDrawable(1).setAlpha(0);
        }
        this.f58363c.setBackgroundDrawable(layerDrawable);
        c.a(this.f58364d).n(R.color.CAM_X0109);
        c.a(this.f58365e).n(R.color.CAM_X0109);
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        RelativeLayout relativeLayout;
        if (bdTypeRecyclerView == null || (relativeLayout = this.f58363c) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
        bdTypeRecyclerView.removeHeaderView(this.f58363c);
    }

    public void e(String str) {
        EMTextView eMTextView = this.f58365e;
        if (eMTextView != null) {
            eMTextView.setText(str);
        }
    }
}
