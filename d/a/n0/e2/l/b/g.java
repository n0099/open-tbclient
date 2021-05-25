package d.a.n0.e2.l.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f53671e;

    /* renamed from: f  reason: collision with root package name */
    public int f53672f;

    /* renamed from: g  reason: collision with root package name */
    public String f53673g;

    /* renamed from: h  reason: collision with root package name */
    public int f53674h;

    public g() {
        this.f53672f = 0;
        this.f53674h = -1;
        this.f53671e = new SpannableStringBuilder();
    }

    @Override // d.a.n0.e2.l.b.c
    public boolean a() {
        int i2 = this.f53672f;
        return (i2 > 0 && i2 < 3) || !StringUtils.isNull(this.f53673g);
    }

    @Override // d.a.n0.e2.l.b.c
    public CharSequence b() {
        return this.f53671e;
    }

    public void c(CharSequence charSequence) {
        if (charSequence != null) {
            this.f53671e.append(charSequence);
        }
    }

    public int d() {
        return this.f53672f;
    }

    public String e() {
        return this.f53673g;
    }

    public int f() {
        return this.f53674h;
    }

    @Override // d.a.n0.e2.l.b.d
    public int getType() {
        return 0;
    }

    public g(Context context, ExcContent excContent) {
        this.f53672f = 0;
        this.f53674h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f53671e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f53672f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f53673g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f53674h = context.getResources().getDimensionPixelSize(identifier);
    }
}
