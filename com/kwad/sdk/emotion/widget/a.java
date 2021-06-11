package com.kwad.sdk.emotion.widget;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f35353a = Pattern.compile("(\\[[^]]*])");

    /* renamed from: b  reason: collision with root package name */
    public static int f35354b = R.drawable.ksad_emotion_loading;

    /* renamed from: com.kwad.sdk.emotion.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0399a implements b {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f35355a;

        /* renamed from: b  reason: collision with root package name */
        public final int f35356b;

        /* renamed from: c  reason: collision with root package name */
        public final int f35357c;

        public C0399a(@NonNull TextView textView, int i2, int i3) {
            this.f35355a = textView;
            this.f35356b = i2;
            this.f35357c = i3;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public View a() {
            return this.f35355a;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public CharSequence b() {
            return this.f35355a.getText();
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int c() {
            return (int) this.f35355a.getTextSize();
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int d() {
            return this.f35356b;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int e() {
            return this.f35357c;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        @NonNull
        View a();

        @NonNull
        CharSequence b();

        int c();

        int d();

        int e();
    }

    public static int a(int i2) {
        Paint paint = new Paint();
        paint.setTextSize(i2);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    public static synchronized CharSequence a(TextView textView, int i2, int i3, boolean z) {
        CharSequence a2;
        synchronized (a.class) {
            a2 = a(new C0399a(textView, i2, i3), z);
        }
        return a2;
    }

    public static synchronized CharSequence a(@NonNull b bVar, boolean z) {
        int a2;
        Bitmap a3;
        synchronized (a.class) {
            if (bVar != null) {
                if (bVar.a() != null) {
                    CharSequence b2 = bVar.b();
                    int d2 = bVar.d();
                    int e2 = bVar.e();
                    if (b2 != null && b2.length() > 0 && d2 >= 0 && e2 <= b2.length()) {
                        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(b2);
                        Matcher a4 = a(b2.subSequence(d2, e2 + d2));
                        int i2 = 0;
                        while (a4.find()) {
                            String group = a4.group();
                            if (com.kwad.sdk.emotion.a.c.a().c(group)) {
                                i2++;
                                if (i2 >= 300) {
                                    break;
                                }
                                int start = a4.start() + d2;
                                int end = a4.end() + d2;
                                com.kwad.sdk.emotion.widget.b bVar2 = new com.kwad.sdk.emotion.widget.b();
                                if (z) {
                                    a2 = bVar.c();
                                    a3 = com.kwad.sdk.emotion.a.c.a().b(group);
                                } else {
                                    a2 = a(bVar.c());
                                    a3 = com.kwad.sdk.emotion.a.c.a().a(bVar.a().getContext(), group, f35354b);
                                }
                                bVar2.setBounds(0, 0, a2, a2);
                                bVar2.a(a3);
                                valueOf.setSpan(new c(bVar2, group, bVar.a()), start, end, 17);
                            }
                        }
                        return valueOf;
                    }
                    return b2;
                }
            }
            Log.w("EmojiDisplay", "filterEmoji on NULL!");
            return "";
        }
    }

    public static Matcher a(CharSequence charSequence) {
        return f35353a.matcher(charSequence);
    }
}
