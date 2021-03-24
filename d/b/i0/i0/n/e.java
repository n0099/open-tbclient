package d.b.i0.i0.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.h0.r.q.p1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55851a;

    /* renamed from: b  reason: collision with root package name */
    public View f55852b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55853c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f55854d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55855e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.i0.b.a(e.this.f55851a, null);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", e.this.f55855e ? 5 : 1);
            statisticItem.param("obj_source", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f55851a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.f55852b = inflate;
        this.f55853c = (TextView) inflate.findViewById(R.id.text_title);
        ImageView imageView = (ImageView) this.f55852b.findViewById(R.id.icon_into);
        this.f55854d = imageView;
        imageView.setOnClickListener(new a());
    }

    public void c(p1 p1Var) {
        String B = p1Var.B();
        if (!TextUtils.isEmpty(B)) {
            this.f55853c.setText(B);
        }
        SkinManager.setViewTextColor(this.f55853c, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55854d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View d() {
        return this.f55852b;
    }

    public void e(boolean z) {
        this.f55855e = z;
    }
}
