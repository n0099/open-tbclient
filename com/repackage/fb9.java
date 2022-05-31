package com.repackage;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.NumberUtils;
import com.repackage.ib9;
import com.repackage.kb9;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int b;
    public int c;
    public final Set<Ssp> d;
    public final Set<kb9> e;
    public final Set<ib9> f;

    public fb9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashSet();
    }

    public final void a() {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long j = this.a;
            int i = this.b;
            int i2 = this.c;
            za9 za9Var = new za9(this.d, this.e, this.f);
            Object obj = lb9.a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                za9Var.srzable(objectOutputStream);
                objectOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                bArr = null;
            }
            String encodeToString = bArr != null ? Base64.encodeToString(bArr, 0) : null;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(encodeToString == null ? -1 : encodeToString.length());
            LogPrinter.v("sspsUTF len:%d", objArr);
            lb9.b.edit().putLong("key_config_v", j).putInt("key_config_interval", i).putInt("key_V", i2).putString("key_adcfg", encodeToString).apply();
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                c(str);
                LogPrinter.v("Config cfgv:%d parsed over.", Long.valueOf(this.a));
                if (d()) {
                    a();
                    LogPrinter.v("Config cfgv:%d persisted over.", Long.valueOf(this.a));
                    return true;
                }
            } catch (JSONException e) {
                LogPrinter.e(e);
            }
            this.d.clear();
            this.e.clear();
            this.f.clear();
            return false;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public void c(String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            this.a = NumberUtils.adjustLong(jSONObject2.getLong("ver"), 0L);
            this.b = NumberUtils.adjustInt(jSONObject2.getInt("interval"), 1, 1440);
            this.c = NumberUtils.adjustInt(jSONObject2.optInt("V", 1), 1);
            JSONObject jSONObject3 = jSONObject.getJSONObject("adConfig");
            JSONArray jSONArray = jSONObject3.getJSONArray("ssps");
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                Ssp ssp = new Ssp(jSONArray.getJSONObject(i));
                for (Ssp.Pid pid : ssp.pids) {
                    hashMap.put(Long.valueOf(pid.id), pid);
                }
                this.d.add(ssp);
            }
            JSONArray jSONArray2 = jSONObject3.getJSONArray("sids");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                this.e.add(new kb9(jSONArray2.getJSONObject(i2), hashMap));
            }
            if (this.c < 2 || (optJSONArray = jSONObject3.optJSONArray("serialSids")) == null) {
                return;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                this.f.add(new ib9(optJSONArray.getJSONObject(i3), hashMap));
            }
        }
    }

    @VisibleForTesting
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (Ssp ssp : this.d) {
                if (hashSet.contains(ssp.type)) {
                    LogPrinter.e("Duplicate ssp:type(%s) found.", ssp.type);
                    return false;
                }
                hashSet.add(ssp.type);
                for (Ssp.Pid pid : ssp.pids) {
                    if (hashSet2.contains(Long.valueOf(pid.id))) {
                        LogPrinter.e("Duplicate pid(%d) found.", Long.valueOf(pid.id));
                        return false;
                    }
                    hashSet2.add(Long.valueOf(pid.id));
                }
            }
            HashSet hashSet3 = new HashSet();
            for (kb9 kb9Var : this.e) {
                if (hashSet3.contains(kb9Var.a)) {
                    LogPrinter.e("Duplicate sid(%s) found in SlotId", kb9Var.a);
                    return false;
                }
                hashSet3.add(kb9Var.a);
                for (kb9.c cVar : kb9Var.e) {
                    HashSet hashSet4 = new HashSet();
                    for (kb9.b bVar : cVar.b) {
                        if (!hashSet2.contains(Long.valueOf(bVar.a))) {
                            LogPrinter.e("Unregistered adId:(%d) in SlotId", Long.valueOf(bVar.a));
                            return false;
                        } else if (hashSet4.contains(Long.valueOf(bVar.a))) {
                            LogPrinter.e("Duplicate adId:(%d) found in one sid:(%s) in SlotId", Long.valueOf(bVar.a), kb9Var.a);
                            return false;
                        } else {
                            hashSet4.add(Long.valueOf(bVar.a));
                        }
                    }
                }
            }
            if (this.c == 2) {
                for (ib9 ib9Var : this.f) {
                    if (hashSet3.contains(ib9Var.a)) {
                        LogPrinter.e("Duplicate sid(%s) found in SerialSlotId.", ib9Var.a);
                        return false;
                    }
                    hashSet3.add(ib9Var.a);
                    for (ib9.b bVar2 : ib9Var.b) {
                        for (ib9.a aVar : bVar2.b) {
                            if (!hashSet2.contains(Long.valueOf(aVar.a))) {
                                LogPrinter.e("Unregistered adId:(%d) in SerialSlotId", Long.valueOf(aVar.a));
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
