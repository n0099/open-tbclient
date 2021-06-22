package d.a.o0.r0.g2;

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
import d.a.o0.e3.a0;
import d.a.o0.e3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class c implements b, d.a.o0.r0.g2.a {

    /* renamed from: a  reason: collision with root package name */
    public View f62430a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62431b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62432c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62433d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f62434e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f62435f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62436g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f62437h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f62438i;
    public View.OnClickListener j = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.f62430a.getResources().getString(R.string.hot_user_rank), c.this.f62435f.f57751b) || c.this.f62438i == null || c.this.f62438i.getForum() == null || TextUtils.isEmpty(c.this.f62438i.getForum().getId())) {
                if (c.this.f62435f != null && c.this.f62435f.f57755f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", c.this.f62435f.f57756g).param("obj_source", "frs_card").param("obj_id", c.this.f62435f.f57755f.f57760b).param("obj_name", c.this.f62435f.f57755f.f57759a).param("obj_param1", c.this.f62435f.f57755f.f57762d.intValue()));
                }
                d.a(view.getContext(), c.this.f62435f);
                d.b(c.this.f62435f);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(c.this.f62438i.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13666");
            statisticItem.param("fid", c.this.f62438i.getForum().getId());
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f62430a = inflate;
        this.f62431b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f62432c = (TextView) this.f62430a.findViewById(R.id.frs_service_category);
        this.f62433d = (TextView) this.f62430a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f62430a.findViewById(R.id.frs_service_icon);
        this.f62434e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f62434e.setIsRound(true);
        this.f62434e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f62430a.findViewById(R.id.image_group);
        this.f62437h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f62437h.setStrokeStyle(1);
        this.f62437h.setLoadImageType(12);
        this.f62430a.setOnClickListener(this.j);
        this.f62436g = (ImageView) this.f62430a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.a.o0.r0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f57749b)) {
            return;
        }
        this.f62438i = frsViewData;
        b0 b0Var = a0Var.f57749b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f62435f = b0Var;
        if (!TextUtils.equals(this.f62430a.getResources().getString(R.string.hot_user_rank), this.f62435f.f57751b)) {
            this.f62432c.setText(this.f62430a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f62432c.setText(this.f62430a.getContext().getString(R.string.frs_service_special));
            this.f62431b.setText(this.f62430a.getContext().getString(R.string.hot_person));
        }
        this.f62433d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f57752c, 20));
        if (TextUtils.equals(this.f62430a.getResources().getString(R.string.hot_user_rank), b0Var.f57751b)) {
            this.f62437h.setVisibility(0);
            this.f62434e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f62434e.U(b0Var.f57751b, 10, false);
            this.f62434e.setVisibility(0);
            this.f62437h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.a.o0.r0.g2.a
    public void b(int i2) {
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f62431b);
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
        this.f62437h.setData(arrayList);
        return false;
    }

    @Override // d.a.o0.r0.g2.b
    public View getView() {
        return this.f62430a;
    }

    @Override // d.a.o0.r0.g2.b
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f62432c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62433d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62431b, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f62436g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f62437h.d();
    }
}
