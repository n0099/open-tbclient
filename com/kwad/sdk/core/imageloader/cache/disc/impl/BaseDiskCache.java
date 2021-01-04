package com.kwad.sdk.core.imageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.core.DefaultConfigurationFactory;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes5.dex */
public abstract class BaseDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NULL = " argument must be not null";
    private static final String TEMP_IMAGE_POSTFIX = ".tmp";
    protected int bufferSize;
    protected final File cacheDir;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    protected final File reserveCacheDir;

    public BaseDiskCache(File file) {
        this(file, null);
    }

    public BaseDiskCache(File file, File file2) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiskCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        this.cacheDir = file;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        File[] listFiles = this.cacheDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        return getFile(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cacheDir;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File getFile(String str) {
        String generate = this.fileNameGenerator.generate(str);
        File file = this.cacheDir;
        if (!this.cacheDir.exists() && !this.cacheDir.mkdirs() && this.reserveCacheDir != null && (this.reserveCacheDir.exists() || this.reserveCacheDir.mkdirs())) {
            file = this.reserveCacheDir;
        }
        return new File(file, generate);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        return getFile(str).delete();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + TEMP_IMAGE_POSTFIX);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            IoUtils.closeSilently(bufferedOutputStream);
            if (compress && !file2.renameTo(file)) {
                compress = false;
            }
            if (!compress) {
                file2.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            IoUtils.closeSilently(bufferedOutputStream);
            file2.delete();
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        boolean z;
        BufferedOutputStream bufferedOutputStream;
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + TEMP_IMAGE_POSTFIX);
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
            z = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            IoUtils.closeSilently(bufferedOutputStream);
            if (z && !file2.renameTo(file)) {
                z = false;
            }
            if (!z) {
                file2.delete();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            if (z && !file2.renameTo(file)) {
                z = false;
            }
            if (!z) {
                file2.delete();
            }
            throw th;
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
}
