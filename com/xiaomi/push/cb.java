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
    private Context f152a;

    /* renamed from: a  reason: collision with other field name */
    private ca f153a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f155a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f156a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f154a = new ArrayList<>();

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f158a;

        /* renamed from: a  reason: collision with other field name */
        private String f159a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f160a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f157a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f161a = new Random();
        private int a = 0;

        public a(String str) {
            this.f159a = str;
        }

        public SQLiteDatabase a() {
            return this.f157a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m192a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m193a() {
            return this.f159a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f158a != null) {
                this.f158a.a(context, m192a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f157a = bzVar;
            this.b = this.f157a.a();
            this.f160a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f158a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m194a() {
            return this.f157a == null || TextUtils.isEmpty(this.b) || this.f160a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f160a == null || (context = this.f160a.get()) == null || context.getFilesDir() == null || this.f157a == null || TextUtils.isEmpty(this.f159a)) {
                return;
            }
            File file = new File(this.f159a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f162a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f163a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f164a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f163a = list;
            this.f162a = str2;
            this.f164a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f157a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f163a == null || this.f163a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f163a.size()];
                this.f163a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f162a, this.f164a, this.c, this.d, this.e, this.a <= 0 ? null : String.valueOf(this.a));
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
        protected String[] f165a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f165a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f165a);
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
        this.f152a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f155a.get(str);
        if (bzVar == null) {
            synchronized (this.f155a) {
                if (bzVar == null) {
                    bzVar = this.f153a.a(this.f152a, str);
                    this.f155a.put(str, bzVar);
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
        ai.a(this.f152a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f152a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m191a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f153a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m193a = aVar.m193a();
        synchronized (this.f155a) {
            bzVar = this.f155a.get(m193a);
            if (bzVar == null) {
                bzVar = this.f153a.a(this.f152a, m193a);
                this.f155a.put(m193a, bzVar);
            }
        }
        if (this.f156a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f152a);
        synchronized (this.f154a) {
            this.f154a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f156a.isShutdown()) {
            return;
        }
        this.f156a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f153a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f156a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m194a()) {
                next.a(a(next.m193a()), this.f152a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m193a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m193a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f157a, this.f152a);
                this.f156a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f153a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m193a = aVar.m193a();
        synchronized (this.f155a) {
            bzVar = this.f155a.get(m193a);
            if (bzVar == null) {
                bzVar = this.f153a.a(this.f152a, m193a);
                this.f155a.put(m193a, bzVar);
            }
        }
        if (this.f156a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f152a);
        a((Runnable) aVar);
    }
}
