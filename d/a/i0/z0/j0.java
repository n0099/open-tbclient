package d.a.i0.z0;

import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f50147a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.j0.x.e0.c> f50148b = new LinkedList();

    /* loaded from: classes3.dex */
    public class a implements Comparator<d.a.j0.x.e0.c> {
        public a(j0 j0Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.j0.x.e0.c cVar, d.a.j0.x.e0.c cVar2) {
            return cVar.sort() - cVar2.sort();
        }
    }

    public List<d.a.j0.x.e0.c> a(List<PbLinkData> list, List<PbGoodsData> list2) {
        if (!ListUtils.isEmpty(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                PbLinkData pbLinkData = list.get(i2);
                if (pbLinkData.urlType == 2 && !this.f50147a) {
                    this.f50147a = true;
                }
                this.f50148b.add(pbLinkData);
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            this.f50147a = true;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                this.f50148b.add(list2.get(i3));
            }
        }
        Collections.sort(this.f50148b, new a(this));
        return this.f50148b;
    }

    public boolean b() {
        return this.f50147a;
    }
}
