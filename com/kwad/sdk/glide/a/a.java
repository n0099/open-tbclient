package com.kwad.sdk.glide.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ThreadPoolExecutor f37560a;

    /* renamed from: b  reason: collision with root package name */
    public final File f37561b;

    /* renamed from: c  reason: collision with root package name */
    public final File f37562c;

    /* renamed from: d  reason: collision with root package name */
    public final File f37563d;

    /* renamed from: e  reason: collision with root package name */
    public final File f37564e;

    /* renamed from: f  reason: collision with root package name */
    public final int f37565f;

    /* renamed from: g  reason: collision with root package name */
    public long f37566g;

    /* renamed from: h  reason: collision with root package name */
    public final int f37567h;

    /* renamed from: i  reason: collision with root package name */
    public long f37568i;
    public Writer j;
    public final LinkedHashMap<String, c> k;
    public int l;
    public long m;
    public final Callable<Void> n;

    /* renamed from: com.kwad.sdk.glide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class ThreadFactoryC0453a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ThreadFactoryC0453a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Thread thread;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                synchronized (this) {
                    thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                    thread.setPriority(1);
                }
                return thread;
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f37570a;

        /* renamed from: b  reason: collision with root package name */
        public final c f37571b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean[] f37572c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37573d;

        public b(a aVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37570a = aVar;
            this.f37571b = cVar;
            this.f37572c = cVar.f37579f ? null : new boolean[aVar.f37567h];
        }

        public File a(int i2) {
            InterceptResult invokeI;
            File b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                synchronized (this.f37570a) {
                    if (this.f37571b.f37580g != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f37571b.f37579f) {
                        this.f37572c[i2] = true;
                    }
                    b2 = this.f37571b.b(i2);
                    if (!this.f37570a.f37561b.exists()) {
                        this.f37570a.f37561b.mkdirs();
                    }
                }
                return b2;
            }
            return (File) invokeI.objValue;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f37570a.a(this, true);
                this.f37573d = true;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f37570a.a(this, false);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f37573d) {
                return;
            }
            try {
                b();
            } catch (IOException unused) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File[] f37574a;

        /* renamed from: b  reason: collision with root package name */
        public File[] f37575b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f37576c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37577d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f37578e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37579f;

        /* renamed from: g  reason: collision with root package name */
        public b f37580g;

        /* renamed from: h  reason: collision with root package name */
        public long f37581h;

        public c(a aVar, String str) {
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
            this.f37576c = aVar;
            this.f37577d = str;
            this.f37578e = new long[aVar.f37567h];
            this.f37574a = new File[aVar.f37567h];
            this.f37575b = new File[aVar.f37567h];
            StringBuilder sb = new StringBuilder(str);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i4 = 0; i4 < aVar.f37567h; i4++) {
                sb.append(i4);
                this.f37574a[i4] = new File(aVar.f37561b, sb.toString());
                sb.append(".tmp");
                this.f37575b[i4] = new File(aVar.f37561b, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, strArr) == null) {
                if (strArr.length != this.f37576c.f37567h) {
                    throw b(strArr);
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.f37578e[i2] = Long.parseLong(strArr[i2]);
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
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f37574a[i2] : (File) invokeI.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.f37578e) {
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
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f37575b[i2] : (File) invokeI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f37582a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37583b;

        /* renamed from: c  reason: collision with root package name */
        public final long f37584c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f37585d;

        /* renamed from: e  reason: collision with root package name */
        public final File[] f37586e;

        public d(a aVar, String str, long j, File[] fileArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j), fileArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37582a = aVar;
            this.f37583b = str;
            this.f37584c = j;
            this.f37586e = fileArr;
            this.f37585d = jArr;
        }

        public File a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f37586e[i2] : (File) invokeI.objValue;
        }
    }

    public a(File file, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37568i = 0L;
        this.k = new LinkedHashMap<>(0, 0.75f, true);
        this.m = 0L;
        this.f37560a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0453a());
        this.n = new Callable<Void>(this) { // from class: com.kwad.sdk.glide.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37569a;

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
                this.f37569a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    synchronized (this.f37569a) {
                        if (this.f37569a.j == null) {
                            return null;
                        }
                        this.f37569a.g();
                        if (this.f37569a.e()) {
                            this.f37569a.d();
                            this.f37569a.l = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.f37561b = file;
        this.f37565f = i2;
        this.f37562c = new File(file, "journal");
        this.f37563d = new File(file, "journal.tmp");
        this.f37564e = new File(file, "journal.bkp");
        this.f37567h = i3;
        this.f37566g = j;
    }

    private synchronized b a(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, this, str, j)) == null) {
            synchronized (this) {
                f();
                c cVar = this.k.get(str);
                if (j == -1 || (cVar != null && cVar.f37581h == j)) {
                    if (cVar == null) {
                        cVar = new c(str);
                        this.k.put(str, cVar);
                    } else if (cVar.f37580g != null) {
                        return null;
                    }
                    b bVar = new b(cVar);
                    cVar.f37580g = bVar;
                    this.j.append((CharSequence) "DIRTY");
                    this.j.append(' ');
                    this.j.append((CharSequence) str);
                    this.j.append('\n');
                    b(this.j);
                    return bVar;
                }
                return null;
            }
        }
        return (b) invokeLJ.objValue;
    }

    public static a a(File file, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
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
                    if (aVar.f37562c.exists()) {
                        try {
                            aVar.b();
                            aVar.c();
                            return aVar;
                        } catch (IOException e2) {
                            PrintStream printStream = System.out;
                            printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.a();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j);
                    aVar2.d();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, this, bVar, z) == null) {
            synchronized (this) {
                c cVar = bVar.f37571b;
                if (cVar.f37580g != bVar) {
                    throw new IllegalStateException();
                }
                if (z && !cVar.f37579f) {
                    for (int i2 = 0; i2 < this.f37567h; i2++) {
                        if (!bVar.f37572c[i2]) {
                            bVar.b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!cVar.b(i2).exists()) {
                            bVar.b();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < this.f37567h; i3++) {
                    File b2 = cVar.b(i3);
                    if (!z) {
                        a(b2);
                    } else if (b2.exists()) {
                        File a2 = cVar.a(i3);
                        b2.renameTo(a2);
                        long j = cVar.f37578e[i3];
                        long length = a2.length();
                        cVar.f37578e[i3] = length;
                        this.f37568i = (this.f37568i - j) + length;
                    }
                }
                this.l++;
                cVar.f37580g = null;
                if (cVar.f37579f || z) {
                    cVar.f37579f = true;
                    this.j.append((CharSequence) "CLEAN");
                    this.j.append(' ');
                    this.j.append((CharSequence) cVar.f37577d);
                    this.j.append((CharSequence) cVar.a());
                    this.j.append('\n');
                    if (z) {
                        long j2 = this.m;
                        this.m = 1 + j2;
                        cVar.f37581h = j2;
                    }
                } else {
                    this.k.remove(cVar.f37577d);
                    this.j.append((CharSequence) "REMOVE");
                    this.j.append(' ');
                    this.j.append((CharSequence) cVar.f37577d);
                    this.j.append('\n');
                }
                b(this.j);
                if (this.f37568i > this.f37566g || e()) {
                    this.f37560a.submit(this.n);
                }
            }
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void a(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, file, file2, z) == null) {
            if (z) {
                a(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    @TargetApi(26)
    public static void a(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, writer) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                writer.close();
                return;
            }
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
            try {
                writer.close();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65546, this) != null) {
            return;
        }
        com.kwad.sdk.glide.a.b bVar = new com.kwad.sdk.glide.a.b(new FileInputStream(this.f37562c), com.kwad.sdk.glide.a.c.f37593a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f37565f).equals(a4) || !Integer.toString(this.f37567h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a5 + StringUtil.ARRAY_ELEMENT_SEPARATOR + a6 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i2++;
                } catch (EOFException unused) {
                    this.l = i2 - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f37562c, true), com.kwad.sdk.glide.a.c.f37593a));
                    }
                    com.kwad.sdk.glide.a.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.glide.a.c.a(bVar);
            throw th;
        }
    }

    @TargetApi(26)
    public static void b(Writer writer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, writer) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                writer.flush();
                return;
            }
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
            try {
                writer.flush();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            a(this.f37563d);
            Iterator<c> it = this.k.values().iterator();
            while (it.hasNext()) {
                c next = it.next();
                int i2 = 0;
                if (next.f37580g == null) {
                    while (i2 < this.f37567h) {
                        this.f37568i += next.f37578e[i2];
                        i2++;
                    }
                } else {
                    next.f37580g = null;
                    while (i2 < this.f37567h) {
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
    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            synchronized (this) {
                if (this.j != null) {
                    a(this.j);
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f37563d), com.kwad.sdk.glide.a.c.f37593a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f37565f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f37567h));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (c cVar : this.k.values()) {
                    bufferedWriter.write(cVar.f37580g != null ? "DIRTY " + cVar.f37577d + '\n' : "CLEAN " + cVar.f37577d + cVar.a() + '\n');
                }
                a(bufferedWriter);
                if (this.f37562c.exists()) {
                    a(this.f37562c, this.f37564e, true);
                }
                a(this.f37563d, this.f37562c, false);
                this.f37564e.delete();
                this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f37562c, true), com.kwad.sdk.glide.a.c.f37593a));
            }
        }
    }

    private void d(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new IOException("unexpected journal line: " + str);
            }
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.k.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            c cVar = this.k.get(substring);
            if (cVar == null) {
                cVar = new c(substring);
                this.k.put(substring, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.f37579f = true;
                cVar.f37580g = null;
                cVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f37580g = new b(cVar);
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            int i2 = this.l;
            return i2 >= 2000 && i2 >= this.k.size();
        }
        return invokeV.booleanValue;
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            while (this.f37568i > this.f37566g) {
                c(this.k.entrySet().iterator().next().getKey());
            }
        }
    }

    public synchronized d a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                f();
                c cVar = this.k.get(str);
                if (cVar == null) {
                    return null;
                }
                if (cVar.f37579f) {
                    for (File file : cVar.f37574a) {
                        if (!file.exists()) {
                            return null;
                        }
                    }
                    this.l++;
                    this.j.append((CharSequence) "READ");
                    this.j.append(' ');
                    this.j.append((CharSequence) str);
                    this.j.append('\n');
                    if (e()) {
                        this.f37560a.submit(this.n);
                    }
                    return new d(str, cVar.f37581h, cVar.f37574a, cVar.f37578e);
                }
                return null;
            }
        }
        return (d) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close();
            com.kwad.sdk.glide.a.c.a(this.f37561b);
        }
    }

    public b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? a(str, -1L) : (b) invokeL.objValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                f();
                c cVar = this.k.get(str);
                if (cVar != null && cVar.f37580g == null) {
                    for (int i2 = 0; i2 < this.f37567h; i2++) {
                        File a2 = cVar.a(i2);
                        if (a2.exists() && !a2.delete()) {
                            throw new IOException("failed to delete " + a2);
                        }
                        this.f37568i -= cVar.f37578e[i2];
                        cVar.f37578e[i2] = 0;
                    }
                    this.l++;
                    this.j.append((CharSequence) "REMOVE");
                    this.j.append(' ');
                    this.j.append((CharSequence) str);
                    this.j.append('\n');
                    this.k.remove(str);
                    if (e()) {
                        this.f37560a.submit(this.n);
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
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (this.j == null) {
                    return;
                }
                Iterator it = new ArrayList(this.k.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.f37580g != null) {
                        cVar.f37580g.b();
                    }
                }
                g();
                a(this.j);
                this.j = null;
            }
        }
    }
}
