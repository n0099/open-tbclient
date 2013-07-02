package com.google.android.gms.internal;

import android.os.IBinder;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.OnSignOutCompleteListener;
import com.google.android.gms.appstate.OnStateDeletedListener;
import com.google.android.gms.appstate.OnStateListLoadedListener;
import com.google.android.gms.appstate.OnStateLoadedListener;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.p;
/* loaded from: classes.dex */
public final class e extends p {
    private final String f;

    /* loaded from: classes.dex */
    final class a extends com.google.android.gms.internal.d {
        final /* synthetic */ e a;
        private final OnStateDeletedListener b;

        @Override // com.google.android.gms.internal.d, com.google.android.gms.internal.f
        public void a(int i, int i2) {
            this.a.a(new b(this.b, i, i2));
        }
    }

    /* loaded from: classes.dex */
    final class b extends p.b {
        private final int b;
        private final int c;

        public b(OnStateDeletedListener onStateDeletedListener, int i, int i2) {
            super(onStateDeletedListener);
            this.b = i;
            this.c = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnStateDeletedListener onStateDeletedListener) {
            onStateDeletedListener.a(this.b, this.c);
        }
    }

    /* loaded from: classes.dex */
    final class c extends com.google.android.gms.internal.d {
        final /* synthetic */ e a;
        private final OnStateListLoadedListener b;

        @Override // com.google.android.gms.internal.d, com.google.android.gms.internal.f
        public void a(k kVar) {
            this.a.a(new d(this.b, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class d extends p.c {
        public d(OnStateListLoadedListener onStateListLoadedListener, k kVar) {
            super(onStateListLoadedListener, kVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnStateListLoadedListener onStateListLoadedListener) {
            onStateListLoadedListener.a(this.d.b(), new AppStateBuffer(this.d));
        }
    }

    /* renamed from: com.google.android.gms.internal.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    final class BinderC0033e extends com.google.android.gms.internal.d {
        final /* synthetic */ e a;
        private final OnStateLoadedListener b;

        @Override // com.google.android.gms.internal.d, com.google.android.gms.internal.f
        public void a(int i, k kVar) {
            this.a.a(new f(this.b, i, kVar));
        }
    }

    /* loaded from: classes.dex */
    final class f extends p.c {
        private final int b;

        public f(OnStateLoadedListener onStateLoadedListener, int i, k kVar) {
            super(onStateLoadedListener, kVar);
            this.b = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnStateLoadedListener onStateLoadedListener) {
            byte[] bArr;
            String str;
            byte[] bArr2 = null;
            AppStateBuffer appStateBuffer = new AppStateBuffer(this.d);
            try {
                if (appStateBuffer.a() > 0) {
                    AppState b = appStateBuffer.b(0);
                    str = b.e();
                    bArr = b.c();
                    bArr2 = b.f();
                } else {
                    bArr = null;
                    str = null;
                }
                appStateBuffer.b();
                int b2 = this.d.b();
                if (b2 == 2000) {
                    onStateLoadedListener.a(this.b, str, bArr, bArr2);
                } else {
                    onStateLoadedListener.a(b2, this.b, bArr);
                }
            } catch (Throwable th) {
                appStateBuffer.b();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    final class g extends com.google.android.gms.internal.d {
        final /* synthetic */ e a;
        private final OnSignOutCompleteListener b;

        @Override // com.google.android.gms.internal.d, com.google.android.gms.internal.f
        public void a() {
            this.a.a(new h(this.b));
        }
    }

    /* loaded from: classes.dex */
    final class h extends p.b {
        public h(OnSignOutCompleteListener onSignOutCompleteListener) {
            super(onSignOutCompleteListener);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.internal.p.b
        public void a(OnSignOutCompleteListener onSignOutCompleteListener) {
            onSignOutCompleteListener.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p
    /* renamed from: a */
    public com.google.android.gms.internal.g b(IBinder iBinder) {
        return g.a.a(iBinder);
    }

    @Override // com.google.android.gms.internal.p
    protected void a(u uVar, p.d dVar) {
        uVar.a(dVar, 3136100, g().getPackageName(), this.f, h());
    }

    @Override // com.google.android.gms.internal.p
    protected String b() {
        return "com.google.android.gms.appstate.service.START";
    }

    @Override // com.google.android.gms.internal.p
    protected String c() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }
}
