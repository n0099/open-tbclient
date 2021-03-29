package com.bytedance.sdk.openadsdk.m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public Context f29797a;

    public g(Context context) {
        this.f29797a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.m.f
    public synchronized List<e> a() {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f29797a, "trackurl", null, null, null, null, null, null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                linkedList.add(new e(a2.getString(a2.getColumnIndex("id")), a2.getString(a2.getColumnIndex("url")), a2.getInt(a2.getColumnIndex("replaceholder")) > 0, a2.getInt(a2.getColumnIndex(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM))));
            }
            if (a2 != null) {
                a2.close();
            }
        }
        return linkedList;
    }

    @Override // com.bytedance.sdk.openadsdk.m.f
    public synchronized void b(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", eVar.a());
        contentValues.put("url", eVar.b());
        contentValues.put("replaceholder", Integer.valueOf(eVar.c() ? 1 : 0));
        contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, Integer.valueOf(eVar.d()));
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f29797a, "trackurl", contentValues, "id=?", new String[]{eVar.a()});
    }

    @Override // com.bytedance.sdk.openadsdk.m.f
    public synchronized void c(e eVar) {
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f29797a, "trackurl", "id=?", new String[]{eVar.a()});
    }

    public static String b() {
        return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " INTEGER default 0" + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // com.bytedance.sdk.openadsdk.m.f
    public synchronized void a(e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", eVar.a());
        contentValues.put("url", eVar.b());
        contentValues.put("replaceholder", Integer.valueOf(eVar.c() ? 1 : 0));
        contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, Integer.valueOf(eVar.d()));
        com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f29797a, "trackurl", contentValues);
    }
}
