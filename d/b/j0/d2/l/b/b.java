package d.b.j0.d2.l.b;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class b implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableString f54929e;

    /* renamed from: f  reason: collision with root package name */
    public String f54930f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f54931g;

    /* renamed from: d.b.j0.d2.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1249b extends ClickableSpan {
        public C1249b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(b.this.f54931g, new String[]{b.this.f54930f});
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    public b(TbPageContext<?> tbPageContext, ExcContent excContent) {
        if (excContent == null || excContent.type.longValue() != 1 || StringUtils.isNull(excContent.text)) {
            return;
        }
        this.f54931g = tbPageContext;
        this.f54929e = new SpannableString(excContent.text);
        this.f54929e.setSpan(new C1249b(), 0, excContent.text.length(), 17);
        this.f54930f = excContent.link;
    }

    @Override // d.b.j0.d2.l.b.c
    public boolean a() {
        return false;
    }

    @Override // d.b.j0.d2.l.b.c
    public CharSequence b() {
        return this.f54929e;
    }

    @Override // d.b.j0.d2.l.b.d
    public int getType() {
        return 1;
    }
}
