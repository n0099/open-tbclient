package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.i.a.b;
/* loaded from: classes6.dex */
public class o {

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.i.a.d dVar);

        void b();
    }

    public static void a(Context context, String str, int i2, final a aVar, boolean z) {
        u.f("splashLoadAd", " getImageBytes url " + str);
        com.bytedance.sdk.openadsdk.i.e.c().g().a(str, new b.InterfaceC0309b() { // from class: com.bytedance.sdk.openadsdk.utils.o.1
            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
            public void a(b.c cVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
            public void a(String str2, com.bytedance.sdk.openadsdk.i.a.d dVar) {
                a aVar2;
                if (dVar.c() && (aVar2 = a.this) != null) {
                    aVar2.a(dVar);
                    return;
                }
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
            public void b(b.c cVar) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC0309b
            public void b() {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        }, i2, i2, z);
    }

    public static Drawable a(byte[] bArr, int i2) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}
