package d.a.n0.z0;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f54763a;

    public static synchronized b c() {
        b bVar;
        synchronized (b.class) {
            if (f54763a == null) {
                f54763a = new b();
            }
            bVar = f54763a;
        }
        return bVar;
    }

    public long a(File file, String str) {
        FileOutputStream fileOutputStream;
        long j = 0;
        if (TextUtils.isEmpty(str) || file == null) {
            return 0L;
        }
        InputStream inputStream = null;
        try {
            Response executeSync = HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(str).build().executeSync();
            if (executeSync == null || executeSync.code() != 200) {
                fileOutputStream = null;
            } else {
                InputStream byteStream = executeSync.body().byteStream();
                if (byteStream != null) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        j = FileUtils.copyStream(byteStream, fileOutputStream);
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = byteStream;
                        try {
                            TiebaStatic.log(e.toString());
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(fileOutputStream);
                            return j;
                        } catch (Throwable th2) {
                            th = th2;
                            Closeables.closeSafely(inputStream);
                            Closeables.closeSafely(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = byteStream;
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(fileOutputStream);
                        throw th;
                    }
                } else {
                    fileOutputStream = null;
                }
                inputStream = byteStream;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        Closeables.closeSafely(inputStream);
        Closeables.closeSafely(fileOutputStream);
        return j;
    }

    public String b() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }

    public void d() {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        d.a.c.e.l.d.h().k(b2, 10, null, 0, 0, null, new Object[0]);
    }
}
