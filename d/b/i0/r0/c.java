package d.b.i0.r0;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes4.dex */
public class c {

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59724a;

        static {
            int[] iArr = new int[FunNativeAd.InteractionType.values().length];
            f59724a = iArr;
            try {
                iArr[FunNativeAd.InteractionType.TYPE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59724a[FunNativeAd.InteractionType.TYPE_DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f59724a[FunNativeAd.InteractionType.TYPE_BROWSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int a(FunNativeAd funNativeAd) {
        ChannelNativeAds_5 channelNativeAds_5;
        if (funNativeAd == null || (channelNativeAds_5 = funNativeAd.getChannelNativeAds_5()) == null) {
            return -1;
        }
        if (channelNativeAds_5.gdtNative != null) {
            return R.drawable.icon_mask_advertisement_guangdiantong_12;
        }
        if (channelNativeAds_5.ksNative != null) {
            return R.drawable.icon_mask_advertisement_kuaishou_12;
        }
        if (channelNativeAds_5.csjNative != null) {
            return R.drawable.icon_mask_advertisement_chuanshanjia_12;
        }
        return -1;
    }

    public static String b(@NonNull FunNativeAd funNativeAd, @NonNull Context context) {
        int i;
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        if (channelNativeAds_5 == null) {
            return context.getString(R.string.ad_interaction_type_browser);
        }
        KsNativeAd ksNativeAd = channelNativeAds_5.ksNative;
        if (ksNativeAd != null) {
            return ksNativeAd.getActionDescription();
        }
        int i2 = a.f59724a[funNativeAd.getInteractionType().ordinal()];
        if (i2 == 1) {
            i = R.string.ad_interaction_type_download;
        } else if (i2 != 2) {
            i = R.string.ad_interaction_type_browser;
        } else {
            i = R.string.ad_interaction_type_dial;
        }
        NativeUnifiedADData nativeUnifiedADData = channelNativeAds_5.gdtNative;
        if (nativeUnifiedADData != null && nativeUnifiedADData.isAppAd()) {
            i = R.string.ad_interaction_type_download;
        }
        if (i == 0) {
            i = R.string.ad_interaction_type_browser;
        }
        return context.getString(i);
    }

    public static boolean c(FunNativeAd funNativeAd) {
        ChannelNativeAds_5 channelNativeAds_5;
        KsNativeAd ksNativeAd;
        if (funNativeAd == null || (channelNativeAds_5 = funNativeAd.getChannelNativeAds_5()) == null || channelNativeAds_5.gdtNative != null || channelNativeAds_5.csjNative != null || (ksNativeAd = channelNativeAds_5.ksNative) == null) {
            return false;
        }
        return !TextUtils.isEmpty(ksNativeAd.getAppIconUrl());
    }

    public static boolean d(FunNativeAd funNativeAd) {
        ChannelNativeAds_5 channelNativeAds_5;
        if (funNativeAd == null || (channelNativeAds_5 = funNativeAd.getChannelNativeAds_5()) == null) {
            return false;
        }
        if (channelNativeAds_5.ksNative == null || funNativeAd.getInteractionType() != FunNativeAd.InteractionType.TYPE_DOWNLOAD) {
            TTNativeAd tTNativeAd = channelNativeAds_5.csjNative;
            if (tTNativeAd == null) {
                return false;
            }
            if (tTNativeAd.getAppSize() == 0 && channelNativeAds_5.csjNative.getAppScore() == 0) {
                return false;
            }
        }
        return true;
    }
}
