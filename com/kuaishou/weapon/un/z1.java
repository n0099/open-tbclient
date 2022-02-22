package com.kuaishou.weapon.un;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.zip.CRC32;
/* loaded from: classes4.dex */
public class z1 {
    public static /* synthetic */ Interceptable $ic;
    public static z1 k;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Context f55534b;

    /* renamed from: c  reason: collision with root package name */
    public d f55535c;

    /* renamed from: d  reason: collision with root package name */
    public volatile String f55536d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f55537e;

    /* renamed from: f  reason: collision with root package name */
    public volatile String f55538f;

    /* renamed from: g  reason: collision with root package name */
    public int f55539g;

    /* renamed from: h  reason: collision with root package name */
    public int f55540h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f55541i;

    /* renamed from: j  reason: collision with root package name */
    public HandlerThread f55542j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z1 a;

        public a(z1 z1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long h2 = this.a.f55535c.h();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h2 >= this.a.f55535c.b(d.e0, 10) * 1000) {
                    z1.c(this.a);
                    this.a.e();
                    this.a.f55535c.e(currentTimeMillis);
                    this.a.f55535c.b(d.f55247d, this.a.f55536d);
                    this.a.f55535c.c(d.f55248e, this.a.f55537e);
                }
            }
        }
    }

    public z1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f55538f = "";
        this.f55539g = -1;
        this.f55540h = -1;
        this.f55542j = new HandlerThread("tokenFKHandlerThread");
        this.f55534b = context;
        this.f55535c = new d(context);
    }

    public static synchronized z1 a(Context context) {
        InterceptResult invokeL;
        z1 z1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (z1.class) {
                try {
                    if (k == null) {
                        k = new z1(context);
                    }
                    z1Var = k;
                } catch (Exception unused) {
                    return null;
                }
            }
            return z1Var;
        }
        return (z1) invokeL.objValue;
    }

    public static /* synthetic */ int c(z1 z1Var) {
        int i2 = z1Var.f55537e;
        z1Var.f55537e = i2 + 1;
        return i2;
    }

    private void c() {
        String c2;
        Context context;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                String e2 = this.f55535c.e(d.f55249f);
                if (TextUtils.isEmpty(e2)) {
                    e2 = UUID.randomUUID().toString();
                }
                this.f55535c.b(d.f55249f, e2);
                boolean b3 = this.f55535c.b(d.Z0);
                boolean b4 = this.f55535c.b(d.a1);
                if (b3 || b4) {
                    c2 = x0.c(this.f55534b);
                    if (!TextUtils.isEmpty(c2) && !c2.contains("RISK_")) {
                        b2 = 1;
                        this.f55535c.b(d.f55250g, c2);
                        this.f55535c.c(d.f55251h, b2);
                        byte[] d2 = s1.d((e2 + " " + l1.l() + " " + c2).getBytes());
                        byte[] array = ByteBuffer.allocate(2).putShort((short) 0).array();
                        byte[] array2 = ByteBuffer.allocate(4).putInt(0).array();
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        byte[] array3 = ByteBuffer.allocate(4).putInt(Integer.parseInt(valueOf.substring(0, valueOf.length() - 3))).array();
                        byte[] array4 = ByteBuffer.allocate(4).putInt((int) (Math.random() * 1.0E9d)).array();
                        byte[] array5 = ByteBuffer.allocate(4).putInt(0).array();
                        int length = d2.length + 2 + array.length + array2.length + array3.length + array4.length + array5.length + ByteBuffer.allocate(2).putShort((short) 0).array().length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(d2, 0, bArr, 0, d2.length);
                        bArr[d2.length] = b2;
                        bArr[d2.length + 1] = 1;
                        System.arraycopy(array, 0, bArr, d2.length + 2, array.length);
                        System.arraycopy(array2, 0, bArr, d2.length + 2 + array.length, array2.length);
                        System.arraycopy(array3, 0, bArr, d2.length + 2 + array.length + array2.length, array3.length);
                        System.arraycopy(array4, 0, bArr, d2.length + 2 + array.length + array2.length + array3.length, array4.length);
                        System.arraycopy(array5, 0, bArr, d2.length + 2 + array.length + array2.length + array3.length + array4.length, array5.length);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr);
                        byte[] array6 = ByteBuffer.allocate(8).putLong(crc32.getValue()).array();
                        byte[] bArr2 = new byte[array6.length + length];
                        System.arraycopy(bArr, 0, bArr2, 0, length);
                        System.arraycopy(array6, 0, bArr2, length, array6.length);
                        String str = new String(k1.a(r1.u.getBytes(), 2));
                        byte[] c3 = i1.c(str, str, bArr2);
                        this.f55536d = k1.c(c3, 2);
                        byte[] array7 = ByteBuffer.allocate(4).putInt(1).array();
                        byte[] bArr3 = new byte[c3.length + array7.length];
                        System.arraycopy(c3, 0, bArr3, 0, c3.length);
                        System.arraycopy(array7, 0, bArr3, c3.length, array7.length);
                        this.f55538f = k1.c(bArr3, 2);
                    }
                    context = this.f55534b;
                } else {
                    context = this.f55534b;
                }
                c2 = l1.g(context).replace("ANDROID_", "");
                b2 = 3;
                this.f55535c.b(d.f55250g, c2);
                this.f55535c.c(d.f55251h, b2);
                byte[] d22 = s1.d((e2 + " " + l1.l() + " " + c2).getBytes());
                byte[] array8 = ByteBuffer.allocate(2).putShort((short) 0).array();
                byte[] array22 = ByteBuffer.allocate(4).putInt(0).array();
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                byte[] array32 = ByteBuffer.allocate(4).putInt(Integer.parseInt(valueOf2.substring(0, valueOf2.length() - 3))).array();
                byte[] array42 = ByteBuffer.allocate(4).putInt((int) (Math.random() * 1.0E9d)).array();
                byte[] array52 = ByteBuffer.allocate(4).putInt(0).array();
                int length2 = d22.length + 2 + array8.length + array22.length + array32.length + array42.length + array52.length + ByteBuffer.allocate(2).putShort((short) 0).array().length;
                byte[] bArr4 = new byte[length2];
                System.arraycopy(d22, 0, bArr4, 0, d22.length);
                bArr4[d22.length] = b2;
                bArr4[d22.length + 1] = 1;
                System.arraycopy(array8, 0, bArr4, d22.length + 2, array8.length);
                System.arraycopy(array22, 0, bArr4, d22.length + 2 + array8.length, array22.length);
                System.arraycopy(array32, 0, bArr4, d22.length + 2 + array8.length + array22.length, array32.length);
                System.arraycopy(array42, 0, bArr4, d22.length + 2 + array8.length + array22.length + array32.length, array42.length);
                System.arraycopy(array52, 0, bArr4, d22.length + 2 + array8.length + array22.length + array32.length + array42.length, array52.length);
                CRC32 crc322 = new CRC32();
                crc322.update(bArr4);
                byte[] array62 = ByteBuffer.allocate(8).putLong(crc322.getValue()).array();
                byte[] bArr22 = new byte[array62.length + length2];
                System.arraycopy(bArr4, 0, bArr22, 0, length2);
                System.arraycopy(array62, 0, bArr22, length2, array62.length);
                String str2 = new String(k1.a(r1.u.getBytes(), 2));
                byte[] c32 = i1.c(str2, str2, bArr22);
                this.f55536d = k1.c(c32, 2);
                byte[] array72 = ByteBuffer.allocate(4).putInt(1).array();
                byte[] bArr32 = new byte[c32.length + array72.length];
                System.arraycopy(c32, 0, bArr32, 0, c32.length);
                System.arraycopy(array72, 0, bArr32, c32.length, array72.length);
                this.f55538f = k1.c(bArr32, 2);
            } catch (Throwable th) {
                this.f55536d = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8";
                try {
                    byte[] array9 = ByteBuffer.allocate(4).putInt(1).array();
                    byte[] a2 = k1.a(this.f55536d, 2);
                    byte[] bArr5 = new byte[a2.length + array9.length];
                    System.arraycopy(a2, 0, bArr5, 0, a2.length);
                    System.arraycopy(array9, 0, bArr5, a2.length, array9.length);
                    this.f55538f = k1.c(bArr5, 2);
                } catch (Exception unused) {
                    this.f55538f = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8AAAAAA==";
                }
                l1.a(th);
            }
        }
    }

    public static z1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? k : (z1) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            try {
                byte[] a2 = k1.a(this.f55536d, 2);
                byte[] bArr = new byte[a2.length + 4];
                System.arraycopy(a2, 0, bArr, 0, a2.length);
                byte[] array = ByteBuffer.allocate(4).putInt(this.f55537e).array();
                System.arraycopy(array, 0, bArr, a2.length, array.length);
                this.f55538f = k1.c(bArr, 2);
            } catch (Throwable unused) {
                this.f55536d = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8";
                this.f55538f = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8AAAAAA==";
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f55540h == -1) {
                this.f55540h = this.f55535c.a(d.f0, 0);
            }
            if (this.f55540h == 0) {
                return null;
            }
            if (this.f55539g == -1) {
                this.f55539g = this.f55535c.a(d.d0, 0);
            }
            if (this.f55539g == 0) {
                return StringUtil.NULL_STRING;
            }
            try {
                if (TextUtils.isEmpty(this.f55536d) || this.f55541i == null) {
                    b();
                } else {
                    this.f55541i.removeCallbacksAndMessages(null);
                    this.f55541i.postDelayed(new a(this), 1000L);
                }
            } catch (Exception unused) {
            }
            return this.f55538f;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str) || str.equals(this.f55536d)) {
                if (!TextUtils.isEmpty(str)) {
                    return;
                }
                str = this.f55535c.a(d.f55247d, "");
                if (TextUtils.isEmpty(str) || str.equals(this.f55536d)) {
                    return;
                }
            }
            this.f55537e = 0;
            this.f55536d = str;
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                try {
                } catch (Exception unused) {
                    this.f55536d = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8";
                    this.f55538f = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8AAAAAA==";
                }
                if (this.a) {
                    return;
                }
                this.a = true;
                if (this.f55539g == -1) {
                    this.f55539g = this.f55535c.a(d.d0, 0);
                }
                if (this.f55540h == -1) {
                    this.f55540h = this.f55535c.a(d.f0, 0);
                }
                if (this.f55539g == 0) {
                    return;
                }
                this.f55536d = this.f55535c.a(d.f55247d, "");
                this.f55537e = this.f55535c.b(d.f55248e, 0);
                if (this.f55542j != null) {
                    this.f55542j.start();
                    this.f55541i = new Handler(this.f55542j.getLooper());
                }
                if (TextUtils.isEmpty(this.f55536d)) {
                    this.f55537e = 0;
                    c();
                    this.f55535c.b(d.f55247d, this.f55536d);
                    this.f55535c.c(d.f55248e, this.f55537e);
                } else {
                    this.f55537e++;
                    this.f55535c.c(d.f55248e, this.f55537e);
                    byte[] a2 = k1.a(this.f55536d, 2);
                    byte[] bArr = new byte[a2.length + 4];
                    System.arraycopy(a2, 0, bArr, 0, a2.length);
                    byte[] array = ByteBuffer.allocate(4).putInt(this.f55537e).array();
                    System.arraycopy(array, 0, bArr, a2.length, array.length);
                    this.f55538f = k1.c(bArr, 2);
                }
            }
        }
    }
}
