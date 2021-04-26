package com.bytedance.sdk.openadsdk.preload.geckox.model;

import androidx.annotation.Keep;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes5.dex */
public class CheckRequestBodyModel {
    @c(a = "common")

    /* renamed from: common  reason: collision with root package name */
    public Common f30921common;
    @c(a = SchedulerSupport.CUSTOM)
    public Map<String, Map<String, Object>> custom;
    @c(a = "deployment")
    public Map<String, List<ChannelInfo>> deployment;
    @c(a = "deployments")
    public Map<String, Object> deployments;
    @c(a = "local")
    public Map<String, Map<String, LocalChannel>> local;

    @Keep
    /* loaded from: classes5.dex */
    public static class Channel {
        @c(a = "c")
        public String channelName;
        @c(a = "l_v")
        public String localVersion;

        public Channel(String str) {
            this.channelName = str;
        }
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class ChannelInfo {
        @c(a = "channel")
        public String channel;
        @c(a = "local_version")
        public long localVersion;

        public ChannelInfo(String str, long j) {
            this.channel = str;
            this.localVersion = j;
        }
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class Channels {
        @c(a = "channels")
        public List<Channel> channels = new ArrayList();
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class Group {
        @c(a = "group_name")
        public String groupName;
        @c(a = "target_channels")
        public List<TargetChannel> targetChannels;
    }

    @Keep
    /* loaded from: classes5.dex */
    public enum GroupType {
        NORMAL("normal"),
        HIGHPRIORITY("high_priority");
        
        public String value;

        GroupType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class LocalChannel {
        @c(a = "l_v")
        public Long localVersion;
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class ProcessorParams {
        @c(a = "domain")
        public String domain;
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class TargetChannel {
        @c(a = "c")
        public String channelName;
        @c(a = "t_v")
        public Long targetVersion;

        public TargetChannel() {
        }

        public TargetChannel(String str) {
            this.channelName = str;
        }

        public TargetChannel(String str, Long l) {
            this.channelName = str;
            this.targetVersion = l;
        }
    }

    public void putChannelInfo(String str, List<ChannelInfo> list) {
        if (this.deployment == null) {
            this.deployment = new HashMap();
        }
        this.deployment.put(str, list);
    }

    public void setCommon(Common common2) {
        this.f30921common = common2;
    }

    public void setCustom(Map<String, Map<String, Object>> map) {
        this.custom = map;
    }

    public void setDeployments(Map<String, Object> map) {
        this.deployments = map;
    }

    public void setLocal(Map<String, Map<String, LocalChannel>> map) {
        this.local = map;
    }
}
