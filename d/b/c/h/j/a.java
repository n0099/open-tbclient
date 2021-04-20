package d.b.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.b.c.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f42753d;

    /* renamed from: a  reason: collision with root package name */
    public c f42754a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f42755b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0565a f42756c;

    /* renamed from: d.b.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0565a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f42757a;

        public C0565a(b bVar) {
            this.f42757a = bVar;
        }

        public final boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f.p(new File(str));
                d.b.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                d.b.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length < 4) {
                return false;
            }
            File file = new File(str.substring(0, length - 4));
            if (file.exists() && file.isDirectory()) {
                try {
                    f.p(file);
                    d.b.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                    return true;
                } catch (Throwable th2) {
                    d.b.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                    return true;
                }
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            b bVar = this.f42757a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f42759a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0565a) bool);
            a.this.f42756c = null;
            if (a.this.f42755b.size() > 0) {
                Iterator it = a.this.f42755b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f42757a, bVar)) {
                        a.this.f42755b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f42754a != null) {
                c cVar = a.this.f42754a;
                b bVar2 = this.f42757a;
                cVar.a(bVar2.f42760b, bVar2.f42759a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f42759a;

        /* renamed from: b  reason: collision with root package name */
        public String f42760b;

        public b(String str, String str2) {
            this.f42760b = str;
            this.f42759a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f42753d == null) {
            synchronized (a.class) {
                if (f42753d == null) {
                    f42753d = new a();
                }
            }
        }
        return f42753d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f42754a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f42759a) && !TextUtils.isEmpty(next.f42760b)) {
                boolean z = false;
                Iterator<b> it2 = this.f42755b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f42755b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f42759a) || TextUtils.isEmpty(bVar2.f42760b) || TextUtils.isEmpty(bVar.f42759a) || TextUtils.isEmpty(bVar.f42760b) || !bVar2.f42760b.equals(bVar.f42760b) || !bVar2.f42759a.equals(bVar.f42759a)) ? false : true;
    }

    public final void i() {
        if (this.f42755b.size() != 0 && this.f42756c == null) {
            C0565a c0565a = new C0565a(this.f42755b.get(0));
            this.f42756c = c0565a;
            c0565a.execute(new String[0]);
        }
    }
}
