package d.b.g0.a.i2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f44721a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f44722b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f44723c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f44722b = (ClipboardManager) l0.f44721a.getSystemService("clipboard");
        }

        @Override // d.b.g0.a.i2.l0
        public CharSequence a() {
            try {
                f44723c = f44722b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.b.g0.a.k.f45051a) {
                    throw e2;
                }
            }
            ClipData clipData = f44723c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f44723c.getItemAt(0).getText();
        }

        @Override // d.b.g0.a.i2.l0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f44723c = newPlainText;
            try {
                f44722b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.b.g0.a.k.f45051a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f44724b;

        public b() {
            f44724b = (android.text.ClipboardManager) l0.f44721a.getSystemService("clipboard");
        }

        @Override // d.b.g0.a.i2.l0
        public CharSequence a() {
            return f44724b.getText();
        }

        @Override // d.b.g0.a.i2.l0
        public void c(CharSequence charSequence) {
            f44724b.setText(charSequence);
        }
    }

    public static l0 b(Context context) {
        f44721a = context.getApplicationContext();
        if (c.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
