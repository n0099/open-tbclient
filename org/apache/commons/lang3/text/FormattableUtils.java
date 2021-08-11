package org.apache.commons.lang3.text;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Formattable;
import java.util.Formatter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;
/* loaded from: classes2.dex */
public class FormattableUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SIMPLEST_FORMAT = "%s";
    public transient /* synthetic */ FieldHolder $fh;

    public FormattableUtils() {
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

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{charSequence, formatter, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) ? append(charSequence, formatter, i2, i3, i4, ' ', null) : (Formatter) invokeCommon.objValue;
    }

    public static String toString(Formattable formattable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, formattable)) == null) ? String.format(SIMPLEST_FORMAT, formattable) : (String) invokeL.objValue;
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{charSequence, formatter, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Character.valueOf(c2)})) == null) ? append(charSequence, formatter, i2, i3, i4, c2, null) : (Formatter) invokeCommon.objValue;
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4, CharSequence charSequence2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{charSequence, formatter, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), charSequence2})) == null) ? append(charSequence, formatter, i2, i3, i4, ' ', charSequence2) : (Formatter) invokeCommon.objValue;
    }

    public static Formatter append(CharSequence charSequence, Formatter formatter, int i2, int i3, int i4, char c2, CharSequence charSequence2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{charSequence, formatter, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Character.valueOf(c2), charSequence2})) == null) {
            Validate.isTrue(charSequence2 == null || i4 < 0 || charSequence2.length() <= i4, "Specified ellipsis '%1$s' exceeds precision of %2$s", charSequence2, Integer.valueOf(i4));
            StringBuilder sb = new StringBuilder(charSequence);
            if (i4 >= 0 && i4 < charSequence.length()) {
                CharSequence charSequence3 = (CharSequence) ObjectUtils.defaultIfNull(charSequence2, "");
                sb.replace(i4 - charSequence3.length(), charSequence.length(), charSequence3.toString());
            }
            boolean z = (i2 & 1) == 1;
            for (int length = sb.length(); length < i3; length++) {
                sb.insert(z ? length : 0, c2);
            }
            formatter.format(sb.toString(), new Object[0]);
            return formatter;
        }
        return (Formatter) invokeCommon.objValue;
    }
}
