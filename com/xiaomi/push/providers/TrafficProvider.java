package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.push.gr;
/* loaded from: classes8.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: a  reason: collision with other field name */
    private SQLiteOpenHelper f803a;

    /* renamed from: a  reason: collision with other field name */
    public static final Uri f802a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");
    private static final UriMatcher a = new UriMatcher(-1);

    static {
        a.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        a.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
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
        switch (a.match(uri)) {
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
        this.f803a = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f804a) {
            switch (a.match(uri)) {
                case 1:
                    query = this.f803a.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown URI " + uri);
            }
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        switch (a.match(uri)) {
            case 2:
                if (contentValues == null || !contentValues.containsKey("imsi")) {
                    return 0;
                }
                gr.m320a(contentValues.getAsString("imsi"));
                return 0;
            default:
                return 0;
        }
    }
}
