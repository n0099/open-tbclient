package com.kwad.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class KsPriceView extends TextView implements b {
    public static String b = "¥%s 到手约 ¥%s";
    public static String c = "¥%s";
    public a a;
    public String d;
    public String e;

    /* loaded from: classes5.dex */
    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;

        public a() {
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }

        public int d() {
            return this.d;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.a = new a();
        a(context, (AttributeSet) null, 0);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new a();
        a(context, attributeSet, 0);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new a();
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new a();
        a(context, attributeSet, i);
    }

    public static float a(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    @Nullable
    public static SpannableString a(String str, @Nullable String str2, a aVar) {
        String format = str2 == null ? String.format(c, str) : String.format(b, str, str2);
        SpannableString spannableString = new SpannableString(format);
        int indexOf = format.indexOf(str) - 1;
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + 1 + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.a()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.c()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.b()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.d()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        setMaxLines(1);
        this.a.a = context.getResources().getColor(R.color.obfuscated_res_0x7f060760);
        this.a.b = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039f);
        this.a.c = context.getResources().getColor(R.color.obfuscated_res_0x7f060762);
        this.a.d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039e);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        this.a.a = cVar.a();
        a(this.d, this.e);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.d = str;
        this.e = str2;
        if (a(str2) <= 0.0f) {
            this.e = null;
        }
        setTextColor(this.a.a());
        SpannableString a2 = a(str, this.e, this.a);
        if (a2 != null) {
            setText(a2);
        }
    }
}
