package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes10.dex */
public class fe {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f77246a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public byte f381a;

    /* renamed from: a  reason: collision with other field name */
    public int f382a;

    /* renamed from: a  reason: collision with other field name */
    public short f383a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f77247b;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f77248a;

        /* renamed from: a  reason: collision with other field name */
        public static final d f384a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1658235588, "Lcom/xiaomi/push/fe$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1658235588, "Lcom/xiaomi/push/fe$a;");
                    return;
                }
            }
            f77248a = new c();
            f384a = new d();
        }

        public static byte[] a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? a(bArr, f384a) : (byte[]) invokeL.objValue;
        }

        public static byte[] a(byte[] bArr, b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bVar)) == null) {
                if (fe.m316a(bArr)) {
                    fe a2 = fe.a(bArr);
                    return (a2.f381a == 0 || a2.f381a != bVar.a()) ? a2.f77247b : bVar.a(a2.f77247b, a2.f382a);
                }
                return bArr;
            }
            return (byte[]) invokeLL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        byte a();

        byte[] a(byte[] bArr, int i2);
    }

    /* loaded from: classes10.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.xiaomi.push.fe.b
        public byte a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (byte) 2;
            }
            return invokeV.byteValue;
        }

        @Override // com.xiaomi.push.fe.b
        public byte[] a(byte[] bArr, int i2) {
            InterceptResult invokeLI;
            GZIPInputStream gZIPInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2)) == null) {
                GZIPInputStream gZIPInputStream2 = null;
                try {
                    gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr), i2);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr2 = new byte[i2];
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56374943, "Lcom/xiaomi/push/fe;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56374943, "Lcom/xiaomi/push/fe;");
                return;
            }
        }
        f77246a = new byte[]{80, 85, 83, 72};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fe(byte b2, int i2, byte[] bArr) {
        this((short) 1, b2, i2, bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Byte.valueOf(b2), Integer.valueOf(i2), bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Short) objArr2[0]).shortValue(), ((Byte) objArr2[1]).byteValue(), ((Integer) objArr2[2]).intValue(), (byte[]) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public fe(short s, byte b2, int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i2), bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f383a = (short) 1;
        this.f383a = s;
        this.f381a = b2;
        this.f382a = i2;
        this.f77247b = bArr;
    }

    public static fe a(byte b2, int i2, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Byte.valueOf(b2), Integer.valueOf(i2), bArr})) == null) ? new fe(b2, i2, bArr) : (fe) invokeCommon.objValue;
    }

    public static fe a(short s, byte b2, int i2, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i2), bArr})) == null) ? new fe(s, b2, i2, bArr) : (fe) invokeCommon.objValue;
    }

    public static fe a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (m316a(bArr)) {
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
                order.getInt();
                short s = order.getShort();
                byte b2 = order.get();
                int i2 = order.getInt();
                byte[] bArr2 = new byte[order.getInt()];
                order.get(bArr2);
                return a(s, b2, i2, bArr2);
            }
            return a((byte) 0, bArr.length, bArr);
        }
        return (fe) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m316a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) {
            byte[] bArr2 = f77246a;
            return a(bArr2, bArr, bArr2.length);
        }
        return invokeL.booleanValue;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, bArr, bArr2, i2)) == null) {
            if (bArr.length < i2 || bArr2.length < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
