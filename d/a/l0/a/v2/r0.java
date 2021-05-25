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
    public static Context f45468a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f45469b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f45470c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f45469b = (ClipboardManager) r0.f45468a.getSystemService("clipboard");
        }

        @Override // d.a.l0.a.v2.r0
        public CharSequence a() {
            try {
                f45470c = f45469b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.a.l0.a.k.f43199a) {
                    throw e2;
                }
            }
            ClipData clipData = f45470c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f45470c.getItemAt(0).getText();
        }

        @Override // d.a.l0.a.v2.r0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f45470c = newPlainText;
            try {
                f45469b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.a.l0.a.k.f43199a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f45471b;

        public b() {
            f45471b = (android.text.ClipboardManager) r0.f45468a.getSystemService("clipboard");
        }

        @Override // d.a.l0.a.v2.r0
        public CharSequence a() {
            return f45471b.getText();
        }

        @Override // d.a.l0.a.v2.r0
        public void c(CharSequence charSequence) {
            f45471b.setText(charSequence);
        }
    }

    public static r0 b(Context context) {
        f45468a = context.getApplicationContext();
        if (d.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
