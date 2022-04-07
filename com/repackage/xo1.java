package com.repackage;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xo1 extends mo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xo1 b;

        public a(xo1 xo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xo1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i, intent)) == null) {
                this.b.d(this.a, new js1(0));
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xo1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.mo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "File" : (String) invokeV.objValue;
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FileApi" : (String) invokeV.objValue;
    }

    public final String x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0) {
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
                return !TextUtils.isEmpty(contentTypeFor) ? contentTypeFor : "*/*";
            }
            return "*/*";
        }
        return (String) invokeL.objValue;
    }

    public js1 y(String str) {
        InterceptResult invokeL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#shareFile", false);
            if (n()) {
                jx1.c("FileApi", "FileApi does not supported when app is invisible.");
                return new js1(1001, "FileApi does not supported when app is invisible.");
            }
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("filePath");
                String M = r73.M(optString, j03.f0());
                if (!TextUtils.isEmpty(optString) && r73.s(optString) == PathType.BD_FILE && !TextUtils.isEmpty(M)) {
                    String optString2 = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString2)) {
                        jx1.c("FileApi", "cb is required");
                        return new js1(202, "cb is required");
                    }
                    File file = new File(M);
                    if (file.exists() && !file.isDirectory()) {
                        SwanAppActivity activity = wl2.U().getActivity();
                        if (activity == null) {
                            jx1.c("FileApi", "activity null");
                            return new js1(1001, "activity null");
                        }
                        ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                        Intent intent = new Intent();
                        if (qc3.i()) {
                            fromFile = ge3.a(activity, file);
                            intent.setFlags(3);
                        } else {
                            fromFile = Uri.fromFile(file);
                        }
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.STREAM", fromFile);
                        intent.setType(x(M));
                        resultDispatcher.addConsumer(new a(this, optString2));
                        resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                        return js1.f();
                    }
                    jx1.c("FileApi", "file not exists");
                    return new js1(1001, "file not exists");
                }
                jx1.c("FileApi", "a valid filePath is required");
                return new js1(202, "a valid filePath is required");
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }
}
