package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class d extends b {
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    @Override // com.kwad.sdk.crash.report.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        String str2;
        JavaExceptionMessage javaExceptionMessage;
        Exception e2;
        JavaExceptionMessage javaExceptionMessage2 = null;
        try {
            str2 = g.d(file);
        } catch (Exception e3) {
            this.f58764b += e3 + StringUtils.LF;
            str2 = null;
        }
        if (str2 != null) {
            try {
                javaExceptionMessage = new JavaExceptionMessage();
                try {
                    javaExceptionMessage.parseJson(new JSONObject(str2));
                } catch (Exception e4) {
                    e2 = e4;
                    this.f58764b += e2 + StringUtils.LF;
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
                    if (!TextUtils.isEmpty(this.f58764b)) {
                    }
                    return javaExceptionMessage2;
                }
            } catch (Exception e5) {
                javaExceptionMessage = null;
                e2 = e5;
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
            this.f58764b += th + StringUtils.LF;
            com.kwad.sdk.core.d.a.b(th);
        }
        if (!TextUtils.isEmpty(this.f58764b)) {
            javaExceptionMessage2.mErrorMessage += this.f58764b;
        }
        return javaExceptionMessage2;
    }
}
