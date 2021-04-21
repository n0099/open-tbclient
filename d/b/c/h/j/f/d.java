package d.b.c.h.j.f;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f43014c;

    /* renamed from: a  reason: collision with root package name */
    public PluginNetConfigInfos f43015a = new PluginNetConfigInfos();

    /* renamed from: b  reason: collision with root package name */
    public b f43016b;

    /* loaded from: classes.dex */
    public class a implements d.b.c.h.j.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c.h.j.f.a f43017a;

        public a(d.b.c.h.j.f.a aVar) {
            this.f43017a = aVar;
        }

        @Override // d.b.c.h.j.f.a
        public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos, String str) {
            if (z) {
                d.this.f43015a = pluginNetConfigInfos;
            }
            d.b.c.h.j.f.a aVar = this.f43017a;
            if (aVar != null) {
                aVar.a(z, cVar, d.this.f43015a, str);
            }
        }
    }

    public static d c() {
        if (f43014c == null) {
            synchronized (d.class) {
                if (f43014c == null) {
                    f43014c = new d();
                }
            }
        }
        return f43014c;
    }

    public PluginNetConfigInfos d() {
        return this.f43015a;
    }

    public void e(PluginSettings pluginSettings, boolean z, d.b.c.h.j.f.a aVar) {
        c g2 = g(pluginSettings);
        b bVar = this.f43016b;
        if (bVar != null) {
            bVar.a(z, g2, new a(aVar));
        }
    }

    public void f(b bVar) {
        this.f43016b = bVar;
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
