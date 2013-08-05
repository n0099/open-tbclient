package com.tencent.mm.sdk.storage;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.Log;
/* loaded from: classes.dex */
public abstract class ContentProviderDB implements ISQLiteDatabase {
    private final Context R;

    public ContentProviderDB(Context context) {
        this.R = context;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public int delete(String str, String str2, String[] strArr) {
        Uri uriFromTable = getUriFromTable(str);
        if (uriFromTable == null) {
            Log.e("MicroMsg.SDK.MContentProviderDB", "get uri from table failed, table=" + str);
            return 0;
        }
        return this.R.getContentResolver().delete(uriFromTable, str2, strArr);
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public boolean execSQL(String str, String str2) {
        Log.e("MicroMsg.SDK.MContentProviderDB", "do not support, execSQL sql=" + str2);
        return false;
    }

    public abstract Uri getUriFromTable(String str);

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public long insert(String str, String str2, ContentValues contentValues) {
        Uri uriFromTable = getUriFromTable(str);
        if (uriFromTable == null) {
            Log.e("MicroMsg.SDK.MContentProviderDB", "get uri from table failed, table=" + str);
            return -1L;
        }
        return ContentUris.parseId(this.R.getContentResolver().insert(uriFromTable, contentValues));
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Uri uriFromTable = getUriFromTable(str);
        if (uriFromTable == null) {
            Log.e("MicroMsg.SDK.MContentProviderDB", "get uri from table failed, table=" + str);
            return new MatrixCursor(strArr);
        }
        Cursor query = this.R.getContentResolver().query(uriFromTable, strArr, str2, strArr2, str5);
        return query == null ? new MatrixCursor(strArr) : query;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor rawQuery(String str, String[] strArr) {
        Log.e("MicroMsg.SDK.MContentProviderDB", "do not support, rawQuery sql=" + str);
        return null;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public long replace(String str, String str2, ContentValues contentValues) {
        Log.e("MicroMsg.SDK.MContentProviderDB", "do not support, replace table=" + str);
        return 0L;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        Uri uriFromTable = getUriFromTable(str);
        if (uriFromTable == null) {
            Log.e("MicroMsg.SDK.MContentProviderDB", "get uri from table failed, table=" + str);
            return 0;
        }
        return this.R.getContentResolver().update(uriFromTable, contentValues, str2, strArr);
    }
}
