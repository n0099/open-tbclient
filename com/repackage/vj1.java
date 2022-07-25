package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.repackage.j94;
import okhttp3.Callback;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface vj1 {
    void d(byte[] bArr);

    <T> void e(String str, String str2, ResponseCallback<T> responseCallback);

    void f(String str, String str2, j94.c cVar);

    boolean g(String str);

    boolean h();

    boolean i(@NonNull i03 i03Var, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, bf3<String> bf3Var);
}
