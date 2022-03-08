package org.apache.commons.lang3.text.translate;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes9.dex */
public class UnicodeEscaper extends CodePointTranslator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int above;
    public final int below;
    public final boolean between;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static UnicodeEscaper above(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? outsideOf(0, i2) : (UnicodeEscaper) invokeI.objValue;
    }

    public static UnicodeEscaper below(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? outsideOf(i2, Integer.MAX_VALUE) : (UnicodeEscaper) invokeI.objValue;
    }

    public static UnicodeEscaper between(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3)) == null) ? new UnicodeEscaper(i2, i3, true) : (UnicodeEscaper) invokeII.objValue;
    }

    public static UnicodeEscaper outsideOf(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i2, i3)) == null) ? new UnicodeEscaper(i2, i3, false) : (UnicodeEscaper) invokeII.objValue;
    }

    public String toUtf16Escape(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            return "\\u" + CharSequenceTranslator.hex(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i2, Writer writer) throws IOException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, writer)) == null) {
            if (this.between) {
                if (i2 < this.below || i2 > this.above) {
                    return false;
                }
            } else if (i2 >= this.below && i2 <= this.above) {
                return false;
            }
            if (i2 > 65535) {
                writer.write(toUtf16Escape(i2));
                return true;
            }
            writer.write("\\u");
            writer.write(CharSequenceTranslator.HEX_DIGITS[(i2 >> 12) & 15]);
            writer.write(CharSequenceTranslator.HEX_DIGITS[(i2 >> 8) & 15]);
            writer.write(CharSequenceTranslator.HEX_DIGITS[(i2 >> 4) & 15]);
            writer.write(CharSequenceTranslator.HEX_DIGITS[i2 & 15]);
            return true;
        }
        return invokeIL.booleanValue;
    }

    public UnicodeEscaper(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.below = i2;
        this.above = i3;
        this.between = z;
    }
}
