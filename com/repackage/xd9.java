package com.repackage;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.yunjiasu.tornadosdk.Pinger;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class xd9 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ xd9 a = new xd9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ xd9() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) ? Pinger.m96pingHandler$lambda0(message) : invokeL.booleanValue;
    }
}
