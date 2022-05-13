package com.meizu.cloud.pushsdk.handler.a.a;

import android.os.Environment;
import com.baidu.mobstat.Config;
import com.repackage.tl9;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes5.dex */
public class b {
    public File a;

    public b(String str) {
        this.a = new File(str);
    }

    private void a(File file, ZipOutputStream zipOutputStream, String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String sb2 = sb.toString();
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2, zipOutputStream, sb2);
            }
            return;
        }
        tl9.d("ZipTask", "current file " + sb2 + "/" + file.getName() + " size is " + (file.length() / 1024) + "KB");
        if (file.length() >= Config.FULL_TRACE_LOG_LIMIT) {
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(sb2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    private void a(Collection<File> collection, File file) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            a(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public boolean a(List<String> list) throws Exception {
        if (!this.a.exists()) {
            this.a.getParentFile().mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(absolutePath + it.next());
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        a(arrayList, this.a);
        return true;
    }
}
