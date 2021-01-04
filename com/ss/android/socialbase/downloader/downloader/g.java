package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ab;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13436a;
    private ExecutorService cjn;
    private ExecutorService p;
    private ExecutorService pXH;
    private ExecutorService pXI;
    private ExecutorService pXJ;
    private k pXu;
    private l pXv;
    private i pXw;
    private com.ss.android.socialbase.downloader.d.r pXx;
    private ab pYA;
    private com.ss.android.socialbase.downloader.d.e pYB;
    private ExecutorService pYC;
    private ExecutorService pYD;
    private com.ss.android.socialbase.downloader.i.h pYv;
    private com.ss.android.socialbase.downloader.i.f pYw;
    private m pYx;
    private h pYy;
    private q pYz;
    private ExecutorService pkc;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f13436a = context;
    }

    public g c(h hVar) {
        this.pYy = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.pYv = hVar;
        return this;
    }

    public g Sq(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.pYA = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.pXx = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.pYB = eVar;
        return this;
    }

    public Context a() {
        return this.f13436a;
    }

    public k eHv() {
        return this.pXu;
    }

    public l eHw() {
        return this.pXv;
    }

    public com.ss.android.socialbase.downloader.i.h eHx() {
        return this.pYv;
    }

    public com.ss.android.socialbase.downloader.i.f eGS() {
        return this.pYw;
    }

    public m eHy() {
        return this.pYx;
    }

    public ExecutorService eHz() {
        return this.pYC;
    }

    public ExecutorService eHA() {
        return this.pYD;
    }

    public ExecutorService i() {
        return this.cjn;
    }

    public ExecutorService eGX() {
        return this.p;
    }

    public ExecutorService ut() {
        return this.pXH;
    }

    public ExecutorService eGY() {
        return this.pXI;
    }

    public ExecutorService eGZ() {
        return this.pXJ;
    }

    public ExecutorService eHa() {
        return this.pkc;
    }

    public ab eHB() {
        return this.pYA;
    }

    public int p() {
        return this.u;
    }

    public i eGu() {
        return this.pXw;
    }

    public h eGv() {
        return this.pYy;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eHC() {
        return this.pYz;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eHD() {
        return this.pXx;
    }

    public com.ss.android.socialbase.downloader.d.e eHE() {
        return this.pYB;
    }

    public f eHF() {
        return new f(this);
    }
}
