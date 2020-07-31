package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes12.dex */
public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public ErrorLogResult(String str) {
        this(str, 5);
    }

    public ErrorLogResult(String str, int i) {
        this.tag = str;
        this.level = i;
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void success(@Nullable Object obj) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void error(String str, @Nullable String str2, @Nullable Object obj) {
        String str3 = obj != null ? " details: " + obj : "";
        if (this.level >= 5) {
            Log.println(this.level, this.tag, str2 + str3);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void notImplemented() {
        if (this.level >= 5) {
            Log.println(this.level, this.tag, "method not implemented");
        }
    }
}
