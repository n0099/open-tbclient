package d.a.k0.a1.f.h;

import android.graphics.drawable.Drawable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public static Drawable[] a(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        Drawable[] drawableArr = new Drawable[2];
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1581702362:
                if (str.equals("share_num")) {
                    c2 = 1;
                    break;
                }
                break;
            case -6986408:
                if (str.equals("care_num")) {
                    c2 = 3;
                    break;
                }
                break;
            case 975378291:
                if (str.equals("agree_num")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2103869862:
                if (str.equals("comment_num")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            drawableArr[0] = WebPManager.getMaskDrawable(R.drawable.pic_banner_tiebatreasure_like, WebPManager.ResourceStateType.NORMAL);
            drawableArr[1] = WebPManager.getMaskDrawable(R.drawable.pic_giadienta_tiebatreasure_like, WebPManager.ResourceStateType.NORMAL);
        } else if (c2 == 1) {
            drawableArr[0] = WebPManager.getMaskDrawable(R.drawable.pic_banner_tiebatreasure_spread, WebPManager.ResourceStateType.NORMAL);
            drawableArr[1] = WebPManager.getMaskDrawable(R.drawable.pic_giadienta_tiebatreasure_spread, WebPManager.ResourceStateType.NORMAL);
        } else if (c2 == 2) {
            drawableArr[0] = WebPManager.getMaskDrawable(R.drawable.pic_banner_tiebatreasure_discuss, WebPManager.ResourceStateType.NORMAL);
            drawableArr[1] = WebPManager.getMaskDrawable(R.drawable.pic_giadienta_tiebatreasure_discuss, WebPManager.ResourceStateType.NORMAL);
        } else if (c2 != 3) {
            drawableArr[0] = WebPManager.getMaskDrawable(R.drawable.pic_banner_tiebatreasure_custom, WebPManager.ResourceStateType.NORMAL);
            drawableArr[1] = WebPManager.getMaskDrawable(R.drawable.pic_giadienta_tiebatreasure_custom, WebPManager.ResourceStateType.NORMAL);
        } else {
            drawableArr[0] = WebPManager.getMaskDrawable(R.drawable.pic_banner_tiebatreasure_care, WebPManager.ResourceStateType.NORMAL);
            drawableArr[1] = WebPManager.getMaskDrawable(R.drawable.pic_giadienta_tiebatreasure_care, WebPManager.ResourceStateType.NORMAL);
        }
        return drawableArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1581702362:
                if (str.equals("share_num")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -6986408:
                if (str.equals("care_num")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 975378291:
                if (str.equals("agree_num")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 2103869862:
                if (str.equals("comment_num")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_custom);
                    }
                    return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_care);
                }
                return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_discuss);
            }
            return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_spread);
        }
        return TbadkCoreApplication.getInst().getResources().getString(R.string.lf_banner_treasure_like);
    }
}
