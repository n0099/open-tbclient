package com.kwad.sdk.core.imageloader.utils;

import com.kwad.sdk.crash.utils.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public final class IoUtils {
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final int DEFAULT_IMAGE_TOTAL_SIZE = 512000;

    /* loaded from: classes10.dex */
    public interface CopyListener {
        boolean onBytesCopied(int i, int i2);
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener) {
        return copyStream(inputStream, outputStream, copyListener, 32768);
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener, int i) {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i];
        if (shouldStopLoading(copyListener, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read == -1) {
                outputStream.flush();
                return true;
            }
            outputStream.write(bArr, 0, read);
            i2 += read;
        } while (!shouldStopLoading(copyListener, i2, available));
        return false;
    }

    public static String inputStreamToString(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            while (true) {
                try {
                    int read = inputStreamReader.read(cArr, 0, 1024);
                    if (read < 0) {
                        b.closeQuietly(inputStreamReader);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                } catch (Exception unused) {
                    b.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    b.closeQuietly(inputStreamReader2);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void readAndCloseStream(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
                return;
            } finally {
                b.closeQuietly(inputStream);
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
    }

    public static boolean shouldStopLoading(CopyListener copyListener, int i, int i2) {
        return (copyListener == null || copyListener.onBytesCopied(i, i2) || (i * 100) / i2 >= 75) ? false : true;
    }
}
