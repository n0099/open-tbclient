package d.a.n0.e2.l.b;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.imageManager.TbFaceManager;
import d.a.m0.a0.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class a implements c {

    /* renamed from: e  reason: collision with root package name */
    public ExcContent f57349e;

    /* renamed from: f  reason: collision with root package name */
    public SpannableString f57350f;

    public a(ExcContent excContent) {
        this.f57349e = excContent;
    }

    @Override // d.a.n0.e2.l.b.c
    public boolean a() {
        return false;
    }

    @Override // d.a.n0.e2.l.b.c
    public CharSequence b() {
        return c(this.f57349e);
    }

    public final SpannableString c(ExcContent excContent) {
        String str;
        int b2;
        a.C1155a c2;
        if (this.f57350f == null && (b2 = TbFaceManager.e().b((str = excContent.text))) != 0) {
            String str2 = SmallTailInfo.EMOTION_PREFIX + TbFaceManager.e().f(str) + SmallTailInfo.EMOTION_SUFFIX;
            this.f57350f = new SpannableString(str2 + " ");
            d.a.m0.b1.m.d dVar = new d.a.m0.b1.m.d(TbadkCoreApplication.getInst().getContext(), b2);
            if (TbFaceManager.e().c(str) != null) {
                int a2 = (int) (c2.a() * 0.6d);
                dVar.setBounds(new Rect(0, 0, a2, a2));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.f57350f.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.f57350f;
    }

    @Override // d.a.n0.e2.l.b.d
    public int getType() {
        return 2;
    }
}
