package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.cs;
import com.xiaomi.push.db;
import com.xiaomi.push.ea;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.er;
import com.xiaomi.push.fa;
import com.xiaomi.push.fh;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fo;
import com.xiaomi.push.fq;
import com.xiaomi.push.fr;
import com.xiaomi.push.fw;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.ge;
import com.xiaomi.push.gq;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.h;
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
public class XMPushService extends Service implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f43534a;

    /* renamed from: a  reason: collision with other field name */
    public long f839a;

    /* renamed from: a  reason: collision with other field name */
    public ContentObserver f840a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f841a;

    /* renamed from: a  reason: collision with other field name */
    public fh f842a;

    /* renamed from: a  reason: collision with other field name */
    public fl f843a;

    /* renamed from: a  reason: collision with other field name */
    public fm f844a;

    /* renamed from: a  reason: collision with other field name */
    public fq f845a;

    /* renamed from: a  reason: collision with other field name */
    public e f846a;

    /* renamed from: a  reason: collision with other field name */
    public p f847a;

    /* renamed from: a  reason: collision with other field name */
    public au f848a;

    /* renamed from: a  reason: collision with other field name */
    public bf f849a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.e f850a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.h f851a;

    /* renamed from: a  reason: collision with other field name */
    public Class f852a;

    /* renamed from: a  reason: collision with other field name */
    public String f853a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<l> f854a;

    /* renamed from: a  reason: collision with other field name */
    public Collection<ai> f855a;

    /* renamed from: b  reason: collision with root package name */
    public int f43535b;

    /* renamed from: b  reason: collision with other field name */
    public ContentObserver f856b;

    /* loaded from: classes8.dex */
    public class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43536a;

        /* renamed from: a  reason: collision with other field name */
        public av.b f857a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(XMPushService xMPushService, av.b bVar) {
            super(9);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, bVar};
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
            this.f43536a = xMPushService;
            this.f857a = null;
            this.f857a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "bind the client. " + this.f857a.f43594g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (!this.f43536a.m567c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                        return;
                    }
                    av.b a2 = av.a().a(this.f857a.f43594g, this.f857a.f914b);
                    if (a2 == null) {
                        str = "ignore bind because the channel " + this.f857a.f43594g + " is removed ";
                    } else if (a2.f909a == av.c.f43602a) {
                        a2.a(av.c.f43603b, 0, 0, (String) null, (String) null);
                        this.f43536a.f843a.a(a2);
                        gz.a(this.f43536a, a2);
                        return;
                    } else {
                        str = "trying duplicate bind, ingore! " + a2.f909a;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m70a(str);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    this.f43536a.a(10, e2);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final av.b f43537a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(av.b bVar) {
            super(12);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
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
            this.f43537a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "bind time out. chid=" + this.f43537a.f43594g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43537a.a(av.c.f43602a, 1, 21, (String) null, (String) null);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof b) {
                    return TextUtils.equals(((b) obj).f43537a.f43594g, this.f43537a.f43594g);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f43537a.f43594g.hashCode() : invokeV.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public fa f43538a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f858a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(XMPushService xMPushService, fa faVar) {
            super(8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, faVar};
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
            this.f858a = xMPushService;
            this.f43538a = null;
            this.f43538a = faVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "receive a message." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f858a.f848a.a(this.f43538a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43539a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(XMPushService xMPushService) {
            super(1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
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
            this.f43539a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "do reconnect.." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f43539a.m563a()) {
                    XMPushService xMPushService = this.f43539a;
                    if (xMPushService.a(xMPushService.getApplicationContext())) {
                        this.f43539a.f();
                        return;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m70a("should not connect. quit the job.");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43540a;

        public e(XMPushService xMPushService) {
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
            this.f43540a = xMPushService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.f43540a.onStart(intent, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43541a;

        /* renamed from: a  reason: collision with other field name */
        public Exception f859a;

        /* renamed from: b  reason: collision with root package name */
        public int f43542b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(XMPushService xMPushService, int i2, Exception exc) {
            super(2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, Integer.valueOf(i2), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43541a = xMPushService;
            this.f43542b = i2;
            this.f859a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "disconnect the connection." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43541a.a(this.f43542b, this.f859a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43543a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(XMPushService xMPushService) {
            super(65535);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
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
            this.f43543a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Init Job" : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43543a.c();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Intent f43544a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f860a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(XMPushService xMPushService, Intent intent) {
            super(15);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, intent};
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
            this.f860a = xMPushService;
            this.f43544a = null;
            this.f43544a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Handle intent action = " + this.f43544a.getAction();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f860a.c(this.f43544a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class i extends h.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public abstract String a();

        /* renamed from: a  reason: collision with other method in class */
        public abstract void m569a();

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f43661a;
                if (i2 != 4 && i2 != 8) {
                    com.xiaomi.channel.commonutils.logger.b.m71a(com.xiaomi.channel.commonutils.logger.a.f42717a, a());
                }
                m569a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43545a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(XMPushService xMPushService) {
            super(5);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
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
            this.f43545a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "ask the job queue to quit" : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43545a.f851a.m620a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public gc f43546a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(XMPushService xMPushService, gc gcVar) {
            super(8);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, gcVar};
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
            this.f861a = xMPushService;
            this.f43546a = null;
            this.f43546a = gcVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "receive a message." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f861a.f848a.a(this.f43546a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface l {
        /* renamed from: a */
        void mo370a();
    }

    /* loaded from: classes8.dex */
    public class m extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43547a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f862a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(XMPushService xMPushService, boolean z) {
            super(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, Boolean.valueOf(z)};
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
            this.f43547a = xMPushService;
            this.f862a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send ping.." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f43547a.m567c()) {
                try {
                    if (!this.f862a) {
                        gz.a();
                    }
                    this.f43547a.f843a.b(this.f862a);
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    this.f43547a.a(10, e2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43548a;

        /* renamed from: a  reason: collision with other field name */
        public av.b f863a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(XMPushService xMPushService, av.b bVar) {
            super(4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, bVar};
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
            this.f43548a = xMPushService;
            this.f863a = null;
            this.f863a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "rebind the client. " + this.f863a.f43594g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f863a.a(av.c.f43602a, 1, 16, (String) null, (String) null);
                    this.f43548a.f843a.a(this.f863a.f43594g, this.f863a.f914b);
                    this.f863a.a(av.c.f43603b, 1, 16, (String) null, (String) null);
                    this.f43548a.f843a.a(this.f863a);
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    this.f43548a.a(10, e2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43549a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(XMPushService xMPushService) {
            super(3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService};
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
            this.f43549a = xMPushService;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "reset the connection." : (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f43549a.a(11, (Exception) null);
                if (this.f43549a.m563a()) {
                    XMPushService xMPushService = this.f43549a;
                    if (xMPushService.a(xMPushService.getApplicationContext())) {
                        this.f43549a.f();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43550a;

        public p(XMPushService xMPushService) {
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
            this.f43550a = xMPushService;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.f43550a.onStart(intent, 1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ XMPushService f43551a;

        /* renamed from: a  reason: collision with other field name */
        public av.b f864a;

        /* renamed from: a  reason: collision with other field name */
        public String f865a;

        /* renamed from: b  reason: collision with root package name */
        public int f43552b;

        /* renamed from: b  reason: collision with other field name */
        public String f866b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(XMPushService xMPushService, av.b bVar, int i2, String str, String str2) {
            super(9);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xMPushService, bVar, Integer.valueOf(i2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43551a = xMPushService;
            this.f864a = null;
            this.f864a = bVar;
            this.f43552b = i2;
            this.f865a = str;
            this.f866b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "unbind the channel. " + this.f864a.f43594g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f864a.f909a != av.c.f43602a && this.f43551a.f843a != null) {
                    try {
                        this.f43551a.f843a.a(this.f864a.f43594g, this.f864a.f914b);
                    } catch (fw e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        this.f43551a.a(10, e2);
                    }
                }
                this.f864a.a(av.c.f43602a, this.f43552b, 0, this.f866b, this.f865a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1323430550, "Lcom/xiaomi/push/service/XMPushService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1323430550, "Lcom/xiaomi/push/service/XMPushService;");
                return;
            }
        }
        cs.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
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
        this.f43534a = 0;
        this.f43535b = 0;
        this.f839a = 0L;
        this.f852a = XMJobService.class;
        this.f848a = null;
        this.f851a = null;
        this.f841a = null;
        this.f855a = Collections.synchronizedCollection(new ArrayList());
        this.f854a = new ArrayList<>();
        this.f845a = new br(this);
    }

    private gc a(gc gcVar, String str, String str2) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, gcVar, str, str2)) == null) {
            av a2 = av.a();
            List<String> m602a = a2.m602a(str);
            if (m602a.isEmpty()) {
                sb = new StringBuilder();
                str3 = "open channel should be called first before sending a packet, pkg=";
            } else {
                gcVar.o(str);
                str = gcVar.k();
                if (TextUtils.isEmpty(str)) {
                    str = m602a.get(0);
                    gcVar.l(str);
                }
                av.b a3 = a2.a(str, gcVar.m());
                if (!m567c()) {
                    sb = new StringBuilder();
                    str3 = "drop a packet as the channel is not connected, chid=";
                } else if (a3 != null && a3.f909a == av.c.f43604c) {
                    if (TextUtils.equals(str2, a3.f43596i)) {
                        return gcVar;
                    }
                    sb = new StringBuilder();
                    sb.append("invalid session. ");
                    sb.append(str2);
                    com.xiaomi.channel.commonutils.logger.b.m70a(sb.toString());
                    return null;
                } else {
                    sb = new StringBuilder();
                    str3 = "drop a packet as the channel is not opened, chid=";
                }
            }
            sb.append(str3);
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.m70a(sb.toString());
            return null;
        }
        return (gc) invokeLLL.objValue;
    }

    private av.b a(String str, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, intent)) == null) {
            av.b a2 = av.a().a(str, intent.getStringExtra(az.p));
            if (a2 == null) {
                a2 = new av.b(this);
            }
            a2.f43594g = intent.getStringExtra(az.s);
            a2.f914b = intent.getStringExtra(az.p);
            a2.f43590c = intent.getStringExtra(az.u);
            a2.f911a = intent.getStringExtra(az.A);
            a2.f43592e = intent.getStringExtra(az.y);
            a2.f43593f = intent.getStringExtra(az.z);
            a2.f913a = intent.getBooleanExtra(az.x, false);
            a2.f43595h = intent.getStringExtra(az.w);
            a2.f43596i = intent.getStringExtra(az.D);
            a2.f43591d = intent.getStringExtra(az.v);
            a2.f910a = this.f850a;
            a2.a((Messenger) intent.getParcelableExtra(az.H));
            a2.f903a = getApplicationContext();
            av.a().a(a2);
            return a2;
        }
        return (av.b) invokeLL.objValue;
    }

    private String a() {
        InterceptResult invokeV;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            com.xiaomi.push.ao.a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Object obj = new Object();
            String str = null;
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                bc a2 = bc.a(this);
                b2 = null;
                while (true) {
                    if (!TextUtils.isEmpty(b2) && a2.a() != 0) {
                        break;
                    }
                    if (TextUtils.isEmpty(b2)) {
                        b2 = com.xiaomi.push.l.m533a("ro.miui.region");
                        if (TextUtils.isEmpty(b2)) {
                            b2 = com.xiaomi.push.l.m533a("ro.product.locale.region");
                        }
                    }
                    try {
                        synchronized (obj) {
                            obj.wait(100L);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                b2 = com.xiaomi.push.l.b();
            }
            if (!TextUtils.isEmpty(b2)) {
                com.xiaomi.push.service.a.a(getApplicationContext()).b(b2);
                str = com.xiaomi.push.l.a(b2).name();
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
            return str;
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
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, intent) == null) {
            String stringExtra = intent.getStringExtra(az.A);
            String stringExtra2 = intent.getStringExtra(az.D);
            Bundle bundleExtra = intent.getBundleExtra("ext_packet");
            av a2 = av.a();
            fa faVar = null;
            if (bundleExtra != null) {
                gb gbVar = (gb) a(new gb(bundleExtra), stringExtra, stringExtra2);
                if (gbVar == null) {
                    return;
                }
                faVar = fa.a(gbVar, a2.a(gbVar.k(), gbVar.m()).f43595h);
            } else {
                byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
                if (byteArrayExtra != null) {
                    try {
                        j2 = Long.parseLong(intent.getStringExtra(az.p));
                    } catch (NumberFormatException unused) {
                        j2 = 0;
                    }
                    String stringExtra3 = intent.getStringExtra(az.q);
                    String stringExtra4 = intent.getStringExtra(az.r);
                    String stringExtra5 = intent.getStringExtra("ext_chid");
                    av.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                    if (a3 != null) {
                        fa faVar2 = new fa();
                        try {
                            faVar2.a(Integer.parseInt(stringExtra5));
                        } catch (NumberFormatException unused2) {
                        }
                        faVar2.a("SECMSG", (String) null);
                        if (TextUtils.isEmpty(stringExtra3)) {
                            stringExtra3 = "xiaomi.com";
                        }
                        faVar2.a(j2, stringExtra3, stringExtra4);
                        faVar2.a(intent.getStringExtra("ext_pkt_id"));
                        faVar2.a(byteArrayExtra, a3.f43595h);
                        com.xiaomi.channel.commonutils.logger.b.m70a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                        faVar = faVar2;
                    }
                }
            }
            if (faVar != null) {
                c(new bg(this, faVar));
            }
        }
    }

    private void a(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, this, intent, i2) == null) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            ie ieVar = new ie();
            try {
                ip.a(ieVar, byteArrayExtra);
                com.xiaomi.push.ai.a(getApplicationContext()).a((ai.a) new com.xiaomi.push.service.b(ieVar, new WeakReference(this), booleanExtra), i2);
            } catch (iv unused) {
                com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
            }
        }
    }

    private void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65552, this, str, i2) == null) {
            Collection<av.b> m601a = av.a().m601a(str);
            if (m601a != null) {
                for (av.b bVar : m601a) {
                    if (bVar != null) {
                        a(new q(this, bVar, i2, null, null));
                    }
                }
            }
            av.a().m604a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, context)) == null) {
            try {
                com.xiaomi.push.ao.a();
                for (int i2 = 100; i2 > 0; i2--) {
                    if (com.xiaomi.push.bg.c(context)) {
                        com.xiaomi.channel.commonutils.logger.b.m70a("network connectivity ok.");
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
    private boolean m552a(String str, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, this, str, intent)) == null) {
            av.b a2 = av.a().a(str, intent.getStringExtra(az.p));
            boolean z = false;
            if (a2 == null || str == null) {
                return false;
            }
            String stringExtra = intent.getStringExtra(az.D);
            String stringExtra2 = intent.getStringExtra(az.w);
            if (!TextUtils.isEmpty(a2.f43596i) && !TextUtils.equals(stringExtra, a2.f43596i)) {
                com.xiaomi.channel.commonutils.logger.b.m70a("session changed. old session=" + a2.f43596i + ", new session=" + stringExtra + " chid = " + str);
                z = true;
            }
            if (stringExtra2.equals(a2.f43595h)) {
                return z;
            }
            com.xiaomi.channel.commonutils.logger.b.m70a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bl.a(stringExtra2));
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m553a() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            String a2 = aq.a(getApplicationContext()).a(hk.aN.a(), "");
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

    private void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, intent) == null) {
            String stringExtra = intent.getStringExtra(az.A);
            String stringExtra2 = intent.getStringExtra(az.D);
            Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
            int length = parcelableArrayExtra.length;
            gb[] gbVarArr = new gb[length];
            intent.getBooleanExtra("ext_encrypt", true);
            for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
                gbVarArr[i2] = new gb((Bundle) parcelableArrayExtra[i2]);
                gbVarArr[i2] = (gb) a(gbVarArr[i2], stringExtra, stringExtra2);
                if (gbVarArr[i2] == null) {
                    return;
                }
            }
            av a2 = av.a();
            fa[] faVarArr = new fa[length];
            for (int i3 = 0; i3 < length; i3++) {
                gb gbVar = gbVarArr[i3];
                faVarArr[i3] = fa.a(gbVar, a2.a(gbVar.k(), gbVar.m()).f43595h);
            }
            c(new com.xiaomi.push.service.c(this, faVarArr));
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, this, z) == null) {
            this.f839a = System.currentTimeMillis();
            if (m567c()) {
                if (com.xiaomi.push.bg.b(this)) {
                    c(new m(this, z));
                    return;
                }
                c(new f(this, 17, null));
            }
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            com.xiaomi.push.service.a a2 = com.xiaomi.push.service.a.a(getApplicationContext());
            String a3 = a2.a();
            com.xiaomi.channel.commonutils.logger.b.m70a("region of cache is " + a3);
            if (TextUtils.isEmpty(a3)) {
                a3 = a();
            }
            if (TextUtils.isEmpty(a3)) {
                this.f853a = com.xiaomi.push.o.f43518a.name();
            } else {
                this.f853a = a3;
                a2.a(a3);
                if (com.xiaomi.push.o.f43519b.name().equals(this.f853a)) {
                    str = "app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.o.f43520c.name().equals(this.f853a)) {
                    str = "fr.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.o.f43521d.name().equals(this.f853a)) {
                    str = "ru.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.o.f43522e.name().equals(this.f853a)) {
                    str = "idmb.app.chat.global.xiaomi.net";
                }
                fm.a(str);
            }
            if (com.xiaomi.push.o.f43518a.name().equals(this.f853a)) {
                fm.a("cn.app.chat.xiaomi.net");
            }
            if (m558h()) {
                ca caVar = new ca(this, 11);
                a(caVar);
                com.xiaomi.push.service.m.a(new cb(this, caVar));
            }
            try {
                if (com.xiaomi.push.t.m639a()) {
                    this.f850a.a(this);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Intent intent) {
        String str;
        com.xiaomi.push.service.e eVar;
        boolean z;
        int i2;
        String format;
        i nVar;
        String str2;
        String b2;
        String str3;
        bg bgVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, intent) == null) {
            av a2 = av.a();
            boolean z2 = true;
            int i3 = 0;
            if (az.f43611d.equalsIgnoreCase(intent.getAction()) || az.j.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(az.s);
                if (!TextUtils.isEmpty(intent.getStringExtra(az.w))) {
                    if (stringExtra == null) {
                        str = "channel id is empty, do nothing!";
                        com.xiaomi.channel.commonutils.logger.b.d(str);
                        return;
                    }
                    boolean m552a = m552a(stringExtra, intent);
                    av.b a3 = a(stringExtra, intent);
                    if (com.xiaomi.push.bg.b(this)) {
                        if (m567c()) {
                            av.c cVar = a3.f909a;
                            if (cVar == av.c.f43602a) {
                                nVar = new a(this, a3);
                            } else if (m552a) {
                                nVar = new n(this, a3);
                            } else if (cVar == av.c.f43603b) {
                                format = String.format("the client is binding. %1$s %2$s.", a3.f43594g, av.b.a(a3.f914b));
                            } else if (cVar != av.c.f43604c) {
                                return;
                            } else {
                                eVar = this.f850a;
                                z = true;
                                i2 = 0;
                            }
                            c(nVar);
                            return;
                        }
                        a(true);
                        return;
                    }
                    eVar = this.f850a;
                    z = false;
                    i2 = 2;
                    eVar.a(this, a3, z, i2, null);
                    return;
                }
                format = "security is empty. ignore.";
                com.xiaomi.channel.commonutils.logger.b.m70a(format);
            } else if (az.f43616i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra2 = intent.getStringExtra(az.A);
                String stringExtra3 = intent.getStringExtra(az.s);
                String stringExtra4 = intent.getStringExtra(az.p);
                com.xiaomi.channel.commonutils.logger.b.m70a("Service called close channel chid = " + stringExtra3 + " res = " + av.b.a(stringExtra4));
                if (TextUtils.isEmpty(stringExtra3)) {
                    for (String str4 : a2.m602a(stringExtra2)) {
                        a(str4, 2);
                    }
                } else if (TextUtils.isEmpty(stringExtra4)) {
                    a(stringExtra3, 2);
                } else {
                    a(stringExtra3, stringExtra4, 2, null, null);
                }
            } else if (az.f43612e.equalsIgnoreCase(intent.getAction())) {
                a(intent);
            } else if (az.f43614g.equalsIgnoreCase(intent.getAction())) {
                b(intent);
            } else {
                if (az.f43613f.equalsIgnoreCase(intent.getAction())) {
                    gc a4 = a(new ga(intent.getBundleExtra("ext_packet")), intent.getStringExtra(az.A), intent.getStringExtra(az.D));
                    if (a4 == null) {
                        return;
                    }
                    bgVar = new bg(this, fa.a(a4, a2.a(a4.k(), a4.m()).f43595h));
                } else if (!az.f43615h.equalsIgnoreCase(intent.getAction())) {
                    if (!az.k.equals(intent.getAction())) {
                        av.b bVar = null;
                        if (!az.l.equals(intent.getAction())) {
                            if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                                if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                    if (m559i()) {
                                        return;
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m70a("exit falldown mode, activate alarm.");
                                    e();
                                    if (m567c() || m568d()) {
                                        return;
                                    }
                                    a(true);
                                    return;
                                } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || !m559i() || !er.m296a()) {
                                    return;
                                } else {
                                    str2 = "enter falldown mode, stop alarm.";
                                }
                            } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                                if (bc.a(getApplicationContext()).m609a() && bc.a(getApplicationContext()).a() == 0) {
                                    str3 = "register without being provisioned. " + intent.getStringExtra("mipush_app_package");
                                } else {
                                    byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                                    String stringExtra5 = intent.getStringExtra("mipush_app_package");
                                    boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
                                    int intExtra = intent.getIntExtra("mipush_env_type", 1);
                                    com.xiaomi.push.service.n.a(this).d(stringExtra5);
                                    if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                                        a(byteArrayExtra, stringExtra5);
                                        return;
                                    }
                                    nVar = new cc(this, 14, intExtra, byteArrayExtra, stringExtra5);
                                }
                            } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                String stringExtra6 = intent.getStringExtra("mipush_app_package");
                                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                                boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                                    com.xiaomi.push.service.n.a(this).a(stringExtra6);
                                }
                                a(stringExtra6, byteArrayExtra2, booleanExtra2);
                                return;
                            } else if (!bd.f43620a.equals(intent.getAction())) {
                                if (bd.f43621b.equals(intent.getAction())) {
                                    String stringExtra7 = intent.getStringExtra("data_cleared_pkg_name");
                                    if (stringExtra7 == null || TextUtils.isEmpty(stringExtra7.trim())) {
                                        return;
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m70a("clear notifications of package " + stringExtra7);
                                    ac.m572a((Context) this, stringExtra7);
                                    ak.a((Context) this, stringExtra7);
                                    return;
                                } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                                    String stringExtra8 = intent.getStringExtra(az.A);
                                    int intExtra2 = intent.getIntExtra(az.B, -2);
                                    if (TextUtils.isEmpty(stringExtra8)) {
                                        return;
                                    }
                                    if (intExtra2 >= -1) {
                                        ac.a(this, stringExtra8, intExtra2);
                                        return;
                                    } else {
                                        ac.a(this, stringExtra8, intent.getStringExtra(az.F), intent.getStringExtra(az.G));
                                        return;
                                    }
                                } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                                    String stringExtra9 = intent.getStringExtra(az.A);
                                    String stringExtra10 = intent.getStringExtra(az.E);
                                    if (intent.hasExtra(az.C)) {
                                        int intExtra3 = intent.getIntExtra(az.C, 0);
                                        b2 = com.xiaomi.push.bl.b(stringExtra9 + intExtra3);
                                        i3 = intExtra3;
                                        z2 = false;
                                    } else {
                                        b2 = com.xiaomi.push.bl.b(stringExtra9);
                                    }
                                    if (!TextUtils.isEmpty(stringExtra9) && TextUtils.equals(stringExtra10, b2)) {
                                        if (z2) {
                                            ac.m577b((Context) this, stringExtra9);
                                            return;
                                        } else {
                                            ac.b(this, stringExtra9, i3);
                                            return;
                                        }
                                    }
                                    str = "invalid notification for " + stringExtra9;
                                    com.xiaomi.channel.commonutils.logger.b.d(str);
                                    return;
                                } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
                                    String stringExtra11 = intent.getStringExtra("mipush_app_package");
                                    if (!TextUtils.isEmpty(stringExtra11)) {
                                        com.xiaomi.push.service.n.a(this).b(stringExtra11);
                                    }
                                    if ("com.xiaomi.xmsf".equals(getPackageName())) {
                                        return;
                                    }
                                    a(19, (Exception) null);
                                    e();
                                    stopSelf();
                                    return;
                                } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                    String stringExtra12 = intent.getStringExtra("mipush_app_package");
                                    byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
                                    String stringExtra13 = intent.getStringExtra("mipush_app_id");
                                    String stringExtra14 = intent.getStringExtra("mipush_app_token");
                                    if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                        com.xiaomi.push.service.n.a(this).c(stringExtra12);
                                    }
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                                        com.xiaomi.push.service.n.a(this).e(stringExtra12);
                                        com.xiaomi.push.service.n.a(this).f(stringExtra12);
                                    }
                                    if (byteArrayExtra3 == null) {
                                        com.xiaomi.push.service.p.a(this, stringExtra12, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                                        return;
                                    }
                                    com.xiaomi.push.service.p.b(stringExtra12, byteArrayExtra3);
                                    a(new com.xiaomi.push.service.o(this, stringExtra12, stringExtra13, stringExtra14, byteArrayExtra3));
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f846a == null) {
                                        this.f846a = new e(this);
                                        registerReceiver(this.f846a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                                        return;
                                    }
                                    return;
                                } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                                    String stringExtra15 = intent.getStringExtra("mipush_app_package");
                                    byte[] byteArrayExtra4 = intent.getByteArrayExtra("mipush_payload");
                                    hj hjVar = new hj();
                                    try {
                                        ip.a(hjVar, byteArrayExtra4);
                                        hd.a(this).a(hjVar, stringExtra15);
                                        return;
                                    } catch (iv e2) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                                        return;
                                    }
                                } else {
                                    if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                                        com.xiaomi.channel.commonutils.logger.b.m70a("Service called on timer");
                                        if (!m559i()) {
                                            er.a(false);
                                            if (!m555e()) {
                                                return;
                                            }
                                        } else if (!er.m296a()) {
                                            return;
                                        } else {
                                            str2 = "enter falldown mode, stop alarm";
                                        }
                                    } else if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                                            com.xiaomi.channel.commonutils.logger.b.m70a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
                                            er.a(this, intent.getIntExtra("com.xiaomi.mipush.thirdparty_LEVEL", 0));
                                            return;
                                        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                                            d();
                                            return;
                                        } else if ("action_cr_config".equals(intent.getAction())) {
                                            boolean booleanExtra3 = intent.getBooleanExtra("action_cr_event_switch", false);
                                            long longExtra = intent.getLongExtra("action_cr_event_frequency", 86400L);
                                            boolean booleanExtra4 = intent.getBooleanExtra("action_cr_perf_switch", false);
                                            long longExtra2 = intent.getLongExtra("action_cr_perf_frequency", 86400L);
                                            boolean booleanExtra5 = intent.getBooleanExtra("action_cr_event_en", true);
                                            long longExtra3 = intent.getLongExtra("action_cr_max_file_size", 1048576L);
                                            Config build = Config.getBuilder().setEventUploadSwitchOpen(booleanExtra3).setEventUploadFrequency(longExtra).setPerfUploadSwitchOpen(booleanExtra4).setPerfUploadFrequency(longExtra2).setAESKey(com.xiaomi.push.bq.a(getApplicationContext())).setEventEncrypted(booleanExtra5).setMaxFileLength(longExtra3).build(getApplicationContext());
                                            if ("com.xiaomi.xmsf".equals(getPackageName()) || longExtra <= 0 || longExtra2 <= 0 || longExtra3 <= 0) {
                                                return;
                                            }
                                            ek.a(getApplicationContext(), build);
                                            return;
                                        } else if (!"action_help_ping".equals(intent.getAction())) {
                                            if ("action_aw_app_logic".equals(intent.getAction())) {
                                                d(intent);
                                                return;
                                            }
                                            return;
                                        } else {
                                            boolean booleanExtra6 = intent.getBooleanExtra("extra_help_ping_switch", false);
                                            int intExtra4 = intent.getIntExtra("extra_help_ping_frequency", 0);
                                            if (intExtra4 >= 0 && intExtra4 < 30) {
                                                com.xiaomi.channel.commonutils.logger.b.c("aw_ping: frquency need > 30s.");
                                                intExtra4 = 30;
                                            }
                                            boolean z3 = intExtra4 >= 0 ? booleanExtra6 : false;
                                            com.xiaomi.channel.commonutils.logger.b.m70a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                                            if (!z3 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                                return;
                                            }
                                            a(intent, intExtra4);
                                            return;
                                        }
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.b.m70a("Service called on check alive.");
                                        if (!m555e()) {
                                            return;
                                        }
                                    }
                                    b(false);
                                    return;
                                }
                            } else {
                                String stringExtra16 = intent.getStringExtra("uninstall_pkg_name");
                                if (stringExtra16 == null || TextUtils.isEmpty(stringExtra16.trim())) {
                                    return;
                                }
                                try {
                                    getPackageManager().getPackageInfo(stringExtra16, 0);
                                    z2 = false;
                                } catch (PackageManager.NameNotFoundException unused) {
                                }
                                if (!"com.xiaomi.channel".equals(stringExtra16) || av.a().m601a("1").isEmpty() || !z2) {
                                    SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                    String string = sharedPreferences.getString(stringExtra16, null);
                                    if (TextUtils.isEmpty(string) || !z2) {
                                        return;
                                    }
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.remove(stringExtra16);
                                    edit.commit();
                                    if (ac.m578b((Context) this, stringExtra16)) {
                                        ac.m577b((Context) this, stringExtra16);
                                    }
                                    ac.m572a((Context) this, stringExtra16);
                                    if (!m567c() || string == null) {
                                        return;
                                    }
                                    try {
                                        y.a(this, y.a(stringExtra16, string));
                                        com.xiaomi.channel.commonutils.logger.b.m70a("uninstall " + stringExtra16 + " msg sent");
                                        return;
                                    } catch (fw e3) {
                                        com.xiaomi.channel.commonutils.logger.b.d("Fail to send Message: " + e3.getMessage());
                                        a(10, e3);
                                        return;
                                    }
                                }
                                a("1", 0);
                                str3 = "close the miliao channel as the app is uninstalled.";
                            }
                            com.xiaomi.channel.commonutils.logger.b.m70a(str2);
                            er.a();
                            return;
                        }
                        String stringExtra17 = intent.getStringExtra(az.A);
                        List<String> m602a = a2.m602a(stringExtra17);
                        if (!m602a.isEmpty()) {
                            String stringExtra18 = intent.getStringExtra(az.s);
                            String stringExtra19 = intent.getStringExtra(az.p);
                            if (TextUtils.isEmpty(stringExtra18)) {
                                stringExtra18 = m602a.get(0);
                            }
                            if (TextUtils.isEmpty(stringExtra19)) {
                                Collection<av.b> m601a = a2.m601a(stringExtra18);
                                if (m601a != null && !m601a.isEmpty()) {
                                    bVar = m601a.iterator().next();
                                }
                            } else {
                                bVar = a2.a(stringExtra18, stringExtra19);
                            }
                            if (bVar != null) {
                                if (intent.hasExtra(az.y)) {
                                    bVar.f43592e = intent.getStringExtra(az.y);
                                }
                                if (intent.hasExtra(az.z)) {
                                    bVar.f43593f = intent.getStringExtra(az.z);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str3 = "open channel should be called first before update info, pkg=" + stringExtra17;
                        com.xiaomi.channel.commonutils.logger.b.m70a(str3);
                        return;
                    }
                    String stringExtra20 = intent.getStringExtra(az.s);
                    String stringExtra21 = intent.getStringExtra(az.p);
                    if (stringExtra20 == null) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m70a("request reset connection from chid = " + stringExtra20);
                    av.b a5 = av.a().a(stringExtra20, stringExtra21);
                    if (a5 == null || !a5.f43595h.equals(intent.getStringExtra(az.w)) || a5.f909a != av.c.f43604c) {
                        return;
                    }
                    fl m560a = m560a();
                    if (m560a != null && m560a.a(System.currentTimeMillis() - 15000)) {
                        return;
                    }
                    nVar = new o(this);
                    c(nVar);
                    return;
                } else {
                    gc a6 = a(new ge(intent.getBundleExtra("ext_packet")), intent.getStringExtra(az.A), intent.getStringExtra(az.D));
                    if (a6 == null) {
                        return;
                    }
                    bgVar = new bg(this, fa.a(a6, a2.a(a6.k(), a6.m()).f43595h));
                }
                c(bgVar);
            }
        }
    }

    private void c(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, iVar) == null) {
            this.f851a.a(iVar);
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, this, z) == null) {
            try {
                if (com.xiaomi.push.t.m639a()) {
                    if (!z) {
                        sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                        return;
                    }
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                    for (ai aiVar : (ai[]) this.f855a.toArray(new ai[0])) {
                        aiVar.mo619a();
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
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            try {
                networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                networkInfo = null;
            }
            if (networkInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("network changed,");
                sb.append(PreferencesUtil.LEFT_MOUNT + "type: " + networkInfo.getTypeName() + PreferencesUtil.LEFT_MOUNT + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
                com.xiaomi.channel.commonutils.logger.b.m70a(sb.toString());
                NetworkInfo.State state = networkInfo.getState();
                if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                    return;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m70a("network changed, no active network");
            }
            if (gx.a() != null) {
                gx.a().m362a();
            }
            gq.m359a((Context) this);
            this.f842a.d();
            if (com.xiaomi.push.bg.b(this)) {
                if (m567c() && m555e()) {
                    b(false);
                }
                if (!m567c() && !m568d()) {
                    this.f851a.a(1);
                    a(new d(this));
                }
                db.a(this).a();
            } else {
                a(new f(this, 2, null));
            }
            e();
        }
    }

    private void d(Intent intent) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, this, intent) == null) {
            try {
                ea.a(getApplicationContext()).a(new bb());
                String stringExtra = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra == null) {
                    return;
                }
                ie ieVar = new ie();
                ip.a(ieVar, byteArrayExtra);
                String b2 = ieVar.b();
                Map<String, String> m466a = ieVar.m466a();
                if (m466a != null) {
                    String str = m466a.get("extra_help_aw_info");
                    String str2 = m466a.get("extra_aw_app_online_cmd");
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
                    ea.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
                }
            } catch (iv e2) {
                com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            if (!m563a()) {
                er.a();
            } else if (er.m296a()) {
            } else {
                er.a(true);
            }
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m555e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            if (System.currentTimeMillis() - this.f839a < 30000) {
                return false;
            }
            return com.xiaomi.push.bg.d(this);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            fl flVar = this.f843a;
            if (flVar == null || !flVar.m326b()) {
                fl flVar2 = this.f843a;
                if (flVar2 == null || !flVar2.m327c()) {
                    this.f844a.b(com.xiaomi.push.bg.m172a((Context) this));
                    g();
                    if (this.f843a == null) {
                        av.a().a(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f  reason: collision with other method in class */
    public boolean m556f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1 : invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            try {
                this.f842a.a(this.f845a, new bu(this));
                this.f842a.e();
                this.f843a = this.f842a;
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
                this.f842a.b(3, e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m557g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1 : invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
        }
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m558h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.n.a(this).m634b(getPackageName()) : invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            synchronized (this.f854a) {
                this.f854a.clear();
            }
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m559i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) ? getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m440b((Context) this) && !com.xiaomi.push.i.m437a(getApplicationContext()) : invokeV.booleanValue;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) {
            int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
            int i2 = this.f43534a;
            int i3 = this.f43535b;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) {
            if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
                return false;
            }
            return aq.a(this).a(hk.H.a(), false);
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public fl m560a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f843a : (fl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.e m561a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.xiaomi.push.service.e() : (com.xiaomi.push.service.e) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m562a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && System.currentTimeMillis() - this.f839a >= fr.a() && com.xiaomi.push.bg.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f851a.a(i2);
        }
    }

    public void a(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, exc) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("disconnect ");
            sb.append(hashCode());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            fl flVar = this.f843a;
            sb.append(flVar == null ? null : Integer.valueOf(flVar.hashCode()));
            com.xiaomi.channel.commonutils.logger.b.m70a(sb.toString());
            fl flVar2 = this.f843a;
            if (flVar2 != null) {
                flVar2.b(i2, exc);
                this.f843a = null;
            }
            a(7);
            a(4);
            av.a().a(this, i2);
        }
    }

    public void a(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, faVar) == null) {
            fl flVar = this.f843a;
            if (flVar == null) {
                throw new fw("try send msg while connection is null.");
            }
            flVar.b(faVar);
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, flVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
            gx.a().a(flVar);
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, flVar, i2, exc) == null) {
            gx.a().a(flVar, i2, exc);
            if (m559i()) {
                return;
            }
            a(false);
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(fl flVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, flVar, exc) == null) {
            gx.a().a(flVar, exc);
            c(false);
            if (m559i()) {
                return;
            }
            a(false);
        }
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
            a(iVar, 0L);
        }
    }

    public void a(i iVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, iVar, j2) == null) {
            try {
                this.f851a.a(iVar, j2);
            } catch (IllegalStateException e2) {
                com.xiaomi.channel.commonutils.logger.b.m70a("can't execute job err = " + e2.getMessage());
            }
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lVar) == null) {
            synchronized (this.f854a) {
                this.f854a.add(lVar);
            }
        }
    }

    public void a(av.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        long a2 = bVar.a();
        com.xiaomi.channel.commonutils.logger.b.m70a("schedule rebind job in " + (a2 / 1000));
        a(new a(this, bVar), a2);
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4}) == null) {
            av.b a2 = av.a().a(str, str2);
            if (a2 != null) {
                a(new q(this, a2, i2, str4, str3));
            }
            av.a().m605a(str, str2);
        }
    }

    public void a(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, str, bArr, z) == null) {
            Collection<av.b> m601a = av.a().m601a("5");
            if (m601a.isEmpty()) {
                if (!z) {
                    return;
                }
            } else if (m601a.iterator().next().f909a == av.c.f43604c) {
                a(new bs(this, 4, str, bArr));
                return;
            } else if (!z) {
                return;
            }
            com.xiaomi.push.service.p.b(str, bArr);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f849a.a(z);
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bArr, str) == null) {
            if (bArr == null) {
                com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                com.xiaomi.channel.commonutils.logger.b.m70a("register request without payload");
                return;
            }
            ib ibVar = new ib();
            try {
                ip.a(ibVar, bArr);
                if (ibVar.f631a == hf.f43236a) {
                    Cif cif = new Cif();
                    try {
                        ip.a(cif, ibVar.m456a());
                        com.xiaomi.push.service.p.a(ibVar.b(), bArr);
                        a(new com.xiaomi.push.service.o(this, ibVar.b(), cif.b(), cif.c(), bArr));
                        el.a(getApplicationContext()).a(ibVar.b(), "E100003", cif.a(), 6002, null);
                    } catch (iv e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                        com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                    }
                } else {
                    com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                    com.xiaomi.channel.commonutils.logger.b.m70a("register request with invalid payload");
                }
            } catch (iv e3) {
                com.xiaomi.channel.commonutils.logger.b.d("app register fail. " + e3);
                com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
            }
        }
    }

    public void a(fa[] faVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, faVarArr) == null) {
            fl flVar = this.f843a;
            if (flVar == null) {
                throw new fw("try send msg while connection is null.");
            }
            flVar.a(faVarArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m563a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            boolean b2 = com.xiaomi.push.bg.b(this);
            boolean z = av.a().m599a() > 0;
            boolean z2 = !m566b();
            boolean m558h = m558h();
            boolean z3 = !m557g();
            boolean z4 = !m556f();
            boolean z5 = b2 && z && z2 && m558h && z3 && z4;
            if (!z5) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;!eps=%s", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m558h), Boolean.valueOf(z3), Boolean.valueOf(z4)));
            }
            return z5;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m564a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.f851a.m622a(i2) : invokeI.booleanValue;
    }

    public com.xiaomi.push.service.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f850a : (com.xiaomi.push.service.e) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m565b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Iterator it = new ArrayList(this.f854a).iterator();
            while (it.hasNext()) {
                ((l) it.next()).mo370a();
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, flVar) == null) {
            gx.a().b(flVar);
            c(true);
            this.f849a.m611a();
            if (!er.m296a() && !m559i()) {
                com.xiaomi.channel.commonutils.logger.b.m70a("reconnection successful, reactivate alarm.");
                er.a(true);
            }
            Iterator<av.b> it = av.a().m600a().iterator();
            while (it.hasNext()) {
                a(new a(this, it.next()));
            }
        }
    }

    public void b(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.f851a.a(iVar.f43661a, iVar);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m566b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            try {
                Class<?> a2 = com.xiaomi.push.t.a(this, "miui.os.Build");
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
    public boolean m567c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            fl flVar = this.f843a;
            return flVar != null && flVar.m327c();
        }
        return invokeV.booleanValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m568d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            fl flVar = this.f843a;
            return flVar != null && flVar.m326b();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, intent)) == null) ? this.f841a.getBinder() : (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onCreate();
            com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
            com.xiaomi.push.t.m638a((Context) this);
            com.xiaomi.push.service.l a2 = com.xiaomi.push.service.m.a((Context) this);
            if (a2 != null) {
                com.xiaomi.push.ab.a(a2.f43673a);
            }
            this.f841a = new Messenger(new bv(this));
            ba.a(this);
            bw bwVar = new bw(this, null, 5222, "xiaomi.com", null);
            this.f844a = bwVar;
            bwVar.a(true);
            this.f842a = new fh(this, this.f844a);
            this.f850a = m561a();
            er.a(this);
            this.f842a.a(this);
            this.f848a = new au(this);
            this.f849a = new bf(this);
            new com.xiaomi.push.service.f().a();
            gx.m363a().a(this);
            this.f851a = new com.xiaomi.push.service.h("Connection Controller Thread");
            av a3 = av.a();
            a3.b();
            a3.a(new bx(this));
            if (k()) {
                h();
            }
            hd.a(this).a(new com.xiaomi.push.service.j(this), "UPLOADER_PUSH_CHANNEL");
            a(new ha(this));
            a(new g(this));
            this.f855a.add(bk.a(this));
            if (m558h()) {
                this.f846a = new e(this);
                registerReceiver(this.f846a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
                if (uriFor != null) {
                    this.f840a = new by(this, new Handler(Looper.getMainLooper()));
                    try {
                        getContentResolver().registerContentObserver(uriFor, false, this.f840a);
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m70a("register observer err:" + th.getMessage());
                    }
                }
                Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
                if (uriFor2 != null) {
                    this.f856b = new bz(this, new Handler(Looper.getMainLooper()));
                    try {
                        getContentResolver().registerContentObserver(uriFor2, false, this.f856b);
                    } catch (Throwable th2) {
                        com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                    }
                }
                int[] m553a = m553a();
                if (m553a != null) {
                    this.f847a = new p(this);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    registerReceiver(this.f847a, intentFilter);
                    this.f43534a = m553a[0];
                    this.f43535b = m553a[1];
                    com.xiaomi.channel.commonutils.logger.b.m70a("falldown initialized: " + this.f43534a + "," + this.f43535b);
                }
            }
            String str = "";
            if (a2 != null) {
                try {
                    if (!TextUtils.isEmpty(a2.f962a) && (split = a2.f962a.split(TNCManager.TNC_PROBE_HEADER_SECEPTOR)) != null && split.length > 0) {
                        str = split[0];
                    }
                } catch (Exception unused) {
                }
            }
            com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", uuid=" + str);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            e eVar = this.f846a;
            if (eVar != null) {
                a(eVar);
                this.f846a = null;
            }
            p pVar = this.f847a;
            if (pVar != null) {
                a(pVar);
                this.f847a = null;
            }
            if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f840a != null) {
                try {
                    getContentResolver().unregisterContentObserver(this.f840a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m70a("unregister observer err:" + th.getMessage());
                }
            }
            if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f856b != null) {
                try {
                    getContentResolver().unregisterContentObserver(this.f856b);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
                }
            }
            this.f855a.clear();
            this.f851a.m623b();
            a(new bt(this, 2));
            a(new j(this));
            av.a().b();
            av.a().a(this, 15);
            av.a().m603a();
            this.f842a.b(this);
            bi.a().m617a();
            er.a();
            i();
            super.onDestroy();
            com.xiaomi.channel.commonutils.logger.b.m70a("Service destroyed");
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048606, this, intent, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (intent == null) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
            } else {
                com.xiaomi.channel.commonutils.logger.b.m70a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(az.s), intent.getStringExtra(az.A), intent.getStringExtra("mipush_app_package")));
            }
            if (intent != null && intent.getAction() != null) {
                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                    if (this.f851a.m621a()) {
                        com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                        av.a().a(this, 14);
                        stopSelf();
                    } else {
                        hVar = new h(this, intent);
                        a(hVar);
                    }
                } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                    hVar = new h(this, intent);
                    a(hVar);
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
