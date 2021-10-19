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
import com.kwad.sdk.utils.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends NativeObject implements com.kwad.sdk.collector.model.b<b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SimpleDateFormat f71730a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1594943302, "Lcom/kwad/sdk/collector/model/jni/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1594943302, "Lcom/kwad/sdk/collector/model/jni/b;");
                return;
            }
        }
        f71730a = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
    }

    public b(long j2) {
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

    public b(long j2, String str, String str2) {
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
    public int compareTo(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return 1;
            }
            int i2 = ((AppStatusNative.appRunningInfoGetLastRunningTime(this) - com.kwad.sdk.collector.model.c.c(bVar)) > 0L ? 1 : ((AppStatusNative.appRunningInfoGetLastRunningTime(this) - com.kwad.sdk.collector.model.c.c(bVar)) == 0L ? 0 : -1));
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
    public b clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
            com.kwad.sdk.collector.model.c.a(bVar, AppStatusNative.appRunningInfoGetLastRunningTime(this));
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? f71730a.format(new Date(j2)) : (String) invokeJ.objValue;
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
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
            if (appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(bVar)) {
                return false;
            }
            long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
            String appRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
            String appRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
            if (appRunningInfoGetGranularity == 0) {
                appRunningInfoGetGranularity = 1;
            }
            if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(bVar) / appRunningInfoGetGranularity && appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(bVar))) {
                return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(bVar));
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
            q.a(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
            q.a(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
            q.a(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "AppRunningInfo{packageName='" + com.kwad.sdk.collector.model.c.b(this) + ExtendedMessageFormat.QUOTE + ", lastRunningTime=" + a(com.kwad.sdk.collector.model.c.c(this)) + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
