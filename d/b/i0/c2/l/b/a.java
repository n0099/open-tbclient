package d.b.i0.c2.l.b;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.imageManager.TbFaceManager;
import d.b.h0.a0.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class a implements c {

    /* renamed from: e  reason: collision with root package name */
    public ExcContent f53096e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableString f53097f;

    public a(ExcContent excContent) {
        this.f53096e = excContent;
    }

    @Override // d.b.i0.c2.l.b.c
    public boolean a() {
        return false;
    }

    @Override // d.b.i0.c2.l.b.c
    public CharSequence b() {
        return c(this.f53096e);
    }

    public final SpannableString c(ExcContent excContent) {
        String str;
        int b2;
        if (this.f53097f == null && (b2 = TbFaceManager.e().b((str = excContent.text))) != 0) {
            String str2 = SmallTailInfo.EMOTION_PREFIX + TbFaceManager.e().f(str) + SmallTailInfo.EMOTION_SUFFIX;
            this.f53097f = new SpannableString(str2 + " ");
            d.b.h0.b1.m.d dVar = new d.b.h0.b1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
            a.C1042a c2 = TbFaceManager.e().c(str);
            if (c2 != null) {
                double a2 = c2.a();
                Double.isNaN(a2);
                int i = (int) (a2 * 0.6d);
                dVar.setBounds(new Rect(0, 0, i, i));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.f53097f.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.f53097f;
    }

    @Override // d.b.i0.c2.l.b.d
    public int getType() {
        return 2;
    }
}
