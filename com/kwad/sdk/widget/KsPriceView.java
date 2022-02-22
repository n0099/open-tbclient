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
import com.kwad.sdk.R;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class KsPriceView extends TextView implements b {

    /* renamed from: b  reason: collision with root package name */
    public static String f58257b = "¥%s 到手约 ¥%s";

    /* renamed from: c  reason: collision with root package name */
    public static String f58258c = "¥%s";
    public a a;

    /* renamed from: d  reason: collision with root package name */
    public String f58259d;

    /* renamed from: e  reason: collision with root package name */
    public String f58260e;

    /* loaded from: classes4.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58261b;

        /* renamed from: c  reason: collision with root package name */
        public int f58262c;

        /* renamed from: d  reason: collision with root package name */
        public int f58263d;

        public a() {
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.f58262c;
        }

        public int c() {
            return this.f58261b;
        }

        public int d() {
            return this.f58263d;
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

    public KsPriceView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new a();
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsPriceView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new a();
        a(context, attributeSet, i2);
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
        String format = str2 == null ? String.format(f58258c, str) : String.format(f58257b, str, str2);
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

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        setMaxLines(1);
        this.a.a = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.a.f58261b = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_price_size);
        this.a.f58262c = context.getResources().getColor(R.color.ksad_reward_original_price);
        this.a.f58263d = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_order_original_price_size);
    }

    @Override // com.kwad.sdk.widget.b
    public void a(c cVar) {
        this.a.a = cVar.a();
        a(this.f58259d, this.f58260e);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        this.f58259d = str;
        this.f58260e = str2;
        if (a(str2) <= 0.0f) {
            this.f58260e = null;
        }
        setTextColor(this.a.a());
        SpannableString a2 = a(str, this.f58260e, this.a);
        if (a2 != null) {
            setText(a2);
        }
    }
}
