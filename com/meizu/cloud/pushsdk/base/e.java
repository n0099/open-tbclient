package com.meizu.cloud.pushsdk.base;

import com.android.internal.http.multipart.Part;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
/* loaded from: classes10.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public BufferedWriter f75057d;

    /* renamed from: a  reason: collision with root package name */
    public String f75054a = "EncryptionWriter";

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f75055b = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: e  reason: collision with root package name */
    public int f75058e = 7;

    /* renamed from: f  reason: collision with root package name */
    public String f75059f = ".log.txt";

    /* renamed from: c  reason: collision with root package name */
    public d f75056c = new d("lo");

    /* loaded from: classes10.dex */
    public class a implements Comparator<File> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            int i2 = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
            if (i2 > 0) {
                return -1;
            }
            return i2 == 0 ? 0 : 1;
        }
    }

    public void a() throws IOException {
        BufferedWriter bufferedWriter = this.f75057d;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.f75057d.close();
            this.f75057d = null;
        }
    }

    public void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.base.e.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(e.this.f75059f);
            }
        });
        if (listFiles != null || listFiles.length > this.f75058e) {
            Arrays.sort(listFiles, new a());
            for (int i2 = this.f75058e; i2 < listFiles.length; i2++) {
                listFiles[i2].delete();
            }
        }
    }

    public void a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("create " + str + " dir failed!!!");
        }
        String format = this.f75055b.format(new Date());
        File file2 = new File(str, format + this.f75059f);
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                String str2 = "create new file " + format + " failed !!!";
            }
        }
        this.f75057d = new BufferedWriter(new FileWriter(file2, true));
    }

    public void a(String str, String str2, String str3) throws IOException {
        if (this.f75057d != null) {
            StringBuffer stringBuffer = new StringBuffer(str);
            stringBuffer.append(str2);
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            this.f75057d.write(this.f75056c.a(stringBuffer.toString().getBytes()));
            this.f75057d.write(Part.CRLF);
        }
    }
}
