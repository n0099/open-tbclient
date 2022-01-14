package com.ss.android.download.api.download;

import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class c implements DownloadEventConfig {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59298b;

    /* renamed from: c  reason: collision with root package name */
    public String f59299c;

    /* renamed from: d  reason: collision with root package name */
    public String f59300d;

    /* renamed from: e  reason: collision with root package name */
    public String f59301e;

    /* renamed from: f  reason: collision with root package name */
    public String f59302f;

    /* renamed from: g  reason: collision with root package name */
    public String f59303g;

    /* renamed from: h  reason: collision with root package name */
    public String f59304h;

    /* renamed from: i  reason: collision with root package name */
    public String f59305i;

    /* renamed from: j  reason: collision with root package name */
    public String f59306j;
    public String k;
    public Object l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public String q;

    /* loaded from: classes3.dex */
    public static final class a {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f59307b;

        /* renamed from: c  reason: collision with root package name */
        public String f59308c;

        /* renamed from: d  reason: collision with root package name */
        public String f59309d;

        /* renamed from: e  reason: collision with root package name */
        public String f59310e;

        /* renamed from: f  reason: collision with root package name */
        public String f59311f;

        /* renamed from: g  reason: collision with root package name */
        public String f59312g;

        /* renamed from: h  reason: collision with root package name */
        public String f59313h;

        /* renamed from: i  reason: collision with root package name */
        public String f59314i;

        /* renamed from: j  reason: collision with root package name */
        public String f59315j;
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
        return this.f59302f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f59303g;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f59299c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f59301e;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f59300d;
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
        return this.f59306j;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f59298b;
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
        this.f59298b = aVar.f59307b;
        this.f59299c = aVar.f59308c;
        this.f59300d = aVar.f59309d;
        this.f59301e = aVar.f59310e;
        this.f59302f = aVar.f59311f;
        this.f59303g = aVar.f59312g;
        this.f59304h = aVar.f59313h;
        this.f59305i = aVar.f59314i;
        this.f59306j = aVar.f59315j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
    }
}
