package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class pr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Message<?> message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, message) == null) {
            MessageManager.getInstance().sendMessage(message);
        }
    }
}
