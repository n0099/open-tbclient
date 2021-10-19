package com.bytedance.sdk.openadsdk.preload.a.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.o;
import com.bytedance.sdk.openadsdk.preload.a.q;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes9.dex */
public final class e extends com.bytedance.sdk.openadsdk.preload.a.d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Reader f68710b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f68711c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f68712d;

    /* renamed from: e  reason: collision with root package name */
    public int f68713e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f68714f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f68715g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523933370, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(523933370, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/e;");
                return;
            }
        }
        f68710b = new Reader() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i2, int i3) throws IOException {
                InterceptResult invokeLII;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cArr, i2, i3)) == null) {
                    throw new AssertionError();
                }
                return invokeLII.intValue;
            }
        };
        f68711c = new Object();
    }

    private Object t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f68712d[this.f68713e - 1] : invokeV.objValue;
    }

    private Object u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Object[] objArr = this.f68712d;
            int i2 = this.f68713e - 1;
            this.f68713e = i2;
            Object obj = objArr[i2];
            objArr[i2] = null;
            return obj;
        }
        return invokeV.objValue;
    }

    private String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            return " at path " + p();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68902a);
            a(((com.bytedance.sdk.openadsdk.preload.a.i) t()).iterator());
            this.f68715g[this.f68713e - 1] = 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68903b);
            u();
            u();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void c() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68904c);
            a(((o) t()).n().iterator());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f68712d = new Object[]{f68711c};
            this.f68713e = 1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void d() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68905d);
            u();
            u();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public boolean e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
            return (f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.f68905d || f2 == com.bytedance.sdk.openadsdk.preload.a.d.b.f68903b) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public com.bytedance.sdk.openadsdk.preload.a.d.b f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f68713e == 0) {
                return com.bytedance.sdk.openadsdk.preload.a.d.b.f68911j;
            }
            Object t = t();
            if (t instanceof Iterator) {
                boolean z = this.f68712d[this.f68713e - 2] instanceof o;
                Iterator it = (Iterator) t;
                if (!it.hasNext()) {
                    return z ? com.bytedance.sdk.openadsdk.preload.a.d.b.f68905d : com.bytedance.sdk.openadsdk.preload.a.d.b.f68903b;
                } else if (z) {
                    return com.bytedance.sdk.openadsdk.preload.a.d.b.f68906e;
                } else {
                    a(it.next());
                    return f();
                }
            } else if (t instanceof o) {
                return com.bytedance.sdk.openadsdk.preload.a.d.b.f68904c;
            } else {
                if (t instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                    return com.bytedance.sdk.openadsdk.preload.a.d.b.f68902a;
                }
                if (t instanceof q) {
                    q qVar = (q) t;
                    if (qVar.p()) {
                        return com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f;
                    }
                    if (qVar.n()) {
                        return com.bytedance.sdk.openadsdk.preload.a.d.b.f68909h;
                    }
                    if (qVar.o()) {
                        return com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g;
                    }
                    throw new AssertionError();
                } else if (t instanceof com.bytedance.sdk.openadsdk.preload.a.n) {
                    return com.bytedance.sdk.openadsdk.preload.a.d.b.f68910i;
                } else {
                    if (t == f68711c) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.b) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String g() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68906e);
            Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
            String str = (String) entry.getKey();
            this.f68714f[this.f68713e - 1] = str;
            a(entry.getValue());
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
            if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g) {
                throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f + " but was " + f2 + v());
            }
            String b2 = ((q) u()).b();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return b2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public boolean i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68909h);
            boolean f2 = ((q) u()).f();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return f2;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void j() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68910i);
            u();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public double k() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
            if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f) {
                throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g + " but was " + f2 + v());
            }
            double c2 = ((q) t()).c();
            if (!q() && (Double.isNaN(c2) || Double.isInfinite(c2))) {
                throw new NumberFormatException("JSON forbids NaN and infinities: " + c2);
            }
            u();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return c2;
        }
        return invokeV.doubleValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public long l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
            if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f) {
                throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g + " but was " + f2 + v());
            }
            long d2 = ((q) t()).d();
            u();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return d2;
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public int m() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.d.b f2 = f();
            if (f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g && f2 != com.bytedance.sdk.openadsdk.preload.a.d.b.f68907f) {
                throw new IllegalStateException("Expected " + com.bytedance.sdk.openadsdk.preload.a.d.b.f68908g + " but was " + f2 + v());
            }
            int e2 = ((q) t()).e();
            u();
            int i2 = this.f68713e;
            if (i2 > 0) {
                int[] iArr = this.f68715g;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return e2;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f68906e) {
                g();
                this.f68714f[this.f68713e - 2] = StringUtil.NULL_STRING;
            } else {
                u();
                int i2 = this.f68713e;
                if (i2 > 0) {
                    this.f68714f[i2 - 1] = StringUtil.NULL_STRING;
                }
            }
            int i3 = this.f68713e;
            if (i3 > 0) {
                int[] iArr = this.f68715g;
                int i4 = i3 - 1;
                iArr[i4] = iArr[i4] + 1;
            }
        }
    }

    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.d.b.f68906e);
            Map.Entry entry = (Map.Entry) ((Iterator) t()).next();
            a(entry.getValue());
            a(new q((String) entry.getKey()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            int i2 = 0;
            while (i2 < this.f68713e) {
                Object[] objArr = this.f68712d;
                if (objArr[i2] instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                    i2++;
                    if (objArr[i2] instanceof Iterator) {
                        sb.append('[');
                        sb.append(this.f68715g[i2]);
                        sb.append(']');
                    }
                } else if (objArr[i2] instanceof o) {
                    i2++;
                    if (objArr[i2] instanceof Iterator) {
                        sb.append('.');
                        String[] strArr = this.f68714f;
                        if (strArr[i2] != null) {
                            sb.append(strArr[i2]);
                        }
                    }
                }
                i2++;
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.a
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? e.class.getSimpleName() : (String) invokeV.objValue;
    }

    private void a(com.bytedance.sdk.openadsdk.preload.a.d.b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, bVar) == null) || f() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + f() + v());
    }

    private void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, obj) == null) {
            int i2 = this.f68713e;
            Object[] objArr = this.f68712d;
            if (i2 == objArr.length) {
                int i3 = i2 * 2;
                this.f68712d = Arrays.copyOf(objArr, i3);
                this.f68715g = Arrays.copyOf(this.f68715g, i3);
                this.f68714f = (String[]) Arrays.copyOf(this.f68714f, i3);
            }
            Object[] objArr2 = this.f68712d;
            int i4 = this.f68713e;
            this.f68713e = i4 + 1;
            objArr2[i4] = obj;
        }
    }
}
