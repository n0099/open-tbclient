package com.repackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x20;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class u20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u20 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public x20 b;
    public y20 c;

    /* loaded from: classes7.dex */
    public class a implements x20.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ u20 b;

        public a(u20 u20Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u20Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u20Var;
            this.a = dVar;
        }

        @Override // com.repackage.x20.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x20.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(new m50(this.b.a, jSONArray.getJSONObject(i).getString("pkg")));
                    }
                } catch (Exception unused) {
                }
                this.a.b(arrayList, bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements x20.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(u20 u20Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u20Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.repackage.x20.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x20.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.a.b(e.a(str), bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements x20.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(u20 u20Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u20Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // com.repackage.x20.c
        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                this.a.a(i, exc, bundle);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.x20.c
        /* renamed from: b */
        public void onResult(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                this.a.b(str, bundle);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d<T> extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w20<T> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w20<T> w20Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w20Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w20Var;
        }

        public void a(int i, Exception exc, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, exc, bundle) == null) {
                obtainMessage(1, i, 0, Pair.create(exc, bundle)).sendToTarget();
            }
        }

        public void b(T t, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t, bundle) == null) {
                obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.repackage.w20<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
                int i = message.what;
                if (i == 0) {
                    Pair pair = (Pair) message.obj;
                    this.a.onResult(pair.first, (Bundle) pair.second);
                } else if (i != 1) {
                } else {
                    Pair pair2 = (Pair) message.obj;
                    this.a.onError(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<f> a;

        public e(List<f> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.addAll(list);
        }

        public static e a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        arrayList.add(new f(jSONObject.getString("pkg"), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                    }
                    return new e(arrayList);
                } catch (JSONException unused) {
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public List<f> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "sids {" + this.a + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;
        public final long c;

        public f(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "aid {packageName='" + this.a + "', aid='" + this.b + "', priority=" + this.c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public u20(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        y20 y20Var = new y20(new u50());
        this.c = y20Var;
        this.b = y20Var.a();
        x20.a aVar = new x20.a();
        aVar.a = new w50();
        aVar.b = new v50();
        aVar.c = this.a;
        aVar.d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        aVar.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.b.b(aVar);
        this.b.c(new x20.b());
    }

    public static synchronized u20 e(Context context) {
        InterceptResult invokeL;
        u20 u20Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (u20.class) {
                if (d == null) {
                    d = new u20(context.getApplicationContext());
                }
                u20Var = d;
            }
            return u20Var;
        }
        return (u20) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.g("aid", null).a : (String) invokeV.objValue;
    }

    public x20 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (x20) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.g("iid", null).a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b.g("oid", null).a : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b.g("ssaid", null).a : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b.e(this.a.getPackageName()) : invokeV.booleanValue;
    }

    public void i(w20<l50> w20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, w20Var, looper) == null) {
            new d(w20Var, looper).b(new l50(), new Bundle());
        }
    }

    public void j(w20<String> w20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, w20Var) == null) {
            k("gaid", w20Var, Looper.getMainLooper());
        }
    }

    public final void k(String str, w20<String> w20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, w20Var, looper) == null) {
            this.b.a(str, null, new c(this, new d(w20Var, looper)));
        }
    }

    public void l(w20<String> w20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, w20Var) == null) {
            k("oid", w20Var, Looper.getMainLooper());
        }
    }

    public void m(w20<List<m50>> w20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, w20Var, looper) == null) {
            this.b.a("sids", null, new a(this, new d(w20Var, looper)));
        }
    }

    public void n(w20<e> w20Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, w20Var) == null) {
            o(w20Var, Looper.getMainLooper());
        }
    }

    public void o(w20<e> w20Var, Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, w20Var, looper) == null) {
            this.b.a("sids", null, new b(this, new d(w20Var, looper)));
        }
    }
}
