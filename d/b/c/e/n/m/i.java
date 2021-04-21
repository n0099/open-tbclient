package d.b.c.e.n.m;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.IMConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {

    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, Integer, String> {
        public b() {
        }

        public final void b() {
            ArrayList<d.b.c.e.n.h.d> c2 = d.b.c.e.n.h.b.c(true);
            if (c2 == null || c2.size() == 0) {
                return;
            }
            int i = 0;
            Iterator<d.b.c.e.n.h.d> it = c2.iterator();
            while (it.hasNext()) {
                i = (int) (i + it.next().f42663a);
            }
            int i2 = i - IMConstants.MAX_IMAGE_CACHE_DISC_SIZE;
            ArrayList arrayList = new ArrayList();
            if (i2 > 0) {
                Collections.sort(c2, new d.b.c.e.n.h.e());
                Iterator<d.b.c.e.n.h.d> it2 = c2.iterator();
                while (it2.hasNext()) {
                    d.b.c.e.n.h.d next = it2.next();
                    arrayList.add(next.f42664b);
                    i2 = (int) (i2 - next.f42663a);
                    if (i2 <= 0) {
                        break;
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<d.b.c.e.n.h.d> it3 = c2.iterator();
            while (it3.hasNext()) {
                d.b.c.e.n.h.d next2 = it3.next();
                if (next2 != null) {
                    long j = next2.f42665c;
                    if (j != 0 && j + 604800000 < currentTimeMillis && !arrayList.contains(next2.f42664b)) {
                        arrayList.add(next2.f42664b);
                    }
                }
            }
            if (arrayList.size() > 0) {
                d.b.c.e.n.h.b.a(arrayList, true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            b();
            return null;
        }
    }

    public void a() {
        new b().execute(new String[0]);
    }
}
