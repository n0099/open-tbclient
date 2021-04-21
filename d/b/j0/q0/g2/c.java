package d.b.j0.q0.g2;

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
import d.b.c.e.p.l;
import d.b.j0.d3.a0;
import d.b.j0.d3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class c implements b, d.b.j0.q0.g2.a {

    /* renamed from: a  reason: collision with root package name */
    public View f59668a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f59669b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f59670c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59671d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f59672e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f59673f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59674g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f59675h;
    public FrsViewData i;
    public View.OnClickListener j = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.f59668a.getResources().getString(R.string.hot_user_rank), c.this.f59673f.f55181b) || c.this.i == null || c.this.i.getForum() == null || TextUtils.isEmpty(c.this.i.getForum().getId())) {
                if (c.this.f59673f != null && c.this.f59673f.f55185f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", c.this.f59673f.f55186g).param("obj_source", "frs_card").param("obj_id", c.this.f59673f.f55185f.f55189b).param("obj_name", c.this.f59673f.f55185f.f55188a).param("obj_param1", c.this.f59673f.f55185f.f55191d.intValue()));
                }
                d.a(view.getContext(), c.this.f59673f);
                d.b(c.this.f59673f);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(d.b.c.e.m.b.f(c.this.i.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13666");
            statisticItem.param("fid", c.this.i.getForum().getId());
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f59668a = inflate;
        this.f59669b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f59670c = (TextView) this.f59668a.findViewById(R.id.frs_service_category);
        this.f59671d = (TextView) this.f59668a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f59668a.findViewById(R.id.frs_service_icon);
        this.f59672e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f59672e.setIsRound(true);
        this.f59672e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f59668a.findViewById(R.id.image_group);
        this.f59675h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f59675h.setStrokeStyle(1);
        this.f59675h.setLoadImageType(12);
        this.f59668a.setOnClickListener(this.j);
        this.f59674g = (ImageView) this.f59668a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.b.j0.q0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f55179b)) {
            return;
        }
        this.i = frsViewData;
        b0 b0Var = a0Var.f55179b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f59673f = b0Var;
        if (!TextUtils.equals(this.f59668a.getResources().getString(R.string.hot_user_rank), this.f59673f.f55181b)) {
            this.f59670c.setText(this.f59668a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f59670c.setText(this.f59668a.getContext().getString(R.string.frs_service_special));
            this.f59669b.setText(this.f59668a.getContext().getString(R.string.hot_person));
        }
        this.f59671d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f55182c, 20));
        if (TextUtils.equals(this.f59668a.getResources().getString(R.string.hot_user_rank), b0Var.f55181b)) {
            this.f59675h.setVisibility(0);
            this.f59672e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f59672e.W(b0Var.f55181b, 10, false);
            this.f59672e.setVisibility(0);
            this.f59675h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.b.j0.q0.g2.a
    public void b(int i) {
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i).into(this.f59669b);
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
        this.f59675h.setData(arrayList);
        return false;
    }

    @Override // d.b.j0.q0.g2.b
    public View getView() {
        return this.f59668a;
    }

    @Override // d.b.j0.q0.g2.b
    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this.f59670c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f59671d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f59669b, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f59674g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f59675h.d();
    }
}
