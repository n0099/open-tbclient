package d.a.j0.d2.l.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f52758e;

    /* renamed from: f  reason: collision with root package name */
    public int f52759f;

    /* renamed from: g  reason: collision with root package name */
    public String f52760g;

    /* renamed from: h  reason: collision with root package name */
    public int f52761h;

    public g() {
        this.f52759f = 0;
        this.f52761h = -1;
        this.f52758e = new SpannableStringBuilder();
    }

    @Override // d.a.j0.d2.l.b.c
    public boolean a() {
        int i2 = this.f52759f;
        return (i2 > 0 && i2 < 3) || !StringUtils.isNull(this.f52760g);
    }

    @Override // d.a.j0.d2.l.b.c
    public CharSequence b() {
        return this.f52758e;
    }

    public void c(CharSequence charSequence) {
        if (charSequence != null) {
            this.f52758e.append(charSequence);
        }
    }

    public int d() {
        return this.f52759f;
    }

    public String e() {
        return this.f52760g;
    }

    public int f() {
        return this.f52761h;
    }

    @Override // d.a.j0.d2.l.b.d
    public int getType() {
        return 0;
    }

    public g(Context context, ExcContent excContent) {
        this.f52759f = 0;
        this.f52761h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f52758e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f52759f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f52760g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f52761h = context.getResources().getDimensionPixelSize(identifier);
    }
}
