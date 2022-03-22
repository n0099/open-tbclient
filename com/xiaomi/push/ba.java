package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ay;
/* loaded from: classes7.dex */
public class ba implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ay.b f128a;

    public ba(ay.b bVar, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, iBinder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f128a = bVar;
        this.a = iBinder;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context context;
        String e2;
        Object obj5;
        Object obj6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                context = this.f128a.a.f121a;
                String packageName = context.getPackageName();
                e2 = this.f128a.a.e();
                ay.a aVar = new ay.a(this.f128a.a, null);
                aVar.f125a = ay.c.a(this.a, packageName, e2, "GUID");
                aVar.f44104b = ay.c.a(this.a, packageName, e2, "OUID");
                aVar.f44105c = ay.c.a(this.a, packageName, e2, "DUID");
                aVar.f44106d = ay.c.a(this.a, packageName, e2, "AUID");
                this.f128a.a.f123a = aVar;
                this.f128a.a.b();
                this.f128a.a.f120a = 2;
                obj5 = this.f128a.a.f124a;
                synchronized (obj5) {
                    try {
                        obj6 = this.f128a.a.f124a;
                        obj6.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                this.f128a.a.b();
                this.f128a.a.f120a = 2;
                obj3 = this.f128a.a.f124a;
                synchronized (obj3) {
                    try {
                        obj4 = this.f128a.a.f124a;
                        obj4.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                this.f128a.a.b();
                this.f128a.a.f120a = 2;
                obj = this.f128a.a.f124a;
                synchronized (obj) {
                    try {
                        obj2 = this.f128a.a.f124a;
                        obj2.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }
    }
}
