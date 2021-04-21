package d.b.h0.a.i2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f45442a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f45443b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f45444c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f45443b = (ClipboardManager) l0.f45442a.getSystemService("clipboard");
        }

        @Override // d.b.h0.a.i2.l0
        public CharSequence a() {
            try {
                f45444c = f45443b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.b.h0.a.k.f45772a) {
                    throw e2;
                }
            }
            ClipData clipData = f45444c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f45444c.getItemAt(0).getText();
        }

        @Override // d.b.h0.a.i2.l0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f45444c = newPlainText;
            try {
                f45443b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.b.h0.a.k.f45772a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f45445b;

        public b() {
            f45445b = (android.text.ClipboardManager) l0.f45442a.getSystemService("clipboard");
        }

        @Override // d.b.h0.a.i2.l0
        public CharSequence a() {
            return f45445b.getText();
        }

        @Override // d.b.h0.a.i2.l0
        public void c(CharSequence charSequence) {
            f45445b.setText(charSequence);
        }
    }

    public static l0 b(Context context) {
        f45442a = context.getApplicationContext();
        if (c.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
