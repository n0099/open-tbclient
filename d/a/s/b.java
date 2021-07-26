package d.a.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.d.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f67704d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67705a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s.d.a f67706b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s.d.b f67707c;

    /* loaded from: classes8.dex */
    public class a implements a.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67708a;

        public a(b bVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67708a = cVar;
        }

        @Override // d.a.s.d.a.c
        public void b(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, exc, bundle) == null) {
                this.f67708a.a(i2, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
                this.f67708a.b(d.a(str), bundle);
            }
        }
    }

    /* renamed from: d.a.s.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1891b implements a.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f67709a;

        public C1891b(b bVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67709a = cVar;
        }

        @Override // d.a.s.d.a.c
        public void b(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, exc, bundle) == null) {
                this.f67709a.a(i2, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.s.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
                this.f67709a.b(str, bundle);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c<T> extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.s.c<T> f67710a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d.a.s.c<T> cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, looper};
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
            this.f67710a = cVar;
        }

        public void a(int i2, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, exc, bundle) == null) {
                obtainMessage(1, i2, 0, Pair.create(exc, bundle)).sendToTarget();
            }
        }

        public void b(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: d.a.s.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    Pair pair = (Pair) message.obj;
                    this.f67710a.a(pair.first, (Bundle) pair.second);
                } else if (i2 != 1) {
                } else {
                    Pair pair2 = (Pair) message.obj;
                    this.f67710a.b(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<e> f67711a;

        public d(List<e> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f67711a = arrayList;
            arrayList.addAll(list);
        }

        public static d a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        arrayList.add(new e(jSONObject.getString("pkg"), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                    }
                    return new d(arrayList);
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (d) invokeL.objValue;
        }

        public List<e> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67711a : (List) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "sids {" + this.f67711a + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f67712a;

        /* renamed from: b  reason: collision with root package name */
        public final String f67713b;

        /* renamed from: c  reason: collision with root package name */
        public final long f67714c;

        public e(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67712a = str;
            this.f67713b = str2;
            this.f67714c = j;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "aid {packageName='" + this.f67712a + "', aid='" + this.f67713b + "', priority=" + this.f67714c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67705a = context.getApplicationContext();
        d.a.s.d.b bVar = new d.a.s.d.b(new d.a.s.i.a());
        this.f67707c = bVar;
        this.f67706b = bVar.a();
        a.C1892a c1892a = new a.C1892a();
        c1892a.f67717a = new d.a.s.i.c();
        c1892a.f67718b = new d.a.s.i.b();
        c1892a.f67719c = this.f67705a;
        c1892a.f67720d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c1892a.f67721e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f67706b.b(c1892a);
        this.f67706b.c(new a.b());
    }

    public static synchronized b d(Context context) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (b.class) {
                if (f67704d == null) {
                    f67704d = new b(context.getApplicationContext());
                }
                bVar = f67704d;
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67706b.f("aid", null).f67722a : (String) invokeV.objValue;
    }

    public d.a.s.d.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67706b : (d.a.s.d.a) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f67706b.f(CommonUrlParamManager.PARAM_IID, null).f67722a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67706b.f("oid", null).f67722a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67706b.f("ssaid", null).f67722a : (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67706b.d(this.f67705a.getPackageName()) : invokeV.booleanValue;
    }

    public void h(d.a.s.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            i("gaid", cVar, Looper.getMainLooper());
        }
    }

    public final void i(String str, d.a.s.c<String> cVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, cVar, looper) == null) {
            this.f67706b.a(str, null, new C1891b(this, new c(cVar, looper)));
        }
    }

    public void j(d.a.s.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            i("oid", cVar, Looper.getMainLooper());
        }
    }

    public void k(d.a.s.c<d> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            l(cVar, Looper.getMainLooper());
        }
    }

    public void l(d.a.s.c<d> cVar, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, cVar, looper) == null) {
            this.f67706b.a("sids", null, new a(this, new c(cVar, looper)));
        }
    }
}
