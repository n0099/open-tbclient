package com.kwai.filedownloader.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.message.MessageSnapshot;
/* loaded from: classes5.dex */
public interface a extends IInterface {

    /* renamed from: com.kwai.filedownloader.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static abstract class AbstractBinderC0352a extends Binder implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.kwai.filedownloader.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0353a implements a {
            public static /* synthetic */ Interceptable $ic;
            public static a a;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder b;

            public C0353a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iBinder;
            }

            @Override // com.kwai.filedownloader.b.a
            public void a(MessageSnapshot messageSnapshot) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                        if (messageSnapshot != null) {
                            obtain.writeInt(1);
                            messageSnapshot.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.b.transact(1, obtain, null, 1) || AbstractBinderC0352a.a() == null) {
                            return;
                        }
                        AbstractBinderC0352a.a().a(messageSnapshot);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (IBinder) invokeV.objValue;
            }
        }

        public AbstractBinderC0352a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, "com.kwai.filedownloader.i.IFileDownloadIPCCallback");
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0353a.a : (a) invokeV.objValue;
        }

        public static a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0353a(iBinder) : (a) queryLocalInterface;
            }
            return (a) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i == 1) {
                    parcel.enforceInterface("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                    a(parcel.readInt() != 0 ? MessageSnapshot.CREATOR.createFromParcel(parcel) : null);
                    return true;
                } else if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel2.writeString("com.kwai.filedownloader.i.IFileDownloadIPCCallback");
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void a(MessageSnapshot messageSnapshot);
}
