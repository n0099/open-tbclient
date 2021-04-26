package d.a.j0.q0.g2;

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
import d.a.j0.d3.a0;
import d.a.j0.d3.b0;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes4.dex */
public class c implements b, d.a.j0.q0.g2.a {

    /* renamed from: a  reason: collision with root package name */
    public View f57731a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57732b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57733c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f57734d;

    /* renamed from: e  reason: collision with root package name */
    public TbClipImageView f57735e;

    /* renamed from: f  reason: collision with root package name */
    public b0 f57736f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57737g;

    /* renamed from: h  reason: collision with root package name */
    public ImageOverlayView f57738h;

    /* renamed from: i  reason: collision with root package name */
    public FrsViewData f57739i;
    public View.OnClickListener j = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(c.this.f57731a.getResources().getString(R.string.hot_user_rank), c.this.f57736f.f53017b) || c.this.f57739i == null || c.this.f57739i.getForum() == null || TextUtils.isEmpty(c.this.f57739i.getForum().getId())) {
                if (c.this.f57736f != null && c.this.f57736f.f53021f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", c.this.f57736f.f53022g).param("obj_source", "frs_card").param("obj_id", c.this.f57736f.f53021f.f53026b).param("obj_name", c.this.f57736f.f53021f.f53025a).param("obj_param1", c.this.f57736f.f53021f.f53028d.intValue()));
                }
                d.a(view.getContext(), c.this.f57736f);
                d.b(c.this.f57736f);
                return;
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view.getContext());
            hotUserRankActivityConfig.setForumId(Long.valueOf(d.a.c.e.m.b.f(c.this.f57739i.getForum().getId(), 0L)));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
            StatisticItem statisticItem = new StatisticItem("c13666");
            statisticItem.param("fid", c.this.f57739i.getForum().getId());
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.frs_one_service_layout, (ViewGroup) null);
        this.f57731a = inflate;
        this.f57732b = (TextView) inflate.findViewById(R.id.frs_service);
        this.f57733c = (TextView) this.f57731a.findViewById(R.id.frs_service_category);
        this.f57734d = (TextView) this.f57731a.findViewById(R.id.frs_service_name);
        TbClipImageView tbClipImageView = (TbClipImageView) this.f57731a.findViewById(R.id.frs_service_icon);
        this.f57735e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.f57735e.setIsRound(true);
        this.f57735e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.f57731a.findViewById(R.id.image_group);
        this.f57738h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.f57738h.setStrokeStyle(1);
        this.f57738h.setLoadImageType(12);
        this.f57731a.setOnClickListener(this.j);
        this.f57737g = (ImageView) this.f57731a.findViewById(R.id.frs_service_arrow);
    }

    @Override // d.a.j0.q0.g2.b
    public void a(a0 a0Var, FrsViewData frsViewData) {
        if (a0Var == null || ListUtils.isEmpty(a0Var.f53015b)) {
            return;
        }
        this.f57739i = frsViewData;
        b0 b0Var = a0Var.f53015b.get(0);
        if (b0Var == null) {
            return;
        }
        this.f57736f = b0Var;
        if (!TextUtils.equals(this.f57731a.getResources().getString(R.string.hot_user_rank), this.f57736f.f53017b)) {
            this.f57733c.setText(this.f57731a.getContext().getString(R.string.forum_exclusive));
        } else {
            this.f57733c.setText(this.f57731a.getContext().getString(R.string.frs_service_special));
            this.f57732b.setText(this.f57731a.getContext().getString(R.string.hot_person));
        }
        this.f57734d.setText(StringHelper.cutStringWithEllipsisStrict(b0Var.f53018c, 20));
        if (TextUtils.equals(this.f57731a.getResources().getString(R.string.hot_user_rank), b0Var.f53017b)) {
            this.f57738h.setVisibility(0);
            this.f57735e.setVisibility(8);
            f(frsViewData);
        } else {
            this.f57735e.V(b0Var.f53017b, 10, false);
            this.f57735e.setVisibility(0);
            this.f57738h.setVisibility(8);
        }
        d.c(b0Var);
    }

    @Override // d.a.j0.q0.g2.a
    public void b(int i2) {
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i2).into(this.f57732b);
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
        this.f57738h.setData(arrayList);
        return false;
    }

    @Override // d.a.j0.q0.g2.b
    public View getView() {
        return this.f57731a;
    }

    @Override // d.a.j0.q0.g2.b
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f57733c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57734d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57732b, R.color.CAM_X0101);
        WebPManager.setPureDrawable(this.f57737g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        this.f57738h.d();
    }
}
