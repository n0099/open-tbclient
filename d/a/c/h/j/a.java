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
    public static a f39459d;

    /* renamed from: a  reason: collision with root package name */
    public c f39460a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f39461b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0510a f39462c;

    /* renamed from: d.a.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0510a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f39463a;

        public C0510a(b bVar) {
            this.f39463a = bVar;
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
            b bVar = this.f39463a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f39465a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0510a) bool);
            a.this.f39462c = null;
            if (a.this.f39461b.size() > 0) {
                Iterator it = a.this.f39461b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f39463a, bVar)) {
                        a.this.f39461b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f39460a != null) {
                c cVar = a.this.f39460a;
                b bVar2 = this.f39463a;
                cVar.a(bVar2.f39466b, bVar2.f39465a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f39465a;

        /* renamed from: b  reason: collision with root package name */
        public String f39466b;

        public b(String str, String str2) {
            this.f39466b = str;
            this.f39465a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f39459d == null) {
            synchronized (a.class) {
                if (f39459d == null) {
                    f39459d = new a();
                }
            }
        }
        return f39459d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f39460a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f39465a) && !TextUtils.isEmpty(next.f39466b)) {
                boolean z = false;
                Iterator<b> it2 = this.f39461b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f39461b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f39465a) || TextUtils.isEmpty(bVar2.f39466b) || TextUtils.isEmpty(bVar.f39465a) || TextUtils.isEmpty(bVar.f39466b) || !bVar2.f39466b.equals(bVar.f39466b) || !bVar2.f39465a.equals(bVar.f39465a)) ? false : true;
    }

    public final void i() {
        if (this.f39461b.size() != 0 && this.f39462c == null) {
            C0510a c0510a = new C0510a(this.f39461b.get(0));
            this.f39462c = c0510a;
            c0510a.execute(new String[0]);
        }
    }
}
