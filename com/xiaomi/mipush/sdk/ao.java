package com.xiaomi.mipush.sdk;

import android.app.Application;
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
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bj;
import com.xiaomi.push.bo;
import com.xiaomi.push.db;
import com.xiaomi.push.eo;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hn;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.ip;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.bn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public static ao a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<a> f56a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f57a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f58a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f59a;

    /* renamed from: a  reason: collision with other field name */
    public Messenger f60a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f61a;

    /* renamed from: a  reason: collision with other field name */
    public String f62a;

    /* renamed from: a  reason: collision with other field name */
    public List<Message> f63a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f64a;
    public boolean c;

    /* loaded from: classes8.dex */
    public static class a<T extends iu<T, ?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hj a;

        /* renamed from: a  reason: collision with other field name */
        public T f65a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f66a;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206631, "Lcom/xiaomi/mipush/sdk/ao;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206631, "Lcom/xiaomi/mipush/sdk/ao;");
                return;
            }
        }
        f56a = new ArrayList<>();
    }

    public ao(Context context) {
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
        this.f64a = false;
        this.f59a = null;
        this.f63a = new ArrayList();
        this.c = false;
        this.f58a = null;
        this.f61a = null;
        this.f57a = context.getApplicationContext();
        this.f62a = null;
        this.f64a = m120c();
        b = m121d();
        this.f59a = new ap(this, Looper.getMainLooper());
        if (com.xiaomi.push.m.m562a(context)) {
            com.xiaomi.push.service.i.a(new aq(this));
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
                i = this.f57a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m115a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? (!m125a() || "com.xiaomi.xmsf".equals(this.f57a.getPackageName())) ? e() : d() : (Intent) invokeV.objValue;
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

    public static synchronized ao a(Context context) {
        InterceptResult invokeL;
        ao aoVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            synchronized (ao.class) {
                if (a == null) {
                    a = new ao(context);
                }
                aoVar = a;
            }
            return aoVar;
        }
        return (ao) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m118a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            try {
                return this.f57a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
            } catch (Exception unused) {
                return "com.xiaomi.xmsf.push.service.XMPushService";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        ii iiVar;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{str, auVar, Boolean.valueOf(z), hashMap}) == null) && b.m132a(this.f57a).m139b() && bj.b(this.f57a)) {
            ii iiVar2 = new ii();
            iiVar2.a(true);
            Intent m115a = m115a();
            if (TextUtils.isEmpty(str)) {
                str = bd.a();
                iiVar2.a(str);
                iiVar = z ? new ii(str, true) : null;
                synchronized (af.class) {
                    af.a(this.f57a).m111a(str);
                }
            } else {
                iiVar2.a(str);
                iiVar = z ? new ii(str, true) : null;
            }
            switch (at.a[auVar.ordinal()]) {
                case 1:
                    iiVar2.c(ht.E.f506a);
                    iiVar.c(ht.E.f506a);
                    if (hashMap != null) {
                        iiVar2.a(hashMap);
                        iiVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m115a.setAction(str2);
                    break;
                case 2:
                    iiVar2.c(ht.F.f506a);
                    iiVar.c(ht.F.f506a);
                    if (hashMap != null) {
                        iiVar2.a(hashMap);
                        iiVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m115a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    iiVar2.c(ht.N.f506a);
                    if (hashMap != null) {
                        iiVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + auVar + StringUtil.ARRAY_ELEMENT_SEPARATOR + str);
            iiVar2.b(b.m132a(this.f57a).m133a());
            iiVar2.d(this.f57a.getPackageName());
            a((ao) iiVar2, hj.i, false, (hw) null);
            if (z) {
                iiVar.b(b.m132a(this.f57a).m133a());
                iiVar.d(this.f57a.getPackageName());
                Context context = this.f57a;
                byte[] a2 = it.a(ai.a(context, iiVar, hj.i, false, context.getPackageName(), b.m132a(this.f57a).m133a()));
                if (a2 != null) {
                    db.a(this.f57a.getPackageName(), this.f57a, iiVar, hj.i, a2.length);
                    m115a.putExtra("mipush_payload", a2);
                    m115a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m115a.putExtra("mipush_app_id", b.m132a(this.f57a).m133a());
                    m115a.putExtra("mipush_app_token", b.m132a(this.f57a).b());
                    c(m115a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f59a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if ("com.xiaomi.xmsf".equals(this.f57a.getPackageName())) {
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
                if (com.xiaomi.push.m.m561a() || Build.VERSION.SDK_INT < 26) {
                    this.f57a.startService(intent);
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
            if (m125a()) {
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
                this.f57a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
            }
        }
    }

    private void c(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, intent) == null) {
            int a2 = ba.a(this.f57a).a(ho.T.a(), hk.a.a());
            int a3 = a();
            boolean z = a2 == hk.b.a() && b;
            int a4 = (z ? hk.b : hk.a).a();
            if (a4 != a3) {
                m126a(a4);
            }
            if (z) {
                d(intent);
            } else {
                b(intent);
            }
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m120c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            try {
                PackageInfo packageInfo = this.f57a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
            String packageName = this.f57a.getPackageName();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m118a());
            intent.putExtra("mipush_app_package", packageName);
            g();
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
                    if (this.f63a.size() >= 50) {
                        this.f63a.remove(0);
                    }
                    this.f63a.add(a2);
                    return;
                }
                if (this.f60a == null) {
                    this.f57a.bindService(intent, new as(this), 1);
                    this.c = true;
                    this.f63a.clear();
                    this.f63a.add(a(intent));
                } else {
                    try {
                        this.f60a.send(a(intent));
                    } catch (RemoteException unused) {
                        this.f60a = null;
                        this.c = false;
                    }
                }
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m121d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            if (m125a()) {
                try {
                    return this.f57a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
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
            String packageName = this.f57a.getPackageName();
            h();
            intent.setComponent(new ComponentName(this.f57a, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m122e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            String packageName = this.f57a.getPackageName();
            return packageName.contains("miui") || packageName.contains(RomUtils.MANUFACTURER_XIAOMI) || (this.f57a.getApplicationInfo().flags & 1) != 0;
        }
        return invokeV.booleanValue;
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            try {
                PackageManager packageManager = this.f57a.getPackageManager();
                ComponentName componentName = new ComponentName(this.f57a, "com.xiaomi.push.service.XMPushService");
                if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            } catch (Throwable unused) {
            }
        }
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            try {
                PackageManager packageManager = this.f57a.getPackageManager();
                ComponentName componentName = new ComponentName(this.f57a, "com.xiaomi.push.service.XMPushService");
                if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m123a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(m115a());
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            a(i, 0);
        }
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            m115a.putExtra(bk.B, this.f57a.getPackageName());
            m115a.putExtra(bk.C, i);
            m115a.putExtra(bk.D, i2);
            c(m115a);
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.thirdparty");
            m115a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
            m115a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
            b(m115a);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m124a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            intent.fillIn(m115a(), 24);
            c(intent);
        }
    }

    public final void a(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hnVar) == null) {
            Intent m115a = m115a();
            byte[] a2 = it.a(hnVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m90a("send TinyData failed, because tinyDataBytes is null.");
                return;
            }
            m115a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
            m115a.putExtra("mipush_payload", a2);
            b(m115a);
        }
    }

    public final void a(ij ijVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, ijVar, z) == null) {
            eo.a(this.f57a.getApplicationContext()).a(this.f57a.getPackageName(), "E100003", ijVar.a(), ARPMessageType.MSG_TYPE_MODEL_LOAD_PROGRESS, null);
            this.f58a = null;
            b.m132a(this.f57a).f71a = ijVar.a();
            Intent m115a = m115a();
            byte[] a2 = it.a(ai.a(this.f57a, ijVar, hj.a));
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m90a("register fail, because msgBytes is null.");
                return;
            }
            m115a.setAction("com.xiaomi.mipush.REGISTER_APP");
            m115a.putExtra("mipush_app_id", b.m132a(this.f57a).m133a());
            m115a.putExtra("mipush_payload", a2);
            m115a.putExtra("mipush_session", this.f62a);
            m115a.putExtra("mipush_env_chanage", z);
            m115a.putExtra("mipush_env_type", b.m132a(this.f57a).a());
            if (bj.b(this.f57a) && m128b()) {
                c(m115a);
            } else {
                this.f58a = m115a;
            }
        }
    }

    public final void a(ip ipVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ipVar) == null) {
            byte[] a2 = it.a(ai.a(this.f57a, ipVar, hj.b));
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.m90a("unregister fail, because msgBytes is null.");
                return;
            }
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
            m115a.putExtra("mipush_app_id", b.m132a(this.f57a).m133a());
            m115a.putExtra("mipush_payload", a2);
            c(m115a);
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, hw hwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t, hjVar, hwVar) == null) {
            a((ao) t, hjVar, !hjVar.equals(hj.a), hwVar);
        }
    }

    public <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, t, hjVar, z) == null) {
            a aVar = new a();
            aVar.f65a = t;
            aVar.a = hjVar;
            aVar.f66a = z;
            synchronized (f56a) {
                f56a.add(aVar);
                if (f56a.size() > 10) {
                    f56a.remove(0);
                }
            }
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, hw hwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{t, hjVar, Boolean.valueOf(z), hwVar}) == null) {
            a(t, hjVar, z, true, hwVar, true);
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, hw hwVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{t, hjVar, Boolean.valueOf(z), hwVar, Boolean.valueOf(z2)}) == null) {
            a(t, hjVar, z, true, hwVar, z2);
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{t, hjVar, Boolean.valueOf(z), Boolean.valueOf(z2), hwVar, Boolean.valueOf(z3)}) == null) {
            a(t, hjVar, z, z2, hwVar, z3, this.f57a.getPackageName(), b.m132a(this.f57a).m133a());
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{t, hjVar, Boolean.valueOf(z), Boolean.valueOf(z2), hwVar, Boolean.valueOf(z3), str, str2}) == null) {
            a(t, hjVar, z, z2, hwVar, z3, str, str2, true);
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3, String str, String str2, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{t, hjVar, Boolean.valueOf(z), Boolean.valueOf(z2), hwVar, Boolean.valueOf(z3), str, str2, Boolean.valueOf(z4)}) == null) {
            a(t, hjVar, z, z2, hwVar, z3, str, str2, z4, true);
        }
    }

    public final <T extends iu<T, ?>> void a(T t, hj hjVar, boolean z, boolean z2, hw hwVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{t, hjVar, Boolean.valueOf(z), Boolean.valueOf(z2), hwVar, Boolean.valueOf(z3), str, str2, Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            if (z5 && !b.m132a(this.f57a).m141c()) {
                if (z2) {
                    a((ao) t, hjVar, z);
                    return;
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m90a("drop the message before initialization.");
                    return;
                }
            }
            Cif a2 = z4 ? ai.a(this.f57a, t, hjVar, z, str, str2) : ai.b(this.f57a, t, hjVar, z, str, str2);
            if (hwVar != null) {
                a2.a(hwVar);
            }
            byte[] a3 = it.a(a2);
            if (a3 == null) {
                com.xiaomi.channel.commonutils.logger.b.m90a("send message fail, because msgBytes is null.");
                return;
            }
            db.a(this.f57a.getPackageName(), this.f57a, t, hjVar, a3.length);
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            m115a.putExtra("mipush_payload", a3);
            m115a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            c(m115a);
        }
    }

    public final void a(String str, au auVar, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, auVar, eVar) == null) {
            af.a(this.f57a).a(auVar, "syncing");
            a(str, auVar, false, i.m151a(this.f57a, eVar));
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
            m115a.putExtra(bk.B, this.f57a.getPackageName());
            m115a.putExtra(bk.H, str);
            m115a.putExtra(bk.I, str2);
            c(m115a);
        }
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            a(z, (String) null);
        }
    }

    public final void a(boolean z, String str) {
        au auVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, str) == null) {
            if (z) {
                af.a(this.f57a).a(au.a, "syncing");
                af.a(this.f57a).a(au.b, "");
                auVar = au.a;
            } else {
                af.a(this.f57a).a(au.b, "syncing");
                af.a(this.f57a).a(au.a, "");
                auVar = au.b;
            }
            a(str, auVar, true, (HashMap<String, String>) null);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m125a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f64a && 1 == b.m132a(this.f57a).a() : invokeV.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m126a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (b.m132a(this.f57a).m139b()) {
                c(i);
                ii iiVar = new ii();
                iiVar.a(bd.a());
                iiVar.b(b.m132a(this.f57a).m133a());
                iiVar.d(this.f57a.getPackageName());
                iiVar.c(ht.G.f506a);
                HashMap hashMap = new HashMap();
                iiVar.f645a = hashMap;
                hashMap.put("boot_mode", i + "");
                a(this.f57a).a((ao) iiVar, hj.i, false, (hw) null);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m127b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
            c(m115a);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            m115a.putExtra(bk.B, this.f57a.getPackageName());
            m115a.putExtra(bk.E, i);
            String str = bk.G;
            m115a.putExtra(str, bo.b(this.f57a.getPackageName() + i));
            c(m115a);
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m128b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (m125a() && m122e()) {
                if (this.f61a == null) {
                    Integer valueOf = Integer.valueOf(bn.a(this.f57a).a());
                    this.f61a = valueOf;
                    if (valueOf.intValue() == 0) {
                        this.f57a.getContentResolver().registerContentObserver(bn.a(this.f57a).m645a(), false, new ar(this, new Handler(Looper.getMainLooper())));
                    }
                }
                return this.f61a.intValue() != 0;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m129c() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (intent = this.f58a) == null) {
            return;
        }
        c(intent);
        this.f58a = null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m130d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            synchronized (f56a) {
                boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
                Iterator<a> it = f56a.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    a(next.f65a, next.a, next.f66a, false, null, true);
                    if (!z) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                f56a.clear();
            }
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m131e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
            Application application = (Application) com.xiaomi.push.bk.a("android.app.ActivityThread", "currentApplication", new Object[0]);
            String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
            String packageName2 = this.f57a.getPackageName();
            if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
                packageName = packageName2;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m90a("application package name: " + packageName + ", not equals context package name: " + packageName2);
            }
            m115a.putExtra(bk.B, packageName);
            c(m115a);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            Intent m115a = m115a();
            m115a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
            m115a.putExtra(bk.B, this.f57a.getPackageName());
            m115a.putExtra(bk.G, bo.b(this.f57a.getPackageName()));
            c(m115a);
        }
    }
}
