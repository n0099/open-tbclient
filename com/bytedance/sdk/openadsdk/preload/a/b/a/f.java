package com.bytedance.sdk.openadsdk.preload.a.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class f extends com.bytedance.sdk.openadsdk.preload.a.d.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Writer f67990a;

    /* renamed from: b  reason: collision with root package name */
    public static final q f67991b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.bytedance.sdk.openadsdk.preload.a.l> f67992c;

    /* renamed from: d  reason: collision with root package name */
    public String f67993d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.preload.a.l f67994e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523933401, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(523933401, "Lcom/bytedance/sdk/openadsdk/preload/a/b/a/f;");
                return;
            }
        }
        f67990a = new Writer() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.f.1
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

            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    throw new AssertionError();
                }
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i2, int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, cArr, i2, i3) == null) {
                    throw new AssertionError();
                }
            }
        };
        f67991b = new q("closed");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f() {
        super(f67990a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Writer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f67992c = new ArrayList();
        this.f67994e = com.bytedance.sdk.openadsdk.preload.a.n.f68222a;
    }

    private com.bytedance.sdk.openadsdk.preload.a.l j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            List<com.bytedance.sdk.openadsdk.preload.a.l> list = this.f67992c;
            return list.get(list.size() - 1);
        }
        return (com.bytedance.sdk.openadsdk.preload.a.l) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.a.l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f67992c.isEmpty()) {
                return this.f67994e;
            }
            throw new IllegalStateException("Expected one JSON element but was " + this.f67992c);
        }
        return (com.bytedance.sdk.openadsdk.preload.a.l) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.i iVar = new com.bytedance.sdk.openadsdk.preload.a.i();
            a(iVar);
            this.f67992c.add(iVar);
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (!this.f67992c.isEmpty() && this.f67993d == null) {
                if (j() instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                    List<com.bytedance.sdk.openadsdk.preload.a.l> list = this.f67992c;
                    list.remove(list.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.f67992c.isEmpty()) {
                this.f67992c.add(f67991b);
                return;
            }
            throw new IOException("Incomplete document");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o oVar = new o();
            a(oVar);
            this.f67992c.add(oVar);
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c e() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!this.f67992c.isEmpty() && this.f67993d == null) {
                if (j() instanceof o) {
                    List<com.bytedance.sdk.openadsdk.preload.a.l> list = this.f67992c;
                    list.remove(list.size() - 1);
                    return this;
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            a(com.bytedance.sdk.openadsdk.preload.a.n.f68222a);
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    private void a(com.bytedance.sdk.openadsdk.preload.a.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, lVar) == null) {
            if (this.f67993d != null) {
                if (!lVar.j() || i()) {
                    ((o) j()).a(this.f67993d, lVar);
                }
                this.f67993d = null;
            } else if (this.f67992c.isEmpty()) {
                this.f67994e = lVar;
            } else {
                com.bytedance.sdk.openadsdk.preload.a.l j2 = j();
                if (j2 instanceof com.bytedance.sdk.openadsdk.preload.a.i) {
                    ((com.bytedance.sdk.openadsdk.preload.a.i) j2).a(lVar);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c b(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str == null) {
                return f();
            }
            a(new q(str));
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                if (!this.f67992c.isEmpty() && this.f67993d == null) {
                    if (j() instanceof o) {
                        this.f67993d = str;
                        return this;
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
            throw new NullPointerException("name == null");
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            a(new q(Boolean.valueOf(z)));
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeZ.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Boolean bool) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
            if (bool == null) {
                return f();
            }
            a(new q(bool));
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            a(new q(Long.valueOf(j2)));
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.d.c
    public com.bytedance.sdk.openadsdk.preload.a.d.c a(Number number) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, number)) == null) {
            if (number == null) {
                return f();
            }
            if (!g()) {
                double doubleValue = number.doubleValue();
                if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                    throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
                }
            }
            a(new q(number));
            return this;
        }
        return (com.bytedance.sdk.openadsdk.preload.a.d.c) invokeL.objValue;
    }
}
