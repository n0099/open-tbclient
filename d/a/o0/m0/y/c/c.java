package d.a.o0.m0.y.c;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.n0.r.w.b.a> f61229a = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.r.w.b.a {

        /* renamed from: a  reason: collision with root package name */
        public String f61230a;

        /* renamed from: b  reason: collision with root package name */
        public String f61231b;

        public a(c cVar, a2 a2Var, String str, String str2, String str3, String str4, int i2) {
            this.f61230a = str;
            this.f61231b = str2;
        }

        @Override // d.a.n0.r.w.b.a
        public String a() {
            return this.f61230a;
        }

        @Override // d.a.n0.r.w.b.a
        public String b() {
            return this.f61231b;
        }
    }

    public c(List<EmotionCenterData.BannerData> list) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            EmotionCenterData.BannerData bannerData = list.get(i2);
            if (bannerData != null) {
                this.f61229a.add(new a(this, null, bannerData.url, bannerData.action, null, null, 0));
            }
        }
    }

    public List<d.a.n0.r.w.b.a> a() {
        return this.f61229a;
    }
}
