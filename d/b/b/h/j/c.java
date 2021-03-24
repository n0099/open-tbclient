package d.b.b.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import d.b.b.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f42268c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f42269a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f42270b;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public String f42271a;

        public a(String str) {
            this.f42271a = str;
        }

        public final void b(String str) {
            File[] listFiles;
            File m = Util.m();
            String k = Util.k(str);
            if (m == null || !m.exists() || (listFiles = m.listFiles()) == null) {
                return;
            }
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(k)) {
                    try {
                        f.p(listFiles[i]);
                        d.b.b.h.h.a.b().o("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                    } catch (Throwable th) {
                        d.b.b.h.h.a b2 = d.b.b.h.h.a.b();
                        b2.r("plugin_del_temp", "deltmp_fail", str, listFiles[i].getName() + "-" + th.getMessage());
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str = this.f42271a;
            if (str != null) {
                b(str);
            }
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            c.this.f42270b = null;
            if (c.this.f42269a.size() > 0) {
                Iterator it = c.this.f42269a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.f42271a)) {
                        c.this.f42269a.remove(str);
                        break;
                    }
                }
            }
            c.this.f();
        }
    }

    public static c e() {
        if (f42268c == null) {
            synchronized (c.class) {
                if (f42268c == null) {
                    f42268c = new c();
                }
            }
        }
        return f42268c;
    }

    public void d(PluginSetting pluginSetting) {
        if (pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        boolean z = false;
        Iterator<String> it = this.f42269a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && next.equals(pluginSetting.packageName)) {
                z = true;
                break;
            }
        }
        if (!z) {
            this.f42269a.add(pluginSetting.packageName);
        }
        f();
    }

    public final void f() {
        if (this.f42269a.size() <= 0 || this.f42270b != null) {
            return;
        }
        a aVar = new a(this.f42269a.get(0));
        this.f42270b = aVar;
        aVar.execute(new String[0]);
    }
}
