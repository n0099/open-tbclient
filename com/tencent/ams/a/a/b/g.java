package com.tencent.ams.a.a.b;

import java.util.List;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public f f13569a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f13570b;
    private String c;

    public String toString() {
        if (this.c != null) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f13569a != null) {
            sb.append("offlineCache[");
            sb.append("len=").append(this.f13569a.f13567a).append(",");
            sb.append("timeout=").append(this.f13569a.c).append(",");
            sb.append("expiration=").append(this.f13569a.f13568b);
            sb.append("]");
        }
        if (this.f13570b != null && this.f13570b.size() > 0) {
            sb.append("companies{");
            for (b bVar : this.f13570b) {
                if (bVar != null) {
                    sb.append("[").append(bVar.f13560a);
                    if (bVar.f13561b != null) {
                        sb.append("--").append(bVar.f13561b.f13564a);
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
