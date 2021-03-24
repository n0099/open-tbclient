package d.b.i0.l0;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.b.h0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public String f56498e;

    /* renamed from: f  reason: collision with root package name */
    public String f56499f;

    /* renamed from: g  reason: collision with root package name */
    public int f56500g;

    /* renamed from: h  reason: collision with root package name */
    public int f56501h;
    public ArrayList<String> i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f56498e = emotionGroupData.getGroupId();
        this.f56499f = emotionGroupData.getGroupName();
        this.f56500g = emotionGroupData.getWidth();
        this.f56501h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.b.h0.w.p.c
    public String b(int i) {
        if (i >= this.i.size()) {
            return null;
        }
        return this.i.get(i);
    }

    @Override // d.b.h0.w.p.c
    public int c() {
        return this.i.size();
    }

    @Override // d.b.h0.w.p.c
    public String f() {
        return this.f56498e;
    }

    @Override // d.b.h0.w.p.c
    public String g() {
        return this.f56499f;
    }

    @Override // d.b.h0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.b.h0.w.p.c
    public int i() {
        return this.f56501h;
    }

    @Override // d.b.h0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.b.h0.w.p.c
    public int l() {
        return this.f56500g;
    }

    @Override // d.b.h0.w.p.c
    public boolean m(String str) {
        return this.i.contains(str);
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a n(String str) {
        return null;
    }

    @Override // d.b.h0.w.p.c
    public d.b.b.j.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f56498e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.b.b.j.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f56498e, "panel.png");
        Bitmap f3 = b.f(this.f56498e, "panel_momo.png");
        if (f2 != null) {
            q(new d.b.b.j.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.b.b.j.d.a(f3, false));
        }
        this.i.clear();
        for (EmotionData emotionData : g.k().m(this.f56498e)) {
            this.i.add(emotionData.getSharpText());
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
