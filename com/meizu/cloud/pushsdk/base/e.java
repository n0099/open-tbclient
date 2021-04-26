package com.meizu.cloud.pushsdk.base;

import android.util.Log;
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
/* loaded from: classes6.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public BufferedWriter f35599d;

    /* renamed from: a  reason: collision with root package name */
    public String f35596a = "EncryptionWriter";

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f35597b = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: e  reason: collision with root package name */
    public int f35600e = 7;

    /* renamed from: f  reason: collision with root package name */
    public String f35601f = ".log.txt";

    /* renamed from: c  reason: collision with root package name */
    public d f35598c = new d("lo");

    /* loaded from: classes6.dex */
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
        BufferedWriter bufferedWriter = this.f35599d;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.f35599d.close();
            this.f35599d = null;
        }
    }

    public void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.base.e.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(e.this.f35601f);
            }
        });
        if (listFiles != null || listFiles.length > this.f35600e) {
            Arrays.sort(listFiles, new a());
            for (int i2 = this.f35600e; i2 < listFiles.length; i2++) {
                listFiles[i2].delete();
            }
        }
    }

    public void a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("create " + str + " dir failed!!!");
        }
        String format = this.f35597b.format(new Date());
        File file2 = new File(str, format + this.f35601f);
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                String str2 = this.f35596a;
                Log.e(str2, "create new file " + format + " failed !!!");
            }
        }
        this.f35599d = new BufferedWriter(new FileWriter(file2, true));
    }

    public void a(String str, String str2, String str3) throws IOException {
        if (this.f35599d != null) {
            StringBuffer stringBuffer = new StringBuffer(str);
            stringBuffer.append(str2);
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            this.f35599d.write(this.f35598c.a(stringBuffer.toString().getBytes()));
            this.f35599d.write(Part.CRLF);
        }
    }
}
