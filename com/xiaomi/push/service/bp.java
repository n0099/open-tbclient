package com.xiaomi.push.service;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
/* loaded from: classes8.dex */
public class bp {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f969a;
    public int b;
    public int c;
    public int d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071163480, "Lcom/xiaomi/push/service/bp;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071163480, "Lcom/xiaomi/push/service/bp;");
        }
    }

    public bp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = IMediaPlayer.SHARED_PLAYER_ON_INFO_EXTRA;
        this.f969a = new byte[256];
        this.c = 0;
        this.b = 0;
    }

    public static int a(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b)) == null) ? b >= 0 ? b : b + 256 : invokeB.intValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.c = 0;
            this.b = 0;
        }
    }

    private void a(int i, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), bArr, Boolean.valueOf(z)}) == null) {
            int length = bArr.length;
            for (int i2 = 0; i2 < 256; i2++) {
                this.f969a[i2] = (byte) i2;
            }
            this.c = 0;
            this.b = 0;
            while (true) {
                int i3 = this.b;
                if (i3 >= i) {
                    break;
                }
                int a2 = ((this.c + a(this.f969a[i3])) + a(bArr[this.b % length])) % 256;
                this.c = a2;
                a(this.f969a, this.b, a2);
                this.b++;
            }
            if (i != 256) {
                this.d = ((this.c + a(this.f969a[i])) + a(bArr[i % length])) % 256;
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("S_");
                int i4 = i - 1;
                sb.append(i4);
                sb.append(":");
                for (int i5 = 0; i5 <= i; i5++) {
                    sb.append(" ");
                    sb.append(a(this.f969a[i5]));
                }
                sb.append("   j_");
                sb.append(i4);
                sb.append("=");
                sb.append(this.c);
                sb.append("   j_");
                sb.append(i);
                sb.append("=");
                sb.append(this.d);
                sb.append("   S_");
                sb.append(i4);
                sb.append("[j_");
                sb.append(i4);
                sb.append("]=");
                sb.append(a(this.f969a[this.c]));
                sb.append("   S_");
                sb.append(i4);
                sb.append("[j_");
                sb.append(i);
                sb.append("]=");
                sb.append(a(this.f969a[this.d]));
                if (this.f969a[1] != 0) {
                    sb.append("   S[1]!=0");
                }
                com.xiaomi.channel.commonutils.logger.b.m99a(sb.toString());
            }
        }
    }

    private void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, bArr) == null) {
            a(256, bArr, false);
        }
    }

    public static void a(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, null, bArr, i, i2) == null) {
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            byte[] m212a = com.xiaomi.push.bm.m212a(str);
            byte[] bytes = str2.getBytes();
            byte[] bArr = new byte[m212a.length + 1 + bytes.length];
            for (int i = 0; i < m212a.length; i++) {
                bArr[i] = m212a[i];
            }
            bArr[m212a.length] = 95;
            for (int i2 = 0; i2 < bytes.length; i2++) {
                bArr[m212a.length + 1 + i2] = bytes[i2];
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bArr, str)) == null) ? a(bArr, com.xiaomi.push.bm.m212a(str)) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr2.length];
            bp bpVar = new bp();
            bpVar.a(bArr);
            bpVar.a();
            for (int i = 0; i < bArr2.length; i++) {
                bArr3[i] = (byte) (bArr2[i] ^ bpVar.m656a());
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        byte[] bArr3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{bArr, bArr2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
                throw new IllegalArgumentException("start = " + i + " len = " + i2);
            }
            if (z) {
                bArr3 = bArr2;
                i3 = i;
            } else {
                bArr3 = new byte[i2];
                i3 = 0;
            }
            bp bpVar = new bp();
            bpVar.a(bArr);
            bpVar.a();
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ bpVar.m656a());
            }
            return bArr3;
        }
        return (byte[]) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte m656a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = (this.b + 1) % 256;
            this.b = i;
            int a2 = (this.c + a(this.f969a[i])) % 256;
            this.c = a2;
            a(this.f969a, this.b, a2);
            byte[] bArr = this.f969a;
            return bArr[(a(bArr[this.b]) + a(this.f969a[this.c])) % 256];
        }
        return invokeV.byteValue;
    }
}
