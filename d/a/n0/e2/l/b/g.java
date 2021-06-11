package d.a.n0.e2.l.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class g implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f57360e;

    /* renamed from: f  reason: collision with root package name */
    public int f57361f;

    /* renamed from: g  reason: collision with root package name */
    public String f57362g;

    /* renamed from: h  reason: collision with root package name */
    public int f57363h;

    public g() {
        this.f57361f = 0;
        this.f57363h = -1;
        this.f57360e = new SpannableStringBuilder();
    }

    @Override // d.a.n0.e2.l.b.c
    public boolean a() {
        int i2 = this.f57361f;
        return (i2 > 0 && i2 < 3) || !StringUtils.isNull(this.f57362g);
    }

    @Override // d.a.n0.e2.l.b.c
    public CharSequence b() {
        return this.f57360e;
    }

    public void c(CharSequence charSequence) {
        if (charSequence != null) {
            this.f57360e.append(charSequence);
        }
    }

    public int d() {
        return this.f57361f;
    }

    public String e() {
        return this.f57362g;
    }

    public int f() {
        return this.f57363h;
    }

    @Override // d.a.n0.e2.l.b.d
    public int getType() {
        return 0;
    }

    public g(Context context, ExcContent excContent) {
        this.f57361f = 0;
        this.f57363h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f57360e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f57361f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f57362g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f57363h = context.getResources().getDimensionPixelSize(identifier);
    }
}
