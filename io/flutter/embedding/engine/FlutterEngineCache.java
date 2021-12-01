package io.flutter.embedding.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class FlutterEngineCache {
    public static /* synthetic */ Interceptable $ic;
    public static FlutterEngineCache instance;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, FlutterEngine> cachedEngines;

    @VisibleForTesting
    public FlutterEngineCache() {
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
        this.cachedEngines = new HashMap();
    }

    @NonNull
    public static FlutterEngineCache getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (instance == null) {
                instance = new FlutterEngineCache();
            }
            return instance;
        }
        return (FlutterEngineCache) invokeV.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.cachedEngines.clear();
        }
    }

    public boolean contains(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.cachedEngines.containsKey(str) : invokeL.booleanValue;
    }

    @Nullable
    public FlutterEngine get(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.cachedEngines.get(str) : (FlutterEngine) invokeL.objValue;
    }

    public void put(@NonNull String str, @Nullable FlutterEngine flutterEngine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, flutterEngine) == null) {
            if (flutterEngine != null) {
                this.cachedEngines.put(str, flutterEngine);
            } else {
                this.cachedEngines.remove(str);
            }
        }
    }

    public void remove(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            put(str, null);
        }
    }
}
