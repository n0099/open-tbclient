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
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.core.e.c;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class KsPriceView extends TextView implements d {
    public static String Ie = "¥%s 到手约 ¥%s";
    public static String If = "¥%s  ¥%s";
    public static String Ig = "¥%s";
    public a Id;
    public String Ih;
    public String Ii;
    public boolean Ij;

    /* loaded from: classes10.dex */
    public static class a {
        public int Ik;
        public int Il;
        public int Im;
        public int In;
        public int Io;
        public int Ip;

        public final int md() {
            return this.Im;
        }

        public final int me() {
            return this.Io;
        }

        public final int mf() {
            return this.In;
        }

        public final int mg() {
            return this.Ip;
        }

        public final int mh() {
            return this.Ik;
        }

        public final int mi() {
            return this.Il;
        }

        public final a ae(int i) {
            this.Il = i;
            return this;
        }

        public final a af(int i) {
            this.Io = i;
            return this;
        }

        public final a ag(int i) {
            this.Ip = i;
            return this;
        }
    }

    public KsPriceView(Context context) {
        super(context);
        this.Id = new a();
        P(context);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        this.Id.Im = eVar.tj();
        d(this.Ih, this.Ii, this.Ij);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Id = new a();
        P(context);
    }

    public final void h(String str, String str2) {
        d(str, str2, false);
    }

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Id = new a();
        P(context);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Id = new a();
        P(context);
    }

    private void P(Context context) {
        setMaxLines(1);
        this.Id.Im = context.getResources().getColor(R.color.obfuscated_res_0x7f0607a6);
        this.Id.In = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070538);
        this.Id.Io = context.getResources().getColor(R.color.obfuscated_res_0x7f0607a7);
        this.Id.Ip = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070537);
        this.Id.Ik = context.getResources().getColor(R.color.obfuscated_res_0x7f0607a6);
        this.Id.Il = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070538);
    }

    @Nullable
    public static SpannableString a(String str, @Nullable String str2, boolean z, a aVar) {
        String str3;
        String format;
        if (str2 == null) {
            format = String.format(Ig, str);
        } else {
            if (z) {
                str3 = If;
            } else {
                str3 = Ie;
            }
            format = String.format(str3, str, str2);
        }
        SpannableString spannableString = new SpannableString(format);
        if (format.startsWith("¥")) {
            spannableString.setSpan(new ForegroundColorSpan(aVar.mh()), 0, 1, 17);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mi()), 0, 1, 17);
        }
        int indexOf = format.indexOf(str);
        if (indexOf < 0) {
            return null;
        }
        int length = str.length() + indexOf;
        spannableString.setSpan(new ForegroundColorSpan(aVar.md()), indexOf, length, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(aVar.mf()), indexOf, length, 18);
        if (str2 != null) {
            int lastIndexOf = format.lastIndexOf(str2) - 1;
            int length2 = str2.length() + 1 + lastIndexOf;
            spannableString.setSpan(new ForegroundColorSpan(aVar.me()), lastIndexOf, length2, 18);
            spannableString.setSpan(new AbsoluteSizeSpan(aVar.mg()), lastIndexOf, length2, 18);
            spannableString.setSpan(new StrikethroughSpan(), lastIndexOf, length2, 18);
        }
        return spannableString;
    }

    public final void d(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.Ih = str;
        this.Ii = str2;
        this.Ij = z;
        SpannableString spannableString = null;
        if (TextUtils.isEmpty(str2)) {
            this.Ii = null;
        }
        if (str != null && str.startsWith("¥")) {
            str = str.replaceFirst("¥", "");
        }
        setTextColor(this.Id.md());
        try {
            spannableString = a(str, this.Ii, z, this.Id);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        if (spannableString != null) {
            setText(spannableString);
        }
    }

    @NonNull
    public a getConfig() {
        return this.Id;
    }
}
