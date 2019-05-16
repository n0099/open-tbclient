package com.xiaomi.push.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.misc.k;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements LoggerInterface {
    private String d;
    private Context e;
    private String f = "";
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    private static k c = new k(true);
    public static String a = "/MiPushLog";
    private static List<Pair<String, Throwable>> g = Collections.synchronizedList(new ArrayList());

    public f(Context context) {
        this.e = context;
        if (context.getApplicationContext() != null) {
            this.e = context.getApplicationContext();
        }
        this.d = this.e.getPackageName();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x021c */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.BufferedWriter */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedWriter bufferedWriter;
        RandomAccessFile randomAccessFile2;
        String str;
        String str2;
        File externalFilesDir;
        BufferedWriter bufferedWriter2 = 0;
        bufferedWriter2 = 0;
        r2 = null;
        bufferedWriter2 = 0;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile3 = null;
        FileLock fileLock3 = null;
        BufferedWriter bufferedWriter3 = null;
        try {
            if (TextUtils.isEmpty(this.f) && (externalFilesDir = this.e.getExternalFilesDir(null)) != null) {
                this.f = externalFilesDir.getAbsolutePath() + "";
            }
            File file = new File(this.f + a);
            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                File file2 = new File(file, "log.lock");
                if (!file2.exists() || file2.isDirectory()) {
                    file2.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    try {
                        BufferedWriter bufferedWriter4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                        while (!g.isEmpty()) {
                            try {
                                Pair<String, Throwable> remove = g.remove(0);
                                String str3 = (String) remove.first;
                                if (remove.second != null) {
                                    str3 = (str3 + "\n") + Log.getStackTraceString((Throwable) remove.second);
                                }
                                bufferedWriter4.write(str3 + "\n");
                            } catch (Exception e) {
                                e = e;
                                bufferedWriter = bufferedWriter4;
                                fileLock2 = fileLock;
                                randomAccessFile2 = randomAccessFile;
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter2 = bufferedWriter4;
                            }
                        }
                        bufferedWriter4.flush();
                        if (bufferedWriter4 != null) {
                            bufferedWriter4.close();
                            bufferedWriter = null;
                        } else {
                            bufferedWriter = bufferedWriter4;
                        }
                        try {
                            File file3 = new File(file, "log1.txt");
                            if (file3.length() >= 1048576) {
                                File file4 = new File(file, "log0.txt");
                                if (file4.exists() && file4.isFile()) {
                                    file4.delete();
                                }
                                file3.renameTo(file4);
                            }
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e2) {
                                    Log.e(this.d, "", e2);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    Log.e(this.d, "", e3);
                                }
                            }
                            if (randomAccessFile == null) {
                                return;
                            }
                            try {
                                randomAccessFile.close();
                                return;
                            } catch (IOException e4) {
                                e = e4;
                                str = this.d;
                                str2 = "";
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fileLock2 = fileLock;
                            randomAccessFile2 = randomAccessFile;
                            try {
                                Log.e(this.d, "", e);
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e6) {
                                        Log.e(this.d, "", e6);
                                    }
                                }
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException e7) {
                                        Log.e(this.d, "", e7);
                                    }
                                }
                                if (randomAccessFile2 == null) {
                                    return;
                                }
                                try {
                                    randomAccessFile2.close();
                                    return;
                                } catch (IOException e8) {
                                    e = e8;
                                    str = this.d;
                                    str2 = "";
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = fileLock2;
                                randomAccessFile = randomAccessFile2;
                                bufferedWriter2 = bufferedWriter;
                                if (bufferedWriter2 != 0) {
                                    try {
                                        bufferedWriter2.close();
                                    } catch (IOException e9) {
                                        Log.e(this.d, "", e9);
                                    }
                                }
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e10) {
                                        Log.e(this.d, "", e10);
                                    }
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e11) {
                                        Log.e(this.d, "", e11);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != 0) {
                            }
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            if (randomAccessFile != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        bufferedWriter = null;
                        randomAccessFile2 = randomAccessFile;
                        fileLock2 = fileLock;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Exception e13) {
                    e = e13;
                    bufferedWriter = null;
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th5) {
                    th = th5;
                    fileLock = null;
                }
            } else {
                Log.w(this.d, "Create mipushlog directory fail.");
                if (0 != 0) {
                    try {
                        bufferedWriter3.close();
                    } catch (IOException e14) {
                        Log.e(this.d, "", e14);
                    }
                }
                if (0 != 0 && bufferedWriter2.isValid()) {
                    try {
                        fileLock3.release();
                    } catch (IOException e15) {
                        Log.e(this.d, "", e15);
                    }
                }
                if (0 == 0) {
                    return;
                }
                try {
                    randomAccessFile3.close();
                    return;
                } catch (IOException e16) {
                    e = e16;
                    str = this.d;
                    str2 = "";
                }
            }
            Log.e(str, str2, e);
        } catch (Exception e17) {
            e = e17;
            bufferedWriter = null;
            randomAccessFile2 = null;
        } catch (Throwable th6) {
            th = th6;
            fileLock = null;
            randomAccessFile = null;
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str, Throwable th) {
        g.add(new Pair<>(String.format("%1$s %2$s %3$s ", b.format(new Date()), this.d, str), th));
        c.a(new g(this));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.d = str;
    }
}
