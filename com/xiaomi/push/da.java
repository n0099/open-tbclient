package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public class da {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f70779a = "/MiPushLog";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f217a;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f218a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<File> f219a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f220a;

    /* renamed from: b  reason: collision with root package name */
    public int f70780b;

    /* renamed from: b  reason: collision with other field name */
    public String f221b;

    /* renamed from: c  reason: collision with root package name */
    public String f70781c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56376989, "Lcom/xiaomi/push/da;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56376989, "Lcom/xiaomi/push/da;");
        }
    }

    public da() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f218a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f70780b = 2097152;
        this.f219a = new ArrayList<>();
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, bufferedReader, bufferedWriter, pattern) == null) {
            char[] cArr = new char[4096];
            int read = bufferedReader.read(cArr);
            boolean z = false;
            while (read != -1 && !z) {
                String str = new String(cArr, 0, read);
                Matcher matcher = pattern.matcher(str);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= read || !matcher.find(i2)) {
                        break;
                    }
                    int start = matcher.start();
                    String substring = str.substring(start, this.f221b.length() + start);
                    if (this.f220a) {
                        if (substring.compareTo(this.f70781c) > 0) {
                            read = start;
                            z = true;
                            break;
                        }
                    } else if (substring.compareTo(this.f221b) >= 0) {
                        this.f220a = true;
                        i3 = start;
                    }
                    int indexOf = str.indexOf(10, start);
                    if (indexOf == -1) {
                        indexOf = this.f221b.length();
                    }
                    i2 = start + indexOf;
                }
                if (this.f220a) {
                    int i4 = read - i3;
                    this.f217a += i4;
                    bufferedWriter.write(cArr, i3, i4);
                    if (z || this.f217a > this.f70780b) {
                        return;
                    }
                }
                read = bufferedReader.read(cArr);
            }
        }
    }

    private void a(File file) {
        BufferedReader bufferedReader;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65539, this, file) != null) {
            return;
        }
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.bi.m615a() + "; lng :" + Locale.getDefault().toString() + "; sdk :43; andver :" + Build.VERSION.SDK_INT + StringUtils.LF);
                    this.f217a = 0;
                    Iterator<File> it = this.f219a.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.channel.commonutils.logger.b.c(str);
                            y.a(bufferedReader2);
                            y.a(bufferedReader);
                            return;
                        } catch (IOException e3) {
                            e = e3;
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
                    bufferedWriter.write(cs.a().c());
                    y.a(bufferedWriter);
                    y.a(bufferedReader2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            bufferedReader = null;
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public da m242a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            if (file.exists()) {
                this.f219a.add(file);
            }
            return this;
        }
        return (da) invokeL.objValue;
    }

    public da a(Date date, Date date2) {
        InterceptResult invokeLL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, date, date2)) == null) {
            if (date.after(date2)) {
                this.f221b = this.f218a.format(date2);
                format = this.f218a.format(date);
            } else {
                this.f221b = this.f218a.format(date);
                format = this.f218a.format(date2);
            }
            this.f70781c = format;
            return this;
        }
        return (da) invokeLL.objValue;
    }

    public File a(Context context, Date date, Date date2, File file) {
        InterceptResult invokeLLLL;
        File file2;
        File file3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, date, date2, file)) == null) {
            if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
                file2 = new File(context.getExternalFilesDir(null), "dump");
                if (!file2.exists()) {
                    file2 = context.getFilesDir();
                }
                m242a(new File(file2, "xmsf.log.1"));
                file3 = new File(file2, "xmsf.log");
            } else {
                file2 = new File(context.getExternalFilesDir(null) + f70779a);
                m242a(new File(file2, "log0.txt"));
                file3 = new File(file2, "log1.txt");
            }
            m242a(file3);
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
        return (File) invokeLLLL.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f70780b = i2;
    }
}
