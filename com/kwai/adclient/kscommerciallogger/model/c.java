package com.kwai.adclient.kscommerciallogger.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.qq.e.comm.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d ase;
    public final BusinessType biz;
    public final String category;
    public final String eventId;
    public final JSONObject extraParam;
    public final JSONObject msg;
    public final SubBusinessType subBiz;
    public final String tag;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String asf;
        public BusinessType asg;
        public SubBusinessType ash;
        public d asi;
        public JSONObject asj;
        public String ask;
        public String mTag;
        public JSONObject msg;

        public a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.asf = str;
        }

        public static a BO() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a(ILoggerReporter.Category.ERROR_LOG) : (a) invokeV.objValue;
        }

        public static a BP() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a(ILoggerReporter.Category.APM_LOG) : (a) invokeV.objValue;
        }

        public final c BQ() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.BE().isDebug()) {
                    if (TextUtils.isEmpty(this.asf) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.ask)) {
                        throw new IllegalArgumentException("param is error, please check it");
                    }
                    if (com.kwai.adclient.kscommerciallogger.a.BE().BG() && !com.kwai.adclient.kscommerciallogger.b.ek(this.ask)) {
                        throw new IllegalArgumentException("event_id format error, please check it");
                    }
                } else if (TextUtils.isEmpty(this.asf) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.ask)) {
                    return null;
                } else {
                    if (com.kwai.adclient.kscommerciallogger.a.BE().BG() && !com.kwai.adclient.kscommerciallogger.b.ek(this.ask)) {
                        return null;
                    }
                }
                if (com.kwai.adclient.kscommerciallogger.a.BE().BF() != null) {
                    this.asj = com.kwai.adclient.kscommerciallogger.a.BE().BF();
                }
                return new c(this, (byte) 0);
            }
            return (c) invokeV.objValue;
        }

        public final a a(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessType)) == null) {
                this.asg = businessType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(SubBusinessType subBusinessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subBusinessType)) == null) {
                this.ash = subBusinessType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
                this.asi = dVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a el(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mTag = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a em(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.ask = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a l(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
                this.msg = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.category = aVar.asf;
        this.biz = aVar.asg;
        this.subBiz = aVar.ash;
        this.tag = aVar.mTag;
        this.ase = aVar.asi;
        this.msg = aVar.msg;
        this.extraParam = aVar.asj;
        this.eventId = aVar.ask;
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String BH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.category : (String) invokeV.objValue;
    }

    public final BusinessType BI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.biz : (BusinessType) invokeV.objValue;
    }

    public final SubBusinessType BJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.subBiz : (SubBusinessType) invokeV.objValue;
    }

    public final d BK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ase : (d) invokeV.objValue;
    }

    public final JSONObject BL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.msg : (JSONObject) invokeV.objValue;
    }

    public final JSONObject BM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.extraParam : (JSONObject) invokeV.objValue;
    }

    public final String BN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.eventId : (String) invokeV.objValue;
    }

    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tag : (String) invokeV.objValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.biz != null) {
                    jSONObject.put(Constants.KEYS.BIZ, this.biz.value);
                }
                if (this.subBiz != null) {
                    jSONObject.put("sub_biz", this.subBiz.value);
                }
                jSONObject.put("tag", this.tag);
                if (this.ase != null) {
                    jSONObject.put("type", this.ase.getValue());
                }
                if (this.msg != null) {
                    jSONObject.put("msg", this.msg);
                }
                if (this.extraParam != null) {
                    jSONObject.put("extra_param", this.extraParam);
                }
                jSONObject.put("event_id", this.eventId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
