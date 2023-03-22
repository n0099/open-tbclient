package com.yy.mobile.framework.revenuesdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.data.IRevenueDataSender;
/* loaded from: classes9.dex */
public class RevenueConfig {
    public int appId;
    public String appName;
    public int authType;
    public String clientVer;
    public int currencyType;
    public IRevenueDataSender dataSender;
    public String deviceId;
    public Context mContext;
    public String pakageName;
    public ProtocolType protoType;
    public long uid;
    public int usedChannel;

    /* loaded from: classes9.dex */
    public static final class RevenueConfigBuilder {
        public IRevenueDataSender dataSender;
        public Context mContext;
        public long uid = 0;
        public int usedChannel = 0;
        public int currencyType = 0;
        public String pakageName = "";
        public String clientVer = "";
        public String appName = "";
        public String deviceId = "";
        public ProtocolType protoType = ProtocolType.SERVICE;
        public int authType = 4;
        public int appId = 0;

        public static RevenueConfigBuilder aRevenueConfig() {
            return new RevenueConfigBuilder();
        }

        public RevenueConfig build() {
            RevenueConfig revenueConfig = new RevenueConfig();
            revenueConfig.currencyType = this.currencyType;
            revenueConfig.dataSender = this.dataSender;
            revenueConfig.usedChannel = this.usedChannel;
            revenueConfig.uid = this.uid;
            revenueConfig.mContext = this.mContext;
            revenueConfig.pakageName = this.pakageName;
            revenueConfig.clientVer = this.clientVer;
            revenueConfig.protoType = this.protoType;
            revenueConfig.authType = this.authType;
            revenueConfig.appId = this.appId;
            revenueConfig.appName = this.appName;
            revenueConfig.deviceId = this.deviceId;
            return revenueConfig;
        }

        public RevenueConfigBuilder setAppId(int i) {
            this.appId = i;
            return this;
        }

        public RevenueConfigBuilder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public RevenueConfigBuilder setAuthType(@NonNull int i) {
            this.authType = i;
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

        public RevenueConfigBuilder setCurrencyType(int i) {
            this.currencyType = i;
            return this;
        }

        public RevenueConfigBuilder setDataSender(@NonNull IRevenueDataSender iRevenueDataSender) {
            this.dataSender = iRevenueDataSender;
            return this;
        }

        public RevenueConfigBuilder setDeviceId(String str) {
            this.deviceId = str;
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

        public RevenueConfigBuilder setUid(long j) {
            this.uid = j;
            return this;
        }

        public RevenueConfigBuilder setUsedChannel(int i) {
            this.usedChannel = i;
            return this;
        }
    }

    public int getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
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

    public int getCurrencyType() {
        return this.currencyType;
    }

    public IRevenueDataSender getDataSender() {
        return this.dataSender;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getPakageName() {
        return this.pakageName;
    }

    public ProtocolType getProtoType() {
        return this.protoType;
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

    public void setAppId(int i) {
        this.appId = i;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String toString() {
        return "RevenueConfig { appId=" + this.appId + " usedChannel=" + this.usedChannel + " deviceId=" + this.deviceId + " currencyType=" + this.currencyType + " clientVer=" + this.clientVer + " authType=" + this.authType + " appName=" + this.appName + "}";
    }
}
