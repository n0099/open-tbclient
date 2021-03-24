package com.google.zxing.pdf417.encoder;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.widget.AutoScrollHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mapapi.UIMsg;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.wallet.utils.ContactPermissionUtil;
import com.bytedance.sdk.adnet.err.VAdError;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.ar.core.InstallActivity;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import org.apache.http.HttpStatus;
/* loaded from: classes6.dex */
public final class PDF417ErrorCorrection {
    public static final int[][] EC_COEFFICIENTS = {new int[]{27, CyberPlayerManager.MEDIA_INFO_DNS_BEGIN}, new int[]{PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, PayBeanFactory.BEAN_ID_CARD_LIST, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 801, 132, QRScanCodeActivity.DIALOG_COLLECTION_CODE_TIP, 116, 442, 428, QRScanCodeActivity.DIALOG_COLLECTION_CODE_TIP, 42, Opcodes.ARETURN, 65}, new int[]{361, 575, 922, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, Opcodes.ARETURN, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, PayBeanFactory.BEAN_ID_CREDIT_PAY, 147, 593, 800, 571, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, HttpStatus.SC_UNPROCESSABLE_ENTITY, 6, 93, 862, BankSignFactory.BEAN_ID_BIND_CARD, 453, 106, 610, 287, 107, 505, 733, 877, 381, VAdError.IMAGE_OOM_FAIL_CODE, 723, 476, 462, 172, 430, VAdError.RENAME_DOWNLOAD_FILE_FAIL_CODE, 858, 822, 543, 376, 511, 400, 672, 762, 283, Opcodes.INVOKESTATIC, 440, 35, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, 31, 460, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 225, 535, 517, 352, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, InstallActivity.BOX_SIZE_DP, BankSignFactory.BEAN_ID_BIND_CARD, 840, 629, 4, 381, 843, 623, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 543}, new int[]{PayBeanFactory.BEAN_ID_SET_PASSFREE, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, 928, 244, 583, 620, 246, Opcodes.LCMP, 447, 631, 292, CyberPlayerManager.MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_SPEED_SLOW, 490, 704, 516, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, 457, 907, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 723, 674, 292, AuthorityState.STATE_INIT_ING, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 157, 374, BaseActivity.DIALOG_LOADING, 726, 600, 269, 375, 898, 845, 454, 354, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 550, 86, 801, 4, 108, 539}, new int[]{PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, BeanConstants.BEAN_ID_FOR_NEW_INIT, 138, PeerConnectionClient.HD_VIDEO_HEIGHT, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, InstallActivity.BOX_SIZE_DP, 201, InstallActivity.BOX_SIZE_DP, AiAppGuideActivity.GIF_HEIGHT, 757, 710, 814, CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, JfifUtil.MARKER_SOI, 257, 284, 549, 209, 884, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, PayBeanFactory.BEAN_ID_SET_PASSFREE, 307, QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, 803, 712, 19, 358, 399, CyberPlayerManager.MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_SPEED_SLOW, 103, 511, 51, 8, 517, 225, QRScanCodeActivity.DIALOG_TXT_COPY, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 637, 731, 66, 255, CyberPlayerManager.MEDIA_INFO_DNS_BEGIN, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, QRScanCodeActivity.DIALOG_CHECK_SAFE, 743, Opcodes.IFNONNULL, 655, 903, 329, 49, 802, 580, 355, 588, Opcodes.NEWARRAY, 462, 10, 134, 628, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 479, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 739, 71, PayBeanFactory.BEAN_ID_CREDIT_PAY, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, Opcodes.RETURN, 752, 607, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, PayBeanFactory.BEAN_ID_PAY_SETTING, 261, 852, 655, 309, 697, 755, 756, 60, 231, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, 434, 421, 726, PayBeanFactory.BEAN_ID_CHARGE_RESULT_BANNER, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, InstallActivity.BOX_SIZE_DP, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, VAdError.RENAME_DOWNLOAD_FILE_FAIL_CODE, 441, 180, 791, 893, 754, 605, 383, 228, 749, AiAppGuideActivity.GIF_WIDTH, 213, 54, 297, 134, 54, 834, 299, 922, 191, CyberPlayerManager.MEDIA_INFO_PROCESS, 532, VAdError.RENAME_DOWNLOAD_FILE_FAIL_CODE, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, GDiffPatcher.COPY_USHORT_INT, 688, 95, 497, 555, 642, 543, 307, Opcodes.IF_ICMPEQ, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, PayBeanFactory.BEAN_ID_CARD_LIST, 428, 207, 409, 574, 118, 498, 285, 380, 350, DownloadConstants.STATUS_FILE_ERROR, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 265, CyberPlayerManager.MEDIA_INFO_CONNECT_END, 155, 914, 299, 229, 643, QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, QRScanCodeActivity.DIALOG_CHECK_SAFE, 632, 545, 37, 858, 916, 552, 41, 542, QRScanCodeActivity.DIALOG_TXT_COPY, 122, AuthorityState.STATE_INIT_ING, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, QRScanCodeActivity.DIALOG_CHECK_SAFE, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD, 240, UIMsg.m_AppUI.MSG_COMPASS_DISPLAY, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, BeanConstants.BEAN_ID_FOR_NEW_INIT, 303, 570, 381, 415, 641, 156, 237, Opcodes.DCMPL, StatusCodeException.IGNORE_429_CODE, PayBeanFactory.BEAN_ID_RCS_APPLY_NO_PWD, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, IChannelPay.ID_IPAY_PAY_GAME, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, PayBeanFactory.BEAN_ID_SET_PASSFREE, 2, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, 851, 543, 152, 729, BankSignFactory.BEAN_ID_BIND_CARD, 95, GDiffPatcher.DATA_INT, 361, 578, 323, 856, 797, QRScanCodeActivity.DIALOG_TXT_COPY, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 298, 332, 552, 43, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, HttpStatus.SC_METHOD_FAILURE, 245, 288, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 394, 511, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, PayBeanFactory.BEAN_ID_SET_PASSFREE, PayBeanFactory.BEAN_ID_PAY_SORT_SAVE, 644, 714, 559, 62, 145, 873, 663, 713, Opcodes.IF_ICMPEQ, 672, 729, 624, 59, 193, HttpStatus.SC_EXPECTATION_FAILED, 158, 209, 563, 564, 343, 693, 109, VAdError.NETWORK_DISPATCH_FAIL_CODE, 563, 365, Opcodes.PUTFIELD, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, 677, 310, GDiffPatcher.DATA_INT, 353, 708, 410, 579, 870, 617, 841, 632, 860, QRScanCodeActivity.DIALOG_TXT_COPY, 536, 35, 777, 618, 586, HttpStatus.SC_FAILED_DEPENDENCY, 833, 77, PayBeanFactory.BEAN_ID_CARD_ADD, 346, 269, 757, 632, 695, 751, 331, GDiffPatcher.DATA_USHORT, Opcodes.INVOKESTATIC, 45, 787, 680, 18, 66, 407, 369, 54, DownloadConstants.STATUS_FILE_ERROR, 228, 613, 830, 922, 437, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, 644, 905, 789, HttpStatus.SC_METHOD_FAILURE, 305, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, GDiffPatcher.COPY_INT_UBYTE, 341, BaseActivity.DIALOG_LOADING, 797, 838, 837, PeerConnectionClient.HD_VIDEO_HEIGHT, 224, 307, 631, 61, 87, PayBeanFactory.BEAN_ID_PAY_SORT_SAVE, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, JfifUtil.MARKER_SOI, 548, 249, 321, 881, 699, 535, 673, 782, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, HttpStatus.SC_UNPROCESSABLE_ENTITY, 907, 817, Opcodes.NEW, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, PeerConnectionClient.HD_VIDEO_HEIGHT, 742, 330, 5, 39, 923, 311, HttpStatus.SC_FAILED_DEPENDENCY, BaseActivity.DIALOG_LOADING, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, PayBeanFactory.BEAN_ID_SAVE_SWITCH_PAYFREE, 540, 316, 486, 721, 610, 46, 656, 447, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 464, 190, PayBeanFactory.BEAN_ID_RCS_APPLY_NO_PWD, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 284, 736, 138, 646, 411, 877, 669, 141, CyberPlayerManager.MEDIA_INFO_CONNECT_BEGIN, 45, 780, 407, IChannelPay.ID_IPAY_PAY_GAME, 332, 899, 165, 726, 600, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, GDiffPatcher.COPY_USHORT_INT, 366, 304, 282, 738, 675, 410, 389, 244, 31, Constants.METHOD_IM_FRIEND_GROUP_DROP, 303, PayBeanFactory.BEAN_ID_CREDIT_PAY}};

    public static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            if (cArr[i4] != 0) {
                cArr[i4] = (char) (929 - cArr[i4]);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }

    public static int getErrorCorrectionCodewordCount(int i) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i + 1);
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i > 0) {
            if (i <= 40) {
                return 2;
            }
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
        throw new IllegalArgumentException("n must be > 0");
    }
}
