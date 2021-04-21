package d.b.q.d.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.TrustSubjectManager;
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
    public Context f65225g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f65226h;

    /* renamed from: d.b.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1773a implements Callable<Boolean> {
        public CallableC1773a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f65226h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f65228e;

        public b(a.c cVar) {
            this.f65228e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f65226h.f65240g == null) {
                this.f65228e.b(-1, null, null);
                return;
            }
            this.f65228e.a(a.this.f65226h.f65240g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f65230e;

        public c(a aVar, a.c cVar) {
            this.f65230e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f65230e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1774a> f65231a = new HashMap();

        /* renamed from: d.b.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1774a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f65232a;

            /* renamed from: b  reason: collision with root package name */
            public long f65233b;

            public C1774a(boolean z, long j) {
                this.f65232a = z;
                this.f65233b = j;
            }
        }

        public C1774a a(String str) {
            return this.f65231a.get(str);
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
                    this.f65231a.put(next, new C1774a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.b.q.h.b f65234a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.b.q.e.b f65235b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f65236c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f65237d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f65238e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.b.q.g.d.a f65239f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f65240g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.b.q.e.a> f65241h = new HashMap();
        public volatile Map<String, d.b.q.h.a> i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f65242a;

        public f(a.c<T> cVar) {
            this.f65242a = cVar;
        }

        @Override // d.b.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f65242a.a(t, bundle);
        }

        @Override // d.b.q.h.a.d
        public void b(int i, Exception exc, Bundle bundle) {
            this.f65242a.b(i, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1775a> f65243a = new HashMap();

        /* renamed from: d.b.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1775a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f65244a;

            public C1775a(boolean z) {
                this.f65244a = z;
            }
        }

        public C1775a a(String str) {
            return this.f65243a.get(str);
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
                    this.f65243a.put(next, new C1775a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1784a f65245a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f65246b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f65247c;

        public h(a.C1784a c1784a) {
            this.f65245a = c1784a;
        }

        public boolean a() {
            this.f65245a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f65245a.d("lock"));
                this.f65246b = fileOutputStream;
                this.f65247c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f65247c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f65246b;
                    if (fileOutputStream != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream);
                        this.f65246b = null;
                    }
                    this.f65247c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f65246b;
                    if (fileOutputStream2 != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream2);
                        this.f65246b = null;
                    }
                    this.f65247c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f65246b;
                    if (fileOutputStream3 != null) {
                        d.b.q.g.c.a.c.b(fileOutputStream3);
                        this.f65246b = null;
                    }
                    this.f65247c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f65248a;

        /* renamed from: b  reason: collision with root package name */
        public String f65249b;

        /* renamed from: c  reason: collision with root package name */
        public long f65250c;

        public i(String str, String str2, long j) {
            this.f65248a = str;
            this.f65249b = str2;
            this.f65250c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f65251a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f65251a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f65248a);
                    jSONObject.put("aid", iVar.f65249b);
                    jSONObject.put("priority", iVar.f65250c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f65251a.add(new i(str, str2, j));
        }
    }

    @Override // d.b.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.b.q.h.a aVar = this.f65226h.i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f65215e.f65220d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f65215e.f65220d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.b.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f65226h.f65237d.f6329a;
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

    @Override // d.b.q.d.a
    public void e(a.b bVar) {
        this.f65225g = this.f65215e.f65219c;
        this.f65226h = new e();
        this.f65226h.f65238e = this.f65215e.f65220d.submit(new CallableC1773a());
    }

    @Override // d.b.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.b.q.h.a aVar = this.f65226h.i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f65226h.f65238e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.b.q.g.d.a aVar = new d.b.q.g.d.a(this.f65225g);
        eVar.f65239f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6326a = this.f65225g;
            aVar2.f6327b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f65236c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f65237d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.b.q.h.b bVar = new d.b.q.h.b(this.f65215e.f65217a);
            eVar.f65234a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f65423a = this.f65225g;
            bVar2.f65424b = aVar;
            bVar2.f65425c = eVar.f65237d;
            bVar2.f65426d = this.f65215e.f65220d;
            bVar2.f65427e = this.f65215e.f65221e;
            a.c cVar = new a.c();
            cVar.f65428a = false;
            List<d.b.q.h.a> b2 = bVar.b();
            ArrayList<d.b.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f65237d.f6330b != null) {
                gVar = new g();
                gVar.b(eVar.f65237d.f6330b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1775a a2 = gVar.a(((d.b.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f65244a) {
                        it.remove();
                    }
                }
            }
            for (d.b.q.h.a aVar3 : arrayList) {
                eVar.i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.b.q.e.b bVar3 = new d.b.q.e.b(this.f65215e.f65218b);
            eVar.f65235b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f65265a = this.f65225g;
            bVar4.f65267c = bVar;
            bVar4.f65266b = aVar;
            List<d.b.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f65237d.f6330b != null) {
                d dVar = new d();
                dVar.b(eVar.f65237d.f6330b);
                Iterator<d.b.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.b.q.e.a next = it2.next();
                    d.C1774a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f65232a) {
                            it2.remove();
                        } else if (a4.f65233b > -1) {
                            next.g(a4.f65233b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.b.q.e.a.f65260e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.b.q.e.a aVar4 : arrayList2) {
                eVar.f65241h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1775a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f65244a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.b.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f65237d.f6329a;
        a.g gVar = new a.g();
        gVar.f65271a = true;
        eVar.f65240g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.b.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6309a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f65240g.b(trustSubject.f6309a, b2.f65272a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
