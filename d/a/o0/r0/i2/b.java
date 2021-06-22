package d.a.o0.r0.i2;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import d.a.c.e.p.k;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62561a;

    /* renamed from: b  reason: collision with root package name */
    public View f62562b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62563c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f62564d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f62565e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62566f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62567g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f62568h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f62569i;
    public TextView j;
    public String k;
    public String l;
    public final View.OnClickListener m = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.isEmpty(b.this.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(b.this.f62561a, new String[]{b.this.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", b.this.l));
        }
    }

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f62561a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f62562b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f62563c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f62564d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f62565e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f62566f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f62567g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f62568h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f62569i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f62564d.setPageId(uniqueId);
        this.f62565e.setPageId(uniqueId);
    }

    public void d() {
        SkinManager.setBackgroundResource(this.f62562b, R.drawable.bg_sports_frs_schedule_card_shape);
        SkinManager.setBackgroundResource(this.f62563c, R.drawable.bg_sports_frs_schedule_card_shape);
        SkinManager.setViewTextColor(this.f62563c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62566f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62567g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f62568h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f62569i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.f62562b.setVisibility(8);
            this.f62563c.setVisibility(0);
            this.f62563c.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.f62562b.setVisibility(0);
        this.f62563c.setVisibility(8);
        this.f62564d.U(sportScheduleInfo.home_team_icon, 10, false);
        this.f62565e.U(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
            str2 = StringHelper.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
            str3 = StringHelper.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.f62566f.setText(str2);
        this.f62567g.setText(str3);
        this.f62568h.setText(sportScheduleInfo.match_top_info);
        this.f62569i.setText(sportScheduleInfo.match_middle_info);
        this.j.setText(sportScheduleInfo.match_bottom_info);
        this.k = sportScheduleInfo.msg_url;
        this.l = str;
        this.f62562b.setOnClickListener(this.m);
    }
}
