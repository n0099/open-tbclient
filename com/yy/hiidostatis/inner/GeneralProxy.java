package com.yy.hiidostatis.inner;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.FlushManager;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class GeneralProxy {
    public static /* synthetic */ Interceptable $ic;
    public static Object OBJ_KEY;
    public static Hashtable<String, GeneralConfigTool> configToolContainer;
    public static FlushManager mFlushManager;
    public static Hashtable<String, GeneralStatisTool> statisToolContainer;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(746366313, "Lcom/yy/hiidostatis/inner/GeneralProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(746366313, "Lcom/yy/hiidostatis/inner/GeneralProxy;");
                return;
            }
        }
        statisToolContainer = new Hashtable<>();
        configToolContainer = new Hashtable<>();
        OBJ_KEY = FlushManager.class;
    }

    public GeneralProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized void exit(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) {
            synchronized (GeneralProxy.class) {
                try {
                    Enumeration<GeneralStatisTool> elements = statisToolContainer.elements();
                    while (elements.hasMoreElements()) {
                        GeneralStatisTool nextElement = elements.nextElement();
                        if (z) {
                            nextElement.getTaskManager().flush(context);
                        } else {
                            nextElement.getTaskManager().enableSend(z);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized void flushCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (GeneralProxy.class) {
                flushCache(context, true);
            }
        }
    }

    public static GeneralConfigTool getGeneralConfigInstance(Context context, AbstractConfig abstractConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, abstractConfig)) == null) {
            GeneralConfigTool generalConfigTool = configToolContainer.get(abstractConfig.getConfigKey());
            if (generalConfigTool == null) {
                GeneralConfigTool generalConfigTool2 = new GeneralConfigTool(context, abstractConfig);
                configToolContainer.put(abstractConfig.getConfigKey(), generalConfigTool2);
                L.info("GeneralProxy", "new GeneralConfigTool && configKey:%s", abstractConfig.getConfigKey());
                return generalConfigTool2;
            }
            return generalConfigTool;
        }
        return (GeneralConfigTool) invokeLL.objValue;
    }

    public static GeneralStatisTool getGeneralStatisInstance(Context context, AbstractConfig abstractConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, abstractConfig)) == null) {
            initFlushManager(context);
            GeneralStatisTool generalStatisTool = statisToolContainer.get(abstractConfig.getConfigKey());
            if (generalStatisTool == null) {
                GeneralStatisTool generalStatisTool2 = new GeneralStatisTool(context, abstractConfig);
                statisToolContainer.put(abstractConfig.getConfigKey(), generalStatisTool2);
                generalStatisTool2.getTaskManager().flush(context);
                L.info("GeneralProxy", "new GeneralStatisTool && configKey:%s", abstractConfig.getConfigKey());
                return generalStatisTool2;
            }
            return generalStatisTool;
        }
        return (GeneralStatisTool) invokeLL.objValue;
    }

    public static void initFlushManager(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, context) == null) && mFlushManager == null) {
            synchronized (OBJ_KEY) {
                if (mFlushManager == null) {
                    FlushManager flushManager = new FlushManager();
                    mFlushManager = flushManager;
                    flushManager.setFlushListener(new FlushManager.FlushListener() { // from class: com.yy.hiidostatis.inner.GeneralProxy.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.yy.hiidostatis.inner.FlushManager.FlushListener
                        public void fluch(Context context2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, context2) == null) {
                                GeneralProxy.flushCache(context2);
                            }
                        }
                    });
                    mFlushManager.regConnectionChangeReceiver(context);
                }
            }
        }
    }

    public static synchronized void start(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, context) == null) {
            synchronized (GeneralProxy.class) {
                try {
                    initFlushManager(context);
                    flushCache(context);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static synchronized void startTimer(Context context, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, l) == null) {
            synchronized (GeneralProxy.class) {
                initFlushManager(context);
                mFlushManager.startTimer(context, l);
            }
        }
    }

    public static synchronized void stopTimer(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            synchronized (GeneralProxy.class) {
                initFlushManager(context);
                mFlushManager.stopTimer(context);
            }
        }
    }

    public static void flushCache(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65540, null, context, z) == null) {
            if (!z) {
                try {
                    if (ProcessUtil.isBackground(context)) {
                        L.verbose("GeneralProxy", "app is Background ,no flush.", new Object[0]);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            Enumeration<GeneralStatisTool> elements = statisToolContainer.elements();
            while (elements.hasMoreElements()) {
                elements.nextElement().getTaskManager().flush(context);
            }
        }
    }
}
