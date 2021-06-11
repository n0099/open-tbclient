package d.a.n0.r0.g2;

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
import d.a.c.e.p.l;
import d.a.n0.e3.a0;
import d.a.n0.e3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class c implements b, d.a.n0.r0.g2.a {

    /* renamed from: a  reason: collision with root package name */
    public View f62305a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62306b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62307c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62308d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f62309e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f62310f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62311g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f62312h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f62313i;
    public View.OnClickListener j = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.f62305a.getResources().getString(R.string.hot_user_rank), c.this.f62310f.f57626b) || c.this.f62313i == null || c.this.f62313i.getForum() == null || TextUtils.isEmpty(c.this.f62313i.getForum().getId())) {
                if (c.this.f62310f != null && c.this.f62310f.f57630f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", c.this.f62310f.f57631g).param("obj_source", "frs_card").param("obj_id", c.this.f62310f.f57630f.f57635b).param("obj_name", c.this.f62310f.f57630f.f57634a).param("obj_param1", c.this.f62310f.f57630f.f57637d.intValue()));
                }
                d.a(view.getContext(), c.this.f62310f);
                d.b(c.this.f62310f);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(c.this.f62313i.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13666");
            statisticItem.param("fid", c.this.f62313i.getForum().getId());
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f62305a = inflate;
        this.f62306b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f62307c = (TextView) this.f62305a.findViewById(R.id.frs_service_category);
        this.f62308d = (TextView) this.f62305a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f62305a.findViewById(R.id.frs_service_icon);
        this.f62309e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f62309e.setIsRound(true);
        this.f62309e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f62305a.findViewById(R.id.image_group);
        this.f62312h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f62312h.setStrokeStyle(1);
        this.f62312h.setLoadImageType(12);
        this.f62305a.setOnClickListener(this.j);
        this.f62311g = (ImageView) this.f62305a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.a.n0.r0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f57624b)) {
            return;
        }
        this.f62313i = frsViewData;
        b0 b0Var = a0Var.f57624b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f62310f = b0Var;
        if (!TextUtils.equals(this.f62305a.getResources().getString(R.string.hot_user_rank), this.f62310f.f57626b)) {
            this.f62307c.setText(this.f62305a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f62307c.setText(this.f62305a.getContext().getString(R.string.frs_service_special));
            this.f62306b.setText(this.f62305a.getContext().getString(R.string.hot_person));
        }
        this.f62308d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f57627c, 20));
        if (TextUtils.equals(this.f62305a.getResources().getString(R.string.hot_user_rank), b0Var.f57626b)) {
            this.f62312h.setVisibility(0);
            this.f62309e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f62309e.U(b0Var.f57626b, 10, false);
            this.f62309e.setVisibility(0);
            this.f62312h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.a.n0.r0.g2.a
    public void b(int i2) {
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f62306b);
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
        this.f62312h.setData(arrayList);
        return false;
    }

    @Override // d.a.n0.r0.g2.b
    public View getView() {
        return this.f62305a;
    }

    @Override // d.a.n0.r0.g2.b
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f62307c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62308d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62306b, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f62311g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f62312h.d();
    }
}
