package d.a.m0.n.g;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.n.g.c.c;
import d.a.m0.n.h.d;
import d.a.m0.n.h.e;
import d.a.m0.n.h.f;
import d.a.m0.n.h.g;
import d.a.m0.n.h.h;
import d.a.m0.n.h.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public c f51768b = new c();

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
                d.a.m0.n.g.c.b<T> a2 = this.f51768b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        List<T> e2 = a2.e(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return e2;
                    } catch (Exception e3) {
                        e = e3;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r0 = cls;
                d.a.m0.n.o.c.a(r0);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.n.o.c.a(r0);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }

    public final <T> T B(Class<T> cls, String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            d.a.m0.n.g.c.b<T> a2 = this.f51768b.a(cls);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
            if (cursor != null) {
                try {
                    try {
                        T d2 = a2.d(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return d2;
                    } catch (Exception e2) {
                        e = e2;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.a.m0.n.o.c.a(cursor2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.n.o.c.a(cursor2);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0029 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public final <T> List<T> C(Class<T> cls, String str, String[] strArr, String str2) {
        Cursor cursor;
        ?? r0 = 0;
        try {
            try {
                d.a.m0.n.g.c.b<T> a2 = this.f51768b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        List<T> e2 = a2.e(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return e2;
                    } catch (Exception e3) {
                        e = e3;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r0 = cls;
                d.a.m0.n.o.c.a(r0);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.n.o.c.a(r0);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }

    @Override // d.a.m0.n.g.a
    public boolean a(f fVar, PMSAppInfo pMSAppInfo) {
        return b(fVar, null, null, null, pMSAppInfo);
    }

    @Override // d.a.m0.n.g.a
    public boolean b(f fVar, List<g> list, d dVar, d.a.m0.n.h.b bVar, PMSAppInfo pMSAppInfo) {
        ContentProviderResult[] applyBatch;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (fVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f51768b.b(f.class)).withValues(this.f51768b.a(f.class).c(fVar)).build());
        }
        if (list != null && !list.isEmpty()) {
            d.a.m0.n.g.c.b a2 = this.f51768b.a(g.class);
            for (g gVar : list) {
                arrayList.add(ContentProviderOperation.newInsert(this.f51768b.b(g.class)).withValues(a2.c(gVar)).build());
            }
        }
        if (dVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f51768b.b(d.class)).withValues(this.f51768b.a(d.class).c(dVar)).build());
        }
        if (bVar != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f51768b.b(d.a.m0.n.h.b.class)).withValues(this.f51768b.a(d.a.m0.n.h.b.class).c(bVar)).build());
        }
        if (pMSAppInfo != null) {
            arrayList.add(ContentProviderOperation.newInsert(this.f51768b.b(PMSAppInfo.class)).withValues(this.f51768b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
        }
        try {
            for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(d.a.m0.n.g.e.b.f51775b, arrayList)) {
                if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    @Override // d.a.m0.n.g.a
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f51768b.b(g.class), "app_id=?", new String[]{str});
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.m0.n.g.a
    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f51768b.b(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.m0.n.g.a
    public <T extends e> boolean e(Class<T> cls, String str) {
        try {
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().delete(this.f51768b.b(cls), "bundle_id =? ", new String[]{str}) > 0;
    }

    @Override // d.a.m0.n.g.a
    public boolean f(@NonNull h hVar) {
        Uri b2;
        String str;
        String[] strArr;
        try {
            b2 = this.f51768b.b(hVar.getClass());
            if (hVar.f51796i >= 0) {
                str = "bundle_id = ?  and version_code < ? ";
                strArr = new String[]{hVar.f51794g, String.valueOf(hVar.f51796i)};
            } else {
                str = "bundle_id = ? ";
                strArr = new String[]{hVar.f51794g};
            }
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().delete(b2, str, strArr) > 0;
    }

    @Override // d.a.m0.n.g.a
    public boolean g(String str) {
        try {
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().delete(this.f51768b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0;
    }

    @Override // d.a.m0.n.g.a
    @WorkerThread
    public int i(@NonNull String str) {
        Cursor cursor = null;
        int i2 = -1;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(g.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                if (cursor != null && cursor.moveToFirst()) {
                    i2 = cursor.getInt(0);
                }
            } catch (Exception e2) {
                if (d.a.m0.n.c.f51766a) {
                    e2.printStackTrace();
                }
            }
            return i2;
        } finally {
            d.a.m0.n.o.c.a(cursor);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // d.a.m0.n.g.a
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<g> j(@NonNull String str, int i2) {
        Cursor cursor;
        String str2;
        Cursor cursor2 = null;
        r1 = null;
        r1 = null;
        List<g> list = null;
        try {
            if (i2 >= 0) {
                str2 = "app_id=? and version_code=?";
            } else {
                str2 = "app_id=? and version_code>?";
            }
            Uri b2 = this.f51768b.b(g.class);
            d.a.m0.n.g.c.b a2 = this.f51768b.a(g.class);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(b2, null, str2, new String[]{str, String.valueOf(i2)}, null);
            if (query != null && a2 != null) {
                try {
                    list = a2.e(query);
                } catch (Exception e2) {
                    cursor = query;
                    e = e2;
                    try {
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        if (list != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.m0.n.o.c.a(cursor2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor2 = query;
                    th = th2;
                    d.a.m0.n.o.c.a(cursor2);
                    throw th;
                }
            }
            d.a.m0.n.o.c.a(query);
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return list != null ? Collections.emptyList() : list;
    }

    @Override // d.a.m0.n.g.a
    public boolean k(PMSAppInfo pMSAppInfo) {
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f51768b.b(pMSAppInfo.getClass()), this.f51768b.a(pMSAppInfo.getClass()).c(pMSAppInfo));
            if (insert != null) {
                return ContentUris.parseId(insert) > 0;
            }
            return false;
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    @Override // d.a.m0.n.g.a
    public <T extends e> boolean l(T t) {
        return y(t);
    }

    @Override // d.a.m0.n.g.a
    public boolean m(String str, String str2, String str3) {
        Cursor cursor = null;
        try {
            try {
                Uri b2 = this.f51768b.b(g.class);
                d.a.m0.n.g.c.b a2 = this.f51768b.a(g.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(b2, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                if (cursor != null) {
                    return a2.d(cursor) != null;
                }
            } catch (Exception e2) {
                if (d.a.m0.n.c.f51766a) {
                    e2.printStackTrace();
                }
            }
            return false;
        } finally {
            d.a.m0.n.o.c.a(cursor);
        }
    }

    @Override // d.a.m0.n.g.a
    public List<h> n(int i2) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th) {
            th = th;
        }
        if (this.f51768b != null) {
            d.a.m0.n.g.c.b a2 = this.f51768b.a(h.class);
            Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(h.class), null, null, null, "update_time ASC limit 0," + i2);
            if (query == null) {
                d.a.m0.n.o.c.a(query);
                return null;
            }
            try {
                List<h> e3 = a2.e(query);
                d.a.m0.n.o.c.a(query);
                return e3;
            } catch (Exception e4) {
                cursor = query;
                e = e4;
                try {
                    if (d.a.m0.n.c.f51766a) {
                        e.printStackTrace();
                    }
                    d.a.m0.n.o.c.a(cursor);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    d.a.m0.n.o.c.a(cursor2);
                    throw th;
                }
            } catch (Throwable th3) {
                cursor2 = query;
                th = th3;
                d.a.m0.n.o.c.a(cursor2);
                throw th;
            }
        }
        Log.i("queryBatchDynamicLib", "mDBDao is null");
        d.a.m0.n.o.c.a(null);
        return null;
    }

    @Override // d.a.m0.n.g.a
    public <T extends e> T o(Class<T> cls, String str) {
        return (T) B(cls, str);
    }

    @Override // d.a.m0.n.g.a
    public Map<String, f> p() {
        HashMap hashMap = new HashMap();
        List<f> C = C(f.class, "state =? ", new String[]{"10"}, "version_code ASC");
        if (C != null && C.size() > 0) {
            for (f fVar : C) {
                if (fVar != null) {
                    hashMap.put(fVar.f51794g, fVar);
                }
            }
        }
        return hashMap;
    }

    @Override // d.a.m0.n.g.a
    public List<h> q(String str, String[] strArr) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            d.a.m0.n.g.c.b a2 = this.f51768b.a(h.class);
            cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(h.class), null, str, strArr, "update_time DESC");
            if (cursor != null) {
                try {
                    try {
                        List<h> e2 = a2.e(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return e2;
                    } catch (Exception e3) {
                        e = e3;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.a.m0.n.o.c.a(cursor2);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.n.o.c.a(cursor2);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    @Override // d.a.m0.n.g.a
    @Nullable
    public i r(String str) {
        Cursor cursor;
        ?? r1 = 0;
        try {
            try {
                d.a.m0.n.g.c.b a2 = this.f51768b.a(i.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(i.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        i iVar = (i) a2.d(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return iVar;
                    } catch (Exception e2) {
                        e = e2;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                r1 = str;
                d.a.m0.n.o.c.a(r1);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.n.o.c.a(r1);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }

    @Override // d.a.m0.n.g.a
    public PMSAppInfo s(String str) {
        return z(str);
    }

    @Override // d.a.m0.n.g.a
    public Map<String, PMSAppInfo> t() {
        HashMap hashMap = new HashMap();
        List<PMSAppInfo> A = A(PMSAppInfo.class, null, null, null);
        if (A != null && A.size() > 0) {
            for (PMSAppInfo pMSAppInfo : A) {
                if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                    hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                }
            }
        }
        return hashMap;
    }

    @Override // d.a.m0.n.g.a
    public List<h> u(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            d.a.m0.n.g.c.b a2 = this.f51768b.a(h.class);
            Uri.Builder buildUpon = this.f51768b.b(h.class).buildUpon();
            buildUpon.appendQueryParameter("rawQuery", "");
            cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
            if (cursor != null) {
                try {
                    try {
                        List<h> e2 = a2.e(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return e2;
                    } catch (Exception e3) {
                        e = e3;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.a.m0.n.o.c.a(cursor2);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.m0.n.o.c.a(cursor2);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }

    @Override // d.a.m0.n.g.a
    public boolean v(@NonNull h hVar) {
        Uri b2;
        ContentValues c2;
        String str;
        String[] strArr;
        try {
            d.a.m0.n.g.c.b a2 = this.f51768b.a(hVar.getClass());
            b2 = this.f51768b.b(hVar.getClass());
            c2 = a2.c(hVar);
            if (hVar.f51796i >= 0) {
                str = "bundle_id = ?  and version_code = ? ";
                strArr = new String[]{hVar.f51794g, String.valueOf(hVar.f51796i)};
            } else {
                str = "bundle_id = ?  and version_name = ? ";
                strArr = new String[]{hVar.f51794g, hVar.j};
            }
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().update(b2, c2, str, strArr) > 0;
    }

    @Override // d.a.m0.n.g.a
    public boolean w(PMSAppInfo pMSAppInfo) {
        try {
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().update(this.f51768b.b(pMSAppInfo.getClass()), this.f51768b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0;
    }

    @Override // d.a.m0.n.g.a
    public boolean x(String str, int i2) {
        Uri b2;
        ContentValues contentValues;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            b2 = this.f51768b.b(PMSAppInfo.class);
            contentValues = new ContentValues();
            contentValues.put("pending_err_code", Integer.valueOf(i2));
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
                e2.printStackTrace();
            }
        }
        return AppRuntime.getAppContext().getContentResolver().update(b2, contentValues, "app_id =? ", new String[]{str}) > 0;
    }

    public final <T extends e> boolean y(T t) {
        try {
            Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f51768b.b(t.getClass()), this.f51768b.a(t.getClass()).c(t));
            if (insert != null) {
                return ContentUris.parseId(insert) > 0;
            }
            return false;
        } catch (Exception e2) {
            if (d.a.m0.n.c.f51766a) {
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
    public final PMSAppInfo z(String str) {
        Throwable th;
        Cursor cursor;
        try {
            try {
                d.a.m0.n.g.c.b a2 = this.f51768b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f51768b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        PMSAppInfo pMSAppInfo = (PMSAppInfo) a2.d(cursor);
                        d.a.m0.n.o.c.a(cursor);
                        return pMSAppInfo;
                    } catch (Exception e2) {
                        e = e2;
                        if (d.a.m0.n.c.f51766a) {
                            e.printStackTrace();
                        }
                        d.a.m0.n.o.c.a(cursor);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                d.a.m0.n.o.c.a(str);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            d.a.m0.n.o.c.a(str);
            throw th;
        }
        d.a.m0.n.o.c.a(cursor);
        return null;
    }
}
