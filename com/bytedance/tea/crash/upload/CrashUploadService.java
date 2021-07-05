package com.bytedance.tea.crash.upload;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.tea.crash.c;
import d.b.c.b.c.a.a;
import d.b.c.b.l;
import d.b.c.b.n.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CrashUploadService extends IntentService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrashUploadService() {
        super("CrashUploadService");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private e a(String str, String str2, String str3, c cVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, this, str, str2, str3, cVar)) == null) {
            if (cVar == null) {
                return new e(201);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("upload_scene", "new_process");
                str2 = jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (cVar == c.f32270c) {
                return b.c(str, str2, str3);
            }
            if (cVar == c.f32268a) {
                return b.b(str, str2);
            }
            return b.d(str, str2, b.g());
        }
        return (e) invokeLLLL.objValue;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDestroy();
            System.exit(0);
        }
    }

    @Override // android.app.IntentService
    public void onHandleIntent(@Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent) == null) || intent == null) {
            return;
        }
        c cVar = intent.hasExtra("crash_type") ? (c) intent.getSerializableExtra("crash_type") : null;
        String stringExtra = intent.getStringExtra("upload_url");
        String stringExtra2 = intent.getStringExtra("crash_json_value");
        String stringExtra3 = intent.getStringExtra("crash_info_file_path");
        String stringExtra4 = intent.getStringExtra("crash_dump_file_path");
        d.b.c.b.c.b.a().b(getApplication());
        if (TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra) || d.b.c.b.c.b.a().d(stringExtra3) || !a(stringExtra, stringExtra2, stringExtra4, cVar).a()) {
            return;
        }
        if (cVar == c.f32270c) {
            if (l.e.g(new File(stringExtra3).getParentFile(), true)) {
                return;
            }
            d.b.c.b.c.b.a().c(a.a(stringExtra3));
        } else if (TextUtils.isEmpty(stringExtra3) || l.e.h(stringExtra3)) {
        } else {
            d.b.c.b.c.b.a().c(a.a(stringExtra3));
        }
    }
}
