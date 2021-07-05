package d.d.a.a.b;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f72012a;

    /* renamed from: b  reason: collision with root package name */
    public int f72013b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f72014c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f72015d;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72016a;

        /* renamed from: b  reason: collision with root package name */
        public String f72017b;

        public b() {
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
    }

    /* loaded from: classes10.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static h f72018a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1909317505, "Ld/d/a/a/b/h$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1909317505, "Ld/d/a/a/b/h$c;");
                    return;
                }
            }
            f72018a = new h(null);
        }
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f72018a : (h) invokeV.objValue;
    }

    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && "normal_log".equals(str)) {
            this.f72013b = i2;
        }
    }

    public void c(j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) || jVar == null) {
            return;
        }
        synchronized (this.f72014c) {
            try {
                this.f72012a.put(this.f72012a.length(), jVar.b());
            } catch (JSONException unused) {
            }
            e(d.d.a.a.a.e().f().isForceToSend(jVar.f72022a));
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && "normal_log".equals(str)) {
            synchronized (this.f72014c) {
                i();
            }
            e(false);
        }
    }

    public final void e(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this.f72014c) {
                if (this.f72012a.length() == 0) {
                    e.g(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", "", false);
                    return;
                }
                String jSONArray = this.f72012a.toString();
                try {
                    i2 = jSONArray.getBytes().length;
                } catch (Throwable th) {
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        return;
                    }
                    i2 = 0;
                }
                if (i2 == 0) {
                    return;
                }
                if (204800 > i2) {
                    e.g(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json", jSONArray, false);
                }
                if (i2 >= 204800 || z) {
                    d.h().i("normal_log");
                }
            }
        }
    }

    public b f(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            b bVar = new b();
            synchronized (this.f72015d) {
                try {
                    d.d.a.a.b.a f2 = d.d.a.a.a.e().f();
                    jSONObject = f2 != null ? new JSONObject(f2.getHeader()) : null;
                } catch (JSONException unused) {
                    return bVar;
                }
            }
            if (jSONObject == null) {
                return bVar;
            }
            synchronized (this.f72014c) {
                try {
                    jSONObject.put("array", this.f72012a);
                    bVar.f72016a = this.f72012a.length();
                    bVar.f72017b = jSONObject.toString();
                } catch (JSONException unused2) {
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.f72014c) {
                z = this.f72012a.length() == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && e.i(d.d.a.a.a.c(), false, "f509cd1137cc45e510496d1c174306a6.json")) {
            String c2 = e.c(false, d.d.a.a.a.c(), "f509cd1137cc45e510496d1c174306a6.json");
            if (TextUtils.isEmpty(c2) || c2.getBytes().length > 409600) {
                return;
            }
            try {
                synchronized (this.f72014c) {
                    this.f72012a = new JSONArray(c2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void i() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i2 = this.f72013b) <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    this.f72012a.remove(0);
                    i2 = i3;
                } else {
                    this.f72013b = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField(SavedStateHandle.VALUES);
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f72012a);
                int i4 = this.f72013b;
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i4 = i5;
                    } else {
                        this.f72013b = 0;
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public h() {
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
        this.f72012a = new JSONArray();
        this.f72013b = 0;
        this.f72014c = new byte[0];
        this.f72015d = new byte[0];
    }
}
