package d.a.c.h.j.f;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f39480c;

    /* renamed from: a  reason: collision with root package name */
    public PluginNetConfigInfos f39481a = new PluginNetConfigInfos();

    /* renamed from: b  reason: collision with root package name */
    public b f39482b;

    /* loaded from: classes.dex */
    public class a implements d.a.c.h.j.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.h.j.f.a f39483a;

        public a(d.a.c.h.j.f.a aVar) {
            this.f39483a = aVar;
        }

        @Override // d.a.c.h.j.f.a
        public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            if (z) {
                d.this.f39481a = pluginNetConfigInfos;
            }
            d.a.c.h.j.f.a aVar = this.f39483a;
            if (aVar != null) {
                aVar.a(z, cVar, d.this.f39481a, str);
            }
        }
    }

    public static d c() {
        if (f39480c == null) {
            synchronized (d.class) {
                if (f39480c == null) {
                    f39480c = new d();
                }
            }
        }
        return f39480c;
    }

    public PluginNetConfigInfos d() {
        return this.f39481a;
    }

    public void e(PluginSettings pluginSettings, boolean z, d.a.c.h.j.f.a aVar) {
        c g2 = g(pluginSettings);
        b bVar = this.f39482b;
        if (bVar != null) {
            bVar.a(z, g2, new a(aVar));
        }
    }

    public void f(b bVar) {
        this.f39482b = bVar;
    }

    public c g(PluginSettings pluginSettings) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        if (pluginSettings.getPlugins() != null) {
            for (Map.Entry<String, PluginSetting> entry : pluginSettings.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null) {
                    arrayList.add(new BasicNameValuePair(value.packageName, String.valueOf(value.versionCode)));
                }
            }
        }
        cVar.b(arrayList);
        return cVar;
    }
}
