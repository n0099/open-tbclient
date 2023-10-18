package com.kwad.components.core.offline.init;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.k.e;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.w;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
/* loaded from: classes10.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ClassLoader classLoader) {
        boolean z;
        try {
            z = b(context, classLoader);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
            z = false;
        }
        w.b(context, nk(), nl(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(Context context) {
        String tag;
        String str;
        com.kwad.sdk.core.e.b.d(getTag(), "initReal");
        if (isEnabled()) {
            String tag2 = getTag();
            com.kwad.sdk.core.e.b.d(tag2, "initReal disableOfflineComponents: " + com.kwad.components.core.a.CL + " , isDevelopEnable: " + com.kwad.components.core.a.aw + " , DEBUG: false");
            if (com.kwad.components.core.a.CL.booleanValue()) {
                a(context, getClass().getClassLoader());
            } else {
                an(context);
            }
            tag = getTag();
            str = "initReal end";
        } else {
            tag = getTag();
            str = "initReal disable";
        }
        com.kwad.sdk.core.e.b.d(tag, str);
    }

    private void an(final Context context) {
        com.kwai.sodler.lib.c.b nj = nj();
        String tag = getTag();
        com.kwad.sdk.core.e.b.d(tag, "loadComponents pluginInfo: " + nj);
        com.kwai.sodler.kwai.a.a(context, nj, new b.a() { // from class: com.kwad.components.core.offline.init.a.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0682b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass2) aVar, pluginError);
                String tag2 = a.this.getTag();
                com.kwad.sdk.core.e.b.d(tag2, "loadComponents failed error: " + pluginError);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwai.sodler.lib.ext.b.C0682b, com.kwai.sodler.lib.ext.b
            public void a(com.kwai.sodler.lib.b.a aVar, com.kwai.sodler.lib.kwai.a aVar2) {
                super.a((AnonymousClass2) aVar, (com.kwai.sodler.lib.b.a) aVar2);
                String tag2 = a.this.getTag();
                if (aVar2 == null) {
                    com.kwad.sdk.core.e.b.d(tag2, "loadComponents failed plugin null");
                    return;
                }
                com.kwad.sdk.core.e.b.d(tag2, "loadComponents success");
                a.this.a(context, aVar2.Ff());
            }
        });
    }

    private com.kwai.sodler.lib.c.b nj() {
        com.kwai.sodler.lib.c.b bVar = new com.kwai.sodler.lib.c.b();
        bVar.ayz = nk();
        bVar.Dv = true;
        bVar.ayD = false;
        bVar.ayA = com.kwad.sdk.core.network.idc.a.tH().bZ(nm());
        bVar.version = nl();
        bVar.ayC = nn();
        return bVar;
    }

    public final <T extends IOfflineCompo> T a(ClassLoader classLoader, String str) {
        T t;
        String tag = getTag();
        com.kwad.sdk.core.e.b.d(tag, "onOfflineComponentsLoaded classLoader:" + classLoader);
        try {
            t = (T) classLoader.loadClass(str).newInstance();
        } catch (Throwable th) {
            String tag2 = getTag();
            com.kwad.sdk.core.e.b.e(tag2, "loadClass or instance failed: " + str, th);
            t = null;
        }
        String tag3 = getTag();
        com.kwad.sdk.core.e.b.d(tag3, "onOfflineComponentsLoaded components: " + t);
        return t;
    }

    public abstract boolean b(Context context, ClassLoader classLoader);

    public abstract String getTag();

    public final void init(final Context context) {
        final boolean g = w.g(context, nk(), nl());
        String tag = getTag();
        com.kwad.sdk.core.e.b.d(tag, "init isSuccessLoaded: " + g);
        e.a(new e.a() { // from class: com.kwad.components.core.offline.init.a.1
            @Override // com.kwad.components.core.k.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                if (g) {
                    return;
                }
                com.kwad.sdk.core.e.b.d(a.this.getTag(), "init onConfigRefresh");
                a.this.am(context);
            }

            @Override // com.kwad.components.core.k.e.a
            public final void no() {
                if (g) {
                    com.kwad.sdk.core.e.b.d(a.this.getTag(), "init onCacheLoaded");
                    a.this.am(context);
                }
            }
        });
    }

    public boolean isEnabled() {
        return true;
    }

    public abstract String nk();

    public abstract String nl();

    public abstract String nm();

    public abstract String nn();
}
