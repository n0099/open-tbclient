package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
@KeepForSdk
/* loaded from: classes7.dex */
public class LibraryVersion {
    public static /* synthetic */ Interceptable $ic;
    public static final GmsLogger zza;
    public static LibraryVersion zzb;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, String> zzc;

    @NonNull
    @KeepForSdk
    public static LibraryVersion getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? zzb : (LibraryVersion) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593232686, "Lcom/google/android/gms/common/internal/LibraryVersion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593232686, "Lcom/google/android/gms/common/internal/LibraryVersion;");
                return;
            }
        }
        zza = new GmsLogger("LibraryVersion", "");
        zzb = new LibraryVersion();
    }

    @VisibleForTesting
    public LibraryVersion() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzc = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc  */
    @NonNull
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getVersion(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        InputStream resourceAsStream;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
            if (this.zzc.containsKey(str)) {
                return this.zzc.get(str);
            }
            Properties properties = new Properties();
            InputStream inputStream = null;
            String str5 = null;
            inputStream = null;
            try {
                try {
                    resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
                } catch (IOException e) {
                    e = e;
                    str2 = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (resourceAsStream != null) {
                    properties.load(resourceAsStream);
                    str5 = properties.getProperty("version", null);
                    GmsLogger gmsLogger = zza;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str5).length());
                    sb.append(str);
                    sb.append(" version is ");
                    sb.append(str5);
                    gmsLogger.v("LibraryVersion", sb.toString());
                } else {
                    GmsLogger gmsLogger2 = zza;
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        str4 = "Failed to get app version for libraryName: ".concat(valueOf);
                    } else {
                        str4 = new String("Failed to get app version for libraryName: ");
                    }
                    gmsLogger2.w("LibraryVersion", str4);
                }
                if (resourceAsStream != null) {
                    IOUtils.closeQuietly(resourceAsStream);
                }
            } catch (IOException e2) {
                e = e2;
                inputStream = resourceAsStream;
                str2 = null;
                GmsLogger gmsLogger3 = zza;
                String valueOf2 = String.valueOf(str);
                if (valueOf2.length() != 0) {
                    str3 = "Failed to get app version for libraryName: ".concat(valueOf2);
                } else {
                    str3 = new String("Failed to get app version for libraryName: ");
                }
                gmsLogger3.e("LibraryVersion", str3, e);
                if (inputStream != null) {
                    IOUtils.closeQuietly(inputStream);
                }
                str5 = str2;
                if (str5 == null) {
                }
                this.zzc.put(str, str5);
                return str5;
            } catch (Throwable th2) {
                th = th2;
                inputStream = resourceAsStream;
                if (inputStream != null) {
                    IOUtils.closeQuietly(inputStream);
                }
                throw th;
            }
            if (str5 == null) {
                zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
                str5 = RomUtils.UNKNOWN;
            }
            this.zzc.put(str, str5);
            return str5;
        }
        return (String) invokeL.objValue;
    }
}
