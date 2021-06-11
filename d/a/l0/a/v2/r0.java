package d.a.l0.a.v2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class r0 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f49142a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f49143b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f49144c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f49143b = (ClipboardManager) r0.f49142a.getSystemService("clipboard");
        }

        @Override // d.a.l0.a.v2.r0
        public CharSequence a() {
            try {
                f49144c = f49143b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.a.l0.a.k.f46875a) {
                    throw e2;
                }
            }
            ClipData clipData = f49144c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f49144c.getItemAt(0).getText();
        }

        @Override // d.a.l0.a.v2.r0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f49144c = newPlainText;
            try {
                f49143b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.a.l0.a.k.f46875a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f49145b;

        public b() {
            f49145b = (android.text.ClipboardManager) r0.f49142a.getSystemService("clipboard");
        }

        @Override // d.a.l0.a.v2.r0
        public CharSequence a() {
            return f49145b.getText();
        }

        @Override // d.a.l0.a.v2.r0
        public void c(CharSequence charSequence) {
            f49145b.setText(charSequence);
        }
    }

    public static r0 b(Context context) {
        f49142a = context.getApplicationContext();
        if (d.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
