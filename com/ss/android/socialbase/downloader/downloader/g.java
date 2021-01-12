package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ab;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13137a;
    private ExecutorService ceA;
    private ExecutorService p;
    private k pUC;
    private l pUD;
    private i pUE;
    private com.ss.android.socialbase.downloader.d.r pUF;
    private ExecutorService pUP;
    private ExecutorService pUQ;
    private ExecutorService pUR;
    private com.ss.android.socialbase.downloader.i.h pVC;
    private com.ss.android.socialbase.downloader.i.f pVD;
    private m pVE;
    private h pVF;
    private q pVG;
    private ab pVH;
    private com.ss.android.socialbase.downloader.d.e pVI;
    private ExecutorService pVJ;
    private ExecutorService pVK;
    private ExecutorService pfx;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f13137a = context;
    }

    public g c(h hVar) {
        this.pVF = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.pVC = hVar;
        return this;
    }

    public g QZ(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.pVH = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.pUF = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.pVI = eVar;
        return this;
    }

    public Context a() {
        return this.f13137a;
    }

    public k eEj() {
        return this.pUC;
    }

    public l eEk() {
        return this.pUD;
    }

    public com.ss.android.socialbase.downloader.i.h eEl() {
        return this.pVC;
    }

    public com.ss.android.socialbase.downloader.i.f eDG() {
        return this.pVD;
    }

    public m eEm() {
        return this.pVE;
    }

    public ExecutorService eEn() {
        return this.pVJ;
    }

    public ExecutorService eEo() {
        return this.pVK;
    }

    public ExecutorService i() {
        return this.ceA;
    }

    public ExecutorService eDL() {
        return this.p;
    }

    public ExecutorService um() {
        return this.pUP;
    }

    public ExecutorService eDM() {
        return this.pUQ;
    }

    public ExecutorService eDN() {
        return this.pUR;
    }

    public ExecutorService eDO() {
        return this.pfx;
    }

    public ab eEp() {
        return this.pVH;
    }

    public int p() {
        return this.u;
    }

    public i eDi() {
        return this.pUE;
    }

    public h eDj() {
        return this.pVF;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eEq() {
        return this.pVG;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eEr() {
        return this.pUF;
    }

    public com.ss.android.socialbase.downloader.d.e eEs() {
        return this.pVI;
    }

    public f eEt() {
        return new f(this);
    }
}
