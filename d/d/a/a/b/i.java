package d.d.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f69576b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f69577a;

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (10001 == i2) {
                    j jVar = (j) message.obj;
                    f.a().c(d.d.a.a.a.c(), jVar.f69584f);
                    h.a().c(jVar);
                } else if (10002 != i2) {
                    if (10003 == i2) {
                        h.a().h();
                    }
                } else {
                    String str = (String) message.obj;
                    h.a().b(message.arg1, str);
                    h.a().d(str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static i f69578a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1909287745, "Ld/d/a/a/b/i$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1909287745, "Ld/d/a/a/b/i$b;");
                    return;
                }
            }
            f69578a = new i(null);
        }
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f69578a : (i) invokeV.objValue;
    }

    public void b(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            f69576b.obtainMessage(10002, i2, -1, str).sendToTarget();
        }
    }

    public void c(String str, String str2, String str3, String str4, long j) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
            if (str3 != null) {
                arrayList = new ArrayList(1);
                arrayList.add(str3);
            } else {
                arrayList = null;
            }
            d(str, str2, arrayList, null, str4, j);
        }
    }

    public void d(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, collection, map, str3, Long.valueOf(j)}) == null) || d.d.a.a.a.e().f().isIgnoreToSend(str)) {
            return;
        }
        e();
        f69576b.obtainMessage(10001, j.a(str, j, str2, k.a(), e.a(), collection, map, str3)).sendToTarget();
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f69577a) {
                return false;
            }
            this.f69577a = true;
            f69576b.sendEmptyMessage(10003);
            d.h().a();
            d.d.a.a.a.e().f().loadStrategy();
            return true;
        }
        return invokeV.booleanValue;
    }

    public i() {
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
        this.f69577a = false;
        f69576b = new a(this, g.a().b().getLooper());
    }
}
