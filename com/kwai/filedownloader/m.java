package com.kwai.filedownloader;

import android.content.Context;
import com.kwai.filedownloader.services.e;
/* loaded from: classes3.dex */
public class m implements t {

    /* renamed from: a  reason: collision with root package name */
    private final t f7223a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final m f7224a = new m();
    }

    private m() {
        this.f7223a = com.kwai.filedownloader.f.e.a().d ? new n() : new o();
    }

    public static m a() {
        return a.f7224a;
    }

    public static e.a b() {
        if (a().f7223a instanceof n) {
            return (e.a) a().f7223a;
        }
        return null;
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        this.f7223a.a(context);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i) {
        return this.f7223a.a(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        return this.f7223a.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i) {
        return this.f7223a.b(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return this.f7223a.c();
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i) {
        return this.f7223a.c(i);
    }
}
