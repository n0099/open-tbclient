package com.google.ar.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public class Anchor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f32949a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class CloudAnchorState {
        public static final /* synthetic */ CloudAnchorState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloudAnchorState ERROR_CLOUD_ID_NOT_FOUND;
        public static final CloudAnchorState ERROR_HOSTING_DATASET_PROCESSING_FAILED;
        public static final CloudAnchorState ERROR_INTERNAL;
        public static final CloudAnchorState ERROR_NOT_AUTHORIZED;
        public static final CloudAnchorState ERROR_RESOLVING_LOCALIZATION_NO_MATCH;
        public static final CloudAnchorState ERROR_RESOLVING_SDK_VERSION_TOO_NEW;
        public static final CloudAnchorState ERROR_RESOLVING_SDK_VERSION_TOO_OLD;
        public static final CloudAnchorState ERROR_RESOURCE_EXHAUSTED;
        public static final CloudAnchorState ERROR_SERVICE_UNAVAILABLE;
        public static final CloudAnchorState NONE;
        public static final CloudAnchorState SUCCESS;
        public static final CloudAnchorState TASK_IN_PROGRESS;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1548938925, "Lcom/google/ar/core/Anchor$CloudAnchorState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1548938925, "Lcom/google/ar/core/Anchor$CloudAnchorState;");
                    return;
                }
            }
            NONE = new CloudAnchorState("NONE", 0, 0);
            TASK_IN_PROGRESS = new CloudAnchorState("TASK_IN_PROGRESS", 1, 1);
            SUCCESS = new CloudAnchorState(com.alipay.security.mobile.module.http.model.c.f2103g, 2, 2);
            ERROR_INTERNAL = new CloudAnchorState("ERROR_INTERNAL", 3, -1);
            ERROR_NOT_AUTHORIZED = new CloudAnchorState("ERROR_NOT_AUTHORIZED", 4, -2);
            ERROR_SERVICE_UNAVAILABLE = new CloudAnchorState("ERROR_SERVICE_UNAVAILABLE", 5, -3);
            ERROR_RESOURCE_EXHAUSTED = new CloudAnchorState("ERROR_RESOURCE_EXHAUSTED", 6, -4);
            ERROR_HOSTING_DATASET_PROCESSING_FAILED = new CloudAnchorState("ERROR_HOSTING_DATASET_PROCESSING_FAILED", 7, -5);
            ERROR_CLOUD_ID_NOT_FOUND = new CloudAnchorState("ERROR_CLOUD_ID_NOT_FOUND", 8, -6);
            ERROR_RESOLVING_LOCALIZATION_NO_MATCH = new CloudAnchorState("ERROR_RESOLVING_LOCALIZATION_NO_MATCH", 9, -7);
            ERROR_RESOLVING_SDK_VERSION_TOO_OLD = new CloudAnchorState("ERROR_RESOLVING_SDK_VERSION_TOO_OLD", 10, -8);
            CloudAnchorState cloudAnchorState = new CloudAnchorState("ERROR_RESOLVING_SDK_VERSION_TOO_NEW", 11, -9);
            ERROR_RESOLVING_SDK_VERSION_TOO_NEW = cloudAnchorState;
            $VALUES = new CloudAnchorState[]{NONE, TASK_IN_PROGRESS, SUCCESS, ERROR_INTERNAL, ERROR_NOT_AUTHORIZED, ERROR_SERVICE_UNAVAILABLE, ERROR_RESOURCE_EXHAUSTED, ERROR_HOSTING_DATASET_PROCESSING_FAILED, ERROR_CLOUD_ID_NOT_FOUND, ERROR_RESOLVING_LOCALIZATION_NO_MATCH, ERROR_RESOLVING_SDK_VERSION_TOO_OLD, cloudAnchorState};
        }

        public CloudAnchorState(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.nativeCode = i3;
        }

        public static CloudAnchorState forNumber(int i2) {
            InterceptResult invokeI;
            CloudAnchorState[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (CloudAnchorState cloudAnchorState : values()) {
                    if (cloudAnchorState.nativeCode == i2) {
                        return cloudAnchorState;
                    }
                }
                StringBuilder sb = new StringBuilder(63);
                sb.append("Unexpected value for native CloudAnchorState, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (CloudAnchorState) invokeI.objValue;
        }

        public static CloudAnchorState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CloudAnchorState) Enum.valueOf(CloudAnchorState.class, str) : (CloudAnchorState) invokeL.objValue;
        }

        public static CloudAnchorState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CloudAnchorState[]) $VALUES.clone() : (CloudAnchorState[]) invokeV.objValue;
        }

        public final boolean isError() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.nativeCode < 0 : invokeV.booleanValue;
        }
    }

    public Anchor() {
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
        this.f32949a = 0L;
    }

    private native void nativeDetach(long j, long j2);

    private native String nativeGetCloudAnchorId(long j, long j2);

    private native int nativeGetCloudAnchorState(long j, long j2);

    private native d.f.c.a.a nativeGetPose(long j, long j2);

    private native int nativeGetTrackingState(long j, long j2);

    public static native void nativeReleaseAnchor(long j);

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj != null && obj.getClass() == Anchor.class && ((Anchor) obj).f32949a == this.f32949a : invokeL.booleanValue;
    }

    public void finalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long j = this.f32949a;
            if (j != 0) {
                nativeReleaseAnchor(j);
            }
            super.finalize();
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Long.valueOf(this.f32949a).hashCode() : invokeV.intValue;
    }
}
