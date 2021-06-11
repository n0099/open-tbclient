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
    public Context f67771g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f67772h;

    /* renamed from: d.a.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1835a implements Callable<Boolean> {
        public CallableC1835a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f67772h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f67774e;

        public b(a.c cVar) {
            this.f67774e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f67772h.f67786g == null) {
                this.f67774e.b(-1, null, null);
                return;
            }
            this.f67774e.a(a.this.f67772h.f67786g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f67776e;

        public c(a aVar, a.c cVar) {
            this.f67776e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f67776e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1836a> f67777a = new HashMap();

        /* renamed from: d.a.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1836a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f67778a;

            /* renamed from: b  reason: collision with root package name */
            public long f67779b;

            public C1836a(boolean z, long j) {
                this.f67778a = z;
                this.f67779b = j;
            }
        }

        public C1836a a(String str) {
            return this.f67777a.get(str);
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
                    this.f67777a.put(next, new C1836a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.a.q.h.b f67780a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.q.e.b f67781b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f67782c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f67783d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f67784e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.a.q.g.d.a f67785f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f67786g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.a.q.e.a> f67787h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, d.a.q.h.a> f67788i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f67789a;

        public f(a.c<T> cVar) {
            this.f67789a = cVar;
        }

        @Override // d.a.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f67789a.a(t, bundle);
        }

        @Override // d.a.q.h.a.d
        public void b(int i2, Exception exc, Bundle bundle) {
            this.f67789a.b(i2, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1837a> f67790a = new HashMap();

        /* renamed from: d.a.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1837a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f67791a;

            public C1837a(boolean z) {
                this.f67791a = z;
            }
        }

        public C1837a a(String str) {
            return this.f67790a.get(str);
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
                    this.f67790a.put(next, new C1837a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1846a f67792a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f67793b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f67794c;

        public h(a.C1846a c1846a) {
            this.f67792a = c1846a;
        }

        public boolean a() {
            this.f67792a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f67792a.d("lock"));
                this.f67793b = fileOutputStream;
                this.f67794c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f67794c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f67793b;
                    if (fileOutputStream != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream);
                        this.f67793b = null;
                    }
                    this.f67794c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f67793b;
                    if (fileOutputStream2 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream2);
                        this.f67793b = null;
                    }
                    this.f67794c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f67793b;
                    if (fileOutputStream3 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream3);
                        this.f67793b = null;
                    }
                    this.f67794c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f67795a;

        /* renamed from: b  reason: collision with root package name */
        public String f67796b;

        /* renamed from: c  reason: collision with root package name */
        public long f67797c;

        public i(String str, String str2, long j) {
            this.f67795a = str;
            this.f67796b = str2;
            this.f67797c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f67798a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f67798a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f67795a);
                    jSONObject.put("aid", iVar.f67796b);
                    jSONObject.put("priority", iVar.f67797c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f67798a.add(new i(str, str2, j));
        }
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.a.q.h.a aVar = this.f67772h.f67788i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f67761e.f67766d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f67761e.f67766d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f67772h.f67783d.f6311a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6290a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        this.f67771g = this.f67761e.f67765c;
        this.f67772h = new e();
        this.f67772h.f67784e = this.f67761e.f67766d.submit(new CallableC1835a());
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.a.q.h.a aVar = this.f67772h.f67788i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f67772h.f67784e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.a.q.g.d.a aVar = new d.a.q.g.d.a(this.f67771g);
        eVar.f67785f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6308a = this.f67771g;
            aVar2.f6309b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f67782c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f67783d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.a.q.h.b bVar = new d.a.q.h.b(this.f67761e.f67763a);
            eVar.f67780a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f67973a = this.f67771g;
            bVar2.f67974b = aVar;
            bVar2.f67975c = eVar.f67783d;
            bVar2.f67976d = this.f67761e.f67766d;
            bVar2.f67977e = this.f67761e.f67767e;
            a.c cVar = new a.c();
            cVar.f67978a = false;
            List<d.a.q.h.a> b2 = bVar.b();
            ArrayList<d.a.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f67783d.f6312b != null) {
                gVar = new g();
                gVar.b(eVar.f67783d.f6312b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1837a a2 = gVar.a(((d.a.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f67791a) {
                        it.remove();
                    }
                }
            }
            for (d.a.q.h.a aVar3 : arrayList) {
                eVar.f67788i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.a.q.e.b bVar3 = new d.a.q.e.b(this.f67761e.f67764b);
            eVar.f67781b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f67813a = this.f67771g;
            bVar4.f67815c = bVar;
            bVar4.f67814b = aVar;
            List<d.a.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f67783d.f6312b != null) {
                d dVar = new d();
                dVar.b(eVar.f67783d.f6312b);
                Iterator<d.a.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.a.q.e.a next = it2.next();
                    d.C1836a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f67778a) {
                            it2.remove();
                        } else if (a4.f67779b > -1) {
                            next.g(a4.f67779b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.a.q.e.a.f67808e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.a.q.e.a aVar4 : arrayList2) {
                eVar.f67787h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1837a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f67791a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.a.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f67783d.f6311a;
        a.g gVar = new a.g();
        gVar.f67819a = true;
        eVar.f67786g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.a.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6290a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f67786g.b(trustSubject.f6290a, b2.f67820a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
