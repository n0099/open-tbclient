package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FloatStrategy;
/* loaded from: classes6.dex */
public class kj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public boolean c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer a;
        public String b;
        public Integer c;
        public Long d;
        public Long e;
        public Integer f;
        public String g;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final kj4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-240788355, "Lcom/repackage/kj4$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-240788355, "Lcom/repackage/kj4$c;");
                    return;
                }
            }
            a = new kj4(null);
        }
    }

    public /* synthetic */ kj4(a aVar) {
        this();
    }

    public static kj4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (kj4) invokeV.objValue;
    }

    public final void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bVar, z) == null) || bVar == null) {
            return;
        }
        try {
            if (this.a) {
                boolean h = iu4.k().h("pref_key_task_first_open", true);
                int l = iu4.k().l("pref_key_float_tip_num", 0);
                long m = iu4.k().m("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (h) {
                    if (e(bVar)) {
                        this.c = true;
                        iu4.k().u("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, m / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.c = true;
                            iu4.k().w("pref_key_float_tip_num", 0);
                        }
                    } else if (l >= bVar.f.intValue() || !e(bVar)) {
                    } else {
                        this.c = true;
                        iu4.k().w("pref_key_float_tip_num", l + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yi4Var)) == null) {
            if (yi4Var == null) {
                return false;
            }
            int x = yi4Var.x();
            return x == 5 || x == 6 || x == 7 || x == 8;
        }
        return invokeL.booleanValue;
    }

    public final boolean d(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar != null && j2 > 0 && !TextUtils.isEmpty(bVar.b) && bVar.d.longValue() < bVar.e.longValue() && j >= bVar.d.longValue() && j <= bVar.e.longValue() && bVar.f.intValue() > 0 && bVar.a.intValue() >= 0 && j > j2) {
                String[] split = bVar.b.split(",");
                if (split != null && split.length > 0) {
                    for (String str : split) {
                        if ("3".equals(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
                long intValue = bVar.a.intValue() * 86400;
                long j3 = j - j2;
                if (j3 > intValue && j3 < intValue + 86400) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean e(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2921409, bVar), Boolean.class);
            if (runTask == null || runTask.getData() == null || !(runTask.getData() instanceof Boolean)) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            iu4.k().y("pref_key_strategy_json", str);
            iu4.k().w("pref_key_float_tip_num", 0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            iu4.k().x("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void h(yi4 yi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, yi4Var) == null) && yi4Var != null && c(yi4Var)) {
            iu4.k().x("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(yj4 yj4Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, yj4Var) == null) || yj4Var == null || yj4Var.a() == null || yj4Var.a().size() <= 0) {
            return;
        }
        ArrayList<FloatStrategy> a2 = yj4Var.a();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<FloatStrategy> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            FloatStrategy next = it.next();
            if (currentTimeMillis > next.show_time_begin.longValue() && currentTimeMillis < next.show_time_end.longValue()) {
                bVar = new b();
                bVar.b = next.browsetimepage;
                bVar.c = next.duration;
                bVar.f = next.show_num;
                bVar.d = next.show_time_begin;
                bVar.e = next.show_time_end;
                bVar.g = next.toast;
                bVar.a = next.un_do_mission;
                break;
            }
        }
        if (bVar == null) {
            f("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("un_do_mission", bVar.a.intValue());
            jSONObject.put("browsetimepage", bVar.b);
            jSONObject.put("duration", bVar.c.intValue());
            jSONObject.put("show_time_begin", bVar.d.longValue());
            jSONObject.put("show_time_end", bVar.e.longValue());
            jSONObject.put("show_num", bVar.f.intValue());
            jSONObject.put("toast", bVar.g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(iu4.k().q("pref_key_strategy_json", null))) {
                f(jSONObject2);
            }
            a(bVar, true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (z && this.b) {
                this.b = false;
                if (!this.c && zi4.y().t()) {
                    String q = iu4.k().q("pref_key_strategy_json", null);
                    if (TextUtils.isEmpty(q)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(q);
                        b bVar = new b();
                        bVar.a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                        bVar.b = jSONObject.optString("browsetimepage", "");
                        bVar.c = Integer.valueOf(jSONObject.optInt("duration", 0));
                        bVar.d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                        bVar.e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                        bVar.f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                        bVar.g = jSONObject.optString("toast", null);
                        a(bVar, false);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public kj4() {
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
        this.a = false;
        this.b = true;
        this.c = false;
    }
}
