package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

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
import java.io.InputStreamReader;
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
public final class DiskLruCache implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final Pattern LEGAL_KEY_PATTERN;
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final OutputStream NULL_OUTPUT_STREAM;
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final String VERSION_1 = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public final int appVersion;
    public final Callable<Void> cleanupCallable;
    public final File directory;
    public final ThreadPoolExecutor executorService;
    public int fileCount;
    public final File journalFile;
    public final File journalFileBackup;
    public final File journalFileTmp;
    public Writer journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries;
    public int maxFileCount;
    public long maxSize;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public final int valueCount;

    /* loaded from: classes7.dex */
    public final class Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean committed;
        public final Entry entry;
        public boolean hasErrors;
        public final /* synthetic */ DiskLruCache this$0;
        public final boolean[] written;

        /* loaded from: classes7.dex */
        public class FaultHidingOutputStream extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Editor this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FaultHidingOutputStream(Editor editor, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {editor, outputStream};
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
                this.this$1 = editor;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.this$1.hasErrors = true;
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
                        this.this$1.hasErrors = true;
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
                        this.this$1.hasErrors = true;
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
                        this.this$1.hasErrors = true;
                    }
                }
            }
        }

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[diskLruCache.valueCount];
        }

        public void abort() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.completeEdit(this, false);
            }
        }

        public void abortUnlessCommitted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.committed) {
                return;
            }
            try {
                abort();
            } catch (IOException unused) {
            }
        }

        public void commit() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.hasErrors) {
                    this.this$0.completeEdit(this, false);
                    this.this$0.remove(this.entry.key);
                } else {
                    this.this$0.completeEdit(this, true);
                }
                this.committed = true;
            }
        }

        public String getString(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                InputStream newInputStream = newInputStream(i2);
                if (newInputStream != null) {
                    return DiskLruCache.inputStreamToString(newInputStream);
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        public InputStream newInputStream(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                synchronized (this.this$0) {
                    if (this.entry.currentEditor == this) {
                        if (this.entry.readable) {
                            try {
                                return new FileInputStream(this.entry.getCleanFile(i2));
                            } catch (FileNotFoundException unused) {
                                return null;
                            }
                        }
                        return null;
                    }
                    throw new IllegalStateException();
                }
            }
            return (InputStream) invokeI.objValue;
        }

        public OutputStream newOutputStream(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            FaultHidingOutputStream faultHidingOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                synchronized (this.this$0) {
                    if (this.entry.currentEditor != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.entry.readable) {
                        this.written[i2] = true;
                    }
                    File dirtyFile = this.entry.getDirtyFile(i2);
                    try {
                        fileOutputStream = new FileOutputStream(dirtyFile);
                    } catch (FileNotFoundException unused) {
                        this.this$0.directory.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(dirtyFile);
                        } catch (FileNotFoundException unused2) {
                            return DiskLruCache.NULL_OUTPUT_STREAM;
                        }
                    }
                    faultHidingOutputStream = new FaultHidingOutputStream(fileOutputStream);
                }
                return faultHidingOutputStream;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void set(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(1048582, this, i2, str) != null) {
                return;
            }
            OutputStreamWriter outputStreamWriter = null;
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(newOutputStream(i2), Util.UTF_8);
                try {
                    outputStreamWriter2.write(str);
                    Util.closeQuietly(outputStreamWriter2);
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    Util.closeQuietly(outputStreamWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Editor currentEditor;
        public final String key;
        public final long[] lengths;
        public boolean readable;
        public long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;

        public Entry(DiskLruCache diskLruCache, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.valueCount];
        }

        private IOException invalidLengths(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLengths(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65548, this, strArr) == null) {
                if (strArr.length != this.this$0.valueCount) {
                    throw invalidLengths(strArr);
                }
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    try {
                        this.lengths[i2] = Long.parseLong(strArr[i2]);
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
            }
        }

        public File getCleanFile(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                File file = this.this$0.directory;
                return new File(file, this.key + "." + i2);
            }
            return (File) invokeI.objValue;
        }

        public File getDirtyFile(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                File file = this.this$0.directory;
                return new File(file, this.key + "." + i2 + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String getLengths() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.lengths) {
                    sb.append(' ');
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class Snapshot implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File[] files;
        public final InputStream[] ins;
        public final String key;
        public final long[] lengths;
        public final long sequenceNumber;
        public final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str, Long.valueOf(j), fileArr, inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.files = fileArr;
            this.ins = inputStreamArr;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (InputStream inputStream : this.ins) {
                    Util.closeQuietly(inputStream);
                }
            }
        }

        public Editor edit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.this$0.edit(this.key, this.sequenceNumber) : (Editor) invokeV.objValue;
        }

        public File getFile(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.files[i2] : (File) invokeI.objValue;
        }

        public InputStream getInputStream(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.ins[i2] : (InputStream) invokeI.objValue;
        }

        public long getLength(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.lengths[i2] : invokeI.longValue;
        }

        public String getString(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? DiskLruCache.inputStreamToString(getInputStream(i2)) : (String) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-648033691, "Lcom/kwad/sdk/core/imageloader/cache/disc/impl/ext/DiskLruCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-648033691, "Lcom/kwad/sdk/core/imageloader/cache/disc/impl/ext/DiskLruCache;");
                return;
            }
        }
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,64}");
        NULL_OUTPUT_STREAM = new OutputStream() { // from class: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.2
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

    public DiskLruCache(File file, int i2, int i3, long j, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.size = 0L;
        this.fileCount = 0;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.cleanupCallable = new Callable<Void>(this) { // from class: com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DiskLruCache this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i7 = newInitContext2.flag;
                    if ((i7 & 1) != 0) {
                        int i8 = i7 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.concurrent.Callable
            public Void call() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    synchronized (this.this$0) {
                        if (this.this$0.journalWriter == null) {
                            return null;
                        }
                        this.this$0.trimToSize();
                        this.this$0.trimToFileCount();
                        if (this.this$0.journalRebuildRequired()) {
                            this.this$0.rebuildJournal();
                            this.this$0.redundantOpCount = 0;
                        }
                        return null;
                    }
                }
                return (Void) invokeV.objValue;
            }
        };
        this.directory = file;
        this.appVersion = i2;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i3;
        this.maxSize = j;
        this.maxFileCount = i4;
    }

    private void checkNotClosed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, this) == null) && this.journalWriter == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void completeEdit(Editor editor, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65551, this, editor, z) == null) {
            synchronized (this) {
                Entry entry = editor.entry;
                if (entry.currentEditor != editor) {
                    throw new IllegalStateException();
                }
                if (z && !entry.readable) {
                    for (int i2 = 0; i2 < this.valueCount; i2++) {
                        if (!editor.written[i2]) {
                            editor.abort();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!entry.getDirtyFile(i2).exists()) {
                            editor.abort();
                            return;
                        }
                    }
                }
                for (int i3 = 0; i3 < this.valueCount; i3++) {
                    File dirtyFile = entry.getDirtyFile(i3);
                    if (!z) {
                        deleteIfExists(dirtyFile);
                    } else if (dirtyFile.exists()) {
                        File cleanFile = entry.getCleanFile(i3);
                        dirtyFile.renameTo(cleanFile);
                        long j = entry.lengths[i3];
                        long length = cleanFile.length();
                        entry.lengths[i3] = length;
                        this.size = (this.size - j) + length;
                        this.fileCount++;
                    }
                }
                this.redundantOpCount++;
                entry.currentEditor = null;
                if (entry.readable || z) {
                    entry.readable = true;
                    this.journalWriter.write("CLEAN " + entry.key + entry.getLengths() + '\n');
                    if (z) {
                        long j2 = this.nextSequenceNumber;
                        this.nextSequenceNumber = 1 + j2;
                        entry.sequenceNumber = j2;
                    }
                } else {
                    this.lruEntries.remove(entry.key);
                    this.journalWriter.write("REMOVE " + entry.key + '\n');
                }
                this.journalWriter.flush();
                if (this.size > this.maxSize || this.fileCount > this.maxFileCount || journalRebuildRequired()) {
                    this.executorService.submit(this.cleanupCallable);
                }
            }
        }
    }

    public static void deleteIfExists(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65552, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Editor edit(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65553, this, str, j)) == null) {
            synchronized (this) {
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (j == -1 || (entry != null && entry.sequenceNumber == j)) {
                    if (entry == null) {
                        entry = new Entry(str);
                        this.lruEntries.put(str, entry);
                    } else if (entry.currentEditor != null) {
                        return null;
                    }
                    Editor editor = new Editor(entry);
                    entry.currentEditor = editor;
                    Writer writer = this.journalWriter;
                    writer.write("DIRTY " + str + '\n');
                    this.journalWriter.flush();
                    return editor;
                }
                return null;
            }
        }
        return (Editor) invokeLJ.objValue;
    }

    public static String inputStreamToString(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, inputStream)) == null) ? Util.readFully(new InputStreamReader(inputStream, Util.UTF_8)) : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean journalRebuildRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            int i2 = this.redundantOpCount;
            return i2 >= 2000 && i2 >= this.lruEntries.size();
        }
        return invokeV.booleanValue;
    }

    public static DiskLruCache open(File file, int i2, int i3, long j, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Integer.valueOf(i4)})) == null) {
            if (j > 0) {
                if (i4 > 0) {
                    if (i3 > 0) {
                        File file2 = new File(file, "journal.bkp");
                        if (file2.exists()) {
                            File file3 = new File(file, "journal");
                            if (file3.exists()) {
                                file2.delete();
                            } else {
                                renameTo(file2, file3, false);
                            }
                        }
                        DiskLruCache diskLruCache = new DiskLruCache(file, i2, i3, j, i4);
                        if (diskLruCache.journalFile.exists()) {
                            try {
                                diskLruCache.readJournal();
                                diskLruCache.processJournal();
                                diskLruCache.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diskLruCache.journalFile, true), Util.US_ASCII));
                                return diskLruCache;
                            } catch (IOException e2) {
                                PrintStream printStream = System.out;
                                printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                                diskLruCache.delete();
                            }
                        }
                        file.mkdirs();
                        DiskLruCache diskLruCache2 = new DiskLruCache(file, i2, i3, j, i4);
                        diskLruCache2.rebuildJournal();
                        return diskLruCache2;
                    }
                    throw new IllegalArgumentException("valueCount <= 0");
                }
                throw new IllegalArgumentException("maxFileCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (DiskLruCache) invokeCommon.objValue;
    }

    private void processJournal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            deleteIfExists(this.journalFileTmp);
            Iterator<Entry> it = this.lruEntries.values().iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                int i2 = 0;
                if (next.currentEditor == null) {
                    while (i2 < this.valueCount) {
                        this.size += next.lengths[i2];
                        this.fileCount++;
                        i2++;
                    }
                } else {
                    next.currentEditor = null;
                    while (i2 < this.valueCount) {
                        deleteIfExists(next.getCleanFile(i2));
                        deleteIfExists(next.getDirtyFile(i2));
                        i2++;
                    }
                    it.remove();
                }
            }
        }
    }

    private void readJournal() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65558, this) != null) {
            return;
        }
        StrictLineReader strictLineReader = new StrictLineReader(new FileInputStream(this.journalFile), Util.US_ASCII);
        try {
            String readLine = strictLineReader.readLine();
            String readLine2 = strictLineReader.readLine();
            String readLine3 = strictLineReader.readLine();
            String readLine4 = strictLineReader.readLine();
            String readLine5 = strictLineReader.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.appVersion).equals(readLine3) || !Integer.toString(this.valueCount).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readLine5 + PreferencesUtil.RIGHT_MOUNT);
            }
            int i2 = 0;
            while (true) {
                try {
                    readJournalLine(strictLineReader.readLine());
                    i2++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i2 - this.lruEntries.size();
                    Util.closeQuietly(strictLineReader);
                    return;
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(strictLineReader);
            throw th;
        }
    }

    private void readJournalLine(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf == -1) {
                throw new IOException("unexpected journal line: " + str);
            }
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                substring = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.lruEntries.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i2, indexOf2);
            }
            Entry entry = this.lruEntries.get(substring);
            if (entry == null) {
                entry = new Entry(substring);
                this.lruEntries.put(substring, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                entry.currentEditor = new Editor(entry);
            } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
            } else {
                throw new IOException("unexpected journal line: " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void rebuildJournal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            synchronized (this) {
                if (this.journalWriter != null) {
                    this.journalWriter.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFileTmp), Util.US_ASCII));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.appVersion));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.valueCount));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (Entry entry : this.lruEntries.values()) {
                    bufferedWriter.write(entry.currentEditor != null ? "DIRTY " + entry.key + '\n' : "CLEAN " + entry.key + entry.getLengths() + '\n');
                }
                bufferedWriter.close();
                if (this.journalFile.exists()) {
                    renameTo(this.journalFile, this.journalFileBackup, true);
                }
                renameTo(this.journalFileTmp, this.journalFile, false);
                this.journalFileBackup.delete();
                this.journalWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.journalFile, true), Util.US_ASCII));
            }
        }
    }

    public static void renameTo(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65561, null, file, file2, z) == null) {
            if (z) {
                deleteIfExists(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToFileCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            while (this.fileCount > this.maxFileCount) {
                remove(this.lruEntries.entrySet().iterator().next().getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            while (this.size > this.maxSize) {
                remove(this.lruEntries.entrySet().iterator().next().getKey());
            }
        }
    }

    private void validateKey(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, str) == null) || LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.journalWriter == null) {
                    return;
                }
                Iterator it = new ArrayList(this.lruEntries.values()).iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                trimToSize();
                trimToFileCount();
                this.journalWriter.close();
                this.journalWriter = null;
            }
        }
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close();
            Util.deleteContents(this.directory);
        }
    }

    public Editor edit(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? edit(str, -1L) : (Editor) invokeL.objValue;
    }

    public synchronized long fileCount() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                j = this.fileCount;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                checkNotClosed();
                trimToSize();
                trimToFileCount();
                this.journalWriter.flush();
            }
        }
    }

    public synchronized Snapshot get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (entry == null) {
                    return null;
                }
                if (entry.readable) {
                    File[] fileArr = new File[this.valueCount];
                    InputStream[] inputStreamArr = new InputStream[this.valueCount];
                    for (int i2 = 0; i2 < this.valueCount; i2++) {
                        try {
                            File cleanFile = entry.getCleanFile(i2);
                            fileArr[i2] = cleanFile;
                            inputStreamArr[i2] = new FileInputStream(cleanFile);
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.valueCount && inputStreamArr[i3] != null; i3++) {
                                Util.closeQuietly(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.redundantOpCount++;
                    this.journalWriter.append((CharSequence) ("READ " + str + '\n'));
                    if (journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    return new Snapshot(str, entry.sequenceNumber, fileArr, inputStreamArr, entry.lengths);
                }
                return null;
            }
        }
        return (Snapshot) invokeL.objValue;
    }

    public File getDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.directory : (File) invokeV.objValue;
    }

    public synchronized int getMaxFileCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i2 = this.maxFileCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized long getMaxSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                j = this.maxSize;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.journalWriter == null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            synchronized (this) {
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (entry != null && entry.currentEditor == null) {
                    for (int i2 = 0; i2 < this.valueCount; i2++) {
                        File cleanFile = entry.getCleanFile(i2);
                        if (cleanFile.exists() && !cleanFile.delete()) {
                            throw new IOException("failed to delete " + cleanFile);
                        }
                        this.size -= entry.lengths[i2];
                        this.fileCount--;
                        entry.lengths[i2] = 0;
                    }
                    this.redundantOpCount++;
                    this.journalWriter.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.lruEntries.remove(str);
                    if (journalRebuildRequired()) {
                        this.executorService.submit(this.cleanupCallable);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void setMaxSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            synchronized (this) {
                this.maxSize = j;
                this.executorService.submit(this.cleanupCallable);
            }
        }
    }

    public synchronized long size() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                j = this.size;
            }
            return j;
        }
        return invokeV.longValue;
    }
}
