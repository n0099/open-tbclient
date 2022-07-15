package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.al;
import com.xiaomi.push.cv;
import com.xiaomi.push.dd;
import com.xiaomi.push.df;
import com.xiaomi.push.ed;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.eu;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.fw;
import com.xiaomi.push.fx;
import com.xiaomi.push.fz;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gh;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.hd;
import com.xiaomi.push.hg;
import com.xiaomi.push.hj;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.it;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class XMPushService extends Service implements fz {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f1560a;

    /* renamed from: a  reason: collision with other field name */
    public ContentObserver f1561a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f1562a;

    /* renamed from: a  reason: collision with other field name */
    public fs f1563a;

    /* renamed from: a  reason: collision with other field name */
    public fw f1564a;

    /* renamed from: a  reason: collision with other field name */
    public fx f1565a;

    /* renamed from: a  reason: collision with other field name */
    public gb f1566a;

    /* renamed from: a  reason: collision with other field name */
    public a f1567a;

    /* renamed from: a  reason: collision with other field name */
    public f f1568a;

    /* renamed from: a  reason: collision with other field name */
    public k f1569a;

    /* renamed from: a  reason: collision with other field name */
    public r f1570a;

    /* renamed from: a  reason: collision with other field name */
    public t f1571a;

    /* renamed from: a  reason: collision with other field name */
    public be f1572a;

    /* renamed from: a  reason: collision with other field name */
    public bq f1573a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.j f1574a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.p f1575a;

    /* renamed from: a  reason: collision with other field name */
    public Class f1576a;

    /* renamed from: a  reason: collision with other field name */
    public String f1577a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<n> f1578a;

    /* renamed from: a  reason: collision with other field name */
    public Collection<ar> f1579a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1580a;

    /* renamed from: b  reason: collision with other field name */
    public int f1581b;

    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f1582a;

        public a(XMPushService xMPushService) {
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
            this.a = xMPushService;
            this.f1582a = new Object();
        }

        public /* synthetic */ a(XMPushService xMPushService, ci ciVar) {
            this(xMPushService);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                    return;
                }
                synchronized (this.f1582a) {
                    try {
                        this.f1582a.notifyAll();
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.m1027a("[Alarm] notify lock. " + e);
                    }
                }
            }
        }

        private void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65539, this, j) == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                    return;
                }
                synchronized (this.f1582a) {
                    try {
                        this.f1582a.wait(j);
                    } catch (InterruptedException e) {
                        com.xiaomi.channel.commonutils.logger.b.m1027a("[Alarm] interrupt from waiting state. " + e);
                    }
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
                if (!bk.p.equals(intent.getAction())) {
                    com.xiaomi.channel.commonutils.logger.b.m1027a("[Alarm] cancel the old ping timer");
                    eu.a();
                } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                    com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                    try {
                        Intent intent2 = new Intent(context, XMPushService.class);
                        intent2.putExtra("time_stamp", System.currentTimeMillis());
                        intent2.setAction("com.xiaomi.push.timer");
                        ServiceClient.getInstance(context).startServiceSafely(intent2);
                        a(3000L);
                        com.xiaomi.channel.commonutils.logger.b.m1027a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public bg.b f1583a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(XMPushService xMPushService, bg.b bVar) {
            super(9);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
            this.f1583a = null;
            this.f1583a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "bind the client. " + this.f1583a.g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (!this.a.m1535c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                        return;
                    }
                    bg.b a = bg.a().a(this.f1583a.g, this.f1583a.f1656b);
                    if (a == null) {
                        str = "ignore bind because the channel " + this.f1583a.g + " is removed ";
                    } else if (a.f1651a == bg.c.a) {
                        a.a(bg.c.b, 0, 0, (String) null, (String) null);
                        this.a.f1564a.a(a);
                        fj.a(this.a, a);
                        return;
                    } else {
                        str = "trying duplicate bind, ingore! " + a.f1651a;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m1027a(str);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. " + e);
                    this.a.a(10, e);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final bg.b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bg.b bVar) {
            super(12);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "bind time out. chid=" + this.a.g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a(bg.c.a, 1, 21, (String) null, (String) null);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof c) {
                    return TextUtils.equals(((c) obj).a.g, this.a.g);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.g.hashCode() : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fl a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f1584a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(XMPushService xMPushService, fl flVar) {
            super(8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, flVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1584a = xMPushService;
            this.a = null;
            this.a = flVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public fl a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (fl) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "receive a message." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ao aoVar = this.a.f1092a;
                if (aoVar != null) {
                    aoVar.c = System.currentTimeMillis();
                }
                this.f1584a.f1572a.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(XMPushService xMPushService) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "do reconnect.." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.m1530a()) {
                    XMPushService xMPushService = this.a;
                    if (xMPushService.a(xMPushService.getApplicationContext())) {
                        this.a.f();
                        return;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m1027a("should not connect. quit the job.");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        public f(XMPushService xMPushService) {
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
            this.a = xMPushService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("network changed, " + com.xiaomi.push.m.a(intent));
                this.a.onStart(intent, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public Exception f1585a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(XMPushService xMPushService, int i, Exception exc) {
            super(2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, Integer.valueOf(i), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
            this.b = i;
            this.f1585a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "disconnect the connection." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a(this.b, this.f1585a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(XMPushService xMPushService) {
            super(65535);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Init Job" : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Intent a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f1586a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(XMPushService xMPushService, Intent intent) {
            super(15);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1586a = xMPushService;
            this.a = null;
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public Intent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (Intent) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "Handle intent action = " + this.a.getAction();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f1586a.d(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class j extends p.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m1537a();

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.a;
                if (i != 4 && i != 8) {
                    com.xiaomi.channel.commonutils.logger.b.m1028a(com.xiaomi.channel.commonutils.logger.a.a, a());
                }
                m1537a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        public k(XMPushService xMPushService) {
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
            this.a = xMPushService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("[HB] hold short heartbeat, " + com.xiaomi.push.m.a(intent));
                if (intent == null || intent.getExtras() == null) {
                    return;
                }
                this.a.onStart(intent, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(XMPushService xMPushService) {
            super(5);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ask the job queue to quit" : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f1575a.m1607a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gn a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f1587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(XMPushService xMPushService, gn gnVar) {
            super(8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, gnVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1587a = xMPushService;
            this.a = null;
            this.a = gnVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "receive a message." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f1587a.f1572a.a(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface n {
        /* renamed from: a */
        void mo1332a();
    }

    /* loaded from: classes8.dex */
    public class o extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1588a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(XMPushService xMPushService, boolean z) {
            super(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
            this.f1588a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send ping.." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.m1535c()) {
                try {
                    if (!this.f1588a) {
                        fj.a();
                    }
                    this.a.f1564a.b(this.f1588a);
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.a.a(10, e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public bg.b f1589a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(XMPushService xMPushService, bg.b bVar) {
            super(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
            this.f1589a = null;
            this.f1589a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "rebind the client. " + this.f1589a.g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f1589a.a(bg.c.a, 1, 16, (String) null, (String) null);
                    this.a.f1564a.a(this.f1589a.g, this.f1589a.f1656b);
                    this.a.a(new b(this.a, this.f1589a), 300L);
                } catch (gh e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.a.a(10, e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(XMPushService xMPushService) {
            super(3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reset the connection." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a(11, (Exception) null);
                if (this.a.m1530a()) {
                    XMPushService xMPushService = this.a;
                    if (xMPushService.a(xMPushService.getApplicationContext())) {
                        this.a.f();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        public r(XMPushService xMPushService) {
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
            this.a = xMPushService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.a.onStart(intent, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public bg.b f1590a;

        /* renamed from: a  reason: collision with other field name */
        public String f1591a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public String f1592b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(XMPushService xMPushService, bg.b bVar, int i, String str, String str2) {
            super(9);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, bVar, Integer.valueOf(i), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xMPushService;
            this.f1590a = null;
            this.f1590a = bVar;
            this.b = i;
            this.f1591a = str;
            this.f1592b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "unbind the channel. " + this.f1590a.g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f1590a.f1651a != bg.c.a && this.a.f1564a != null) {
                    try {
                        this.a.f1564a.a(this.f1590a.g, this.f1590a.f1656b);
                    } catch (gh e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        this.a.a(10, e);
                    }
                }
                this.f1590a.a(bg.c.a, this.b, 0, this.f1592b, this.f1591a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        public t(XMPushService xMPushService) {
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
            this.a = xMPushService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                if (!this.a.f1580a) {
                    this.a.f1580a = true;
                }
                com.xiaomi.channel.commonutils.logger.b.m1027a("[HB] wifi changed, " + com.xiaomi.push.m.a(intent));
                this.a.onStart(intent, 1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1323430550, "Lcom/xiaomi/push/service/XMPushService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1323430550, "Lcom/xiaomi/push/service/XMPushService;");
        }
    }

    public XMPushService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1580a = false;
        this.a = 0;
        this.f1581b = 0;
        this.f1560a = 0L;
        this.f1576a = XMJobService.class;
        this.f1572a = null;
        this.f1575a = null;
        this.f1562a = null;
        this.f1579a = Collections.synchronizedCollection(new ArrayList());
        this.f1578a = new ArrayList<>();
        this.f1566a = new ci(this);
    }

    private gn a(gn gnVar, String str, String str2) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, gnVar, str, str2)) == null) {
            bg a2 = bg.a();
            List<String> m1576a = a2.m1576a(str);
            if (m1576a.isEmpty()) {
                sb = new StringBuilder();
                str3 = "open channel should be called first before sending a packet, pkg=";
            } else {
                gnVar.o(str);
                str = gnVar.k();
                if (TextUtils.isEmpty(str)) {
                    str = m1576a.get(0);
                    gnVar.l(str);
                }
                bg.b a3 = a2.a(str, gnVar.m());
                if (!m1535c()) {
                    sb = new StringBuilder();
                    str3 = "drop a packet as the channel is not connected, chid=";
                } else if (a3 != null && a3.f1651a == bg.c.c) {
                    if (TextUtils.equals(str2, a3.i)) {
                        return gnVar;
                    }
                    sb = new StringBuilder();
                    sb.append("invalid session. ");
                    sb.append(str2);
                    com.xiaomi.channel.commonutils.logger.b.m1027a(sb.toString());
                    return null;
                } else {
                    sb = new StringBuilder();
                    str3 = "drop a packet as the channel is not opened, chid=";
                }
            }
            sb.append(str3);
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.m1027a(sb.toString());
            return null;
        }
        return (gn) invokeLLL.objValue;
    }

    private bg.b a(String str, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, intent)) == null) {
            bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
            if (a2 == null) {
                a2 = new bg.b(this);
            }
            a2.g = intent.getStringExtra(bk.t);
            a2.f1656b = intent.getStringExtra(bk.q);
            a2.c = intent.getStringExtra(bk.v);
            a2.f1653a = intent.getStringExtra(bk.B);
            a2.e = intent.getStringExtra(bk.z);
            a2.f = intent.getStringExtra(bk.A);
            a2.f1655a = intent.getBooleanExtra(bk.y, false);
            a2.h = intent.getStringExtra(bk.x);
            a2.i = intent.getStringExtra(bk.F);
            a2.d = intent.getStringExtra(bk.w);
            a2.f1652a = this.f1574a;
            a2.a((Messenger) intent.getParcelableExtra(bk.J));
            a2.f1645a = getApplicationContext();
            bg.a().a(a2);
            return a2;
        }
        return (bg.b) invokeLL.objValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            String m1496a = com.xiaomi.push.m.m1496a("ro.miui.region");
            return TextUtils.isEmpty(m1496a) ? com.xiaomi.push.m.m1496a("ro.product.locale.region") : m1496a;
        }
        return (String) invokeV.objValue;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, broadcastReceiver) == null) || broadcastReceiver == null) {
            return;
        }
        try {
            unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, intent) == null) || intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).m1603a(extras.getString("digest"));
    }

    private void a(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, this, intent, i2) == null) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            ii iiVar = new ii();
            try {
                it.a(iiVar, byteArrayExtra);
                com.xiaomi.push.al.a(getApplicationContext()).a((al.a) new com.xiaomi.push.service.b(iiVar, new WeakReference(this), booleanExtra), i2);
            } catch (iz unused) {
                com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
            }
        }
    }

    private void a(com.xiaomi.push.service.a aVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, aVar) == null) {
            if (aVar == null || !TextUtils.isEmpty(aVar.b()) || TextUtils.isEmpty(aVar.a())) {
                str = "no need to check country code";
            } else {
                String a2 = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : com.xiaomi.push.m.b();
                if (!TextUtils.isEmpty(a2)) {
                    String name = com.xiaomi.push.m.a(a2).name();
                    if (TextUtils.equals(name, aVar.a())) {
                        aVar.b(a2);
                        str2 = "update country code";
                    } else {
                        str2 = "not update country code, because not equals " + name;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m1027a(str2);
                    return;
                }
                str = "check no country code";
            }
            com.xiaomi.channel.commonutils.logger.b.b(str);
        }
    }

    public static void a(String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            if (com.xiaomi.push.q.a.name().equals(str)) {
                cv.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
                cv.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
                cv.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
                cv.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
                cv.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
                str2 = "resolver.msg.xiaomi.net";
                cv.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
                str3 = "111.202.1.252:443";
            } else {
                cv.a("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
                str2 = "resolver.msg.global.xiaomi.net";
                cv.a("resolver.msg.global.xiaomi.net", "161.117.97.14:443");
                str3 = "161.117.180.178:443";
            }
            cv.a(str2, str3);
        }
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65554, this, str, i2) == null) {
            Collection<bg.b> m1575a = bg.a().m1575a(str);
            if (m1575a != null) {
                for (bg.b bVar : m1575a) {
                    if (bVar != null) {
                        a(new s(this, bVar, i2, null, null));
                    }
                }
            }
            bg.a().m1578a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, context)) == null) {
            try {
                com.xiaomi.push.ar.a();
                for (int i2 = 100; i2 > 0; i2--) {
                    if (com.xiaomi.push.bj.c(context)) {
                        com.xiaomi.channel.commonutils.logger.b.m1027a("network connectivity ok.");
                        return true;
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (Exception unused) {
                    }
                }
                return false;
            } catch (Exception unused2) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m1519a(String str, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, str, intent)) == null) {
            bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
            boolean z = false;
            if (a2 == null || str == null) {
                return false;
            }
            String stringExtra = intent.getStringExtra(bk.F);
            String stringExtra2 = intent.getStringExtra(bk.x);
            if (!TextUtils.isEmpty(a2.i) && !TextUtils.equals(stringExtra, a2.i)) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
                z = true;
            }
            if (stringExtra2.equals(a2.h)) {
                return z;
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bo.a(stringExtra2));
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m1520a() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            String a2 = ba.a(getApplicationContext()).a(ho.aN.a(), "");
            if (!TextUtils.isEmpty(a2) && (split = a2.split(",")) != null && split.length >= 2) {
                int[] iArr = new int[2];
                try {
                    iArr[0] = Integer.valueOf(split[0]).intValue();
                    iArr[1] = Integer.valueOf(split[1]).intValue();
                    if (iArr[0] >= 0 && iArr[0] <= 23 && iArr[1] >= 0 && iArr[1] <= 23) {
                        if (iArr[0] != iArr[1]) {
                            return iArr;
                        }
                    }
                } catch (NumberFormatException e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: " + e2);
                }
            }
            return null;
        }
        return (int[]) invokeV.objValue;
    }

    private String b() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            com.xiaomi.push.ar.a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Object obj = new Object();
            String str = null;
            int i2 = 0;
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                bn a2 = bn.a(this);
                String str2 = null;
                while (true) {
                    if (!TextUtils.isEmpty(str2) && a2.a() != 0) {
                        break;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = a();
                    }
                    try {
                        synchronized (obj) {
                            if (i2 < 30) {
                                obj.wait(1000L);
                            } else {
                                obj.wait(30000L);
                            }
                        }
                    } catch (InterruptedException unused) {
                    }
                    i2++;
                }
                b2 = a();
            } else {
                b2 = com.xiaomi.push.m.b();
            }
            if (!TextUtils.isEmpty(b2)) {
                com.xiaomi.push.service.a.a(getApplicationContext()).b(b2);
                str = com.xiaomi.push.m.a(b2).name();
            }
            com.xiaomi.channel.commonutils.logger.b.m1027a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " , count = " + i2);
            return str;
        }
        return (String) invokeV.objValue;
    }

    private void b(Intent intent) {
        long j2;
        String str;
        fl flVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, intent) == null) {
            String stringExtra = intent.getStringExtra(bk.B);
            String stringExtra2 = intent.getStringExtra(bk.F);
            Bundle bundleExtra = intent.getBundleExtra("ext_packet");
            bg a2 = bg.a();
            if (bundleExtra != null) {
                gm gmVar = (gm) a(new gm(bundleExtra), stringExtra, stringExtra2);
                if (gmVar == null) {
                    return;
                }
                flVar = fl.a(gmVar, a2.a(gmVar.k(), gmVar.m()).h);
            } else {
                byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
                if (byteArrayExtra != null) {
                    try {
                        j2 = Long.parseLong(intent.getStringExtra(bk.q));
                    } catch (NumberFormatException unused) {
                        j2 = 0;
                    }
                    String stringExtra3 = intent.getStringExtra(bk.r);
                    String stringExtra4 = intent.getStringExtra(bk.s);
                    String stringExtra5 = intent.getStringExtra("ext_chid");
                    bg.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                    if (a3 != null) {
                        fl flVar2 = new fl();
                        if ("10".equals(stringExtra5)) {
                            flVar2.b(Integer.parseInt("10"));
                            flVar2.f1092a.f1621a = intent.getBooleanExtra("screen_on", true);
                            flVar2.f1092a.f1623b = intent.getBooleanExtra("wifi", true);
                            str = stringExtra3;
                            flVar2.f1092a.f1620a = intent.getLongExtra("rx_msg", -1L);
                            flVar2.f1092a.f1622b = intent.getLongExtra("enqueue", -1L);
                            flVar2.f1092a.b = intent.getIntExtra("num", -1);
                            flVar2.f1092a.c = intent.getLongExtra("run", -1L);
                        } else {
                            str = stringExtra3;
                        }
                        try {
                            flVar2.a(Integer.parseInt(stringExtra5));
                        } catch (NumberFormatException unused2) {
                        }
                        flVar2.a("SECMSG", (String) null);
                        flVar2.a(j2, TextUtils.isEmpty(str) ? "xiaomi.com" : str, stringExtra4);
                        flVar2.a(intent.getStringExtra("ext_pkt_id"));
                        flVar2.a(byteArrayExtra, a3.h);
                        com.xiaomi.channel.commonutils.logger.b.m1027a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                        flVar = flVar2;
                    }
                }
                flVar = null;
            }
            if (flVar != null) {
                c(new bt(this, flVar));
            }
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65564, this, z) == null) {
            this.f1560a = SystemClock.elapsedRealtime();
            if (m1535c()) {
                if (com.xiaomi.push.bj.b(this)) {
                    c(new o(this, z));
                    return;
                }
                c(new g(this, 17, null));
            }
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
            String a3 = a2.a();
            com.xiaomi.channel.commonutils.logger.b.m1027a("region of cache is " + a3);
            if (TextUtils.isEmpty(a3)) {
                a3 = b();
            } else {
                a(a2);
            }
            if (TextUtils.isEmpty(a3)) {
                this.f1577a = com.xiaomi.push.q.a.name();
            } else {
                this.f1577a = a3;
                a2.a(a3);
                if (com.xiaomi.push.q.b.name().equals(this.f1577a)) {
                    str = "app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.q.c.name().equals(this.f1577a)) {
                    str = "fr.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.q.d.name().equals(this.f1577a)) {
                    str = "ru.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.q.e.name().equals(this.f1577a)) {
                    str = "idmb.app.chat.global.xiaomi.net";
                }
                fx.a(str);
            }
            if (com.xiaomi.push.q.a.name().equals(this.f1577a)) {
                fx.a("cn.app.chat.xiaomi.net");
            }
            a(this.f1577a);
            if (m1525h()) {
                cs csVar = new cs(this, 11);
                a(csVar);
                u.a(new ct(this, csVar));
            }
            try {
                if (com.xiaomi.push.v.m1627a()) {
                    this.f1574a.a(this);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, intent) == null) {
            String stringExtra = intent.getStringExtra(bk.B);
            String stringExtra2 = intent.getStringExtra(bk.F);
            Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
            int length = parcelableArrayExtra.length;
            gm[] gmVarArr = new gm[length];
            intent.getBooleanExtra("ext_encrypt", true);
            for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
                gmVarArr[i2] = new gm((Bundle) parcelableArrayExtra[i2]);
                gmVarArr[i2] = (gm) a(gmVarArr[i2], stringExtra, stringExtra2);
                if (gmVarArr[i2] == null) {
                    return;
                }
            }
            bg a2 = bg.a();
            fl[] flVarArr = new fl[length];
            for (int i3 = 0; i3 < length; i3++) {
                gm gmVar = gmVarArr[i3];
                flVarArr[i3] = fl.a(gmVar, a2.a(gmVar.k(), gmVar.m()).h);
            }
            c(new com.xiaomi.push.service.c(this, flVarArr));
        }
    }

    private void c(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, jVar) == null) {
            this.f1575a.a(jVar);
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65570, this, z) == null) {
            try {
                if (com.xiaomi.push.v.m1627a()) {
                    if (!z) {
                        sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                        return;
                    }
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                    for (ar arVar : (ar[]) this.f1579a.toArray(new ar[0])) {
                        arVar.mo1593a();
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            try {
                networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                networkInfo = null;
            }
            com.xiaomi.push.service.o.a(getApplicationContext()).a(networkInfo);
            if (networkInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("network changed,");
                sb.append(PreferencesUtil.LEFT_MOUNT + "type: " + networkInfo.getTypeName() + PreferencesUtil.LEFT_MOUNT + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
                com.xiaomi.channel.commonutils.logger.b.m1027a(sb.toString());
                NetworkInfo.State state = networkInfo.getState();
                if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                    return;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m1027a("network changed, no active network");
            }
            if (fh.a() != null) {
                fh.a().m1265a();
            }
            hb.m1330a((Context) this);
            this.f1563a.d();
            if (com.xiaomi.push.bj.b(this)) {
                if (m1535c() && m1523f()) {
                    b(false);
                }
                if (!m1535c() && !m1536d()) {
                    this.f1575a.a(1);
                    a(new e(this));
                }
                df.a(this).a();
            } else {
                a(new g(this, 2, null));
            }
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:381:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Intent intent) {
        String str;
        com.xiaomi.push.service.j jVar;
        boolean z;
        int i2;
        String format;
        j pVar;
        int i3;
        String b2;
        SharedPreferences sharedPreferences;
        String str2;
        bt btVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, intent) == null) {
            bg a2 = bg.a();
            boolean z2 = true;
            int i4 = 0;
            if (bk.d.equalsIgnoreCase(intent.getAction()) || bk.j.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(bk.t);
                if (!TextUtils.isEmpty(intent.getStringExtra(bk.x))) {
                    if (TextUtils.isEmpty(stringExtra)) {
                        str = "channel id is empty, do nothing!";
                        com.xiaomi.channel.commonutils.logger.b.d(str);
                        return;
                    }
                    boolean m1519a = m1519a(stringExtra, intent);
                    bg.b a3 = a(stringExtra, intent);
                    if (com.xiaomi.push.bj.c(this)) {
                        if (m1535c()) {
                            bg.c cVar = a3.f1651a;
                            if (cVar == bg.c.a) {
                                pVar = new b(this, a3);
                            } else if (m1519a) {
                                pVar = new p(this, a3);
                            } else if (cVar == bg.c.b) {
                                format = String.format("the client is binding. %1$s %2$s.", a3.g, bg.b.a(a3.f1656b));
                            } else if (cVar != bg.c.c) {
                                return;
                            } else {
                                jVar = this.f1574a;
                                z = true;
                                i2 = 0;
                            }
                            c(pVar);
                            return;
                        }
                        a(true);
                        return;
                    }
                    jVar = this.f1574a;
                    z = false;
                    i2 = 2;
                    jVar.a(this, a3, z, i2, null);
                    return;
                }
                format = "security is empty. ignore.";
                com.xiaomi.channel.commonutils.logger.b.m1027a(format);
            } else if (bk.i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra2 = intent.getStringExtra(bk.B);
                String stringExtra3 = intent.getStringExtra(bk.t);
                String stringExtra4 = intent.getStringExtra(bk.q);
                com.xiaomi.channel.commonutils.logger.b.m1027a("Service called close channel chid = " + stringExtra3 + " res = " + bg.b.a(stringExtra4));
                if (TextUtils.isEmpty(stringExtra3)) {
                    for (String str3 : a2.m1576a(stringExtra2)) {
                        a(str3, 2);
                    }
                } else if (TextUtils.isEmpty(stringExtra4)) {
                    a(stringExtra3, 2);
                } else {
                    a(stringExtra3, stringExtra4, 2, null, null);
                }
            } else if (bk.e.equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("run", System.currentTimeMillis());
                }
                b(intent);
            } else if (bk.g.equalsIgnoreCase(intent.getAction())) {
                c(intent);
            } else {
                if (bk.f.equalsIgnoreCase(intent.getAction())) {
                    gn a4 = a(new gl(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bk.B), intent.getStringExtra(bk.F));
                    if (a4 == null) {
                        return;
                    }
                    btVar = new bt(this, fl.a(a4, a2.a(a4.k(), a4.m()).h));
                } else if (!bk.h.equalsIgnoreCase(intent.getAction())) {
                    if (!bk.k.equals(intent.getAction())) {
                        String str4 = null;
                        r2 = null;
                        bg.b a5 = null;
                        str4 = null;
                        if (bk.l.equals(intent.getAction())) {
                            String stringExtra5 = intent.getStringExtra(bk.B);
                            List<String> m1576a = a2.m1576a(stringExtra5);
                            if (!m1576a.isEmpty()) {
                                String stringExtra6 = intent.getStringExtra(bk.t);
                                String stringExtra7 = intent.getStringExtra(bk.q);
                                if (TextUtils.isEmpty(stringExtra6)) {
                                    stringExtra6 = m1576a.get(0);
                                }
                                if (TextUtils.isEmpty(stringExtra7)) {
                                    Collection<bg.b> m1575a = a2.m1575a(stringExtra6);
                                    if (m1575a != null && !m1575a.isEmpty()) {
                                        a5 = m1575a.iterator().next();
                                    }
                                } else {
                                    a5 = a2.a(stringExtra6, stringExtra7);
                                }
                                if (a5 != null) {
                                    if (intent.hasExtra(bk.z)) {
                                        a5.e = intent.getStringExtra(bk.z);
                                    }
                                    if (intent.hasExtra(bk.A)) {
                                        a5.f = intent.getStringExtra(bk.A);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            str2 = "open channel should be called first before update info, pkg=" + stringExtra5;
                        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                            if (!"android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && m1526i() && eu.m1258a()) {
                                    com.xiaomi.channel.commonutils.logger.b.m1027a("enter falldown mode, stop alarm.");
                                    eu.a();
                                    return;
                                }
                                return;
                            } else if (m1526i()) {
                                return;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m1027a("exit falldown mode, activate alarm.");
                                e();
                                if (m1535c() || m1536d()) {
                                    return;
                                }
                                a(true);
                                return;
                            }
                        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                            if (bn.a(getApplicationContext()).m1583a() && bn.a(getApplicationContext()).a() == 0) {
                                str2 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                            } else {
                                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                                String stringExtra8 = intent.getStringExtra("mipush_app_package");
                                boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                                int intExtra = intent.getIntExtra("mipush_env_type", 1);
                                v.a(this).d(stringExtra8);
                                if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                    a(byteArrayExtra, stringExtra8);
                                    return;
                                }
                                pVar = new cu(this, 14, intExtra, stringExtra8, byteArrayExtra);
                            }
                        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                            String stringExtra9 = intent.getStringExtra("mipush_app_package");
                            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                            if (com.xiaomi.push.service.m.a(byteArrayExtra2, stringExtra9)) {
                                format = "duplicate msg from: " + String.valueOf(stringExtra9);
                                com.xiaomi.channel.commonutils.logger.b.m1027a(format);
                            }
                            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                v.a(this).a(stringExtra9);
                                if (com.xiaomi.push.m.m1499a(getApplicationContext())) {
                                    ag.a(stringExtra9);
                                }
                            }
                            a(stringExtra9, byteArrayExtra2, booleanExtra2);
                            return;
                        } else if (!bo.a.equals(intent.getAction())) {
                            if (bo.b.equals(intent.getAction())) {
                                String stringExtra10 = intent.getStringExtra("data_cleared_pkg_name");
                                if (TextUtils.isEmpty(stringExtra10)) {
                                    return;
                                }
                                try {
                                    sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                    if (sharedPreferences != null) {
                                        try {
                                            str4 = sharedPreferences.getString(stringExtra10, null);
                                        } catch (Throwable th) {
                                            th = th;
                                            com.xiaomi.channel.commonutils.logger.b.m1027a("Fail to get sp or appId : " + th);
                                            if (!TextUtils.isEmpty(str4)) {
                                            }
                                            at.a((Context) this, stringExtra10);
                                            if (com.xiaomi.push.m.m1499a(getApplicationContext())) {
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    sharedPreferences = null;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.remove(stringExtra10);
                                    edit.commit();
                                    if (al.m1550b((Context) this, stringExtra10)) {
                                        al.c(this, stringExtra10);
                                    }
                                    al.m1544a((Context) this, stringExtra10);
                                    a(stringExtra10, it.a(ah.b(stringExtra10, str4)), true);
                                }
                                at.a((Context) this, stringExtra10);
                                if (com.xiaomi.push.m.m1499a(getApplicationContext())) {
                                    return;
                                }
                                ag.a(stringExtra10);
                                return;
                            } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                                String stringExtra11 = intent.getStringExtra(bk.B);
                                int intExtra2 = intent.getIntExtra(bk.C, -2);
                                if (TextUtils.isEmpty(stringExtra11)) {
                                    return;
                                }
                                if (intExtra2 >= -1) {
                                    al.a(this, stringExtra11, intExtra2, intent.getIntExtra(bk.D, -1));
                                    return;
                                } else {
                                    al.a(this, stringExtra11, intent.getStringExtra(bk.H), intent.getStringExtra(bk.I));
                                    return;
                                }
                            } else if ("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION".equals(intent.getAction())) {
                                String stringExtra12 = intent.getStringExtra(bk.B);
                                if (TextUtils.isEmpty(stringExtra12)) {
                                    return;
                                }
                                al.m1549b((Context) this, stringExtra12);
                                return;
                            } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                                String stringExtra13 = intent.getStringExtra(bk.B);
                                String stringExtra14 = intent.getStringExtra(bk.G);
                                if (intent.hasExtra(bk.E)) {
                                    int intExtra3 = intent.getIntExtra(bk.E, 0);
                                    b2 = com.xiaomi.push.bo.b(stringExtra13 + intExtra3);
                                    i4 = intExtra3;
                                    z2 = false;
                                } else {
                                    b2 = com.xiaomi.push.bo.b(stringExtra13);
                                }
                                if (!TextUtils.isEmpty(stringExtra13) && TextUtils.equals(stringExtra14, b2)) {
                                    if (z2) {
                                        al.c(this, stringExtra13);
                                        return;
                                    } else {
                                        al.b(this, stringExtra13, i4);
                                        return;
                                    }
                                }
                                str = "invalid notification for " + stringExtra13;
                                com.xiaomi.channel.commonutils.logger.b.d(str);
                                return;
                            } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                                String stringExtra15 = intent.getStringExtra("mipush_app_package");
                                if (!TextUtils.isEmpty(stringExtra15)) {
                                    v.a(this).b(stringExtra15);
                                }
                                if ("com.xiaomi.xmsf".equals(getPackageName())) {
                                    return;
                                }
                                a(19, (Exception) null);
                                e();
                                stopSelf();
                                return;
                            } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                String stringExtra16 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                                String stringExtra17 = intent.getStringExtra("mipush_app_id");
                                String stringExtra18 = intent.getStringExtra("mipush_app_token");
                                if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    v.a(this).c(stringExtra16);
                                }
                                if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    v.a(this).e(stringExtra16);
                                    v.a(this).f(stringExtra16);
                                }
                                if (byteArrayExtra3 == null) {
                                    x.a(this, stringExtra16, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                                    return;
                                }
                                x.b(stringExtra16, byteArrayExtra3);
                                a(new w(this, stringExtra16, stringExtra17, stringExtra18, byteArrayExtra3));
                                if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f1568a == null) {
                                    this.f1568a = new f(this);
                                    registerReceiver(this.f1568a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                    return;
                                }
                                return;
                            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                                String stringExtra19 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                                hn hnVar = new hn();
                                try {
                                    it.a(hnVar, byteArrayExtra4);
                                    hg.a(this).a(hnVar, stringExtra19);
                                    return;
                                } catch (iz e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    return;
                                }
                            } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                                com.xiaomi.channel.commonutils.logger.b.m1027a("[Alarm] Service called on timer");
                                if (!m1526i()) {
                                    eu.a(false);
                                    if (m1523f()) {
                                        b(false);
                                    }
                                } else if (eu.m1258a()) {
                                    com.xiaomi.channel.commonutils.logger.b.m1027a("enter falldown mode, stop alarm");
                                    eu.a();
                                }
                                a aVar = this.f1567a;
                                if (aVar != null) {
                                    aVar.a();
                                    return;
                                }
                                return;
                            } else if ("com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                                com.xiaomi.channel.commonutils.logger.b.m1027a("Service called on check alive.");
                                if (m1523f()) {
                                    b(false);
                                    return;
                                }
                                return;
                            } else if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                                com.xiaomi.channel.commonutils.logger.b.m1027a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                                eu.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                                return;
                            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                                d();
                                return;
                            } else if ("miui.net.wifi.DIGEST_INFORMATION_CHANGED".equals(intent.getAction())) {
                                a(intent);
                                return;
                            } else if ("com.xiaomi.xmsf.USE_INTELLIGENT_HB".equals(intent.getAction())) {
                                if (intent.getExtras() == null || (i3 = intent.getExtras().getInt("effectivePeriod", 0)) <= 0 || i3 > 604800) {
                                    return;
                                }
                                com.xiaomi.push.service.o.a(getApplicationContext()).a(i3);
                                return;
                            } else if ("action_cr_config".equals(intent.getAction())) {
                                boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                                long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                                boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                                long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                                boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                                long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                                Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.push.bt.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
                                if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                    return;
                                }
                                en.a(getApplicationContext(), build);
                                return;
                            } else if (!"action_help_ping".equals(intent.getAction())) {
                                if ("action_aw_app_logic".equals(intent.getAction())) {
                                    e(intent);
                                    return;
                                } else if (bk.n.equals(intent.getAction())) {
                                    com.xiaomi.push.service.n.a(getApplicationContext(), intent);
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                                int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                                if (intExtra4 >= 0 && intExtra4 < 30) {
                                    com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                                    intExtra4 = 30;
                                }
                                boolean z3 = intExtra4 >= 0 ? booleanExtra6 : false;
                                com.xiaomi.channel.commonutils.logger.b.m1027a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                                if (!z3 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                    return;
                                }
                                a(intent, intExtra4);
                                return;
                            }
                        } else {
                            String stringExtra20 = intent.getStringExtra("uninstall_pkg_name");
                            if (stringExtra20 == null || TextUtils.isEmpty(stringExtra20.trim())) {
                                return;
                            }
                            try {
                                PackageInfo packageInfo = getPackageManager().getPackageInfo(stringExtra20, 0);
                                if (packageInfo == null || packageInfo.applicationInfo == null || !com.xiaomi.push.j.a(this, packageInfo.packageName)) {
                                    z2 = false;
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.m1027a("dual space's app uninstalled " + stringExtra20);
                                }
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                            if (!"com.xiaomi.channel".equals(stringExtra20) || bg.a().m1575a("1").isEmpty() || !z2) {
                                SharedPreferences sharedPreferences2 = getSharedPreferences("pref_registered_pkg_names", 0);
                                String string = sharedPreferences2.getString(stringExtra20, null);
                                if (TextUtils.isEmpty(string) || !z2) {
                                    return;
                                }
                                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                                edit2.remove(stringExtra20);
                                edit2.commit();
                                if (al.m1550b((Context) this, stringExtra20)) {
                                    al.c(this, stringExtra20);
                                }
                                al.m1544a((Context) this, stringExtra20);
                                at.a(getApplicationContext(), stringExtra20);
                                if (!m1535c() || string == null) {
                                    return;
                                }
                                try {
                                    ah.a(this, ah.a(stringExtra20, string));
                                    com.xiaomi.channel.commonutils.logger.b.m1027a("uninstall " + stringExtra20 + " msg sent");
                                    return;
                                } catch (gh e3) {
                                    com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                                    a(10, e3);
                                    return;
                                }
                            }
                            a("1", 0);
                            str2 = "close the miliao channel as the app is uninstalled.";
                        }
                        com.xiaomi.channel.commonutils.logger.b.m1027a(str2);
                        return;
                    }
                    String stringExtra21 = intent.getStringExtra(bk.t);
                    String stringExtra22 = intent.getStringExtra(bk.q);
                    if (stringExtra21 == null) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m1027a("request reset connection from chid = " + stringExtra21);
                    bg.b a6 = bg.a().a(stringExtra21, stringExtra22);
                    if (a6 == null || !a6.h.equals(intent.getStringExtra(bk.x)) || a6.f1651a != bg.c.c) {
                        return;
                    }
                    fw m1527a = m1527a();
                    if (m1527a != null && m1527a.a(SystemClock.elapsedRealtime() - 15000)) {
                        return;
                    }
                    pVar = new q(this);
                    c(pVar);
                    return;
                } else {
                    gn a7 = a(new gp(intent.getBundleExtra("ext_packet")), intent.getStringExtra(bk.B), intent.getStringExtra(bk.F));
                    if (a7 == null) {
                        return;
                    }
                    btVar = new bt(this, fl.a(a7, a2.a(a7.k(), a7.m()).h));
                }
                c(btVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            if (!m1530a()) {
                eu.a();
            } else if (eu.m1258a()) {
            } else {
                eu.a(true);
            }
        }
    }

    private void e(Intent intent) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, this, intent) == null) {
            try {
                ed.a(getApplicationContext()).a(new bm());
                String stringExtra = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra == null) {
                    return;
                }
                ii iiVar = new ii();
                it.a(iiVar, byteArrayExtra);
                String b2 = iiVar.b();
                Map<String, String> m1419a = iiVar.m1419a();
                if (m1419a != null) {
                    String str = m1419a.get("extra_help_aw_info");
                    String str2 = m1419a.get("extra_aw_app_online_cmd");
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        i2 = Integer.parseInt(str2);
                    } catch (NumberFormatException unused) {
                        i2 = 0;
                    }
                    if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    ed.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
                }
            } catch (iz e2) {
                com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
            }
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m1522e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? b : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            fw fwVar = this.f1564a;
            if (fwVar == null || !fwVar.m1297b()) {
                fw fwVar2 = this.f1564a;
                if (fwVar2 == null || !fwVar2.m1298c()) {
                    this.f1565a.b(com.xiaomi.push.bj.m1132a((Context) this));
                    g();
                    if (this.f1564a == null) {
                        bg.a().a(this);
                        c(false);
                        return;
                    }
                    return;
                }
                str = "try to connect while is connected.";
            } else {
                str = "try to connect while connecting.";
            }
            com.xiaomi.channel.commonutils.logger.b.d(str);
        }
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m1523f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            if (SystemClock.elapsedRealtime() - this.f1560a < 30000) {
                return false;
            }
            return com.xiaomi.push.bj.d(this);
        }
        return invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            try {
                this.f1563a.a(this.f1566a, new cl(this));
                this.f1563a.e();
                this.f1564a = this.f1563a;
            } catch (gh e2) {
                com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
                this.f1563a.b(3, e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m1524g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1 : invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
        }
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m1525h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) || !v.a(this).m1623b(getPackageName()) : invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            synchronized (this.f1578a) {
                this.f1578a.clear();
            }
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m1526i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) ? getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.j.m1476b((Context) this) && !com.xiaomi.push.j.m1474a(getApplicationContext()) : invokeV.booleanValue;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
            int i2 = this.a;
            int i3 = this.f1581b;
            if (i2 > i3) {
                if (intValue >= i2 || intValue < i3) {
                    return true;
                }
            } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
                return false;
            }
            return ba.a(this).a(ho.H.a(), false);
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fw m1527a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1564a : (fw) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.j m1528a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.xiaomi.push.service.j() : (com.xiaomi.push.service.j) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1529a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && SystemClock.elapsedRealtime() - this.f1560a >= gc.a() && com.xiaomi.push.bj.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f1575a.a(i2);
        }
    }

    public void a(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, exc) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("disconnect ");
            sb.append(hashCode());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            fw fwVar = this.f1564a;
            sb.append(fwVar == null ? null : Integer.valueOf(fwVar.hashCode()));
            com.xiaomi.channel.commonutils.logger.b.m1027a(sb.toString());
            fw fwVar2 = this.f1564a;
            if (fwVar2 != null) {
                fwVar2.b(i2, exc);
                this.f1564a = null;
            }
            a(7);
            a(4);
            bg.a().a(this, i2);
        }
    }

    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, flVar) == null) {
            fw fwVar = this.f1564a;
            if (fwVar == null) {
                throw new gh("try send msg while connection is null.");
            }
            fwVar.b(flVar);
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fwVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
            fh.a().a(fwVar);
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, fwVar, i2, exc) == null) {
            fh.a().a(fwVar, i2, exc);
            if (m1526i()) {
                return;
            }
            a(false);
        }
    }

    @Override // com.xiaomi.push.fz
    public void a(fw fwVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fwVar, exc) == null) {
            fh.a().a(fwVar, exc);
            c(false);
            if (m1526i()) {
                return;
            }
            a(false);
        }
    }

    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jVar) == null) {
            a(jVar, 0L);
        }
    }

    public void a(j jVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, jVar, j2) == null) {
            try {
                this.f1575a.a(jVar, j2);
            } catch (IllegalStateException e2) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("can't execute job err = " + e2.getMessage());
            }
        }
    }

    public void a(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, nVar) == null) {
            synchronized (this.f1578a) {
                this.f1578a.add(nVar);
            }
        }
    }

    public void a(bg.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        long a2 = bVar.a();
        com.xiaomi.channel.commonutils.logger.b.m1027a("schedule rebind job in " + (a2 / 1000));
        a(new b(this, bVar), a2);
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4}) == null) {
            bg.b a2 = bg.a().a(str, str2);
            if (a2 != null) {
                a(new s(this, a2, i2, str4, str3));
            }
            bg.a().m1579a(str, str2);
        }
    }

    public void a(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, str, bArr, z) == null) {
            Collection<bg.b> m1575a = bg.a().m1575a("5");
            if (m1575a.isEmpty()) {
                if (!z) {
                    return;
                }
            } else if (m1575a.iterator().next().f1651a == bg.c.c) {
                a(new cj(this, 4, str, bArr));
                return;
            } else if (!z) {
                return;
            }
            x.b(str, bArr);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f1573a.a(z);
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bArr, str) == null) {
            if (bArr == null) {
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                com.xiaomi.channel.commonutils.logger.b.m1027a("register request without payload");
                return;
            }
            Cif cif = new Cif();
            try {
                it.a(cif, bArr);
                if (cif.f1345a == hj.a) {
                    ij ijVar = new ij();
                    try {
                        it.a(ijVar, cif.m1409a());
                        a(new w(this, cif.b(), ijVar.b(), ijVar.c(), bArr));
                        eo.a(getApplicationContext()).a(cif.b(), "E100003", ijVar.a(), 6002, null);
                    } catch (iz e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                        x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                    }
                } else {
                    x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                    com.xiaomi.channel.commonutils.logger.b.m1027a("register request with invalid payload");
                }
            } catch (iz e3) {
                com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
            }
        }
    }

    public void a(fl[] flVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, flVarArr) == null) {
            fw fwVar = this.f1564a;
            if (fwVar == null) {
                throw new gh("try send msg while connection is null.");
            }
            fwVar.a(flVarArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1530a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            boolean b2 = com.xiaomi.push.bj.b(this);
            boolean z = bg.a().m1573a() > 0;
            boolean z2 = !m1534b();
            boolean m1525h = m1525h();
            boolean z3 = !m1524g();
            boolean z4 = b2 && z && z2 && m1525h && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m1525h), Boolean.valueOf(z3)));
            }
            return z4;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1531a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.f1575a.m1609a(i2) : invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public com.xiaomi.push.service.j m1532b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f1574a : (com.xiaomi.push.service.j) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m1533b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.xiaomi.push.service.o.a(getApplicationContext()).m1606d();
            Iterator it = new ArrayList(this.f1578a).iterator();
            while (it.hasNext()) {
                ((n) it.next()).mo1332a();
            }
        }
    }

    @Override // com.xiaomi.push.fz
    public void b(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fwVar) == null) {
            fh.a().b(fwVar);
            c(true);
            this.f1573a.m1585a();
            if (!eu.m1258a() && !m1526i()) {
                com.xiaomi.channel.commonutils.logger.b.m1027a("reconnection successful, reactivate alarm.");
                eu.a(true);
            }
            Iterator<bg.b> it = bg.a().m1574a().iterator();
            while (it.hasNext()) {
                a(new b(this, it.next()));
            }
            if (this.f1580a || !com.xiaomi.push.m.m1499a(getApplicationContext())) {
                return;
            }
            com.xiaomi.push.al.a(getApplicationContext()).a(new cm(this));
        }
    }

    public void b(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, jVar) == null) {
            this.f1575a.a(jVar.a, jVar);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1534b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            try {
                Class<?> a2 = com.xiaomi.push.v.a(this, "miui.os.Build");
                Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
                Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
                Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
                if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                    if (!field3.getBoolean(null)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1535c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            fw fwVar = this.f1564a;
            return fwVar != null && fwVar.m1298c();
        }
        return invokeV.booleanValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m1536d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            fw fwVar = this.f1564a;
            return fwVar != null && fwVar.m1297b();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, intent)) == null) ? this.f1562a.getBinder() : (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onCreate();
            com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
            com.xiaomi.push.v.a((Context) this);
            com.xiaomi.push.service.t m1618a = u.m1618a((Context) this);
            if (m1618a != null) {
                com.xiaomi.push.ae.a(m1618a.a);
            }
            if (com.xiaomi.push.m.m1499a(getApplicationContext())) {
                HandlerThread handlerThread = new HandlerThread("hb-alarm");
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                this.f1567a = new a(this, null);
                registerReceiver(this.f1567a, new IntentFilter(bk.p), null, handler);
                b = true;
                handler.post(new cn(this));
            }
            this.f1562a = new Messenger(new co(this));
            bl.a(this);
            cp cpVar = new cp(this, null, 5222, "xiaomi.com", null);
            this.f1565a = cpVar;
            cpVar.a(true);
            this.f1563a = new fs(this, this.f1565a);
            this.f1574a = m1528a();
            eu.a(this);
            this.f1563a.a(this);
            this.f1572a = new be(this);
            this.f1573a = new bq(this);
            new com.xiaomi.push.service.k().a();
            fh.m1266a().a(this);
            this.f1575a = new com.xiaomi.push.service.p("Connection Controller Thread");
            bg a2 = bg.a();
            a2.b();
            a2.a(new cq(this));
            if (k()) {
                h();
            }
            hg.a(this).a(new com.xiaomi.push.service.r(this), "UPLOADER_PUSH_CHANNEL");
            a(new hd(this));
            a(new cg(this));
            if (com.xiaomi.push.m.m1499a((Context) this)) {
                a(new bf());
            }
            a(new h(this));
            this.f1579a.add(bx.a(this));
            if (m1525h()) {
                this.f1568a = new f(this);
                registerReceiver(this.f1568a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            if (com.xiaomi.push.m.m1499a(getApplicationContext())) {
                this.f1571a = new t(this);
                registerReceiver(this.f1571a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null);
                k kVar = new k(this);
                this.f1569a = kVar;
                registerReceiver(kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null);
            }
            com.xiaomi.push.service.o.a(getApplicationContext()).m1602a();
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
                if (uriFor != null) {
                    this.f1561a = new cr(this, new Handler(Looper.getMainLooper()));
                    try {
                        getContentResolver().registerContentObserver(uriFor, false, this.f1561a);
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                    }
                }
                int[] m1520a = m1520a();
                if (m1520a != null) {
                    this.f1570a = new r(this);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    registerReceiver(this.f1570a, intentFilter);
                    this.a = m1520a[0];
                    this.f1581b = m1520a[1];
                    com.xiaomi.channel.commonutils.logger.b.m1027a("falldown initialized: " + this.a + "," + this.f1581b);
                }
            }
            String str = "";
            if (m1618a != null) {
                try {
                    if (!TextUtils.isEmpty(m1618a.f1724a) && (split = m1618a.f1724a.split("@")) != null && split.length > 0) {
                        str = split[0];
                    }
                } catch (Exception unused) {
                }
            }
            dd.a(this);
            com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.h.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            f fVar = this.f1568a;
            if (fVar != null) {
                a(fVar);
                this.f1568a = null;
            }
            t tVar = this.f1571a;
            if (tVar != null) {
                a(tVar);
                this.f1571a = null;
            }
            k kVar = this.f1569a;
            if (kVar != null) {
                a(kVar);
                this.f1569a = null;
            }
            r rVar = this.f1570a;
            if (rVar != null) {
                a(rVar);
                this.f1570a = null;
            }
            a aVar = this.f1567a;
            if (aVar != null) {
                a(aVar);
                this.f1567a = null;
            }
            if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f1561a != null) {
                try {
                    getContentResolver().unregisterContentObserver(this.f1561a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
                }
            }
            this.f1579a.clear();
            this.f1575a.m1610b();
            a(new ck(this, 2));
            a(new l(this));
            bg.a().b();
            bg.a().a(this, 15);
            bg.a().m1577a();
            this.f1563a.b(this);
            bv.a().m1591a();
            eu.a();
            i();
            super.onDestroy();
            com.xiaomi.channel.commonutils.logger.b.m1027a("Service destroyed");
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, intent, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (intent == null) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
            } else {
                com.xiaomi.channel.commonutils.logger.b.m1027a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bk.t), intent.getStringExtra(bk.B), intent.getStringExtra("mipush_app_package")));
            }
            if (intent != null && intent.getAction() != null) {
                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                    if (this.f1575a.m1608a()) {
                        com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                        bg.a().a(this, 14);
                        stopSelf();
                    } else {
                        iVar = new i(this, intent);
                        a(iVar);
                    }
                } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                    if ("10".equals(intent.getStringExtra("ext_chid"))) {
                        intent.putExtra("rx_msg", System.currentTimeMillis());
                        intent.putExtra("screen_on", com.xiaomi.push.w.a(getApplicationContext()));
                        intent.putExtra("wifi", com.xiaomi.push.bj.e(getApplicationContext()));
                    }
                    iVar = new i(this, intent);
                    a(iVar);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis2 > 50) {
                com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048607, this, intent, i2, i3)) == null) {
            onStart(intent, i3);
            return 1;
        }
        return invokeLII.intValue;
    }
}
