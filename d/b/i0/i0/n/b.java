package d.b.i0.i0.n;

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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55828a;

    /* renamed from: b  reason: collision with root package name */
    public View f55829b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f55830c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f55831d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55832e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55833f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55834g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55835h;
    public int i;
    public int j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.i0.b.a(b.this.f55828a, null);
            StatisticItem statisticItem = new StatisticItem("c13645");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", b.this.k ? 5 : 1);
            statisticItem.param("obj_source", b.this.k ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f55828a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.forum_square_item_view, (ViewGroup) null);
        this.f55829b = inflate;
        this.f55830c = (RoundRelativeLayout) inflate.findViewById(R.id.square_background);
        this.f55831d = (ImageView) this.f55829b.findViewById(R.id.square_left_img);
        this.f55832e = (ImageView) this.f55829b.findViewById(R.id.square_right_img);
        this.f55834g = (TextView) this.f55829b.findViewById(R.id.square_title);
        this.f55835h = (TextView) this.f55829b.findViewById(R.id.square_desc);
        this.f55833f = (ImageView) this.f55829b.findViewById(R.id.iv_right_arrow);
        this.f55834g.setText(R.string.forum_square_title);
        this.f55835h.setText(R.string.forum_square_desc);
        this.f55829b.setOnClickListener(new a());
        this.i = l.g(this.f55828a.getPageActivity(), R.dimen.tbds90);
        this.j = l.g(this.f55828a.getPageActivity(), R.dimen.tbds58);
        RoundRelativeLayout roundRelativeLayout = this.f55830c;
        int i = this.i;
        roundRelativeLayout.setRoundLayoutRadius(new float[]{i, i, i, i, i, i, i, i});
    }

    public void c(d.b.i0.i0.d.a aVar) {
        if (aVar.B()) {
            if (this.f55830c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f55830c.getLayoutParams();
                int i = marginLayoutParams.bottomMargin;
                int i2 = this.j;
                if (i != i2) {
                    marginLayoutParams.bottomMargin = i2;
                    this.f55830c.requestLayout();
                }
            }
        } else if (this.f55830c.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f55830c.getLayoutParams();
            if (marginLayoutParams2.bottomMargin != 0) {
                marginLayoutParams2.bottomMargin = 0;
                this.f55830c.requestLayout();
            }
        }
        SkinManager.setBackgroundColor(this.f55830c, R.color.CAM_X0206);
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f55831d, R.drawable.ic_pic_mask_square, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setImageResource(this.f55832e, R.drawable.pic_mask_square_circle);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55833f, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setViewTextColor(this.f55834g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55835h, R.color.CAM_X0108);
    }

    public View d() {
        return this.f55829b;
    }

    public void e(boolean z) {
        this.k = z;
    }
}
