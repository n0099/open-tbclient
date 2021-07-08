package d.a.p0.w0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import d.a.c.e.p.l;
import d.a.p0.h3.h0.n;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f65705a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1658839704, "Ld/a/p0/w0/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1658839704, "Ld/a/p0/w0/b$a;");
                    return;
                }
            }
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            f65705a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f65705a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f65705a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void a(StatisticItem statisticItem, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, statisticItem, nVar) == null) || statisticItem == null || nVar == null || nVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.d();
        statisticItem.param("tid", nVar.e());
        statisticItem.param("fid", nVar.c());
        statisticItem.param(TiebaStatic.Params.AD_TYPE, i(funNativeAd));
        statisticItem.param(TiebaStatic.Params.AD_TITLE, funNativeAd.getTitle());
        statisticItem.param(TiebaStatic.Params.AD_DESC, funNativeAd.getDescription());
        statisticItem.param(TiebaStatic.Params.AD_SOURCE, f(funNativeAd));
        List<String> imageUrls = funNativeAd.getImageUrls();
        if (imageUrls != null) {
            statisticItem.param("ad_pic", imageUrls.toString());
        }
    }

    public static String b(@NonNull FunNativeAd funNativeAd, @NonNull Context context) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, funNativeAd, context)) == null) {
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            if (channelNativeAds_6 == null) {
                return context.getString(R.string.ad_interaction_type_browser);
            }
            KsNativeAd ksNativeAd = channelNativeAds_6.ksNative;
            if (ksNativeAd != null) {
                return ksNativeAd.getActionDescription();
            }
            int i3 = a.f65705a[funNativeAd.getInteractionType().ordinal()];
            if (i3 == 1) {
                i2 = R.string.ad_interaction_type_download;
            } else if (i3 != 2) {
                i2 = R.string.ad_interaction_type_browser;
            } else {
                i2 = R.string.ad_interaction_type_dial;
            }
            NativeUnifiedADData nativeUnifiedADData = channelNativeAds_6.gdtNative;
            if (nativeUnifiedADData != null && nativeUnifiedADData.isAppAd()) {
                i2 = R.string.ad_interaction_type_download;
            }
            if (i2 == 0) {
                i2 = R.string.ad_interaction_type_browser;
            }
            return context.getString(i2);
        }
        return (String) invokeLL.objValue;
    }

    public static int c(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null || (tTNativeAd = funNativeAd.getChannelNativeAds_6().csjNative) == null) {
                return 0;
            }
            if (tTNativeAd.getImageMode() == 2) {
                return 6;
            }
            if (tTNativeAd.getImageMode() == 3) {
                return 1;
            }
            if (tTNativeAd.getImageMode() == 4) {
                return 5;
            }
            if (tTNativeAd.getImageMode() == 5) {
                return 2;
            }
            if (tTNativeAd.getImageMode() == 15) {
                return 4;
            }
            return tTNativeAd.getImageMode() == 16 ? 3 : 0;
        }
        return invokeL.intValue;
    }

    public static int d(@DimenRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    public static int e(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds_6 channelNativeAds_6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, funNativeAd)) == null) {
            if (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null) {
                return -1;
            }
            if (channelNativeAds_6.gdtNative != null) {
                return 1;
            }
            if (channelNativeAds_6.ksNative != null) {
                return 2;
            }
            return channelNativeAds_6.csjNative != null ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static String f(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds_6 channelNativeAds_6;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, funNativeAd)) == null) ? (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null) ? "" : channelNativeAds_6.gdtNative != null ? FunAdSdk.PLATFORM_GDT : channelNativeAds_6.ksNative != null ? FunAdSdk.PLATFORM_KS : channelNativeAds_6.csjNative != null ? "cjs" : "" : (String) invokeL.objValue;
    }

    public static int g(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null || (tTNativeAd = funNativeAd.getChannelNativeAds_6().csjNative) == null) {
                return -1;
            }
            if (tTNativeAd.getImageMode() == 2) {
                return 2;
            }
            if (tTNativeAd.getImageMode() == 3) {
                return 3;
            }
            if (tTNativeAd.getImageMode() == 4) {
                return 1;
            }
            if (tTNativeAd.getImageMode() == 5) {
                return 5;
            }
            if (tTNativeAd.getImageMode() == 15) {
                return 6;
            }
            return tTNativeAd.getImageMode() == 16 ? 4 : 0;
        }
        return invokeL.intValue;
    }

    public static int h(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, funNativeAd)) == null) ? (funNativeAd == null || funNativeAd.getVideoView() == null) ? 1 : 2 : invokeL.intValue;
    }

    public static int i(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, funNativeAd)) == null) {
            if (funNativeAd != null && funNativeAd.getChannelNativeAds_6() != null) {
                ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
                if (channelNativeAds_6.gdtNative != null) {
                    return h(funNativeAd);
                }
                if (channelNativeAds_6.ksNative != null) {
                    return h(funNativeAd);
                }
                if (channelNativeAds_6.csjNative != null) {
                    return c(funNativeAd);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean j(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds_6 channelNativeAds_6;
        KsNativeAd ksNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, funNativeAd)) == null) {
            if (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null || channelNativeAds_6.gdtNative != null || channelNativeAds_6.csjNative != null || (ksNativeAd = channelNativeAds_6.ksNative) == null) {
                return false;
            }
            return !TextUtils.isEmpty(ksNativeAd.getAppIconUrl());
        }
        return invokeL.booleanValue;
    }

    public static boolean k(FunNativeAd funNativeAd, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, funNativeAd, list)) == null) {
            return (ListUtils.getCount(list) == 1) && g(funNativeAd) == 2;
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(FunNativeAd funNativeAd, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, funNativeAd, list)) == null) {
            return (ListUtils.getCount(list) == 1) && g(funNativeAd) == 4;
        }
        return invokeLL.booleanValue;
    }

    public static boolean m(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, funNativeAd)) == null) {
            return (funNativeAd.getVideoView() != null) && g(funNativeAd) == 6;
        }
        return invokeL.booleanValue;
    }

    public static void n(ImageView imageView, FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, null, imageView, funNativeAd) == null) || funNativeAd == null || imageView == null) {
            return;
        }
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        if (channelNativeAds_6 == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (channelNativeAds_6.gdtNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_ad_fun_logo_gdt, WebPManager.ResourceStateType.NORMAL);
        } else if (channelNativeAds_6.ksNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_ad_fun_logo_ks, WebPManager.ResourceStateType.NORMAL);
        } else if (channelNativeAds_6.csjNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_ad_fun_logo_csj, WebPManager.ResourceStateType.NORMAL);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static void o(View view, boolean z, List<String> list) {
        int i2;
        int d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{view, Boolean.valueOf(z), list}) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i2 = d(R.dimen.tbds650);
            d2 = d(R.dimen.tbds1154);
        } else {
            i2 = -1;
            d2 = d(ListUtils.getCount(list) == 1 ? R.dimen.tbds551 : R.dimen.tbds213);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width == i2 && layoutParams.height == d2) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = d2;
        view.setLayoutParams(layoutParams);
    }

    public static void p(View view, boolean z) {
        int i2;
        int d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65551, null, view, z) == null) || view == null || view.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i2 = d(R.dimen.tbds650);
            d2 = d(R.dimen.tbds1154);
        } else {
            i2 = -1;
            d2 = d(R.dimen.tbds551);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width == i2 && layoutParams.height == d2) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = d2;
        view.setLayoutParams(layoutParams);
    }

    public static void q(ImageView imageView, FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, imageView, funNativeAd) == null) || funNativeAd == null) {
            return;
        }
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        if (channelNativeAds_6 == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (channelNativeAds_6.gdtNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_advertisement_guangdiantong_12, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (channelNativeAds_6.ksNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_advertisement_kuaishou_12, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (channelNativeAds_6.csjNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.icon_mask_advertisement_chuanshanjia_12, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static void r(int i2, String str, String str2, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, str2, nVar}) == null) || nVar == null || nVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.d();
        List<String> imageUrls = funNativeAd.getImageUrls();
        FunAdRecordHttpMessage.uploadShowOrClickRecord(str, str2, String.valueOf(i2), nVar.e(), nVar.c(), funNativeAd.getTitle(), funNativeAd.getDescription(), imageUrls == null ? null : imageUrls.toString(), f(funNativeAd), String.valueOf(i(funNativeAd)));
    }
}
