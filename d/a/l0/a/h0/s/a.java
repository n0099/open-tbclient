package d.a.l0.a.h0.s;

import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.l0.a.h2.f;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
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
    public static final boolean f46230a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f46231b = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";

    /* renamed from: c  reason: collision with root package name */
    public static final String f46232c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f46233d;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(AppRuntime.getAppContext().getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("libs");
        f46232c = sb.toString();
        f46233d = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0170 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        FileLock fileLock;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        if (f46230a) {
            Log.d("SwanSailorHelper", "fixSoLoadCrash: start");
        }
        File file = new File(f46231b + File.separator + GlobalConstants.LIB_ZEUS_V8);
        if (file.exists() && file.length() > 0) {
            File file2 = new File(f46232c);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, GlobalConstants.LIB_ZEUS_V8);
            long j = h.a().getLong("zeus_v8_modified_time", -1L);
            if (file.lastModified() == j && file.length() == file3.length()) {
                if (f46230a) {
                    Log.d("SwanSailorHelper", "fixSoLoadCrash: srcModifiedTime=" + file.lastModified() + ";savedModifiedTime=" + j + ";srcFileLength=" + file.length() + ";destFileLength=" + file3.length());
                    return;
                }
                return;
            }
            if (f46230a) {
                Log.d("SwanSailorHelper", "fixSoLoadCrash: start copy");
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
                                long lastModified = file.lastModified();
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
                                        h.a().putLong("zeus_v8_modified_time", lastModified);
                                        fileInputStream = fileInputStream2;
                                        d.a.l0.t.d.d(fileInputStream);
                                        d.a.l0.t.d.d(fileOutputStream);
                                        if (fileLock != null) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        d.a.l0.t.d.d(channel);
                                    } catch (Exception e3) {
                                        fileChannel = channel;
                                        e = e3;
                                        fileInputStream = fileInputStream2;
                                        try {
                                            e.printStackTrace();
                                            d.a.l0.t.d.d(fileInputStream);
                                            d.a.l0.t.d.d(fileOutputStream);
                                            if (fileLock != null) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            d.a.l0.t.d.d(fileChannel);
                                            return;
                                        } catch (Throwable th) {
                                            th = th;
                                            d.a.l0.t.d.d(fileInputStream);
                                            d.a.l0.t.d.d(fileOutputStream);
                                            if (fileLock != null) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e5) {
                                                    e5.printStackTrace();
                                                }
                                            }
                                            d.a.l0.t.d.d(fileChannel);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        fileChannel = channel;
                                        th = th2;
                                        fileInputStream = fileInputStream2;
                                        d.a.l0.t.d.d(fileInputStream);
                                        d.a.l0.t.d.d(fileOutputStream);
                                        if (fileLock != null) {
                                        }
                                        d.a.l0.t.d.d(fileChannel);
                                        throw th;
                                    }
                                } catch (Exception e6) {
                                    fileChannel = channel;
                                    e = e6;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    fileChannel = channel;
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            }
                        } catch (Exception e7) {
                            fileChannel = channel;
                            e = e7;
                            fileOutputStream = null;
                        } catch (Throwable th4) {
                            fileChannel = channel;
                            th = th4;
                            fileOutputStream = null;
                        }
                    }
                    fileOutputStream = null;
                    d.a.l0.t.d.d(fileInputStream);
                    d.a.l0.t.d.d(fileOutputStream);
                    if (fileLock != null) {
                    }
                    d.a.l0.t.d.d(channel);
                } catch (Exception e8) {
                    fileChannel = channel;
                    fileOutputStream = null;
                    e = e8;
                    fileLock = null;
                } catch (Throwable th5) {
                    fileChannel = channel;
                    fileOutputStream = null;
                    th = th5;
                    fileLock = null;
                }
            } catch (Exception e9) {
                e = e9;
                fileLock = null;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th6) {
                th = th6;
                fileLock = null;
                fileOutputStream = null;
                fileChannel = null;
            }
        } else if (f46230a) {
            Log.d("SwanSailorHelper", "fixSoLoadCrash: srcFile is not exist");
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
            d.g(AppRuntime.getAppContext(), f46231b);
            boolean h2 = d.h("zeusv8", f46232c, true);
            if (new File(f46231b + File.separator + "libv8.engine.so").exists()) {
                if (!d.h("arcore_sdk_c", f46231b, false) || !d.h("arcore_sdk_jni", f46231b, false) || !d.h("c++_shared", f46231b, false) || !d.h("v8.engine", f46231b, false)) {
                    z2 = false;
                }
            } else {
                z2 = SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
            }
            return f.d(h2, z2);
        }
        d.h("zeusv8", f46233d, true);
        return f.c(d.h("v8.engine", f46233d, true));
    }

    public static void d() {
        h.a().putLong("zeus_v8_modified_time", -1L);
        if (f46230a) {
            Log.d("SwanSailorHelper", "fixSoLoadCrash: resetZeusV8ModifiedTime");
        }
    }
}
