package d.a.j0.h1.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f54792a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f54793b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f54794c;

    public List<Integer> a() {
        return this.f54794c;
    }

    public List<a> b() {
        return this.f54793b;
    }

    public List<a> c() {
        return this.f54792a;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.sex_taglist)) {
            ArrayList arrayList = new ArrayList();
            this.f54792a = arrayList;
            e(arrayList, dataRes.sex_taglist);
        }
        if (ListUtils.isEmpty(dataRes.taglist)) {
            return;
        }
        this.f54793b = new ArrayList();
        this.f54794c = new ArrayList();
        e(this.f54793b, dataRes.taglist);
    }

    public final void e(List<a> list, List<ResponseTagInfo> list2) {
        if (list == null || list2 == null) {
            return;
        }
        for (ResponseTagInfo responseTagInfo : list2) {
            if (responseTagInfo != null && !StringUtils.isNull(responseTagInfo.tag_name)) {
                a aVar = new a();
                aVar.a(responseTagInfo);
                list.add(aVar);
                List<Integer> list3 = this.f54794c;
                if (list3 != null && aVar.f54791c) {
                    list3.add(Integer.valueOf(aVar.f54789a));
                }
            }
        }
    }
}
