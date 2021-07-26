package d.a.o0.a.t1.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.n.e;
import d.a.o0.a.a2.n.f;
import d.a.o0.a.b1.c;
import d.a.o0.a.b1.d;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> l;
    public static final f<a> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f47921e;

    /* renamed from: f  reason: collision with root package name */
    public String f47922f;

    /* renamed from: g  reason: collision with root package name */
    public long f47923g;

    /* renamed from: h  reason: collision with root package name */
    public String f47924h;

    /* renamed from: i  reason: collision with root package name */
    public int f47925i;
    public String j;
    public String k;

    /* renamed from: d.a.o0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0906a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0906a() {
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
        @Override // d.a.o0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.f47921e = cVar.r();
                aVar.f47922f = cVar.r();
                aVar.f47923g = cVar.readLong();
                aVar.f47924h = cVar.r();
                aVar.f47925i = cVar.readInt();
                aVar.j = cVar.r();
                aVar.k = cVar.r();
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends f<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.f47921e);
                dVar.f(aVar.f47922f);
                dVar.writeLong(aVar.f47923g);
                dVar.f(aVar.f47924h);
                dVar.writeInt(aVar.f47925i);
                dVar.f(aVar.j);
                dVar.f(aVar.k);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1759006594, "Ld/a/o0/a/t1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1759006594, "Ld/a/o0/a/t1/f/a;");
                return;
            }
        }
        l = new C0906a();
        m = new b();
    }

    public a() {
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
        this.f47923g = -1L;
        this.f47925i = 4;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f47924h) && (this.f47923g >= 0 || !TextUtils.isEmpty(this.f47922f)) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanPluginModel{pluginAlias='" + this.f47921e + "', pluginVersionName='" + this.f47922f + "', pluginVersionCode='" + this.f47923g + "', pluginName='" + this.f47924h + "', pluginCategory=" + this.f47925i + ", pluginPath='" + this.j + "', pluginPagesConfigFileName='" + this.k + "'}";
        }
        return (String) invokeV.objValue;
    }

    public a(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f47923g = -1L;
        this.f47925i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f47922f = jSONObject.optString("version");
        this.f47923g = jSONObject.optLong("version_code", -1L);
        this.f47924h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f47925i = i2;
    }
}
