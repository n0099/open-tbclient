package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
class dh {

    /* renamed from: a  reason: collision with root package name */
    private static String f13937a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private int f281a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f284a;

    /* renamed from: b  reason: collision with other field name */
    private String f285b;
    private String c;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a  reason: collision with other field name */
    private final SimpleDateFormat f282a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: b  reason: collision with root package name */
    private int f13938b = 2097152;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<File> f283a = new ArrayList<>();

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        int i;
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (i2 < read && matcher.find(i2)) {
                i = matcher.start();
                String substring = str.substring(i, this.f285b.length() + i);
                if (this.f284a) {
                    if (substring.compareTo(this.c) > 0) {
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f285b) >= 0) {
                    this.f284a = true;
                    i3 = i;
                }
                int indexOf = str.indexOf(10, i);
                i2 = indexOf != -1 ? i + indexOf : i + this.f285b.length();
            }
            i = read;
            if (this.f284a) {
                int i4 = i - i3;
                this.f281a += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                }
                bufferedWriter.write(cArr, i3, i4);
                if (this.f281a > this.f13938b) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x011d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0125 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0086 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.String] */
    private void a(File file) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = null;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("model :").append(Build.MODEL);
                    sb.append("; os :").append(Build.VERSION.INCREMENTAL);
                    sb.append("; uid :").append(com.xiaomi.push.service.be.m585a());
                    sb.append("; lng :").append(Locale.getDefault().toString());
                    sb.append("; sdk :").append(39);
                    sb.append("; andver :").append(Build.VERSION.SDK_INT);
                    sb.append("\n");
                    bufferedWriter.write(sb.toString());
                    this.f281a = 0;
                    Iterator<File> it = this.f283a.iterator();
                    bufferedReader2 = "\n";
                    while (true) {
                        try {
                            bufferedReader2 = bufferedReader3;
                            if (!it.hasNext()) {
                                bufferedWriter.write(cz.a().c());
                                y.a(bufferedWriter);
                                y.a(bufferedReader2);
                                return;
                            }
                            bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                            try {
                                a(bufferedReader3, bufferedWriter, compile);
                                bufferedReader3.close();
                                bufferedReader2 = bufferedReader2;
                            } catch (FileNotFoundException e) {
                                e = e;
                                bufferedReader2 = bufferedReader3;
                                com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                                y.a(bufferedWriter);
                                y.a(bufferedReader2);
                                return;
                            } catch (IOException e2) {
                                e = e2;
                                bufferedReader2 = bufferedReader3;
                                com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                                y.a(bufferedWriter);
                                y.a(bufferedReader2);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader3;
                                y.a(bufferedWriter);
                                y.a(bufferedReader);
                                throw th;
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedReader2 = null;
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            bufferedWriter = null;
            bufferedReader2 = null;
        } catch (IOException e8) {
            e = e8;
            bufferedWriter = null;
            bufferedReader2 = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            bufferedReader = null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    dh m252a(File file) {
        if (file.exists()) {
            this.f283a.add(file);
        }
        return this;
    }

    dh a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f285b = this.f282a.format(date2);
            this.c = this.f282a.format(date);
        } else {
            this.f285b = this.f282a.format(date);
            this.c = this.f282a.format(date2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            m252a(new File(file2, "xmsf.log.1"));
            m252a(new File(file2, "xmsf.log"));
        } else {
            file2 = new File(context.getExternalFilesDir(null) + f13937a);
            m252a(new File(file2, "log0.txt"));
            m252a(new File(file2, "log1.txt"));
        }
        if (file2.isDirectory()) {
            File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
            if (file3.exists()) {
                return null;
            }
            a(date, date2);
            long currentTimeMillis = System.currentTimeMillis();
            File file4 = new File(file, "log.txt");
            a(file4);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
            if (file4.exists()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                y.a(file3, file4);
                com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                file4.delete();
                if (file3.exists()) {
                    return file3;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (i != 0) {
            this.f13938b = i;
        }
    }
}
