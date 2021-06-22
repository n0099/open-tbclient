package d.a.o0.m0;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.faceshop.CollectEmotionData;
import d.a.o0.m0.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    public u f61194a = u.s();

    /* renamed from: b  reason: collision with root package name */
    public Handler f61195b = new Handler(Looper.getMainLooper());

    /* loaded from: classes4.dex */
    public class a implements u.l {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f61196e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Map f61197f;

        public a(List list, Map map) {
            this.f61196e = list;
            this.f61197f = map;
        }

        @Override // d.a.o0.m0.u.l
        public void onResult(int i2, int i3, int i4) {
            w.this.d(this.f61196e, this.f61197f);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f61199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f61200f;

        /* loaded from: classes4.dex */
        public class a implements u.l {
            public a() {
            }

            @Override // d.a.o0.m0.u.l
            public void onResult(int i2, int i3, int i4) {
                b bVar = b.this;
                w.this.g(bVar.f61200f);
            }
        }

        public b(List list, List list2) {
            this.f61199e = list;
            this.f61200f = list2;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f61194a.h(this.f61199e, false, new a());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements u.l {
        public c(w wVar) {
        }

        @Override // d.a.o0.m0.u.l
        public void onResult(int i2, int i3, int i4) {
            if (i3 > 0) {
                BdLog.e("NewFaceSyncUtil setCollectUpdateTime reSortLocalFace Called:" + System.currentTimeMillis());
                d.a.o0.z1.d.s(System.currentTimeMillis());
            }
            d.a.o0.z1.d.m().u(false);
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
                d.a.n0.b0.c cVar = new d.a.n0.b0.c();
                cVar.f52696f = collectEmotionData2.pkgId;
                cVar.f52691a = collectEmotionData2.pid;
                cVar.f52694d = collectEmotionData2.picUrl;
                cVar.f52692b = collectEmotionData2.width;
                cVar.f52693c = collectEmotionData2.height;
                cVar.f52695e = collectEmotionData2.thumbnail;
                arrayList2.add(cVar);
            }
            this.f61195b.post(new b(arrayList2, list));
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
            this.f61194a.l(arrayList, false, new a(list, h2));
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
        this.f61194a.t(list, false, new c(this));
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
