package d.a.j0.i0.n;

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
import com.baidu.tieba.view.RoundRelativeLayout;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55311a;

    /* renamed from: b  reason: collision with root package name */
    public View f55312b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f55313c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f55314d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55315e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55316f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55317g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55318h;

    /* renamed from: i  reason: collision with root package name */
    public int f55319i;
    public int j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.i0.b.a(b.this.f55311a, null);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", b.this.k ? 5 : 1);
            statisticItem.param("obj_source", b.this.k ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f55311a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.f55312b = inflate;
        this.f55313c = (RoundRelativeLayout) inflate.findViewById(R.id.square_background);
        this.f55314d = (ImageView) this.f55312b.findViewById(R.id.square_left_img);
        this.f55315e = (ImageView) this.f55312b.findViewById(R.id.square_right_img);
        this.f55317g = (TextView) this.f55312b.findViewById(R.id.square_title);
        this.f55318h = (TextView) this.f55312b.findViewById(R.id.square_desc);
        this.f55316f = (ImageView) this.f55312b.findViewById(R.id.iv_right_arrow);
        this.f55317g.setText(R.string.forum_square_title);
        this.f55318h.setText(R.string.forum_square_desc);
        this.f55312b.setOnClickListener(new a());
        this.f55319i = l.g(this.f55311a.getPageActivity(), R.dimen.tbds90);
        this.j = l.g(this.f55311a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.f55313c;
        int i2 = this.f55319i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i2, i2, i2, i2, i2, i2, i2, i2});
    }

    public void c(d.a.j0.i0.d.a aVar) {
        if (aVar.B()) {
            if (this.f55313c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55313c.getLayoutParams();
                int i2 = marginLayoutParams.bottomMargin;
                int i3 = this.j;
                if (i2 != i3) {
                    marginLayoutParams.bottomMargin = i3;
                    this.f55313c.requestLayout();
                }
            }
        } else if (this.f55313c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f55313c.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.f55313c.requestLayout();
            }
        }
        SkinManager.setBackgroundColor(this.f55313c, R.color.CAM_X0206);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f55314d, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setImageResource(this.f55315e, R.drawable.pic_mask_square_circle);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55316f, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f55317g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55318h, R.color.CAM_X0108);
    }

    public View d() {
        return this.f55312b;
    }

    public void e(boolean z) {
        this.k = z;
    }
}
