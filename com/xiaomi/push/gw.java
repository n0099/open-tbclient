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
/* loaded from: classes10.dex */
public class gw implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77565a;

    /* renamed from: a  reason: collision with other field name */
    public long f460a;

    /* renamed from: a  reason: collision with other field name */
    public fl f461a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f462a;

    /* renamed from: a  reason: collision with other field name */
    public Exception f463a;

    /* renamed from: a  reason: collision with other field name */
    public String f464a;

    /* renamed from: b  reason: collision with root package name */
    public long f77566b;

    /* renamed from: c  reason: collision with root package name */
    public long f77567c;

    /* renamed from: d  reason: collision with root package name */
    public long f77568d;

    /* renamed from: e  reason: collision with root package name */
    public long f77569e;

    /* renamed from: f  reason: collision with root package name */
    public long f77570f;

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
        this.f460a = 0L;
        this.f77566b = 0L;
        this.f77567c = 0L;
        this.f77568d = 0L;
        this.f77569e = 0L;
        this.f77570f = 0L;
        this.f462a = xMPushService;
        this.f464a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f77570f = TrafficStats.getUidRxBytes(myUid);
            this.f77569e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Failed to obtain traffic data during initialization: " + e2);
            this.f77570f = -1L;
            this.f77569e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f77566b = 0L;
            this.f77568d = 0L;
            this.f460a = 0L;
            this.f77567c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f462a)) {
                this.f460a = elapsedRealtime;
            }
            if (this.f462a.m570c()) {
                this.f77567c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f464a + " netDuration = " + this.f77566b + " ChannelDuration = " + this.f77568d + " channelConnectedTime = " + this.f77567c);
                ex exVar = new ex();
                exVar.f348a = (byte) 0;
                exVar.a(ew.f77420h.a());
                exVar.a(this.f464a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.f77566b / 1000));
                exVar.c((int) (this.f77568d / 1000));
                gx.m366a().a(exVar);
                b();
            }
        }
    }

    public Exception a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f463a : (Exception) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m365a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f462a == null) {
                    return;
                }
                String m175a = bg.m175a((Context) this.f462a);
                boolean b2 = bg.b(this.f462a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f460a > 0) {
                    this.f77566b += elapsedRealtime - this.f460a;
                    this.f460a = 0L;
                }
                if (this.f77567c != 0) {
                    this.f77568d += elapsedRealtime - this.f77567c;
                    this.f77567c = 0L;
                }
                if (b2) {
                    if ((!TextUtils.equals(this.f464a, m175a) && this.f77566b > 30000) || this.f77566b > 5400000) {
                        c();
                    }
                    this.f464a = m175a;
                    if (this.f460a == 0) {
                        this.f460a = elapsedRealtime;
                    }
                    if (this.f462a.m570c()) {
                        this.f77567c = elapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            this.f77565a = 0;
            this.f463a = null;
            this.f461a = flVar;
            this.f464a = bg.m175a((Context) this.f462a);
            gz.a(0, ew.v.a());
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, flVar, i2, exc) == null) {
            if (this.f77565a == 0 && this.f463a == null) {
                this.f77565a = i2;
                this.f463a = exc;
                gz.b(flVar.m324a(), exc);
            }
            if (i2 == 22 && this.f77567c != 0) {
                long m322a = flVar.m322a() - this.f77567c;
                if (m322a < 0) {
                    m322a = 0;
                }
                this.f77568d += m322a + (fr.b() / 2);
                this.f77567c = 0L;
            }
            m365a();
            int myUid = Process.myUid();
            long j3 = -1;
            try {
                j3 = TrafficStats.getUidRxBytes(myUid);
                j2 = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("Failed to obtain traffic data: " + e2);
                j2 = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j3 - this.f77570f) + ", tx=" + (j2 - this.f77569e));
            this.f77570f = j3;
            this.f77569e = j2;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.f77416d.a(), 1, flVar.m324a(), bg.c(this.f462a) ? 1 : 0);
            m365a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m365a();
            this.f77567c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m324a(), flVar.a());
        }
    }
}
