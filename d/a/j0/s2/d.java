package d.a.j0.s2;

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
/* loaded from: classes3.dex */
public class d implements p, r {

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f60199i;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.a.c.e.d.l<String>> f60200a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.a.c.e.d.l<String>> f60201b = new AtomicReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public boolean f60205f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60206g = false;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f60207h = new a(this, 2921022);

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, i> f60202c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f60203d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f60204e = r();

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(d dVar, int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921022 && (customResponsedMessage.getData() instanceof String)) {
                d.a.j0.o.a.l().c(TbadkCoreApplication.getInst(), new String[]{(String) customResponsedMessage.getData()}, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* loaded from: classes3.dex */
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
                Iterator it = d.this.q(str2).iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (iVar != null) {
                        d.this.f60202c.put(iVar.f60317a, iVar);
                        d.this.f60205f = true;
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.c.e.d.l lVar = (d.a.c.e.d.l) d.this.f60200a.get();
            if (lVar == null) {
                return;
            }
            lVar.f(d.this.f60204e, new a());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* loaded from: classes3.dex */
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
                    d.this.f60203d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    d.this.f60203d = 0;
                }
                d.this.f60206g = true;
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((d.a.c.e.d.l) d.this.f60201b.get()).f(d.this.f60204e, new a());
        }
    }

    /* renamed from: d.a.j0.s2.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1545d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.a.c.e.d.l<String>> f60212a;

        /* renamed from: b  reason: collision with root package name */
        public final String f60213b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f60214c;

        public /* synthetic */ C1545d(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            Runnable runnable = this.f60214c;
            if (runnable != null) {
                runnable.run();
            }
        }

        public C1545d(AtomicReference<d.a.c.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            this.f60212a = atomicReference;
            this.f60213b = str;
            this.f60214c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.f60212a.get() != null) {
                return null;
            }
            synchronized (C1545d.class) {
                if (this.f60212a.get() == null) {
                    this.f60212a.set(d.a.i0.r.r.a.f().g(this.f60213b));
                }
            }
            return null;
        }
    }

    public d() {
        MessageManager.getInstance().registerListener(this.f60207h);
    }

    public static d t() {
        if (f60199i == null) {
            synchronized (d.class) {
                if (f60199i == null) {
                    f60199i = new d();
                }
            }
        }
        return f60199i;
    }

    @Override // d.a.j0.s2.r
    public void a() {
        d.a.c.e.d.l<String> lVar = this.f60201b.get();
        if (lVar == null) {
            return;
        }
        p();
        int i2 = this.f60203d + 1;
        this.f60203d = i2;
        lVar.i(this.f60204e, Integer.toString(i2), 86400000L);
    }

    @Override // d.a.j0.s2.r
    public int b() {
        if (v(r())) {
            return this.f60203d;
        }
        return 0;
    }

    @Override // d.a.j0.s2.r
    public void c() {
        if (this.f60206g) {
            return;
        }
        c cVar = new c();
        if (this.f60201b.get() == null) {
            new C1545d(this.f60201b, "hot.splash.count", cVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.j0.s2.p
    public int d(String str, boolean z) {
        return s(str, true, z);
    }

    @Override // d.a.j0.s2.p
    public int e(String str, boolean z) {
        return s(str, false, z);
    }

    @Override // d.a.j0.s2.p
    public void f() {
        if (this.f60205f) {
            return;
        }
        b bVar = new b();
        if (this.f60200a.get() == null) {
            new C1545d(this.f60200a, "frs.refresh.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.a.j0.s2.p
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
        this.f60202c.clear();
        this.f60203d = 0;
        this.f60204e = r;
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
        i iVar = this.f60202c.get(str);
        if (iVar == null || !v(r())) {
            return 0;
        }
        return iVar.b(z, z2);
    }

    public final void u(String str, boolean z, boolean z2) {
        p();
        i iVar = this.f60202c.get(str);
        if (iVar == null) {
            iVar = new i();
            iVar.f60317a = str;
            this.f60202c.put(str, iVar);
        }
        iVar.a(z, z2);
        w(this.f60202c);
    }

    public final boolean v(String str) {
        if (TextUtils.isEmpty(this.f60204e)) {
            return false;
        }
        return this.f60204e.equals(str);
    }

    public final synchronized void w(HashMap<String, i> hashMap) {
        d.a.c.e.d.l<String> lVar = this.f60200a.get();
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
        lVar.i(this.f60204e, jSONArray.toString(), 86400000L);
    }
}
