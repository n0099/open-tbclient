package d.b.j0.d2.l.b;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class g implements c {

    /* renamed from: e  reason: collision with root package name */
    public SpannableStringBuilder f54937e;

    /* renamed from: f  reason: collision with root package name */
    public int f54938f;

    /* renamed from: g  reason: collision with root package name */
    public String f54939g;

    /* renamed from: h  reason: collision with root package name */
    public int f54940h;

    public g() {
        this.f54938f = 0;
        this.f54940h = -1;
        this.f54937e = new SpannableStringBuilder();
    }

    @Override // d.b.j0.d2.l.b.c
    public boolean a() {
        int i = this.f54938f;
        return (i > 0 && i < 3) || !StringUtils.isNull(this.f54939g);
    }

    @Override // d.b.j0.d2.l.b.c
    public CharSequence b() {
        return this.f54937e;
    }

    public void c(CharSequence charSequence) {
        if (charSequence != null) {
            this.f54937e.append(charSequence);
        }
    }

    public int d() {
        return this.f54938f;
    }

    public String e() {
        return this.f54939g;
    }

    public int f() {
        return this.f54940h;
    }

    @Override // d.b.j0.d2.l.b.d
    public int getType() {
        return 0;
    }

    public g(Context context, ExcContent excContent) {
        this.f54938f = 0;
        this.f54940h = -1;
        if (excContent == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.f54937e = spannableStringBuilder;
        if (excContent != null) {
            spannableStringBuilder.append((CharSequence) excContent.text);
        }
        Integer num = excContent.align;
        if (num != null) {
            this.f54938f = num.intValue();
        }
        if (!StringUtils.isNull(excContent.color)) {
            this.f54939g = excContent.color;
        }
        Integer num2 = excContent.size;
        if (num2 == null || num2.intValue() <= 0 || context == null || context.getResources() == null) {
            return;
        }
        int identifier = context.getResources().getIdentifier("fontsize" + excContent.size, "dimen", context.getPackageName());
        if (identifier <= 0) {
            return;
        }
        this.f54940h = context.getResources().getDimensionPixelSize(identifier);
    }
}
