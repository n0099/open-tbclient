package d.b.g0.l.i.e;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.internal.ETAG;
import d.b.g0.l.f;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f48897b = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f48898c = Uri.parse("content://" + f48897b + "/framework");

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f48899d = Uri.parse("content://" + f48897b + "/swan_app");

    /* renamed from: e  reason: collision with root package name */
    public static final Uri f48900e = Uri.parse("content://" + f48897b + "/pkg_main");

    /* renamed from: f  reason: collision with root package name */
    public static final Uri f48901f = Uri.parse("content://" + f48897b + "/pkg_sub");

    /* renamed from: g  reason: collision with root package name */
    public static final Uri f48902g = Uri.parse("content://" + f48897b + "/" + ETAG.KEY_EXTENSION);

    /* renamed from: h  reason: collision with root package name */
    public static final Uri f48903h = Uri.parse("content://" + f48897b + "/swan_plugin");
    public static final Uri i = Uri.parse("content://" + f48897b + "/so_lib");
    public static final Uri j = Uri.parse("content://" + f48897b + "/swan_mini_pkg");
    public static UriMatcher k;

    /* renamed from: a  reason: collision with root package name */
    public Context f48904a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        k = uriMatcher;
        uriMatcher.addURI(f48897b, "framework", 2);
        k.addURI(f48897b, "pkg_main", 0);
        k.addURI(f48897b, "pkg_sub", 1);
        k.addURI(f48897b, ETAG.KEY_EXTENSION, 3);
        k.addURI(f48897b, "swan_app", 4);
        k.addURI(f48897b, "swan_plugin", 5);
        k.addURI(f48897b, "swan_mini_pkg", 6);
        k.addURI(f48897b, "so_lib", 7);
    }

    public b(Context context) {
        this.f48904a = context;
    }

    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return 0;
        }
        if (f.f48888a) {
            Log.e("PMSDBProvider", "delete");
        }
        try {
            int delete = b().getWritableDatabase().delete(c2, str, strArr);
            if (delete > 0) {
                this.f48904a.getContentResolver().notifyChange(uri, null);
            }
            return delete;
        } catch (SQLException e2) {
            if (f.f48888a) {
                e2.printStackTrace();
                return 0;
            }
            return 0;
        }
    }

    public SQLiteOpenHelper b() {
        return a.a();
    }

    public final String c(Uri uri) {
        switch (k.match(uri)) {
            case 0:
                return "pkg_main";
            case 1:
                return "pkg_sub";
            case 2:
                return "framework";
            case 3:
                return ETAG.KEY_EXTENSION;
            case 4:
                return "swan_app";
            case 5:
                return "swan_plugin";
            case 6:
                return "swan_mini_pkg";
            case 7:
                return "so_lib";
            default:
                return null;
        }
    }

    @Nullable
    public String d(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri e(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        Log.e("PMSDBProvider", "name:" + Thread.currentThread().getName());
        String c2 = c(uri);
        if (!TextUtils.isEmpty(c2) && contentValues != null) {
            if (f.f48888a) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = b().getWritableDatabase().insertWithOnConflict(c2, null, contentValues, 5);
                if (insertWithOnConflict > 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                    this.f48904a.getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                return uri;
            } catch (SQLException e2) {
                if (f.f48888a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    @Nullable
    public Cursor f(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        if (f.f48888a) {
            Log.e("PMSDBProvider", "query");
        }
        try {
            return b().getReadableDatabase().query(c2, strArr, str, strArr2, null, null, str2, null);
        } catch (SQLException e2) {
            if (f.f48888a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public int g(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return 0;
        }
        if (f.f48888a) {
            Log.e("PMSDBProvider", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        try {
            int update = b().getWritableDatabase().update(c2, contentValues, str, strArr);
            if (update > 0) {
                this.f48904a.getContentResolver().notifyChange(uri, null);
            }
            return update;
        } catch (SQLException e2) {
            if (f.f48888a) {
                e2.printStackTrace();
                return 0;
            }
            return 0;
        }
    }
}
