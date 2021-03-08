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
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f6461a = Pattern.compile("(\\[[^]]*])");
    private static int b = R.drawable.ksad_emotion_loading;

    /* renamed from: com.kwad.sdk.emotion.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1131a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f6462a;
        private final int b;
        private final int c;

        public C1131a(@NonNull TextView textView, int i, int i2) {
            this.f6462a = textView;
            this.b = i;
            this.c = i2;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public View a() {
            return this.f6462a;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public CharSequence b() {
            return this.f6462a.getText();
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int c() {
            return (int) this.f6462a.getTextSize();
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int d() {
            return this.b;
        }

        @Override // com.kwad.sdk.emotion.widget.a.b
        public int e() {
            return this.c;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        @NonNull
        View a();

        @NonNull
        CharSequence b();

        int c();

        int d();

        int e();
    }

    private static int a(int i) {
        Paint paint = new Paint();
        paint.setTextSize(i);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    public static synchronized CharSequence a(TextView textView, int i, int i2, boolean z) {
        CharSequence a2;
        synchronized (a.class) {
            a2 = a(new C1131a(textView, i, i2), z);
        }
        return a2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0018 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.text.SpannableStringBuilder, android.text.Editable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    public static synchronized CharSequence a(@NonNull b bVar, boolean z) {
        ?? r0;
        int a2;
        Bitmap a3;
        synchronized (a.class) {
            if (bVar != null) {
                if (bVar.a() != null) {
                    CharSequence b2 = bVar.b();
                    int d = bVar.d();
                    int e = bVar.e();
                    if (b2 != null && b2.length() > 0 && d >= 0 && e <= b2.length()) {
                        r0 = SpannableStringBuilder.valueOf(b2);
                        Matcher a4 = a(b2.subSequence(d, e + d));
                        int i = 0;
                        while (a4.find()) {
                            String group = a4.group();
                            if (com.kwad.sdk.emotion.a.c.a().c(group)) {
                                int i2 = i + 1;
                                if (i2 >= 300) {
                                    break;
                                }
                                int start = d + a4.start();
                                int end = d + a4.end();
                                com.kwad.sdk.emotion.widget.b bVar2 = new com.kwad.sdk.emotion.widget.b();
                                if (z) {
                                    a2 = bVar.c();
                                    a3 = com.kwad.sdk.emotion.a.c.a().b(group);
                                } else {
                                    a2 = a(bVar.c());
                                    a3 = com.kwad.sdk.emotion.a.c.a().a(bVar.a().getContext(), group, b);
                                }
                                bVar2.setBounds(0, 0, a2, a2);
                                bVar2.a(a3);
                                r0.setSpan(new c(bVar2, group, bVar.a()), start, end, 17);
                                i = i2;
                            }
                        }
                    } else {
                        r0 = b2;
                    }
                }
            }
            Log.w("EmojiDisplay", "filterEmoji on NULL!");
            r0 = "";
        }
        return r0;
    }

    public static Matcher a(CharSequence charSequence) {
        return f6461a.matcher(charSequence);
    }
}
