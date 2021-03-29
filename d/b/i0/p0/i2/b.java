package d.b.i0.p0.i2;

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
import d.b.b.e.p.k;
import tbclient.SportScheduleInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57672a;

    /* renamed from: b  reason: collision with root package name */
    public View f57673b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57674c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f57675d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f57676e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57677f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57678g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57679h;
    public TextView i;
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
            UrlManager.getInstance().dealOneLink(b.this.f57672a, new String[]{b.this.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", b.this.l));
        }
    }

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f57672a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f57673b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f57674c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f57675d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f57676e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f57677f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f57678g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f57679h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f57675d.setPageId(uniqueId);
        this.f57676e.setPageId(uniqueId);
    }

    public void d() {
        SkinManager.setBackgroundResource(this.f57673b, R.drawable.bg_sports_frs_schedule_card_shape);
        SkinManager.setBackgroundResource(this.f57674c, R.drawable.bg_sports_frs_schedule_card_shape);
        SkinManager.setViewTextColor(this.f57674c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57677f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57678g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57679h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        if (sportScheduleInfo == null) {
            this.f57673b.setVisibility(8);
            this.f57674c.setVisibility(0);
            this.f57674c.setText(R.string.frs_sports_recommend_tab_txt);
            return;
        }
        this.f57673b.setVisibility(0);
        this.f57674c.setVisibility(8);
        this.f57675d.W(sportScheduleInfo.home_team_icon, 10, false);
        this.f57676e.W(sportScheduleInfo.guest_team_icon, 10, false);
        String str2 = sportScheduleInfo.home_team_name;
        if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
            str2 = StringHelper.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
        }
        String str3 = sportScheduleInfo.guest_team_name;
        if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
            str3 = StringHelper.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
        }
        this.f57677f.setText(str2);
        this.f57678g.setText(str3);
        this.f57679h.setText(sportScheduleInfo.match_top_info);
        this.i.setText(sportScheduleInfo.match_middle_info);
        this.j.setText(sportScheduleInfo.match_bottom_info);
        this.k = sportScheduleInfo.msg_url;
        this.l = str;
        this.f57673b.setOnClickListener(this.m);
    }
}
