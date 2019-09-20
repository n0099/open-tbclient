package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class d {
    public static Context D;

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    private static int a(ContentResolver contentResolver, Uri uri) {
        int i = 0;
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
        } else {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = contentResolver.openInputStream(uri);
                    if (inputStream != null) {
                        i = inputStream.available();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                            }
                        }
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e4.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
            }
        }
        return i;
    }

    public static boolean a(int i) {
        return i == 36 || i == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static int c(String str) {
        if (str != null) {
            try {
                if (str.length() <= 0) {
                    return 0;
                }
                return Integer.parseInt(str);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public static int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (D == null || !str.startsWith("content")) {
            return 0;
        }
        try {
            return a(D.getContentResolver(), Uri.parse(str));
        } catch (Exception e) {
            return 0;
        }
    }
}
