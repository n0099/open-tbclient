package com.repackage;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageBrowseModelTipView;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ft4;
import com.repackage.iy;
import com.repackage.t98;
import com.repackage.x16;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Anti;
import tbclient.App;
import tbclient.BannerList;
import tbclient.BlockPopInfo;
import tbclient.DiscoverHotForum;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes6.dex */
public class fv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public vw6 F;
    public boolean G;
    public BdUniqueId H;
    public SmartBubbleAnimatedView I;
    public HomePageYoungsterTopView J;
    public HomePageBrowseModelTipView K;
    public int L;
    public BdUniqueId M;
    public iy.a N;
    public ThreadInfo O;
    public t98 P;
    public ay4 Q;
    public RecyclerView.OnScrollListener R;
    public View.OnTouchListener S;
    public x16.b T;
    public final t98.b U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final CustomMessageListener Y;
    public CustomMessageListener Z;
    public final long a;
    public CustomMessageListener a0;
    public final cv6 b;
    public CustomMessageListener b0;
    public p0 c;
    public CustomMessageListener c0;
    public final List<jn> d;
    public String d0;
    public DataRes.Builder e;
    public int e0;
    public int f;
    public Runnable f0;
    public boolean g;
    public ev6 g0;
    public boolean h;
    public CustomMessageListener h0;
    public int i;
    public CustomMessageListener i0;
    public final TbPageContext<?> j;
    public CustomMessageListener j0;
    public final BdTypeRecyclerView k;
    public CustomMessageListener k0;
    public final BigdaySwipeRefreshLayout l;
    public CustomMessageListener l0;
    public final PersonalizePageView m;
    public CustomMessageListener m0;
    public final lw6 n;
    public wa n0;
    public int o;
    public CustomMessageListener o0;
    public zc6 p;
    public CustomMessageListener p0;
    public final zw6 q;
    public final wa q0;
    public rg8 r;
    public CustomMessageListener r0;
    public v75 s;
    public ScrollFragmentTabHost t;
    public x16 u;
    public boolean v;
    public j48 w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Boolean bool = Boolean.FALSE;
            if (customResponsedMessage.getData() instanceof Boolean) {
                bool = (Boolean) customResponsedMessage.getData();
            }
            if (bool.booleanValue()) {
                this.a.Z0(true);
            } else {
                this.a.Z0(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public b(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder h0 = this.a.h0();
                if (h0 != null && h0.c() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(h0.c().o(new iy.a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ fv6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.f = fv6Var;
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.b = jSONObject.optString("tid", "");
                    this.c = jSONObject.optString("fid", "");
                    this.d = jSONObject.optString("liveId", "");
                    this.e = jSONObject.optString("sid", "");
                } else if ((this.a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.a)) && ((this.d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.d)) && (this.e == null || !TextUtils.equals(jSONObject.optString("sid"), this.e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.b);
                        jSONObject.put("fid", this.c);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.f.f0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public c(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l == null) {
                return;
            }
            this.a.l.setRefreshing(false);
        }
    }

    /* loaded from: classes6.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.e == null || ListUtils.getCount(this.a.e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            fv6 fv6Var = this.a;
            fv6Var.c0(str, fv6Var.d);
            this.a.b1(str);
            if (this.a.n != null) {
                this.a.n.x(new ArrayList(this.a.d));
            }
            if (this.a.w == null || !this.a.A) {
                return;
            }
            this.a.w.n(this.a.x, this.a.y, this.a.v, true);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public d(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l == null) {
                return;
            }
            ft4.i k0 = this.a.k0();
            if (!this.a.l.u() || k0 == null || TbSingleton.getInstance().isBrowseMode()) {
                this.a.l.setRefreshing(false);
            } else {
                this.a.l.z(k0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder h0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (h0 = this.a.h0()) == null || h0.c() == null) {
                    return;
                }
                h0.c().o(new iy.a(3));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public e(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.b((this.a.e == null || this.a.e.thread_list == null || this.a.p0()) ? 0 : this.a.e.thread_list.size(), this.a.W(true), 0);
        }
    }

    /* loaded from: classes6.dex */
    public class e0 extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(fv6 fv6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            xz6 xz6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 == 0) {
                return;
            }
            for (jn jnVar : this.a.d) {
                if ((jnVar instanceof wz6) && (xz6Var = ((wz6) jnVar).X) != null && j2 == xz6Var.b) {
                    xz6Var.c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
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
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(ex6.m().l()) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public f0(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.u != null) {
                    this.a.u.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public g(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null || bool.booleanValue() || this.a.c == null) {
                return;
            }
            this.a.c.b((this.a.e == null || this.a.e.thread_list == null || this.a.p0()) ? 0 : this.a.e.thread_list.size(), this.a.W(true), 0);
        }
    }

    /* loaded from: classes6.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g0 a;

            public a(g0 g0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {g0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = g0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.n.k();
                    if (this.a.a.z || !this.a.a.A) {
                        return;
                    }
                    this.a.a.w.n(this.a.a.x, this.a.a.y, this.a.a.v, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<jn> h = this.a.n.h();
                if (!ListUtils.isEmpty(h)) {
                    for (jn jnVar : h) {
                        if (jnVar instanceof zw5) {
                            zw5 zw5Var = (zw5) jnVar;
                            if (zw5Var.j != 0 && (threadData = zw5Var.a) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                zw5Var.j = imageWidthAndHeight[0];
                                zw5Var.k = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                mg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends mc5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public h(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mc5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            DataRes k;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    k = fx6.c().a();
                } else {
                    k = ex6.m().k();
                }
                this.a.B0(k);
                return k;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zo4)) {
                zo4 zo4Var = (zo4) customResponsedMessage.getData();
                if (zo4Var.a != 1) {
                    return;
                }
                int k = li.k(TbadkCoreApplication.getInst());
                int i = li.i(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.a.M);
                requestGetMyPostNetMessage.setParams(jg.g(zo4Var.c, 0L), 0L, 0L, k, i, f, i2);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements tb5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.m == null) {
                    return;
                }
                this.a.a.m.x0();
            }
        }

        public i(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) && dataRes != null && MainTabDataSwitch.isCacheOpen()) {
                fx6.c().g(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(fv6 fv6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl responseData;
            tbclient.GetMyPost.DataRes dataRes;
            ThreadInfo threadInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    responseData = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    responseData = responsedMessage instanceof GetMyPostSocketResponseMessage ? ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData() : null;
                }
                if (responseData == null || (dataRes = responseData.data) == null || (threadInfo = dataRes.thread_info) == null) {
                    return;
                }
                this.a.O = threadInfo;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends mc5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ fv6 b;

        public j(fv6 fv6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fv6Var;
            this.a = builder;
        }

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                cq4.f();
                try {
                    cq4.e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (UbsABTestHelper.isPushOpenNewStyle()) {
                    if (by4.f(TbadkCoreApplication.getInst(), 1)) {
                        fv6 fv6Var = this.a;
                        fv6Var.Q = by4.h(fv6Var.j, "homepage", 0L);
                    }
                } else if (zx4.g(TbadkCoreApplication.getInst(), 1)) {
                    zx4.i(this.a.j, 7, 0L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ScrollFragmentTabHost.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public k(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.y
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.t.F(i) == 1 || this.a.p == null) {
                return;
            }
            this.a.p.d();
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements x16.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public k0(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.repackage.x16.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.v = false;
            }
        }

        @Override // com.repackage.x16.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.v = true;
            }
        }

        @Override // com.repackage.x16.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.x16.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends mc5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ fv6 b;

        public l(fv6 fv6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fv6Var;
            this.a = builder;
        }

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                cq4.f();
                try {
                    cq4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements t98.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public l0(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.repackage.t98.b
        public void a(w98 w98Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, w98Var) == null) || this.a.k == null || this.a.q == null) {
                return;
            }
            this.a.q.j(this.a.d, w98Var, this.a.k.getFirstVisiblePosition());
            this.a.n.x(this.a.d);
        }

        @Override // com.repackage.t98.b
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public m(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.j, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.k == null) {
                return;
            }
            this.a.w.x();
            this.a.A = false;
            this.a.l.setRefreshing(true);
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ThreadData) || this.a.e == null || ListUtils.getCount(this.a.e.thread_list) == 0 || (threadData = (ThreadData) customResponsedMessage.getData()) == null || threadData.getPraise() == null || threadData.getId() == null || ListUtils.getCount(this.a.e.thread_list) == 0) {
                return;
            }
            for (int i = 0; i < this.a.e.thread_list.size(); i++) {
                ThreadInfo threadInfo = this.a.e.thread_list.get(i);
                if (threadInfo != null && threadInfo.id.longValue() == jg.g(threadData.getId(), -1L)) {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    Zan.Builder builder2 = new Zan.Builder(builder.zan);
                    builder2.num = Integer.valueOf((int) threadData.getPraise().getNum());
                    builder.zan = builder2.build(true);
                    this.a.e.thread_list.set(i, builder.build(true));
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.k == null) {
                return;
            }
            this.a.e0();
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage)) {
                List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
                List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
                if (ListUtils.isEmpty(this.a.d) || ListUtils.isEmpty(ids) || ListUtils.isEmpty(originData)) {
                    return;
                }
                for (int i = 0; i < originData.size(); i++) {
                    if ((originData.get(i) instanceof ThreadData) && (threadData = (ThreadData) originData.get(i)) != null && threadData.getThreadAlaInfo() != null && ids.contains(Long.valueOf(threadData.getThreadAlaInfo().live_id))) {
                        this.a.d.remove(threadData);
                    }
                }
                if (this.a.n != null) {
                    this.a.n.x(new ArrayList(this.a.d));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    ((Integer) data).intValue();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            User user;
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !(customResponsedMessage instanceof UpdateAttentionMessage) || this.a.e == null || ListUtils.isEmpty(this.a.e.thread_list)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().c)) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= this.a.e.thread_list.size()) {
                    break;
                }
                ThreadInfo threadInfo = this.a.e.thread_list.get(i);
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != jg.g(updateAttentionMessage.getData().c, -1L)) {
                    i++;
                } else {
                    ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                    User.Builder builder2 = new User.Builder(builder.author);
                    builder2.is_like = Integer.valueOf(updateAttentionMessage.getData().d ? 1 : 0);
                    builder2.has_concerned = Integer.valueOf(updateAttentionMessage.getData().d ? 1 : 0);
                    GodInfo.Builder builder3 = new GodInfo.Builder(builder2.god_data);
                    if (updateAttentionMessage.getData().d) {
                        intValue = builder2.fans_num.intValue() + 1;
                        builder3.followed = 1;
                    } else {
                        builder3.followed = 0;
                        intValue = builder2.fans_num.intValue() - 1;
                    }
                    builder2.fans_num = Integer.valueOf(intValue);
                    builder2.god_data = builder3.build(true);
                    builder.author = builder2.build(true);
                    this.a.e.thread_list.set(i, builder.build(true));
                }
            }
            this.a.d1(updateAttentionMessage);
        }
    }

    /* loaded from: classes6.dex */
    public interface p0 {
        void a(boolean z);

        void b(int i, gb5 gb5Var, int i2);

        void c();

        void d(int i, int i2, gb5 gb5Var, int i3);

        void onError(int i, String str);
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.a.e == null || this.a.e.hot_recomforum == null || ListUtils.isEmpty(this.a.e.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.a.e.hot_recomforum);
            if (er6.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.a.e.hot_recomforum = builder.build(true);
                this.a.K0(new DataRes.Builder(this.a.e.build(true)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends mc5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ fv6 c;

        public r(fv6 fv6Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fv6Var;
            this.a = str;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.mc5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    cq4.f();
                    qe<byte[]> e = cq4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (e == null) {
                        return Boolean.FALSE;
                    }
                    byte[] bArr = e.get("0");
                    if (bArr != null && bArr.length != 0) {
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list != null && builder.thread_list.size() > 0) {
                            for (int i = 0; i < builder.thread_list.size(); i++) {
                                ThreadInfo threadInfo = builder.thread_list.get(i);
                                if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == jg.g(this.a, -1L)) {
                                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                                    User.Builder builder3 = new User.Builder(builder2.author);
                                    builder3.is_like = Integer.valueOf(this.b ? 1 : 0);
                                    builder3.has_concerned = Integer.valueOf(this.b ? 1 : 0);
                                    GodInfo.Builder builder4 = new GodInfo.Builder(builder3.god_data);
                                    if (this.b) {
                                        intValue = builder3.fans_num.intValue() + 1;
                                        builder4.followed = 1;
                                    } else {
                                        intValue = builder3.fans_num.intValue() - 1;
                                        builder4.followed = 0;
                                    }
                                    builder3.fans_num = Integer.valueOf(intValue);
                                    builder3.god_data = builder4.build(true);
                                    builder2.author = builder3.build(true);
                                    builder.thread_list.set(i, builder2.build(true));
                                }
                            }
                            DataRes.Builder builder5 = new DataRes.Builder(builder.build(true));
                            this.c.b.g(builder5.thread_list);
                            e.g("0", builder5.build(true).toByteArray());
                            return Boolean.TRUE;
                        }
                        return Boolean.FALSE;
                    }
                    return Boolean.FALSE;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return Boolean.FALSE;
                }
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements tb5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
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
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t extends mc5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ fv6 b;

        public t(fv6 fv6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fv6Var;
            this.a = i;
        }

        @Override // com.repackage.mc5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                cq4.f();
                qe<String> h = cq4.h(this.b.d0, TbadkCoreApplication.getCurrentAccount());
                if (h != null) {
                    h.e(this.b.d0, Integer.toString(this.a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class u extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public final /* synthetic */ fv6 d;

        public u(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fv6Var;
            this.a = -1;
            this.b = 0;
            this.c = false;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.b > i) {
                    this.c = true;
                }
                this.b = i;
                int i3 = (i2 + i) - 1;
                if (!this.c && this.a != i3) {
                    this.a = i3;
                    this.d.F0(i3);
                }
                if (this.c && this.a != i) {
                    this.a = i;
                    this.d.F0(i);
                }
                this.d.e0 = i;
                this.d.x = i;
                this.d.y = i3;
                ThreadCardViewHolder h0 = this.d.h0();
                if (h0 == null || h0.c() == null) {
                    return;
                }
                h0.c().o(this.d.N);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (this.d.s == null) {
                    this.d.s = new v75();
                    this.d.s.a(1005);
                    this.d.s.e = 1;
                }
                if (i == 0) {
                    dv6.b(this.d.k);
                    this.d.s.e();
                    gw5.b().d(true);
                    ai5.c().h("page_recommend", "show_");
                    bf8.g().h(this.d.H, false);
                    this.c = false;
                    if (this.d.w == null || !this.d.A || this.d.z) {
                        return;
                    }
                    this.d.w.m(this.d.x, this.d.y, this.d.v, 1);
                    if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
                        this.d.w.p(2);
                    } else {
                        this.d.w.p(1);
                    }
                    this.d.w.q(true);
                    return;
                }
                this.d.s.d();
                if (i == 1) {
                    if (this.d.p != null) {
                        this.d.p.d();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                    i3 = 0;
                } else {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                }
                a(i4, (i3 - i4) + 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements ev6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ v b;

            public a(v vVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {vVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = vVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.k.getHandler() == null) {
                    return;
                }
                this.b.a.k.requestFocusFromTouch();
                if (this.a > this.b.a.k.getCount() - 1) {
                    return;
                }
                this.b.a.k.setSelection(this.a);
            }
        }

        public v(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        @Override // com.repackage.ev6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f0 == null) {
                    this.a.f0 = new a(this, i);
                }
                this.a.k.removeCallbacks(this.a.f0);
                this.a.k.post(this.a.f0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w extends mc5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        public w(fv6 fv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mc5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                cq4.f();
                qe<String> h = cq4.h(this.a.d0, TbadkCoreApplication.getCurrentAccount());
                if (h != null) {
                    return h.get(this.a.d0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class x implements tb5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ev6 a;

        public x(fv6 fv6Var, ev6 ev6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, ev6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ev6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            ev6 ev6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (ev6Var = this.a) == null) {
                return;
            }
            ev6Var.a(jg.e(str, 0));
        }
    }

    /* loaded from: classes6.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.F == null) {
                return;
            }
            TbSingleton.getInstance().isAddBanner = false;
            this.a.d.remove(this.a.F);
            this.a.n.x(new ArrayList(this.a.d));
            ys4.k().x("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes6.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(fv6 fv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fv6Var, Integer.valueOf(i)};
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
            this.a = fv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f0(customResponsedMessage);
                if (this.a.w == null || !this.a.A) {
                    return;
                }
                this.a.w.n(this.a.x, this.a.y, this.a.v, true);
            }
        }
    }

    public fv6(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, lw6 lw6Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, lw6Var, bigdaySwipeRefreshLayout, personalizePageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = new LinkedList();
        this.f = 1;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.o = 2000;
        this.s = null;
        this.v = false;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = true;
        this.B = false;
        this.E = false;
        this.G = true;
        this.L = 0;
        this.M = BdUniqueId.gen();
        this.N = new iy.a(2);
        this.O = null;
        this.R = new u(this);
        this.S = new f0(this);
        this.T = new k0(this);
        this.U = new l0(this);
        this.V = new m0(this, 2001399);
        this.W = new n0(this, 2921461);
        this.X = new o0(this, 2921486);
        this.Y = new a(this, 2921562);
        this.Z = new n(this, 2004004);
        this.a0 = new o(this, 2921026);
        this.b0 = new p(this, 2001115);
        this.c0 = new q(this, 0);
        this.d0 = "lastReadReadPositionKey";
        this.e0 = 0;
        this.g0 = new v(this);
        this.h0 = new y(this, 2016569);
        this.i0 = new z(this, 2016488);
        this.j0 = new a0(this, 2016553);
        this.k0 = new b0(this, 2921547);
        this.l0 = new c0(this, 2016331);
        this.m0 = new d0(this, 2921381);
        this.n0 = new e0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.o0 = new g0(this, 2921414);
        this.p0 = new h0(this, 2921453);
        this.q0 = new i0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.r0 = new j0(this, 2921482);
        this.j = tbPageContext;
        this.L = ys4.k().l("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.m = personalizePageView;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.S);
        x16 x16Var = new x16();
        this.u = x16Var;
        x16Var.d(this.T);
        this.n = lw6Var;
        this.q = new zw6();
        this.a = ys4.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.R);
        this.p = new zc6();
        o0();
        this.w = new j48(this.j, this.k);
        if (UbsABTestHelper.isFeedVideoAutoPlayABTest()) {
            this.w.p(2);
        } else {
            this.w.p(1);
        }
        this.w.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.b = new cv6(this.d, this.n);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.I = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, li.f(tbPageContext.getContext(), R.dimen.tbds83)));
        O0();
        this.o0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.o0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.q0.setTag(this.M);
        if (this.q0.getHttpMessageListener() != null) {
            this.q0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.q0.getSocketMessageListener() != null) {
            this.q0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.q0);
        MessageManager.getInstance().registerListener(this.p0);
        MessageManager.getInstance().registerListener(this.r0);
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) {
            this.z = z2;
            ScrollFragmentTabHost scrollFragmentTabHost = this.t;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.O(z2);
            }
            j48 j48Var = this.w;
            if (j48Var == null) {
                return;
            }
            j48Var.r(!z2);
            ThreadCardViewHolder h02 = h0();
            boolean z3 = false;
            if (h02 != null && h02.c() != null) {
                z3 = h02.c().o(new iy.a(8, Boolean.valueOf(z2)));
            }
            if (!z3) {
                if (z2) {
                    this.w.x();
                } else if (this.A) {
                    this.w.n(this.x, this.y, this.v, true);
                }
            }
            if (!z2) {
                if (this.P == null) {
                    t98 t98Var = new t98();
                    this.P = t98Var;
                    t98Var.h(this.U);
                }
                this.P.g();
            }
            ay4 ay4Var = this.Q;
            if (ay4Var != null) {
                ay4Var.q();
            }
        }
    }

    public final void B0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            this.h = true;
            if (dataRes != null) {
                kx6.a("cacheSuccess");
                J0(false, true, true, dataRes);
                p0 p0Var = this.c;
                if (p0Var != null) {
                    p0Var.a(true);
                    y0();
                    return;
                }
                kx6.a("errorNetLoadCallback");
                return;
            }
            kx6.a("cacheFail");
            w0();
        }
    }

    public void C0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.I;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.J;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.b();
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView = this.K;
            if (homePageBrowseModelTipView != null) {
                homePageBrowseModelTipView.a();
            }
            ay4 ay4Var = this.Q;
            if (ay4Var != null) {
                ay4Var.u();
            }
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j48 j48Var = this.w;
            if (j48Var != null) {
                j48Var.h();
            }
            zc6 zc6Var = this.p;
            if (zc6Var != null) {
                zc6Var.e();
            }
            cv6 cv6Var = this.b;
            if (cv6Var != null) {
                cv6Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.f0);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.p0);
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.r0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        int size;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) == null) {
            DataRes dataRes2 = dataRes;
            if (z2) {
                hv6.a();
            }
            zw6 zw6Var = this.q;
            if (zw6Var != null && zw6Var.k() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
                if (dataRes2 == null) {
                    DataRes.Builder builder = new DataRes.Builder();
                    builder.thread_list = new ArrayList();
                    dataRes2 = builder.build(false);
                }
                if (dataRes2.thread_list != null) {
                    List<ThreadInfo> d2 = this.q.d();
                    dataRes2.thread_list.addAll(d2);
                    if (d2 != null) {
                        d2.clear();
                    }
                    z4 = true;
                    DataRes.Builder builder2 = this.e;
                    size = (builder2 != null || (list = builder2.thread_list) == null) ? 0 : list.size();
                    if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                        p0 p0Var = this.c;
                        if (p0Var != null) {
                            p0Var.c();
                        }
                        T0(false);
                        qg.b(new c(this));
                        return;
                    }
                    if (this.O != null) {
                        DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                        builder3.thread_list.add(0, this.O);
                        dataRes2 = builder3.build(false);
                        DataRes.Builder builder4 = this.e;
                        if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                            Iterator<ThreadInfo> it = this.e.thread_list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ThreadInfo next = it.next();
                                if (next != null && (l2 = next.tid) != null && this.O.tid != null && l2.longValue() == this.O.tid.longValue()) {
                                    this.e.thread_list.remove(next);
                                    break;
                                }
                            }
                        }
                        this.O = null;
                    }
                    if ((!z4 || i2 == 0) && dataRes2 != null && J0(true, z2, z3, dataRes2)) {
                        z0();
                        if (this.c != null) {
                            ys4 k2 = ys4.k();
                            k2.x("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            this.c.a(false);
                        }
                        this.B = true;
                        this.C = z2;
                        this.D = size;
                        c1();
                    } else {
                        this.B = false;
                        if (this.d.size() > 0) {
                            p0 p0Var2 = this.c;
                            if (p0Var2 != null) {
                                p0Var2.onError(1, str);
                            }
                        } else {
                            p0 p0Var3 = this.c;
                            if (p0Var3 != null) {
                                p0Var3.onError(2, str);
                            }
                        }
                    }
                    T0(false);
                    qg.b(new d(this));
                }
            }
            z4 = false;
            DataRes.Builder builder22 = this.e;
            if (builder22 != null) {
            }
            if (z2) {
            }
            if (this.O != null) {
            }
            if (!z4) {
            }
            z0();
            if (this.c != null) {
            }
            this.B = true;
            this.C = z2;
            this.D = size;
            c1();
            T0(false);
            qg.b(new d(this));
        }
    }

    public void F0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            rg8 rg8Var = this.r;
            if ((rg8Var != null ? rg8Var.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.r.c(i2);
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            dv6.b(this.k);
            X(this.e0);
            v75 v75Var = this.s;
            if (v75Var != null) {
                v75Var.c();
            }
        }
    }

    public void H0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && z2) {
            this.n.k();
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (ListUtils.getCount(this.d) < this.q.e() - 40) {
                return;
            }
            List<jn> list = null;
            bx6 c2 = this.q.c(true, this.e, null, 1);
            int i2 = 0;
            if (c2 != null) {
                list = c2.a;
                int i3 = c2.c;
                c2.c = 0;
                i2 = i3;
            }
            if (list != null) {
                this.d.clear();
                this.d.addAll(list);
                this.n.y(new LinkedList(this.d), i2);
            }
        }
    }

    public final boolean J0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        List<jn> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.L == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || p0())) {
                    Q0();
                    this.e = null;
                }
            } else if (z3 && p0()) {
                this.e = null;
            }
            int size = z3 ? 0 : this.d.size();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.d.clear();
            bx6 c2 = this.q.c(z2, this.e, builder, !z3 ? 1 : 0);
            if (c2 != null) {
                list = c2.a;
                this.i = c2.b;
                i2 = c2.c;
                c2.c = 0;
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                this.d.addAll(list);
                V(list, size);
                P0(!z3 ? 1 : 0, list, size);
                if (this.E) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.e == null) {
                this.e = builder;
                this.b.j(builder.thread_list);
            }
            if (this.d.size() != 0) {
                if (z3) {
                    if (dataRes.live_answer != null) {
                        vw6 vw6Var = new vw6();
                        this.F = vw6Var;
                        vw6Var.e(dataRes.live_answer);
                        this.e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.F = null;
                        this.e.live_answer = null;
                    }
                    this.e.float_info = dataRes.float_info;
                }
                long m2 = ys4.k().m("key_maintab_banner_close_time", 0L);
                if (this.F != null && !StringHelper.isTaday(m2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.d.add(0, this.F);
                }
                LinkedList linkedList = new LinkedList(this.d);
                lw6 lw6Var = this.n;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                lw6Var.r(z5);
                this.n.y(linkedList, i2);
                j48 j48Var = this.w;
                if (j48Var != null && this.A) {
                    j48Var.n(this.x, this.y, this.v, true);
                }
                z5 = true;
            }
            qs6.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e2 = qs6.d().e(1);
            int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
            if (i3 > 0) {
                qs6.d().k(System.currentTimeMillis() - e2, 1);
                qs6.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                tn8.g(blockPopInfo);
            }
            bp4 bp4Var = new bp4();
            bp4Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, bp4Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                d85.b().D(System.currentTimeMillis() - e2);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public final void K0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, builder) == null) {
            pc5.b(new l(this, builder), null);
        }
    }

    public void L0(int i2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || ListUtils.isEmpty(this.d) || this.d.size() <= i2 || i2 < 0 || i2 < 0 || i3 < 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (i2 < this.d.size() && i2 <= i3) {
            if (this.d.get(i2).getType().getId() == ThreadData.TYPE_VIDEO_ALA_ONLIVE.getId() && (threadData = (ThreadData) this.d.get(i2)) != null && threadData.getThreadAlaInfo() != null) {
                arrayList.add(Long.valueOf(threadData.getThreadAlaInfo().live_id));
                arrayList2.add(threadData);
            }
            i2++;
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            j48 j48Var = this.w;
            if (j48Var != null && !this.z && this.A) {
                j48Var.n(this.x, this.y, this.v, true);
            }
            if (this.B) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                    boolean z2 = this.C;
                    if (z2) {
                        bf8.g().h(this.H, false);
                        if (q0(false)) {
                            a1(3, this.i);
                        } else if (this.D > 0) {
                            a1(2, this.i);
                        }
                    } else if (!z2 && this.i == 0) {
                        a1(2, 0);
                    }
                }
                this.B = false;
                this.C = false;
                this.D = 0;
                if (this.E) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
                this.E = false;
                t98 t98Var = this.P;
                if (t98Var != null) {
                    t98Var.d();
                }
            }
        }
    }

    public void N0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.H = bdUniqueId;
        CustomMessageListener customMessageListener = this.Z;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
        }
        CustomMessageListener customMessageListener2 = this.V;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
        this.b0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.b0);
        this.c0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.c0);
        MessageManager.getInstance().registerListener(2001336, this.c0);
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.a0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        j48 j48Var = this.w;
        if (j48Var != null) {
            j48Var.u(bdUniqueId);
        }
        this.b.i(bdUniqueId);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        this.m0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m0);
        this.n0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.n0);
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void P0(int i2, List<jn> list, int i3) {
        rg8 rg8Var;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) == null) || (rg8Var = this.r) == null) {
            return;
        }
        if (i2 == 0) {
            rg8Var.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = rg8.e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof rw5) && (i6 = i6 + 1) == i4 - 1) {
                int i8 = i7 + 1;
                if (i3 < i8) {
                    this.r.a(i4, i8);
                }
                i5++;
            }
        }
    }

    public final void Q0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (builder = this.e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        Z(builder2, list2 != null ? list2.size() : 0);
        pc5.b(new j(this, builder2), null);
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            dv6.c(this.k);
        }
    }

    public void S0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.G = z2;
            zc6 zc6Var = this.p;
            if (zc6Var == null || z2) {
                return;
            }
            zc6Var.d();
        }
    }

    public final void T0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            this.g = z2;
        }
    }

    public void U0(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, p0Var) == null) {
            this.c = p0Var;
        }
    }

    public final void V(List<jn> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i2) == null) {
            Set<jn> a2 = u68.a(list, this.f, "HOME");
            if (a2.size() > 0) {
                bf8.g().c(this.H, ze8.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.A = z2;
        }
    }

    public final gb5 W(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z2)) == null) {
            String e2 = u68.e(this.d, z2);
            int Y = Y(z2);
            gb5 gb5Var = new gb5();
            gb5Var.b = e2;
            gb5Var.a = Y;
            return gb5Var;
        }
        return (gb5) invokeZ.objValue;
    }

    public void W0(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, scrollFragmentTabHost) == null) {
            this.t = scrollFragmentTabHost;
            if (scrollFragmentTabHost == null) {
                return;
            }
            scrollFragmentTabHost.setOnTabSelectedListener(new k(this));
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            pc5.b(new t(this, i2), null);
        }
    }

    public void X0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.z = z2;
        }
    }

    public int Y(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z2)) == null) {
            List<jn> list = this.d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.d.size()) {
                    jn jnVar = (jn) db7.d(this.d, i4);
                    if ((jnVar instanceof rw5) && (i3 = ((rw5) jnVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((jnVar instanceof ow6) && jnVar.getType() != AdvertAppInfo.v) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    jn jnVar2 = (jn) db7.d(this.d, size);
                    if ((jnVar2 instanceof rw5) && (i2 = ((rw5) jnVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((jnVar2 instanceof ow6) && jnVar2.getType() != AdvertAppInfo.v) {
                        return i4;
                    }
                }
            }
            return this.d.size();
        }
        return invokeZ.intValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (!activityPrizeData.isSwitchTurn() || StringUtils.isNull(activityPrizeData.getFeedText())) {
                return;
            }
            String currentDay = UtilHelper.getCurrentDay();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            String str = "";
            String q2 = ys4.k().q("activity_prize_feed_text_time", "");
            boolean z2 = true;
            if (!StringUtils.isNull(q2)) {
                String[] split = q2.split("@");
                if (split != null && split.length == 2) {
                    String str2 = split[0];
                    String[] split2 = split[1].split(",");
                    if (!StringUtils.isNull(str2) && split2.length != 0) {
                        if (str2.equals(currentDay)) {
                            List<String> asList = Arrays.asList(split2);
                            if (asList.contains(currentAccount)) {
                                z2 = false;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(currentDay);
                                sb.append("@");
                                for (String str3 : asList) {
                                    sb.append(str3);
                                    sb.append(",");
                                }
                                sb.append(currentAccount);
                                str = sb.toString();
                            }
                        } else {
                            str = currentDay + "@" + currentAccount;
                        }
                    } else {
                        str = currentDay + "@" + currentAccount;
                    }
                } else {
                    str = currentDay + "@" + currentAccount;
                }
            } else {
                str = currentDay + "@" + currentAccount;
            }
            if (z2) {
                a1(4, 0);
                ys4.k().y("activity_prize_feed_text_time", str);
            }
        }
    }

    public final void Z(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048605, this, builder, i2) == null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = v68.b(next);
                if (b2 < 0) {
                    it.remove();
                } else if (b2 < i2 + i3 + 1) {
                    i3++;
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        builder.banner_list = builder2.build(false);
    }

    public final void Z0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            if (z2) {
                if (this.K == null) {
                    HomePageBrowseModelTipView homePageBrowseModelTipView = new HomePageBrowseModelTipView(this.j.getPageActivity());
                    this.K = homePageBrowseModelTipView;
                    homePageBrowseModelTipView.setListener(new m(this));
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setHeaderView(this.K, false);
                    this.K.setVisibility(0);
                    this.k.scrollToPosition(0);
                    return;
                }
                return;
            }
            HomePageBrowseModelTipView homePageBrowseModelTipView2 = this.K;
            if (homePageBrowseModelTipView2 != null) {
                this.k.removeHeaderView(homePageBrowseModelTipView2);
                this.K.setVisibility(8);
                this.K = null;
            }
        }
    }

    public final void a0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public final void a1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) || t0()) {
            return;
        }
        if (this.t != null) {
            this.p.f();
        }
        ScrollFragmentTabHost scrollFragmentTabHost = this.t;
        if (scrollFragmentTabHost != null && scrollFragmentTabHost.getCurrentTabType() != 1) {
            this.p.d();
        } else if (!this.G) {
            this.p.d();
        } else {
            String str = null;
            if (i2 == 2) {
                if (i3 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7f), Integer.valueOf(i3));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7e);
                }
            } else if (i2 == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7d);
            } else if (i2 == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText();
            }
            if (TextUtils.isEmpty(str) || !ji.z()) {
                return;
            }
            if (i2 == 4) {
                this.o = 3000;
            } else {
                this.o = 2000;
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.I;
            smartBubbleAnimatedView.a = str;
            smartBubbleAnimatedView.b = this.o;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            ScrollFragmentTabHost scrollFragmentTabHost2 = this.t;
            if (scrollFragmentTabHost2 != null) {
                FrameLayout frameLayout = scrollFragmentTabHost2.getFrameLayout();
                frameLayout.removeView(this.I);
                frameLayout.addView(this.I, layoutParams);
                this.I.g();
            }
        }
    }

    public final void b0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public final void b1(String str) {
        DataRes.Builder builder;
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || TextUtils.isEmpty(str) || (builder = this.e) == null || (bannerList = builder.banner_list) == null || (list = bannerList.app) == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (App app : this.e.banner_list.app) {
            if (app != null && str.equals(v68.a(app))) {
                arrayList.add(app);
            }
        }
        BannerList.Builder builder2 = new BannerList.Builder(this.e.banner_list);
        List<App> list2 = builder2.app;
        if (list2 != null) {
            list2.removeAll(arrayList);
        }
        this.e.banner_list = builder2.build(false);
        DataRes.Builder builder3 = new DataRes.Builder(this.e.build(true));
        builder3.banner_list = builder2.build(true);
        K0(builder3);
    }

    public final void c0(String str, List<jn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048611, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<jn> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                jn next = it.next();
                if (next instanceof ow6) {
                    advertAppInfo = ((ow6) next).e();
                } else if (next instanceof eo4) {
                    eo4 eo4Var = (eo4) next;
                    if (eo4Var.e() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) eo4Var.e()).getAdvertAppInfo();
                    }
                }
                if (advertAppInfo == null || !str.equals(advertAppInfo.a)) {
                }
            }
            return;
            it.remove();
        }
    }

    public final void c1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (builder = this.e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        Z(builder2, list2 != null ? list2.size() : 0);
        a0(builder2);
        b0(builder2);
        K0(builder2);
    }

    public void d0(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, l2) == null) || (builder = this.e) == null || (list = builder.thread_list) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ThreadInfo threadInfo = list.get(i2);
            if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                builder2.top_agree_post = null;
                list.set(i2, builder2.build(true));
                c1();
                J0(false, true, false, this.e.build(true));
                return;
            }
        }
    }

    public final void d1(UpdateAttentionMessage updateAttentionMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, updateAttentionMessage) == null) || updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().c)) {
            return;
        }
        pc5.b(new r(this, updateAttentionMessage.getData().c, updateAttentionMessage.getData().d), new s(this));
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            Iterator<jn> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof uw6) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            c1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> j02 = j0(bdTypeRecyclerView);
                int intValue = j02.get(0).intValue();
                int intValue2 = j02.get(1).intValue();
                if (intValue == -1 || intValue2 == -1) {
                    return;
                }
                this.k.F(intValue, intValue2);
            }
        }
    }

    public final void f0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.e) == null || ListUtils.getCount(builder.thread_list) == 0 || ListUtils.getCount(this.d) == 0) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("tid");
        if (StringUtils.isNull(optString)) {
            String optString2 = jSONObject.optString("liveid");
            if (this.k == null || TextUtils.isEmpty(optString2)) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.k.getCount()) {
                    break;
                }
                jn C = this.k.C(i2);
                if (C instanceof yw5) {
                    yw5 yw5Var = (yw5) C;
                    if (yw5Var.getThreadData() != null && yw5Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(yw5Var.getThreadData().getThreadAlaInfo().live_id))) {
                        optString = yw5Var.getThreadData().getTid();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<jn> it = this.d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jn next = it.next();
            if (next instanceof rw5) {
                rw5 rw5Var = (rw5) next;
                if (rw5Var.getThreadData() != null && rw5Var.getThreadData().getTid() != null) {
                    if (rw5Var.getThreadData().getTid().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        ax6.b(this.d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long g2 = jg.g(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.e.thread_list.size()) {
                ThreadInfo threadInfo = this.e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                    ix6.d(threadInfo.tid.longValue(), i3, this.e.thread_list, this.d);
                    this.e.thread_list.remove(i3);
                    c1();
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.k;
        if (bdTypeRecyclerView != null) {
            List<Integer> n02 = n0(optString, bdTypeRecyclerView);
            int intValue = n02.get(0).intValue();
            int intValue2 = n02.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.k.F(intValue, intValue2);
        }
    }

    public void g0(ev6 ev6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, ev6Var) == null) {
            pc5.b(new w(this), new x(this, ev6Var));
        }
    }

    public final ThreadCardViewHolder h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            j48 j48Var = this.w;
            if (j48Var == null || j48Var.j() == null || !(this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.w.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public final List<Integer> j0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                jn C = bdTypeRecyclerView.C(i4);
                if (C instanceof uw6) {
                    uw6 uw6Var = (uw6) C;
                    if (!z2) {
                        i2 = i4;
                    }
                    z2 = true;
                    i3 = i4;
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ft4.i k0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        ScrollFragmentTabHost scrollFragmentTabHost;
        String feedText;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048621, this)) != null) {
            return (ft4.i) invokeV.objValue;
        }
        if (!this.B || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || t0()) {
            return null;
        }
        int i2 = this.i;
        boolean z2 = this.C;
        if (z2) {
            bf8.g().h(this.H, false);
            if (q0(false)) {
                c2 = 3;
            } else if (this.D <= 0) {
                c2 = 0;
            }
            if (this.t != null) {
                this.p.f();
            }
            scrollFragmentTabHost = this.t;
            if (scrollFragmentTabHost == null && scrollFragmentTabHost.getCurrentTabType() != 1) {
                this.p.d();
                return null;
            } else if (this.G) {
                this.p.d();
                return null;
            } else {
                if (c2 == 2) {
                    if (i2 > 0) {
                        feedText = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7f), Integer.valueOf(i2));
                    } else {
                        feedText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7e);
                    }
                } else if (c2 == 3) {
                    feedText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f7d);
                } else {
                    feedText = c2 == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText() : null;
                }
                if (TextUtils.isEmpty(feedText) || !ji.z()) {
                    return null;
                }
                if (c2 == 4) {
                    this.o = 1000;
                } else {
                    this.o = 0;
                }
                return new ft4.i(feedText, this.o);
            }
        } else if (z2 || i2 != 0) {
            return null;
        } else {
            i2 = 0;
        }
        c2 = 2;
        if (this.t != null) {
        }
        scrollFragmentTabHost = this.t;
        if (scrollFragmentTabHost == null) {
        }
        if (this.G) {
        }
    }

    public j48 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.w : (j48) invokeV.objValue;
    }

    public t98 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.P : (t98) invokeV.objValue;
    }

    public final List<Integer> n0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048624, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                jn C = bdTypeRecyclerView.C(i4);
                if (C instanceof rw5) {
                    rw5 rw5Var = (rw5) C;
                    if (rw5Var.getThreadData() != null && rw5Var.getThreadData().getTid().equals(str)) {
                        if (!z2) {
                            i2 = i4;
                        }
                        z2 = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            rg8 rg8Var = new rg8("new_index", null);
            this.r = rg8Var;
            rg8Var.d();
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? q0(true) : invokeV.booleanValue;
    }

    public final boolean q0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z2)) == null) {
            ys4 k2 = ys4.k();
            long m2 = k2.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return m2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - m2) > this.a;
        }
        return invokeZ.booleanValue;
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? ys4.k().h(i0(), true) : invokeV.booleanValue;
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.J;
            return homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            g0(this.g0);
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            qs6.d().j(System.currentTimeMillis(), 1);
            this.f = 1;
            this.E = true;
            t98 t98Var = this.P;
            if (t98Var != null) {
                t98Var.e();
            }
            if (this.d.size() == 0 && !r0()) {
                if (!this.h) {
                    v0();
                    return;
                } else {
                    w0();
                    return;
                }
            }
            w0();
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.h = true;
            pc5.b(new h(this), new i(this));
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (MainTabDataSwitch.isCacheOpen()) {
                fx6.c().b(new e(this));
            } else {
                pc5.b(new f(this), new g(this));
            }
        }
    }

    public void x0() {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (s0()) {
                qs6.d().j(0L, 1);
            } else if (this.c != null) {
                I0();
                this.f++;
                T0(true);
                DataRes.Builder builder = this.e;
                this.c.d(this.f, (builder == null || (list = builder.thread_list) == null) ? 0 : list.size(), W(false), 0);
            }
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            d85.b().q(System.currentTimeMillis() - d85.b().c());
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            ys4.k().u(i0(), false);
        }
    }
}
