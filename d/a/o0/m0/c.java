package d.a.o0.m0;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.a.n0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public String f61034e;

    /* renamed from: f  reason: collision with root package name */
    public String f61035f;

    /* renamed from: g  reason: collision with root package name */
    public int f61036g;

    /* renamed from: h  reason: collision with root package name */
    public int f61037h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f61038i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f61034e = emotionGroupData.getGroupId();
        this.f61035f = emotionGroupData.getGroupName();
        this.f61036g = emotionGroupData.getWidth();
        this.f61037h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.a.n0.w.p.c
    public String b(int i2) {
        if (i2 >= this.f61038i.size()) {
            return null;
        }
        return this.f61038i.get(i2);
    }

    @Override // d.a.n0.w.p.c
    public int c() {
        return this.f61038i.size();
    }

    @Override // d.a.n0.w.p.c
    public String f() {
        return this.f61034e;
    }

    @Override // d.a.n0.w.p.c
    public String g() {
        return this.f61035f;
    }

    @Override // d.a.n0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.a.n0.w.p.c
    public int i() {
        return this.f61037h;
    }

    @Override // d.a.n0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.a.n0.w.p.c
    public int l() {
        return this.f61036g;
    }

    @Override // d.a.n0.w.p.c
    public boolean m(String str) {
        return this.f61038i.contains(str);
    }

    @Override // d.a.n0.w.p.c
    public d.a.c.k.d.a n(String str) {
        return null;
    }

    @Override // d.a.n0.w.p.c
    public d.a.c.k.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f61034e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.a.c.k.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f61034e, "panel.png");
        Bitmap f3 = b.f(this.f61034e, "panel_momo.png");
        if (f2 != null) {
            q(new d.a.c.k.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.a.c.k.d.a(f3, false));
        }
        this.f61038i.clear();
        for (EmotionData emotionData : g.k().m(this.f61034e)) {
            this.f61038i.add(emotionData.getSharpText());
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
