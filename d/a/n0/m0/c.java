package d.a.n0.m0;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.a.m0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public String f60909e;

    /* renamed from: f  reason: collision with root package name */
    public String f60910f;

    /* renamed from: g  reason: collision with root package name */
    public int f60911g;

    /* renamed from: h  reason: collision with root package name */
    public int f60912h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f60913i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f60909e = emotionGroupData.getGroupId();
        this.f60910f = emotionGroupData.getGroupName();
        this.f60911g = emotionGroupData.getWidth();
        this.f60912h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.a.m0.w.p.c
    public String b(int i2) {
        if (i2 >= this.f60913i.size()) {
            return null;
        }
        return this.f60913i.get(i2);
    }

    @Override // d.a.m0.w.p.c
    public int c() {
        return this.f60913i.size();
    }

    @Override // d.a.m0.w.p.c
    public String f() {
        return this.f60909e;
    }

    @Override // d.a.m0.w.p.c
    public String g() {
        return this.f60910f;
    }

    @Override // d.a.m0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.a.m0.w.p.c
    public int i() {
        return this.f60912h;
    }

    @Override // d.a.m0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.a.m0.w.p.c
    public int l() {
        return this.f60911g;
    }

    @Override // d.a.m0.w.p.c
    public boolean m(String str) {
        return this.f60913i.contains(str);
    }

    @Override // d.a.m0.w.p.c
    public d.a.c.k.d.a n(String str) {
        return null;
    }

    @Override // d.a.m0.w.p.c
    public d.a.c.k.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f60909e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.a.c.k.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f60909e, "panel.png");
        Bitmap f3 = b.f(this.f60909e, "panel_momo.png");
        if (f2 != null) {
            q(new d.a.c.k.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.a.c.k.d.a(f3, false));
        }
        this.f60913i.clear();
        for (EmotionData emotionData : g.k().m(this.f60909e)) {
            this.f60913i.add(emotionData.getSharpText());
        }
    }

    public boolean u(String str) {
        if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String substring = replace.substring(0, replace.indexOf(","));
            if (substring.contains("_") && !substring.contains("collect_")) {
                return true;
            }
        }
        return false;
    }
}
