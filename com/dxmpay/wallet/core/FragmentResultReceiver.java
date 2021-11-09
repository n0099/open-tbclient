package com.dxmpay.wallet.core;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes11.dex */
public class FragmentResultReceiver extends ResultReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f62550a;

    /* loaded from: classes11.dex */
    public interface a {
        void onReceiveResult(int i2, Bundle bundle);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62550a = null;
        }
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i2, Bundle bundle) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bundle) == null) || (aVar = this.f62550a) == null) {
            return;
        }
        aVar.onReceiveResult(i2, bundle);
    }
}
