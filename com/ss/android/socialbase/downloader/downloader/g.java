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
    private ExecutorService ppQ;
    private k qeH;
    private l qeI;
    private i qeJ;
    private com.ss.android.socialbase.downloader.d.r qeK;
    private ExecutorService qeU;
    private ExecutorService qeV;
    private ExecutorService qeW;
    private com.ss.android.socialbase.downloader.i.h qfH;
    private com.ss.android.socialbase.downloader.i.f qfI;
    private m qfJ;
    private h qfK;
    private q qfL;
    private ab qfM;
    private com.ss.android.socialbase.downloader.d.e qfN;
    private ExecutorService qfO;
    private ExecutorService qfP;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f13139a = context;
    }

    public g c(h hVar) {
        this.qfK = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.qfH = hVar;
        return this;
    }

    public g Ru(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.qfM = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.qeK = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.qfN = eVar;
        return this;
    }

    public Context a() {
        return this.f13139a;
    }

    public k eGA() {
        return this.qeH;
    }

    public l eGB() {
        return this.qeI;
    }

    public com.ss.android.socialbase.downloader.i.h eGC() {
        return this.qfH;
    }

    public com.ss.android.socialbase.downloader.i.f eFX() {
        return this.qfI;
    }

    public m eGD() {
        return this.qfJ;
    }

    public ExecutorService eGE() {
        return this.qfO;
    }

    public ExecutorService eGF() {
        return this.qfP;
    }

    public ExecutorService i() {
        return this.ciJ;
    }

    public ExecutorService eGc() {
        return this.p;
    }

    public ExecutorService uj() {
        return this.qeU;
    }

    public ExecutorService eGd() {
        return this.qeV;
    }

    public ExecutorService eGe() {
        return this.qeW;
    }

    public ExecutorService eGf() {
        return this.ppQ;
    }

    public ab eGG() {
        return this.qfM;
    }

    public int p() {
        return this.u;
    }

    public i eFz() {
        return this.qeJ;
    }

    public h eFA() {
        return this.qfK;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eGH() {
        return this.qfL;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eGI() {
        return this.qeK;
    }

    public com.ss.android.socialbase.downloader.d.e eGJ() {
        return this.qfN;
    }

    public f eGK() {
        return new f(this);
    }
}
