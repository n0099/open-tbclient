package d.a.n0.i1.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f55687a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f55688b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f55689c;

    public List<Integer> a() {
        return this.f55689c;
    }

    public List<a> b() {
        return this.f55688b;
    }

    public List<a> c() {
        return this.f55687a;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.sex_taglist)) {
            ArrayList arrayList = new ArrayList();
            this.f55687a = arrayList;
            e(arrayList, dataRes.sex_taglist);
        }
        if (ListUtils.isEmpty(dataRes.taglist)) {
            return;
        }
        this.f55688b = new ArrayList();
        this.f55689c = new ArrayList();
        e(this.f55688b, dataRes.taglist);
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
                List<Integer> list3 = this.f55689c;
                if (list3 != null && aVar.f55686c) {
                    list3.add(Integer.valueOf(aVar.f55684a));
                }
            }
        }
    }
}
