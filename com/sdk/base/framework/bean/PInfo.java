package com.sdk.base.framework.bean;

import com.sdk.base.framework.f.c.a;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PInfo {

    /* renamed from: c  reason: collision with root package name */
    public String f39325c;
    public ArrayList<String> imei;
    public String mac;
    public String n;
    public String os;

    public String getC() {
        return this.f39325c;
    }

    public ArrayList<String> getImei() {
        return this.imei;
    }

    public String getMac() {
        return this.mac;
    }

    public String getN() {
        return this.n;
    }

    public String getOs() {
        return this.os;
    }

    public void setC(String str) {
        this.f39325c = str;
    }

    public void setImei(ArrayList<String> arrayList) {
        this.imei = arrayList;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setN(String str) {
        this.n = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public String toString() {
        return a.a(this);
    }
}
