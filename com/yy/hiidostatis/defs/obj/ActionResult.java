package com.yy.hiidostatis.defs.obj;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import com.yy.hiidostatis.inner.util.log.L;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ActionResult implements IJsonSerialize {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, String> moreinfo;
    public long reqTime;
    public String ret;
    public long rtime;
    public int scode;
    public String uri;

    public ActionResult(int i2, String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Long.valueOf(j), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.scode = i2;
        this.uri = str;
        this.reqTime = j;
        this.ret = str2;
        this.rtime = System.currentTimeMillis();
    }

    @Override // com.yy.hiidostatis.defs.obj.IJsonSerialize
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scode", this.scode);
                jSONObject.put("uri", URLEncoder.encode(this.uri, "utf-8"));
                jSONObject.put("reqtime", this.reqTime);
                jSONObject.put(Constants.KEYS.RET, URLEncoder.encode(this.ret, "utf-8"));
                jSONObject.put("rtime", this.rtime);
                if (this.moreinfo != null && !this.moreinfo.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : this.moreinfo.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put("moreinfo", jSONObject2);
                }
                return jSONObject;
            } catch (Exception e2) {
                L.debug(this, e2.getMessage(), new Object[0]);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionResult(int i2, String str, long j, String str2, Map<String, String> map) {
        this(i2, str, j, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {Integer.valueOf(i2), str, Long.valueOf(j), str2, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], ((Long) objArr2[2]).longValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.moreinfo = map;
    }
}
