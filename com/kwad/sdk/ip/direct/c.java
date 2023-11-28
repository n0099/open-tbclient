package com.kwad.sdk.ip.direct;
/* loaded from: classes10.dex */
public final class c implements Comparable<c> {
    public String ip;
    public boolean success;
    public int weight;
    public float aHB = -1.0f;
    public int aHH = 20;
    public int aHG = 3;
    public StringBuffer aHI = new StringBuffer();

    public c(String str) {
        this.ip = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return (int) (this.aHB - cVar.aHB);
    }

    public final void bB(boolean z) {
        this.success = z;
    }

    public final void dd(int i) {
        this.weight = i;
    }

    public final void i(float f) {
        this.aHB = f;
    }

    public final int HH() {
        return this.aHG;
    }

    public final float HI() {
        return this.aHB;
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
        return "PingNetEntity{ip='" + this.ip + "', pingCount=" + this.aHG + ", pingWaitTime=" + this.aHH + ", pingTime='" + this.aHB + " ms', success=" + this.success + '}';
    }
}
