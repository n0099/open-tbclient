package d.a.n0.r0.i2;

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
    public TbPageContext f58745a;

    /* renamed from: b  reason: collision with root package name */
    public View f58746b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58747c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f58748d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f58749e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58750f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58751g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58752h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f58753i;
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
            UrlManager.getInstance().dealOneLink(b.this.f58745a, new String[]{b.this.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", b.this.l));
        }
    }

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f58745a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f58746b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f58747c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f58748d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f58749e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f58750f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f58751g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f58752h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f58753i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f58748d.setPageId(uniqueId);
        this.f58749e.setPageId(uniqueId);
    }

    public void d() {
        SkinManager.setBackgroundResource(this.f58746b, R.drawable.bg_sports_frs_schedule_card_shape);
        SkinManager.setBackgroundResource(this.f58747c, R.drawable.bg_sports_frs_schedule_card_shape);
        SkinManager.setViewTextColor(this.f58747c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58750f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58751g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f58752h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.f58753i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.f58746b.setVisibility(8);
            this.f58747c.setVisibility(0);
            this.f58747c.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.f58746b.setVisibility(0);
        this.f58747c.setVisibility(8);
        this.f58748d.V(sportScheduleInfo.home_team_icon, 10, false);
        this.f58749e.V(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
            str2 = StringHelper.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
            str3 = StringHelper.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.f58750f.setText(str2);
        this.f58751g.setText(str3);
        this.f58752h.setText(sportScheduleInfo.match_top_info);
        this.f58753i.setText(sportScheduleInfo.match_middle_info);
        this.j.setText(sportScheduleInfo.match_bottom_info);
        this.k = sportScheduleInfo.msg_url;
        this.l = str;
        this.f58746b.setOnClickListener(this.m);
    }
}
