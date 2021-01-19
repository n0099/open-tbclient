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
    private k pUD;
    private l pUE;
    private i pUF;
    private com.ss.android.socialbase.downloader.d.r pUG;
    private ExecutorService pUQ;
    private ExecutorService pUR;
    private ExecutorService pUS;
    private com.ss.android.socialbase.downloader.i.h pVD;
    private com.ss.android.socialbase.downloader.i.f pVE;
    private m pVF;
    private h pVG;
    private q pVH;
    private ab pVI;
    private com.ss.android.socialbase.downloader.d.e pVJ;
    private ExecutorService pVK;
    private ExecutorService pVL;
    private ExecutorService pfy;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f13137a = context;
    }

    public g c(h hVar) {
        this.pVG = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.pVD = hVar;
        return this;
    }

    public g QZ(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.pVI = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.pUG = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.pVJ = eVar;
        return this;
    }

    public Context a() {
        return this.f13137a;
    }

    public k eEj() {
        return this.pUD;
    }

    public l eEk() {
        return this.pUE;
    }

    public com.ss.android.socialbase.downloader.i.h eEl() {
        return this.pVD;
    }

    public com.ss.android.socialbase.downloader.i.f eDG() {
        return this.pVE;
    }

    public m eEm() {
        return this.pVF;
    }

    public ExecutorService eEn() {
        return this.pVK;
    }

    public ExecutorService eEo() {
        return this.pVL;
    }

    public ExecutorService i() {
        return this.ceA;
    }

    public ExecutorService eDL() {
        return this.p;
    }

    public ExecutorService um() {
        return this.pUQ;
    }

    public ExecutorService eDM() {
        return this.pUR;
    }

    public ExecutorService eDN() {
        return this.pUS;
    }

    public ExecutorService eDO() {
        return this.pfy;
    }

    public ab eEp() {
        return this.pVI;
    }

    public int p() {
        return this.u;
    }

    public i eDi() {
        return this.pUF;
    }

    public h eDj() {
        return this.pVG;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eEq() {
        return this.pVH;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eEr() {
        return this.pUG;
    }

    public com.ss.android.socialbase.downloader.d.e eEs() {
        return this.pVJ;
    }

    public f eEt() {
        return new f(this);
    }
}
