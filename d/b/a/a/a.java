package d.b.a.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f41814a;

    public a(File file) {
        this.f41814a = null;
        this.f41814a = file.getAbsolutePath();
    }

    public boolean a() {
        return b();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0055 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.zip.ZipInputStream] */
    public final boolean b() {
        FileInputStream fileInputStream;
        Exception e2;
        ZipInputStream zipInputStream;
        if (TextUtils.isEmpty(this.f41814a)) {
            return false;
        }
        File file = new File(this.f41814a);
        ?? r2 = 0;
        r2 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                r2 = file;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            e2 = e3;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        try {
                            zipInputStream.close();
                            fileInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        return true;
                    } else if (!nextEntry.isDirectory() && nextEntry.getName().contains(Constants.PATH_PARENT)) {
                        try {
                            zipInputStream.close();
                            fileInputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        return false;
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            return false;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                        return false;
                    }
                    return false;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            zipInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (r2 != 0) {
                try {
                    r2.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                    throw th;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
