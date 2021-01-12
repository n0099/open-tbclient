package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.crash.utils.f;
import com.kwad.sdk.crash.utils.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class d extends b {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fd  */
    @Override // com.kwad.sdk.crash.report.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        String str2;
        JavaExceptionMessage javaExceptionMessage;
        JavaExceptionMessage javaExceptionMessage2;
        JavaExceptionMessage javaExceptionMessage3;
        try {
            str2 = g.d(file);
        } catch (Exception e) {
            this.f9647b += e + "\n";
            str2 = null;
        }
        if (str2 != null) {
            try {
                javaExceptionMessage = new JavaExceptionMessage();
                try {
                    javaExceptionMessage.parseJson(new JSONObject(str2));
                    javaExceptionMessage2 = javaExceptionMessage;
                } catch (Exception e2) {
                    e = e2;
                    this.f9647b += e + "\n";
                    javaExceptionMessage2 = javaExceptionMessage;
                    if (javaExceptionMessage2 != null) {
                    }
                    javaExceptionMessage3.mLogUUID = f.a(file.getName());
                    this.f9646a.a("ExceptionCollector", "------ Java Crash Report Begin ------\n" + javaExceptionMessage3);
                    a(new File(str + ".jtrace"), javaExceptionMessage3);
                    b(file3, javaExceptionMessage3);
                    f.a(file, javaExceptionMessage3.toString());
                    f.a(file3, file);
                    file.renameTo(file3);
                    if (!TextUtils.isEmpty(this.f9647b)) {
                    }
                    return javaExceptionMessage3;
                }
            } catch (Exception e3) {
                e = e3;
                javaExceptionMessage = null;
            }
        } else {
            javaExceptionMessage2 = null;
        }
        if (javaExceptionMessage2 != null) {
            JavaExceptionMessage javaExceptionMessage4 = new JavaExceptionMessage();
            if (!TextUtils.isEmpty(str2)) {
                javaExceptionMessage4.mCrashDetail = str2;
            }
            javaExceptionMessage3 = javaExceptionMessage4;
        } else {
            javaExceptionMessage3 = javaExceptionMessage2;
        }
        try {
            javaExceptionMessage3.mLogUUID = f.a(file.getName());
            this.f9646a.a("ExceptionCollector", "------ Java Crash Report Begin ------\n" + javaExceptionMessage3);
            a(new File(str + ".jtrace"), javaExceptionMessage3);
            b(file3, javaExceptionMessage3);
            f.a(file, javaExceptionMessage3.toString());
            f.a(file3, file);
            file.renameTo(file3);
        } catch (Throwable th) {
            this.f9647b += th + "\n";
            com.kwad.sdk.core.d.a.b(th);
        }
        if (!TextUtils.isEmpty(this.f9647b)) {
            javaExceptionMessage3.mErrorMessage += this.f9647b;
        }
        return javaExceptionMessage3;
    }
}
