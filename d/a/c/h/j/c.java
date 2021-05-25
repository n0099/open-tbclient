package d.a.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import d.a.c.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f39136c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f39137a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f39138b;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public String f39139a;

        public a(String str) {
            this.f39139a = str;
        }

        public final void b(String str) {
            File[] listFiles;
            File m = Util.m();
            String k = Util.k(str);
            if (m == null || !m.exists() || (listFiles = m.listFiles()) == null) {
                return;
            }
            int length = listFiles.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (listFiles[i2] != null && listFiles[i2].isFile() && listFiles[i2].getName().startsWith(k)) {
                    try {
                        f.p(listFiles[i2]);
                        d.a.c.h.h.a.b().o("plugin_del_temp", "deltmp_suc", str, listFiles[i2].getName());
                    } catch (Throwable th) {
                        d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
                        b2.r("plugin_del_temp", "deltmp_fail", str, listFiles[i2].getName() + "-" + th.getMessage());
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str = this.f39139a;
            if (str != null) {
                b(str);
            }
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            c.this.f39138b = null;
            if (c.this.f39137a.size() > 0) {
                Iterator it = c.this.f39137a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.f39139a)) {
                        c.this.f39137a.remove(str);
                        break;
                    }
                }
            }
            c.this.f();
        }
    }

    public static c e() {
        if (f39136c == null) {
            synchronized (c.class) {
                if (f39136c == null) {
                    f39136c = new c();
                }
            }
        }
        return f39136c;
    }

    public void d(PluginSetting pluginSetting) {
        if (pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        boolean z = false;
        Iterator<String> it = this.f39137a.iterator();
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
            this.f39137a.add(pluginSetting.packageName);
        }
        f();
    }

    public final void f() {
        if (this.f39137a.size() <= 0 || this.f39138b != null) {
            return;
        }
        a aVar = new a(this.f39137a.get(0));
        this.f39138b = aVar;
        aVar.execute(new String[0]);
    }
}
