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
/* loaded from: classes5.dex */
public class c implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f32230a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f32231b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Writer f32232c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f32233d;

    /* renamed from: e  reason: collision with root package name */
    public int f32234e;

    /* renamed from: f  reason: collision with root package name */
    public String f32235f;

    /* renamed from: g  reason: collision with root package name */
    public String f32236g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32237h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32238i;
    public String j;
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
        f32230a = new String[128];
        for (int i2 = 0; i2 <= 31; i2++) {
            f32230a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f32230a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f32231b = strArr2;
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
        this.f32233d = new int[32];
        this.f32234e = 0;
        a(6);
        this.f32236g = ":";
        this.k = true;
        if (writer != null) {
            this.f32232c = writer;
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
            this.f32232c.write(c2);
            return this;
        }
        return (c) invokeCommon.objValue;
    }

    private void j() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.j == null) {
            return;
        }
        l();
        d(this.j);
        this.j = null;
    }

    private void k() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.f32235f == null) {
            return;
        }
        this.f32232c.write(10);
        int i2 = this.f32234e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f32232c.write(this.f32235f);
        }
    }

    private void l() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            int a2 = a();
            if (a2 == 5) {
                this.f32232c.write(44);
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
                this.f32232c.append(',');
                k();
            } else if (a2 != 4) {
                if (a2 != 6) {
                    if (a2 == 7) {
                        if (!this.f32237h) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                b(7);
            } else {
                this.f32232c.append((CharSequence) this.f32236g);
                b(5);
            }
        }
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f32237h = z;
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str.length() == 0) {
                this.f32235f = null;
                this.f32236g = ":";
                return;
            }
            this.f32235f = str;
            this.f32236g = ": ";
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f32232c.close();
            int i2 = this.f32234e;
            if (i2 <= 1 && (i2 != 1 || this.f32233d[i2 - 1] == 7)) {
                this.f32234e = 0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(3, 5, '}') : (c) invokeV.objValue;
    }

    public c f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.j != null) {
                if (this.k) {
                    j();
                } else {
                    this.j = null;
                    return this;
                }
            }
            m();
            this.f32232c.write(StringUtil.NULL_STRING);
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f32234e != 0) {
                this.f32232c.flush();
                return;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f32237h : invokeV.booleanValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f32238i : invokeV.booleanValue;
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
            return a(3, '{');
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
            if (this.j == null) {
                this.f32234e--;
                if (a2 == i3) {
                    k();
                }
                this.f32232c.write(c2);
                return this;
            }
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        return (c) invokeCommon.objValue;
    }

    private void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, this, i2) == null) {
            this.f32233d[this.f32234e - 1] = i2;
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
            String[] strArr = this.f32238i ? f32231b : f32230a;
            this.f32232c.write(34);
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    str2 = strArr[charAt];
                    i2 = str2 == null ? i2 + 1 : 0;
                    if (i3 < i2) {
                        this.f32232c.write(str, i3, i2 - i3);
                    }
                    this.f32232c.write(str2);
                    i3 = i2 + 1;
                } else {
                    if (charAt == 8232) {
                        str2 = "\\u2028";
                    } else if (charAt == 8233) {
                        str2 = "\\u2029";
                    }
                    if (i3 < i2) {
                    }
                    this.f32232c.write(str2);
                    i3 = i2 + 1;
                }
            }
            if (i3 < length) {
                this.f32232c.write(str, i3, length - i3);
            }
            this.f32232c.write(34);
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
            this.f32238i = z;
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
            int i3 = this.f32234e;
            int[] iArr = this.f32233d;
            if (i3 == iArr.length) {
                this.f32233d = Arrays.copyOf(iArr, i3 * 2);
            }
            int[] iArr2 = this.f32233d;
            int i4 = this.f32234e;
            this.f32234e = i4 + 1;
            iArr2[i4] = i2;
        }
    }

    private int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int i2 = this.f32234e;
            if (i2 != 0) {
                return this.f32233d[i2 - 1];
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
                if (this.j == null) {
                    if (this.f32234e != 0) {
                        this.j = str;
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
            this.f32232c.write(z ? "true" : "false");
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
            this.f32232c.write(bool.booleanValue() ? "true" : "false");
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c a(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            j();
            m();
            this.f32232c.write(Long.toString(j));
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
            if (!this.f32237h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals(WalletPayViewController.DEF_CHANNEL_TITLE))) {
                throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
            }
            m();
            this.f32232c.append((CharSequence) obj);
            return this;
        }
        return (c) invokeL.objValue;
    }
}
