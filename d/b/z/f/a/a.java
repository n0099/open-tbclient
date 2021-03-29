package d.b.z.f.a;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.b.z.h.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f64885b;

    /* renamed from: a  reason: collision with root package name */
    public c f64886a;

    /* renamed from: d.b.z.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1780a extends d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f64887b;

        public C1780a(a aVar, ContentValues contentValues) {
            this.f64887b = contentValues;
        }

        @Override // d.b.z.f.a.d
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            BundleInfo bundleInfo = BundleInfo.toBundleInfo(this.f64887b);
            if (bundleInfo == null) {
                return false;
            }
            Cursor query = sQLiteDatabase.query("bundleinfo", null, "pkg_name =? ", new String[]{bundleInfo.getPackageName()}, null, null, null);
            List<BundleInfo> bundleInfoList = BundleInfo.toBundleInfoList(query);
            try {
                query.close();
            } catch (Exception unused) {
            }
            if (bundleInfoList.isEmpty()) {
                sQLiteDatabase.insert("bundleinfo", null, this.f64887b);
                return true;
            }
            HashMap hashMap = new HashMap();
            for (BundleInfo bundleInfo2 : bundleInfoList) {
                if (bundleInfo2 != null) {
                    hashMap.put(Integer.valueOf(bundleInfo2.getType()), bundleInfo2);
                }
            }
            BundleInfo bundleInfo3 = (BundleInfo) hashMap.get(3);
            BundleInfo bundleInfo4 = (BundleInfo) hashMap.get(2);
            BundleInfo bundleInfo5 = (BundleInfo) hashMap.get(1);
            if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() > bundleInfo.getUpdateV()) {
                BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo3);
            }
            if (bundleInfo4 != null && bundleInfo4.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo4.getUpdateV() > bundleInfo.getUpdateV()) {
                BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo4);
            }
            if (bundleInfo5 != null && bundleInfo5.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo5.getUpdateV() > bundleInfo.getUpdateV()) {
                BundleInfo.updateBundleInfoConfig(bundleInfo, bundleInfo4);
            }
            int type = bundleInfo.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        if (bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.put(3, bundleInfo);
                        }
                        if (bundleInfo4 != null && bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.remove(2);
                        }
                        if (bundleInfo5 != null && bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.remove(1);
                        }
                    }
                } else if (bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) {
                    if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() <= bundleInfo.getUpdateV()) {
                        BundleInfo.updateBundleInfoConfig(bundleInfo3, bundleInfo);
                    } else {
                        if (bundleInfo4 == null || bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.put(2, bundleInfo);
                        }
                        if (bundleInfo5 != null && bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                            hashMap.remove(1);
                        }
                    }
                }
            } else if ((bundleInfo3 == null || bundleInfo3.getVersionCode() <= bundleInfo.getVersionCode()) && (bundleInfo4 == null || bundleInfo4.getVersionCode() <= bundleInfo.getVersionCode())) {
                if (bundleInfo3 != null && bundleInfo3.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo3.getUpdateV() <= bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo3, bundleInfo);
                } else if (bundleInfo4 != null && bundleInfo4.getVersionCode() == bundleInfo.getVersionCode() && bundleInfo4.getUpdateV() <= bundleInfo.getUpdateV()) {
                    BundleInfo.updateBundleInfoConfig(bundleInfo4, bundleInfo);
                } else if (bundleInfo5 == null || bundleInfo5.getVersionCode() <= bundleInfo.getVersionCode()) {
                    hashMap.put(1, bundleInfo);
                }
            }
            sQLiteDatabase.delete("bundleinfo", "pkg_name =? ", new String[]{this.f64887b.getAsString(EmotionResourceInfo.JSON_KEY_PKG_NAME)});
            for (BundleInfo bundleInfo6 : hashMap.values()) {
                sQLiteDatabase.insert("bundleinfo", null, BundleInfo.toContentValues(bundleInfo6));
            }
            return true;
        }
    }

    public a(Context context) {
        this.f64886a = null;
        this.f64886a = new c(context);
    }

    public static a d(Context context) {
        if (f64885b == null) {
            synchronized (a.class) {
                if (f64885b == null) {
                    Application applicationContext = ContextHolder.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    f64885b = new a(context);
                }
            }
        }
        return f64885b;
    }

    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int b(String str, int i) {
        this.f64886a.getWritableDatabase().delete("bundleinfo", "pkg_name =? AND version_code < ? ", new String[]{str, String.valueOf(i)});
        return 0;
    }

    public int c() {
        this.f64886a.getWritableDatabase().delete("bundleinfo", "abi <>? AND abi <> 3", new String[]{String.valueOf(e.a())});
        return 0;
    }

    public Cursor e(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f64886a.getReadableDatabase().query("bundleinfo", null, str, strArr2, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (d.b.z.h.b.a() == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (d.b.z.h.b.a() == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<BundleInfo> f() {
        Cursor query = this.f64886a.getReadableDatabase().query("bundleinfo", null, "", null, null, null, null);
        List<BundleInfo> arrayList = new ArrayList<>();
        try {
            try {
                arrayList = BundleInfo.toBundleInfoList(query);
                try {
                    query.close();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                if (d.b.z.h.b.a()) {
                    e3.printStackTrace();
                }
                try {
                    query.close();
                } catch (Exception e4) {
                    e = e4;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                query.close();
            } catch (Exception e5) {
                if (d.b.z.h.b.a()) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public Cursor g(int i) {
        return e(null, null, "type = ? AND broken = ? ", new String[]{String.valueOf(i), "0"}, null);
    }

    public Cursor h(String str, int i) {
        return e(null, null, "pkg_name =? AND type = ? AND broken = ? ", new String[]{str, String.valueOf(i), "0"}, null);
    }

    public Cursor i(String str, int i, int i2) {
        return e(null, null, "pkg_name =? AND type = ? AND version_code >= ? AND broken = ? ", new String[]{str, String.valueOf(i2), String.valueOf(i), "0"}, null);
    }

    public final boolean j(d dVar) {
        dVar.c(this.f64886a.getWritableDatabase());
        return dVar.a();
    }

    public int k(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        j(new C1780a(this, contentValues));
        return 1;
    }
}
