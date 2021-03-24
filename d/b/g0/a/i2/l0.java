package d.b.g0.a.i2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f44720a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f44721b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f44722c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f44721b = (ClipboardManager) l0.f44720a.getSystemService("clipboard");
        }

        @Override // d.b.g0.a.i2.l0
        public CharSequence a() {
            try {
                f44722c = f44721b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.b.g0.a.k.f45050a) {
                    throw e2;
                }
            }
            ClipData clipData = f44722c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f44722c.getItemAt(0).getText();
        }

        @Override // d.b.g0.a.i2.l0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f44722c = newPlainText;
            try {
                f44721b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.b.g0.a.k.f45050a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f44723b;

        public b() {
            f44723b = (android.text.ClipboardManager) l0.f44720a.getSystemService("clipboard");
        }

        @Override // d.b.g0.a.i2.l0
        public CharSequence a() {
            return f44723b.getText();
        }

        @Override // d.b.g0.a.i2.l0
        public void c(CharSequence charSequence) {
            f44723b.setText(charSequence);
        }
    }

    public static l0 b(Context context) {
        f44720a = context.getApplicationContext();
        if (c.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
