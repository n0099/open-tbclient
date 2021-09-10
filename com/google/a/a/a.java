package com.google.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a implements IInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f70063a;

    /* renamed from: b  reason: collision with root package name */
    public final String f70064b;

    public a(IBinder iBinder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iBinder, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70063a = iBinder;
        this.f70064b = str;
    }

    public final Parcel a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(this.f70064b);
            return obtain;
        }
        return (Parcel) invokeV.objValue;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70063a : (IBinder) invokeV.objValue;
    }

    public final void b(int i2, Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, parcel) == null) {
            try {
                this.f70063a.transact(i2, parcel, null, 1);
            } finally {
                parcel.recycle();
            }
        }
    }

    public final Parcel a(int i2, Parcel parcel) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, parcel)) == null) {
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    this.f70063a.transact(i2, parcel, obtain, 0);
                    obtain.readException();
                    return obtain;
                } catch (RuntimeException e2) {
                    obtain.recycle();
                    throw e2;
                }
            } finally {
                parcel.recycle();
            }
        }
        return (Parcel) invokeIL.objValue;
    }
}
