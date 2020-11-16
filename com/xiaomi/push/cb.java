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
/* loaded from: classes18.dex */
public class cb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cb f4829a;

    /* renamed from: a  reason: collision with other field name */
    private Context f150a;

    /* renamed from: a  reason: collision with other field name */
    private ca f151a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f153a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f154a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f152a = new ArrayList<>();

    /* loaded from: classes18.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f156a;

        /* renamed from: a  reason: collision with other field name */
        private String f157a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f158a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f155a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f159a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f4830a = 0;

        public a(String str) {
            this.f157a = str;
        }

        public SQLiteDatabase a() {
            return this.f155a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m201a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m202a() {
            return this.f157a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f156a != null) {
                this.f156a.a(context, m201a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f155a = bzVar;
            this.b = this.f155a.a();
            this.f158a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f156a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m203a() {
            return this.f155a == null || TextUtils.isEmpty(this.b) || this.f158a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f158a == null || (context = this.f158a.get()) == null || context.getFilesDir() == null || this.f155a == null || TextUtils.isEmpty(this.f157a)) {
                return;
            }
            File file = new File(this.f157a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes18.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f4831a;

        /* renamed from: a  reason: collision with other field name */
        private String f160a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f161a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f162a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f161a = list;
            this.f160a = str2;
            this.f162a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f4831a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f155a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f161a == null || this.f161a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f161a.size()];
                this.f161a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f160a, this.f162a, this.c, this.d, this.e, this.f4831a <= 0 ? null : String.valueOf(this.f4831a));
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

    /* loaded from: classes18.dex */
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

    /* loaded from: classes18.dex */
    public static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f4833a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f163a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f4833a = str2;
            this.f163a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.f4833a, this.f163a);
        }
    }

    /* loaded from: classes18.dex */
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
        this.f150a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f153a.get(str);
        if (bzVar == null) {
            synchronized (this.f153a) {
                if (bzVar == null) {
                    bzVar = this.f151a.a(this.f150a, str);
                    this.f153a.put(str, bzVar);
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
        ai.a(this.f150a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f150a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m200a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f151a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m202a = aVar.m202a();
        synchronized (this.f153a) {
            bzVar = this.f153a.get(m202a);
            if (bzVar == null) {
                bzVar = this.f151a.a(this.f150a, m202a);
                this.f153a.put(m202a, bzVar);
            }
        }
        if (this.f154a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f150a);
        synchronized (this.f152a) {
            this.f152a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f154a.isShutdown()) {
            return;
        }
        this.f154a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f151a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f154a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m203a()) {
                next.a(a(next.m202a()), this.f150a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m202a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m202a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f155a, this.f150a);
                this.f154a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f151a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m202a = aVar.m202a();
        synchronized (this.f153a) {
            bzVar = this.f153a.get(m202a);
            if (bzVar == null) {
                bzVar = this.f151a.a(this.f150a, m202a);
                this.f153a.put(m202a, bzVar);
            }
        }
        if (this.f154a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f150a);
        a((Runnable) aVar);
    }
}
