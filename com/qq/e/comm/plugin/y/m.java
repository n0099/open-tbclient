package com.qq.e.comm.plugin.y;

import android.content.Context;
import java.util.List;
import java.util.Set;
import yaq.gdtadv;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
public class m extends a<k> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.y.a
    public void a(Set<Integer> set) {
        i.a(this.f12994a).b().a(set);
    }

    @Override // com.qq.e.comm.plugin.y.a
    void c(List<k> list) {
        gdtadv.getVresult(142, 0, this, list);
    }

    @Override // com.qq.e.comm.plugin.y.a
    public void d(List<k> list) {
        i.a(this.f12994a).b().a(list);
    }

    @Override // com.qq.e.comm.plugin.y.a
    boolean e() {
        return gdtadv.getZresult(143, 0, this);
    }

    @Override // com.qq.e.comm.plugin.y.a
    public List<k> f() {
        return i.a(this.f12994a).b().a();
    }
}
