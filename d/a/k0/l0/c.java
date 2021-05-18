package d.a.k0.l0;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.a.j0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public String f57030e;

    /* renamed from: f  reason: collision with root package name */
    public String f57031f;

    /* renamed from: g  reason: collision with root package name */
    public int f57032g;

    /* renamed from: h  reason: collision with root package name */
    public int f57033h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f57034i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f57030e = emotionGroupData.getGroupId();
        this.f57031f = emotionGroupData.getGroupName();
        this.f57032g = emotionGroupData.getWidth();
        this.f57033h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.a.j0.w.p.c
    public String b(int i2) {
        if (i2 >= this.f57034i.size()) {
            return null;
        }
        return this.f57034i.get(i2);
    }

    @Override // d.a.j0.w.p.c
    public int c() {
        return this.f57034i.size();
    }

    @Override // d.a.j0.w.p.c
    public String f() {
        return this.f57030e;
    }

    @Override // d.a.j0.w.p.c
    public String g() {
        return this.f57031f;
    }

    @Override // d.a.j0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.a.j0.w.p.c
    public int i() {
        return this.f57033h;
    }

    @Override // d.a.j0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.a.j0.w.p.c
    public int l() {
        return this.f57032g;
    }

    @Override // d.a.j0.w.p.c
    public boolean m(String str) {
        return this.f57034i.contains(str);
    }

    @Override // d.a.j0.w.p.c
    public d.a.c.j.d.a n(String str) {
        return null;
    }

    @Override // d.a.j0.w.p.c
    public d.a.c.j.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f57030e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.a.c.j.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f57030e, "panel.png");
        Bitmap f3 = b.f(this.f57030e, "panel_momo.png");
        if (f2 != null) {
            q(new d.a.c.j.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.a.c.j.d.a(f3, false));
        }
        this.f57034i.clear();
        for (EmotionData emotionData : g.k().m(this.f57030e)) {
            this.f57034i.add(emotionData.getSharpText());
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
