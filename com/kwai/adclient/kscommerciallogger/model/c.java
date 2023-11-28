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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d anC;
    public final BusinessType biz;
    public final String category;
    public final String eventId;
    public final JSONObject extraParam;
    public final JSONObject msg;
    public final SubBusinessType subBiz;
    public final String tag;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String aSB;
        public BusinessType aSC;
        public SubBusinessType aSD;
        public d aSE;
        public JSONObject aSF;
        public String aSG;
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
            this.aSB = str;
        }

        public final a gD(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mTag = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a gE(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.aSG = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a y(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
                this.msg = jSONObject;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public static a ML() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new a(ILoggerReporter.Category.ERROR_LOG);
            }
            return (a) invokeV.objValue;
        }

        public static a MM() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return new a(ILoggerReporter.Category.APM_LOG);
            }
            return (a) invokeV.objValue;
        }

        public final c MN() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (com.kwai.adclient.kscommerciallogger.a.MB().isDebug()) {
                    if (!TextUtils.isEmpty(this.aSB) && !TextUtils.isEmpty(this.mTag) && !TextUtils.isEmpty(this.aSG)) {
                        if (com.kwai.adclient.kscommerciallogger.a.MB().MD() && !com.kwai.adclient.kscommerciallogger.b.gC(this.aSG)) {
                            throw new IllegalArgumentException("event_id format error, please check it");
                        }
                    } else {
                        throw new IllegalArgumentException("param is error, please check it");
                    }
                } else if (TextUtils.isEmpty(this.aSB) || TextUtils.isEmpty(this.mTag) || TextUtils.isEmpty(this.aSG)) {
                    return null;
                } else {
                    if (com.kwai.adclient.kscommerciallogger.a.MB().MD() && !com.kwai.adclient.kscommerciallogger.b.gC(this.aSG)) {
                        return null;
                    }
                }
                if (com.kwai.adclient.kscommerciallogger.a.MB().MC() != null) {
                    this.aSF = com.kwai.adclient.kscommerciallogger.a.MB().MC();
                }
                return new c(this, (byte) 0);
            }
            return (c) invokeV.objValue;
        }

        public final a b(BusinessType businessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, businessType)) == null) {
                this.aSC = businessType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(SubBusinessType subBusinessType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, subBusinessType)) == null) {
                this.aSD = subBusinessType;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public final a b(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
                this.aSE = dVar;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c(a aVar) {
        JSONObject jSONObject;
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
        this.category = aVar.aSB;
        this.biz = aVar.aSC;
        this.subBiz = aVar.aSD;
        this.tag = aVar.mTag;
        this.anC = aVar.aSE;
        this.extraParam = aVar.aSF;
        this.eventId = aVar.aSG;
        if (aVar.msg != null) {
            jSONObject = aVar.msg;
        } else {
            jSONObject = new JSONObject();
        }
        this.msg = jSONObject;
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final String ME() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.category;
        }
        return (String) invokeV.objValue;
    }

    public final BusinessType MF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.biz;
        }
        return (BusinessType) invokeV.objValue;
    }

    public final SubBusinessType MG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.subBiz;
        }
        return (SubBusinessType) invokeV.objValue;
    }

    public final d MH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.anC;
        }
        return (d) invokeV.objValue;
    }

    public final JSONObject MI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.msg;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject MJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.extraParam;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final String MK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.eventId;
        }
        return (String) invokeV.objValue;
    }

    public final String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.tag;
        }
        return (String) invokeV.objValue;
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.biz != null) {
                    jSONObject.put("biz", this.biz.value);
                }
                if (this.subBiz != null) {
                    jSONObject.put("sub_biz", this.subBiz.value);
                }
                jSONObject.put("tag", this.tag);
                if (this.anC != null) {
                    jSONObject.put("type", this.anC.getValue());
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
