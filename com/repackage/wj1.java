package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.k94;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface wj1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, k94.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull j03 j03Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, cf3<String> cf3Var);
}
