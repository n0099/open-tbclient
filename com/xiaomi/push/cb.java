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
    private static volatile cb f14200a;

    /* renamed from: a  reason: collision with other field name */
    private Context f227a;

    /* renamed from: a  reason: collision with other field name */
    private ca f228a;

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bz> f230a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f231a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f229a = new ArrayList<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        private a f233a;

        /* renamed from: a  reason: collision with other field name */
        private String f234a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f235a;

        /* renamed from: b  reason: collision with root package name */
        protected String f14202b;

        /* renamed from: a  reason: collision with other field name */
        protected bz f232a = null;

        /* renamed from: a  reason: collision with other field name */
        private Random f236a = new Random();

        /* renamed from: a  reason: collision with root package name */
        private int f14201a = 0;

        public a(String str) {
            this.f234a = str;
        }

        public SQLiteDatabase a() {
            return this.f232a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m228a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m229a() {
            return this.f234a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Context context) {
            if (this.f233a != null) {
                this.f233a.a(context, m228a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            cb.a(context).a(this);
        }

        void a(bz bzVar, Context context) {
            this.f232a = bzVar;
            this.f14202b = this.f232a.a();
            this.f235a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f233a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m230a() {
            return this.f232a == null || TextUtils.isEmpty(this.f14202b) || this.f235a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            if (this.f235a == null || (context = this.f235a.get()) == null || context.getFilesDir() == null || this.f232a == null || TextUtils.isEmpty(this.f234a)) {
                return;
            }
            File file = new File(this.f234a);
            v.a(context, new File(file.getParentFile(), be.b(file.getAbsolutePath())), new cd(this, context));
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f14203a;

        /* renamed from: a  reason: collision with other field name */
        private String f237a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f238a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f239a;

        /* renamed from: b  reason: collision with root package name */
        private List<T> f14204b;
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f14204b = new ArrayList();
            this.f238a = list;
            this.f237a = str2;
            this.f239a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f14203a = i;
        }

        @Override // com.xiaomi.push.cb.a
        public SQLiteDatabase a() {
            return this.f232a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f14204b.clear();
            if (this.f238a == null || this.f238a.size() <= 0) {
                strArr = null;
            } else {
                strArr = new String[this.f238a.size()];
                this.f238a.toArray(strArr);
            }
            Cursor query = sQLiteDatabase.query(this.f14202b, strArr, this.f237a, this.f239a, this.c, this.d, this.e, this.f14203a <= 0 ? null : String.valueOf(this.f14203a));
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.f14204b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.f14204b);
        }

        public abstract void a(Context context, List<T> list);
    }

    /* loaded from: classes6.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f14205a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            this.f14205a = new ArrayList<>();
            this.f14205a.addAll(arrayList);
        }

        @Override // com.xiaomi.push.cb.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.f14205a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.f14205a.iterator();
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
        private String f14206a;

        /* renamed from: a  reason: collision with other field name */
        protected String[] f240a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f14206a = str2;
            this.f240a = strArr;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f14202b, this.f14206a, this.f240a);
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f14207a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f14207a = contentValues;
        }

        @Override // com.xiaomi.push.cb.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f14202b, null, this.f14207a);
        }
    }

    private cb(Context context) {
        this.f227a = context;
    }

    private bz a(String str) {
        bz bzVar = this.f230a.get(str);
        if (bzVar == null) {
            synchronized (this.f230a) {
                if (bzVar == null) {
                    bzVar = this.f228a.a(this.f227a, str);
                    this.f230a.put(str, bzVar);
                }
            }
        }
        return bzVar;
    }

    public static cb a(Context context) {
        if (f14200a == null) {
            synchronized (cb.class) {
                if (f14200a == null) {
                    f14200a = new cb(context);
                }
            }
        }
        return f14200a;
    }

    private void a() {
        ai.a(this.f227a).b(new cc(this), com.xiaomi.push.service.ak.a(this.f227a).a(hr.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m227a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f228a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m229a = aVar.m229a();
        synchronized (this.f230a) {
            bzVar = this.f230a.get(m229a);
            if (bzVar == null) {
                bzVar = this.f228a.a(this.f227a, m229a);
                this.f230a.put(m229a, bzVar);
            }
        }
        if (this.f231a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f227a);
        synchronized (this.f229a) {
            this.f229a.add(aVar);
            a();
        }
    }

    public void a(Runnable runnable) {
        if (this.f231a.isShutdown()) {
            return;
        }
        this.f231a.execute(runnable);
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f228a == null) {
            throw new IllegalStateException("should exec setDbHelperFactory method first!");
        }
        HashMap hashMap = new HashMap();
        if (this.f231a.isShutdown()) {
            return;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.m230a()) {
                next.a(a(next.m229a()), this.f227a);
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(next.m229a());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap.put(next.m229a(), arrayList2);
            }
            arrayList2.add(next);
        }
        for (String str : hashMap.keySet()) {
            ArrayList arrayList3 = (ArrayList) hashMap.get(str);
            if (arrayList3 != null && arrayList3.size() > 0) {
                c cVar = new c(str, arrayList3);
                cVar.a(((a) arrayList3.get(0)).f232a, this.f227a);
                this.f231a.execute(cVar);
            }
        }
    }

    public void b(a aVar) {
        bz bzVar;
        if (aVar == null) {
            return;
        }
        if (this.f228a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String m229a = aVar.m229a();
        synchronized (this.f230a) {
            bzVar = this.f230a.get(m229a);
            if (bzVar == null) {
                bzVar = this.f228a.a(this.f227a, m229a);
                this.f230a.put(m229a, bzVar);
            }
        }
        if (this.f231a.isShutdown()) {
            return;
        }
        aVar.a(bzVar, this.f227a);
        a((Runnable) aVar);
    }
}
