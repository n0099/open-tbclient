package com.google.zxing.maxicode.decoder;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.google.zxing.common.BitMatrix;
import com.kwai.video.player.PlayerPostEvent;
import com.qq.e.comm.constants.ErrorCode;
import com.sina.weibo.sdk.constant.WBConstants;
import com.thunder.livesdk.system.ThunderNetStateService;
import com.thunder.livesdk.video.serviceConfig.VideoLiveConfig;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.YYVideoLibMgr;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpStatus;
/* loaded from: classes4.dex */
final class BitMatrixParser {
    private static final int[][] BITNR = {new int[]{Constants.METHOD_IM_FRIEND_GROUP_DROP, 120, ThunderNetStateService.NetState.SYSNET_UNKNOWN, Opcodes.IAND, 133, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 139, 138, 145, 144, Opcodes.DCMPL, 150, 157, 156, Opcodes.IF_ICMPGT, 162, Opcodes.RET, 168, 175, 174, Opcodes.PUTFIELD, 180, Opcodes.NEW, 186, 193, 192, Opcodes.IFNONNULL, Opcodes.IFNULL, -2, -2}, new int[]{Constants.METHOD_IM_FRIEND_GROUP_QUERY, 122, 129, 128, 135, 134, 141, 140, 147, 146, Opcodes.IFEQ, 152, Opcodes.IF_ICMPEQ, Opcodes.IFLE, Opcodes.IF_ACMPEQ, 164, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, Opcodes.RETURN, Opcodes.ARETURN, 183, Opcodes.INVOKEVIRTUAL, 189, Opcodes.NEWARRAY, DownloadConstants.STATUS_WAITING_FOR_NETWORK, DownloadConstants.STATUS_WAITING_TO_RETRY, 201, 200, 816, -3}, new int[]{Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER, 137, 136, 143, 142, Opcodes.FCMPL, Opcodes.LCMP, 155, Opcodes.IFNE, 161, 160, 167, Opcodes.IF_ACMPNE, 173, 172, 179, Opcodes.GETSTATIC, 185, Opcodes.INVOKESTATIC, 191, 190, Constants.METHOD_IM_DELIVER_CONFIG_MSG, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, GDiffPatcher.COPY_INT_USHORT, GDiffPatcher.COPY_INT_UBYTE, GDiffPatcher.DATA_USHORT, 246, BaseActivity.DIALOG_PROMPT, 240, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, AuthorityState.STATE_INIT_ING, 267, 266, 261, 260, 255, GDiffPatcher.COPY_INT_INT, 249, GDiffPatcher.DATA_INT, 243, BaseActivity.DIALOG_LOADING, 237, 236, 231, RtcConstants.METHOD_IM_RTC_MSG, 225, 224, 219, 218, 213, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, GDiffPatcher.COPY_USHORT_INT, 250, GDiffPatcher.COPY_UBYTE_USHORT, GDiffPatcher.COPY_UBYTE_UBYTE, 239, 238, 233, 232, 227, Constants.METHOD_MEDIA_NOTIFY, VideoLiveConfig.EncodeType.PHONE_CODEC_X265, VideoLiveConfig.EncodeType.PHONE_CODEC_HW_H265, 215, 214, FAUEnum.PR_TIMEOUT, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, EncoderTextureDrawer.X264_WIDTH, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, StatusLine.HTTP_PERM_REDIRECT, 315, 314, 321, VideoConstant.THUMBNAIL_WIDTH, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, YYVideoLibMgr.MediaDecodeConfigKey.CCK_H265_HARDWARE_DECODE, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, HttpStatus.SC_METHOD_FAILURE, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{HttpStatus.SC_EXPECTATION_FAILED, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, HttpStatus.SC_LOCKED, HttpStatus.SC_UNPROCESSABLE_ENTITY, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 418, 425, HttpStatus.SC_FAILED_DEPENDENCY, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, RTCConst.RTC_ROOM_USERID_ALREADY_EXIST_ERROR, Constants.SOCKET_PORT_SSL, 442, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, DownloadConstants.STATUS_FILE_ERROR, DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, UIMsg.m_AppUI.MSG_CITY_SUP_DOM, UIMsg.m_AppUI.MSG_CHINA_SUP_ITS, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, UIMsg.m_AppUI.MSG_COMPASS_DISPLAY, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, BaseWebViewActivity.TIME_OUT_MSG_CODE, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, VideoEncoderConfig.DEFAULT_ENCODE_HIGH_WIDTH, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, 600, 607, ErrorCode.OtherError.CONTAINER_HEIGHT_ERROR, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, ErrorCode.OtherError.SKIP_VIEW_SIZE_ERROR, IMConstants.ERROR_MSG_UNSUBSCRIBE_ME_TIPS, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, ErrorCode.OtherError.UNKNOWN_ERROR, ErrorCode.OtherError.GET_PARAS_FROM_NATIVE_ERROR, 611, 610, 617, IMConstants.ERROR_MSG_SHEILD_ME_TIPS, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, PlayerPostEvent.MEDIA_INFO_NETWORK_BANDWIDTH, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, FormCard.WIDTH_DEFAULT_SIZE, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    private final BitMatrix bitMatrix;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitMatrixParser(BitMatrix bitMatrix) {
        this.bitMatrix = bitMatrix;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
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
