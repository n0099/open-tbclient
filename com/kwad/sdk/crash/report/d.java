package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ce  */
    @Override // com.kwad.sdk.crash.report.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        InterceptResult invokeLLLL;
        String str2;
        JavaExceptionMessage javaExceptionMessage;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, file, file2, file3, str)) == null) {
            JavaExceptionMessage javaExceptionMessage2 = null;
            try {
                str2 = g.d(file);
            } catch (Exception e3) {
                this.f58183b += e3 + StringUtils.LF;
                str2 = null;
            }
            if (str2 != null) {
                try {
                    javaExceptionMessage = new JavaExceptionMessage();
                } catch (Exception e4) {
                    javaExceptionMessage = null;
                    e2 = e4;
                }
                try {
                    javaExceptionMessage.parseJson(new JSONObject(str2));
                } catch (Exception e5) {
                    e2 = e5;
                    this.f58183b += e2 + StringUtils.LF;
                    javaExceptionMessage2 = javaExceptionMessage;
                    if (javaExceptionMessage2 == null) {
                    }
                    javaExceptionMessage2.mLogUUID = f.a(file.getName());
                    this.a.a("ExceptionCollector", "------ Java Crash Report Begin ------\n" + javaExceptionMessage2);
                    a(new File(str + ".jtrace"), javaExceptionMessage2);
                    b(file3, javaExceptionMessage2);
                    f.a(file, javaExceptionMessage2.toString());
                    f.a(file3, file);
                    file.renameTo(file3);
                    if (!TextUtils.isEmpty(this.f58183b)) {
                    }
                    return javaExceptionMessage2;
                }
                javaExceptionMessage2 = javaExceptionMessage;
            }
            if (javaExceptionMessage2 == null) {
                javaExceptionMessage2 = new JavaExceptionMessage();
                if (!TextUtils.isEmpty(str2)) {
                    javaExceptionMessage2.mCrashDetail = str2;
                }
            }
            try {
                javaExceptionMessage2.mLogUUID = f.a(file.getName());
                this.a.a("ExceptionCollector", "------ Java Crash Report Begin ------\n" + javaExceptionMessage2);
                a(new File(str + ".jtrace"), javaExceptionMessage2);
                b(file3, javaExceptionMessage2);
                f.a(file, javaExceptionMessage2.toString());
                f.a(file3, file);
                file.renameTo(file3);
            } catch (Throwable th) {
                this.f58183b += th + StringUtils.LF;
                com.kwad.sdk.core.d.a.b(th);
            }
            if (!TextUtils.isEmpty(this.f58183b)) {
                javaExceptionMessage2.mErrorMessage += this.f58183b;
            }
            return javaExceptionMessage2;
        }
        return (ExceptionMessage) invokeLLLL.objValue;
    }
}
