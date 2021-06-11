package d.a.n0.j0.k.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
import tbclient.Recommforum.DataRes;
import tbclient.Recommforum.RecommForum;
import tbclient.Recommforum.TestInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public List<f> f59687a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Integer> f59688b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, List<b>> f59689c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Long, Integer> f59690d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, List<b>> f59691e;

    public List<n> a(long j, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (j > 0) {
            List<n> c2 = c(j, z);
            if (c2 != null && !ListUtils.isEmpty(c2)) {
                arrayList.addAll(c2);
            }
            List<n> b2 = b(z);
            if (b2 != null && !ListUtils.isEmpty(b2)) {
                arrayList.addAll(b2);
            }
        } else {
            List<n> b3 = b(z);
            if (b3 != null && !ListUtils.isEmpty(b3)) {
                arrayList.addAll(b3);
            }
        }
        e eVar = new e();
        eVar.f59709e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }

    public List<n> b(boolean z) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Integer> hashMap = this.f59688b;
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : this.f59688b.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.f59688b.get(str).intValue();
                    d dVar = new d();
                    dVar.y(str);
                    dVar.needTopMargin = !z;
                    dVar.w(intValue);
                    dVar.t(e(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.p());
                }
            }
        }
        return arrayList;
    }

    public final List<n> c(long j, boolean z) {
        if (j <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashMap<String, List<b>> hashMap = this.f59691e;
        if (hashMap != null && hashMap.size() > 0) {
            Iterator<String> it = this.f59691e.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.f59690d.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.y(str);
                        dVar.needTopMargin = !z;
                        dVar.w(intValue);
                        dVar.t(g(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.p());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> d() {
        return this.f59687a;
    }

    public final List<b> e(String str) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, List<b>> linkedHashMap = this.f59689c;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            arrayList.addAll(this.f59689c.get(str));
        }
        return arrayList;
    }

    public List<f> f(long j) {
        if (ListUtils.isEmpty(this.f59687a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f59687a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = 0;
                break;
            } else if (this.f59687a.get(i2).f59710a == j) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == 0) {
            int i3 = size - 1;
            arrayList.add(this.f59687a.get(i3));
            arrayList.addAll(this.f59687a.subList(0, i3));
        } else {
            int i4 = i2 - 1;
            arrayList.addAll(this.f59687a.subList(i4, size));
            arrayList.addAll(this.f59687a.subList(0, i4));
        }
        return arrayList;
    }

    public final List<b> g(String str) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, List<b>> hashMap = this.f59691e;
        if (hashMap != null && hashMap.size() > 0) {
            arrayList.addAll(this.f59691e.get(str));
        }
        return arrayList;
    }

    public void h(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.test_info)) {
            this.f59687a = new ArrayList();
            this.f59690d = new HashMap<>();
            this.f59691e = new HashMap<>();
            for (TestInfo testInfo : dataRes.test_info) {
                if (testInfo != null) {
                    f fVar = new f();
                    fVar.a(testInfo);
                    this.f59687a.add(fVar);
                    RecommForum recommForum = testInfo.recomm_forum;
                    if (recommForum != null && !ListUtils.isEmpty(recommForum.forums)) {
                        ArrayList arrayList = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                            if (recommendForumInfo != null) {
                                b bVar = new b();
                                bVar.a(recommendForumInfo);
                                bVar.f59699h = 1;
                                arrayList.add(bVar);
                            }
                        }
                        this.f59690d.put(Long.valueOf(fVar.f59710a), testInfo.recomm_forum.page_size);
                        HashMap<String, List<b>> hashMap = this.f59691e;
                        hashMap.put(String.valueOf(fVar.f59710a) + "|" + testInfo.recomm_forum.title, arrayList);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(dataRes.recomm_forum)) {
            return;
        }
        this.f59688b = new HashMap<>();
        this.f59689c = new LinkedHashMap<>();
        for (RecommForum recommForum2 : dataRes.recomm_forum) {
            if (recommForum2 != null && !ListUtils.isEmpty(recommForum2.forums)) {
                ArrayList arrayList2 = new ArrayList();
                for (RecommendForumInfo recommendForumInfo2 : recommForum2.forums) {
                    if (recommendForumInfo2 != null) {
                        b bVar2 = new b();
                        bVar2.a(recommendForumInfo2);
                        bVar2.f59699h = 2;
                        arrayList2.add(bVar2);
                    }
                }
                this.f59688b.put(recommForum2.title, recommForum2.page_size);
                this.f59689c.put(recommForum2.title, arrayList2);
            }
        }
    }
}
