package com.qq.e.comm.plugin.y;

import android.content.Context;
import java.util.List;
import java.util.Set;
import yaq.gdtadv;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class q extends a<o> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.y.a
    public void a(Set<Integer> set) {
        i.a(this.f12696a).c().a(set);
    }

    @Override // com.qq.e.comm.plugin.y.a
    void c(List<o> list) {
        gdtadv.getVresult(144, 0, this, list);
    }

    @Override // com.qq.e.comm.plugin.y.a
    public void d(List<o> list) {
        i.a(this.f12696a).c().a(list);
    }

    @Override // com.qq.e.comm.plugin.y.a
    boolean e() {
        return gdtadv.getZresult(145, 0, this);
    }

    @Override // com.qq.e.comm.plugin.y.a
    public List<o> f() {
        return i.a(this.f12696a).c().a();
    }
}
