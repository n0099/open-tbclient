package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.i84;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface ui1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, i84.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull hz2 hz2Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, ae3<String> ae3Var);
}
