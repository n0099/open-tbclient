package d.a.k0.q0.n2;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.a.j0.r.q.a2;
import d.a.k0.q0.r;
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
        public final /* synthetic */ r f58999e;

        public a(r rVar) {
            this.f58999e = rVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f58999e.D0();
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
            d.a.c.e.m.e.a().postDelayed(new a(rVar), TimeUnit.SECONDS.toMillis(2L));
        }
    }

    public static void b(r rVar) {
        HashMap<Integer, a2> h2;
        if (rVar == null || rVar.U() == null || (h2 = rVar.U().h()) == null) {
            return;
        }
        ArrayList<AdvertAppInfo> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, a2> entry : h2.entrySet()) {
            a2 value = entry.getValue();
            if (value != null && (value instanceof AdvertAppInfo)) {
                arrayList.add((AdvertAppInfo) value);
            }
        }
        d.a.k0.s2.c0.e.n().w(arrayList);
    }
}
