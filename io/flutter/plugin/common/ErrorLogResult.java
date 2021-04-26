package io.flutter.plugin.common;

import android.util.Log;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes7.dex */
public class ErrorLogResult implements MethodChannel.Result {
    public int level;
    public String tag;

    public ErrorLogResult(String str) {
        this(str, 5);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void error(String str, @Nullable String str2, @Nullable Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = "";
        }
        int i2 = this.level;
        if (i2 < 5) {
            return;
        }
        Log.println(i2, this.tag, str2 + str3);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void notImplemented() {
        int i2 = this.level;
        if (i2 < 5) {
            return;
        }
        Log.println(i2, this.tag, "method not implemented");
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void success(@Nullable Object obj) {
    }

    public ErrorLogResult(String str, int i2) {
        this.tag = str;
        this.level = i2;
    }
}
