package com.kwad.sdk.collector.model.jni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleDateFormat a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1072778955, "Lcom/kwad/sdk/collector/model/jni/AppRunningInfoNative;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1072778955, "Lcom/kwad/sdk/collector/model/jni/AppRunningInfoNative;");
                return;
            }
        }
        a = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    }

    public AppRunningInfoNative(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPtr = j2;
    }

    public AppRunningInfoNative(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j2, str, str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, appRunningInfoNative)) == null) {
            if (appRunningInfoNative == null) {
                return 1;
            }
            int i2 = ((AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative)) > 0L ? 1 : ((AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative)) == 0L ? 0 : -1));
            if (i2 == 0) {
                return 0;
            }
            return i2 > 0 ? 1 : -1;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @NonNull
    /* renamed from: a */
    public AppRunningInfoNative clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
            c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
            return appRunningInfoNative;
        }
        return (AppRunningInfoNative) invokeV.objValue;
    }

    public String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? a.format(new Date(j2)) : (String) invokeJ.objValue;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long j2 = this.mPtr;
            if (j2 != 0) {
                AppStatusNative.nativeDeleteAppRunningInfo(j2);
                this.mPtr = 0L;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AppRunningInfoNative.class != obj.getClass()) {
                return false;
            }
            AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
            long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
            if (appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
                return false;
            }
            long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
            String appRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
            String appRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
            if (appRunningInfoGetGranularity == 0) {
                appRunningInfoGetGranularity = 1;
            }
            if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / appRunningInfoGetGranularity && appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
                return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
            if (appRunningInfoGetGranularity == 0) {
                appRunningInfoGetGranularity = 1;
            }
            long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / appRunningInfoGetGranularity;
            return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (appRunningInfoGetLastRunningTime ^ (appRunningInfoGetLastRunningTime >>> 32)));
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
            t.a(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
            t.a(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "AppRunningInfo{packageName='" + c.b(this) + ExtendedMessageFormat.QUOTE + ", lastRunningTime=" + a(c.c(this)) + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
