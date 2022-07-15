package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import com.kwad.sdk.utils.o;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class f extends d {
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    @Override // com.kwad.sdk.crash.report.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        String str2;
        JavaExceptionMessage javaExceptionMessage;
        Exception e;
        JavaExceptionMessage javaExceptionMessage2 = null;
        try {
            str2 = o.h(file);
        } catch (Exception e2) {
            this.b += e2 + "\n";
            str2 = null;
        }
        if (str2 != null) {
            try {
                javaExceptionMessage = new JavaExceptionMessage();
                try {
                    javaExceptionMessage.parseJson(new JSONObject(str2));
                } catch (Exception e3) {
                    e = e3;
                    this.b += e + "\n";
                    javaExceptionMessage2 = javaExceptionMessage;
                    if (javaExceptionMessage2 == null) {
                    }
                    javaExceptionMessage2.mLogUUID = com.kwad.sdk.crash.utils.f.a(file.getName());
                    new StringBuilder("------ Java Crash Report Begin ------\n").append(javaExceptionMessage2);
                    d.a(new File(str + ".jtrace"), javaExceptionMessage2);
                    b(file3, javaExceptionMessage2);
                    com.kwad.sdk.crash.utils.f.a(file, javaExceptionMessage2.toString());
                    com.kwad.sdk.crash.utils.f.a(file3, file);
                    file.renameTo(file3);
                    javaExceptionMessage2.mDumpsys = o.h(new File(str + ".minfo"));
                    if (!TextUtils.isEmpty(this.b)) {
                    }
                    return javaExceptionMessage2;
                }
            } catch (Exception e4) {
                javaExceptionMessage = null;
                e = e4;
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
            javaExceptionMessage2.mLogUUID = com.kwad.sdk.crash.utils.f.a(file.getName());
            new StringBuilder("------ Java Crash Report Begin ------\n").append(javaExceptionMessage2);
            d.a(new File(str + ".jtrace"), javaExceptionMessage2);
            b(file3, javaExceptionMessage2);
            com.kwad.sdk.crash.utils.f.a(file, javaExceptionMessage2.toString());
            com.kwad.sdk.crash.utils.f.a(file3, file);
            file.renameTo(file3);
            javaExceptionMessage2.mDumpsys = o.h(new File(str + ".minfo"));
        } catch (Throwable th) {
            this.b += th + "\n";
            com.kwad.sdk.core.d.b.b(th);
        }
        if (!TextUtils.isEmpty(this.b)) {
            javaExceptionMessage2.mErrorMessage += this.b;
        }
        return javaExceptionMessage2;
    }
}
