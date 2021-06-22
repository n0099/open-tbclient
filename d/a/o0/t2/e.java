package d.a.o0.t2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.d.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e implements q, s {

    /* renamed from: i  reason: collision with root package name */
    public static volatile e f64847i;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.a.c.e.d.l<String>> f64848a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.a.c.e.d.l<String>> f64849b = new AtomicReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public boolean f64853f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64854g = false;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f64855h = new a(this, 2921022);

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, j> f64850c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f64851d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f64852e = r();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(e eVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                d.a.o0.q.a.l().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements l.a<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Iterator it = e.this.q(str2).iterator();
                while (it.hasNext()) {
                    j jVar = (j) it.next();
                    if (jVar != null) {
                        e.this.f64850c.put(jVar.f64978a, jVar);
                        e.this.f64853f = true;
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.d.l lVar = (d.a.c.e.d.l) e.this.f64848a.get();
            if (lVar == null) {
                return;
            }
            lVar.f(e.this.f64852e, new a());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements l.a<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    e.this.f64851d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    e.this.f64851d = 0;
                }
                e.this.f64854g = true;
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((d.a.c.e.d.l) e.this.f64849b.get()).f(e.this.f64852e, new a());
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.a.c.e.d.l<String>> f64860a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64861b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f64862c;

        public /* synthetic */ d(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            Runnable runnable = this.f64862c;
            if (runnable != null) {
                runnable.run();
            }
        }

        public d(AtomicReference<d.a.c.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            this.f64860a = atomicReference;
            this.f64861b = str;
            this.f64862c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.f64860a.get() != null) {
                return null;
            }
            synchronized (d.class) {
                if (this.f64860a.get() == null) {
                    this.f64860a.set(d.a.n0.r.r.a.f().g(this.f64861b));
                }
            }
            return null;
        }
    }

    public e() {
        MessageManager.getInstance().registerListener(this.f64855h);
    }

    public static e t() {
        if (f64847i == null) {
            synchronized (e.class) {
                if (f64847i == null) {
                    f64847i = new e();
                }
            }
        }
        return f64847i;
    }

    @Override // d.a.o0.t2.s
    public int a() {
        if (v(r())) {
            return this.f64851d;
        }
        return 0;
    }

    @Override // d.a.o0.t2.s
    public void b() {
        d.a.c.e.d.l<String> lVar = this.f64849b.get();
        if (lVar == null) {
            return;
        }
        p();
        int i2 = this.f64851d + 1;
        this.f64851d = i2;
        lVar.i(this.f64852e, Integer.toString(i2), 86400000L);
    }

    @Override // d.a.o0.t2.s
    public void c() {
        if (this.f64854g) {
            return;
        }
        c cVar = new c();
        if (this.f64849b.get() == null) {
            new d(this.f64849b, "hot.splash.count", cVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.o0.t2.q
    public int d(String str, boolean z) {
        return s(str, true, z);
    }

    @Override // d.a.o0.t2.q
    public int e(String str, boolean z) {
        return s(str, false, z);
    }

    @Override // d.a.o0.t2.q
    public void f() {
        if (this.f64853f) {
            return;
        }
        b bVar = new b();
        if (this.f64848a.get() == null) {
            new d(this.f64848a, "frs.refresh.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.o0.t2.q
    public void g(String str, int i2, boolean z) {
        if (i2 == 1) {
            u(str, true, z);
        } else if (i2 == 2) {
            u(str, false, z);
        }
    }

    public final void p() {
        String r = r();
        if (v(r)) {
            return;
        }
        this.f64850c.clear();
        this.f64851d = 0;
        this.f64852e = r;
    }

    public final ArrayList<j> q(String str) {
        ArrayList<j> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(new j(jSONArray.optJSONObject(i2)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final String r() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public final int s(String str, boolean z, boolean z2) {
        j jVar = this.f64850c.get(str);
        if (jVar == null || !v(r())) {
            return 0;
        }
        return jVar.b(z, z2);
    }

    public final void u(String str, boolean z, boolean z2) {
        p();
        j jVar = this.f64850c.get(str);
        if (jVar == null) {
            jVar = new j();
            jVar.f64978a = str;
            this.f64850c.put(str, jVar);
        }
        jVar.a(z, z2);
        w(this.f64850c);
    }

    public final boolean v(String str) {
        if (TextUtils.isEmpty(this.f64852e)) {
            return false;
        }
        return this.f64852e.equals(str);
    }

    public final synchronized void w(HashMap<String, j> hashMap) {
        d.a.c.e.d.l<String> lVar = this.f64848a.get();
        if (lVar == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, j> entry : hashMap.entrySet()) {
            JSONObject c2 = entry.getValue().c();
            if (c2 != null) {
                jSONArray.put(c2);
            }
        }
        lVar.i(this.f64852e, jSONArray.toString(), 86400000L);
    }
}
