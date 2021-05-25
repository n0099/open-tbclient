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
    public ArrayList<String> f62712a;

    /* renamed from: b  reason: collision with root package name */
    public String f62713b;

    /* renamed from: c  reason: collision with root package name */
    public int f62714c;

    /* renamed from: d  reason: collision with root package name */
    public int f62715d;

    /* renamed from: e  reason: collision with root package name */
    public int f62716e;

    /* renamed from: f  reason: collision with root package name */
    public int f62717f;

    /* renamed from: g  reason: collision with root package name */
    public int f62718g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62719h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62720i = false;

    public ArrayList<String> a() {
        return this.f62712a;
    }

    public int b() {
        return this.f62718g;
    }

    public String c() {
        return this.f62713b;
    }

    public boolean d() {
        return this.f62719h;
    }

    public boolean e() {
        return this.f62720i;
    }

    public SpannableStringBuilder f(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.f62712a)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.f62718g >= 0;
        this.f62718g = -1;
        Iterator<String> it = this.f62712a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                m(spannableStringBuilder, obj, next);
            }
        }
        if (this.f62718g >= 0 || z) {
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
        int i2 = this.f62714c;
        if (i2 != 0) {
            this.f62716e = SkinManager.getColor(i2);
        }
        int i3 = this.f62715d;
        if (i3 != 0) {
            this.f62717f = SkinManager.getColor(i3);
        }
    }

    public void h(int i2) {
        this.f62715d = i2;
        this.f62717f = SkinManager.getColor(i2);
    }

    public void i(ArrayList<String> arrayList) {
        this.f62712a = arrayList;
    }

    public void j(int i2) {
        this.f62714c = i2;
        this.f62716e = SkinManager.getColor(i2);
    }

    public void k(boolean z) {
        this.f62719h = z;
    }

    public void l(boolean z) {
        this.f62720i = z;
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f62716e == 0 && this.f62717f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i2 = this.f62718g;
            if (i2 == -1) {
                this.f62718g = indexOf + length;
            } else {
                int i3 = indexOf + length;
                if (i3 < i2) {
                    this.f62718g = i3;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.f62716e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f62716e), indexOf, indexOf + length, 33);
            }
            if (this.f62717f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f62717f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        this.f62713b = str;
    }
}
