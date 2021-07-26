package d.a.q0.w2.c0.o;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static String f66527d;

    /* renamed from: e  reason: collision with root package name */
    public static String f66528e;

    /* renamed from: f  reason: collision with root package name */
    public static String f66529f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f66530g;

    /* renamed from: h  reason: collision with root package name */
    public static String f66531h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g f66532a;

    /* renamed from: b  reason: collision with root package name */
    public c f66533b;

    /* renamed from: c  reason: collision with root package name */
    public long f66534c;

    public d() {
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
        h();
    }

    public static void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            f66527d = str;
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f66529f = str;
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            f66528e = str;
        }
    }

    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gVar) == null) {
            b(gVar, false);
        }
    }

    public final void b(g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, z) == null) || gVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(f66527d)) {
            gVar.a().a("Cookie", f66527d);
        } else {
            gVar.a().a("Cookie", "");
        }
        if (!TextUtils.isEmpty(f66529f)) {
            gVar.a().a("client_user_token", f66529f);
        }
        if (!TextUtils.isEmpty(f66528e)) {
            gVar.a().a("User-Agent", f66528e);
        }
        if (z) {
            gVar.a().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        } else {
            gVar.a().a("Accept-Encoding", "");
        }
        if (f66530g) {
            gVar.a().a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } else {
            gVar.a().a(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
        }
        gVar.a().a("client_logid", String.valueOf(this.f66534c));
        if (TextUtils.isEmpty(f66531h)) {
            return;
        }
        gVar.a().a("cuid", f66531h);
    }

    public void c() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cVar = this.f66533b) == null) {
            return;
        }
        cVar.a();
    }

    public boolean d(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, jVar, Boolean.valueOf(z2)})) == null) ? e(str, str2, z, i2, i3, i4, i5, linkedList, jVar, z2, false) : invokeCommon.booleanValue;
    }

    public boolean e(String str, String str2, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList, jVar, Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            g gVar = new g();
            this.f66532a = gVar;
            a(gVar);
            this.f66532a.a().i(str);
            c cVar = new c(this.f66532a);
            this.f66533b = cVar;
            return cVar.b(str2, jVar, i2, i3, i4, i5, z2, z3);
        }
        return invokeCommon.booleanValue;
    }

    public g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66532a : (g) invokeV.objValue;
    }

    public i g(String str, boolean z, int i2, int i3, int i4, int i5, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), linkedList})) == null) {
            g gVar = new g();
            this.f66532a = gVar;
            b(gVar, z);
            this.f66532a.a().i(str);
            c cVar = new c(this.f66532a);
            this.f66533b = cVar;
            cVar.c(i2, i4, i5);
            return this.f66532a.b();
        }
        return (i) invokeCommon.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            System.setProperty("http.keepAlive", "false");
            this.f66534c = BdStatisticsManager.getInstance().getClientLogId();
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c cVar = this.f66533b;
            if (cVar != null) {
                return cVar.d();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public i j(String str, List<BasicNameValuePair> list, boolean z, int i2, int i3, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, list, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), linkedList})) == null) {
            g gVar = new g();
            this.f66532a = gVar;
            b(gVar, z);
            this.f66532a.a().i(str);
            if (list != null) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    this.f66532a.a().b(basicNameValuePair);
                }
            }
            if (linkedList != null) {
                Iterator<BasicNameValuePair> it = linkedList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    this.f66532a.a().a(next.getName(), next.getValue());
                }
            }
            c cVar = new c(this.f66532a);
            this.f66533b = cVar;
            cVar.f(i2, i3, -1);
            return this.f66532a.b();
        }
        return (i) invokeCommon.objValue;
    }

    public void k() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (cVar = this.f66533b) == null) {
            return;
        }
        cVar.i();
    }
}
