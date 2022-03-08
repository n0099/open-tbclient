package com.google.zxing.maxicode.decoder;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.widget.AutoScrollHelper;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.player.VideoInfoConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.aiapps.apps.guide.AiAppGuideActivity;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.qrcodescanner.QRScanCodeActivity;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.ar.core.InstallActivity;
import com.google.zxing.common.BitMatrix;
import com.kuaishou.weapon.un.w0;
import com.sina.weibo.sdk.constant.WBConstants;
import org.apache.http.HttpStatus;
/* loaded from: classes7.dex */
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
        BITNR = new int[][]{new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, Cea708Decoder.COMMAND_SPA, 151, 150, 157, Cea708Decoder.COMMAND_DS4, 163, 162, 169, w0.d0, 175, MatroskaExtractor.ID_TRACK_ENTRY, 181, 180, 187, 186, 193, 192, 199, Opcodes.IFNULL, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, Cea708Decoder.COMMAND_DLY, 140, 147, Cea708Decoder.COMMAND_SPL, 153, Cea708Decoder.COMMAND_DF0, 159, 158, 165, IChannelPay.ID_IPAY_PAY_GAME, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 177, 176, 183, Opcodes.INVOKEVIRTUAL, PsExtractor.PRIVATE_STREAM_1, 188, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, Cea708Decoder.COMMAND_DLC, Opcodes.FCMPL, 148, 155, 154, 161, 160, 167, 166, w0.f53860i, 172, 179, 178, 185, 184, w0.M, 190, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 196, 203, 202, 818, 817}, new int[]{283, w0.z0, 277, 276, w0.O, 270, 265, PayBeanFactory.BEAN_ID_SEND_SMS_FOR_VERIFY_BY_BANK, 259, 258, GDiffPatcher.COPY_INT_USHORT, 252, GDiffPatcher.DATA_USHORT, 246, 241, 240, w0.k0, 234, 229, 228, 223, w0.k, 217, 216, w0.A, 210, 205, 204, 819, -3}, new int[]{w0.j0, 284, 279, w0.w0, 273, AuthorityState.STATE_INIT_ING, w0.g0, w0.m0, w0.F, 260, 255, 254, 249, 248, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK, 242, 237, 236, 231, 230, 225, 224, 219, 218, 213, w0.f53859h, 207, 206, 821, 820}, new int[]{287, 286, 281, InstallActivity.BOX_SIZE_DP, w0.y, 274, 269, w0.W, PayBeanFactory.BEAN_ID_CREDIT_PAY, 262, 257, 256, 251, 250, 245, 244, 239, 238, WriteActivity.CONTENT_MAX_COUNT, w0.c1, w0.z, Constants.METHOD_MEDIA_NOTIFY, w0.h0, 220, 215, w0.c0, 209, 208, 822, -3}, new int[]{QRScanCodeActivity.DIALOG_TXT_COPY, 288, QRScanCodeActivity.DIALOG_COLLECTION_CODE_TIP, QRScanCodeActivity.DIALOG_ALIPAY_JD_WX_COPY, 301, 300, 307, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 313, 312, 319, 318, PullToRefreshBase.SMOOTH_SCROLL_LONG_DURATION_MS, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, VideoInfoConstants.VIDEO_PREFERRED_CLARITY_RANK, 361, 360, 367, 366, 824, 823}, new int[]{QRScanCodeActivity.DIALOG_PROCESS_IMG_FAILED, QRScanCodeActivity.DIALOG_CHECK_SAFE, 297, 296, 303, 302, 309, 308, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 314, 321, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, AiAppGuideActivity.GIF_HEIGHT, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, HttpStatus.SC_METHOD_FAILURE, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{HttpStatus.SC_EXPECTATION_FAILED, 416, HttpStatus.SC_LOCKED, HttpStatus.SC_UNPROCESSABLE_ENTITY, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, PsExtractor.MPEG_PROGRAM_END_CODE, 440, 447, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 418, 425, HttpStatus.SC_FAILED_DEPENDENCY, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, PsExtractor.PACK_START_CODE, 449, FileUtils.S_IRWXU, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, DownloadConstants.STATUS_FILE_ERROR, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, LoadErrorCode.MSG_SDK_JAR_DISMATCH, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, RecordConstants.DEFAULT_PREVIEW_WIDTH, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, PayBeanFactory.BEAN_ID_CHECK_PWD, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_RESETPWD, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, 551, 550, 545, RecordConstants.VIDEO_CONSTANT_WIDTH_OLD, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, PayBeanFactory.BEAN_ID_WIDTHDRAW, PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, PayBeanFactory.BEAN_ID_SCANCODE_SEND_SMS_TO_PAY, PayBeanFactory.BEAN_ID_SCANCODE_PAY, 601, 600, ResponseCode.TFE_IMMGR_PERMISSION_DENIED, PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, PayBeanFactory.BEAN_ID_CARD_ADD, PayBeanFactory.BEAN_ID_OPEN_FINGERPRINT_REFACTOR, 603, 602, 609, 608, IMConstants.ERROR_MSG_UNSUBSCRIBE_ME_TIPS, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, PayBeanFactory.BEAN_ID_SAVE_FEEDBACK, 605, 604, 611, 610, 617, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, BeanConstants.BEAN_ID_FOR_SPARE_INIT, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, BankSignFactory.BEAN_ID_BIND_CARD, BankSignFactory.BEAN_ID_QUERY, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, AiAppGuideActivity.GIF_WIDTH, 767, 766, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_OPEN, 779, 778, 785, 784, 791, AppConfig.VOICE_ID, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
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
            byte[] bArr = new byte[Cea708Decoder.COMMAND_SPA];
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
