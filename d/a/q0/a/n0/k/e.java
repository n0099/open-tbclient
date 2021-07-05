package d.a.q0.a.n0.k;

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
import d.a.q0.a.k;
import d.a.q0.a.n0.k.d;
import d.a.q0.n.h.i;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class e implements d.a.q0.n.j.c<JSONArray> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f49591a;

    /* renamed from: b  reason: collision with root package name */
    public final String f49592b;

    /* renamed from: c  reason: collision with root package name */
    public i f49593c;

    /* renamed from: d  reason: collision with root package name */
    public i f49594d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.a.q2.a f49595e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49596f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49597g;

    /* renamed from: h  reason: collision with root package name */
    public final Collection<d.a.q0.a.v2.e1.b<e>> f49598h;

    /* renamed from: i  reason: collision with root package name */
    public final Collection<d.a.q0.a.v2.e1.b<e>> f49599i;
    public d.b j;

    /* loaded from: classes8.dex */
    public class a implements Function1<d.a.q0.a.q2.a, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f49600e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49600e = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(d.a.q0.a.q2.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (e.k) {
                    Log.i("SoUpdating", "install: " + this.f49600e.k() + " onCallback");
                }
                this.f49600e.i(aVar);
                this.f49600e.f49596f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1735591278, "Ld/a/q0/a/n0/k/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1735591278, "Ld/a/q0/a/n0/k/e;");
                return;
            }
        }
        k = k.f49133a;
    }

    public e(@NonNull f fVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49593c = null;
        this.f49594d = null;
        this.f49595e = null;
        this.f49596f = false;
        this.f49597g = false;
        this.f49598h = new HashSet();
        this.f49599i = new HashSet();
        this.j = null;
        this.f49591a = fVar;
        this.f49592b = str;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f49598h.clear();
                this.f49599i.clear();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.n.j.c
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            i l = l();
            if (k) {
                Log.i("SoUpdating", "decorateParams libName=" + this.f49592b + " localSo=" + l);
            }
            try {
                Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
                while (it.hasNext()) {
                    AbiType next = it.next();
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop abi=" + next);
                    }
                    if (next != null) {
                        d.a.q0.n.l.a d2 = d.a.q0.n.l.a.d(this.f49592b, next);
                        if (k) {
                            Log.i("SoUpdating", "decorateParams loop bundleId=" + d2);
                        }
                        if (d2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            boolean z = l != null && next == l.q;
                            long j = (l == null || !z) ? 0L : l.f53940i;
                            String str = "0";
                            String str2 = (l == null || !z) ? "0" : l.j;
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d2.f54110b);
                            jSONObject.put("version_code", j);
                            jSONObject.put("version_name", str);
                            if (k) {
                                Log.i("SoUpdating", "decorate abi=" + next + " jo=" + jSONObject);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e2) {
                if (k) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public synchronized e g(d.a.q0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            synchronized (this) {
                this.f49598h.remove(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e h(d.a.q0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            synchronized (this) {
                this.f49599i.remove(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public final synchronized e i(d.a.q0.a.q2.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "finish: " + k() + " finished=" + this.f49597g + " error=" + aVar);
                }
                if (this.f49597g) {
                    return this;
                }
                this.f49597g = true;
                this.f49595e = aVar;
                if (aVar == null) {
                    c.f49579d.v(k(), System.currentTimeMillis());
                }
                c.f49579d.f(k());
                t();
                e();
                return this;
            }
        }
        return (e) invokeL.objValue;
    }

    public i j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f49594d : (i) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49592b : (String) invokeV.objValue;
    }

    public i l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f49593c == null && !TextUtils.isEmpty(this.f49592b)) {
                this.f49593c = d.a.q0.n.g.a.h().r(this.f49592b);
            }
            return this.f49593c;
        }
        return (i) invokeV.objValue;
    }

    public d.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (d.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f49597g : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? n() && (this.f49595e == null || c.f49579d.k(k())) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            i iVar = this.f49594d;
            return (iVar == null || iVar == this.f49593c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "install: " + k() + " finished=" + this.f49597g + " installing=" + this.f49596f);
                }
                if (!this.f49597g && !this.f49596f) {
                    this.f49596f = true;
                    if (k) {
                        Log.i("SoUpdating", "install: " + k());
                    }
                    c.f49579d.x(k(), new a(this));
                }
            }
        }
    }

    public boolean r(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) ? fVar != null && fVar == this.f49591a : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !n() && this.f49596f : invokeV.booleanValue;
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.f49598h.size());
                }
                this.f49597g = true;
                for (d.a.q0.a.v2.e1.b<e> bVar : this.f49598h) {
                    if (bVar != null) {
                        bVar.onCallback(this);
                    }
                }
            }
        }
    }

    public synchronized e u(d.a.q0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bVar)) == null) {
            synchronized (this) {
                this.f49598h.add(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public synchronized e v(d.a.q0.a.v2.e1.b<e> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bVar)) == null) {
            synchronized (this) {
                this.f49599i.add(bVar);
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public e w(f fVar, i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, fVar, iVar)) == null) {
            if (r(fVar)) {
                this.f49594d = iVar;
            }
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public synchronized void x(d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.f49597g && bVar != null && 0 != bVar.f49590b) {
                    this.j = bVar;
                    for (d.a.q0.a.v2.e1.b<e> bVar2 : this.f49599i) {
                        if (bVar2 != null) {
                            bVar2.onCallback(this);
                        }
                    }
                }
            }
        }
    }
}
