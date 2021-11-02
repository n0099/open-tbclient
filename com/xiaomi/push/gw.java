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
/* loaded from: classes2.dex */
public class gw implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71054a;

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
    public long f71055b;

    /* renamed from: c  reason: collision with root package name */
    public long f71056c;

    /* renamed from: d  reason: collision with root package name */
    public long f71057d;

    /* renamed from: e  reason: collision with root package name */
    public long f71058e;

    /* renamed from: f  reason: collision with root package name */
    public long f71059f;

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
        this.f71055b = 0L;
        this.f71056c = 0L;
        this.f71057d = 0L;
        this.f71058e = 0L;
        this.f71059f = 0L;
        this.f463a = xMPushService;
        this.f465a = "";
        b();
        int myUid = Process.myUid();
        try {
            this.f71059f = TrafficStats.getUidRxBytes(myUid);
            this.f71058e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Failed to obtain traffic data during initialization: " + e2);
            this.f71059f = -1L;
            this.f71058e = -1L;
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.f71055b = 0L;
            this.f71057d = 0L;
            this.f461a = 0L;
            this.f71056c = 0L;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (bg.b(this.f463a)) {
                this.f461a = elapsedRealtime;
            }
            if (this.f463a.m570c()) {
                this.f71056c = elapsedRealtime;
            }
        }
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                com.xiaomi.channel.commonutils.logger.b.c("stat connpt = " + this.f465a + " netDuration = " + this.f71055b + " ChannelDuration = " + this.f71057d + " channelConnectedTime = " + this.f71056c);
                ex exVar = new ex();
                exVar.f349a = (byte) 0;
                exVar.a(ew.f70913h.a());
                exVar.a(this.f465a);
                exVar.d((int) (System.currentTimeMillis() / 1000));
                exVar.b((int) (this.f71055b / 1000));
                exVar.c((int) (this.f71057d / 1000));
                gx.m366a().a(exVar);
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
    public synchronized void m365a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.f463a == null) {
                    return;
                }
                String m175a = bg.m175a((Context) this.f463a);
                boolean b2 = bg.b(this.f463a);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.f461a > 0) {
                    this.f71055b += elapsedRealtime - this.f461a;
                    this.f461a = 0L;
                }
                if (this.f71056c != 0) {
                    this.f71057d += elapsedRealtime - this.f71056c;
                    this.f71056c = 0L;
                }
                if (b2) {
                    if ((!TextUtils.equals(this.f465a, m175a) && this.f71055b > 30000) || this.f71055b > 5400000) {
                        c();
                    }
                    this.f465a = m175a;
                    if (this.f461a == 0) {
                        this.f461a = elapsedRealtime;
                    }
                    if (this.f463a.m570c()) {
                        this.f71056c = elapsedRealtime;
                    }
                }
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flVar) == null) {
            this.f71054a = 0;
            this.f464a = null;
            this.f462a = flVar;
            this.f465a = bg.m175a((Context) this.f463a);
            gz.a(0, ew.v.a());
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, flVar, i2, exc) == null) {
            if (this.f71054a == 0 && this.f464a == null) {
                this.f71054a = i2;
                this.f464a = exc;
                gz.b(flVar.m324a(), exc);
            }
            if (i2 == 22 && this.f71056c != 0) {
                long m322a = flVar.m322a() - this.f71056c;
                if (m322a < 0) {
                    m322a = 0;
                }
                this.f71057d += m322a + (fr.b() / 2);
                this.f71056c = 0L;
            }
            m365a();
            int myUid = Process.myUid();
            long j2 = -1;
            try {
                j2 = TrafficStats.getUidRxBytes(myUid);
                j = TrafficStats.getUidTxBytes(myUid);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("Failed to obtain traffic data: " + e2);
                j = -1L;
            }
            com.xiaomi.channel.commonutils.logger.b.c("Stats rx=" + (j2 - this.f71059f) + ", tx=" + (j - this.f71058e));
            this.f71059f = j2;
            this.f71058e = j;
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, flVar, exc) == null) {
            gz.a(0, ew.f70909d.a(), 1, flVar.m324a(), bg.c(this.f463a) ? 1 : 0);
            m365a();
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            m365a();
            this.f71056c = SystemClock.elapsedRealtime();
            gz.a(0, ew.v.a(), flVar.m324a(), flVar.a());
        }
    }
}
