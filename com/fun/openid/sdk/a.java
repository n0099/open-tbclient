package com.fun.openid.sdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public interface a extends IInterface {

    /* renamed from: com.fun.openid.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static abstract class AbstractBinderC1862a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f62884a = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.fun.openid.sdk.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C1863a implements a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f62885a;

            public C1863a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f62885a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62885a : (IBinder) invokeV.objValue;
            }
        }
    }
}
