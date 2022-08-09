package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.common.internal.IAccountAccessor;
/* loaded from: classes5.dex */
public class AccountAccessor extends IAccountAccessor.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Account getAccountBinderSafe(@NonNull IAccountAccessor iAccountAccessor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iAccountAccessor)) == null) {
            Account account = null;
            if (iAccountAccessor != null) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        account = iAccountAccessor.zzb();
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                    }
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
            return account;
        }
        return (Account) invokeL.objValue;
    }

    public final boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            throw null;
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.gms.common.internal.IAccountAccessor
    @NonNull
    public final Account zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw null;
        }
        return (Account) invokeV.objValue;
    }
}
