package d.b.g0.a.i2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f45113a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f45114b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f45115c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f45114b = (ClipboardManager) l0.f45113a.getSystemService("clipboard");
        }

        @Override // d.b.g0.a.i2.l0
        public CharSequence a() {
            try {
                f45115c = f45114b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.b.g0.a.k.f45443a) {
                    throw e2;
                }
            }
            ClipData clipData = f45115c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f45115c.getItemAt(0).getText();
        }

        @Override // d.b.g0.a.i2.l0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f45115c = newPlainText;
            try {
                f45114b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.b.g0.a.k.f45443a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f45116b;

        public b() {
            f45116b = (android.text.ClipboardManager) l0.f45113a.getSystemService("clipboard");
        }

        @Override // d.b.g0.a.i2.l0
        public CharSequence a() {
            return f45116b.getText();
        }

        @Override // d.b.g0.a.i2.l0
        public void c(CharSequence charSequence) {
            f45116b.setText(charSequence);
        }
    }

    public static l0 b(Context context) {
        f45113a = context.getApplicationContext();
        if (c.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
