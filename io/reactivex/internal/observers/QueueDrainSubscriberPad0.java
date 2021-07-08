package io.reactivex.internal.observers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class QueueDrainSubscriberPad0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long p1;
    public volatile long p10;
    public volatile long p11;
    public volatile long p12;
    public volatile long p13;
    public volatile long p14;
    public volatile long p15;
    public volatile long p2;
    public volatile long p3;
    public volatile long p4;
    public volatile long p5;
    public volatile long p6;
    public volatile long p7;
    public volatile long p8;
    public volatile long p9;

    public QueueDrainSubscriberPad0() {
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
