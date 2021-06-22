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
    public static a f42879d;

    /* renamed from: a  reason: collision with root package name */
    public c f42880a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f42881b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0553a f42882c;

    /* renamed from: d.a.c.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0553a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f42883a;

        public C0553a(b bVar) {
            this.f42883a = bVar;
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
            b bVar = this.f42883a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f42885a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0553a) bool);
            a.this.f42882c = null;
            if (a.this.f42881b.size() > 0) {
                Iterator it = a.this.f42881b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f42883a, bVar)) {
                        a.this.f42881b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f42880a != null) {
                c cVar = a.this.f42880a;
                b bVar2 = this.f42883a;
                cVar.a(bVar2.f42886b, bVar2.f42885a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f42885a;

        /* renamed from: b  reason: collision with root package name */
        public String f42886b;

        public b(String str, String str2) {
            this.f42886b = str;
            this.f42885a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f42879d == null) {
            synchronized (a.class) {
                if (f42879d == null) {
                    f42879d = new a();
                }
            }
        }
        return f42879d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f42880a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f42885a) && !TextUtils.isEmpty(next.f42886b)) {
                boolean z = false;
                Iterator<b> it2 = this.f42881b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f42881b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f42885a) || TextUtils.isEmpty(bVar2.f42886b) || TextUtils.isEmpty(bVar.f42885a) || TextUtils.isEmpty(bVar.f42886b) || !bVar2.f42886b.equals(bVar.f42886b) || !bVar2.f42885a.equals(bVar.f42885a)) ? false : true;
    }

    public final void i() {
        if (this.f42881b.size() != 0 && this.f42882c == null) {
            C0553a c0553a = new C0553a(this.f42881b.get(0));
            this.f42882c = c0553a;
            c0553a.execute(new String[0]);
        }
    }
}
