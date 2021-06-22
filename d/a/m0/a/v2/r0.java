package d.a.m0.a.v2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
/* loaded from: classes3.dex */
public abstract class r0 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f49250a;

    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class a extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static ClipboardManager f49251b;

        /* renamed from: c  reason: collision with root package name */
        public static ClipData f49252c;

        @SuppressLint({"ServiceCast"})
        public a() {
            f49251b = (ClipboardManager) r0.f49250a.getSystemService("clipboard");
        }

        @Override // d.a.m0.a.v2.r0
        public CharSequence a() {
            try {
                f49252c = f49251b.getPrimaryClip();
            } catch (Exception e2) {
                if (d.a.m0.a.k.f46983a) {
                    throw e2;
                }
            }
            ClipData clipData = f49252c;
            return (clipData == null || clipData.getItemCount() <= 0) ? "" : f49252c.getItemAt(0).getText();
        }

        @Override // d.a.m0.a.v2.r0
        public void c(CharSequence charSequence) {
            ClipData newPlainText = ClipData.newPlainText("text/plain", charSequence);
            f49252c = newPlainText;
            try {
                f49251b.setPrimaryClip(newPlainText);
            } catch (RuntimeException e2) {
                if (d.a.m0.a.k.f46983a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends r0 {

        /* renamed from: b  reason: collision with root package name */
        public static android.text.ClipboardManager f49253b;

        public b() {
            f49253b = (android.text.ClipboardManager) r0.f49250a.getSystemService("clipboard");
        }

        @Override // d.a.m0.a.v2.r0
        public CharSequence a() {
            return f49253b.getText();
        }

        @Override // d.a.m0.a.v2.r0
        public void c(CharSequence charSequence) {
            f49253b.setText(charSequence);
        }
    }

    public static r0 b(Context context) {
        f49250a = context.getApplicationContext();
        if (d.c()) {
            return new a();
        }
        return new b();
    }

    public abstract CharSequence a();

    public abstract void c(CharSequence charSequence);
}
