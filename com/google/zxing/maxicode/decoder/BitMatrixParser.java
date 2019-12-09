package com.google.zxing.maxicode.decoder;

import android.support.v7.widget.helper.ItemTouchHelper;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.UIMsg;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.zxing.common.BitMatrix;
import com.sina.weibo.sdk.constant.WBConstants;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpStatus;
/* loaded from: classes5.dex */
final class BitMatrixParser {
    private static final int[][] BITNR = {new int[]{Constants.METHOD_IM_FRIEND_GROUP_DROP, 120, 127, 126, 133, 132, 139, 138, 145, 144, 151, 150, 157, 156, 163, BDLocation.TypeServerDecryptError, 169, 168, 175, 174, 181, SubsamplingScaleImageView.ORIENTATION_180, 187, 186, Constants.METHOD_IM_FETCH_CONFIG_MSG, 192, 199, 198, -2, -2}, new int[]{Constants.METHOD_IM_FRIEND_GROUP_QUERY, 122, 129, 128, 135, 134, 141, 140, 147, 146, 153, 152, 159, 158, 165, 164, Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 177, 176, 183, 182, 189, 188, 195, 194, 201, 200, 816, -3}, new int[]{Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER, 131, 130, 137, 136, 143, 142, 149, 148, 155, 154, BDLocation.TypeNetWorkLocation, 160, BDLocation.TypeServerError, 166, 173, 172, 179, 178, Constants.METHOD_IM_SEND_MCAST_MSG, 184, 191, 190, Constants.METHOD_IM_DELIVER_CONFIG_MSG, Constants.METHOD_IM_DELIVER_MSG, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, SubsamplingScaleImageView.ORIENTATION_270, 265, 264, 259, 258, 253, 252, 247, 246, 241, 240, 235, 234, 229, 228, SapiAccountManager.VERSION_CODE, 222, 217, 216, 211, Constants.METHOD_IM_SEND_QUIZ_ANSWER_CAST, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, AuthorityState.STATE_INIT_ING, 267, 266, 261, 260, 255, 254, 249, 248, 243, 242, 237, 236, 231, 230, 225, 224, 219, 218, 213, 212, HttpStatus.SC_MULTI_STATUS, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, 251, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, 309, StatusLine.HTTP_PERM_REDIRECT, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, HttpStatus.SC_METHOD_FAILURE, TbConfig.PB_IMAGE_DIP_MAX_WIDTH, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{HttpStatus.SC_EXPECTATION_FAILED, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, HttpStatus.SC_LOCKED, HttpStatus.SC_UNPROCESSABLE_ENTITY, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 418, 425, HttpStatus.SC_FAILED_DEPENDENCY, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, 443, 442, 449, 448, 836, 835}, new int[]{481, CameraInterface.DEFAULT_PREVIEW_HEIGHT, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, UIMsg.m_AppUI.MSG_CITY_SUP_DOM, UIMsg.m_AppUI.MSG_CHINA_SUP_ITS, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, UIMsg.d_ResultType.SUGGESTION_SEARCH, 513, 512, UIMsg.m_AppUI.MSG_SET_SENSOR_STATUS, UIMsg.m_AppUI.MSG_COMPASS_DISPLAY, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, UIMsg.d_ResultType.LONG_URL, 515, 514, 521, UIMsg.m_AppUI.MSG_PLACEFIELD_RELOAD, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, BaseWebViewActivity.TIME_OUT_MSG_CODE, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, LBSAuthManager.CODE_UNAUTHENTICATE, 600, ResponseCode.TFE_IMMGR_PERMISSION_DENIED, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, ResponseCode.TFE_IMMGR_KVACCESS_NOT_EXIST, LBSAuthManager.CODE_AUTHENTICATING, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, CyberPlayerManager.MEDIA_INFO_BUFFERING_START, CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, FormCard.WIDTH_DEFAULT_SIZE, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, CyberPlayerManager.MEDIA_INFO_NOT_SEEKABLE, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, CyberPlayerManager.MEDIA_INFO_METADATA_UPDATE, 809, 808, 815, 814, 863, 862}};
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
