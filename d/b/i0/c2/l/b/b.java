package d.b.i0.c2.l.b;

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
    public SpannableString f53098e;

    /* renamed from: f  reason: collision with root package name */
    public String f53099f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext<?> f53100g;

    /* renamed from: d.b.i0.c2.l.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1168b extends ClickableSpan {
        public C1168b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(b.this.f53100g, new String[]{b.this.f53099f});
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
        this.f53100g = tbPageContext;
        this.f53098e = new SpannableString(excContent.text);
        this.f53098e.setSpan(new C1168b(), 0, excContent.text.length(), 17);
        this.f53099f = excContent.link;
    }

    @Override // d.b.i0.c2.l.b.c
    public boolean a() {
        return false;
    }

    @Override // d.b.i0.c2.l.b.c
    public CharSequence b() {
        return this.f53098e;
    }

    @Override // d.b.i0.c2.l.b.d
    public int getType() {
        return 1;
    }
}
