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
    public static volatile d f42900c;

    /* renamed from: a  reason: collision with root package name */
    public PluginNetConfigInfos f42901a = new PluginNetConfigInfos();

    /* renamed from: b  reason: collision with root package name */
    public b f42902b;

    /* loaded from: classes.dex */
    public class a implements d.a.c.h.j.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c.h.j.f.a f42903a;

        public a(d.a.c.h.j.f.a aVar) {
            this.f42903a = aVar;
        }

        @Override // d.a.c.h.j.f.a
        public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            if (z) {
                d.this.f42901a = pluginNetConfigInfos;
            }
            d.a.c.h.j.f.a aVar = this.f42903a;
            if (aVar != null) {
                aVar.a(z, cVar, d.this.f42901a, str);
            }
        }
    }

    public static d c() {
        if (f42900c == null) {
            synchronized (d.class) {
                if (f42900c == null) {
                    f42900c = new d();
                }
            }
        }
        return f42900c;
    }

    public PluginNetConfigInfos d() {
        return this.f42901a;
    }

    public void e(PluginSettings pluginSettings, boolean z, d.a.c.h.j.f.a aVar) {
        c g2 = g(pluginSettings);
        b bVar = this.f42902b;
        if (bVar != null) {
            bVar.a(z, g2, new a(aVar));
        }
    }

    public void f(b bVar) {
        this.f42902b = bVar;
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
