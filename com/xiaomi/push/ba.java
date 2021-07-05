package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ay;
/* loaded from: classes8.dex */
public class ba implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBinder f42867a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ay.b f147a;

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
        this.f147a = bVar;
        this.f42867a = iBinder;
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
                context = this.f147a.f42857a.f140a;
                String packageName = context.getPackageName();
                e2 = this.f147a.f42857a.e();
                ay.a aVar = new ay.a(this.f147a.f42857a, null);
                aVar.f144a = ay.c.a(this.f42867a, packageName, e2, "GUID");
                aVar.f42854b = ay.c.a(this.f42867a, packageName, e2, "OUID");
                aVar.f42855c = ay.c.a(this.f42867a, packageName, e2, "DUID");
                aVar.f42856d = ay.c.a(this.f42867a, packageName, e2, "AUID");
                this.f147a.f42857a.f142a = aVar;
                this.f147a.f42857a.b();
                this.f147a.f42857a.f139a = 2;
                obj5 = this.f147a.f42857a.f143a;
                synchronized (obj5) {
                    try {
                        obj6 = this.f147a.f42857a.f143a;
                        obj6.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                this.f147a.f42857a.b();
                this.f147a.f42857a.f139a = 2;
                obj3 = this.f147a.f42857a.f143a;
                synchronized (obj3) {
                    try {
                        obj4 = this.f147a.f42857a.f143a;
                        obj4.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                this.f147a.f42857a.b();
                this.f147a.f42857a.f139a = 2;
                obj = this.f147a.f42857a.f143a;
                synchronized (obj) {
                    try {
                        obj2 = this.f147a.f42857a.f143a;
                        obj2.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }
    }
}
