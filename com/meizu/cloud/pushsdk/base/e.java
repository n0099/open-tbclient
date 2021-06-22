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
/* loaded from: classes7.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public BufferedWriter f38550d;

    /* renamed from: a  reason: collision with root package name */
    public String f38547a = "EncryptionWriter";

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f38548b = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: e  reason: collision with root package name */
    public int f38551e = 7;

    /* renamed from: f  reason: collision with root package name */
    public String f38552f = ".log.txt";

    /* renamed from: c  reason: collision with root package name */
    public d f38549c = new d("lo");

    /* loaded from: classes7.dex */
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
        BufferedWriter bufferedWriter = this.f38550d;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.f38550d.close();
            this.f38550d = null;
        }
    }

    public void a(File file) {
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.meizu.cloud.pushsdk.base.e.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.getName().endsWith(e.this.f38552f);
            }
        });
        if (listFiles != null || listFiles.length > this.f38551e) {
            Arrays.sort(listFiles, new a());
            for (int i2 = this.f38551e; i2 < listFiles.length; i2++) {
                listFiles[i2].delete();
            }
        }
    }

    public void a(String str) throws IOException {
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("create " + str + " dir failed!!!");
        }
        String format = this.f38548b.format(new Date());
        File file2 = new File(str, format + this.f38552f);
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                String str2 = this.f38547a;
                Log.e(str2, "create new file " + format + " failed !!!");
            }
        }
        this.f38550d = new BufferedWriter(new FileWriter(file2, true));
    }

    public void a(String str, String str2, String str3) throws IOException {
        if (this.f38550d != null) {
            StringBuffer stringBuffer = new StringBuffer(str);
            stringBuffer.append(str2);
            stringBuffer.append(" ");
            stringBuffer.append(str3);
            this.f38550d.write(this.f38549c.a(stringBuffer.toString().getBytes()));
            this.f38550d.write(Part.CRLF);
        }
    }
}
