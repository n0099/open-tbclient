package com.kwad.sdk.glide.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f37613a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f37614b;

    /* renamed from: c  reason: collision with root package name */
    public c f37615c;

    /* renamed from: d  reason: collision with root package name */
    public int f37616d;

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
                return;
            }
        }
        this.f37613a = new byte[256];
        this.f37616d = 0;
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
            boolean z = false;
            while (!z && !o() && this.f37615c.f37606c <= i2) {
                int m = m();
                if (m == 33) {
                    int m2 = m();
                    if (m2 != 1) {
                        if (m2 == 249) {
                            this.f37615c.f37607d = new b();
                            e();
                        } else if (m2 != 254 && m2 == 255) {
                            l();
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < 11; i3++) {
                                sb.append((char) this.f37613a[i3]);
                            }
                            if (sb.toString().equals("NETSCAPE2.0")) {
                                g();
                            }
                        }
                    }
                    k();
                } else if (m == 44) {
                    c cVar = this.f37615c;
                    if (cVar.f37607d == null) {
                        cVar.f37607d = new b();
                    }
                    f();
                } else if (m != 59) {
                    this.f37615c.f37605b = 1;
                } else {
                    z = true;
                }
            }
        }
    }

    @Nullable
    private int[] b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            byte[] bArr = new byte[i2 * 3];
            int[] iArr = null;
            try {
                this.f37614b.get(bArr);
                iArr = new int[256];
                int i3 = 0;
                int i4 = 0;
                while (i3 < i2) {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = i3 + 1;
                    iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                    i4 = i7;
                    i3 = i8;
                }
            } catch (BufferUnderflowException e2) {
                if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                    Log.d(GifHeaderParser.TAG, "Format Error Reading Color Table", e2);
                }
                this.f37615c.f37605b = 1;
            }
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f37614b = null;
            Arrays.fill(this.f37613a, (byte) 0);
            this.f37615c = new c();
            this.f37616d = 0;
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            a(Integer.MAX_VALUE);
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            m();
            int m = m();
            b bVar = this.f37615c.f37607d;
            int i2 = (m & 28) >> 2;
            bVar.f37601g = i2;
            if (i2 == 0) {
                bVar.f37601g = 1;
            }
            this.f37615c.f37607d.f37600f = (m & 1) != 0;
            int n = n();
            if (n < 2) {
                n = 10;
            }
            b bVar2 = this.f37615c.f37607d;
            bVar2.f37603i = n * 10;
            bVar2.f37602h = m();
            m();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f37615c.f37607d.f37595a = n();
            this.f37615c.f37607d.f37596b = n();
            this.f37615c.f37607d.f37597c = n();
            this.f37615c.f37607d.f37598d = n();
            int m = m();
            boolean z = (m & 128) != 0;
            int pow = (int) Math.pow(2.0d, (m & 7) + 1);
            this.f37615c.f37607d.f37599e = (m & 64) != 0;
            b bVar = this.f37615c.f37607d;
            if (z) {
                bVar.k = b(pow);
            } else {
                bVar.k = null;
            }
            this.f37615c.f37607d.j = this.f37614b.position();
            j();
            if (o()) {
                return;
            }
            c cVar = this.f37615c;
            cVar.f37606c++;
            cVar.f37608e.add(cVar.f37607d);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            do {
                l();
                byte[] bArr = this.f37613a;
                if (bArr[0] == 1) {
                    this.f37615c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                }
                if (this.f37616d <= 0) {
                    return;
                }
            } while (!o());
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 6; i2++) {
                sb.append((char) m());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.f37615c.f37605b = 1;
                return;
            }
            i();
            if (!this.f37615c.f37611h || o()) {
                return;
            }
            c cVar = this.f37615c;
            cVar.f37604a = b(cVar.f37612i);
            c cVar2 = this.f37615c;
            cVar2.l = cVar2.f37604a[cVar2.j];
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f37615c.f37609f = n();
            this.f37615c.f37610g = n();
            int m = m();
            this.f37615c.f37611h = (m & 128) != 0;
            this.f37615c.f37612i = (int) Math.pow(2.0d, (m & 7) + 1);
            this.f37615c.j = m();
            this.f37615c.k = m();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            m();
            k();
        }
    }

    private void k() {
        int m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            do {
                m = m();
                this.f37614b.position(Math.min(this.f37614b.position() + m, this.f37614b.limit()));
            } while (m > 0);
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            int m = m();
            this.f37616d = m;
            if (m > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < this.f37616d) {
                    try {
                        i3 = this.f37616d - i2;
                        this.f37614b.get(this.f37613a, i2, i3);
                        i2 += i3;
                    } catch (Exception e2) {
                        if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                            Log.d(GifHeaderParser.TAG, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f37616d, e2);
                        }
                        this.f37615c.f37605b = 1;
                        return;
                    }
                }
            }
        }
    }

    private int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            try {
                return this.f37614b.get() & 255;
            } catch (Exception unused) {
                this.f37615c.f37605b = 1;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    private int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.f37614b.getShort() : invokeV.intValue;
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.f37615c.f37605b != 0 : invokeV.booleanValue;
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            c();
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f37614b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f37614b.order(ByteOrder.LITTLE_ENDIAN);
            return this;
        }
        return (d) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f37614b = null;
            this.f37615c = null;
        }
    }

    @NonNull
    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f37614b != null) {
                if (o()) {
                    return this.f37615c;
                }
                h();
                if (!o()) {
                    d();
                    c cVar = this.f37615c;
                    if (cVar.f37606c < 0) {
                        cVar.f37605b = 1;
                    }
                }
                return this.f37615c;
            }
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        return (c) invokeV.objValue;
    }
}
