package d.a.n0.m0.y.c;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.m0.r.w.b.a> f57415a = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.r.w.b.a {

        /* renamed from: a  reason: collision with root package name */
        public String f57416a;

        /* renamed from: b  reason: collision with root package name */
        public String f57417b;

        public a(c cVar, a2 a2Var, String str, String str2, String str3, String str4, int i2) {
            this.f57416a = str;
            this.f57417b = str2;
        }

        @Override // d.a.m0.r.w.b.a
        public String a() {
            return this.f57416a;
        }

        @Override // d.a.m0.r.w.b.a
        public String b() {
            return this.f57417b;
        }
    }

    public c(List<EmotionCenterData.BannerData> list) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            EmotionCenterData.BannerData bannerData = list.get(i2);
            if (bannerData != null) {
                this.f57415a.add(new a(this, null, bannerData.url, bannerData.action, null, null, 0));
            }
        }
    }

    public List<d.a.m0.r.w.b.a> a() {
        return this.f57415a;
    }
}
