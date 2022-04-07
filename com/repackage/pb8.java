package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class pb8 {
    public static /* synthetic */ Interceptable $ic;
    public static String d;
    public static String e;
    public static String f;
    public static boolean g;
    public static String h;
    public transient /* synthetic */ FieldHolder $fh;
    public sb8 a;
    public ob8 b;
    public long c;

    public pb8() {
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
        h();
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            d = str;
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f = str;
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            e = str;
        }
    }

    public final void a(sb8 sb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sb8Var) == null) {
            b(sb8Var, false);
        }
    }

    public final void b(sb8 sb8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb8Var, z) == null) || sb8Var == null) {
            return;
        }
        if (!TextUtils.isEmpty(d)) {
            sb8Var.a().a("Cookie", d);
        } else {
            sb8Var.a().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f)) {
            sb8Var.a().a("client_user_token", f);
        }
        if (!TextUtils.isEmpty(e)) {
            sb8Var.a().a("User-Agent", e);
        }
        if (z) {
            sb8Var.a().a("Accept-Encoding", "gzip");
        } else {
            sb8Var.a().a("Accept-Encoding", "");
        }
        if (g) {
            sb8Var.a().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            sb8Var.a().a(HTTP.CONN_DIRECTIVE, "close");
        }
        sb8Var.a().a("client_logid", String.valueOf(this.c));
        if (TextUtils.isEmpty(h)) {
            return;
        }
        sb8Var.a().a("cuid", h);
    }

    public void c() {
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (ob8Var = this.b) == null) {
            return;
        }
        ob8Var.a();
    }

    public boolean d(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, vb8 vb8Var, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), linkedList, vb8Var, Boolean.valueOf(z2)})) == null) ? e(str, str2, z, i, i2, i3, i4, linkedList, vb8Var, z2, false) : invokeCommon.booleanValue;
    }

    public boolean e(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, vb8 vb8Var, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), linkedList, vb8Var, Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            sb8 sb8Var = new sb8();
            this.a = sb8Var;
            a(sb8Var);
            this.a.a().h(str);
            ob8 ob8Var = new ob8(this.a);
            this.b = ob8Var;
            return ob8Var.b(str2, vb8Var, i, i2, i3, i4, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public sb8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (sb8) invokeV.objValue;
    }

    public ub8 g(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), linkedList})) == null) {
            sb8 sb8Var = new sb8();
            this.a = sb8Var;
            b(sb8Var, z);
            this.a.a().h(str);
            ob8 ob8Var = new ob8(this.a);
            this.b = ob8Var;
            ob8Var.c(i, i3, i4);
            return this.a.b();
        }
        return (ub8) invokeCommon.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            System.setProperty("http.keepAlive", "false");
            this.c = BdStatisticsManager.getInstance().getClientLogId();
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ob8 ob8Var = this.b;
            if (ob8Var != null) {
                return ob8Var.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ub8 j(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), linkedList})) == null) {
            sb8 sb8Var = new sb8();
            this.a = sb8Var;
            b(sb8Var, z);
            this.a.a().h(str);
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.a.a().b(basicNameValuePair);
                }
            }
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.a.a().a(next.getName(), next.getValue());
                }
            }
            ob8 ob8Var = new ob8(this.a);
            this.b = ob8Var;
            ob8Var.f(i, i2, -1);
            return this.a.b();
        }
        return (ub8) invokeCommon.objValue;
    }

    public void k() {
        ob8 ob8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ob8Var = this.b) == null) {
            return;
        }
        ob8Var.i();
    }
}
