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
/* loaded from: classes4.dex */
public class e implements com.ss.android.downloadad.api.a.a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public DownloadModel f59509b;

    /* renamed from: c  reason: collision with root package name */
    public DownloadEventConfig f59510c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadController f59511d;

    public e() {
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.f59509b.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.f59509b.getId();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.f59509b.isAd();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.f59509b.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.f59509b.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        if (this.f59509b.getDeepLink() != null) {
            return this.f59509b.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.f59509b.getExtra();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        if (this.f59511d.getDownloadMode() == 2) {
            return 2;
        }
        return this.f59509b.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.f59510c.getRefer();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.f59510c.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return this.f59510c.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.f59509b.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.f59510c.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return this.f59509b.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return this.f59510c.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return this.f59510c.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.f59511d.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return this.f59509b.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return 0;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return this.f59510c.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return this.f59509b;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return this.f59510c;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return this.f59511d;
    }

    public boolean x() {
        DownloadModel downloadModel;
        if (this.a == 0 || (downloadModel = this.f59509b) == null || this.f59510c == null || this.f59511d == null) {
            return true;
        }
        return downloadModel.isAd() && this.a <= 0;
    }

    public boolean y() {
        if (x()) {
            return false;
        }
        if (this.f59509b.isAd()) {
            DownloadModel downloadModel = this.f59509b;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f59510c instanceof AdDownloadEventConfig) && (this.f59511d instanceof AdDownloadController);
        }
        return this.f59509b instanceof AdDownloadModel;
    }

    public e(long j2, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.a = j2;
        this.f59509b = downloadModel;
        this.f59510c = downloadEventConfig;
        this.f59511d = downloadController;
    }
}
