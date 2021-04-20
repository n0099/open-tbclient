package d.b.h0.r.g0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.e.p.f;
import d.b.c.e.p.o;
import java.io.File;
/* loaded from: classes3.dex */
public class a {
    public static boolean a(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }

    public static String b(String str) {
        return FileHelper.getStoreFile(str, 1);
    }

    public static String c(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String d(String str) {
        return f.u(c(str));
    }

    public static String e() {
        return o.a();
    }
}
