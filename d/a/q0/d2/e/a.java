package d.a.q0.d2.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.q0.d2.c.b> f55463a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55463a = new ArrayList();
        a();
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            switch (i2) {
                case 1:
                    return R.drawable.ic_icon_mask_guide_game_svg;
                case 2:
                    return R.drawable.ic_icon_pure_module_life_svg;
                case 3:
                    return R.drawable.ic_icon_pure_module_comic_svg;
                case 4:
                    return R.drawable.ic_icon_pure_module_literatue_svg;
                case 5:
                    return R.drawable.ic_icon_pure_module_science_svg;
                case 6:
                    return R.drawable.ic_icon_mask_guide_game_svg;
                case 7:
                    return R.drawable.ic_icon_mask_guide_star_svg;
                case 8:
                    return R.drawable.ic_icon_mask_guide_motion_svg;
                case 9:
                    return R.drawable.ic_icon_mask_guide_sport_svg;
                case 10:
                    return R.drawable.ic_icon_mask_guide_tech_svg;
                case 11:
                    return R.drawable.ic_icon_mask_guide_movie_svg;
                case 12:
                    return R.drawable.ic_icon_mask_guide_education_svg;
                case 13:
                    return R.drawable.ic_icon_mask_guide_travel_svg;
                case 14:
                    return R.drawable.ic_icon_mask_guide_art_svg;
                case 15:
                    return R.drawable.ic_icon_mask_guide_social_svg;
                case 16:
                    return R.drawable.ic_icon_mask_guide_food_svg;
                case 17:
                    return R.drawable.ic_icon_mask_guide_current_svg;
                case 18:
                    return R.drawable.ic_icon_mask_guide_fasion_svg;
                case 19:
                    return R.drawable.ic_icon_mask_guide_funny_svg;
                case 20:
                    return R.drawable.ic_icon_mask_guide_car_svg;
                case 21:
                    return R.drawable.ic_icon_mask_guide_company_svg;
                default:
                    return -1;
            }
        }
        return invokeI.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f55463a.add(new d.a.q0.d2.c.b(1, "游戏", R.drawable.ic_icon_mask_guide_game_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(2, "生活", R.drawable.ic_icon_pure_module_life_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(3, "动漫", R.drawable.ic_icon_pure_module_comic_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(4, "文学", R.drawable.ic_icon_pure_module_literatue_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(5, "科学", R.drawable.ic_icon_pure_module_science_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(6, "动植物", R.drawable.ic_icon_mask_guide_leaf_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(7, "明星", R.drawable.ic_icon_mask_guide_star_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(8, "情感", R.drawable.ic_icon_mask_guide_motion_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(9, "体育", R.drawable.ic_icon_mask_guide_sport_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(10, "科技", R.drawable.ic_icon_mask_guide_tech_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(11, "影视", R.drawable.ic_icon_mask_guide_movie_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(12, "教育", R.drawable.ic_icon_mask_guide_education_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(13, "旅游", R.drawable.ic_icon_mask_guide_travel_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(14, "文化艺术", R.drawable.ic_icon_mask_guide_art_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(15, "社会", R.drawable.ic_icon_mask_guide_social_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(16, "美食", R.drawable.ic_icon_mask_guide_food_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(17, "实事", R.drawable.ic_icon_mask_guide_current_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(18, "时尚", R.drawable.ic_icon_mask_guide_fasion_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(19, "搞笑", R.drawable.ic_icon_mask_guide_funny_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(20, "汽车", R.drawable.ic_icon_mask_guide_car_svg, false));
            this.f55463a.add(new d.a.q0.d2.c.b(21, "企业", R.drawable.ic_icon_mask_guide_company_svg, false));
        }
    }

    public List<d.a.q0.d2.c.b> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f55463a : (List) invokeV.objValue;
    }
}
