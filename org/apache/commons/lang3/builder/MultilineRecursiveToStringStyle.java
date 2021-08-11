package org.apache.commons.lang3.builder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.SystemUtils;
/* loaded from: classes2.dex */
public class MultilineRecursiveToStringStyle extends RecursiveToStringStyle {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int indent;
    public int spaces;

    public MultilineRecursiveToStringStyle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.indent = 2;
        this.spaces = 2;
        resetIndent();
    }

    private void resetIndent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setArrayStart(StringUtil.ARRAY_START + SystemUtils.LINE_SEPARATOR + ((Object) spacer(this.spaces)));
            setArraySeparator("," + SystemUtils.LINE_SEPARATOR + ((Object) spacer(this.spaces)));
            setArrayEnd(SystemUtils.LINE_SEPARATOR + ((Object) spacer(this.spaces - this.indent)) + "}");
            setContentStart(PreferencesUtil.LEFT_MOUNT + SystemUtils.LINE_SEPARATOR + ((Object) spacer(this.spaces)));
            setFieldSeparator("," + SystemUtils.LINE_SEPARATOR + ((Object) spacer(this.spaces)));
            setContentEnd(SystemUtils.LINE_SEPARATOR + ((Object) spacer(this.spaces - this.indent)) + PreferencesUtil.RIGHT_MOUNT);
        }
    }

    private StringBuilder spacer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(" ");
            }
            return sb;
        }
        return (StringBuilder) invokeI.objValue;
    }

    @Override // org.apache.commons.lang3.builder.RecursiveToStringStyle, org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, stringBuffer, str, obj) == null) {
            if (!ClassUtils.isPrimitiveWrapper(obj.getClass()) && !String.class.equals(obj.getClass()) && accept(obj.getClass())) {
                this.spaces += this.indent;
                resetIndent();
                stringBuffer.append(ReflectionToStringBuilder.toString(obj, this));
                this.spaces -= this.indent;
                resetIndent();
                return;
            }
            super.appendDetail(stringBuffer, str, obj);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, stringBuffer, str, obj) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, obj);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, stringBuffer, str, objArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, objArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, stringBuffer, str, jArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, jArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, stringBuffer, str, iArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, iArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, stringBuffer, str, sArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, sArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stringBuffer, str, bArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, bArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, stringBuffer, str, cArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, cArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, stringBuffer, str, dArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, dArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, stringBuffer, str, fArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, fArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, stringBuffer, str, zArr) == null) {
            this.spaces += this.indent;
            resetIndent();
            super.appendDetail(stringBuffer, str, zArr);
            this.spaces -= this.indent;
            resetIndent();
        }
    }
}
