package com.repackage;

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
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
public final class z81 implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern o;
    public static final OutputStream p;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final int e;
    public long f;
    public final int g;
    public long h;
    public Writer i;
    public final LinkedHashMap<String, d> j;
    public int k;
    public long l;
    public final ThreadPoolExecutor m;
    public final Callable<Void> n;

    /* loaded from: classes7.dex */
    public class a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z81 a;

        public a(z81 z81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z81Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.a) {
                    if (this.a.i == null) {
                        return null;
                    }
                    this.a.A();
                    if (this.a.s()) {
                        this.a.x();
                        this.a.k = 0;
                    }
                    return null;
                }
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends OutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d a;
        public final boolean[] b;
        public boolean c;
        public final /* synthetic */ z81 d;

        /* loaded from: classes7.dex */
        public class a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public /* synthetic */ a(c cVar, OutputStream outputStream, a aVar) {
                this(cVar, outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.a.c = true;
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
                        this.a.c = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(i);
                    } catch (IOException unused) {
                        this.a.c = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, outputStream};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((OutputStream) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i, i2);
                    } catch (IOException unused) {
                        this.a.c = true;
                    }
                }
            }
        }

        public /* synthetic */ c(z81 z81Var, d dVar, a aVar) {
            this(z81Var, dVar);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.k(this, false);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.c) {
                    this.d.k(this, false);
                    this.d.y(this.a.a);
                    return;
                }
                this.d.k(this, true);
            }
        }

        public OutputStream f(int i) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < 0 || i >= this.d.g) {
                    throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + this.d.g);
                }
                synchronized (this.d) {
                    if (this.a.d == this) {
                        if (!this.a.c) {
                            this.b[i] = true;
                        }
                        File k = this.a.k(i);
                        try {
                            fileOutputStream = new FileOutputStream(k);
                        } catch (FileNotFoundException unused) {
                            this.d.a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(k);
                            } catch (FileNotFoundException unused2) {
                                return z81.p;
                            }
                        }
                        aVar = new a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return aVar;
            }
            return (OutputStream) invokeI.objValue;
        }

        public c(z81 z81Var, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z81Var, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z81Var;
            this.a = dVar;
            this.b = dVar.c ? null : new boolean[z81Var.g];
        }
    }

    /* loaded from: classes7.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final long[] b;
        public boolean c;
        public c d;
        public long e;
        public final /* synthetic */ z81 f;

        public /* synthetic */ d(z81 z81Var, String str, a aVar) {
            this(z81Var, str);
        }

        public File j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                File file = this.f.a;
                return new File(file, this.a + "." + i);
            }
            return (File) invokeI.objValue;
        }

        public File k(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                File file = this.f.a;
                return new File(file, this.a + "." + i + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String l() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.b) {
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final IOException m(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        public final void n(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
                if (strArr.length == this.f.g) {
                    for (int i = 0; i < strArr.length; i++) {
                        try {
                            this.b[i] = Long.parseLong(strArr[i]);
                        } catch (NumberFormatException unused) {
                            m(strArr);
                            throw null;
                        }
                    }
                    return;
                }
                m(strArr);
                throw null;
            }
        }

        public d(z81 z81Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z81Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = z81Var;
            this.a = str;
            this.b = new long[z81Var.g];
        }
    }

    /* loaded from: classes7.dex */
    public final class e implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final InputStream[] a;
        public final /* synthetic */ z81 b;

        public /* synthetic */ e(z81 z81Var, String str, long j, InputStream[] inputStreamArr, long[] jArr, a aVar) {
            this(z81Var, str, j, inputStreamArr, jArr);
        }

        public InputStream a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.a[i] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.a) {
                    b91.a(inputStream);
                }
            }
        }

        public e(z81 z81Var, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z81Var, str, Long.valueOf(j), inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = z81Var;
            this.a = inputStreamArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755158242, "Lcom/repackage/z81;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755158242, "Lcom/repackage/z81;");
                return;
            }
        }
        o = Pattern.compile("[a-z0-9_-]{1,120}");
        p = new b();
    }

    public z81(File file, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = 0L;
        this.j = new LinkedHashMap<>(0, 0.75f, true);
        this.l = 0L;
        this.m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.n = new a(this);
        this.a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    public static void l(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static z81 t(File file, int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i2 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            z(file2, file3, false);
                        }
                    }
                    z81 z81Var = new z81(file, i, i2, j);
                    if (z81Var.b.exists()) {
                        try {
                            z81Var.v();
                            z81Var.u();
                            return z81Var;
                        } catch (IOException e2) {
                            w91.d("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            z81Var.delete();
                        }
                    }
                    file.mkdirs();
                    z81 z81Var2 = new z81(file, i, i2, j);
                    z81Var2.x();
                    return z81Var2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (z81) invokeCommon.objValue;
    }

    public static void z(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65549, null, file, file2, z) == null) {
            if (z) {
                l(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            while (this.h > this.f) {
                y(this.j.entrySet().iterator().next().getKey());
            }
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.i == null) {
                    return;
                }
                Iterator it = new ArrayList(this.j.values()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.d != null) {
                        dVar.d.a();
                    }
                }
                A();
                this.i.close();
                this.i = null;
            }
        }
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            close();
            b91.b(this.a);
        }
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                j();
                A();
                this.i.flush();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void k(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, cVar, z) == null) {
            synchronized (this) {
                d dVar = cVar.a;
                if (dVar.d == cVar) {
                    if (z && !dVar.c) {
                        for (int i = 0; i < this.g; i++) {
                            if (cVar.b[i]) {
                                if (!dVar.k(i).exists()) {
                                    cVar.a();
                                    return;
                                }
                            } else {
                                cVar.a();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < this.g; i2++) {
                        File k = dVar.k(i2);
                        if (z) {
                            if (k.exists()) {
                                File j = dVar.j(i2);
                                k.renameTo(j);
                                long j2 = dVar.b[i2];
                                long length = j.length();
                                dVar.b[i2] = length;
                                this.h = (this.h - j2) + length;
                            }
                        } else {
                            l(k);
                        }
                    }
                    this.k++;
                    dVar.d = null;
                    if (!dVar.c && !z) {
                        this.j.remove(dVar.a);
                        this.i.write("REMOVE " + dVar.a + '\n');
                        this.i.flush();
                        if (this.h <= this.f || s()) {
                            this.m.submit(this.n);
                        }
                        return;
                    }
                    dVar.c = true;
                    this.i.write("CLEAN " + dVar.a + dVar.l() + '\n');
                    if (z) {
                        long j3 = this.l;
                        this.l = 1 + j3;
                        dVar.e = j3;
                    }
                    this.i.flush();
                    if (this.h <= this.f) {
                    }
                    this.m.submit(this.n);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public c p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? q(str, -1L) : (c) invokeL.objValue;
    }

    public final synchronized c q(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j)) == null) {
            synchronized (this) {
                j();
                B(str);
                d dVar = this.j.get(str);
                if (j == -1 || (dVar != null && dVar.e == j)) {
                    if (dVar != null) {
                        if (dVar.d != null) {
                            return null;
                        }
                    } else {
                        dVar = new d(this, str, null);
                        this.j.put(str, dVar);
                    }
                    c cVar = new c(this, dVar, null);
                    dVar.d = cVar;
                    Writer writer = this.i;
                    writer.write("DIRTY " + str + '\n');
                    this.i.flush();
                    return cVar;
                }
                return null;
            }
        }
        return (c) invokeLJ.objValue;
    }

    public synchronized e r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            synchronized (this) {
                j();
                B(str);
                d dVar = this.j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (dVar.c) {
                    InputStream[] inputStreamArr = new InputStream[this.g];
                    for (int i = 0; i < this.g; i++) {
                        try {
                            inputStreamArr[i] = new FileInputStream(dVar.j(i));
                        } catch (FileNotFoundException unused) {
                            for (int i2 = 0; i2 < this.g && inputStreamArr[i2] != null; i2++) {
                                b91.a(inputStreamArr[i2]);
                            }
                            return null;
                        }
                    }
                    this.k++;
                    this.i.append((CharSequence) ("READ " + str + '\n'));
                    if (s()) {
                        this.m.submit(this.n);
                    }
                    return new e(this, str, dVar.e, inputStreamArr, dVar.b, null);
                }
                return null;
            }
        }
        return (e) invokeL.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.k;
            return i >= 2000 && i >= this.j.size();
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            l(this.c);
            Iterator<d> it = this.j.values().iterator();
            while (it.hasNext()) {
                d next = it.next();
                int i = 0;
                if (next.d != null) {
                    next.d = null;
                    while (i < this.g) {
                        l(next.j(i));
                        l(next.k(i));
                        i++;
                    }
                    it.remove();
                } else {
                    while (i < this.g) {
                        this.h += next.b[i];
                        i++;
                    }
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048588, this) != null) {
            return;
        }
        a91 a91Var = new a91(new FileInputStream(this.b), b91.a);
        try {
            String f = a91Var.f();
            String f2 = a91Var.f();
            String f3 = a91Var.f();
            String f4 = a91Var.f();
            String f5 = a91Var.f();
            if (!"libcore.io.DiskLruCache".equals(f) || !"1".equals(f2) || !Integer.toString(this.e).equals(f3) || !Integer.toString(this.g).equals(f4) || !"".equals(f5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(f);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(f2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(f4);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(f5);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                throw new IOException(sb.toString());
            }
            int i = 0;
            while (true) {
                try {
                    w(a91Var.f());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (a91Var.e()) {
                        x();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), b91.a));
                    }
                    b91.a(a91Var);
                    return;
                }
            }
        } catch (Throwable th) {
            b91.a(a91Var);
            throw th;
        }
    }

    public final void w(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(32, i);
                if (indexOf2 == -1) {
                    substring = str.substring(i);
                    if (indexOf == 6 && str.startsWith("REMOVE")) {
                        this.j.remove(substring);
                        return;
                    }
                } else {
                    substring = str.substring(i, indexOf2);
                }
                d dVar = this.j.get(substring);
                if (dVar == null) {
                    dVar = new d(this, substring, null);
                    this.j.put(substring, dVar);
                }
                if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                    String[] split = str.substring(indexOf2 + 1).split(" ");
                    dVar.c = true;
                    dVar.d = null;
                    dVar.n(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    dVar.d = new c(this, dVar, null);
                    return;
                } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                    return;
                } else {
                    throw new IOException("unexpected journal line: " + str);
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public final synchronized void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                Writer writer = this.i;
                if (writer != null) {
                    writer.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), b91.a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.j.values()) {
                    if (dVar.d != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(dVar.a);
                        sb.append('\n');
                        bufferedWriter.write(sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(dVar.a);
                        sb2.append(dVar.l());
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    }
                }
                bufferedWriter.close();
                if (this.b.exists()) {
                    z(this.b, this.d, true);
                }
                z(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), b91.a));
            }
        }
    }

    public synchronized boolean y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                j();
                B(str);
                d dVar = this.j.get(str);
                if (dVar != null && dVar.d == null) {
                    for (int i = 0; i < this.g; i++) {
                        File j = dVar.j(i);
                        if (j.exists() && !j.delete()) {
                            throw new IOException("failed to delete " + j);
                        }
                        this.h -= dVar.b[i];
                        dVar.b[i] = 0;
                    }
                    this.k++;
                    this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.j.remove(str);
                    if (s()) {
                        this.m.submit(this.n);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
