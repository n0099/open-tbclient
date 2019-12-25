package org.conscrypt;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class NativeLibraryLoader {
    private static final String DELETE_LIB_PROPERTY_NAME = "org.conscrypt.native.deleteLibAfterLoading";
    private static final boolean DELETE_NATIVE_LIB_AFTER_LOADING;
    private static final String NATIVE_RESOURCE_HOME = "META-INF/native/";
    private static final File WORKDIR;
    private static final String WORK_DIR_PROPERTY_NAME = "org.conscrypt.native.workdir";
    private static final Logger logger = Logger.getLogger(NativeLibraryLoader.class.getName());

    static {
        File workDir = getWorkDir();
        if (workDir == null) {
            workDir = HostProperties.getTempDir();
        }
        WORKDIR = workDir;
        log("-D{0}: {1}", WORK_DIR_PROPERTY_NAME, WORKDIR);
        DELETE_NATIVE_LIB_AFTER_LOADING = Boolean.valueOf(System.getProperty(DELETE_LIB_PROPERTY_NAME, "true")).booleanValue();
    }

    private static File getWorkDir() {
        String property = System.getProperty(WORK_DIR_PROPERTY_NAME);
        if (property == null) {
            return null;
        }
        File file = new File(property);
        if (!file.mkdirs() && !file.exists()) {
            log("Unable to find or create working directory: {0}", property);
            return null;
        }
        try {
            return file.getAbsoluteFile();
        } catch (Exception e) {
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean loadFirstAvailable(ClassLoader classLoader, List<LoadResult> list, String... strArr) {
        for (String str : strArr) {
            if (load(str, classLoader, list)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class LoadResult {
        final boolean absolute;
        final Throwable error;
        final boolean loaded;
        final String name;
        final boolean usingHelperClassloader;

        /* JADX INFO: Access modifiers changed from: private */
        public static LoadResult newSuccessResult(String str, boolean z, boolean z2) {
            return new LoadResult(str, z, true, z2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LoadResult newFailureResult(String str, boolean z, boolean z2, Throwable th) {
            return new LoadResult(str, z, false, z2, th);
        }

        private LoadResult(String str, boolean z, boolean z2, boolean z3, Throwable th) {
            this.name = str;
            this.absolute = z;
            this.loaded = z2;
            this.usingHelperClassloader = z3;
            this.error = th;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void log() {
            if (this.error != null) {
                NativeLibraryLoader.log("Unable to load the library {0} (using helper classloader={1})", this.name, Boolean.valueOf(this.usingHelperClassloader), this.error);
            } else {
                NativeLibraryLoader.log("Successfully loaded library {0}  (using helper classloader={1})", this.name, Boolean.valueOf(this.usingHelperClassloader));
            }
        }
    }

    private static boolean load(String str, ClassLoader classLoader, List<LoadResult> list) {
        return loadFromWorkdir(str, classLoader, list) || loadLibrary(classLoader, str, false, list);
    }

    private static boolean loadFromWorkdir(String str, ClassLoader classLoader, List<LoadResult> list) {
        String mapLibraryName = System.mapLibraryName(str);
        String str2 = NATIVE_RESOURCE_HOME + mapLibraryName;
        URL resource = classLoader.getResource(str2);
        if (resource == null && HostProperties.isOSX()) {
            resource = str2.endsWith(".jnilib") ? classLoader.getResource("META-INF/native/lib" + str + ".dynlib") : classLoader.getResource("META-INF/native/lib" + str + ".jnilib");
        }
        if (resource == null) {
            return false;
        }
        int lastIndexOf = mapLibraryName.lastIndexOf(46);
        String substring = mapLibraryName.substring(0, lastIndexOf);
        String substring2 = mapLibraryName.substring(lastIndexOf, mapLibraryName.length());
        File file = null;
        try {
            try {
                File createTempFile = Platform.createTempFile(substring, substring2, WORKDIR);
                if (createTempFile.isFile() && createTempFile.canRead() && !Platform.canExecuteExecutable(createTempFile)) {
                    throw new IOException(MessageFormat.format("{0} exists but cannot be executed even when execute permissions set; check volume for \"noexec\" flag; use -D{1}=[path] to set native working directory separately.", createTempFile.getPath(), WORK_DIR_PROPERTY_NAME));
                }
                copyLibrary(resource, createTempFile);
                boolean loadLibrary = loadLibrary(classLoader, createTempFile.getPath(), true, list);
                if (createTempFile != null) {
                    if (!(DELETE_NATIVE_LIB_AFTER_LOADING ? createTempFile.delete() : false)) {
                        createTempFile.deleteOnExit();
                    }
                }
                return loadLibrary;
            } catch (IOException e) {
                list.add(LoadResult.newFailureResult(str, true, false, new UnsatisfiedLinkError(MessageFormat.format("Failed creating temp file ({0})", null)).initCause(e)));
                if (0 != 0) {
                    if (DELETE_NATIVE_LIB_AFTER_LOADING ? file.delete() : false) {
                        return false;
                    }
                    file.deleteOnExit();
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                if (!(DELETE_NATIVE_LIB_AFTER_LOADING ? file.delete() : false)) {
                    file.deleteOnExit();
                }
            }
            throw th;
        }
    }

    private static void copyLibrary(URL url, File file) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream inputStream = null;
        try {
            InputStream openStream = url.openStream();
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            closeQuietly(openStream);
                            closeQuietly(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = openStream;
                    closeQuietly(inputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                inputStream = openStream;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static boolean loadLibrary(ClassLoader classLoader, String str, boolean z, List<LoadResult> list) {
        try {
            LoadResult loadLibraryFromHelperClassloader = loadLibraryFromHelperClassloader(tryToLoadClass(classLoader, NativeLibraryUtil.class), str, z);
            list.add(loadLibraryFromHelperClassloader);
            if (loadLibraryFromHelperClassloader.loaded) {
                return true;
            }
        } catch (Exception e) {
        }
        LoadResult loadLibraryFromCurrentClassloader = loadLibraryFromCurrentClassloader(str, z);
        list.add(loadLibraryFromCurrentClassloader);
        return loadLibraryFromCurrentClassloader.loaded;
    }

    private static LoadResult loadLibraryFromHelperClassloader(final Class<?> cls, final String str, final boolean z) {
        return (LoadResult) AccessController.doPrivileged(new PrivilegedAction<LoadResult>() { // from class: org.conscrypt.NativeLibraryLoader.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.security.PrivilegedAction
            public LoadResult run() {
                try {
                    Method method = cls.getMethod("loadLibrary", String.class, Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(null, str, Boolean.valueOf(z));
                    return LoadResult.newSuccessResult(str, z, true);
                } catch (InvocationTargetException e) {
                    return LoadResult.newFailureResult(str, z, true, e.getCause());
                } catch (Throwable th) {
                    return LoadResult.newFailureResult(str, z, true, th);
                }
            }
        });
    }

    private static LoadResult loadLibraryFromCurrentClassloader(String str, boolean z) {
        try {
            NativeLibraryUtil.loadLibrary(str, z);
            return LoadResult.newSuccessResult(str, z, false);
        } catch (Throwable th) {
            return LoadResult.newFailureResult(str, z, false, th);
        }
    }

    private static Class<?> tryToLoadClass(final ClassLoader classLoader, final Class<?> cls) throws ClassNotFoundException {
        try {
            return classLoader.loadClass(cls.getName());
        } catch (ClassNotFoundException e) {
            final byte[] classToByteArray = classToByteArray(cls);
            return (Class) AccessController.doPrivileged(new PrivilegedAction<Class<?>>() { // from class: org.conscrypt.NativeLibraryLoader.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedAction
                public Class<?> run() {
                    try {
                        Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        return (Class) declaredMethod.invoke(classLoader, cls.getName(), classToByteArray, 0, Integer.valueOf(classToByteArray.length));
                    } catch (Exception e2) {
                        throw new IllegalStateException("Define class failed!", e2);
                    }
                }
            });
        }
    }

    private static byte[] classToByteArray(Class<?> cls) throws ClassNotFoundException {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf > 0) {
            name = name.substring(lastIndexOf + 1);
        }
        URL resource = cls.getResource(name + ".class");
        if (resource == null) {
            throw new ClassNotFoundException(cls.getName());
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        InputStream inputStream = null;
        try {
            try {
                inputStream = resource.openStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        return byteArrayOutputStream.toByteArray();
                    }
                }
            } catch (IOException e) {
                throw new ClassNotFoundException(cls.getName(), e);
            }
        } finally {
            closeQuietly(inputStream);
            closeQuietly(byteArrayOutputStream);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    private NativeLibraryLoader() {
    }

    private static void log(String str, Object obj) {
        logger.log(Level.FINE, str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str, Object obj, Object obj2) {
        logger.log(Level.FINE, str, new Object[]{obj, obj2});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str, Object obj, Object obj2, Throwable th) {
        debug(MessageFormat.format(str, obj, obj2), th);
    }

    private static void debug(String str, Throwable th) {
        logger.log(Level.FINE, str, th);
    }
}
