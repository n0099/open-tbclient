package d.b.c.e.n.l;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import d.b.c.e.n.h.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    public static ArrayList<d.b.c.e.n.h.d> a(d.b.c.e.n.h.a aVar) {
        ArrayList arrayList = new ArrayList();
        File[] b2 = d.b.c.e.n.h.c.b(aVar.C());
        if (b2 != null) {
            for (File file : b2) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith(aVar.h()) && name.contains("Uploading")) {
                        arrayList.add(new d.b.c.e.n.h.d(name, file.length(), file.lastModified()));
                    }
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<d.b.c.e.n.h.d> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.c.e.n.h.d dVar = (d.b.c.e.n.h.d) it.next();
            if (dVar != null) {
                long j = dVar.f42665c;
                if (j != 0 && j + 604800000 < currentTimeMillis) {
                    arrayList3.add(dVar.f42664b);
                } else {
                    arrayList2.add(dVar);
                }
            }
        }
        if (arrayList3.size() > 0) {
            d.b.c.e.n.h.c.a(arrayList3, aVar.C());
        }
        return arrayList2;
    }

    public static BdUploadingLogInfo b(d.b.c.e.n.h.a aVar) {
        ArrayList<d.b.c.e.n.h.d> a2 = a(aVar);
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.C(), aVar.A());
        if (a2 != null && a2.size() > 0) {
            if (a2.size() > 1) {
                Collections.sort(a2, new e());
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                d.b.c.e.n.h.d dVar = a2.get(i);
                j += dVar.f42663a;
                arrayList.add(dVar);
                if (j >= 20480) {
                    bdUploadingLogInfo.add(arrayList);
                    arrayList = new ArrayList();
                    j = 0;
                }
            }
            if (arrayList.size() > 0) {
                bdUploadingLogInfo.add(arrayList);
            }
        }
        return bdUploadingLogInfo;
    }
}
