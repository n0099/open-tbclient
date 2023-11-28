package com.kwad.sdk.core.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public final class d {

    /* loaded from: classes10.dex */
    public static final class a implements Comparator<File> {
        public static int compareLong(long j, long j2) {
            int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i == 0 ? 0 : 1;
        }

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }
    }

    public static void u(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (file.mkdirs()) {
        } else {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static void w(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!file.setLastModified(currentTimeMillis)) {
                x(file);
                if (file.lastModified() < currentTimeMillis) {
                    com.kwad.sdk.core.e.c.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
                }
            }
        }
    }

    public static void x(File file) {
        RandomAccessFile randomAccessFile;
        long j;
        long length = file.length();
        if (length == 0) {
            y(file);
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rwd");
                j = length - 1;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            randomAccessFile.seek(j);
            byte readByte = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(readByte);
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
        } catch (IOException e2) {
            e = e2;
            randomAccessFile2 = randomAccessFile;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
            throw th;
        }
    }

    public static List<File> v(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new a((byte) 0));
            return asList;
        }
        return linkedList;
    }

    public static void y(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
