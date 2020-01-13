package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class bw {
    private static volatile bw a;

    /* renamed from: a  reason: collision with other field name */
    private Context f162a;

    /* renamed from: a  reason: collision with other field name */
    private bv f163a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bu> f165a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f166a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f164a = new ArrayList<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f168a;

        /* renamed from: a  reason: collision with other field name */
        private String f169a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f170a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bu f167a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f171a = new Random();
        private int a = 0;

        public a(String str) {
            this.f169a = str;
        }

        public SQLiteDatabase a() {
            return this.f167a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m163a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m164a() {
            return this.f169a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f168a != null) {
                this.f168a.a(context, m163a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            bw.a(context).a(this);
        }

        void a(bu buVar, Context context) {
            this.f167a = buVar;
            this.b = this.f167a.a();
            this.f170a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f168a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m165a() {
            return this.f167a == null || TextUtils.isEmpty(this.b) || this.f170a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f170a == null || (context = this.f170a.get()) == null || context.getFilesDir() == null || this.f167a == null || TextUtils.isEmpty(this.f169a)) {
                return;
            }
            File file = new File(this.f169a);
            v.a(context, new File(file.getParentFile(), ax.b(file.getAbsolutePath())), new by(this, context));
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f172a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f173a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f174a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f173a = list;
            this.f172a = str2;
            this.f174a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.bw.a
        public SQLiteDatabase a() {
            return this.f167a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f173a == null || this.f173a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f173a.size()];
                this.f173a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f172a, this.f174a, this.c, this.d, this.e, this.a <= 0 ? null : String.valueOf(this.a));
            if (query != null && query.moveToFirst()) {
                do {
                    T a = a(context, query);
                    if (a != null) {
                        this.b.add(a);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes6.dex */
    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.a = new ArrayList<>();
            this.a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bw.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d extends a {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f175a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f175a = strArr;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f175a);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private bw(Context context) {
        this.f162a = context;
    }

    private bu a(String str) {
        bu buVar = this.f165a.get(str);
        if (buVar == null) {
            synchronized (this.f165a) {
                if (buVar == null) {
                    buVar = this.f163a.a(this.f162a, str);
                    this.f165a.put(str, buVar);
                }
            }
        }
        return buVar;
    }

    public static bw a(Context context) {
        if (a == null) {
            synchronized (bw.class) {
                if (a == null) {
                    a = new bw(context);
                }
            }
        }
        return a;
    }

    private void a() {
        ai.a(this.f162a).b(new bx(this), com.xiaomi.push.service.ag.a(this.f162a).a(hl.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m162a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bu buVar;
        if (aVar == null) {
            return;
        }
        if (this.f163a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m164a = aVar.m164a();
        synchronized (this.f165a) {
            buVar = this.f165a.get(m164a);
            if (buVar == null) {
                buVar = this.f163a.a(this.f162a, m164a);
                this.f165a.put(m164a, buVar);
            }
        }
        if (this.f166a.isShutdown()) {
            return;
        }
        aVar.a(buVar, this.f162a);
        synchronized (this.f164a) {
            this.f164a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f166a.isShutdown()) {
            return;
        }
        this.f166a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f163a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f166a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m165a()) {
                next.a(a(next.m164a()), this.f162a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m164a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m164a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f167a, this.f162a);
                this.f166a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bu buVar;
        if (aVar == null) {
            return;
        }
        if (this.f163a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m164a = aVar.m164a();
        synchronized (this.f165a) {
            buVar = this.f165a.get(m164a);
            if (buVar == null) {
                buVar = this.f163a.a(this.f162a, m164a);
                this.f165a.put(m164a, buVar);
            }
        }
        if (this.f166a.isShutdown()) {
            return;
        }
        aVar.a(buVar, this.f162a);
        a((Runnable) aVar);
    }
}
