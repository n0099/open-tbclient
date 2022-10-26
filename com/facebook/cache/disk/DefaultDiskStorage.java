package com.facebook.cache.disk;

import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.CountingOutputStream;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class DefaultDiskStorage implements DiskStorage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_FILE_EXTENSION = ".cnt";
    public static final String DEFAULT_DISK_STORAGE_VERSION_PREFIX = "v2";
    public static final int SHARDING_BUCKET_COUNT = 100;
    public static final Class TAG;
    public static final String TEMP_FILE_EXTENSION = ".tmp";
    public static final long TEMP_FILE_LIFETIME_MS;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheErrorLogger mCacheErrorLogger;
    public final Clock mClock;
    public final boolean mIsExternal;
    public final File mRootDirectory;
    public final File mVersionDirectory;

    /* renamed from: com.facebook.cache.disk.DefaultDiskStorage$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public @interface FileType {
        public static final String CONTENT = ".cnt";
        public static final String TEMP = ".tmp";
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class EntriesCollector implements FileTreeVisitor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List result;
        public final /* synthetic */ DefaultDiskStorage this$0;

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            }
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file) == null) {
            }
        }

        public EntriesCollector(DefaultDiskStorage defaultDiskStorage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDiskStorage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDiskStorage;
            this.result = new ArrayList();
        }

        public /* synthetic */ EntriesCollector(DefaultDiskStorage defaultDiskStorage, AnonymousClass1 anonymousClass1) {
            this(defaultDiskStorage);
        }

        public List getEntries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Collections.unmodifiableList(this.result);
            }
            return (List) invokeV.objValue;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            FileInfo shardFileInfo;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, file) == null) && (shardFileInfo = this.this$0.getShardFileInfo(file)) != null && shardFileInfo.type == ".cnt") {
                this.result.add(new EntryImpl(shardFileInfo.resourceId, file, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class EntryImpl implements DiskStorage.Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String id;
        public final FileBinaryResource resource;
        public long size;
        public long timestamp;

        public EntryImpl(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Preconditions.checkNotNull(file);
            this.id = (String) Preconditions.checkNotNull(str);
            this.resource = FileBinaryResource.createOrNull(file);
            this.size = -1L;
            this.timestamp = -1L;
        }

        public /* synthetic */ EntryImpl(String str, File file, AnonymousClass1 anonymousClass1) {
            this(str, file);
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.id;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.size < 0) {
                    this.size = this.resource.size();
                }
                return this.size;
            }
            return invokeV.longValue;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.timestamp < 0) {
                    this.timestamp = this.resource.getFile().lastModified();
                }
                return this.timestamp;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public FileBinaryResource getResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.resource;
            }
            return (FileBinaryResource) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class FileInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String resourceId;
        public final String type;

        public FileInfo(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = str;
            this.resourceId = str2;
        }

        public /* synthetic */ FileInfo(String str, String str2, AnonymousClass1 anonymousClass1) {
            this(str, str2);
        }

        @Nullable
        public static FileInfo fromFile(File file) {
            InterceptResult invokeL;
            String fileTypefromExtension;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf <= 0 || (fileTypefromExtension = DefaultDiskStorage.getFileTypefromExtension(name.substring(lastIndexOf))) == null) {
                    return null;
                }
                String substring = name.substring(0, lastIndexOf);
                if (fileTypefromExtension.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new FileInfo(fileTypefromExtension, substring);
            }
            return (FileInfo) invokeL.objValue;
        }

        public File createTempFile(File file) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                return File.createTempFile(this.resourceId + ".", ".tmp", file);
            }
            return (File) invokeL.objValue;
        }

        public String toPath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return str + File.separator + this.resourceId + this.type;
            }
            return (String) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.type + "(" + this.resourceId + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class IncompleteFileException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long actual;
        public final long expected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.expected = j;
            this.actual = j2;
        }
    }

    /* loaded from: classes7.dex */
    public class InserterImpl implements DiskStorage.Inserter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mResourceId;
        public final File mTemporaryFile;
        public final /* synthetic */ DefaultDiskStorage this$0;

        public InserterImpl(DefaultDiskStorage defaultDiskStorage, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDiskStorage, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDiskStorage;
            this.mResourceId = str;
            this.mTemporaryFile = file;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean cleanUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mTemporaryFile.exists() && !this.mTemporaryFile.delete()) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource commit(Object obj) throws IOException {
            InterceptResult invokeL;
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                File contentFileFor = this.this$0.getContentFileFor(this.mResourceId);
                try {
                    FileUtils.rename(this.mTemporaryFile, contentFileFor);
                    if (contentFileFor.exists()) {
                        contentFileFor.setLastModified(this.this$0.mClock.now());
                    }
                    return FileBinaryResource.createOrNull(contentFileFor);
                } catch (FileUtils.RenameException e) {
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        if (!(cause instanceof FileUtils.ParentDirNotFoundException)) {
                            if (cause instanceof FileNotFoundException) {
                                cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                            } else {
                                cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                            }
                        } else {
                            cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                        }
                    } else {
                        cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                    }
                    this.this$0.mCacheErrorLogger.logError(cacheErrorCategory, DefaultDiskStorage.TAG, "commit", e);
                    throw e;
                }
            }
            return (BinaryResource) invokeL.objValue;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void writeData(WriterCallback writerCallback, Object obj) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, writerCallback, obj) == null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mTemporaryFile);
                    try {
                        CountingOutputStream countingOutputStream = new CountingOutputStream(fileOutputStream);
                        writerCallback.write(countingOutputStream);
                        countingOutputStream.flush();
                        long count = countingOutputStream.getCount();
                        fileOutputStream.close();
                        if (this.mTemporaryFile.length() == count) {
                            return;
                        }
                        throw new IncompleteFileException(count, this.mTemporaryFile.length());
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (FileNotFoundException e) {
                    this.this$0.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.TAG, "updateResource", e);
                    throw e;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class PurgingVisitor implements FileTreeVisitor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean insideBaseDirectory;
        public final /* synthetic */ DefaultDiskStorage this$0;

        public PurgingVisitor(DefaultDiskStorage defaultDiskStorage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {defaultDiskStorage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = defaultDiskStorage;
        }

        private boolean isExpectedFile(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65538, this, file)) != null) {
                return invokeL.booleanValue;
            }
            FileInfo shardFileInfo = this.this$0.getShardFileInfo(file);
            boolean z = false;
            if (shardFileInfo == null) {
                return false;
            }
            String str = shardFileInfo.type;
            if (str == ".tmp") {
                return isRecentFile(file);
            }
            if (str == ".cnt") {
                z = true;
            }
            Preconditions.checkState(z);
            return true;
        }

        private boolean isRecentFile(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) {
                if (file.lastModified() > this.this$0.mClock.now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void preVisitDirectory(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && !this.insideBaseDirectory && file.equals(this.this$0.mVersionDirectory)) {
                this.insideBaseDirectory = true;
            }
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void visitFile(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file) == null) {
                if (!this.insideBaseDirectory || !isExpectedFile(file)) {
                    file.delete();
                }
            }
        }

        public /* synthetic */ PurgingVisitor(DefaultDiskStorage defaultDiskStorage, AnonymousClass1 anonymousClass1) {
            this(defaultDiskStorage);
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void postVisitDirectory(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                if (!this.this$0.mRootDirectory.equals(file) && !this.insideBaseDirectory) {
                    file.delete();
                }
                if (this.insideBaseDirectory && file.equals(this.this$0.mVersionDirectory)) {
                    this.insideBaseDirectory = false;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(463809320, "Lcom/facebook/cache/disk/DefaultDiskStorage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(463809320, "Lcom/facebook/cache/disk/DefaultDiskStorage;");
                return;
            }
        }
        TAG = DefaultDiskStorage.class;
        TEMP_FILE_LIFETIME_MS = TimeUnit.MINUTES.toMillis(30L);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FileTree.deleteContents(this.mRootDirectory);
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isExternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mIsExternal;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void purgeUnexpectedResources() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FileTree.walkFileTree(this.mRootDirectory, new PurgingVisitor(this, null));
        }
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i), cacheErrorLogger};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(file);
        this.mRootDirectory = file;
        this.mIsExternal = isExternal(file, cacheErrorLogger);
        this.mVersionDirectory = new File(this.mRootDirectory, getVersionSubdirectoryName(i));
        this.mCacheErrorLogger = cacheErrorLogger;
        recreateDirectoryIfVersionChanges();
        this.mClock = SystemClock.get();
    }

    private void mkdirs(File file, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, file, str) == null) {
            try {
                FileUtils.mkdirs(file);
            } catch (FileUtils.CreateDirectoryException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, str, e);
                throw e;
            }
        }
    }

    private boolean query(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65555, this, str, z)) == null) {
            File contentFileFor = getContentFileFor(str);
            boolean exists = contentFileFor.exists();
            if (z && exists) {
                contentFileFor.setLastModified(this.mClock.now());
            }
            return exists;
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean contains(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            return query(str, false);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    @Nullable
    public BinaryResource getResource(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
            File contentFileFor = getContentFileFor(str);
            if (contentFileFor.exists()) {
                contentFileFor.setLastModified(this.mClock.now());
                return FileBinaryResource.createOrNull(contentFileFor);
            }
            return null;
        }
        return (BinaryResource) invokeLL.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean touch(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, obj)) == null) {
            return query(str, true);
        }
        return invokeLL.booleanValue;
    }

    private long doRemove(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, file)) == null) {
            if (!file.exists()) {
                return 0L;
            }
            long length = file.length();
            if (file.delete()) {
                return length;
            }
            return -1L;
        }
        return invokeL.longValue;
    }

    @Nullable
    public static String getFileTypefromExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (".cnt".equals(str)) {
                return ".cnt";
            }
            if (".tmp".equals(str)) {
                return ".tmp";
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private String getFilename(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
            FileInfo fileInfo = new FileInfo(".cnt", str, null);
            return fileInfo.toPath(getSubdirectoryPath(fileInfo.resourceId));
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FileInfo getShardFileInfo(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, file)) == null) {
            FileInfo fromFile = FileInfo.fromFile(file);
            if (fromFile == null || !getSubdirectory(fromFile.resourceId).equals(file.getParentFile())) {
                return null;
            }
            return fromFile;
        }
        return (FileInfo) invokeL.objValue;
    }

    private File getSubdirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, str)) == null) {
            return new File(getSubdirectoryPath(str));
        }
        return (File) invokeL.objValue;
    }

    public File getContentFileFor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new File(getFilename(str));
        }
        return (File) invokeL.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(DiskStorage.Entry entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, entry)) == null) {
            return doRemove(((EntryImpl) entry).getResource().getFile());
        }
        return invokeL.longValue;
    }

    private DiskStorage.DiskDumpInfoEntry dumpCacheEntry(DiskStorage.Entry entry) throws IOException {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, entry)) == null) {
            EntryImpl entryImpl = (EntryImpl) entry;
            byte[] read = entryImpl.getResource().read();
            String typeOfBytes = typeOfBytes(read);
            if (typeOfBytes.equals(SessionMonitorEngine.PUBLIC_DATA_UNDIFNED) && read.length >= 4) {
                str = String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", Byte.valueOf(read[0]), Byte.valueOf(read[1]), Byte.valueOf(read[2]), Byte.valueOf(read[3]));
            } else {
                str = "";
            }
            return new DiskStorage.DiskDumpInfoEntry(entryImpl.getId(), entryImpl.getResource().getFile().getPath(), typeOfBytes, (float) entryImpl.getSize(), str);
        }
        return (DiskStorage.DiskDumpInfoEntry) invokeL.objValue;
    }

    private String getSubdirectoryPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, str)) == null) {
            String valueOf = String.valueOf(Math.abs(str.hashCode() % 100));
            return this.mVersionDirectory + File.separator + valueOf;
        }
        return (String) invokeL.objValue;
    }

    public static String getVersionSubdirectoryName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            return String.format(null, "%s.ols%d.%d", DEFAULT_DISK_STORAGE_VERSION_PREFIX, 100, Integer.valueOf(i));
        }
        return (String) invokeI.objValue;
    }

    public static boolean isExternal(File file, CacheErrorLogger cacheErrorLogger) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, file, cacheErrorLogger)) == null) {
            try {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory == null) {
                    return false;
                }
                try {
                    try {
                        return file.getCanonicalPath().contains(externalStorageDirectory.toString());
                    } catch (IOException e) {
                        e = e;
                        CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.OTHER;
                        Class cls = TAG;
                        cacheErrorLogger.logError(cacheErrorCategory, cls, "failed to read folder to check if external: " + ((String) null), e);
                        return false;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                cacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.OTHER, TAG, "failed to get the external storage directory!", e3);
                return false;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    private void recreateDirectoryIfVersionChanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            boolean z = true;
            if (this.mRootDirectory.exists()) {
                if (!this.mVersionDirectory.exists()) {
                    FileTree.deleteRecursively(this.mRootDirectory);
                } else {
                    z = false;
                }
            }
            if (z) {
                try {
                    FileUtils.mkdirs(this.mVersionDirectory);
                } catch (FileUtils.CreateDirectoryException unused) {
                    CacheErrorLogger cacheErrorLogger = this.mCacheErrorLogger;
                    CacheErrorLogger.CacheErrorCategory cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR;
                    Class cls = TAG;
                    cacheErrorLogger.logError(cacheErrorCategory, cls, "version directory could not be created: " + this.mVersionDirectory, null);
                }
            }
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<DiskStorage.Entry> entries = getEntries();
            DiskStorage.DiskDumpInfo diskDumpInfo = new DiskStorage.DiskDumpInfo();
            for (DiskStorage.Entry entry : entries) {
                DiskStorage.DiskDumpInfoEntry dumpCacheEntry = dumpCacheEntry(entry);
                String str = dumpCacheEntry.type;
                if (!diskDumpInfo.typeCounts.containsKey(str)) {
                    diskDumpInfo.typeCounts.put(str, 0);
                }
                Map map = diskDumpInfo.typeCounts;
                map.put(str, Integer.valueOf(((Integer) map.get(str)).intValue() + 1));
                diskDumpInfo.entries.add(dumpCacheEntry);
            }
            return diskDumpInfo;
        }
        return (DiskStorage.DiskDumpInfo) invokeV.objValue;
    }

    private String typeOfBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, bArr)) == null) {
            if (bArr.length >= 2) {
                if (bArr[0] == -1 && bArr[1] == -40) {
                    return "jpg";
                }
                if (bArr[0] == -119 && bArr[1] == 80) {
                    return "png";
                }
                if (bArr[0] == 82 && bArr[1] == 73) {
                    return "webp";
                }
                if (bArr[0] == 71 && bArr[1] == 73) {
                    return NativeConstants.TYPE_GIF;
                }
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
            return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.cache.disk.DiskStorage
    public List getEntries() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EntriesCollector entriesCollector = new EntriesCollector(this, null);
            FileTree.walkFileTree(this.mVersionDirectory, entriesCollector);
            return entriesCollector.getEntries();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public String getStorageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String absolutePath = this.mRootDirectory.getAbsolutePath();
            return "_" + absolutePath.substring(absolutePath.lastIndexOf(47) + 1, absolutePath.length()) + "_" + absolutePath.hashCode();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, obj)) == null) {
            FileInfo fileInfo = new FileInfo(".tmp", str, null);
            File subdirectory = getSubdirectory(fileInfo.resourceId);
            if (!subdirectory.exists()) {
                mkdirs(subdirectory, "insert");
            }
            try {
                return new InserterImpl(this, str, fileInfo.createTempFile(subdirectory));
            } catch (IOException e) {
                this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, TAG, "insert", e);
                throw e;
            }
        }
        return (DiskStorage.Inserter) invokeLL.objValue;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return doRemove(getContentFileFor(str));
        }
        return invokeL.longValue;
    }
}
