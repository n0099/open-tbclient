package d.a.c.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.a.c.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f42776d;

    /* renamed from: a  reason: collision with root package name */
    public c f42777a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f42778b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0550a f42779c;

    /* renamed from: d.a.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0550a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f42780a;

        public C0550a(b bVar) {
            this.f42780a = bVar;
        }

        public final boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f.p(new File(str));
                d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length < 4) {
                return false;
            }
            File file = new File(str.substring(0, length - 4));
            if (file.exists() && file.isDirectory()) {
                try {
                    f.p(file);
                    d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                    return true;
                } catch (Throwable th2) {
                    d.a.c.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                    return true;
                }
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            b bVar = this.f42780a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f42782a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0550a) bool);
            a.this.f42779c = null;
            if (a.this.f42778b.size() > 0) {
                Iterator it = a.this.f42778b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f42780a, bVar)) {
                        a.this.f42778b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f42777a != null) {
                c cVar = a.this.f42777a;
                b bVar2 = this.f42780a;
                cVar.a(bVar2.f42783b, bVar2.f42782a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f42782a;

        /* renamed from: b  reason: collision with root package name */
        public String f42783b;

        public b(String str, String str2) {
            this.f42783b = str;
            this.f42782a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f42776d == null) {
            synchronized (a.class) {
                if (f42776d == null) {
                    f42776d = new a();
                }
            }
        }
        return f42776d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f42777a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f42782a) && !TextUtils.isEmpty(next.f42783b)) {
                boolean z = false;
                Iterator<b> it2 = this.f42778b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f42778b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f42782a) || TextUtils.isEmpty(bVar2.f42783b) || TextUtils.isEmpty(bVar.f42782a) || TextUtils.isEmpty(bVar.f42783b) || !bVar2.f42783b.equals(bVar.f42783b) || !bVar2.f42782a.equals(bVar.f42782a)) ? false : true;
    }

    public final void i() {
        if (this.f42778b.size() != 0 && this.f42779c == null) {
            C0550a c0550a = new C0550a(this.f42778b.get(0));
            this.f42779c = c0550a;
            c0550a.execute(new String[0]);
        }
    }
}
