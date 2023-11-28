package com.kwad.components.core.n.b;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.sdk.core.e.c;
/* loaded from: classes10.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    public long EV;

    public abstract void a(Context context, boolean z, T t);

    public abstract String getTag();

    public abstract boolean isEnabled();

    public abstract int oD();

    public abstract String oE();

    public abstract String oF();

    public abstract String oG();

    public abstract String oH();

    public abstract String oI();

    public abstract String oJ();

    public final void oC() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.EV;
        String tag = getTag();
        c.d(tag, "init component success cost: " + elapsedRealtime);
        com.kwad.components.core.n.a.b(oD(), elapsedRealtime);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.kwad.components.core.n.b.a<T extends com.kwad.components.offline.api.IOfflineCompo<?>> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, boolean z, ClassLoader classLoader) {
        String oJ = oJ();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(oJ).newInstance();
            String tag = getTag();
            c.d(tag, "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            a(context, z, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            String tag2 = getTag();
            c.e(tag2, "loadClass or instance failed: " + oJ, th);
        }
    }

    private void ab(final Context context) {
        if (com.kwad.components.core.a.It.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b oB = oB();
        String tag = getTag();
        c.d(tag, "load component start pluginInfo: " + oB);
        com.kwad.library.solder.a.a.a(context, oB, new b.a() { // from class: com.kwad.components.core.n.b.a.1
            public boolean Mv = false;

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                c.d(a.this.getTag(), "load component resource success");
                a.this.a(context, this.Mv, aVar2.wK());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a((AnonymousClass1) aVar);
                this.Mv = true;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.b.C0690b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass1) aVar, pluginError);
                String tag2 = a.this.getTag();
                c.d(tag2, "load component resource failed error: " + pluginError);
            }
        });
    }

    private com.kwad.library.solder.lib.c.b oB() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.ajM = oE();
        bVar.Jq = true;
        bVar.ajQ = false;
        bVar.ajN = com.kwad.sdk.core.network.idc.a.CJ().du(oG());
        bVar.version = oF();
        bVar.ajP = oH();
        if (com.kwad.components.core.a.Iw.booleanValue()) {
            bVar.ajs = oI();
            bVar.ajt = true;
        }
        return bVar;
    }

    public final void init(Context context) {
        if (isEnabled()) {
            this.EV = SystemClock.elapsedRealtime();
            com.kwad.components.core.n.a.ar(oD());
            c.d(getTag(), "init start");
            ab(context);
            return;
        }
        try {
            c.d(getTag(), "del start");
            com.kwad.library.solder.a.a.j(context, oE());
        } catch (Throwable unused) {
        }
    }
}
