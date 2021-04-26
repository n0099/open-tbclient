package d.a.j0.l0;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.a.i0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public String f56323e;

    /* renamed from: f  reason: collision with root package name */
    public String f56324f;

    /* renamed from: g  reason: collision with root package name */
    public int f56325g;

    /* renamed from: h  reason: collision with root package name */
    public int f56326h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f56327i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f56323e = emotionGroupData.getGroupId();
        this.f56324f = emotionGroupData.getGroupName();
        this.f56325g = emotionGroupData.getWidth();
        this.f56326h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.a.i0.w.p.c
    public String b(int i2) {
        if (i2 >= this.f56327i.size()) {
            return null;
        }
        return this.f56327i.get(i2);
    }

    @Override // d.a.i0.w.p.c
    public int c() {
        return this.f56327i.size();
    }

    @Override // d.a.i0.w.p.c
    public String f() {
        return this.f56323e;
    }

    @Override // d.a.i0.w.p.c
    public String g() {
        return this.f56324f;
    }

    @Override // d.a.i0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.a.i0.w.p.c
    public int i() {
        return this.f56326h;
    }

    @Override // d.a.i0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.a.i0.w.p.c
    public int l() {
        return this.f56325g;
    }

    @Override // d.a.i0.w.p.c
    public boolean m(String str) {
        return this.f56327i.contains(str);
    }

    @Override // d.a.i0.w.p.c
    public d.a.c.j.d.a n(String str) {
        return null;
    }

    @Override // d.a.i0.w.p.c
    public d.a.c.j.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f56323e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.a.c.j.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f56323e, "panel.png");
        Bitmap f3 = b.f(this.f56323e, "panel_momo.png");
        if (f2 != null) {
            q(new d.a.c.j.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.a.c.j.d.a(f3, false));
        }
        this.f56327i.clear();
        for (EmotionData emotionData : g.k().m(this.f56323e)) {
            this.f56327i.add(emotionData.getSharpText());
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
