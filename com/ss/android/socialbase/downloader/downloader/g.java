package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.d.ab;
import java.util.concurrent.ExecutorService;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f13437a;
    private ExecutorService cjn;
    private ExecutorService p;
    private k pZc;
    private l pZd;
    private i pZe;
    private com.ss.android.socialbase.downloader.d.r pZf;
    private ExecutorService pZp;
    private ExecutorService pZq;
    private ExecutorService pZr;
    private ExecutorService pkc;
    private com.ss.android.socialbase.downloader.i.h qad;
    private com.ss.android.socialbase.downloader.i.f qae;
    private m qaf;
    private h qag;
    private q qah;
    private ab qai;
    private com.ss.android.socialbase.downloader.d.e qaj;
    private ExecutorService qak;
    private ExecutorService qal;
    private int u;
    private int v;
    private boolean w;
    private boolean x = true;
    private int y = 1056964095;

    public g(Context context) {
        this.f13437a = context;
    }

    public g c(h hVar) {
        this.qag = hVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.i.h hVar) {
        this.qad = hVar;
        return this;
    }

    public g SG(int i) {
        this.y = i;
        return this;
    }

    public g c(ab abVar) {
        this.qai = abVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.r rVar) {
        this.pZf = rVar;
        return this;
    }

    public g b(com.ss.android.socialbase.downloader.d.e eVar) {
        this.qaj = eVar;
        return this;
    }

    public Context a() {
        return this.f13437a;
    }

    public k eHZ() {
        return this.pZc;
    }

    public l eIa() {
        return this.pZd;
    }

    public com.ss.android.socialbase.downloader.i.h eIb() {
        return this.qad;
    }

    public com.ss.android.socialbase.downloader.i.f eHw() {
        return this.qae;
    }

    public m eIc() {
        return this.qaf;
    }

    public ExecutorService eId() {
        return this.qak;
    }

    public ExecutorService eIe() {
        return this.qal;
    }

    public ExecutorService i() {
        return this.cjn;
    }

    public ExecutorService eHB() {
        return this.p;
    }

    public ExecutorService ut() {
        return this.pZp;
    }

    public ExecutorService eHC() {
        return this.pZq;
    }

    public ExecutorService eHD() {
        return this.pZr;
    }

    public ExecutorService eHE() {
        return this.pkc;
    }

    public ab eIf() {
        return this.qai;
    }

    public int p() {
        return this.u;
    }

    public i eGY() {
        return this.pZe;
    }

    public h eGZ() {
        return this.qag;
    }

    public int s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public q eIg() {
        return this.qah;
    }

    public int v() {
        return this.y;
    }

    public boolean w() {
        return this.x;
    }

    public com.ss.android.socialbase.downloader.d.r eIh() {
        return this.pZf;
    }

    public com.ss.android.socialbase.downloader.d.e eIi() {
        return this.qaj;
    }

    public f eIj() {
        return new f(this);
    }
}
