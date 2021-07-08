package d.a.p0.u0.i2;

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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62915a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f62916b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradientView f62917c;

    /* renamed from: d  reason: collision with root package name */
    public BarImageView f62918d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62919e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f62920f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62921g;

    /* renamed from: h  reason: collision with root package name */
    public String f62922h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62923i;
    public final View.OnClickListener j;

    /* renamed from: d.a.p0.u0.i2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1676a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f62924e;

        public View$OnClickListenerC1676a(a aVar) {
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
            this.f62924e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == this.f62924e.f62916b) {
                    if (k.isEmpty(this.f62924e.f62922h) || this.f62924e.f62920f == null || this.f62924e.f62920f.getForum() == null) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.f62924e.f62915a, new String[]{this.f62924e.f62922h}, true);
                    TiebaStatic.log(new StatisticItem("c13415").param("fid", this.f62924e.f62920f.getForum().getId()).param("obj_type", this.f62924e.f62923i ? 2 : 1));
                } else if ((view != this.f62924e.f62918d && view != this.f62924e.f62919e) || this.f62924e.f62920f == null || this.f62924e.f62920f.getForum() == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.f62924e.f62915a.getPageActivity(), this.f62924e.f62920f.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    TiebaStatic.log(new StatisticItem("c13416").param("fid", this.f62924e.f62920f.getForum().getId()));
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
        this.j = new View$OnClickListenerC1676a(this);
        if (frsSportsRecommendFragment == null || view == null) {
            return;
        }
        this.f62915a = frsSportsRecommendFragment.getPageContext();
        this.f62916b = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
        this.f62917c = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
        this.f62918d = (BarImageView) view.findViewById(R.id.frs_image);
        this.f62919e = (TextView) view.findViewById(R.id.forum_name);
        this.f62916b.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f62918d.setPageId(frsSportsRecommendFragment.getUniqueId());
        this.f62918d.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62918d.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
        this.f62918d.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.f62918d.setShowOval(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i();
            SkinManager.setViewTextColor(this.f62919e, R.color.CAM_X0101);
            BarImageView barImageView = this.f62918d;
            if (barImageView != null) {
                barImageView.setBorderWidth(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
                this.f62918d.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
                this.f62918d.setStrokeColorResId(R.color.CAM_X0201);
                this.f62918d.invalidate();
            }
        }
    }

    public final void i() {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (frsViewData = this.f62920f) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
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
        if (this.f62921g) {
            return;
        }
        LinearGradientView linearGradientView = this.f62917c;
        if (linearGradientView != null) {
            ThemeElement themeElement2 = themeColorInfo.day;
            String str = themeElement2.light_color;
            String str2 = themeElement2.dark_color;
            ThemeElement themeElement3 = themeColorInfo.night;
            String str3 = themeElement3.light_color;
            String str4 = themeElement3.dark_color;
            ThemeElement themeElement4 = themeColorInfo.dark;
            linearGradientView.setGradientColor(str, str2, str3, str4, themeElement4.light_color, themeElement4.dark_color);
            this.f62917c.a(skinType);
        }
        TbImageView tbImageView = this.f62916b;
        if (tbImageView != null) {
            tbImageView.M(themeElement.pattern_image, 10, false);
        }
    }

    public void j(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        this.f62920f = frsViewData;
        this.f62921g = false;
        String name = frsViewData.getForum().getName();
        if (StringHelper.getChineseAndEnglishLength(name) > 20) {
            name = StringHelper.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
        }
        this.f62919e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
        this.f62918d.M(this.f62920f.getForum().getImage_url(), 10, false);
        i();
        this.f62918d.setOnClickListener(this.j);
        this.f62919e.setOnClickListener(this.j);
    }

    public void k(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            this.f62918d.refresh();
            if (k.isEmpty(str)) {
                this.f62921g = false;
                i();
                return;
            }
            this.f62921g = true;
            this.f62922h = str2;
            this.f62923i = z;
            this.f62916b.M(str, 10, false);
            this.f62916b.setOnClickListener(this.j);
        }
    }
}
