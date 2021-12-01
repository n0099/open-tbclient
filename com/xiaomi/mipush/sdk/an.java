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
/* loaded from: classes3.dex */
public class an {
    public static /* synthetic */ Interceptable $ic;
    public static an a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f71a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f62689b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f72a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f73a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f74a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f75a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f76a;

    /* renamed from: a  reason: collision with other field name */
    public String f77a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f78a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f79a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62690c;

    /* loaded from: classes3.dex */
    public static class a<T extends iq<T, ?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hf a;

        /* renamed from: a  reason: collision with other field name */
        public T f80a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f81a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        f71a = new ArrayList<>();
    }

    public an(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f79a = false;
        this.f74a = null;
        this.f78a = new ArrayList();
        this.f62690c = false;
        this.f73a = null;
        this.f76a = null;
        this.f72a = context.getApplicationContext();
        this.f77a = null;
        this.f79a = m151c();
        f62689b = m152d();
        this.f74a = new ao(this, Looper.getMainLooper());
        if (com.xiaomi.push.l.m588a(context)) {
            com.xiaomi.push.service.d.a(new ap(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                i2 = this.f72a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m146a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? (!m156a() || "com.xiaomi.xmsf".equals(this.f72a.getPackageName())) ? e() : d() : (Intent) invokeV.objValue;
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
    private String m149a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                return this.f72a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
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
        if ((interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{str, atVar, Boolean.valueOf(z), hashMap}) == null) && b.m163a(this.f72a).m170b() && bg.b(this.f72a)) {
            ie ieVar2 = new ie();
            ieVar2.a(true);
            Intent m146a = m146a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.at.a();
                ieVar2.a(str);
                ieVar = z ? new ie(str, true) : null;
                synchronized (ae.class) {
                    ae.a(this.f72a).m142a(str);
                }
            } else {
                ieVar2.a(str);
                ieVar = z ? new ie(str, true) : null;
            }
            switch (as.a[atVar.ordinal()]) {
                case 1:
                    ieVar2.c(hp.E.f514a);
                    ieVar.c(hp.E.f514a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        ieVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m146a.setAction(str2);
                    break;
                case 2:
                    ieVar2.c(hp.F.f514a);
                    ieVar.c(hp.F.f514a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        ieVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m146a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    ieVar2.c(hp.N.f514a);
                    if (hashMap != null) {
                        ieVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + atVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
            ieVar2.b(b.m163a(this.f72a).m164a());
            ieVar2.d(this.f72a.getPackageName());
            a((an) ieVar2, hf.f62975i, false, (hs) null);
            if (z) {
                ieVar.b(b.m163a(this.f72a).m164a());
                ieVar.d(this.f72a.getPackageName());
                Context context = this.f72a;
                byte[] a2 = ip.a(ah.a(context, ieVar, hf.f62975i, false, context.getPackageName(), b.m163a(this.f72a).m164a()));
                if (a2 != null) {
                    cy.a(this.f72a.getPackageName(), this.f72a, ieVar, hf.f62975i, a2.length);
                    m146a.putExtra("mipush_payload", a2);
                    m146a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m146a.putExtra("mipush_app_id", b.m163a(this.f72a).m164a());
                    m146a.putExtra("mipush_app_token", b.m163a(this.f72a).b());
                    c(m146a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = atVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f74a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if ("com.xiaomi.xmsf".equals(this.f72a.getPackageName())) {
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
                if (com.xiaomi.push.l.m587a() || Build.VERSION.SDK_INT < 26) {
                    this.f72a.startService(intent);
                } else {
                    d(intent);
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private Intent c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            if (m156a()) {
                com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
                return d();
            }
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
            return e();
        }
        return (Intent) invokeV.objValue;
    }

    private synchronized void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, this, i2) == null) {
            synchronized (this) {
                this.f72a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i2).commit();
            }
        }
    }

    private void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, intent) == null) {
            int a2 = com.xiaomi.push.service.aq.a(this.f72a).a(hk.T.a(), hg.a.a());
            int a3 = a();
            boolean z = a2 == hg.f62978b.a() && f62689b;
            int a4 = (z ? hg.f62978b : hg.a).a();
            if (a4 != a3) {
                m157a(a4);
            }
            if (z) {
                d(intent);
            } else {
                b(intent);
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m151c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            try {
                PackageInfo packageInfo = this.f72a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
            String packageName = this.f72a.getPackageName();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m149a());
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
                if (this.f62690c) {
                    Message a2 = a(intent);
                    if (this.f78a.size() >= 50) {
                        this.f78a.remove(0);
                    }
                    this.f78a.add(a2);
                    return;
                }
                if (this.f75a == null) {
                    this.f72a.bindService(intent, new ar(this), 1);
                    this.f62690c = true;
                    this.f78a.clear();
                    this.f78a.add(a(intent));
                } else {
                    try {
                        this.f75a.send(a(intent));
                    } catch (RemoteException unused) {
                        this.f75a = null;
                        this.f62690c = false;
                    }
                }
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m152d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (m156a()) {
                try {
                    return this.f72a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
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
            String packageName = this.f72a.getPackageName();
            g();
            intent.setComponent(new ComponentName(this.f72a, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m153e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            String packageName = this.f72a.getPackageName();
            return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f72a.getApplicationInfo().flags & 1) != 0;
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            try {
                PackageManager packageManager = this.f72a.getPackageManager();
                ComponentName componentName = new ComponentName(this.f72a, "com.xiaomi.push.service.XMPushService");
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
                PackageManager packageManager = this.f72a.getPackageManager();
                ComponentName componentName = new ComponentName(this.f72a, "com.xiaomi.push.service.XMPushService");
                if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m154a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(m146a());
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            m146a.putExtra(az.A, this.f72a.getPackageName());
            m146a.putExtra(az.B, i2);
            c(m146a);
        }
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.thirdparty");
            m146a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i2);
            m146a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
            b(m146a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m155a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            intent.fillIn(m146a(), 24);
            c(intent);
        }
    }

    public final void a(hj hjVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hjVar) == null) {
            Intent m146a = m146a();
            byte[] a2 = ip.a(hjVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m122a("send TinyData failed, because tinyDataBytes is null.");
                return;
            }
            m146a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
            m146a.putExtra("mipush_payload", a2);
            b(m146a);
        }
    }

    public final void a(Cif cif, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, cif, z) == null) {
            el.a(this.f72a.getApplicationContext()).a(this.f72a.getPackageName(), "E100003", cif.a(), 6001, null);
            this.f73a = null;
            b.m163a(this.f72a).f86a = cif.a();
            Intent m146a = m146a();
            byte[] a2 = ip.a(ah.a(this.f72a, cif, hf.a));
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m122a("register fail, because msgBytes is null.");
                return;
            }
            m146a.setAction("com.xiaomi.mipush.REGISTER_APP");
            m146a.putExtra("mipush_app_id", b.m163a(this.f72a).m164a());
            m146a.putExtra("mipush_payload", a2);
            m146a.putExtra("mipush_session", this.f77a);
            m146a.putExtra("mipush_env_chanage", z);
            m146a.putExtra("mipush_env_type", b.m163a(this.f72a).a());
            if (bg.b(this.f72a) && m159b()) {
                c(m146a);
            } else {
                this.f73a = m146a;
            }
        }
    }

    public final void a(il ilVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ilVar) == null) {
            byte[] a2 = ip.a(ah.a(this.f72a, ilVar, hf.f62968b));
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m122a("unregister fail, because msgBytes is null.");
                return;
            }
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
            m146a.putExtra("mipush_app_id", b.m163a(this.f72a).m164a());
            m146a.putExtra("mipush_payload", a2);
            c(m146a);
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
            aVar.f80a = t;
            aVar.a = hfVar;
            aVar.f81a = z;
            synchronized (f71a) {
                f71a.add(aVar);
                if (f71a.size() > 10) {
                    f71a.remove(0);
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
            a(t, hfVar, z, z2, hsVar, z3, this.f72a.getPackageName(), b.m163a(this.f72a).m164a());
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
            if (!b.m163a(this.f72a).m172c()) {
                if (z2) {
                    a((an) t, hfVar, z);
                    return;
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m122a("drop the message before initialization.");
                    return;
                }
            }
            Context context = this.f72a;
            ib a2 = z4 ? ah.a(context, t, hfVar, z, str, str2) : ah.b(context, t, hfVar, z, str, str2);
            if (hsVar != null) {
                a2.a(hsVar);
            }
            byte[] a3 = ip.a(a2);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.m122a("send message fail, because msgBytes is null.");
                return;
            }
            cy.a(this.f72a.getPackageName(), this.f72a, t, hfVar, a3.length);
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            m146a.putExtra("mipush_payload", a3);
            m146a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            c(m146a);
        }
    }

    public final void a(String str, at atVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, str, atVar, eVar) == null) {
            ae.a(this.f72a).a(atVar, "syncing");
            a(str, atVar, false, i.a(this.f72a, eVar));
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            m146a.putExtra(az.A, this.f72a.getPackageName());
            m146a.putExtra(az.F, str);
            m146a.putExtra(az.G, str2);
            c(m146a);
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
                ae.a(this.f72a).a(at.a, "syncing");
                ae.a(this.f72a).a(at.f62691b, "");
                atVar = at.a;
            } else {
                ae.a(this.f72a).a(at.f62691b, "syncing");
                ae.a(this.f72a).a(at.a, "");
                atVar = at.f62691b;
            }
            a(str, atVar, true, (HashMap<String, String>) null);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m156a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f79a && 1 == b.m163a(this.f72a).a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m157a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (b.m163a(this.f72a).m170b()) {
                c(i2);
                ie ieVar = new ie();
                ieVar.a(com.xiaomi.push.service.at.a());
                ieVar.b(b.m163a(this.f72a).m164a());
                ieVar.d(this.f72a.getPackageName());
                ieVar.c(hp.G.f514a);
                HashMap hashMap = new HashMap();
                ieVar.f655a = hashMap;
                hashMap.put("boot_mode", i2 + "");
                a(this.f72a).a((an) ieVar, hf.f62975i, false, (hs) null);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m158b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
            c(m146a);
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            m146a.putExtra(az.A, this.f72a.getPackageName());
            m146a.putExtra(az.C, i2);
            String str = az.E;
            m146a.putExtra(str, bl.b(this.f72a.getPackageName() + i2));
            c(m146a);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m159b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (m156a() && m153e()) {
                if (this.f76a == null) {
                    Integer valueOf = Integer.valueOf(bc.a(this.f72a).a());
                    this.f76a = valueOf;
                    if (valueOf.intValue() == 0) {
                        this.f72a.getContentResolver().registerContentObserver(bc.a(this.f72a).m660a(), false, new aq(this, new Handler(Looper.getMainLooper())));
                    }
                }
                return this.f76a.intValue() != 0;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m160c() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (intent = this.f73a) == null) {
            return;
        }
        c(intent);
        this.f73a = null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m161d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            synchronized (f71a) {
                boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
                Iterator<a> it = f71a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    a(next.f80a, next.a, next.f81a, false, null, true);
                    if (!z) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                f71a.clear();
            }
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m162e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Intent m146a = m146a();
            m146a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            m146a.putExtra(az.A, this.f72a.getPackageName());
            m146a.putExtra(az.E, bl.b(this.f72a.getPackageName()));
            c(m146a);
        }
    }
}
