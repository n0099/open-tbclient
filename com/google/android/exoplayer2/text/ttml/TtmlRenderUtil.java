package com.google.android.exoplayer2.text.ttml;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public final class TtmlRenderUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TtmlRenderUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void applyStylesToSpan(SpannableStringBuilder spannableStringBuilder, int i2, int i3, TtmlStyle ttmlStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), ttmlStyle}) == null) {
            if (ttmlStyle.getStyle() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(ttmlStyle.getStyle()), i2, i3, 33);
            }
            if (ttmlStyle.isLinethrough()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
            }
            if (ttmlStyle.isUnderline()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
            }
            if (ttmlStyle.hasFontColor()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ttmlStyle.getFontColor()), i2, i3, 33);
            }
            if (ttmlStyle.hasBackgroundColor()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(ttmlStyle.getBackgroundColor()), i2, i3, 33);
            }
            if (ttmlStyle.getFontFamily() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(ttmlStyle.getFontFamily()), i2, i3, 33);
            }
            if (ttmlStyle.getTextAlign() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(ttmlStyle.getTextAlign()), i2, i3, 33);
            }
            int fontSizeUnit = ttmlStyle.getFontSizeUnit();
            if (fontSizeUnit == 1) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) ttmlStyle.getFontSize(), true), i2, i3, 33);
            } else if (fontSizeUnit == 2) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.getFontSize()), i2, i3, 33);
            } else if (fontSizeUnit != 3) {
            } else {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(ttmlStyle.getFontSize() / 100.0f), i2, i3, 33);
            }
        }
    }

    public static String applyTextElementSpacePolicy(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.replaceAll("\r\n", StringUtils.LF).replaceAll(" *\n *", StringUtils.LF).replaceAll(StringUtils.LF, " ").replaceAll("[ \t\\x0B\f\r]+", " ") : (String) invokeL.objValue;
    }

    public static void endParagraph(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, spannableStringBuilder) == null) {
            int length = spannableStringBuilder.length() - 1;
            while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
                length--;
            }
            if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
                return;
            }
            spannableStringBuilder.append('\n');
        }
    }

    public static TtmlStyle resolveStyle(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ttmlStyle, strArr, map)) == null) {
            if (ttmlStyle == null && strArr == null) {
                return null;
            }
            int i2 = 0;
            if (ttmlStyle == null && strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (ttmlStyle == null && strArr.length > 1) {
                TtmlStyle ttmlStyle2 = new TtmlStyle();
                int length = strArr.length;
                while (i2 < length) {
                    ttmlStyle2.chain(map.get(strArr[i2]));
                    i2++;
                }
                return ttmlStyle2;
            } else if (ttmlStyle != null && strArr != null && strArr.length == 1) {
                return ttmlStyle.chain(map.get(strArr[0]));
            } else {
                if (ttmlStyle != null && strArr != null && strArr.length > 1) {
                    int length2 = strArr.length;
                    while (i2 < length2) {
                        ttmlStyle.chain(map.get(strArr[i2]));
                        i2++;
                    }
                }
                return ttmlStyle;
            }
        }
        return (TtmlStyle) invokeLLL.objValue;
    }
}
