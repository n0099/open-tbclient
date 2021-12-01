package com.tachikoma.core.component.anim;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class TimeFunctionConst {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface Time {
        public static final String EASE_IN = "EaseIn";
        public static final String EASE_IN_OUT = "EaseInEaseOut";
        public static final String EASE_OUT = "EaseOut";
        public static final String LINEAR = "Linear";
    }

    /* loaded from: classes2.dex */
    public interface Timing {
        public static final String EASE_IN = "ease-in";
        public static final String EASE_IN_OUT = "ease-in-out";
        public static final String EASE_OUT = "ease-out";
        public static final String LINEAR = "linear";
    }

    public TimeFunctionConst() {
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
}
