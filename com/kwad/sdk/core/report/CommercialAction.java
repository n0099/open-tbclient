package com.kwad.sdk.core.report;

import java.io.Serializable;
/* loaded from: classes7.dex */
public class CommercialAction {

    /* loaded from: classes7.dex */
    public static class TKDownloadMsg extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final int FAIL = 2;
        public static final int START = 0;
        public static final int SUCCESS = 1;
        public static final long serialVersionUID = -8872909341685100922L;
        public int downloadState;
        public long downloadTime;
        public String errorReason;
        public int preload;
        public String templateId;
        public String versionCode;

        public TKDownloadMsg setDownloadState(int i) {
            this.downloadState = i;
            return this;
        }

        public TKDownloadMsg setDownloadTime(long j) {
            this.downloadTime = j;
            return this;
        }

        public TKDownloadMsg setErrorReason(String str) {
            this.errorReason = str;
            return this;
        }

        public TKDownloadMsg setPreload(int i) {
            this.preload = i;
            return this;
        }

        public TKDownloadMsg setTemplateId(String str) {
            this.templateId = str;
            return this;
        }

        public TKDownloadMsg setVersionCode(String str) {
            this.versionCode = str;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class TKPerformMsg extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final int OTHER_FAIL = 3;
        public static final int PAGE_STATUS_FAIL = 2;
        public static final int START = 0;
        public static final int SUCCESS = 1;
        public static final long serialVersionUID = -5293371882532982729L;
        public String errorReason;
        public int renderState;
        public long renderTime;
        public int source;
        public String templateId;
        public String versionCode;

        public TKPerformMsg() {
            setSource(2);
        }

        public TKPerformMsg setErrorReason(String str) {
            this.errorReason = str;
            return this;
        }

        public TKPerformMsg setRenderState(int i) {
            this.renderState = i;
            return this;
        }

        public TKPerformMsg setRenderTime(long j) {
            this.renderTime = j;
            return this;
        }

        public TKPerformMsg setSource(int i) {
            this.source = i;
            return this;
        }

        public TKPerformMsg setTemplateId(String str) {
            this.templateId = str;
            return this;
        }

        public TKPerformMsg setVersionCode(String str) {
            this.versionCode = str;
            return this;
        }
    }
}
