package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
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
/* loaded from: classes10.dex */
public class dd {
    public static String a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    public int f204a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f207a;

    /* renamed from: b  reason: collision with other field name */
    public String f208b;
    public String c;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f205a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public int b = 2097152;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<File> f206a = new ArrayList<>();

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= read || !matcher.find(i)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f208b.length() + start);
                if (this.f207a) {
                    if (substring.compareTo(this.c) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f208b) >= 0) {
                    this.f207a = true;
                    i2 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f208b.length();
                }
                i = start + indexOf;
            }
            if (this.f207a) {
                int i3 = read - i2;
                this.f204a += i3;
                bufferedWriter.write(cArr, i2, i3);
                if (z || this.f204a > this.b) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    private void a(File file) {
        BufferedReader bufferedReader;
        String str;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.bv.m801a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f204a = 0;
                    Iterator<File> it = this.f206a.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.channel.commonutils.logger.b.c(str);
                            y.a(bufferedReader2);
                            y.a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.channel.commonutils.logger.b.c(str);
                            y.a(bufferedReader2);
                            y.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            y.a(bufferedReader2);
                            y.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(cu.a().c());
                    y.a(bufferedWriter);
                    y.a(bufferedReader2);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                } catch (IOException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public dd m352a(File file) {
        if (file.exists()) {
            this.f206a.add(file);
        }
        return this;
    }

    public dd a(Date date, Date date2) {
        String format;
        if (date.after(date2)) {
            this.f208b = this.f205a.format(date2);
            format = this.f205a.format(date);
        } else {
            this.f208b = this.f205a.format(date);
            format = this.f205a.format(date2);
        }
        this.c = format;
        return this;
    }

    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        File file3;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = new File(context.getExternalFilesDir(null), com.xiaomi.push.service.bk.N);
            if (!file2.exists()) {
                file2 = new File(context.getFilesDir(), com.xiaomi.push.service.bk.N);
            }
            if (!file2.exists()) {
                file2 = context.getFilesDir();
            }
            m352a(new File(file2, "xmsf.log.1"));
            file3 = new File(file2, "xmsf.log");
        } else {
            file2 = new File(context.getExternalFilesDir(null) + a);
            m352a(new File(file2, "log0.txt"));
            file3 = new File(file2, "log1.txt");
        }
        m352a(file3);
        if (file2.isDirectory()) {
            File file4 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
            if (file4.exists()) {
                return null;
            }
            a(date, date2);
            long currentTimeMillis = System.currentTimeMillis();
            File file5 = new File(file, "log.txt");
            a(file5);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
            if (file5.exists()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                y.a(file4, file5);
                com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                file5.delete();
                if (file4.exists()) {
                    return file4;
                }
            }
            return null;
        }
        return null;
    }

    public void a(int i) {
        if (i != 0) {
            this.b = i;
        }
    }
}
