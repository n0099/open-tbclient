package com.repackage;

import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.yunjiasu.tornadosdk.Pinger;
/* compiled from: lambda */
/* loaded from: classes7.dex */
public final /* synthetic */ class te9 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ te9 a = new te9();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ te9() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) ? Pinger.m71pingHandler$lambda0(message) : invokeL.booleanValue;
    }
}
