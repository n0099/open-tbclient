package d.b.b.e.a;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41579a = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: b  reason: collision with root package name */
    public String f41580b = this.f41579a + "/baidu/";

    /* renamed from: c  reason: collision with root package name */
    public String f41581c;

    /* renamed from: d  reason: collision with root package name */
    public String f41582d;

    public b() {
        this.f41581c = null;
        this.f41582d = null;
        try {
            this.f41581c = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.f41582d = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public String a(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        String str3;
        if (z2) {
            if (!b()) {
                return null;
            }
            if (str != null) {
                str3 = this.f41580b + str + "/";
            } else {
                str3 = this.f41580b;
            }
        } else if (z3) {
            str2 = this.f41582d;
            if (str2 == null) {
                return null;
            }
            if (str != null) {
                str3 = this.f41582d + str + "/";
            }
            str3 = str2;
        } else {
            str2 = this.f41581c;
            if (str2 == null) {
                return null;
            }
            if (str != null) {
                str3 = this.f41581c + str + "/";
            }
            str3 = str2;
        }
        File file = new File(str3);
        if (file.exists()) {
            return str3;
        }
        if (z && file.mkdirs()) {
            return str3;
        }
        return null;
    }

    public boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public File c(String str, String str2, boolean z, boolean z2, boolean z3) {
        String a2;
        if (str2 == null || (a2 = a(str, z, z2, z3)) == null) {
            return null;
        }
        return new File(a2 + str2);
    }

    public File d(String str, boolean z, boolean z2, boolean z3) {
        String a2 = a(str, z, z2, z3);
        if (a2 == null) {
            return null;
        }
        return new File(a2);
    }

    public void e(String str) {
        if (str == null) {
            return;
        }
        this.f41580b = this.f41579a + "/" + str + "/";
    }
}
