package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.push.gx;
/* loaded from: classes5.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: a  reason: collision with other field name */
    private SQLiteOpenHelper f791a;

    /* renamed from: a  reason: collision with other field name */
    public static final Uri f790a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f8479a = new UriMatcher(-1);

    static {
        f8479a.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        f8479a.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
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
        switch (f8479a.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f791a = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f792a) {
            switch (f8479a.match(uri)) {
                case 1:
                    query = this.f791a.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown URI " + uri);
            }
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        switch (f8479a.match(uri)) {
            case 2:
                if (contentValues == null || !contentValues.containsKey("imsi")) {
                    return 0;
                }
                gx.m335a(contentValues.getAsString("imsi"));
                return 0;
            default:
                return 0;
        }
    }
}
