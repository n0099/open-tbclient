package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x92;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class y92 implements pb4<JSONArray> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public final z92 a;
    public final String b;
    public h94 c;
    public h94 d;
    public ac3 e;
    public boolean f;
    public boolean g;
    public final Collection<af3<y92>> h;
    public final Collection<af3<y92>> i;
    public x92.b j;

    /* loaded from: classes7.dex */
    public class a implements Function1<ac3, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y92 a;

        public a(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(ac3 ac3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ac3Var)) == null) {
                if (y92.k) {
                    Log.i("SoUpdating", "install: " + this.a.k() + " onCallback");
                }
                this.a.i(ac3Var);
                this.a.f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755187041, "Lcom/repackage/y92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755187041, "Lcom/repackage/y92;");
                return;
            }
        }
        k = rg1.a;
    }

    public y92(@NonNull z92 z92Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z92Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = new HashSet();
        this.i = new HashSet();
        this.j = null;
        this.a = z92Var;
        this.b = str;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.h.clear();
                this.i.clear();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pb4
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            h94 l = l();
            if (k) {
                Log.i("SoUpdating", "decorateParams libName=" + this.b + " localSo=" + l);
            }
            try {
                Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
                while (it.hasNext()) {
                    AbiType next = it.next();
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop abi=" + next);
                    }
                    if (next != null) {
                        dd4 d = dd4.d(this.b, next);
                        if (k) {
                            Log.i("SoUpdating", "decorateParams loop bundleId=" + d);
                        }
                        if (d != null) {
                            JSONObject jSONObject = new JSONObject();
                            boolean z = l != null && next == l.q;
                            long j = (l == null || !z) ? 0L : l.i;
                            String str = "0";
                            String str2 = (l == null || !z) ? "0" : l.j;
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d.b);
                            jSONObject.put("version_code", j);
                            jSONObject.put("version_name", str);
                            if (k) {
                                Log.i("SoUpdating", "decorate abi=" + next + " jo=" + jSONObject);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e) {
                if (k) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized y92 g(af3<y92> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, af3Var)) == null) {
            synchronized (this) {
                this.h.remove(af3Var);
            }
            return this;
        }
        return (y92) invokeL.objValue;
    }

    public synchronized y92 h(af3<y92> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, af3Var)) == null) {
            synchronized (this) {
                this.i.remove(af3Var);
            }
            return this;
        }
        return (y92) invokeL.objValue;
    }

    public final synchronized y92 i(ac3 ac3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ac3Var)) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "finish: " + k() + " finished=" + this.g + " error=" + ac3Var);
                }
                if (this.g) {
                    return this;
                }
                this.g = true;
                this.e = ac3Var;
                if (ac3Var == null) {
                    w92.d.v(k(), System.currentTimeMillis());
                }
                w92.d.f(k());
                t();
                e();
                return this;
            }
        }
        return (y92) invokeL.objValue;
    }

    public h94 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (h94) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public h94 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c == null && !TextUtils.isEmpty(this.b)) {
                this.c = c84.i().t(this.b);
            }
            return this.c;
        }
        return (h94) invokeV.objValue;
    }

    public x92.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (x92.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? n() && (this.e == null || w92.d.k(k())) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            h94 h94Var = this.d;
            return (h94Var == null || h94Var == this.c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "install: " + k() + " finished=" + this.g + " installing=" + this.f);
                }
                if (!this.g && !this.f) {
                    this.f = true;
                    if (k) {
                        Log.i("SoUpdating", "install: " + k());
                    }
                    w92.d.x(k(), new a(this));
                }
            }
        }
    }

    public boolean r(z92 z92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, z92Var)) == null) ? z92Var != null && z92Var == this.a : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !n() && this.f : invokeV.booleanValue;
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.h.size());
                }
                this.g = true;
                for (af3<y92> af3Var : this.h) {
                    if (af3Var != null) {
                        af3Var.a(this);
                    }
                }
            }
        }
    }

    public synchronized y92 u(af3<y92> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, af3Var)) == null) {
            synchronized (this) {
                this.h.add(af3Var);
            }
            return this;
        }
        return (y92) invokeL.objValue;
    }

    public synchronized y92 v(af3<y92> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, af3Var)) == null) {
            synchronized (this) {
                this.i.add(af3Var);
            }
            return this;
        }
        return (y92) invokeL.objValue;
    }

    public y92 w(z92 z92Var, h94 h94Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, z92Var, h94Var)) == null) {
            if (r(z92Var)) {
                this.d = h94Var;
            }
            return this;
        }
        return (y92) invokeLL.objValue;
    }

    public synchronized void x(x92.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.g && bVar != null && 0 != bVar.b) {
                    this.j = bVar;
                    for (af3<y92> af3Var : this.i) {
                        if (af3Var != null) {
                            af3Var.a(this);
                        }
                    }
                }
            }
        }
    }
}
