package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements com.ss.android.downloadad.api.a.a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadModel f61804b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadEventConfig f61805c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadController f61806d;

    public e() {
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.f61804b.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.f61804b.getId();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.f61804b.isAd();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.f61804b.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.f61804b.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        if (this.f61804b.getDeepLink() != null) {
            return this.f61804b.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.f61804b.getExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        if (this.f61806d.getDownloadMode() == 2) {
            return 2;
        }
        return this.f61804b.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.f61805c.getRefer();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.f61805c.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return this.f61805c.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.f61804b.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.f61805c.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return this.f61804b.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return this.f61805c.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return this.f61805c.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.f61806d.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return this.f61804b.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return this.f61805c.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return this.f61804b;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return this.f61805c;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return this.f61806d;
    }

    public boolean x() {
        DownloadModel downloadModel;
        if (this.a == 0 || (downloadModel = this.f61804b) == null || this.f61805c == null || this.f61806d == null) {
            return true;
        }
        return downloadModel.isAd() && this.a <= 0;
    }

    public boolean y() {
        if (x()) {
            return false;
        }
        if (this.f61804b.isAd()) {
            DownloadModel downloadModel = this.f61804b;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f61805c instanceof AdDownloadEventConfig) && (this.f61806d instanceof AdDownloadController);
        }
        return this.f61804b instanceof AdDownloadModel;
    }

    public e(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.a = j2;
        this.f61804b = downloadModel;
        this.f61805c = downloadEventConfig;
        this.f61806d = downloadController;
    }
}
