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
    public List<f> f55633a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Integer> f55634b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, List<b>> f55635c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<Long, Integer> f55636d;

    /* renamed from: e  reason: collision with root package name */
    public HashMap<String, List<b>> f55637e;

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
        eVar.f55654e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
        arrayList.add(eVar);
        return arrayList;
    }

    public List<n> b(boolean z) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, Integer> hashMap = this.f55634b;
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : this.f55634b.keySet()) {
                if (!StringUtils.isNull(str)) {
                    int intValue = this.f55634b.get(str).intValue();
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
        HashMap<String, List<b>> hashMap = this.f55637e;
        if (hashMap != null && hashMap.size() > 0) {
            Iterator<String> it = this.f55637e.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!StringUtils.isNull(next)) {
                    String[] split = next.split("[|]");
                    if (String.valueOf(j).equals(split[0]) && split.length == 2 && !StringUtils.isNull(split[1])) {
                        String str = split[1];
                        int intValue = this.f55636d.get(Long.valueOf(j)).intValue();
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
        return this.f55633a;
    }

    public final List<b> e(String str) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, List<b>> linkedHashMap = this.f55635c;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            arrayList.addAll(this.f55635c.get(str));
        }
        return arrayList;
    }

    public List<f> f(long j) {
        if (ListUtils.isEmpty(this.f55633a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f55633a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = 0;
                break;
            } else if (this.f55633a.get(i).f55655a == j) {
                break;
            } else {
                i++;
            }
        }
        if (i == 0) {
            int i2 = size - 1;
            arrayList.add(this.f55633a.get(i2));
            arrayList.addAll(this.f55633a.subList(0, i2));
        } else {
            int i3 = i - 1;
            arrayList.addAll(this.f55633a.subList(i3, size));
            arrayList.addAll(this.f55633a.subList(0, i3));
        }
        return arrayList;
    }

    public final List<b> g(String str) {
        ArrayList arrayList = new ArrayList();
        HashMap<String, List<b>> hashMap = this.f55637e;
        if (hashMap != null && hashMap.size() > 0) {
            arrayList.addAll(this.f55637e.get(str));
        }
        return arrayList;
    }

    public void h(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.test_info)) {
            this.f55633a = new ArrayList();
            this.f55636d = new HashMap<>();
            this.f55637e = new HashMap<>();
            for (TestInfo testInfo : dataRes.test_info) {
                if (testInfo != null) {
                    f fVar = new f();
                    fVar.a(testInfo);
                    this.f55633a.add(fVar);
                    RecommForum recommForum = testInfo.recomm_forum;
                    if (recommForum != null && !ListUtils.isEmpty(recommForum.forums)) {
                        ArrayList arrayList = new ArrayList();
                        for (RecommendForumInfo recommendForumInfo : testInfo.recomm_forum.forums) {
                            if (recommendForumInfo != null) {
                                b bVar = new b();
                                bVar.a(recommendForumInfo);
                                bVar.f55645h = 1;
                                arrayList.add(bVar);
                            }
                        }
                        this.f55636d.put(Long.valueOf(fVar.f55655a), testInfo.recomm_forum.page_size);
                        HashMap<String, List<b>> hashMap = this.f55637e;
                        hashMap.put(String.valueOf(fVar.f55655a) + FieldBuilder.SE + testInfo.recomm_forum.title, arrayList);
                    }
                }
            }
        }
        if (ListUtils.isEmpty(dataRes.recomm_forum)) {
            return;
        }
        this.f55634b = new HashMap<>();
        this.f55635c = new LinkedHashMap<>();
        for (RecommForum recommForum2 : dataRes.recomm_forum) {
            if (recommForum2 != null && !ListUtils.isEmpty(recommForum2.forums)) {
                ArrayList arrayList2 = new ArrayList();
                for (RecommendForumInfo recommendForumInfo2 : recommForum2.forums) {
                    if (recommendForumInfo2 != null) {
                        b bVar2 = new b();
                        bVar2.a(recommendForumInfo2);
                        bVar2.f55645h = 2;
                        arrayList2.add(bVar2);
                    }
                }
                this.f55634b.put(recommForum2.title, recommForum2.page_size);
                this.f55635c.put(recommForum2.title, arrayList2);
            }
        }
    }
}
