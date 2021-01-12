package com.fun.ad;

import android.widget.Button;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.R;
/* loaded from: classes14.dex */
public class bj implements TTAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public Button f7770a;

    public bj(Button button) {
        this.f7770a = button;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        m.a("CSJAppDownloadListener 下载中，点击图片暂停");
        Button button = this.f7770a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        Button button2 = this.f7770a;
        button2.setText(button2.getContext().getResources().getString(R.string.ad_interaction_type_downloading, String.format("%s/100", Long.valueOf((100 * j2) / j))));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        m.a("CSJAppDownloadListener 下载失败，点击图片重新下载");
        Button button = this.f7770a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        this.f7770a.setText(R.string.ad_interaction_type_download);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        m.a("CSJAppDownloadListener 点击图片安装");
        Button button = this.f7770a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        this.f7770a.setText(R.string.ad_interaction_type_install);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        m.a("CSJAppDownloadListener 下载暂停，点击图片继续");
        Button button = this.f7770a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        Button button2 = this.f7770a;
        button2.setText(button2.getContext().getResources().getString(R.string.ad_interaction_type_downloading, String.format("%s/100", Long.valueOf((100 * j2) / j))));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        m.a("CSJAppDownloadListener 点击图片开始下载");
        Button button = this.f7770a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        this.f7770a.setText(R.string.ad_interaction_type_download);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        m.a("CSJAppDownloadListener 安装完成，点击图片打开");
        Button button = this.f7770a;
        if (button == null || button.getTag(R.id.download_button_listener) != this) {
            return;
        }
        this.f7770a.setText(R.string.ad_interaction_type_open);
    }
}
