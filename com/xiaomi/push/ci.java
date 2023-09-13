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
/* loaded from: classes10.dex */
public class ci {
    public static volatile ci a;

    /* renamed from: a  reason: collision with other field name */
    public Context f165a;

    /* renamed from: a  reason: collision with other field name */
    public ch f166a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap<String, cg> f168a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public ThreadPoolExecutor f169a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f167a = new ArrayList<>();

    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public a f171a;

        /* renamed from: a  reason: collision with other field name */
        public String f172a;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<Context> f173a;
        public String b;

        /* renamed from: a  reason: collision with other field name */
        public cg f170a = null;

        /* renamed from: a  reason: collision with other field name */
        public Random f174a = new Random();
        public int a = 0;

        public a(String str) {
            this.f172a = str;
        }

        public SQLiteDatabase a() {
            return this.f170a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object mo332a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m333a() {
            return this.f172a;
        }

        public void a(Context context) {
            a aVar = this.f171a;
            if (aVar != null) {
                aVar.a(context, mo332a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            ci.a(context).a(this);
        }

        public void a(cg cgVar, Context context) {
            this.f170a = cgVar;
            this.b = cgVar.a();
            this.f173a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f171a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m334a() {
            return this.f170a == null || TextUtils.isEmpty(this.b) || this.f173a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f173a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f170a == null || TextUtils.isEmpty(this.f172a)) {
                return;
            }
            File file = new File(this.f172a);
            v.a(context, new File(file.getParentFile(), bn.b(file.getAbsolutePath())), new ck(this, context));
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b<T> extends a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public String f175a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f176a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f177a;
        public List<T> b;
        public String c;
        public String d;
        public String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f176a = list;
            this.f175a = str2;
            this.f177a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.ci.a
        public SQLiteDatabase a() {
            return ((a) this).f170a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.ci.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f176a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f176a.size()];
                this.f176a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.a;
            Cursor query = sQLiteDatabase.query(super.b, strArr, this.f175a, this.f177a, this.c, this.d, this.e, i > 0 ? String.valueOf(i) : null);
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

    /* loaded from: classes10.dex */
    public static class c extends a {
        public ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.ci.a
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

        @Override // com.xiaomi.push.ci.a
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

    /* loaded from: classes10.dex */
    public static class d extends a {
        public String a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f178a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f178a = strArr;
        }

        @Override // com.xiaomi.push.ci.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f178a);
        }
    }

    /* loaded from: classes10.dex */
    public static class e extends a {
        public ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.ci.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    public ci(Context context) {
        this.f165a = context;
    }

    private cg a(String str) {
        cg cgVar = this.f168a.get(str);
        if (cgVar == null) {
            synchronized (this.f168a) {
                if (cgVar == null) {
                    cgVar = this.f166a.a(this.f165a, str);
                    this.f168a.put(str, cgVar);
                }
            }
        }
        return cgVar;
    }

    public static ci a(Context context) {
        if (a == null) {
            synchronized (ci.class) {
                if (a == null) {
                    a = new ci(context);
                }
            }
        }
        return a;
    }

    private void a() {
        aj.a(this.f165a).b(new cj(this), com.xiaomi.push.service.ba.a(this.f165a).a(hm.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m331a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        cg cgVar;
        if (aVar == null) {
            return;
        }
        if (this.f166a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m333a = aVar.m333a();
        synchronized (this.f168a) {
            cgVar = this.f168a.get(m333a);
            if (cgVar == null) {
                cgVar = this.f166a.a(this.f165a, m333a);
                this.f168a.put(m333a, cgVar);
            }
        }
        if (this.f169a.isShutdown()) {
            return;
        }
        aVar.a(cgVar, this.f165a);
        synchronized (this.f167a) {
            this.f167a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f169a.isShutdown()) {
            return;
        }
        this.f169a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f166a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f169a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m334a()) {
                next.a(a(next.m333a()), this.f165a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m333a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m333a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f170a, this.f165a);
                this.f169a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        cg cgVar;
        if (aVar == null) {
            return;
        }
        if (this.f166a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m333a = aVar.m333a();
        synchronized (this.f168a) {
            cgVar = this.f168a.get(m333a);
            if (cgVar == null) {
                cgVar = this.f166a.a(this.f165a, m333a);
                this.f168a.put(m333a, cgVar);
            }
        }
        if (this.f169a.isShutdown()) {
            return;
        }
        aVar.a(cgVar, this.f165a);
        a((Runnable) aVar);
    }
}
