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
    public long f382a;

    /* renamed from: a  reason: collision with other field name */
    public fw f383a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f384a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f385a;

    /* renamed from: a  reason: collision with other field name */
    public String f386a;
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
        this.f382a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.f384a = xMPushService;
        this.f386a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m105a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = 0L;
            this.d = 0L;
            this.f382a = 0L;
            this.c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bj.b(this.f384a)) {
                this.f382a = elapsedRealtime;
            }
            if (this.f384a.m673c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f386a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
                fa faVar = new fa();
                faVar.f361a = (byte) 0;
                faVar.a(ez.h.a());
                faVar.a(this.f386a);
                faVar.d((int) (System.currentTimeMillis() / 1000));
                faVar.b((int) (this.b / 1000));
                faVar.c((int) (this.d / 1000));
                fh.m399a().a(faVar);
                b();
            }
        }
    }

    public Exception a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f385a : (Exception) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m398a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f384a == null) {
                    return;
                }
                String m211a = bj.m211a((Context) this.f384a);
                boolean c = bj.c(this.f384a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f382a > 0) {
                    this.b += elapsedRealtime - this.f382a;
                    this.f382a = 0L;
                }
                if (this.c != 0) {
                    this.d += elapsedRealtime - this.c;
                    this.c = 0L;
                }
                if (c) {
                    if ((!TextUtils.equals(this.f386a, m211a) && this.b > 30000) || this.b > 5400000) {
                        c();
                    }
                    this.f386a = m211a;
                    if (this.f382a == 0) {
                        this.f382a = elapsedRealtime;
                    }
                    if (this.f384a.m673c()) {
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
            this.f385a = null;
            this.f383a = fwVar;
            this.f386a = bj.m211a((Context) this.f384a);
            fj.a(0, ez.v.a());
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i, Exception exc) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, fwVar, i, exc) == null) {
            if (this.a == 0 && this.f385a == null) {
                this.a = i;
                this.f385a = exc;
                fj.b(fwVar.mo428a(), exc);
            }
            if (i == 22 && this.c != 0) {
                long m426a = fwVar.m426a() - this.c;
                if (m426a < 0) {
                    m426a = 0;
                }
                this.d += m426a + (gc.b() / 2);
                this.c = 0L;
            }
            m398a();
            int myUid = Process.myUid();
            long j2 = -1;
            try {
                j2 = TrafficStats.getUidRxBytes(myUid);
                j = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m105a("Failed to obtain traffic data: " + e);
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
            fj.a(0, ez.d.a(), 1, fwVar.mo428a(), bj.c(this.f384a) ? 1 : 0);
            m398a();
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fwVar) == null) {
            m398a();
            this.c = SystemClock.elapsedRealtime();
            fj.a(0, ez.v.a(), fwVar.mo428a(), fwVar.a());
        }
    }
}
