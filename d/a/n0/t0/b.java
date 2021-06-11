package d.a.n0.t0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import d.a.c.e.p.l;
import d.a.n0.e3.h0.n;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64528a;

        static {
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            f64528a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64528a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64528a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void a(StatisticItem statisticItem, n nVar) {
        if (statisticItem == null || nVar == null || nVar.d() == null) {
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
        int i2;
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        if (channelNativeAds_6 == null) {
            return context.getString(R.string.ad_interaction_type_browser);
        }
        KsNativeAd ksNativeAd = channelNativeAds_6.ksNative;
        if (ksNativeAd != null) {
            return ksNativeAd.getActionDescription();
        }
        int i3 = a.f64528a[funNativeAd.getInteractionType().ordinal()];
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

    public static int c(FunNativeAd funNativeAd) {
        TTNativeAd tTNativeAd;
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

    public static int d(@DimenRes int i2) {
        return l.g(TbadkCoreApplication.getInst(), i2);
    }

    public static int e(FunNativeAd funNativeAd) {
        ChannelNativeAds_6 channelNativeAds_6;
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

    public static String f(FunNativeAd funNativeAd) {
        ChannelNativeAds_6 channelNativeAds_6;
        return (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null) ? "" : channelNativeAds_6.gdtNative != null ? FunAdSdk.PLATFORM_GDT : channelNativeAds_6.ksNative != null ? FunAdSdk.PLATFORM_KS : channelNativeAds_6.csjNative != null ? "cjs" : "";
    }

    public static int g(FunNativeAd funNativeAd) {
        TTNativeAd tTNativeAd;
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

    public static int h(FunNativeAd funNativeAd) {
        return (funNativeAd == null || funNativeAd.getVideoView() == null) ? 1 : 2;
    }

    public static int i(FunNativeAd funNativeAd) {
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

    public static boolean j(FunNativeAd funNativeAd) {
        ChannelNativeAds_6 channelNativeAds_6;
        KsNativeAd ksNativeAd;
        if (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null || channelNativeAds_6.gdtNative != null || channelNativeAds_6.csjNative != null || (ksNativeAd = channelNativeAds_6.ksNative) == null) {
            return false;
        }
        return !TextUtils.isEmpty(ksNativeAd.getAppIconUrl());
    }

    public static boolean k(FunNativeAd funNativeAd, List<String> list) {
        return (ListUtils.getCount(list) == 1) && g(funNativeAd) == 2;
    }

    public static boolean l(FunNativeAd funNativeAd, List<String> list) {
        return (ListUtils.getCount(list) == 1) && g(funNativeAd) == 4;
    }

    public static boolean m(FunNativeAd funNativeAd) {
        return (funNativeAd.getVideoView() != null) && g(funNativeAd) == 6;
    }

    public static boolean n(FunNativeAd funNativeAd) {
        ChannelNativeAds_6 channelNativeAds_6;
        if (funNativeAd == null || (channelNativeAds_6 = funNativeAd.getChannelNativeAds_6()) == null) {
            return false;
        }
        if (channelNativeAds_6.ksNative == null || funNativeAd.getInteractionType() != FunNativeAd.InteractionType.TYPE_DOWNLOAD) {
            TTNativeAd tTNativeAd = channelNativeAds_6.csjNative;
            if (tTNativeAd == null) {
                return false;
            }
            if (tTNativeAd.getAppSize() == 0 && channelNativeAds_6.csjNative.getAppScore() == 0) {
                return false;
            }
        }
        return true;
    }

    public static void o(ImageView imageView, FunNativeAd funNativeAd) {
        if (funNativeAd == null || imageView == null) {
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

    public static void p(View view, boolean z, List<String> list) {
        int i2;
        int d2;
        if (view == null || view.getLayoutParams() == null) {
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

    public static void q(View view, boolean z) {
        int i2;
        int d2;
        if (view == null || view.getLayoutParams() == null) {
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

    public static void r(ImageView imageView, FunNativeAd funNativeAd) {
        if (funNativeAd == null) {
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

    public static void s(int i2, String str, String str2, n nVar) {
        if (nVar == null || nVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.d();
        List<String> imageUrls = funNativeAd.getImageUrls();
        FunAdRecordHttpMessage.uploadShowOrClickRecord(str, str2, String.valueOf(i2), nVar.e(), nVar.c(), funNativeAd.getTitle(), funNativeAd.getDescription(), imageUrls == null ? null : imageUrls.toString(), f(funNativeAd), String.valueOf(i(funNativeAd)));
    }
}
