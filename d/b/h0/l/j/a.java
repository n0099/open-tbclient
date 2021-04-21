package d.b.h0.l.j;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f49627a;

    /* renamed from: b  reason: collision with root package name */
    public String f49628b;

    /* renamed from: c  reason: collision with root package name */
    public int f49629c;

    /* renamed from: d  reason: collision with root package name */
    public String f49630d;

    /* renamed from: e  reason: collision with root package name */
    public long f49631e;

    /* renamed from: f  reason: collision with root package name */
    public String f49632f;

    /* renamed from: g  reason: collision with root package name */
    public String f49633g;

    /* renamed from: h  reason: collision with root package name */
    public String f49634h;
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
        aVar.f49628b = string;
        aVar.f49627a = cursor.getString(columnIndex);
        aVar.f49630d = cursor.getString(columnIndex3);
        aVar.f49629c = cursor.getInt(columnIndex4);
        aVar.f49631e = cursor.getLong(columnIndex5);
        aVar.f49632f = cursor.getString(columnIndex6);
        aVar.f49633g = cursor.getString(columnIndex7);
        aVar.f49634h = cursor.getString(columnIndex8);
        aVar.i = cursor.getLong(columnIndex9);
        return aVar;
    }

    public String a() {
        return this.f49627a;
    }

    public String b() {
        return this.f49628b;
    }

    public String c() {
        return this.f49634h;
    }

    public String d() {
        return this.f49632f;
    }

    public String e() {
        return this.f49633g;
    }

    public long f() {
        return this.f49631e;
    }

    public int g() {
        return this.f49629c;
    }

    public String h() {
        return this.f49630d;
    }

    @NonNull
    public String toString() {
        return "SwanMiniPackageInfo{appId='" + this.f49627a + "', bundleId='" + this.f49628b + "', versionCode=" + this.f49629c + ", versionName='" + this.f49630d + "', size=" + this.f49631e + ", md5='" + this.f49632f + "', sign='" + this.f49633g + "', downloadUrl='" + this.f49634h + "', rawid=" + this.i + '}';
    }
}
