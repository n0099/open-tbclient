package d.b.j0.l0;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.faceshop.CollectEmotionData;
import d.b.j0.l0.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public u f58478a = u.s();

    /* renamed from: b  reason: collision with root package name */
    public Handler f58479b = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a implements u.l {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f58480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f58481f;

        public a(List list, Map map) {
            this.f58480e = list;
            this.f58481f = map;
        }

        @Override // d.b.j0.l0.u.l
        public void onResult(int i, int i2, int i3) {
            w.this.d(this.f58480e, this.f58481f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f58483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f58484f;

        /* loaded from: classes4.dex */
        public class a implements u.l {
            public a() {
            }

            @Override // d.b.j0.l0.u.l
            public void onResult(int i, int i2, int i3) {
                b bVar = b.this;
                w.this.g(bVar.f58484f);
            }
        }

        public b(List list, List list2) {
            this.f58483e = list;
            this.f58484f = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f58478a.h(this.f58483e, false, new a());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements u.l {
        public c(w wVar) {
        }

        @Override // d.b.j0.l0.u.l
        public void onResult(int i, int i2, int i3) {
            if (i2 > 0) {
                BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                d.b.j0.y1.d.s(System.currentTimeMillis());
            }
            d.b.j0.y1.d.m().u(false);
        }
    }

    public final void d(List<CollectEmotionData> list, Map<String, CollectEmotionData> map) {
        ArrayList<CollectEmotionData> arrayList = new ArrayList();
        for (CollectEmotionData collectEmotionData : list) {
            if (collectEmotionData != null && !map.containsKey(collectEmotionData.pid) && !TextUtils.isEmpty(collectEmotionData.picUrl)) {
                arrayList.add(collectEmotionData);
            }
        }
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (CollectEmotionData collectEmotionData2 : arrayList) {
                d.b.i0.b0.c cVar = new d.b.i0.b0.c();
                cVar.f50508f = collectEmotionData2.pkgId;
                cVar.f50503a = collectEmotionData2.pid;
                cVar.f50506d = collectEmotionData2.picUrl;
                cVar.f50504b = collectEmotionData2.width;
                cVar.f50505c = collectEmotionData2.height;
                cVar.f50507e = collectEmotionData2.thumbnail;
                arrayList2.add(cVar);
            }
            this.f58479b.post(new b(arrayList2, list));
            return;
        }
        g(list);
    }

    public final void e(List<CollectEmotionData> list, List<CollectEmotionData> list2) {
        ArrayList arrayList = new ArrayList();
        Map<String, CollectEmotionData> h2 = h(list2);
        Map<String, CollectEmotionData> h3 = h(list);
        for (Map.Entry<String, CollectEmotionData> entry : h2.entrySet()) {
            if (!h3.containsKey(entry.getKey())) {
                arrayList.add(entry.getValue());
            }
        }
        if (!arrayList.isEmpty()) {
            this.f58478a.l(arrayList, false, new a(list, h2));
        } else {
            d(list, h2);
        }
    }

    public void f(List<CollectEmotionData> list) {
        u.s().k(true);
        List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
        for (CollectEmotionData collectEmotionData : n) {
            String o = u.o(collectEmotionData.pid, false);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(o);
            collectEmotionData.imageFileInfo = imageFileInfo;
        }
        BdLog.e("NewFaceSyncUtil MergeCollectFace Called CloudList:");
        Iterator<CollectEmotionData> it = list.iterator();
        while (it.hasNext()) {
            BdLog.e("NewFaceSyncUtil Cloud data:" + it.next().pkgId);
        }
        BdLog.e("NewFaceSyncUtil MergeCollectFace Called localList:");
        Iterator<CollectEmotionData> it2 = n.iterator();
        while (it2.hasNext()) {
            BdLog.e("NewFaceSyncUtil Local data:" + it2.next().pkgId);
        }
        e(list, n);
    }

    public final void g(List<CollectEmotionData> list) {
        this.f58478a.t(list, false, new c(this));
    }

    public final Map<String, CollectEmotionData> h(List<CollectEmotionData> list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (CollectEmotionData collectEmotionData : list) {
                if (collectEmotionData != null && !TextUtils.isEmpty(collectEmotionData.pid)) {
                    hashMap.put(collectEmotionData.pid, collectEmotionData);
                }
            }
        }
        return hashMap;
    }
}
