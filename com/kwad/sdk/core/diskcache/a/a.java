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
/* loaded from: classes10.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f71361a;
    public static final OutputStream p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f71362b;

    /* renamed from: c  reason: collision with root package name */
    public final File f71363c;

    /* renamed from: d  reason: collision with root package name */
    public final File f71364d;

    /* renamed from: e  reason: collision with root package name */
    public final File f71365e;

    /* renamed from: f  reason: collision with root package name */
    public final File f71366f;

    /* renamed from: g  reason: collision with root package name */
    public final int f71367g;

    /* renamed from: h  reason: collision with root package name */
    public long f71368h;

    /* renamed from: i  reason: collision with root package name */
    public final int f71369i;

    /* renamed from: j  reason: collision with root package name */
    public long f71370j;
    public Writer k;
    public final LinkedHashMap<String, b> l;
    public int m;
    public long n;
    public final Callable<Void> o;

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public final class C1984a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f71372a;

        /* renamed from: b  reason: collision with root package name */
        public final b f71373b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f71374c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71375d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f71376e;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C1985a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C1984a f71377a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1985a(C1984a c1984a, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1984a, outputStream};
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
                this.f71377a = c1984a;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f71377a.f71375d = true;
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
                        this.f71377a.f71375d = true;
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
                        this.f71377a.f71375d = true;
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
                        this.f71377a.f71375d = true;
                    }
                }
            }
        }

        public C1984a(a aVar, b bVar) {
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
            this.f71372a = aVar;
            this.f71373b = bVar;
            this.f71374c = bVar.f71381d ? null : new boolean[aVar.f71369i];
        }

        public OutputStream a(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C1985a c1985a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f71372a.f71369i) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f71372a.f71369i);
                }
                synchronized (this.f71372a) {
                    if (this.f71373b.f71382e != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f71373b.f71381d) {
                        this.f71374c[i2] = true;
                    }
                    File b2 = this.f71373b.b(i2);
                    try {
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException unused) {
                        this.f71372a.f71363c.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(b2);
                        } catch (FileNotFoundException unused2) {
                            return a.p;
                        }
                    }
                    c1985a = new C1985a(fileOutputStream);
                }
                return c1985a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f71375d) {
                    this.f71372a.a(this, false);
                    this.f71372a.b(this.f71373b.f71379b);
                } else {
                    this.f71372a.a(this, true);
                }
                this.f71376e = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f71372a.a(this, false);
            }
        }
    }

    /* loaded from: classes10.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f71378a;

        /* renamed from: b  reason: collision with root package name */
        public final String f71379b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f71380c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f71381d;

        /* renamed from: e  reason: collision with root package name */
        public C1984a f71382e;

        /* renamed from: f  reason: collision with root package name */
        public long f71383f;

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
            this.f71378a = aVar;
            this.f71379b = str;
            this.f71380c = new long[aVar.f71369i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) {
                if (strArr.length != this.f71378a.f71369i) {
                    throw b(strArr);
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f71380c[i2] = Long.parseLong(strArr[i2]);
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? new File(this.f71378a.f71363c, this.f71379b) : (File) invokeI.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j2 : this.f71380c) {
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
                File file = this.f71378a.f71363c;
                return new File(file, this.f71379b + ".tmp");
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
        f71361a = Pattern.compile("[a-z0-9_-]{1,120}");
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
        this.f71370j = 0L;
        this.l = new LinkedHashMap<>(0, 0.75f, true);
        this.n = 0L;
        this.f71362b = com.kwad.sdk.core.i.b.a();
        this.o = new Callable<Void>(this) { // from class: com.kwad.sdk.core.diskcache.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f71371a;

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
                this.f71371a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.f71371a) {
                        if (this.f71371a.k == null) {
                            return null;
                        }
                        this.f71371a.j();
                        if (this.f71371a.h()) {
                            this.f71371a.g();
                            this.f71371a.m = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f71363c = file;
        this.f71367g = i2;
        this.f71364d = new File(file, "journal");
        this.f71365e = new File(file, "journal.tmp");
        this.f71366f = new File(file, "journal.bkp");
        this.f71369i = i3;
        this.f71368h = j2;
    }

    private synchronized C1984a a(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, str, j2)) == null) {
            synchronized (this) {
                i();
                d(str);
                b bVar = this.l.get(str);
                if (j2 == -1 || (bVar != null && bVar.f71383f == j2)) {
                    if (bVar == null) {
                        bVar = new b(str);
                        this.l.put(str, bVar);
                    } else if (bVar.f71382e != null) {
                        return null;
                    }
                    C1984a c1984a = new C1984a(bVar);
                    bVar.f71382e = c1984a;
                    Writer writer = this.k;
                    writer.write("DIRTY " + str + '\n');
                    this.k.flush();
                    return c1984a;
                }
                return null;
            }
        }
        return (C1984a) invokeLJ.objValue;
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
                    if (aVar.f71364d.exists()) {
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
    public synchronized void a(C1984a c1984a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, this, c1984a, z) == null) {
            synchronized (this) {
                b bVar = c1984a.f71373b;
                if (bVar.f71382e != c1984a) {
                    throw new IllegalStateException();
                }
                if (z && !bVar.f71381d) {
                    for (int i2 = 0; i2 < this.f71369i; i2++) {
                        if (!c1984a.f71374c[i2]) {
                            c1984a.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!bVar.b(i2).exists()) {
                            c1984a.b();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < this.f71369i; i3++) {
                    File b2 = bVar.b(i3);
                    if (!z) {
                        a(b2);
                    } else if (b2.exists()) {
                        File a2 = bVar.a(i3);
                        b2.renameTo(a2);
                        long j2 = bVar.f71380c[i3];
                        long length = a2.length();
                        bVar.f71380c[i3] = length;
                        this.f71370j = (this.f71370j - j2) + length;
                    }
                }
                this.m++;
                bVar.f71382e = null;
                if (bVar.f71381d || z) {
                    bVar.f71381d = true;
                    this.k.write("CLEAN " + bVar.f71379b + bVar.a() + '\n');
                    if (z) {
                        long j3 = this.n;
                        this.n = 1 + j3;
                        bVar.f71383f = j3;
                    }
                } else {
                    this.l.remove(bVar.f71379b);
                    this.k.write("REMOVE " + bVar.f71379b + '\n');
                }
                this.k.flush();
                if (this.f71370j > this.f71368h || h()) {
                    this.f71362b.submit(this.o);
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
                bVar.f71381d = true;
                bVar.f71382e = null;
                bVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f71382e = new C1984a(bVar);
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, str) == null) || f71361a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65553, this) != null) {
            return;
        }
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.f71364d), c.f71390a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f71367g).equals(a4) || !Integer.toString(this.f71369i).equals(a5) || !"".equals(a6)) {
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
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f71364d, true), c.f71390a));
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
            a(this.f71365e);
            Iterator<b> it = this.l.values().iterator();
            while (it.hasNext()) {
                b next = it.next();
                int i2 = 0;
                if (next.f71382e == null) {
                    while (i2 < this.f71369i) {
                        this.f71370j += next.f71380c[i2];
                        i2++;
                    }
                } else {
                    next.f71382e = null;
                    while (i2 < this.f71369i) {
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
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f71365e), c.f71390a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f71367g));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f71369i));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (b bVar : this.l.values()) {
                    bufferedWriter.write(bVar.f71382e != null ? "DIRTY " + bVar.f71379b + '\n' : "CLEAN " + bVar.f71379b + bVar.a() + '\n');
                }
                bufferedWriter.close();
                if (this.f71364d.exists()) {
                    a(this.f71364d, this.f71366f, true);
                }
                a(this.f71365e, this.f71364d, false);
                this.f71366f.delete();
                this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f71364d, true), c.f71390a));
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
            while (this.f71370j > this.f71368h) {
                b(this.l.entrySet().iterator().next().getKey());
            }
        }
    }

    public C1984a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? a(str, -1L) : (C1984a) invokeL.objValue;
    }

    public File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71363c : (File) invokeV.objValue;
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
                if (bVar != null && bVar.f71382e == null) {
                    for (int i2 = 0; i2 < this.f71369i; i2++) {
                        File a2 = bVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.f71370j -= bVar.f71380c[i2];
                        bVar.f71380c[i2] = 0;
                    }
                    this.m++;
                    this.k.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.l.remove(str);
                    if (h()) {
                        this.f71362b.submit(this.o);
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
            c.a(this.f71363c);
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
                    if (bVar.f71382e != null) {
                        bVar.f71382e.b();
                    }
                }
                j();
                this.k.close();
                this.k = null;
            }
        }
    }
}
