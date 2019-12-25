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
/* loaded from: classes5.dex */
public class bw {
    private static volatile bw a;

    /* renamed from: a  reason: collision with other field name */
    private Context f164a;

    /* renamed from: a  reason: collision with other field name */
    private bv f165a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bu> f167a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f168a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f166a = new ArrayList<>();

    /* loaded from: classes5.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f170a;

        /* renamed from: a  reason: collision with other field name */
        private String f171a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f172a;
        protected String b;

        /* renamed from: a  reason: collision with other field name */
        protected bu f169a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f173a = new Random();
        private int a = 0;

        public a(String str) {
            this.f171a = str;
        }

        public SQLiteDatabase a() {
            return this.f169a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m154a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m155a() {
            return this.f171a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f170a != null) {
                this.f170a.a(context, m154a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            bw.a(context).a(this);
        }

        void a(bu buVar, Context context) {
            this.f169a = buVar;
            this.b = this.f169a.a();
            this.f172a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f170a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m156a() {
            return this.f169a == null || TextUtils.isEmpty(this.b) || this.f172a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f172a == null || (context = this.f172a.get()) == null || context.getFilesDir() == null || this.f169a == null || TextUtils.isEmpty(this.f171a)) {
                return;
            }
            File file = new File(this.f171a);
            v.a(context, new File(file.getParentFile(), ax.b(file.getAbsolutePath())), new by(this, context));
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f174a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f175a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f176a;
        private List<T> b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f175a = list;
            this.f174a = str2;
            this.f176a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.bw.a
        public SQLiteDatabase a() {
            return this.f169a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            if (this.f175a == null || this.f175a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f175a.size()];
                this.f175a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f174a, this.f176a, this.c, this.d, this.e, this.a <= 0 ? null : String.valueOf(this.a));
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public static class d extends a {
        private String a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f177a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f177a = strArr;
        }

        @Override // com.xiaomi.push.bw.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f177a);
        }
    }

    /* loaded from: classes5.dex */
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
        this.f164a = context;
    }

    private bu a(String str) {
        bu buVar = this.f167a.get(str);
        if (buVar == null) {
            synchronized (this.f167a) {
                if (buVar == null) {
                    buVar = this.f165a.a(this.f164a, str);
                    this.f167a.put(str, buVar);
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
        ai.a(this.f164a).b(new bx(this), com.xiaomi.push.service.ag.a(this.f164a).a(hl.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m153a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bu buVar;
        if (aVar == null) {
            return;
        }
        if (this.f165a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m155a = aVar.m155a();
        synchronized (this.f167a) {
            buVar = this.f167a.get(m155a);
            if (buVar == null) {
                buVar = this.f165a.a(this.f164a, m155a);
                this.f167a.put(m155a, buVar);
            }
        }
        if (this.f168a.isShutdown()) {
            return;
        }
        aVar.a(buVar, this.f164a);
        synchronized (this.f166a) {
            this.f166a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f168a.isShutdown()) {
            return;
        }
        this.f168a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f165a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f168a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m156a()) {
                next.a(a(next.m155a()), this.f164a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m155a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m155a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f169a, this.f164a);
                this.f168a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bu buVar;
        if (aVar == null) {
            return;
        }
        if (this.f165a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m155a = aVar.m155a();
        synchronized (this.f167a) {
            buVar = this.f167a.get(m155a);
            if (buVar == null) {
                buVar = this.f165a.a(this.f164a, m155a);
                this.f167a.put(m155a, buVar);
            }
        }
        if (this.f168a.isShutdown()) {
            return;
        }
        aVar.a(buVar, this.f164a);
        a((Runnable) aVar);
    }
}
