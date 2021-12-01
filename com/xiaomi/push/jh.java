package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ix;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class jh extends ix {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f63214b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static int f63215c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public static int f63216d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static int f63217e = 10485760;

    /* renamed from: f  reason: collision with root package name */
    public static int f63218f = 104857600;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends ix.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(false, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.xiaomi.push.ix.a, com.xiaomi.push.jd
        public jb a(jl jlVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jlVar)) == null) {
                jh jhVar = new jh(jlVar, ((ix.a) this).f813a, this.f63212b);
                int i2 = ((ix.a) this).a;
                if (i2 != 0) {
                    jhVar.b(i2);
                }
                return jhVar;
            }
            return (jb) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56371006, "Lcom/xiaomi/push/jh;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56371006, "Lcom/xiaomi/push/jh;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh(jl jlVar, boolean z, boolean z2) {
        super(jlVar, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jlVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((jl) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public iz a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte a2 = a();
            int a3 = a();
            if (a3 <= f63215c) {
                return new iz(a2, a3);
            }
            throw new jc(3, "Thrift list size " + a3 + " out of range!");
        }
        return (iz) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public ja a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte a2 = a();
            byte a3 = a();
            int a4 = a();
            if (a4 <= f63214b) {
                return new ja(a2, a3, a4);
            }
            throw new jc(3, "Thrift map size " + a4 + " out of range!");
        }
        return (ja) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public jf a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte a2 = a();
            int a3 = a();
            if (a3 <= f63216d) {
                return new jf(a2, a3);
            }
            throw new jc(3, "Thrift set size " + a3 + " out of range!");
        }
        return (jf) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int a2 = a();
            if (a2 > f63217e) {
                throw new jc(3, "Thrift string size " + a2 + " out of range!");
            } else if (((jb) this).a.b() >= a2) {
                try {
                    String str = new String(((jb) this).a.m583a(), ((jb) this).a.a(), a2, "UTF-8");
                    ((jb) this).a.a(a2);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new iv("JVM DOES NOT SUPPORT UTF-8");
                }
            } else {
                return a(a2);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ix, com.xiaomi.push.jb
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int a2 = a();
            if (a2 > f63218f) {
                throw new jc(3, "Thrift binary size " + a2 + " out of range!");
            }
            c(a2);
            if (((jb) this).a.b() >= a2) {
                ByteBuffer wrap = ByteBuffer.wrap(((jb) this).a.m583a(), ((jb) this).a.a(), a2);
                ((jb) this).a.a(a2);
                return wrap;
            }
            byte[] bArr = new byte[a2];
            ((jb) this).a.b(bArr, 0, a2);
            return ByteBuffer.wrap(bArr);
        }
        return (ByteBuffer) invokeV.objValue;
    }
}
