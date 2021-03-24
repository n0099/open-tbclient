package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import com.baidu.mobads.production.cpu.CPUWebAdRequestParam;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class SettingsChannel {
    public static final String ALWAYS_USE_24_HOUR_FORMAT = "alwaysUse24HourFormat";
    public static final String CHANNEL_NAME = "flutter/settings";
    public static final String PLATFORM_BRIGHTNESS = "platformBrightness";
    public static final String TAG = "SettingsChannel";
    public static final String TEXT_SCALE_FACTOR = "textScaleFactor";
    @NonNull
    public final BasicMessageChannel<Object> channel;

    /* loaded from: classes7.dex */
    public static class MessageBuilder {
        @NonNull
        public final BasicMessageChannel<Object> channel;
        @NonNull
        public Map<String, Object> message = new HashMap();

        public MessageBuilder(@NonNull BasicMessageChannel<Object> basicMessageChannel) {
            this.channel = basicMessageChannel;
        }

        public void send() {
            Log.v(SettingsChannel.TAG, "Sending message: \ntextScaleFactor: " + this.message.get(SettingsChannel.TEXT_SCALE_FACTOR) + "\nalwaysUse24HourFormat: " + this.message.get(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT) + "\nplatformBrightness: " + this.message.get(SettingsChannel.PLATFORM_BRIGHTNESS));
            this.channel.send(this.message);
        }

        @NonNull
        public MessageBuilder setPlatformBrightness(@NonNull PlatformBrightness platformBrightness) {
            this.message.put(SettingsChannel.PLATFORM_BRIGHTNESS, platformBrightness.name);
            return this;
        }

        @NonNull
        public MessageBuilder setTextScaleFactor(float f2) {
            this.message.put(SettingsChannel.TEXT_SCALE_FACTOR, Float.valueOf(f2));
            return this;
        }

        @NonNull
        public MessageBuilder setUse24HourFormat(boolean z) {
            this.message.put(SettingsChannel.ALWAYS_USE_24_HOUR_FORMAT, Boolean.valueOf(z));
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public enum PlatformBrightness {
        light(CPUWebAdRequestParam.LIGHT_MODE),
        dark("dark");
        
        @NonNull
        public String name;

        PlatformBrightness(@NonNull String str) {
            this.name = str;
        }
    }

    public SettingsChannel(@NonNull DartExecutor dartExecutor) {
        this.channel = new BasicMessageChannel<>(dartExecutor, CHANNEL_NAME, JSONMessageCodec.INSTANCE);
    }

    @NonNull
    public MessageBuilder startMessage() {
        return new MessageBuilder(this.channel);
    }
}
