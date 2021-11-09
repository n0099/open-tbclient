package com.kwad.sdk.core.diskcache.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f64366a;
    public static final OutputStream p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f64367b;

    /* renamed from: c  reason: collision with root package name */
    public final File f64368c;

    /* renamed from: d  reason: collision with root package name */
    public final File f64369d;

    /* renamed from: e  reason: collision with root package name */
    public final File f64370e;

    /* renamed from: f  reason: collision with root package name */
    public final File f64371f;

    /* renamed from: g  reason: collision with root package name */
    public final int f64372g;

    /* renamed from: h  reason: collision with root package name */
    public long f64373h;

    /* renamed from: i  reason: collision with root package name */
    public final int f64374i;
    public long j;
    public Writer k;
    public final LinkedHashMap<String, b> l;
    public int m;
    public long n;
    public final Callable<Void> o;

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C1899a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64376a;

        /* renamed from: b  reason: collision with root package name */
        public final b f64377b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f64378c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64379d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64380e;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1900a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C1899a f64381a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1900a(C1899a c1899a, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1899a, outputStream};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((OutputStream) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64381a = c1899a;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f64381a.f64379d = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.flush();
                    } catch (IOException unused) {
                        this.f64381a.f64379d = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(i2);
                    } catch (IOException unused) {
                        this.f64381a.f64379d = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    } catch (IOException unused) {
                        this.f64381a.f64379d = true;
                    }
                }
            }
        }

        public C1899a(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64376a = aVar;
            this.f64377b = bVar;
            this.f64378c = bVar.f64385d ? null : new boolean[aVar.f64374i];
        }

        public OutputStream a(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C1900a c1900a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f64376a.f64374i) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f64376a.f64374i);
                }
                synchronized (this.f64376a) {
                    if (this.f64377b.f64386e != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f64377b.f64385d) {
                        this.f64378c[i2] = true;
                    }
                    File b2 = this.f64377b.b(i2);
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused) {
                        this.f64376a.f64368c.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused2) {
                            return a.p;
                        }
                    }
                    c1900a = new C1900a(fileOutputStream);
                }
                return c1900a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f64379d) {
                    this.f64376a.a(this, false);
                    this.f64376a.b(this.f64377b.f64383b);
                } else {
                    this.f64376a.a(this, true);
                }
                this.f64380e = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f64376a.a(this, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64382a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64383b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f64384c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f64385d;

        /* renamed from: e  reason: collision with root package name */
        public C1899a f64386e;

        /* renamed from: f  reason: collision with root package name */
        public long f64387f;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64382a = aVar;
            this.f64383b = str;
            this.f64384c = new long[aVar.f64374i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) {
                if (strArr.length != this.f64382a.f64374i) {
                    throw b(strArr);
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f64384c[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
            }
        }

        private IOException b(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        public File a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new File(this.f64382a.f64368c, this.f64383b) : (File) invokeI.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.f64384c) {
                    sb.append(' ');
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public File b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                File file = this.f64382a.f64368c;
                return new File(file, this.f64383b + ".tmp");
            }
            return (File) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1945814503, "Lcom/kwad/sdk/core/diskcache/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1945814503, "Lcom/kwad/sdk/core/diskcache/a/a;");
                return;
            }
        }
        f64366a = Pattern.compile("[a-z0-9_-]{1,120}");
        p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                }
            }
        };
    }

    public a(File file, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 0L;
        this.l = new LinkedHashMap<>(0, 0.75f, true);
        this.n = 0L;
        this.f64367b = com.kwad.sdk.core.i.b.a();
        this.o = new Callable<Void>(this) { // from class: com.kwad.sdk.core.diskcache.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f64375a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f64375a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.f64375a) {
                        if (this.f64375a.k == null) {
                            return null;
                        }
                        this.f64375a.j();
                        if (this.f64375a.h()) {
                            this.f64375a.g();
                            this.f64375a.m = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f64368c = file;
        this.f64372g = i2;
        this.f64369d = new File(file, "journal");
        this.f64370e = new File(file, "journal.tmp");
        this.f64371f = new File(file, "journal.bkp");
        this.f64374i = i3;
        this.f64373h = j;
    }

    private synchronized C1899a a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, str, j)) == null) {
            synchronized (this) {
                i();
                d(str);
                b bVar = this.l.get(str);
                if (j == -1 || (bVar != null && bVar.f64387f == j)) {
                    if (bVar == null) {
                        bVar = new b(str);
                        this.l.put(str, bVar);
                    } else if (bVar.f64386e != null) {
                        return null;
                    }
                    C1899a c1899a = new C1899a(bVar);
                    bVar.f64386e = c1899a;
                    Writer writer = this.k;
                    writer.write("DIRTY " + str + '\n');
                    this.k.flush();
                    return c1899a;
                }
                return null;
            }
        }
        return (C1899a) invokeLJ.objValue;
    }

    public static a a(File file, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i3 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            a(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i2, i3, j);
                    if (aVar.f64369d.exists()) {
                        try {
                            aVar.e();
                            aVar.f();
                            return aVar;
                        } catch (IOException e2) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.c();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j);
                    aVar2.g();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C1899a c1899a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, c1899a, z) == null) {
            synchronized (this) {
                b bVar = c1899a.f64377b;
                if (bVar.f64386e != c1899a) {
                    throw new IllegalStateException();
                }
                if (z && !bVar.f64385d) {
                    for (int i2 = 0; i2 < this.f64374i; i2++) {
                        if (!c1899a.f64378c[i2]) {
                            c1899a.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!bVar.b(i2).exists()) {
                            c1899a.b();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < this.f64374i; i3++) {
                    File b2 = bVar.b(i3);
                    if (!z) {
                        a(b2);
                    } else if (b2.exists()) {
                        File a2 = bVar.a(i3);
                        b2.renameTo(a2);
                        long j = bVar.f64384c[i3];
                        long length = a2.length();
                        bVar.f64384c[i3] = length;
                        this.j = (this.j - j) + length;
                    }
                }
                this.m++;
                bVar.f64386e = null;
                if (bVar.f64385d || z) {
                    bVar.f64385d = true;
                    this.k.write("CLEAN " + bVar.f64383b + bVar.a() + '\n');
                    if (z) {
                        long j2 = this.n;
                        this.n = 1 + j2;
                        bVar.f64387f = j2;
                    }
                } else {
                    this.l.remove(bVar.f64383b);
                    this.k.write("REMOVE " + bVar.f64383b + '\n');
                }
                this.k.flush();
                if (this.j > this.f64373h || h()) {
                    this.f64367b.submit(this.o);
                }
            }
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, null, file, file2, z) == null) {
            if (z) {
                a(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    private void c(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new IOException("unexpected journal line: " + str);
            }
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.l.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            b bVar = this.l.get(substring);
            if (bVar == null) {
                bVar = new b(substring);
                this.l.put(substring, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                bVar.f64385d = true;
                bVar.f64386e = null;
                bVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f64386e = new C1899a(bVar);
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, str) == null) || f64366a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65553, this) != null) {
            return;
        }
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.f64369d), c.f64394a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f64372g).equals(a4) || !Integer.toString(this.f64374i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    c(bVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.m = i2 - this.l.size();
                    if (bVar.b()) {
                        g();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f64369d, true), c.f64394a));
                    }
                    c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a(bVar);
            throw th;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            a(this.f64370e);
            Iterator<b> it = this.l.values().iterator();
            while (it.hasNext()) {
                b next = it.next();
                int i2 = 0;
                if (next.f64386e == null) {
                    while (i2 < this.f64374i) {
                        this.j += next.f64384c[i2];
                        i2++;
                    }
                } else {
                    next.f64386e = null;
                    while (i2 < this.f64374i) {
                        a(next.a(i2));
                        a(next.b(i2));
                        i2++;
                    }
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            synchronized (this) {
                if (this.k != null) {
                    this.k.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f64370e), c.f64394a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f64372g));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f64374i));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (b bVar : this.l.values()) {
                    bufferedWriter.write(bVar.f64386e != null ? "DIRTY " + bVar.f64383b + '\n' : "CLEAN " + bVar.f64383b + bVar.a() + '\n');
                }
                bufferedWriter.close();
                if (this.f64369d.exists()) {
                    a(this.f64369d, this.f64371f, true);
                }
                a(this.f64370e, this.f64369d, false);
                this.f64371f.delete();
                this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f64369d, true), c.f64394a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            int i2 = this.m;
            return i2 >= 2000 && i2 >= this.l.size();
        }
        return invokeV.booleanValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            while (this.j > this.f64373h) {
                b(this.l.entrySet().iterator().next().getKey());
            }
        }
    }

    public C1899a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str, -1L) : (C1899a) invokeL.objValue;
    }

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64368c : (File) invokeV.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                i();
                j();
                this.k.flush();
            }
        }
    }

    public synchronized boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                i();
                d(str);
                b bVar = this.l.get(str);
                if (bVar != null && bVar.f64386e == null) {
                    for (int i2 = 0; i2 < this.f64374i; i2++) {
                        File a2 = bVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.j -= bVar.f64384c[i2];
                        bVar.f64384c[i2] = 0;
                    }
                    this.m++;
                    this.k.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.l.remove(str);
                    if (h()) {
                        this.f64367b.submit(this.o);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close();
            c.a(this.f64368c);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (this.k == null) {
                    return;
                }
                Iterator it = new ArrayList(this.l.values()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.f64386e != null) {
                        bVar.f64386e.b();
                    }
                }
                j();
                this.k.close();
                this.k = null;
            }
        }
    }
}
