package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public EnqueueType J;
    public int K;
    public int L;
    public boolean M;
    public x N;
    public n O;
    public com.ss.android.socialbase.appdownloader.c.e P;
    public IDownloadFileUriProvider Q;
    public r R;
    public boolean S;
    public af T;
    public boolean U;
    public JSONObject V;
    public String W;
    public List<m> X;
    public int Y;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public Activity f68986a;
    public int aa;
    public boolean ab;
    public boolean ac;
    public boolean ad;
    public String ae;
    public int[] af;

    /* renamed from: b  reason: collision with root package name */
    public Context f68987b;

    /* renamed from: c  reason: collision with root package name */
    public String f68988c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f68989d;

    /* renamed from: e  reason: collision with root package name */
    public String f68990e;

    /* renamed from: f  reason: collision with root package name */
    public String f68991f;

    /* renamed from: g  reason: collision with root package name */
    public String f68992g;

    /* renamed from: h  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f68993h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68994i;
    public boolean j;
    public boolean k;
    public boolean l;
    public IDownloadListener m;
    public IDownloadListener n;
    public String o;
    public String p;
    public boolean q;
    public com.ss.android.socialbase.downloader.downloader.g r;
    public com.ss.android.socialbase.downloader.downloader.h s;
    public s t;
    public com.ss.android.socialbase.downloader.notification.a u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public long z;

    public f(@NonNull Context context, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68994i = true;
        this.j = false;
        this.k = true;
        this.l = false;
        this.p = "application/vnd.android.package-archive";
        this.B = 5;
        this.F = true;
        this.J = EnqueueType.ENQUEUE_NONE;
        this.K = 150;
        this.M = true;
        this.X = new ArrayList();
        this.ac = true;
        this.ad = true;
        this.f68987b = context.getApplicationContext();
        this.f68988c = str;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public s C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : (s) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.K : invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.L : invokeV.intValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public EnqueueType J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.J : (EnqueueType) invokeV.objValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f68991f : (String) invokeV.objValue;
    }

    public x M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.N : (x) invokeV.objValue;
    }

    public n N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.O : (n) invokeV.objValue;
    }

    public com.ss.android.socialbase.appdownloader.c.e O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.P : (com.ss.android.socialbase.appdownloader.c.e) invokeV.objValue;
    }

    public IDownloadFileUriProvider P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.Q : (IDownloadFileUriProvider) invokeV.objValue;
    }

    public af Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.T : (af) invokeV.objValue;
    }

    public List<m> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.X : (List) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.U : invokeV.booleanValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.Y : invokeV.intValue;
    }

    public long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.Z : invokeV.longValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.ad : invokeV.booleanValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.ae : (String) invokeV.objValue;
    }

    public int[] X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.af : (int[]) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.ab : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.ac : invokeV.booleanValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f68988c : (String) invokeV.objValue;
    }

    public String aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public List<String> ab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f68989d : (List) invokeV.objValue;
    }

    public r ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.R : (r) invokeV.objValue;
    }

    public JSONObject ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.V : (JSONObject) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.f68990e : (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f68992g : (String) invokeV.objValue;
    }

    public List<com.ss.android.socialbase.downloader.model.c> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.f68993h : (List) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.f68994i : invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f68986a : (Activity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.f68987b : (Context) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public IDownloadListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.m : (IDownloadListener) invokeV.objValue;
    }

    public IDownloadListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.n : (IDownloadListener) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public com.ss.android.socialbase.downloader.notification.a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.u : (com.ss.android.socialbase.downloader.notification.a) invokeV.objValue;
    }

    public com.ss.android.socialbase.downloader.downloader.h o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.s : (com.ss.android.socialbase.downloader.downloader.h) invokeV.objValue;
    }

    public com.ss.android.socialbase.downloader.downloader.g p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.r : (com.ss.android.socialbase.downloader.downloader.g) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.v : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.aa : invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.y : (String) invokeV.objValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.z : invokeV.longValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.B : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.C : invokeV.intValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.aa = i2;
        }
    }

    public f b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            this.f68991f = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            this.f68992g = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            this.o = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            this.p = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048637, this, z)) == null) {
            this.w = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, str)) == null) {
            this.y = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) {
            this.E = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048648, this, z)) == null) {
            this.F = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048651, this, z)) == null) {
            this.G = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048653, this, z)) == null) {
            this.H = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048655, this, z)) == null) {
            this.I = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f m(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048657, this, z)) == null) {
            this.M = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048659, this, z)) == null) {
            this.A = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048661, this, z)) == null) {
            this.ab = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048663, this, z)) == null) {
            this.ac = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            this.f68990e = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
            this.j = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
            this.q = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048633, this, z)) == null) {
            this.v = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
            this.x = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048640, this, z)) == null) {
            this.D = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048645, this, z)) == null) {
            this.S = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) {
            this.ae = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            this.W = str;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, list)) == null) {
            this.f68993h = list;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048618, this, i2)) == null) {
            this.B = i2;
            return this;
        }
        return (f) invokeI.objValue;
    }

    public f c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            this.C = i2;
            return this;
        }
        return (f) invokeI.objValue;
    }

    public f d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
            this.K = i2;
            return this;
        }
        return (f) invokeI.objValue;
    }

    public f e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            this.L = i2;
            return this;
        }
        return (f) invokeI.objValue;
    }

    public f f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            this.Y = i2;
            return this;
        }
        return (f) invokeI.objValue;
    }

    public f a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048611, this, z)) == null) {
            this.f68994i = z;
            return this;
        }
        return (f) invokeZ.objValue;
    }

    public f b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, list)) == null) {
            this.f68989d = list;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(IDownloadListener iDownloadListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, iDownloadListener)) == null) {
            this.m = iDownloadListener;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048602, this, j)) == null) {
            this.z = j;
            return this;
        }
        return (f) invokeJ.objValue;
    }

    public f a(EnqueueType enqueueType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, enqueueType)) == null) {
            this.J = enqueueType;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(IDownloadFileUriProvider iDownloadFileUriProvider) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, iDownloadFileUriProvider)) == null) {
            this.Q = iDownloadFileUriProvider;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(r rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, rVar)) == null) {
            this.R = rVar;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, jSONObject)) == null) {
            this.V = jSONObject;
            return this;
        }
        return (f) invokeL.objValue;
    }

    public f a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, mVar)) == null) {
            synchronized (this.X) {
                if (mVar != null) {
                    if (!this.X.contains(mVar)) {
                        this.X.add(mVar);
                        return this;
                    }
                }
                return this;
            }
        }
        return (f) invokeL.objValue;
    }
}
