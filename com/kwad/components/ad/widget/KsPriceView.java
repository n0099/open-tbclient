package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.components.core.widget.e;
import com.kwad.components.core.widget.f;
import com.kwad.sdk.core.e.b;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class KsPriceView extends TextView implements e {
    public static String Cw = "¥%s 到手约 ¥%s";
    public static String Cx = "¥%s  ¥%s";
    public static String Cy = "¥%s";
    public String CA;
    public boolean CB;
    public a Cv;
    public String Cz;

    /* loaded from: classes10.dex */
    public static class a {
        public int CC;
        public int CD;
        public int CE;
        public int CF;
        public int CG;
        public int CH;

        public final a ab(int i) {
            this.CD = i;
            return this;
        }

        public final a ac(int i) {
            this.CG = i;
            return this;
        }

        public final a ad(int i) {
            this.CH = i;
            return this;
        }

        public final int kX() {
            return this.CE;
        }

        public final int kY() {
            return this.CG;
        }

        public final int kZ() {
            return this.CF;
        }

        public final int la() {
            return this.CH;
        }

        public final int lb() {
            return this.CC;
        }

        public final int lc() {
            return this.CD;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Cv = new a();
        L(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Cv = new a();
        L(context);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Cv = new a();
        L(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Cv = new a();
        L(context);
    }

    private void L(Context context) {
        setMaxLines(1);
        this.Cv.CE = context.getResources().getColor(R.color.obfuscated_res_0x7f0607a4);
        this.Cv.CF = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070538);
        this.Cv.CG = context.getResources().getColor(R.color.obfuscated_res_0x7f0607a5);
        this.Cv.CH = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070537);
        this.Cv.CC = context.getResources().getColor(R.color.obfuscated_res_0x7f0607a4);
        this.Cv.CD = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070538);
    }

    @Nullable
    public static SpannableString a(String str, @Nullable String str2, boolean z, a aVar) {
        String format;
        if (str2 == null) {
            format = String.format(Cy, str);
        } else {
            format = String.format(z ? Cx : Cw, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.lb()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.lc()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.kX()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.kZ()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.kY()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.la()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    @Override // com.kwad.components.core.widget.e
    public final void a(f fVar) {
        this.Cv.CE = fVar.qh();
        d(this.Cz, this.CA, this.CB);
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Cz = str;
        this.CA = str2;
        this.CB = z;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.CA = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Cv.kX());
        try {
            spannableString = a(str, this.CA, z, this.Cv);
        } catch (Exception e) {
            b.printStackTraceOnly(e);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    public final void f(String str, String str2) {
        d(str, str2, false);
    }

    @NonNull
    public a getConfig() {
        return this.Cv;
    }
}
