package d.a.z.g.a;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.baidu.nps.pm.BundleInfo;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import d.a.z.i.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68640b;

    /* renamed from: a  reason: collision with root package name */
    public c f68641a;

    /* renamed from: d.a.z.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1878a extends d {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f68642b;

        public C1878a(a aVar, ContentValues contentValues) {
            this.f68642b = contentValues;
        }

        @Override // d.a.z.g.a.d
        public boolean b(SQLiteDatabase sQLiteDatabase) {
            BundleInfo bundleInfo = BundleInfo.toBundleInfo(this.f68642b);
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
                sQLiteDatabase.insert("bundleinfo", null, this.f68642b);
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
            sQLiteDatabase.delete("bundleinfo", "pkg_name =? ", new String[]{this.f68642b.getAsString(EmotionResourceInfo.JSON_KEY_PKG_NAME)});
            for (BundleInfo bundleInfo6 : hashMap.values()) {
                sQLiteDatabase.insert("bundleinfo", null, BundleInfo.toContentValues(bundleInfo6));
            }
            return true;
        }
    }

    public a(Context context) {
        this.f68641a = null;
        this.f68641a = new c(context);
    }

    public static a c(Context context) {
        if (f68640b == null) {
            synchronized (a.class) {
                if (f68640b == null) {
                    Application applicationContext = ContextHolder.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    f68640b = new a(context);
                }
            }
        }
        return f68640b;
    }

    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int b() {
        this.f68641a.getWritableDatabase().delete("bundleinfo", "abi <>? AND abi <> 3", new String[]{String.valueOf(f.a())});
        return 0;
    }

    public Cursor d(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.f68641a.getReadableDatabase().query("bundleinfo", null, str, strArr2, null, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (d.a.z.i.b.a() == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (d.a.z.i.b.a() == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<BundleInfo> e() {
        Cursor query = this.f68641a.getReadableDatabase().query("bundleinfo", null, "", null, null, null, null);
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
                if (d.a.z.i.b.a()) {
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
                if (d.a.z.i.b.a()) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public Cursor f(String str, int i2) {
        return d(null, null, "pkg_name =? AND type = ? AND broken = ? ", new String[]{str, String.valueOf(i2), "0"}, null);
    }

    public Cursor g(String str, int i2, int i3) {
        return d(null, null, "pkg_name =? AND type = ? AND version_code >= ? AND broken = ? ", new String[]{str, String.valueOf(i3), String.valueOf(i2), "0"}, null);
    }

    public final boolean h(d dVar) {
        dVar.c(this.f68641a.getWritableDatabase());
        return dVar.a();
    }

    public int i(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        h(new C1878a(this, contentValues));
        return 1;
    }
}
