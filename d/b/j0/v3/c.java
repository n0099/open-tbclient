package d.b.j0.v3;

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
    public ArrayList<String> f63640a;

    /* renamed from: b  reason: collision with root package name */
    public String f63641b;

    /* renamed from: c  reason: collision with root package name */
    public int f63642c;

    /* renamed from: d  reason: collision with root package name */
    public int f63643d;

    /* renamed from: e  reason: collision with root package name */
    public int f63644e;

    /* renamed from: f  reason: collision with root package name */
    public int f63645f;

    /* renamed from: g  reason: collision with root package name */
    public int f63646g = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63647h = false;
    public boolean i = false;

    public ArrayList<String> a() {
        return this.f63640a;
    }

    public int b() {
        return this.f63646g;
    }

    public String c() {
        return this.f63641b;
    }

    public boolean d() {
        return this.f63647h;
    }

    public boolean e() {
        return this.i;
    }

    public SpannableStringBuilder f(Editable editable) {
        if (editable == null || StringUtils.isNull(editable.toString()) || ListUtils.isEmpty(this.f63640a)) {
            return null;
        }
        String obj = editable.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
        boolean z = this.f63646g >= 0;
        this.f63646g = -1;
        Iterator<String> it = this.f63640a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!StringUtils.isNull(next)) {
                m(spannableStringBuilder, obj, next);
            }
        }
        if (this.f63646g >= 0 || z) {
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
        int i = this.f63642c;
        if (i != 0) {
            this.f63644e = SkinManager.getColor(i);
        }
        int i2 = this.f63643d;
        if (i2 != 0) {
            this.f63645f = SkinManager.getColor(i2);
        }
    }

    public void h(int i) {
        this.f63643d = i;
        this.f63645f = SkinManager.getColor(i);
    }

    public void i(ArrayList<String> arrayList) {
        this.f63640a = arrayList;
    }

    public void j(int i) {
        this.f63642c = i;
        this.f63644e = SkinManager.getColor(i);
    }

    public void k(boolean z) {
        this.f63647h = z;
    }

    public void l(boolean z) {
        this.i = z;
    }

    public final void m(SpannableStringBuilder spannableStringBuilder, String str, String str2) {
        if (spannableStringBuilder == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f63644e == 0 && this.f63645f == 0) {
            return;
        }
        int indexOf = str.indexOf(str2);
        int length = str2.length();
        if (indexOf >= 0) {
            int i = this.f63646g;
            if (i == -1) {
                this.f63646g = indexOf + length;
            } else {
                int i2 = indexOf + length;
                if (i2 < i) {
                    this.f63646g = i2;
                }
            }
        }
        while (indexOf >= 0) {
            if (this.f63644e != 0) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f63644e), indexOf, indexOf + length, 33);
            }
            if (this.f63645f != 0) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f63645f), indexOf, indexOf + length, 33);
            }
            indexOf = str.indexOf(str2, indexOf + 1);
        }
    }

    public void n(String str) {
        this.f63641b = str;
    }
}
