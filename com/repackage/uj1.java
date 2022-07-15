package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.i94;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface uj1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, i94.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull h03 h03Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, af3<String> af3Var);
}
