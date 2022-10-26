package okhttp3.internal.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
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
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
/* loaded from: classes8.dex */
public final class DiskLruCache implements Closeable, Flushable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final Pattern LEGAL_KEY_PATTERN;
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String READ = "READ";
    public static final String REMOVE = "REMOVE";
    public static final String VERSION_1 = "1";
    public transient /* synthetic */ FieldHolder $fh;
    public final int appVersion;
    public final Runnable cleanupRunnable;
    public boolean closed;
    public final File directory;
    public final Executor executor;
    public final FileSystem fileSystem;
    public boolean hasJournalErrors;
    public boolean initialized;
    public final File journalFile;
    public final File journalFileBackup;
    public final File journalFileTmp;
    public BufferedSink journalWriter;
    public final LinkedHashMap<String, Entry> lruEntries;
    public long maxSize;
    public boolean mostRecentRebuildFailed;
    public boolean mostRecentTrimFailed;
    public long nextSequenceNumber;
    public int redundantOpCount;
    public long size;
    public final int valueCount;

    /* loaded from: classes8.dex */
    public final class Editor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean done;
        public final Entry entry;
        public final /* synthetic */ DiskLruCache this$0;
        public final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            boolean[] zArr;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.entry = entry;
            if (entry.readable) {
                zArr = null;
            } else {
                zArr = new boolean[diskLruCache.valueCount];
            }
            this.written = zArr;
        }

        public void abort() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0) {
                    if (!this.done) {
                        if (this.entry.currentEditor == this) {
                            this.this$0.completeEdit(this, false);
                        }
                        this.done = true;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        }

        public void abortUnlessCommitted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.this$0) {
                    if (!this.done && this.entry.currentEditor == this) {
                        try {
                            this.this$0.completeEdit(this, false);
                        } catch (IOException unused) {
                        }
                    }
                }
            }
        }

        public void commit() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.this$0) {
                    if (!this.done) {
                        if (this.entry.currentEditor == this) {
                            this.this$0.completeEdit(this, true);
                        }
                        this.done = true;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        }

        public void detach() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.entry.currentEditor == this) {
                int i = 0;
                while (true) {
                    DiskLruCache diskLruCache = this.this$0;
                    if (i < diskLruCache.valueCount) {
                        try {
                            diskLruCache.fileSystem.delete(this.entry.dirtyFiles[i]);
                        } catch (IOException unused) {
                        }
                        i++;
                    } else {
                        this.entry.currentEditor = null;
                        return;
                    }
                }
            }
        }

        public Sink newSink(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                synchronized (this.this$0) {
                    if (!this.done) {
                        if (this.entry.currentEditor != this) {
                            return Okio.blackhole();
                        }
                        if (!this.entry.readable) {
                            this.written[i] = true;
                        }
                        try {
                            return new FaultHidingSink(this, this.this$0.fileSystem.sink(this.entry.dirtyFiles[i])) { // from class: okhttp3.internal.cache.DiskLruCache.Editor.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Editor this$1;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(r8);
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r8};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            super((Sink) newInitContext.callArgs[0]);
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // okhttp3.internal.cache.FaultHidingSink
                                public void onException(IOException iOException) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iOException) == null) {
                                        synchronized (this.this$1.this$0) {
                                            this.this$1.detach();
                                        }
                                    }
                                }
                            };
                        } catch (FileNotFoundException unused) {
                            return Okio.blackhole();
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            return (Sink) invokeI.objValue;
        }

        public Source newSource(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                synchronized (this.this$0) {
                    if (!this.done) {
                        if (!this.entry.readable || this.entry.currentEditor != this) {
                            return null;
                        }
                        try {
                            return this.this$0.fileSystem.source(this.entry.cleanFiles[i]);
                        } catch (FileNotFoundException unused) {
                            return null;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            return (Source) invokeI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final File[] cleanFiles;
        public Editor currentEditor;
        public final File[] dirtyFiles;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            int i3 = diskLruCache.valueCount;
            this.lengths = new long[i3];
            this.cleanFiles = new File[i3];
            this.dirtyFiles = new File[i3];
            StringBuilder sb = new StringBuilder(str);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            int length = sb.length();
            for (int i4 = 0; i4 < diskLruCache.valueCount; i4++) {
                sb.append(i4);
                this.cleanFiles[i4] = new File(diskLruCache.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i4] = new File(diskLruCache.directory, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        public void setLengths(String[] strArr) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) {
                if (strArr.length == this.this$0.valueCount) {
                    for (int i = 0; i < strArr.length; i++) {
                        try {
                            this.lengths[i] = Long.parseLong(strArr[i]);
                        } catch (NumberFormatException unused) {
                            throw invalidLengths(strArr);
                        }
                    }
                    return;
                }
                throw invalidLengths(strArr);
            }
        }

        public void writeLengths(BufferedSink bufferedSink) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                for (long j : this.lengths) {
                    bufferedSink.writeByte(32).writeDecimalLong(j);
                }
            }
        }

        public Snapshot snapshot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Thread.holdsLock(this.this$0)) {
                    Source[] sourceArr = new Source[this.this$0.valueCount];
                    long[] jArr = (long[]) this.lengths.clone();
                    for (int i = 0; i < this.this$0.valueCount; i++) {
                        try {
                            sourceArr[i] = this.this$0.fileSystem.source(this.cleanFiles[i]);
                        } catch (FileNotFoundException unused) {
                            for (int i2 = 0; i2 < this.this$0.valueCount && sourceArr[i2] != null; i2++) {
                                Util.closeQuietly(sourceArr[i2]);
                            }
                            try {
                                this.this$0.removeEntry(this);
                                return null;
                            } catch (IOException unused2) {
                                return null;
                            }
                        }
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, sourceArr, jArr);
                }
                throw new AssertionError();
            }
            return (Snapshot) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class Snapshot implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String key;
        public final long[] lengths;
        public final long sequenceNumber;
        public final Source[] sources;
        public final /* synthetic */ DiskLruCache this$0;

        public Snapshot(DiskLruCache diskLruCache, String str, long j, Source[] sourceArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {diskLruCache, str, Long.valueOf(j), sourceArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public long getLength(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return this.lengths[i];
            }
            return invokeI.longValue;
        }

        public Source getSource(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return this.sources[i];
            }
            return (Source) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Source source : this.sources) {
                    Util.closeQuietly(source);
                }
            }
        }

        @Nullable
        public Editor edit() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.this$0.edit(this.key, this.sequenceNumber);
            }
            return (Editor) invokeV.objValue;
        }

        public String key() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.key;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(644943416, "Lokhttp3/internal/cache/DiskLruCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(644943416, "Lokhttp3/internal/cache/DiskLruCache;");
                return;
            }
        }
        LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    }

    private synchronized void checkNotClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (isClosed()) {
                    throw new IllegalStateException("cache is closed");
                }
            }
        }
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return Okio.buffer(new FaultHidingSink(this, this.fileSystem.appendingSink(this.journalFile)) { // from class: okhttp3.internal.cache.DiskLruCache.2
                public static final /* synthetic */ boolean $assertionsDisabled = false;
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DiskLruCache this$0;

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1315311658, "Lokhttp3/internal/cache/DiskLruCache$2;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(1315311658, "Lokhttp3/internal/cache/DiskLruCache$2;");
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Sink) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // okhttp3.internal.cache.FaultHidingSink
                public void onException(IOException iOException) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, iOException) == null) {
                        this.this$0.hasJournalErrors = true;
                    }
                }
            });
        }
        return (BufferedSink) invokeV.objValue;
    }

    public void delete() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            close();
            this.fileSystem.deleteContents(this.directory);
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (!this.initialized) {
                    return;
                }
                checkNotClosed();
                trimToSize();
                this.journalWriter.flush();
            }
        }
    }

    public File getDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.directory;
        }
        return (File) invokeV.objValue;
    }

    public synchronized long getMaxSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                z = this.closed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean journalRebuildRequired() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i = this.redundantOpCount;
            if (i >= 2000 && i >= this.lruEntries.size()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized long size() throws IOException {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                initialize();
                j = this.size;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        InterceptResult invokeV;
        Iterator<Snapshot> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                initialize();
                it = new Iterator<Snapshot>(this) { // from class: okhttp3.internal.cache.DiskLruCache.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final Iterator<Entry> delegate;
                    public Snapshot nextSnapshot;
                    public Snapshot removeSnapshot;
                    public final /* synthetic */ DiskLruCache this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.delegate = new ArrayList(this.this$0.lruEntries.values()).iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                            if (this.nextSnapshot != null) {
                                return true;
                            }
                            synchronized (this.this$0) {
                                if (this.this$0.closed) {
                                    return false;
                                }
                                while (this.delegate.hasNext()) {
                                    Snapshot snapshot = this.delegate.next().snapshot();
                                    if (snapshot != null) {
                                        this.nextSnapshot = snapshot;
                                        return true;
                                    }
                                }
                                return false;
                            }
                        }
                        return invokeV2.booleanValue;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            Snapshot snapshot = this.removeSnapshot;
                            if (snapshot != null) {
                                try {
                                    this.this$0.remove(snapshot.key);
                                } catch (IOException unused) {
                                } catch (Throwable th) {
                                    this.removeSnapshot = null;
                                    throw th;
                                }
                                this.removeSnapshot = null;
                                return;
                            }
                            throw new IllegalStateException("remove() before next()");
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Iterator
                    public Snapshot next() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            if (hasNext()) {
                                Snapshot snapshot = this.nextSnapshot;
                                this.removeSnapshot = snapshot;
                                this.nextSnapshot = null;
                                return snapshot;
                            }
                            throw new NoSuchElementException();
                        }
                        return (Snapshot) invokeV2.objValue;
                    }
                };
            }
            return it;
        }
        return (Iterator) invokeV.objValue;
    }

    public void trimToSize() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            while (this.size > this.maxSize) {
                removeEntry(this.lruEntries.values().iterator().next());
            }
            this.mostRecentTrimFailed = false;
        }
    }

    public DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileSystem, file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.size = 0L;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.nextSequenceNumber = 0L;
        this.cleanupRunnable = new Runnable(this) { // from class: okhttp3.internal.cache.DiskLruCache.1
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0) {
                        if (!this.this$0.initialized) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z | this.this$0.closed) {
                            return;
                        }
                        try {
                            this.this$0.trimToSize();
                        } catch (IOException unused) {
                            this.this$0.mostRecentTrimFailed = true;
                        }
                        try {
                            if (this.this$0.journalRebuildRequired()) {
                                this.this$0.rebuildJournal();
                                this.this$0.redundantOpCount = 0;
                            }
                        } catch (IOException unused2) {
                            this.this$0.mostRecentRebuildFailed = true;
                            this.this$0.journalWriter = Okio.buffer(Okio.blackhole());
                        }
                    }
                }
            }
        };
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, "journal");
        this.journalFileTmp = new File(file, "journal.tmp");
        this.journalFileBackup = new File(file, "journal.bkp");
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{fileSystem, file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i2 > 0) {
                    return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (DiskLruCache) invokeCommon.objValue;
    }

    private void processJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.fileSystem.delete(this.journalFileTmp);
            Iterator<Entry> it = this.lruEntries.values().iterator();
            while (it.hasNext()) {
                Entry next = it.next();
                int i = 0;
                if (next.currentEditor == null) {
                    while (i < this.valueCount) {
                        this.size += next.lengths[i];
                        i++;
                    }
                } else {
                    next.currentEditor = null;
                    while (i < this.valueCount) {
                        this.fileSystem.delete(next.cleanFiles[i]);
                        this.fileSystem.delete(next.dirtyFiles[i]);
                        i++;
                    }
                    it.remove();
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Entry[] entryArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.initialized && !this.closed) {
                    for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                        if (entry.currentEditor != null) {
                            entry.currentEditor.abort();
                        }
                    }
                    trimToSize();
                    this.journalWriter.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
                this.closed = true;
            }
        }
    }

    private void readJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            BufferedSource buffer = Okio.buffer(this.fileSystem.source(this.journalFile));
            try {
                String readUtf8LineStrict = buffer.readUtf8LineStrict();
                String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
                String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
                String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
                String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
                if ("libcore.io.DiskLruCache".equals(readUtf8LineStrict) && "1".equals(readUtf8LineStrict2) && Integer.toString(this.appVersion).equals(readUtf8LineStrict3) && Integer.toString(this.valueCount).equals(readUtf8LineStrict4) && "".equals(readUtf8LineStrict5)) {
                    int i = 0;
                    while (true) {
                        try {
                            readJournalLine(buffer.readUtf8LineStrict());
                            i++;
                        } catch (EOFException unused) {
                            this.redundantOpCount = i - this.lruEntries.size();
                            if (!buffer.exhausted()) {
                                rebuildJournal();
                            } else {
                                this.journalWriter = newJournalWriter();
                            }
                            Util.closeQuietly(buffer);
                            return;
                        }
                    }
                } else {
                    throw new IOException("unexpected journal header: [" + readUtf8LineStrict + StringUtil.ARRAY_ELEMENT_SEPARATOR + readUtf8LineStrict2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readUtf8LineStrict4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + readUtf8LineStrict5 + PreferencesUtil.RIGHT_MOUNT);
                }
            } catch (Throwable th) {
                Util.closeQuietly(buffer);
                throw th;
            }
        }
    }

    private void readJournalLine(String str) throws IOException {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(32, i);
                if (indexOf2 == -1) {
                    substring = str.substring(i);
                    if (indexOf == 6 && str.startsWith("REMOVE")) {
                        this.lruEntries.remove(substring);
                        return;
                    }
                } else {
                    substring = str.substring(i, indexOf2);
                }
                Entry entry = this.lruEntries.get(substring);
                if (entry == null) {
                    entry = new Entry(this, substring);
                    this.lruEntries.put(substring, entry);
                }
                if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                    String[] split = str.substring(indexOf2 + 1).split(" ");
                    entry.readable = true;
                    entry.currentEditor = null;
                    entry.setLengths(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    entry.currentEditor = new Editor(this, entry);
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

    private void validateKey(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, this, str) != null) || LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public synchronized boolean remove(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                initialize();
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (entry == null) {
                    return false;
                }
                boolean removeEntry = removeEntry(entry);
                if (removeEntry && this.size <= this.maxSize) {
                    this.mostRecentTrimFailed = false;
                }
                return removeEntry;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void completeEdit(Editor editor, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editor, z) == null) {
            synchronized (this) {
                Entry entry = editor.entry;
                if (entry.currentEditor == editor) {
                    if (z && !entry.readable) {
                        for (int i = 0; i < this.valueCount; i++) {
                            if (editor.written[i]) {
                                if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                                    editor.abort();
                                    return;
                                }
                            } else {
                                editor.abort();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < this.valueCount; i2++) {
                        File file = entry.dirtyFiles[i2];
                        if (z) {
                            if (this.fileSystem.exists(file)) {
                                File file2 = entry.cleanFiles[i2];
                                this.fileSystem.rename(file, file2);
                                long j = entry.lengths[i2];
                                long size = this.fileSystem.size(file2);
                                entry.lengths[i2] = size;
                                this.size = (this.size - j) + size;
                            }
                        } else {
                            this.fileSystem.delete(file);
                        }
                    }
                    this.redundantOpCount++;
                    entry.currentEditor = null;
                    if (entry.readable | z) {
                        entry.readable = true;
                        this.journalWriter.writeUtf8("CLEAN").writeByte(32);
                        this.journalWriter.writeUtf8(entry.key);
                        entry.writeLengths(this.journalWriter);
                        this.journalWriter.writeByte(10);
                        if (z) {
                            long j2 = this.nextSequenceNumber;
                            this.nextSequenceNumber = 1 + j2;
                            entry.sequenceNumber = j2;
                        }
                    } else {
                        this.lruEntries.remove(entry.key);
                        this.journalWriter.writeUtf8("REMOVE").writeByte(32);
                        this.journalWriter.writeUtf8(entry.key);
                        this.journalWriter.writeByte(10);
                    }
                    this.journalWriter.flush();
                    if (this.size > this.maxSize || journalRebuildRequired()) {
                        this.executor.execute(this.cleanupRunnable);
                    }
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    @Nullable
    public Editor edit(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return edit(str, -1L);
        }
        return (Editor) invokeL.objValue;
    }

    public synchronized void setMaxSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            synchronized (this) {
                this.maxSize = j;
                if (this.initialized) {
                    this.executor.execute(this.cleanupRunnable);
                }
            }
        }
    }

    public synchronized Editor edit(String str, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
            synchronized (this) {
                initialize();
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
                    return null;
                }
                if (entry != null && entry.currentEditor != null) {
                    return null;
                }
                if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
                    this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(str).writeByte(10);
                    this.journalWriter.flush();
                    if (this.hasJournalErrors) {
                        return null;
                    }
                    if (entry == null) {
                        entry = new Entry(this, str);
                        this.lruEntries.put(str, entry);
                    }
                    Editor editor = new Editor(this, entry);
                    entry.currentEditor = editor;
                    return editor;
                }
                this.executor.execute(this.cleanupRunnable);
                return null;
            }
        }
        return (Editor) invokeLJ.objValue;
    }

    public synchronized void evictAll() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                initialize();
                for (Entry entry : (Entry[]) this.lruEntries.values().toArray(new Entry[this.lruEntries.size()])) {
                    removeEntry(entry);
                }
                this.mostRecentTrimFailed = false;
            }
        }
    }

    public synchronized Snapshot get(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                initialize();
                checkNotClosed();
                validateKey(str);
                Entry entry = this.lruEntries.get(str);
                if (entry != null && entry.readable) {
                    Snapshot snapshot = entry.snapshot();
                    if (snapshot == null) {
                        return null;
                    }
                    this.redundantOpCount++;
                    this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(str).writeByte(10);
                    if (journalRebuildRequired()) {
                        this.executor.execute(this.cleanupRunnable);
                    }
                    return snapshot;
                }
                return null;
            }
        }
        return (Snapshot) invokeL.objValue;
    }

    public boolean removeEntry(Entry entry) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, entry)) == null) {
            Editor editor = entry.currentEditor;
            if (editor != null) {
                editor.detach();
            }
            for (int i = 0; i < this.valueCount; i++) {
                this.fileSystem.delete(entry.cleanFiles[i]);
                long j = this.size;
                long[] jArr = entry.lengths;
                this.size = j - jArr[i];
                jArr[i] = 0;
            }
            this.redundantOpCount++;
            this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.key).writeByte(10);
            this.lruEntries.remove(entry.key);
            if (journalRebuildRequired()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized void initialize() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                if (this.initialized) {
                    return;
                }
                if (this.fileSystem.exists(this.journalFileBackup)) {
                    if (this.fileSystem.exists(this.journalFile)) {
                        this.fileSystem.delete(this.journalFileBackup);
                    } else {
                        this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                    }
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    try {
                        readJournal();
                        processJournal();
                        this.initialized = true;
                        return;
                    } catch (IOException e) {
                        Platform platform = Platform.get();
                        platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                        delete();
                        this.closed = false;
                    }
                }
                rebuildJournal();
                this.initialized = true;
            }
        }
    }

    public synchronized void rebuildJournal() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (this.journalWriter != null) {
                    this.journalWriter.close();
                }
                BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
                buffer.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
                buffer.writeUtf8("1").writeByte(10);
                buffer.writeDecimalLong(this.appVersion).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        buffer.writeUtf8("DIRTY").writeByte(32);
                        buffer.writeUtf8(entry.key);
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8("CLEAN").writeByte(32);
                        buffer.writeUtf8(entry.key);
                        entry.writeLengths(buffer);
                        buffer.writeByte(10);
                    }
                }
                buffer.close();
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            }
        }
    }
}
