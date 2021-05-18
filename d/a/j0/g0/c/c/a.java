package d.a.j0.g0.c.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.j0.g0.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a {
    public List<d.a.j0.g0.c.a> eventDelegates;
    public boolean isDispatchMvcEventing = false;
    public BdUniqueId uniqueId;

    public void addEventDelegate(d.a.j0.g0.c.a aVar) {
        if (this.eventDelegates == null) {
            this.eventDelegates = new ArrayList();
        }
        if (this.eventDelegates.contains(aVar)) {
            return;
        }
        if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("can not add event delegate on dispatch mvcevent");
        }
        this.eventDelegates.add(aVar);
    }

    public boolean dispatchMvcEvent(b bVar) {
        boolean z;
        if (bVar != null && bVar.e() == null) {
            bVar.i(this.uniqueId);
        }
        if (this.eventDelegates != null) {
            try {
                this.isDispatchMvcEventing = true;
                onBeforeDispatchMvcEvent(bVar);
                int size = this.eventDelegates.size();
                z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    try {
                        d.a.j0.g0.c.a aVar = this.eventDelegates.get(i2);
                        if (aVar != null && ((!aVar.isEventMustSelf() || (aVar.isEventMustSelf() && bVar.e() == aVar.getUniqueId())) && (z = aVar.onEventDispatch(bVar)) && bVar.f())) {
                            return true;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            BdLog.e(th);
                            if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException(th);
                            }
                            this.isDispatchMvcEventing = false;
                            return z;
                        } finally {
                            this.isDispatchMvcEventing = false;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            this.isDispatchMvcEventing = false;
            return z;
        }
        return false;
    }

    public void onBeforeDispatchMvcEvent(b bVar) {
    }

    public void removeEventDelegate(d.a.j0.g0.c.a aVar) {
        List<d.a.j0.g0.c.a> list = this.eventDelegates;
        if (list != null && list.contains(aVar)) {
            if (this.isDispatchMvcEventing && TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("can not add event delegate on dispatch mvcevent");
            }
            this.eventDelegates.remove(aVar);
        }
    }
}
