package com.xiaomi.push.service;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
/* loaded from: classes10.dex */
public class be {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f77784a = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f929a;

    /* renamed from: b  reason: collision with root package name */
    public int f77785b;

    /* renamed from: c  reason: collision with root package name */
    public int f77786c;

    /* renamed from: d  reason: collision with root package name */
    public int f77787d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1071163139, "Lcom/xiaomi/push/service/be;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1071163139, "Lcom/xiaomi/push/service/be;");
        }
    }

    public be() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f77787d = IMediaPlayer.SHARED_PLAYER_ON_INFO_EXTRA;
        this.f929a = new byte[256];
        this.f77786c = 0;
        this.f77785b = 0;
    }

    public static int a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) ? b2 >= 0 ? b2 : b2 + 256 : invokeB.intValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f77786c = 0;
            this.f77785b = 0;
        }
    }

    private void a(int i2, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), bArr, Boolean.valueOf(z)}) == null) {
            int length = bArr.length;
            for (int i3 = 0; i3 < 256; i3++) {
                this.f929a[i3] = (byte) i3;
            }
            this.f77786c = 0;
            this.f77785b = 0;
            while (true) {
                int i4 = this.f77785b;
                if (i4 >= i2) {
                    break;
                }
                int a2 = ((this.f77786c + a(this.f929a[i4])) + a(bArr[this.f77785b % length])) % 256;
                this.f77786c = a2;
                a(this.f929a, this.f77785b, a2);
                this.f77785b++;
            }
            if (i2 != 256) {
                this.f77787d = ((this.f77786c + a(this.f929a[i2])) + a(bArr[i2 % length])) % 256;
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("S_");
                int i5 = i2 - 1;
                sb.append(i5);
                sb.append(":");
                for (int i6 = 0; i6 <= i2; i6++) {
                    sb.append(" ");
                    sb.append(a(this.f929a[i6]));
                }
                sb.append("   j_");
                sb.append(i5);
                sb.append("=");
                sb.append(this.f77786c);
                sb.append("   j_");
                sb.append(i2);
                sb.append("=");
                sb.append(this.f77787d);
                sb.append("   S_");
                sb.append(i5);
                sb.append("[j_");
                sb.append(i5);
                sb.append("]=");
                sb.append(a(this.f929a[this.f77786c]));
                sb.append("   S_");
                sb.append(i5);
                sb.append("[j_");
                sb.append(i2);
                sb.append("]=");
                sb.append(a(this.f929a[this.f77787d]));
                if (this.f929a[1] != 0) {
                    sb.append("   S[1]!=0");
                }
                com.xiaomi.channel.commonutils.logger.b.m73a(sb.toString());
            }
        }
    }

    private void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bArr) == null) {
            a(256, bArr, false);
        }
    }

    public static void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2, i3) == null) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
    }

    public static byte[] a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            byte[] m183a = com.xiaomi.push.bj.m183a(str);
            byte[] bytes = str2.getBytes();
            byte[] bArr = new byte[m183a.length + 1 + bytes.length];
            for (int i2 = 0; i2 < m183a.length; i2++) {
                bArr[i2] = m183a[i2];
            }
            bArr[m183a.length] = 95;
            for (int i3 = 0; i3 < bytes.length; i3++) {
                bArr[m183a.length + 1 + i3] = bytes[i3];
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bArr, str)) == null) ? a(bArr, com.xiaomi.push.bj.m183a(str)) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, bArr2)) == null) {
            byte[] bArr3 = new byte[bArr2.length];
            be beVar = new be();
            beVar.a(bArr);
            beVar.a();
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr3[i2] = (byte) (bArr2[i2] ^ beVar.m613a());
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i2, int i3) {
        InterceptResult invokeCommon;
        byte[] bArr3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{bArr, bArr2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i2 < 0 || i2 > bArr2.length || i2 + i3 > bArr2.length) {
                throw new IllegalArgumentException("start = " + i2 + " len = " + i3);
            }
            if (z) {
                bArr3 = bArr2;
                i4 = i2;
            } else {
                bArr3 = new byte[i3];
                i4 = 0;
            }
            be beVar = new be();
            beVar.a(bArr);
            beVar.a();
            for (int i5 = 0; i5 < i3; i5++) {
                bArr3[i4 + i5] = (byte) (bArr2[i2 + i5] ^ beVar.m613a());
            }
            return bArr3;
        }
        return (byte[]) invokeCommon.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte m613a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = (this.f77785b + 1) % 256;
            this.f77785b = i2;
            int a2 = (this.f77786c + a(this.f929a[i2])) % 256;
            this.f77786c = a2;
            a(this.f929a, this.f77785b, a2);
            byte[] bArr = this.f929a;
            return bArr[(a(bArr[this.f77785b]) + a(this.f929a[this.f77786c])) % 256];
        }
        return invokeV.byteValue;
    }
}
