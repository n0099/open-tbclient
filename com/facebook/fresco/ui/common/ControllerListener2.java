package com.facebook.fresco.ui.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import javax.annotation.Nullable;
@Deprecated
/* loaded from: classes7.dex */
public interface ControllerListener2 {
    void onFailure(String str, Throwable th, @Nullable Extras extras);

    void onFinalImageSet(String str, @Nullable Object obj, Extras extras);

    void onIntermediateImageFailed(String str);

    void onIntermediateImageSet(String str, @Nullable Object obj);

    void onRelease(String str, @Nullable Extras extras);

    void onSubmit(String str, Object obj, @Nullable Extras extras);

    /* loaded from: classes7.dex */
    public class Extras {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public Map pipe;
        @Nullable

        /* renamed from: view  reason: collision with root package name */
        public Map f1068view;

        public Extras() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "pipe: " + this.pipe + ", view: " + this.f1068view;
            }
            return (String) invokeV.objValue;
        }

        public static Extras of(@Nullable Map map, @Nullable Map map2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, map2)) == null) {
                Extras extras = new Extras();
                extras.pipe = map;
                extras.f1068view = map2;
                return extras;
            }
            return (Extras) invokeLL.objValue;
        }
    }
}
