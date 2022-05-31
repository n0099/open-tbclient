package com.repackage;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.launch.SmartLaunchStats;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e45 implements d45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public Map<String, c45> c;
    public boolean d;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final e45 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-462403666, "Lcom/repackage/e45$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-462403666, "Lcom/repackage/e45$a;");
                    return;
                }
            }
            a = new e45();
        }
    }

    public e45() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
    }

    public static final e45 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (e45) invokeV.objValue;
    }

    @Override // com.repackage.d45
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, c45>> it = this.c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Map.Entry<String, c45> next = it.next();
                if (next.getValue() != null && !next.getValue().m()) {
                    z = false;
                    break;
                }
            }
            this.d = z;
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
            return this.d && currentTimeMillis > f() && currentTimeMillis < e();
        }
        return invokeV.booleanValue;
    }

    public c45 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.c.get(str) : (c45) invokeL.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : invokeV.longValue;
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
            for (Map.Entry<String, c45> entry : this.c.entrySet()) {
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
            this.a = jSONObject.optLong(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY);
            this.b = jSONObject.optLong("end_time");
            JSONObject optJSONObject = jSONObject.optJSONObject(ExternalTransferSpeedStats.FEED_PAGE);
            if (optJSONObject != null) {
                c45 c45Var = new c45();
                c45Var.o(optJSONObject);
                this.c.put("homePage", c45Var);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                c45 c45Var2 = new c45();
                c45Var2.o(optJSONObject2);
                this.c.put("enterForum", c45Var2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                c45 c45Var3 = new c45();
                c45Var3.o(optJSONObject3);
                this.c.put("channel", c45Var3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
            if (optJSONObject4 != null) {
                c45 c45Var4 = new c45();
                c45Var4.o(optJSONObject4);
                this.c.put("message", c45Var4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                c45 c45Var5 = new c45();
                c45Var5.o(optJSONObject5);
                this.c.put("person", c45Var5);
            }
        }
    }
}
