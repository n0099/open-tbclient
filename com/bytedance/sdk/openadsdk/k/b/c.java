package com.bytedance.sdk.openadsdk.k.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.bytedance.sdk.openadsdk.l.h;
import com.kwai.video.player.misc.IMediaFormat;
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
    public static volatile c f29281b;

    /* renamed from: c  reason: collision with root package name */
    public final d f29283c;

    /* renamed from: e  reason: collision with root package name */
    public volatile SQLiteStatement f29285e;

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray<Map<String, a>> f29282a = new SparseArray<>(2);

    /* renamed from: d  reason: collision with root package name */
    public final Executor f29284d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));

    public c(Context context) {
        this.f29283c = new d(context.getApplicationContext());
        this.f29282a.put(0, new ConcurrentHashMap());
        this.f29282a.put(1, new ConcurrentHashMap());
    }

    private String b(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static c a(Context context) {
        if (f29281b == null) {
            synchronized (c.class) {
                if (f29281b == null) {
                    f29281b = new c(context);
                }
            }
        }
        return f29281b;
    }

    public a a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = this.f29282a.get(i);
        a aVar = map == null ? null : map.get(str);
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor query = this.f29283c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    aVar = new a(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex(IMediaFormat.KEY_MIME)), query.getInt(query.getColumnIndex(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH)), i, query.getString(query.getColumnIndex("extra")));
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
            Map<String, a> map = this.f29282a.get(aVar.f29271d);
            if (map != null) {
                map.put(aVar.f29268a, aVar);
            }
            this.f29284d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f29285e != null) {
                            c.this.f29285e.clearBindings();
                        } else {
                            c.this.f29285e = c.this.f29283c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        c.this.f29285e.bindString(1, aVar.f29268a);
                        c.this.f29285e.bindString(2, aVar.f29269b);
                        c.this.f29285e.bindLong(3, aVar.f29270c);
                        c.this.f29285e.bindLong(4, aVar.f29271d);
                        c.this.f29285e.bindString(5, aVar.f29272e);
                        c.this.f29285e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(Collection<String> collection, int i) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        int i2 = -1;
        Map<String, a> map = this.f29282a.get(i);
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i2++;
            strArr[i2] = str;
        }
        strArr[i2 + 1] = String.valueOf(i);
        try {
            SQLiteDatabase writableDatabase = this.f29283c.getWritableDatabase();
            writableDatabase.delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }

    public void a(final int i) {
        Map<String, a> map = this.f29282a.get(i);
        if (map != null) {
            map.clear();
        }
        this.f29284d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f29283c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
