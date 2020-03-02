package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
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
/* loaded from: classes8.dex */
public class dh implements LoggerInterface {

    /* renamed from: a  reason: collision with other field name */
    private Context f238a;
    private String b;
    private String c = "";

    /* renamed from: a  reason: collision with other field name */
    private static final SimpleDateFormat f236a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    private static al a = new al(true);

    /* renamed from: a  reason: collision with other field name */
    public static String f235a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private static List<Pair<String, Throwable>> f237a = Collections.synchronizedList(new ArrayList());

    public dh(Context context) {
        this.f238a = context;
        if (context.getApplicationContext() != null) {
            this.f238a = context.getApplicationContext();
        }
        this.b = this.f238a.getPackageName();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:109:0x021e */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.BufferedWriter */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m221a() {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedWriter bufferedWriter;
        RandomAccessFile randomAccessFile2;
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
            if (TextUtils.isEmpty(this.c) && (externalFilesDir = this.f238a.getExternalFilesDir(null)) != null) {
                this.c = externalFilesDir.getAbsolutePath() + "";
            }
            File file = new File(this.c + f235a);
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.b, "Create mipushlog directory fail.");
                if (0 != 0) {
                    try {
                        bufferedWriter3.close();
                    } catch (IOException e) {
                        Log.e(this.b, "", e);
                    }
                }
                if (0 != 0 && bufferedWriter2.isValid()) {
                    try {
                        fileLock3.release();
                    } catch (IOException e2) {
                        Log.e(this.b, "", e2);
                    }
                }
                if (0 != 0) {
                    try {
                        randomAccessFile3.close();
                        return;
                    } catch (IOException e3) {
                        Log.e(this.b, "", e3);
                        return;
                    }
                }
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f237a.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f237a.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter4.write(str + "\n");
                        } catch (Exception e4) {
                            e = e4;
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
                            } catch (IOException e5) {
                                Log.e(this.b, "", e5);
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                Log.e(this.b, "", e6);
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e7) {
                                Log.e(this.b, "", e7);
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                        fileLock2 = fileLock;
                        randomAccessFile2 = randomAccessFile;
                        try {
                            Log.e(this.b, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e9) {
                                    Log.e(this.b, "", e9);
                                }
                            }
                            if (fileLock2 != null && fileLock2.isValid()) {
                                try {
                                    fileLock2.release();
                                } catch (IOException e10) {
                                    Log.e(this.b, "", e10);
                                }
                            }
                            if (randomAccessFile2 != null) {
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e11) {
                                    Log.e(this.b, "", e11);
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile2;
                            bufferedWriter2 = bufferedWriter;
                            if (bufferedWriter2 != 0) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e12) {
                                    Log.e(this.b, "", e12);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e13) {
                                    Log.e(this.b, "", e13);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e14) {
                                    Log.e(this.b, "", e14);
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
                } catch (Exception e15) {
                    e = e15;
                    bufferedWriter = null;
                    randomAccessFile2 = randomAccessFile;
                    fileLock2 = fileLock;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e16) {
                e = e16;
                bufferedWriter = null;
                randomAccessFile2 = randomAccessFile;
            } catch (Throwable th5) {
                th = th5;
                fileLock = null;
            }
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
        f237a.add(new Pair<>(String.format("%1$s %2$s %3$s ", f236a.format(new Date()), this.b, str), th));
        a.a(new di(this));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.b = str;
    }
}
