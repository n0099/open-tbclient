package d.b.i0.h1.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetTagList.DataRes;
import tbclient.GetTagList.ResponseTagInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f56461a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f56462b;

    /* renamed from: c  reason: collision with root package name */
    public List<Integer> f56463c;

    public List<Integer> a() {
        return this.f56463c;
    }

    public List<a> b() {
        return this.f56462b;
    }

    public List<a> c() {
        return this.f56461a;
    }

    public void d(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (!ListUtils.isEmpty(dataRes.sex_taglist)) {
            ArrayList arrayList = new ArrayList();
            this.f56461a = arrayList;
            e(arrayList, dataRes.sex_taglist);
        }
        if (ListUtils.isEmpty(dataRes.taglist)) {
            return;
        }
        this.f56462b = new ArrayList();
        this.f56463c = new ArrayList();
        e(this.f56462b, dataRes.taglist);
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
                List<Integer> list3 = this.f56463c;
                if (list3 != null && aVar.f56460c) {
                    list3.add(Integer.valueOf(aVar.f56458a));
                }
            }
        }
    }
}
