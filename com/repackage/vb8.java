package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes7.dex */
public class vb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zb8 a;
    public ub8 b;
    public long c;

    public vb8(zb8 zb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zb8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 0L;
        this.a = zb8Var;
    }

    public void a() {
        ub8 ub8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ub8Var = this.b) == null) {
            return;
        }
        ub8Var.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(String str, cc8 cc8Var, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        xb8 xb8Var;
        int i6;
        xb8 xb8Var2;
        tb8 b;
        tb8 b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, cc8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int b3 = i3 <= 0 ? fb.d().b().b() : i3;
            int a = i <= 0 ? fb.d().a() : i;
            int b4 = i4 <= 0 ? fb.d().c().b() : i4;
            this.b = new ub8(this.a);
            while (i5 < a) {
                xb8 xb8Var3 = new xb8();
                int i7 = i5 + 1;
                try {
                    i6 = i5;
                    try {
                        boolean c = this.b.c(str, cc8Var, b3, b4, z, xb8Var3, z2);
                        this.a.d(xb8Var3);
                        tb8 b5 = tb8.b();
                        if (b5 != null) {
                            b5.c(this.a);
                            return c;
                        }
                        return c;
                    } catch (FileNotFoundException e) {
                        e = e;
                        xb8Var2 = xb8Var3;
                        this.a.b().b = -100;
                        String str2 = String.valueOf(this.a.b().b) + "|retryCount:" + i6 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.d(xb8Var2);
                        this.a.d(xb8Var2);
                        b2 = tb8.b();
                        i5 = b2 == null ? i7 : 0;
                        b2.c(this.a);
                    } catch (Exception e2) {
                        e = e2;
                        xb8Var = xb8Var3;
                        try {
                            this.a.b().b = -10;
                            String str3 = String.valueOf(this.a.b().b) + "|retryCount:" + i6 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.d(xb8Var);
                            this.a.d(xb8Var);
                            b2 = tb8.b();
                            if (b2 == null) {
                            }
                            b2.c(this.a);
                        } catch (Throwable th) {
                            th = th;
                            this.a.d(xb8Var);
                            b = tb8.b();
                            if (b != null) {
                                b.c(this.a);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        xb8Var = xb8Var3;
                        this.a.d(xb8Var);
                        b = tb8.b();
                        if (b != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    xb8Var2 = xb8Var3;
                    i6 = i5;
                } catch (Exception e4) {
                    e = e4;
                    xb8Var = xb8Var3;
                    i6 = i5;
                } catch (Throwable th3) {
                    th = th3;
                    xb8Var = xb8Var3;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ec, code lost:
        if (r4 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0247, code lost:
        if (r4 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0249, code lost:
        r4.c(r12.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x024e, code lost:
        r4 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(int i, int i2, int i3) {
        int i4;
        tb8 b;
        ub8 ub8Var;
        tb8 b2;
        ub8 ub8Var2;
        ub8 ub8Var3;
        tb8 b3;
        ub8 ub8Var4;
        ub8 ub8Var5;
        ub8 ub8Var6;
        ub8 ub8Var7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = fb.d().b().b();
            }
            if (i <= 0) {
                i = fb.d().a();
            }
            if (i3 <= 0) {
                i3 = fb.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            while (!this.a.b().a && z && i4 < i) {
                xb8 xb8Var = new xb8();
                this.a.d(xb8Var);
                try {
                    try {
                        try {
                            try {
                                try {
                                    ub8 ub8Var8 = new ub8(this.a);
                                    this.b = ub8Var8;
                                    ub8Var8.g(i2, i3, xb8Var);
                                } catch (Exception e) {
                                    String str = String.valueOf(this.a.b().b) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                                    this.a.b().c = -10;
                                    BdLog.e(e.getMessage());
                                    if (this.c <= 0 && (ub8Var4 = this.b) != null) {
                                        this.c = ub8Var4.f();
                                    }
                                    System.currentTimeMillis();
                                    this.a.e(xb8Var);
                                    b3 = tb8.b();
                                    if (b3 == null) {
                                        return;
                                    }
                                }
                            } catch (SocketException e2) {
                                String str2 = String.valueOf(this.a.b().b) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                                this.a.b().c = -12;
                                if (this.c <= 0 && (ub8Var3 = this.b) != null) {
                                    this.c = ub8Var3.f();
                                }
                                System.currentTimeMillis();
                                this.a.e(xb8Var);
                                b2 = tb8.b();
                            }
                        } catch (SocketTimeoutException e3) {
                            String str3 = String.valueOf(this.a.b().b) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                            this.a.b().c = -13;
                            if (this.c <= 0 && (ub8Var2 = this.b) != null) {
                                this.c = ub8Var2.f();
                            }
                            System.currentTimeMillis();
                            this.a.e(xb8Var);
                            b2 = tb8.b();
                        }
                    } catch (IllegalStateException e4) {
                        this.a.b().c = -19;
                        String str4 = "errorCode:" + String.valueOf(-19) + "|" + e4.getClass() + "|" + e4.getMessage() + "|getcontent_illegal_error";
                        if (this.c <= 0 && (ub8Var = this.b) != null) {
                            this.c = ub8Var.f();
                        }
                        System.currentTimeMillis();
                        this.a.e(xb8Var);
                        b = tb8.b();
                        if (b == null) {
                        }
                    }
                    if (this.a.b().b != 200) {
                        String str5 = this.a.b().b + "|retryCount:" + i4;
                        z = e(this.a.b().b);
                        if (this.c <= 0 && (ub8Var7 = this.b) != null) {
                            this.c = ub8Var7.f();
                        }
                        System.currentTimeMillis();
                        this.a.e(xb8Var);
                        b = tb8.b();
                        i4 = b == null ? i4 + 1 : 0;
                        b.c(this.a);
                    } else {
                        this.a.e(xb8Var);
                        if (this.c <= 0 && (ub8Var6 = this.b) != null) {
                            this.c = ub8Var6.f();
                        }
                        System.currentTimeMillis();
                        this.a.e(xb8Var);
                        b3 = tb8.b();
                        if (b3 == null) {
                            return;
                        }
                        b3.c(this.a);
                        return;
                    }
                } catch (Throwable th) {
                    if (this.c <= 0 && (ub8Var5 = this.b) != null) {
                        this.c = ub8Var5.f();
                    }
                    System.currentTimeMillis();
                    this.a.e(xb8Var);
                    tb8 b4 = tb8.b();
                    if (b4 != null) {
                        b4.c(this.a);
                    }
                    throw th;
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            zb8 zb8Var = this.a;
            if (zb8Var == null) {
                return false;
            }
            return zb8Var.b().a;
        }
        return invokeV.booleanValue;
    }

    public final boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
                return true;
            }
            return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public void f(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            if (this.a.a().e()) {
                h(i, i2, i3);
            } else {
                g(i, i2, i3);
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0120, code lost:
        if (r2 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0161, code lost:
        if (r2 == null) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0163, code lost:
        r2.c(r10.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b1, code lost:
        if (r2 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01fa, code lost:
        if (r2 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01fc, code lost:
        r2.c(r10.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0201, code lost:
        r2 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i, int i2, int i3) {
        tb8 b;
        ub8 ub8Var;
        ub8 ub8Var2;
        tb8 b2;
        ub8 ub8Var3;
        ub8 ub8Var4;
        ub8 ub8Var5;
        ub8 ub8Var6;
        ub8 ub8Var7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = fb.d().b().b();
            }
            if (i <= 0) {
                i = fb.d().a();
            }
            if (i3 <= 0) {
                i3 = fb.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            while (!this.a.b().a && z && i4 < i) {
                xb8 xb8Var = new xb8();
                int i5 = i4 + 1;
                try {
                    try {
                        try {
                            ub8 ub8Var8 = new ub8(this.a);
                            this.b = ub8Var8;
                            ub8Var8.o(i2, i3, xb8Var);
                        } catch (SocketTimeoutException e) {
                            this.a.b().c = -13;
                            BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                            BdLog.e(e.getMessage());
                            this.a.d(xb8Var);
                            if (this.c <= 0 && (ub8Var5 = this.b) != null) {
                                this.c = ub8Var5.f();
                            }
                            System.currentTimeMillis();
                            this.a.d(xb8Var);
                            b2 = tb8.b();
                        }
                    } catch (SocketException e2) {
                        this.a.b().c = -12;
                        BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e2.getMessage());
                        this.a.d(xb8Var);
                        if (this.c <= 0 && (ub8Var3 = this.b) != null) {
                            this.c = ub8Var3.f();
                        }
                        System.currentTimeMillis();
                        this.a.d(xb8Var);
                        b2 = tb8.b();
                    }
                } catch (UnsupportedOperationException unused) {
                    this.a.b().c = -14;
                    BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                    this.a.d(xb8Var);
                    if (this.c <= 0 && (ub8Var2 = this.b) != null) {
                        this.c = ub8Var2.f();
                    }
                    System.currentTimeMillis();
                    this.a.d(xb8Var);
                    b = tb8.b();
                } catch (Throwable th) {
                    try {
                        this.a.b().c = -10;
                        BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(th.getMessage());
                        this.a.d(xb8Var);
                        if (this.c <= 0 && (ub8Var = this.b) != null) {
                            this.c = ub8Var.f();
                        }
                        System.currentTimeMillis();
                        this.a.d(xb8Var);
                        b = tb8.b();
                    } catch (Throwable th2) {
                        if (this.c <= 0 && (ub8Var4 = this.b) != null) {
                            this.c = ub8Var4.f();
                        }
                        System.currentTimeMillis();
                        this.a.d(xb8Var);
                        tb8 b3 = tb8.b();
                        if (b3 != null) {
                            b3.c(this.a);
                        }
                        throw th2;
                    }
                }
                if (this.a.b().b != 200) {
                    String str = this.a.b().b + "|retryCount:" + i4;
                    boolean e3 = e(this.a.b().b);
                    this.a.d(xb8Var);
                    if (this.c <= 0 && (ub8Var7 = this.b) != null) {
                        this.c = ub8Var7.f();
                    }
                    System.currentTimeMillis();
                    this.a.d(xb8Var);
                    tb8 b4 = tb8.b();
                    if (b4 != null) {
                        b4.c(this.a);
                    }
                    z = e3;
                    i4 = i5;
                } else {
                    if (this.c <= 0 && (ub8Var6 = this.b) != null) {
                        this.c = ub8Var6.f();
                    }
                    System.currentTimeMillis();
                    this.a.d(xb8Var);
                    tb8 b5 = tb8.b();
                    if (b5 != null) {
                        b5.c(this.a);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0142, code lost:
        if (r3.m() != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x018d, code lost:
        if (r3.m() != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018f, code lost:
        r2.c(r10.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e7, code lost:
        if (r3.m() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023a, code lost:
        if (r3.m() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x023c, code lost:
        r2.c(r10.a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h(int i, int i2, int i3) {
        tb8 b;
        ub8 ub8Var;
        ub8 ub8Var2;
        tb8 b2;
        ub8 ub8Var3;
        ub8 ub8Var4;
        ub8 ub8Var5;
        ub8 ub8Var6;
        ub8 ub8Var7;
        ub8 ub8Var8;
        ub8 ub8Var9;
        ub8 ub8Var10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i2 = fb.d().b().b();
            }
            if (i <= 0) {
                i = fb.d().a();
            }
            if (i3 <= 0) {
                i3 = fb.d().c().b();
            }
            System.currentTimeMillis();
            boolean z = true;
            int i4 = 0;
            while (!this.a.b().a && z && i4 < i) {
                xb8 xb8Var = new xb8();
                int i5 = i4 + 1;
                try {
                    try {
                        try {
                            ub8 ub8Var11 = new ub8(this.a);
                            this.b = ub8Var11;
                            ub8Var11.n(i2, i3, xb8Var);
                        } catch (SocketException e) {
                            this.a.b().c = -12;
                            BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                            BdLog.e(e.getMessage());
                            this.a.d(xb8Var);
                            if (this.c <= 0 && (ub8Var6 = this.b) != null) {
                                this.c = ub8Var6.f();
                            }
                            System.currentTimeMillis();
                            this.a.d(xb8Var);
                            b2 = tb8.b();
                            if (b2 != null) {
                                ub8 ub8Var12 = this.b;
                                if (ub8Var12 != null) {
                                }
                            }
                            z = true;
                            i4 = i5;
                        }
                    } catch (SocketTimeoutException e2) {
                        this.a.b().c = -13;
                        BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(e2.getMessage());
                        this.a.d(xb8Var);
                        if (this.c <= 0 && (ub8Var3 = this.b) != null) {
                            this.c = ub8Var3.f();
                        }
                        System.currentTimeMillis();
                        this.a.d(xb8Var);
                        b2 = tb8.b();
                        if (b2 != null) {
                            ub8 ub8Var13 = this.b;
                            if (ub8Var13 != null) {
                            }
                        }
                        z = true;
                        i4 = i5;
                    }
                } catch (UnsupportedOperationException unused) {
                    this.a.b().c = -14;
                    BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                    this.a.d(xb8Var);
                    if (this.c <= 0 && (ub8Var2 = this.b) != null) {
                        this.c = ub8Var2.f();
                    }
                    System.currentTimeMillis();
                    this.a.d(xb8Var);
                    b = tb8.b();
                    if (b != null) {
                        ub8 ub8Var14 = this.b;
                        if (ub8Var14 != null) {
                        }
                    }
                    z = false;
                    i4 = i5;
                } catch (Throwable th) {
                    try {
                        this.a.b().c = -10;
                        BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c17);
                        BdLog.e(th.getMessage());
                        this.a.d(xb8Var);
                        if (this.c <= 0 && (ub8Var = this.b) != null) {
                            this.c = ub8Var.f();
                        }
                        System.currentTimeMillis();
                        this.a.d(xb8Var);
                        b = tb8.b();
                        if (b != null) {
                            ub8 ub8Var15 = this.b;
                            if (ub8Var15 != null) {
                            }
                        }
                        z = false;
                        i4 = i5;
                    } catch (Throwable th2) {
                        if (this.c <= 0 && (ub8Var5 = this.b) != null) {
                            this.c = ub8Var5.f();
                        }
                        System.currentTimeMillis();
                        this.a.d(xb8Var);
                        tb8 b3 = tb8.b();
                        if (b3 != null && (ub8Var4 = this.b) != null && ub8Var4.m()) {
                            b3.c(this.a);
                        }
                        throw th2;
                    }
                }
                if (this.a.b().b != 200) {
                    String str = String.valueOf(this.a.b().b) + "|retryCount:" + i4;
                    boolean e3 = e(this.a.b().b);
                    this.a.d(xb8Var);
                    if (this.c <= 0 && (ub8Var10 = this.b) != null) {
                        this.c = ub8Var10.f();
                    }
                    System.currentTimeMillis();
                    this.a.d(xb8Var);
                    tb8 b4 = tb8.b();
                    if (b4 != null && (ub8Var9 = this.b) != null && ub8Var9.m()) {
                        b4.c(this.a);
                    }
                    z = e3;
                    i4 = i5;
                } else {
                    if (this.c <= 0 && (ub8Var8 = this.b) != null) {
                        this.c = ub8Var8.f();
                    }
                    System.currentTimeMillis();
                    this.a.d(xb8Var);
                    tb8 b5 = tb8.b();
                    if (b5 == null || (ub8Var7 = this.b) == null || !ub8Var7.m()) {
                        return;
                    }
                    b5.c(this.a);
                    return;
                }
            }
        }
    }

    public void i() {
        zb8 zb8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (zb8Var = this.a) == null) {
            return;
        }
        zb8Var.b().a = true;
    }
}
