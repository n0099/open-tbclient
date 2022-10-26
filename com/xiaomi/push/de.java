package com.xiaomi.push;

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
/* loaded from: classes8.dex */
public class de {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "/MiPushLog";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f202a;

    /* renamed from: a  reason: collision with other field name */
    public final SimpleDateFormat f203a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList f204a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f205a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public String f206b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56376865, "Lcom/xiaomi/push/de;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56376865, "Lcom/xiaomi/push/de;");
        }
    }

    public de() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f203a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.b = 2097152;
        this.f204a = new ArrayList();
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
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= read || !matcher.find(i)) {
                        break;
                    }
                    int start = matcher.start();
                    String substring = str.substring(start, this.f206b.length() + start);
                    if (this.f205a) {
                        if (substring.compareTo(this.c) > 0) {
                            read = start;
                            z = true;
                            break;
                        }
                    } else if (substring.compareTo(this.f206b) >= 0) {
                        this.f205a = true;
                        i2 = start;
                    }
                    int indexOf = str.indexOf(10, start);
                    if (indexOf == -1) {
                        indexOf = this.f206b.length();
                    }
                    i = start + indexOf;
                }
                if (this.f205a) {
                    int i3 = read - i2;
                    this.f202a += i3;
                    bufferedWriter.write(cArr, i2, i3);
                    if (z || this.f202a > this.b) {
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
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + com.xiaomi.push.service.bv.m648a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f202a = 0;
                    Iterator it = this.f204a.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e) {
                            e = e;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.channel.commonutils.logger.b.c(str);
                            ab.a(bufferedReader2);
                            ab.a(bufferedReader);
                            return;
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            com.xiaomi.channel.commonutils.logger.b.c(str);
                            ab.a(bufferedReader2);
                            ab.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            ab.a(bufferedReader2);
                            ab.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(cv.a().c());
                    ab.a(bufferedWriter);
                    ab.a(bufferedReader2);
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
    public de m262a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
            if (file.exists()) {
                this.f204a.add(file);
            }
            return this;
        }
        return (de) invokeL.objValue;
    }

    public de a(Date date, Date date2) {
        InterceptResult invokeLL;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, date, date2)) == null) {
            if (date.after(date2)) {
                this.f206b = this.f203a.format(date2);
                format = this.f203a.format(date);
            } else {
                this.f206b = this.f203a.format(date);
                format = this.f203a.format(date2);
            }
            this.c = format;
            return this;
        }
        return (de) invokeLL.objValue;
    }

    public File a(Context context, Date date, Date date2, File file) {
        InterceptResult invokeLLLL;
        File file2;
        File file3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, date, date2, file)) == null) {
            if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
                file2 = new File(context.getExternalFilesDir(null), com.xiaomi.push.service.bk.N);
                if (!file2.exists()) {
                    file2 = new File(context.getFilesDir(), com.xiaomi.push.service.bk.N);
                }
                if (!file2.exists()) {
                    file2 = context.getFilesDir();
                }
                m262a(new File(file2, "xmsf.log.1"));
                file3 = new File(file2, "xmsf.log");
            } else {
                file2 = new File(context.getExternalFilesDir(null) + a);
                m262a(new File(file2, "log0.txt"));
                file3 = new File(file2, "log1.txt");
            }
            m262a(file3);
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
                    ab.a(file4, file5);
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

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i == 0) {
            return;
        }
        this.b = i;
    }
}
