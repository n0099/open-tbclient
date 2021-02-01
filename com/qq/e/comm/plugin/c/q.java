package com.qq.e.comm.plugin.c;

import com.baidu.idl.authority.AuthorityState;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
class q implements k {

    /* renamed from: a  reason: collision with root package name */
    private String f11979a;

    q() {
    }

    private String b(f fVar) {
        return (String) gdtadv.getobjresult(271, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(AuthorityState.STATE_INIT_ING, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(273, 0, this, fVar, aVar);
    }
}
