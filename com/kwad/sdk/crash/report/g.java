package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class g extends d {
    public static final Pattern ahF = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern ahG = Pattern.compile("\\sd+\\spc");

    private NativeExceptionMessage A(File file) {
        String str;
        try {
            str = o.S(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        o.P(file);
        return nativeExceptionMessage;
    }

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.f.df(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z = false;
        boolean z2 = false;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (z && readLine.startsWith("backtrace:")) {
                    z = false;
                    z2 = true;
                } else if (z2) {
                    if (readLine.startsWith("###### ending of java stack trace ######")) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                } else if (z) {
                    a(nativeExceptionMessage, readLine, sb2);
                } else if (readLine.startsWith("*** ***")) {
                    z = true;
                }
            } catch (IOException e) {
                this.mErrorMessage += e + "\n";
            }
        }
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    public static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
        } else if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
        } else if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
        } else if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
        } else if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
        } else if (str.startsWith("    r") || str.startsWith("    ip") || str.startsWith("    x") || str.startsWith("    sp")) {
            sb.append(str);
            sb.append('\n');
        } else if (!str.startsWith("pid: ")) {
            if (str.startsWith("signal ")) {
                String[] split = str.split("\\s+");
                if (split.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.f.dg(split[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.f.dg(split[5]);
                    nativeExceptionMessage.mFaultAddr = split[split.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split[split.length + (-1)]) ? "True" : "False";
                }
            }
        } else {
            String[] split2 = str.split("\\s+");
            if (split2.length < 9) {
                return;
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < split2.length; i4++) {
                if ("name:".equals(split2[i4])) {
                    i = i4;
                } else if (">>>".equals(split2[i4])) {
                    i2 = i4;
                } else if ("<<<".equals(split2[i4])) {
                    i3 = i4;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            int i5 = i + 1;
            String str2 = split2[i5];
            while (true) {
                sb2.append(str2);
                i5++;
                if (i5 >= i2) {
                    break;
                }
                sb2.append(" ");
                str2 = split2[i5];
            }
            nativeExceptionMessage.mThreadName = sb2.toString();
            sb2.setLength(0);
            int i6 = i2 + 1;
            String str3 = split2[i6];
            while (true) {
                sb2.append(str3);
                i6++;
                if (i6 >= i3) {
                    nativeExceptionMessage.mProcessName = sb2.toString();
                    return;
                } else {
                    sb2.append(" ");
                    str3 = split2[i6];
                }
            }
        }
    }

    public static void c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else if (ahG.matcher(readLine).matches()) {
                        if (threadInfo.mTrace != null) {
                            readLine = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = readLine;
                        threadInfo.mTrace += "\n";
                    } else {
                        Matcher matcher = ahF.matcher(readLine);
                        if (matcher.lookingAt()) {
                            threadInfo.mName = matcher.group(1);
                            threadInfo.mTid = Integer.parseInt(matcher.group(2));
                            threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                        }
                    }
                }
                memoryInfo.mNativeThreads = arrayList;
                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
            } catch (IOException e) {
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
        } catch (Exception e2) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.crash.report.d
    public final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage A = A(file2);
        try {
            a(A, file);
            b(file3, A);
            d.a(file4, A);
            c(new File(str + ".ntrace"), A);
            com.kwad.sdk.crash.utils.f.a(file, (CharSequence) A.toString(), true);
            com.kwad.sdk.crash.utils.f.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ Native Crash Report Begin ------\n").append(A);
            A.mDumpsys = o.S(new File(str + ".minfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            A.mErrorMessage += this.mErrorMessage;
        }
        return A;
    }
}
