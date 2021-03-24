package d.d.a.a.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Base64;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public final class e {
    public static String a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) d.d.a.a.a.c().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                return (typeName.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            byte[] l = l(context, str);
            if (l != null) {
                return new String(l, "utf-8");
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String c(boolean z, Context context, String str) {
        if (context == null) {
            return null;
        }
        if (z) {
            return n(context, str);
        }
        return b(context, str);
    }

    public static String d(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String e(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return d(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void f(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(str, z ? 32768 : 0);
            if (fileOutputStream != null) {
                fileOutputStream.write(str2.getBytes("utf-8"));
            }
            if (fileOutputStream == null) {
                return;
            }
        } catch (Exception unused) {
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
        try {
            fileOutputStream.close();
        } catch (Exception unused3) {
        }
    }

    public static void g(boolean z, Context context, String str, String str2, boolean z2) {
        if (context == null) {
            return;
        }
        if (z) {
            j(context, str, str2, z2);
        } else {
            f(context, str, str2, z2);
        }
    }

    public static boolean h(Context context) {
        NetworkInfo m = m(context);
        return m != null && m.isConnected();
    }

    public static boolean i(Context context, boolean z, String str) {
        if (context == null) {
            return false;
        }
        if (z) {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                StringBuilder sb = new StringBuilder();
                sb.append(externalStorageDirectory);
                sb.append(File.separator);
                sb.append("c82c403505338808201aad86f8194734");
                sb.append(File.separator);
                sb.append(context.getPackageName());
                sb.append(File.separator);
                sb.append(str);
                return new File(sb.toString()).exists();
            }
            return false;
        }
        return context.getFileStreamPath(str).exists();
    }

    public static void j(Context context, String str, String str2, boolean z) {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    StringBuilder sb = new StringBuilder();
                    sb.append(externalStorageDirectory);
                    sb.append(File.separator);
                    sb.append("c82c403505338808201aad86f8194734");
                    sb.append(File.separator);
                    sb.append(context.getPackageName());
                    sb.append(File.separator);
                    String sb2 = sb.toString();
                    File file = new File(sb2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(sb2 + str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2, z);
                    try {
                        fileOutputStream2.write(Base64.encode(str2.getBytes("utf-8"), 2));
                        fileOutputStream2.close();
                    } catch (FileNotFoundException unused) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused4) {
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean k(Context context) {
        NetworkInfo m = m(context);
        return m != null && m.isConnected() && 1 == m.getType();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
        r1 = r0;
        r0 = r2;
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0035, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] l(Context context, String str) {
        byte[] bArr;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r0 = null;
        r0 = null;
        byte[] bArr2 = null;
        r0 = null;
        FileInputStream fileInputStream3 = null;
        try {
            fileInputStream = context.openFileInput(str);
            if (fileInputStream != null) {
                try {
                    bArr2 = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr2);
                } catch (FileNotFoundException unused) {
                    byte[] bArr3 = bArr2;
                    fileInputStream3 = fileInputStream;
                    bArr = bArr3;
                } catch (IOException unused2) {
                    byte[] bArr4 = bArr2;
                    fileInputStream3 = fileInputStream;
                    bArr = bArr4;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream == null) {
                return bArr2;
            }
        } catch (FileNotFoundException unused4) {
            bArr = null;
        } catch (IOException unused5) {
            bArr = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused6) {
            return bArr2;
        }
    }

    public static NetworkInfo m(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            d.d.a.a.a.e();
            d.d.a.a.a.onEvent("Exception_On_getActiveNetworkInfo" + e2.toString());
            return null;
        }
    }

    public static String n(Context context, String str) {
        String externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState) && !"mounted_ro".equals(externalStorageState)) {
            return "";
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory + File.separator + "c82c403505338808201aad86f8194734" + File.separator + context.getPackageName() + File.separator + str);
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(Base64.decode(bArr, 2), "utf-8");
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return str2;
            } catch (FileNotFoundException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return "";
                }
                try {
                    fileInputStream.close();
                    return "";
                } catch (IOException unused3) {
                    return "";
                }
            } catch (IOException unused4) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return "";
                }
                fileInputStream.close();
                return "";
            } catch (IllegalArgumentException unused5) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return "";
                }
                fileInputStream.close();
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused7) {
        } catch (IOException unused8) {
        } catch (IllegalArgumentException unused9) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
