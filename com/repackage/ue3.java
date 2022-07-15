package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.channels.Channel;
/* loaded from: classes7.dex */
public final class ue3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable Channel channel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, channel) == null) && channel != null && channel.isOpen()) {
            jg4.d(channel);
        }
    }
}
