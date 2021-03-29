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
public class cg {

    /* renamed from: a  reason: collision with root package name */
    public static volatile cg f40308a;

    /* renamed from: a  reason: collision with other field name */
    public Context f170a;

    /* renamed from: a  reason: collision with other field name */
    public cf f171a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, ce> f173a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public ThreadPoolExecutor f174a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f172a = new ArrayList<>();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public a f176a;

        /* renamed from: a  reason: collision with other field name */
        public String f177a;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<Context> f178a;

        /* renamed from: b  reason: collision with root package name */
        public String f40310b;

        /* renamed from: a  reason: collision with other field name */
        public ce f175a = null;

        /* renamed from: a  reason: collision with other field name */
        public Random f179a = new Random();

        /* renamed from: a  reason: collision with root package name */
        public int f40309a = 0;

        public a(String str) {
            this.f177a = str;
        }

        public SQLiteDatabase a() {
            return this.f175a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m196a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m197a() {
            return this.f177a;
        }

        public void a(Context context) {
            a aVar = this.f176a;
            if (aVar != null) {
                aVar.a(context, m196a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cg.a(context).a(this);
        }

        public void a(ce ceVar, Context context) {
            this.f175a = ceVar;
            this.f40310b = ceVar.a();
            this.f178a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f176a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m198a() {
            return this.f175a == null || TextUtils.isEmpty(this.f40310b) || this.f178a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f178a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f175a == null || TextUtils.isEmpty(this.f177a)) {
                return;
            }
            File file = new File(this.f177a);
            v.a(context, new File(file.getParentFile(), bl.b(file.getAbsolutePath())), new ci(this, context));
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        public int f40311a;

        /* renamed from: a  reason: collision with other field name */
        public String f180a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f181a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f182a;

        /* renamed from: b  reason: collision with root package name */
        public List<T> f40312b;

        /* renamed from: c  reason: collision with root package name */
        public String f40313c;

        /* renamed from: d  reason: collision with root package name */
        public String f40314d;

        /* renamed from: e  reason: collision with root package name */
        public String f40315e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f40312b = new ArrayList();
            this.f181a = list;
            this.f180a = str2;
            this.f182a = strArr;
            this.f40313c = str3;
            this.f40314d = str4;
            this.f40315e = str5;
            this.f40311a = i;
        }

        @Override // com.xiaomi.push.cg.a
        public SQLiteDatabase a() {
            return ((a) this).f175a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f40312b.clear();
            List<String> list = this.f181a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f181a.size()];
                this.f181a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.f40311a;
            Cursor query = sQLiteDatabase.query(super.f40310b, strArr, this.f180a, this.f182a, this.f40313c, this.f40314d, this.f40315e, i > 0 ? String.valueOf(i) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.f40312b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.f40312b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes7.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<a> f40316a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f40316a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cg.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f40316a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f40316a.iterator();
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

        /* renamed from: a  reason: collision with root package name */
        public String f40317a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f183a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f40317a = str2;
            this.f183a = strArr;
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f40310b, this.f40317a, this.f183a);
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        public ContentValues f40318a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f40318a = contentValues;
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f40310b, null, this.f40318a);
        }
    }

    public cg(Context context) {
        this.f170a = context;
    }

    private ce a(String str) {
        ce ceVar = this.f173a.get(str);
        if (ceVar == null) {
            synchronized (this.f173a) {
                if (ceVar == null) {
                    ceVar = this.f171a.a(this.f170a, str);
                    this.f173a.put(str, ceVar);
                }
            }
        }
        return ceVar;
    }

    public static cg a(Context context) {
        if (f40308a == null) {
            synchronized (cg.class) {
                if (f40308a == null) {
                    f40308a = new cg(context);
                }
            }
        }
        return f40308a;
    }

    private void a() {
        ai.a(this.f170a).b(new ch(this), com.xiaomi.push.service.aq.a(this.f170a).a(hk.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m195a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        ce ceVar;
        if (aVar == null) {
            return;
        }
        if (this.f171a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m197a = aVar.m197a();
        synchronized (this.f173a) {
            ceVar = this.f173a.get(m197a);
            if (ceVar == null) {
                ceVar = this.f171a.a(this.f170a, m197a);
                this.f173a.put(m197a, ceVar);
            }
        }
        if (this.f174a.isShutdown()) {
            return;
        }
        aVar.a(ceVar, this.f170a);
        synchronized (this.f172a) {
            this.f172a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f174a.isShutdown()) {
            return;
        }
        this.f174a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f171a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f174a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m198a()) {
                next.a(a(next.m197a()), this.f170a);
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
                cVar.a(((a) arrayList3.get(0)).f175a, this.f170a);
                this.f174a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        ce ceVar;
        if (aVar == null) {
            return;
        }
        if (this.f171a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m197a = aVar.m197a();
        synchronized (this.f173a) {
            ceVar = this.f173a.get(m197a);
            if (ceVar == null) {
                ceVar = this.f171a.a(this.f170a, m197a);
                this.f173a.put(m197a, ceVar);
            }
        }
        if (this.f174a.isShutdown()) {
            return;
        }
        aVar.a(ceVar, this.f170a);
        a((Runnable) aVar);
    }
}
