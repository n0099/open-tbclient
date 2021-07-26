package d.a.p0.g0.e;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.yy.gslbsdk.db.ResultTB;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f52638a;

    /* renamed from: b  reason: collision with root package name */
    public long f52639b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d.a.p0.g0.e.a> f52640c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52641d;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f52642a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1761501663, "Ld/a/p0/g0/e/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1761501663, "Ld/a/p0/g0/e/c$a;");
                    return;
                }
            }
            f52642a = new c();
        }
    }

    public c() {
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
        this.f52640c = new HashMap();
    }

    public static final c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f52642a : (c) invokeV.objValue;
    }

    @Override // d.a.p0.g0.e.b
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, d.a.p0.g0.e.a>> it = this.f52640c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Map.Entry<String, d.a.p0.g0.e.a> next = it.next();
                if (next.getValue() != null && !next.getValue().m()) {
                    z = false;
                    break;
                }
            }
            this.f52641d = z;
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921551, Boolean.TRUE));
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return this.f52641d && currentTimeMillis > f() && currentTimeMillis < e();
        }
        return invokeV.booleanValue;
    }

    public d.a.p0.g0.e.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f52640c.get(str) : (d.a.p0.g0.e.a) invokeL.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52639b : invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52638a : invokeV.longValue;
    }

    public void g() {
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof BaseActivity) {
                uniqueId = ((BaseActivity) currentActivity).getUniqueId();
            } else {
                uniqueId = currentActivity instanceof BaseFragmentActivity ? ((BaseFragmentActivity) currentActivity).getUniqueId() : null;
            }
            for (Map.Entry<String, d.a.p0.g0.e.a> entry : this.f52640c.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().q(uniqueId);
                    entry.getValue().p(this);
                    entry.getValue().n();
                }
            }
        }
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.f52638a = jSONObject.optLong("start_time");
            this.f52639b = jSONObject.optLong(ResultTB.ENDTIME);
            JSONObject optJSONObject = jSONObject.optJSONObject("feed");
            if (optJSONObject != null) {
                d.a.p0.g0.e.a aVar = new d.a.p0.g0.e.a();
                aVar.o(optJSONObject);
                this.f52640c.put("homePage", aVar);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                d.a.p0.g0.e.a aVar2 = new d.a.p0.g0.e.a();
                aVar2.o(optJSONObject2);
                this.f52640c.put("enterForum", aVar2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                d.a.p0.g0.e.a aVar3 = new d.a.p0.g0.e.a();
                aVar3.o(optJSONObject3);
                this.f52640c.put("channel", aVar3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
            if (optJSONObject4 != null) {
                d.a.p0.g0.e.a aVar4 = new d.a.p0.g0.e.a();
                aVar4.o(optJSONObject4);
                this.f52640c.put("message", aVar4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject(BaiduWalletServiceProviderMap.PLUGIN_PERSONAL);
            if (optJSONObject5 != null) {
                d.a.p0.g0.e.a aVar5 = new d.a.p0.g0.e.a();
                aVar5.o(optJSONObject5);
                this.f52640c.put("person", aVar5);
            }
        }
    }
}
