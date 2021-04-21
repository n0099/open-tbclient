package d.b.j0.l0;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.EmotionData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends d.b.i0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public String f58326e;

    /* renamed from: f  reason: collision with root package name */
    public String f58327f;

    /* renamed from: g  reason: collision with root package name */
    public int f58328g;

    /* renamed from: h  reason: collision with root package name */
    public int f58329h;
    public ArrayList<String> i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f58326e = emotionGroupData.getGroupId();
        this.f58327f = emotionGroupData.getGroupName();
        this.f58328g = emotionGroupData.getWidth();
        this.f58329h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.b.i0.w.p.c
    public String b(int i) {
        if (i >= this.i.size()) {
            return null;
        }
        return this.i.get(i);
    }

    @Override // d.b.i0.w.p.c
    public int c() {
        return this.i.size();
    }

    @Override // d.b.i0.w.p.c
    public String f() {
        return this.f58326e;
    }

    @Override // d.b.i0.w.p.c
    public String g() {
        return this.f58327f;
    }

    @Override // d.b.i0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.b.i0.w.p.c
    public int i() {
        return this.f58329h;
    }

    @Override // d.b.i0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.b.i0.w.p.c
    public int l() {
        return this.f58328g;
    }

    @Override // d.b.i0.w.p.c
    public boolean m(String str) {
        return this.i.contains(str);
    }

    @Override // d.b.i0.w.p.c
    public d.b.c.j.d.a n(String str) {
        return null;
    }

    @Override // d.b.i0.w.p.c
    public d.b.c.j.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f58326e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.b.c.j.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f58326e, "panel.png");
        Bitmap f3 = b.f(this.f58326e, "panel_momo.png");
        if (f2 != null) {
            q(new d.b.c.j.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.b.c.j.d.a(f3, false));
        }
        this.i.clear();
        for (EmotionData emotionData : g.k().m(this.f58326e)) {
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
