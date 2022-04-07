package com.repackage;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class lm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lm b;
    public transient /* synthetic */ FieldHolder $fh;
    public jm a;

    /* loaded from: classes6.dex */
    public class a implements im {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(lm lmVar, im imVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lmVar, imVar};
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

    public lm() {
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
        new PluginNetConfigInfos();
    }

    public static lm a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (lm.class) {
                    if (b == null) {
                        b = new lm();
                    }
                }
            }
            return b;
        }
        return (lm) invokeV.objValue;
    }

    public void b(PluginSettings pluginSettings, boolean z, im imVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{pluginSettings, Boolean.valueOf(z), imVar}) == null) {
            km c = c(pluginSettings);
            jm jmVar = this.a;
            if (jmVar != null) {
                jmVar.a(z, c, new a(this, imVar));
            }
        }
    }

    public km c(PluginSettings pluginSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pluginSettings)) == null) {
            km kmVar = new km();
            ArrayList arrayList = new ArrayList();
            if (pluginSettings.getPlugins() != null) {
                for (Map.Entry<String, PluginSetting> entry : pluginSettings.getPlugins().entrySet()) {
                    PluginSetting value = entry.getValue();
                    if (value != null) {
                        arrayList.add(new BasicNameValuePair(value.packageName, String.valueOf(value.versionCode)));
                    }
                }
            }
            kmVar.a(arrayList);
            return kmVar;
        }
        return (km) invokeL.objValue;
    }
}
