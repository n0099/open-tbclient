package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String i;

    public fa5(zo zoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 2;
        this.b = "index";
        this.c = "index";
        this.d = "2001";
        this.e = 1;
        this.f = 1;
        this.g = 1;
        this.h = 3;
        this.i = "personalize_page";
        if (zoVar == null || zoVar.getListView() == null) {
            return;
        }
        String a = TbPageExtraHelper.findPageExtraByView(zoVar.getListView()).a();
        this.a = c(a);
        this.b = e(a);
        this.c = d(a);
        this.d = i(a);
        this.e = a(a);
        this.f = b(a);
        this.g = f(a);
        this.h = g(a);
        this.i = h(a);
        eb5.b("currentPageKey=" + a);
        eb5.b(toString());
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("a072".equals(str)) {
                return 10;
            }
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str)) {
                return 2;
            }
            if ("a005".equals(str)) {
                return 4;
            }
            if ("a007".equals(str)) {
                return 12;
            }
            if ("a038".equals(str)) {
                return 9;
            }
            if ("a066".equals(str)) {
                return 15;
            }
            if ("a067".equals(str)) {
                return 21;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 1;
            }
            if ("a011".equals(str)) {
                return 3;
            }
            if ("a068".equals(str)) {
                return 22;
            }
            return "a008".equals(str) ? 13 : 1;
        }
        return invokeL.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if ("a072".equals(str)) {
                return 10;
            }
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str)) {
                return 2;
            }
            if ("a005".equals(str)) {
                return 7;
            }
            if ("a007".equals(str)) {
                return 9;
            }
            if ("a038".equals(str)) {
                return 4;
            }
            if ("a066".equals(str)) {
                return 11;
            }
            if ("a067".equals(str)) {
                return 18;
            }
            if (!"a001".equals(str) && !"a002".equals(str)) {
                if ("a010".equals(str) || "a014".equals(str)) {
                    return 5;
                }
                if ("a011".equals(str)) {
                    return 3;
                }
                if ("a068".equals(str)) {
                    return 19;
                }
                if ("a008".equals(str)) {
                    return 10;
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return 3;
            }
            if ("a005".equals(str)) {
                return 20;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 2;
            }
            if ("a038".equals(str)) {
                return 1;
            }
            if ("a066".equals(str)) {
                return 18;
            }
            if ("a067".equals(str)) {
                return 19;
            }
            if ("a011".equals(str)) {
                return 4;
            }
            return ("a068".equals(str) || "a023".equals(str) || !"a024".equals(str)) ? 2 : 17;
        }
        return invokeL.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) ? "frs" : "a005".equals(str) ? "pb" : ("a007".equals(str) || "a001".equals(str) || "a002".equals(str)) ? "index" : "a038".equals(str) ? "concern_tab" : "a066".equals(str) ? ImageViewerConfig.FROM_GAME_VIDEO : "a067".equals(str) ? "video_tab" : "a011".equals(str) ? "profile" : "a068".equals(str) ? "14" : "a023".equals(str) ? "auto_midpage" : "index" : (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return "frs";
            }
            if ("a005".equals(str)) {
                return "pb";
            }
            if ("a038".equals(str)) {
                return ImageViewerConfig.FROM_CONCERN;
            }
            if ("a066".equals(str)) {
                return ImageViewerConfig.FROM_GAME_VIDEO;
            }
            if ("a067".equals(str)) {
                return "video_tab";
            }
            if ("a001".equals(str)) {
                return "index";
            }
            "a002".equals(str);
            return "index";
        }
        return (String) invokeL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return 2;
            }
            if ("a005".equals(str)) {
                return 4;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 1;
            }
            if ("a038".equals(str)) {
                return 9;
            }
            if ("a066".equals(str)) {
                return 12;
            }
            if ("a067".equals(str)) {
                return 16;
            }
            return "a011".equals(str) ? 8 : 1;
        }
        return invokeL.intValue;
    }

    public static int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return 1;
            }
            if ("a005".equals(str)) {
                return 2;
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return 3;
            }
            if ("a038".equals(str)) {
                return 4;
            }
            if ("a066".equals(str)) {
                return 9;
            }
            if ("a067".equals(str)) {
                return 10;
            }
            if ("a011".equals(str)) {
                return 6;
            }
            if ("a075".equals(str)) {
                return 12;
            }
            return "a076".equals(str) ? 13 : 3;
        }
        return invokeL.intValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return "frs_page";
            }
            if ("a001".equals(str) || "a002".equals(str)) {
                return "personalize_page";
            }
            if ("a011".equals(str)) {
                return "person_page";
            }
            if ("a038".equals(str)) {
                return "concern_page";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if ("a006".equals(str) || "a070".equals(str) || "a071".equals(str) || "a072".equals(str)) {
                return "2003";
            }
            if ("a005".equals(str)) {
                return "2002";
            }
            if ("a023".equals(str)) {
                return "2005";
            }
            if ("a001".equals(str)) {
                return "2001";
            }
            "a002".equals(str);
            return "2001";
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "AdapterSourceItem:【pbPageFromType=" + this.a + ",imageViewerFromType=" + this.b + ",videoLocationType=" + this.c + ",videoStageType=" + this.d + ",agreeLocate=" + this.e + ",disagreeLocate=" + this.f + ",pageFrom=" + this.g + ",shareReportFrom=" + this.h + ",stType=" + this.i + "】";
        }
        return (String) invokeV.objValue;
    }
}
