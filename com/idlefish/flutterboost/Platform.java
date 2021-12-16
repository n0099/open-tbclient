package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterView;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class Platform {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FlutterBoost.BoostLifecycleListener lifecycleListener;

    public Platform() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void closeContainer(IContainerRecord iContainerRecord, Map<String, Object> map, Map<String, Object> map2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, iContainerRecord, map, map2) == null) || iContainerRecord == null) {
            return;
        }
        iContainerRecord.getContainer().finishContainer(map);
    }

    public abstract String dartEntrypoint();

    public abstract FlutterEngineProvider flutterEngineProvider();

    public abstract Application getApplication();

    public abstract Class<? extends FlutterView> getFlutterViewClass();

    public abstract String initialRoute();

    public abstract boolean isDebug();

    public abstract void openContainer(Context context, String str, Map<String, Object> map, int i2, Map<String, Object> map2);

    public abstract FlutterView.RenderMode renderMode();

    public abstract List<String> shellArgs();

    public abstract int whenEngineStart();
}
