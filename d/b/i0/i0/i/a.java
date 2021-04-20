package d.b.i0.i0.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.tieba.view.IrregularImageView;
import d.b.h0.z0.i0;
import java.util.ArrayList;
import java.util.List;
import tbclient.TiebaFieldsInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f56698a;

    /* renamed from: b  reason: collision with root package name */
    public final long f56699b;

    /* renamed from: d  reason: collision with root package name */
    public View f56701d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56702e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56703f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56704g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56705h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public IrregularImageView m;
    public TextView n;
    public RelativeLayout o;
    public ImageView p;
    public TextView q;
    public ImageOverlayView r;
    public ImageView s;
    public ImageView t;
    public String u;
    public View v;
    public d.b.i0.i0.i.c.a w;

    /* renamed from: c  reason: collision with root package name */
    public int f56700c = 3;
    public View.OnClickListener x = new b();

    /* renamed from: d.b.i0.i0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1325a implements View.OnClickListener {
        public View$OnClickListenerC1325a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56699b > 0) {
                StatisticItem statisticItem = new StatisticItem("c13671");
                statisticItem.param("fid", a.this.f56699b);
                TiebaStatic.log(statisticItem);
            }
            HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(a.this.f56701d.getContext());
            hotUserRankActivityConfig.setCategory(a.this.u);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != a.this.v.getId() || a.this.w == null || a.this.w.f56719c == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(a.this.f56701d.getContext(), a.this.w.f56719c.getUserId(), a.this.w.f56719c.getName_show())));
            if (!TextUtils.isEmpty(a.this.f56698a)) {
                StatisticItem statisticItem = new StatisticItem("c13659");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, a.this.w.f56717a);
                statisticItem.param(TiebaStatic.Params.FRIEND_UID, a.this.w.f56719c.rankNum);
                TiebaStatic.log(statisticItem);
                return;
            }
            StatisticItem statisticItem2 = new StatisticItem("c13683");
            statisticItem2.param("uid", a.this.w.f56719c.getUserId());
            statisticItem2.param("fid", a.this.f56699b);
            TiebaStatic.log(statisticItem2);
        }
    }

    public a(View view, String str, long j) {
        this.f56701d = view;
        this.f56698a = str;
        this.f56699b = j;
        View findViewById = view.findViewById(R.id.top_container);
        this.v = findViewById;
        findViewById.setOnClickListener(this.x);
        TextView textView = (TextView) view.findViewById(R.id.rank_name);
        this.f56702e = textView;
        textView.getPaint().setFakeBoldText(true);
        this.f56703f = (TextView) view.findViewById(R.id.top_user_name);
        this.f56704g = (TextView) view.findViewById(R.id.rank_data);
        this.f56705h = (ImageView) view.findViewById(R.id.img_left_top_cover);
        this.i = (ImageView) view.findViewById(R.id.img_left_bottom_cover);
        this.j = (ImageView) view.findViewById(R.id.img_center_top_cover);
        this.k = (ImageView) view.findViewById(R.id.img_right_top_cover);
        this.l = (ImageView) view.findViewById(R.id.img_right_bottom_cover);
        IrregularImageView irregularImageView = (IrregularImageView) view.findViewById(R.id.img_user_head);
        this.m = irregularImageView;
        irregularImageView.setErrorRes(R.drawable.pic_list_avatar);
        this.f56705h.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_rule_line100, 1, false));
        this.i.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_circle, 1, false));
        this.j.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_line, 1, false));
        this.k.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_circle2, 1, false));
        this.l.setImageDrawable(SvgManager.getInstance().getDrawable(R.drawable.svg_pic_mask_list_line2, 1, false));
        TextView textView2 = (TextView) view.findViewById(R.id.text_compute_method);
        this.n = textView2;
        textView2.setText(this.f56701d.getResources().getString(R.string.hot_user_rank_influence_desc));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.hot_rank_entry);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(new View$OnClickListenerC1325a());
        this.p = (ImageView) view.findViewById(R.id.hot_rank_entry_crown);
        this.q = (TextView) view.findViewById(R.id.hot_rank_entry_describe);
        this.t = (ImageView) view.findViewById(R.id.hot_rank_entry_first_tag);
        this.r = (ImageOverlayView) view.findViewById(R.id.hot_rank_entry_image_group);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds82);
        this.r.a(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2), R.color.CAM_X0618, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds25));
        this.r.setStrokeStyle(1);
        this.r.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.r.setLoadImageType(12);
        this.s = (ImageView) view.findViewById(R.id.hot_rank_entry_arrow);
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g(List<String> list) {
        int count = ListUtils.getCount(list);
        if (count == 0) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds267);
        if (count < 3) {
            int i = 3 - count;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams.rightMargin = dimensionPixelOffset - (i * TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57));
            this.t.setLayoutParams(layoutParams);
        }
    }

    public BdUniqueId h(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext().getUniqueId();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext().getUniqueId();
        }
        return null;
    }

    public final List<String> i(List<User> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (User user : list) {
            if (user != null) {
                arrayList.add(user.portrait);
            }
        }
        return arrayList;
    }

    public void j(int i) {
        if (this.f56700c != i) {
            this.f56700c = i;
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.p, R.drawable.svg_icon_mask_crown24, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.t, R.drawable.svg_icon_mask_first16, SvgManager.SvgResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.s, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            this.r.d();
        }
    }

    public void k(d.b.i0.i0.i.c.a aVar, boolean z) {
        this.w = aVar;
        if (aVar == null) {
            return;
        }
        this.f56702e.setText(aVar.f56717a);
        if (aVar.f56719c != null) {
            String str = aVar.f56718b;
            if (i0.d(str) > 10) {
                str = i0.m(aVar.f56718b, 10) + StringHelper.STRING_MORE;
            }
            this.f56703f.setText(String.format(this.f56701d.getContext().getResources().getString(R.string.hot_user_rank_top_name), str));
        }
        if (aVar.f56720d == 0) {
            this.f56704g.setVisibility(8);
        } else {
            this.f56704g.setVisibility(0);
            this.f56704g.setText(String.format(this.f56701d.getContext().getString(R.string.hot_user_rank_data), StringHelper.getDateStringMdChinease(aVar.f56720d * 1000)));
        }
        this.m.setImage(aVar.f56721e, h(this.f56701d.getContext()), R.drawable.mask_list_avatar);
        TiebaFieldsInfo tiebaFieldsInfo = aVar.f56722f;
        if (tiebaFieldsInfo != null && !z && !TextUtils.isEmpty(tiebaFieldsInfo.tieba_name)) {
            this.o.setVisibility(0);
            this.q.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.cat_hot_rank), aVar.f56722f.tieba_name));
            List<String> i = i(aVar.f56722f.user_rank);
            this.r.setData(i);
            g(i);
            this.u = aVar.f56722f.tieba_name;
            if (this.f56699b > 0) {
                StatisticItem statisticItem = new StatisticItem("c13670");
                statisticItem.param("fid", this.f56699b);
                TiebaStatic.log(statisticItem);
                return;
            }
            return;
        }
        this.o.setVisibility(8);
    }
}
