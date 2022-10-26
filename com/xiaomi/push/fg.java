package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
public class fg implements fz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f359a;

    /* renamed from: a  reason: collision with other field name */
    public fw f360a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f361a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f362a;

    /* renamed from: a  reason: collision with other field name */
    public String f363a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;

    public fg(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f359a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.f361a = xMPushService;
        this.f363a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m89a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = 0L;
            this.d = 0L;
            this.f359a = 0L;
            this.c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bj.b(this.f361a)) {
                this.f359a = elapsedRealtime;
            }
            if (this.f361a.m597c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f363a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
                fa faVar = new fa();
                faVar.f338a = (byte) 0;
                faVar.a(ez.h.a());
                faVar.a(this.f363a);
                faVar.d((int) (System.currentTimeMillis() / 1000));
                faVar.b((int) (this.b / 1000));
                faVar.c((int) (this.d / 1000));
                fh.m328a().a(faVar);
                b();
            }
        }
    }

    public Exception a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f362a : (Exception) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m327a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f361a == null) {
                    return;
                }
                String m194a = bj.m194a((Context) this.f361a);
                boolean c = bj.c(this.f361a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f359a > 0) {
                    this.b += elapsedRealtime - this.f359a;
                    this.f359a = 0L;
                }
                if (this.c != 0) {
                    this.d += elapsedRealtime - this.c;
                    this.c = 0L;
                }
                if (c) {
                    if ((!TextUtils.equals(this.f363a, m194a) && this.b > 30000) || this.b > 5400000) {
                        c();
                    }
                    this.f363a = m194a;
                    if (this.f359a == 0) {
                        this.f359a = elapsedRealtime;
                    }
                    if (this.f361a.m597c()) {
                        this.c = elapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fwVar) == null) {
            this.a = 0;
            this.f362a = null;
            this.f360a = fwVar;
            this.f363a = bj.m194a((Context) this.f361a);
            fj.a(0, ez.v.a());
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, fwVar, i, exc) == null) {
            if (this.a == 0 && this.f362a == null) {
                this.a = i;
                this.f362a = exc;
                fj.b(fwVar.m354a(), exc);
            }
            if (i == 22 && this.c != 0) {
                long m352a = fwVar.m352a() - this.c;
                if (m352a < 0) {
                    m352a = 0;
                }
                this.d += m352a + (gc.b() / 2);
                this.c = 0L;
            }
            m327a();
            int myUid = Process.myUid();
            long j2 = -1;
            try {
                j2 = TrafficStats.getUidRxBytes(myUid);
                j = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m89a("Failed to obtain traffic data: " + e);
                j = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
            this.f = j2;
            this.e = j;
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fwVar, exc) == null) {
            fj.a(0, ez.d.a(), 1, fwVar.m354a(), bj.c(this.f361a) ? 1 : 0);
            m327a();
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fwVar) == null) {
            m327a();
            this.c = SystemClock.elapsedRealtime();
            fj.a(0, ez.v.a(), fwVar.m354a(), fwVar.a());
        }
    }
}
