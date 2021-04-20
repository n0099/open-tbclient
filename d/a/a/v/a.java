package d.a.a.v;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.network.FileExtension;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.a.x.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f41731a;

    public a(Context context) {
        this.f41731a = context.getApplicationContext();
    }

    public static String b(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> a(String str) {
        FileExtension fileExtension;
        try {
            File c2 = c(str);
            if (c2 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c2);
            if (c2.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            d.a("Cache hit for " + str + " at " + c2.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public final File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public final File d() {
        File file = new File(this.f41731a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void e(String str, FileExtension fileExtension) {
        File file = new File(d(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(XAdSimpleImageLoader.TEMP_SUFFIX, ""));
        boolean renameTo = file.renameTo(file2);
        d.a("Copying temp file to real file (" + file2 + SmallTailInfo.EMOTION_SUFFIX);
        if (renameTo) {
            return;
        }
        d.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    public File f(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(d(), b(str, fileExtension, true));
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
