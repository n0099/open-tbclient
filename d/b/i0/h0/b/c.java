package d.b.i0.h0.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes4.dex */
public class c extends d.b.h0.w.p.c {
    public c() {
        t();
    }

    @Override // d.b.h0.w.p.c
    public String b(int i) {
        int intValue = (i < 0 || i >= d.b.h0.w.p.b.f51539b.size()) ? 0 : d.b.h0.w.p.b.f51539b.get(i).intValue();
        for (Map.Entry<String, Integer> entry : d.b.h0.w.p.b.f51540c.entrySet()) {
            if (entry.getValue().intValue() == intValue) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // d.b.h0.w.p.c
    public int c() {
        return d.b.h0.w.p.b.f51539b.size();
    }

    @Override // d.b.h0.w.p.c
    public String f() {
        return "_local";
    }

    @Override // d.b.h0.w.p.c
    public String g() {
        return "_local";
    }

    @Override // d.b.h0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.LOCAL;
    }

    @Override // d.b.h0.w.p.c
    public int i() {
        return 0;
    }

    @Override // d.b.h0.w.p.c
    public boolean j() {
        return true;
    }

    @Override // d.b.h0.w.p.c
    public int l() {
        return 0;
    }

    @Override // d.b.h0.w.p.c
    public boolean m(String str) {
        return d.b.h0.w.p.b.f51540c.get(str) != null;
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a n(String str) {
        return o(str);
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a o(String str) {
        Bitmap e2;
        Integer num = d.b.h0.w.p.b.f51540c.get(str);
        if (num == null || (e2 = d.b.b.e.p.d.d().e(TbadkCoreApplication.getInst().getApp(), num.intValue())) == null) {
            return null;
        }
        return new d.b.b.j.d.a(e2, false, str);
    }

    public final void t() {
        super.p(7);
        super.s(3);
        d.b.b.j.d.a aVar = new d.b.b.j.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_face_original_s), false);
        super.r(aVar);
        super.q(aVar);
    }
}
