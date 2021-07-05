package d.a.q0.n.i.i.g;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f<T> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f53980e;

    /* renamed from: f  reason: collision with root package name */
    public T f53981f;

    /* renamed from: g  reason: collision with root package name */
    public File f53982g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f53983h;

    /* renamed from: i  reason: collision with root package name */
    public c<T> f53984i;
    public boolean j;

    public f(e eVar, T t, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, t, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53983h = new AtomicBoolean(false);
        this.f53980e = eVar;
        this.f53981f = t;
        this.f53984i = cVar;
    }

    public final void a(int i2, d.a.q0.n.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, eVar) == null) || eVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (i2 == 2200) {
            i2 = 0;
        } else {
            try {
                jSONObject.put("response", eVar.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (eVar instanceof d.a.q0.n.h.f) {
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, eVar.f53938g);
        }
        d.a.q0.n.m.a.a(eVar.f53939h, "pkg_download", null, i2, jSONObject);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            d.a.q0.n.h.e eVar = this.f53980e.f53979b;
            if (eVar.f53936e != i2) {
                eVar.f53936e = i2;
                if (i2 != 2 && i2 != 3 && i2 != 10) {
                    r(false);
                } else {
                    r(true);
                }
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.f53980e.f53979b.f53932a)) {
                File b2 = d.a.q0.n.o.d.b(this.f53984i.d(this.f53981f), this.f53980e.f53979b.l);
                this.f53982g = b2;
                if (b2 == null) {
                    this.f53982g = d.a.q0.n.o.d.b(d.a.q0.m.b.b().getAppContext().getCacheDir().getAbsolutePath(), this.f53980e.f53979b.l);
                }
                File file = this.f53982g;
                if (file == null) {
                    this.f53984i.e(this.f53981f, new d.a.q0.n.h.a(2203, ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH));
                    return false;
                }
                this.f53980e.f53979b.f53932a = file.getAbsolutePath();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d(f<T> fVar) {
        InterceptResult invokeL;
        e eVar;
        d.a.q0.n.h.e eVar2;
        e eVar3;
        d.a.q0.n.h.e eVar4;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fVar)) == null) ? (fVar == null || (eVar = fVar.f53980e) == null || (eVar2 = eVar.f53979b) == null || (eVar3 = this.f53980e) == null || (eVar4 = eVar3.f53979b) == null || !eVar4.equals(eVar2)) ? false : true : invokeL.booleanValue;
    }

    public d.a.q0.n.f.c<T> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f53984i : (d.a.q0.n.f.c) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (super.equals(obj)) {
                return true;
            }
            if (obj != null && (obj instanceof f)) {
                return d((f) obj);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f53981f : (T) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new d.a.q0.n.i.i.d.a().a(this.f53984i.k()).intValue() : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f53980e.f53979b.f53936e : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Objects.hash(this.f53980e.f53979b) : invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            String d2 = this.f53984i.d(this.f53981f);
            if (d2 == null) {
                return false;
            }
            try {
                StatFs statFs = new StatFs(d2);
                return Build.VERSION.SDK_INT >= 18 ? statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong() > j : ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) > j;
            } catch (Throwable th) {
                if (d.a.q0.n.c.f53910a) {
                    Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": path exception or no space left." + th.toString());
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f53984i.a(this.f53981f);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b(3);
            this.f53984i.e(this.f53981f, this.f53980e.f53978a);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b(10);
            this.f53984i.i(this.f53981f);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d.a.q0.n.c.f53910a) {
                Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": onNotifyPending" + this);
            }
            this.j = true;
            r(true);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b(1);
            this.f53984i.c(this.f53981f);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b(2);
            this.f53984i.j(this.f53981f);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (d.a.q0.n.c.f53910a) {
                Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": onResetPending" + this);
            }
            if (z) {
                this.f53980e.f53979b.f53933b = 0L;
            }
            b(0);
            r(false);
            this.j = false;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.f53983h.get() == z) {
            return;
        }
        this.f53983h.set(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048596, this) != null) {
            return;
        }
        if (d.a.q0.n.c.f53910a) {
            Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": run:" + this.f53980e.f53979b.n);
        }
        j jVar = new j(this);
        while (true) {
            d.a.q0.n.h.a aVar = this.f53980e.f53978a;
            if (aVar != null && aVar.f53928a == 2200) {
                return;
            }
            if (this.f53983h.get()) {
                if (d.a.q0.n.c.f53910a) {
                    Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": stopped:" + this.f53980e.f53979b.n);
                }
                p();
                return;
            }
            jVar.b();
            d.a.q0.n.h.a aVar2 = this.f53980e.f53978a;
            if (aVar2 != null) {
                if (aVar2.f53928a != 2200) {
                    if (this.f53983h.get()) {
                        if (d.a.q0.n.c.f53910a) {
                            Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": stopped:" + this.f53980e.f53979b.n);
                        }
                        p();
                        return;
                    }
                    if (d.a.q0.n.c.f53910a) {
                        Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": retry download:" + this.f53980e.f53979b.n);
                    }
                    c<T> cVar = this.f53984i;
                    int i2 = cVar.f53975f + 1;
                    cVar.f53975f = i2;
                    if (i2 < 3) {
                        try {
                            if (!this.f53983h.get()) {
                                Thread.sleep(this.f53984i.f53975f * 1000);
                            }
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        l();
                        e eVar = this.f53980e;
                        a(eVar.f53978a.f53928a, eVar.f53979b);
                        return;
                    }
                } else {
                    if (d.a.q0.n.c.f53910a) {
                        Log.d("ThunderInfoTask", d.a.q0.n.c.b().v() + ": success download:" + this.f53980e.f53979b.n);
                    }
                    m();
                    return;
                }
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "downloadUrl:" + this.f53980e.f53979b.n + ",versionName:" + this.f53980e.f53979b.j + ",versionCode:" + this.f53980e.f53979b.f53940i + "md5:" + this.f53980e.f53979b.l + "bundleId:" + this.f53980e.f53979b.f53938g;
        }
        return (String) invokeV.objValue;
    }
}
