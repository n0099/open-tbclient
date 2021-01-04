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
/* loaded from: classes5.dex */
class d {

    /* loaded from: classes5.dex */
    private static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<File> b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new a());
            return asList;
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < currentTimeMillis) {
                com.kwad.sdk.core.d.a.c("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    static void d(File file) {
        long length = file.length();
        if (length == 0) {
            e(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        randomAccessFile.seek(length - 1);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(length - 1);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void e(File file) {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }
}
