package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.pyramid.runtime.service.ServiceReference;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface o51 {
    public static final ServiceReference a = new ServiceReference("nad.core", "crius");

    Object a(JSONObject jSONObject);

    c61<View> b(@NonNull Context context);
}
