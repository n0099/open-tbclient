package com.ss.android.downloadad.api.download;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadlib.addownload.j;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AdDownloadController implements DownloadController {
    public int mDownloadMode;
    public Object mExtraClickOperation;
    public JSONObject mExtraJson;
    public Object mExtraObject;
    public int mInterceptFlag;
    public boolean mIsAddToDownloadManage;
    public boolean mIsAutoDownloadOnCardShow;
    public boolean mIsEnableBackDialog;
    public int mLinkMode;
    public boolean mShouldUseNewWebView;
    public boolean mEnableShowComplianceDialog = true;
    public boolean mEnableNewActivity = true;
    public boolean mEnableAH = true;
    public boolean mEnableAM = true;

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 1;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    /* loaded from: classes10.dex */
    public static final class Builder {
        public AdDownloadController controller = new AdDownloadController();

        @Deprecated
        public Builder setDowloadChunkCount(int i) {
            return this;
        }

        @Deprecated
        public Builder setIsEnableMultipleDownload(boolean z) {
            return this;
        }

        public AdDownloadController build() {
            return this.controller;
        }

        public Builder setDownloadMode(int i) {
            this.controller.mDownloadMode = i;
            return this;
        }

        public Builder setEnableAH(boolean z) {
            this.controller.mEnableAH = z;
            return this;
        }

        public Builder setEnableAM(boolean z) {
            this.controller.mEnableAM = z;
            return this;
        }

        public Builder setEnableNewActivity(boolean z) {
            this.controller.mEnableNewActivity = z;
            return this;
        }

        public Builder setEnableShowComplianceDialog(boolean z) {
            this.controller.mEnableShowComplianceDialog = z;
            return this;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            this.controller.mExtraJson = jSONObject;
            return this;
        }

        public Builder setExtraObject(Object obj) {
            this.controller.mExtraObject = obj;
            return this;
        }

        @Deprecated
        public Builder setExtraOperation(Object obj) {
            this.controller.mExtraClickOperation = obj;
            return this;
        }

        public Builder setInterceptFlag(int i) {
            this.controller.mInterceptFlag = i;
            return this;
        }

        public Builder setIsAddToDownloadManage(boolean z) {
            this.controller.mIsAddToDownloadManage = z;
            return this;
        }

        public Builder setIsAutoDownloadOnCardShow(boolean z) {
            this.controller.mIsAutoDownloadOnCardShow = z;
            return this;
        }

        public Builder setIsEnableBackDialog(boolean z) {
            this.controller.mIsEnableBackDialog = z;
            return this;
        }

        public Builder setLinkMode(int i) {
            this.controller.mLinkMode = i;
            return this;
        }

        public Builder setShouldUseNewWebView(boolean z) {
            this.controller.mShouldUseNewWebView = z;
            return this;
        }
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return this.mEnableAH;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return this.mEnableAM;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return this.mEnableNewActivity;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return this.mEnableShowComplianceDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return this.mDownloadMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        return this.mExtraClickOperation;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        return this.mExtraObject;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return this.mInterceptFlag;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return this.mLinkMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return this.mIsAddToDownloadManage;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return this.mIsAutoDownloadOnCardShow;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return this.mShouldUseNewWebView;
    }

    public static AdDownloadController fromJson(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            builder.setLinkMode(jSONObject.optInt("link_mode"));
            builder.setDownloadMode(jSONObject.optInt("download_mode"));
            boolean z8 = false;
            if (jSONObject.optInt("enable_back_dialog") == 1) {
                z = true;
            } else {
                z = false;
            }
            builder.setIsEnableBackDialog(z);
            if (jSONObject.optInt("add_to_manage") == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            builder.setIsAddToDownloadManage(z2);
            if (jSONObject.optInt("use_new_webview") == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            builder.setShouldUseNewWebView(z3);
            builder.setInterceptFlag(jSONObject.optInt("intercept_flag"));
            if (jSONObject.optInt("enable_show_compliance_dialog", 1) == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            builder.setEnableShowComplianceDialog(z4);
            if (jSONObject.optInt("is_auto_download_on_card_show") == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            builder.setIsAutoDownloadOnCardShow(z5);
            if (jSONObject.optInt("enable_new_activity", 1) == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            builder.setEnableNewActivity(z6);
            if (jSONObject.optInt("enable_ah", 1) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            builder.setEnableAH(z7);
            if (jSONObject.optInt("enable_am", 1) == 1) {
                z8 = true;
            }
            builder.setEnableAM(z8);
            builder.setExtraJson(jSONObject.optJSONObject("extra"));
        } catch (Exception e) {
            j.s().a(e, "AdDownloadController fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i) {
        this.mDownloadMode = i;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z) {
        this.mEnableNewActivity = z;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
        this.mEnableShowComplianceDialog = z;
    }

    public void setExtraJson(JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public void setExtraObject(Object obj) {
        this.mExtraObject = obj;
    }

    public void setIsAutoDownloadOnCardShow(boolean z) {
        this.mIsAutoDownloadOnCardShow = z;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int i) {
        this.mLinkMode = i;
    }

    public JSONObject toJson() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("link_mode", Integer.valueOf(this.mLinkMode));
            jSONObject.putOpt("download_mode", Integer.valueOf(this.mDownloadMode));
            int i8 = 1;
            if (this.mIsEnableBackDialog) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.putOpt("enable_back_dialog", Integer.valueOf(i));
            if (this.mIsAddToDownloadManage) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            jSONObject.putOpt("add_to_manage", Integer.valueOf(i2));
            if (this.mShouldUseNewWebView) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            jSONObject.putOpt("use_new_webview", Integer.valueOf(i3));
            jSONObject.putOpt("intercept_flag", Integer.valueOf(this.mInterceptFlag));
            if (this.mEnableShowComplianceDialog) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            jSONObject.putOpt("enable_show_compliance_dialog", Integer.valueOf(i4));
            if (this.mIsAutoDownloadOnCardShow) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            jSONObject.putOpt("is_auto_download_on_card_show", Integer.valueOf(i5));
            jSONObject.putOpt("extra", this.mExtraJson);
            if (this.mEnableNewActivity) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            jSONObject.putOpt("enable_new_activity", Integer.valueOf(i6));
            if (this.mEnableAH) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            jSONObject.putOpt("enable_ah", Integer.valueOf(i7));
            if (!this.mEnableAM) {
                i8 = 0;
            }
            jSONObject.putOpt("enable_am", Integer.valueOf(i8));
        } catch (Exception e) {
            j.s().a(e, "AdDownloadController toJson");
        }
        return jSONObject;
    }
}
