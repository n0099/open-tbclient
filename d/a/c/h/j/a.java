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
    public static a f39123d;

    /* renamed from: a  reason: collision with root package name */
    public c f39124a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f39125b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0494a f39126c;

    /* renamed from: d.a.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0494a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f39127a;

        public C0494a(b bVar) {
            this.f39127a = bVar;
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
            b bVar = this.f39127a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f39129a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0494a) bool);
            a.this.f39126c = null;
            if (a.this.f39125b.size() > 0) {
                Iterator it = a.this.f39125b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f39127a, bVar)) {
                        a.this.f39125b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f39124a != null) {
                c cVar = a.this.f39124a;
                b bVar2 = this.f39127a;
                cVar.a(bVar2.f39130b, bVar2.f39129a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f39129a;

        /* renamed from: b  reason: collision with root package name */
        public String f39130b;

        public b(String str, String str2) {
            this.f39130b = str;
            this.f39129a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f39123d == null) {
            synchronized (a.class) {
                if (f39123d == null) {
                    f39123d = new a();
                }
            }
        }
        return f39123d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f39124a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f39129a) && !TextUtils.isEmpty(next.f39130b)) {
                boolean z = false;
                Iterator<b> it2 = this.f39125b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f39125b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f39129a) || TextUtils.isEmpty(bVar2.f39130b) || TextUtils.isEmpty(bVar.f39129a) || TextUtils.isEmpty(bVar.f39130b) || !bVar2.f39130b.equals(bVar.f39130b) || !bVar2.f39129a.equals(bVar.f39129a)) ? false : true;
    }

    public final void i() {
        if (this.f39125b.size() != 0 && this.f39126c == null) {
            C0494a c0494a = new C0494a(this.f39125b.get(0));
            this.f39126c = c0494a;
            c0494a.execute(new String[0]);
        }
    }
}
