package d.a.h0.a.i2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static Context f42760a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f42761b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f42762c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f42761b = (ClipboardManager) l0.f42760a.getSystemService("clipboard");
        }

        @Override // d.a.h0.a.i2.l0
        public CharSequence a() {
            try {
                f42762c = f42761b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.a.h0.a.k.f43101a) {
                    throw e2;
                }
            }
            ClipData clipData = f42762c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f42762c.getItemAt(0).getText();
        }

        @Override // d.a.h0.a.i2.l0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f42762c = newPlainText;
            try {
                f42761b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.a.h0.a.k.f43101a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends l0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f42763b;

        public b() {
            f42763b = (android.text.ClipboardManager) l0.f42760a.getSystemService("clipboard");
        }

        @Override // d.a.h0.a.i2.l0
        public CharSequence a() {
            return f42763b.getText();
        }

        @Override // d.a.h0.a.i2.l0
        public void c(CharSequence charSequence) {
            f42763b.setText(charSequence);
        }
    }

    public static l0 b(Context context) {
        f42760a = context.getApplicationContext();
        if (c.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
