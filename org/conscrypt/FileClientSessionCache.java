package org.conscrypt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
/* loaded from: classes8.dex */
public final class FileClientSessionCache {
    public static final int MAX_SIZE = 12;
    private static final Logger logger = Logger.getLogger(FileClientSessionCache.class.getName());
    static final Map<File, Impl> caches = new HashMap();

    private FileClientSessionCache() {
    }

    /* loaded from: classes8.dex */
    static class Impl implements SSLClientSessionCache {
        Map<String, File> accessOrder = newAccessOrder();
        final File directory;
        String[] initialFiles;
        int size;

        Impl(File file) throws IOException {
            boolean exists = file.exists();
            if (exists && !file.isDirectory()) {
                throw new IOException(file + " exists but is not a directory.");
            }
            if (exists) {
                this.initialFiles = file.list();
                if (this.initialFiles == null) {
                    throw new IOException(file + " exists but cannot list contents.");
                }
                Arrays.sort(this.initialFiles);
                this.size = this.initialFiles.length;
            } else if (!file.mkdirs()) {
                throw new IOException("Creation of " + file + " directory failed.");
            } else {
                this.size = 0;
            }
            this.directory = file;
        }

        private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap(12, 0.75f, true);
        }

        private static String fileName(String str, int i) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            return str + "." + i;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:3|4|(3:6|(1:8)(2:12|(1:14)(2:15|16))|9)(1:39)|17|18|19|20|(2:22|23)|9) */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
            logReadError(r7, r2, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
            logReadError(r7, r2, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
            if (r3 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            r3.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
            r0 = null;
         */
        @Override // org.conscrypt.SSLClientSessionCache
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized byte[] getSessionData(String str, int i) {
            File file;
            byte[] bArr;
            String fileName = fileName(str, i);
            File file2 = this.accessOrder.get(fileName);
            if (file2 != null) {
                file = file2;
            } else if (this.initialFiles == null) {
                bArr = null;
            } else if (Arrays.binarySearch(this.initialFiles, fileName) < 0) {
                bArr = null;
            } else {
                File file3 = new File(this.directory, fileName);
                this.accessOrder.put(fileName, file3);
                file = file3;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = new byte[(int) file.length()];
            new DataInputStream(fileInputStream).readFully(bArr);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
            }
            return bArr;
        }

        static void logReadError(String str, File file, Throwable th) {
            FileClientSessionCache.logger.log(Level.WARNING, "FileClientSessionCache: Error reading session data for " + str + " from " + file + ".", th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [239=8, 242=4] */
        @Override // org.conscrypt.SSLClientSessionCache
        public synchronized void putSessionData(SSLSession sSLSession, byte[] bArr) {
            String peerHost = sSLSession.getPeerHost();
            if (bArr == null) {
                throw new NullPointerException("sessionData == null");
            }
            String fileName = fileName(peerHost, sSLSession.getPeerPort());
            File file = new File(this.directory, fileName);
            boolean exists = file.exists();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (!exists) {
                    this.size++;
                    makeRoom();
                }
                try {
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                        this.accessOrder.put(fileName, file);
                    } catch (IOException e) {
                        logWriteError(peerHost, file, e);
                        delete(file);
                    }
                } catch (IOException e2) {
                    logWriteError(peerHost, file, e2);
                    try {
                        fileOutputStream.close();
                        delete(file);
                    } catch (IOException e3) {
                        logWriteError(peerHost, file, e3);
                        delete(file);
                    }
                }
            } catch (FileNotFoundException e4) {
                logWriteError(peerHost, file, e4);
            }
        }

        private void makeRoom() {
            if (this.size > 12) {
                indexFiles();
                int i = this.size - 12;
                Iterator<File> it = this.accessOrder.values().iterator();
                while (true) {
                    delete(it.next());
                    it.remove();
                    i--;
                    if (i <= 0) {
                        return;
                    }
                }
            }
        }

        private void indexFiles() {
            String[] strArr = this.initialFiles;
            if (strArr != null) {
                this.initialFiles = null;
                TreeSet<CacheFile> treeSet = new TreeSet();
                for (String str : strArr) {
                    if (!this.accessOrder.containsKey(str)) {
                        treeSet.add(new CacheFile(this.directory, str));
                    }
                }
                if (!treeSet.isEmpty()) {
                    Map<String, File> newAccessOrder = newAccessOrder();
                    for (CacheFile cacheFile : treeSet) {
                        newAccessOrder.put(cacheFile.name, cacheFile);
                    }
                    newAccessOrder.putAll(this.accessOrder);
                    this.accessOrder = newAccessOrder;
                }
            }
        }

        private void delete(File file) {
            if (!file.delete()) {
                IOException iOException = new IOException("FileClientSessionCache: Failed to delete " + file + ".");
                FileClientSessionCache.logger.log(Level.WARNING, iOException.getMessage(), (Throwable) iOException);
            }
            this.size--;
        }

        static void logWriteError(String str, File file, Throwable th) {
            FileClientSessionCache.logger.log(Level.WARNING, "FileClientSessionCache: Error writing session data for " + str + " to " + file + ".", th);
        }
    }

    public static synchronized SSLClientSessionCache usingDirectory(File file) throws IOException {
        Impl impl;
        synchronized (FileClientSessionCache.class) {
            impl = caches.get(file);
            if (impl == null) {
                impl = new Impl(file);
                caches.put(file, impl);
            }
        }
        return impl;
    }

    static synchronized void reset() {
        synchronized (FileClientSessionCache.class) {
            caches.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class CacheFile extends File {
        long lastModified;
        final String name;

        CacheFile(File file, String str) {
            super(file, str);
            this.lastModified = -1L;
            this.name = str;
        }

        @Override // java.io.File
        public long lastModified() {
            long j = this.lastModified;
            if (j == -1) {
                long lastModified = super.lastModified();
                this.lastModified = lastModified;
                return lastModified;
            }
            return j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.Comparable
        public int compareTo(File file) {
            long lastModified = lastModified() - file.lastModified();
            if (lastModified == 0) {
                return super.compareTo(file);
            }
            return lastModified < 0 ? -1 : 1;
        }
    }
}
