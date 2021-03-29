package d.b.g0.l.i;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.tencent.connect.common.Constants;
import d.b.g0.l.f;
import d.b.g0.l.i.c.c;
import d.b.g0.l.k.d;
import d.b.g0.l.k.e;
import d.b.g0.l.k.g;
import d.b.g0.l.k.h;
import d.b.g0.l.k.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public c f48891b = new c();

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0029 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public final <T> List<T> A(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        ?? r0 = 0;
        try {
            try {
                d.b.g0.l.i.c.b<T> a2 = this.f48891b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        List<T> e2 = a2.e(cursor);
                        d.b.g0.l.r.c.a(cursor);
                        return e2;
                    } catch (Exception e3) {
                        e = e3;
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r0 = cls;
                d.b.g0.l.r.c.a(r0);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.l.r.c.a(r0);
            throw th;
        }
        d.b.g0.l.r.c.a(cursor);
        return null;
    }

    @Override // d.b.g0.l.i.a
    public boolean a(d.b.g0.l.k.f fVar, PMSAppInfo pMSAppInfo) {
        return b(fVar, null, null, null, pMSAppInfo);
    }

    @Override // d.b.g0.l.i.a
    public boolean b(d.b.g0.l.k.f fVar, List<g> list, d dVar, d.b.g0.l.k.b bVar, PMSAppInfo pMSAppInfo) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (fVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f48891b.b(d.b.g0.l.k.f.class)).withValues(this.f48891b.a(d.b.g0.l.k.f.class).c(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            d.b.g0.l.i.c.b a2 = this.f48891b.a(g.class);
            for (g gVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.f48891b.b(g.class)).withValues(a2.c(gVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f48891b.b(d.class)).withValues(this.f48891b.a(d.class).c(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f48891b.b(d.b.g0.l.k.b.class)).withValues(this.f48891b.a(d.b.g0.l.k.b.class).c(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f48891b.b(PMSAppInfo.class)).withValues(this.f48891b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
        }
        try {
            ContentProviderResult[] applyBatch = AppRuntime.getAppContext().getContentResolver().applyBatch(d.b.g0.l.i.e.b.f48898b, arrayList);
            if (applyBatch == null) {
                return false;
            }
            for (ContentProviderResult contentProviderResult : applyBatch) {
                if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // d.b.g0.l.i.a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f48891b.b(g.class), "app_id=?", new String[]{str});
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.g0.l.i.a
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f48891b.b(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.g0.l.i.a
    public <T extends e> boolean e(Class<T> cls, String str) {
        try {
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().delete(this.f48891b.b(cls), "bundle_id =? ", new String[]{str}) > 0;
    }

    @Override // d.b.g0.l.i.a
    public boolean f(h hVar) {
        try {
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().delete(this.f48891b.b(hVar.getClass()), "bundle_id = ?  and version_name =? ", new String[]{hVar.f48923g, hVar.j}) > 0;
    }

    @Override // d.b.g0.l.i.a
    public boolean g(String str) {
        try {
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().delete(this.f48891b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0;
    }

    @Override // d.b.g0.l.i.a
    @WorkerThread
    public int i(@NonNull String str) {
        Cursor cursor = null;
        int i = -1;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(g.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                if (cursor != null && cursor.moveToFirst()) {
                    i = cursor.getInt(0);
                }
            } catch (Exception e2) {
                if (f.f48889a) {
                    e2.printStackTrace();
                }
            }
            return i;
        } finally {
            d.b.g0.l.r.c.a(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // d.b.g0.l.i.a
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<g> j(@NonNull String str, int i) {
        Cursor cursor;
        String str2;
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        List<g> list = null;
        try {
            if (i >= 0) {
                str2 = "app_id=? and version_code=?";
            } else {
                str2 = "app_id=? and version_code>?";
            }
            Uri b2 = this.f48891b.b(g.class);
            d.b.g0.l.i.c.b a2 = this.f48891b.a(g.class);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(b2, null, str2, new String[]{str, String.valueOf(i)}, null);
            if (query != null && a2 != null) {
                try {
                    list = a2.e(query);
                } catch (Exception e2) {
                    cursor = query;
                    e = e2;
                    try {
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        if (list != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.b.g0.l.r.c.a(cursor2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor2 = query;
                    th = th2;
                    d.b.g0.l.r.c.a(cursor2);
                    throw th;
                }
            }
            d.b.g0.l.r.c.a(query);
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return list != null ? Collections.emptyList() : list;
    }

    @Override // d.b.g0.l.i.a
    public boolean k(PMSAppInfo pMSAppInfo) {
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f48891b.b(pMSAppInfo.getClass()), this.f48891b.a(pMSAppInfo.getClass()).c(pMSAppInfo));
            if (insert != null) {
                return ContentUris.parseId(insert) > 0;
            }
            return false;
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // d.b.g0.l.i.a
    public <T extends e> boolean l(T t) {
        return w(t);
    }

    @Override // d.b.g0.l.i.a
    public boolean m(String str, String str2, String str3) {
        Cursor cursor = null;
        try {
            try {
                Uri b2 = this.f48891b.b(g.class);
                d.b.g0.l.i.c.b a2 = this.f48891b.a(g.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(b2, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                if (cursor != null) {
                    return a2.d(cursor) != null;
                }
            } catch (Exception e2) {
                if (f.f48889a) {
                    e2.printStackTrace();
                }
            }
            return false;
        } finally {
            d.b.g0.l.r.c.a(cursor);
        }
    }

    @Override // d.b.g0.l.i.a
    public <T extends e> T n(Class<T> cls, String str) {
        return (T) z(cls, str);
    }

    @Override // d.b.g0.l.i.a
    public Map<String, d.b.g0.l.k.f> o() {
        HashMap hashMap = new HashMap();
        List<d.b.g0.l.k.f> A = A(d.b.g0.l.k.f.class, "state =? ", new String[]{Constants.VIA_REPORT_TYPE_SHARE_TO_QQ}, "version_code ASC");
        if (A != null && A.size() > 0) {
            for (d.b.g0.l.k.f fVar : A) {
                if (fVar != null) {
                    hashMap.put(fVar.f48923g, fVar);
                }
            }
        }
        return hashMap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    @Override // d.b.g0.l.i.a
    public h p(String str, String str2) {
        Cursor cursor;
        ?? r1 = 0;
        try {
            try {
                d.b.g0.l.i.c.b a2 = this.f48891b.a(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(h.class), null, "bundle_id = ?  and version_name =? ", new String[]{str, str2}, null);
                if (cursor != null) {
                    try {
                        h hVar = (h) a2.d(cursor);
                        d.b.g0.l.r.c.a(cursor);
                        return hVar;
                    } catch (Exception e2) {
                        e = e2;
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = str;
                d.b.g0.l.r.c.a(r1);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.l.r.c.a(r1);
            throw th;
        }
        d.b.g0.l.r.c.a(cursor);
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    @Override // d.b.g0.l.i.a
    @Nullable
    public i q(String str) {
        Cursor cursor;
        ?? r1 = 0;
        try {
            try {
                d.b.g0.l.i.c.b a2 = this.f48891b.a(i.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(i.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        i iVar = (i) a2.d(cursor);
                        d.b.g0.l.r.c.a(cursor);
                        return iVar;
                    } catch (Exception e2) {
                        e = e2;
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = str;
                d.b.g0.l.r.c.a(r1);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.l.r.c.a(r1);
            throw th;
        }
        d.b.g0.l.r.c.a(cursor);
        return null;
    }

    @Override // d.b.g0.l.i.a
    public PMSAppInfo r(String str) {
        return x(str);
    }

    @Override // d.b.g0.l.i.a
    public Map<String, PMSAppInfo> s() {
        HashMap hashMap = new HashMap();
        List<PMSAppInfo> y = y(PMSAppInfo.class, null, null, null);
        if (y != null && y.size() > 0) {
            for (PMSAppInfo pMSAppInfo : y) {
                if (pMSAppInfo != null) {
                    hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                }
            }
        }
        return hashMap;
    }

    @Override // d.b.g0.l.i.a
    public boolean t(h hVar) {
        try {
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().update(this.f48891b.b(hVar.getClass()), this.f48891b.a(hVar.getClass()).c(hVar), "bundle_id = ?  and version_name =? ", new String[]{hVar.f48923g, hVar.j}) > 0;
    }

    @Override // d.b.g0.l.i.a
    public boolean u(PMSAppInfo pMSAppInfo) {
        try {
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().update(this.f48891b.b(pMSAppInfo.getClass()), this.f48891b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0;
    }

    @Override // d.b.g0.l.i.a
    public boolean v(String str, int i) {
        Uri b2;
        ContentValues contentValues;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            b2 = this.f48891b.b(PMSAppInfo.class);
            contentValues = new ContentValues();
            contentValues.put("pending_err_code", Integer.valueOf(i));
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().update(b2, contentValues, "app_id =? ", new String[]{str}) > 0;
    }

    public final <T extends e> boolean w(T t) {
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f48891b.b(t.getClass()), this.f48891b.a(t.getClass()).c(t));
            if (insert != null) {
                return ContentUris.parseId(insert) > 0;
            }
            return false;
        } catch (Exception e2) {
            if (f.f48889a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0048 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.io.Closeable] */
    public final PMSAppInfo x(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                d.b.g0.l.i.c.b a2 = this.f48891b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) a2.d(cursor);
                        d.b.g0.l.r.c.a(cursor);
                        return pMSAppInfo;
                    } catch (Exception e2) {
                        e = e2;
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                d.b.g0.l.r.c.a(str);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            d.b.g0.l.r.c.a(str);
            throw th;
        }
        d.b.g0.l.r.c.a(cursor);
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0029 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public final <T> List<T> y(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        ?? r0 = 0;
        try {
            try {
                d.b.g0.l.i.c.b<T> a2 = this.f48891b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        List<T> e2 = a2.e(cursor);
                        d.b.g0.l.r.c.a(cursor);
                        return e2;
                    } catch (Exception e3) {
                        e = e3;
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r0 = cls;
                d.b.g0.l.r.c.a(r0);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.l.r.c.a(r0);
            throw th;
        }
        d.b.g0.l.r.c.a(cursor);
        return null;
    }

    public final <T> T z(Class<T> cls, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            d.b.g0.l.i.c.b<T> a2 = this.f48891b.a(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.f48891b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
            if (cursor != null) {
                try {
                    try {
                        T d2 = a2.d(cursor);
                        d.b.g0.l.r.c.a(cursor);
                        return d2;
                    } catch (Exception e2) {
                        e = e2;
                        if (f.f48889a) {
                            e.printStackTrace();
                        }
                        d.b.g0.l.r.c.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.b.g0.l.r.c.a(cursor2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.l.r.c.a(cursor2);
            throw th;
        }
        d.b.g0.l.r.c.a(cursor);
        return null;
    }
}
