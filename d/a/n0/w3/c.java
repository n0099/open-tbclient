package d.a.n0.w3;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f66427a;

    /* renamed from: b  reason: collision with root package name */
    public String f66428b;

    /* renamed from: c  reason: collision with root package name */
    public int f66429c;

    /* renamed from: d  reason: collision with root package name */
    public int f66430d;

    /* renamed from: e  reason: collision with root package name */
    public int f66431e;

    /* renamed from: f  reason: collision with root package name */
    public int f66432f;

    /* renamed from: g  reason: collision with root package name */
    public int f66433g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66434h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66435i = false;

    public ArrayList<String> a() {
        return this.f66427a;
    }

    public int b() {
        return this.f66433g;
    }

    public String c() {
        return this.f66428b;
    }

    public boolean d() {
        return this.f66434h;
    }

    public boolean e() {
        return this.f66435i;
    }

    public SpannableStringBuilder f(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.f66427a)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.f66433g >= 0;
        this.f66433g = -1;
        Iterator<String> it = this.f66427a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                m(spannableStringBuilder, obj, next);
            }
        }
        if (this.f66433g >= 0 || z) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) editable.getSpans(0, obj.length(), ImageSpan.class);
            if (imageSpanArr != null) {
                for (ImageSpan imageSpan : imageSpanArr) {
                    if (imageSpan != null) {
                        spannableStringBuilder.setSpan(imageSpan, editable.getSpanStart(imageSpan), editable.getSpanEnd(imageSpan), editable.getSpanFlags(imageSpan));
                    }
                }
            }
            return spannableStringBuilder;
        }
        return null;
    }

    public void g() {
        int i2 = this.f66429c;
        if (i2 != 0) {
            this.f66431e = SkinManager.getColor(i2);
        }
        int i3 = this.f66430d;
        if (i3 != 0) {
            this.f66432f = SkinManager.getColor(i3);
        }
    }

    public void h(int i2) {
        this.f66430d = i2;
        this.f66432f = SkinManager.getColor(i2);
    }

    public void i(ArrayList<String> arrayList) {
        this.f66427a = arrayList;
    }

    public void j(int i2) {
        this.f66429c = i2;
        this.f66431e = SkinManager.getColor(i2);
    }

    public void k(boolean z) {
        this.f66434h = z;
    }

    public void l(boolean z) {
        this.f66435i = z;
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f66431e == 0 && this.f66432f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i2 = this.f66433g;
            if (i2 == -1) {
                this.f66433g = indexOf + length;
            } else {
                int i3 = indexOf + length;
                if (i3 < i2) {
                    this.f66433g = i3;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.f66431e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f66431e), indexOf, indexOf + length, 33);
            }
            if (this.f66432f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f66432f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        this.f66428b = str;
    }
}
