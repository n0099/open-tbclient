package com.repackage;

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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u78;
import com.repackage.wp;
import java.util.HashMap;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class l07 extends s78 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wp P0;
    public ThreadData Q0;
    public boolean R0;
    public boolean S0;
    public CustomMessageListener T0;
    public Runnable U0;

    /* loaded from: classes6.dex */
    public class a implements wp.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l07 a;

        public a(l07 l07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l07Var;
        }

        @Override // com.repackage.wp.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.startPlay();
            }
        }

        @Override // com.repackage.wp.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.repackage.wp.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.repackage.wp.d
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u78.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l07 a;

        public b(l07 l07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l07Var;
        }

        @Override // com.repackage.u78.l
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || this.a.h0()) {
                return;
            }
            if (i2 >= i) {
                if (this.a.P0 != null) {
                    this.a.P0.E(false, false, "HOME");
                }
            } else if (i == 0 || this.a.T || (i2 * 100) / i < 80 || i <= 15000) {
            } else {
                l07 l07Var = this.a;
                l07Var.H0(l07Var.Q0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l07 l07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l07Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            yp ypVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof yp) || (ypVar = (yp) customResponsedMessage.getData()) == null) {
                return;
            }
            String d = ypVar.d();
            if (StringUtils.isNull(d) || this.a.Q0 == null || !d.equals(this.a.Q0.getId())) {
                return;
            }
            this.a.G0();
            wp wpVar = this.a.P0;
            l07 l07Var = this.a;
            wpVar.F(l07Var.F0(l07Var.Q0, ypVar));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l07 a;

        public d(l07 l07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l07Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.P0 == null) {
                return;
            }
            l07 l07Var = this.a;
            l07Var.S0 = false;
            l07Var.P0.G();
            this.a.P0.v();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l07(Context context, View view2) {
        super(context, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R0 = false;
        this.T0 = new c(this, 2921395);
        this.U0 = new d(this);
        m0(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final tp F0(ThreadData threadData, yp ypVar) {
        InterceptResult invokeLL;
        int i;
        VideoInfo threadVideoInfo;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, threadData, ypVar)) == null) {
            if (threadData == null || ypVar == null) {
                return null;
            }
            int c2 = ypVar.c();
            int b2 = ypVar.b();
            int a2 = ypVar.a();
            int i4 = -1;
            if (a2 != -1) {
                int i5 = c2 != -1 ? (a2 - c2) - 1 : -1;
                if (b2 != -1) {
                    i4 = i5;
                    i = (b2 - a2) - 1;
                    threadVideoInfo = threadData.getThreadVideoInfo();
                    if (threadVideoInfo == null) {
                        int intValue = threadVideoInfo.video_width.intValue();
                        i3 = threadVideoInfo.video_height.intValue();
                        i2 = intValue;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("video_vid", threadData.getId());
                    hashMap.put("video_title", threadData.getTitle());
                    hashMap.put("forum_id", String.valueOf(threadData.getFid()));
                    hashMap.put("forum_name", threadData.getForum_name());
                    hashMap.put("up_distance", String.valueOf(i4));
                    hashMap.put("down_distance", String.valueOf(i));
                    tp h = vp.h(3, 0, "1546854828072", a2 + 1, i2, i3);
                    h.d(hashMap);
                    return h;
                }
                i4 = i5;
            }
            i = -1;
            threadVideoInfo = threadData.getThreadVideoInfo();
            if (threadVideoInfo == null) {
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("video_vid", threadData.getId());
            hashMap2.put("video_title", threadData.getTitle());
            hashMap2.put("forum_id", String.valueOf(threadData.getFid()));
            hashMap2.put("forum_name", threadData.getForum_name());
            hashMap2.put("up_distance", String.valueOf(i4));
            hashMap2.put("down_distance", String.valueOf(i));
            tp h2 = vp.h(3, 0, "1546854828072", a2 + 1, i2, i3);
            h2.d(hashMap2);
            return h2;
        }
        return (tp) invokeLL.objValue;
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.P0 == null) {
            wp wpVar = new wp(this.O, (ViewGroup) getMainView());
            this.P0 = wpVar;
            wpVar.C(new a(this));
            n0(new b(this));
        }
    }

    public final void H0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null || threadData.getId() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921394, threadData.getId()));
    }

    @Override // com.repackage.u78
    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.u78, com.repackage.r78
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wp wpVar = this.P0;
            if (wpVar == null || !wpVar.q()) {
                return super.isPlaying();
            }
            return this.S0 || this.P0.s();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.u78, com.repackage.r78
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            wp wpVar = this.P0;
            if (wpVar != null) {
                if (z) {
                    if (wpVar.q()) {
                        this.S0 = false;
                        this.P0.G();
                    }
                } else if (wpVar.q()) {
                    this.R0 = true;
                    this.P0.B(true);
                }
            }
            return super.onBackground(z);
        }
        return invokeZ.booleanValue;
    }

    @Override // com.repackage.s78, com.repackage.u78, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            wp wpVar = this.P0;
            if ((wpVar != null ? wpVar.E(false, false, "HOME") : false) || UbsABTestHelper.isFeedVideoImmersionTransition()) {
                return;
            }
            startPlay();
        }
    }

    @Override // com.repackage.s78, com.repackage.u78, com.repackage.r78
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, threadData) == null) || threadData == null) {
            return;
        }
        super.setData(threadData);
        boolean z = this.Q0 == threadData;
        this.Q0 = threadData;
        if (this.P0 != null) {
            if (this.R0 && z) {
                this.R0 = false;
            } else {
                this.P0.y();
            }
        }
    }

    @Override // com.repackage.u78, com.repackage.r78
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.T0.setTag(this.R);
            MessageManager.getInstance().registerListener(this.T0);
        }
    }

    @Override // com.repackage.u78, com.repackage.r78
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            wp wpVar = this.P0;
            if (wpVar != null && wpVar.q()) {
                this.S0 = true;
                this.P0.A();
                return;
            }
            super.startPlay();
        }
    }

    @Override // com.repackage.u78, com.repackage.r78
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.stopPlay();
            wp wpVar = this.P0;
            if (wpVar == null || !wpVar.q()) {
                return;
            }
            pg.a().removeCallbacks(this.U0);
            pg.a().post(this.U0);
        }
    }
}
