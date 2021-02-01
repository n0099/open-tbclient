package com.qq.e.comm.plugin.nativeadunified;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.UIMsg;
import com.qq.e.comm.plugin.c.f;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes15.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private g f12280a;

    /* renamed from: b  reason: collision with root package name */
    private h f12281b;
    private com.qq.e.comm.plugin.y.c c;
    private com.qq.e.comm.plugin.c.a.a d;

    public e(g gVar, h hVar, com.qq.e.comm.plugin.c.a.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        this.f12281b = hVar;
        this.f12280a = gVar;
        this.d = aVar;
        this.c = cVar;
    }

    private void a(View view) {
        com.qq.e.comm.plugin.s.c l = this.f12281b.l();
        if (l == null) {
            return;
        }
        String c = l.c();
        if (TextUtils.isEmpty(c)) {
            return;
        }
        new com.qq.e.comm.plugin.ac.e(view.getContext()).a(c);
    }

    private void a(View view, int i, int i2) {
        a(view, i, i2, false);
    }

    private void a(View view, int i, int i2, boolean z) {
        this.f12280a.a(view, i, this.f12280a.getTitle(), this.f12280a.p(), this.f12280a.o(), this.f12280a.m(), this.f12280a.isAppAd(), i2, false, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GDTLogger.d("report click event");
        if (!this.f12280a.a(this.f12280a.f12288a, view)) {
            u.a(30492, 0, this.c);
            GDTLogger.e("clicked view is not in NativeAdContainer");
            return;
        }
        this.f12280a.c.b(System.currentTimeMillis());
        if (com.qq.e.comm.plugin.c.e.a(this.f12281b)) {
            com.qq.e.comm.plugin.c.e.c(new f.a(this.f12281b, this.f12280a.f12288a).a(this.f12280a.m()).a(), this.d);
            this.f12280a.a(2, new Object[]{""});
            return;
        }
        com.qq.e.comm.plugin.s.c l = this.f12281b.l();
        if (l == null) {
            u.a(30492, 1, this.c);
            return;
        }
        switch (l.a()) {
            case 1:
                a(view, 0, UIMsg.m_AppUI.MSG_CLICK_ITEM);
                u.a(30472, 2, this.c);
                return;
            case 2:
                a(view);
                a(view, 0, com.baidu.pass.ecommerce.d.b.p);
                u.a(30472, 1, this.c);
                return;
            case 3:
                a(view, 0, 9002);
                u.a(30472, 3, this.c);
                return;
            default:
                return;
        }
    }
}
