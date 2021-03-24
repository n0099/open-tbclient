package d.b.i0.u3;

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
    public ArrayList<String> f61480a;

    /* renamed from: b  reason: collision with root package name */
    public String f61481b;

    /* renamed from: c  reason: collision with root package name */
    public int f61482c;

    /* renamed from: d  reason: collision with root package name */
    public int f61483d;

    /* renamed from: e  reason: collision with root package name */
    public int f61484e;

    /* renamed from: f  reason: collision with root package name */
    public int f61485f;

    /* renamed from: g  reason: collision with root package name */
    public int f61486g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61487h = false;
    public boolean i = false;

    public ArrayList<String> a() {
        return this.f61480a;
    }

    public int b() {
        return this.f61486g;
    }

    public String c() {
        return this.f61481b;
    }

    public boolean d() {
        return this.f61487h;
    }

    public boolean e() {
        return this.i;
    }

    public SpannableStringBuilder f(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.f61480a)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.f61486g >= 0;
        this.f61486g = -1;
        Iterator<String> it = this.f61480a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                m(spannableStringBuilder, obj, next);
            }
        }
        if (this.f61486g >= 0 || z) {
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
        int i = this.f61482c;
        if (i != 0) {
            this.f61484e = SkinManager.getColor(i);
        }
        int i2 = this.f61483d;
        if (i2 != 0) {
            this.f61485f = SkinManager.getColor(i2);
        }
    }

    public void h(int i) {
        this.f61483d = i;
        this.f61485f = SkinManager.getColor(i);
    }

    public void i(ArrayList<String> arrayList) {
        this.f61480a = arrayList;
    }

    public void j(int i) {
        this.f61482c = i;
        this.f61484e = SkinManager.getColor(i);
    }

    public void k(boolean z) {
        this.f61487h = z;
    }

    public void l(boolean z) {
        this.i = z;
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f61484e == 0 && this.f61485f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i = this.f61486g;
            if (i == -1) {
                this.f61486g = indexOf + length;
            } else {
                int i2 = indexOf + length;
                if (i2 < i) {
                    this.f61486g = i2;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.f61484e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f61484e), indexOf, indexOf + length, 33);
            }
            if (this.f61485f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f61485f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        this.f61481b = str;
    }
}
