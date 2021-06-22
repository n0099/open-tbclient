package com.win.opensdk;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class Z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ byte[] f40772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40773b;

    public Z0(byte[] bArr, String str) {
        this.f40772a = bArr;
        this.f40773b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        FileOutputStream fileOutputStream;
        byte[] bArr = this.f40772a;
        String str = this.f40773b;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        File file = new File(str);
        String substring = str.substring(0, str.lastIndexOf("/"));
        if (!file.exists()) {
            new File(substring).mkdir();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr2, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }
}
