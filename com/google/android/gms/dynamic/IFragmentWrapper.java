package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ap9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes7.dex */
public interface IFragmentWrapper extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
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

        @NonNull
        public static IFragmentWrapper asInterface(@NonNull IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new zza(iBinder);
            }
            return (IFragmentWrapper) invokeL.objValue;
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i, @NonNull Parcel parcel, @NonNull Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                switch (i) {
                    case 2:
                        IObjectWrapper zzg = zzg();
                        parcel2.writeNoException();
                        ap9.e(parcel2, zzg);
                        return true;
                    case 3:
                        Bundle zzd = zzd();
                        parcel2.writeNoException();
                        ap9.d(parcel2, zzd);
                        return true;
                    case 4:
                        int zzb = zzb();
                        parcel2.writeNoException();
                        parcel2.writeInt(zzb);
                        return true;
                    case 5:
                        IFragmentWrapper zze = zze();
                        parcel2.writeNoException();
                        ap9.e(parcel2, zze);
                        return true;
                    case 6:
                        IObjectWrapper zzh = zzh();
                        parcel2.writeNoException();
                        ap9.e(parcel2, zzh);
                        return true;
                    case 7:
                        boolean zzs = zzs();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzs);
                        return true;
                    case 8:
                        String zzj = zzj();
                        parcel2.writeNoException();
                        parcel2.writeString(zzj);
                        return true;
                    case 9:
                        IFragmentWrapper zzf = zzf();
                        parcel2.writeNoException();
                        ap9.e(parcel2, zzf);
                        return true;
                    case 10:
                        int zzc = zzc();
                        parcel2.writeNoException();
                        parcel2.writeInt(zzc);
                        return true;
                    case 11:
                        boolean zzt = zzt();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzt);
                        return true;
                    case 12:
                        IObjectWrapper zzi = zzi();
                        parcel2.writeNoException();
                        ap9.e(parcel2, zzi);
                        return true;
                    case 13:
                        boolean zzu = zzu();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzu);
                        return true;
                    case 14:
                        boolean zzv = zzv();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzv);
                        return true;
                    case 15:
                        boolean zzw = zzw();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzw);
                        return true;
                    case 16:
                        boolean zzx = zzx();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzx);
                        return true;
                    case 17:
                        boolean zzy = zzy();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzy);
                        return true;
                    case 18:
                        boolean zzz = zzz();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzz);
                        return true;
                    case 19:
                        boolean zzA = zzA();
                        parcel2.writeNoException();
                        ap9.b(parcel2, zzA);
                        return true;
                    case 20:
                        zzk(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        zzl(ap9.f(parcel));
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        zzm(ap9.f(parcel));
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        zzn(ap9.f(parcel));
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        zzo(ap9.f(parcel));
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        zzp((Intent) ap9.a(parcel, Intent.CREATOR));
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        zzq((Intent) ap9.a(parcel, Intent.CREATOR), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        zzr(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    default:
                        return false;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    boolean zzA() throws RemoteException;

    int zzb() throws RemoteException;

    int zzc() throws RemoteException;

    @Nullable
    Bundle zzd() throws RemoteException;

    @Nullable
    IFragmentWrapper zze() throws RemoteException;

    @Nullable
    IFragmentWrapper zzf() throws RemoteException;

    @NonNull
    IObjectWrapper zzg() throws RemoteException;

    @NonNull
    IObjectWrapper zzh() throws RemoteException;

    @NonNull
    IObjectWrapper zzi() throws RemoteException;

    @Nullable
    String zzj() throws RemoteException;

    void zzk(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(boolean z) throws RemoteException;

    void zzm(boolean z) throws RemoteException;

    void zzn(boolean z) throws RemoteException;

    void zzo(boolean z) throws RemoteException;

    void zzp(@NonNull Intent intent) throws RemoteException;

    void zzq(@NonNull Intent intent, int i) throws RemoteException;

    void zzr(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs() throws RemoteException;

    boolean zzt() throws RemoteException;

    boolean zzu() throws RemoteException;

    boolean zzv() throws RemoteException;

    boolean zzw() throws RemoteException;

    boolean zzx() throws RemoteException;

    boolean zzy() throws RemoteException;

    boolean zzz() throws RemoteException;
}
