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
/* loaded from: classes8.dex */
public class cb {
    private static volatile cb a;

    /* renamed from: a  reason: collision with other field name */
    private Context f146a;

    /* renamed from: a  reason: collision with other field name */
    private ca f147a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f149a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f150a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f148a = new ArrayList<>();

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f152a;

        /* renamed from: a  reason: collision with other field name */
        private String f153a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f154a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f151a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f155a = new Random();
        private int a = 0;

        public a(String str) {
            this.f153a = str;
        }

        public SQLiteDatabase a() {
            return this.f151a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m196a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m197a() {
            return this.f153a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f152a != null) {
                this.f152a.a(context, m196a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f151a = bzVar;
            this.b = this.f151a.a();
            this.f154a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f152a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m198a() {
            return this.f151a == null || TextUtils.isEmpty(this.b) || this.f154a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f154a == null || (context = this.f154a.get()) == null || context.getFilesDir() == null || this.f151a == null || TextUtils.isEmpty(this.f153a)) {
                return;
            }
            File file = new File(this.f153a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f156a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f157a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f158a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f157a = list;
            this.f156a = str2;
            this.f158a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f151a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f157a == null || this.f157a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f157a.size()];
                this.f157a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f156a, this.f158a, this.c, this.d, this.e, this.a <= 0 ? null : String.valueOf(this.a));
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

    /* loaded from: classes8.dex */
    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.a = new ArrayList<>();
            this.a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cb.a
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

        @Override // com.xiaomi.push.cb.a
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

    /* loaded from: classes8.dex */
    public static class d extends a {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f159a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f159a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f159a);
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private cb(Context context) {
        this.f146a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f149a.get(str);
        if (bzVar == null) {
            synchronized (this.f149a) {
                if (bzVar == null) {
                    bzVar = this.f147a.a(this.f146a, str);
                    this.f149a.put(str, bzVar);
                }
            }
        }
        return bzVar;
    }

    public static cb a(Context context) {
        if (a == null) {
            synchronized (cb.class) {
                if (a == null) {
                    a = new cb(context);
                }
            }
        }
        return a;
    }

    private void a() {
        ai.a(this.f146a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f146a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m195a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f147a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m197a = aVar.m197a();
        synchronized (this.f149a) {
            bzVar = this.f149a.get(m197a);
            if (bzVar == null) {
                bzVar = this.f147a.a(this.f146a, m197a);
                this.f149a.put(m197a, bzVar);
            }
        }
        if (this.f150a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f146a);
        synchronized (this.f148a) {
            this.f148a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f150a.isShutdown()) {
            return;
        }
        this.f150a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f147a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f150a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m198a()) {
                next.a(a(next.m197a()), this.f146a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m197a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m197a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f151a, this.f146a);
                this.f150a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f147a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m197a = aVar.m197a();
        synchronized (this.f149a) {
            bzVar = this.f149a.get(m197a);
            if (bzVar == null) {
                bzVar = this.f147a.a(this.f146a, m197a);
                this.f149a.put(m197a, bzVar);
            }
        }
        if (this.f150a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f146a);
        a((Runnable) aVar);
    }
}
