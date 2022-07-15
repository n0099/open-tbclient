package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes7.dex */
public class wd7 implements ud7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yd7 a;
    public List<ICardInfo> b;
    public String c;
    public String d;
    public String e;
    public List<xd7> f;
    public boolean g;
    public int h;
    public String i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;

    public wd7(yd7 yd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yd7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.h = 1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.a = yd7Var;
    }

    @Override // com.repackage.ud7
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.g : invokeV.booleanValue;
    }

    @Override // com.repackage.ud7
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : invokeV.intValue;
    }

    @Override // com.repackage.ud7
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<ICardInfo> list = this.b;
            return list != null && list.size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ud7
    public void d(boolean z, Message message, boolean z2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Integer.valueOf(i)}) == null) {
            if (z) {
                this.l = true;
            } else {
                this.k = true;
            }
            DataRes dataRes = (DataRes) message;
            if (dataRes == null) {
                return;
            }
            this.g = dataRes.has_more.intValue() == 1;
            if (!TextUtils.isEmpty(dataRes.page_info)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.page_info);
                    JSONObject optJSONObject = jSONObject.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.c = optJSONObject.optString("name");
                        this.d = optJSONObject.optString("url");
                        this.e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f == null) {
                            this.f = new ArrayList();
                        } else {
                            this.f.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                xd7 xd7Var = new xd7();
                                xd7Var.b(optJSONObject2);
                                if (xd7Var.a()) {
                                    this.f.add(xd7Var);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (dataRes.cards != null) {
                for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                    ICardInfo i4 = uc7.i(dataRes.cards.get(i3));
                    if (i4 != null && i4.isValid()) {
                        arrayList.add(i4);
                    }
                    if (i3 == dataRes.cards.size() - 1 && i4 != null) {
                        p(i4.getFlipId());
                    }
                }
            }
            if (z2) {
                this.b.addAll(arrayList);
                this.h = i;
                return;
            }
            this.h = 1;
            this.b = arrayList;
        }
    }

    @Override // com.repackage.ud7
    public List<ICardInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public List<xd7> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.intValue;
    }

    public yd7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : (yd7) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.i = str;
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.j = i;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("page_info");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, optString));
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.c = optJSONObject.optString("name");
                        this.d = optJSONObject.optString("url");
                        this.e = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.f == null) {
                            this.f = new ArrayList();
                        } else {
                            this.f.clear();
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                xd7 xd7Var = new xd7();
                                xd7Var.b(optJSONObject2);
                                if (xd7Var.a()) {
                                    this.f.add(xd7Var);
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ICardInfo i3 = uc7.i(optJSONArray2.getString(i2));
                        if (i3 != null && i3.isValid()) {
                            arrayList.add(i3);
                        }
                        if (i2 == optJSONArray2.length() - 1 && i3 != null) {
                            p(i3.getFlipId());
                        }
                    }
                }
                this.b = arrayList;
                if (c()) {
                    this.m = true;
                } else {
                    this.m = false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
