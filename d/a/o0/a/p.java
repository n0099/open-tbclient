package d.a.o0.a;

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
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51366a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51367b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51368c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Integer f51369a;

        /* renamed from: b  reason: collision with root package name */
        public String f51370b;

        /* renamed from: c  reason: collision with root package name */
        public Integer f51371c;

        /* renamed from: d  reason: collision with root package name */
        public Long f51372d;

        /* renamed from: e  reason: collision with root package name */
        public Long f51373e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f51374f;

        /* renamed from: g  reason: collision with root package name */
        public String f51375g;

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
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final p f51376a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(155226083, "Ld/a/o0/a/p$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(155226083, "Ld/a/o0/a/p$c;");
                    return;
                }
            }
            f51376a = new p(null);
        }
    }

    public /* synthetic */ p(a aVar) {
        this();
    }

    public static p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f51376a : (p) invokeV.objValue;
    }

    public final void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bVar, z) == null) || bVar == null) {
            return;
        }
        try {
            if (this.f51366a) {
                boolean g2 = d.a.o0.r.d0.b.j().g("pref_key_task_first_open", true);
                int k = d.a.o0.r.d0.b.j().k("pref_key_float_tip_num", 0);
                long l = d.a.o0.r.d0.b.j().l("pref_key_new_task_complete_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (g2) {
                    if (e(bVar)) {
                        this.f51368c = true;
                        d.a.o0.r.d0.b.j().t("pref_key_task_first_open", false);
                    }
                } else if (d(bVar, currentTimeMillis / 1000, l / 1000)) {
                    if (z) {
                        if (e(bVar)) {
                            this.f51368c = true;
                            d.a.o0.r.d0.b.j().v("pref_key_float_tip_num", 0);
                        }
                    } else if (k >= bVar.f51374f.intValue() || !e(bVar)) {
                    } else {
                        this.f51368c = true;
                        d.a.o0.r.d0.b.j().v("pref_key_float_tip_num", k + 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final boolean c(d.a.o0.a.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            int x = cVar.x();
            return x == 5 || x == 6 || x == 7 || x == 8;
        }
        return invokeL.booleanValue;
    }

    public final boolean d(b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (bVar != null && j2 > 0 && !TextUtils.isEmpty(bVar.f51370b) && bVar.f51372d.longValue() < bVar.f51373e.longValue() && j >= bVar.f51372d.longValue() && j <= bVar.f51373e.longValue() && bVar.f51374f.intValue() > 0 && bVar.f51369a.intValue() >= 0 && j > j2) {
                String[] split = bVar.f51370b.split(",");
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
                long intValue = bVar.f51369a.intValue() * 86400;
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
            d.a.o0.r.d0.b.j().x("pref_key_strategy_json", str);
            d.a.o0.r.d0.b.j().v("pref_key_float_tip_num", 0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.o0.r.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void h(d.a.o0.a.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) && cVar != null && c(cVar)) {
            d.a.o0.r.d0.b.j().w("pref_key_new_task_complete_time", System.currentTimeMillis());
        }
    }

    public void i(d.a.o0.a.c0.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || bVar == null || bVar.a() == null || bVar.a().size() <= 0) {
            return;
        }
        ArrayList<FloatStrategy> a2 = bVar.a();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<FloatStrategy> it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar2 = null;
                break;
            }
            FloatStrategy next = it.next();
            if (currentTimeMillis > next.show_time_begin.longValue() && currentTimeMillis < next.show_time_end.longValue()) {
                bVar2 = new b();
                bVar2.f51370b = next.browsetimepage;
                bVar2.f51371c = next.duration;
                bVar2.f51374f = next.show_num;
                bVar2.f51372d = next.show_time_begin;
                bVar2.f51373e = next.show_time_end;
                bVar2.f51375g = next.toast;
                bVar2.f51369a = next.un_do_mission;
                break;
            }
        }
        if (bVar2 == null) {
            f("");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("un_do_mission", bVar2.f51369a.intValue());
            jSONObject.put("browsetimepage", bVar2.f51370b);
            jSONObject.put("duration", bVar2.f51371c.intValue());
            jSONObject.put("show_time_begin", bVar2.f51372d.longValue());
            jSONObject.put("show_time_end", bVar2.f51373e.longValue());
            jSONObject.put("show_num", bVar2.f51374f.intValue());
            jSONObject.put("toast", bVar2.f51375g);
            String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                f("");
                return;
            }
            if (!jSONObject2.equals(d.a.o0.r.d0.b.j().p("pref_key_strategy_json", null))) {
                f(jSONObject2);
            }
            a(bVar2, true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f51366a = z;
            if (z && this.f51367b) {
                this.f51367b = false;
                if (!this.f51368c && d.y().t()) {
                    String p = d.a.o0.r.d0.b.j().p("pref_key_strategy_json", null);
                    if (TextUtils.isEmpty(p)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(p);
                        b bVar = new b();
                        bVar.f51369a = Integer.valueOf(jSONObject.optInt("un_do_mission", 0));
                        bVar.f51370b = jSONObject.optString("browsetimepage", "");
                        bVar.f51371c = Integer.valueOf(jSONObject.optInt("duration", 0));
                        bVar.f51372d = Long.valueOf(jSONObject.optLong("show_time_begin", 0L));
                        bVar.f51373e = Long.valueOf(jSONObject.optLong("show_time_end", 0L));
                        bVar.f51374f = Integer.valueOf(jSONObject.optInt("show_num", 0));
                        bVar.f51375g = jSONObject.optString("toast", null);
                        a(bVar, false);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public p() {
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
        this.f51366a = false;
        this.f51367b = true;
        this.f51368c = false;
    }
}
