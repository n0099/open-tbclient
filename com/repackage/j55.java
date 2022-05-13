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
/* loaded from: classes6.dex */
public class j55 implements i55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public Map<String, h55> c;
    public boolean d;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final j55 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318334390, "Lcom/repackage/j55$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318334390, "Lcom/repackage/j55$a;");
                    return;
                }
            }
            a = new j55();
        }
    }

    public j55() {
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

    public static final j55 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (j55) invokeV.objValue;
    }

    @Override // com.repackage.i55
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, h55>> it = this.c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Map.Entry<String, h55> next = it.next();
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

    public h55 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.c.get(str) : (h55) invokeL.objValue;
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
            for (Map.Entry<String, h55> entry : this.c.entrySet()) {
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
                h55 h55Var = new h55();
                h55Var.o(optJSONObject);
                this.c.put("homePage", h55Var);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                h55 h55Var2 = new h55();
                h55Var2.o(optJSONObject2);
                this.c.put("enterForum", h55Var2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                h55 h55Var3 = new h55();
                h55Var3.o(optJSONObject3);
                this.c.put("channel", h55Var3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
            if (optJSONObject4 != null) {
                h55 h55Var4 = new h55();
                h55Var4.o(optJSONObject4);
                this.c.put("message", h55Var4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                h55 h55Var5 = new h55();
                h55Var5.o(optJSONObject5);
                this.c.put("person", h55Var5);
            }
        }
    }
}
