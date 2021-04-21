package d.b.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import d.b.c.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f43006c;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f43007a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f43008b;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public String f43009a;

        public a(String str) {
            this.f43009a = str;
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
                        d.b.c.h.h.a.b().o("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                    } catch (Throwable th) {
                        d.b.c.h.h.a b2 = d.b.c.h.h.a.b();
                        b2.r("plugin_del_temp", "deltmp_fail", str, listFiles[i].getName() + "-" + th.getMessage());
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            String str = this.f43009a;
            if (str != null) {
                b(str);
            }
            return Boolean.TRUE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            c.this.f43008b = null;
            if (c.this.f43007a.size() > 0) {
                Iterator it = c.this.f43007a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.f43009a)) {
                        c.this.f43007a.remove(str);
                        break;
                    }
                }
            }
            c.this.f();
        }
    }

    public static c e() {
        if (f43006c == null) {
            synchronized (c.class) {
                if (f43006c == null) {
                    f43006c = new c();
                }
            }
        }
        return f43006c;
    }

    public void d(PluginSetting pluginSetting) {
        if (pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        boolean z = false;
        Iterator<String> it = this.f43007a.iterator();
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
            this.f43007a.add(pluginSetting.packageName);
        }
        f();
    }

    public final void f() {
        if (this.f43007a.size() <= 0 || this.f43008b != null) {
            return;
        }
        a aVar = new a(this.f43007a.get(0));
        this.f43008b = aVar;
        aVar.execute(new String[0]);
    }
}
