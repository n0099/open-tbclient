package d.a.r0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile g f67408i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f67409a;

    /* renamed from: b  reason: collision with root package name */
    public int f67410b;

    /* renamed from: c  reason: collision with root package name */
    public int f67411c;

    /* renamed from: d  reason: collision with root package name */
    public int f67412d;

    /* renamed from: e  reason: collision with root package name */
    public int f67413e;

    /* renamed from: f  reason: collision with root package name */
    public int f67414f;

    /* renamed from: g  reason: collision with root package name */
    public f f67415g;

    /* renamed from: h  reason: collision with root package name */
    public e0 f67416h;

    public g() {
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
        this.f67413e = 614400;
        this.f67414f = 153600;
        this.f67415g = new f();
        this.f67416h = new e0();
    }

    public static g m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f67408i == null) {
                synchronized (e.class) {
                    if (f67408i == null) {
                        f67408i = new g();
                    }
                }
            }
            return f67408i;
        }
        return (g) invokeV.objValue;
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 < this.f67411c) {
            return;
        }
        this.f67411c = i2;
        h0.e().putInt("ubc_data_expire_time", i2);
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 < this.f67412d) {
            return;
        }
        this.f67412d = i2;
        h0.e().putInt("ubc_database_limit", i2);
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 < 307200) {
            return;
        }
        this.f67413e = i2;
        h0.e().putInt("ubc_launch_upload_max_limit", i2);
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 < 30720) {
            return;
        }
        this.f67414f = i2;
        h0.e().putInt("ubc_single_log_max_limit", i2);
    }

    public void E(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (i3 = i2 * 60000) < this.f67410b) {
            return;
        }
        this.f67410b = i3;
    }

    public void F(List<k> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (k kVar : list) {
                String b2 = kVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    if ("0".equals(kVar.getSwitch())) {
                        this.f67415g.f67399a.add(b2);
                        this.f67415g.f67402d.remove(b2);
                    } else {
                        this.f67415g.f67399a.remove(b2);
                        this.f67415g.f67402d.add(b2);
                    }
                    if ("1".equals(kVar.getIsReal())) {
                        this.f67415g.f67400b.add(b2);
                    } else {
                        this.f67415g.f67400b.remove(b2);
                    }
                    if ("1".equals(kVar.getAbtest())) {
                        this.f67415g.f67401c.add(b2);
                    } else {
                        this.f67415g.f67401c.remove(b2);
                    }
                    if ("1".equals(kVar.getNoCache())) {
                        this.f67415g.f67403e.add(b2);
                    } else {
                        this.f67415g.f67403e.remove(b2);
                    }
                    if (kVar.f() >= 1 && kVar.f() <= 100) {
                        this.f67415g.f67404f.put(b2, String.valueOf(kVar.f()));
                    } else {
                        this.f67415g.f67404f.remove(b2);
                    }
                    if (!TextUtils.isEmpty(kVar.a())) {
                        this.f67415g.f67405g.put(b2, kVar.a());
                    } else {
                        this.f67415g.f67405g.remove(b2);
                    }
                    if (kVar.c() != 0 && kVar.d() != 0) {
                        m mVar = new m(b2, kVar.d(), kVar.c());
                        this.f67415g.f67406h.put(mVar.a(), mVar);
                    }
                    if (TextUtils.equals(kVar.getIdType(), "1")) {
                        this.f67415g.f67407i.add(b2);
                    } else {
                        this.f67415g.f67407i.remove(b2);
                    }
                    if (TextUtils.equals(kVar.getReallog(), "1")) {
                        this.f67415g.j.add(b2);
                    } else {
                        this.f67415g.j.remove(b2);
                    }
                    String gFlow = kVar.getGFlow();
                    if (!TextUtils.isEmpty(gFlow) && !TextUtils.equals(gFlow, "0")) {
                        this.f67415g.k.put(b2, gFlow);
                    } else {
                        this.f67415g.k.remove(b2);
                    }
                    String uploadType = kVar.getUploadType();
                    if (!TextUtils.isEmpty(uploadType)) {
                        this.f67415g.l.put(b2, uploadType);
                    } else {
                        this.f67415g.l.remove(b2);
                    }
                    int e2 = kVar.e();
                    if (e2 != 2) {
                        this.f67415g.m.put(b2, Integer.valueOf(e2));
                    } else {
                        this.f67415g.m.remove(b2);
                    }
                }
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? this.f67415g.f67401c.contains(str) : invokeL.booleanValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!this.f67415g.m.containsKey(str) || (num = this.f67415g.m.get(str)) == null) {
                return 2;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.f67415g.f67403e.contains(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? TextUtils.equals("0", s(str)) : invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (this.f67416h.isUBCDebug()) {
                return true;
            }
            return this.f67415g.f67400b.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? this.f67415g.j.contains(str) : invokeL.booleanValue;
    }

    public boolean g(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i2)) == null) {
            if (this.f67415g.f67399a.contains(str)) {
                return false;
            }
            return ((i2 & 16) == 0 && (i2 & 32) == 0) || this.f67415g.f67402d.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (!u() && this.f67416h.isUBCSample() && q(str) > 0) {
                if (new Random().nextInt(100) >= q(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.f67415g.f67405g.containsKey(str) ? this.f67415g.f67405g.get(str) : "" : (String) invokeL.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f67411c : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f67412d : invokeV.intValue;
    }

    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this.f67415g.k.containsKey(str) ? this.f67415g.k.get(str) : "" : (String) invokeL.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f67413e : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f67414f : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f67410b : invokeV.intValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !this.f67415g.f67404f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f67415g.f67404f.get(str));
        }
        return invokeL.intValue;
    }

    public String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.f67415g.f67407i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? this.f67415g.l.containsKey(str) ? this.f67415g.l.get(str) : "" : (String) invokeL.objValue;
    }

    public void t(c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, cVar, context) == null) {
            this.f67409a = context;
            this.f67410b = 360000;
            h0 e2 = h0.e();
            this.f67411c = e2.getInt("ubc_data_expire_time", 604800000);
            this.f67412d = e2.getInt("ubc_database_limit", 10000);
            cVar.n().q(this.f67415g);
            this.f67413e = e2.getInt("ubc_launch_upload_max_limit", 614400);
            this.f67414f = e2.getInt("ubc_single_log_max_limit", 153600);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            r uBCContext = UBC.getUBCContext();
            if (uBCContext != null) {
                return uBCContext.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            HashMap<String, m> hashMap = this.f67415g.f67406h;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.f67415g.f67406h.get(str).b();
        }
        return invokeL.booleanValue;
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            HashMap<String, m> hashMap = this.f67415g.f67406h;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.f67415g.f67406h.get(str).c();
        }
        return invokeL.booleanValue;
    }

    public boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            Context context = this.f67409a;
            return context == null || y(context) || !c(str);
        }
        return invokeL.booleanValue;
    }

    public boolean y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }

    public boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? this.f67415g.f67400b.contains(str) : invokeL.booleanValue;
    }
}
