package d.a.v.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f68305g = "Flow";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68306a;

    /* renamed from: b  reason: collision with root package name */
    public int f68307b;

    /* renamed from: c  reason: collision with root package name */
    public final long f68308c;

    /* renamed from: d  reason: collision with root package name */
    public long f68309d;

    /* renamed from: e  reason: collision with root package name */
    public Context f68310e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f68311f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f68312e;

        /* renamed from: f  reason: collision with root package name */
        public String f68313f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f68314g;

        public a(c cVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68314g = cVar;
            this.f68312e = str;
            this.f68313f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68314g.f68311f.put(this.f68312e, this.f68313f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(788815890, "Ld/a/v/a/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(788815890, "Ld/a/v/a/a/c;");
        }
    }

    public c(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68309d = 0L;
        this.f68310e = context;
        this.f68306a = i2;
        this.f68307b = i3;
        this.f68308c = System.currentTimeMillis();
        this.f68311f = new ConcurrentHashMap();
    }

    public c b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                d.a.v.a.a.a.h(this.f68310e).f().execute(new a(this, str, String.valueOf(i2)));
            }
            String str2 = f68305g;
            d.a.v.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + i2);
            return this;
        }
        return (c) invokeLI.objValue;
    }

    public c c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            if (!TextUtils.isEmpty(str)) {
                d.a.v.a.a.a.h(this.f68310e).f().execute(new a(this, str, String.valueOf(j)));
            }
            String str2 = f68305g;
            d.a.v.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + j);
            return this;
        }
        return (c) invokeLJ.objValue;
    }

    public c d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && str2 != null) {
                d.a.v.a.a.a.h(this.f68310e).f().execute(new a(this, str, str2));
            }
            String str3 = f68305g;
            d.a.v.a.h.e.a(str3, "flow addEvent id:" + str + ",value:" + str2);
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f68309d = System.currentTimeMillis();
            d.a.v.a.a.a.h(this.f68310e).e(this);
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f68311f.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f68311f : (Map) invokeV.objValue;
    }
}
