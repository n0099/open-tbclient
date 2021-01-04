package com.qq.e.comm.plugin.u;

import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import java.io.File;
/* loaded from: classes3.dex */
class a implements com.qq.e.comm.plugin.j.a {

    /* renamed from: a  reason: collision with root package name */
    private c f12841a = new c();

    /* renamed from: b  reason: collision with root package name */
    private d f12842b = new d();

    public a(com.qq.e.comm.plugin.aa.a.b bVar, String str) {
        this.f12841a.a(str);
        if (bVar != null) {
            this.f12842b.a(DownloadDataConstants.Columns.COLUMN_URI, bVar.c());
            this.f12842b.a(MapBundleKey.MapObjKey.OBJ_DIR, bVar.a() == null ? null : bVar.a().getAbsolutePath());
        }
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(long j, long j2, int i) {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(long j, boolean z) {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(com.qq.e.comm.plugin.j.c cVar) {
        u.a(100152, 0, this.f12841a, this.f12842b);
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void a(File file, long j) {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void b() {
    }

    @Override // com.qq.e.comm.plugin.j.a
    public void c() {
        u.a(100142, 0, this.f12841a, this.f12842b);
    }
}
