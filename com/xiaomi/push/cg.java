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
    public static volatile cg f38208a;

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
        public String f38210b;

        /* renamed from: a  reason: collision with other field name */
        public ce f175a = null;

        /* renamed from: a  reason: collision with other field name */
        public Random f179a = new Random();

        /* renamed from: a  reason: collision with root package name */
        public int f38209a = 0;

        public a(String str) {
            this.f177a = str;
        }

        public SQLiteDatabase a() {
            return this.f175a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m203a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m204a() {
            return this.f177a;
        }

        public void a(Context context) {
            a aVar = this.f176a;
            if (aVar != null) {
                aVar.a(context, m203a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cg.a(context).a(this);
        }

        public void a(ce ceVar, Context context) {
            this.f175a = ceVar;
            this.f38210b = ceVar.a();
            this.f178a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f176a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m205a() {
            return this.f175a == null || TextUtils.isEmpty(this.f38210b) || this.f178a == null;
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
        public int f38211a;

        /* renamed from: a  reason: collision with other field name */
        public String f180a;

        /* renamed from: a  reason: collision with other field name */
        public List<String> f181a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f182a;

        /* renamed from: b  reason: collision with root package name */
        public List<T> f38212b;

        /* renamed from: c  reason: collision with root package name */
        public String f38213c;

        /* renamed from: d  reason: collision with root package name */
        public String f38214d;

        /* renamed from: e  reason: collision with root package name */
        public String f38215e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.f38212b = new ArrayList();
            this.f181a = list;
            this.f180a = str2;
            this.f182a = strArr;
            this.f38213c = str3;
            this.f38214d = str4;
            this.f38215e = str5;
            this.f38211a = i2;
        }

        @Override // com.xiaomi.push.cg.a
        public SQLiteDatabase a() {
            return ((a) this).f175a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f38212b.clear();
            List<String> list = this.f181a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f181a.size()];
                this.f181a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.f38211a;
            Cursor query = sQLiteDatabase.query(super.f38210b, strArr, this.f180a, this.f182a, this.f38213c, this.f38214d, this.f38215e, i2 > 0 ? String.valueOf(i2) : null);
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.f38212b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.f38212b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes7.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<a> f38216a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f38216a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cg.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f38216a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f38216a.iterator();
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
        public String f38217a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f183a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f38217a = str2;
            this.f183a = strArr;
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f38210b, this.f38217a, this.f183a);
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        public ContentValues f38218a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f38218a = contentValues;
        }

        @Override // com.xiaomi.push.cg.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f38210b, null, this.f38218a);
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
        if (f38208a == null) {
            synchronized (cg.class) {
                if (f38208a == null) {
                    f38208a = new cg(context);
                }
            }
        }
        return f38208a;
    }

    private void a() {
        ai.a(this.f170a).b(new ch(this), com.xiaomi.push.service.aq.a(this.f170a).a(hk.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m202a(String str) {
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
        String m204a = aVar.m204a();
        synchronized (this.f173a) {
            ceVar = this.f173a.get(m204a);
            if (ceVar == null) {
                ceVar = this.f171a.a(this.f170a, m204a);
                this.f173a.put(m204a, ceVar);
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
            if (next.m205a()) {
                next.a(a(next.m204a()), this.f170a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m204a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m204a(), arrayList2);
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
        String m204a = aVar.m204a();
        synchronized (this.f173a) {
            ceVar = this.f173a.get(m204a);
            if (ceVar == null) {
                ceVar = this.f171a.a(this.f170a, m204a);
                this.f173a.put(m204a, ceVar);
            }
        }
        if (this.f174a.isShutdown()) {
            return;
        }
        aVar.a(ceVar, this.f170a);
        a((Runnable) aVar);
    }
}
