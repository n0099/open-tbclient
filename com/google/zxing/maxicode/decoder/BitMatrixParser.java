package com.google.zxing.maxicode.decoder;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.widget.AutoScrollHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.apollon.a;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.widget.player.PlayerEvent;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
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
import com.google.zxing.common.BitMatrix;
import com.sina.weibo.sdk.constant.WBConstants;
import org.apache.http.HttpStatus;
/* loaded from: classes10.dex */
public final class BitMatrixParser {
    public static /* synthetic */ Interceptable $ic;
    public static final int[][] BITNR;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitMatrix bitMatrix;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1276175793, "Lcom/google/zxing/maxicode/decoder/BitMatrixParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1276175793, "Lcom/google/zxing/maxicode/decoder/BitMatrixParser;");
                return;
            }
        }
        BITNR = new int[][]{new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, Opcodes.DCMPL, 150, 157, 156, 163, 162, Opcodes.RET, 168, 175, 174, Opcodes.PUTFIELD, 180, Opcodes.NEW, 186, 193, 192, Opcodes.IFNONNULL, Opcodes.IFNULL, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, 140, 147, 146, 153, 152, Opcodes.IF_ICMPEQ, 158, 165, IChannelPay.ID_IPAY_PAY_GAME, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Opcodes.RETURN, Opcodes.ARETURN, 183, Opcodes.INVOKEVIRTUAL, 189, Opcodes.NEWARRAY, DownloadConstants.STATUS_WAITING_FOR_NETWORK, 194, 201, 200, 816, -3}, new int[]{125, 124, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, ContactPermissionUtil.DIALOG_NO_PERMISSION_CONTACTS, 136, 143, 142, Opcodes.FCMPL, Opcodes.LCMP, a.f37799e, Opcodes.IFNE, 161, 160, 167, 166, 173, 172, 179, 178, 185, Opcodes.INVOKESTATIC, 191, 190, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 259, 258, GDiffPatcher.COPY_INT_USHORT, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.DATA_USHORT, 246, BaseActivity.DIALOG_PROMPT, 240, 235, 234, 229, 228, 223, 222, 217, JfifUtil.MARKER_SOI, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, AuthorityState.STATE_INIT_ING, 267, 266, PlayerEvent.PLAY_LOADING_START, 260, 255, 254, 249, GDiffPatcher.DATA_INT, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, BaseActivity.DIALOG_LOADING, 237, 236, 231, 230, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, InstallActivity.BOX_SIZE_DP, 275, 274, 269, 268, PayBeanFactory.BEAN_ID_CREDIT_PAY, PlayerEvent.PLAY_LOADING_END, 257, 256, GDiffPatcher.COPY_USHORT_INT, 250, 245, 244, 239, 238, WriteActivity.CONTENT_MAX_COUNT, 232, 227, Constants.METHOD_MEDIA_NOTIFY, 221, PassLivenessRecogActivity.S, JfifUtil.MARKER_RST7, 214, 209, 208, 822, -3}, new int[]{QRScanCodeActivity.DIALOG_TXT_COPY, 288, QRScanCodeActivity.DIALOG_COLLECTION_CODE_TIP, QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY, 301, 300, 307, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 313, 312, 319, 318, PullToRefreshBase.SMOOTH_SCROLL_LONG_DURATION_MS, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, SDKLogTypeConstants.DZZB_ALERTDIALOG_NEGATIVE_CLICKED, 360, 367, SDKLogTypeConstants.TYPE_APO_CLICK, 824, 823}, new int[]{QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, QRScanCodeActivity.DIALOG_CHECK_SAFE, 297, 296, 303, 302, 309, 308, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 314, 321, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 327, 326, 333, 332, 339, 338, 345, 344, 351, VideoPlayFragment.COVER_ANIMINATION_TIME, 357, 356, 363, SDKLogTypeConstants.TYPE_FEED_IMPRESSION, SDKLogTypeConstants.TYPE_APO_SUCCESS, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, SDKLogTypeConstants.DZZB_ALERTDIALOG, 358, SDKLogTypeConstants.TYPE_SYSTEM_SPP_LIST, SDKLogTypeConstants.TYPE_FEED_CLICK, SDKLogTypeConstants.TYPE_IS_SMART, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, AiAppGuideActivity.GIF_HEIGHT, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, SDKLogTypeConstants.TYPE_SEND_INFO, 386, SDKLogTypeConstants.TYPE_APO_WAKE_UP_RECEIVER, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, SDKLogTypeConstants.TYPE_APO_WAKE_UP_MONITOR, 388, SDKLogTypeConstants.SPLASH_VIDEO_MONITOR, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, HttpStatus.SC_METHOD_FAILURE, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, SDKLogTypeConstants.TYPE_SHOUBAI_APO_INFO, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{HttpStatus.SC_EXPECTATION_FAILED, 416, HttpStatus.SC_LOCKED, HttpStatus.SC_UNPROCESSABLE_ENTITY, StatusCodeException.IGNORE_429_CODE, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, SDKLogTypeConstants.TYPE_RSPLASH_HTML_LOG, SDKLogTypeConstants.TYPE_CRASH_SOURCE, HttpStatus.SC_FAILED_DEPENDENCY, 431, SDKLogTypeConstants.TYPE_LP_DOWNLOAD, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, Constants.SOCKET_PORT_SSL, 442, 449, FileUtils.S_IRWXU, 836, SDKLogTypeConstants.TYPE_OAID_STATUS}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, DownloadConstants.STATUS_FILE_ERROR, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, UIMsg.m_AppUI.MSG_COMPASS_DISPLAY, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD, 845, 844}, new int[]{559, 558, SDKLogTypeConstants.TYPE_ASL_DELAY_DOWNLOAD, SDKLogTypeConstants.TYPE_ASL_DELAY_APO, 547, 546, 541, RecordConstants.DEFAULT_PREVIEW_WIDTH, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, SDKLogTypeConstants.TYPE_DOWNLOAD_COMPLETED_ACTION, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_CHECKSMS, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_SENDSMS, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, SDKLogTypeConstants.TYPE_ASL_INSTALL_COMPLETED, SDKLogTypeConstants.TYPE_ASL_APO, 545, RecordConstants.VIDEO_CONSTANT_WIDTH_OLD, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, PayBeanFactory.BEAN_ID_SCANCODE_SEND_SMS_TO_PAY, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 601, 600, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, PayBeanFactory.BEAN_ID_CARD_ADD, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 603, 602, 609, 608, IMConstants.ERROR_MSG_UNSUBSCRIBE_ME_TIPS, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, 605, 604, 611, 610, 617, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, SDKLogTypeConstants.TYPE_JMY_DIRECT_LAUNCH, SDKLogTypeConstants.ADSERV_AD_CLICK_TYPE, SDKLogTypeConstants.SEND_AD_CARD_TYPE, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, SDKLogTypeConstants.TYPE_INSTALL_WAKE_UP, SDKLogTypeConstants.TYPE_FOR_XUZHANG, SDKLogTypeConstants.SEND_PLAY_FAIL_TYPE, SDKLogTypeConstants.SEND_DOWNLOAD_TYPE, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, SDKLogTypeConstants.TYPE_JMY_DEEP_LINK, SDKLogTypeConstants.TYPE_JMY_ACTION, SDKLogTypeConstants.GAME_ID_ALL, SDKLogTypeConstants.CLOSE_GAME_TYPE, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, BeanConstants.BEAN_ID_FOR_SPARE_INIT, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, BankSignFactory.BEAN_ID_BIND_CARD, BankSignFactory.BEAN_ID_QUERY, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, AiAppGuideActivity.GIF_WIDTH, 767, 766, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, 779, 778, 785, 784, 791, AppConfig.VOICE_ID, 797, 796, SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG, 802, 809, 808, 815, 814, 863, 862}};
    }

    public BitMatrixParser(BitMatrix bitMatrix) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitMatrix};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bitMatrix = bitMatrix;
    }

    public byte[] readCodewords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte[] bArr = new byte[144];
            int height = this.bitMatrix.getHeight();
            int width = this.bitMatrix.getWidth();
            for (int i2 = 0; i2 < height; i2++) {
                int[] iArr = BITNR[i2];
                for (int i3 = 0; i3 < width; i3++) {
                    int i4 = iArr[i3];
                    if (i4 >= 0 && this.bitMatrix.get(i3, i2)) {
                        int i5 = i4 / 6;
                        bArr[i5] = (byte) (((byte) (1 << (5 - (i4 % 6)))) | bArr[i5]);
                    }
                }
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }
}
