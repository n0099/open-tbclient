package d.a.l0.a.b1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44480a = k.f46875a;

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b8 A[Catch: all -> 0x00ef, TryCatch #10 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:11:0x001b, B:21:0x0073, B:22:0x0076, B:49:0x00b0, B:51:0x00b8, B:52:0x00d4, B:25:0x007b, B:26:0x0081, B:57:0x00dd, B:58:0x00e0, B:62:0x00ee, B:61:0x00e5, B:44:0x00a1, B:45:0x00a4, B:48:0x00a9), top: B:74:0x0003, inners: #0, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(String str) {
        BufferedReader bufferedReader;
        String str2;
        String stackTraceString;
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            FileLock fileLock = null;
            if (TextUtils.isEmpty(str) && f44480a) {
                Log.w("SwanAppFile", "path name is empty");
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            try {
                FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                FileLock lock = channel.lock(0L, Long.MAX_VALUE, true);
                try {
                    bufferedReader = new BufferedReader(Channels.newReader(channel, Charset.defaultCharset().name()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e2) {
                            e = e2;
                            fileLock = lock;
                            try {
                                Log.e("SwanAppFile", Log.getStackTraceString(e));
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e3) {
                                        str2 = "SwanAppFile";
                                        stackTraceString = Log.getStackTraceString(e3);
                                        Log.e(str2, stackTraceString);
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        if (f44480a) {
                                        }
                                        return stringBuffer.toString();
                                    }
                                }
                                d.a.l0.t.d.d(bufferedReader);
                                long currentTimeMillis22 = System.currentTimeMillis();
                                if (f44480a) {
                                }
                                return stringBuffer.toString();
                            } catch (Throwable th) {
                                th = th;
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e4) {
                                        Log.e("SwanAppFile", Log.getStackTraceString(e4));
                                        throw th;
                                    }
                                }
                                d.a.l0.t.d.d(bufferedReader);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileLock = lock;
                            if (fileLock != null) {
                            }
                            d.a.l0.t.d.d(bufferedReader);
                            throw th;
                        }
                    }
                    if (f44480a) {
                        Log.d("SwanAppFile", "Read file: " + stringBuffer.toString());
                    }
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (IOException e5) {
                            str2 = "SwanAppFile";
                            stackTraceString = Log.getStackTraceString(e5);
                            Log.e(str2, stackTraceString);
                            long currentTimeMillis222 = System.currentTimeMillis();
                            if (f44480a) {
                            }
                            return stringBuffer.toString();
                        }
                    }
                    d.a.l0.t.d.d(bufferedReader);
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            long currentTimeMillis2222 = System.currentTimeMillis();
            if (f44480a) {
                Log.d("SwanAppFile", "Read file done: cost time = " + (currentTimeMillis2222 - currentTimeMillis) + "ms");
            }
            return stringBuffer.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00be A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0012, B:26:0x0079, B:30:0x0087, B:47:0x00b6, B:49:0x00be, B:29:0x007e, B:54:0x00df, B:58:0x00ed, B:59:0x00f0, B:57:0x00e4, B:42:0x00a5, B:46:0x00b3, B:45:0x00aa), top: B:65:0x0003, inners: #0, #4, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(String str, String str2, boolean z) {
        FileChannel fileChannel;
        FileChannel channel;
        synchronized (a.class) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = false;
            if (TextUtils.isEmpty(str) && f44480a) {
                Log.w("SwanAppFile", "path name is null");
                return false;
            }
            FileLock fileLock = null;
            try {
                File file = new File(str);
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                channel = new FileOutputStream(file, z).getChannel();
            } catch (IOException e2) {
                e = e2;
                fileChannel = null;
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                fileLock = channel.lock();
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                channel.write(ByteBuffer.wrap(str2.getBytes()));
                z2 = true;
                if (f44480a) {
                    Log.d("SwanAppFile", "Write file：" + str2);
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e3) {
                        Log.e("SwanAppFile", Log.getStackTraceString(e3));
                    }
                }
                d.a.l0.t.d.d(channel);
            } catch (IOException e4) {
                fileChannel = channel;
                e = e4;
                try {
                    Log.e("SwanAppFile", Log.getStackTraceString(e));
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            Log.e("SwanAppFile", Log.getStackTraceString(e5));
                        }
                    }
                    d.a.l0.t.d.d(fileChannel);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (f44480a) {
                    }
                    return z2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            Log.e("SwanAppFile", Log.getStackTraceString(e6));
                        }
                    }
                    d.a.l0.t.d.d(fileChannel);
                    throw th;
                }
            } catch (Throwable th3) {
                fileChannel = channel;
                th = th3;
                if (fileLock != null) {
                }
                d.a.l0.t.d.d(fileChannel);
                throw th;
            }
            long currentTimeMillis22 = System.currentTimeMillis();
            if (f44480a) {
                Log.d("SwanAppFile", "Write file done: cost time =" + (currentTimeMillis22 - currentTimeMillis) + "ms");
            }
            return z2;
        }
    }
}
