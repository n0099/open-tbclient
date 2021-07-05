package d.a.q0.a.t1.f;

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
import d.a.q0.a.a2.n.e;
import d.a.q0.a.a2.n.f;
import d.a.q0.a.b1.c;
import d.a.q0.a.b1.d;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> l;
    public static final f<a> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f50719e;

    /* renamed from: f  reason: collision with root package name */
    public String f50720f;

    /* renamed from: g  reason: collision with root package name */
    public long f50721g;

    /* renamed from: h  reason: collision with root package name */
    public String f50722h;

    /* renamed from: i  reason: collision with root package name */
    public int f50723i;
    public String j;
    public String k;

    /* renamed from: d.a.q0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0948a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0948a() {
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
        @Override // d.a.q0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.f50719e = cVar.r();
                aVar.f50720f = cVar.r();
                aVar.f50721g = cVar.readLong();
                aVar.f50722h = cVar.r();
                aVar.f50723i = cVar.readInt();
                aVar.j = cVar.r();
                aVar.k = cVar.r();
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
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
        @Override // d.a.q0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.f50719e);
                dVar.f(aVar.f50720f);
                dVar.writeLong(aVar.f50721g);
                dVar.f(aVar.f50722h);
                dVar.writeInt(aVar.f50723i);
                dVar.f(aVar.j);
                dVar.f(aVar.k);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1500841156, "Ld/a/q0/a/t1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1500841156, "Ld/a/q0/a/t1/f/a;");
                return;
            }
        }
        l = new C0948a();
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
        this.f50721g = -1L;
        this.f50723i = 4;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f50722h) && (this.f50721g >= 0 || !TextUtils.isEmpty(this.f50720f)) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanPluginModel{pluginAlias='" + this.f50719e + "', pluginVersionName='" + this.f50720f + "', pluginVersionCode='" + this.f50721g + "', pluginName='" + this.f50722h + "', pluginCategory=" + this.f50723i + ", pluginPath='" + this.j + "', pluginPagesConfigFileName='" + this.k + "'}";
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
        this.f50721g = -1L;
        this.f50723i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f50720f = jSONObject.optString("version");
        this.f50721g = jSONObject.optLong("version_code", -1L);
        this.f50722h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f50723i = i2;
    }
}
