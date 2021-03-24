package d.b.i0.r2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.d.l;
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
public class c implements m, o {
    public static volatile c i;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<d.b.b.e.d.l<String>> f59775a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public AtomicReference<d.b.b.e.d.l<String>> f59776b = new AtomicReference<>(null);

    /* renamed from: f  reason: collision with root package name */
    public boolean f59780f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59781g = false;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f59782h = new a(this, 2921022);

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, h> f59777c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public int f59778d = 0;

    /* renamed from: e  reason: collision with root package name */
    public String f59779e = r();

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(c cVar, int i) {
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

    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements l.a<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.b.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                Iterator it = c.this.q(str2).iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (hVar != null) {
                        c.this.f59777c.put(hVar.f59842a, hVar);
                        c.this.f59780f = true;
                    }
                }
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.b.e.d.l lVar = (d.b.b.e.d.l) c.this.f59775a.get();
            if (lVar == null) {
                return;
            }
            lVar.f(c.this.f59779e, new a());
        }
    }

    /* renamed from: d.b.i0.r2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1504c implements Runnable {

        /* renamed from: d.b.i0.r2.c$c$a */
        /* loaded from: classes5.dex */
        public class a implements l.a<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.b.e.d.l.a
            /* renamed from: b */
            public void a(String str, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    c.this.f59778d = Integer.parseInt(str2);
                } catch (NumberFormatException unused) {
                    c.this.f59778d = 0;
                }
                c.this.f59781g = true;
            }
        }

        public RunnableC1504c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((d.b.b.e.d.l) c.this.f59776b.get()).f(c.this.f59779e, new a());
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final AtomicReference<d.b.b.e.d.l<String>> f59787a;

        /* renamed from: b  reason: collision with root package name */
        public final String f59788b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f59789c;

        public /* synthetic */ d(AtomicReference atomicReference, String str, Runnable runnable, a aVar) {
            this(atomicReference, str, runnable);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r1) {
            super.onPostExecute(r1);
            Runnable runnable = this.f59789c;
            if (runnable != null) {
                runnable.run();
            }
        }

        public d(AtomicReference<d.b.b.e.d.l<String>> atomicReference, String str, Runnable runnable) {
            this.f59787a = atomicReference;
            this.f59788b = str;
            this.f59789c = runnable;
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (this.f59787a.get() != null) {
                return null;
            }
            synchronized (d.class) {
                if (this.f59787a.get() == null) {
                    this.f59787a.set(d.b.h0.r.r.a.f().g(this.f59788b));
                }
            }
            return null;
        }
    }

    public c() {
        MessageManager.getInstance().registerListener(this.f59782h);
    }

    public static c t() {
        if (i == null) {
            synchronized (c.class) {
                if (i == null) {
                    i = new c();
                }
            }
        }
        return i;
    }

    @Override // d.b.i0.r2.o
    public void a() {
        d.b.b.e.d.l<String> lVar = this.f59776b.get();
        if (lVar == null) {
            return;
        }
        p();
        int i2 = this.f59778d + 1;
        this.f59778d = i2;
        lVar.i(this.f59779e, Integer.toString(i2), 86400000L);
    }

    @Override // d.b.i0.r2.o
    public int b() {
        if (v(r())) {
            return this.f59778d;
        }
        return 0;
    }

    @Override // d.b.i0.r2.o
    public void c() {
        if (this.f59781g) {
            return;
        }
        RunnableC1504c runnableC1504c = new RunnableC1504c();
        if (this.f59776b.get() == null) {
            new d(this.f59776b, "hot.splash.count", runnableC1504c, null).execute(new Void[0]);
        }
    }

    @Override // d.b.i0.r2.m
    public int d(String str, boolean z) {
        return s(str, true, z);
    }

    @Override // d.b.i0.r2.m
    public int e(String str, boolean z) {
        return s(str, false, z);
    }

    @Override // d.b.i0.r2.m
    public void f() {
        if (this.f59780f) {
            return;
        }
        b bVar = new b();
        if (this.f59775a.get() == null) {
            new d(this.f59775a, "frs.refresh.count", bVar, null).execute(new Void[0]);
        }
    }

    @Override // d.b.i0.r2.m
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
        this.f59777c.clear();
        this.f59778d = 0;
        this.f59779e = r;
    }

    public final ArrayList<h> q(String str) {
        ArrayList<h> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(new h(jSONArray.optJSONObject(i2)));
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
        h hVar = this.f59777c.get(str);
        if (hVar == null || !v(r())) {
            return 0;
        }
        return hVar.b(z, z2);
    }

    public final void u(String str, boolean z, boolean z2) {
        p();
        h hVar = this.f59777c.get(str);
        if (hVar == null) {
            hVar = new h();
            hVar.f59842a = str;
            this.f59777c.put(str, hVar);
        }
        hVar.a(z, z2);
        w(this.f59777c);
    }

    public final boolean v(String str) {
        if (TextUtils.isEmpty(this.f59779e)) {
            return false;
        }
        return this.f59779e.equals(str);
    }

    public final synchronized void w(HashMap<String, h> hashMap) {
        d.b.b.e.d.l<String> lVar = this.f59775a.get();
        if (lVar == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, h> entry : hashMap.entrySet()) {
            JSONObject c2 = entry.getValue().c();
            if (c2 != null) {
                jSONArray.put(c2);
            }
        }
        lVar.i(this.f59779e, jSONArray.toString(), 86400000L);
    }
}
