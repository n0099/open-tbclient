package d.a.q0.h.f0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f53298c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53299a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ArrayList<a> f53300b;

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
                return;
            }
        }
        this.f53300b = new ArrayList<>(20);
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f53298c == null) {
                synchronized (b.class) {
                    if (f53298c == null) {
                        f53298c = new b();
                    }
                }
            }
            return f53298c;
        }
        return (b) invokeV.objValue;
    }

    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                if (this.f53300b.size() < 20) {
                    this.f53300b.add(aVar);
                } else {
                    this.f53299a++;
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f53300b.clear();
                this.f53299a = 0;
            }
        }
    }

    public synchronized JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int size = this.f53300b.size();
                if (size == 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("dropcnt", this.f53299a);
                    jSONObject.put("errorcnt", size);
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("errors", jSONArray);
                    Iterator<a> it = this.f53300b.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().a());
                    }
                } catch (JSONException unused) {
                }
                this.f53300b.clear();
                return jSONObject;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
