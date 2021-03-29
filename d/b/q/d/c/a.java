package d.b.q.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import d.b.q.d.a;
import d.b.q.e.a;
import d.b.q.g.d.a;
import d.b.q.h.a;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.d.a {

    /* renamed from: g  reason: collision with root package name */
    public Context f64267g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f64268h;

    /* renamed from: d.b.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1742a implements Callable<Boolean> {
        public CallableC1742a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f64268h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64270e;

        public b(a.c cVar) {
            this.f64270e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64268h.f64282g == null) {
                this.f64270e.b(-1, null, null);
                return;
            }
            this.f64270e.a(a.this.f64268h.f64282g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64272e;

        public c(a aVar, a.c cVar) {
            this.f64272e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64272e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1743a> f64273a = new HashMap();

        /* renamed from: d.b.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1743a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64274a;

            /* renamed from: b  reason: collision with root package name */
            public long f64275b;

            public C1743a(boolean z, long j) {
                this.f64274a = z;
                this.f64275b = j;
            }
        }

        public C1743a a(String str) {
            return this.f64273a.get(str);
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String m = trustSubject.m("config-cs");
                if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject(IXAdRequestInfo.CS)) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.f64273a.put(next, new C1743a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.b.q.h.b f64276a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.b.q.e.b f64277b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f64278c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f64279d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f64280e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.b.q.g.d.a f64281f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f64282g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.b.q.e.a> f64283h = new HashMap();
        public volatile Map<String, d.b.q.h.a> i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f64284a;

        public f(a.c<T> cVar) {
            this.f64284a = cVar;
        }

        @Override // d.b.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f64284a.a(t, bundle);
        }

        @Override // d.b.q.h.a.d
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64284a.b(i, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1744a> f64285a = new HashMap();

        /* renamed from: d.b.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1744a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64286a;

            public C1744a(boolean z) {
                this.f64286a = z;
            }
        }

        public C1744a a(String str) {
            return this.f64285a.get(str);
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String m = trustSubject.m("config-ids");
                if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("ids")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.f64285a.put(next, new C1744a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1753a f64287a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f64288b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f64289c;

        public h(a.C1753a c1753a) {
            this.f64287a = c1753a;
        }

        public boolean a() {
            this.f64287a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f64287a.d("lock"));
                this.f64288b = fileOutputStream;
                this.f64289c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f64289c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f64288b;
                    if (fileOutputStream != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream);
                        this.f64288b = null;
                    }
                    this.f64289c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f64288b;
                    if (fileOutputStream2 != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream2);
                        this.f64288b = null;
                    }
                    this.f64289c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f64288b;
                    if (fileOutputStream3 != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream3);
                        this.f64288b = null;
                    }
                    this.f64289c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f64290a;

        /* renamed from: b  reason: collision with root package name */
        public String f64291b;

        /* renamed from: c  reason: collision with root package name */
        public long f64292c;

        public i(String str, String str2, long j) {
            this.f64290a = str;
            this.f64291b = str2;
            this.f64292c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f64293a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f64293a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f64290a);
                    jSONObject.put("aid", iVar.f64291b);
                    jSONObject.put("priority", iVar.f64292c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f64293a.add(new i(str, str2, j));
        }
    }

    @Override // d.b.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.b.q.h.a aVar = this.f64268h.i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f64257e.f64262d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f64257e.f64262d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.b.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f64268h.f64279d.f6294a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6274a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.b.q.d.a
    public void e(a.b bVar) {
        this.f64267g = this.f64257e.f64261c;
        this.f64268h = new e();
        this.f64268h.f64280e = this.f64257e.f64262d.submit(new CallableC1742a());
    }

    @Override // d.b.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.b.q.h.a aVar = this.f64268h.i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f64268h.f64280e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.b.q.g.d.a aVar = new d.b.q.g.d.a(this.f64267g);
        eVar.f64281f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6291a = this.f64267g;
            aVar2.f6292b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f64278c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f64279d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.b.q.h.b bVar = new d.b.q.h.b(this.f64257e.f64259a);
            eVar.f64276a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f64465a = this.f64267g;
            bVar2.f64466b = aVar;
            bVar2.f64467c = eVar.f64279d;
            bVar2.f64468d = this.f64257e.f64262d;
            bVar2.f64469e = this.f64257e.f64263e;
            a.c cVar = new a.c();
            cVar.f64470a = false;
            List<d.b.q.h.a> b2 = bVar.b();
            ArrayList<d.b.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f64279d.f6295b != null) {
                gVar = new g();
                gVar.b(eVar.f64279d.f6295b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1744a a2 = gVar.a(((d.b.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f64286a) {
                        it.remove();
                    }
                }
            }
            for (d.b.q.h.a aVar3 : arrayList) {
                eVar.i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.b.q.e.b bVar3 = new d.b.q.e.b(this.f64257e.f64260b);
            eVar.f64277b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f64307a = this.f64267g;
            bVar4.f64309c = bVar;
            bVar4.f64308b = aVar;
            List<d.b.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f64279d.f6295b != null) {
                d dVar = new d();
                dVar.b(eVar.f64279d.f6295b);
                Iterator<d.b.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.b.q.e.a next = it2.next();
                    d.C1743a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f64274a) {
                            it2.remove();
                        } else if (a4.f64275b > -1) {
                            next.g(a4.f64275b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.b.q.e.a.f64302e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.b.q.e.a aVar4 : arrayList2) {
                eVar.f64283h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1744a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f64286a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.b.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f64279d.f6294a;
        a.g gVar = new a.g();
        gVar.f64313a = true;
        eVar.f64282g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.b.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6274a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f64282g.b(trustSubject.f6274a, b2.f64314a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
