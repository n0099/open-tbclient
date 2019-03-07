package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.at;
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
/* loaded from: classes3.dex */
class a {
    private static String b = "/MiPushLog";
    private String c;
    private String d;
    private boolean e;
    private int f;
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int g = 2097152;
    private ArrayList<File> h = new ArrayList<>();

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
                String substring = str.substring(i, this.c.length() + i);
                if (this.e) {
                    if (substring.compareTo(this.d) > 0) {
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.c) >= 0) {
                    this.e = true;
                    i3 = i;
                }
                int indexOf = str.indexOf(10, i);
                i2 = indexOf != -1 ? i + indexOf : i + this.c.length();
            }
            i = read;
            z = z2;
            if (this.e) {
                int i4 = i - i3;
                this.f += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                }
                bufferedWriter.write(cArr, i3, i4);
                if (this.f > this.g) {
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
    private void b(File file) {
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
                    sb.append("; uid :").append(at.e());
                    sb.append("; lng :").append(Locale.getDefault().toString());
                    sb.append("; sdk :").append(26);
                    sb.append("; andver :").append(Build.VERSION.SDK_INT);
                    sb.append("\n");
                    bufferedWriter.write(sb.toString());
                    this.f = 0;
                    Iterator<File> it = this.h.iterator();
                    BufferedReader bufferedReader2 = "\n";
                    while (true) {
                        try {
                            bufferedReader2 = bufferedReader;
                            if (!it.hasNext()) {
                                com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                                com.xiaomi.channel.commonutils.file.a.a(bufferedReader2);
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
                            com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
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

    a a(File file) {
        if (file.exists()) {
            this.h.add(file);
        }
        return this;
    }

    a a(Date date, Date date2) {
        if (date.after(date2)) {
            this.c = this.a.format(date2);
            this.d = this.a.format(date);
        } else {
            this.c = this.a.format(date);
            this.d = this.a.format(date2);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            file2 = new File(context.getExternalFilesDir(null) + b);
            a(new File(file2, "log0.txt"));
            a(new File(file2, "log1.txt"));
        }
        if (file2.isDirectory()) {
            File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
            if (file3.exists()) {
                return null;
            }
            a(date, date2);
            long currentTimeMillis = System.currentTimeMillis();
            File file4 = new File(file, "log.txt");
            b(file4);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
            if (file4.exists()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                com.xiaomi.channel.commonutils.file.a.a(file3, file4);
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
            this.g = i;
        }
    }
}
