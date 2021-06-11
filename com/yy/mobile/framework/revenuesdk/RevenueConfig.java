package com.yy.mobile.framework.revenuesdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.ReportConfig;
import java.util.Locale;
/* loaded from: classes7.dex */
public class RevenueConfig {
    public int appId;
    public int authType;
    public String clientVer;
    public String countryCode;
    public int currencyType;
    public IRevenueDataSender dataSender;
    public String functionName;
    public boolean isOpenRisk;
    public String language;
    public Context mContext;
    public String pakageName;
    public ProtocolType protoType;
    public ReportConfig reportConfig;
    public String serviceName;
    public long uid;
    public int usedChannel;

    /* loaded from: classes7.dex */
    public static final class RevenueConfigBuilder {
        public IRevenueDataSender dataSender;
        public Context mContext;
        public ReportConfig reportConfig;
        public long uid = 0;
        public int usedChannel = 0;
        public int currencyType = 0;
        public String countryCode = Locale.getDefault().getCountry();
        public String language = Locale.getDefault().getLanguage();
        public String pakageName = "";
        public String clientVer = "";
        public String serviceName = "";
        public String functionName = "";
        public String httpUrl = "";
        public ProtocolType protoType = ProtocolType.SERVICE;
        public int authType = 4;
        public boolean isOpenRisk = false;
        public int appId = 0;

        public static RevenueConfigBuilder aRevenueConfig() {
            return new RevenueConfigBuilder();
        }

        public RevenueConfig build() {
            RevenueConfig revenueConfig = new RevenueConfig();
            revenueConfig.currencyType = this.currencyType;
            revenueConfig.dataSender = this.dataSender;
            revenueConfig.usedChannel = this.usedChannel;
            revenueConfig.countryCode = this.countryCode;
            revenueConfig.language = this.language;
            revenueConfig.uid = this.uid;
            revenueConfig.mContext = this.mContext;
            revenueConfig.pakageName = this.pakageName;
            revenueConfig.clientVer = this.clientVer;
            revenueConfig.serviceName = this.serviceName;
            revenueConfig.functionName = this.functionName;
            revenueConfig.protoType = this.protoType;
            revenueConfig.authType = this.authType;
            revenueConfig.isOpenRisk = this.isOpenRisk;
            revenueConfig.reportConfig = this.reportConfig;
            revenueConfig.appId = this.appId;
            return revenueConfig;
        }

        public RevenueConfigBuilder setAppId(int i2) {
            this.appId = i2;
            return this;
        }

        public RevenueConfigBuilder setAuthType(@NonNull int i2) {
            this.authType = i2;
            return this;
        }

        public RevenueConfigBuilder setClientVersion(@NonNull String str) {
            this.clientVer = str;
            return this;
        }

        public RevenueConfigBuilder setContext(@NonNull Context context) {
            this.mContext = context;
            return this;
        }

        public RevenueConfigBuilder setCountryCode(@NonNull String str) {
            this.countryCode = str;
            return this;
        }

        public RevenueConfigBuilder setCurrencyType(int i2) {
            this.currencyType = i2;
            return this;
        }

        public RevenueConfigBuilder setDataSender(@NonNull IRevenueDataSender iRevenueDataSender) {
            this.dataSender = iRevenueDataSender;
            return this;
        }

        public RevenueConfigBuilder setFunctionName(@NonNull String str) {
            this.functionName = str;
            return this;
        }

        public RevenueConfigBuilder setHttpUrl(@NonNull String str) {
            this.httpUrl = str;
            return this;
        }

        public RevenueConfigBuilder setIsOpenRisk(@NonNull boolean z) {
            this.isOpenRisk = z;
            return this;
        }

        public RevenueConfigBuilder setLanguage(@NonNull String str) {
            this.language = str;
            return this;
        }

        public RevenueConfigBuilder setPakageName(@NonNull String str) {
            this.pakageName = str;
            return this;
        }

        public RevenueConfigBuilder setProtoType(@NonNull ProtocolType protocolType) {
            this.protoType = protocolType;
            return this;
        }

        public RevenueConfigBuilder setReportConfig(@NonNull ReportConfig reportConfig) {
            this.reportConfig = reportConfig;
            return this;
        }

        public RevenueConfigBuilder setServiceName(@NonNull String str) {
            this.serviceName = str;
            return this;
        }

        public RevenueConfigBuilder setUid(long j) {
            this.uid = j;
            return this;
        }

        public RevenueConfigBuilder setUsedChannel(int i2) {
            this.usedChannel = i2;
            return this;
        }
    }

    public int getAppId() {
        return this.appId;
    }

    public int getAuthType() {
        return this.authType;
    }

    public String getClientVerion() {
        return this.clientVer;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public int getCurrencyType() {
        return this.currencyType;
    }

    public IRevenueDataSender getDataSender() {
        return this.dataSender;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public boolean getIsOpenRisk() {
        return this.isOpenRisk;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getPakageName() {
        return this.pakageName;
    }

    public ProtocolType getProtoType() {
        return this.protoType;
    }

    public ReportConfig getReportConfig() {
        return this.reportConfig;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public long getUid() {
        return this.uid;
    }

    public int getUsedChannel() {
        return this.usedChannel;
    }

    public Context getmContext() {
        return this.mContext;
    }

    public void setAppId(int i2) {
        this.appId = i2;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String toString() {
        return "RevenueConfig { uid=" + this.uid + " appId=" + this.appId + " usedChannel=" + this.usedChannel + " currencyType=" + this.currencyType + " clientVer=" + this.clientVer + " authType=" + this.authType + " }";
    }
}
