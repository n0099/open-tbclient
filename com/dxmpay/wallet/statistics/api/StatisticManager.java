package com.dxmpay.wallet.statistics.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.NoProguard;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes2.dex */
public class StatisticManager implements NoProguard {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static SensorStatisticApi f56164e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static StatisticManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514559505, "Lcom/dxmpay/wallet/statistics/api/StatisticManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-514559505, "Lcom/dxmpay/wallet/statistics/api/StatisticManager$b;");
                    return;
                }
            }
            a = new StatisticManager(null);
        }
    }

    public /* synthetic */ StatisticManager(a aVar) {
        this();
    }

    public static StatisticManager a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (StatisticManager) invokeV.objValue;
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                f56164e.onEvent(str);
            }
        }
    }

    public static void onEventEnd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                f56164e.onEventEnd(str);
            }
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65545, null, str, i2, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tresultCode: " + i2;
                String str5 = "\tvalue: " + str2;
                f56164e.onEventEndWithValue(str, i2, str2);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, str, i2, collection) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                String str3 = "\tresultCode: " + i2;
                if (collection != null) {
                    String str4 = "\tvalues: " + collection.toString();
                }
                f56164e.onEventEndWithValues(str, i2, collection);
            }
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                f56164e.onEventStart(str);
            }
        }
    }

    public static void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tvalue: " + str2;
                f56164e.onEventWithValue(str, str2);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, str, collection) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                if (collection != null) {
                    String str3 = "\tvalues: " + collection.toString();
                }
                f56164e.onEventWithValues(str, collection);
            }
        }
    }

    public static void triggerSending() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            a();
            SensorStatisticApi sensorStatisticApi = f56164e;
            if (sensorStatisticApi != null) {
                sensorStatisticApi.triggerSending();
            }
        }
    }

    public StatisticManager() {
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
        f56164e = SensorStatisticApi.getInstance();
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tabType: " + str2;
                f56164e.onEvent(str, str2);
            }
        }
    }

    public static void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, str, i2) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                String str3 = "\tresultCode: " + i2;
                f56164e.onEventEnd(str, i2);
            }
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, str, str2, str3) == null) {
            a();
            if (f56164e != null) {
                String str4 = "\tEventId: " + str;
                String str5 = "\tabType: " + str3;
                String str6 = "\tvalue: " + str2;
                f56164e.onEventWithValue(str, str2, str3);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, str, collection, map) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                if (collection != null) {
                    String str3 = "\tvalues: " + collection.toString();
                }
                if (map != null) {
                    String str4 = "\tkv: " + map.toString();
                }
                f56164e.onEventWithValues(str, collection, map);
            }
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65546, null, str, i2, str2, str3) == null) {
            a();
            if (f56164e != null) {
                String str4 = "\tEventId: " + str;
                String str5 = "\tresultCode: " + i2;
                String str6 = "\tvalue: " + str2;
                String str7 = "\tabType: " + str3;
                f56164e.onEventEndWithValue(str, i2, str2, str3);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65551, null, str, i2, collection, map) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                String str3 = "\tresultCode: " + i2;
                if (collection != null) {
                    String str4 = "\tvalues: " + collection.toString();
                }
                if (map != null) {
                    String str5 = "\tkv: " + map.toString();
                }
                f56164e.onEventEndWithValues(str, i2, collection, map);
            }
        }
    }

    public static void onEventEnd(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tabType: " + str2;
                f56164e.onEventEnd(str, str2);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, str, collection, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tabType: " + str2;
                if (collection != null) {
                    String str5 = "\tvalues: " + collection.toString();
                }
                f56164e.onEventWithValues(str, collection, str2);
            }
        }
    }

    public static void onEventEndWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tvalue: " + str2;
                f56164e.onEventEndWithValue(str, str2);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65550, null, str, i2, collection, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tresultCode: " + i2;
                String str5 = "\tabType: " + str2;
                if (collection != null) {
                    String str6 = "\tvalues: " + collection.toString();
                }
                f56164e.onEventEndWithValues(str, i2, collection, str2);
            }
        }
    }

    public static void onEventEnd(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, str, i2, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tresultCode: " + i2;
                String str5 = "\tabType: " + str2;
                f56164e.onEventEnd(str, i2, str2);
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, null, str, collection, map, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tabType: " + str2;
                if (collection != null) {
                    String str5 = "\tvalues: " + collection.toString();
                }
                if (map != null) {
                    String str6 = "\tkv: " + map.toString();
                }
                f56164e.onEventWithValues(str, collection, map, str2);
            }
        }
    }

    public static void onEventEndWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, str, str2, str3) == null) {
            a();
            if (f56164e != null) {
                String str4 = "\tEventId: " + str;
                String str5 = "\tvalue: " + str2;
                String str6 = "\tabType: " + str3;
                f56164e.onEventEndWithValue(str, str2, str3);
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{str, Integer.valueOf(i2), collection, map, str2}) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tresultCode: " + i2;
                String str5 = "\tabType: " + str2;
                if (collection != null) {
                    String str6 = "\tvalues: " + collection.toString();
                }
                if (map != null) {
                    String str7 = "\tkv: " + map.toString();
                }
                f56164e.onEventEndWithValues(str, i2, collection, map, str2);
            }
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, collection) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                if (collection != null) {
                    String str3 = "\tvalues: " + collection.toString();
                }
                f56164e.onEventEndWithValues(str, collection);
            }
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, str, collection, map) == null) {
            a();
            if (f56164e != null) {
                String str2 = "\tEventId: " + str;
                if (collection != null) {
                    String str3 = "\tvalues: " + collection.toString();
                }
                if (map != null) {
                    String str4 = "\tkv: " + map.toString();
                }
                f56164e.onEventEndWithValues(str, collection, map);
            }
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, str, collection, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tabType: " + str2;
                if (collection != null) {
                    String str5 = "\tvalues: " + collection.toString();
                }
                f56164e.onEventEndWithValues(str, collection, str2);
            }
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, null, str, collection, map, str2) == null) {
            a();
            if (f56164e != null) {
                String str3 = "\tEventId: " + str;
                String str4 = "\tabType: " + str2;
                if (collection != null) {
                    String str5 = "\tvalues: " + collection.toString();
                }
                if (map != null) {
                    String str6 = "\tkv: " + map.toString();
                }
                f56164e.onEventEndWithValues(str, collection, map, str2);
            }
        }
    }
}
