package com.kuaishou.aegon.httpdns;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
@Keep
/* loaded from: classes3.dex */
public class ResolvedIP implements Comparable<ResolvedIP> {
    public final long mExpiredDate;
    public final String mHost;
    public final String mIP;
    public String mResolver;
    public long mRtt;
    public final long mTtl;

    @Keep
    public ResolvedIP(String str, String str2, String str3, long j, long j2) {
        this.mHost = str;
        this.mIP = str2;
        this.mResolver = str3;
        this.mRtt = j2;
        this.mExpiredDate = System.currentTimeMillis() + j;
        this.mTtl = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull ResolvedIP resolvedIP) {
        return (int) (this.mRtt - resolvedIP.mRtt);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ResolvedIP) && this.mIP.equals(((ResolvedIP) obj).mIP);
    }

    public int hashCode() {
        return this.mIP.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        sb.append("\thost = ").append(this.mHost).append("\n").append("\tip = ").append(this.mIP).append("\n").append("\ttype = ").append(this.mResolver).append("\n").append("\trtt = ").append(this.mRtt).append("\n").append("\tttl = ").append(this.mTtl).append("\n").append("\texpired = ").append(this.mExpiredDate).append("\n}\n");
        return sb.toString();
    }
}
