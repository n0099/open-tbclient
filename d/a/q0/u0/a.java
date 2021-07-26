package d.a.q0.u0;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<b2> f63139a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f63140b;

    /* renamed from: c  reason: collision with root package name */
    public String f63141c;

    /* renamed from: d  reason: collision with root package name */
    public int f63142d;

    /* renamed from: e  reason: collision with root package name */
    public List<FrsTabInfo> f63143e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f63144f;

    /* renamed from: g  reason: collision with root package name */
    public w0 f63145g;

    /* renamed from: d.a.q0.u0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f63146a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(664576965, "Ld/a/q0/u0/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(664576965, "Ld/a/q0/u0/a$b;");
                    return;
                }
            }
            f63146a = new a(null);
        }
    }

    public /* synthetic */ a(C1664a c1664a) {
        this();
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f63146a : (a) invokeV.objValue;
    }

    public boolean a(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2Var)) == null) {
            if (b2Var == null) {
                return false;
            }
            if (this.f63139a.size() > 29) {
                w0 w0Var = this.f63145g;
                if (w0Var != null) {
                    w0Var.b(2);
                }
                return false;
            }
            this.f63139a.add(b2Var);
            w0 w0Var2 = this.f63145g;
            if (w0Var2 != null) {
                w0Var2.c(this.f63139a.size(), 2);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (b2 b2Var : this.f63139a) {
                if (b2Var != null) {
                    b2Var.O3(false);
                }
            }
            this.f63139a.clear();
            w0 w0Var = this.f63145g;
            if (w0Var != null) {
                w0Var.c(0, 2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f63141c = null;
            this.f63142d = -1;
            List<FrsTabInfo> list = this.f63143e;
            if (list != null) {
                list.clear();
            }
            SparseArray<FrsTabInfo> sparseArray = this.f63144f;
            if (sparseArray != null) {
                sparseArray.clear();
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || ListUtils.isEmpty(this.f63139a)) {
            return;
        }
        this.f63139a.clear();
        w0 w0Var = this.f63145g;
        if (w0Var != null) {
            w0Var.c(this.f63139a.size(), 2);
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63142d : invokeV.intValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f63141c : (String) invokeV.objValue;
    }

    public List<FrsTabInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f63143e : (List) invokeV.objValue;
    }

    public List<b2> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f63139a : (List) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f63140b : invokeV.booleanValue;
    }

    public boolean k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? this.f63144f.get(i2) != null && this.f63144f.get(i2).is_general_tab.intValue() == 1 : invokeI.booleanValue;
    }

    public void l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b2Var) == null) {
            this.f63139a.remove(b2Var);
            w0 w0Var = this.f63145g;
            if (w0Var != null) {
                w0Var.c(this.f63139a.size(), 2);
            }
        }
    }

    public void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            try {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
                JSONArray jSONArray = new JSONArray();
                for (b2 b2Var : h().i()) {
                    if (b2Var != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("thread_id", b2Var.d0());
                        jSONObject.put("from_tab_id", b2Var.d1());
                        jSONObject.put("to_tab_id", i3);
                        jSONArray.put(jSONObject);
                    }
                }
                httpMessage.addParam("threads", jSONArray.toString());
                httpMessage.addParam("forum_id", h().f());
                MessageManager.getInstance().sendMessage(httpMessage);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p(false, false);
            b();
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f63142d = i2;
        }
    }

    public void p(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f63140b = z;
            w0 w0Var = this.f63145g;
            if (w0Var != null) {
                w0Var.a(z, z2, 2);
            }
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f63141c = str;
        }
    }

    public void r(List<FrsTabInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f63143e = new ArrayList(list);
            this.f63144f = new SparseArray<>();
            for (FrsTabInfo frsTabInfo : this.f63143e) {
                if (frsTabInfo != null) {
                    this.f63144f.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
                }
            }
        }
    }

    public void s(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, w0Var) == null) {
            this.f63145g = w0Var;
        }
    }

    public a() {
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
        this.f63142d = -1;
        this.f63139a = new ArrayList();
    }
}
