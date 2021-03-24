package d.b.b.h.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.b.b.e.p.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f42255d;

    /* renamed from: a  reason: collision with root package name */
    public c f42256a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f42257b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0546a f42258c;

    /* renamed from: d.b.b.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0546a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f42259a;

        public C0546a(b bVar) {
            this.f42259a = bVar;
        }

        public final boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f.p(new File(str));
                d.b.b.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                d.b.b.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length < 4) {
                return false;
            }
            File file = new File(str.substring(0, length - 4));
            if (file.exists() && file.isDirectory()) {
                try {
                    f.p(file);
                    d.b.b.h.h.a.b().o("plugin_del_unuse", "delete_unuse", str, null);
                    return true;
                } catch (Throwable th2) {
                    d.b.b.h.h.a.b().o("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                    return true;
                }
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            b bVar = this.f42259a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f42261a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0546a) bool);
            a.this.f42258c = null;
            if (a.this.f42257b.size() > 0) {
                Iterator it = a.this.f42257b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f42259a, bVar)) {
                        a.this.f42257b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f42256a != null) {
                c cVar = a.this.f42256a;
                b bVar2 = this.f42259a;
                cVar.a(bVar2.f42262b, bVar2.f42261a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f42261a;

        /* renamed from: b  reason: collision with root package name */
        public String f42262b;

        public b(String str, String str2) {
            this.f42262b = str;
            this.f42261a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f42255d == null) {
            synchronized (a.class) {
                if (f42255d == null) {
                    f42255d = new a();
                }
            }
        }
        return f42255d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f42256a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f42261a) && !TextUtils.isEmpty(next.f42262b)) {
                boolean z = false;
                Iterator<b> it2 = this.f42257b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f42257b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f42261a) || TextUtils.isEmpty(bVar2.f42262b) || TextUtils.isEmpty(bVar.f42261a) || TextUtils.isEmpty(bVar.f42262b) || !bVar2.f42262b.equals(bVar.f42262b) || !bVar2.f42261a.equals(bVar.f42261a)) ? false : true;
    }

    public final void i() {
        if (this.f42257b.size() != 0 && this.f42258c == null) {
            C0546a c0546a = new C0546a(this.f42257b.get(0));
            this.f42258c = c0546a;
            c0546a.execute(new String[0]);
        }
    }
}
