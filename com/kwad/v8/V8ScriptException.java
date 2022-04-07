package com.kwad.v8;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes5.dex */
public abstract class V8ScriptException extends V8RuntimeException {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int endColumn;
    public final String fileName;
    public final String jsMessage;
    public final String jsStackTrace;
    public final int lineNumber;
    public final String sourceLine;
    public final int startColumn;

    public V8ScriptException(String str, int i, String str2, String str3, int i2, int i3, String str4, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, th};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fileName = str;
        this.lineNumber = i;
        this.jsMessage = str2;
        this.sourceLine = str3;
        this.startColumn = i2;
        this.endColumn = i3;
        this.jsStackTrace = str4;
        if (th != null) {
            initCause(th);
        }
    }

    private char[] createCharSequence(int i, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Character.valueOf(c)})) == null) {
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = c;
            }
            return cArr;
        }
        return (char[]) invokeCommon.objValue;
    }

    private String createJSStackDetails() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.jsStackTrace != null) {
                return "\n" + this.jsStackTrace;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    private String createMessageDetails() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            StringBuilder sb = new StringBuilder();
            String str = this.sourceLine;
            if (str != null && !str.isEmpty()) {
                sb.append('\n');
                sb.append(this.sourceLine);
                sb.append('\n');
                int i = this.startColumn;
                if (i >= 0) {
                    sb.append(createCharSequence(i, WebvttCueParser.CHAR_SPACE));
                    sb.append(createCharSequence(this.endColumn - this.startColumn, '^'));
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    private String createMessageLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.fileName + ":" + this.lineNumber + ": " + this.jsMessage;
        }
        return (String) invokeV.objValue;
    }

    public int getEndColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.endColumn : invokeV.intValue;
    }

    public String getFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.fileName : (String) invokeV.objValue;
    }

    public String getJSMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.jsMessage : (String) invokeV.objValue;
    }

    public String getJSStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.jsStackTrace : (String) invokeV.objValue;
    }

    public int getLineNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.lineNumber : invokeV.intValue;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? createMessageLine() : (String) invokeV.objValue;
    }

    public String getSourceLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sourceLine : (String) invokeV.objValue;
    }

    public int getStartColumn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.startColumn : invokeV.intValue;
    }

    @Override // java.lang.Throwable
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return createMessageLine() + createMessageDetails() + createJSStackDetails() + "\n" + getClass().getName();
        }
        return (String) invokeV.objValue;
    }
}
