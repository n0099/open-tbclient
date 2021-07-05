package com.yxcorp.kuaishou.addfp.a.b.a;

import android.os.IBinder;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IBinder f43713a;

    public d(IBinder iBinder) {
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
        this.f43713a = iBinder;
    }

    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f43713a.transact(1, obtain, obtain2, 0);
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

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43713a : (IBinder) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE, MOVE_EXCEPTION, INVOKE, CONST_STR, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f43713a.transact(2, obtain, obtain2, 0);
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
    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f43713a.transact(3, obtain, obtain2, 0);
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
    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String d() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f43713a.transact(4, obtain, obtain2, 0);
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
    @Override // com.yxcorp.kuaishou.addfp.a.b.a.b
    public final String e() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.f43713a.transact(5, obtain, obtain2, 0);
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
}
