package com.yxcorp.kuaishou.addfp.a.b.c;

import android.os.IBinder;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IBinder f43722a;

    public c(IBinder iBinder) {
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
        this.f43722a = iBinder;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.f43722a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } finally {
                try {
                    return str;
                } finally {
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                obtain.writeString(str);
                this.f43722a.transact(4, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
            } finally {
                try {
                    return str2;
                } finally {
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43722a : (IBinder) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.f43722a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } finally {
                try {
                    return str;
                } finally {
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                obtain.writeString(str);
                this.f43722a.transact(5, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
            } finally {
                try {
                    return str2;
                } finally {
                }
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.c.a
    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                this.f43722a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                r2 = obtain2.readInt() != 0;
                obtain2.recycle();
                obtain.recycle();
                return r2;
            } catch (Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
                return r2;
            }
        }
        return invokeV.booleanValue;
    }
}
