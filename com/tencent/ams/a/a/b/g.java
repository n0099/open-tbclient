package com.tencent.ams.a.a.b;

import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public f f13270a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f13271b;
    private String c;

    public String toString() {
        if (this.c != null) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f13270a != null) {
            sb.append("offlineCache[");
            sb.append("len=").append(this.f13270a.f13268a).append(",");
            sb.append("timeout=").append(this.f13270a.c).append(",");
            sb.append("expiration=").append(this.f13270a.f13269b);
            sb.append("]");
        }
        if (this.f13271b != null && this.f13271b.size() > 0) {
            sb.append("companies{");
            for (b bVar : this.f13271b) {
                if (bVar != null) {
                    sb.append("[").append(bVar.f13261a);
                    if (bVar.f13262b != null) {
                        sb.append("--").append(bVar.f13262b.f13265a);
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
