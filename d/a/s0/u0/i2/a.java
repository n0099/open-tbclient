package d.a.s0.u0.i2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66134a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f66135b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f66136c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f66137d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66138e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f66139f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66140g;

    /* renamed from: h  reason: collision with root package name */
    public String f66141h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66142i;
    public final View.OnClickListener j;

    /* renamed from: d.a.s0.u0.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1717a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f66143e;

        public View$OnClickListenerC1717a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66143e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f66143e.f66135b) {
                    if (k.isEmpty(this.f66143e.f66141h) || this.f66143e.f66139f == null || this.f66143e.f66139f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f66143e.f66134a, new String[]{this.f66143e.f66141h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f66143e.f66139f.getForum().getId()).param("obj_type", this.f66143e.f66142i ? 2 : 1));
                } else if ((view != this.f66143e.f66137d && view != this.f66143e.f66138e) || this.f66143e.f66139f == null || this.f66143e.f66139f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f66143e.f66134a.getPageActivity(), this.f66143e.f66139f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f66143e.f66139f.getForum().getId()));
                }
            }
        }
    }

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
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
        this.j = new View$OnClickListenerC1717a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f66134a = frsSportsRecommendFragment.getPageContext();
        this.f66135b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f66136c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f66137d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f66138e = (TextView) view.findViewById(R.id.forum_name);
        this.f66135b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f66137d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f66137d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f66137d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f66137d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f66137d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f66138e, R.color.CAM_X0101);
            BarImageView barImageView = this.f66137d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.f66137d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.f66137d.setStrokeColorResId(R.color.CAM_X0201);
                this.f66137d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f66139f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 4) {
            themeElement = themeColorInfo.dark;
        } else if (skinType == 1) {
            themeElement = themeColorInfo.night;
        } else {
            themeElement = themeColorInfo.day;
        }
        if (this.f66140g) {
            return;
        }
        LinearGradientView linearGradientView = this.f66136c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f66136c.a(skinType);
        }
        TbImageView tbImageView = this.f66135b;
        if (tbImageView != null) {
            tbImageView.M(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f66139f = frsViewData;
        this.f66140g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f66138e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f66137d.M(this.f66139f.getForum().getImage_url(), 10, false);
        i();
        this.f66137d.setOnClickListener(this.j);
        this.f66138e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f66137d.refresh();
            if (k.isEmpty(str)) {
                this.f66140g = false;
                i();
                return;
            }
            this.f66140g = true;
            this.f66141h = str2;
            this.f66142i = z;
            this.f66135b.M(str, 10, false);
            this.f66135b.setOnClickListener(this.j);
        }
    }
}
