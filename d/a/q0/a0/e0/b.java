package d.a.q0.a0.e0;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.w0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class b extends d.a.p0.s.q.a implements PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId H;
    public static final BdUniqueId I;
    public static final BdUniqueId J;
    public static final BdUniqueId K;
    public static final BdUniqueId L;
    public static final BdUniqueId M;
    public static final BdUniqueId N;
    public static final BdUniqueId O;
    public static final BdUniqueId P;
    public static final BdUniqueId Q;
    public static final ArrayList<BdUniqueId> R;
    public static final ArrayList<BdUniqueId> S;
    public static BdUniqueId[][] T;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;

    /* renamed from: e  reason: collision with root package name */
    public b2 f54338e;

    /* renamed from: f  reason: collision with root package name */
    public String f54339f;

    /* renamed from: g  reason: collision with root package name */
    public String f54340g;

    /* renamed from: h  reason: collision with root package name */
    public int f54341h;

    /* renamed from: i  reason: collision with root package name */
    public String f54342i;
    public String j;
    public int k;
    public String l;
    public String m;
    public Integer n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1365415064, "Ld/a/q0/a0/e0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1365415064, "Ld/a/q0/a0/e0/b;");
                return;
            }
        }
        H = BdUniqueId.gen();
        I = BdUniqueId.gen();
        J = BdUniqueId.gen();
        K = BdUniqueId.gen();
        L = BdUniqueId.gen();
        M = BdUniqueId.gen();
        N = BdUniqueId.gen();
        O = BdUniqueId.gen();
        P = BdUniqueId.gen();
        Q = BdUniqueId.gen();
        R = new ArrayList<>();
        S = new ArrayList<>();
        R.add(H);
        R.add(I);
        S.add(M);
        S.add(J);
        S.add(L);
        S.add(K);
        T = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, R.size(), S.size());
        for (int i2 = 0; i2 < R.size(); i2++) {
            for (int i3 = 0; i3 < S.size(); i3++) {
                T[i2][i3] = BdUniqueId.gen();
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 1;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54339f : (String) invokeV.objValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.q == 1 : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f54342i = str;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }

    public void H(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.n = num;
        }
    }

    public void I(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f54341h = i2;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f54340g = str;
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.q = i2;
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.j = str;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f54339f = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f54342i : (String) invokeV.objValue;
    }

    public StatisticItem d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return null;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            b2 threadData = getThreadData();
            if (threadData != null) {
                return threadData.getImages();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.a
    public w0 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getThreadData() == null || (sparseArray = this.feedBackReasonMap) == null || sparseArray.size() <= 0) {
                return null;
            }
            w0 w0Var = new w0();
            w0Var.n(getThreadData().o1());
            w0Var.k(getThreadData().R());
            w0Var.m(getThreadData().B0());
            w0Var.j(this.feedBackReasonMap);
            w0Var.j = this.f54339f;
            w0Var.k = this.f54340g;
            w0Var.l = this.m;
            w0Var.m = getThreadData().Z;
            return w0Var;
        }
        return (w0) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.a
    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.f54340g + "#" + this.f54341h + "#" + this.f54342i;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.p0.s.q.a
    public b2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (b2) invokeV.objValue;
    }

    public StatisticItem h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public Integer j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.n : (Integer) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f54341h : invokeV.intValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f54340g : (String) invokeV.objValue;
    }

    public StatisticItem q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? w(str, false) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem t(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, str, i2)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.R())).param("tid", String.valueOf(threadData.o1())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", C()).param("obj_source", p()).param("obj_locate", o()).param("obj_name", c()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.a.q0.a0.m.e());
            if (i2 == 0) {
                param.param("obj_type", x());
            } else {
                param.param("obj_type", i2);
            }
            param.param("obj_id", e());
            return param;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem w(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, str, z)) == null) {
            b2 threadData = getThreadData();
            if (threadData == null || str.length() == 0) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.R())).param("tid", String.valueOf(threadData.o1())).param("nid", threadData.B0()).param("obj_id", e()).param("obj_param1", C()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", p()).param("obj_locate", o()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, d.a.q0.a0.m.e()).param("ab_tag", c()).param(TiebaStatic.Params.IS_ZP, threadData.w2() ? 1 : 0);
            if (!z) {
                param.param("obj_type", x());
            } else {
                if (threadData.s1 > 0) {
                    param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                } else {
                    param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                }
                param.param(TiebaStatic.Params.IS_VERTICAL, j().intValue());
            }
            if (threadData.q1() != null && threadData.q1().K() != null && threadData.q1().K().y() != null && threadData.q1().K().y().size() > 0) {
                param.param(TiebaStatic.Params.OBJ_TO, threadData.q1().N ? 2 : 1);
            }
            return param;
        }
        return (StatisticItem) invokeLZ.objValue;
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            b2 threadData = getThreadData();
            int i2 = 0;
            if (threadData == null) {
                return 0;
            }
            ArrayList<MediaData> A0 = threadData.A0();
            if (A0 != null) {
                Iterator<MediaData> it = A0.iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public StatisticItem y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }
}
