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
/* loaded from: classes7.dex */
public class gw implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f437a;

    /* renamed from: a  reason: collision with other field name */
    public fl f438a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f439a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f440a;

    /* renamed from: a  reason: collision with other field name */
    public String f441a;

    /* renamed from: b  reason: collision with root package name */
    public long f44316b;

    /* renamed from: c  reason: collision with root package name */
    public long f44317c;

    /* renamed from: d  reason: collision with root package name */
    public long f44318d;

    /* renamed from: e  reason: collision with root package name */
    public long f44319e;

    /* renamed from: f  reason: collision with root package name */
    public long f44320f;

    public gw(XMPushService xMPushService) {
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
        this.f437a = 0L;
        this.f44316b = 0L;
        this.f44317c = 0L;
        this.f44318d = 0L;
        this.f44319e = 0L;
        this.f44320f = 0L;
        this.f439a = xMPushService;
        this.f441a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f44320f = TrafficStats.getUidRxBytes(myUid);
            this.f44319e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m112a("Failed to obtain traffic data during initialization: " + e2);
            this.f44320f = -1L;
            this.f44319e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f44316b = 0L;
            this.f44318d = 0L;
            this.f437a = 0L;
            this.f44317c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f439a)) {
                this.f437a = elapsedRealtime;
            }
            if (this.f439a.m609c()) {
                this.f44317c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f441a + " netDuration = " + this.f44316b + " ChannelDuration = " + this.f44318d + " channelConnectedTime = " + this.f44317c);
                ex exVar = new ex();
                exVar.f325a = (byte) 0;
                exVar.a(ew.f44228h.a());
                exVar.a(this.f441a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.f44316b / 1000));
                exVar.c((int) (this.f44318d / 1000));
                gx.m405a().a(exVar);
                b();
            }
        }
    }

    public Exception a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f440a : (Exception) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m404a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f439a == null) {
                    return;
                }
                String m214a = bg.m214a((Context) this.f439a);
                boolean b2 = bg.b(this.f439a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f437a > 0) {
                    this.f44316b += elapsedRealtime - this.f437a;
                    this.f437a = 0L;
                }
                if (this.f44317c != 0) {
                    this.f44318d += elapsedRealtime - this.f44317c;
                    this.f44317c = 0L;
                }
                if (b2) {
                    if ((!TextUtils.equals(this.f441a, m214a) && this.f44316b > 30000) || this.f44316b > 5400000) {
                        c();
                    }
                    this.f441a = m214a;
                    if (this.f437a == 0) {
                        this.f437a = elapsedRealtime;
                    }
                    if (this.f439a.m609c()) {
                        this.f44317c = elapsedRealtime;
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
            this.f440a = null;
            this.f438a = flVar;
            this.f441a = bg.m214a((Context) this.f439a);
            gz.a(0, ew.v.a());
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i, Exception exc) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, flVar, i, exc) == null) {
            if (this.a == 0 && this.f440a == null) {
                this.a = i;
                this.f440a = exc;
                gz.b(flVar.m363a(), exc);
            }
            if (i == 22 && this.f44317c != 0) {
                long m361a = flVar.m361a() - this.f44317c;
                if (m361a < 0) {
                    m361a = 0;
                }
                this.f44318d += m361a + (fr.b() / 2);
                this.f44317c = 0L;
            }
            m404a();
            int myUid = Process.myUid();
            long j2 = -1;
            try {
                j2 = TrafficStats.getUidRxBytes(myUid);
                j = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m112a("Failed to obtain traffic data: " + e2);
                j = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f44320f) + ", tx=" + (j - this.f44319e));
            this.f44320f = j2;
            this.f44319e = j;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.f44224d.a(), 1, flVar.m363a(), bg.c(this.f439a) ? 1 : 0);
            m404a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m404a();
            this.f44317c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m363a(), flVar.a());
        }
    }
}
