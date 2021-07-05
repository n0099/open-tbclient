package d.a.s0.q2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f64971a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64972b;

    /* renamed from: c  reason: collision with root package name */
    public int f64973c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64974d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.s0.p2.b> f64975e;

    /* loaded from: classes9.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                d.a.s0.x1.d.a(d.a.s0.x1.f.f69412b);
                d.a.s0.x1.d.a(d.a.s0.x1.f.f69413c);
                d.a.s0.x1.d.a(d.a.s0.x1.f.f69414d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<l, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(l... lVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVarArr)) == null) {
                if (lVarArr == null || lVarArr.length != 1 || lVarArr[0] == null) {
                    return null;
                }
                l lVar = lVarArr[0];
                synchronized ("debug") {
                    File file = new File(d.a.s0.x1.f.f69415e + d.a.s0.x1.f.f69411a + lVar.f64977b + d.a.s0.x1.f.f69411a + "debug");
                    StringBuilder sb = new StringBuilder();
                    sb.append(lVar.f64976a.a().toString());
                    sb.append("\n");
                    d.a.s0.x1.d.g(file, sb.toString(), true);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<e, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(e... eVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVarArr)) == null) {
                if (eVarArr == null || eVarArr.length != 1 || eVarArr[0] == null) {
                    return null;
                }
                e eVar = eVarArr[0];
                synchronized ("kpi") {
                    d.a.s0.x1.d.g(new File(d.a.s0.x1.f.f69415e + d.a.s0.x1.f.f69411a + eVar.f64946d + d.a.s0.x1.f.f69411a + "kpi"), k.e(eVar.f64943a, eVar.f64944b, eVar.f64945c).toString(), false);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-629049231, "Ld/a/s0/q2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-629049231, "Ld/a/s0/q2/k;");
                return;
            }
        }
        if (d.a.c.e.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }

    public k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64972b = true;
        this.f64973c = 0;
        this.f64974d = false;
        this.f64971a = str;
        this.f64975e = new ArrayList();
    }

    public static final JSONObject e(boolean z, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            int i3 = 1;
            try {
                jSONObject.put("postSuccess", (z2 && z) ? 1 : 0);
                jSONObject.put("errorTimes", i2);
                if (!z2) {
                    i3 = 0;
                }
                jSONObject.put("posted", i3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void a(d.a.s0.p2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f64975e.add(bVar);
            c();
            m(bVar);
            l();
        }
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!ListUtils.isEmpty(this.f64975e)) {
                    int size = this.f64975e.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put(this.f64975e.get(i2).a());
                    }
                }
                jSONObject.put("running", jSONArray);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && d.a.c.e.p.f.c()) {
            File file = new File(d.a.s0.x1.f.f69415e + d.a.s0.x1.f.f69411a + this.f64971a + d.a.s0.x1.f.f69411a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e(this.f64972b, this.f64973c, this.f64974d) : (JSONObject) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f64973c++;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f64973c > 0 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64974d : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64972b = false;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f64972b = true;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f64974d = true;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && d.a.c.e.p.f.c()) {
            new c(this).execute(new e(this.f64972b, this.f64973c, this.f64974d, this.f64971a));
        }
    }

    public final void m(d.a.s0.p2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) && d.a.c.e.p.f.c() && bVar != null) {
            new b(this).execute(new l(bVar, this.f64971a));
        }
    }
}
