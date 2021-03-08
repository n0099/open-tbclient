package com.bytedance.sdk.openadsdk.i.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.bytedance.sdk.openadsdk.j.h;
import com.kwai.video.player.misc.IMediaFormat;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class c {
    private static volatile c b;
    private final d c;
    private volatile SQLiteStatement e;

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<Map<String, a>> f4814a = new SparseArray<>(2);
    private final Executor d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));

    private c(Context context) {
        this.c = new d(context.getApplicationContext());
        this.f4814a.put(0, new ConcurrentHashMap());
        this.f4814a.put(1, new ConcurrentHashMap());
    }

    public static c a(Context context) {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c(context);
                }
            }
        }
        return b;
    }

    public a a(String str, int i) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = this.f4814a.get(i);
        a aVar2 = map == null ? null : map.get(str);
        if (aVar2 != null) {
            return aVar2;
        }
        try {
            Cursor query = this.c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (query != null) {
                aVar = (query.getCount() <= 0 || !query.moveToNext()) ? aVar2 : new a(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex(IMediaFormat.KEY_MIME)), query.getInt(query.getColumnIndex("contentLength")), i, query.getString(query.getColumnIndex("extra")));
                query.close();
            } else {
                aVar = aVar2;
            }
            if (aVar != null && map != null) {
                map.put(str, aVar);
                return aVar;
            }
            return aVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public void a(final a aVar) {
        if (aVar != null) {
            Map<String, a> map = this.f4814a.get(aVar.d);
            if (map != null) {
                map.put(aVar.f4812a, aVar);
            }
            this.d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.e != null) {
                            c.this.e.clearBindings();
                        } else {
                            c.this.e = c.this.c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        }
                        c.this.e.bindString(1, aVar.f4812a);
                        c.this.e.bindString(2, aVar.b);
                        c.this.e.bindLong(3, aVar.c);
                        c.this.e.bindLong(4, aVar.d);
                        c.this.e.bindString(5, aVar.e);
                        c.this.e.executeInsert();
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }

    public void a(Collection<String> collection, int i) {
        if (collection != null && !collection.isEmpty()) {
            String[] strArr = new String[collection.size() + 1];
            Map<String, a> map = this.f4814a.get(i);
            int i2 = -1;
            for (String str : collection) {
                if (map != null) {
                    map.remove(str);
                }
                i2++;
                strArr[i2] = str;
            }
            strArr[i2 + 1] = String.valueOf(i);
            try {
                this.c.getWritableDatabase().delete("video_http_header_t", "key IN(" + b(strArr.length) + ") AND " + FrsActivityConfig.FLAG + "=?", strArr);
            } catch (Throwable th) {
            }
        }
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

    public void a(final int i) {
        Map<String, a> map = this.f4814a.get(i);
        if (map != null) {
            map.clear();
        }
        this.d.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.i.b.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable th) {
                }
            }
        });
    }
}
