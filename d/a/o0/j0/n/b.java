package d.a.o0.j0.n;

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
    public TbPageContext<?> f60016a;

    /* renamed from: b  reason: collision with root package name */
    public View f60017b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f60018c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60019d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60020e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60021f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60022g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60023h;

    /* renamed from: i  reason: collision with root package name */
    public int f60024i;
    public int j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.j0.b.a(b.this.f60016a, null);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", b.this.k ? 5 : 1);
            statisticItem.param("obj_source", b.this.k ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f60016a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.f60017b = inflate;
        this.f60018c = (RoundRelativeLayout) inflate.findViewById(R.id.square_background);
        this.f60019d = (ImageView) this.f60017b.findViewById(R.id.square_left_img);
        this.f60020e = (ImageView) this.f60017b.findViewById(R.id.square_right_img);
        this.f60022g = (TextView) this.f60017b.findViewById(R.id.square_title);
        this.f60023h = (TextView) this.f60017b.findViewById(R.id.square_desc);
        this.f60021f = (ImageView) this.f60017b.findViewById(R.id.iv_right_arrow);
        this.f60022g.setText(R.string.forum_square_title);
        this.f60023h.setText(R.string.forum_square_desc);
        this.f60017b.setOnClickListener(new a());
        this.f60024i = l.g(this.f60016a.getPageActivity(), R.dimen.tbds90);
        this.j = l.g(this.f60016a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.f60018c;
        int i2 = this.f60024i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i2, i2, i2, i2, i2, i2, i2, i2});
    }

    public void c(d.a.o0.j0.d.a aVar) {
        if (aVar.B()) {
            if (this.f60018c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f60018c.getLayoutParams();
                int i2 = marginLayoutParams.bottomMargin;
                int i3 = this.j;
                if (i2 != i3) {
                    marginLayoutParams.bottomMargin = i3;
                    this.f60018c.requestLayout();
                }
            }
        } else if (this.f60018c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f60018c.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.f60018c.requestLayout();
            }
        }
        SkinManager.setBackgroundColor(this.f60018c, R.color.CAM_X0206);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f60019d, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setImageResource(this.f60020e, R.drawable.pic_mask_square_circle);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60021f, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f60022g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60023h, R.color.CAM_X0108);
    }

    public View d() {
        return this.f60017b;
    }

    public void e(boolean z) {
        this.k = z;
    }
}
