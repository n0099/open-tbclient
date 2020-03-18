package com.yanzhenjie.permission;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
/* loaded from: classes6.dex */
public class b {
    private static final c nue;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public interface c {
        h a(com.yanzhenjie.permission.b.b bVar);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            nue = new C0757b();
        } else {
            nue = new a();
        }
    }

    @NonNull
    public static h gD(@NonNull Context context) {
        return nue.a(new com.yanzhenjie.permission.b.a(context));
    }

    /* loaded from: classes6.dex */
    private static class a implements c {
        private a() {
        }

        @Override // com.yanzhenjie.permission.b.c
        public h a(com.yanzhenjie.permission.b.b bVar) {
            return new com.yanzhenjie.permission.c(bVar);
        }
    }

    @RequiresApi(api = 23)
    /* renamed from: com.yanzhenjie.permission.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static class C0757b implements c {
        private C0757b() {
        }

        @Override // com.yanzhenjie.permission.b.c
        public h a(com.yanzhenjie.permission.b.b bVar) {
            return new d(bVar);
        }
    }
}
