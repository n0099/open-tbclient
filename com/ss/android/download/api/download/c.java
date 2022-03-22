package com.ss.android.download.api.download;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes7.dex */
public class c implements DownloadEventConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42627b;

    /* renamed from: c  reason: collision with root package name */
    public String f42628c;

    /* renamed from: d  reason: collision with root package name */
    public String f42629d;

    /* renamed from: e  reason: collision with root package name */
    public String f42630e;

    /* renamed from: f  reason: collision with root package name */
    public String f42631f;

    /* renamed from: g  reason: collision with root package name */
    public String f42632g;

    /* renamed from: h  reason: collision with root package name */
    public String f42633h;
    public String i;
    public String j;
    public String k;
    public Object l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    /* loaded from: classes7.dex */
    public static final class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f42634b;

        /* renamed from: c  reason: collision with root package name */
        public String f42635c;

        /* renamed from: d  reason: collision with root package name */
        public String f42636d;

        /* renamed from: e  reason: collision with root package name */
        public String f42637e;

        /* renamed from: f  reason: collision with root package name */
        public String f42638f;

        /* renamed from: g  reason: collision with root package name */
        public String f42639g;

        /* renamed from: h  reason: collision with root package name */
        public String f42640h;
        public String i;
        public String j;
        public String k;
        public Object l;
        public boolean m;
        public boolean n;
        public boolean o;
        public String p;
        public String q;

        public c a() {
            return new c(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f42631f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f42632g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f42628c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f42630e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f42629d;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.l;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.q;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f42627b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public c() {
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f42627b = aVar.f42634b;
        this.f42628c = aVar.f42635c;
        this.f42629d = aVar.f42636d;
        this.f42630e = aVar.f42637e;
        this.f42631f = aVar.f42638f;
        this.f42632g = aVar.f42639g;
        this.f42633h = aVar.f42640h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
