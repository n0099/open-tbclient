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
/* loaded from: classes5.dex */
public class z1 {
    public static /* synthetic */ Interceptable $ic;
    public static z1 k;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public Context b;
    public d c;
    public volatile String d;
    public volatile int e;
    public volatile String f;
    public int g;
    public int h;
    public Handler i;
    public HandlerThread j;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                long h = this.a.c.h();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - h >= this.a.c.b(d.e0, 10) * 1000) {
                    z1.c(this.a);
                    this.a.e();
                    this.a.c.e(currentTimeMillis);
                    this.a.c.b(d.d, this.a.d);
                    this.a.c.c(d.e, this.a.e);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f = "";
        this.g = -1;
        this.h = -1;
        this.j = new HandlerThread("tokenFKHandlerThread");
        this.b = context;
        this.c = new d(context);
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
        int i = z1Var.e;
        z1Var.e = i + 1;
        return i;
    }

    private void c() {
        String c;
        Context context;
        byte b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            try {
                String e = this.c.e(d.f);
                if (TextUtils.isEmpty(e)) {
                    e = UUID.randomUUID().toString();
                }
                this.c.b(d.f, e);
                boolean b2 = this.c.b(d.Z0);
                boolean b3 = this.c.b(d.a1);
                if (b2 || b3) {
                    c = x0.c(this.b);
                    if (!TextUtils.isEmpty(c) && !c.contains("RISK_")) {
                        b = 1;
                        this.c.b(d.g, c);
                        this.c.c(d.h, b);
                        byte[] d = s1.d((e + " " + l1.l() + " " + c).getBytes());
                        byte[] array = ByteBuffer.allocate(2).putShort((short) 0).array();
                        byte[] array2 = ByteBuffer.allocate(4).putInt(0).array();
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        byte[] array3 = ByteBuffer.allocate(4).putInt(Integer.parseInt(valueOf.substring(0, valueOf.length() - 3))).array();
                        byte[] array4 = ByteBuffer.allocate(4).putInt((int) (Math.random() * 1.0E9d)).array();
                        byte[] array5 = ByteBuffer.allocate(4).putInt(0).array();
                        int length = d.length + 2 + array.length + array2.length + array3.length + array4.length + array5.length + ByteBuffer.allocate(2).putShort((short) 0).array().length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(d, 0, bArr, 0, d.length);
                        bArr[d.length] = b;
                        bArr[d.length + 1] = 1;
                        System.arraycopy(array, 0, bArr, d.length + 2, array.length);
                        System.arraycopy(array2, 0, bArr, d.length + 2 + array.length, array2.length);
                        System.arraycopy(array3, 0, bArr, d.length + 2 + array.length + array2.length, array3.length);
                        System.arraycopy(array4, 0, bArr, d.length + 2 + array.length + array2.length + array3.length, array4.length);
                        System.arraycopy(array5, 0, bArr, d.length + 2 + array.length + array2.length + array3.length + array4.length, array5.length);
                        CRC32 crc32 = new CRC32();
                        crc32.update(bArr);
                        byte[] array6 = ByteBuffer.allocate(8).putLong(crc32.getValue()).array();
                        byte[] bArr2 = new byte[array6.length + length];
                        System.arraycopy(bArr, 0, bArr2, 0, length);
                        System.arraycopy(array6, 0, bArr2, length, array6.length);
                        String str = new String(k1.a(r1.u.getBytes(), 2));
                        byte[] c2 = i1.c(str, str, bArr2);
                        this.d = k1.c(c2, 2);
                        byte[] array7 = ByteBuffer.allocate(4).putInt(1).array();
                        byte[] bArr3 = new byte[c2.length + array7.length];
                        System.arraycopy(c2, 0, bArr3, 0, c2.length);
                        System.arraycopy(array7, 0, bArr3, c2.length, array7.length);
                        this.f = k1.c(bArr3, 2);
                    }
                    context = this.b;
                } else {
                    context = this.b;
                }
                c = l1.g(context).replace("ANDROID_", "");
                b = 3;
                this.c.b(d.g, c);
                this.c.c(d.h, b);
                byte[] d2 = s1.d((e + " " + l1.l() + " " + c).getBytes());
                byte[] array8 = ByteBuffer.allocate(2).putShort((short) 0).array();
                byte[] array22 = ByteBuffer.allocate(4).putInt(0).array();
                String valueOf2 = String.valueOf(System.currentTimeMillis());
                byte[] array32 = ByteBuffer.allocate(4).putInt(Integer.parseInt(valueOf2.substring(0, valueOf2.length() - 3))).array();
                byte[] array42 = ByteBuffer.allocate(4).putInt((int) (Math.random() * 1.0E9d)).array();
                byte[] array52 = ByteBuffer.allocate(4).putInt(0).array();
                int length2 = d2.length + 2 + array8.length + array22.length + array32.length + array42.length + array52.length + ByteBuffer.allocate(2).putShort((short) 0).array().length;
                byte[] bArr4 = new byte[length2];
                System.arraycopy(d2, 0, bArr4, 0, d2.length);
                bArr4[d2.length] = b;
                bArr4[d2.length + 1] = 1;
                System.arraycopy(array8, 0, bArr4, d2.length + 2, array8.length);
                System.arraycopy(array22, 0, bArr4, d2.length + 2 + array8.length, array22.length);
                System.arraycopy(array32, 0, bArr4, d2.length + 2 + array8.length + array22.length, array32.length);
                System.arraycopy(array42, 0, bArr4, d2.length + 2 + array8.length + array22.length + array32.length, array42.length);
                System.arraycopy(array52, 0, bArr4, d2.length + 2 + array8.length + array22.length + array32.length + array42.length, array52.length);
                CRC32 crc322 = new CRC32();
                crc322.update(bArr4);
                byte[] array62 = ByteBuffer.allocate(8).putLong(crc322.getValue()).array();
                byte[] bArr22 = new byte[array62.length + length2];
                System.arraycopy(bArr4, 0, bArr22, 0, length2);
                System.arraycopy(array62, 0, bArr22, length2, array62.length);
                String str2 = new String(k1.a(r1.u.getBytes(), 2));
                byte[] c22 = i1.c(str2, str2, bArr22);
                this.d = k1.c(c22, 2);
                byte[] array72 = ByteBuffer.allocate(4).putInt(1).array();
                byte[] bArr32 = new byte[c22.length + array72.length];
                System.arraycopy(c22, 0, bArr32, 0, c22.length);
                System.arraycopy(array72, 0, bArr32, c22.length, array72.length);
                this.f = k1.c(bArr32, 2);
            } catch (Throwable th) {
                this.d = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8";
                try {
                    byte[] array9 = ByteBuffer.allocate(4).putInt(1).array();
                    byte[] a2 = k1.a(this.d, 2);
                    byte[] bArr5 = new byte[a2.length + array9.length];
                    System.arraycopy(a2, 0, bArr5, 0, a2.length);
                    System.arraycopy(array9, 0, bArr5, a2.length, array9.length);
                    this.f = k1.c(bArr5, 2);
                } catch (Exception unused) {
                    this.f = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8AAAAAA==";
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
                byte[] a2 = k1.a(this.d, 2);
                byte[] bArr = new byte[a2.length + 4];
                System.arraycopy(a2, 0, bArr, 0, a2.length);
                byte[] array = ByteBuffer.allocate(4).putInt(this.e).array();
                System.arraycopy(array, 0, bArr, a2.length, array.length);
                this.f = k1.c(bArr, 2);
            } catch (Throwable unused) {
                this.d = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8";
                this.f = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8AAAAAA==";
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == -1) {
                this.h = this.c.a(d.f0, 0);
            }
            if (this.h == 0) {
                return null;
            }
            if (this.g == -1) {
                this.g = this.c.a(d.d0, 0);
            }
            if (this.g == 0) {
                return StringUtil.NULL_STRING;
            }
            try {
                if (TextUtils.isEmpty(this.d) || this.i == null) {
                    b();
                } else {
                    this.i.removeCallbacksAndMessages(null);
                    this.i.postDelayed(new a(this), 1000L);
                }
            } catch (Exception unused) {
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (TextUtils.isEmpty(str) || str.equals(this.d)) {
                if (!TextUtils.isEmpty(str)) {
                    return;
                }
                str = this.c.a(d.d, "");
                if (TextUtils.isEmpty(str) || str.equals(this.d)) {
                    return;
                }
            }
            this.e = 0;
            this.d = str;
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                try {
                } catch (Exception unused) {
                    this.d = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8";
                    this.f = "k7uScHh359Yzm5EBZWL1FnUqbNQIQgoi62qnRh115RoBSMNbVVwfqDuJ62OPICG8AAAAAA==";
                }
                if (this.a) {
                    return;
                }
                this.a = true;
                if (this.g == -1) {
                    this.g = this.c.a(d.d0, 0);
                }
                if (this.h == -1) {
                    this.h = this.c.a(d.f0, 0);
                }
                if (this.g == 0) {
                    return;
                }
                this.d = this.c.a(d.d, "");
                this.e = this.c.b(d.e, 0);
                if (this.j != null) {
                    this.j.start();
                    this.i = new Handler(this.j.getLooper());
                }
                if (TextUtils.isEmpty(this.d)) {
                    this.e = 0;
                    c();
                    this.c.b(d.d, this.d);
                    this.c.c(d.e, this.e);
                } else {
                    this.e++;
                    this.c.c(d.e, this.e);
                    byte[] a2 = k1.a(this.d, 2);
                    byte[] bArr = new byte[a2.length + 4];
                    System.arraycopy(a2, 0, bArr, 0, a2.length);
                    byte[] array = ByteBuffer.allocate(4).putInt(this.e).array();
                    System.arraycopy(array, 0, bArr, a2.length, array.length);
                    this.f = k1.c(bArr, 2);
                }
            }
        }
    }
}
