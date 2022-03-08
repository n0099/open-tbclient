package com.google.ar.core;

import android.content.Context;
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
/* loaded from: classes7.dex */
public class ArCoreApk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class InstallBehavior {
        public static final /* synthetic */ InstallBehavior[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InstallBehavior OPTIONAL;
        public static final InstallBehavior REQUIRED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-773656460, "Lcom/google/ar/core/ArCoreApk$InstallBehavior;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-773656460, "Lcom/google/ar/core/ArCoreApk$InstallBehavior;");
                    return;
                }
            }
            REQUIRED = new InstallBehavior("REQUIRED", 0, 0);
            InstallBehavior installBehavior = new InstallBehavior("OPTIONAL", 1, 1);
            OPTIONAL = installBehavior;
            $VALUES = new InstallBehavior[]{REQUIRED, installBehavior};
        }

        public InstallBehavior(String str, int i2, int i3) {
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

        public static InstallBehavior forNumber(int i2) {
            InterceptResult invokeI;
            InstallBehavior[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (InstallBehavior installBehavior : values()) {
                    if (installBehavior.nativeCode == i2) {
                        return installBehavior;
                    }
                }
                StringBuilder sb = new StringBuilder(62);
                sb.append("Unexpected value for native InstallBehavior, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (InstallBehavior) invokeI.objValue;
        }

        public static InstallBehavior valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (InstallBehavior) Enum.valueOf(InstallBehavior.class, str) : (InstallBehavior) invokeL.objValue;
        }

        public static InstallBehavior[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (InstallBehavior[]) $VALUES.clone() : (InstallBehavior[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class InstallStatus {
        public static final /* synthetic */ InstallStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final InstallStatus INSTALLED;
        public static final InstallStatus INSTALL_REQUESTED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1409752468, "Lcom/google/ar/core/ArCoreApk$InstallStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1409752468, "Lcom/google/ar/core/ArCoreApk$InstallStatus;");
                    return;
                }
            }
            INSTALLED = new InstallStatus("INSTALLED", 0, 0);
            InstallStatus installStatus = new InstallStatus("INSTALL_REQUESTED", 1, 1);
            INSTALL_REQUESTED = installStatus;
            $VALUES = new InstallStatus[]{INSTALLED, installStatus};
        }

        public InstallStatus(String str, int i2, int i3) {
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

        public static InstallStatus forNumber(int i2) {
            InterceptResult invokeI;
            InstallStatus[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (InstallStatus installStatus : values()) {
                    if (installStatus.nativeCode == i2) {
                        return installStatus;
                    }
                }
                StringBuilder sb = new StringBuilder(60);
                sb.append("Unexpected value for native InstallStatus, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (InstallStatus) invokeI.objValue;
        }

        public static InstallStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (InstallStatus) Enum.valueOf(InstallStatus.class, str) : (InstallStatus) invokeL.objValue;
        }

        public static InstallStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (InstallStatus[]) $VALUES.clone() : (InstallStatus[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class UserMessageType {
        public static final /* synthetic */ UserMessageType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UserMessageType APPLICATION;
        public static final UserMessageType FEATURE;
        public static final UserMessageType USER_ALREADY_INFORMED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2107278453, "Lcom/google/ar/core/ArCoreApk$UserMessageType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2107278453, "Lcom/google/ar/core/ArCoreApk$UserMessageType;");
                    return;
                }
            }
            APPLICATION = new UserMessageType("APPLICATION", 0, 0);
            FEATURE = new UserMessageType("FEATURE", 1, 1);
            UserMessageType userMessageType = new UserMessageType("USER_ALREADY_INFORMED", 2, 2);
            USER_ALREADY_INFORMED = userMessageType;
            $VALUES = new UserMessageType[]{APPLICATION, FEATURE, userMessageType};
        }

        public UserMessageType(String str, int i2, int i3) {
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

        public static UserMessageType forNumber(int i2) {
            InterceptResult invokeI;
            UserMessageType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (UserMessageType userMessageType : values()) {
                    if (userMessageType.nativeCode == i2) {
                        return userMessageType;
                    }
                }
                StringBuilder sb = new StringBuilder(62);
                sb.append("Unexpected value for native UserMessageType, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (UserMessageType) invokeI.objValue;
        }

        public static UserMessageType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (UserMessageType) Enum.valueOf(UserMessageType.class, str) : (UserMessageType) invokeL.objValue;
        }

        public static UserMessageType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (UserMessageType[]) $VALUES.clone() : (UserMessageType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface a {
        void a(Availability availability);
    }

    public ArCoreApk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ArCoreApk b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.i.b.a.f.d() : (ArCoreApk) invokeV.objValue;
    }

    public abstract Availability a(Context context);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static class Availability {
        public static final /* synthetic */ Availability[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Availability SUPPORTED_APK_TOO_OLD;
        public static final Availability SUPPORTED_INSTALLED;
        public static final Availability SUPPORTED_NOT_INSTALLED;
        public static final Availability UNKNOWN_CHECKING;
        public static final Availability UNKNOWN_ERROR;
        public static final Availability UNKNOWN_TIMED_OUT;
        public static final Availability UNSUPPORTED_DEVICE_NOT_CAPABLE;
        public transient /* synthetic */ FieldHolder $fh;
        public final int nativeCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2030114726, "Lcom/google/ar/core/ArCoreApk$Availability;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2030114726, "Lcom/google/ar/core/ArCoreApk$Availability;");
                    return;
                }
            }
            UNKNOWN_ERROR = new com.google.ar.core.a("UNKNOWN_ERROR", 0, 0);
            UNKNOWN_CHECKING = new b("UNKNOWN_CHECKING", 1, 1);
            UNKNOWN_TIMED_OUT = new c("UNKNOWN_TIMED_OUT", 2, 2);
            UNSUPPORTED_DEVICE_NOT_CAPABLE = new d("UNSUPPORTED_DEVICE_NOT_CAPABLE", 3, 100);
            SUPPORTED_NOT_INSTALLED = new e("SUPPORTED_NOT_INSTALLED", 4, 201);
            SUPPORTED_APK_TOO_OLD = new f("SUPPORTED_APK_TOO_OLD", 5, 202);
            g gVar = new g("SUPPORTED_INSTALLED", 6, 203);
            SUPPORTED_INSTALLED = gVar;
            $VALUES = new Availability[]{UNKNOWN_ERROR, UNKNOWN_CHECKING, UNKNOWN_TIMED_OUT, UNSUPPORTED_DEVICE_NOT_CAPABLE, SUPPORTED_NOT_INSTALLED, SUPPORTED_APK_TOO_OLD, gVar};
        }

        public Availability(String str, int i2, int i3) {
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

        public static Availability forNumber(int i2) {
            InterceptResult invokeI;
            Availability[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                for (Availability availability : values()) {
                    if (availability.nativeCode == i2) {
                        return availability;
                    }
                }
                StringBuilder sb = new StringBuilder(59);
                sb.append("Unexpected value for native Availability, value=");
                sb.append(i2);
                throw new FatalException(sb.toString());
            }
            return (Availability) invokeI.objValue;
        }

        public static Availability valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Availability) Enum.valueOf(Availability.class, str) : (Availability) invokeL.objValue;
        }

        public static Availability[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (Availability[]) $VALUES.clone() : (Availability[]) invokeV.objValue;
        }

        public boolean isSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isTransient() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isUnknown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isUnsupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ Availability(String str, int i2, int i3, c.i.b.a.e eVar) {
            this(str, i2, i3);
        }
    }
}
