package com.repackage;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.data.UserStickinessSQLiteOpenHelper;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class bm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bm b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Integer> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1964044006, "Lcom/repackage/bm;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1964044006, "Lcom/repackage/bm;");
        }
    }

    public bm() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public static synchronized bm b() {
        InterceptResult invokeV;
        bm bmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (bm.class) {
                if (b == null) {
                    synchronized (bm.class) {
                        if (b == null) {
                            b = new bm();
                        }
                    }
                }
                bmVar = b;
            }
            return bmVar;
        }
        return (bm) invokeV.objValue;
    }

    public final void a(sg sgVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, sgVar) == null) || sgVar == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.a.entrySet()) {
            sgVar.b(entry.getKey() + "_count", String.valueOf(entry.getValue()));
        }
        this.a.clear();
    }

    public final sg c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BdStatisticsManager.getInstance().getStatsItem("dbg") : (sg) invokeV.objValue;
    }

    public void d(String str, String str2, PluginSetting pluginSetting, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, pluginSetting, str3) == null) {
            if (pluginSetting == null) {
                pluginSetting = lm.h().g(str2);
            }
            int i = pluginSetting != null ? pluginSetting.install_fail_count : 0;
            j(str, null, str2, "failContent_" + i + "-callFrom_" + str3);
        }
    }

    public void e(String str, String str2, PluginSetting pluginSetting, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, pluginSetting, str3) == null) {
            if (pluginSetting == null) {
                pluginSetting = lm.h().g(str2);
            }
            int i = pluginSetting != null ? pluginSetting.install_fail_count : 0;
            j(str, str3, str2, "failContent_" + i);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false) : invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            j(str, null, null, null);
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            j(str, null, null, UserStickinessSQLiteOpenHelper.COUNT_PREFIX + i);
        }
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            j(str, null, str2, null);
        }
    }

    public final void j(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            sg c = c();
            if (str != null) {
                c.b("workflow", str);
            }
            if (str2 != null) {
                c.b("reason", str2);
            }
            if (str3 != null) {
                c.b("pname", str3);
            }
            if (str4 != null) {
                c.b("comment", str4);
            }
            c.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings i = lm.h().i();
            if (i != null) {
                c.b("pver", i.getContainerVersion());
            }
            c.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdLog.e(c.toString());
            BdStatisticsManager.getInstance().debug("pluginproxy", c);
        }
    }

    public void k(String str, long j, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i), str2}) == null) {
            sg c = c();
            c.b("workflow", str + "_cost");
            c.c("cost", Long.valueOf(j));
            if (i != 0) {
                c.c("count", Integer.valueOf(i));
            }
            if (str2 != null) {
                c.b("pname", str2);
            }
            c.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings i2 = lm.h().i();
            if (i2 != null) {
                c.b("pver", i2.getContainerVersion());
            }
            c.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", c);
        }
    }

    public void l(String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
            k(str, j, 0, str2);
        }
    }

    public void m(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, str3, str4) == null) {
            sg c = c();
            if (str != null) {
                c.b("workflow", str + "_debug");
            }
            if (str2 != null) {
                c.b("reason", str2);
            }
            if (str3 != null) {
                c.b("pname", str3);
            }
            if (str4 != null) {
                c.b("comment", str4);
            }
            c.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings i = lm.h().i();
            if (i != null) {
                c.b("pver", i.getContainerVersion());
            }
            c.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdLog.e(c.toString());
            BdStatisticsManager.getInstance().debug("pluginproxy", c);
        }
    }

    public void n(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048588, this, str, str2, str3, str4) == null) {
            j(str, str3, str2, str4);
        }
    }

    public void o(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, str3) == null) {
            p(str, str2, str3, null);
        }
    }

    public void p(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, str3, str4) == null) {
            sg c = c();
            if (str != null) {
                c.b("workflow", str + "_failure");
            }
            if (str2 != null) {
                c.b("reason", str2);
            }
            if (str3 != null) {
                c.b("pname", str3);
            }
            a(c);
            if (str4 != null) {
                c.b("comment", str4);
            }
            c.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings i = lm.h().i();
            if (i != null) {
                c.b("pver", i.getContainerVersion());
            }
            c.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdLog.e(c.toString());
            BdStatisticsManager.getInstance().debug("pluginproxy", c);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || str == null) {
            return;
        }
        Integer num = this.a.get(str);
        if (num == null) {
            num = 0;
        }
        this.a.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        q(str);
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
        }
    }
}
