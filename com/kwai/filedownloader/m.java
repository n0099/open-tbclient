package com.kwai.filedownloader;

import android.content.Context;
import com.kwai.filedownloader.services.e;
/* loaded from: classes7.dex */
public class m implements t {

    /* renamed from: a  reason: collision with root package name */
    public final t f37808a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final m f37809a = new m();
    }

    public m() {
        this.f37808a = com.kwai.filedownloader.f.e.a().f37780d ? new n() : new o();
    }

    public static m a() {
        return a.f37809a;
    }

    public static e.a b() {
        if (a().f37808a instanceof n) {
            return (e.a) a().f37808a;
        }
        return null;
    }

    @Override // com.kwai.filedownloader.t
    public void a(Context context) {
        this.f37808a.a(context);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(int i2) {
        return this.f37808a.a(i2);
    }

    @Override // com.kwai.filedownloader.t
    public boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.d.b bVar, boolean z3) {
        return this.f37808a.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.t
    public byte b(int i2) {
        return this.f37808a.b(i2);
    }

    @Override // com.kwai.filedownloader.t
    public boolean c() {
        return this.f37808a.c();
    }

    @Override // com.kwai.filedownloader.t
    public boolean c(int i2) {
        return this.f37808a.c(i2);
    }
}
