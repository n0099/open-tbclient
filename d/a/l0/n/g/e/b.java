package d.a.l0.n.g.e;

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
import d.a.l0.n.c;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f47993b = AppRuntime.getAppContext().getPackageName() + ".aiapp.pms";

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f47994c = Uri.parse("content://" + f47993b + "/framework");

    /* renamed from: d  reason: collision with root package name */
    public static final Uri f47995d = Uri.parse("content://" + f47993b + "/swan_app");

    /* renamed from: e  reason: collision with root package name */
    public static final Uri f47996e = Uri.parse("content://" + f47993b + "/pkg_main");

    /* renamed from: f  reason: collision with root package name */
    public static final Uri f47997f = Uri.parse("content://" + f47993b + "/pkg_sub");

    /* renamed from: g  reason: collision with root package name */
    public static final Uri f47998g = Uri.parse("content://" + f47993b + "/" + ETAG.KEY_EXTENSION);

    /* renamed from: h  reason: collision with root package name */
    public static final Uri f47999h = Uri.parse("content://" + f47993b + "/swan_plugin");

    /* renamed from: i  reason: collision with root package name */
    public static final Uri f48000i = Uri.parse("content://" + f47993b + "/so_lib");
    public static UriMatcher j;

    /* renamed from: a  reason: collision with root package name */
    public Context f48001a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        j = uriMatcher;
        uriMatcher.addURI(f47993b, "framework", 2);
        j.addURI(f47993b, "pkg_main", 0);
        j.addURI(f47993b, "pkg_sub", 1);
        j.addURI(f47993b, ETAG.KEY_EXTENSION, 3);
        j.addURI(f47993b, "swan_app", 4);
        j.addURI(f47993b, "swan_plugin", 5);
        j.addURI(f47993b, "so_lib", 7);
    }

    public b(Context context) {
        this.f48001a = context;
    }

    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return 0;
        }
        if (c.f47984a) {
            Log.e("PMSDBProvider", "delete");
        }
        try {
            int delete = b().getWritableDatabase().delete(c2, str, strArr);
            if (delete > 0) {
                this.f48001a.getContentResolver().notifyChange(uri, null);
            }
            return delete;
        } catch (SQLException e2) {
            if (c.f47984a) {
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
        int match = j.match(uri);
        if (match != 0) {
            if (match != 1) {
                if (match != 2) {
                    if (match != 3) {
                        if (match != 4) {
                            if (match != 5) {
                                if (match != 7) {
                                    return null;
                                }
                                return "so_lib";
                            }
                            return "swan_plugin";
                        }
                        return "swan_app";
                    }
                    return ETAG.KEY_EXTENSION;
                }
                return "framework";
            }
            return "pkg_sub";
        }
        return "pkg_main";
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
            if (c.f47984a) {
                Log.e("PMSDBProvider", "insert:" + contentValues.toString());
            }
            try {
                long insertWithOnConflict = b().getWritableDatabase().insertWithOnConflict(c2, null, contentValues, 5);
                if (insertWithOnConflict > 0) {
                    Uri withAppendedId = ContentUris.withAppendedId(uri, insertWithOnConflict);
                    this.f48001a.getContentResolver().notifyChange(withAppendedId, null);
                    return withAppendedId;
                }
                return uri;
            } catch (SQLException e2) {
                if (c.f47984a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    @Nullable
    public Cursor f(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        if (uri.getQueryParameter("rawQuery") != null) {
            return g(uri, str);
        }
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        if (c.f47984a) {
            Log.e("PMSDBProvider", "query");
        }
        try {
            return b().getReadableDatabase().query(c2, strArr, str, strArr2, null, null, str2, null);
        } catch (SQLException e2) {
            if (c.f47984a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    @Nullable
    public Cursor g(@NonNull Uri uri, @Nullable String str) {
        if (!TextUtils.isEmpty(c(uri))) {
            if (c.f47984a) {
                Log.e("PMSDBProvider", "query");
            }
            try {
                return b().getReadableDatabase().rawQuery(str, null);
            } catch (SQLException e2) {
                if (c.f47984a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public int h(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return 0;
        }
        if (c.f47984a) {
            Log.e("PMSDBProvider", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        try {
            int update = b().getWritableDatabase().update(c2, contentValues, str, strArr);
            if (update > 0) {
                this.f48001a.getContentResolver().notifyChange(uri, null);
            }
            return update;
        } catch (SQLException e2) {
            if (c.f47984a) {
                e2.printStackTrace();
                return 0;
            }
            return 0;
        }
    }
}
