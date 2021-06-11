package d.a.l0.a.j0.b;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.database.SwanAppDbControl;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f46722b = AppRuntime.getApplication().getPackageName() + ".swan.favorite";

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f46723c = Uri.parse("content://" + f46722b);

    /* renamed from: a  reason: collision with root package name */
    public UriMatcher f46724a;

    public b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f46724a = uriMatcher;
        uriMatcher.addURI(f46722b, "favorite", 0);
        this.f46724a.addURI(f46722b, "favorite_and_aps", 1);
        this.f46724a.addURI(f46722b, "history", 2);
        this.f46724a.addURI(f46722b, "history_with_app", 3);
        this.f46724a.addURI(f46722b, "favorite_with_aps_pms", 4);
        this.f46724a.addURI(f46722b, "history_with_aps_pms", 5);
        this.f46724a.addURI(f46722b, "user_behavior", 6);
    }

    public static void e() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(d.a.l0.a.j0.c.a.b(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(d.a.l0.a.j0.c.a.c(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(d.a.l0.a.j0.c.a.a(), (ContentObserver) null, false);
    }

    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        SQLiteDatabase e2;
        int match = this.f46724a.match(uri);
        if (match != 0) {
            if (match != 2) {
                if (match == 6 && (e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                    return e2.delete(b(match), str, strArr);
                }
                return 0;
            }
            int c2 = SwanAppDbControl.f(AppRuntime.getAppContext()).c(str, strArr);
            if (c2 > 0) {
                e();
            }
            return c2;
        }
        return SwanAppDbControl.f(AppRuntime.getAppContext()).b(str, strArr);
    }

    @NonNull
    public final String b(int i2) {
        if (i2 != 6) {
            if (k.f46875a) {
                throw new NullPointerException("tableName must not Null");
            }
            return "";
        }
        return "user_behavior";
    }

    @Nullable
    public String c(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri d(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase e2;
        int match = this.f46724a.match(uri);
        if (match == 0) {
            long i2 = SwanAppDbControl.f(AppRuntime.getAppContext()).i(contentValues);
            if (i2 < 0) {
                return null;
            }
            return ContentUris.withAppendedId(f46723c.buildUpon().build(), i2);
        } else if (match != 2) {
            if (match == 6 && (e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                e2.insertWithOnConflict(b(match), null, contentValues, 5);
                return uri;
            }
            return null;
        } else {
            long j = SwanAppDbControl.f(AppRuntime.getAppContext()).j(contentValues);
            if (j < 0) {
                return null;
            }
            e();
            return ContentUris.withAppendedId(f46723c.buildUpon().build(), j);
        }
    }

    @Nullable
    public Cursor f(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.f46724a.match(uri);
        switch (match) {
            case 0:
                Cursor l = SwanAppDbControl.f(AppRuntime.getAppContext()).l(strArr, str, strArr2, str2);
                l.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return l;
            case 1:
                Cursor k = SwanAppDbControl.f(AppRuntime.getAppContext()).k(strArr, str, strArr2, str2);
                k.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return k;
            case 2:
                Cursor n = SwanAppDbControl.f(AppRuntime.getAppContext()).n(strArr, str, strArr2, str2);
                n.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return n;
            case 3:
                Cursor m = SwanAppDbControl.f(AppRuntime.getAppContext()).m(strArr, str, strArr2, str2);
                m.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return m;
            case 4:
                Cursor s = a.s();
                s.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return s;
            case 5:
                int i2 = -1;
                try {
                    i2 = Integer.valueOf(uri.getQueryParameter("query_limit")).intValue();
                } catch (Exception e2) {
                    if (k.f46875a) {
                        e2.printStackTrace();
                    }
                }
                String queryParameter = uri.getQueryParameter("query_word");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Cursor n2 = d.a.l0.a.j0.c.b.n(queryParameter, i2);
                n2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return n2;
            case 6:
                SQLiteDatabase e3 = SwanAppDbControl.f(AppRuntime.getAppContext()).e();
                if (e3 != null) {
                    return e3.query(b(match), strArr, str, strArr2, null, null, str2);
                }
                return null;
            default:
                return null;
        }
    }

    public int g(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        SQLiteDatabase e2;
        int match = this.f46724a.match(uri);
        if (match != 0) {
            if (match != 2) {
                if (match == 6 && (e2 = SwanAppDbControl.f(AppRuntime.getAppContext()).e()) != null) {
                    return e2.update(b(match), contentValues, str, strArr);
                }
                return 0;
            }
            int r = SwanAppDbControl.f(AppRuntime.getAppContext()).r(contentValues, str, strArr);
            if (r > 0) {
                e();
            }
            return r;
        }
        return SwanAppDbControl.f(AppRuntime.getAppContext()).q(contentValues, str, strArr);
    }
}
