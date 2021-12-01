package com.kuaishou.weapon;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.l1;
import com.kuaishou.weapon.un.o;
import com.kuaishou.weapon.un.p;
import com.kuaishou.weapon.un.t1;
/* loaded from: classes2.dex */
public class WeaponS extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Intent a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WeaponS f56606b;

        public a(WeaponS weaponS, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {weaponS, intent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56606b = weaponS;
            this.a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String stringExtra = this.a.getStringExtra("from_plugin_apk");
                if (TextUtils.isEmpty(stringExtra)) {
                    this.f56606b.a();
                } else if (this.f56606b.getPackageName().equals(stringExtra)) {
                    WeaponS weaponS = this.f56606b;
                    weaponS.a(weaponS.getClassLoader(), this.a);
                    this.f56606b.a();
                } else {
                    o c2 = o.c();
                    if (c2 == null) {
                        this.f56606b.a();
                        return;
                    }
                    p a = c2.a(stringExtra);
                    if (a == null) {
                        this.f56606b.a();
                    } else {
                        this.f56606b.a(a.f56791g, this.a);
                    }
                }
            }
        }
    }

    public WeaponS() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                this.a--;
                if (this.a <= 0) {
                    this.a = 0;
                    stopSelf();
                }
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ClassLoader classLoader, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, classLoader, intent) == null) {
            try {
                Class<?> loadClass = classLoader.loadClass(intent.getStringExtra("call_class"));
                loadClass.getDeclaredMethod(intent.getStringExtra("call_method"), Context.class, Intent.class).invoke(loadClass.newInstance(), getApplicationContext(), intent);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, i2, i3)) == null) {
            try {
            } catch (Throwable th) {
                l1.a(th);
                a();
            }
            if (intent == null) {
                return super.onStartCommand(intent, i2, i3);
            }
            this.a++;
            t1.a().a(new a(this, intent));
            a();
            return super.onStartCommand(intent, i2, i3);
        }
        return invokeLII.intValue;
    }
}
