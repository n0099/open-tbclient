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
    public String f57220e;

    /* renamed from: f  reason: collision with root package name */
    public String f57221f;

    /* renamed from: g  reason: collision with root package name */
    public int f57222g;

    /* renamed from: h  reason: collision with root package name */
    public int f57223h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f57224i = new ArrayList<>();

    public c(EmotionGroupData emotionGroupData) {
        this.f57220e = emotionGroupData.getGroupId();
        this.f57221f = emotionGroupData.getGroupName();
        this.f57222g = emotionGroupData.getWidth();
        this.f57223h = emotionGroupData.getHeight();
        t();
    }

    @Override // d.a.m0.w.p.c
    public String b(int i2) {
        if (i2 >= this.f57224i.size()) {
            return null;
        }
        return this.f57224i.get(i2);
    }

    @Override // d.a.m0.w.p.c
    public int c() {
        return this.f57224i.size();
    }

    @Override // d.a.m0.w.p.c
    public String f() {
        return this.f57220e;
    }

    @Override // d.a.m0.w.p.c
    public String g() {
        return this.f57221f;
    }

    @Override // d.a.m0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // d.a.m0.w.p.c
    public int i() {
        return this.f57223h;
    }

    @Override // d.a.m0.w.p.c
    public boolean j() {
        return false;
    }

    @Override // d.a.m0.w.p.c
    public int l() {
        return this.f57222g;
    }

    @Override // d.a.m0.w.p.c
    public boolean m(String str) {
        return this.f57224i.contains(str);
    }

    @Override // d.a.m0.w.p.c
    public d.a.c.j.d.a n(String str) {
        return null;
    }

    @Override // d.a.m0.w.p.c
    public d.a.c.j.d.a o(String str) {
        String b2;
        if (u(str)) {
            b2 = b.c(str, true, false);
        } else {
            b2 = b.b(str, false);
        }
        Bitmap f2 = b.f(this.f57220e, b2);
        if (f2 == null) {
            return null;
        }
        return new d.a.c.j.d.a(f2, false, str);
    }

    public final void t() {
        s(2);
        p(4);
        Bitmap f2 = b.f(this.f57220e, "panel.png");
        Bitmap f3 = b.f(this.f57220e, "panel_momo.png");
        if (f2 != null) {
            q(new d.a.c.j.d.a(f2, false));
        }
        if (f3 != null) {
            r(new d.a.c.j.d.a(f3, false));
        }
        this.f57224i.clear();
        for (EmotionData emotionData : g.k().m(this.f57220e)) {
            this.f57224i.add(emotionData.getSharpText());
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
