package d.f.b.a.e0.p;

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
import com.android.internal.http.multipart.Part;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{spannableStringBuilder, Integer.valueOf(i2), Integer.valueOf(i3), eVar}) == null) {
            if (eVar.h() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(eVar.h()), i2, i3, 33);
            }
            if (eVar.m()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
            }
            if (eVar.n()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
            }
            if (eVar.k()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(eVar.c()), i2, i3, 33);
            }
            if (eVar.j()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(eVar.b()), i2, i3, 33);
            }
            if (eVar.d() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(eVar.d()), i2, i3, 33);
            }
            if (eVar.i() != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(eVar.i()), i2, i3, 33);
            }
            int f2 = eVar.f();
            if (f2 == 1) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) eVar.e(), true), i2, i3, 33);
            } else if (f2 == 2) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.e()), i2, i3, 33);
            } else if (f2 != 3) {
            } else {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(eVar.e() / 100.0f), i2, i3, 33);
            }
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? str.replaceAll(Part.CRLF, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ") : (String) invokeL.objValue;
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, spannableStringBuilder) == null) {
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

    public static e d(e eVar, String[] strArr, Map<String, e> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, eVar, strArr, map)) == null) {
            if (eVar == null && strArr == null) {
                return null;
            }
            int i2 = 0;
            if (eVar == null && strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (eVar == null && strArr.length > 1) {
                e eVar2 = new e();
                int length = strArr.length;
                while (i2 < length) {
                    eVar2.a(map.get(strArr[i2]));
                    i2++;
                }
                return eVar2;
            } else if (eVar != null && strArr != null && strArr.length == 1) {
                eVar.a(map.get(strArr[0]));
                return eVar;
            } else {
                if (eVar != null && strArr != null && strArr.length > 1) {
                    int length2 = strArr.length;
                    while (i2 < length2) {
                        eVar.a(map.get(strArr[i2]));
                        i2++;
                    }
                }
                return eVar;
            }
        }
        return (e) invokeLLL.objValue;
    }
}
