package com.kwad.sdk.core.diskcache.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import java.io.InputStream;
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
    public static final Pattern a;
    public static final OutputStream p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f57283b;

    /* renamed from: c  reason: collision with root package name */
    public final File f57284c;

    /* renamed from: d  reason: collision with root package name */
    public final File f57285d;

    /* renamed from: e  reason: collision with root package name */
    public final File f57286e;

    /* renamed from: f  reason: collision with root package name */
    public final File f57287f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57288g;

    /* renamed from: h  reason: collision with root package name */
    public long f57289h;

    /* renamed from: i  reason: collision with root package name */
    public final int f57290i;

    /* renamed from: j  reason: collision with root package name */
    public long f57291j;

    /* renamed from: k  reason: collision with root package name */
    public Writer f57292k;
    public final LinkedHashMap<String, b> l;
    public int m;
    public long n;
    public final Callable<Void> o;

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C2013a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public final b f57293b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f57294c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57295d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f57296e;

        /* renamed from: com.kwad.sdk.core.diskcache.kwai.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C2014a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C2013a a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2014a(C2013a c2013a, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2013a, outputStream};
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
                this.a = c2013a;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.a.f57295d = true;
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
                        this.a.f57295d = true;
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
                        this.a.f57295d = true;
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
                        this.a.f57295d = true;
                    }
                }
            }
        }

        public C2013a(a aVar, b bVar) {
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
            this.a = aVar;
            this.f57293b = bVar;
            this.f57294c = bVar.f57299d ? null : new boolean[aVar.f57290i];
        }

        public OutputStream a(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C2014a c2014a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.a.f57290i) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.a.f57290i);
                }
                synchronized (this.a) {
                    if (this.f57293b.f57300e != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f57293b.f57299d) {
                        this.f57294c[i2] = true;
                    }
                    File b2 = this.f57293b.b(i2);
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused) {
                        this.a.f57284c.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused2) {
                            return a.p;
                        }
                    }
                    c2014a = new C2014a(fileOutputStream);
                }
                return c2014a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f57295d) {
                    this.a.a(this, false);
                    this.a.c(this.f57293b.f57297b);
                } else {
                    this.a.a(this, true);
                }
                this.f57296e = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.a(this, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57297b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f57298c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f57299d;

        /* renamed from: e  reason: collision with root package name */
        public C2013a f57300e;

        /* renamed from: f  reason: collision with root package name */
        public long f57301f;

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
            this.a = aVar;
            this.f57297b = str;
            this.f57298c = new long[aVar.f57290i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, strArr) == null) {
                if (strArr.length != this.a.f57290i) {
                    throw b(strArr);
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f57298c[i2] = Long.parseLong(strArr[i2]);
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new File(this.a.f57284c, this.f57297b) : (File) invokeI.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j2 : this.f57298c) {
                    sb.append(' ');
                    sb.append(j2);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public File b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                File file = this.a.f57284c;
                return new File(file, this.f57297b + ".tmp");
            }
            return (File) invokeI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public final class c implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57302b;

        /* renamed from: c  reason: collision with root package name */
        public final long f57303c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f57304d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f57305e;

        public c(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j2), inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f57302b = str;
            this.f57303c = j2;
            this.f57304d = inputStreamArr;
            this.f57305e = jArr;
        }

        public InputStream a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f57304d[i2] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.f57304d) {
                    com.kwad.sdk.core.diskcache.kwai.c.a(inputStream);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(934084470, "Lcom/kwad/sdk/core/diskcache/kwai/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(934084470, "Lcom/kwad/sdk/core/diskcache/kwai/a;");
                return;
            }
        }
        a = Pattern.compile("[a-z0-9_-]{1,120}");
        p = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.kwai.a.2
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

    public a(File file, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57291j = 0L;
        this.l = new LinkedHashMap<>(0, 0.75f, true);
        this.n = 0L;
        this.f57283b = com.kwad.sdk.core.i.b.a();
        this.o = new Callable<Void>(this) { // from class: com.kwad.sdk.core.diskcache.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.a) {
                        if (this.a.f57292k == null) {
                            return null;
                        }
                        this.a.j();
                        if (this.a.h()) {
                            this.a.g();
                            this.a.m = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f57284c = file;
        this.f57288g = i2;
        this.f57285d = new File(file, "journal");
        this.f57286e = new File(file, "journal.tmp");
        this.f57287f = new File(file, "journal.bkp");
        this.f57290i = i3;
        this.f57289h = j2;
    }

    private synchronized C2013a a(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, str, j2)) == null) {
            synchronized (this) {
                i();
                e(str);
                b bVar = this.l.get(str);
                if (j2 == -1 || (bVar != null && bVar.f57301f == j2)) {
                    if (bVar == null) {
                        bVar = new b(str);
                        this.l.put(str, bVar);
                    } else if (bVar.f57300e != null) {
                        return null;
                    }
                    C2013a c2013a = new C2013a(bVar);
                    bVar.f57300e = c2013a;
                    Writer writer = this.f57292k;
                    writer.write("DIRTY " + str + '\n');
                    this.f57292k.flush();
                    return c2013a;
                }
                return null;
            }
        }
        return (C2013a) invokeLJ.objValue;
    }

    public static a a(File file, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            if (j2 > 0) {
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
                    a aVar = new a(file, i2, i3, j2);
                    if (aVar.f57285d.exists()) {
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
                    a aVar2 = new a(file, i2, i3, j2);
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
    public synchronized void a(C2013a c2013a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, this, c2013a, z) == null) {
            synchronized (this) {
                b bVar = c2013a.f57293b;
                if (bVar.f57300e != c2013a) {
                    throw new IllegalStateException();
                }
                if (z && !bVar.f57299d) {
                    for (int i2 = 0; i2 < this.f57290i; i2++) {
                        if (!c2013a.f57294c[i2]) {
                            c2013a.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!bVar.b(i2).exists()) {
                            c2013a.b();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < this.f57290i; i3++) {
                    File b2 = bVar.b(i3);
                    if (!z) {
                        a(b2);
                    } else if (b2.exists()) {
                        File a2 = bVar.a(i3);
                        b2.renameTo(a2);
                        long j2 = bVar.f57298c[i3];
                        long length = a2.length();
                        bVar.f57298c[i3] = length;
                        this.f57291j = (this.f57291j - j2) + length;
                    }
                }
                this.m++;
                bVar.f57300e = null;
                if (bVar.f57299d || z) {
                    bVar.f57299d = true;
                    this.f57292k.write("CLEAN " + bVar.f57297b + bVar.a() + '\n');
                    if (z) {
                        long j3 = this.n;
                        this.n = 1 + j3;
                        bVar.f57301f = j3;
                    }
                } else {
                    this.l.remove(bVar.f57297b);
                    this.f57292k.write("REMOVE " + bVar.f57297b + '\n');
                }
                this.f57292k.flush();
                if (this.f57291j > this.f57289h || h()) {
                    this.f57283b.submit(this.o);
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

    private void d(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
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
                bVar.f57299d = true;
                bVar.f57300e = null;
                bVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f57300e = new C2013a(bVar);
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65552, this) != null) {
            return;
        }
        com.kwad.sdk.core.diskcache.kwai.b bVar = new com.kwad.sdk.core.diskcache.kwai.b(new FileInputStream(this.f57285d), com.kwad.sdk.core.diskcache.kwai.c.a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f57288g).equals(a4) || !Integer.toString(this.f57290i).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.m = i2 - this.l.size();
                    if (bVar.b()) {
                        g();
                    } else {
                        this.f57292k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57285d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
                    }
                    com.kwad.sdk.core.diskcache.kwai.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.diskcache.kwai.c.a(bVar);
            throw th;
        }
    }

    private void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, this, str) == null) || a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            a(this.f57286e);
            Iterator<b> it = this.l.values().iterator();
            while (it.hasNext()) {
                b next = it.next();
                int i2 = 0;
                if (next.f57300e == null) {
                    while (i2 < this.f57290i) {
                        this.f57291j += next.f57298c[i2];
                        i2++;
                    }
                } else {
                    next.f57300e = null;
                    while (i2 < this.f57290i) {
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
                if (this.f57292k != null) {
                    this.f57292k.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57286e), com.kwad.sdk.core.diskcache.kwai.c.a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f57288g));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f57290i));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (b bVar : this.l.values()) {
                    bufferedWriter.write(bVar.f57300e != null ? "DIRTY " + bVar.f57297b + '\n' : "CLEAN " + bVar.f57297b + bVar.a() + '\n');
                }
                bufferedWriter.close();
                if (this.f57285d.exists()) {
                    a(this.f57285d, this.f57287f, true);
                }
                a(this.f57286e, this.f57285d, false);
                this.f57287f.delete();
                this.f57292k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f57285d, true), com.kwad.sdk.core.diskcache.kwai.c.a));
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
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && this.f57292k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            while (this.f57291j > this.f57289h) {
                c(this.l.entrySet().iterator().next().getKey());
            }
        }
    }

    public synchronized c a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                i();
                e(str);
                b bVar = this.l.get(str);
                if (bVar == null) {
                    return null;
                }
                if (bVar.f57299d) {
                    InputStream[] inputStreamArr = new InputStream[this.f57290i];
                    for (int i2 = 0; i2 < this.f57290i; i2++) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(bVar.a(i2));
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.f57290i && inputStreamArr[i3] != null; i3++) {
                                com.kwad.sdk.core.diskcache.kwai.c.a(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.m++;
                    this.f57292k.append((CharSequence) ("READ " + str + '\n'));
                    if (h()) {
                        this.f57283b.submit(this.o);
                    }
                    return new c(str, bVar.f57301f, inputStreamArr, bVar.f57298c);
                }
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57284c : (File) invokeV.objValue;
    }

    public C2013a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(str, -1L) : (C2013a) invokeL.objValue;
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                i();
                j();
                this.f57292k.flush();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close();
            com.kwad.sdk.core.diskcache.kwai.c.a(this.f57284c);
        }
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                i();
                e(str);
                b bVar = this.l.get(str);
                if (bVar != null && bVar.f57300e == null) {
                    for (int i2 = 0; i2 < this.f57290i; i2++) {
                        File a2 = bVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.f57291j -= bVar.f57298c[i2];
                        bVar.f57298c[i2] = 0;
                    }
                    this.m++;
                    this.f57292k.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.l.remove(str);
                    if (h()) {
                        this.f57283b.submit(this.o);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.f57292k == null) {
                    return;
                }
                Iterator it = new ArrayList(this.l.values()).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.f57300e != null) {
                        bVar.f57300e.b();
                    }
                }
                j();
                this.f57292k.close();
                this.f57292k = null;
            }
        }
    }
}
