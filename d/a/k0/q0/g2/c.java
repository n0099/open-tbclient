package d.a.k0.q0.g2;

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
import d.a.k0.d3.a0;
import d.a.k0.d3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class c implements b, d.a.k0.q0.g2.a {

    /* renamed from: a  reason: collision with root package name */
    public View f58473a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58474b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58475c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58476d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f58477e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f58478f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58479g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f58480h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f58481i;
    public View.OnClickListener j = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.f58473a.getResources().getString(R.string.hot_user_rank), c.this.f58478f.f53724b) || c.this.f58481i == null || c.this.f58481i.getForum() == null || TextUtils.isEmpty(c.this.f58481i.getForum().getId())) {
                if (c.this.f58478f != null && c.this.f58478f.f53728f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", c.this.f58478f.f53729g).param("obj_source", "frs_card").param("obj_id", c.this.f58478f.f53728f.f53733b).param("obj_name", c.this.f58478f.f53728f.f53732a).param("obj_param1", c.this.f58478f.f53728f.f53735d.intValue()));
                }
                d.a(view.getContext(), c.this.f58478f);
                d.b(c.this.f58478f);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(c.this.f58481i.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13666");
            statisticItem.param("fid", c.this.f58481i.getForum().getId());
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f58473a = inflate;
        this.f58474b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f58475c = (TextView) this.f58473a.findViewById(R.id.frs_service_category);
        this.f58476d = (TextView) this.f58473a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f58473a.findViewById(R.id.frs_service_icon);
        this.f58477e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f58477e.setIsRound(true);
        this.f58477e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f58473a.findViewById(R.id.image_group);
        this.f58480h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f58480h.setStrokeStyle(1);
        this.f58480h.setLoadImageType(12);
        this.f58473a.setOnClickListener(this.j);
        this.f58479g = (ImageView) this.f58473a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.a.k0.q0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53722b)) {
            return;
        }
        this.f58481i = frsViewData;
        b0 b0Var = a0Var.f53722b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f58478f = b0Var;
        if (!TextUtils.equals(this.f58473a.getResources().getString(R.string.hot_user_rank), this.f58478f.f53724b)) {
            this.f58475c.setText(this.f58473a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f58475c.setText(this.f58473a.getContext().getString(R.string.frs_service_special));
            this.f58474b.setText(this.f58473a.getContext().getString(R.string.hot_person));
        }
        this.f58476d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f53725c, 20));
        if (TextUtils.equals(this.f58473a.getResources().getString(R.string.hot_user_rank), b0Var.f53724b)) {
            this.f58480h.setVisibility(0);
            this.f58477e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f58477e.V(b0Var.f53724b, 10, false);
            this.f58477e.setVisibility(0);
            this.f58480h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.a.k0.q0.g2.a
    public void b(int i2) {
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f58474b);
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
        this.f58480h.setData(arrayList);
        return false;
    }

    @Override // d.a.k0.q0.g2.b
    public View getView() {
        return this.f58473a;
    }

    @Override // d.a.k0.q0.g2.b
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f58475c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58476d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58474b, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f58479g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f58480h.d();
    }
}
