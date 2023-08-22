package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class Status extends Result implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<Status> CREATOR;
    public static final Status CoreException;
    public static final Status FAILURE;
    public static final Status MessageNotFound;
    @Deprecated
    public static final Status RESULT_CANCELED;
    @Deprecated
    public static final Status RESULT_DEAD_CLIENT;
    @Deprecated
    public static final Status RESULT_INTERNAL_ERROR;
    @Deprecated
    public static final Status RESULT_INTERRUPTED;
    @Deprecated
    public static final Status RESULT_TIMEOUT;
    public static final Status SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    @Packed
    public Intent intent;
    @Packed
    public PendingIntent pendingIntent;
    @Packed
    public int statusCode;
    @Packed
    public String statusMessage;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public Status getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (Status) invokeV.objValue;
    }

    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes10.dex */
    public static class a implements Parcelable.Creator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public Status createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new Status(parcel.readInt(), parcel.readString(), PendingIntent.readPendingIntentOrNullFromParcel(parcel));
            }
            return (Status) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        public Status[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return new Status[i];
            }
            return (Status[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1513512471, "Lcom/huawei/hms/support/api/client/Status;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1513512471, "Lcom/huawei/hms/support/api/client/Status;");
                return;
            }
        }
        SUCCESS = new Status(0);
        FAILURE = new Status(1);
        RESULT_CANCELED = new Status(16);
        RESULT_DEAD_CLIENT = new Status(18);
        RESULT_INTERNAL_ERROR = new Status(8);
        RESULT_INTERRUPTED = new Status(14);
        RESULT_TIMEOUT = new Status(15);
        MessageNotFound = new Status(404);
        CoreException = new Status(500);
        CREATOR = new a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Status(int i) {
        this(i, null);
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
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Status)) {
                return false;
            }
            Status status = (Status) obj;
            if (this.statusCode == status.statusCode && equal(this.statusMessage, status.statusMessage) && equal(this.pendingIntent, status.pendingIntent) && equal(this.intent, status.intent)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Status(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.statusCode = i;
        this.statusMessage = str;
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, pendingIntent};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.statusCode = i;
        this.statusMessage = str;
        this.pendingIntent = pendingIntent;
    }

    public Status(int i, String str, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, intent};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.statusCode = i;
        this.statusMessage = str;
        this.intent = intent;
    }

    public static boolean equal(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, obj2)) == null) {
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048591, this, activity, i) == null) && hasResolution()) {
            PendingIntent pendingIntent = this.pendingIntent;
            if (pendingIntent != null) {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
            } else {
                activity.startActivityForResult(this.intent, i);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i) == null) {
            parcel.writeInt(this.statusCode);
            parcel.writeString(this.statusMessage);
            PendingIntent pendingIntent = this.pendingIntent;
            if (pendingIntent != null) {
                pendingIntent.writeToParcel(parcel, i);
            }
            PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, parcel);
            Intent intent = this.intent;
            if (intent != null) {
                intent.writeToParcel(parcel, i);
            }
        }
    }

    public String getErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getStatusMessage();
        }
        return (String) invokeV.objValue;
    }

    public PendingIntent getResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.pendingIntent;
        }
        return (PendingIntent) invokeV.objValue;
    }

    public Intent getResolutionIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.intent;
        }
        return (Intent) invokeV.objValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.statusCode;
        }
        return invokeV.intValue;
    }

    public String getStatusMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.statusMessage;
        }
        return (String) invokeV.objValue;
    }

    public boolean hasResolution() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.pendingIntent == null && this.intent == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent, this.intent});
        }
        return invokeV.intValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.statusCode <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, intent) == null) {
            this.intent = intent;
        }
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pendingIntent) == null) {
            this.pendingIntent = pendingIntent;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "{statusCode: " + this.statusCode + ", statusMessage: " + this.statusMessage + ", pendingIntent: " + this.pendingIntent + ", intent: " + this.intent + ",}";
        }
        return (String) invokeV.objValue;
    }
}
