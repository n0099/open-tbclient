package d.a.o0.e2.l.b;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableString f57476e;

    /* renamed from: f  reason: collision with root package name */
    public String f57477f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f57478g;

    /* renamed from: d.a.o0.e2.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1338b extends ClickableSpan {
        public C1338b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(b.this.f57478g, new String[]{b.this.f57477f});
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
        this.f57478g = tbPageContext;
        this.f57476e = new SpannableString(excContent.text);
        this.f57476e.setSpan(new C1338b(), 0, excContent.text.length(), 17);
        this.f57477f = excContent.link;
    }

    @Override // d.a.o0.e2.l.b.c
    public boolean a() {
        return false;
    }

    @Override // d.a.o0.e2.l.b.c
    public CharSequence b() {
        return this.f57476e;
    }

    @Override // d.a.o0.e2.l.b.d
    public int getType() {
        return 1;
    }
}
