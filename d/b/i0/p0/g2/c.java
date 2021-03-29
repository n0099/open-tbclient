package d.b.i0.p0.g2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import d.b.b.e.p.l;
import d.b.i0.c3.a0;
import d.b.i0.c3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class c implements b, d.b.i0.p0.g2.a {

    /* renamed from: a  reason: collision with root package name */
    public View f57548a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57549b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57550c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57551d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f57552e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f57553f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57554g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f57555h;
    public FrsViewData i;
    public View.OnClickListener j = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.f57548a.getResources().getString(R.string.hot_user_rank), c.this.f57553f.f53318b) || c.this.i == null || c.this.i.getForum() == null || TextUtils.isEmpty(c.this.i.getForum().getId())) {
                if (c.this.f57553f != null && c.this.f57553f.f53322f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", c.this.f57553f.f53323g).param("obj_source", "frs_card").param("obj_id", c.this.f57553f.f53322f.f53326b).param("obj_name", c.this.f57553f.f53322f.f53325a).param("obj_param1", c.this.f57553f.f53322f.f53328d.intValue()));
                }
                d.a(view.getContext(), c.this.f57553f);
                d.b(c.this.f57553f);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(d.b.b.e.m.b.f(c.this.i.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13666");
            statisticItem.param("fid", c.this.i.getForum().getId());
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f57548a = inflate;
        this.f57549b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f57550c = (TextView) this.f57548a.findViewById(R.id.frs_service_category);
        this.f57551d = (TextView) this.f57548a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f57548a.findViewById(R.id.frs_service_icon);
        this.f57552e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f57552e.setIsRound(true);
        this.f57552e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f57548a.findViewById(R.id.image_group);
        this.f57555h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f57555h.setStrokeStyle(1);
        this.f57555h.setLoadImageType(12);
        this.f57548a.setOnClickListener(this.j);
        this.f57554g = (ImageView) this.f57548a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.b.i0.p0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53316b)) {
            return;
        }
        this.i = frsViewData;
        b0 b0Var = a0Var.f53316b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f57553f = b0Var;
        if (!TextUtils.equals(this.f57548a.getResources().getString(R.string.hot_user_rank), this.f57553f.f53318b)) {
            this.f57550c.setText(this.f57548a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f57550c.setText(this.f57548a.getContext().getString(R.string.frs_service_special));
            this.f57549b.setText(this.f57548a.getContext().getString(R.string.hot_person));
        }
        this.f57551d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f53319c, 20));
        if (TextUtils.equals(this.f57548a.getResources().getString(R.string.hot_user_rank), b0Var.f53318b)) {
            this.f57555h.setVisibility(0);
            this.f57552e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f57552e.W(b0Var.f53318b, 10, false);
            this.f57552e.setVisibility(0);
            this.f57555h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.b.i0.p0.g2.a
    public void b(int i) {
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i).into(this.f57549b);
    }

    public final boolean f(FrsViewData frsViewData) {
        if (frsViewData.getHotUserRankData() == null || frsViewData.getHotUserRankData().hot_user == null || frsViewData.getHotUserRankData().hot_user.size() <= 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
            if (shortUserInfo != null) {
                arrayList.add(shortUserInfo.portrait);
            }
        }
        this.f57555h.setData(arrayList);
        return false;
    }

    @Override // d.b.i0.p0.g2.b
    public View getView() {
        return this.f57548a;
    }

    @Override // d.b.i0.p0.g2.b
    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.f57550c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57551d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57549b, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f57554g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f57555h.d();
    }
}
