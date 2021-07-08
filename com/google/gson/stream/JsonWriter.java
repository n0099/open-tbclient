package com.google.gson.stream;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes6.dex */
public class JsonWriter implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    public static final String[] REPLACEMENT_CHARS;
    public transient /* synthetic */ FieldHolder $fh;
    public String deferredName;
    public boolean htmlSafe;
    public String indent;
    public boolean lenient;
    public final Writer out;
    public String separator;
    public boolean serializeNulls;
    public int[] stack;
    public int stackSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935776889, "Lcom/google/gson/stream/JsonWriter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935776889, "Lcom/google/gson/stream/JsonWriter;");
                return;
            }
        }
        REPLACEMENT_CHARS = new String[128];
        for (int i2 = 0; i2 <= 31; i2++) {
            REPLACEMENT_CHARS[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.stack = new int[32];
        this.stackSize = 0;
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer != null) {
            this.out = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private void beforeName() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int peek = peek();
            if (peek == 5) {
                this.out.write(44);
            } else if (peek != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            newline();
            replaceTop(4);
        }
    }

    private void beforeValue() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int peek = peek();
            if (peek == 1) {
                replaceTop(2);
                newline();
            } else if (peek == 2) {
                this.out.append(',');
                newline();
            } else if (peek != 4) {
                if (peek != 6) {
                    if (peek == 7) {
                        if (!this.lenient) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                replaceTop(7);
            } else {
                this.out.append((CharSequence) this.separator);
                replaceTop(5);
            }
        }
    }

    private JsonWriter close(int i2, int i3, String str) throws IOException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, str)) == null) {
            int peek = peek();
            if (peek != i3 && peek != i2) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (this.deferredName == null) {
                this.stackSize--;
                if (peek == i3) {
                    newline();
                }
                this.out.write(str);
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        return (JsonWriter) invokeIIL.objValue;
    }

    private void newline() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.indent == null) {
            return;
        }
        this.out.write("\n");
        int i2 = this.stackSize;
        for (int i3 = 1; i3 < i2; i3++) {
            this.out.write(this.indent);
        }
    }

    private JsonWriter open(int i2, String str) throws IOException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, this, i2, str)) == null) {
            beforeValue();
            push(i2);
            this.out.write(str);
            return this;
        }
        return (JsonWriter) invokeIL.objValue;
    }

    private int peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int i2 = this.stackSize;
            if (i2 != 0) {
                return this.stack[i2 - 1];
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return invokeV.intValue;
    }

    private void push(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            int i3 = this.stackSize;
            int[] iArr = this.stack;
            if (i3 == iArr.length) {
                int[] iArr2 = new int[i3 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                this.stack = iArr2;
            }
            int[] iArr3 = this.stack;
            int i4 = this.stackSize;
            this.stackSize = i4 + 1;
            iArr3[i4] = i2;
        }
    }

    private void replaceTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            this.stack[this.stackSize - 1] = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void string(String str) throws IOException {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
            this.out.write("\"");
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    str2 = strArr[charAt];
                    i2 = str2 == null ? i2 + 1 : 0;
                    if (i3 < i2) {
                        this.out.write(str, i3, i2 - i3);
                    }
                    this.out.write(str2);
                    i3 = i2 + 1;
                } else {
                    if (charAt == 8232) {
                        str2 = "\\u2028";
                    } else if (charAt == 8233) {
                        str2 = "\\u2029";
                    }
                    if (i3 < i2) {
                    }
                    this.out.write(str2);
                    i3 = i2 + 1;
                }
            }
            if (i3 < length) {
                this.out.write(str, i3, length - i3);
            }
            this.out.write("\"");
        }
    }

    private void writeDeferredName() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.deferredName == null) {
            return;
        }
        beforeName();
        string(this.deferredName);
        this.deferredName = null;
    }

    public JsonWriter beginArray() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            writeDeferredName();
            return open(1, PreferencesUtil.LEFT_MOUNT);
        }
        return (JsonWriter) invokeV.objValue;
    }

    public JsonWriter beginObject() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            writeDeferredName();
            return open(3, StringUtil.ARRAY_START);
        }
        return (JsonWriter) invokeV.objValue;
    }

    public JsonWriter endArray() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? close(1, 2, PreferencesUtil.RIGHT_MOUNT) : (JsonWriter) invokeV.objValue;
    }

    public JsonWriter endObject() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? close(3, 5, "}") : (JsonWriter) invokeV.objValue;
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.stackSize != 0) {
                this.out.flush();
                return;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public final boolean getSerializeNulls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.serializeNulls : invokeV.booleanValue;
    }

    public final boolean isHtmlSafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.htmlSafe : invokeV.booleanValue;
    }

    public boolean isLenient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.lenient : invokeV.booleanValue;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str == null) {
                return nullValue();
            }
            writeDeferredName();
            beforeValue();
            this.out.append((CharSequence) str);
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }

    public JsonWriter name(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str != null) {
                if (this.deferredName == null) {
                    if (this.stackSize != 0) {
                        this.deferredName = str;
                        return this;
                    }
                    throw new IllegalStateException("JsonWriter is closed.");
                }
                throw new IllegalStateException();
            }
            throw new NullPointerException("name == null");
        }
        return (JsonWriter) invokeL.objValue;
    }

    public JsonWriter nullValue() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.deferredName != null) {
                if (this.serializeNulls) {
                    writeDeferredName();
                } else {
                    this.deferredName = null;
                    return this;
                }
            }
            beforeValue();
            this.out.write(StringUtil.NULL_STRING);
            return this;
        }
        return (JsonWriter) invokeV.objValue;
    }

    public final void setHtmlSafe(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.htmlSafe = z;
        }
    }

    public final void setIndent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (str.length() == 0) {
                this.indent = null;
                this.separator = ":";
                return;
            }
            this.indent = str;
            this.separator = ": ";
        }
    }

    public final void setLenient(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.lenient = z;
        }
    }

    public final void setSerializeNulls(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.serializeNulls = z;
        }
    }

    public JsonWriter value(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (str == null) {
                return nullValue();
            }
            writeDeferredName();
            beforeValue();
            string(str);
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }

    public JsonWriter value(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            writeDeferredName();
            beforeValue();
            this.out.write(z ? "true" : "false");
            return this;
        }
        return (JsonWriter) invokeZ.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.out.close();
            int i2 = this.stackSize;
            if (i2 <= 1 && (i2 != 1 || this.stack[i2 - 1] == 7)) {
                this.stackSize = 0;
                return;
            }
            throw new IOException("Incomplete document");
        }
    }

    public JsonWriter value(Boolean bool) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bool)) == null) {
            if (bool == null) {
                return nullValue();
            }
            writeDeferredName();
            beforeValue();
            this.out.write(bool.booleanValue() ? "true" : "false");
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }

    public JsonWriter value(double d2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d2)})) == null) {
            writeDeferredName();
            if (!this.lenient && (Double.isNaN(d2) || Double.isInfinite(d2))) {
                throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
            }
            beforeValue();
            this.out.append((CharSequence) Double.toString(d2));
            return this;
        }
        return (JsonWriter) invokeCommon.objValue;
    }

    public JsonWriter value(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            writeDeferredName();
            beforeValue();
            this.out.write(Long.toString(j));
            return this;
        }
        return (JsonWriter) invokeJ.objValue;
    }

    public JsonWriter value(Number number) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, number)) == null) {
            if (number == null) {
                return nullValue();
            }
            writeDeferredName();
            String obj = number.toString();
            if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals(WalletPayViewController.DEF_CHANNEL_TITLE))) {
                throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
            }
            beforeValue();
            this.out.append((CharSequence) obj);
            return this;
        }
        return (JsonWriter) invokeL.objValue;
    }
}
