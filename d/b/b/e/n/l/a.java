package d.b.b.e.n.l;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.down.statistic.ConfigSpeedStat;
import d.b.b.e.n.h.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    public static ArrayList<d.b.b.e.n.h.d> a(d.b.b.e.n.h.a aVar, boolean z) {
        ArrayList<d.b.b.e.n.h.d> arrayList = new ArrayList<>();
        File[] b2 = d.b.b.e.n.h.b.b(aVar.E(), z);
        if (b2 != null) {
            for (File file : b2) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (!TextUtils.isEmpty(name) && name.startsWith(aVar.h()) && name.contains("Uploading")) {
                        long length = file.length();
                        if (z && file.getPath().contains("/notUpload")) {
                            name = "notUpload/" + file.getName();
                        }
                        arrayList.add(new d.b.b.e.n.h.d(name, length, file.lastModified()));
                    }
                }
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<d.b.b.e.n.h.d> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        if (aVar.h() != "stat") {
            Iterator<d.b.b.e.n.h.d> it = arrayList.iterator();
            while (it.hasNext()) {
                d.b.b.e.n.h.d next = it.next();
                if (next != null) {
                    long j = next.f41928c;
                    if (j != 0 && j + 604800000 < currentTimeMillis) {
                        arrayList3.add(next.f41927b);
                    } else {
                        arrayList2.add(next);
                    }
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList3.size() > 0) {
            d.b.b.e.n.h.b.a(arrayList3, aVar.E());
        }
        return arrayList;
    }

    public static BdUploadingLogInfo b(d.b.b.e.n.h.a aVar, boolean z) {
        ArrayList<d.b.b.e.n.h.d> a2 = a(aVar, z);
        BdUploadingLogInfo bdUploadingLogInfo = new BdUploadingLogInfo(BdStatisticsManager.getInstance().getWriteDir(), aVar.E(), aVar.A());
        if (a2 != null && a2.size() > 0) {
            if (a2.size() > 1) {
                Collections.sort(a2, new e());
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                d.b.b.e.n.h.d dVar = a2.get(i);
                j += dVar.f41926a;
                arrayList.add(dVar);
                if (j >= ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
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
