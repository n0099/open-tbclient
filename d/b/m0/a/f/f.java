package d.b.m0.a.f;

import android.os.Build;
import android.os.Environment;
import com.android.internal.http.multipart.Part;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f64842a = {StorageUtils.EXTERNAL_STORAGE_PERMISSION};

    /* renamed from: b  reason: collision with root package name */
    public static File f64843b;

    /* renamed from: c  reason: collision with root package name */
    public static RandomAccessFile f64844c;

    public static boolean a(String str) {
        File file = new File(str);
        f64843b = file;
        return file.exists();
    }

    public static boolean b(String str) {
        File file = new File(str);
        f64843b = file;
        return file.delete();
    }

    public static boolean c() {
        String externalStorageState = Environment.getExternalStorageState();
        if (Build.VERSION.SDK_INT >= 23) {
            return d.b.m0.a.c.i().g().checkCallingOrSelfPermission(f64842a[0]) == 0 && externalStorageState.equals("mounted");
        }
        return externalStorageState.equals("mounted");
    }

    public static synchronized boolean d(String str, String str2, String str3) {
        synchronized (f.class) {
            if (c() && f(str2, str3)) {
                try {
                    f64843b = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f64843b, "rwd");
                    f64844c = randomAccessFile;
                    randomAccessFile.seek(f64843b.length());
                    f64844c.write((str + Part.CRLF).getBytes("UTF-8"));
                    f64844c.close();
                    return true;
                } catch (Exception e2) {
                    i.e(e2);
                    return false;
                }
            }
            return false;
        }
    }

    public static synchronized String e(String str, String str2) {
        synchronized (f.class) {
            if (c()) {
                if (a(str + str2)) {
                    try {
                        f64843b = new File(str + str2);
                        f64844c = new RandomAccessFile(f64843b, r.f7699a);
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = f64844c.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8"));
                            stringBuffer.append(",");
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            f64844c.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return stringBuffer2;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        try {
                            f64844c.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                return "";
            }
            return "";
        }
    }

    public static boolean f(String str, String str2) {
        try {
            f64843b = new File(str);
            if (!a(str)) {
                f64843b.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            f64843b = file;
            if (file.exists()) {
                return true;
            }
            return f64843b.createNewFile();
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
