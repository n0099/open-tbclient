package d.a.a.t;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f41420a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41421b;

    public a(Context context, String str) {
        this.f41420a = context.getApplicationContext();
        this.f41421b = str;
    }

    public static String b(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
        return sb.toString();
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> a() {
        FileExtension fileExtension;
        try {
            File c2 = c(this.f41421b);
            if (c2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c2);
            if (c2.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.Zip;
            } else {
                fileExtension = FileExtension.Json;
            }
            c.b("Cache hit for " + this.f41421b + " at " + c2.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public final File c(String str) throws FileNotFoundException {
        File file = new File(this.f41420a.getCacheDir(), b(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.f41420a.getCacheDir(), b(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public void d(FileExtension fileExtension) {
        File file = new File(this.f41420a.getCacheDir(), b(this.f41421b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        c.b("Copying temp file to real file (" + file2 + SmallTailInfo.EMOTION_SUFFIX);
        if (renameTo) {
            return;
        }
        c.d("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    public File e(InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(this.f41420a.getCacheDir(), b(this.f41421b, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
