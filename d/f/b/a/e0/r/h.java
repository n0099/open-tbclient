package d.f.b.a.e0.r;

import androidx.core.view.InputDeviceCompat;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import d.f.b.a.i0.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f70299a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f70300b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1197716793, "Ld/f/b/a/e0/r/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1197716793, "Ld/f/b/a/e0/r/h;");
                return;
            }
        }
        f70299a = Pattern.compile("^NOTE(( |\t).*)?$");
        f70300b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");
    }

    public static Matcher a(l lVar) {
        String k;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, lVar)) != null) {
            return (Matcher) invokeL.objValue;
        }
        while (true) {
            String k2 = lVar.k();
            if (k2 == null) {
                return null;
            }
            if (f70299a.matcher(k2).matches()) {
                do {
                    k = lVar.k();
                    if (k != null) {
                    }
                } while (!k.isEmpty());
            } else {
                Matcher matcher = f.f70289b.matcher(k2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static float b(String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.endsWith("%")) {
                return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
            }
            throw new NumberFormatException("Percentages must end with %");
        }
        return invokeL.floatValue;
    }

    public static long c(String str) throws NumberFormatException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, 2);
            long j = 0;
            for (String str2 : split[0].split(":")) {
                j = (j * 60) + Long.parseLong(str2);
            }
            long j2 = j * 1000;
            if (split.length == 2) {
                j2 += Long.parseLong(split[1]);
            }
            return j2 * 1000;
        }
        return invokeL.longValue;
    }

    public static void d(l lVar) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, lVar) == null) {
            String k = lVar.k();
            if (k == null || !f70300b.matcher(k).matches()) {
                throw new SubtitleDecoderException("Expected WEBVTT. Got " + k);
            }
        }
    }
}
