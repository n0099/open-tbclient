package d.b.g0.a.g0.c;

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
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f44883b = AppRuntime.getApplication().getPackageName() + ".swan.favorite";

    /* renamed from: c  reason: collision with root package name */
    public static final Uri f44884c = Uri.parse("content://" + f44883b);

    /* renamed from: a  reason: collision with root package name */
    public UriMatcher f44885a;

    public b() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f44885a = uriMatcher;
        uriMatcher.addURI(f44883b, "favorite", 0);
        this.f44885a.addURI(f44883b, "favorite_and_aps", 1);
        this.f44885a.addURI(f44883b, "history", 2);
        this.f44885a.addURI(f44883b, "history_with_app", 3);
        this.f44885a.addURI(f44883b, "favorite_with_aps_pms", 4);
        this.f44885a.addURI(f44883b, "history_with_aps_pms", 5);
        this.f44885a.addURI(f44883b, "user_behavior", 6);
    }

    public static void e() {
        AppRuntime.getAppContext().getContentResolver().notifyChange(d.b.g0.a.g0.d.a.b(), (ContentObserver) null, false);
        AppRuntime.getAppContext().getContentResolver().notifyChange(d.b.g0.a.g0.d.a.c(), (ContentObserver) null, false);
    }

    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        SQLiteDatabase e2;
        int match = this.f44885a.match(uri);
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
    public final String b(int i) {
        if (i == 6) {
            return "user_behavior";
        }
        throw new NullPointerException("tableName must not Null");
    }

    @Nullable
    public String c(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri d(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase e2;
        int match = this.f44885a.match(uri);
        if (match == 0) {
            long i = SwanAppDbControl.f(AppRuntime.getAppContext()).i(contentValues);
            if (i < 0) {
                return null;
            }
            return ContentUris.withAppendedId(f44884c.buildUpon().build(), i);
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
            return ContentUris.withAppendedId(f44884c.buildUpon().build(), j);
        }
    }

    @Nullable
    public Cursor f(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        int match = this.f44885a.match(uri);
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
                return SwanAppDbControl.f(AppRuntime.getAppContext()).n(strArr, str, strArr2, str2);
            case 3:
                Cursor m = SwanAppDbControl.f(AppRuntime.getAppContext()).m(strArr, str, strArr2, str2);
                m.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return m;
            case 4:
                Cursor s = a.s();
                s.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return s;
            case 5:
                int i = -1;
                try {
                    i = Integer.valueOf(uri.getQueryParameter("query_limit")).intValue();
                } catch (Exception e2) {
                    if (k.f45443a) {
                        e2.printStackTrace();
                    }
                }
                String queryParameter = uri.getQueryParameter("query_word");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Cursor m2 = d.b.g0.a.g0.d.b.m(queryParameter, i);
                m2.setNotificationUri(AppRuntime.getAppContext().getContentResolver(), uri);
                return m2;
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
        int match = this.f44885a.match(uri);
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
