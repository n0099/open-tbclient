package com.bytedance.sdk.openadsdk.preload.a.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.util.Arrays;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class c implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f68877a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f68878b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Writer f68879c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f68880d;

    /* renamed from: e  reason: collision with root package name */
    public int f68881e;

    /* renamed from: f  reason: collision with root package name */
    public String f68882f;

    /* renamed from: g  reason: collision with root package name */
    public String f68883g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f68884h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68885i;

    /* renamed from: j  reason: collision with root package name */
    public String f68886j;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639710284, "Lcom/bytedance/sdk/openadsdk/preload/a/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639710284, "Lcom/bytedance/sdk/openadsdk/preload/a/d/c;");
                return;
            }
        }
        f68877a = new String[128];
        for (int i2 = 0; i2 <= 31; i2++) {
            f68877a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f68877a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f68878b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
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
        this.f68880d = new int[32];
        this.f68881e = 0;
        a(6);
        this.f68883g = ":";
        this.k = true;
        if (writer != null) {
            this.f68879c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private c a(int i2, char c2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Character.valueOf(c2)})) == null) {
            m();
            a(i2);
            this.f68879c.write(c2);
            return this;
        }
        return (c) invokeCommon.objValue;
    }

    private void j() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f68886j == null) {
            return;
        }
        l();
        d(this.f68886j);
        this.f68886j = null;
    }

    private void k() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f68882f == null) {
            return;
        }
        this.f68879c.write(10);
        int i2 = this.f68881e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f68879c.write(this.f68882f);
        }
    }

    private void l() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int a2 = a();
            if (a2 == 5) {
                this.f68879c.write(44);
            } else if (a2 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            k();
            b(4);
        }
    }

    private void m() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            int a2 = a();
            if (a2 == 1) {
                b(2);
                k();
            } else if (a2 == 2) {
                this.f68879c.append(',');
                k();
            } else if (a2 != 4) {
                if (a2 != 6) {
                    if (a2 == 7) {
                        if (!this.f68884h) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                b(7);
            } else {
                this.f68879c.append((CharSequence) this.f68883g);
                b(5);
            }
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f68884h = z;
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str.length() == 0) {
                this.f68882f = null;
                this.f68883g = ":";
                return;
            }
            this.f68882f = str;
            this.f68883g = ": ";
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f68879c.close();
            int i2 = this.f68881e;
            if (i2 <= 1 && (i2 != 1 || this.f68880d[i2 - 1] == 7)) {
                this.f68881e = 0;
                return;
            }
            throw new IOException("Incomplete document");
        }
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.k = z;
        }
    }

    public c e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(3, 5, ExtendedMessageFormat.END_FE) : (c) invokeV.objValue;
    }

    public c f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f68886j != null) {
                if (this.k) {
                    j();
                } else {
                    this.f68886j = null;
                    return this;
                }
            }
            m();
            this.f68879c.write(StringUtil.NULL_STRING);
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f68881e != 0) {
                this.f68879c.flush();
                return;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f68884h : invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f68885i : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public c b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j();
            return a(1, '[');
        }
        return (c) invokeV.objValue;
    }

    public c d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j();
            return a(3, ExtendedMessageFormat.START_FE);
        }
        return (c) invokeV.objValue;
    }

    private c a(int i2, int i3, char c2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            int a2 = a();
            if (a2 != i3 && a2 != i2) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (this.f68886j == null) {
                this.f68881e--;
                if (a2 == i3) {
                    k();
                }
                this.f68879c.write(c2);
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.f68886j);
        }
        return (c) invokeCommon.objValue;
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            this.f68880d[this.f68881e - 1] = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(String str) throws IOException {
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            String[] strArr = this.f68885i ? f68878b : f68877a;
            this.f68879c.write(34);
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    str2 = strArr[charAt];
                    i2 = str2 == null ? i2 + 1 : 0;
                    if (i3 < i2) {
                        this.f68879c.write(str, i3, i2 - i3);
                    }
                    this.f68879c.write(str2);
                    i3 = i2 + 1;
                } else {
                    if (charAt == 8232) {
                        str2 = "\\u2028";
                    } else if (charAt == 8233) {
                        str2 = "\\u2029";
                    }
                    if (i3 < i2) {
                    }
                    this.f68879c.write(str2);
                    i3 = i2 + 1;
                }
            }
            if (i3 < length) {
                this.f68879c.write(str, i3, length - i3);
            }
            this.f68879c.write(34);
        }
    }

    public c b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str == null) {
                return f();
            }
            j();
            m();
            d(str);
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f68885i = z;
        }
    }

    public c c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? a(1, 2, ']') : (c) invokeV.objValue;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            int i3 = this.f68881e;
            int[] iArr = this.f68880d;
            if (i3 == iArr.length) {
                this.f68880d = Arrays.copyOf(iArr, i3 * 2);
            }
            int[] iArr2 = this.f68880d;
            int i4 = this.f68881e;
            this.f68881e = i4 + 1;
            iArr2[i4] = i2;
        }
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = this.f68881e;
            if (i2 != 0) {
                return this.f68880d[i2 - 1];
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return invokeV.intValue;
    }

    public c a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                if (this.f68886j == null) {
                    if (this.f68881e != 0) {
                        this.f68886j = str;
                        return this;
                    }
                    throw new IllegalStateException("JsonWriter is closed.");
                }
                throw new IllegalStateException();
            }
            throw new NullPointerException("name == null");
        }
        return (c) invokeL.objValue;
    }

    public c a(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            j();
            m();
            this.f68879c.write(z ? "true" : "false");
            return this;
        }
        return (c) invokeZ.objValue;
    }

    public c a(Boolean bool) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
            if (bool == null) {
                return f();
            }
            j();
            m();
            this.f68879c.write(bool.booleanValue() ? "true" : "false");
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c a(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            j();
            m();
            this.f68879c.write(Long.toString(j2));
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public c a(Number number) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, number)) == null) {
            if (number == null) {
                return f();
            }
            j();
            String obj = number.toString();
            if (!this.f68884h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals(WalletPayViewController.DEF_CHANNEL_TITLE))) {
                throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
            }
            m();
            this.f68879c.append((CharSequence) obj);
            return this;
        }
        return (c) invokeL.objValue;
    }
}
