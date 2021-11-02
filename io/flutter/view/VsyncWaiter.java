package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.engine.FlutterJNI;
/* loaded from: classes3.dex */
public class VsyncWaiter {
    public static /* synthetic */ Interceptable $ic;
    public static VsyncWaiter instance;
    public transient /* synthetic */ FieldHolder $fh;
    public final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
    @NonNull
    public final WindowManager windowManager;

    public VsyncWaiter(@NonNull WindowManager windowManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {windowManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate(this) { // from class: io.flutter.view.VsyncWaiter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VsyncWaiter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
            public void asyncWaitForVsync(long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                    Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback(this, j) { // from class: io.flutter.view.VsyncWaiter.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass1 this$1;
                        public final /* synthetic */ long val$cookie;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, Long.valueOf(j)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$cookie = j;
                        }

                        @Override // android.view.Choreographer.FrameCallback
                        public void doFrame(long j2) {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeJ(1048576, this, j2) == null) {
                                FlutterJNI.nativeOnVsync(j2, j2 + ((long) (1.0E9d / this.this$1.this$0.windowManager.getDefaultDisplay().getRefreshRate())), this.val$cookie);
                            }
                        }
                    });
                }
            }
        };
        this.windowManager = windowManager;
    }

    @NonNull
    public static VsyncWaiter getInstance(@NonNull WindowManager windowManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, windowManager)) == null) {
            if (instance == null) {
                instance = new VsyncWaiter(windowManager);
            }
            return instance;
        }
        return (VsyncWaiter) invokeL.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FlutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
            FlutterJNI.setRefreshRateFPS(this.windowManager.getDefaultDisplay().getRefreshRate());
        }
    }
}
