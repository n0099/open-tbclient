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
/* loaded from: classes3.dex */
public class WeaponRECE extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f55063c = 101;

    /* renamed from: d  reason: collision with root package name */
    public static final int f55064d = 102;

    /* renamed from: e  reason: collision with root package name */
    public static final int f55065e = 107;

    /* renamed from: f  reason: collision with root package name */
    public static final long f55066f = 60000;
    public transient /* synthetic */ FieldHolder $fh;
    public NetworkInfo a;

    /* renamed from: b  reason: collision with root package name */
    public int f55067b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f55068b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WeaponRECE f55069c;

        public a(WeaponRECE weaponRECE, Intent intent, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weaponRECE, intent, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55069c = weaponRECE;
            this.a = intent;
            this.f55068b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            o c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String action = this.a.getAction();
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f55068b.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (this.f55069c.f55067b == -1) {
                            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                                this.f55069c.f55067b = 2;
                                return;
                            }
                            this.f55069c.f55067b = 1;
                        } else if (this.f55069c.a != activeNetworkInfo) {
                            if (this.f55069c.a == null || activeNetworkInfo == null || this.f55069c.a.getType() != activeNetworkInfo.getType()) {
                                this.f55069c.a = activeNetworkInfo;
                                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                                    this.f55069c.f55067b = 1;
                                    return;
                                }
                                d dVar = new d(this.f55068b);
                                if (this.f55069c.f55067b == 1) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (currentTimeMillis - dVar.f() >= 60000) {
                                        dVar.c(currentTimeMillis);
                                        n.a(this.f55068b).b(107);
                                    }
                                }
                                this.f55069c.f55067b = 2;
                                if (dVar.b(d.W, 0) == 1) {
                                    if (activeNetworkInfo.getType() != 1) {
                                        dVar.c(d.c1, 1);
                                    } else if (dVar.c(d.c1) == 1) {
                                        n.a(this.f55068b).f();
                                        dVar.c(d.c1, 0);
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (action.equals(PackageChangedReceiver.ACTION_UNINSTALL)) {
                    try {
                        d dVar2 = new d(this.f55068b);
                        dVar2.c(d.e1, dVar2.b(d.e1, 0) + 1);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (currentTimeMillis2 - dVar2.e() >= 60000) {
                            dVar2.b(currentTimeMillis2);
                            n.a(this.f55068b).b(102);
                        }
                    } catch (Exception unused) {
                    }
                } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL)) {
                    try {
                        d dVar3 = new d(this.f55068b);
                        dVar3.c(d.d1, dVar3.b(d.d1, 0) + 1);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        if (currentTimeMillis3 - dVar3.e() >= 60000) {
                            dVar3.b(currentTimeMillis3);
                            n.a(this.f55068b).b(101);
                        }
                    } catch (Exception unused2) {
                    }
                } else if (TextUtils.isEmpty(this.a.getStringExtra("from_plugin_apk")) && (c2 = o.c()) != null) {
                    List<p> a = c2.a();
                    if (a == null && a.size() == 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < a.size(); i2++) {
                        p pVar = a.get(i2);
                        if (pVar != null && pVar.r != null) {
                            for (int i3 = 0; i3 < pVar.r.size(); i3++) {
                                try {
                                    r rVar = pVar.r.get(i3);
                                    if (rVar != null && rVar.f55273d.match(this.a.getAction(), this.a.getType(), this.a.getScheme(), this.a.getData(), this.a.getCategories(), "WR") >= 0) {
                                        Class<?> loadClass = pVar.f55243g.loadClass(rVar.f55271b);
                                        loadClass.getDeclaredMethod(rVar.f55272c, Context.class, Intent.class).invoke(loadClass.newInstance(), this.f55068b.getApplicationContext(), this.a);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55067b = -1;
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
