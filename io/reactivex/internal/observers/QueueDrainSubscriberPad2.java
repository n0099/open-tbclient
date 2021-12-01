package io.reactivex.internal.observers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class QueueDrainSubscriberPad2 extends QueueDrainSubscriberWip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long p10a;
    public volatile long p11a;
    public volatile long p12a;
    public volatile long p13a;
    public volatile long p14a;
    public volatile long p15a;
    public volatile long p1a;
    public volatile long p2a;
    public volatile long p3a;
    public volatile long p4a;
    public volatile long p5a;
    public volatile long p6a;
    public volatile long p7a;
    public volatile long p8a;
    public volatile long p9a;

    public QueueDrainSubscriberPad2() {
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
