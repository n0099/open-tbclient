package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bg;
import com.xiaomi.push.bl;
import com.xiaomi.push.cy;
import com.xiaomi.push.el;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.il;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.bc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;
    public static an a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f47a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f48a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f49a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f50a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f51a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f52a;

    /* renamed from: a  reason: collision with other field name */
    public String f53a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f54a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f55a;
    public boolean c;

    /* loaded from: classes8.dex */
    public static class a<T extends iq<T, ?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hf a;

        /* renamed from: a  reason: collision with other field name */
        public T f56a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f57a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206662, "Lcom/xiaomi/mipush/sdk/an;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206662, "Lcom/xiaomi/mipush/sdk/an;");
                return;
            }
        }
        f47a = new ArrayList<>();
    }

    public an(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55a = false;
        this.f50a = null;
        this.f54a = new ArrayList();
        this.c = false;
        this.f49a = null;
        this.f52a = null;
        this.f48a = context.getApplicationContext();
        this.f53a = null;
        this.f55a = m138c();
        b = m139d();
        this.f50a = new ao(this, Looper.getMainLooper());
        if (com.xiaomi.push.l.m575a(context)) {
            com.xiaomi.push.service.d.a(new ap(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                i = this.f48a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m133a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? (!m143a() || "com.xiaomi.xmsf".equals(this.f48a.getPackageName())) ? e() : d() : (Intent) invokeV.objValue;
    }

    private Message a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, intent)) == null) {
            Message obtain = Message.obtain();
            obtain.what = 17;
            obtain.obj = intent;
            return obtain;
        }
        return (Message) invokeL.objValue;
    }

    public static synchronized an a(Context context) {
        InterceptResult invokeL;
        an anVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            synchronized (an.class) {
                if (a == null) {
                    a = new an(context);
                }
                anVar = a;
            }
            return anVar;
        }
        return (an) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m136a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                return this.f48a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
            } catch (Exception unused) {
                return "com.xiaomi.xmsf.push.service.XMPushService";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, at atVar, boolean z, HashMap<String, String> hashMap) {
        ie ieVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{str, atVar, Boolean.valueOf(z), hashMap}) == null) && b.m150a(this.f48a).m157b() && bg.b(this.f48a)) {
            ie ieVar2 = new ie();
            ieVar2.a(true);
            Intent m133a = m133a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.at.a();
                ieVar2.a(str);
                ieVar = z ? new ie(str, true) : null;
                synchronized (ae.class) {
                    ae.a(this.f48a).m129a(str);
                }
            } else {
                ieVar2.a(str);
                ieVar = z ? new ie(str, true) : null;
            }
            switch (as.a[atVar.ordinal()]) {
                case 1:
                    ieVar2.c(hp.E.f490a);
                    ieVar.c(hp.E.f490a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        ieVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m133a.setAction(str2);
                    break;
                case 2:
                    ieVar2.c(hp.F.f490a);
                    ieVar.c(hp.F.f490a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        ieVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m133a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ieVar2.c(hp.N.f490a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + atVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
            ieVar2.b(b.m150a(this.f48a).m151a());
            ieVar2.d(this.f48a.getPackageName());
            a((an) ieVar2, hf.i, false, (hs) null);
            if (z) {
                ieVar.b(b.m150a(this.f48a).m151a());
                ieVar.d(this.f48a.getPackageName());
                Context context = this.f48a;
                byte[] a2 = ip.a(ah.a(context, ieVar, hf.i, false, context.getPackageName(), b.m150a(this.f48a).m151a()));
                if (a2 != null) {
                    cy.a(this.f48a.getPackageName(), this.f48a, ieVar, hf.i, a2.length);
                    m133a.putExtra("mipush_payload", a2);
                    m133a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m133a.putExtra("mipush_app_id", b.m150a(this.f48a).m151a());
                    m133a.putExtra("mipush_app_token", b.m150a(this.f48a).b());
                    c(m133a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = atVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f50a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if ("com.xiaomi.xmsf".equals(this.f48a.getPackageName())) {
                com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
                return e();
            }
            return c();
        }
        return (Intent) invokeV.objValue;
    }

    private void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, intent) == null) {
            try {
                if (com.xiaomi.push.l.m574a() || Build.VERSION.SDK_INT < 26) {
                    this.f48a.startService(intent);
                } else {
                    d(intent);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    private Intent c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (m143a()) {
                com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
                return d();
            }
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
            return e();
        }
        return (Intent) invokeV.objValue;
    }

    private synchronized void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i) == null) {
            synchronized (this) {
                this.f48a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
            }
        }
    }

    private void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, intent) == null) {
            int a2 = com.xiaomi.push.service.aq.a(this.f48a).a(hk.T.a(), hg.a.a());
            int a3 = a();
            boolean z = a2 == hg.b.a() && b;
            int a4 = (z ? hg.b : hg.a).a();
            if (a4 != a3) {
                m144a(a4);
            }
            if (z) {
                d(intent);
            } else {
                b(intent);
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m138c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            try {
                PackageInfo packageInfo = this.f48a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                return packageInfo.versionCode >= 105;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private Intent d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            Intent intent = new Intent();
            String packageName = this.f48a.getPackageName();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m136a());
            intent.putExtra("mipush_app_package", packageName);
            f();
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    private synchronized void d(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, intent) == null) {
            synchronized (this) {
                if (this.c) {
                    Message a2 = a(intent);
                    if (this.f54a.size() >= 50) {
                        this.f54a.remove(0);
                    }
                    this.f54a.add(a2);
                    return;
                }
                if (this.f51a == null) {
                    this.f48a.bindService(intent, new ar(this), 1);
                    this.c = true;
                    this.f54a.clear();
                    this.f54a.add(a(intent));
                } else {
                    try {
                        this.f51a.send(a(intent));
                    } catch (RemoteException unused) {
                        this.f51a = null;
                        this.c = false;
                    }
                }
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m139d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (m143a()) {
                try {
                    return this.f48a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
                } catch (Exception unused) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private Intent e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            Intent intent = new Intent();
            String packageName = this.f48a.getPackageName();
            g();
            intent.setComponent(new ComponentName(this.f48a, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m140e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            String packageName = this.f48a.getPackageName();
            return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f48a.getApplicationInfo().flags & 1) != 0;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            try {
                PackageManager packageManager = this.f48a.getPackageManager();
                ComponentName componentName = new ComponentName(this.f48a, "com.xiaomi.push.service.XMPushService");
                if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            } catch (Throwable unused) {
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            try {
                PackageManager packageManager = this.f48a.getPackageManager();
                ComponentName componentName = new ComponentName(this.f48a, "com.xiaomi.push.service.XMPushService");
                if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m141a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(m133a());
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            m133a.putExtra(az.A, this.f48a.getPackageName());
            m133a.putExtra(az.B, i);
            c(m133a);
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.thirdparty");
            m133a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
            m133a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
            b(m133a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m142a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            intent.fillIn(m133a(), 24);
            c(intent);
        }
    }

    public final void a(hj hjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hjVar) == null) {
            Intent m133a = m133a();
            byte[] a2 = ip.a(hjVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m109a("send TinyData failed, because tinyDataBytes is null.");
                return;
            }
            m133a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
            m133a.putExtra("mipush_payload", a2);
            b(m133a);
        }
    }

    public final void a(Cif cif, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, cif, z) == null) {
            el.a(this.f48a.getApplicationContext()).a(this.f48a.getPackageName(), "E100003", cif.a(), 6001, null);
            this.f49a = null;
            b.m150a(this.f48a).f62a = cif.a();
            Intent m133a = m133a();
            byte[] a2 = ip.a(ah.a(this.f48a, cif, hf.a));
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m109a("register fail, because msgBytes is null.");
                return;
            }
            m133a.setAction("com.xiaomi.mipush.REGISTER_APP");
            m133a.putExtra("mipush_app_id", b.m150a(this.f48a).m151a());
            m133a.putExtra("mipush_payload", a2);
            m133a.putExtra("mipush_session", this.f53a);
            m133a.putExtra("mipush_env_chanage", z);
            m133a.putExtra("mipush_env_type", b.m150a(this.f48a).a());
            if (bg.b(this.f48a) && m146b()) {
                c(m133a);
            } else {
                this.f49a = m133a;
            }
        }
    }

    public final void a(il ilVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ilVar) == null) {
            byte[] a2 = ip.a(ah.a(this.f48a, ilVar, hf.b));
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m109a("unregister fail, because msgBytes is null.");
                return;
            }
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
            m133a.putExtra("mipush_app_id", b.m150a(this.f48a).m151a());
            m133a.putExtra("mipush_payload", a2);
            c(m133a);
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, hs hsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, t, hfVar, hsVar) == null) {
            a((an) t, hfVar, !hfVar.equals(hf.a), hsVar);
        }
    }

    public <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, t, hfVar, z) == null) {
            a aVar = new a();
            aVar.f56a = t;
            aVar.a = hfVar;
            aVar.f57a = z;
            synchronized (f47a) {
                f47a.add(aVar);
                if (f47a.size() > 10) {
                    f47a.remove(0);
                }
            }
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, hs hsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{t, hfVar, Boolean.valueOf(z), hsVar}) == null) {
            a(t, hfVar, z, true, hsVar, true);
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, hs hsVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{t, hfVar, Boolean.valueOf(z), hsVar, Boolean.valueOf(z2)}) == null) {
            a(t, hfVar, z, true, hsVar, z2);
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, boolean z2, hs hsVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{t, hfVar, Boolean.valueOf(z), Boolean.valueOf(z2), hsVar, Boolean.valueOf(z3)}) == null) {
            a(t, hfVar, z, z2, hsVar, z3, this.f48a.getPackageName(), b.m150a(this.f48a).m151a());
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, boolean z2, hs hsVar, boolean z3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{t, hfVar, Boolean.valueOf(z), Boolean.valueOf(z2), hsVar, Boolean.valueOf(z3), str, str2}) == null) {
            a(t, hfVar, z, z2, hsVar, z3, str, str2, true);
        }
    }

    public final <T extends iq<T, ?>> void a(T t, hf hfVar, boolean z, boolean z2, hs hsVar, boolean z3, String str, String str2, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{t, hfVar, Boolean.valueOf(z), Boolean.valueOf(z2), hsVar, Boolean.valueOf(z3), str, str2, Boolean.valueOf(z4)}) == null) {
            if (!b.m150a(this.f48a).m159c()) {
                if (z2) {
                    a((an) t, hfVar, z);
                    return;
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m109a("drop the message before initialization.");
                    return;
                }
            }
            Context context = this.f48a;
            ib a2 = z4 ? ah.a(context, t, hfVar, z, str, str2) : ah.b(context, t, hfVar, z, str, str2);
            if (hsVar != null) {
                a2.a(hsVar);
            }
            byte[] a3 = ip.a(a2);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.m109a("send message fail, because msgBytes is null.");
                return;
            }
            cy.a(this.f48a.getPackageName(), this.f48a, t, hfVar, a3.length);
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            m133a.putExtra("mipush_payload", a3);
            m133a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            c(m133a);
        }
    }

    public final void a(String str, at atVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, atVar, eVar) == null) {
            ae.a(this.f48a).a(atVar, "syncing");
            a(str, atVar, false, i.a(this.f48a, eVar));
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            m133a.putExtra(az.A, this.f48a.getPackageName());
            m133a.putExtra(az.F, str);
            m133a.putExtra(az.G, str2);
            c(m133a);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            a(z, (String) null);
        }
    }

    public final void a(boolean z, String str) {
        at atVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048593, this, z, str) == null) {
            if (z) {
                ae.a(this.f48a).a(at.a, "syncing");
                ae.a(this.f48a).a(at.b, "");
                atVar = at.a;
            } else {
                ae.a(this.f48a).a(at.b, "syncing");
                ae.a(this.f48a).a(at.a, "");
                atVar = at.b;
            }
            a(str, atVar, true, (HashMap<String, String>) null);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m143a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f55a && 1 == b.m150a(this.f48a).a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m144a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            if (b.m150a(this.f48a).m157b()) {
                c(i);
                ie ieVar = new ie();
                ieVar.a(com.xiaomi.push.service.at.a());
                ieVar.b(b.m150a(this.f48a).m151a());
                ieVar.d(this.f48a.getPackageName());
                ieVar.c(hp.G.f490a);
                HashMap hashMap = new HashMap();
                ieVar.f631a = hashMap;
                hashMap.put("boot_mode", i + "");
                a(this.f48a).a((an) ieVar, hf.i, false, (hs) null);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m145b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
            c(m133a);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            m133a.putExtra(az.A, this.f48a.getPackageName());
            m133a.putExtra(az.C, i);
            String str = az.E;
            m133a.putExtra(str, bl.b(this.f48a.getPackageName() + i));
            c(m133a);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m146b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (m143a() && m140e()) {
                if (this.f52a == null) {
                    Integer valueOf = Integer.valueOf(bc.a(this.f48a).a());
                    this.f52a = valueOf;
                    if (valueOf.intValue() == 0) {
                        this.f48a.getContentResolver().registerContentObserver(bc.a(this.f48a).m647a(), false, new aq(this, new Handler(Looper.getMainLooper())));
                    }
                }
                return this.f52a.intValue() != 0;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m147c() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (intent = this.f49a) == null) {
            return;
        }
        c(intent);
        this.f49a = null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m148d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (f47a) {
                boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
                Iterator<a> it = f47a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    a(next.f56a, next.a, next.f57a, false, null, true);
                    if (!z) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                f47a.clear();
            }
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m149e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Intent m133a = m133a();
            m133a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            m133a.putExtra(az.A, this.f48a.getPackageName());
            m133a.putExtra(az.E, bl.b(this.f48a.getPackageName()));
            c(m133a);
        }
    }
}
