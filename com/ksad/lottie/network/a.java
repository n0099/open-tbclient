package com.ksad.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.ksad.lottie.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f32239a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32240b;

    public a(Context context, String str) {
        this.f32239a = context.getApplicationContext();
        this.f32240b = str;
    }

    @Nullable
    private File a(String str) {
        File file = new File(this.f32239a.getCacheDir(), a(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f32239a.getCacheDir(), a(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public static String a(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
        return sb.toString();
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> a() {
        try {
            File a2 = a(this.f32240b);
            if (a2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(a2);
            FileExtension fileExtension = a2.getAbsolutePath().endsWith(".zip") ? FileExtension.Zip : FileExtension.Json;
            c.a("Cache hit for " + this.f32240b + " at " + a2.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File a(InputStream inputStream, FileExtension fileExtension) {
        File file = new File(this.f32239a.getCacheDir(), a(this.f32240b, fileExtension, true));
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

    public void a(FileExtension fileExtension) {
        File file = new File(this.f32239a.getCacheDir(), a(this.f32240b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(XAdSimpleImageLoader.TEMP_SUFFIX, ""));
        boolean renameTo = file.renameTo(file2);
        c.a("Copying temp file to real file (" + file2 + SmallTailInfo.EMOTION_SUFFIX);
        if (renameTo) {
            return;
        }
        c.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }
}
