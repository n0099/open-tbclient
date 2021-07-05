package d.a.q0.a.k2.g;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49177e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0847b f49178b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f49179c;

    /* renamed from: d  reason: collision with root package name */
    public final String f49180d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-869780720, "Ld/a/q0/a/k2/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-869780720, "Ld/a/q0/a/k2/g/b;");
                return;
            }
        }
        f49177e = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49178b = new SharedPreferences$EditorC0847b(this, null);
        this.f49180d = str;
        this.f49179c = ProcessUtils.isMainProcess() || b();
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f49179c) {
                super.clear();
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 100, "", ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    public boolean e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) ? super.getBoolean(str, z) : invokeLZ.booleanValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49179c ? super.edit() : this.f49178b : (SharedPreferences.Editor) invokeV.objValue;
    }

    public float f(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048579, this, str, f2)) == null) ? super.getFloat(str, f2) : invokeLF.floatValue;
    }

    public int g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i2)) == null) ? super.getInt(str, i2) : invokeLI.intValue;
    }

    @Override // d.a.q0.a.k2.g.g, d.a.q0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? k() ? super.getAll() : new HashMap(super.getAll()) : (Map) invokeV.objValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            try {
                if (this.f49179c) {
                    return e(str, z);
                }
                d.a.q0.a.v1.b.f b2 = d.a.q0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
                if (f49177e) {
                    Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f51225a.getBoolean("result_value"));
                }
                return b2.f51225a.getBoolean("result_value");
            } catch (ClassCastException e2) {
                Log.e("IpcSp", "getBoolean", e2);
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f2)) == null) {
            if (this.f49179c) {
                return f(str, f2);
            }
            d.a.q0.a.v1.b.f b2 = d.a.q0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
            if (f49177e) {
                Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f51225a.getFloat("result_value"));
            }
            return b2.f51225a.getFloat("result_value");
        }
        return invokeLF.floatValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            if (this.f49179c) {
                return g(str, i2);
            }
            d.a.q0.a.v1.b.f b2 = d.a.q0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
            if (f49177e) {
                Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f51225a.getInt("result_value"));
            }
            return b2.f51225a.getInt("result_value");
        }
        return invokeLI.intValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (this.f49179c) {
                return h(str, j);
            }
            d.a.q0.a.v1.b.f b2 = d.a.q0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j)));
            if (f49177e) {
                Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f51225a.getLong("result_value"));
            }
            return b2.f51225a.getLong("result_value");
        }
        return invokeLJ.longValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            if (this.f49179c) {
                return j(str, str2);
            }
            d.a.q0.a.v1.b.f b2 = d.a.q0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
            if (f49177e) {
                Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f51225a.getString("result_value"));
            }
            return b2.f51225a.getString("result_value");
        }
        return (String) invokeLL.objValue;
    }

    public long h(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, str, j)) == null) ? super.getLong(str, j) : invokeLJ.longValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f49180d : (String) invokeV.objValue;
    }

    public String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? super.getString(str, str2) : (String) invokeLL.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f49179c : invokeV.booleanValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) {
            if (this.f49179c) {
                super.putBoolean(str, z);
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048592, this, str, f2)) == null) {
            if (this.f49179c) {
                super.putFloat(str, f2);
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i2)) == null) {
            if (this.f49179c) {
                super.putInt(str, i2);
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048594, this, str, j)) == null) {
            if (this.f49179c) {
                super.edit().putLong(str, j).commit();
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j)));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            if (this.f49179c) {
                super.putString(str, str2);
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // d.a.q0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            if (this.f49179c) {
                super.remove(str);
            } else {
                d.a.q0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    /* renamed from: d.a.q0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class SharedPreferences$EditorC0847b implements SharedPreferences.Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f49181a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f49182b;

        /* renamed from: d.a.q0.a.k2.g.b$b$a */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49183e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f49184f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49185g;

            public a(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str, str2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49185g = sharedPreferences$EditorC0847b;
                this.f49183e = str;
                this.f49184f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49185g.f49182b.putString(this.f49183e, this.f49184f);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0848b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49186e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f49187f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49188g;

            public RunnableC0848b(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str, Set set) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str, set};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49188g = sharedPreferences$EditorC0847b;
                this.f49186e = str;
                this.f49187f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49188g.f49182b.putStringSet(this.f49186e, this.f49187f);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$c */
        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49189e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f49190f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49191g;

            public c(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49191g = sharedPreferences$EditorC0847b;
                this.f49189e = str;
                this.f49190f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49191g.f49182b.putInt(this.f49189e, this.f49190f);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$d */
        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49192e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f49193f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49194g;

            public d(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49194g = sharedPreferences$EditorC0847b;
                this.f49192e = str;
                this.f49193f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49194g.f49182b.putLong(this.f49192e, this.f49193f);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$e */
        /* loaded from: classes8.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49195e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f49196f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49197g;

            public e(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49197g = sharedPreferences$EditorC0847b;
                this.f49195e = str;
                this.f49196f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49197g.f49182b.putFloat(this.f49195e, this.f49196f);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$f */
        /* loaded from: classes8.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49198e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f49199f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49200g;

            public f(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49200g = sharedPreferences$EditorC0847b;
                this.f49198e = str;
                this.f49199f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49200g.f49182b.putBoolean(this.f49198e, this.f49199f);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$g */
        /* loaded from: classes8.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f49201e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49202f;

            public g(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49202f = sharedPreferences$EditorC0847b;
                this.f49201e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49202f.f49182b.remove(this.f49201e);
                }
            }
        }

        /* renamed from: d.a.q0.a.k2.g.b$b$h */
        /* loaded from: classes8.dex */
        public class h implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SharedPreferences$EditorC0847b f49203e;

            public h(SharedPreferences$EditorC0847b sharedPreferences$EditorC0847b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sharedPreferences$EditorC0847b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49203e = sharedPreferences$EditorC0847b;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49203e.f49182b.clear();
                }
            }
        }

        public SharedPreferences$EditorC0847b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49182b = bVar;
            this.f49181a = new ArrayDeque();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                commit();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e(new h(this));
                return this;
            }
            return (SharedPreferences.Editor) invokeV.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this.f49181a) {
                    while (!this.f49181a.isEmpty()) {
                        Runnable poll = this.f49181a.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public final SharedPreferences$EditorC0847b e(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, runnable)) == null) {
                synchronized (this.f49181a) {
                    this.f49181a.offer(runnable);
                }
                return this;
            }
            return (SharedPreferences$EditorC0847b) invokeL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) {
                e(new f(this, str, z));
                return this;
            }
            return (SharedPreferences.Editor) invokeLZ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, str, f2)) == null) {
                e(new e(this, str, f2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLF.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i2)) == null) {
                e(new c(this, str, i2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLI.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, str, j)) == null) {
                e(new d(this, str, j));
                return this;
            }
            return (SharedPreferences.Editor) invokeLJ.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
                e(new a(this, str, str2));
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) {
                e(new RunnableC0848b(this, str, set));
                return this;
            }
            return (SharedPreferences.Editor) invokeLL.objValue;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
                e(new g(this, str));
                return this;
            }
            return (SharedPreferences.Editor) invokeL.objValue;
        }

        public /* synthetic */ SharedPreferences$EditorC0847b(b bVar, a aVar) {
            this(bVar);
        }
    }
}
