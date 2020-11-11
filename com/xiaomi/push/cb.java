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
    private static volatile cb f4829a;

    /* renamed from: a  reason: collision with other field name */
    private Context f147a;

    /* renamed from: a  reason: collision with other field name */
    private ca f148a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f150a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f151a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f149a = new ArrayList<>();

    /* loaded from: classes12.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f153a;

        /* renamed from: a  reason: collision with other field name */
        private String f154a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f155a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f152a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f156a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f4830a = 0;

        public a(String str) {
            this.f154a = str;
        }

        public SQLiteDatabase a() {
            return this.f152a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m198a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m199a() {
            return this.f154a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f153a != null) {
                this.f153a.a(context, m198a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f152a = bzVar;
            this.b = this.f152a.a();
            this.f155a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f153a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m200a() {
            return this.f152a == null || TextUtils.isEmpty(this.b) || this.f155a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f155a == null || (context = this.f155a.get()) == null || context.getFilesDir() == null || this.f152a == null || TextUtils.isEmpty(this.f154a)) {
                return;
            }
            File file = new File(this.f154a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes12.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f4831a;

        /* renamed from: a  reason: collision with other field name */
        private String f157a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f158a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f159a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f158a = list;
            this.f157a = str2;
            this.f159a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f4831a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f152a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f158a == null || this.f158a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f158a.size()];
                this.f158a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f157a, this.f159a, this.c, this.d, this.e, this.f4831a <= 0 ? null : String.valueOf(this.f4831a));
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
        private ArrayList<a> f4832a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.f4832a = new ArrayList<>();
            this.f4832a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cb.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f4832a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f4832a.iterator();
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
        private String f4833a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f160a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f4833a = str2;
            this.f160a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f4833a, this.f160a);
        }
    }

    /* loaded from: classes12.dex */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f4834a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f4834a = contentValues;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.f4834a);
        }
    }

    private cb(Context context) {
        this.f147a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f150a.get(str);
        if (bzVar == null) {
            synchronized (this.f150a) {
                if (bzVar == null) {
                    bzVar = this.f148a.a(this.f147a, str);
                    this.f150a.put(str, bzVar);
                }
            }
        }
        return bzVar;
    }

    public static cb a(Context context) {
        if (f4829a == null) {
            synchronized (cb.class) {
                if (f4829a == null) {
                    f4829a = new cb(context);
                }
            }
        }
        return f4829a;
    }

    private void a() {
        ai.a(this.f147a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f147a).a(hr.StatDataProcessFrequency.a(), 5));
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
        if (this.f148a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m199a = aVar.m199a();
        synchronized (this.f150a) {
            bzVar = this.f150a.get(m199a);
            if (bzVar == null) {
                bzVar = this.f148a.a(this.f147a, m199a);
                this.f150a.put(m199a, bzVar);
            }
        }
        if (this.f151a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f147a);
        synchronized (this.f149a) {
            this.f149a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f151a.isShutdown()) {
            return;
        }
        this.f151a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f148a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f151a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m200a()) {
                next.a(a(next.m199a()), this.f147a);
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
                cVar.a(((a) arrayList3.get(0)).f152a, this.f147a);
                this.f151a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f148a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m199a = aVar.m199a();
        synchronized (this.f150a) {
            bzVar = this.f150a.get(m199a);
            if (bzVar == null) {
                bzVar = this.f148a.a(this.f147a, m199a);
                this.f150a.put(m199a, bzVar);
            }
        }
        if (this.f151a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f147a);
        a((Runnable) aVar);
    }
}
