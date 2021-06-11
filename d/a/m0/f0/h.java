package d.a.m0.f0;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mutiprocess.StickyEvent;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: h  reason: collision with root package name */
    public static h f53049h;

    /* renamed from: e  reason: collision with root package name */
    public d f53054e;

    /* renamed from: a  reason: collision with root package name */
    public boolean f53050a = false;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f53053d = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public final d.a.m0.f0.c f53055f = new a();

    /* renamed from: g  reason: collision with root package name */
    public final d.a.m0.m.g f53056g = new c();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<? extends d.a.m0.f0.a>, d.a.m0.f0.b> f53051b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<? extends d.a.m0.f0.a>, LinkedList<i>> f53052c = new HashMap();

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.f0.c {
        public a() {
        }

        @Override // d.a.m0.f0.c
        public void a(d.a.m0.f0.a aVar) {
            h.this.d(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.f0.a f53058e;

        public b(d.a.m0.f0.a aVar) {
            this.f53058e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.c(this.f53058e);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.m0.m.g {
        public c() {
        }

        @Override // d.a.m0.m.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof TbPageContextSupport) {
                h.this.n(((TbPageContextSupport) activity).getPageContext().getUniqueId());
            }
        }
    }

    public static h f() {
        if (f53049h == null) {
            synchronized (h.class) {
                if (f53049h == null) {
                    f53049h = new h();
                }
            }
        }
        return f53049h;
    }

    public static void i(@NonNull d.a.m0.f0.a aVar) {
        f().h(aVar);
    }

    public final void c(d.a.m0.f0.a aVar) {
        if (aVar == null) {
            return;
        }
        Class<?> cls = aVar.getClass();
        try {
            d.a.m0.f0.b bVar = this.f53051b.get(cls);
            if (bVar != null) {
                bVar.onEvent(aVar);
            }
        } catch (Exception e2) {
            BdLog.detailException(cls.getName(), e2);
        }
        try {
            LinkedList<i> linkedList = this.f53052c.get(cls);
            if (ListUtils.isEmpty(linkedList)) {
                return;
            }
            int myPid = Process.myPid();
            for (i iVar : linkedList) {
                if (iVar != null && (!iVar.isSelfListener() || (aVar.getPid() == myPid && iVar.getTag() != null && iVar.getTag().getId() == aVar.getTag()))) {
                    try {
                        iVar.onEvent(aVar);
                    } catch (Exception e3) {
                        BdLog.detailException(cls.getName(), e3);
                    }
                }
            }
        } catch (Exception e4) {
            BdLog.detailException(cls.getName(), e4);
        }
    }

    public final void d(d.a.m0.f0.a aVar) {
        if (l.C()) {
            c(aVar);
        } else {
            this.f53053d.post(new b(aVar));
        }
    }

    public final void e(@NonNull Class<? extends d.a.m0.f0.a> cls, BdUniqueId bdUniqueId) {
        if (StickyEvent.class.isAssignableFrom(cls)) {
            OrmObject c2 = g.c(cls.getSimpleName(), cls);
            if (c2 instanceof StickyEvent) {
                StickyEvent stickyEvent = (StickyEvent) c2;
                stickyEvent.resetPid();
                stickyEvent.setTag(bdUniqueId);
                stickyEvent.setType(2);
                i(stickyEvent);
            }
        }
    }

    public void g(@NonNull Application application) {
        if (this.f53050a) {
            return;
        }
        k(application);
        e eVar = new e(application);
        this.f53054e = eVar;
        eVar.c(this.f53055f);
        this.f53054e.a();
        this.f53050a = true;
    }

    public void h(@NonNull d.a.m0.f0.a aVar) {
        int myPid = Process.myPid();
        int pid = aVar.getPid();
        if (aVar.getType() == 2 && myPid == pid) {
            d(aVar);
        } else {
            j(aVar);
        }
    }

    public final void j(d.a.m0.f0.a aVar) {
        d dVar = this.f53054e;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public final void k(Application application) {
        try {
            application.registerActivityLifecycleCallbacks(this.f53056g);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void l(@NonNull Class<? extends d.a.m0.f0.a> cls, @NonNull d.a.m0.f0.b bVar) {
        if (this.f53051b.containsKey(cls)) {
            BdLog.e(cls + " has existed, Please unRegister old listener first！");
            return;
        }
        this.f53051b.put(cls, bVar);
    }

    public void m(@NonNull Class<? extends d.a.m0.f0.a> cls, @NonNull i iVar, BdUniqueId bdUniqueId) {
        LinkedList<i> linkedList = this.f53052c.get(cls);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.f53052c.put(cls, linkedList);
        }
        if (linkedList.contains(iVar)) {
            BdLog.e("listener has existed, Please unRegister old listener first！");
            return;
        }
        iVar.setTag(bdUniqueId);
        FrameHelper.f(linkedList, iVar);
        e(cls, bdUniqueId);
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return;
        }
        for (Map.Entry<Class<? extends d.a.m0.f0.a>, LinkedList<i>> entry : this.f53052c.entrySet()) {
            LinkedList<i> value = entry.getValue();
            if (!ListUtils.isEmpty(value)) {
                Iterator<i> it = value.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (next != null && next.getTag() != null && next.getTag() == bdUniqueId) {
                        it.remove();
                    }
                }
            }
        }
    }
}
