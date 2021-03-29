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
    public static a f42256d;

    /* renamed from: a  reason: collision with root package name */
    public c f42257a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<b> f42258b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public C0547a f42259c;

    /* renamed from: d.b.b.h.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0547a extends BdAsyncTask<String, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public b f42260a;

        public C0547a(b bVar) {
            this.f42260a = bVar;
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
            b bVar = this.f42260a;
            if (bVar != null) {
                return Boolean.valueOf(b(bVar.f42262a));
            }
            return Boolean.FALSE;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0547a) bool);
            a.this.f42259c = null;
            if (a.this.f42258b.size() > 0) {
                Iterator it = a.this.f42258b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.g(this.f42260a, bVar)) {
                        a.this.f42258b.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.f42257a != null) {
                c cVar = a.this.f42257a;
                b bVar2 = this.f42260a;
                cVar.a(bVar2.f42263b, bVar2.f42262a);
            }
            a.this.i();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f42262a;

        /* renamed from: b  reason: collision with root package name */
        public String f42263b;

        public b(String str, String str2) {
            this.f42263b = str;
            this.f42262a = str2;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public static a h() {
        if (f42256d == null) {
            synchronized (a.class) {
                if (f42256d == null) {
                    f42256d = new a();
                }
            }
        }
        return f42256d;
    }

    public void f(ArrayList<b> arrayList, c cVar) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.f42257a = cVar;
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f42262a) && !TextUtils.isEmpty(next.f42263b)) {
                boolean z = false;
                Iterator<b> it2 = this.f42258b.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (g(it2.next(), next)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.f42258b.add(next);
                }
            }
        }
        i();
    }

    public final boolean g(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.f42262a) || TextUtils.isEmpty(bVar2.f42263b) || TextUtils.isEmpty(bVar.f42262a) || TextUtils.isEmpty(bVar.f42263b) || !bVar2.f42263b.equals(bVar.f42263b) || !bVar2.f42262a.equals(bVar.f42262a)) ? false : true;
    }

    public final void i() {
        if (this.f42258b.size() != 0 && this.f42259c == null) {
            C0547a c0547a = new C0547a(this.f42258b.get(0));
            this.f42259c = c0547a;
            c0547a.execute(new String[0]);
        }
    }
}
