package com.google.android.gms.ads.identifier;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.gms.internal.ads_identifier.zzi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public final class zzc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void zza(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            try {
                try {
                    zzi.zzb(263);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode < 200 || responseCode >= 300) {
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                            sb.append("Received non-success response code ");
                            sb.append(responseCode);
                            sb.append(" from pinging URL: ");
                            sb.append(str);
                            Log.w("HttpUrlPinger", sb.toString());
                        }
                        zzi.zza();
                    } finally {
                        httpURLConnection.disconnect();
                    }
                } catch (IOException e) {
                    e = e;
                    String message = e.getMessage();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
                    sb2.append("Error while pinging URL: ");
                    sb2.append(str);
                    sb2.append(". ");
                    sb2.append(message);
                    Log.w("HttpUrlPinger", sb2.toString(), e);
                    zzi.zza();
                } catch (IndexOutOfBoundsException e2) {
                    String message2 = e2.getMessage();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length());
                    sb3.append("Error while parsing ping URL: ");
                    sb3.append(str);
                    sb3.append(". ");
                    sb3.append(message2);
                    Log.w("HttpUrlPinger", sb3.toString(), e2);
                    zzi.zza();
                } catch (RuntimeException e3) {
                    e = e3;
                    String message3 = e.getMessage();
                    StringBuilder sb22 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
                    sb22.append("Error while pinging URL: ");
                    sb22.append(str);
                    sb22.append(". ");
                    sb22.append(message3);
                    Log.w("HttpUrlPinger", sb22.toString(), e);
                    zzi.zza();
                }
            } catch (Throwable th) {
                zzi.zza();
                throw th;
            }
        }
    }
}
