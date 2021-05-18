package d.a.i0.a.v2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class r0 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f45292a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f45293b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f45294c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f45293b = (ClipboardManager) r0.f45292a.getSystemService("clipboard");
        }

        @Override // d.a.i0.a.v2.r0
        public CharSequence a() {
            try {
                f45294c = f45293b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.a.i0.a.k.f43025a) {
                    throw e2;
                }
            }
            ClipData clipData = f45294c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f45294c.getItemAt(0).getText();
        }

        @Override // d.a.i0.a.v2.r0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f45294c = newPlainText;
            try {
                f45293b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.a.i0.a.k.f43025a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f45295b;

        public b() {
            f45295b = (android.text.ClipboardManager) r0.f45292a.getSystemService("clipboard");
        }

        @Override // d.a.i0.a.v2.r0
        public CharSequence a() {
            return f45295b.getText();
        }

        @Override // d.a.i0.a.v2.r0
        public void c(CharSequence charSequence) {
            f45295b.setText(charSequence);
        }
    }

    public static r0 b(Context context) {
        f45292a = context.getApplicationContext();
        if (d.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
