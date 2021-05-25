package d.a.q.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import d.a.q.d.a;
import d.a.q.e.a;
import d.a.q.g.d.a;
import d.a.q.h.a;
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
public class a extends d.a.q.d.a {

    /* renamed from: g  reason: collision with root package name */
    public Context f64053g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f64054h;

    /* renamed from: d.a.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1777a implements Callable<Boolean> {
        public CallableC1777a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f64054h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64056e;

        public b(a.c cVar) {
            this.f64056e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64054h.f64068g == null) {
                this.f64056e.b(-1, null, null);
                return;
            }
            this.f64056e.a(a.this.f64054h.f64068g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64058e;

        public c(a aVar, a.c cVar) {
            this.f64058e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64058e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1778a> f64059a = new HashMap();

        /* renamed from: d.a.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1778a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64060a;

            /* renamed from: b  reason: collision with root package name */
            public long f64061b;

            public C1778a(boolean z, long j) {
                this.f64060a = z;
                this.f64061b = j;
            }
        }

        public C1778a a(String str) {
            return this.f64059a.get(str);
        }

        public void b(TrustSubject trustSubject) {
            JSONObject optJSONObject;
            try {
                String m = trustSubject.m("config-cs");
                if (TextUtils.isEmpty(m) || (optJSONObject = new JSONObject(m).optJSONObject("cs")) == null) {
                    return;
                }
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject = optJSONObject.getJSONObject(next);
                    this.f64059a.put(next, new C1778a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.a.q.h.b f64062a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.q.e.b f64063b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f64064c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f64065d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f64066e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.a.q.g.d.a f64067f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f64068g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.a.q.e.a> f64069h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, d.a.q.h.a> f64070i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f64071a;

        public f(a.c<T> cVar) {
            this.f64071a = cVar;
        }

        @Override // d.a.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f64071a.a(t, bundle);
        }

        @Override // d.a.q.h.a.d
        public void b(int i2, Exception exc, Bundle bundle) {
            this.f64071a.b(i2, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1779a> f64072a = new HashMap();

        /* renamed from: d.a.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1779a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64073a;

            public C1779a(boolean z) {
                this.f64073a = z;
            }
        }

        public C1779a a(String str) {
            return this.f64072a.get(str);
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
                    this.f64072a.put(next, new C1779a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1788a f64074a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f64075b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f64076c;

        public h(a.C1788a c1788a) {
            this.f64074a = c1788a;
        }

        public boolean a() {
            this.f64074a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f64074a.d("lock"));
                this.f64075b = fileOutputStream;
                this.f64076c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f64076c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f64075b;
                    if (fileOutputStream != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream);
                        this.f64075b = null;
                    }
                    this.f64076c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f64075b;
                    if (fileOutputStream2 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream2);
                        this.f64075b = null;
                    }
                    this.f64076c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f64075b;
                    if (fileOutputStream3 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream3);
                        this.f64075b = null;
                    }
                    this.f64076c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f64077a;

        /* renamed from: b  reason: collision with root package name */
        public String f64078b;

        /* renamed from: c  reason: collision with root package name */
        public long f64079c;

        public i(String str, String str2, long j) {
            this.f64077a = str;
            this.f64078b = str2;
            this.f64079c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f64080a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f64080a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f64077a);
                    jSONObject.put("aid", iVar.f64078b);
                    jSONObject.put("priority", iVar.f64079c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f64080a.add(new i(str, str2, j));
        }
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.a.q.h.a aVar = this.f64054h.f64070i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f64043e.f64048d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f64043e.f64048d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f64054h.f64065d.f6268a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6247a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        this.f64053g = this.f64043e.f64047c;
        this.f64054h = new e();
        this.f64054h.f64066e = this.f64043e.f64048d.submit(new CallableC1777a());
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.a.q.h.a aVar = this.f64054h.f64070i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f64054h.f64066e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.a.q.g.d.a aVar = new d.a.q.g.d.a(this.f64053g);
        eVar.f64067f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6265a = this.f64053g;
            aVar2.f6266b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f64064c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f64065d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.a.q.h.b bVar = new d.a.q.h.b(this.f64043e.f64045a);
            eVar.f64062a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f64255a = this.f64053g;
            bVar2.f64256b = aVar;
            bVar2.f64257c = eVar.f64065d;
            bVar2.f64258d = this.f64043e.f64048d;
            bVar2.f64259e = this.f64043e.f64049e;
            a.c cVar = new a.c();
            cVar.f64260a = false;
            List<d.a.q.h.a> b2 = bVar.b();
            ArrayList<d.a.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f64065d.f6269b != null) {
                gVar = new g();
                gVar.b(eVar.f64065d.f6269b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1779a a2 = gVar.a(((d.a.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f64073a) {
                        it.remove();
                    }
                }
            }
            for (d.a.q.h.a aVar3 : arrayList) {
                eVar.f64070i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.a.q.e.b bVar3 = new d.a.q.e.b(this.f64043e.f64046b);
            eVar.f64063b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f64095a = this.f64053g;
            bVar4.f64097c = bVar;
            bVar4.f64096b = aVar;
            List<d.a.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f64065d.f6269b != null) {
                d dVar = new d();
                dVar.b(eVar.f64065d.f6269b);
                Iterator<d.a.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.a.q.e.a next = it2.next();
                    d.C1778a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f64060a) {
                            it2.remove();
                        } else if (a4.f64061b > -1) {
                            next.g(a4.f64061b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.a.q.e.a.f64090e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.a.q.e.a aVar4 : arrayList2) {
                eVar.f64069h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1779a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f64073a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.a.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f64065d.f6268a;
        a.g gVar = new a.g();
        gVar.f64101a = true;
        eVar.f64068g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.a.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6247a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f64068g.b(trustSubject.f6247a, b2.f64102a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
