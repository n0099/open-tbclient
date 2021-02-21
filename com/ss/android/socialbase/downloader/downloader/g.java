package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ab;
import java.util.concurrent.ExecutorService;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13139a;
    private ExecutorService ciJ;
    private ExecutorService p;
    private ExecutorService pqq;
    private k qfh;
    private l qfi;
    private i qfj;
    private com.ss.android.socialbase.downloader.d.r qfk;
    private ExecutorService qfu;
    private ExecutorService qfv;
    private ExecutorService qfw;
    private com.ss.android.socialbase.downloader.i.h qgh;
    private com.ss.android.socialbase.downloader.i.f qgi;
    private m qgj;
    private h qgk;
    private q qgl;
    private ab qgm;
    private com.ss.android.socialbase.downloader.d.e qgn;
    private ExecutorService qgo;
    private ExecutorService qgp;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f13139a = context;
    }

    public g c(h hVar) {
        this.qgk = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.qgh = hVar;
        return this;
    }

    public g Rv(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.qgm = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.qfk = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.qgn = eVar;
        return this;
    }

    public Context a() {
        return this.f13139a;
    }

    public k eGI() {
        return this.qfh;
    }

    public l eGJ() {
        return this.qfi;
    }

    public com.ss.android.socialbase.downloader.i.h eGK() {
        return this.qgh;
    }

    public com.ss.android.socialbase.downloader.i.f eGf() {
        return this.qgi;
    }

    public m eGL() {
        return this.qgj;
    }

    public ExecutorService eGM() {
        return this.qgo;
    }

    public ExecutorService eGN() {
        return this.qgp;
    }

    public ExecutorService i() {
        return this.ciJ;
    }

    public ExecutorService eGk() {
        return this.p;
    }

    public ExecutorService uj() {
        return this.qfu;
    }

    public ExecutorService eGl() {
        return this.qfv;
    }

    public ExecutorService eGm() {
        return this.qfw;
    }

    public ExecutorService eGn() {
        return this.pqq;
    }

    public ab eGO() {
        return this.qgm;
    }

    public int p() {
        return this.u;
    }

    public i eFH() {
        return this.qfj;
    }

    public h eFI() {
        return this.qgk;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eGP() {
        return this.qgl;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eGQ() {
        return this.qfk;
    }

    public com.ss.android.socialbase.downloader.d.e eGR() {
        return this.qgn;
    }

    public f eGS() {
        return new f(this);
    }
}
