package d.a.i0.e.n.a;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends d.a.i0.e.n.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f46375a = {"_id", Constants.APP_ID, "app_key", "app_sign", "version_code", "version_name", "description", "app_status", "status_detail", "status_desc", "resume_date", "icon_url", "app_name", "service_category", "subject_info", "type", "pkg_size", "app_category", "orientation", "create_time", "favorite_time"};

    /* renamed from: d.a.i0.e.n.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0955b implements Comparator<c> {
        public C0955b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return Long.compare(cVar2.f46377b, cVar.f46377b);
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public String f46376a;

        /* renamed from: b  reason: collision with root package name */
        public long f46377b;

        public c(b bVar, String str, long j) {
            this.f46376a = str;
            this.f46377b = j;
        }
    }

    @Override // d.a.i0.e.n.a.a
    @Nullable
    public Cursor c(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        List<c> f2 = f();
        if (f2.isEmpty()) {
            return null;
        }
        HashMap<String, PMSAppInfo> a2 = d.a.i0.e.n.b.a.a();
        if (a2.isEmpty()) {
            return null;
        }
        Collections.sort(f2, new C0955b());
        MatrixCursor matrixCursor = new MatrixCursor(f46375a, f2.size());
        int i2 = 0;
        for (c cVar : f2) {
            PMSAppInfo pMSAppInfo = a2.get(cVar.f46376a);
            if (pMSAppInfo != null) {
                e(matrixCursor, i2, cVar, pMSAppInfo);
                i2++;
            }
        }
        return matrixCursor;
    }

    public final void e(MatrixCursor matrixCursor, int i2, c cVar, PMSAppInfo pMSAppInfo) {
        if (matrixCursor == null || i2 < 0 || cVar == null || pMSAppInfo == null) {
            return;
        }
        matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(Constants.APP_ID, pMSAppInfo.appId).add("app_key", pMSAppInfo.appKey).add("app_sign", Long.valueOf(pMSAppInfo.appSign)).add("version_code", Long.valueOf(pMSAppInfo.versionCode)).add("version_name", pMSAppInfo.versionName).add("description", pMSAppInfo.description).add("app_status", Integer.valueOf(pMSAppInfo.appStatus)).add("status_detail", pMSAppInfo.statusDetail).add("status_desc", pMSAppInfo.statusDesc).add("resume_date", pMSAppInfo.resumeDate).add("icon_url", pMSAppInfo.iconUrl).add("app_name", pMSAppInfo.appName).add("service_category", pMSAppInfo.serviceCategory).add("subject_info", pMSAppInfo.subjectInfo).add("type", Integer.valueOf(pMSAppInfo.type)).add("pkg_size", Long.valueOf(pMSAppInfo.pkgSize)).add("app_category", Integer.valueOf(pMSAppInfo.appCategory)).add("orientation", Integer.valueOf(pMSAppInfo.i())).add("create_time", Long.valueOf(pMSAppInfo.createTime)).add("favorite_time", Long.valueOf(cVar.f46377b));
    }

    public final List<c> f() {
        Cursor l = SwanAppDbControl.f(AppRuntime.getAppContext()).l(null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (l != null && l.moveToFirst()) {
            int columnIndex = l.getColumnIndex(Constants.APP_ID);
            int columnIndex2 = l.getColumnIndex("favorite_time");
            do {
                arrayList.add(new c(this, l.getString(columnIndex), l.getLong(columnIndex2)));
            } while (l.moveToNext());
            d.a.i0.t.d.d(l);
            return arrayList;
        }
        d.a.i0.t.d.d(l);
        return arrayList;
    }
}
