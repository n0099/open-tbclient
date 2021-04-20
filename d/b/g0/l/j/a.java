package d.b.g0.l.j;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49298a;

    /* renamed from: b  reason: collision with root package name */
    public String f49299b;

    /* renamed from: c  reason: collision with root package name */
    public int f49300c;

    /* renamed from: d  reason: collision with root package name */
    public String f49301d;

    /* renamed from: e  reason: collision with root package name */
    public long f49302e;

    /* renamed from: f  reason: collision with root package name */
    public String f49303f;

    /* renamed from: g  reason: collision with root package name */
    public String f49304g;

    /* renamed from: h  reason: collision with root package name */
    public String f49305h;
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
        int columnIndex8 = cursor.getColumnIndex(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
        int columnIndex9 = cursor.getColumnIndex("_id");
        String string = cursor.getString(columnIndex2);
        if (TextUtils.isEmpty(string)) {
            return aVar;
        }
        aVar.f49299b = string;
        aVar.f49298a = cursor.getString(columnIndex);
        aVar.f49301d = cursor.getString(columnIndex3);
        aVar.f49300c = cursor.getInt(columnIndex4);
        aVar.f49302e = cursor.getLong(columnIndex5);
        aVar.f49303f = cursor.getString(columnIndex6);
        aVar.f49304g = cursor.getString(columnIndex7);
        aVar.f49305h = cursor.getString(columnIndex8);
        aVar.i = cursor.getLong(columnIndex9);
        return aVar;
    }

    public String a() {
        return this.f49298a;
    }

    public String b() {
        return this.f49299b;
    }

    public String c() {
        return this.f49305h;
    }

    public String d() {
        return this.f49303f;
    }

    public String e() {
        return this.f49304g;
    }

    public long f() {
        return this.f49302e;
    }

    public int g() {
        return this.f49300c;
    }

    public String h() {
        return this.f49301d;
    }

    @NonNull
    public String toString() {
        return "SwanMiniPackageInfo{appId='" + this.f49298a + "', bundleId='" + this.f49299b + "', versionCode=" + this.f49300c + ", versionName='" + this.f49301d + "', size=" + this.f49302e + ", md5='" + this.f49303f + "', sign='" + this.f49304g + "', downloadUrl='" + this.f49305h + "', rawid=" + this.i + '}';
    }
}
