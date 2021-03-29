package d.b.h0.z0;

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
    public boolean f51707a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.i0.x.e0.c> f51708b = new LinkedList();

    /* loaded from: classes3.dex */
    public class a implements Comparator<d.b.i0.x.e0.c> {
        public a(j0 j0Var) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.b.i0.x.e0.c cVar, d.b.i0.x.e0.c cVar2) {
            return cVar.sort() - cVar2.sort();
        }
    }

    public List<d.b.i0.x.e0.c> a(List<PbLinkData> list, List<PbGoodsData> list2) {
        if (!ListUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                PbLinkData pbLinkData = list.get(i);
                if (pbLinkData.urlType == 2 && !this.f51707a) {
                    this.f51707a = true;
                }
                this.f51708b.add(pbLinkData);
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            this.f51707a = true;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                this.f51708b.add(list2.get(i2));
            }
        }
        Collections.sort(this.f51708b, new a(this));
        return this.f51708b;
    }

    public boolean b() {
        return this.f51707a;
    }
}
