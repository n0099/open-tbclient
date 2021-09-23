package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ay;
/* loaded from: classes10.dex */
public class ba implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBinder f77704a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ay.b f151a;

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
        this.f151a = bVar;
        this.f77704a = iBinder;
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
                context = this.f151a.f77694a.f144a;
                String packageName = context.getPackageName();
                e2 = this.f151a.f77694a.e();
                ay.a aVar = new ay.a(this.f151a.f77694a, null);
                aVar.f148a = ay.c.a(this.f77704a, packageName, e2, "GUID");
                aVar.f77691b = ay.c.a(this.f77704a, packageName, e2, "OUID");
                aVar.f77692c = ay.c.a(this.f77704a, packageName, e2, "DUID");
                aVar.f77693d = ay.c.a(this.f77704a, packageName, e2, "AUID");
                this.f151a.f77694a.f146a = aVar;
                this.f151a.f77694a.b();
                this.f151a.f77694a.f143a = 2;
                obj5 = this.f151a.f77694a.f147a;
                synchronized (obj5) {
                    try {
                        obj6 = this.f151a.f77694a.f147a;
                        obj6.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                this.f151a.f77694a.b();
                this.f151a.f77694a.f143a = 2;
                obj3 = this.f151a.f77694a.f147a;
                synchronized (obj3) {
                    try {
                        obj4 = this.f151a.f77694a.f147a;
                        obj4.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                this.f151a.f77694a.b();
                this.f151a.f77694a.f143a = 2;
                obj = this.f151a.f77694a.f147a;
                synchronized (obj) {
                    try {
                        obj2 = this.f151a.f77694a.f147a;
                        obj2.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }
    }
}
