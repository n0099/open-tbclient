package d.a.j0.v3;

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
    public ArrayList<String> f61881a;

    /* renamed from: b  reason: collision with root package name */
    public String f61882b;

    /* renamed from: c  reason: collision with root package name */
    public int f61883c;

    /* renamed from: d  reason: collision with root package name */
    public int f61884d;

    /* renamed from: e  reason: collision with root package name */
    public int f61885e;

    /* renamed from: f  reason: collision with root package name */
    public int f61886f;

    /* renamed from: g  reason: collision with root package name */
    public int f61887g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61888h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61889i = false;

    public ArrayList<String> a() {
        return this.f61881a;
    }

    public int b() {
        return this.f61887g;
    }

    public String c() {
        return this.f61882b;
    }

    public boolean d() {
        return this.f61888h;
    }

    public boolean e() {
        return this.f61889i;
    }

    public SpannableStringBuilder f(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.f61881a)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.f61887g >= 0;
        this.f61887g = -1;
        Iterator<String> it = this.f61881a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                m(spannableStringBuilder, obj, next);
            }
        }
        if (this.f61887g >= 0 || z) {
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
        int i2 = this.f61883c;
        if (i2 != 0) {
            this.f61885e = SkinManager.getColor(i2);
        }
        int i3 = this.f61884d;
        if (i3 != 0) {
            this.f61886f = SkinManager.getColor(i3);
        }
    }

    public void h(int i2) {
        this.f61884d = i2;
        this.f61886f = SkinManager.getColor(i2);
    }

    public void i(ArrayList<String> arrayList) {
        this.f61881a = arrayList;
    }

    public void j(int i2) {
        this.f61883c = i2;
        this.f61885e = SkinManager.getColor(i2);
    }

    public void k(boolean z) {
        this.f61888h = z;
    }

    public void l(boolean z) {
        this.f61889i = z;
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f61885e == 0 && this.f61886f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i2 = this.f61887g;
            if (i2 == -1) {
                this.f61887g = indexOf + length;
            } else {
                int i3 = indexOf + length;
                if (i3 < i2) {
                    this.f61887g = i3;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.f61885e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f61885e), indexOf, indexOf + length, 33);
            }
            if (this.f61886f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f61886f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        this.f61882b = str;
    }
}
