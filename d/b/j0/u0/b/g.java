package d.b.j0.u0.b;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class g {
    public static SpannableString a(long j, int i) {
        Drawable drawable;
        String formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
        String str = "[icon]" + formatOverBaiwanNum;
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            drawable = SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
        } else {
            drawable = SkinManager.getDrawable(R.drawable.icon_gift_bluedrill);
        }
        if (TbadkApplication.getInst().getSkinType() == 1) {
            drawable.setAlpha(179);
        } else {
            drawable.setAlpha(255);
        }
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        if (i == 1) {
            drawable.setBounds(0, 0, g2, g2);
        } else {
            drawable.setBounds(0, 0, g2, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20));
        }
        d.b.i0.b1.d dVar = new d.b.i0.b1.d(drawable);
        dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108)));
        return spannableString;
    }

    public static SpannableString b(long j, boolean z) {
        String str;
        String formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(j);
        if (z) {
            str = "=[icon]" + formatOverBaiwanNum;
        } else {
            str = "[icon]" + formatOverBaiwanNum;
        }
        SpannableString spannableString = new SpannableString(str);
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_huobi_tdou);
        int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds24);
        drawable.setBounds(0, 0, g2, g2);
        d.b.i0.b1.d dVar = new d.b.i0.b1.d(drawable);
        dVar.b(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
        UtilHelper.setSpan(spannableString, str, "[icon]", dVar);
        UtilHelper.setSpan(spannableString, str, formatOverBaiwanNum, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
        if (z) {
            UtilHelper.setSpan(spannableString, str, "=", new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0108)));
        }
        return spannableString;
    }

    public static SpannableString c(String str, String str2, String str3) {
        if (StringUtils.isNull(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        UtilHelper.setSpan(spannableString, str, str, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)));
        UtilHelper.setSpan(spannableString, str, str2, new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305)));
        if (!StringUtils.isNull(str3)) {
            UtilHelper.setSpan(spannableString, str, str3, new StrikethroughSpan());
        }
        return spannableString;
    }
}
