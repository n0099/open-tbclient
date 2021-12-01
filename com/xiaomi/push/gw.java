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
/* loaded from: classes3.dex */
public class gw implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f461a;

    /* renamed from: a  reason: collision with other field name */
    public fl f462a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f463a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f464a;

    /* renamed from: a  reason: collision with other field name */
    public String f465a;

    /* renamed from: b  reason: collision with root package name */
    public long f62962b;

    /* renamed from: c  reason: collision with root package name */
    public long f62963c;

    /* renamed from: d  reason: collision with root package name */
    public long f62964d;

    /* renamed from: e  reason: collision with root package name */
    public long f62965e;

    /* renamed from: f  reason: collision with root package name */
    public long f62966f;

    public gw(XMPushService xMPushService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f461a = 0L;
        this.f62962b = 0L;
        this.f62963c = 0L;
        this.f62964d = 0L;
        this.f62965e = 0L;
        this.f62966f = 0L;
        this.f463a = xMPushService;
        this.f465a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f62966f = TrafficStats.getUidRxBytes(myUid);
            this.f62965e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m122a("Failed to obtain traffic data during initialization: " + e2);
            this.f62966f = -1L;
            this.f62965e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f62962b = 0L;
            this.f62964d = 0L;
            this.f461a = 0L;
            this.f62963c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f463a)) {
                this.f461a = elapsedRealtime;
            }
            if (this.f463a.m619c()) {
                this.f62963c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f465a + " netDuration = " + this.f62962b + " ChannelDuration = " + this.f62964d + " channelConnectedTime = " + this.f62963c);
                ex exVar = new ex();
                exVar.f349a = (byte) 0;
                exVar.a(ew.f62862h.a());
                exVar.a(this.f465a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.f62962b / 1000));
                exVar.c((int) (this.f62964d / 1000));
                gx.m415a().a(exVar);
                b();
            }
        }
    }

    public Exception a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f464a : (Exception) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m414a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f463a == null) {
                    return;
                }
                String m224a = bg.m224a((Context) this.f463a);
                boolean b2 = bg.b(this.f463a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f461a > 0) {
                    this.f62962b += elapsedRealtime - this.f461a;
                    this.f461a = 0L;
                }
                if (this.f62963c != 0) {
                    this.f62964d += elapsedRealtime - this.f62963c;
                    this.f62963c = 0L;
                }
                if (b2) {
                    if ((!TextUtils.equals(this.f465a, m224a) && this.f62962b > 30000) || this.f62962b > 5400000) {
                        c();
                    }
                    this.f465a = m224a;
                    if (this.f461a == 0) {
                        this.f461a = elapsedRealtime;
                    }
                    if (this.f463a.m619c()) {
                        this.f62963c = elapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            this.a = 0;
            this.f464a = null;
            this.f462a = flVar;
            this.f465a = bg.m224a((Context) this.f463a);
            gz.a(0, ew.v.a());
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, flVar, i2, exc) == null) {
            if (this.a == 0 && this.f464a == null) {
                this.a = i2;
                this.f464a = exc;
                gz.b(flVar.m373a(), exc);
            }
            if (i2 == 22 && this.f62963c != 0) {
                long m371a = flVar.m371a() - this.f62963c;
                if (m371a < 0) {
                    m371a = 0;
                }
                this.f62964d += m371a + (fr.b() / 2);
                this.f62963c = 0L;
            }
            m414a();
            int myUid = Process.myUid();
            long j3 = -1;
            try {
                j3 = TrafficStats.getUidRxBytes(myUid);
                j2 = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m122a("Failed to obtain traffic data: " + e2);
                j2 = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j3 - this.f62966f) + ", tx=" + (j2 - this.f62965e));
            this.f62966f = j3;
            this.f62965e = j2;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.f62858d.a(), 1, flVar.m373a(), bg.c(this.f463a) ? 1 : 0);
            m414a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m414a();
            this.f62963c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m373a(), flVar.a());
        }
    }
}
