package d.a.k0.h0.b;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import d.a.j0.w.p.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f55478c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f55479d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.j0.w.p.c> f55480a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final List<d.a.j0.w.p.a> f55481b = new ArrayList();

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<d.a.j0.w.p.c> f55482a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public final a.InterfaceC1158a f55483b = new C1351a();

        /* renamed from: d.a.k0.h0.b.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1351a implements a.InterfaceC1158a {
            public C1351a() {
            }

            @Override // d.a.j0.w.p.a.InterfaceC1158a
            public void a(d.a.j0.w.p.c cVar) {
                a.this.f55482a.add(cVar);
            }
        }

        public a() {
            setPriority(4);
            setParallel(e.f55479d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            e.this.f55480a = this.f55482a;
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            for (int i2 = 0; i2 < e.this.f55481b.size(); i2++) {
                ((d.a.j0.w.p.a) e.this.f55481b.get(i2)).b(this.f55483b);
            }
            return null;
        }
    }

    public static e i() {
        return f55478c;
    }

    public void d(String str, d.a.c.j.d.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        if (z) {
            d.a.j0.a0.c.k().e(e(str, z), aVar, true);
            return;
        }
        d.a.j0.a0.c.k().e(str, aVar, false);
    }

    public String e(String str, boolean z) {
        if (d.f().g()) {
            return str;
        }
        List<d.a.j0.w.p.c> e2 = d.f().e();
        if (z) {
            for (d.a.j0.w.p.c cVar : e2) {
                if (cVar.m(str)) {
                    return str;
                }
            }
            return "#@" + str;
        }
        return str;
    }

    public String f(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            if (str.equals(d.a.j0.a0.d.f48794d)) {
                return null;
            }
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("collect_")) {
                String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + d.a.j0.a0.d.b() + "/" + substring.replace("collect_", "");
                if (z) {
                    return str2 + "_b.gif";
                }
                return str2 + "_s.jpg";
            }
            long hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "d_" : "s_");
            sb.append(hashCode);
            String sb2 = sb.toString();
            if (z) {
                return sb2 + ".gif";
            }
            return sb2 + ".jpg";
        }
        long hashCode2 = str.hashCode();
        if (hashCode2 < 0) {
            hashCode2 *= -1;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z ? "d_" : "s_");
        sb3.append(hashCode2);
        return sb3.toString();
    }

    public String g(String str) {
        if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_")) {
                return substring.substring(0, substring.indexOf("_"));
            }
        }
        return "";
    }

    public ArrayList<d.a.j0.w.p.c> h() {
        return this.f55480a;
    }

    public boolean j(String str) {
        Iterator<d.a.j0.w.p.c> it = this.f55480a.iterator();
        while (it.hasNext()) {
            if (it.next().m(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean k(String str) {
        if (str == null || !j(str)) {
            return false;
        }
        Iterator<d.a.j0.w.p.c> it = this.f55480a.iterator();
        while (it.hasNext()) {
            d.a.j0.w.p.c next = it.next();
            if (next.m(str)) {
                return next.h() == EmotionGroupType.LOCAL;
            }
        }
        return false;
    }

    public boolean l(String str) {
        if (!d.a.j0.a0.d.f48794d.equals(str) && str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_") && !substring.contains("collect_")) {
                return true;
            }
        }
        return false;
    }

    public boolean m(String str) {
        return d.a.j0.a0.d.f48794d.equals(str) || str.startsWith(d.a.j0.a0.d.f48795e);
    }

    public d.a.c.j.d.a n(String str, String str2) {
        Bitmap o;
        d.a.c.j.d.a m = d.a.j0.a0.c.k().m(str2);
        if (m != null) {
            return m;
        }
        Iterator<d.a.j0.w.p.c> it = this.f55480a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.j0.w.p.c next = it.next();
            if (next.m(str2)) {
                m = next.o(str2);
                break;
            }
        }
        if (m == null && str != null && (o = o(str, f(str2, false))) != null) {
            m = new d.a.c.j.d.a(o, false, str2);
        }
        d(str2, m, false);
        return m;
    }

    public Bitmap o(String str, String str2) {
        return FileHelper.getImage(".emotions/" + str, str2);
    }

    public void p(d.a.j0.w.p.a aVar) {
        synchronized (this.f55481b) {
            if (!this.f55481b.contains(aVar)) {
                this.f55481b.add(aVar);
                Collections.sort(this.f55481b);
            }
        }
    }

    public void q() {
        new a().execute(new Void[0]);
    }
}
