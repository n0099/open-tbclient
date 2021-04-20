package d.b.i0.d2.l.b;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.imageManager.TbFaceManager;
import d.b.h0.a0.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: e  reason: collision with root package name */
    public ExcContent f54506e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableString f54507f;

    public a(ExcContent excContent) {
        this.f54506e = excContent;
    }

    @Override // d.b.i0.d2.l.b.c
    public boolean a() {
        return false;
    }

    @Override // d.b.i0.d2.l.b.c
    public CharSequence b() {
        return c(this.f54506e);
    }

    public final SpannableString c(ExcContent excContent) {
        String str;
        int b2;
        a.C1055a c2;
        if (this.f54507f == null && (b2 = TbFaceManager.e().b((str = excContent.text))) != 0) {
            String str2 = SmallTailInfo.EMOTION_PREFIX + TbFaceManager.e().f(str) + SmallTailInfo.EMOTION_SUFFIX;
            this.f54507f = new SpannableString(str2 + " ");
            d.b.h0.b1.m.d dVar = new d.b.h0.b1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
            if (TbFaceManager.e().c(str) != null) {
                int a2 = (int) (c2.a() * 0.6d);
                dVar.setBounds(new Rect(0, 0, a2, a2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.f54507f.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.f54507f;
    }

    @Override // d.b.i0.d2.l.b.d
    public int getType() {
        return 2;
    }
}
