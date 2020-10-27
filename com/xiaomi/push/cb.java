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
/* loaded from: classes12.dex */
public class cb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cb f4827a;

    /* renamed from: a  reason: collision with other field name */
    private Context f145a;

    /* renamed from: a  reason: collision with other field name */
    private ca f146a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f148a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f149a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f147a = new ArrayList<>();

    /* loaded from: classes12.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f151a;

        /* renamed from: a  reason: collision with other field name */
        private String f152a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f153a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f150a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f154a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f4828a = 0;

        public a(String str) {
            this.f152a = str;
        }

        public SQLiteDatabase a() {
            return this.f150a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m198a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m199a() {
            return this.f152a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f151a != null) {
                this.f151a.a(context, m198a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f150a = bzVar;
            this.b = this.f150a.a();
            this.f153a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f151a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m200a() {
            return this.f150a == null || TextUtils.isEmpty(this.b) || this.f153a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f153a == null || (context = this.f153a.get()) == null || context.getFilesDir() == null || this.f150a == null || TextUtils.isEmpty(this.f152a)) {
                return;
            }
            File file = new File(this.f152a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes12.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f4829a;

        /* renamed from: a  reason: collision with other field name */
        private String f155a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f156a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f157a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f156a = list;
            this.f155a = str2;
            this.f157a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f4829a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f150a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f156a == null || this.f156a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f156a.size()];
                this.f156a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f155a, this.f157a, this.c, this.d, this.e, this.f4829a <= 0 ? null : String.valueOf(this.f4829a));
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes12.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f4830a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.f4830a = new ArrayList<>();
            this.f4830a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cb.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f4830a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f4830a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f4831a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f158a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f4831a = str2;
            this.f158a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f4831a, this.f158a);
        }
    }

    /* loaded from: classes12.dex */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f4832a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f4832a = contentValues;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.f4832a);
        }
    }

    private cb(Context context) {
        this.f145a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f148a.get(str);
        if (bzVar == null) {
            synchronized (this.f148a) {
                if (bzVar == null) {
                    bzVar = this.f146a.a(this.f145a, str);
                    this.f148a.put(str, bzVar);
                }
            }
        }
        return bzVar;
    }

    public static cb a(Context context) {
        if (f4827a == null) {
            synchronized (cb.class) {
                if (f4827a == null) {
                    f4827a = new cb(context);
                }
            }
        }
        return f4827a;
    }

    private void a() {
        ai.a(this.f145a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f145a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m197a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f146a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m199a = aVar.m199a();
        synchronized (this.f148a) {
            bzVar = this.f148a.get(m199a);
            if (bzVar == null) {
                bzVar = this.f146a.a(this.f145a, m199a);
                this.f148a.put(m199a, bzVar);
            }
        }
        if (this.f149a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f145a);
        synchronized (this.f147a) {
            this.f147a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f149a.isShutdown()) {
            return;
        }
        this.f149a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f146a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f149a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m200a()) {
                next.a(a(next.m199a()), this.f145a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m199a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m199a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f150a, this.f145a);
                this.f149a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f146a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m199a = aVar.m199a();
        synchronized (this.f148a) {
            bzVar = this.f148a.get(m199a);
            if (bzVar == null) {
                bzVar = this.f146a.a(this.f145a, m199a);
                this.f148a.put(m199a, bzVar);
            }
        }
        if (this.f149a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f145a);
        a((Runnable) aVar);
    }
}
