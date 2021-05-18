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
    public Context f64177g;

    /* renamed from: h  reason: collision with root package name */
    public volatile e f64178h;

    /* renamed from: d.a.q.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CallableC1774a implements Callable<Boolean> {
        public CallableC1774a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            a aVar = a.this;
            aVar.i(aVar.f64178h);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64180e;

        public b(a.c cVar) {
            this.f64180e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64178h.f64192g == null) {
                this.f64180e.b(-1, null, null);
                return;
            }
            this.f64180e.a(a.this.f64178h.f64192g.a(), null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f64182e;

        public c(a aVar, a.c cVar) {
            this.f64182e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f64182e.b(-1, null, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1775a> f64183a = new HashMap();

        /* renamed from: d.a.q.d.c.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1775a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64184a;

            /* renamed from: b  reason: collision with root package name */
            public long f64185b;

            public C1775a(boolean z, long j) {
                this.f64184a = z;
                this.f64185b = j;
            }
        }

        public C1775a a(String str) {
            return this.f64183a.get(str);
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
                    this.f64183a.put(next, new C1775a(jSONObject.optBoolean(com.baidu.fsg.face.base.b.c.l, true), jSONObject.optLong("priority", -1L)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public volatile d.a.q.h.b f64186a;

        /* renamed from: b  reason: collision with root package name */
        public volatile d.a.q.e.b f64187b;

        /* renamed from: c  reason: collision with root package name */
        public volatile TrustSubjectManager f64188c;

        /* renamed from: d  reason: collision with root package name */
        public volatile TrustSubjectManager.d f64189d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Future<Boolean> f64190e;

        /* renamed from: f  reason: collision with root package name */
        public volatile d.a.q.g.d.a f64191f;

        /* renamed from: g  reason: collision with root package name */
        public volatile j f64192g;

        /* renamed from: h  reason: collision with root package name */
        public volatile Map<String, d.a.q.e.a> f64193h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        public volatile Map<String, d.a.q.h.a> f64194i = new HashMap();
    }

    /* loaded from: classes2.dex */
    public static class f<T> implements a.d<T> {

        /* renamed from: a  reason: collision with root package name */
        public a.c<T> f64195a;

        public f(a.c<T> cVar) {
            this.f64195a = cVar;
        }

        @Override // d.a.q.h.a.d
        public void a(T t, Bundle bundle) {
            this.f64195a.a(t, bundle);
        }

        @Override // d.a.q.h.a.d
        public void b(int i2, Exception exc, Bundle bundle) {
            this.f64195a.b(i2, exc, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, C1776a> f64196a = new HashMap();

        /* renamed from: d.a.q.d.c.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C1776a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f64197a;

            public C1776a(boolean z) {
                this.f64197a = z;
            }
        }

        public C1776a a(String str) {
            return this.f64196a.get(str);
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
                    this.f64196a.put(next, new C1776a(optJSONObject.getJSONObject(next).optBoolean(com.baidu.fsg.face.base.b.c.l, true)));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public a.C1785a f64198a;

        /* renamed from: b  reason: collision with root package name */
        public FileOutputStream f64199b;

        /* renamed from: c  reason: collision with root package name */
        public FileLock f64200c;

        public h(a.C1785a c1785a) {
            this.f64198a = c1785a;
        }

        public boolean a() {
            this.f64198a.a();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f64198a.d("lock"));
                this.f64199b = fileOutputStream;
                this.f64200c = fileOutputStream.getChannel().lock();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IPUT, INVOKE, IPUT, IPUT, IF] complete} */
        public boolean b() {
            FileLock fileLock = this.f64200c;
            if (fileLock != null) {
                try {
                    fileLock.release();
                    FileOutputStream fileOutputStream = this.f64199b;
                    if (fileOutputStream != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream);
                        this.f64199b = null;
                    }
                    this.f64200c = null;
                    return true;
                } catch (IOException unused) {
                    FileOutputStream fileOutputStream2 = this.f64199b;
                    if (fileOutputStream2 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream2);
                        this.f64199b = null;
                    }
                    this.f64200c = null;
                    return false;
                } catch (Throwable th) {
                    FileOutputStream fileOutputStream3 = this.f64199b;
                    if (fileOutputStream3 != null) {
                        d.a.q.g.c.a.c.b(fileOutputStream3);
                        this.f64199b = null;
                    }
                    this.f64200c = null;
                    throw th;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f64201a;

        /* renamed from: b  reason: collision with root package name */
        public String f64202b;

        /* renamed from: c  reason: collision with root package name */
        public long f64203c;

        public i(String str, String str2, long j) {
            this.f64201a = str;
            this.f64202b = str2;
            this.f64203c = j;
        }
    }

    /* loaded from: classes2.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public List<i> f64204a = new ArrayList();

        public String a() {
            JSONArray jSONArray = new JSONArray();
            try {
                for (i iVar : this.f64204a) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pkg", iVar.f64201a);
                    jSONObject.put("aid", iVar.f64202b);
                    jSONObject.put("priority", iVar.f64203c);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception unused) {
            }
            return jSONArray.toString();
        }

        public void b(String str, String str2, long j) {
            this.f64204a.add(new i(str, str2, j));
        }
    }

    @Override // d.a.q.d.a
    public void a(String str, Bundle bundle, a.c<String> cVar) {
        ExecutorService executorService;
        Runnable cVar2;
        h();
        d.a.q.h.a aVar = this.f64178h.f64194i.get(str);
        if (aVar != null) {
            aVar.g(new f(cVar));
            return;
        }
        if ("sids".equals(str)) {
            executorService = this.f64167e.f64172d;
            cVar2 = new b(cVar);
        } else {
            executorService = this.f64167e.f64172d;
            cVar2 = new c(this, cVar);
        }
        executorService.submit(cVar2);
    }

    @Override // d.a.q.d.a
    public boolean d(String str) {
        h();
        List<TrustSubject> list = this.f64178h.f64189d.f6368a;
        if (list != null) {
            for (TrustSubject trustSubject : list) {
                if (trustSubject.f6347a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // d.a.q.d.a
    public void e(a.b bVar) {
        this.f64177g = this.f64167e.f64171c;
        this.f64178h = new e();
        this.f64178h.f64190e = this.f64167e.f64172d.submit(new CallableC1774a());
    }

    @Override // d.a.q.d.a
    public a.d f(String str, Bundle bundle) {
        h();
        d.a.q.h.a aVar = this.f64178h.f64194i.get(str);
        return aVar != null ? a.d.c(aVar.c()) : a.d.a(-1, null);
    }

    public final void h() {
        try {
            this.f64178h.f64190e.get();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final void i(e eVar) {
        g gVar;
        d.a.q.g.d.a aVar = new d.a.q.g.d.a(this.f64177g);
        eVar.f64191f = aVar;
        h hVar = new h(aVar.d().f("init"));
        try {
            hVar.a();
            TrustSubjectManager.a aVar2 = new TrustSubjectManager.a();
            aVar2.f6365a = this.f64177g;
            aVar2.f6366b = aVar;
            TrustSubjectManager trustSubjectManager = new TrustSubjectManager();
            eVar.f64188c = trustSubjectManager;
            trustSubjectManager.f(aVar2);
            trustSubjectManager.i(new TrustSubjectManager.b());
            eVar.f64189d = trustSubjectManager.j(new TrustSubjectManager.c());
            d.a.q.h.b bVar = new d.a.q.h.b(this.f64167e.f64169a);
            eVar.f64186a = bVar;
            a.b bVar2 = new a.b();
            bVar2.f64379a = this.f64177g;
            bVar2.f64380b = aVar;
            bVar2.f64381c = eVar.f64189d;
            bVar2.f64382d = this.f64167e.f64172d;
            bVar2.f64383e = this.f64167e.f64173e;
            a.c cVar = new a.c();
            cVar.f64384a = false;
            List<d.a.q.h.a> b2 = bVar.b();
            ArrayList<d.a.q.h.a> arrayList = b2 == null ? new ArrayList() : new ArrayList(b2);
            if (eVar.f64189d.f6369b != null) {
                gVar = new g();
                gVar.b(eVar.f64189d.f6369b);
            } else {
                gVar = null;
            }
            if (arrayList.size() > 0 && gVar != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    g.C1776a a2 = gVar.a(((d.a.q.h.a) it.next()).e());
                    if (a2 != null && !a2.f64197a) {
                        it.remove();
                    }
                }
            }
            for (d.a.q.h.a aVar3 : arrayList) {
                eVar.f64194i.put(aVar3.e(), aVar3);
                aVar3.a(bVar2);
                aVar3.f(cVar);
            }
            d.a.q.e.b bVar3 = new d.a.q.e.b(this.f64167e.f64170b);
            eVar.f64187b = bVar3;
            a.b bVar4 = new a.b();
            bVar4.f64219a = this.f64177g;
            bVar4.f64221c = bVar;
            bVar4.f64220b = aVar;
            List<d.a.q.e.a> a3 = bVar3.a();
            ArrayList arrayList2 = a3 == null ? new ArrayList() : new ArrayList(a3);
            if (arrayList2.size() > 0 && eVar.f64189d.f6369b != null) {
                d dVar = new d();
                dVar.b(eVar.f64189d.f6369b);
                Iterator<d.a.q.e.a> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    d.a.q.e.a next = it2.next();
                    d.C1775a a4 = dVar.a(next.c());
                    if (a4 != null) {
                        if (!a4.f64184a) {
                            it2.remove();
                        } else if (a4.f64185b > -1) {
                            next.g(a4.f64185b);
                        }
                    }
                }
            }
            Collections.sort(arrayList2, d.a.q.e.a.f64214e);
            a.d dVar2 = new a.d();
            a.e eVar2 = new a.e();
            for (d.a.q.e.a aVar4 : arrayList2) {
                eVar.f64193h.put(aVar4.c(), aVar4);
                aVar4.a(bVar4);
                aVar4.e(dVar2);
                aVar4.f(eVar2);
            }
            g.C1776a a5 = gVar != null ? gVar.a("sids") : null;
            if (a5 == null || a5.f64197a) {
                j(eVar, arrayList2);
            }
        } finally {
            hVar.b();
        }
    }

    public final void j(e eVar, List<d.a.q.e.a> list) {
        List<TrustSubject> list2 = eVar.f64189d.f6368a;
        a.g gVar = new a.g();
        gVar.f64225a = true;
        eVar.f64192g = new j();
        if (list2 != null) {
            for (TrustSubject trustSubject : list2) {
                Iterator<d.a.q.e.a> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a.h b2 = it.next().b(trustSubject.f6347a, gVar);
                    if (b2 != null && b2.d()) {
                        eVar.f64192g.b(trustSubject.f6347a, b2.f64226a, trustSubject.o());
                        break;
                    }
                }
            }
        }
    }
}
