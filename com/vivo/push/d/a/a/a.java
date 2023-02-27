package com.vivo.push.d.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.u;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;
    public String b;
    public long c;
    public int d;
    public h e;
    public boolean f;
    public a g;

    public abstract int a(T t);

    public a(String str, T t, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, t, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1L;
        this.d = -1;
        this.f = false;
        this.b = str;
        this.a = t;
        this.e = hVar;
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.d = a((a<T>) this.a);
            this.c = System.currentTimeMillis() - currentTimeMillis;
            int i = this.d;
            if (i != 0) {
                h hVar = this.e;
                if (hVar != null) {
                    hVar.a(this, this.a, i);
                    return;
                }
                return;
            }
            a aVar = this.g;
            if (aVar != null) {
                aVar.a();
                return;
            }
            h hVar2 = this.e;
            if (hVar2 != null) {
                hVar2.a((h) this.a);
            }
        }
    }

    public synchronized String b() {
        InterceptResult invokeV;
        String jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("name", this.b);
                    jSONObject2.put("code", this.d);
                    jSONObject2.put("cost", this.c);
                } catch (Exception e) {
                    u.a("AbstractMessageNodeMoni", e);
                }
                jSONObject = jSONObject2.toString();
            }
            return jSONObject;
        }
        return (String) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f) {
                com.vivo.push.util.g.a().execute(new b(this));
            } else {
                d();
            }
        }
    }

    public final JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (a<T> aVar = this; aVar != null; aVar = aVar.g) {
                try {
                    jSONArray.put(aVar.b());
                } catch (Exception e) {
                    u.a("AbstractMessageNodeMoni", e);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) && this != aVar) {
            this.g = aVar;
        }
    }
}
