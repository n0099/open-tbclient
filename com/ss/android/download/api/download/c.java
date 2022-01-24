package com.ss.android.download.api.download;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes4.dex */
public class c implements DownloadEventConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59343b;

    /* renamed from: c  reason: collision with root package name */
    public String f59344c;

    /* renamed from: d  reason: collision with root package name */
    public String f59345d;

    /* renamed from: e  reason: collision with root package name */
    public String f59346e;

    /* renamed from: f  reason: collision with root package name */
    public String f59347f;

    /* renamed from: g  reason: collision with root package name */
    public String f59348g;

    /* renamed from: h  reason: collision with root package name */
    public String f59349h;

    /* renamed from: i  reason: collision with root package name */
    public String f59350i;

    /* renamed from: j  reason: collision with root package name */
    public String f59351j;
    public String k;
    public Object l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    /* loaded from: classes4.dex */
    public static final class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f59352b;

        /* renamed from: c  reason: collision with root package name */
        public String f59353c;

        /* renamed from: d  reason: collision with root package name */
        public String f59354d;

        /* renamed from: e  reason: collision with root package name */
        public String f59355e;

        /* renamed from: f  reason: collision with root package name */
        public String f59356f;

        /* renamed from: g  reason: collision with root package name */
        public String f59357g;

        /* renamed from: h  reason: collision with root package name */
        public String f59358h;

        /* renamed from: i  reason: collision with root package name */
        public String f59359i;

        /* renamed from: j  reason: collision with root package name */
        public String f59360j;
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
        return this.f59347f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f59348g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f59344c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f59346e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f59345d;
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
        return this.f59351j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f59343b;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.m;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i2) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public c() {
    }

    public c(a aVar) {
        this.a = aVar.a;
        this.f59343b = aVar.f59352b;
        this.f59344c = aVar.f59353c;
        this.f59345d = aVar.f59354d;
        this.f59346e = aVar.f59355e;
        this.f59347f = aVar.f59356f;
        this.f59348g = aVar.f59357g;
        this.f59349h = aVar.f59358h;
        this.f59350i = aVar.f59359i;
        this.f59351j = aVar.f59360j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
