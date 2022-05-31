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
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;

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
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.f439a = xMPushService;
        this.f441a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f = TrafficStats.getUidRxBytes(myUid);
            this.e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m108a("Failed to obtain traffic data during initialization: " + e);
            this.f = -1L;
            this.e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = 0L;
            this.d = 0L;
            this.f437a = 0L;
            this.c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f439a)) {
                this.f437a = elapsedRealtime;
            }
            if (this.f439a.m605c()) {
                this.c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f441a + " netDuration = " + this.b + " ChannelDuration = " + this.d + " channelConnectedTime = " + this.c);
                ex exVar = new ex();
                exVar.f325a = (byte) 0;
                exVar.a(ew.h.a());
                exVar.a(this.f441a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.b / 1000));
                exVar.c((int) (this.d / 1000));
                gx.m401a().a(exVar);
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
    public synchronized void m400a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f439a == null) {
                    return;
                }
                String m210a = bg.m210a((Context) this.f439a);
                boolean b = bg.b(this.f439a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f437a > 0) {
                    this.b += elapsedRealtime - this.f437a;
                    this.f437a = 0L;
                }
                if (this.c != 0) {
                    this.d += elapsedRealtime - this.c;
                    this.c = 0L;
                }
                if (b) {
                    if ((!TextUtils.equals(this.f441a, m210a) && this.b > 30000) || this.b > 5400000) {
                        c();
                    }
                    this.f441a = m210a;
                    if (this.f437a == 0) {
                        this.f437a = elapsedRealtime;
                    }
                    if (this.f439a.m605c()) {
                        this.c = elapsedRealtime;
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
            this.f441a = bg.m210a((Context) this.f439a);
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
                gz.b(flVar.m359a(), exc);
            }
            if (i == 22 && this.c != 0) {
                long m357a = flVar.m357a() - this.c;
                if (m357a < 0) {
                    m357a = 0;
                }
                this.d += m357a + (fr.b() / 2);
                this.c = 0L;
            }
            m400a();
            int myUid = Process.myUid();
            long j2 = -1;
            try {
                j2 = TrafficStats.getUidRxBytes(myUid);
                j = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.m108a("Failed to obtain traffic data: " + e);
                j = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f) + ", tx=" + (j - this.e));
            this.f = j2;
            this.e = j;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.d.a(), 1, flVar.m359a(), bg.c(this.f439a) ? 1 : 0);
            m400a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m400a();
            this.c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m359a(), flVar.a());
        }
    }
}
