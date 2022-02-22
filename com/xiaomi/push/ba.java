package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ay;
/* loaded from: classes4.dex */
public class ba implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ay.b f152a;

    public ba(ay.b bVar, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, iBinder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f152a = bVar;
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
                context = this.f152a.a.f145a;
                String packageName = context.getPackageName();
                e2 = this.f152a.a.e();
                ay.a aVar = new ay.a(this.f152a.a, null);
                aVar.f149a = ay.c.a(this.a, packageName, e2, "GUID");
                aVar.f61135b = ay.c.a(this.a, packageName, e2, "OUID");
                aVar.f61136c = ay.c.a(this.a, packageName, e2, "DUID");
                aVar.f61137d = ay.c.a(this.a, packageName, e2, "AUID");
                this.f152a.a.f147a = aVar;
                this.f152a.a.b();
                this.f152a.a.f144a = 2;
                obj5 = this.f152a.a.f148a;
                synchronized (obj5) {
                    try {
                        obj6 = this.f152a.a.f148a;
                        obj6.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                this.f152a.a.b();
                this.f152a.a.f144a = 2;
                obj3 = this.f152a.a.f148a;
                synchronized (obj3) {
                    try {
                        obj4 = this.f152a.a.f148a;
                        obj4.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                this.f152a.a.b();
                this.f152a.a.f144a = 2;
                obj = this.f152a.a.f148a;
                synchronized (obj) {
                    try {
                        obj2 = this.f152a.a.f148a;
                        obj2.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }
    }
}
