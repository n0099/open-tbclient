package d.a.k0.i0.l.e;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.view.HotUserRankImageOverlayView;
import com.baidu.tieba.view.RoundRelativeLayout;
import d.a.c.e.p.l;
import d.a.k0.i0.l.d.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f55918a = 3;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f55919b;

    /* renamed from: c  reason: collision with root package name */
    public View f55920c;

    /* renamed from: d  reason: collision with root package name */
    public RoundRelativeLayout f55921d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55922e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55923f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f55924g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55925h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55926i;
    public TextView j;
    public ImageView k;
    public HotUserRankImageOverlayView l;
    public ImageView m;
    public int n;
    public String o;
    public String p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.f55919b.getPageActivity());
            hotUserRankActivityConfig.setCategory(b.this.o);
            b.this.f55919b.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13655");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, b.this.p);
            TiebaStatic.log(statisticItem);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f55919b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.f55920c = inflate;
        this.f55921d = (RoundRelativeLayout) inflate.findViewById(R.id.view_container);
        this.f55922e = (ImageView) this.f55920c.findViewById(R.id.ic_red_background);
        this.f55923f = (ImageView) this.f55920c.findViewById(R.id.ic_red_pic);
        this.f55924g = (TbImageView) this.f55920c.findViewById(R.id.rank_icon);
        this.f55925h = (ImageView) this.f55920c.findViewById(R.id.rank_icon_default);
        this.f55926i = (TextView) this.f55920c.findViewById(R.id.forum_text);
        this.j = (TextView) this.f55920c.findViewById(R.id.no_1_user);
        this.l = (HotUserRankImageOverlayView) this.f55920c.findViewById(R.id.image_overlay_view);
        this.k = (ImageView) this.f55920c.findViewById(R.id.iv_crown);
        this.m = (ImageView) this.f55920c.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.l.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.l.setStrokeStyle(1);
        this.l.setLoadImageType(12);
        this.l.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.f55921d.setOnClickListener(new a());
        int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.n = g2;
        this.f55921d.setRoundLayoutRadius(new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
    }

    public View d() {
        return this.f55920c;
    }

    public void e() {
        if (this.f55918a != TbadkCoreApplication.getInst().getSkinType()) {
            this.f55918a = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f55921d, R.color.CAM_X0206);
            if (this.f55925h.getVisibility() == 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f55925h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f55922e, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.f55923f, R.drawable.pic_list_redword);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f55926i, R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mask_first24, null);
            this.l.d();
        }
    }

    public void f(c cVar) {
        if (cVar == null) {
            return;
        }
        String str = cVar.f55899b;
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.o = "";
        }
        TextView textView = this.f55926i;
        textView.setText(this.o + "榜");
        List<ShortUserInfo> list = cVar.f55898a;
        if (list != null && list.size() > 0) {
            TextView textView2 = this.j;
            textView2.setText("NO.1 " + cVar.f55898a.get(0).user_name);
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (ShortUserInfo shortUserInfo : cVar.f55898a) {
                if (i2 > 2) {
                    break;
                }
                i2++;
                arrayList.add(shortUserInfo.portrait);
            }
            this.l.setData(arrayList);
            if (!TextUtils.isEmpty(cVar.f55900c)) {
                this.f55924g.setVisibility(0);
                this.f55925h.setVisibility(8);
                this.f55924g.V(cVar.f55900c, 12, false);
            } else {
                this.f55925h.setVisibility(0);
                this.f55924g.setVisibility(8);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f55925h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
        e();
    }

    public void g(String str) {
        this.p = str;
    }
}
