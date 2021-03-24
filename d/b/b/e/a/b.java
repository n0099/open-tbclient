package d.b.b.e.a;

import android.os.Environment;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41578a = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: b  reason: collision with root package name */
    public String f41579b = this.f41578a + "/baidu/";

    /* renamed from: c  reason: collision with root package name */
    public String f41580c;

    /* renamed from: d  reason: collision with root package name */
    public String f41581d;

    public b() {
        this.f41580c = null;
        this.f41581d = null;
        try {
            this.f41580c = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.f41581d = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
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
                str3 = this.f41579b + str + "/";
            } else {
                str3 = this.f41579b;
            }
        } else if (z3) {
            str2 = this.f41581d;
            if (str2 == null) {
                return null;
            }
            if (str != null) {
                str3 = this.f41581d + str + "/";
            }
            str3 = str2;
        } else {
            str2 = this.f41580c;
            if (str2 == null) {
                return null;
            }
            if (str != null) {
                str3 = this.f41580c + str + "/";
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
        this.f41579b = this.f41578a + "/" + str + "/";
    }
}
