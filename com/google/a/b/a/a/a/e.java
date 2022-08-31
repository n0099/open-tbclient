package com.google.a.b.a.a.a;

import android.os.Bundle;
import android.os.Parcel;
import com.baidu.tieba.qm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class e extends com.google.a.a.b implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.a.a.b
    public final boolean a(int i, Parcel parcel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, parcel)) == null) {
            if (i == 1) {
                a((Bundle) qm9.a(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                b((Bundle) qm9.a(parcel, Bundle.CREATOR));
            } else if (i != 3) {
                return false;
            } else {
                qm9.a(parcel, Bundle.CREATOR);
                a();
            }
            return true;
        }
        return invokeIL.booleanValue;
    }
}
