package com.qiniu.android.bigdata;
/* loaded from: classes5.dex */
public final class Configuration implements Cloneable {
    public String nCk = "https://pipeline.qiniu.com";
    public int connectTimeout = 3;
    public int responseTimeout = 10;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: dMC */
    public Configuration clone() throws CloneNotSupportedException {
        return (Configuration) super.clone();
    }
}
