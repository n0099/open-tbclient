package d.b.j0.s2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.d.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements p, r {
    public static volatile d i;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.b.c.e.d.l<String>> f62054a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.b.c.e.d.l<String>> f62055b = new AtomicReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public boolean f62059f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62060g = false;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f62061h = new a(this, 2921022);

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, i> f62056c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f62057d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f62058e = r();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(d dVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                d.b.j0.o.a.l().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* loaded from: classes4.dex */
        public class a implements l.a<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Iterator it = d.this.q(str2).iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar != null) {
                        d.this.f62056c.put(iVar.f62157a, iVar);
                        d.this.f62059f = true;
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.c.e.d.l lVar = (d.b.c.e.d.l) d.this.f62054a.get();
            if (lVar == null) {
                return;
            }
            lVar.f(d.this.f62058e, new a());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* loaded from: classes4.dex */
        public class a implements l.a<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.c.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    d.this.f62057d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    d.this.f62057d = 0;
                }
                d.this.f62060g = true;
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((d.b.c.e.d.l) d.this.f62055b.get()).f(d.this.f62058e, new a());
        }
    }

    /* renamed from: d.b.j0.s2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1604d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.b.c.e.d.l<String>> f62066a;

        /* renamed from: b  reason: collision with root package name */
        public final String f62067b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f62068c;

        public /* synthetic */ C1604d(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            Runnable runnable = this.f62068c;
            if (runnable != null) {
                runnable.run();
            }
        }

        public C1604d(AtomicReference<d.b.c.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            this.f62066a = atomicReference;
            this.f62067b = str;
            this.f62068c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.f62066a.get() != null) {
                return null;
            }
            synchronized (C1604d.class) {
                if (this.f62066a.get() == null) {
                    this.f62066a.set(d.b.i0.r.r.a.f().g(this.f62067b));
                }
            }
            return null;
        }
    }

    public d() {
        MessageManager.getInstance().registerListener(this.f62061h);
    }

    public static d t() {
        if (i == null) {
            synchronized (d.class) {
                if (i == null) {
                    i = new d();
                }
            }
        }
        return i;
    }

    @Override // d.b.j0.s2.r
    public void a() {
        d.b.c.e.d.l<String> lVar = this.f62055b.get();
        if (lVar == null) {
            return;
        }
        p();
        int i2 = this.f62057d + 1;
        this.f62057d = i2;
        lVar.i(this.f62058e, Integer.toString(i2), 86400000L);
    }

    @Override // d.b.j0.s2.r
    public int b() {
        if (v(r())) {
            return this.f62057d;
        }
        return 0;
    }

    @Override // d.b.j0.s2.r
    public void c() {
        if (this.f62060g) {
            return;
        }
        c cVar = new c();
        if (this.f62055b.get() == null) {
            new C1604d(this.f62055b, "hot.splash.count", cVar, null).execute(new Void[0]);
        }
    }

    @Override // d.b.j0.s2.p
    public int d(String str, boolean z) {
        return s(str, true, z);
    }

    @Override // d.b.j0.s2.p
    public int e(String str, boolean z) {
        return s(str, false, z);
    }

    @Override // d.b.j0.s2.p
    public void f() {
        if (this.f62059f) {
            return;
        }
        b bVar = new b();
        if (this.f62054a.get() == null) {
            new C1604d(this.f62054a, "frs.refresh.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.b.j0.s2.p
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
        this.f62056c.clear();
        this.f62057d = 0;
        this.f62058e = r;
    }

    public final ArrayList<i> q(String str) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(new i(jSONArray.optJSONObject(i2)));
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
        i iVar = this.f62056c.get(str);
        if (iVar == null || !v(r())) {
            return 0;
        }
        return iVar.b(z, z2);
    }

    public final void u(String str, boolean z, boolean z2) {
        p();
        i iVar = this.f62056c.get(str);
        if (iVar == null) {
            iVar = new i();
            iVar.f62157a = str;
            this.f62056c.put(str, iVar);
        }
        iVar.a(z, z2);
        w(this.f62056c);
    }

    public final boolean v(String str) {
        if (TextUtils.isEmpty(this.f62058e)) {
            return false;
        }
        return this.f62058e.equals(str);
    }

    public final synchronized void w(HashMap<String, i> hashMap) {
        d.b.c.e.d.l<String> lVar = this.f62054a.get();
        if (lVar == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, i> entry : hashMap.entrySet()) {
            JSONObject c2 = entry.getValue().c();
            if (c2 != null) {
                jSONArray.put(c2);
            }
        }
        lVar.i(this.f62058e, jSONArray.toString(), 86400000L);
    }
}
