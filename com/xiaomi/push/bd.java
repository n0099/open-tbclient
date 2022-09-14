package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.bb;
/* loaded from: classes8.dex */
public class bd implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ bb.b f137a;

    public bd(bb.b bVar, IBinder iBinder) {
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
        this.f137a = bVar;
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
        String b;
        Object obj5;
        Object obj6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                context = this.f137a.a.f132a;
                String packageName = context.getPackageName();
                b = this.f137a.a.b();
                bb.a aVar = new bb.a(this.f137a.a, null);
                aVar.f136a = bb.c.a(this.a, packageName, b, "GUID");
                aVar.b = bb.c.a(this.a, packageName, b, "OUID");
                aVar.c = bb.c.a(this.a, packageName, b, "DUID");
                aVar.d = bb.c.a(this.a, packageName, b, "AUID");
                this.f137a.a.f134a = aVar;
                this.f137a.a.m193b();
                this.f137a.a.f131a = 2;
                obj5 = this.f137a.a.f135a;
                synchronized (obj5) {
                    try {
                        obj6 = this.f137a.a.f135a;
                        obj6.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                this.f137a.a.m193b();
                this.f137a.a.f131a = 2;
                obj3 = this.f137a.a.f135a;
                synchronized (obj3) {
                    try {
                        obj4 = this.f137a.a.f135a;
                        obj4.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                this.f137a.a.m193b();
                this.f137a.a.f131a = 2;
                obj = this.f137a.a.f135a;
                synchronized (obj) {
                    try {
                        obj2 = this.f137a.a.f135a;
                        obj2.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }
    }
}
