package com.yanzhenjie.permission;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
/* loaded from: classes18.dex */
public class b {
    private static final c pMn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public interface c {
        h a(com.yanzhenjie.permission.b.b bVar);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            pMn = new C1060b();
        } else {
            pMn = new a();
        }
    }

    @NonNull
    public static h hq(@NonNull Context context) {
        return pMn.a(new com.yanzhenjie.permission.b.a(context));
    }

    /* loaded from: classes18.dex */
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
    /* loaded from: classes18.dex */
    private static class C1060b implements c {
        private C1060b() {
        }

        @Override // com.yanzhenjie.permission.b.c
        public h a(com.yanzhenjie.permission.b.b bVar) {
            return new d(bVar);
        }
    }
}
