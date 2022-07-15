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
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
/* loaded from: classes7.dex */
public class v55 implements u55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public Map<String, t55> c;
    public boolean d;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final v55 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(25215422, "Lcom/repackage/v55$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(25215422, "Lcom/repackage/v55$a;");
                    return;
                }
            }
            a = new v55();
        }
    }

    public v55() {
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

    public static final v55 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.a : (v55) invokeV.objValue;
    }

    @Override // com.repackage.u55
    public void a() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Iterator<Map.Entry<String, t55>> it = this.c.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Map.Entry<String, t55> next = it.next();
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

    public t55 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.c.get(str) : (t55) invokeL.objValue;
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
            for (Map.Entry<String, t55> entry : this.c.entrySet()) {
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
                t55 t55Var = new t55();
                t55Var.o(optJSONObject);
                this.c.put("homePage", t55Var);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("forum");
            if (optJSONObject2 != null) {
                t55 t55Var2 = new t55();
                t55Var2.o(optJSONObject2);
                this.c.put("enterForum", t55Var2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("channel");
            if (optJSONObject3 != null) {
                t55 t55Var3 = new t55();
                t55Var3.o(optJSONObject3);
                this.c.put("channel", t55Var3);
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("news");
            if (optJSONObject4 != null) {
                t55 t55Var4 = new t55();
                t55Var4.o(optJSONObject4);
                this.c.put("message", t55Var4);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("personal");
            if (optJSONObject5 != null) {
                t55 t55Var5 = new t55();
                t55Var5.o(optJSONObject5);
                this.c.put("person", t55Var5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject(AlbumActivityConfig.FROM_WRITE);
            if (optJSONObject6 != null) {
                t55 t55Var6 = new t55();
                t55Var6.o(optJSONObject6);
                this.c.put(AlbumActivityConfig.FROM_WRITE, t55Var6);
            }
        }
    }
}
