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
public class cb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cb f14199a;

    /* renamed from: a  reason: collision with other field name */
    private Context f226a;

    /* renamed from: a  reason: collision with other field name */
    private ca f227a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f229a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f230a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f228a = new ArrayList<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f232a;

        /* renamed from: a  reason: collision with other field name */
        private String f233a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f234a;

        /* renamed from: b  reason: collision with root package name */
        protected String f14201b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f231a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f235a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f14200a = 0;

        public a(String str) {
            this.f233a = str;
        }

        public SQLiteDatabase a() {
            return this.f231a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m217a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m218a() {
            return this.f233a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f232a != null) {
                this.f232a.a(context, m217a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f231a = bzVar;
            this.f14201b = this.f231a.a();
            this.f234a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f232a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m219a() {
            return this.f231a == null || TextUtils.isEmpty(this.f14201b) || this.f234a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f234a == null || (context = this.f234a.get()) == null || context.getFilesDir() == null || this.f231a == null || TextUtils.isEmpty(this.f233a)) {
                return;
            }
            File file = new File(this.f233a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f14202a;

        /* renamed from: a  reason: collision with other field name */
        private String f236a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f237a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f238a;

        /* renamed from: b  reason: collision with root package name */
        private List<T> f14203b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f14203b = new ArrayList();
            this.f237a = list;
            this.f236a = str2;
            this.f238a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f14202a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f231a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f14203b.clear();
            if (this.f237a == null || this.f237a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f237a.size()];
                this.f237a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.f14201b, strArr, this.f236a, this.f238a, this.c, this.d, this.e, this.f14202a <= 0 ? null : String.valueOf(this.f14202a));
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.f14203b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.f14203b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes6.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f14204a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.f14204a = new ArrayList<>();
            this.f14204a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cb.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f14204a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f14204a.iterator();
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

        /* renamed from: a  reason: collision with root package name */
        private String f14205a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f239a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f14205a = str2;
            this.f239a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f14201b, this.f14205a, this.f239a);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f14206a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f14206a = contentValues;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f14201b, null, this.f14206a);
        }
    }

    private cb(Context context) {
        this.f226a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f229a.get(str);
        if (bzVar == null) {
            synchronized (this.f229a) {
                if (bzVar == null) {
                    bzVar = this.f227a.a(this.f226a, str);
                    this.f229a.put(str, bzVar);
                }
            }
        }
        return bzVar;
    }

    public static cb a(Context context) {
        if (f14199a == null) {
            synchronized (cb.class) {
                if (f14199a == null) {
                    f14199a = new cb(context);
                }
            }
        }
        return f14199a;
    }

    private void a() {
        ai.a(this.f226a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f226a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m216a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f227a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m218a = aVar.m218a();
        synchronized (this.f229a) {
            bzVar = this.f229a.get(m218a);
            if (bzVar == null) {
                bzVar = this.f227a.a(this.f226a, m218a);
                this.f229a.put(m218a, bzVar);
            }
        }
        if (this.f230a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f226a);
        synchronized (this.f228a) {
            this.f228a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f230a.isShutdown()) {
            return;
        }
        this.f230a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f227a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f230a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m219a()) {
                next.a(a(next.m218a()), this.f226a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m218a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m218a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f231a, this.f226a);
                this.f230a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f227a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m218a = aVar.m218a();
        synchronized (this.f229a) {
            bzVar = this.f229a.get(m218a);
            if (bzVar == null) {
                bzVar = this.f227a.a(this.f226a, m218a);
                this.f229a.put(m218a, bzVar);
            }
        }
        if (this.f230a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f226a);
        a((Runnable) aVar);
    }
}
