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
    public Context f64266g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f64267h;

    /* renamed from: d.b.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1741a implements Callable<Boolean> {
        public CallableC1741a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f64267h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64269e;

        public b(a.c cVar) {
            this.f64269e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64267h.f64281g == null) {
                this.f64269e.b(-1, null, null);
                return;
            }
            this.f64269e.a(a.this.f64267h.f64281g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64271e;

        public c(a aVar, a.c cVar) {
            this.f64271e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64271e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1742a> f64272a = new HashMap();

        /* renamed from: d.b.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1742a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64273a;

            /* renamed from: b  reason: collision with root package name */
            public long f64274b;

            public C1742a(boolean z, long j) {
                this.f64273a = z;
                this.f64274b = j;
            }
        }

        public C1742a a(String str) {
            return this.f64272a.get(str);
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
                    this.f64272a.put(next, new C1742a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.b.q.h.b f64275a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.b.q.e.b f64276b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f64277c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f64278d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f64279e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.b.q.g.d.a f64280f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f64281g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.b.q.e.a> f64282h = new HashMap();
        public volatile Map<String, d.b.q.h.a> i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f64283a;

        public f(a.c<T> cVar) {
            this.f64283a = cVar;
        }

        @Override // d.b.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f64283a.a(t, bundle);
        }

        @Override // d.b.q.h.a.d
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64283a.b(i, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1743a> f64284a = new HashMap();

        /* renamed from: d.b.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1743a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64285a;

            public C1743a(boolean z) {
                this.f64285a = z;
            }
        }

        public C1743a a(String str) {
            return this.f64284a.get(str);
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
                    this.f64284a.put(next, new C1743a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1752a f64286a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f64287b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f64288c;

        public h(a.C1752a c1752a) {
            this.f64286a = c1752a;
        }

        public boolean a() {
            this.f64286a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f64286a.d("lock"));
                this.f64287b = fileOutputStream;
                this.f64288c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f64288c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f64287b;
                    if (fileOutputStream != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream);
                        this.f64287b = null;
                    }
                    this.f64288c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f64287b;
                    if (fileOutputStream2 != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream2);
                        this.f64287b = null;
                    }
                    this.f64288c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f64287b;
                    if (fileOutputStream3 != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream3);
                        this.f64287b = null;
                    }
                    this.f64288c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f64289a;

        /* renamed from: b  reason: collision with root package name */
        public String f64290b;

        /* renamed from: c  reason: collision with root package name */
        public long f64291c;

        public i(String str, String str2, long j) {
            this.f64289a = str;
            this.f64290b = str2;
            this.f64291c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f64292a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f64292a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f64289a);
                    jSONObject.put("aid", iVar.f64290b);
                    jSONObject.put("priority", iVar.f64291c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f64292a.add(new i(str, str2, j));
        }
    }

    @Override // d.b.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.b.q.h.a aVar = this.f64267h.i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f64256e.f64261d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f64256e.f64261d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.b.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f64267h.f64278d.f6293a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6273a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.b.q.d.a
    public void e(a.b bVar) {
        this.f64266g = this.f64256e.f64260c;
        this.f64267h = new e();
        this.f64267h.f64279e = this.f64256e.f64261d.submit(new CallableC1741a());
    }

    @Override // d.b.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.b.q.h.a aVar = this.f64267h.i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f64267h.f64279e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.b.q.g.d.a aVar = new d.b.q.g.d.a(this.f64266g);
        eVar.f64280f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6290a = this.f64266g;
            aVar2.f6291b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f64277c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f64278d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.b.q.h.b bVar = new d.b.q.h.b(this.f64256e.f64258a);
            eVar.f64275a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f64464a = this.f64266g;
            bVar2.f64465b = aVar;
            bVar2.f64466c = eVar.f64278d;
            bVar2.f64467d = this.f64256e.f64261d;
            bVar2.f64468e = this.f64256e.f64262e;
            a.c cVar = new a.c();
            cVar.f64469a = false;
            List<d.b.q.h.a> b2 = bVar.b();
            ArrayList<d.b.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f64278d.f6294b != null) {
                gVar = new g();
                gVar.b(eVar.f64278d.f6294b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1743a a2 = gVar.a(((d.b.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f64285a) {
                        it.remove();
                    }
                }
            }
            for (d.b.q.h.a aVar3 : arrayList) {
                eVar.i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.b.q.e.b bVar3 = new d.b.q.e.b(this.f64256e.f64259b);
            eVar.f64276b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f64306a = this.f64266g;
            bVar4.f64308c = bVar;
            bVar4.f64307b = aVar;
            List<d.b.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f64278d.f6294b != null) {
                d dVar = new d();
                dVar.b(eVar.f64278d.f6294b);
                Iterator<d.b.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.b.q.e.a next = it2.next();
                    d.C1742a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f64273a) {
                            it2.remove();
                        } else if (a4.f64274b > -1) {
                            next.g(a4.f64274b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.b.q.e.a.f64301e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.b.q.e.a aVar4 : arrayList2) {
                eVar.f64282h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1743a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f64285a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.b.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f64278d.f6293a;
        a.g gVar = new a.g();
        gVar.f64312a = true;
        eVar.f64281g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.b.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6273a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f64281g.b(trustSubject.f6273a, b2.f64313a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
