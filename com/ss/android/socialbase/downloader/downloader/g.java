package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ab;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f7822a;
    private ExecutorService ckj;
    private ExecutorService p;
    private ExecutorService psv;
    private k qfW;
    private l qfX;
    private i qfY;
    private com.ss.android.socialbase.downloader.d.r qfZ;
    private com.ss.android.socialbase.downloader.i.h qgW;
    private com.ss.android.socialbase.downloader.i.f qgX;
    private m qgY;
    private h qgZ;
    private ExecutorService qgj;
    private ExecutorService qgk;
    private ExecutorService qgl;
    private q qha;
    private ab qhb;
    private com.ss.android.socialbase.downloader.d.e qhc;
    private ExecutorService qhd;
    private ExecutorService qhe;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f7822a = context;
    }

    public g c(h hVar) {
        this.qgZ = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.qgW = hVar;
        return this;
    }

    public g Rz(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.qhb = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.qfZ = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.qhc = eVar;
        return this;
    }

    public Context a() {
        return this.f7822a;
    }

    public k eGM() {
        return this.qfW;
    }

    public l eGN() {
        return this.qfX;
    }

    public com.ss.android.socialbase.downloader.i.h eGO() {
        return this.qgW;
    }

    public com.ss.android.socialbase.downloader.i.f eGj() {
        return this.qgX;
    }

    public m eGP() {
        return this.qgY;
    }

    public ExecutorService eGQ() {
        return this.qhd;
    }

    public ExecutorService eGR() {
        return this.qhe;
    }

    public ExecutorService i() {
        return this.ckj;
    }

    public ExecutorService eGo() {
        return this.p;
    }

    public ExecutorService uj() {
        return this.qgj;
    }

    public ExecutorService eGp() {
        return this.qgk;
    }

    public ExecutorService eGq() {
        return this.qgl;
    }

    public ExecutorService eGr() {
        return this.psv;
    }

    public ab eGS() {
        return this.qhb;
    }

    public int p() {
        return this.u;
    }

    public i eFL() {
        return this.qfY;
    }

    public h eFM() {
        return this.qgZ;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eGT() {
        return this.qha;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eGU() {
        return this.qfZ;
    }

    public com.ss.android.socialbase.downloader.d.e eGV() {
        return this.qhc;
    }

    public f eGW() {
        return new f(this);
    }
}
