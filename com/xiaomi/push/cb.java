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
    private Context f148a;

    /* renamed from: a  reason: collision with other field name */
    private ca f149a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f151a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f152a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f150a = new ArrayList<>();

    /* loaded from: classes12.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f154a;

        /* renamed from: a  reason: collision with other field name */
        private String f155a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f156a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f153a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f157a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f4830a = 0;

        public a(String str) {
            this.f155a = str;
        }

        public SQLiteDatabase a() {
            return this.f153a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m199a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m200a() {
            return this.f155a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f154a != null) {
                this.f154a.a(context, m199a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f153a = bzVar;
            this.b = this.f153a.a();
            this.f156a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f154a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m201a() {
            return this.f153a == null || TextUtils.isEmpty(this.b) || this.f156a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f156a == null || (context = this.f156a.get()) == null || context.getFilesDir() == null || this.f153a == null || TextUtils.isEmpty(this.f155a)) {
                return;
            }
            File file = new File(this.f155a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes12.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f4831a;

        /* renamed from: a  reason: collision with other field name */
        private String f158a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f159a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f160a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f159a = list;
            this.f158a = str2;
            this.f160a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f4831a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f153a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f159a == null || this.f159a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f159a.size()];
                this.f159a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f158a, this.f160a, this.c, this.d, this.e, this.f4831a <= 0 ? null : String.valueOf(this.f4831a));
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
        protected String[] f161a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f4833a = str2;
            this.f161a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f4833a, this.f161a);
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
        this.f148a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f151a.get(str);
        if (bzVar == null) {
            synchronized (this.f151a) {
                if (bzVar == null) {
                    bzVar = this.f149a.a(this.f148a, str);
                    this.f151a.put(str, bzVar);
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
        ai.a(this.f148a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f148a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m198a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f149a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m200a = aVar.m200a();
        synchronized (this.f151a) {
            bzVar = this.f151a.get(m200a);
            if (bzVar == null) {
                bzVar = this.f149a.a(this.f148a, m200a);
                this.f151a.put(m200a, bzVar);
            }
        }
        if (this.f152a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f148a);
        synchronized (this.f150a) {
            this.f150a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f152a.isShutdown()) {
            return;
        }
        this.f152a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f149a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f152a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m201a()) {
                next.a(a(next.m200a()), this.f148a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m200a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m200a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f153a, this.f148a);
                this.f152a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f149a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m200a = aVar.m200a();
        synchronized (this.f151a) {
            bzVar = this.f151a.get(m200a);
            if (bzVar == null) {
                bzVar = this.f149a.a(this.f148a, m200a);
                this.f151a.put(m200a, bzVar);
            }
        }
        if (this.f152a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f148a);
        a((Runnable) aVar);
    }
}
