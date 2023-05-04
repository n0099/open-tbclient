package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;
@KeepForSdk
/* loaded from: classes8.dex */
public class ProcessUtils {
    @Nullable
    public static String zza;
    public static int zzb;

    @androidx.annotation.Nullable
    @KeepForSdk
    public static String getMyProcessName() {
        BufferedReader bufferedReader;
        if (zza == null) {
            int i = zzb;
            if (i == 0) {
                i = Process.myPid();
                zzb = i;
            }
            String str = null;
            str = null;
            str = null;
            BufferedReader bufferedReader2 = null;
            if (i > 0) {
                try {
                    StringBuilder sb = new StringBuilder(25);
                    sb.append("/proc/");
                    sb.append(i);
                    sb.append("/cmdline");
                    String sb2 = sb.toString();
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(sb2));
                        try {
                            String readLine = bufferedReader.readLine();
                            Preconditions.checkNotNull(readLine);
                            str = readLine.trim();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            IOUtils.closeQuietly(bufferedReader2);
                            throw th;
                        }
                    } finally {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                IOUtils.closeQuietly(bufferedReader);
            }
            zza = str;
        }
        return zza;
    }
}
