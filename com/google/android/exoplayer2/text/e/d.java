package com.google.android.exoplayer2.text.e;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.util.Map;
/* loaded from: classes4.dex */
final class d {
    public static e a(e eVar, String[] strArr, Map<String, e> map) {
        if (eVar == null && strArr == null) {
            return null;
        }
        if (eVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (eVar == null && strArr.length > 1) {
            e eVar2 = new e();
            for (String str : strArr) {
                eVar2.b(map.get(str));
            }
            return eVar2;
        } else if (eVar != null && strArr != null && strArr.length == 1) {
            return eVar.b(map.get(strArr[0]));
        } else {
            if (eVar != null && strArr != null && strArr.length > 1) {
                for (String str2 : strArr) {
                    eVar.b(map.get(str2));
                }
                return eVar;
            }
            return eVar;
        }
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, e eVar) {
        if (eVar.getStyle() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(eVar.getStyle()), i, i2, 33);
        }
        if (eVar.dvM()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (eVar.dvN()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (eVar.dvP()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(eVar.getFontColor()), i, i2, 33);
        }
        if (eVar.dvQ()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(eVar.getBackgroundColor()), i, i2, 33);
        }
        if (eVar.dvO() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(eVar.dvO()), i, i2, 33);
        }
        if (eVar.dvR() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(eVar.dvR()), i, i2, 33);
        }
        switch (eVar.dvS()) {
            case 1:
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) eVar.dvT(), true), i, i2, 33);
                return;
            case 2:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.dvT()), i, i2, 33);
                return;
            case 3:
                spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.dvT() / 100.0f), i, i2, 33);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String PB(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", HanziToPinyin.Token.SEPARATOR).replaceAll("[ \t\\x0B\f\r]+", HanziToPinyin.Token.SEPARATOR);
    }
}
