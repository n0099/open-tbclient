package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.repackage.an9;
import com.repackage.vn9;
import com.repackage.xm9;
import com.repackage.ym9;
/* loaded from: classes5.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int API_DISABLED = 23;
    public static final int API_DISABLED_FOR_CONNECTION = 24;
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR;
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_ACTIVITY_NOT_FOUND = 22;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    @NonNull
    public static final ConnectionResult RESULT_SUCCESS;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int zza;
    public final int zzb;
    @Nullable
    public final PendingIntent zzc;
    @Nullable
    public final String zzd;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-106896486, "Lcom/google/android/gms/common/ConnectionResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-106896486, "Lcom/google/android/gms/common/ConnectionResult;");
                return;
            }
        }
        RESULT_SUCCESS = new ConnectionResult(0);
        CREATOR = new vn9();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionResult(int i) {
        this(i, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (PendingIntent) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ConnectionResult(int i, int i2, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), pendingIntent, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.zza = i;
        this.zzb = i2;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    @NonNull
    public static String zza(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            if (i != 99) {
                if (i != 1500) {
                    switch (i) {
                        case -1:
                            return RomUtils.UNKNOWN;
                        case 0:
                            return "SUCCESS";
                        case 1:
                            return "SERVICE_MISSING";
                        case 2:
                            return "SERVICE_VERSION_UPDATE_REQUIRED";
                        case 3:
                            return "SERVICE_DISABLED";
                        case 4:
                            return "SIGN_IN_REQUIRED";
                        case 5:
                            return "INVALID_ACCOUNT";
                        case 6:
                            return "RESOLUTION_REQUIRED";
                        case 7:
                            return "NETWORK_ERROR";
                        case 8:
                            return "INTERNAL_ERROR";
                        case 9:
                            return "SERVICE_INVALID";
                        case 10:
                            return "DEVELOPER_ERROR";
                        case 11:
                            return "LICENSE_CHECK_FAILED";
                        default:
                            switch (i) {
                                case 13:
                                    return "CANCELED";
                                case 14:
                                    return "TIMEOUT";
                                case 15:
                                    return "INTERRUPTED";
                                case 16:
                                    return "API_UNAVAILABLE";
                                case 17:
                                    return "SIGN_IN_FAILED";
                                case 18:
                                    return "SERVICE_UPDATING";
                                case 19:
                                    return "SERVICE_MISSING_PERMISSION";
                                case 20:
                                    return "RESTRICTED_PROFILE";
                                case 21:
                                    return "API_VERSION_UPDATE_REQUIRED";
                                case 22:
                                    return "RESOLUTION_ACTIVITY_NOT_FOUND";
                                case 23:
                                    return "API_DISABLED";
                                case 24:
                                    return "API_DISABLED_FOR_CONNECTION";
                                default:
                                    StringBuilder sb = new StringBuilder(31);
                                    sb.append("UNKNOWN_ERROR_CODE(");
                                    sb.append(i);
                                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                                    return sb.toString();
                            }
                    }
                }
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            }
            return "UNFINISHED";
        }
        return (String) invokeI.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ConnectionResult) {
                ConnectionResult connectionResult = (ConnectionResult) obj;
                return this.zzb == connectionResult.zzb && xm9.a(this.zzc, connectionResult.zzc) && xm9.a(this.zzd, connectionResult.zzd);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzb : invokeV.intValue;
    }

    @Nullable
    public String getErrorMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zzd : (String) invokeV.objValue;
    }

    @Nullable
    public PendingIntent getResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzc : (PendingIntent) invokeV.objValue;
    }

    public boolean hasResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (this.zzb == 0 || this.zzc == null) ? false : true : invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? xm9.b(Integer.valueOf(this.zzb), this.zzc, this.zzd) : invokeV.intValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.zzb == 0 : invokeV.booleanValue;
    }

    public void startResolutionForResult(@NonNull Activity activity, int i) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, activity, i) == null) && hasResolution()) {
            PendingIntent pendingIntent = this.zzc;
            ym9.d(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            xm9.a c = xm9.c(this);
            c.a("statusCode", zza(this.zzb));
            c.a("resolution", this.zzc);
            c.a("message", this.zzd);
            return c.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i) == null) {
            int a = an9.a(parcel);
            an9.g(parcel, 1, this.zza);
            an9.g(parcel, 2, getErrorCode());
            an9.j(parcel, 3, getResolution(), i, false);
            an9.k(parcel, 4, getErrorMessage(), false);
            an9.b(parcel, a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), pendingIntent};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (PendingIntent) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i, pendingIntent, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), pendingIntent, str};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (PendingIntent) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
    }
}
