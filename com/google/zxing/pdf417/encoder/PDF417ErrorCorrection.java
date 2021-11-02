package com.google.zxing.pdf417.encoder;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.AutoScrollHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.apollon.a;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.searchbox.live.interfaces.player.VideoInfoConstants;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.ar.core.InstallActivity;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public final class PDF417ErrorCorrection {
    public static /* synthetic */ Interceptable $ic;
    public static final int[][] EC_COEFFICIENTS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(898117840, "Lcom/google/zxing/pdf417/encoder/PDF417ErrorCorrection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(898117840, "Lcom/google/zxing/pdf417/encoder/PDF417ErrorCorrection;");
                return;
            }
        }
        EC_COEFFICIENTS = new int[][]{new int[]{27, CyberPlayerManager.MEDIA_INFO_DNS_BEGIN}, new int[]{PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, TTAdConstant.STYLE_SIZE_RADIO_9_16, 232, 755, 599, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 801, 132, QRScanCodeActivity.DIALOG_COLLECTION_CODE_TIP, 116, 442, 428, QRScanCodeActivity.DIALOG_COLLECTION_CODE_TIP, 42, Opcodes.ARETURN, 65}, new int[]{SDKLogTypeConstants.DZZB_ALERTDIALOG_NEGATIVE_CLICKED, 575, 922, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, Opcodes.ARETURN, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, PayBeanFactory.BEAN_ID_CREDIT_PAY, 147, 593, 800, 571, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, HttpStatus.SC_UNPROCESSABLE_ENTITY, 6, 93, 862, BankSignFactory.BEAN_ID_BIND_CARD, 453, 106, 610, 287, 107, 505, 733, 877, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 612, 723, 476, 462, 172, SDKLogTypeConstants.TYPE_LP_DOWNLOAD, 609, 858, 822, 543, 376, 511, 400, 672, 762, 283, Opcodes.INVOKESTATIC, 440, 35, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, 31, 460, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 225, 535, 517, VideoInfoConstants.VIDEO_MPD_VID, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, InstallActivity.BOX_SIZE_DP, BankSignFactory.BEAN_ID_BIND_CARD, 840, 629, 4, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 843, 623, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, 928, 244, 583, 620, 246, Opcodes.LCMP, 447, 631, 292, CyberPlayerManager.MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_SPEED_SLOW, 490, SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, 516, 258, 457, 907, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 723, 674, 292, AuthorityState.STATE_INIT_ING, 96, 684, 432, 686, PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, SDKLogTypeConstants.TYPE_JMY_ACTION, 463, 646, 776, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, PlayerEvent.PLAY_LOADING_END, 380, 602, 754, 336, 89, 614, 87, 432, 670, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 157, 374, BaseActivity.DIALOG_LOADING, 726, 600, 269, 375, 898, 845, 454, VideoInfoConstants.VIDEO_PREFERRED_CLARITY_RANK, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 550, 86, 801, 4, 108, 539}, new int[]{PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 894, 75, 766, 882, 857, 74, 204, 82, 586, SDKLogTypeConstants.SEND_AD_CARD_TYPE, 250, 905, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, InstallActivity.BOX_SIZE_DP, 201, InstallActivity.BOX_SIZE_DP, AiAppGuideActivity.GIF_HEIGHT, 757, SDKLogTypeConstants.TYPE_FOR_XUZHANG, 814, CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN, 89, 68, 569, 11, 204, 796, 605, RecordConstants.DEFAULT_PREVIEW_WIDTH, 913, 801, 700, 799, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 439, SDKLogTypeConstants.TYPE_RSPLASH_HTML_LOG, 592, 668, VideoInfoConstants.VIDEO_RESOURCE_TYPE, 859, 370, 694, PullToRefreshBase.SMOOTH_SCROLL_LONG_DURATION_MS, 240, JfifUtil.MARKER_SOI, 257, 284, 549, 209, 884, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG, SDKLogTypeConstants.TYPE_JMY_ACTION, 19, 358, 399, CyberPlayerManager.MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_SPEED_SLOW, 103, 511, 51, 8, 517, 225, QRScanCodeActivity.DIALOG_TXT_COPY, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 637, 731, 66, 255, CyberPlayerManager.MEDIA_INFO_DNS_BEGIN, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, QRScanCodeActivity.DIALOG_CHECK_SAFE, 743, Opcodes.IFNONNULL, 655, 903, 329, 49, 802, 580, 355, 588, Opcodes.NEWARRAY, 462, 10, 134, 628, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 479, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 739, 71, PayBeanFactory.BEAN_ID_CREDIT_PAY, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, Opcodes.RETURN, 752, ResponseCode.TFE_IMMGR_PERMISSION_DENIED, 640, 455, 193, 689, SDKLogTypeConstants.GAME_ID_ALL, 805, 641, 48, 60, 732, 621, 895, RecordConstants.VIDEO_CONSTANT_WIDTH_OLD, PlayerEvent.PLAY_LOADING_START, 852, 655, 309, 697, 755, 756, 60, 231, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, 434, 421, 726, SDKLogTypeConstants.TYPE_DOWNLOAD_COMPLETED_ACTION, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, InstallActivity.BOX_SIZE_DP, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, SDKLogTypeConstants.SPLASH_VIDEO_MONITOR, 228, 749, AiAppGuideActivity.GIF_WIDTH, 213, 54, 297, 134, 54, 834, 299, 922, 191, CyberPlayerManager.MEDIA_INFO_PROCESS, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, GDiffPatcher.COPY_USHORT_INT, 688, 95, 497, 555, 642, 543, 307, Opcodes.IF_ICMPEQ, 924, 558, 648, 55, 497, 10}, new int[]{VideoInfoConstants.VIDEO_MPD_VID, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, DownloadConstants.STATUS_FILE_ERROR, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 265, CyberPlayerManager.MEDIA_INFO_CONNECT_END, a.f35825e, 914, 299, 229, 643, QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY, 871, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 88, 87, 193, VideoInfoConstants.VIDEO_MPD_VID, 781, 846, 75, 327, UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD, 435, 543, 203, TTAdConstant.STYLE_SIZE_RADIO_2_3, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, QRScanCodeActivity.DIALOG_CHECK_SAFE, 632, 545, 37, 858, 916, SDKLogTypeConstants.TYPE_ASL_DELAY_APO, 41, 542, QRScanCodeActivity.DIALOG_TXT_COPY, 122, AuthorityState.STATE_INIT_ING, SDKLogTypeConstants.SPLASH_VIDEO_MONITOR, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, QRScanCodeActivity.DIALOG_CHECK_SAFE, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, UIMsg.m_AppUI.MSG_COMPASS_DISPLAY, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 786, 303, 570, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 415, 641, 156, 237, Opcodes.DCMPL, StatusCodeException.IGNORE_429_CODE, 531, 207, 676, SDKLogTypeConstants.TYPE_FOR_XUZHANG, 89, 168, 304, 402, 40, SDKLogTypeConstants.SEND_AD_CARD_TYPE, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, SDKLogTypeConstants.GAME_ID_ALL, 94, 8, 494, 114, 521, 2, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, 851, 543, 152, 729, BankSignFactory.BEAN_ID_BIND_CARD, 95, GDiffPatcher.DATA_INT, SDKLogTypeConstants.DZZB_ALERTDIALOG_NEGATIVE_CLICKED, 578, 323, 856, 797, QRScanCodeActivity.DIALOG_TXT_COPY, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, SDKLogTypeConstants.TYPE_ASL_DELAY_APO, 43, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, 119, 662, 777, 475, 850, 764, SDKLogTypeConstants.TYPE_FEED_CLICK, 578, 911, 283, SDKLogTypeConstants.TYPE_INSTALL_WAKE_UP, 472, HttpStatus.SC_METHOD_FAILURE, 245, 288, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 394, 511, 327, 589, 777, 699, 688, 43, 408, 842, SDKLogTypeConstants.SPLASH_VIDEO_MONITOR, 721, 521, CoolPraiseView.START_DELAY_TIME_MS, 644, SDKLogTypeConstants.TYPE_JMY_DIRECT_LAUNCH, 559, 62, 145, 873, 663, SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, Opcodes.IF_ICMPEQ, 672, 729, 624, 59, 193, HttpStatus.SC_EXPECTATION_FAILED, 158, 209, 563, 564, 343, 693, 109, 608, 563, SDKLogTypeConstants.TYPE_SYSTEM_SPP_LIST, Opcodes.PUTFIELD, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, 677, 310, GDiffPatcher.DATA_INT, VideoInfoConstants.VIDEO_RESOURCE_TYPE, SDKLogTypeConstants.SEND_AD_CARD_TYPE, 410, 579, 870, 617, 841, 632, 860, QRScanCodeActivity.DIALOG_TXT_COPY, 536, 35, 777, 618, 586, HttpStatus.SC_FAILED_DEPENDENCY, 833, 77, PayBeanFactory.BEAN_ID_CARD_ADD, 346, 269, 757, 632, 695, 751, 331, GDiffPatcher.DATA_USHORT, Opcodes.INVOKESTATIC, 45, BeanConstants.BEAN_ID_FOR_SPARE_INIT, 680, 18, 66, 407, SDKLogTypeConstants.TYPE_APO_SUCCESS, 54, DownloadConstants.STATUS_FILE_ERROR, 228, 613, 830, 922, 437, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, 644, 905, 789, HttpStatus.SC_METHOD_FAILURE, 305, 441, 207, 300, 892, 827, 141, 537, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 662, 513, 56, GDiffPatcher.COPY_INT_UBYTE, 341, BaseActivity.DIALOG_LOADING, 797, 838, 837, 720, 224, 307, 631, 61, 87, CoolPraiseView.START_DELAY_TIME_MS, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, SDKLogTypeConstants.TYPE_CRASH_SOURCE, JfifUtil.MARKER_SOI, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, a.f35825e, HttpStatus.SC_UNPROCESSABLE_ENTITY, 907, 817, Opcodes.NEW, 62, 16, SDKLogTypeConstants.TYPE_CRASH_SOURCE, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, VideoInfoConstants.VIDEO_RESOURCE_TYPE, 62, SDKLogTypeConstants.TYPE_APO_CLICK, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, HttpStatus.SC_FAILED_DEPENDENCY, BaseActivity.DIALOG_LOADING, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, RecordConstants.DEFAULT_PREVIEW_WIDTH, 316, 486, 721, 610, 46, 656, 447, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 433, 717, 45, 111, 20, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 284, 736, 138, 646, 411, 877, 669, 141, CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN, 45, 780, 407, 164, 332, 899, 165, 726, 600, PullToRefreshBase.SMOOTH_SCROLL_LONG_DURATION_MS, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, GDiffPatcher.COPY_USHORT_INT, SDKLogTypeConstants.TYPE_APO_CLICK, 304, 282, 738, 675, 410, SDKLogTypeConstants.TYPE_APO_WAKE_UP_MONITOR, 244, 31, 121, 303, PayBeanFactory.BEAN_ID_CREDIT_PAY}};
    }

    public PDF417ErrorCorrection() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String generateErrorCorrection(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, charSequence, i2)) == null) {
            int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i2);
            char[] cArr = new char[errorCorrectionCodewordCount];
            int length = charSequence.length();
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = errorCorrectionCodewordCount - 1;
                int charAt = (charSequence.charAt(i3) + cArr[i4]) % PDF417Common.NUMBER_OF_CODEWORDS;
                while (i4 > 0) {
                    cArr[i4] = (char) ((cArr[i4 - 1] + (929 - ((EC_COEFFICIENTS[i2][i4] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                    i4--;
                }
                cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i2][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
            }
            StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
            for (int i5 = errorCorrectionCodewordCount - 1; i5 >= 0; i5--) {
                if (cArr[i5] != 0) {
                    cArr[i5] = (char) (929 - cArr[i5]);
                }
                sb.append(cArr[i5]);
            }
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static int getErrorCorrectionCodewordCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 < 0 || i2 > 8) {
                throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
            }
            return 1 << (i2 + 1);
        }
        return invokeI.intValue;
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i2) throws WriterException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 > 0) {
                if (i2 <= 40) {
                    return 2;
                }
                if (i2 <= 160) {
                    return 3;
                }
                if (i2 <= 320) {
                    return 4;
                }
                if (i2 <= 863) {
                    return 5;
                }
                throw new WriterException("No recommendation possible");
            }
            throw new IllegalArgumentException("n must be > 0");
        }
        return invokeI.intValue;
    }
}
