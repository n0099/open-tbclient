package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.impl.ext.DiskLruCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    public static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    public static final String ERROR_ARG_NULL = " argument must be not null";
    public int bufferSize;
    public DiskLruCache cache;
    public Bitmap.CompressFormat compressFormat;
    public int compressQuality;
    public final FileNameGenerator fileNameGenerator;
    public File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j) {
        this(file, null, fileNameGenerator, j, 0);
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j, int i2) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i3 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j2 = i3 == 0 ? Long.MAX_VALUE : j;
        int i4 = i2 == 0 ? Integer.MAX_VALUE : i2;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
        initCache(file, file2, j2, i4);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j, int i2) {
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

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
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

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        try {
            this.cache.close();
        } catch (IOException e2) {
            L.e(e2);
        }
        this.cache = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File get(String str) {
        Throwable th;
        DiskLruCache.Snapshot snapshot;
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
        return this.cache.getDirectory();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e2) {
            L.e(e2);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
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

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
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

    public void setBufferSize(int i2) {
        this.bufferSize = i2;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i2) {
        this.compressQuality = i2;
    }
}
