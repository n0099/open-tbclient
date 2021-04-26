package d.a.n0.a.f;

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
    public static String[] f63421a = {StorageUtils.EXTERNAL_STORAGE_PERMISSION};

    /* renamed from: b  reason: collision with root package name */
    public static File f63422b;

    /* renamed from: c  reason: collision with root package name */
    public static RandomAccessFile f63423c;

    public static boolean a(String str) {
        File file = new File(str);
        f63422b = file;
        return file.exists();
    }

    public static boolean b(String str) {
        File file = new File(str);
        f63422b = file;
        return file.delete();
    }

    public static boolean c() {
        String externalStorageState = Environment.getExternalStorageState();
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a.n0.a.c.i().g().checkCallingOrSelfPermission(f63421a[0]) == 0 && externalStorageState.equals("mounted");
        }
        return externalStorageState.equals("mounted");
    }

    public static synchronized boolean d(String str, String str2, String str3) {
        synchronized (f.class) {
            if (c() && f(str2, str3)) {
                try {
                    f63422b = new File(str2 + str3);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f63422b, "rwd");
                    f63423c = randomAccessFile;
                    randomAccessFile.seek(f63422b.length());
                    f63423c.write((str + Part.CRLF).getBytes("UTF-8"));
                    f63423c.close();
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
                        f63422b = new File(str + str2);
                        f63423c = new RandomAccessFile(f63422b, r.f7975a);
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = f63423c.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(new String(readLine.getBytes("ISO-8859-1"), "utf-8"));
                            stringBuffer.append(",");
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            f63423c.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return stringBuffer2;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        try {
                            f63423c.close();
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
            f63422b = new File(str);
            if (!a(str)) {
                f63422b.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            File file = new File(str + str2);
            f63422b = file;
            if (file.exists()) {
                return true;
            }
            return f63422b.createNewFile();
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
