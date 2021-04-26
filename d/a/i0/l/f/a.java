package d.a.i0.l.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public LinearLayout A;
    public ImageView B;
    public TextView C;
    public LinearLayout D;
    public ImageView E;
    public TextView F;
    public View G;
    public View H;
    public View I;

    /* renamed from: a  reason: collision with root package name */
    public final View f48598a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f48599b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f48600c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadAchievementShareInfo.ThreadListBean> f48601d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48602e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48603f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48604g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48605h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48606i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public View p;
    public TextView q;
    public TbImageView r;
    public TbImageView s;
    public TbImageView t;
    public View u;
    public View v;
    public View w;
    public LinearLayout x;
    public ImageView y;
    public TextView z;

    public a(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f48600c = context;
        this.f48598a = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        ThreadAchievementShareInfo.ParamBean params = threadAchievementShareInfo.getParams();
        this.f48599b = params;
        if (params != null) {
            this.f48601d = params.getThread_list();
        }
        c();
        b();
    }

    public View a() {
        return this.f48598a;
    }

    public final void b() {
        List<ThreadAchievementShareInfo.ThreadListBean> list;
        if (this.f48599b == null || (list = this.f48601d) == null || list.size() < 2) {
            return;
        }
        int rank = this.f48599b.getRank();
        if (rank == 0) {
            ThreadAchievementShareInfo.ThreadListBean threadListBean = this.f48601d.get(rank);
            threadListBean.setDuration(500);
            int i2 = rank + 1;
            e(i2, threadListBean);
            f(rank + 2, this.f48601d.get(i2));
            this.u.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = l.g(this.f48600c, R.dimen.tbds8);
        } else if (rank == 1) {
            d(rank, this.f48601d.get(rank - 1));
            f(rank + 1, this.f48601d.get(rank));
            this.v.setVisibility(4);
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.g(this.f48600c, R.dimen.tbds5);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.cp_other_b_alpha20);
        } else {
            int i3 = rank - 1;
            e(i3, this.f48601d.get(rank - 2));
            d(rank, this.f48601d.get(i3));
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.g(this.f48600c, R.dimen.tbds230);
            this.w.setVisibility(4);
        }
    }

    @SuppressLint({"CutPasteId"})
    public final void c() {
        this.q = (TextView) this.f48598a.findViewById(R.id.title);
        this.f48602e = (TextView) this.f48598a.findViewById(R.id.first_rank_num);
        this.f48603f = (TextView) this.f48598a.findViewById(R.id.first_thread_content);
        this.r = (TbImageView) this.f48598a.findViewById(R.id.first_thread_img);
        this.f48604g = (TextView) this.f48598a.findViewById(R.id.first_heat_degree);
        this.n = this.f48598a.findViewById(R.id.first_heat_degree_bg);
        this.f48605h = (TextView) this.f48598a.findViewById(R.id.second_rank_num);
        this.f48606i = (TextView) this.f48598a.findViewById(R.id.second_thread_content);
        this.s = (TbImageView) this.f48598a.findViewById(R.id.second_thread_img);
        this.j = (TextView) this.f48598a.findViewById(R.id.second_heat_degree);
        this.o = this.f48598a.findViewById(R.id.second_heat_degree_bg);
        this.k = (TextView) this.f48598a.findViewById(R.id.current_rank_num);
        this.l = (TextView) this.f48598a.findViewById(R.id.current_thread_content);
        this.t = (TbImageView) this.f48598a.findViewById(R.id.current_thread_img);
        this.m = (TextView) this.f48598a.findViewById(R.id.current_heat_degree);
        this.p = this.f48598a.findViewById(R.id.current_heat_degree_bg);
        this.v = this.f48598a.findViewById(R.id.first_item_layout);
        this.w = this.f48598a.findViewById(R.id.second_item_layout);
        this.u = this.f48598a.findViewById(R.id.current_item_layout);
        this.I = this.f48598a.findViewById(R.id.first_thread_img_overlay);
        this.H = this.f48598a.findViewById(R.id.second_thread_img_overlay);
        this.G = this.f48598a.findViewById(R.id.current_thread_img_overlay);
        this.x = (LinearLayout) this.f48598a.findViewById(R.id.first_video_during_container);
        this.y = (ImageView) this.f48598a.findViewById(R.id.first_vidoe_play_iv);
        this.z = (TextView) this.f48598a.findViewById(R.id.first_video_during_tv);
        this.A = (LinearLayout) this.f48598a.findViewById(R.id.second_video_during_container);
        this.B = (ImageView) this.f48598a.findViewById(R.id.second_vidoe_play_iv);
        this.C = (TextView) this.f48598a.findViewById(R.id.second_video_during_tv);
        this.D = (LinearLayout) this.f48598a.findViewById(R.id.current_video_during_container);
        this.E = (ImageView) this.f48598a.findViewById(R.id.current_vidoe_play_iv);
        this.F = (TextView) this.f48598a.findViewById(R.id.current_video_during_tv);
        this.r.setRadius(l.g(this.f48600c, R.dimen.tbds10));
        this.r.setConrers(15);
        this.r.setPlaceHolder(2);
        this.s.setRadius(l.g(this.f48600c, R.dimen.tbds10));
        this.s.setConrers(15);
        this.s.setPlaceHolder(2);
        this.t.setRadius(l.g(this.f48600c, R.dimen.tbds10));
        this.t.setConrers(15);
        this.t.setPlaceHolder(2);
        this.f48603f.setLineSpacing(l.g(this.f48600c, R.dimen.tbds13), 1.0f);
        this.f48606i.setLineSpacing(l.g(this.f48600c, R.dimen.tbds13), 1.0f);
        this.l.setLineSpacing(l.g(this.f48600c, R.dimen.tbds13), 1.0f);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f48602e, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f48602e, R.drawable.cp_other_d_round_bg);
        SkinManager.setBackgroundResource(this.n, R.drawable.cp_other_b_alpha20_round_bg);
        SkinManager.setViewTextColor(this.f48603f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f48604g, R.color.CAM_X0310);
        SkinManager.setViewTextColor(this.f48605h, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f48605h, R.drawable.cp_link_tip_d_round_bg);
        SkinManager.setBackgroundResource(this.o, R.drawable.cp_link_tip_d_alpha20_round_bg);
        SkinManager.setViewTextColor(this.f48606i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0305);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.k, R.drawable.cp_link_tip_d_round_bg);
        SkinManager.setBackgroundResource(this.p, R.drawable.cp_link_tip_d_alpha20_round_bg);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0305);
        SkinManager.setBackgroundColor(this.f48598a, R.color.CAM_X0201);
        TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(0).setBgColor(SkinManager.getResourceId(R.color.CAM_X0201)).setShadowColor(SkinManager.getResourceId(R.color.CAM_X0806)).setShadowSide(UIMsg.k_event.MV_MAP_CHANGETO2D).setShadowRadius(l.g(this.f48600c, R.dimen.tbds16)).setOffsetX(0).setOffsetY(l.g(this.f48600c, R.dimen.tbds5)).into(this.u);
        this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.B.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.E.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
    }

    public final void d(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.u.setVisibility(0);
        this.k.setText(String.valueOf(i2));
        this.l.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.p.setVisibility(0);
            TextView textView = this.m;
            textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.D.setVisibility(0);
            this.G.setVisibility(0);
            this.F.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.t.setVisibility(0);
            this.t.V(threadListBean.getImg(), 10, false);
            return;
        }
        this.t.setVisibility(8);
        this.D.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).rightMargin = l.g(this.f48600c, R.dimen.tbds44);
    }

    public final void e(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.v.setVisibility(0);
        this.f48602e.setText(String.valueOf(i2));
        this.f48603f.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.n.setVisibility(0);
            TextView textView = this.f48604g;
            textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.x.setVisibility(0);
            this.I.setVisibility(0);
            this.z.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.r.setVisibility(0);
            this.r.V(threadListBean.getImg(), 10, false);
            return;
        }
        this.r.setVisibility(8);
        this.x.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.f48603f.getLayoutParams()).rightMargin = l.g(this.f48600c, R.dimen.tbds44);
    }

    public final void f(int i2, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.w.setVisibility(0);
        this.f48605h.setText(String.valueOf(i2));
        this.f48606i.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.o.setVisibility(0);
            TextView textView = this.j;
            textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.A.setVisibility(0);
            this.H.setVisibility(0);
            this.C.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.s.setVisibility(0);
            this.s.V(threadListBean.getImg(), 10, false);
            return;
        }
        this.s.setVisibility(8);
        this.A.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.f48606i.getLayoutParams()).rightMargin = l.g(this.f48600c, R.dimen.tbds44);
    }
}
