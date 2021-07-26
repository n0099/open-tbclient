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
/* loaded from: classes6.dex */
public class gw implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40505a;

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
    public long f40506b;

    /* renamed from: c  reason: collision with root package name */
    public long f40507c;

    /* renamed from: d  reason: collision with root package name */
    public long f40508d;

    /* renamed from: e  reason: collision with root package name */
    public long f40509e;

    /* renamed from: f  reason: collision with root package name */
    public long f40510f;

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
        this.f40506b = 0L;
        this.f40507c = 0L;
        this.f40508d = 0L;
        this.f40509e = 0L;
        this.f40510f = 0L;
        this.f458a = xMPushService;
        this.f460a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f40510f = TrafficStats.getUidRxBytes(myUid);
            this.f40509e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m70a("Failed to obtain traffic data during initialization: " + e2);
            this.f40510f = -1L;
            this.f40509e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f40506b = 0L;
            this.f40508d = 0L;
            this.f456a = 0L;
            this.f40507c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f458a)) {
                this.f456a = elapsedRealtime;
            }
            if (this.f458a.m567c()) {
                this.f40507c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f460a + " netDuration = " + this.f40506b + " ChannelDuration = " + this.f40508d + " channelConnectedTime = " + this.f40507c);
                ex exVar = new ex();
                exVar.f344a = (byte) 0;
                exVar.a(ew.f40364h.a());
                exVar.a(this.f460a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.f40506b / 1000));
                exVar.c((int) (this.f40508d / 1000));
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
                    this.f40506b += elapsedRealtime - this.f456a;
                    this.f456a = 0L;
                }
                if (this.f40507c != 0) {
                    this.f40508d += elapsedRealtime - this.f40507c;
                    this.f40507c = 0L;
                }
                if (b2) {
                    if ((!TextUtils.equals(this.f460a, m172a) && this.f40506b > 30000) || this.f40506b > 5400000) {
                        c();
                    }
                    this.f460a = m172a;
                    if (this.f456a == 0) {
                        this.f456a = elapsedRealtime;
                    }
                    if (this.f458a.m567c()) {
                        this.f40507c = elapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            this.f40505a = 0;
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
            if (this.f40505a == 0 && this.f459a == null) {
                this.f40505a = i2;
                this.f459a = exc;
                gz.b(flVar.m321a(), exc);
            }
            if (i2 == 22 && this.f40507c != 0) {
                long m319a = flVar.m319a() - this.f40507c;
                if (m319a < 0) {
                    m319a = 0;
                }
                this.f40508d += m319a + (fr.b() / 2);
                this.f40507c = 0L;
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
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f40510f) + ", tx=" + (j - this.f40509e));
            this.f40510f = j2;
            this.f40509e = j;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.f40360d.a(), 1, flVar.m321a(), bg.c(this.f458a) ? 1 : 0);
            m362a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m362a();
            this.f40507c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m321a(), flVar.a());
        }
    }
}
