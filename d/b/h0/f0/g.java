package d.b.h0.f0;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.e.p.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: h  reason: collision with root package name */
    public static g f50180h;

    /* renamed from: d  reason: collision with root package name */
    public d f50184d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50181a = false;

    /* renamed from: e  reason: collision with root package name */
    public final d.b.h0.f0.c f50185e = new a();

    /* renamed from: f  reason: collision with root package name */
    public Handler f50186f = new Handler(Looper.getMainLooper());

    /* renamed from: g  reason: collision with root package name */
    public final d.b.h0.m.g f50187g = new c();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<? extends d.b.h0.f0.a>, d.b.h0.f0.b> f50182b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<? extends d.b.h0.f0.a>, LinkedList<h>> f50183c = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.f0.c {
        public a() {
        }

        @Override // d.b.h0.f0.c
        public void a(d.b.h0.f0.a aVar) {
            g.this.d(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.f0.a f50189e;

        public b(d.b.h0.f0.a aVar) {
            this.f50189e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.c(this.f50189e);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.h0.m.g {
        public c() {
        }

        @Override // d.b.h0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof TbPageContextSupport) {
                g.this.l(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public static g e() {
        if (f50180h == null) {
            synchronized (g.class) {
                if (f50180h == null) {
                    f50180h = new g();
                }
            }
        }
        return f50180h;
    }

    public static void g(d.b.h0.f0.a aVar) {
        int myPid = Process.myPid();
        int pid = aVar.getPid();
        if (aVar.getType() == 2 && myPid == pid) {
            e().d(aVar);
        } else {
            e().h(aVar);
        }
    }

    public final void c(d.b.h0.f0.a aVar) {
        if (aVar == null) {
            return;
        }
        Class<?> cls = aVar.getClass();
        try {
            d.b.h0.f0.b bVar = this.f50182b.get(cls);
            if (bVar != null) {
                bVar.onEvent(aVar);
            }
        } catch (Exception e2) {
            BdLog.detailException(cls.getName(), e2);
        }
        try {
            LinkedList<h> linkedList = this.f50183c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (h hVar : linkedList) {
                if (hVar != null && (!hVar.isSelfListener() || (aVar.getPid() == myPid && hVar.getTag() != null && hVar.getTag().getId() == aVar.getTag()))) {
                    try {
                        hVar.onEvent(aVar);
                    } catch (Exception e3) {
                        BdLog.detailException(cls.getName(), e3);
                    }
                }
            }
        } catch (Exception e4) {
            BdLog.detailException(cls.getName(), e4);
        }
    }

    public final void d(d.b.h0.f0.a aVar) {
        if (l.B()) {
            c(aVar);
        } else {
            this.f50186f.post(new b(aVar));
        }
    }

    public void f(Application application) {
        if (this.f50181a) {
            return;
        }
        if (application != null) {
            i(application);
            e eVar = new e(application);
            this.f50184d = eVar;
            eVar.b(this.f50185e);
            this.f50184d.c();
            this.f50181a = true;
            return;
        }
        throw new NullPointerException("MutiProcessManager Initialized, application is null");
    }

    public final void h(d.b.h0.f0.a aVar) {
        d dVar = this.f50184d;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    public final void i(Application application) {
        try {
            application.registerActivityLifecycleCallbacks(this.f50187g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(Class<? extends d.b.h0.f0.a> cls, d.b.h0.f0.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("register listener is null");
        }
        if (cls != null) {
            if (this.f50182b.containsKey(cls)) {
                BdLog.e(cls + " has existed, Please unRegister old listener first！");
                return;
            }
            this.f50182b.put(cls, bVar);
            return;
        }
        throw new NullPointerException("register IEvent class is null");
    }

    public void k(Class<? extends d.b.h0.f0.a> cls, h hVar, BdUniqueId bdUniqueId) {
        if (hVar == null) {
            throw new NullPointerException("register listener is null");
        }
        if (cls != null) {
            LinkedList<h> linkedList = this.f50183c.get(cls);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f50183c.put(cls, linkedList);
            }
            if (linkedList.contains(hVar)) {
                BdLog.e("listener has existed, Please unRegister old listener first！");
                return;
            }
            hVar.setTag(bdUniqueId);
            FrameHelper.f(linkedList, hVar);
            return;
        }
        throw new NullPointerException("register IEvent class is null");
    }

    public void l(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends d.b.h0.f0.a>, LinkedList<h>> entry : this.f50183c.entrySet()) {
            LinkedList<h> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<h> it = value.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }
}
