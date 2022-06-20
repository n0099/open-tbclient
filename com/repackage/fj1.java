package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.t84;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface fj1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, t84.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull sz2 sz2Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, le3<String> le3Var);
}
