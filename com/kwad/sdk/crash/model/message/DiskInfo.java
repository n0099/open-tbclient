package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.q;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DiskInfo implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -154725647775465930L;
    public transient /* synthetic */ FieldHolder $fh;
    public double mDataAvailableGB;
    public double mDataTotalGB;
    public double mExternalStorageAvailableGB;
    public double mExternalStorageTotalGB;

    public DiskInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.mDataTotalGB = jSONObject.optDouble("mDataTotalGB");
        this.mDataAvailableGB = jSONObject.optDouble("mDataAvailableGB");
        this.mExternalStorageTotalGB = jSONObject.optDouble("mExternalStorageTotalGB");
        this.mExternalStorageAvailableGB = jSONObject.optDouble("mExternalStorageAvailableGB");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            q.a(jSONObject, "mDataTotalGB", this.mDataTotalGB);
            q.a(jSONObject, "mDataAvailableGB", this.mDataAvailableGB);
            q.a(jSONObject, "mExternalStorageTotalGB", this.mExternalStorageTotalGB);
            q.a(jSONObject, "mExternalStorageAvailableGB", this.mExternalStorageAvailableGB);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t总存储空间: ");
            sb.append(this.mDataTotalGB);
            sb.append(" (GB)\n");
            sb.append("\t可用存储空间: ");
            sb.append(this.mDataAvailableGB);
            sb.append(" (GB)\n");
            sb.append("\t总SD卡空间: ");
            sb.append(this.mExternalStorageTotalGB);
            sb.append(" (GB)\n");
            sb.append("\t可用SD卡空间: ");
            sb.append(this.mExternalStorageAvailableGB);
            sb.append(" (GB)\n");
            return sb.substring(0);
        }
        return (String) invokeV.objValue;
    }
}
