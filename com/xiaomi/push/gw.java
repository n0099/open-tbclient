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

    /* renamed from: a  reason: collision with root package name */
    public int f43219a;

    /* renamed from: a  reason: collision with other field name */
    public long f456a;

    /* renamed from: a  reason: collision with other field name */
    public fl f457a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f458a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f459a;

    /* renamed from: a  reason: collision with other field name */
    public String f460a;

    /* renamed from: b  reason: collision with root package name */
    public long f43220b;

    /* renamed from: c  reason: collision with root package name */
    public long f43221c;

    /* renamed from: d  reason: collision with root package name */
    public long f43222d;

    /* renamed from: e  reason: collision with root package name */
    public long f43223e;

    /* renamed from: f  reason: collision with root package name */
    public long f43224f;

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
        this.f456a = 0L;
        this.f43220b = 0L;
        this.f43221c = 0L;
        this.f43222d = 0L;
        this.f43223e = 0L;
        this.f43224f = 0L;
        this.f458a = xMPushService;
        this.f460a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f43224f = TrafficStats.getUidRxBytes(myUid);
            this.f43223e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m70a("Failed to obtain traffic data during initialization: " + e2);
            this.f43224f = -1L;
            this.f43223e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f43220b = 0L;
            this.f43222d = 0L;
            this.f456a = 0L;
            this.f43221c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f458a)) {
                this.f456a = elapsedRealtime;
            }
            if (this.f458a.m567c()) {
                this.f43221c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f460a + " netDuration = " + this.f43220b + " ChannelDuration = " + this.f43222d + " channelConnectedTime = " + this.f43221c);
                ex exVar = new ex();
                exVar.f344a = (byte) 0;
                exVar.a(ew.f43078h.a());
                exVar.a(this.f460a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.f43220b / 1000));
                exVar.c((int) (this.f43222d / 1000));
                gx.m363a().a(exVar);
                b();
            }
        }
    }

    public Exception a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f459a : (Exception) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m362a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f458a == null) {
                    return;
                }
                String m172a = bg.m172a((Context) this.f458a);
                boolean b2 = bg.b(this.f458a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f456a > 0) {
                    this.f43220b += elapsedRealtime - this.f456a;
                    this.f456a = 0L;
                }
                if (this.f43221c != 0) {
                    this.f43222d += elapsedRealtime - this.f43221c;
                    this.f43221c = 0L;
                }
                if (b2) {
                    if ((!TextUtils.equals(this.f460a, m172a) && this.f43220b > 30000) || this.f43220b > 5400000) {
                        c();
                    }
                    this.f460a = m172a;
                    if (this.f456a == 0) {
                        this.f456a = elapsedRealtime;
                    }
                    if (this.f458a.m567c()) {
                        this.f43221c = elapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            this.f43219a = 0;
            this.f459a = null;
            this.f457a = flVar;
            this.f460a = bg.m172a((Context) this.f458a);
            gz.a(0, ew.v.a());
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, flVar, i2, exc) == null) {
            if (this.f43219a == 0 && this.f459a == null) {
                this.f43219a = i2;
                this.f459a = exc;
                gz.b(flVar.m321a(), exc);
            }
            if (i2 == 22 && this.f43221c != 0) {
                long m319a = flVar.m319a() - this.f43221c;
                if (m319a < 0) {
                    m319a = 0;
                }
                this.f43222d += m319a + (fr.b() / 2);
                this.f43221c = 0L;
            }
            m362a();
            int myUid = Process.myUid();
            long j2 = -1;
            try {
                j2 = TrafficStats.getUidRxBytes(myUid);
                j = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a("Failed to obtain traffic data: " + e2);
                j = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f43224f) + ", tx=" + (j - this.f43223e));
            this.f43224f = j2;
            this.f43223e = j;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.f43074d.a(), 1, flVar.m321a(), bg.c(this.f458a) ? 1 : 0);
            m362a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m362a();
            this.f43221c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m321a(), flVar.a());
        }
    }
}
