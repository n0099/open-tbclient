package com.repackage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.refresh.LoadAnimStrategy;
import com.baidu.live.business.view.emotion.EmotionStrategy;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ab0 {
    public static /* synthetic */ Interceptable $ic;
    public static ab0 d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ua0 c;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final ab0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-534587259, "Lcom/repackage/ab0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-534587259, "Lcom/repackage/ab0$a;");
                    return;
                }
            }
            a = new ab0();
        }
    }

    public ab0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "day";
    }

    public static ab0 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                d = a.a;
            }
            return d;
        }
        return (ab0) invokeV.objValue;
    }

    public int a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        ua0 ua0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str2) || (ua0Var = this.c) == null) {
                return -16777216;
            }
            return ua0Var.a(context, str, str2);
        }
        return invokeLLL.intValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recEmptyImageRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().emptyImageRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().emptyImageRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().emptyImageRes2;
            }
            return EmotionStrategy.getInstance().emptyImageRes;
        }
        return invokeL.intValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recErrorImageRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().errorImageRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().errorImageRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().errorImageRes2;
            }
            return EmotionStrategy.getInstance().errorImageRes;
        }
        return invokeL.intValue;
    }

    public int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recNetworkImageRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().networkImageRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().networkImageRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().networkImageRes2;
            }
            return EmotionStrategy.getInstance().networkImageRes;
        }
        return invokeL.intValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? "recommend".equals(str) ? R.drawable.obfuscated_res_0x7f080d1b : (LiveFeedPageSdk.IMMERSION.equals(str) || LiveFeedPageSdk.VIDEO_BAR.equals(str)) ? R.drawable.obfuscated_res_0x7f080d1c : "night".equals(this.b) ? R.drawable.obfuscated_res_0x7f080d1d : "dark".equals(this.b) ? R.drawable.obfuscated_res_0x7f080d1c : R.drawable.obfuscated_res_0x7f080d1b : invokeL.intValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRecRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRes3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRes1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieRes2;
            }
            return LoadAnimStrategy.getInstance().loadMoreLottieRes;
        }
        return (String) invokeL.objValue;
    }

    public int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResRecId;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResId3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResId1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadMoreLottieResId2;
            }
            return LoadAnimStrategy.getInstance().loadMoreLottieResId;
        }
        return invokeL.intValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieRecRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieRes3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieRes1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieRes2;
            }
            return LoadAnimStrategy.getInstance().loadingLottieRes;
        }
        return (String) invokeL.objValue;
    }

    public int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieRecResId;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().loadingLottieResId3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieResId1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().loadingLottieResId2;
            }
            return LoadAnimStrategy.getInstance().loadingLottieResId;
        }
        return invokeL.intValue;
    }

    public int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (LiveFeedPageSdk.VIDEO_BAR.equals(str)) {
                return EmotionStrategy.getInstance().videoBarPlaceHolderRes;
            }
            if ("recommend".equals(str)) {
                return EmotionStrategy.getInstance().recPlaceHolderRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return EmotionStrategy.getInstance().placeHolderRes3;
            }
            if ("night".equals(this.b)) {
                return EmotionStrategy.getInstance().placeHolderRes1;
            }
            if ("dark".equals(this.b)) {
                return EmotionStrategy.getInstance().placeHolderRes2;
            }
            return EmotionStrategy.getInstance().placeHolderRes;
        }
        return invokeL.intValue;
    }

    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRecRes;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRes3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRes1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRes2;
            }
            return LoadAnimStrategy.getInstance().pullDownLottieRes;
        }
        return (String) invokeL.objValue;
    }

    public int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if ("recommend".equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieRecResId;
            }
            if (LiveFeedPageSdk.IMMERSION.equals(str)) {
                return LoadAnimStrategy.getInstance().pullDownLottieResId3;
            }
            if ("night".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieResId1;
            }
            if ("dark".equals(this.b)) {
                return LoadAnimStrategy.getInstance().pullDownLottieResId2;
            }
            return LoadAnimStrategy.getInstance().pullDownLottieResId;
        }
        return invokeL.intValue;
    }

    public GradientDrawable n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, str)) == null) {
            float b = m80.b(context, 18.0f);
            float[] fArr = {b, b, b, b, b, b, b, b};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(fArr);
            gradientDrawable.setColor(a(context, str, "color_btn_fill"));
            gradientDrawable.setStroke(1, a(context, str, "color_btn_stroke"));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeLL.objValue;
    }

    public int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? ("recommend".equals(str) || LiveFeedPageSdk.IMMERSION.equals(str)) ? R.drawable.obfuscated_res_0x7f080cce : "night".equals(this.b) ? R.drawable.obfuscated_res_0x7f080ccf : "dark".equals(this.b) ? R.drawable.obfuscated_res_0x7f080cce : R.drawable.obfuscated_res_0x7f080ccd : invokeL.intValue;
    }

    public int p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if ("recommend".equals(str) || LiveFeedPageSdk.IMMERSION.equals(str)) {
                return R.drawable.obfuscated_res_0x7f080cdf;
            }
            if ("night".equals(this.b)) {
                return R.drawable.obfuscated_res_0x7f080ce0;
            }
            if ("dark".equals(this.b)) {
            }
            return R.drawable.obfuscated_res_0x7f080cde;
        }
        return invokeL.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.a = str;
            if (s(str2)) {
                this.b = str2;
            }
            if ("baidu".equals(this.a)) {
                this.c = new ta0();
            } else if (LiveFeedPageSdk.HOST_HAOKAN.equals(this.a)) {
                this.c = new va0();
            } else if (LiveFeedPageSdk.HOST_QUANMIN.equals(this.a)) {
                this.c = new xa0();
            } else if ("tieba".equals(this.a)) {
                this.c = new za0();
            }
            this.c.b(str2);
        }
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? "day".equals(str) || "night".equals(str) || "dark".equals(str) : invokeL.booleanValue;
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, str) == null) && s(str)) {
            this.b = str;
            ua0 ua0Var = this.c;
            if (ua0Var != null) {
                ua0Var.b(str);
            }
        }
    }
}
