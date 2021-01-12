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
/* loaded from: classes6.dex */
public class dm implements LoggerInterface {

    /* renamed from: a  reason: collision with other field name */
    private Context f303a;

    /* renamed from: b  reason: collision with root package name */
    private String f13949b;
    private String c = "";

    /* renamed from: a  reason: collision with other field name */
    private static final SimpleDateFormat f301a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a  reason: collision with root package name */
    private static al f13948a = new al(true);

    /* renamed from: a  reason: collision with other field name */
    public static String f300a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private static List<Pair<String, Throwable>> f302a = Collections.synchronizedList(new ArrayList());

    public dm(Context context) {
        this.f303a = context;
        if (context.getApplicationContext() != null) {
            this.f303a = context.getApplicationContext();
        }
        this.f13949b = this.f303a.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a  reason: collision with other method in class */
    public void m256a() {
        BufferedWriter bufferedWriter;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedWriter bufferedWriter2;
        File externalFilesDir;
        FileLock fileLock2 = null;
        RandomAccessFile randomAccessFile2 = null;
        FileLock fileLock3 = null;
        BufferedWriter bufferedWriter3 = null;
        try {
            try {
                if (TextUtils.isEmpty(this.c) && (externalFilesDir = this.f303a.getExternalFilesDir(null)) != null) {
                    this.c = externalFilesDir.getAbsolutePath() + "";
                }
                File file = new File(this.c + f300a);
                if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                    Log.w(this.f13949b, "Create mipushlog directory fail.");
                    if (0 != 0) {
                        try {
                            bufferedWriter3.close();
                        } catch (IOException e) {
                            Log.e(this.f13949b, "", e);
                        }
                    }
                    if (0 != 0 && fileLock2.isValid()) {
                        try {
                            fileLock3.release();
                        } catch (IOException e2) {
                            Log.e(this.f13949b, "", e2);
                        }
                    }
                    if (0 != 0) {
                        try {
                            randomAccessFile2.close();
                            return;
                        } catch (IOException e3) {
                            Log.e(this.f13949b, "", e3);
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
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                        while (!f302a.isEmpty()) {
                            try {
                                Pair<String, Throwable> remove = f302a.remove(0);
                                String str = (String) remove.first;
                                if (remove.second != null) {
                                    str = (str + "\n") + Log.getStackTraceString((Throwable) remove.second);
                                }
                                bufferedWriter.write(str + "\n");
                            } catch (Exception e4) {
                                e = e4;
                                bufferedWriter2 = bufferedWriter;
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e5) {
                                        Log.e(this.f13949b, "", e5);
                                    }
                                }
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e6) {
                                        Log.e(this.f13949b, "", e6);
                                    }
                                }
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (IOException e7) {
                                        Log.e(this.f13949b, "", e7);
                                    }
                                }
                                throw th;
                            }
                        }
                        bufferedWriter.flush();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                            bufferedWriter2 = null;
                        } else {
                            bufferedWriter2 = bufferedWriter;
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
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e8) {
                                    Log.e(this.f13949b, "", e8);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e9) {
                                    Log.e(this.f13949b, "", e9);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e10) {
                                    Log.e(this.f13949b, "", e10);
                                }
                            }
                        } catch (Exception e11) {
                            e = e11;
                            Log.e(this.f13949b, "", e);
                            if (bufferedWriter2 != null) {
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e12) {
                                    Log.e(this.f13949b, "", e12);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e13) {
                                    Log.e(this.f13949b, "", e13);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e14) {
                                    Log.e(this.f13949b, "", e14);
                                }
                            }
                        }
                    } catch (Exception e15) {
                        e = e15;
                        bufferedWriter2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = null;
                    }
                } catch (Exception e16) {
                    e = e16;
                    bufferedWriter2 = null;
                    fileLock = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = null;
                    fileLock = null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedWriter = null;
            }
        } catch (Exception e17) {
            e = e17;
            bufferedWriter2 = null;
            fileLock = null;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
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
        f302a.add(new Pair<>(String.format("%1$s %2$s %3$s ", f301a.format(new Date()), this.f13949b, str), th));
        f13948a.a(new dn(this));
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.f13949b = str;
    }
}
