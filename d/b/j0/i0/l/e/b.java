package d.b.j0.i0.l.e;

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
import d.b.c.e.p.l;
import d.b.j0.i0.l.d.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f57278a = 3;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f57279b;

    /* renamed from: c  reason: collision with root package name */
    public View f57280c;

    /* renamed from: d  reason: collision with root package name */
    public RoundRelativeLayout f57281d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f57282e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57283f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f57284g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57285h;
    public TextView i;
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
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.f57279b.getPageActivity());
            hotUserRankActivityConfig.setCategory(b.this.o);
            b.this.f57279b.sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13655");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, b.this.p);
            TiebaStatic.log(statisticItem);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f57279b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.f57280c = inflate;
        this.f57281d = (RoundRelativeLayout) inflate.findViewById(R.id.view_container);
        this.f57282e = (ImageView) this.f57280c.findViewById(R.id.ic_red_background);
        this.f57283f = (ImageView) this.f57280c.findViewById(R.id.ic_red_pic);
        this.f57284g = (TbImageView) this.f57280c.findViewById(R.id.rank_icon);
        this.f57285h = (ImageView) this.f57280c.findViewById(R.id.rank_icon_default);
        this.i = (TextView) this.f57280c.findViewById(R.id.forum_text);
        this.j = (TextView) this.f57280c.findViewById(R.id.no_1_user);
        this.l = (HotUserRankImageOverlayView) this.f57280c.findViewById(R.id.image_overlay_view);
        this.k = (ImageView) this.f57280c.findViewById(R.id.iv_crown);
        this.m = (ImageView) this.f57280c.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.l.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.l.setStrokeStyle(1);
        this.l.setLoadImageType(12);
        this.l.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.f57281d.setOnClickListener(new a());
        int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.n = g2;
        this.f57281d.setRoundLayoutRadius(new float[]{g2, g2, g2, g2, g2, g2, g2, g2});
    }

    public View d() {
        return this.f57280c;
    }

    public void e() {
        if (this.f57278a != TbadkCoreApplication.getInst().getSkinType()) {
            this.f57278a = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.f57281d, R.color.CAM_X0206);
            if (this.f57285h.getVisibility() == 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f57285h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f57282e, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setImageResource(this.f57283f, R.drawable.pic_list_redword);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.m, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0311);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0311);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.k, R.drawable.ic_icon_mask_first24, null);
            this.l.d();
        }
    }

    public void f(c cVar) {
        if (cVar == null) {
            return;
        }
        String str = cVar.f57260b;
        this.o = str;
        if (TextUtils.isEmpty(str)) {
            this.o = "";
        }
        TextView textView = this.i;
        textView.setText(this.o + "榜");
        List<ShortUserInfo> list = cVar.f57259a;
        if (list != null && list.size() > 0) {
            TextView textView2 = this.j;
            textView2.setText("NO.1 " + cVar.f57259a.get(0).user_name);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ShortUserInfo shortUserInfo : cVar.f57259a) {
                if (i > 2) {
                    break;
                }
                i++;
                arrayList.add(shortUserInfo.portrait);
            }
            this.l.setData(arrayList);
            if (!TextUtils.isEmpty(cVar.f57261c)) {
                this.f57284g.setVisibility(0);
                this.f57285h.setVisibility(8);
                this.f57284g.W(cVar.f57261c, 12, false);
            } else {
                this.f57285h.setVisibility(0);
                this.f57284g.setVisibility(8);
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f57285h, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
        e();
    }

    public void g(String str) {
        this.p = str;
    }
}
