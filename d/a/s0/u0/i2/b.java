package d.a.s0.u0.i2;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import tbclient.SportScheduleInfo;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66144a;

    /* renamed from: b  reason: collision with root package name */
    public View f66145b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66146c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f66147d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f66148e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66149f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66150g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f66151h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f66152i;
    public TextView j;
    public String k;
    public String l;
    public final View.OnClickListener m;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66153e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66153e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || k.isEmpty(this.f66153e.k)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f66153e.f66144a, new String[]{this.f66153e.k}, true);
            TiebaStatic.log(new StatisticItem("c13418").param("fid", this.f66153e.l));
        }
    }

    public b(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsSportsRecommendFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f66144a = frsSportsRecommendFragment.getPageContext();
        BdUniqueId uniqueId = frsSportsRecommendFragment.getUniqueId();
        this.f66145b = view.findViewById(R.id.frs_sports_schedule_card_layout);
        this.f66146c = (TextView) view.findViewById(R.id.frs_sports_tab_view);
        this.f66147d = (TbImageView) view.findViewById(R.id.frs_sports_schedule_left_team_icon);
        this.f66148e = (TbImageView) view.findViewById(R.id.frs_sports_schedule_right_team_icon);
        this.f66149f = (TextView) view.findViewById(R.id.frs_sports_schedule_left_team_name);
        this.f66150g = (TextView) view.findViewById(R.id.frs_sports_schedule_right_team_name);
        this.f66151h = (TextView) view.findViewById(R.id.frs_sports_schedule_match_top);
        this.f66152i = (TextView) view.findViewById(R.id.frs_sports_schedule_match_middle);
        this.j = (TextView) view.findViewById(R.id.frs_sports_schedule_match_bottom);
        this.f66147d.setPageId(uniqueId);
        this.f66148e.setPageId(uniqueId);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SkinManager.setBackgroundResource(this.f66145b, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setBackgroundResource(this.f66146c, R.drawable.bg_sports_frs_schedule_card_shape);
            SkinManager.setViewTextColor(this.f66146c, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66149f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66150g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f66151h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.f66152i, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0108);
        }
    }

    public void e(SportScheduleInfo sportScheduleInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sportScheduleInfo, str) == null) {
            if (sportScheduleInfo == null) {
                this.f66145b.setVisibility(8);
                this.f66146c.setVisibility(0);
                this.f66146c.setText(R.string.frs_sports_recommend_tab_txt);
                return;
            }
            this.f66145b.setVisibility(0);
            this.f66146c.setVisibility(8);
            this.f66147d.M(sportScheduleInfo.home_team_icon, 10, false);
            this.f66148e.M(sportScheduleInfo.guest_team_icon, 10, false);
            String str2 = sportScheduleInfo.home_team_name;
            if (StringHelper.getChineseAndEnglishLength(str2) > 14) {
                str2 = StringHelper.cutForumNameWithSuffix(str2, 14, StringHelper.STRING_MORE);
            }
            String str3 = sportScheduleInfo.guest_team_name;
            if (StringHelper.getChineseAndEnglishLength(str3) > 14) {
                str3 = StringHelper.cutForumNameWithSuffix(str3, 14, StringHelper.STRING_MORE);
            }
            this.f66149f.setText(str2);
            this.f66150g.setText(str3);
            this.f66151h.setText(sportScheduleInfo.match_top_info);
            this.f66152i.setText(sportScheduleInfo.match_middle_info);
            this.j.setText(sportScheduleInfo.match_bottom_info);
            this.k = sportScheduleInfo.msg_url;
            this.l = str;
            this.f66145b.setOnClickListener(this.m);
        }
    }
}
