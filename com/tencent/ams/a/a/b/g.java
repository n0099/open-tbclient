package com.tencent.ams.a.a.b;

import java.util.List;
/* loaded from: classes15.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public f f13272a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f13273b;
    private String c;

    public String toString() {
        if (this.c != null) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f13272a != null) {
            sb.append("offlineCache[");
            sb.append("len=").append(this.f13272a.f13270a).append(",");
            sb.append("timeout=").append(this.f13272a.c).append(",");
            sb.append("expiration=").append(this.f13272a.f13271b);
            sb.append("]");
        }
        if (this.f13273b != null && this.f13273b.size() > 0) {
            sb.append("companies{");
            for (b bVar : this.f13273b) {
                if (bVar != null) {
                    sb.append("[").append(bVar.f13263a);
                    if (bVar.f13264b != null) {
                        sb.append("--").append(bVar.f13264b.f13267a);
                    }
                    sb.append("]");
                }
            }
            sb.append("}");
        }
        this.c = sb.toString();
        return this.c;
    }
}
