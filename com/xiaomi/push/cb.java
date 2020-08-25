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
/* loaded from: classes7.dex */
public class cb {
    private static volatile cb a;

    /* renamed from: a  reason: collision with other field name */
    private Context f149a;

    /* renamed from: a  reason: collision with other field name */
    private ca f150a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f152a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f153a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f151a = new ArrayList<>();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f155a;

        /* renamed from: a  reason: collision with other field name */
        private String f156a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f157a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f154a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f158a = new Random();
        private int a = 0;

        public a(String str) {
            this.f156a = str;
        }

        public SQLiteDatabase a() {
            return this.f154a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m198a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m199a() {
            return this.f156a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f155a != null) {
                this.f155a.a(context, m198a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f154a = bzVar;
            this.b = this.f154a.a();
            this.f157a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f155a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m200a() {
            return this.f154a == null || TextUtils.isEmpty(this.b) || this.f157a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f157a == null || (context = this.f157a.get()) == null || context.getFilesDir() == null || this.f154a == null || TextUtils.isEmpty(this.f156a)) {
                return;
            }
            File file = new File(this.f156a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f159a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f160a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f161a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f160a = list;
            this.f159a = str2;
            this.f161a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f154a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f160a == null || this.f160a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f160a.size()];
                this.f160a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f159a, this.f161a, this.c, this.d, this.e, this.a <= 0 ? null : String.valueOf(this.a));
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class d extends a {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f162a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f162a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f162a);
        }
    }

    /* loaded from: classes7.dex */
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
        this.f149a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f152a.get(str);
        if (bzVar == null) {
            synchronized (this.f152a) {
                if (bzVar == null) {
                    bzVar = this.f150a.a(this.f149a, str);
                    this.f152a.put(str, bzVar);
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
        ai.a(this.f149a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f149a).a(hr.StatDataProcessFrequency.a(), 5));
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
        if (this.f150a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m199a = aVar.m199a();
        synchronized (this.f152a) {
            bzVar = this.f152a.get(m199a);
            if (bzVar == null) {
                bzVar = this.f150a.a(this.f149a, m199a);
                this.f152a.put(m199a, bzVar);
            }
        }
        if (this.f153a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f149a);
        synchronized (this.f151a) {
            this.f151a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f153a.isShutdown()) {
            return;
        }
        this.f153a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f150a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f153a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m200a()) {
                next.a(a(next.m199a()), this.f149a);
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
                cVar.a(((a) arrayList3.get(0)).f154a, this.f149a);
                this.f153a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f150a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m199a = aVar.m199a();
        synchronized (this.f152a) {
            bzVar = this.f152a.get(m199a);
            if (bzVar == null) {
                bzVar = this.f150a.a(this.f149a, m199a);
                this.f152a.put(m199a, bzVar);
            }
        }
        if (this.f153a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f149a);
        a((Runnable) aVar);
    }
}
