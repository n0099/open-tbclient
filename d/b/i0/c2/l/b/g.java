package d.b.i0.c2.l.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f53107e;

    /* renamed from: f  reason: collision with root package name */
    public int f53108f;

    /* renamed from: g  reason: collision with root package name */
    public String f53109g;

    /* renamed from: h  reason: collision with root package name */
    public int f53110h;

    public g() {
        this.f53108f = 0;
        this.f53110h = -1;
        this.f53107e = new SpannableStringBuilder();
    }

    @Override // d.b.i0.c2.l.b.c
    public boolean a() {
        int i = this.f53108f;
        return (i > 0 && i < 3) || !StringUtils.isNull(this.f53109g);
    }

    @Override // d.b.i0.c2.l.b.c
    public CharSequence b() {
        return this.f53107e;
    }

    public void c(CharSequence charSequence) {
        if (charSequence != null) {
            this.f53107e.append(charSequence);
        }
    }

    public int d() {
        return this.f53108f;
    }

    public String e() {
        return this.f53109g;
    }

    public int f() {
        return this.f53110h;
    }

    @Override // d.b.i0.c2.l.b.d
    public int getType() {
        return 0;
    }

    public g(Context context, ExcContent excContent) {
        this.f53108f = 0;
        this.f53110h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f53107e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f53108f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f53109g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f53110h = context.getResources().getDimensionPixelSize(identifier);
    }
}
