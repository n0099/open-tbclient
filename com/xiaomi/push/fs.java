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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes10.dex */
public abstract class fs extends fl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Exception f77473a;

    /* renamed from: a  reason: collision with other field name */
    public Socket f415a;

    /* renamed from: b  reason: collision with root package name */
    public XMPushService f77474b;

    /* renamed from: c  reason: collision with root package name */
    public int f77475c;

    /* renamed from: c  reason: collision with other field name */
    public String f416c;

    /* renamed from: d  reason: collision with root package name */
    public String f77476d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f77477e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f77478f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f77479g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs(XMPushService xMPushService, fm fmVar) {
        super(xMPushService, fmVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, fmVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((XMPushService) objArr2[0], (fm) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77473a = null;
        this.f416c = null;
        this.f77477e = 0L;
        this.f77478f = 0L;
        this.f77479g = 0L;
        this.f77474b = xMPushService;
    }

    private void a(fm fmVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, fmVar) == null) {
            a(fmVar.c(), fmVar.mo331a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x030d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, int i2) {
        StringBuilder sb;
        boolean z;
        String str2;
        Iterator<String> it;
        co coVar;
        String str3;
        String str4;
        String str5;
        String str6;
        co coVar2;
        String str7;
        String str8;
        String sb2;
        String str9;
        String str10;
        co coVar3;
        String str11;
        String str12;
        String str13;
        long currentTimeMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, str, i2) == null) {
            String str14 = "|";
            this.f77473a = null;
            ArrayList<String> arrayList = new ArrayList<>();
            int intValue = com.xiaomi.channel.commonutils.logger.b.a("get bucket for host : " + str).intValue();
            co a2 = a(str);
            com.xiaomi.channel.commonutils.logger.b.a(Integer.valueOf(intValue));
            if (a2 != null) {
                arrayList = a2.a(true);
            }
            if (arrayList.isEmpty()) {
                arrayList.add(str);
            }
            this.f77479g = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String m175a = bg.m175a((Context) this.f77474b);
            StringBuilder sb3 = new StringBuilder();
            Iterator<String> it2 = arrayList.iterator();
            String str15 = "";
            int i3 = 0;
            while (it2.hasNext()) {
                String next = it2.next();
                long currentTimeMillis2 = System.currentTimeMillis();
                ((fl) this).f396a++;
                int i4 = i3 + 1;
                try {
                    try {
                        try {
                            com.xiaomi.channel.commonutils.logger.b.m73a("begin to connect to " + next);
                            this.f415a = a();
                            it = it2;
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str14;
                            it = it2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        it = it2;
                        coVar = a2;
                        str3 = m175a;
                        str4 = str14;
                        sb = sb3;
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = str14;
                    it = it2;
                }
                try {
                    this.f415a.connect(cq.m229a(next, i2), 8000);
                    com.xiaomi.channel.commonutils.logger.b.m73a("tcp connected");
                    this.f415a.setTcpNoDelay(true);
                    this.f77476d = next;
                    a();
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                } catch (Exception e4) {
                    e = e4;
                    str2 = str14;
                    sb = sb3;
                    coVar = a2;
                    str3 = m175a;
                    str4 = str2;
                    try {
                        this.f77473a = e;
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i2);
                        sb.append(" err:");
                        sb.append(this.f77473a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (TextUtils.isEmpty(str15)) {
                        }
                        gz.a(next, this.f77473a);
                        if (coVar == null) {
                        }
                        if (TextUtils.equals(str12, bg.m175a((Context) this.f77474b))) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        coVar2 = coVar;
                        str2 = str4;
                        str7 = str3;
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i2);
                        sb.append(" err:");
                        sb.append(this.f77473a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (TextUtils.isEmpty(str15)) {
                            str13 = str15 + str2 + next;
                        } else {
                            str13 = next;
                        }
                        gz.a(next, this.f77473a);
                        if (coVar2 != null) {
                            coVar2.b(next, System.currentTimeMillis() - currentTimeMillis2, 0L, this.f77473a);
                        }
                        if (!TextUtils.equals(str7, bg.m175a((Context) this.f77474b))) {
                            throw th;
                        }
                        str15 = str13;
                        i3 = i4;
                        z = false;
                        cs.a().m239c();
                        int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (!z) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = str14;
                    str5 = str15;
                    str6 = m175a;
                    sb = sb3;
                    coVar = a2;
                    try {
                        this.f77473a = new Exception("abnormal exception", th);
                        com.xiaomi.channel.commonutils.logger.b.a(th);
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i2);
                        sb.append(" err:");
                        sb.append(this.f77473a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (TextUtils.isEmpty(str5)) {
                        }
                        gz.a(next, this.f77473a);
                        if (coVar != null) {
                        }
                        str10 = str6;
                        if (TextUtils.equals(str10, bg.m175a((Context) this.f77474b))) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str15 = str5;
                        coVar2 = coVar;
                        str7 = str6;
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i2);
                        sb.append(" err:");
                        sb.append(this.f77473a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (TextUtils.isEmpty(str15)) {
                        }
                        gz.a(next, this.f77473a);
                        if (coVar2 != null) {
                        }
                        if (!TextUtils.equals(str7, bg.m175a((Context) this.f77474b))) {
                        }
                    }
                }
                try {
                    ((fl) this).f397a = currentTimeMillis;
                    ((fl) this).f406b = m175a;
                    if (a2 != null) {
                        str5 = str15;
                        str2 = str14;
                        str6 = m175a;
                        sb = sb3;
                        coVar = a2;
                        try {
                            a2.b(next, currentTimeMillis, 0L);
                        } catch (Exception e5) {
                            e = e5;
                            next = next;
                            str15 = str5;
                            str3 = str6;
                            str4 = str2;
                            this.f77473a = e;
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next);
                            sb.append(" port:");
                            sb.append(i2);
                            sb.append(" err:");
                            sb.append(this.f77473a.getClass().getSimpleName());
                            sb.append(StringUtils.LF);
                            if (TextUtils.isEmpty(str15)) {
                                sb2 = str15 + str4 + next;
                            } else {
                                sb2 = next;
                            }
                            gz.a(next, this.f77473a);
                            if (coVar == null) {
                                coVar3 = coVar;
                                str11 = str4;
                                str12 = str3;
                                coVar.b(next, System.currentTimeMillis() - currentTimeMillis2, 0L, this.f77473a);
                            } else {
                                coVar3 = coVar;
                                str11 = str4;
                                str12 = str3;
                            }
                            if (TextUtils.equals(str12, bg.m175a((Context) this.f77474b))) {
                                str15 = sb2;
                                i3 = i4;
                                z = false;
                                cs.a().m239c();
                                int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (!z) {
                                }
                            } else {
                                str15 = sb2;
                                a2 = coVar3;
                                sb3 = sb;
                                m175a = str12;
                                i3 = i4;
                                it2 = it;
                                str14 = str11;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            next = next;
                            this.f77473a = new Exception("abnormal exception", th);
                            com.xiaomi.channel.commonutils.logger.b.a(th);
                            com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                            sb.append("SMACK: Could not connect to ");
                            sb.append(next);
                            sb.append(" port:");
                            sb.append(i2);
                            sb.append(" err:");
                            sb.append(this.f77473a.getClass().getSimpleName());
                            sb.append(StringUtils.LF);
                            if (TextUtils.isEmpty(str5)) {
                                sb2 = next;
                                str8 = str2;
                            } else {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(str5);
                                str8 = str2;
                                sb4.append(str8);
                                sb4.append(next);
                                sb2 = sb4.toString();
                            }
                            gz.a(next, this.f77473a);
                            if (coVar != null) {
                                String str16 = next;
                                str9 = str8;
                                coVar.b(str16, System.currentTimeMillis() - currentTimeMillis2, 0L, this.f77473a);
                            } else {
                                str9 = str8;
                            }
                            str10 = str6;
                            if (TextUtils.equals(str10, bg.m175a((Context) this.f77474b))) {
                                str15 = sb2;
                                coVar3 = coVar;
                                str11 = str9;
                                str12 = str10;
                                a2 = coVar3;
                                sb3 = sb;
                                m175a = str12;
                                i3 = i4;
                                it2 = it;
                                str14 = str11;
                            } else {
                                str15 = sb2;
                                i3 = i4;
                                z = false;
                                cs.a().m239c();
                                int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (!z) {
                                }
                            }
                        }
                    } else {
                        str2 = str14;
                        str5 = str15;
                        str6 = m175a;
                        sb = sb3;
                        coVar = a2;
                    }
                    this.f77479g = SystemClock.elapsedRealtime();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("connected to ");
                    next = next;
                    try {
                        sb5.append(next);
                        sb5.append(" in ");
                        sb5.append(((fl) this).f397a);
                        com.xiaomi.channel.commonutils.logger.b.m73a(sb5.toString());
                        i3 = i4;
                        str15 = str5;
                        z = true;
                        break;
                    } catch (Exception e6) {
                        e = e6;
                        str15 = str5;
                        str3 = str6;
                        str4 = str2;
                        this.f77473a = e;
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i2);
                        sb.append(" err:");
                        sb.append(this.f77473a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (TextUtils.isEmpty(str15)) {
                        }
                        gz.a(next, this.f77473a);
                        if (coVar == null) {
                        }
                        if (TextUtils.equals(str12, bg.m175a((Context) this.f77474b))) {
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        this.f77473a = new Exception("abnormal exception", th);
                        com.xiaomi.channel.commonutils.logger.b.a(th);
                        com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                        sb.append("SMACK: Could not connect to ");
                        sb.append(next);
                        sb.append(" port:");
                        sb.append(i2);
                        sb.append(" err:");
                        sb.append(this.f77473a.getClass().getSimpleName());
                        sb.append(StringUtils.LF);
                        if (TextUtils.isEmpty(str5)) {
                        }
                        gz.a(next, this.f77473a);
                        if (coVar != null) {
                        }
                        str10 = str6;
                        if (TextUtils.equals(str10, bg.m175a((Context) this.f77474b))) {
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    str2 = str14;
                    sb = sb3;
                    coVar = a2;
                    next = next;
                    str3 = m175a;
                    str4 = str2;
                    this.f77473a = e;
                    com.xiaomi.channel.commonutils.logger.b.d("SMACK: Could not connect to:" + next);
                    sb.append("SMACK: Could not connect to ");
                    sb.append(next);
                    sb.append(" port:");
                    sb.append(i2);
                    sb.append(" err:");
                    sb.append(this.f77473a.getClass().getSimpleName());
                    sb.append(StringUtils.LF);
                    if (TextUtils.isEmpty(str15)) {
                    }
                    gz.a(next, this.f77473a);
                    if (coVar == null) {
                    }
                    if (TextUtils.equals(str12, bg.m175a((Context) this.f77474b))) {
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str2 = str14;
                    str5 = str15;
                    str6 = m175a;
                    sb = sb3;
                    coVar = a2;
                }
            }
            sb = sb3;
            z = false;
            cs.a().m239c();
            int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
            if (!z) {
                gz.a(0, ew.f77421i.a(), elapsedRealtime2222, str15, i3);
                return;
            }
            gz.a(0, ew.f77422j.a(), elapsedRealtime2222, str15, bg.c(this.f77474b.getApplicationContext()) ? 1 : 0);
            throw new fw(sb.toString());
        }
    }

    @Override // com.xiaomi.push.fl
    public co a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            co a2 = cs.a().a(str, false);
            if (!a2.b()) {
                go.a(new fv(this, str));
            }
            return a2;
        }
        return (co) invokeL.objValue;
    }

    @Override // com.xiaomi.push.fl
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f77476d : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.fl
    public Socket a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Socket() : (Socket) invokeV.objValue;
    }

    @Override // com.xiaomi.push.fl
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
            }
        }
    }

    public synchronized void a(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, exc) == null) {
            synchronized (this) {
                if (b() == 2) {
                    return;
                }
                a(2, i2, exc);
                ((fl) this).f401a = "";
                try {
                    this.f415a.close();
                } catch (Throwable unused) {
                }
                this.f77477e = 0L;
                this.f77478f = 0L;
            }
        }
    }

    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            if (SystemClock.elapsedRealtime() - this.f77479g < 300000) {
                if (!bg.b(this.f77474b)) {
                    return;
                }
                int i2 = this.f77475c + 1;
                this.f77475c = i2;
                if (i2 < 2) {
                    return;
                }
                String a2 = a();
                com.xiaomi.channel.commonutils.logger.b.m73a("max short conn time reached, sink down current host:" + a2);
                a(a2, 0L, exc);
            }
            this.f77475c = 0;
        }
    }

    public void a(String str, long j2, Exception exc) {
        co a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), exc}) == null) || (a2 = cs.a().a(fm.a(), false)) == null) {
            return;
        }
        a2.b(str, j2, 0L, exc);
        cs.a().m239c();
    }

    /* renamed from: a */
    public abstract void mo318a(boolean z);

    @Override // com.xiaomi.push.fl
    public void a(fa[] faVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, faVarArr) == null) {
            throw new fw("Don't support send Blob");
        }
    }

    @Override // com.xiaomi.push.fl
    public void b(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, exc) == null) {
            a(i2, exc);
            if ((exc != null || i2 == 18) && this.f77479g != 0) {
                a(exc);
            }
        }
    }

    @Override // com.xiaomi.push.fl
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            mo318a(z);
            if (z) {
                return;
            }
            this.f77474b.a(new ft(this, 13, currentTimeMillis), 10000L);
        }
    }

    @Override // com.xiaomi.push.fl
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? ((fl) this).f401a : (String) invokeV.objValue;
    }

    public void c(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, exc) == null) {
            this.f77474b.a(new fu(this, 2, i2, exc));
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                try {
                    if (!m330c() && !m329b()) {
                        a(0, 0, (Exception) null);
                        a(((fl) this).f398a);
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m73a("WARNING: current xmpp has connected");
                } catch (IOException e2) {
                    throw new fw(e2);
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f77477e = SystemClock.elapsedRealtime();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f77478f = SystemClock.elapsedRealtime();
        }
    }
}
