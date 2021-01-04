package com.qq.e.comm.plugin.y;

import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends b {

    /* renamed from: a  reason: collision with root package name */
    private int f12998a;

    /* renamed from: b  reason: collision with root package name */
    private int f12999b;

    public e(int i) {
        a(NotificationStyle.EXPANDABLE_IMAGE_URL, Integer.valueOf(i));
        this.f12998a = i;
    }

    @Override // com.qq.e.comm.plugin.y.b
    public /* bridge */ /* synthetic */ JSONObject a() {
        return super.a();
    }

    @Override // com.qq.e.comm.plugin.y.b
    public /* bridge */ /* synthetic */ void a(c cVar) {
        super.a(cVar);
    }

    @Override // com.qq.e.comm.plugin.y.b
    public /* bridge */ /* synthetic */ void a(d dVar) {
        super.a(dVar);
    }

    public e b(int i) {
        a("vl", Integer.valueOf(i));
        this.f12999b = i;
        return this;
    }

    @Override // com.qq.e.comm.plugin.y.b
    public String toString() {
        return "ei=" + this.f12998a + " , vl=" + this.f12999b;
    }
}
