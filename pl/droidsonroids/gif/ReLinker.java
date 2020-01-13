package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
class ReLinker {
    private static final int COPY_BUFFER_SIZE = 8192;
    private static final String LIB_DIR = "lib";
    private static final String MAPPED_BASE_LIB_NAME = System.mapLibraryName("pl_droidsonroids_gif");
    private static final int MAX_TRIES = 5;

    private ReLinker() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static void loadLibrary(Context context) {
        synchronized (ReLinker.class) {
            System.load(unpackLibrary(context).getAbsolutePath());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [117=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00d6 */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
        if (r5 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static File unpackLibrary(Context context) {
        InputStream inputStream;
        ?? r2;
        int i = 0;
        ZipFile zipFile = null;
        String str = MAPPED_BASE_LIB_NAME + BuildConfig.VERSION_NAME;
        File file = new File(context.getDir("lib", 0), str);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(context.getCacheDir(), str);
        if (file2.isFile()) {
            return file2;
        }
        final String mapLibraryName = System.mapLibraryName("pl_droidsonroids_gif_surface");
        FilenameFilter filenameFilter = new FilenameFilter() { // from class: pl.droidsonroids.gif.ReLinker.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file3, String str2) {
                return str2.startsWith(ReLinker.MAPPED_BASE_LIB_NAME) || str2.startsWith(mapLibraryName);
            }
        };
        clearOldLibraryFiles(file, filenameFilter);
        clearOldLibraryFiles(file2, filenameFilter);
        try {
            ZipFile openZipFile = openZipFile(new File(context.getApplicationInfo().sourceDir));
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                try {
                    ZipEntry findLibraryEntry = findLibraryEntry(openZipFile);
                    if (findLibraryEntry == null) {
                        throw new IllegalStateException("Library " + MAPPED_BASE_LIB_NAME + " for supported ABIs not found in APK file");
                    }
                    try {
                        inputStream = openZipFile.getInputStream(findLibraryEntry);
                        try {
                            r2 = new FileOutputStream(file);
                            try {
                                copy(inputStream, r2);
                                closeSilently(inputStream);
                                closeSilently(r2);
                                setFilePermissions(file);
                                break;
                            } catch (IOException e) {
                                if (i2 > 2) {
                                    file = file2;
                                }
                                closeSilently(inputStream);
                                closeSilently(r2);
                                i = i2;
                            } catch (Throwable th) {
                                th = th;
                                zipFile = r2;
                                closeSilently(inputStream);
                                closeSilently(zipFile);
                                throw th;
                            }
                        } catch (IOException e2) {
                            r2 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (IOException e3) {
                        r2 = 0;
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zipFile = openZipFile;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
                closeSilently(inputStream);
                closeSilently(r2);
                i = i2;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @TargetApi(21)
    private static ZipEntry findLibraryEntry(ZipFile zipFile) {
        if (Build.VERSION.SDK_INT >= 21) {
            for (String str : Build.SUPPORTED_ABIS) {
                ZipEntry entry = getEntry(zipFile, str);
                if (entry != null) {
                    return entry;
                }
            }
        }
        return getEntry(zipFile, Build.CPU_ABI);
    }

    private static ZipEntry getEntry(ZipFile zipFile, String str) {
        return zipFile.getEntry(PluginInstallerService.APK_LIB_DIR_PREFIX + str + "/" + MAPPED_BASE_LIB_NAME);
    }

    private static ZipFile openZipFile(File file) {
        ZipFile zipFile;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                zipFile = null;
                break;
            }
            try {
                zipFile = new ZipFile(file, 1);
                break;
            } catch (IOException e) {
                i = i2;
            }
        }
        if (zipFile == null) {
            throw new IllegalStateException("Could not open APK file: " + file.getAbsolutePath());
        }
        return zipFile;
    }

    private static void clearOldLibraryFiles(File file, FilenameFilter filenameFilter) {
        File[] listFiles = file.getParentFile().listFiles(filenameFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    @SuppressLint({"SetWorldReadable"})
    private static void setFilePermissions(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
