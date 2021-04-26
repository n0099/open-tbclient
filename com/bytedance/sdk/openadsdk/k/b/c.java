package com.bytedance.sdk.openadsdk.k.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.bytedance.sdk.openadsdk.l.h;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f30189b;

    /* renamed from: c  reason: collision with root package name */
    public final d f30191c;

    /* renamed from: e  reason: collision with root package name */
    public volatile SQLiteStatement f30193e;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Map<String, a>> f30190a = new SparseArray<>(2);

    /* renamed from: d  reason: collision with root package name */
    public final Executor f30192d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));

    public c(Context context) {
        this.f30191c = new d(context.getApplicationContext());
        this.f30190a.put(0, new ConcurrentHashMap());
        this.f30190a.put(1, new ConcurrentHashMap());
    }

    private String b(int i2) {
        if (i2 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i2 << 1);
        sb.append("?");
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static c a(Context context) {
        if (f30189b == null) {
            synchronized (c.class) {
                if (f30189b == null) {
                    f30189b = new c(context);
                }
            }
        }
        return f30189b;
    }

    public a a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = this.f30190a.get(i2);
        a aVar = map == null ? null : map.get(str);
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor query = this.f30191c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i2)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    aVar = new a(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex("mime")), query.getInt(query.getColumnIndex(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH)), i2, query.getString(query.getColumnIndex("extra")));
                }
                query.close();
            }
            if (aVar != null && map != null) {
                map.put(str, aVar);
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(final a aVar) {
        if (aVar != null) {
            Map<String, a> map = this.f30190a.get(aVar.f30178d);
            if (map != null) {
                map.put(aVar.f30175a, aVar);
            }
            this.f30192d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f30193e != null) {
                            c.this.f30193e.clearBindings();
                        } else {
                            c.this.f30193e = c.this.f30191c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        c.this.f30193e.bindString(1, aVar.f30175a);
                        c.this.f30193e.bindString(2, aVar.f30176b);
                        c.this.f30193e.bindLong(3, aVar.f30177c);
                        c.this.f30193e.bindLong(4, aVar.f30178d);
                        c.this.f30193e.bindString(5, aVar.f30179e);
                        c.this.f30193e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(Collection<String> collection, int i2) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i3 = -1;
        Map<String, a> map = this.f30190a.get(i2);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i3++;
            strArr[i3] = str;
        }
        strArr[i3 + 1] = String.valueOf(i2);
        try {
            SQLiteDatabase writableDatabase = this.f30191c.getWritableDatabase();
            writableDatabase.delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void a(final int i2) {
        Map<String, a> map = this.f30190a.get(i2);
        if (map != null) {
            map.clear();
        }
        this.f30192d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f30191c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i2)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
