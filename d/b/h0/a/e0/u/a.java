package d.b.h0.a.e0.u;

import android.preference.PreferenceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.b.h0.g.i0.f.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f45007a = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";

    /* renamed from: b  reason: collision with root package name */
    public static final String f45008b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f45009c;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(AppRuntime.getAppContext().getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("libs");
        f45008b = sb.toString();
        f45009c = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileLock fileLock;
        File file = new File(f45007a + File.separator + GlobalConstants.LIB_ZEUS_V8);
        if (!file.exists() || file.length() <= 0) {
            return;
        }
        File file2 = new File(f45008b);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        File file3 = new File(file2, GlobalConstants.LIB_ZEUS_V8);
        if (file.length() == file3.length()) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            File file4 = new File(file2, "libzeusv8.so.lock");
            if (!file4.exists()) {
                try {
                    file4.createNewFile();
                } catch (IOException unused) {
                }
            }
            FileChannel channel = new RandomAccessFile(file4, "rw").getChannel();
            try {
                fileLock = channel.lock();
                if (fileLock != null) {
                    try {
                        if (fileLock.isValid()) {
                            if (file.length() == file3.length()) {
                                d.b.h0.p.d.a(null);
                                d.b.h0.p.d.a(null);
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                d.b.h0.p.d.a(channel);
                                return;
                            }
                            FileInputStream fileInputStream2 = new FileInputStream(file);
                            try {
                                fileOutputStream = new FileOutputStream(file3);
                                try {
                                    byte[] bArr = new byte[8192];
                                    while (true) {
                                        int read = fileInputStream2.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.flush();
                                    fileInputStream = fileInputStream2;
                                    d.b.h0.p.d.a(fileInputStream);
                                    d.b.h0.p.d.a(fileOutputStream);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    d.b.h0.p.d.a(channel);
                                } catch (Exception e4) {
                                    fileChannel = channel;
                                    e = e4;
                                    fileInputStream = fileInputStream2;
                                    try {
                                        e.printStackTrace();
                                        d.b.h0.p.d.a(fileInputStream);
                                        d.b.h0.p.d.a(fileOutputStream);
                                        if (fileLock != null) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e5) {
                                                e5.printStackTrace();
                                            }
                                        }
                                        d.b.h0.p.d.a(fileChannel);
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        d.b.h0.p.d.a(fileInputStream);
                                        d.b.h0.p.d.a(fileOutputStream);
                                        if (fileLock != null) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                        d.b.h0.p.d.a(fileChannel);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    fileChannel = channel;
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    d.b.h0.p.d.a(fileInputStream);
                                    d.b.h0.p.d.a(fileOutputStream);
                                    if (fileLock != null) {
                                    }
                                    d.b.h0.p.d.a(fileChannel);
                                    throw th;
                                }
                            } catch (Exception e7) {
                                fileChannel = channel;
                                e = e7;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                fileChannel = channel;
                                th = th3;
                                fileOutputStream = null;
                            }
                        }
                    } catch (Exception e8) {
                        fileChannel = channel;
                        e = e8;
                        fileOutputStream = null;
                    } catch (Throwable th4) {
                        fileChannel = channel;
                        th = th4;
                        fileOutputStream = null;
                    }
                }
                fileOutputStream = null;
                d.b.h0.p.d.a(fileInputStream);
                d.b.h0.p.d.a(fileOutputStream);
                if (fileLock != null) {
                }
                d.b.h0.p.d.a(channel);
            } catch (Exception e9) {
                fileChannel = channel;
                fileLock = null;
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th5) {
                fileChannel = channel;
                fileLock = null;
                th = th5;
                fileOutputStream = null;
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            fileChannel = null;
            fileLock = null;
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
            fileChannel = null;
            fileLock = null;
        }
    }

    public static boolean b() {
        return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
    }

    public static f c(boolean z) {
        if (z) {
            return f.c(SoLoader.load(AppRuntime.getAppContext(), "v8.engine"));
        }
        boolean z2 = true;
        if (b()) {
            a();
            return f.d(d.a("zeusv8", f45008b, true), (d.a("arcore_sdk_c", f45007a, false) && d.a("arcore_sdk_jni", f45007a, false) && d.a("c++_shared", f45007a, false) && d.a("v8.engine", f45007a, false)) ? false : false);
        }
        d.a("zeusv8", f45009c, true);
        return f.c(d.a("v8.engine", f45009c, true));
    }
}
