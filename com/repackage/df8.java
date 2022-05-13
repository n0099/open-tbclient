package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class df8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ArrayList<ef8> B;
    public ArrayList<ef8> C;
    public ArrayList<ef8> D;
    public HashMap<String, ef8> E;
    public bf8 F;
    public int G;
    public gf8 H;
    public lf8 I;
    public BlockPopInfoData J;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public int k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    public int u;
    public String v;
    public String w;
    public int x;
    public boolean y;
    public int z;

    /* loaded from: classes5.dex */
    public class a implements Comparator<ef8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(df8 df8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {df8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ef8 ef8Var, ef8 ef8Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ef8Var, ef8Var2)) == null) ? ef8Var2.i() - ef8Var.i() : invokeLL.intValue;
        }
    }

    public df8() {
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
        this.b = "0";
        this.B = new ArrayList<>();
        this.C = new ArrayList<>();
        this.D = new ArrayList<>();
        this.E = new HashMap<>();
        this.F = new bf8();
        this.H = new gf8();
        this.I = new lf8();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            gf8 gf8Var = this.H;
            if (gf8Var == null) {
                return false;
            }
            return !StringUtils.isNull(gf8Var.a);
        }
        return invokeV.booleanValue;
    }

    public void D(if8 if8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, if8Var) == null) {
            this.z = 0;
            this.A = 0;
            ArrayList<jf8> d = if8Var.d();
            int size = d.size();
            for (int i = 0; i < size; i++) {
                jf8 jf8Var = d.get(i);
                ef8 ef8Var = this.E.get(jf8Var.c() + "");
                if (ef8Var != null) {
                    if (jf8Var.e() != 0) {
                        this.z++;
                        ef8Var.r(1);
                        ef8Var.o(jf8Var.d());
                        ef8Var.q(jf8Var.a());
                        ef8Var.u(true);
                        ef8Var.s(false);
                        ef8Var.t(false);
                        c(ef8Var);
                    } else {
                        this.A++;
                        ef8Var.u(false);
                        ef8Var.s(true);
                        ef8Var.t(false);
                        ef8Var.p(jf8Var.b().b());
                    }
                }
            }
            b();
            a(true);
        }
    }

    public void E(SignData signData) {
        ef8 ef8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, signData) == null) || signData == null || (ef8Var = this.E.get(signData.forumId)) == null) {
            return;
        }
        ef8Var.r(1);
        ef8Var.o(signData.count_sign_num);
        ef8Var.q(signData.sign_bonus_point);
        ef8Var.u(true);
        ef8Var.s(false);
        ef8Var.t(false);
        c(ef8Var);
        b();
        a(true);
    }

    public void F(JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.F.c(jSONObject.optJSONObject("error"));
        this.a = jSONObject.optInt("level", 7);
        this.b = jSONObject.optString("sign_new");
        this.c = jSONObject.optString("title");
        this.d = jSONObject.optString("text_pre");
        this.e = jSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR);
        this.f = jSONObject.optString("text_mid");
        this.g = jSONObject.optString("text_suf");
        this.h = jSONObject.optString("num_notice");
        this.i = jSONObject.optInt("show_dialog");
        this.j = jSONObject.optString("sign_notice");
        this.k = jSONObject.optInt("valid", 0);
        this.G = jSONObject.optInt("sign_max_num", 50);
        this.u = jSONObject.optInt("can_use", 0);
        this.w = jSONObject.optString("content");
        this.v = jSONObject.optString("button_content");
        JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
        if (optJSONObject != null) {
            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
            this.J = blockPopInfoData;
            blockPopInfoData.block_info = optJSONObject.optString("block_content");
            this.J.ahead_info = optJSONObject.optString("block_confirm");
            this.J.ahead_url = optJSONObject.optString("block_dealurl");
            this.J.ok_info = optJSONObject.optString("block_cancel");
            this.J.appeal_status = optJSONObject.optInt("appeal_status");
            this.J.appeal_msg = optJSONObject.optString("appeal_msg");
        }
        if (this.u == 1) {
            this.l = true;
        } else {
            this.l = false;
        }
        this.r = this.a + this.c;
        this.q = "1-" + (this.a - 1) + TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f117e);
        kf8.o = this.G;
        JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
        if (optJSONArray != null) {
            int min = Math.min(optJSONArray.length(), kf8.o);
            for (int i = 0; i < min; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    ef8 ef8Var = new ef8();
                    ef8Var.n(jSONObject2);
                    if (ef8Var.f() == 0) {
                        if (this.k == 0) {
                            if (this.l) {
                                ef8Var.s(true);
                            } else if (ef8Var.i() > this.a) {
                                ef8Var.s(true);
                            }
                        }
                        if (ef8Var.i() >= this.a) {
                            this.p++;
                        } else {
                            this.n++;
                        }
                        this.D.add(ef8Var);
                        this.E.put(ef8Var.c() + "", ef8Var);
                    } else {
                        if (ef8Var.i() >= this.a) {
                            this.o++;
                        } else {
                            this.m++;
                        }
                        this.C.add(ef8Var);
                        TbadkApplication.getInst().addSignedForum(ef8Var.d(), ef8Var.e(), -1);
                    }
                    this.B.add(ef8Var);
                    Collections.sort(this.B, new a(this));
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
        if (this.H == null) {
            this.H = new gf8();
        }
        this.H.a(optJSONObject2);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
        if (this.I == null) {
            this.I = new lf8();
        }
        this.I.a(optJSONObject3);
        a(false);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                Iterator<ef8> it = this.B.iterator();
                while (it.hasNext()) {
                    ef8 next = it.next();
                    if (next instanceof cf8) {
                        arrayList.add(next);
                    }
                }
                this.B.removeAll(arrayList);
            }
            int i = this.p;
            int i2 = this.o;
            if (i + i2 > 0) {
                if (i2 > 0) {
                    this.t = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f1194, Integer.valueOf(this.o), Integer.valueOf(this.p));
                } else {
                    this.t = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f118e, Integer.valueOf(this.p + this.o));
                }
                if (this.B.size() > 0) {
                    this.B.add(0, new cf8(this.r, this.t));
                }
            }
            int i3 = this.n;
            int i4 = this.m;
            if (i3 + i4 > 0) {
                if (i4 > 0) {
                    this.s = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f1194, Integer.valueOf(this.m), Integer.valueOf(this.n));
                } else {
                    this.s = TbadkApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f118e, Integer.valueOf(this.n + this.m));
                }
                if (this.p + this.o > 0) {
                    if (this.B.size() > this.p + this.o + 1) {
                        this.B.add(this.p + this.o + 1, new cf8(this.q, this.s));
                    }
                } else if (this.B.size() > 0) {
                    this.B.add(0, new cf8(this.q, this.s));
                }
            }
            if (this.B.size() <= 0) {
                this.x = 3;
            } else if (this.l) {
                if (this.k == 1 && this.D.size() > 0) {
                    this.x = 0;
                } else {
                    this.x = 2;
                }
            } else if (this.k == 1 && this.p > 0) {
                this.x = 0;
            } else {
                int i5 = this.p;
                int i6 = this.o;
                if (i5 + i6 > 0) {
                    this.x = 2;
                } else if (i5 + i6 <= 0) {
                    this.x = 3;
                }
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.l) {
                if (this.p + this.n <= 0) {
                    this.y = true;
                } else {
                    this.y = false;
                }
            } else if (this.p <= 0) {
                this.y = true;
            } else {
                this.y = false;
            }
        }
    }

    public final void c(ef8 ef8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ef8Var) == null) {
            if (ef8Var.i() >= this.a) {
                this.o++;
                this.p--;
            } else {
                this.m++;
                this.n--;
            }
            this.E.remove(String.valueOf(ef8Var.c()));
            this.D.remove(ef8Var);
            if (ef8Var.h() + ef8Var.e() >= ef8Var.g()) {
                ef8Var.w(ef8Var.i() + 1);
                ef8Var.v(true);
                if (ef8Var.i() == this.a) {
                    this.o++;
                    this.m--;
                }
            }
            this.C.add(ef8Var);
            TbadkApplication.getInst().addSignedForum(ef8Var.d(), ef8Var.e(), -1);
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.H.a : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.H.b : (String) invokeV.objValue;
    }

    public BlockPopInfoData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.J : (BlockPopInfoData) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public bf8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.F : (bf8) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.A : invokeV.intValue;
    }

    public ArrayList<ef8> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.a : invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? !StringUtils.isNull(this.b) && this.b.equals("1") : invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.i : invokeV.intValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.x : invokeV.intValue;
    }

    public ArrayList<ef8> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.z : invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f : (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public ArrayList<ef8> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.D : (ArrayList) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.I.a : (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.I.b : (String) invokeV.objValue;
    }
}
