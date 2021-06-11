package d.a.l0.e.n.a;

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
public class c extends d.a.l0.e.n.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f50228a = {"_id", Constants.APP_ID, "app_key", "app_sign", "version_code", "version_name", "description", "app_status", "status_detail", "status_desc", "resume_date", "icon_url", "app_name", "service_category", "subject_info", "type", "pkg_size", "app_category", "orientation", "create_time", "app_from", "visit_time"};

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f50229a;

        /* renamed from: b  reason: collision with root package name */
        public String f50230b;

        /* renamed from: c  reason: collision with root package name */
        public long f50231c;

        public b(String str, String str2, long j) {
            this.f50229a = str;
            this.f50230b = str2;
            this.f50231c = j;
        }
    }

    /* renamed from: d.a.l0.e.n.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1023c implements Comparator<b> {
        public C1023c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            return Long.compare(bVar2.f50231c, bVar.f50231c);
        }
    }

    @Override // d.a.l0.e.n.a.a
    @Nullable
    public Cursor c(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        List<b> f2 = f();
        if (f2.isEmpty()) {
            return null;
        }
        HashMap<String, PMSAppInfo> a2 = d.a.l0.e.n.b.a.a();
        if (a2.isEmpty()) {
            return null;
        }
        Collections.sort(f2, new C1023c());
        MatrixCursor matrixCursor = new MatrixCursor(f50228a, f2.size());
        int i2 = 0;
        for (b bVar : f2) {
            PMSAppInfo pMSAppInfo = a2.get(bVar.f50229a);
            if (pMSAppInfo != null) {
                e(matrixCursor, i2, bVar, pMSAppInfo);
                i2++;
            }
        }
        return matrixCursor;
    }

    public final void e(MatrixCursor matrixCursor, int i2, b bVar, PMSAppInfo pMSAppInfo) {
        if (matrixCursor == null || i2 < 0 || bVar == null || pMSAppInfo == null) {
            return;
        }
        matrixCursor.newRow().add("_id", Integer.valueOf(i2)).add(Constants.APP_ID, pMSAppInfo.appId).add("app_key", pMSAppInfo.appKey).add("app_sign", Long.valueOf(pMSAppInfo.appSign)).add("version_code", Long.valueOf(pMSAppInfo.versionCode)).add("version_name", pMSAppInfo.versionName).add("description", pMSAppInfo.description).add("app_status", Integer.valueOf(pMSAppInfo.appStatus)).add("status_detail", pMSAppInfo.statusDetail).add("status_desc", pMSAppInfo.statusDesc).add("resume_date", pMSAppInfo.resumeDate).add("icon_url", pMSAppInfo.iconUrl).add("app_name", pMSAppInfo.appName).add("service_category", pMSAppInfo.serviceCategory).add("subject_info", pMSAppInfo.subjectInfo).add("type", Integer.valueOf(pMSAppInfo.type)).add("pkg_size", Long.valueOf(pMSAppInfo.pkgSize)).add("app_category", Integer.valueOf(pMSAppInfo.appCategory)).add("orientation", Integer.valueOf(pMSAppInfo.i())).add("create_time", Long.valueOf(pMSAppInfo.createTime)).add("app_from", bVar.f50230b).add("visit_time", Long.valueOf(bVar.f50231c));
    }

    public final List<b> f() {
        Cursor n = SwanAppDbControl.f(AppRuntime.getAppContext()).n(null, null, null, null);
        ArrayList arrayList = new ArrayList();
        if (n != null && n.moveToFirst()) {
            int columnIndex = n.getColumnIndex(Constants.APP_ID);
            int columnIndex2 = n.getColumnIndex("app_from");
            int columnIndex3 = n.getColumnIndex("visit_time");
            do {
                arrayList.add(new b(n.getString(columnIndex), n.getString(columnIndex2), n.getLong(columnIndex3)));
            } while (n.moveToNext());
            d.a.l0.t.d.d(n);
            return arrayList;
        }
        d.a.l0.t.d.d(n);
        return arrayList;
    }
}
