package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.i.a.b;
/* loaded from: classes4.dex */
public class o {

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void a(@NonNull byte[] bArr);
    }

    public static void a(Context context, String str, int i, final a aVar, boolean z) {
        u.f("splashLoadAd", " getImageBytes url " + str);
        com.bytedance.sdk.openadsdk.i.e.a(context).f().a(str, new b.InterfaceC1033b() { // from class: com.bytedance.sdk.openadsdk.utils.o.1
            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1033b
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1033b
            public void a(String str2, byte[] bArr) {
                if (bArr != null && bArr.length > 0 && a.this != null) {
                    u.b("ImageBytesHelper: ", "图片数据返回成功" + bArr.length);
                    a.this.a(bArr);
                } else if (a.this != null) {
                    a.this.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1033b
            public void a(b.c cVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.i.a.b.InterfaceC1033b
            public void b(b.c cVar) {
                if (a.this != null) {
                    a.this.a();
                }
            }
        }, i, i, z);
    }

    public static Drawable a(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable th) {
            return new ColorDrawable(0);
        }
    }
}
