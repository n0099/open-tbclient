package d.a.o0.j0.n;

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
import d.a.n0.r.q.p1;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60040a;

    /* renamed from: b  reason: collision with root package name */
    public View f60041b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60042c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60043d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60044e;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.j0.b.a(e.this.f60040a, null);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", e.this.f60044e ? 5 : 1);
            statisticItem.param("obj_source", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        this.f60040a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.f60041b = inflate;
        this.f60042c = (TextView) inflate.findViewById(R.id.text_title);
        ImageView imageView = (ImageView) this.f60041b.findViewById(R.id.icon_into);
        this.f60043d = imageView;
        imageView.setOnClickListener(new a());
    }

    public void c(p1 p1Var) {
        String B = p1Var.B();
        if (!TextUtils.isEmpty(B)) {
            this.f60042c.setText(B);
        }
        SkinManager.setViewTextColor(this.f60042c, R.color.CAM_X0105);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60043d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public View d() {
        return this.f60041b;
    }

    public void e(boolean z) {
        this.f60044e = z;
    }
}
