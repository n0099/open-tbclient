package d.a.d.e.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import java.net.InetAddress;
import java.net.URL;
import java.util.Calendar;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static a f41643d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f41644a;

    /* renamed from: b  reason: collision with root package name */
    public String f41645b;

    /* renamed from: c  reason: collision with root package name */
    public long f41646c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-402363362, "Ld/a/d/e/e/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-402363362, "Ld/a/d/e/e/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41644a = 0L;
        this.f41645b = null;
        this.f41646c = 0L;
        SharedPreferences a2 = a();
        this.f41644a = a2.getLong(f("c.tieba.baidu.com"), 0L);
        this.f41645b = a2.getString(e("c.tieba.baidu.com"), null);
        this.f41646c = a2.getLong(d("c.tieba.baidu.com"), 0L);
    }

    public static final a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41643d == null) {
                synchronized (a.class) {
                    if (f41643d == null) {
                        f41643d = new a();
                    }
                }
            }
            return f41643d;
        }
        return (a) invokeV.objValue;
    }

    public final SharedPreferences a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BdBaseApplication.getInst().getSharedPreferences("adp", 0) : (SharedPreferences) invokeV.objValue;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'UnknownHostException', keep only Throwable */
    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return InetAddress.getByName(str).getHostAddress();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return str + "-lastGetIpTime";
        }
        return (String) invokeL.objValue;
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return str + "-lastIpAddress";
        }
        return (String) invokeL.objValue;
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return str + "-lastLogTime";
        }
        return (String) invokeL.objValue;
    }

    public void g(String str, String str2, boolean z, boolean z2) {
        String str3;
        String host;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && !TextUtils.isEmpty(str) && j.z()) {
            try {
                URL url = new URL(str);
                String host2 = url.getHost();
                if ("c.tieba.baidu.com".equals(host2) || TextUtils.isEmpty(str2)) {
                    str3 = null;
                    host = url.getHost();
                } else {
                    str3 = host2;
                    host = str2;
                }
                if ("c.tieba.baidu.com".equals(host)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = this.f41644a;
                    long j2 = this.f41646c;
                    String str4 = this.f41645b;
                    if (currentTimeMillis - j > 43200000) {
                        h(host, str3, z, "12hour", z2);
                        return;
                    }
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(currentTimeMillis);
                    int i2 = calendar.get(6);
                    calendar.setTimeInMillis(j);
                    if (i2 != calendar.get(6)) {
                        h(host, str3, z, "newday", z2);
                    } else if (System.currentTimeMillis() - j2 > 3600000) {
                        String b2 = TextUtils.isEmpty(str3) ? b(host) : str3;
                        if (TextUtils.equals(b2, str4) && str4 != null) {
                            this.f41646c = System.currentTimeMillis();
                        } else {
                            h(host, b2, z, "ipchange", z2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void h(String str, String str2, boolean z, String str3, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(z2)}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str2 == null) {
            str2 = b(str);
        }
        if (str2 == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = System.currentTimeMillis();
        d.a.d.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.b("host", str);
        statsItem.b("hostip", str2);
        statsItem.c("issuc", Boolean.valueOf(z));
        statsItem.c("isuseip", Boolean.valueOf(z2));
        BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
        SharedPreferences a2 = a();
        EditorHelper.putLong(a2, f(str), currentTimeMillis);
        EditorHelper.putString(a2, e(str), str2);
        EditorHelper.putLong(a2, d(str), currentTimeMillis2);
        this.f41644a = currentTimeMillis;
        this.f41646c = currentTimeMillis2;
        this.f41645b = str2;
    }
}
