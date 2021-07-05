package com.kwad.sdk.core.diskcache.a;

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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f35958a;
    public static final OutputStream p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadPoolExecutor f35959b;

    /* renamed from: c  reason: collision with root package name */
    public final File f35960c;

    /* renamed from: d  reason: collision with root package name */
    public final File f35961d;

    /* renamed from: e  reason: collision with root package name */
    public final File f35962e;

    /* renamed from: f  reason: collision with root package name */
    public final File f35963f;

    /* renamed from: g  reason: collision with root package name */
    public final int f35964g;

    /* renamed from: h  reason: collision with root package name */
    public long f35965h;

    /* renamed from: i  reason: collision with root package name */
    public final int f35966i;
    public long j;
    public Writer k;
    public final LinkedHashMap<String, b> l;
    public int m;
    public long n;
    public final Callable<Void> o;

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public final class C0424a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35968a;

        /* renamed from: b  reason: collision with root package name */
        public final b f35969b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f35970c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35971d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f35972e;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0425a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0424a f35973a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0425a(C0424a c0424a, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0424a, outputStream};
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
                this.f35973a = c0424a;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f35973a.f35971d = true;
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
                        this.f35973a.f35971d = true;
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
                        this.f35973a.f35971d = true;
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
                        this.f35973a.f35971d = true;
                    }
                }
            }
        }

        public C0424a(a aVar, b bVar) {
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
            this.f35968a = aVar;
            this.f35969b = bVar;
            this.f35970c = bVar.f35977d ? null : new boolean[aVar.f35966i];
        }

        public OutputStream a(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C0425a c0425a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f35968a.f35966i) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f35968a.f35966i);
                }
                synchronized (this.f35968a) {
                    if (this.f35969b.f35978e != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f35969b.f35977d) {
                        this.f35970c[i2] = true;
                    }
                    File b2 = this.f35969b.b(i2);
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused) {
                        this.f35968a.f35960c.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused2) {
                            return a.p;
                        }
                    }
                    c0425a = new C0425a(fileOutputStream);
                }
                return c0425a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f35971d) {
                    this.f35968a.a(this, false);
                    this.f35968a.b(this.f35969b.f35975b);
                } else {
                    this.f35968a.a(this, true);
                }
                this.f35972e = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f35968a.a(this, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f35974a;

        /* renamed from: b  reason: collision with root package name */
        public final String f35975b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f35976c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35977d;

        /* renamed from: e  reason: collision with root package name */
        public C0424a f35978e;

        /* renamed from: f  reason: collision with root package name */
        public long f35979f;

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
            this.f35974a = aVar;
            this.f35975b = str;
            this.f35976c = new long[aVar.f35966i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) {
                if (strArr.length != this.f35974a.f35966i) {
                    throw b(strArr);
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f35976c[i2] = Long.parseLong(strArr[i2]);
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new File(this.f35974a.f35960c, this.f35975b) : (File) invokeI.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.f35976c) {
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
                File file = this.f35974a.f35960c;
                return new File(file, this.f35975b + ".tmp");
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
        f35958a = Pattern.compile("[a-z0-9_-]{1,120}");
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
        this.f35959b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.o = new Callable<Void>(this) { // from class: com.kwad.sdk.core.diskcache.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35967a;

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
                this.f35967a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.f35967a) {
                        if (this.f35967a.k == null) {
                            return null;
                        }
                        this.f35967a.j();
                        if (this.f35967a.h()) {
                            this.f35967a.g();
                            this.f35967a.m = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f35960c = file;
        this.f35964g = i2;
        this.f35961d = new File(file, "journal");
        this.f35962e = new File(file, "journal.tmp");
        this.f35963f = new File(file, "journal.bkp");
        this.f35966i = i3;
        this.f35965h = j;
    }

    private synchronized C0424a a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, str, j)) == null) {
            synchronized (this) {
                i();
                d(str);
                b bVar = this.l.get(str);
                if (j == -1 || (bVar != null && bVar.f35979f == j)) {
                    if (bVar == null) {
                        bVar = new b(str);
                        this.l.put(str, bVar);
                    } else if (bVar.f35978e != null) {
                        return null;
                    }
                    C0424a c0424a = new C0424a(bVar);
                    bVar.f35978e = c0424a;
                    Writer writer = this.k;
                    writer.write("DIRTY " + str + '\n');
                    this.k.flush();
                    return c0424a;
                }
                return null;
            }
        }
        return (C0424a) invokeLJ.objValue;
    }

    public static a a(File file, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
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
                    if (aVar.f35961d.exists()) {
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
    public synchronized void a(C0424a c0424a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, c0424a, z) == null) {
            synchronized (this) {
                b bVar = c0424a.f35969b;
                if (bVar.f35978e != c0424a) {
                    throw new IllegalStateException();
                }
                if (z && !bVar.f35977d) {
                    for (int i2 = 0; i2 < this.f35966i; i2++) {
                        if (!c0424a.f35970c[i2]) {
                            c0424a.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!bVar.b(i2).exists()) {
                            c0424a.b();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < this.f35966i; i3++) {
                    File b2 = bVar.b(i3);
                    if (!z) {
                        a(b2);
                    } else if (b2.exists()) {
                        File a2 = bVar.a(i3);
                        b2.renameTo(a2);
                        long j = bVar.f35976c[i3];
                        long length = a2.length();
                        bVar.f35976c[i3] = length;
                        this.j = (this.j - j) + length;
                    }
                }
                this.m++;
                bVar.f35978e = null;
                if (bVar.f35977d || z) {
                    bVar.f35977d = true;
                    this.k.write("CLEAN " + bVar.f35975b + bVar.a() + '\n');
                    if (z) {
                        long j2 = this.n;
                        this.n = 1 + j2;
                        bVar.f35979f = j2;
                    }
                } else {
                    this.l.remove(bVar.f35975b);
                    this.k.write("REMOVE " + bVar.f35975b + '\n');
                }
                this.k.flush();
                if (this.j > this.f35965h || h()) {
                    this.f35959b.submit(this.o);
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
                bVar.f35977d = true;
                bVar.f35978e = null;
                bVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f35978e = new C0424a(bVar);
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, str) == null) || f35958a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65553, this) != null) {
            return;
        }
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.f35961d), c.f35986a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f35964g).equals(a4) || !Integer.toString(this.f35966i).equals(a5) || !"".equals(a6)) {
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
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35961d, true), c.f35986a));
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
            a(this.f35962e);
            Iterator<b> it = this.l.values().iterator();
            while (it.hasNext()) {
                b next = it.next();
                int i2 = 0;
                if (next.f35978e == null) {
                    while (i2 < this.f35966i) {
                        this.j += next.f35976c[i2];
                        i2++;
                    }
                } else {
                    next.f35978e = null;
                    while (i2 < this.f35966i) {
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
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35962e), c.f35986a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f35964g));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f35966i));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (b bVar : this.l.values()) {
                    bufferedWriter.write(bVar.f35978e != null ? "DIRTY " + bVar.f35975b + '\n' : "CLEAN " + bVar.f35975b + bVar.a() + '\n');
                }
                bufferedWriter.close();
                if (this.f35961d.exists()) {
                    a(this.f35961d, this.f35963f, true);
                }
                a(this.f35962e, this.f35961d, false);
                this.f35963f.delete();
                this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f35961d, true), c.f35986a));
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
            while (this.j > this.f35965h) {
                b(this.l.entrySet().iterator().next().getKey());
            }
        }
    }

    public C0424a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str, -1L) : (C0424a) invokeL.objValue;
    }

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35960c : (File) invokeV.objValue;
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
                if (bVar != null && bVar.f35978e == null) {
                    for (int i2 = 0; i2 < this.f35966i; i2++) {
                        File a2 = bVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.j -= bVar.f35976c[i2];
                        bVar.f35976c[i2] = 0;
                    }
                    this.m++;
                    this.k.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.l.remove(str);
                    if (h()) {
                        this.f35959b.submit(this.o);
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
            c.a(this.f35960c);
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
                    if (bVar.f35978e != null) {
                        bVar.f35978e.b();
                    }
                }
                j();
                this.k.close();
                this.k = null;
            }
        }
    }
}
