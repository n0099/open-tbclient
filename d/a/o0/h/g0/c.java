package d.a.o0.h.g0;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.p.b.a.l;
import d.a.o0.a.q2.c;
import d.a.o0.a.r0.n;
import d.a.o0.h.s.a;
import java.io.File;
import java.util.Set;
@Singleton
@Service
/* loaded from: classes7.dex */
public class c implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50512c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f50513a;

    /* renamed from: b  reason: collision with root package name */
    public File f50514b;

    /* loaded from: classes7.dex */
    public class a implements c.a<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f50515a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50515a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.q2.c.a
        /* renamed from: a */
        public Long update() throws IllegalStateException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Long.valueOf(this.f50515a.m()) : (Long) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1868370418, "Ld/a/o0/h/g0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1868370418, "Ld/a/o0/h/g0/c;");
                return;
            }
        }
        f50512c = k.f46335a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        String o = o();
        if (f50512c) {
            Log.i("SwanGameStorageManager", "preferencesName:" + o);
        }
        if (o != null) {
            this.f50513a = d.a.o0.a.c1.a.b().getSharedPreferences(o, 0);
            File q = q();
            this.f50514b = new File(q, o + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        }
        d.a.o0.a.q2.d.f47365h.e(new a(this));
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            l(String.format("aigame_storage_%s_anonymous", str, ""));
        }
    }

    public static void l(String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || str == null || !str.startsWith("aigame_storage_") || (listFiles = q().listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith(str)) {
                d.a.o0.t.d.K(file);
            }
        }
    }

    @NonNull
    public static File q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs") : (File) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.b.a.l
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? n.U(str) : (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.p.b.a.l
    public d.a.o0.a.n0.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new d.a.o0.h.g0.a() : (d.a.o0.a.n0.c) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.b.a.l
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n.c();
        }
    }

    @Override // d.a.o0.a.p.b.a.l
    public File[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? q().listFiles() : (File[]) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.b.a.l
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? n.n() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.b.a.l
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String I = d.a.o0.t.d.I(d.a.o0.h.s.a.d());
            String I2 = d.a.o0.t.d.I(a.d.g());
            g();
            c();
            d.a.o0.t.d.j(I);
            d.a.o0.t.d.j(I2);
        }
    }

    @Override // d.a.o0.a.p.b.a.l
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l("aigame_storage_");
        }
    }

    @Override // d.a.o0.a.p.b.a.l
    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? n.V(str) : (String) invokeL.objValue;
    }

    @Override // d.a.o0.a.p.b.a.l
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.o0.a.r0.k.c();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? r() && this.f50513a.edit().clear().commit() : invokeV.booleanValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            File file = this.f50514b;
            if (file != null) {
                return file.length();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String[] n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (r()) {
                Set<String> keySet = this.f50513a.getAll().keySet();
                String[] strArr = new String[keySet.size()];
                keySet.toArray(strArr);
                return strArr;
            }
            return new String[0];
        }
        return (String[]) invokeV.objValue;
    }

    @Nullable
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String V = d.a.o0.a.a2.e.V();
            if (TextUtils.isEmpty(V)) {
                return null;
            }
            return String.format("aigame_storage_%s_anonymous", V);
        }
        return (String) invokeV.objValue;
    }

    public String p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            if (r()) {
                return this.f50513a.getString(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f50513a != null : invokeV.booleanValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? Config.FULL_TRACE_LOG_LIMIT : invokeV.longValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, str, str2)) == null) ? r() && this.f50513a.edit().putString(str, str2).commit() : invokeLL.booleanValue;
    }

    @SuppressLint({"ApplySharedPref"})
    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? r() && this.f50513a.edit().remove(str).commit() : invokeL.booleanValue;
    }
}
