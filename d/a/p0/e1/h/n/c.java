package d.a.p0.e1.h.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.m.e;
import d.a.d.m.d;
import d.a.o0.r.q.b2;
import d.a.p0.n2.q.d;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class c extends d.a.p0.n2.q.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.d.m.d O0;
    public b2 P0;
    public boolean Q0;
    public boolean R0;
    public CustomMessageListener S0;
    public Runnable T0;

    /* loaded from: classes8.dex */
    public class a implements d.InterfaceC0569d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55668a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55668a = cVar;
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55668a.startPlay();
            }
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // d.a.d.m.d.InterfaceC0569d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55669a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55669a = cVar;
        }

        @Override // d.a.p0.n2.q.d.k
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f55669a.i0()) {
                return;
            }
            if (i3 >= i2) {
                this.f55669a.O0.I(false, false, "NEWINDEX");
            } else if (i2 == 0 || this.f55669a.U || (i3 * 100) / i2 < 80 || i2 <= 15000) {
            } else {
                c cVar = this.f55669a;
                cVar.Q0(cVar.P0);
            }
        }
    }

    /* renamed from: d.a.p0.e1.h.n.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1348c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f55670a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1348c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55670a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.d.m.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof d.a.d.m.e.b) || (bVar = (d.a.d.m.e.b) customResponsedMessage.getData()) == null) {
                return;
            }
            String d2 = bVar.d();
            if (StringUtils.isNull(d2) || this.f55670a.P0 == null || !d2.equals(this.f55670a.P0.c0())) {
                return;
            }
            d.a.d.m.d dVar = this.f55670a.O0;
            c cVar = this.f55670a;
            dVar.K(cVar.M0(cVar.P0, bVar));
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f55671e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55671e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55671e.O0 == null) {
                return;
            }
            c cVar = this.f55671e;
            cVar.R0 = false;
            cVar.O0.L();
            this.f55671e.O0.w();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View view) {
        super(context, view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Q0 = false;
        this.S0 = new C1348c(this, 2921395);
        this.T0 = new d(this);
        p0(true);
        N0();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.a.d.m.a M0(b2 b2Var, d.a.d.m.e.b bVar) {
        InterceptResult invokeLL;
        int i2;
        VideoInfo l1;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, b2Var, bVar)) == null) {
            if (b2Var == null || bVar == null) {
                return null;
            }
            int c2 = bVar.c();
            int b2 = bVar.b();
            int a2 = bVar.a();
            int i5 = -1;
            if (a2 != -1) {
                int i6 = c2 != -1 ? (a2 - c2) - 1 : -1;
                if (b2 != -1) {
                    i5 = i6;
                    i2 = (b2 - a2) - 1;
                    l1 = b2Var.l1();
                    if (l1 == null) {
                        int intValue = l1.video_width.intValue();
                        i4 = l1.video_height.intValue();
                        i3 = intValue;
                    } else {
                        i3 = 0;
                        i4 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", b2Var.c0());
                    hashMap.put("video_title", b2Var.getTitle());
                    hashMap.put("forum_id", String.valueOf(b2Var.Q()));
                    hashMap.put("forum_name", b2Var.W());
                    hashMap.put("up_distance", String.valueOf(i5));
                    hashMap.put("down_distance", String.valueOf(i2));
                    d.a.d.m.a h2 = d.a.d.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
                    h2.a(hashMap);
                    return h2;
                }
                i5 = i6;
            }
            i2 = -1;
            l1 = b2Var.l1();
            if (l1 == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", b2Var.c0());
            hashMap2.put("video_title", b2Var.getTitle());
            hashMap2.put("forum_id", String.valueOf(b2Var.Q()));
            hashMap2.put("forum_name", b2Var.W());
            hashMap2.put("up_distance", String.valueOf(i5));
            hashMap2.put("down_distance", String.valueOf(i2));
            d.a.d.m.a h22 = d.a.d.m.c.h(3, 0, "1546854828072", a2 + 1, i3, i4);
            h22.a(hashMap2);
            return h22;
        }
        return (d.a.d.m.a) invokeLL.objValue;
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.d.m.d dVar = new d.a.d.m.d(this.P, (ViewGroup) E());
            this.O0 = dVar;
            dVar.G(new a(this));
            q0(new b(this));
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void Q0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) || b2Var == null || b2Var.c0() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, b2Var.c0()));
    }

    @Override // d.a.p0.n2.q.d
    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.n2.q.d, d.a.p0.n2.q.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.d.m.d dVar = this.O0;
            if (dVar == null || !dVar.r()) {
                return super.isPlaying();
            }
            return this.R0 || this.O0.t();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.p0.n2.q.b, d.a.p0.n2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.O0.I(false, false, "NEWINDEX")) {
            return;
        }
        startPlay();
    }

    @Override // d.a.p0.n2.q.d, d.a.p0.n2.q.a
    public boolean r0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            d.a.d.m.d dVar = this.O0;
            if (dVar != null) {
                if (z) {
                    if (dVar.r()) {
                        this.R0 = false;
                        this.O0.L();
                    }
                } else if (dVar.r()) {
                    this.Q0 = true;
                    this.O0.F(true);
                }
            }
            return super.r0(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // d.a.p0.n2.q.b, d.a.p0.n2.q.d, d.a.p0.n2.q.a
    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, b2Var) == null) || b2Var == null) {
            return;
        }
        super.setData(b2Var);
        boolean z = this.P0 == b2Var;
        this.P0 = b2Var;
        if (this.O0 != null) {
            if (this.Q0 && z) {
                this.Q0 = false;
            } else {
                this.O0.B();
            }
        }
    }

    @Override // d.a.p0.n2.q.d, d.a.p0.n2.q.a
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.S0.setTag(this.S);
            MessageManager.getInstance().registerListener(this.S0);
        }
    }

    @Override // d.a.p0.n2.q.d, d.a.p0.n2.q.a
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d.a.d.m.d dVar = this.O0;
            if (dVar != null && dVar.r()) {
                this.R0 = true;
                this.O0.E();
                return;
            }
            super.startPlay();
        }
    }

    @Override // d.a.p0.n2.q.d, d.a.p0.n2.q.a
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.stopPlay();
            d.a.d.m.d dVar = this.O0;
            if (dVar == null || !dVar.r()) {
                return;
            }
            e.a().removeCallbacks(this.T0);
            e.a().post(this.T0);
        }
    }
}
