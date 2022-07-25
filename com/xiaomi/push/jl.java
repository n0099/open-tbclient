package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.jb;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class jl extends jb {
    public static /* synthetic */ Interceptable $ic = null;
    public static int b = 10000;
    public static int c = 10000;
    public static int d = 10000;
    public static int e = 10485760;
    public static int f = 104857600;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends jb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(false, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, boolean z2, int i) {
            super(z, z2, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.xiaomi.push.jb.a, com.xiaomi.push.jh
        public jf a(jp jpVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jpVar)) == null) {
                jl jlVar = new jl(jpVar, ((jb.a) this).f807a, this.b);
                int i = ((jb.a) this).a;
                if (i != 0) {
                    jlVar.b(i);
                }
                return jlVar;
            }
            return (jf) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56370882, "Lcom/xiaomi/push/jl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56370882, "Lcom/xiaomi/push/jl;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jl(jp jpVar, boolean z, boolean z2) {
        super(jpVar, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jpVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((jp) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    public jd a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            byte a2 = a();
            int a3 = a();
            if (a3 <= c) {
                return new jd(a2, a3);
            }
            throw new jg(3, "Thrift list size " + a3 + " out of range!");
        }
        return (jd) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    public je a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte a2 = a();
            byte a3 = a();
            int a4 = a();
            if (a4 <= b) {
                return new je(a2, a3, a4);
            }
            throw new jg(3, "Thrift map size " + a4 + " out of range!");
        }
        return (je) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    public jj a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte a2 = a();
            int a3 = a();
            if (a3 <= d) {
                return new jj(a2, a3);
            }
            throw new jg(3, "Thrift set size " + a3 + " out of range!");
        }
        return (jj) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int a2 = a();
            if (a2 > e) {
                throw new jg(3, "Thrift string size " + a2 + " out of range!");
            } else if (((jf) this).a.b() >= a2) {
                try {
                    String str = new String(((jf) this).a.m556a(), ((jf) this).a.a(), a2, "UTF-8");
                    ((jf) this).a.a(a2);
                    return str;
                } catch (UnsupportedEncodingException unused) {
                    throw new iz("JVM DOES NOT SUPPORT UTF-8");
                }
            } else {
                return a(a2);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.jb, com.xiaomi.push.jf
    public ByteBuffer a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int a2 = a();
            if (a2 > f) {
                throw new jg(3, "Thrift binary size " + a2 + " out of range!");
            }
            c(a2);
            if (((jf) this).a.b() >= a2) {
                ByteBuffer wrap = ByteBuffer.wrap(((jf) this).a.m556a(), ((jf) this).a.a(), a2);
                ((jf) this).a.a(a2);
                return wrap;
            }
            byte[] bArr = new byte[a2];
            ((jf) this).a.b(bArr, 0, a2);
            return ByteBuffer.wrap(bArr);
        }
        return (ByteBuffer) invokeV.objValue;
    }
}
