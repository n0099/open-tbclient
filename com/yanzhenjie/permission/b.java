package com.yanzhenjie.permission;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
/* loaded from: classes5.dex */
public class b {
    private static final c nrC;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface c {
        h a(com.yanzhenjie.permission.b.b bVar);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            nrC = new C0748b();
        } else {
            nrC = new a();
        }
    }

    @NonNull
    public static h gF(@NonNull Context context) {
        return nrC.a(new com.yanzhenjie.permission.b.a(context));
    }

    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    private static class C0748b implements c {
        private C0748b() {
        }

        @Override // com.yanzhenjie.permission.b.c
        public h a(com.yanzhenjie.permission.b.b bVar) {
            return new d(bVar);
        }
    }
}
