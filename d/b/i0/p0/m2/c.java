package d.b.i0.p0.m2;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.i0.p0.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class c {

    /* loaded from: classes4.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f57906e;

        public a(r rVar) {
            this.f57906e = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f57906e.D0();
        }
    }

    public static void a(ResponsedMessage<?> responsedMessage, r rVar, FrsViewData frsViewData) {
        List<DownloadData> data;
        if (frsViewData == null || rVar == null || !(responsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) responsedMessage).getData()) == null) {
            return;
        }
        boolean z = false;
        Iterator<DownloadData> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getStatus() == 0) {
                z = true;
                break;
            }
        }
        if (z) {
            d.b.b.e.m.e.a().postDelayed(new a(rVar), TimeUnit.SECONDS.toMillis(2L));
        }
    }

    public static void b(r rVar) {
        HashMap<Integer, a2> c2;
        if (rVar == null || rVar.U() == null || (c2 = rVar.U().c()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, a2> entry : c2.entrySet()) {
            a2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.b.i0.r2.x.e.n().w(arrayList);
    }
}
