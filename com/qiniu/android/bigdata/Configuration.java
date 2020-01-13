package com.qiniu.android.bigdata;
/* loaded from: classes4.dex */
public final class Configuration implements Cloneable {
    public String nlJ = "https://pipeline.qiniu.com";
    public int connectTimeout = 3;
    public int responseTimeout = 10;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: dEz */
    public Configuration clone() throws CloneNotSupportedException {
        return (Configuration) super.clone();
    }
}
