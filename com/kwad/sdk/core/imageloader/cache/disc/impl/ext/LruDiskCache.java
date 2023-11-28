package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    public static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    public static final String ERROR_ARG_NULL = " argument must be not null";
    public int bufferSize;
    public a cache;
    public Bitmap.CompressFormat compressFormat;
    public int compressQuality;
    public final FileNameGenerator fileNameGenerator;
    public File reserveCacheDir;

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e) {
            L.e(e);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.BM());
        } catch (IOException e2) {
            L.e(e2);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        b.closeQuietly(this.cache);
        this.cache = null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cache.getDirectory();
    }

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j) {
        this(file, null, fileNameGenerator, j, 0);
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j, int i) {
        int i2;
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file != null) {
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i3 >= 0) {
                if (i >= 0) {
                    if (fileNameGenerator != null) {
                        long j2 = i3 == 0 ? Long.MAX_VALUE : j;
                        if (i == 0) {
                            i2 = Integer.MAX_VALUE;
                        } else {
                            i2 = i;
                        }
                        this.reserveCacheDir = file2;
                        this.fileNameGenerator = fileNameGenerator;
                        initCache(file, file2, j2, i2);
                        return;
                    }
                    throw new IllegalArgumentException("fileNameGenerator argument must be not null");
                }
                throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
            }
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        throw new IllegalArgumentException("cacheDir argument must be not null");
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        Throwable th;
        a.c cVar;
        File file = null;
        try {
            cVar = this.cache.cQ(getKey(str));
            if (cVar != null) {
                try {
                    try {
                        file = cVar.cp(0);
                    } catch (IOException e) {
                        e = e;
                        L.e(e);
                        b.closeQuietly(cVar);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    b.closeQuietly(cVar);
                    throw th;
                }
            }
            b.closeQuietly(cVar);
            return file;
        } catch (IOException e2) {
            e = e2;
            cVar = null;
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            b.closeQuietly(cVar);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e) {
            L.e(e);
            return false;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }

    private void initCache(File file, File file2, long j, int i) {
        try {
            this.cache = a.a(file, 1, 1, j, i);
        } catch (IOException e) {
            L.e(e);
            if (file2 != null) {
                initCache(file2, null, j, i);
            }
            if (this.cache != null) {
                return;
            }
            throw e;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        a.C0701a cR = this.cache.cR(getKey(str));
        if (cR == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(cR.cm(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                cR.commit();
            } else {
                cR.abort();
            }
            return compress;
        } finally {
            b.closeQuietly(bufferedOutputStream);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        a.C0701a cR = this.cache.cR(getKey(str));
        if (cR == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(cR.cm(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            b.closeQuietly(bufferedOutputStream);
            if (copyStream) {
                cR.commit();
            } else {
                cR.abort();
            }
            return copyStream;
        } catch (Throwable th) {
            b.closeQuietly(bufferedOutputStream);
            cR.abort();
            throw th;
        }
    }
}
