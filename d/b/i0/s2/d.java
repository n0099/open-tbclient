package d.b.i0.s2;

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
    public final AtomicReference<d.b.c.e.d.l<String>> f61633a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.b.c.e.d.l<String>> f61634b = new AtomicReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public boolean f61638f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61639g = false;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f61640h = new a(this, 2921022);

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, i> f61635c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f61636d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f61637e = r();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(d dVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                d.b.i0.o.a.l().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
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
                        d.this.f61635c.put(iVar.f61736a, iVar);
                        d.this.f61638f = true;
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.c.e.d.l lVar = (d.b.c.e.d.l) d.this.f61633a.get();
            if (lVar == null) {
                return;
            }
            lVar.f(d.this.f61637e, new a());
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
                    d.this.f61636d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    d.this.f61636d = 0;
                }
                d.this.f61639g = true;
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((d.b.c.e.d.l) d.this.f61634b.get()).f(d.this.f61637e, new a());
        }
    }

    /* renamed from: d.b.i0.s2.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1581d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.b.c.e.d.l<String>> f61645a;

        /* renamed from: b  reason: collision with root package name */
        public final String f61646b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f61647c;

        public /* synthetic */ C1581d(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            Runnable runnable = this.f61647c;
            if (runnable != null) {
                runnable.run();
            }
        }

        public C1581d(AtomicReference<d.b.c.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            this.f61645a = atomicReference;
            this.f61646b = str;
            this.f61647c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.f61645a.get() != null) {
                return null;
            }
            synchronized (C1581d.class) {
                if (this.f61645a.get() == null) {
                    this.f61645a.set(d.b.h0.r.r.a.f().g(this.f61646b));
                }
            }
            return null;
        }
    }

    public d() {
        MessageManager.getInstance().registerListener(this.f61640h);
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

    @Override // d.b.i0.s2.r
    public void a() {
        d.b.c.e.d.l<String> lVar = this.f61634b.get();
        if (lVar == null) {
            return;
        }
        p();
        int i2 = this.f61636d + 1;
        this.f61636d = i2;
        lVar.i(this.f61637e, Integer.toString(i2), 86400000L);
    }

    @Override // d.b.i0.s2.r
    public int b() {
        if (v(r())) {
            return this.f61636d;
        }
        return 0;
    }

    @Override // d.b.i0.s2.r
    public void c() {
        if (this.f61639g) {
            return;
        }
        c cVar = new c();
        if (this.f61634b.get() == null) {
            new C1581d(this.f61634b, "hot.splash.count", cVar, null).execute(new Void[0]);
        }
    }

    @Override // d.b.i0.s2.p
    public int d(String str, boolean z) {
        return s(str, true, z);
    }

    @Override // d.b.i0.s2.p
    public int e(String str, boolean z) {
        return s(str, false, z);
    }

    @Override // d.b.i0.s2.p
    public void f() {
        if (this.f61638f) {
            return;
        }
        b bVar = new b();
        if (this.f61633a.get() == null) {
            new C1581d(this.f61633a, "frs.refresh.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.b.i0.s2.p
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
        this.f61635c.clear();
        this.f61636d = 0;
        this.f61637e = r;
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
        i iVar = this.f61635c.get(str);
        if (iVar == null || !v(r())) {
            return 0;
        }
        return iVar.b(z, z2);
    }

    public final void u(String str, boolean z, boolean z2) {
        p();
        i iVar = this.f61635c.get(str);
        if (iVar == null) {
            iVar = new i();
            iVar.f61736a = str;
            this.f61635c.put(str, iVar);
        }
        iVar.a(z, z2);
        w(this.f61635c);
    }

    public final boolean v(String str) {
        if (TextUtils.isEmpty(this.f61637e)) {
            return false;
        }
        return this.f61637e.equals(str);
    }

    public final synchronized void w(HashMap<String, i> hashMap) {
        d.b.c.e.d.l<String> lVar = this.f61633a.get();
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
        lVar.i(this.f61637e, jSONArray.toString(), 86400000L);
    }
}
