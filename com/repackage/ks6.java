package com.repackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.repackage.cs6;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ks6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements TTFeedAd.VideoAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs6.j a;

        public a(cs6.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onProgressUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.a.a(j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdComplete(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdPaused(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, tTFeedAd) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoError(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
        public void onVideoLoad(TTFeedAd tTFeedAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, tTFeedAd) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-232417115, "Lcom/repackage/ks6$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-232417115, "Lcom/repackage/ks6$b;");
                    return;
                }
            }
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void A(FunNativeAd funNativeAd, int i, cs6.j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65536, null, funNativeAd, i, jVar) == null) && i == 3) {
            Object obj = funNativeAd.getChannelNativeAds().csjNative;
            if (obj instanceof TTFeedAd) {
                ((TTFeedAd) obj).setVideoAdListener(new a(jVar));
            }
        }
    }

    public static void B(ImageView imageView, FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, imageView, funNativeAd) == null) || funNativeAd == null) {
            return;
        }
        ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
        if (channelNativeAds == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (channelNativeAds.gdtNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807c1, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (channelNativeAds.ksNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807c2, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else if (channelNativeAds.csjNative != null) {
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807c0, WebPManager.ResourceStateType.NORMAL);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static boolean C(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, funNativeAd)) == null) ? (funNativeAd == null || funNativeAd.getChannelNativeAds() == null || funNativeAd.getChannelNativeAds().gdtNative == null) ? false : true : invokeL.booleanValue;
    }

    public static void D(int i, String str, String str2, uk8 uk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), str, str2, uk8Var}) == null) || uk8Var == null || uk8Var.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) uk8Var.d();
        List<String> imageUrls = funNativeAd.getImageUrls();
        FunAdRecordHttpMessage.uploadShowOrClickRecord(str, str2, String.valueOf(i), uk8Var.e(), uk8Var.c(), funNativeAd.getTitle(), funNativeAd.getDescription(), imageUrls == null ? null : imageUrls.toString(), j(funNativeAd), String.valueOf(n(funNativeAd)));
    }

    public static void a(StatisticItem statisticItem, uk8 uk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, statisticItem, uk8Var) == null) || statisticItem == null || uk8Var == null || uk8Var.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) uk8Var.d();
        statisticItem.param("tid", uk8Var.e());
        statisticItem.param("fid", uk8Var.c());
        statisticItem.param(TiebaStatic.Params.AD_TYPE, n(funNativeAd));
        statisticItem.param(TiebaStatic.Params.AD_TITLE, funNativeAd.getTitle());
        statisticItem.param(TiebaStatic.Params.AD_DESC, funNativeAd.getDescription());
        statisticItem.param(TiebaStatic.Params.AD_SOURCE, j(funNativeAd));
        List<String> imageUrls = funNativeAd.getImageUrls();
        if (imageUrls != null) {
            statisticItem.param("ad_pic", imageUrls.toString());
        }
    }

    public static int b(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, funNativeAd)) == null) {
            int i = b.a[funNativeAd.getInteractionType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 1 : 4;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static String c(FunNativeAd funNativeAd, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, funNativeAd, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && (funNativeAd.getChannelNativeAds().csjNative instanceof TTNativeAd)) {
                        return ((TTNativeAd) funNativeAd.getChannelNativeAds().csjNative).getTitle();
                    }
                } else if (funNativeAd.getChannelNativeAds().ksNative instanceof KsNativeAd) {
                    if (ni.isEmpty(((KsNativeAd) funNativeAd.getChannelNativeAds().ksNative).getAppIconUrl())) {
                        return ((KsNativeAd) funNativeAd.getChannelNativeAds().ksNative).getProductName();
                    }
                    return ((KsNativeAd) funNativeAd.getChannelNativeAds().ksNative).getAppName();
                }
            } else if (funNativeAd.getChannelNativeAds().gdtNative instanceof NativeUnifiedADData) {
                return ((NativeUnifiedADData) funNativeAd.getChannelNativeAds().gdtNative).getTitle();
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static String d(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, funNativeAd)) == null) {
            ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
            if (channelNativeAds == null) {
                return TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f00a8);
            }
            Object obj = channelNativeAds.ksNative;
            if (obj instanceof KsNativeAd) {
                return ((KsNativeAd) obj).getActionDescription();
            }
            int i = b.a[funNativeAd.getInteractionType().ordinal()];
            int i2 = R.string.obfuscated_res_0x7f0f00a9;
            int i3 = R.string.obfuscated_res_0x7f0f00ab;
            int i4 = i != 1 ? i != 2 ? R.string.obfuscated_res_0x7f0f00a9 : R.string.obfuscated_res_0x7f0f00aa : R.string.obfuscated_res_0x7f0f00ab;
            Object obj2 = channelNativeAds.gdtNative;
            if (!(obj2 instanceof NativeUnifiedADData) || !((NativeUnifiedADData) obj2).isAppAd()) {
                i3 = i4;
            }
            if (i3 != 0) {
                i2 = i3;
            }
            return TbadkCoreApplication.getInst().getContext().getString(i2);
        }
        return (String) invokeL.objValue;
    }

    public static String e(@NonNull FunNativeAd funNativeAd, @NonNull Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, funNativeAd, context)) == null) {
            ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
            int i = R.string.obfuscated_res_0x7f0f00a8;
            if (channelNativeAds == null) {
                return context.getString(R.string.obfuscated_res_0x7f0f00a8);
            }
            Object obj = channelNativeAds.ksNative;
            if (obj instanceof KsNativeAd) {
                return ((KsNativeAd) obj).getActionDescription();
            }
            int i2 = b.a[funNativeAd.getInteractionType().ordinal()];
            int i3 = R.string.obfuscated_res_0x7f0f00ab;
            int i4 = i2 != 1 ? i2 != 2 ? R.string.obfuscated_res_0x7f0f00a8 : R.string.obfuscated_res_0x7f0f00aa : R.string.obfuscated_res_0x7f0f00ab;
            Object obj2 = channelNativeAds.gdtNative;
            if (!(obj2 instanceof NativeUnifiedADData) || !((NativeUnifiedADData) obj2).isAppAd()) {
                i3 = i4;
            }
            if (i3 != 0) {
                i = i3;
            }
            return context.getString(i);
        }
        return (String) invokeLL.objValue;
    }

    public static int f(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, funNativeAd)) == null) {
            if (funNativeAd == null || funNativeAd.getChannelNativeAds() == null || !(funNativeAd.getChannelNativeAds().csjNative instanceof TTNativeAd) || (tTNativeAd = (TTNativeAd) funNativeAd.getChannelNativeAds().csjNative) == null) {
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

    public static String g(FunNativeAd funNativeAd, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, funNativeAd, i)) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && (funNativeAd.getChannelNativeAds().csjNative instanceof TTNativeAd)) {
                        return ((TTNativeAd) funNativeAd.getChannelNativeAds().csjNative).getDescription();
                    }
                } else if (funNativeAd.getChannelNativeAds().ksNative instanceof KsNativeAd) {
                    return ((KsNativeAd) funNativeAd.getChannelNativeAds().ksNative).getAdDescription();
                }
            } else if (funNativeAd.getChannelNativeAds().gdtNative instanceof NativeUnifiedADData) {
                return ((NativeUnifiedADData) funNativeAd.getChannelNativeAds().gdtNative).getDesc();
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static int h(@DimenRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) ? oi.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    public static int i(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds channelNativeAds;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, funNativeAd)) == null) {
            if (funNativeAd == null || (channelNativeAds = funNativeAd.getChannelNativeAds()) == null) {
                return -1;
            }
            if (channelNativeAds.gdtNative != null) {
                return 1;
            }
            if (channelNativeAds.ksNative != null) {
                return 2;
            }
            return channelNativeAds.csjNative != null ? 3 : -1;
        }
        return invokeL.intValue;
    }

    public static String j(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds channelNativeAds;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, funNativeAd)) == null) ? (funNativeAd == null || (channelNativeAds = funNativeAd.getChannelNativeAds()) == null) ? "" : channelNativeAds.gdtNative != null ? FunAdSdk.PLATFORM_GDT : channelNativeAds.ksNative != null ? FunAdSdk.PLATFORM_KS : channelNativeAds.csjNative != null ? "cjs" : "" : (String) invokeL.objValue;
    }

    public static int k(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        KsImage ksImage;
        TTNativeAd tTNativeAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, funNativeAd)) == null) {
            if (funNativeAd != null && funNativeAd.getChannelNativeAds() != null) {
                int i = i(funNativeAd);
                if (i == 1) {
                    NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) funNativeAd.getChannelNativeAds().gdtNative;
                    if (nativeUnifiedADData != null) {
                        return funNativeAd.getVideoView() != null ? nativeUnifiedADData.getPictureWidth() > nativeUnifiedADData.getPictureHeight() ? 5 : 6 : nativeUnifiedADData.getPictureWidth() > nativeUnifiedADData.getPictureHeight() ? 0 : 4;
                    }
                } else if (i != 2) {
                    if (i == 3 && (tTNativeAd = (TTNativeAd) funNativeAd.getChannelNativeAds().csjNative) != null) {
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
                    return -1;
                } else {
                    KsNativeAd ksNativeAd = (KsNativeAd) funNativeAd.getChannelNativeAds().ksNative;
                    if (ksNativeAd == null) {
                        return -1;
                    }
                    if (funNativeAd.getVideoView() != null) {
                        return ksNativeAd.getVideoWidth() > ksNativeAd.getVideoHeight() ? 5 : 6;
                    }
                    List<KsImage> imageList = ksNativeAd.getImageList();
                    if (!ListUtils.isEmpty(imageList) && (ksImage = (KsImage) ListUtils.getItem(imageList, 0)) != null) {
                        return ksImage.getWidth() > ksImage.getHeight() ? 0 : 4;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String l(FunNativeAd funNativeAd, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, funNativeAd, i)) == null) {
            if (i != 1) {
                if (i == 2) {
                    return ((funNativeAd.getChannelNativeAds().ksNative instanceof KsNativeAd) && !ni.isEmpty(((KsNativeAd) funNativeAd.getChannelNativeAds().ksNative).getAppIconUrl())) ? ((KsNativeAd) funNativeAd.getChannelNativeAds().ksNative).getAppIconUrl() : "";
                } else if (i == 3 && (funNativeAd.getChannelNativeAds().csjNative instanceof TTNativeAd)) {
                    return ((TTNativeAd) funNativeAd.getChannelNativeAds().csjNative).getIcon().getImageUrl();
                }
            } else if (funNativeAd.getChannelNativeAds().gdtNative instanceof NativeUnifiedADData) {
                return ((NativeUnifiedADData) funNativeAd.getChannelNativeAds().gdtNative).getIconUrl();
            }
            return "";
        }
        return (String) invokeLI.objValue;
    }

    public static int m(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, funNativeAd)) == null) ? (funNativeAd == null || funNativeAd.getVideoView() == null) ? 1 : 2 : invokeL.intValue;
    }

    public static int n(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, funNativeAd)) == null) {
            if (funNativeAd != null && funNativeAd.getChannelNativeAds() != null) {
                ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
                if (channelNativeAds.gdtNative != null) {
                    return m(funNativeAd);
                }
                if (channelNativeAds.ksNative != null) {
                    return m(funNativeAd);
                }
                if (channelNativeAds.csjNative != null) {
                    return f(funNativeAd);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean o(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        ChannelNativeAds channelNativeAds;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, funNativeAd)) == null) {
            if (funNativeAd != null && (channelNativeAds = funNativeAd.getChannelNativeAds()) != null && channelNativeAds.gdtNative == null && channelNativeAds.csjNative == null) {
                Object obj = channelNativeAds.ksNative;
                if (obj instanceof KsNativeAd) {
                    return !TextUtils.isEmpty(((KsNativeAd) obj).getAppIconUrl());
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean p(FunNativeAd funNativeAd, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, funNativeAd, list)) == null) {
            return (ListUtils.getCount(list) == 1) && k(funNativeAd) == 2;
        }
        return invokeLL.booleanValue;
    }

    public static boolean q(FunNativeAd funNativeAd, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, funNativeAd, list)) == null) {
            return (ListUtils.getCount(list) == 1) && k(funNativeAd) == 4;
        }
        return invokeLL.booleanValue;
    }

    public static boolean r(FunNativeAd funNativeAd) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, funNativeAd)) == null) {
            return (funNativeAd.getVideoView() != null) && k(funNativeAd) == 6;
        }
        return invokeL.booleanValue;
    }

    public static void s(FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, funNativeAd) == null) || !vm4.h() || funNativeAd == null || funNativeAd.getChannelNativeAds() == null) {
            return;
        }
        ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
        Log.e(LogPrinter.TAG, "===== Show Fun Ad Type START ===== ");
        Log.e(LogPrinter.TAG, "isDownloadAd = " + funNativeAd.getInteractionType().name());
        Log.e(LogPrinter.TAG, "csjNative = " + channelNativeAds.csjNative);
        Log.e(LogPrinter.TAG, "ksNative = " + channelNativeAds.ksNative);
        Log.e(LogPrinter.TAG, "gdtNative = " + channelNativeAds.gdtNative);
        Log.e(LogPrinter.TAG, "jyNative = " + channelNativeAds.jyNative);
        Log.e(LogPrinter.TAG, "imageurls = " + funNativeAd.getImageUrls());
        Log.e(LogPrinter.TAG, "videoView = " + funNativeAd.getVideoView());
        Log.e(LogPrinter.TAG, "interactionType = " + funNativeAd.getInteractionType().name());
        Log.e(LogPrinter.TAG, "description = " + funNativeAd.getDescription());
        Log.e(LogPrinter.TAG, "iconUrl = " + funNativeAd.getIconUrl());
        Log.e(LogPrinter.TAG, "title = " + funNativeAd.getTitle());
        Object obj = channelNativeAds.csjNative;
        if (obj instanceof TTNativeAd) {
            TTNativeAd tTNativeAd = (TTNativeAd) obj;
            Log.e(LogPrinter.TAG, "title=" + tTNativeAd.getTitle());
            Log.e(LogPrinter.TAG, "Description=" + tTNativeAd.getDescription());
            Log.e(LogPrinter.TAG, "AppScore=" + tTNativeAd.getAppScore());
            Log.e(LogPrinter.TAG, "Source=" + tTNativeAd.getSource());
            Log.e(LogPrinter.TAG, "AppSize=" + tTNativeAd.getAppSize());
        } else {
            Object obj2 = channelNativeAds.ksNative;
            if (obj2 instanceof KsNativeAd) {
                KsNativeAd ksNativeAd = (KsNativeAd) obj2;
                Log.e(LogPrinter.TAG, "AdSourc=" + ksNativeAd.getAdSource());
                Log.e(LogPrinter.TAG, "AppName=" + ksNativeAd.getAppName());
                Log.e(LogPrinter.TAG, "AppScore=" + ksNativeAd.getAppScore());
                Log.e(LogPrinter.TAG, "AppVersion=" + ksNativeAd.getAppVersion());
                Log.e(LogPrinter.TAG, "AppDownloadCountDes=" + ksNativeAd.getAppDownloadCountDes());
                Log.e(LogPrinter.TAG, "CorporationName=" + ksNativeAd.getCorporationName());
                Log.e(LogPrinter.TAG, "PermissionInfo=" + ksNativeAd.getPermissionInfo());
                Log.e(LogPrinter.TAG, "getAppPrivacyUrl=" + ksNativeAd.getAppPrivacyUrl());
                Log.e(LogPrinter.TAG, "getActionDescription=" + ksNativeAd.getActionDescription());
                Log.e(LogPrinter.TAG, "getAdDescription=" + ksNativeAd.getAdDescription());
                List<KsImage> imageList = ksNativeAd.getImageList();
                if (imageList != null) {
                    for (KsImage ksImage : imageList) {
                        PrintStream printStream = System.out;
                        printStream.println("Test=>ksImage: height=" + ksImage.getHeight() + " width=" + ksImage.getWidth());
                    }
                }
                PrintStream printStream2 = System.out;
                printStream2.println("Test=>ksVideo[1]: height=" + ksNativeAd.getVideoHeight() + " width=" + ksNativeAd.getVideoWidth());
                if (ksNativeAd.getVideoCoverImage() != null) {
                    PrintStream printStream3 = System.out;
                    printStream3.println("Test=>ksVideo[2]: height=" + ksNativeAd.getVideoCoverImage().getHeight() + " width=" + ksNativeAd.getVideoCoverImage().getWidth());
                }
            } else {
                Object obj3 = channelNativeAds.gdtNative;
                if (obj3 instanceof NativeUnifiedADData) {
                    NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) obj3;
                    Log.e(LogPrinter.TAG, "CTAText=" + nativeUnifiedADData.getCTAText());
                    Log.e(LogPrinter.TAG, "Title=" + nativeUnifiedADData.getTitle());
                    Log.e(LogPrinter.TAG, "AppScore=" + nativeUnifiedADData.getAppScore());
                    Log.e(LogPrinter.TAG, "DownloadCount=" + nativeUnifiedADData.getDownloadCount());
                    Log.e(LogPrinter.TAG, "ECPM=" + nativeUnifiedADData.getECPM());
                    Log.e(LogPrinter.TAG, "isAppAd=" + nativeUnifiedADData.isAppAd());
                    List<String> imgList = nativeUnifiedADData.getImgList();
                    if (imgList != null) {
                        Iterator<String> it = imgList.iterator();
                        while (it.hasNext()) {
                            PrintStream printStream4 = System.out;
                            printStream4.println("Test=>gdtImage: image=" + it.next());
                        }
                    }
                    PrintStream printStream5 = System.out;
                    printStream5.println("Test=>gdtImage: height=" + nativeUnifiedADData.getPictureHeight() + " width=" + nativeUnifiedADData.getPictureWidth());
                }
            }
        }
        View videoView = funNativeAd.getVideoView();
        if (videoView != null) {
            PrintStream printStream6 = System.out;
            printStream6.println("Test=>mediaView: width=" + videoView.getWidth() + " height=" + videoView.getHeight());
        }
        Log.e(LogPrinter.TAG, "===== Show Fun Ad Type END =====\n\n");
    }

    public static void t(FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, funNativeAd) == null) && i(funNativeAd) == 3 && (funNativeAd.getChannelNativeAds().csjNative instanceof TTDrawFeedAd)) {
            TTDrawFeedAd tTDrawFeedAd = (TTDrawFeedAd) funNativeAd.getChannelNativeAds().csjNative;
            tTDrawFeedAd.setCanInterruptVideoPlay(true);
            tTDrawFeedAd.setPauseIcon(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getResources(), R.drawable.obfuscated_res_0x7f0809e4), 67);
        }
    }

    public static void u(FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, funNativeAd) == null) || funNativeAd == null || funNativeAd.getChannelNativeAds() == null || !(funNativeAd.getChannelNativeAds().gdtNative instanceof NativeUnifiedADData)) {
            return;
        }
        ((NativeUnifiedADData) funNativeAd.getChannelNativeAds().gdtNative).setVideoMute(false);
    }

    public static void v(ImageView imageView, FunNativeAd funNativeAd) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, null, imageView, funNativeAd) == null) || funNativeAd == null || imageView == null) {
            return;
        }
        ChannelNativeAds channelNativeAds = funNativeAd.getChannelNativeAds();
        if (channelNativeAds == null) {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else if (channelNativeAds.gdtNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807be, WebPManager.ResourceStateType.NORMAL);
        } else if (channelNativeAds.ksNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807bf, WebPManager.ResourceStateType.NORMAL);
        } else if (channelNativeAds.csjNative != null) {
            imageView.setVisibility(0);
            WebPManager.setMaskDrawable(imageView, R.drawable.obfuscated_res_0x7f0807bd, WebPManager.ResourceStateType.NORMAL);
        } else {
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        }
    }

    public static void w(View view2, boolean z) {
        int i;
        int h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65562, null, view2, z) == null) || view2 == null || view2.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i = h(R.dimen.tbds447);
            h = h(R.dimen.tbds796);
        } else {
            i = -1;
            h = h(R.dimen.tbds504);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.topMargin = h(R.dimen.M_H_X004);
        if (layoutParams.width == i && layoutParams.height == h) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = h;
        view2.setLayoutParams(layoutParams);
    }

    public static void x(View view2, boolean z, List<String> list) {
        int i;
        int h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{view2, Boolean.valueOf(z), list}) == null) || view2 == null || view2.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i = h(R.dimen.tbds515);
            h = h(R.dimen.tbds915);
        } else {
            i = -1;
            h = h(ListUtils.getCount(list) == 1 ? R.dimen.tbds551 : R.dimen.tbds213);
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams.width == i && layoutParams.height == h) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = h;
        view2.setLayoutParams(layoutParams);
    }

    public static void y(View view2, boolean z) {
        int h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65564, null, view2, z) == null) || view2 == null || view2.getLayoutParams() == null) {
            return;
        }
        if (z) {
            h = h(R.dimen.tbds33);
        } else {
            h = h(R.dimen.tbds25);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.topMargin = h;
        layoutParams.bottomMargin = 0;
        view2.setLayoutParams(layoutParams);
    }

    public static void z(View view2, boolean z) {
        int i;
        int h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65565, null, view2, z) == null) || view2 == null || view2.getLayoutParams() == null) {
            return;
        }
        if (z) {
            i = h(R.dimen.tbds515);
            h = h(R.dimen.tbds915);
        } else {
            i = -1;
            h = h(R.dimen.tbds551);
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams.width == i && layoutParams.height == h) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = h;
        view2.setLayoutParams(layoutParams);
    }
}
