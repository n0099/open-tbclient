package io.reactivex.internal.subscribers;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class QueueDrainSubscriberPad4 extends QueueDrainSubscriberPad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long q1;
    public volatile long q10;
    public volatile long q11;
    public volatile long q12;
    public volatile long q13;
    public volatile long q14;
    public volatile long q15;
    public volatile long q2;
    public volatile long q3;
    public volatile long q4;
    public volatile long q5;
    public volatile long q6;
    public volatile long q7;
    public volatile long q8;
    public volatile long q9;

    public QueueDrainSubscriberPad4() {
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
