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
    public Context f63540g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f63541h;

    /* renamed from: d.a.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1711a implements Callable<Boolean> {
        public CallableC1711a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f63541h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f63543e;

        public b(a.c cVar) {
            this.f63543e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f63541h.f63555g == null) {
                this.f63543e.b(-1, null, null);
                return;
            }
            this.f63543e.a(a.this.f63541h.f63555g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f63545e;

        public c(a aVar, a.c cVar) {
            this.f63545e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f63545e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1712a> f63546a = new HashMap();

        /* renamed from: d.a.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1712a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f63547a;

            /* renamed from: b  reason: collision with root package name */
            public long f63548b;

            public C1712a(boolean z, long j) {
                this.f63547a = z;
                this.f63548b = j;
            }
        }

        public C1712a a(String str) {
            return this.f63546a.get(str);
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
                    this.f63546a.put(next, new C1712a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.a.q.h.b f63549a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.q.e.b f63550b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f63551c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f63552d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f63553e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.a.q.g.d.a f63554f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f63555g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.a.q.e.a> f63556h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, d.a.q.h.a> f63557i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f63558a;

        public f(a.c<T> cVar) {
            this.f63558a = cVar;
        }

        @Override // d.a.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f63558a.a(t, bundle);
        }

        @Override // d.a.q.h.a.d
        public void b(int i2, Exception exc, Bundle bundle) {
            this.f63558a.b(i2, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1713a> f63559a = new HashMap();

        /* renamed from: d.a.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1713a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f63560a;

            public C1713a(boolean z) {
                this.f63560a = z;
            }
        }

        public C1713a a(String str) {
            return this.f63559a.get(str);
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
                    this.f63559a.put(next, new C1713a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1722a f63561a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f63562b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f63563c;

        public h(a.C1722a c1722a) {
            this.f63561a = c1722a;
        }

        public boolean a() {
            this.f63561a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f63561a.d("lock"));
                this.f63562b = fileOutputStream;
                this.f63563c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f63563c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f63562b;
                    if (fileOutputStream != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream);
                        this.f63562b = null;
                    }
                    this.f63563c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f63562b;
                    if (fileOutputStream2 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream2);
                        this.f63562b = null;
                    }
                    this.f63563c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f63562b;
                    if (fileOutputStream3 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream3);
                        this.f63562b = null;
                    }
                    this.f63563c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f63564a;

        /* renamed from: b  reason: collision with root package name */
        public String f63565b;

        /* renamed from: c  reason: collision with root package name */
        public long f63566c;

        public i(String str, String str2, long j) {
            this.f63564a = str;
            this.f63565b = str2;
            this.f63566c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f63567a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f63567a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f63564a);
                    jSONObject.put("aid", iVar.f63565b);
                    jSONObject.put("priority", iVar.f63566c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f63567a.add(new i(str, str2, j));
        }
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.a.q.h.a aVar = this.f63541h.f63557i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f63530e.f63535d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f63530e.f63535d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f63541h.f63552d.f6514a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6493a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        this.f63540g = this.f63530e.f63534c;
        this.f63541h = new e();
        this.f63541h.f63553e = this.f63530e.f63535d.submit(new CallableC1711a());
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.a.q.h.a aVar = this.f63541h.f63557i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f63541h.f63553e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.a.q.g.d.a aVar = new d.a.q.g.d.a(this.f63540g);
        eVar.f63554f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6511a = this.f63540g;
            aVar2.f6512b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f63551c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f63552d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.a.q.h.b bVar = new d.a.q.h.b(this.f63530e.f63532a);
            eVar.f63549a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f63742a = this.f63540g;
            bVar2.f63743b = aVar;
            bVar2.f63744c = eVar.f63552d;
            bVar2.f63745d = this.f63530e.f63535d;
            bVar2.f63746e = this.f63530e.f63536e;
            a.c cVar = new a.c();
            cVar.f63747a = false;
            List<d.a.q.h.a> b2 = bVar.b();
            ArrayList<d.a.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f63552d.f6515b != null) {
                gVar = new g();
                gVar.b(eVar.f63552d.f6515b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1713a a2 = gVar.a(((d.a.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f63560a) {
                        it.remove();
                    }
                }
            }
            for (d.a.q.h.a aVar3 : arrayList) {
                eVar.f63557i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.a.q.e.b bVar3 = new d.a.q.e.b(this.f63530e.f63533b);
            eVar.f63550b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f63582a = this.f63540g;
            bVar4.f63584c = bVar;
            bVar4.f63583b = aVar;
            List<d.a.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f63552d.f6515b != null) {
                d dVar = new d();
                dVar.b(eVar.f63552d.f6515b);
                Iterator<d.a.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.a.q.e.a next = it2.next();
                    d.C1712a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f63547a) {
                            it2.remove();
                        } else if (a4.f63548b > -1) {
                            next.g(a4.f63548b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.a.q.e.a.f63577e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.a.q.e.a aVar4 : arrayList2) {
                eVar.f63556h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1713a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f63560a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.a.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f63552d.f6514a;
        a.g gVar = new a.g();
        gVar.f63588a = true;
        eVar.f63555g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.a.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6493a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f63555g.b(trustSubject.f6493a, b2.f63589a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
