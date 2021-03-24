package d.b.i0.i0.k.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
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
    public List<f> f55632a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Integer> f55633b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, List<b>> f55634c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Long, Integer> f55635d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, List<b>> f55636e;

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
        eVar.f55653e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }

    public List<n> b(boolean z) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Integer> hashMap = this.f55633b;
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : this.f55633b.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.f55633b.get(str).intValue();
                    d dVar = new d();
                    dVar.y(str);
                    dVar.needTopMargin = !z;
                    dVar.w(intValue);
                    dVar.v(e(str));
                    arrayList.add(dVar);
                    arrayList.addAll(dVar.t());
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
        HashMap<String, List<b>> hashMap = this.f55636e;
        if (hashMap != null && hashMap.size() > 0) {
            Iterator<String> it = this.f55636e.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.f55635d.get(Long.valueOf(j)).intValue();
                        d dVar = new d();
                        dVar.y(str);
                        dVar.needTopMargin = !z;
                        dVar.w(intValue);
                        dVar.v(g(next));
                        arrayList.add(dVar);
                        arrayList.addAll(dVar.t());
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public List<f> d() {
        return this.f55632a;
    }

    public final List<b> e(String str) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, List<b>> linkedHashMap = this.f55634c;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            arrayList.addAll(this.f55634c.get(str));
        }
        return arrayList;
    }

    public List<f> f(long j) {
        if (ListUtils.isEmpty(this.f55632a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f55632a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (this.f55632a.get(i).f55654a == j) {
                break;
            } else {
                i++;
            }
        }
        if (i == 0) {
            int i2 = size - 1;
            arrayList.add(this.f55632a.get(i2));
            arrayList.addAll(this.f55632a.subList(0, i2));
        } else {
            int i3 = i - 1;
            arrayList.addAll(this.f55632a.subList(i3, size));
            arrayList.addAll(this.f55632a.subList(0, i3));
        }
        return arrayList;
    }

    public final List<b> g(String str) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, List<b>> hashMap = this.f55636e;
        if (hashMap != null && hashMap.size() > 0) {
            arrayList.addAll(this.f55636e.get(str));
        }
        return arrayList;
    }

    public void h(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.test_info)) {
            this.f55632a = new ArrayList();
            this.f55635d = new HashMap<>();
            this.f55636e = new HashMap<>();
            for (TestInfo testInfo : dataRes.test_info) {
                if (testInfo != null) {
                    f fVar = new f();
                    fVar.a(testInfo);
                    this.f55632a.add(fVar);
                    RecommForum recommForum = testInfo.recomm_forum;
                    if (recommForum != null && !ListUtils.isEmpty(recommForum.forums)) {
                        ArrayList arrayList = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                            if (recommendForumInfo != null) {
                                b bVar = new b();
                                bVar.a(recommendForumInfo);
                                bVar.f55644h = 1;
                                arrayList.add(bVar);
                            }
                        }
                        this.f55635d.put(Long.valueOf(fVar.f55654a), testInfo.recomm_forum.page_size);
                        HashMap<String, List<b>> hashMap = this.f55636e;
                        hashMap.put(String.valueOf(fVar.f55654a) + FieldBuilder.SE + testInfo.recomm_forum.title, arrayList);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(dataRes.recomm_forum)) {
            return;
        }
        this.f55633b = new HashMap<>();
        this.f55634c = new LinkedHashMap<>();
        for (RecommForum recommForum2 : dataRes.recomm_forum) {
            if (recommForum2 != null && !ListUtils.isEmpty(recommForum2.forums)) {
                ArrayList arrayList2 = new ArrayList();
                for (RecommendForumInfo recommendForumInfo2 : recommForum2.forums) {
                    if (recommendForumInfo2 != null) {
                        b bVar2 = new b();
                        bVar2.a(recommendForumInfo2);
                        bVar2.f55644h = 2;
                        arrayList2.add(bVar2);
                    }
                }
                this.f55633b.put(recommForum2.title, recommForum2.page_size);
                this.f55634c.put(recommForum2.title, arrayList2);
            }
        }
    }
}
