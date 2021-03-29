package d.b.g0.l.j;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.pms.db.PackageTable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f48906a;

    /* renamed from: b  reason: collision with root package name */
    public String f48907b;

    /* renamed from: c  reason: collision with root package name */
    public int f48908c;

    /* renamed from: d  reason: collision with root package name */
    public String f48909d;

    /* renamed from: e  reason: collision with root package name */
    public long f48910e;

    /* renamed from: f  reason: collision with root package name */
    public String f48911f;

    /* renamed from: g  reason: collision with root package name */
    public String f48912g;

    /* renamed from: h  reason: collision with root package name */
    public String f48913h;
    public long i = 0;

    @NonNull
    public static a i(@NonNull Cursor cursor) {
        a aVar = new a();
        int columnIndex = cursor.getColumnIndex(Constants.APP_ID);
        int columnIndex2 = cursor.getColumnIndex("bundle_id");
        int columnIndex3 = cursor.getColumnIndex("version_name");
        int columnIndex4 = cursor.getColumnIndex("version_code");
        int columnIndex5 = cursor.getColumnIndex("size");
        int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
        int columnIndex7 = cursor.getColumnIndex("sign");
        int columnIndex8 = cursor.getColumnIndex("downloadUrl");
        int columnIndex9 = cursor.getColumnIndex("_id");
        String string = cursor.getString(columnIndex2);
        if (TextUtils.isEmpty(string)) {
            return aVar;
        }
        aVar.f48907b = string;
        aVar.f48906a = cursor.getString(columnIndex);
        aVar.f48909d = cursor.getString(columnIndex3);
        aVar.f48908c = cursor.getInt(columnIndex4);
        aVar.f48910e = cursor.getLong(columnIndex5);
        aVar.f48911f = cursor.getString(columnIndex6);
        aVar.f48912g = cursor.getString(columnIndex7);
        aVar.f48913h = cursor.getString(columnIndex8);
        aVar.i = cursor.getLong(columnIndex9);
        return aVar;
    }

    public String a() {
        return this.f48906a;
    }

    public String b() {
        return this.f48907b;
    }

    public String c() {
        return this.f48913h;
    }

    public String d() {
        return this.f48911f;
    }

    public String e() {
        return this.f48912g;
    }

    public long f() {
        return this.f48910e;
    }

    public int g() {
        return this.f48908c;
    }

    public String h() {
        return this.f48909d;
    }

    @NonNull
    public String toString() {
        return "SwanMiniPackageInfo{appId='" + this.f48906a + "', bundleId='" + this.f48907b + "', versionCode=" + this.f48908c + ", versionName='" + this.f48909d + "', size=" + this.f48910e + ", md5='" + this.f48911f + "', sign='" + this.f48912g + "', downloadUrl='" + this.f48913h + "', rawid=" + this.i + '}';
    }
}
