package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.v94;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface hk1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, v94.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull u03 u03Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, nf3<String> nf3Var);
}
