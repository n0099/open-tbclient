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
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
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
/* loaded from: classes4.dex */
public class XMPushService extends Service implements fo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f844a;

    /* renamed from: a  reason: collision with other field name */
    public ContentObserver f845a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f846a;

    /* renamed from: a  reason: collision with other field name */
    public fh f847a;

    /* renamed from: a  reason: collision with other field name */
    public fl f848a;

    /* renamed from: a  reason: collision with other field name */
    public fm f849a;

    /* renamed from: a  reason: collision with other field name */
    public fq f850a;

    /* renamed from: a  reason: collision with other field name */
    public e f851a;

    /* renamed from: a  reason: collision with other field name */
    public p f852a;

    /* renamed from: a  reason: collision with other field name */
    public au f853a;

    /* renamed from: a  reason: collision with other field name */
    public bf f854a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.e f855a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.push.service.h f856a;

    /* renamed from: a  reason: collision with other field name */
    public Class f857a;

    /* renamed from: a  reason: collision with other field name */
    public String f858a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<l> f859a;

    /* renamed from: a  reason: collision with other field name */
    public Collection<ai> f860a;

    /* renamed from: b  reason: collision with root package name */
    public int f61406b;

    /* renamed from: b  reason: collision with other field name */
    public ContentObserver f861b;

    /* loaded from: classes4.dex */
    public class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public av.b f862a;

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
            this.a = xMPushService;
            this.f862a = null;
            this.f862a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "bind the client. " + this.f862a.f61423g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (!this.a.m631c()) {
                        com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                        return;
                    }
                    av.b a = av.a().a(this.f862a.f61423g, this.f862a.f919b);
                    if (a == null) {
                        str = "ignore bind because the channel " + this.f862a.f61423g + " is removed ";
                    } else if (a.f914a == av.c.a) {
                        a.a(av.c.f61429b, 0, 0, (String) null, (String) null);
                        this.a.f848a.a(a);
                        gz.a(this.a, a);
                        return;
                    } else {
                        str = "trying duplicate bind, ingore! " + a.f914a;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m134a(str);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    this.a.a(10, e2);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final av.b a;

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
            this.a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "bind time out. chid=" + this.a.f61423g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a(av.c.a, 1, 21, (String) null, (String) null);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof b) {
                    return TextUtils.equals(((b) obj).a.f61423g, this.a.f61423g);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.f61423g.hashCode() : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public fa a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f863a;

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
            this.f863a = xMPushService;
            this.a = null;
            this.a = faVar;
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
                this.f863a.f853a.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

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
            this.a = xMPushService;
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
                if (this.a.m627a()) {
                    XMPushService xMPushService = this.a;
                    if (xMPushService.a(xMPushService.getApplicationContext())) {
                        this.a.f();
                        return;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m134a("should not connect. quit the job.");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

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

    /* loaded from: classes4.dex */
    public class f extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public Exception f864a;

        /* renamed from: b  reason: collision with root package name */
        public int f61407b;

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
            this.a = xMPushService;
            this.f61407b = i2;
            this.f864a = exc;
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
                this.a.a(this.f61407b, this.f864a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

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
            this.a = xMPushService;
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
                this.a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Intent a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f865a;

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
            this.f865a = xMPushService;
            this.a = null;
            this.a = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "Handle intent action = " + this.a.getAction();
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f865a.c(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public abstract void m633a();

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.a;
                if (i2 != 4 && i2 != 8) {
                    com.xiaomi.channel.commonutils.logger.b.m135a(com.xiaomi.channel.commonutils.logger.a.a, a());
                }
                m633a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

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
            this.a = xMPushService;
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
                this.a.f856a.m684a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gc a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ XMPushService f866a;

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
            this.f866a = xMPushService;
            this.a = null;
            this.a = gcVar;
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
                this.f866a.f853a.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface l {
        /* renamed from: a */
        void mo434a();
    }

    /* loaded from: classes4.dex */
    public class m extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f867a;

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
            this.a = xMPushService;
            this.f867a = z;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.m631c()) {
                try {
                    if (!this.f867a) {
                        gz.a();
                    }
                    this.a.f848a.b(this.f867a);
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    this.a.a(10, e2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public av.b f868a;

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
            this.a = xMPushService;
            this.f868a = null;
            this.f868a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "rebind the client. " + this.f868a.f61423g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.f868a.a(av.c.a, 1, 16, (String) null, (String) null);
                    this.a.f848a.a(this.f868a.f61423g, this.f868a.f919b);
                    this.f868a.a(av.c.f61429b, 1, 16, (String) null, (String) null);
                    this.a.f848a.a(this.f868a);
                } catch (fw e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    this.a.a(10, e2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

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
            this.a = xMPushService;
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
                this.a.a(11, (Exception) null);
                if (this.a.m627a()) {
                    XMPushService xMPushService = this.a;
                    if (xMPushService.a(xMPushService.getApplicationContext())) {
                        this.a.f();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

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

    /* loaded from: classes4.dex */
    public class q extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XMPushService a;

        /* renamed from: a  reason: collision with other field name */
        public av.b f869a;

        /* renamed from: a  reason: collision with other field name */
        public String f870a;

        /* renamed from: b  reason: collision with root package name */
        public int f61408b;

        /* renamed from: b  reason: collision with other field name */
        public String f871b;

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
            this.a = xMPushService;
            this.f869a = null;
            this.f869a = bVar;
            this.f61408b = i2;
            this.f870a = str;
            this.f871b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "unbind the channel. " + this.f869a.f61423g;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.xiaomi.push.service.XMPushService.i
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f869a.f914a != av.c.a && this.a.f848a != null) {
                    try {
                        this.a.f848a.a(this.f869a.f61423g, this.f869a.f919b);
                    } catch (fw e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                        this.a.a(10, e2);
                    }
                }
                this.f869a.a(av.c.a, this.f61408b, 0, this.f871b, this.f870a);
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
        this.a = 0;
        this.f61406b = 0;
        this.f844a = 0L;
        this.f857a = XMJobService.class;
        this.f853a = null;
        this.f856a = null;
        this.f846a = null;
        this.f860a = Collections.synchronizedCollection(new ArrayList());
        this.f859a = new ArrayList<>();
        this.f850a = new br(this);
    }

    private gc a(gc gcVar, String str, String str2) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, gcVar, str, str2)) == null) {
            av a2 = av.a();
            List<String> m666a = a2.m666a(str);
            if (m666a.isEmpty()) {
                sb = new StringBuilder();
                str3 = "open channel should be called first before sending a packet, pkg=";
            } else {
                gcVar.o(str);
                str = gcVar.k();
                if (TextUtils.isEmpty(str)) {
                    str = m666a.get(0);
                    gcVar.l(str);
                }
                av.b a3 = a2.a(str, gcVar.m());
                if (!m631c()) {
                    sb = new StringBuilder();
                    str3 = "drop a packet as the channel is not connected, chid=";
                } else if (a3 != null && a3.f914a == av.c.f61430c) {
                    if (TextUtils.equals(str2, a3.f61425i)) {
                        return gcVar;
                    }
                    sb = new StringBuilder();
                    sb.append("invalid session. ");
                    sb.append(str2);
                    com.xiaomi.channel.commonutils.logger.b.m134a(sb.toString());
                    return null;
                } else {
                    sb = new StringBuilder();
                    str3 = "drop a packet as the channel is not opened, chid=";
                }
            }
            sb.append(str3);
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.m134a(sb.toString());
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
            a2.f61423g = intent.getStringExtra(az.s);
            a2.f919b = intent.getStringExtra(az.p);
            a2.f61419c = intent.getStringExtra(az.u);
            a2.f916a = intent.getStringExtra(az.A);
            a2.f61421e = intent.getStringExtra(az.y);
            a2.f61422f = intent.getStringExtra(az.z);
            a2.f918a = intent.getBooleanExtra(az.x, false);
            a2.f61424h = intent.getStringExtra(az.w);
            a2.f61425i = intent.getStringExtra(az.D);
            a2.f61420d = intent.getStringExtra(az.v);
            a2.f915a = this.f855a;
            a2.a((Messenger) intent.getParcelableExtra(az.H));
            a2.f908a = getApplicationContext();
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
                        b2 = com.xiaomi.push.l.m597a("ro.miui.region");
                        if (TextUtils.isEmpty(b2)) {
                            b2 = com.xiaomi.push.l.m597a("ro.product.locale.region");
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
            com.xiaomi.channel.commonutils.logger.b.m134a("wait region :" + str + " cost = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
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
                faVar = fa.a(gbVar, a2.a(gbVar.k(), gbVar.m()).f61424h);
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
                        faVar2.a(byteArrayExtra, a3.f61424h);
                        com.xiaomi.channel.commonutils.logger.b.m134a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
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
            Collection<av.b> m665a = av.a().m665a(str);
            if (m665a != null) {
                for (av.b bVar : m665a) {
                    if (bVar != null) {
                        a(new q(this, bVar, i2, null, null));
                    }
                }
            }
            av.a().m668a(str);
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
                        com.xiaomi.channel.commonutils.logger.b.m134a("network connectivity ok.");
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
    private boolean m616a(String str, Intent intent) {
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
            if (!TextUtils.isEmpty(a2.f61425i) && !TextUtils.equals(stringExtra, a2.f61425i)) {
                com.xiaomi.channel.commonutils.logger.b.m134a("session changed. old session=" + a2.f61425i + ", new session=" + stringExtra + " chid = " + str);
                z = true;
            }
            if (stringExtra2.equals(a2.f61424h)) {
                return z;
            }
            com.xiaomi.channel.commonutils.logger.b.m134a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bl.a(stringExtra2));
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m617a() {
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
                faVarArr[i3] = fa.a(gbVar, a2.a(gbVar.k(), gbVar.m()).f61424h);
            }
            c(new com.xiaomi.push.service.c(this, faVarArr));
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, this, z) == null) {
            this.f844a = System.currentTimeMillis();
            if (m631c()) {
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
            com.xiaomi.channel.commonutils.logger.b.m134a("region of cache is " + a3);
            if (TextUtils.isEmpty(a3)) {
                a3 = a();
            }
            if (TextUtils.isEmpty(a3)) {
                this.f858a = com.xiaomi.push.o.a.name();
            } else {
                this.f858a = a3;
                a2.a(a3);
                if (com.xiaomi.push.o.f61399b.name().equals(this.f858a)) {
                    str = "app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.o.f61400c.name().equals(this.f858a)) {
                    str = "fr.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.o.f61401d.name().equals(this.f858a)) {
                    str = "ru.app.chat.global.xiaomi.net";
                } else if (com.xiaomi.push.o.f61402e.name().equals(this.f858a)) {
                    str = "idmb.app.chat.global.xiaomi.net";
                }
                fm.a(str);
            }
            if (com.xiaomi.push.o.a.name().equals(this.f858a)) {
                fm.a("cn.app.chat.xiaomi.net");
            }
            if (m622h()) {
                ca caVar = new ca(this, 11);
                a(caVar);
                com.xiaomi.push.service.m.a(new cb(this, caVar));
            }
            try {
                if (com.xiaomi.push.t.m703a()) {
                    this.f855a.a(this);
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
            if (az.f61433d.equalsIgnoreCase(intent.getAction()) || az.f61439j.equalsIgnoreCase(intent.getAction())) {
                String stringExtra = intent.getStringExtra(az.s);
                if (!TextUtils.isEmpty(intent.getStringExtra(az.w))) {
                    if (stringExtra == null) {
                        str = "channel id is empty, do nothing!";
                        com.xiaomi.channel.commonutils.logger.b.d(str);
                        return;
                    }
                    boolean m616a = m616a(stringExtra, intent);
                    av.b a3 = a(stringExtra, intent);
                    if (com.xiaomi.push.bg.b(this)) {
                        if (m631c()) {
                            av.c cVar = a3.f914a;
                            if (cVar == av.c.a) {
                                nVar = new a(this, a3);
                            } else if (m616a) {
                                nVar = new n(this, a3);
                            } else if (cVar == av.c.f61429b) {
                                format = String.format("the client is binding. %1$s %2$s.", a3.f61423g, av.b.a(a3.f919b));
                            } else if (cVar != av.c.f61430c) {
                                return;
                            } else {
                                eVar = this.f855a;
                                z = true;
                                i2 = 0;
                            }
                            c(nVar);
                            return;
                        }
                        a(true);
                        return;
                    }
                    eVar = this.f855a;
                    z = false;
                    i2 = 2;
                    eVar.a(this, a3, z, i2, null);
                    return;
                }
                format = "security is empty. ignore.";
                com.xiaomi.channel.commonutils.logger.b.m134a(format);
            } else if (az.f61438i.equalsIgnoreCase(intent.getAction())) {
                String stringExtra2 = intent.getStringExtra(az.A);
                String stringExtra3 = intent.getStringExtra(az.s);
                String stringExtra4 = intent.getStringExtra(az.p);
                com.xiaomi.channel.commonutils.logger.b.m134a("Service called close channel chid = " + stringExtra3 + " res = " + av.b.a(stringExtra4));
                if (TextUtils.isEmpty(stringExtra3)) {
                    for (String str4 : a2.m666a(stringExtra2)) {
                        a(str4, 2);
                    }
                } else if (TextUtils.isEmpty(stringExtra4)) {
                    a(stringExtra3, 2);
                } else {
                    a(stringExtra3, stringExtra4, 2, null, null);
                }
            } else if (az.f61434e.equalsIgnoreCase(intent.getAction())) {
                a(intent);
            } else if (az.f61436g.equalsIgnoreCase(intent.getAction())) {
                b(intent);
            } else {
                if (az.f61435f.equalsIgnoreCase(intent.getAction())) {
                    gc a4 = a(new ga(intent.getBundleExtra("ext_packet")), intent.getStringExtra(az.A), intent.getStringExtra(az.D));
                    if (a4 == null) {
                        return;
                    }
                    bgVar = new bg(this, fa.a(a4, a2.a(a4.k(), a4.m()).f61424h));
                } else if (!az.f61437h.equalsIgnoreCase(intent.getAction())) {
                    if (!az.k.equals(intent.getAction())) {
                        av.b bVar = null;
                        if (!az.l.equals(intent.getAction())) {
                            if ("android.intent.action.SCREEN_ON".equals(intent.getAction()) || "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                                if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                                    if (m623i()) {
                                        return;
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m134a("exit falldown mode, activate alarm.");
                                    e();
                                    if (m631c() || m632d()) {
                                        return;
                                    }
                                    a(true);
                                    return;
                                } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || !m623i() || !er.m360a()) {
                                    return;
                                } else {
                                    str2 = "enter falldown mode, stop alarm.";
                                }
                            } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                                if (bc.a(getApplicationContext()).m673a() && bc.a(getApplicationContext()).a() == 0) {
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
                            } else if (!bd.a.equals(intent.getAction())) {
                                if (bd.f61440b.equals(intent.getAction())) {
                                    String stringExtra7 = intent.getStringExtra("data_cleared_pkg_name");
                                    if (stringExtra7 == null || TextUtils.isEmpty(stringExtra7.trim())) {
                                        return;
                                    }
                                    com.xiaomi.channel.commonutils.logger.b.m134a("clear notifications of package " + stringExtra7);
                                    ac.m636a((Context) this, stringExtra7);
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
                                            ac.m641b((Context) this, stringExtra9);
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
                                    if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) && this.f851a == null) {
                                        this.f851a = new e(this);
                                        registerReceiver(this.f851a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
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
                                        com.xiaomi.channel.commonutils.logger.b.m134a("Service called on timer");
                                        if (!m623i()) {
                                            er.a(false);
                                            if (!m619e()) {
                                                return;
                                            }
                                        } else if (!er.m360a()) {
                                            return;
                                        } else {
                                            str2 = "enter falldown mode, stop alarm";
                                        }
                                    } else if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                                        if ("com.xiaomi.mipush.thirdparty".equals(intent.getAction())) {
                                            com.xiaomi.channel.commonutils.logger.b.m134a("on thirdpart push :" + intent.getStringExtra("com.xiaomi.mipush.thirdparty_DESC"));
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
                                            com.xiaomi.channel.commonutils.logger.b.m134a("aw_ping: receive a aw_ping message. switch: " + z3 + " frequency: " + intExtra4);
                                            if (!z3 || intExtra4 <= 0 || "com.xiaomi.xmsf".equals(getPackageName())) {
                                                return;
                                            }
                                            a(intent, intExtra4);
                                            return;
                                        }
                                    } else {
                                        com.xiaomi.channel.commonutils.logger.b.m134a("Service called on check alive.");
                                        if (!m619e()) {
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
                                if (!"com.xiaomi.channel".equals(stringExtra16) || av.a().m665a("1").isEmpty() || !z2) {
                                    SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                                    String string = sharedPreferences.getString(stringExtra16, null);
                                    if (TextUtils.isEmpty(string) || !z2) {
                                        return;
                                    }
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.remove(stringExtra16);
                                    edit.commit();
                                    if (ac.m642b((Context) this, stringExtra16)) {
                                        ac.m641b((Context) this, stringExtra16);
                                    }
                                    ac.m636a((Context) this, stringExtra16);
                                    if (!m631c() || string == null) {
                                        return;
                                    }
                                    try {
                                        y.a(this, y.a(stringExtra16, string));
                                        com.xiaomi.channel.commonutils.logger.b.m134a("uninstall " + stringExtra16 + " msg sent");
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
                            com.xiaomi.channel.commonutils.logger.b.m134a(str2);
                            er.a();
                            return;
                        }
                        String stringExtra17 = intent.getStringExtra(az.A);
                        List<String> m666a = a2.m666a(stringExtra17);
                        if (!m666a.isEmpty()) {
                            String stringExtra18 = intent.getStringExtra(az.s);
                            String stringExtra19 = intent.getStringExtra(az.p);
                            if (TextUtils.isEmpty(stringExtra18)) {
                                stringExtra18 = m666a.get(0);
                            }
                            if (TextUtils.isEmpty(stringExtra19)) {
                                Collection<av.b> m665a = a2.m665a(stringExtra18);
                                if (m665a != null && !m665a.isEmpty()) {
                                    bVar = m665a.iterator().next();
                                }
                            } else {
                                bVar = a2.a(stringExtra18, stringExtra19);
                            }
                            if (bVar != null) {
                                if (intent.hasExtra(az.y)) {
                                    bVar.f61421e = intent.getStringExtra(az.y);
                                }
                                if (intent.hasExtra(az.z)) {
                                    bVar.f61422f = intent.getStringExtra(az.z);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        str3 = "open channel should be called first before update info, pkg=" + stringExtra17;
                        com.xiaomi.channel.commonutils.logger.b.m134a(str3);
                        return;
                    }
                    String stringExtra20 = intent.getStringExtra(az.s);
                    String stringExtra21 = intent.getStringExtra(az.p);
                    if (stringExtra20 == null) {
                        return;
                    }
                    com.xiaomi.channel.commonutils.logger.b.m134a("request reset connection from chid = " + stringExtra20);
                    av.b a5 = av.a().a(stringExtra20, stringExtra21);
                    if (a5 == null || !a5.f61424h.equals(intent.getStringExtra(az.w)) || a5.f914a != av.c.f61430c) {
                        return;
                    }
                    fl m624a = m624a();
                    if (m624a != null && m624a.a(System.currentTimeMillis() - 15000)) {
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
                    bgVar = new bg(this, fa.a(a6, a2.a(a6.k(), a6.m()).f61424h));
                }
                c(bgVar);
            }
        }
    }

    private void c(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, this, iVar) == null) {
            this.f856a.a(iVar);
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, this, z) == null) {
            try {
                if (com.xiaomi.push.t.m703a()) {
                    if (!z) {
                        sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                        return;
                    }
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                    for (ai aiVar : (ai[]) this.f860a.toArray(new ai[0])) {
                        aiVar.mo683a();
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
                com.xiaomi.channel.commonutils.logger.b.m134a(sb.toString());
                NetworkInfo.State state = networkInfo.getState();
                if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                    return;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.m134a("network changed, no active network");
            }
            if (gx.a() != null) {
                gx.a().m426a();
            }
            gq.m423a((Context) this);
            this.f847a.d();
            if (com.xiaomi.push.bg.b(this)) {
                if (m631c() && m619e()) {
                    b(false);
                }
                if (!m631c() && !m632d()) {
                    this.f856a.a(1);
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
                Map<String, String> m530a = ieVar.m530a();
                if (m530a != null) {
                    String str = m530a.get("extra_help_aw_info");
                    String str2 = m530a.get("extra_aw_app_online_cmd");
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
            if (!m627a()) {
                er.a();
            } else if (er.m360a()) {
            } else {
                er.a(true);
            }
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m619e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            if (System.currentTimeMillis() - this.f844a < 30000) {
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
            fl flVar = this.f848a;
            if (flVar == null || !flVar.m390b()) {
                fl flVar2 = this.f848a;
                if (flVar2 == null || !flVar2.m391c()) {
                    this.f849a.b(com.xiaomi.push.bg.m236a((Context) this));
                    g();
                    if (this.f848a == null) {
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
    public boolean m620f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) && Settings.Secure.getInt(getContentResolver(), "EXTREME_POWER_MODE_ENABLE", 0) == 1 : invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            try {
                this.f847a.a(this.f850a, new bu(this));
                this.f847a.e();
                this.f848a = this.f847a;
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
                this.f847a.b(3, e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m621g() {
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
    private boolean m622h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) ? "com.xiaomi.xmsf".equals(getPackageName()) || !com.xiaomi.push.service.n.a(this).m698b(getPackageName()) : invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            synchronized (this.f859a) {
                this.f859a.clear();
            }
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m623i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) ? getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m504b((Context) this) && !com.xiaomi.push.i.m501a(getApplicationContext()) : invokeV.booleanValue;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) {
            int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
            int i2 = this.a;
            int i3 = this.f61406b;
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
    public fl m624a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f848a : (fl) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.e m625a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new com.xiaomi.push.service.e() : (com.xiaomi.push.service.e) invokeV.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m626a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && System.currentTimeMillis() - this.f844a >= fr.a() && com.xiaomi.push.bg.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f856a.a(i2);
        }
    }

    public void a(int i2, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, exc) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("disconnect ");
            sb.append(hashCode());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            fl flVar = this.f848a;
            sb.append(flVar == null ? null : Integer.valueOf(flVar.hashCode()));
            com.xiaomi.channel.commonutils.logger.b.m134a(sb.toString());
            fl flVar2 = this.f848a;
            if (flVar2 != null) {
                flVar2.b(i2, exc);
                this.f848a = null;
            }
            a(7);
            a(4);
            av.a().a(this, i2);
        }
    }

    public void a(fa faVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, faVar) == null) {
            fl flVar = this.f848a;
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
            if (m623i()) {
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
            if (m623i()) {
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
                this.f856a.a(iVar, j2);
            } catch (IllegalStateException e2) {
                com.xiaomi.channel.commonutils.logger.b.m134a("can't execute job err = " + e2.getMessage());
            }
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lVar) == null) {
            synchronized (this.f859a) {
                this.f859a.add(lVar);
            }
        }
    }

    public void a(av.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) || bVar == null) {
            return;
        }
        long a2 = bVar.a();
        com.xiaomi.channel.commonutils.logger.b.m134a("schedule rebind job in " + (a2 / 1000));
        a(new a(this, bVar), a2);
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i2), str3, str4}) == null) {
            av.b a2 = av.a().a(str, str2);
            if (a2 != null) {
                a(new q(this, a2, i2, str4, str3));
            }
            av.a().m669a(str, str2);
        }
    }

    public void a(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, str, bArr, z) == null) {
            Collection<av.b> m665a = av.a().m665a("5");
            if (m665a.isEmpty()) {
                if (!z) {
                    return;
                }
            } else if (m665a.iterator().next().f914a == av.c.f61430c) {
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
            this.f854a.a(z);
        }
    }

    public void a(byte[] bArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, bArr, str) == null) {
            if (bArr == null) {
                com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                com.xiaomi.channel.commonutils.logger.b.m134a("register request without payload");
                return;
            }
            ib ibVar = new ib();
            try {
                ip.a(ibVar, bArr);
                if (ibVar.f636a == hf.a) {
                    Cif cif = new Cif();
                    try {
                        ip.a(cif, ibVar.m520a());
                        com.xiaomi.push.service.p.a(ibVar.b(), bArr);
                        a(new com.xiaomi.push.service.o(this, ibVar.b(), cif.b(), cif.c(), bArr));
                        el.a(getApplicationContext()).a(ibVar.b(), "E100003", cif.a(), w0.p6, null);
                    } catch (iv e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("app register error. " + e2);
                        com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                    }
                } else {
                    com.xiaomi.push.service.p.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                    com.xiaomi.channel.commonutils.logger.b.m134a("register request with invalid payload");
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
            fl flVar = this.f848a;
            if (flVar == null) {
                throw new fw("try send msg while connection is null.");
            }
            flVar.a(faVarArr);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m627a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            boolean b2 = com.xiaomi.push.bg.b(this);
            boolean z = av.a().m663a() > 0;
            boolean z2 = !m630b();
            boolean m622h = m622h();
            boolean z3 = !m621g();
            boolean z4 = !m620f();
            boolean z5 = b2 && z && z2 && m622h && z3 && z4;
            if (!z5) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;!eps=%s", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m622h), Boolean.valueOf(z3), Boolean.valueOf(z4)));
            }
            return z5;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m628a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? this.f856a.m686a(i2) : invokeI.booleanValue;
    }

    public com.xiaomi.push.service.e b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f855a : (com.xiaomi.push.service.e) invokeV.objValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m629b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Iterator it = new ArrayList(this.f859a).iterator();
            while (it.hasNext()) {
                ((l) it.next()).mo434a();
            }
        }
    }

    @Override // com.xiaomi.push.fo
    public void b(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, flVar) == null) {
            gx.a().b(flVar);
            c(true);
            this.f854a.m675a();
            if (!er.m360a() && !m623i()) {
                com.xiaomi.channel.commonutils.logger.b.m134a("reconnection successful, reactivate alarm.");
                er.a(true);
            }
            Iterator<av.b> it = av.a().m664a().iterator();
            while (it.hasNext()) {
                a(new a(this, it.next()));
            }
        }
    }

    public void b(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.f856a.a(iVar.a, iVar);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m630b() {
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
    public boolean m631c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            fl flVar = this.f848a;
            return flVar != null && flVar.m391c();
        }
        return invokeV.booleanValue;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m632d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            fl flVar = this.f848a;
            return flVar != null && flVar.m390b();
        }
        return invokeV.booleanValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, intent)) == null) ? this.f846a.getBinder() : (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onCreate();
            com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
            com.xiaomi.push.t.m702a((Context) this);
            com.xiaomi.push.service.l a2 = com.xiaomi.push.service.m.a((Context) this);
            if (a2 != null) {
                com.xiaomi.push.ab.a(a2.a);
            }
            this.f846a = new Messenger(new bv(this));
            ba.a(this);
            bw bwVar = new bw(this, null, 5222, "xiaomi.com", null);
            this.f849a = bwVar;
            bwVar.a(true);
            this.f847a = new fh(this, this.f849a);
            this.f855a = m625a();
            er.a(this);
            this.f847a.a(this);
            this.f853a = new au(this);
            this.f854a = new bf(this);
            new com.xiaomi.push.service.f().a();
            gx.m427a().a(this);
            this.f856a = new com.xiaomi.push.service.h("Connection Controller Thread");
            av a3 = av.a();
            a3.b();
            a3.a(new bx(this));
            if (k()) {
                h();
            }
            hd.a(this).a(new com.xiaomi.push.service.j(this), "UPLOADER_PUSH_CHANNEL");
            a(new ha(this));
            a(new g(this));
            this.f860a.add(bk.a(this));
            if (m622h()) {
                this.f851a = new e(this);
                registerReceiver(this.f851a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                Uri uriFor = Settings.Secure.getUriFor("EXTREME_POWER_MODE_ENABLE");
                if (uriFor != null) {
                    this.f845a = new by(this, new Handler(Looper.getMainLooper()));
                    try {
                        getContentResolver().registerContentObserver(uriFor, false, this.f845a);
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m134a("register observer err:" + th.getMessage());
                    }
                }
                Uri uriFor2 = Settings.System.getUriFor("power_supersave_mode_open");
                if (uriFor2 != null) {
                    this.f861b = new bz(this, new Handler(Looper.getMainLooper()));
                    try {
                        getContentResolver().registerContentObserver(uriFor2, false, this.f861b);
                    } catch (Throwable th2) {
                        com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th2.getMessage());
                    }
                }
                int[] m617a = m617a();
                if (m617a != null) {
                    this.f852a = new p(this);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    registerReceiver(this.f852a, intentFilter);
                    this.a = m617a[0];
                    this.f61406b = m617a[1];
                    com.xiaomi.channel.commonutils.logger.b.m134a("falldown initialized: " + this.a + "," + this.f61406b);
                }
            }
            String str = "";
            if (a2 != null) {
                try {
                    if (!TextUtils.isEmpty(a2.f967a) && (split = a2.f967a.split("@")) != null && split.length > 0) {
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
            e eVar = this.f851a;
            if (eVar != null) {
                a(eVar);
                this.f851a = null;
            }
            p pVar = this.f852a;
            if (pVar != null) {
                a(pVar);
                this.f852a = null;
            }
            if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f845a != null) {
                try {
                    getContentResolver().unregisterContentObserver(this.f845a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.m134a("unregister observer err:" + th.getMessage());
                }
            }
            if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f861b != null) {
                try {
                    getContentResolver().unregisterContentObserver(this.f861b);
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th2.getMessage());
                }
            }
            this.f860a.clear();
            this.f856a.m687b();
            a(new bt(this, 2));
            a(new j(this));
            av.a().b();
            av.a().a(this, 15);
            av.a().m667a();
            this.f847a.b(this);
            bi.a().m681a();
            er.a();
            i();
            super.onDestroy();
            com.xiaomi.channel.commonutils.logger.b.m134a("Service destroyed");
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
                com.xiaomi.channel.commonutils.logger.b.m134a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(az.s), intent.getStringExtra(az.A), intent.getStringExtra("mipush_app_package")));
            }
            if (intent != null && intent.getAction() != null) {
                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                    if (this.f856a.m685a()) {
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
