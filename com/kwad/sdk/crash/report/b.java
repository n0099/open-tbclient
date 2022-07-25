package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b extends d {
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(AnrExceptionMessage anrExceptionMessage, File file) {
        String str;
        String df = com.kwad.sdk.crash.utils.f.df(file.getName());
        anrExceptionMessage.mLogUUID = df;
        anrExceptionMessage.mIndex = com.kwad.sdk.crash.utils.f.getIndex(df);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                boolean z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!z && readLine.startsWith("\"main\" prio")) {
                            sb2.append(readLine);
                            sb2.append('\n');
                            String[] split = readLine.split("\\s+");
                            anrExceptionMessage.mThreadStatus = split[split.length - 1];
                            z = true;
                        } else if (!z) {
                            continue;
                        } else if (readLine.length() == 0) {
                            break;
                        } else if (readLine.startsWith("  |")) {
                            sb2.append(readLine);
                            sb2.append('\n');
                        } else {
                            sb.append(readLine);
                            sb.append('\n');
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        str = this.mErrorMessage + e + "\n";
                        this.mErrorMessage = str;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        if (sb.length() > 1) {
                        }
                        if (TextUtils.isEmpty(anrExceptionMessage.mCrashDetail)) {
                        }
                        com.kwad.sdk.core.e.b.d("AnrReporter", " message.mCrashSource=" + anrExceptionMessage.mCrashSource + "message.mCrashDetail = " + anrExceptionMessage.mCrashDetail);
                        if (sb2.length() > 1) {
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        str = this.mErrorMessage + e + "\n";
                        this.mErrorMessage = str;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        if (sb.length() > 1) {
                        }
                        if (TextUtils.isEmpty(anrExceptionMessage.mCrashDetail)) {
                        }
                        com.kwad.sdk.core.e.b.d("AnrReporter", " message.mCrashSource=" + anrExceptionMessage.mCrashSource + "message.mCrashDetail = " + anrExceptionMessage.mCrashDetail);
                        if (sb2.length() > 1) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        throw th;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
        if (sb.length() > 1) {
            anrExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (TextUtils.isEmpty(anrExceptionMessage.mCrashDetail)) {
            anrExceptionMessage.mCrashSource = 0;
        } else if (da(anrExceptionMessage.mCrashDetail)) {
            anrExceptionMessage.mCrashSource = 1;
        } else {
            anrExceptionMessage.mCrashSource = 2;
        }
        com.kwad.sdk.core.e.b.d("AnrReporter", " message.mCrashSource=" + anrExceptionMessage.mCrashSource + "message.mCrashDetail = " + anrExceptionMessage.mCrashDetail);
        if (sb2.length() > 1) {
            anrExceptionMessage.mThreadDetail = sb2.substring(0, sb2.length() - 1);
        }
    }

    private String cZ(String str) {
        File file = new File(str + ".anr");
        String str2 = "";
        if (file.exists()) {
            try {
                str2 = o.S(file);
            } catch (IOException e) {
                this.mErrorMessage += e + "\n";
            }
            o.P(file);
        }
        return str2;
    }

    public static boolean da(@NonNull String str) {
        String[] wA;
        for (String str2 : com.kwad.sdk.crash.d.wz().wA()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.e.b.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    private AnrExceptionMessage y(File file) {
        String str;
        try {
            str = o.S(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        o.P(file);
        return anrExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        com.kwad.sdk.core.e.b.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage y = y(file2);
        try {
            y.mReason = cZ(str);
            a(y, file);
            b(file3, y);
            com.kwad.sdk.crash.utils.f.a(file, (CharSequence) y.toString(), true);
            com.kwad.sdk.crash.utils.f.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ ANR Report Begin ------\n").append(y);
            y.mDumpsys = o.S(new File(str + ".minfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            y.mErrorMessage += this.mErrorMessage;
        }
        return y;
    }
}
