package com.win.opensdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes7.dex */
public abstract class b extends Binder implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(IBinder iBinder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iBinder)) == null) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }
        return (c) invokeL.objValue;
    }
}
