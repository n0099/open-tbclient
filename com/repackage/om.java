package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.status.PluginStatus;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Locale;
/* loaded from: classes6.dex */
public class om {
    public static /* synthetic */ Interceptable $ic;
    public static om b;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<String, PluginStatus> a;

    public om() {
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
        this.a = new LinkedHashMap<>(10);
    }

    public static om a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (om.class) {
                    if (b == null) {
                        b = new om();
                    }
                }
            }
            return b;
        }
        return (om) invokeV.objValue;
    }

    public PluginStatus b(String str) {
        InterceptResult invokeL;
        PluginStatus pluginStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (this.a) {
                pluginStatus = this.a.get(str);
                if (pluginStatus == null) {
                    pluginStatus = new PluginStatus();
                    this.a.put(str, pluginStatus);
                }
            }
            return pluginStatus;
        }
        return (PluginStatus) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str, String str2, String str3) {
        String string;
        String string2;
        String str4;
        String str5;
        PluginStatus b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            int i = 1;
            if ("rom_size".equals(str2)) {
                str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea7);
                str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea4);
            } else if ("plugin_install_retry_timeout".equals(str2) || "plugin_install_timeout".equals(str2)) {
                return;
            } else {
                if (str3 != null) {
                    String lowerCase = str3.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains("no_space_left_on_device") && !lowerCase.contains("no space left on device")) {
                        if (!lowerCase.contains("read-only_file_system") && !lowerCase.contains("read-only file system")) {
                            if (!lowerCase.contains("permission_denied") && !lowerCase.contains("permission denied")) {
                                if (!lowerCase.contains("fsync_failed") && !lowerCase.contains("fsync failed")) {
                                    string = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eaa);
                                    string2 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea5);
                                } else {
                                    String string3 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eaa);
                                    str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea5);
                                    str5 = string3;
                                    i = 5;
                                }
                            } else {
                                str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea6);
                                str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea3);
                                i = 4;
                            }
                        } else {
                            str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea6);
                            str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea3);
                            i = 3;
                        }
                        b2 = b(str);
                        if (b2 == null) {
                            b2 = new PluginStatus();
                        }
                        b2.a = PluginPackageManager.PluginStatus.ERROR;
                        b2.c = str5;
                        b2.d = str4;
                        b2.b = i;
                        b2.e = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, b2));
                    }
                    str5 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea7);
                    str4 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea4);
                } else {
                    string = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eaa);
                    string2 = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea5);
                }
                String str6 = string;
                str4 = string2;
                str5 = str6;
                b2 = b(str);
                if (b2 == null) {
                }
                b2.a = PluginPackageManager.PluginStatus.ERROR;
                b2.c = str5;
                b2.d = str4;
                b2.b = i;
                b2.e = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, b2));
            }
            i = 2;
            b2 = b(str);
            if (b2 == null) {
            }
            b2.a = PluginPackageManager.PluginStatus.ERROR;
            b2.c = str5;
            b2.d = str4;
            b2.b = i;
            b2.e = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000991, b2));
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            PluginStatus b2 = a().b(str);
            if (b2 != null) {
                b2.a = PluginPackageManager.PluginStatus.NROMAL;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000992, b2));
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            PluginStatus b2 = b(str);
            if (b2 == null) {
                b2 = new PluginStatus();
            }
            b2.a = PluginPackageManager.PluginStatus.ERROR;
            b2.b = 100;
            b2.c = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0eaa);
            b2.d = BdBaseApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ea5);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2000990, b2));
        }
    }
}
