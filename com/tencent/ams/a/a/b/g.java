package com.tencent.ams.a.a.b;

import java.util.List;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public f f13570a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f13571b;
    private String c;

    public String toString() {
        if (this.c != null) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f13570a != null) {
            sb.append("offlineCache[");
            sb.append("len=").append(this.f13570a.f13568a).append(",");
            sb.append("timeout=").append(this.f13570a.c).append(",");
            sb.append("expiration=").append(this.f13570a.f13569b);
            sb.append("]");
        }
        if (this.f13571b != null && this.f13571b.size() > 0) {
            sb.append("companies{");
            for (b bVar : this.f13571b) {
                if (bVar != null) {
                    sb.append("[").append(bVar.f13561a);
                    if (bVar.f13562b != null) {
                        sb.append("--").append(bVar.f13562b.f13565a);
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
