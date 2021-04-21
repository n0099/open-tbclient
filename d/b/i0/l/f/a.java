package d.b.i0.l.f;

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
import d.b.c.e.p.l;
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
    public final View f51014a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f51015b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f51016c;

    /* renamed from: d  reason: collision with root package name */
    public List<ThreadAchievementShareInfo.ThreadListBean> f51017d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51018e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51019f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51020g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f51021h;
    public TextView i;
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
        this.f51016c = context;
        this.f51014a = LayoutInflater.from(context).inflate(R.layout.hot_thread_rank_list, (ViewGroup) null);
        ThreadAchievementShareInfo.ParamBean params = threadAchievementShareInfo.getParams();
        this.f51015b = params;
        if (params != null) {
            this.f51017d = params.getThread_list();
        }
        c();
        b();
    }

    public View a() {
        return this.f51014a;
    }

    public final void b() {
        List<ThreadAchievementShareInfo.ThreadListBean> list;
        if (this.f51015b == null || (list = this.f51017d) == null || list.size() < 2) {
            return;
        }
        int rank = this.f51015b.getRank();
        if (rank == 0) {
            ThreadAchievementShareInfo.ThreadListBean threadListBean = this.f51017d.get(rank);
            threadListBean.setDuration(500);
            int i = rank + 1;
            e(i, threadListBean);
            f(rank + 2, this.f51017d.get(i));
            this.u.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.w.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = l.g(this.f51016c, R.dimen.tbds8);
        } else if (rank == 1) {
            d(rank, this.f51017d.get(rank - 1));
            f(rank + 1, this.f51017d.get(rank));
            this.v.setVisibility(4);
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.g(this.f51016c, R.dimen.tbds5);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0310);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0310);
            SkinManager.setBackgroundColor(this.p, R.color.cp_other_b_alpha20);
        } else {
            int i2 = rank - 1;
            e(i2, this.f51017d.get(rank - 2));
            d(rank, this.f51017d.get(i2));
            ((RelativeLayout.LayoutParams) this.u.getLayoutParams()).topMargin = l.g(this.f51016c, R.dimen.tbds230);
            this.w.setVisibility(4);
        }
    }

    @SuppressLint({"CutPasteId"})
    public final void c() {
        this.q = (TextView) this.f51014a.findViewById(R.id.title);
        this.f51018e = (TextView) this.f51014a.findViewById(R.id.first_rank_num);
        this.f51019f = (TextView) this.f51014a.findViewById(R.id.first_thread_content);
        this.r = (TbImageView) this.f51014a.findViewById(R.id.first_thread_img);
        this.f51020g = (TextView) this.f51014a.findViewById(R.id.first_heat_degree);
        this.n = this.f51014a.findViewById(R.id.first_heat_degree_bg);
        this.f51021h = (TextView) this.f51014a.findViewById(R.id.second_rank_num);
        this.i = (TextView) this.f51014a.findViewById(R.id.second_thread_content);
        this.s = (TbImageView) this.f51014a.findViewById(R.id.second_thread_img);
        this.j = (TextView) this.f51014a.findViewById(R.id.second_heat_degree);
        this.o = this.f51014a.findViewById(R.id.second_heat_degree_bg);
        this.k = (TextView) this.f51014a.findViewById(R.id.current_rank_num);
        this.l = (TextView) this.f51014a.findViewById(R.id.current_thread_content);
        this.t = (TbImageView) this.f51014a.findViewById(R.id.current_thread_img);
        this.m = (TextView) this.f51014a.findViewById(R.id.current_heat_degree);
        this.p = this.f51014a.findViewById(R.id.current_heat_degree_bg);
        this.v = this.f51014a.findViewById(R.id.first_item_layout);
        this.w = this.f51014a.findViewById(R.id.second_item_layout);
        this.u = this.f51014a.findViewById(R.id.current_item_layout);
        this.I = this.f51014a.findViewById(R.id.first_thread_img_overlay);
        this.H = this.f51014a.findViewById(R.id.second_thread_img_overlay);
        this.G = this.f51014a.findViewById(R.id.current_thread_img_overlay);
        this.x = (LinearLayout) this.f51014a.findViewById(R.id.first_video_during_container);
        this.y = (ImageView) this.f51014a.findViewById(R.id.first_vidoe_play_iv);
        this.z = (TextView) this.f51014a.findViewById(R.id.first_video_during_tv);
        this.A = (LinearLayout) this.f51014a.findViewById(R.id.second_video_during_container);
        this.B = (ImageView) this.f51014a.findViewById(R.id.second_vidoe_play_iv);
        this.C = (TextView) this.f51014a.findViewById(R.id.second_video_during_tv);
        this.D = (LinearLayout) this.f51014a.findViewById(R.id.current_video_during_container);
        this.E = (ImageView) this.f51014a.findViewById(R.id.current_vidoe_play_iv);
        this.F = (TextView) this.f51014a.findViewById(R.id.current_video_during_tv);
        this.r.setRadius(l.g(this.f51016c, R.dimen.tbds10));
        this.r.setConrers(15);
        this.r.setPlaceHolder(2);
        this.s.setRadius(l.g(this.f51016c, R.dimen.tbds10));
        this.s.setConrers(15);
        this.s.setPlaceHolder(2);
        this.t.setRadius(l.g(this.f51016c, R.dimen.tbds10));
        this.t.setConrers(15);
        this.t.setPlaceHolder(2);
        this.f51019f.setLineSpacing(l.g(this.f51016c, R.dimen.tbds13), 1.0f);
        this.i.setLineSpacing(l.g(this.f51016c, R.dimen.tbds13), 1.0f);
        this.l.setLineSpacing(l.g(this.f51016c, R.dimen.tbds13), 1.0f);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f51018e, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f51018e, R.drawable.cp_other_d_round_bg);
        SkinManager.setBackgroundResource(this.n, R.drawable.cp_other_b_alpha20_round_bg);
        SkinManager.setViewTextColor(this.f51019f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f51020g, R.color.CAM_X0310);
        SkinManager.setViewTextColor(this.f51021h, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.f51021h, R.drawable.cp_link_tip_d_round_bg);
        SkinManager.setBackgroundResource(this.o, R.drawable.cp_link_tip_d_alpha20_round_bg);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0305);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        SkinManager.setBackgroundResource(this.k, R.drawable.cp_link_tip_d_round_bg);
        SkinManager.setBackgroundResource(this.p, R.drawable.cp_link_tip_d_alpha20_round_bg);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0305);
        SkinManager.setBackgroundColor(this.f51014a, R.color.CAM_X0201);
        TBSelector.makeShadowDrawable().setShape(1).setShapeRadius(0).setBgColor(SkinManager.getResourceId(R.color.CAM_X0201)).setShadowColor(SkinManager.getResourceId(R.color.CAM_X0806)).setShadowSide(UIMsg.k_event.MV_MAP_CHANGETO2D).setShadowRadius(l.g(this.f51016c, R.dimen.tbds16)).setOffsetX(0).setOffsetY(l.g(this.f51016c, R.dimen.tbds5)).into(this.u);
        this.y.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.B.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.E.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.F, R.color.CAM_X0101);
    }

    public final void d(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.u.setVisibility(0);
        this.k.setText(String.valueOf(i));
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
            this.t.W(threadListBean.getImg(), 10, false);
            return;
        }
        this.t.setVisibility(8);
        this.D.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.l.getLayoutParams()).rightMargin = l.g(this.f51016c, R.dimen.tbds44);
    }

    public final void e(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.v.setVisibility(0);
        this.f51018e.setText(String.valueOf(i));
        this.f51019f.setText(threadListBean.getTitle());
        if (!TextUtils.isEmpty(threadListBean.getHotvalue())) {
            this.n.setVisibility(0);
            TextView textView = this.f51020g;
            textView.setText("热度 " + StringHelper.numFormatOverWanNa(Long.parseLong(threadListBean.getHotvalue())));
        }
        if (threadListBean.getDuration() > 0) {
            this.x.setVisibility(0);
            this.I.setVisibility(0);
            this.z.setText(StringUtils.translateSecondsToString(threadListBean.getDuration()));
        }
        if (!TextUtils.isEmpty(threadListBean.getImg())) {
            this.r.setVisibility(0);
            this.r.W(threadListBean.getImg(), 10, false);
            return;
        }
        this.r.setVisibility(8);
        this.x.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.f51019f.getLayoutParams()).rightMargin = l.g(this.f51016c, R.dimen.tbds44);
    }

    public final void f(int i, ThreadAchievementShareInfo.ThreadListBean threadListBean) {
        this.w.setVisibility(0);
        this.f51021h.setText(String.valueOf(i));
        this.i.setText(threadListBean.getTitle());
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
            this.s.W(threadListBean.getImg(), 10, false);
            return;
        }
        this.s.setVisibility(8);
        this.A.setVisibility(8);
        ((RelativeLayout.LayoutParams) this.i.getLayoutParams()).rightMargin = l.g(this.f51016c, R.dimen.tbds44);
    }
}
