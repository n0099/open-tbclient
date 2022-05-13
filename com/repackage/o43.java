package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o43 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ u03 c;
        public final /* synthetic */ o43 d;

        /* renamed from: com.repackage.o43$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0476a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ a b;

            public RunnableC0476a(a aVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.d.o(this.a, aVar.a, aVar.b, aVar.c);
                }
            }
        }

        public a(o43 o43Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o43Var, unitedSchemeEntity, callbackHandler, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o43Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = u03Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bitmap y = le3.y();
                if (y == null) {
                    this.d.n(this.a, this.b, "can't get screenshot");
                } else {
                    od3.k(new RunnableC0476a(this, y), "savescreenshot");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o43(r13 r13Var) {
        super(r13Var, "/swanAPI/getScreenshot");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (u03Var == null) {
                ux1.c("Screenshot", "illegal swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            }
            String optString = ud3.d(unitedSchemeEntity.getParam("params")).optString("name");
            this.c = optString;
            if (TextUtils.isEmpty(optString)) {
                ux1.c("Screenshot", "invalid params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            m(unitedSchemeEntity, callbackHandler, u03Var);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject l(boolean z, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), str, str2})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.c);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("message", str2);
                }
                if (z) {
                    jSONObject.put("path", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void m(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull u03 u03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, u03Var) == null) {
            oe3.e0(new a(this, unitedSchemeEntity, callbackHandler, u03Var));
        }
    }

    public final void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, str) == null) {
            ux1.c("Screenshot", str);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(false, null, str), 0));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00ba */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00dd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0077 */
    public final void o(@NonNull Bitmap bitmap, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull u03 u03Var) {
        String x;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048580, this, bitmap, unitedSchemeEntity, callbackHandler, u03Var) == null) || (x = c83.x(u03Var.b)) == null) {
            return;
        }
        String str = x + File.separator + StatisticConstants.SCREENSHOT;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            if (!file.mkdir()) {
                n(unitedSchemeEntity, callbackHandler, "mkdir fail");
                return;
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        String str2 = str + File.separator + simpleDateFormat.format(new Date()) + this.c + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (IOException e) {
                    e.printStackTrace();
                    n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            String str3 = "save screenshot to " + str2;
            ux1.i("Screenshot", str3);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(l(true, c83.J(str2, u03Var.b), "success"), 0));
            fileOutputStream.close();
            fileOutputStream2 = str3;
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
                fileOutputStream2 = fileOutputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    n(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                }
            }
            throw th;
        }
    }
}
