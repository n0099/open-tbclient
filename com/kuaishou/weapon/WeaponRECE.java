package com.kuaishou.weapon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.d;
import com.kuaishou.weapon.un.l1;
import com.kuaishou.weapon.un.n;
import com.kuaishou.weapon.un.o;
import com.kuaishou.weapon.un.p;
import com.kuaishou.weapon.un.r;
import com.kuaishou.weapon.un.t1;
import java.util.List;
/* loaded from: classes5.dex */
public class WeaponRECE extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int c = 101;
    public static final int d = 102;
    public static final int e = 107;
    public static final long f = 60000;
    public transient /* synthetic */ FieldHolder $fh;
    public NetworkInfo a;
    public int b;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ WeaponRECE c;

        public a(WeaponRECE weaponRECE, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weaponRECE, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = weaponRECE;
            this.a = intent;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            o c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String action = this.a.getAction();
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (this.c.b == -1) {
                            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                                this.c.b = 2;
                                return;
                            }
                            this.c.b = 1;
                        } else if (this.c.a != activeNetworkInfo) {
                            if (this.c.a == null || activeNetworkInfo == null || this.c.a.getType() != activeNetworkInfo.getType()) {
                                this.c.a = activeNetworkInfo;
                                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                                    this.c.b = 1;
                                    return;
                                }
                                d dVar = new d(this.b);
                                if (this.c.b == 1) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (currentTimeMillis - dVar.f() >= 60000) {
                                        dVar.c(currentTimeMillis);
                                        n.a(this.b).b(107);
                                    }
                                }
                                this.c.b = 2;
                                if (dVar.b(d.W, 0) == 1) {
                                    if (activeNetworkInfo.getType() != 1) {
                                        dVar.c(d.c1, 1);
                                    } else if (dVar.c(d.c1) == 1) {
                                        n.a(this.b).f();
                                        dVar.c(d.c1, 0);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (action.equals(PackageChangedReceiver.ACTION_UNINSTALL)) {
                    try {
                        d dVar2 = new d(this.b);
                        dVar2.c(d.e1, dVar2.b(d.e1, 0) + 1);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (currentTimeMillis2 - dVar2.e() >= 60000) {
                            dVar2.b(currentTimeMillis2);
                            n.a(this.b).b(102);
                        }
                    } catch (Exception unused) {
                    }
                } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL)) {
                    try {
                        d dVar3 = new d(this.b);
                        dVar3.c(d.d1, dVar3.b(d.d1, 0) + 1);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (currentTimeMillis3 - dVar3.e() >= 60000) {
                            dVar3.b(currentTimeMillis3);
                            n.a(this.b).b(101);
                        }
                    } catch (Exception unused2) {
                    }
                } else if (TextUtils.isEmpty(this.a.getStringExtra("from_plugin_apk")) && (c = o.c()) != null) {
                    List<p> a = c.a();
                    if (a == null && a.size() == 0) {
                        return;
                    }
                    for (int i = 0; i < a.size(); i++) {
                        p pVar = a.get(i);
                        if (pVar != null && pVar.r != null) {
                            for (int i2 = 0; i2 < pVar.r.size(); i2++) {
                                try {
                                    r rVar = pVar.r.get(i2);
                                    if (rVar != null && rVar.d.match(this.a.getAction(), this.a.getType(), this.a.getScheme(), this.a.getData(), this.a.getCategories(), "WR") >= 0) {
                                        Class<?> loadClass = pVar.g.loadClass(rVar.b);
                                        loadClass.getDeclaredMethod(rVar.c, Context.class, Intent.class).invoke(loadClass.newInstance(), this.b.getApplicationContext(), this.a);
                                    }
                                } catch (Throwable th) {
                                    l1.a(th);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public WeaponRECE() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            try {
                t1.a().a(new a(this, intent, context));
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }
}
