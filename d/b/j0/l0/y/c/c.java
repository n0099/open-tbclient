package d.b.j0.l0.y.c;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import d.b.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d.b.i0.r.w.b.a> f58512a = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements d.b.i0.r.w.b.a {

        /* renamed from: a  reason: collision with root package name */
        public String f58513a;

        /* renamed from: b  reason: collision with root package name */
        public String f58514b;

        public a(c cVar, a2 a2Var, String str, String str2, String str3, String str4, int i) {
            this.f58513a = str;
            this.f58514b = str2;
        }

        @Override // d.b.i0.r.w.b.a
        public String a() {
            return this.f58513a;
        }

        @Override // d.b.i0.r.w.b.a
        public String b() {
            return this.f58514b;
        }
    }

    public c(List<EmotionCenterData.BannerData> list) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            EmotionCenterData.BannerData bannerData = list.get(i);
            if (bannerData != null) {
                this.f58512a.add(new a(this, null, bannerData.url, bannerData.action, null, null, 0));
            }
        }
    }

    public List<d.b.i0.r.w.b.a> a() {
        return this.f58512a;
    }
}
