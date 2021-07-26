package d.a.m0.m;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m0.n.b;
import d.a.m0.q.c;
/* loaded from: classes7.dex */
public class a implements d.a.m0.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f43655c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.n.a f43656a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f43657b;

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
                return;
            }
        }
        this.f43656a = null;
        this.f43657b = false;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f43655c == null) {
                synchronized (a.class) {
                    if (f43655c == null) {
                        f43655c = new a();
                    }
                }
            }
            return f43655c;
        }
        return (a) invokeV.objValue;
    }

    @Override // d.a.m0.n.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.m0.n.a aVar = this.f43656a;
            if (aVar == null) {
                return null;
            }
            try {
                return aVar.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0004, B:7:0x0009, B:23:0x0040, B:25:0x0044, B:17:0x0024, B:18:0x0029, B:19:0x002c, B:20:0x0032, B:21:0x0038), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // d.a.m0.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, b bVar) {
        d.a.m0.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) != null) {
            return;
        }
        try {
            if (this.f43657b) {
                return;
            }
            this.f43657b = true;
            int ordinal = com.baidu.sso.r.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                aVar = null;
            } else if (ordinal == 1) {
                aVar = new d.a.m0.o.b();
            } else if (ordinal == 2) {
                aVar = new d.a.m0.r.b();
            } else if (ordinal == 3) {
                aVar = new c();
            } else if (ordinal != 4) {
                if (this.f43656a == null) {
                    this.f43656a.a(context, bVar);
                    return;
                }
                return;
            } else {
                aVar = new d.a.m0.p.b();
            }
            this.f43656a = aVar;
            if (this.f43656a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
