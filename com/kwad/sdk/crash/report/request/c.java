package com.kwad.sdk.crash.report.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.ReportEvent;
import com.kwad.sdk.crash.utils.d;
import java.util.Calendar;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ReportEvent a(@NonNull ExceptionMessage exceptionMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exceptionMessage)) == null) {
            ReportEvent reportEvent = new ReportEvent();
            reportEvent.clientIncrementId = d.a();
            reportEvent.clientTimeStamp = exceptionMessage.mCurrentTimeStamp;
            reportEvent.sessionId = a(exceptionMessage.mCustomMsg);
            reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
            reportEvent.statPackage = new ReportEvent.StatPackage();
            ReportEvent.ExceptionEvent exceptionEvent = new ReportEvent.ExceptionEvent();
            exceptionEvent.type = exceptionMessage.mExceptionType;
            exceptionEvent.message = exceptionMessage.toJson().toString();
            exceptionEvent.urlPackage = new ReportEvent.UrlPackage();
            reportEvent.statPackage.exceptionEvent = exceptionEvent;
            return reportEvent;
        }
        return (ReportEvent) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !"Unknown".equals(str)) {
                try {
                    String optString = new JSONObject(str).optString(com.kwad.sdk.crash.c.f58751g);
                    if (!TextUtils.isEmpty(optString)) {
                        return optString;
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.b(e2);
                }
            }
            return "Unknown";
        }
        return (String) invokeL.objValue;
    }
}
