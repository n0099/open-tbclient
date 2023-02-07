package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;
/* loaded from: classes8.dex */
public class fp {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public byte f413a;

    /* renamed from: a  reason: collision with other field name */
    public int f414a;

    /* renamed from: a  reason: collision with other field name */
    public short f415a;
    public byte[] b;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;

        /* renamed from: a  reason: collision with other field name */
        public static final d f416a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1658563289, "Lcom/xiaomi/push/fp$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1658563289, "Lcom/xiaomi/push/fp$a;");
                    return;
                }
            }
            a = new c();
            f416a = new d();
        }

        public static byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? a(bArr, f416a) : (byte[]) invokeL.objValue;
        }

        public static byte[] a(byte[] bArr, b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bVar)) == null) {
                if (fp.m417a(bArr)) {
                    fp a2 = fp.a(bArr);
                    return (a2.f413a == 0 || a2.f413a != bVar.a()) ? a2.b : bVar.a(a2.b, a2.f414a);
                }
                return bArr;
            }
            return (byte[]) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i);
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.xiaomi.push.fp.b
        public byte a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (byte) 2;
            }
            return invokeV.byteValue;
        }

        @Override // com.xiaomi.push.fp.b
        public byte[] a(byte[] bArr, int i) {
            InterceptResult invokeLI;
            GZIPInputStream gZIPInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i)) == null) {
                GZIPInputStream gZIPInputStream2 = null;
                try {
                    gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream.read(bArr2);
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return bArr2;
                } catch (IOException unused3) {
                    gZIPInputStream2 = gZIPInputStream;
                    if (gZIPInputStream2 != null) {
                        try {
                            gZIPInputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPInputStream2 = gZIPInputStream;
                    if (gZIPInputStream2 != null) {
                        try {
                            gZIPInputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
            return (byte[]) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374602, "Lcom/xiaomi/push/fp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374602, "Lcom/xiaomi/push/fp;");
                return;
            }
        }
        a = new byte[]{80, 85, 83, 72};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fp(byte b2, int i, byte[] bArr) {
        this((short) 1, b2, i, bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Byte.valueOf(b2), Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Short) objArr2[0]).shortValue(), ((Byte) objArr2[1]).byteValue(), ((Integer) objArr2[2]).intValue(), (byte[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public fp(short s, byte b2, int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f415a = (short) 1;
        this.f415a = s;
        this.f413a = b2;
        this.f414a = i;
        this.b = bArr;
    }

    public static fp a(byte b2, int i, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i), bArr})) == null) ? new fp(b2, i, bArr) : (fp) invokeCommon.objValue;
    }

    public static fp a(short s, byte b2, int i, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i), bArr})) == null) ? new fp(s, b2, i, bArr) : (fp) invokeCommon.objValue;
    }

    public static fp a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (m417a(bArr)) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
                order.getInt();
                short s = order.getShort();
                byte b2 = order.get();
                int i = order.getInt();
                byte[] bArr2 = new byte[order.getInt()];
                order.get(bArr2);
                return a(s, b2, i, bArr2);
            }
            return a((byte) 0, bArr.length, bArr);
        }
        return (fp) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m417a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            byte[] bArr2 = a;
            return a(bArr2, bArr, bArr2.length);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, bArr, bArr2, i)) == null) {
            if (bArr.length < i || bArr2.length < i) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
