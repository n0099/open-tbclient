package com.kwad.sdk.ip.direct;
/* loaded from: classes9.dex */
public final class c implements Comparable<c> {
    public String ip;
    public boolean success;
    public int weight;
    public float ajf = -1.0f;
    public int ajk = 20;
    public int ajj = 3;
    public StringBuffer ajl = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return (int) (this.ajf - cVar.ajf);
    }

    public final void aU(boolean z) {
        this.success = z;
    }

    public final void bf(int i) {
        this.weight = i;
    }

    public final void g(float f) {
        this.ajf = f;
    }

    public final String getIp() {
        return this.ip;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final boolean isSuccess() {
        return this.success;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.ajj + ", pingWaitTime=" + this.ajk + ", pingTime='" + this.ajf + " ms', success=" + this.success + '}';
    }

    public final int xN() {
        return this.ajj;
    }

    public final float xO() {
        return this.ajf;
    }
}
