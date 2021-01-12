package com.bytedance.tea.crash.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.bytedance.tea.crash.g.j;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b extends a<com.bytedance.tea.crash.b.a.a> {
    public b() {
        super("duplicatelog");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        Cursor query;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            query = sQLiteDatabase.query(this.f7623b, null, "path=?", new String[]{str}, null, null, null);
            i = query.getCount();
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        try {
            query.close();
        } catch (Exception e2) {
            e = e2;
            j.b(e);
            if (i <= 0) {
            }
        }
        return i <= 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.tea.crash.b.b.a
    public void a(SQLiteDatabase sQLiteDatabase, com.bytedance.tea.crash.b.a.a aVar) {
        if (aVar != null && !c(sQLiteDatabase, aVar.f7620a)) {
            super.a(sQLiteDatabase, (SQLiteDatabase) aVar);
            try {
                sQLiteDatabase.execSQL("delete from " + this.f7623b + " where " + IMConstants.MSG_ROW_ID + " in (select " + IMConstants.MSG_ROW_ID + " from " + this.f7623b + " order by insert_time desc limit 1000 offset 500)");
            } catch (Exception e) {
                j.b(e);
            }
        }
    }

    @Override // com.bytedance.tea.crash.b.b.a
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.tea.crash.b.b.a
    /* renamed from: b */
    public ContentValues aY(com.bytedance.tea.crash.b.a.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.f7620a);
        contentValues.put("insert_time", Long.valueOf(aVar.f7621b));
        return contentValues;
    }
}
