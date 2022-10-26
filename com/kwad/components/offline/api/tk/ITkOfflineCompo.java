package com.kwad.components.offline.api.tk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.SdkConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface ITkOfflineCompo extends IOfflineCompo {
    public static final String IMPL = "com.kwad.tachikoma.TkOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.tachikoma";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public final class TKState {
        public static final /* synthetic */ TKState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TKState READY;
        public static final TKState SO_FAIL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-131327700, "Lcom/kwad/components/offline/api/tk/ITkOfflineCompo$TKState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-131327700, "Lcom/kwad/components/offline/api/tk/ITkOfflineCompo$TKState;");
                    return;
                }
            }
            READY = new TKState("READY", 0);
            TKState tKState = new TKState("SO_FAIL", 1);
            SO_FAIL = tKState;
            $VALUES = new TKState[]{READY, tKState};
        }

        public TKState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TKState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TKState) Enum.valueOf(TKState.class, str) : (TKState) invokeL.objValue;
        }

        public static TKState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TKState[]) $VALUES.clone() : (TKState[]) invokeV.objValue;
        }
    }

    StyleTemplate findStyleTemplateFromConfigById(String str);

    String getJsBaseDir(Context context, String str);

    TKState getState();

    String getTKVersion();

    IOfflineCompoTachikomaView getView(Context context, String str, int i, int i2);

    void initReal(Context context, SdkConfig sdkConfig, ITkOfflineCompoInitConfig iTkOfflineCompoInitConfig);

    StyleTemplate loadTkFileByTemplateId(Context context, String str);

    void onConfigRefresh(Context context, JSONObject jSONObject);
}
