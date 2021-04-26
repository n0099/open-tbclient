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
    public static a f40214d;

    /* renamed from: a  reason: collision with root package name */
    public c f40215a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f40216b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0523a f40217c;

    /* renamed from: d.a.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0523a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f40218a;

        public C0523a(b bVar) {
            this.f40218a = bVar;
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
            b bVar = this.f40218a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f40220a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0523a) bool);
            a.this.f40217c = null;
            if (a.this.f40216b.size() > 0) {
                Iterator it = a.this.f40216b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f40218a, bVar)) {
                        a.this.f40216b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f40215a != null) {
                c cVar = a.this.f40215a;
                b bVar2 = this.f40218a;
                cVar.a(bVar2.f40221b, bVar2.f40220a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f40220a;

        /* renamed from: b  reason: collision with root package name */
        public String f40221b;

        public b(String str, String str2) {
            this.f40221b = str;
            this.f40220a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f40214d == null) {
            synchronized (a.class) {
                if (f40214d == null) {
                    f40214d = new a();
                }
            }
        }
        return f40214d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f40215a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f40220a) && !TextUtils.isEmpty(next.f40221b)) {
                boolean z = false;
                Iterator<b> it2 = this.f40216b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f40216b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f40220a) || TextUtils.isEmpty(bVar2.f40221b) || TextUtils.isEmpty(bVar.f40220a) || TextUtils.isEmpty(bVar.f40221b) || !bVar2.f40221b.equals(bVar.f40221b) || !bVar2.f40220a.equals(bVar.f40220a)) ? false : true;
    }

    public final void i() {
        if (this.f40216b.size() != 0 && this.f40217c == null) {
            C0523a c0523a = new C0523a(this.f40216b.get(0));
            this.f40217c = c0523a;
            c0523a.execute(new String[0]);
        }
    }
}
