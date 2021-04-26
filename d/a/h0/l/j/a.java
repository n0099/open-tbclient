package d.a.h0.l.j;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f47135a;

    /* renamed from: b  reason: collision with root package name */
    public String f47136b;

    /* renamed from: c  reason: collision with root package name */
    public int f47137c;

    /* renamed from: d  reason: collision with root package name */
    public String f47138d;

    /* renamed from: e  reason: collision with root package name */
    public long f47139e;

    /* renamed from: f  reason: collision with root package name */
    public String f47140f;

    /* renamed from: g  reason: collision with root package name */
    public String f47141g;

    /* renamed from: h  reason: collision with root package name */
    public String f47142h;

    /* renamed from: i  reason: collision with root package name */
    public long f47143i = 0;

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
        aVar.f47136b = string;
        aVar.f47135a = cursor.getString(columnIndex);
        aVar.f47138d = cursor.getString(columnIndex3);
        aVar.f47137c = cursor.getInt(columnIndex4);
        aVar.f47139e = cursor.getLong(columnIndex5);
        aVar.f47140f = cursor.getString(columnIndex6);
        aVar.f47141g = cursor.getString(columnIndex7);
        aVar.f47142h = cursor.getString(columnIndex8);
        aVar.f47143i = cursor.getLong(columnIndex9);
        return aVar;
    }

    public String a() {
        return this.f47135a;
    }

    public String b() {
        return this.f47136b;
    }

    public String c() {
        return this.f47142h;
    }

    public String d() {
        return this.f47140f;
    }

    public String e() {
        return this.f47141g;
    }

    public long f() {
        return this.f47139e;
    }

    public int g() {
        return this.f47137c;
    }

    public String h() {
        return this.f47138d;
    }

    @NonNull
    public String toString() {
        return "SwanMiniPackageInfo{appId='" + this.f47135a + "', bundleId='" + this.f47136b + "', versionCode=" + this.f47137c + ", versionName='" + this.f47138d + "', size=" + this.f47139e + ", md5='" + this.f47140f + "', sign='" + this.f47141g + "', downloadUrl='" + this.f47142h + "', rawid=" + this.f47143i + '}';
    }
}
