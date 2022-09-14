package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class gd extends fw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Exception a;

    /* renamed from: a  reason: collision with other field name */
    public Socket f424a;
    public XMPushService b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f425c;
    public String d;
    public volatile long e;
    public volatile long f;
    public volatile long g;
    public long h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd(XMPushService xMPushService, fx fxVar) {
        super(xMPushService, fxVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fxVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((XMPushService) objArr2[0], (fx) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f425c = null;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.b = xMPushService;
    }

    private void a(fx fxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, fxVar) == null) {
            a(fxVar.c(), fxVar.mo362a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x033f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i) {
        StringBuilder sb;
        long j;
        int i2;
        String str2;
        boolean z;
        Iterator<String> it;
        String str3;
        cr crVar;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, str, i) == null) {
            this.a = null;
            ArrayList<String> arrayList = new ArrayList<>();
            int intValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
            cr a = a(str);
            com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
            if (a != null) {
                arrayList = a.a(true);
            }
            cr d = cv.a().d(str);
            if (d != null) {
                Iterator<String> it2 = d.a(true).iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(str);
            }
            long j2 = 0;
            this.g = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String m195a = bj.m195a((Context) this.b);
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it3 = arrayList.iterator();
            String str10 = "";
            int i3 = 0;
            while (it3.hasNext()) {
                String next2 = it3.next();
                long currentTimeMillis = System.currentTimeMillis();
                ((fw) this).f405a++;
                int i4 = i3 + 1;
                try {
                    com.xiaomi.channel.commonutils.logger.b.m90a("begin to connect to " + next2);
                    this.f424a = a();
                    this.f424a.connect(ct.m250a(next2, i), 8000);
                    com.xiaomi.channel.commonutils.logger.b.m90a("tcp connected");
                    this.f424a.setTcpNoDelay(true);
                    this.d = next2;
                    a();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    ((fw) this).f406a = currentTimeMillis2;
                    ((fw) this).f415b = m195a;
                    if (a != null) {
                        it = it3;
                        sb = sb2;
                        str3 = m195a;
                        j = 0;
                        crVar = a;
                        try {
                            a.b(next2, currentTimeMillis2, 0L);
                        } catch (Exception e) {
                            e = e;
                            str4 = str10;
                            str5 = str3;
                            try {
                                this.a = e;
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next2);
                                sb.append(" port:");
                                sb.append(i);
                                sb.append(" err:");
                                sb.append(this.a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str4)) {
                                    str2 = next2;
                                } else {
                                    str2 = str4 + "|" + next2;
                                }
                                fj.a(next2, this.a);
                                if (crVar != null) {
                                    str7 = str5;
                                    crVar.b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                                } else {
                                    str7 = str5;
                                }
                            } catch (Throwable th) {
                                th = th;
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next2);
                                sb.append(" port:");
                                sb.append(i);
                                sb.append(" err:");
                                sb.append(this.a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str4)) {
                                    str8 = str4 + "|" + next2;
                                } else {
                                    str8 = next2;
                                }
                                fj.a(next2, this.a);
                                if (crVar == null) {
                                    str9 = str5;
                                    crVar.b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                                } else {
                                    str9 = str5;
                                }
                                if (!TextUtils.equals(str9, bj.m195a((Context) this.b))) {
                                    throw th;
                                }
                                str2 = str8;
                                i2 = i4;
                                z = false;
                                cv.a().m260c();
                                int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (!z) {
                                }
                            }
                            if (TextUtils.equals(str7, bj.m195a((Context) this.b))) {
                                str10 = str2;
                                sb2 = sb;
                                m195a = str7;
                                i3 = i4;
                                it3 = it;
                                j2 = j;
                                a = crVar;
                            } else {
                                i2 = i4;
                                z = false;
                                cv.a().m260c();
                                int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (!z) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                this.a = new Exception("abnormal exception", th);
                                com.xiaomi.channel.commonutils.logger.b.a(th);
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next2);
                                sb.append(" port:");
                                sb.append(i);
                                sb.append(" err:");
                                sb.append(this.a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str10)) {
                                    str2 = next2;
                                } else {
                                    str2 = str10 + "|" + next2;
                                }
                                fj.a(next2, this.a);
                                if (crVar != null) {
                                    crVar.b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.a);
                                }
                                str6 = str3;
                            } catch (Throwable th3) {
                                th = th3;
                                str4 = str10;
                                str5 = str3;
                                com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next2);
                                sb.append("SMACK: Could not connect to ");
                                sb.append(next2);
                                sb.append(" port:");
                                sb.append(i);
                                sb.append(" err:");
                                sb.append(this.a.getClass().getSimpleName());
                                sb.append("\n");
                                if (TextUtils.isEmpty(str4)) {
                                }
                                fj.a(next2, this.a);
                                if (crVar == null) {
                                }
                                if (!TextUtils.equals(str9, bj.m195a((Context) this.b))) {
                                }
                            }
                            if (TextUtils.equals(str6, bj.m195a((Context) this.b))) {
                                str7 = str6;
                                str10 = str2;
                                sb2 = sb;
                                m195a = str7;
                                i3 = i4;
                                it3 = it;
                                j2 = j;
                                a = crVar;
                            } else {
                                i2 = i4;
                                z = false;
                                cv.a().m260c();
                                int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (!z) {
                                }
                            }
                        }
                    } else {
                        it = it3;
                        sb = sb2;
                        str3 = m195a;
                        crVar = a;
                        j = 0;
                    }
                    this.g = SystemClock.elapsedRealtime();
                    com.xiaomi.channel.commonutils.logger.b.m90a("connected to " + next2 + " in " + ((fw) this).f406a);
                    str2 = str10;
                    i2 = i4;
                    z = true;
                    break;
                } catch (Exception e2) {
                    e = e2;
                    it = it3;
                    sb = sb2;
                    crVar = a;
                    j = 0;
                    str4 = str10;
                    str5 = m195a;
                } catch (Throwable th4) {
                    th = th4;
                    it = it3;
                    sb = sb2;
                    str3 = m195a;
                    crVar = a;
                    j = 0;
                }
            }
            sb = sb2;
            j = j2;
            i2 = i3;
            str2 = str10;
            z = false;
            cv.a().m260c();
            int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
            if (!z) {
                fj.a(0, ez.i.a(), elapsedRealtime2222, str2, i2);
                return;
            }
            if (this.h == j || SystemClock.elapsedRealtime() - this.h > 480000) {
                this.h = SystemClock.elapsedRealtime();
                fj.a(0, ez.j.a(), elapsedRealtime2222, str2, bj.c(this.b.getApplicationContext()) ? 1 : 0);
            }
            throw new gh(sb.toString());
        }
    }

    @Override // com.xiaomi.push.fw
    public cr a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            cr a = cv.a().a(str, false);
            if (!a.b()) {
                gz.a(new gg(this, str));
            }
            return a;
        }
        return (cr) invokeL.objValue;
    }

    @Override // com.xiaomi.push.fw
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.fw
    public Socket a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Socket() : (Socket) invokeV.objValue;
    }

    @Override // com.xiaomi.push.fw
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
            }
        }
    }

    public synchronized void a(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, exc) == null) {
            synchronized (this) {
                if (b() == 2) {
                    return;
                }
                a(2, i, exc);
                ((fw) this).f410a = "";
                try {
                    this.f424a.close();
                } catch (Throwable unused) {
                }
                this.e = 0L;
                this.f = 0L;
            }
        }
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            if (SystemClock.elapsedRealtime() - this.g < 300000) {
                if (!bj.b(this.b)) {
                    return;
                }
                int i = this.c + 1;
                this.c = i;
                if (i < 2) {
                    return;
                }
                String a = a();
                com.xiaomi.channel.commonutils.logger.b.m90a("max short conn time reached, sink down current host:" + a);
                a(a, 0L, exc);
            }
            this.c = 0;
        }
    }

    public void a(String str, long j, Exception exc) {
        cr a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j), exc}) == null) || (a = cv.a().a(fx.a(), false)) == null) {
            return;
        }
        a.b(str, j, 0L, exc);
        cv.a().m260c();
    }

    /* renamed from: a */
    public abstract void mo349a(boolean z);

    @Override // com.xiaomi.push.fw
    public void a(fl[] flVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, flVarArr) == null) {
            throw new gh("Don't support send Blob");
        }
    }

    @Override // com.xiaomi.push.fw
    public void b(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, exc) == null) {
            a(i, exc);
            if ((exc != null || i == 18) && this.g != 0) {
                a(exc);
            }
        }
    }

    @Override // com.xiaomi.push.fw
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long currentTimeMillis = System.currentTimeMillis();
            mo349a(z);
            com.xiaomi.push.service.o.a(this.b).m668c();
            if (z) {
                return;
            }
            this.b.a(new ge(this, 13, elapsedRealtime, currentTimeMillis), 10000L);
        }
    }

    @Override // com.xiaomi.push.fw
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ((fw) this).f410a : (String) invokeV.objValue;
    }

    public void c(int i, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, exc) == null) {
            this.b.a(new gf(this, 2, i, exc));
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                try {
                    if (!m361c() && !m360b()) {
                        a(0, 0, (Exception) null);
                        a(((fw) this).f407a);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m90a("WARNING: current xmpp has connected");
                } catch (IOException e) {
                    throw new gh(e);
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f = SystemClock.elapsedRealtime();
        }
    }
}
