package com.google.zxing.maxicode.decoder;

import androidx.core.widget.AutoScrollHelper;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.location.BDLocation;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.live.interfaces.player.VideoInfoConstants;
import com.baidu.searchbox.ui.CoolPraiseView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.common.BitMatrix;
import com.sina.weibo.sdk.constant.WBConstants;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import org.apache.http.HttpStatus;
/* loaded from: classes9.dex */
public final class BitMatrixParser {
    public static final int[][] BITNR = {new int[]{121, 120, 127, 126, 133, 132, Cea708Decoder.COMMAND_TGW, 138, 145, Cea708Decoder.COMMAND_SPA, Cea708Decoder.COMMAND_SWA, 150, Cea708Decoder.COMMAND_DF5, Cea708Decoder.COMMAND_DS4, MatroskaExtractor.ID_SIMPLE_BLOCK, BDLocation.TypeServerDecryptError, 169, 168, 175, MatroskaExtractor.ID_TRACK_ENTRY, 181, 180, 187, MatroskaExtractor.ID_PIXEL_HEIGHT, 193, 192, Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG, Constants.METHOD_IM_FETCH_BUSINESS_SESSION_MSG, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, Cea708Decoder.COMMAND_DLW, 147, Cea708Decoder.COMMAND_SPL, 153, Cea708Decoder.COMMAND_DF0, 159, Cea708Decoder.COMMAND_DF6, 165, 164, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 177, MatroskaExtractor.ID_PIXEL_WIDTH, 183, 182, PsExtractor.PRIVATE_STREAM_1, TsExtractor.TS_PACKET_SIZE, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, Cea708Decoder.COMMAND_DSW, 136, Cea708Decoder.COMMAND_RST, Cea708Decoder.COMMAND_DLC, 149, 148, 155, Cea708Decoder.COMMAND_DF2, 161, 160, 167, TTAdConstant.IMAGE_MODE_LIVE, 173, 172, 179, 178, Constants.METHOD_IM_SEND_MCAST_MSG, H262Reader.START_GROUP, 191, 190, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256, ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PSS_WITH_SHA512, GDiffPatcher.COPY_INT_USHORT, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.DATA_USHORT, 246, MatroskaExtractor.ID_CUE_CLUSTER_POSITION, 240, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, 254, 249, GDiffPatcher.DATA_INT, 243, 242, Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG, Constants.METHOD_IM_CONSULT_NOTIFY_MSG, 231, 230, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, 250, GDiffPatcher.COPY_UBYTE_USHORT, GDiffPatcher.COPY_UBYTE_UBYTE, Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG, 238, 233, 232, 227, Constants.METHOD_MEDIA_NOTIFY, 221, PassFaceRecogManager.j, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, VideoInfoConstants.VIDEO_PREFERRED_CLARITY_RANK, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, 308, AutoScrollHelper.DEFAULT_MINIMUM_VELOCITY_DIPS, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, BuildConfig.VERSION_CODE, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, HttpStatus.SC_METHOD_FAILURE, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, HttpStatus.SC_LOCKED, HttpStatus.SC_UNPROCESSABLE_ENTITY, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, PsExtractor.MPEG_PROGRAM_END_CODE, 440, 447, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 425, HttpStatus.SC_FAILED_DEPENDENCY, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR, 443, PsExtractor.PACK_START_CODE, 449, FileUtils.S_IRWXU, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, FloatingActionButton.AUTO_MINI_LARGEST_SCREEN_WIDTH, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, com.vivo.push.BuildConfig.VERSION_CODE, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{Downloads.Impl.STATUS_CANNOT_RESUME, 488, Downloads.Impl.STATUS_HTTP_DATA_ERROR, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{Downloads.Impl.STATUS_UNKNOWN_ERROR, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, LoadErrorCode.MSG_SDK_LIB_DISMATCH, 846, -3}, new int[]{561, CoolPraiseView.START_DELAY_TIME_MS, BaseWebViewActivity.TIME_OUT_MSG_CODE, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, UIMsg.MsgDefine.MSG_MSG_CENTER, 524, 848, 847}, new int[]{563, TTAdConstant.STYLE_SIZE_RADIO_9_16, 557, 556, UIMsg.MsgDefine.MSG_LOG_GESTURE, CoolPraiseView.LONG_PRESS_TIME_MS, 545, RecordConstants.VIDEO_CONSTANT_WIDTH_OLD, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, UIMsg.MsgDefine.MSG_USERINFO_SECURE, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, ResponseCode.TFE_IMMGR_PERMISSION_DENIED, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, ResponseCode.TFE_IMMGR_KVACCESS_NOT_EXIST, 602, 609, 608, IMConstants.ERROR_MSG_UNSUBSCRIBE_ME_TIPS, 614, 621, PassBiometricUtil.f, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, TTAdConstant.STYLE_SIZE_RADIO_2_3, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, PassBiometricUtil.i, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, PassBiometricUtil.k, 757, 756, 763, 762, ApkSignatureSchemeV2Verifier.SIGNATURE_DSA_WITH_SHA256, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, CyberPlayerManager.MEDIA_ERROR_UNDEFINE_VIDEO_NOT_PLAY, CyberPlayerManager.MEDIA_ERROR_UNDEFINE_AUDIO_NOT_PLAY, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, AppConfig.VOICE_ID, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    public final BitMatrix bitMatrix;

    public BitMatrixParser(BitMatrix bitMatrix) {
        this.bitMatrix = bitMatrix;
    }

    public byte[] readCodewords() {
        byte[] bArr = new byte[Cea708Decoder.COMMAND_SPA];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i = 0; i < height; i++) {
            int[] iArr = BITNR[i];
            for (int i2 = 0; i2 < width; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.bitMatrix.get(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}
