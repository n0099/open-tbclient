package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.aa4;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface mk1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, aa4.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull z03 z03Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, sf3<String> sf3Var);
}
