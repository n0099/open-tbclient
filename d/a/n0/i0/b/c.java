package d.a.n0.i0.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes4.dex */
public class c extends d.a.m0.w.p.c {
    public c() {
        t();
    }

    @Override // d.a.m0.w.p.c
    public String b(int i2) {
        int intValue = (i2 < 0 || i2 >= d.a.m0.w.p.b.f50857b.size()) ? 0 : d.a.m0.w.p.b.f50857b.get(i2).intValue();
        for (Map.Entry<String, Integer> entry : d.a.m0.w.p.b.f50858c.entrySet()) {
            if (entry.getValue().intValue() == intValue) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // d.a.m0.w.p.c
    public int c() {
        return d.a.m0.w.p.b.f50857b.size();
    }

    @Override // d.a.m0.w.p.c
    public String f() {
        return "_local";
    }

    @Override // d.a.m0.w.p.c
    public String g() {
        return "_local";
    }

    @Override // d.a.m0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.LOCAL;
    }

    @Override // d.a.m0.w.p.c
    public int i() {
        return 0;
    }

    @Override // d.a.m0.w.p.c
    public boolean j() {
        return true;
    }

    @Override // d.a.m0.w.p.c
    public int l() {
        return 0;
    }

    @Override // d.a.m0.w.p.c
    public boolean m(String str) {
        return d.a.m0.w.p.b.f50858c.get(str) != null;
    }

    @Override // d.a.m0.w.p.c
    public d.a.c.j.d.a n(String str) {
        return o(str);
    }

    @Override // d.a.m0.w.p.c
    public d.a.c.j.d.a o(String str) {
        Bitmap e2;
        Integer num = d.a.m0.w.p.b.f50858c.get(str);
        if (num == null || (e2 = d.a.c.e.p.d.d().e(TbadkCoreApplication.getInst().getApp(), num.intValue())) == null) {
            return null;
        }
        return new d.a.c.j.d.a(e2, false, str);
    }

    public final void t() {
        super.p(7);
        super.s(3);
        d.a.c.j.d.a aVar = new d.a.c.j.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_face_original_s), false);
        super.r(aVar);
        super.q(aVar);
    }
}
