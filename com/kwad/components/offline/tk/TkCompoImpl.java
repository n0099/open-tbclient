package com.kwad.components.offline.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.offline.init.DefaultOfflineCompo;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaView;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.tk.kwai.d;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.h;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class TkCompoImpl extends DefaultOfflineCompo implements com.kwad.components.core.offline.api.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ITkOfflineCompo mOfflineCompo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TkCompoImpl(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        super(iTkOfflineCompo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iTkOfflineCompo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((IOfflineCompo) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOfflineCompo = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public StyleTemplate findStyleTemplateFromConfigById(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.mOfflineCompo.findStyleTemplateFromConfigById(str) : (StyleTemplate) invokeL.objValue;
    }

    @Override // com.kwad.sdk.components.a
    public Class getComponentsType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TkCompoImpl.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public String getJsBaseDir(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) ? this.mOfflineCompo.getJsBaseDir(context, str) : (String) invokeLL.objValue;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public ITkOfflineCompo.TKState getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOfflineCompo.getState() : (ITkOfflineCompo.TKState) invokeV.objValue;
    }

    public String getTKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mOfflineCompo.getTKVersion() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public h getView(Context context, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048581, this, context, str, i, i2)) == null) {
            IOfflineCompoTachikomaView view2 = this.mOfflineCompo.getView(context, str, i, i2);
            if (view2 == null) {
                return null;
            }
            return new d(view2);
        }
        return (h) invokeLLII.objValue;
    }

    @Override // com.kwad.components.core.offline.init.DefaultOfflineCompo, com.kwad.sdk.components.a
    public void init(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, sdkConfig) == null) {
        }
    }

    @Override // com.kwad.components.core.offline.api.kwai.a
    public StyleTemplate loadTkFileByTemplateId(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, context, str)) == null) ? this.mOfflineCompo.loadTkFileByTemplateId(context, str) : (StyleTemplate) invokeLL.objValue;
    }

    public void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mOfflineCompo.onConfigRefresh(context, jSONObject);
    }
}
