package com.kwai.filedownloader;

import android.content.Context;
import com.kwai.filedownloader.services.e;
/* loaded from: classes6.dex */
public class m implements t {

    /* renamed from: a  reason: collision with root package name */
    public final t f37428a;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final m f37429a = new m();
    }

    public m() {
        this.f37428a = com.kwai.filedownloader.f.e.a().f37400d ? new n() : new o();
    }

    public static m a() {
        return a.f37429a;
    }

    public static e.a b() {
        if (a().f37428a instanceof n) {
            return (e.a) a().f37428a;
        }
        return null;
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        this.f37428a.a(context);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i) {
        return this.f37428a.a(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        return this.f37428a.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i) {
        return this.f37428a.b(i);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return this.f37428a.c();
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i) {
        return this.f37428a.c(i);
    }
}
