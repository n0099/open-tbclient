package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes6.dex */
public interface f extends IInterface {
    void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException;

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.ss.android.socialbase.downloader.depend.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0497a implements f {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static f f38672a;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f38673b;

            public C0497a(IBinder iBinder) {
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
                this.f38673b = iBinder;
            }

            @Override // com.ss.android.socialbase.downloader.depend.f
            public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                        if (downloadInfo != null) {
                            obtain.writeInt(1);
                            downloadInfo.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (baseException != null) {
                            obtain.writeInt(1);
                            baseException.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i2);
                        if (!this.f38673b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                            a.a().a(downloadInfo, baseException, i2);
                        } else {
                            obtain2.readException();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38673b : (IBinder) invokeV.objValue;
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, "com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
        }

        public static f a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                    return (f) queryLocalInterface;
                }
                return new C0497a(iBinder);
            }
            return (f) invokeL.objValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 != 1) {
                    if (i2 != 1598968902) {
                        return super.onTransact(i2, parcel, parcel2, i3);
                    }
                    parcel2.writeString("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                    return true;
                }
                parcel.enforceInterface("com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend");
                a(parcel.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BaseException.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public static f a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C0497a.f38672a : (f) invokeV.objValue;
        }
    }
}
