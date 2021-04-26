package d.a.h0.g.i0.f;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.utils.so.SoLoader;
import com.baidu.swan.games.utils.so.SoUtils;
import d.a.h0.a.k;
import d.a.h0.a.l;
import d.a.h0.a.z1.c;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes3.dex */
public class c implements SoUtils.a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46418a = k.f43101a;

    public final String a(String str) {
        File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(d.a.h0.a.w0.a.c(), str);
        return String.format(Locale.CHINA, "[%s:%s,size:%d]", str, findSoFilesInLibrary == null ? null : findSoFilesInLibrary.getAbsolutePath(), Long.valueOf(findSoFilesInLibrary == null ? 0L : findSoFilesInLibrary.length()));
    }

    @Override // com.baidu.swan.games.utils.so.SoUtils.a
    public void onEvent(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String[] strArr = {Build.CPU_ABI, Build.CPU_ABI2};
        String str3 = Arrays.toString(strArr) + "\n" + l.a() + "\n" + a("v8.engine") + "\n" + a("zeusv8") + "\n" + str2;
        if (f46418a) {
            Log.d("SoUbcDefaultImpl", "reportSoLoadInfo: " + str3);
        }
        c.b bVar = new c.b(10007);
        bVar.j(str);
        bVar.i(str3);
        bVar.h(d.a.h0.a.r1.e.T());
        bVar.l();
    }
}
