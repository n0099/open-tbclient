package com.meizu.cloud.pushsdk.base;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e {
    private BufferedWriter d;

    /* renamed from: a  reason: collision with root package name */
    private String f11538a = "EncryptionWriter";

    /* renamed from: b  reason: collision with root package name */
    private SimpleDateFormat f11539b = new SimpleDateFormat("yyyy-MM-dd");
    private int e = 7;
    private String f = ".log.txt";
    private d c = new d("lo");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Comparator<File> {
        a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return -1;
            }
            return lastModified == 0 ? 0 : 1;
        }
    }

    public void a() throws IOException {
        if (this.d != null) {
            this.d.flush();
            this.d.close();
            this.d = null;
        }
    }

    void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.base.e.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(e.this.f);
            }
        });
        if (listFiles != null || listFiles.length > this.e) {
            Arrays.sort(listFiles, new a());
            for (int i = this.e; i < listFiles.length; i++) {
                listFiles[i].delete();
            }
        }
    }

    public void a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("create " + str + " dir failed!!!");
        }
        String format = this.f11539b.format(new Date());
        File file2 = new File(str, format + this.f);
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                Log.e(this.f11538a, "create new file " + format + " failed !!!");
            }
        }
        this.d = new BufferedWriter(new FileWriter(file2, true));
    }

    public void a(String str, String str2, String str3) throws IOException {
        if (this.d != null) {
            StringBuffer stringBuffer = new StringBuffer(str);
            stringBuffer.append(str2);
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            this.d.write(this.c.a(stringBuffer.toString().getBytes()));
            this.d.write("\r\n");
        }
    }
}
