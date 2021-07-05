package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class LruDiskCache implements DiskCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    public static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    public static final String ERROR_ARG_NULL = " argument must be not null";
    public transient /* synthetic */ FieldHolder $fh;
    public int bufferSize;
    public DiskLruCache cache;
    public Bitmap.CompressFormat compressFormat;
    public int compressQuality;
    public final FileNameGenerator fileNameGenerator;
    public File reserveCacheDir;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1477220353, "Lcom/kwad/sdk/core/imageloader/cache/disc/impl/ext/LruDiskCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1477220353, "Lcom/kwad/sdk/core/imageloader/cache/disc/impl/ext/LruDiskCache;");
                return;
            }
        }
        DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j) {
        this(file, null, fileNameGenerator, j, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, fileNameGenerator, Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], (File) objArr2[1], (FileNameGenerator) objArr2[2], ((Long) objArr2[3]).longValue(), ((Integer) objArr2[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, file2, fileNameGenerator, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        int i5 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i5 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j2 = i5 == 0 ? Long.MAX_VALUE : j;
        int i6 = i2 == 0 ? Integer.MAX_VALUE : i2;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
        initCache(file, file2, j2, i6);
    }

    private String getKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? this.fileNameGenerator.generate(str) : (String) invokeL.objValue;
    }

    private void initCache(File file, File file2, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{file, file2, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            try {
                this.cache = DiskLruCache.open(file, 1, 1, j, i2);
            } catch (IOException e2) {
                L.e(e2);
                if (file2 != null) {
                    initCache(file2, null, j, i2);
                }
                if (this.cache == null) {
                    throw e2;
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.cache.delete();
            } catch (IOException e2) {
                L.e(e2);
            }
            try {
                initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
            } catch (IOException e3) {
                L.e(e3);
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                this.cache.close();
            } catch (IOException e2) {
                L.e(e2);
            }
            this.cache = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0032  */
    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File get(String str) {
        InterceptResult invokeL;
        Throwable th;
        DiskLruCache.Snapshot snapshot;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) != null) {
            return (File) invokeL.objValue;
        }
        File file = null;
        try {
            snapshot = this.cache.get(getKey(str));
            if (snapshot != null) {
                try {
                    try {
                        file = snapshot.getFile(0);
                    } catch (IOException e2) {
                        e = e2;
                        L.e(e);
                        if (snapshot != null) {
                            snapshot.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (snapshot != null) {
                        snapshot.close();
                    }
                    throw th;
                }
            }
            if (snapshot != null) {
                snapshot.close();
            }
            return file;
        } catch (IOException e3) {
            e = e3;
            snapshot = null;
        } catch (Throwable th3) {
            th = th3;
            snapshot = null;
            if (snapshot != null) {
            }
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.cache.getDirectory() : (File) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            try {
                return this.cache.remove(getKey(str));
            } catch (IOException e2) {
                L.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bitmap)) == null) {
            DiskLruCache.Editor edit = this.cache.edit(getKey(str));
            if (edit == null) {
                return false;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
            try {
                boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
                if (compress) {
                    edit.commit();
                } else {
                    edit.abort();
                }
                return compress;
            } finally {
                IoUtils.closeSilently(bufferedOutputStream);
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, inputStream, copyListener)) == null) {
            DiskLruCache.Editor edit = this.cache.edit(getKey(str));
            if (edit == null) {
                return false;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
            try {
                boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
                IoUtils.closeSilently(bufferedOutputStream);
                if (copyStream) {
                    edit.commit();
                } else {
                    edit.abort();
                }
                return copyStream;
            } catch (Throwable th) {
                IoUtils.closeSilently(bufferedOutputStream);
                edit.abort();
                throw th;
            }
        }
        return invokeLLL.booleanValue;
    }

    public void setBufferSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.bufferSize = i2;
        }
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, compressFormat) == null) {
            this.compressFormat = compressFormat;
        }
    }

    public void setCompressQuality(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.compressQuality = i2;
        }
    }
}
