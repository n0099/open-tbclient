package com.yy.hiidostatis.config;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import com.yy.hiidostatis.inner.util.ThreadPool;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ABTestHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FALSE = 1;
    public static final String KEY_PREFERENCE_ABTEST = "ab_test_config";
    public static final int TRUE = 2;
    public static ABTestHandler instance;
    public static boolean loaded;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile Map map;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1410576962, "Lcom/yy/hiidostatis/config/ABTestHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1410576962, "Lcom/yy/hiidostatis/config/ABTestHandler;");
                return;
            }
        }
        instance = new ABTestHandler();
        loaded = false;
    }

    public ABTestHandler() {
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
        this.map = new HashMap();
    }

    public static ABTestHandler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return instance;
        }
        return (ABTestHandler) invokeV.objValue;
    }

    public static void updateValue(Context context, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65547, null, context, map) == null) && map != null && !map.isEmpty()) {
            ThreadPool.getPool().execute(new Runnable(context, map) { // from class: com.yy.hiidostatis.config.ABTestHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Map val$ab;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {context, map};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$context = context;
                    this.val$ab = map;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ABTestHandler.updateValueInner(this.val$context, this.val$ab);
                    }
                }
            });
        }
    }

    public static int getAbInteger(ABNameDefine aBNameDefine) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aBNameDefine)) == null) {
            Integer num = (Integer) getInstance().map.get(aBNameDefine.getName());
            if (num == null) {
                return aBNameDefine.getDefaultValue();
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public static void initInstance(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            instance.loadConfig(context);
        }
    }

    public static String parseTest(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("val");
                if (jSONObject2 == null) {
                    return null;
                }
                return jSONObject2.getString("action");
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean getAbBoolean(ABNameDefine aBNameDefine) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aBNameDefine)) == null) {
            Integer num = (Integer) getInstance().map.get(aBNameDefine.getName());
            if (num == null) {
                if (aBNameDefine.getDefaultValue() == 2) {
                    return true;
                }
            } else if (num.intValue() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private synchronized void loadConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            synchronized (this) {
                if (loaded) {
                    return;
                }
                String string = context.getSharedPreferences(KEY_PREFERENCE_ABTEST, 4).getString(KEY_PREFERENCE_ABTEST, null);
                if (string != null) {
                    for (String str : string.split(ParamableElem.DIVIDE_PARAM)) {
                        String[] split = str.split("=");
                        if (split.length == 2) {
                            this.map.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
                        }
                    }
                }
                loaded = true;
            }
        }
    }

    public static void updateMemoryValue(Context context, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, map) == null) {
            if (!loaded) {
                getInstance().loadConfig(context);
            }
            for (Map.Entry entry : map.entrySet()) {
                getInstance().map.put(entry.getKey(), Integer.valueOf(Integer.parseInt((String) entry.getValue())));
            }
        }
    }

    public static void updateValue(Context context, String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65548, null, context, strArr) == null) && strArr != null && strArr.length != 0) {
            ThreadPool.getPool().execute(new Runnable(strArr, context) { // from class: com.yy.hiidostatis.config.ABTestHandler.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String[] val$json;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {strArr, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$json = strArr;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String parseTest;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        HashMap hashMap = new HashMap();
                        for (String str : this.val$json) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (next.startsWith("hiido_") && (parseTest = ABTestHandler.parseTest(jSONObject.getJSONObject(next))) != null && !parseTest.isEmpty()) {
                                        hashMap.put(next, parseTest);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (!hashMap.isEmpty()) {
                            ABTestHandler.updateValueInner(this.val$context, hashMap);
                        }
                    }
                }
            });
        }
    }

    public static void updateValueInner(Context context, Map map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, context, map) == null) && map != null && !map.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : map.entrySet()) {
                    if (((String) entry.getKey()).startsWith("hiido_")) {
                        String[] split = ((String) entry.getKey()).split("_");
                        sb.append(split[split.length - 1]);
                        sb.append("=");
                        sb.append((String) entry.getValue());
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
                sb.setLength(sb.length() - 1);
                context.getSharedPreferences(KEY_PREFERENCE_ABTEST, 4).edit().putString(KEY_PREFERENCE_ABTEST, sb.toString()).apply();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
