package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t81 a;

        /* renamed from: com.repackage.b81$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0445a extends t81 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONArray a;
            public final /* synthetic */ a b;

            public C0445a(a aVar, JSONArray jSONArray) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONArray};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = jSONArray;
            }

            @Override // com.repackage.t81
            public void a(int i, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                    t81 t81Var = this.b.a;
                    if (t81Var != null) {
                        t81Var.a(i, str);
                    }
                    if (i == 1) {
                        b81.e(this.a);
                    }
                }
            }
        }

        public a(t81 t81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t81Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c = b81.c()) == null) {
                return;
            }
            x71.d(c, new C0445a(this, c));
        }
    }

    public static synchronized JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (b81.class) {
                File file = new File(m91.a().getFilesDir(), "poly_cashier_commission_record_cache.json");
                JSONArray jSONArray = null;
                if (file.exists()) {
                    try {
                        JSONArray jSONArray2 = new JSONArray(g91.b(file));
                        try {
                            file.delete();
                        } catch (JSONException unused) {
                        }
                        jSONArray = jSONArray2;
                    } catch (JSONException unused2) {
                    }
                    return jSONArray;
                }
                return null;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void d(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
        } catch (JSONException unused) {
        }
        JSONArray c = c();
        if (c == null) {
            c = new JSONArray();
        }
        c.put(jSONObject);
        if (c.length() > 100) {
            c.remove(0);
        }
        e(c);
    }

    public static synchronized void e(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray) == null) {
            synchronized (b81.class) {
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        g91.d(jSONArray.toString(), new File(m91.a().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                    }
                }
            }
        }
    }

    public static void f(t81 t81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, t81Var) == null) {
            a91.a(new a(t81Var));
        }
    }
}
