package com.ksad.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.ksad.lottie.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes3.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5406a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str) {
        this.f5406a = context.getApplicationContext();
        this.b = str;
    }

    @Nullable
    private File a(String str) {
        File file = new File(this.f5406a.getCacheDir(), a(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f5406a.getCacheDir(), a(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private static String a(String str, FileExtension fileExtension, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? fileExtension.extension : fileExtension.tempExtension());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> a() {
        try {
            File a2 = a(this.b);
            if (a2 == null) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(a2);
                FileExtension fileExtension = a2.getAbsolutePath().endsWith(".zip") ? FileExtension.Zip : FileExtension.Json;
                c.a("Cache hit for " + this.b + " at " + a2.getAbsolutePath());
                return new Pair<>(fileExtension, fileInputStream);
            } catch (FileNotFoundException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(InputStream inputStream, FileExtension fileExtension) {
        File file = new File(this.f5406a.getCacheDir(), a(this.b, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FileExtension fileExtension) {
        File file = new File(this.f5406a.getCacheDir(), a(this.b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        c.a("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        c.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }
}
