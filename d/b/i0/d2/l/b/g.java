package d.b.i0.d2.l.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f54516e;

    /* renamed from: f  reason: collision with root package name */
    public int f54517f;

    /* renamed from: g  reason: collision with root package name */
    public String f54518g;

    /* renamed from: h  reason: collision with root package name */
    public int f54519h;

    public g() {
        this.f54517f = 0;
        this.f54519h = -1;
        this.f54516e = new SpannableStringBuilder();
    }

    @Override // d.b.i0.d2.l.b.c
    public boolean a() {
        int i = this.f54517f;
        return (i > 0 && i < 3) || !StringUtils.isNull(this.f54518g);
    }

    @Override // d.b.i0.d2.l.b.c
    public CharSequence b() {
        return this.f54516e;
    }

    public void c(CharSequence charSequence) {
        if (charSequence != null) {
            this.f54516e.append(charSequence);
        }
    }

    public int d() {
        return this.f54517f;
    }

    public String e() {
        return this.f54518g;
    }

    public int f() {
        return this.f54519h;
    }

    @Override // d.b.i0.d2.l.b.d
    public int getType() {
        return 0;
    }

    public g(Context context, ExcContent excContent) {
        this.f54517f = 0;
        this.f54519h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f54516e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f54517f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f54518g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f54519h = context.getResources().getDimensionPixelSize(identifier);
    }
}
