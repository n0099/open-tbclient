package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
@KeepForSdk
/* loaded from: classes9.dex */
public class LibraryVersion {
    public static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    public static LibraryVersion zzb = new LibraryVersion();
    public ConcurrentHashMap<String, String> zzc = new ConcurrentHashMap<>();

    @NonNull
    @KeepForSdk
    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    @NonNull
    @KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getVersion(@NonNull String str) {
        String str2;
        String str3;
        InputStream resourceAsStream;
        String str4;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.zzc.containsKey(str)) {
            return this.zzc.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        String str5 = null;
        InputStream inputStream2 = null;
        try {
            try {
                resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            str2 = null;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str5 = properties.getProperty("version", null);
                GmsLogger gmsLogger = zza;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str5).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str5);
                gmsLogger.v("LibraryVersion", sb.toString());
            } else {
                GmsLogger gmsLogger2 = zza;
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str4 = "Failed to get app version for libraryName: ".concat(valueOf);
                } else {
                    str4 = new String("Failed to get app version for libraryName: ");
                }
                gmsLogger2.w("LibraryVersion", str4);
            }
            if (resourceAsStream != null) {
                IOUtils.closeQuietly(resourceAsStream);
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = resourceAsStream;
            str2 = null;
            GmsLogger gmsLogger3 = zza;
            String valueOf2 = String.valueOf(str);
            if (valueOf2.length() != 0) {
                str3 = "Failed to get app version for libraryName: ".concat(valueOf2);
            } else {
                str3 = new String("Failed to get app version for libraryName: ");
            }
            gmsLogger3.e("LibraryVersion", str3, e);
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            str5 = str2;
            if (str5 == null) {
            }
            this.zzc.put(str, str5);
            return str5;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = resourceAsStream;
            if (inputStream2 != null) {
                IOUtils.closeQuietly(inputStream2);
            }
            throw th;
        }
        if (str5 == null) {
            zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            str5 = "UNKNOWN";
        }
        this.zzc.put(str, str5);
        return str5;
    }
}
