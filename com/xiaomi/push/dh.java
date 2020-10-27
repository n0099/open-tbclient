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
/* loaded from: classes12.dex */
class dh {

    /* renamed from: a  reason: collision with root package name */
    private static String f4852a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private int f200a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f203a;

    /* renamed from: b  reason: collision with other field name */
    private String f204b;
    private String c;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a  reason: collision with other field name */
    private final SimpleDateFormat f201a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int b = 2097152;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<File> f202a = new ArrayList<>();

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        int i;
        boolean z;
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z2 = false;
        while (read != -1 && !z2) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (i2 < read && matcher.find(i2)) {
                i = matcher.start();
                String substring = str.substring(i, this.f204b.length() + i);
                if (this.f203a) {
                    if (substring.compareTo(this.c) > 0) {
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f204b) >= 0) {
                    this.f203a = true;
                    i3 = i;
                }
                int indexOf = str.indexOf(10, i);
                i2 = indexOf != -1 ? i + indexOf : i + this.f204b.length();
            }
            i = read;
            z = z2;
            if (this.f203a) {
                int i4 = i - i3;
                this.f200a += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                }
                bufferedWriter.write(cArr, i3, i4);
                if (this.f200a > this.b) {
                    return;
                }
            }
            z2 = z;
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0086 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.String] */
    private void a(File file) {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader = null;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("model :").append(Build.MODEL);
                    sb.append("; os :").append(Build.VERSION.INCREMENTAL);
                    sb.append("; uid :").append(com.xiaomi.push.service.be.m559a());
                    sb.append("; lng :").append(Locale.getDefault().toString());
                    sb.append("; sdk :").append(39);
                    sb.append("; andver :").append(Build.VERSION.SDK_INT);
                    sb.append("\n");
                    bufferedWriter.write(sb.toString());
                    this.f200a = 0;
                    Iterator<File> it = this.f202a.iterator();
                    BufferedReader bufferedReader2 = "\n";
                    while (true) {
                        try {
                            bufferedReader2 = bufferedReader;
                            if (!it.hasNext()) {
                                bufferedWriter.write(cz.a().c());
                                y.a(bufferedWriter);
                                y.a(bufferedReader2);
                                return;
                            }
                            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader2;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            y.a(bufferedWriter);
                            y.a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            y.a(bufferedWriter);
                            y.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            y.a(bufferedWriter);
                            y.a(bufferedReader);
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedWriter = null;
        } catch (IOException e6) {
            e = e6;
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    dh m226a(File file) {
        if (file.exists()) {
            this.f202a.add(file);
        }
        return this;
    }

    dh a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f204b = this.f201a.format(date2);
            this.c = this.f201a.format(date);
        } else {
            this.f204b = this.f201a.format(date);
            this.c = this.f201a.format(date2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            m226a(new File(file2, "xmsf.log.1"));
            m226a(new File(file2, "xmsf.log"));
        } else {
            file2 = new File(context.getExternalFilesDir(null) + f4852a);
            m226a(new File(file2, "log0.txt"));
            m226a(new File(file2, "log1.txt"));
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
            this.b = i;
        }
    }
}
