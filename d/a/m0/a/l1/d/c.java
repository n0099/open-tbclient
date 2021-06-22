package d.a.m0.a.l1.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.a1.e;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
import d.a.m0.n.h.f;
import d.a.m0.n.h.g;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47156a = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && TextUtils.isDigitsOnly(file.getName());
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(e.g(), str);
        if (file.exists()) {
            if (f47156a) {
                Log.d("PkgInfoExt", "clear all pkg info's ext ,appId - " + str);
            }
            File[] listFiles = file.listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                b(str, file2.getName());
            }
        }
    }

    public static void b(String str, String str2) {
        String e2 = e(str, str2);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        h.a().edit().remove(e2).apply();
        if (f47156a) {
            Log.d("PkgInfoExt", "clear pkg info's ext , appId - " + str + ", version code - " + str2);
        }
    }

    public static String c(PMSAppInfo pMSAppInfo) {
        return d(pMSAppInfo.appId, pMSAppInfo.versionCode);
    }

    public static String d(String str, long j) {
        return e(str, String.valueOf(j));
    }

    public static String e(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return str + "_" + str2 + "_pkg_info_ext";
        } else if (f47156a) {
            Log.e("PkgInfoExt", "appId or version code is empty");
            Log.d("PkgInfoExt", "appId - " + str);
            Log.d("PkgInfoExt", "version code - " + str2);
            return null;
        } else {
            return null;
        }
    }

    public static String f(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo == null) {
            return "";
        }
        String c2 = c(pMSAppInfo);
        if (TextUtils.isEmpty(c2)) {
            return "";
        }
        String string = h.a().getString(c2, "");
        if (f47156a) {
            Log.d("PkgInfoExt", "appId - " + pMSAppInfo.appId + ", get pkg info' ext - " + string);
        }
        return string;
    }

    public static void g(String str, JSONObject jSONObject, f fVar, List<g> list) {
        long j;
        if (jSONObject == null) {
            if (f47156a) {
                Log.d("PkgInfoExt", "pkgObject from pms is null");
            }
        } else if (fVar == null && list == null) {
            if (f47156a) {
                Log.d("PkgInfoExt", "pkg info's ext must has at lest one main or sub pkg");
            }
        } else {
            String str2 = null;
            if (fVar != null) {
                str = fVar.f51794g;
                j = fVar.f51796i;
                str2 = fVar.p;
            } else if (list.size() > 0) {
                g gVar = list.get(0);
                j = gVar.f51796i;
                str2 = gVar.s;
            } else {
                j = -1;
            }
            if (str2 == null) {
                if (f47156a) {
                    Log.e("PkgInfoExt", "can not get ext from pkg ");
                }
            } else if (!TextUtils.isEmpty(str) && j != -1) {
                h.a().edit().putString(d(str, j), str2).apply();
            } else if (f47156a) {
                Log.e("PkgInfoExt", "can not get appId and version code from pkg ");
            }
        }
    }
}
