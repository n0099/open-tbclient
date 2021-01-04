package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
abstract class a implements l {

    /* renamed from: a  reason: collision with root package name */
    protected final List<Class<? extends k>> f12219a = new ArrayList();

    private k a(Class<? extends k> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.c.l
    public void a(f fVar, final com.qq.e.comm.plugin.c.a.a aVar) {
        if (this.f12219a.size() <= 0) {
            return;
        }
        g.a(false, 0, fVar);
        for (Class<? extends k> cls : this.f12219a) {
            k a2 = a(cls);
            if (a2 == null) {
                g.a(true, 1, fVar);
                return;
            }
            boolean a3 = a2.a(fVar);
            ai.a(getClass().getSimpleName(), cls.getSimpleName() + ", canAction = " + a3);
            if (a3) {
                boolean a4 = a2.a(fVar, aVar);
                ai.a(getClass().getSimpleName(), cls.getSimpleName() + ", actionFinish = " + a4);
                if (a4) {
                    k a5 = a(t.class);
                    if (a5 == null || !a5.a(fVar)) {
                        return;
                    }
                    a5.a(fVar, aVar);
                    return;
                }
            }
        }
        if (aVar != null) {
            w.a(new Runnable() { // from class: com.qq.e.comm.plugin.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a();
                }
            });
        }
        g.a(true, 2, fVar);
    }
}
