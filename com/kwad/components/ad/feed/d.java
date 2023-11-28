package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class d {
    public static com.kwad.sdk.core.g.d eg;
    public static Vibrator eh;
    public static List<a> ei = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface b {
        boolean b(double d);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public b ek;
        public Context mContext;

        public a(b bVar, Context context) {
            this.ek = bVar;
            this.mContext = context;
        }
    }

    public static Vibrator D(Context context) {
        if (eh == null) {
            eh = (Vibrator) context.getSystemService("vibrator");
        }
        return eh;
    }

    public static void a(float f, Context context) {
        eg = new com.kwad.sdk.core.g.d(f);
        ei = new CopyOnWriteArrayList();
        eg.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void a(double d) {
                if (d.ei != null) {
                    Iterator it = d.ei.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (aVar.ek != null && aVar.ek.b(d)) {
                            bn.a(aVar.mContext, d.D(aVar.mContext));
                            break;
                        }
                    }
                    bn.a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.e.c.d("KSFeedShakeManager", "onShakeEvent openGate2");
                            d.eg.El();
                        }
                    }, null, 500L);
                }
            }
        });
        eg.e(f);
        eg.bi(context);
    }

    public static void a(float f, Context context, b bVar) {
        if (eg == null) {
            a(f, context);
        }
        ei.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : ei) {
            if (aVar.ek == bVar) {
                ei.remove(aVar);
            }
        }
        com.kwad.sdk.core.e.c.d("KSFeedShakeManager", "sShakeItems size " + ei.size());
    }
}
