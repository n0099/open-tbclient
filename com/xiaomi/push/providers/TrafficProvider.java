package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.push.gq;
/* loaded from: classes7.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final UriMatcher f41186a;

    /* renamed from: a  reason: collision with other field name */
    public static final Uri f821a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: a  reason: collision with other field name */
    public SQLiteOpenHelper f822a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f41186a = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        f41186a.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f41186a.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f822a = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f823a) {
            if (f41186a.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            query = this.f822a.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f41186a.match(uri) == 2 && contentValues != null && contentValues.containsKey("imsi")) {
            gq.m345a(contentValues.getAsString("imsi"));
            return 0;
        }
        return 0;
    }
}
