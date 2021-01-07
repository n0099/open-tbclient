package com.bytedance.tea.crash.b.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.IMConstants;
import com.bytedance.tea.crash.g.j;
import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final String f7922a = IMConstants.MSG_ROW_ID;

    /* renamed from: b  reason: collision with root package name */
    protected final String f7923b;

    protected abstract HashMap<String, String> a();

    protected abstract ContentValues aY(T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str) {
        this.f7923b = str;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.f7923b).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> a2 = a();
            if (a2 != null) {
                for (String str : a2.keySet()) {
                    sb.append(str).append(" ").append(a2.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase != null && t != null) {
            try {
                sQLiteDatabase.insert(this.f7923b, null, aY(t));
            } catch (Exception e) {
                j.b(e);
            }
        }
    }
}
