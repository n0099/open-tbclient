package d.b.p.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
import d.b.p.d.a;
import d.b.p.e.a;
import d.b.p.g.d.a;
import d.b.p.h.a;
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
public class a extends d.b.p.d.a {

    /* renamed from: g  reason: collision with root package name */
    public Context f64961g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f64962h;

    /* renamed from: d.b.p.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1754a implements Callable<Boolean> {
        public CallableC1754a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f64962h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64964e;

        public b(a.c cVar) {
            this.f64964e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64962h.f64976g == null) {
                this.f64964e.b(-1, null, null);
                return;
            }
            this.f64964e.a(a.this.f64962h.f64976g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64966e;

        public c(a aVar, a.c cVar) {
            this.f64966e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64966e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1755a> f64967a = new HashMap();

        /* renamed from: d.b.p.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1755a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64968a;

            /* renamed from: b  reason: collision with root package name */
            public long f64969b;

            public C1755a(boolean z, long j) {
                this.f64968a = z;
                this.f64969b = j;
            }
        }

        public C1755a a(String str) {
            return this.f64967a.get(str);
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
                    this.f64967a.put(next, new C1755a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.b.p.h.b f64970a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.b.p.e.b f64971b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f64972c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f64973d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f64974e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.b.p.g.d.a f64975f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f64976g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.b.p.e.a> f64977h = new HashMap();
        public volatile Map<String, d.b.p.h.a> i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f64978a;

        public f(a.c<T> cVar) {
            this.f64978a = cVar;
        }

        @Override // d.b.p.h.a.d
        public void a(T t, Bundle bundle) {
            this.f64978a.a(t, bundle);
        }

        @Override // d.b.p.h.a.d
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64978a.b(i, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1756a> f64979a = new HashMap();

        /* renamed from: d.b.p.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1756a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64980a;

            public C1756a(boolean z) {
                this.f64980a = z;
            }
        }

        public C1756a a(String str) {
            return this.f64979a.get(str);
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
                    this.f64979a.put(next, new C1756a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1765a f64981a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f64982b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f64983c;

        public h(a.C1765a c1765a) {
            this.f64981a = c1765a;
        }

        public boolean a() {
            this.f64981a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f64981a.d("lock"));
                this.f64982b = fileOutputStream;
                this.f64983c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f64983c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f64982b;
                    if (fileOutputStream != null) {
                        d.b.p.g.c.a.c.b(fileOutputStream);
                        this.f64982b = null;
                    }
                    this.f64983c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f64982b;
                    if (fileOutputStream2 != null) {
                        d.b.p.g.c.a.c.b(fileOutputStream2);
                        this.f64982b = null;
                    }
                    this.f64983c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f64982b;
                    if (fileOutputStream3 != null) {
                        d.b.p.g.c.a.c.b(fileOutputStream3);
                        this.f64982b = null;
                    }
                    this.f64983c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f64984a;

        /* renamed from: b  reason: collision with root package name */
        public String f64985b;

        /* renamed from: c  reason: collision with root package name */
        public long f64986c;

        public i(String str, String str2, long j) {
            this.f64984a = str;
            this.f64985b = str2;
            this.f64986c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f64987a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f64987a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f64984a);
                    jSONObject.put("aid", iVar.f64985b);
                    jSONObject.put("priority", iVar.f64986c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f64987a.add(new i(str, str2, j));
        }
    }

    @Override // d.b.p.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.b.p.h.a aVar = this.f64962h.i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f64951e.f64956d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f64951e.f64956d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.b.p.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f64962h.f64973d.f6329a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6309a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.b.p.d.a
    public void e(a.b bVar) {
        this.f64961g = this.f64951e.f64955c;
        this.f64962h = new e();
        this.f64962h.f64974e = this.f64951e.f64956d.submit(new CallableC1754a());
    }

    @Override // d.b.p.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.b.p.h.a aVar = this.f64962h.i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f64962h.f64974e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.b.p.g.d.a aVar = new d.b.p.g.d.a(this.f64961g);
        eVar.f64975f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6326a = this.f64961g;
            aVar2.f6327b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f64972c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f64973d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.b.p.h.b bVar = new d.b.p.h.b(this.f64951e.f64953a);
            eVar.f64970a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f65159a = this.f64961g;
            bVar2.f65160b = aVar;
            bVar2.f65161c = eVar.f64973d;
            bVar2.f65162d = this.f64951e.f64956d;
            bVar2.f65163e = this.f64951e.f64957e;
            a.c cVar = new a.c();
            cVar.f65164a = false;
            List<d.b.p.h.a> b2 = bVar.b();
            ArrayList<d.b.p.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f64973d.f6330b != null) {
                gVar = new g();
                gVar.b(eVar.f64973d.f6330b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1756a a2 = gVar.a(((d.b.p.h.a) it.next()).e());
                    if (a2 != null && !a2.f64980a) {
                        it.remove();
                    }
                }
            }
            for (d.b.p.h.a aVar3 : arrayList) {
                eVar.i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.b.p.e.b bVar3 = new d.b.p.e.b(this.f64951e.f64954b);
            eVar.f64971b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f65001a = this.f64961g;
            bVar4.f65003c = bVar;
            bVar4.f65002b = aVar;
            List<d.b.p.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f64973d.f6330b != null) {
                d dVar = new d();
                dVar.b(eVar.f64973d.f6330b);
                Iterator<d.b.p.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.b.p.e.a next = it2.next();
                    d.C1755a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f64968a) {
                            it2.remove();
                        } else if (a4.f64969b > -1) {
                            next.g(a4.f64969b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.b.p.e.a.f64996e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.b.p.e.a aVar4 : arrayList2) {
                eVar.f64977h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1756a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f64980a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.b.p.e.a> list) {
        List<TrustSubject> list2 = eVar.f64973d.f6329a;
        a.g gVar = new a.g();
        gVar.f65007a = true;
        eVar.f64976g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.b.p.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6309a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f64976g.b(trustSubject.f6309a, b2.f65008a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
