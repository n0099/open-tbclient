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
import com.baidu.tbadk.core.liveremind.LiveRemindModel;
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
import com.repackage.fu4;
import com.repackage.ny;
import com.repackage.v36;
import com.repackage.vb8;
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
/* loaded from: classes5.dex */
public class dx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public ty6 F;
    public boolean G;
    public BdUniqueId H;
    public SmartBubbleAnimatedView I;
    public HomePageYoungsterTopView J;
    public HomePageBrowseModelTipView K;
    public int L;
    public BdUniqueId M;
    public ny.a N;
    public ThreadInfo O;
    public vb8 P;
    public LiveRemindModel Q;
    public mz4 R;
    public RecyclerView.OnScrollListener S;
    public View.OnTouchListener T;
    public v36.b U;
    public final vb8.b V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final CustomMessageListener Y;
    public final CustomMessageListener Z;
    public final long a;
    public CustomMessageListener a0;
    public final ax6 b;
    public CustomMessageListener b0;
    public p0 c;
    public CustomMessageListener c0;
    public final List<nn> d;
    public CustomMessageListener d0;
    public DataRes.Builder e;
    public String e0;
    public int f;
    public int f0;
    public boolean g;
    public Runnable g0;
    public boolean h;
    public cx6 h0;
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
    public final jy6 n;
    public CustomMessageListener n0;
    public int o;
    public za o0;
    public we6 p;
    public CustomMessageListener p0;
    public final xy6 q;
    public CustomMessageListener q0;
    public fi8 r;
    public final za r0;
    public k95 s;
    public CustomMessageListener s0;
    public mu6 t;
    public v36 u;
    public boolean v;
    public i68 w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public b(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder h0 = this.a.h0();
                if (h0 != null && h0.c() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(h0.c().o(new ny.a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ dx6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.f = dx6Var;
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

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public c(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.e == null || ListUtils.getCount(this.a.e.thread_list) == 0) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            dx6 dx6Var = this.a;
            dx6Var.c0(str, dx6Var.d);
            this.a.b1(str);
            if (this.a.n != null) {
                this.a.n.y(new ArrayList(this.a.d));
            }
            if (this.a.w == null || !this.a.A) {
                return;
            }
            this.a.w.n(this.a.x, this.a.y, this.a.v, true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public d(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.l == null) {
                return;
            }
            fu4.i k0 = this.a.k0();
            if (!this.a.l.u() || k0 == null || TbSingleton.getInstance().isBrowseMode()) {
                this.a.l.setRefreshing(false);
            } else {
                this.a.l.z(k0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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
                h0.c().o(new ny.a(3));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public e(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class e0 extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(dx6 dx6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = dx6Var;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            w17 w17Var;
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
            for (nn nnVar : this.a.d) {
                if ((nnVar instanceof v17) && (w17Var = ((v17) nnVar).X) != null && j2 == w17Var.b) {
                    w17Var.c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
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
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Boolean.valueOf(cz6.m().l()) : (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public f0(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class g implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public g(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || bool == null || bool.booleanValue() || this.a.c == null) {
                return;
            }
            this.a.c.b((this.a.e == null || this.a.e.thread_list == null || this.a.p0()) ? 0 : this.a.e.thread_list.size(), this.a.W(true), 0);
        }
    }

    /* loaded from: classes5.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* loaded from: classes5.dex */
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
                    this.a.a.n.l();
                    if (this.a.a.z || !this.a.a.A) {
                        return;
                    }
                    this.a.a.w.n(this.a.a.x, this.a.a.y, this.a.a.v, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<nn> h = this.a.n.h();
                if (!ListUtils.isEmpty(h)) {
                    for (nn nnVar : h) {
                        if (nnVar instanceof vy5) {
                            vy5 vy5Var = (vy5) nnVar;
                            if (vy5Var.j != 0 && (threadData = vy5Var.a) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                vy5Var.j = imageWidthAndHeight[0];
                                vy5Var.k = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                qg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends de5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public h(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            DataRes k;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (MainTabDataSwitch.isCacheOpen()) {
                    k = dz6.c().a();
                } else {
                    k = cz6.m().k();
                }
                this.a.B0(k);
                return k;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yp4)) {
                yp4 yp4Var = (yp4) customResponsedMessage.getData();
                if (yp4Var.a != 1) {
                    return;
                }
                int k = pi.k(TbadkCoreApplication.getInst());
                int i = pi.i(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.a.M);
                requestGetMyPostNetMessage.setParams(ng.g(yp4Var.c, 0L), 0L, 0L, k, i, f, i2);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements jd5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* loaded from: classes5.dex */
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
                this.a.a.m.z0();
            }
        }

        public i(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) && dataRes != null && MainTabDataSwitch.isCacheOpen()) {
                dz6.c().g(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(dx6 dx6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = dx6Var;
        }

        @Override // com.repackage.za
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

    /* loaded from: classes5.dex */
    public class j extends de5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ dx6 b;

        public j(dx6 dx6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx6Var;
            this.a = builder;
        }

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                br4.f();
                try {
                    br4.e("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if (UbsABTestHelper.isPushOpenNewStyle()) {
                    if (nz4.g(TbadkCoreApplication.getInst(), 1)) {
                        dx6 dx6Var = this.a;
                        dx6Var.R = nz4.i(dx6Var.j, "homepage", 0L);
                    }
                } else if (kz4.g(TbadkCoreApplication.getInst(), 1)) {
                    kz4.i(this.a.j, 7, 0L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ScrollFragmentTabHost.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public k(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.z
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.t.d(i) == 1 || this.a.p == null) {
                return;
            }
            this.a.p.d();
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements v36.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public k0(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // com.repackage.v36.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.v = false;
            }
        }

        @Override // com.repackage.v36.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.v = true;
            }
        }

        @Override // com.repackage.v36.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.v36.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends de5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ dx6 b;

        public l(dx6 dx6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx6Var;
            this.a = builder;
        }

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                br4.f();
                try {
                    br4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements vb8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public l0(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // com.repackage.vb8.b
        public void a(yb8 yb8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, yb8Var) == null) || this.a.k == null || this.a.q == null) {
                return;
            }
            this.a.q.j(this.a.d, yb8Var, this.a.k.getFirstVisiblePosition());
            this.a.n.y(this.a.d);
        }

        @Override // com.repackage.vb8.b
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public m(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.j, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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
                if (threadInfo != null && threadInfo.id.longValue() == ng.g(threadData.getId(), -1L)) {
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

    /* loaded from: classes5.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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

    /* loaded from: classes5.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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
                    this.a.n.y(new ArrayList(this.a.d));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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
                if (threadInfo == null || (user = threadInfo.author) == null || user.id.longValue() != ng.g(updateAttentionMessage.getData().c, -1L)) {
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

    /* loaded from: classes5.dex */
    public interface p0 {
        void a(boolean z);

        void b(int i, wc5 wc5Var, int i2);

        void c();

        void d(int i, int i2, wc5 wc5Var, int i3);

        void onError(int i, String str);
    }

    /* loaded from: classes5.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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
            if (vs6.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.a.e.hot_recomforum = builder.build(true);
                this.a.K0(new DataRes.Builder(this.a.e.build(true)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ dx6 c;

        public r(dx6 dx6Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dx6Var;
            this.a = str;
            this.b = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            int intValue;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    br4.f();
                    te<byte[]> e = br4.e("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount());
                    if (e == null) {
                        return Boolean.FALSE;
                    }
                    byte[] bArr = e.get("0");
                    if (bArr != null && bArr.length != 0) {
                        DataRes.Builder builder = new DataRes.Builder((DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class));
                        if (builder.thread_list != null && builder.thread_list.size() > 0) {
                            for (int i = 0; i < builder.thread_list.size(); i++) {
                                ThreadInfo threadInfo = builder.thread_list.get(i);
                                if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == ng.g(this.a, -1L)) {
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

    /* loaded from: classes5.dex */
    public class s implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
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
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t extends de5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ dx6 b;

        public t(dx6 dx6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dx6Var;
            this.a = i;
        }

        @Override // com.repackage.de5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                br4.f();
                te<String> h = br4.h(this.b.e0, TbadkCoreApplication.getCurrentAccount());
                if (h != null) {
                    h.e(this.b.e0, Integer.toString(this.a), 43200000L);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class u extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public final /* synthetic */ dx6 d;

        public u(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dx6Var;
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
                this.d.f0 = i;
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
                    this.d.s = new k95();
                    this.d.s.a(1005);
                    this.d.s.e = 1;
                }
                if (i == 0) {
                    bx6.b(this.d.k);
                    this.d.s.e();
                    cy5.b().d(true);
                    ak5.c().h("page_recommend", "show_");
                    pg8.g().h(this.d.H, false);
                    this.c = false;
                    if (this.d.w == null || !this.d.A || this.d.z) {
                        return;
                    }
                    this.d.w.m(this.d.x, this.d.y, this.d.v, 1);
                    this.d.w.p(2);
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

    /* loaded from: classes5.dex */
    public class v implements cx6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* loaded from: classes5.dex */
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

        public v(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        @Override // com.repackage.cx6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.g0 == null) {
                    this.a.g0 = new a(this, i);
                }
                this.a.k.removeCallbacks(this.a.g0);
                this.a.k.post(this.a.g0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w extends de5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        public w(dx6 dx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                br4.f();
                te<String> h = br4.h(this.a.e0, TbadkCoreApplication.getCurrentAccount());
                if (h != null) {
                    return h.get(this.a.e0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements jd5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cx6 a;

        public x(dx6 dx6Var, cx6 cx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, cx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cx6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            cx6 cx6Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (cx6Var = this.a) == null) {
                return;
            }
            cx6Var.a(ng.e(str, 0));
        }
    }

    /* loaded from: classes5.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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
            this.a.n.y(new ArrayList(this.a.d));
            xt4.k().x("key_maintab_banner_close_time", System.currentTimeMillis());
        }
    }

    /* loaded from: classes5.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(dx6 dx6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx6Var, Integer.valueOf(i)};
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
            this.a = dx6Var;
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

    public dx6(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, jy6 jy6Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, jy6Var, bigdaySwipeRefreshLayout, personalizePageView};
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
        this.N = new ny.a(2);
        this.O = null;
        this.S = new u(this);
        this.T = new f0(this);
        this.U = new k0(this);
        this.V = new l0(this);
        this.W = new m0(this, 2001399);
        this.X = new n0(this, 2921461);
        this.Y = new o0(this, 2921486);
        this.Z = new a(this, 2921562);
        this.a0 = new n(this, 2004004);
        this.b0 = new o(this, 2921026);
        this.c0 = new p(this, 2001115);
        this.d0 = new q(this, 0);
        this.e0 = "lastReadReadPositionKey";
        this.f0 = 0;
        this.h0 = new v(this);
        this.i0 = new y(this, 2016569);
        this.j0 = new z(this, 2016488);
        this.k0 = new a0(this, 2016553);
        this.l0 = new b0(this, 2921547);
        this.m0 = new c0(this, 2016331);
        this.n0 = new d0(this, 2921381);
        this.o0 = new e0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.p0 = new g0(this, 2921414);
        this.q0 = new h0(this, 2921453);
        this.r0 = new i0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.s0 = new j0(this, 2921482);
        this.j = tbPageContext;
        this.L = xt4.k().l("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.m = personalizePageView;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.T);
        v36 v36Var = new v36();
        this.u = v36Var;
        v36Var.d(this.U);
        this.n = jy6Var;
        this.q = new xy6();
        this.a = xt4.k().m("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.S);
        this.p = new we6();
        o0();
        i68 i68Var = new i68(this.j, this.k);
        this.w = i68Var;
        i68Var.p(2);
        this.w.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.b = new ax6(this.d, this.n);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.I = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, pi.f(tbPageContext.getContext(), R.dimen.tbds83)));
        O0();
        this.p0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.p0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.r0.setTag(this.M);
        if (this.r0.getHttpMessageListener() != null) {
            this.r0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.r0.getSocketMessageListener() != null) {
            this.r0.getSocketMessageListener().setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.r0);
        MessageManager.getInstance().registerListener(this.q0);
        MessageManager.getInstance().registerListener(this.s0);
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) {
            this.z = z2;
            mu6 mu6Var = this.t;
            if (mu6Var != null) {
                mu6Var.f(z2);
            }
            i68 i68Var = this.w;
            if (i68Var == null) {
                return;
            }
            i68Var.r(!z2);
            ThreadCardViewHolder h02 = h0();
            boolean z3 = false;
            if (h02 != null && h02.c() != null) {
                z3 = h02.c().o(new ny.a(8, Boolean.valueOf(z2)));
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
                    vb8 vb8Var = new vb8();
                    this.P = vb8Var;
                    vb8Var.h(this.V);
                }
                this.P.g();
            }
            mz4 mz4Var = this.R;
            if (mz4Var != null) {
                mz4Var.q();
            }
        }
    }

    public final void B0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            this.h = true;
            if (dataRes != null) {
                jz6.a("cacheSuccess");
                J0(false, true, true, dataRes);
                p0 p0Var = this.c;
                if (p0Var != null) {
                    p0Var.a(true);
                    y0();
                    return;
                }
                jz6.a("errorNetLoadCallback");
                return;
            }
            jz6.a("cacheFail");
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
            mz4 mz4Var = this.R;
            if (mz4Var != null) {
                mz4Var.v();
            }
        }
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            i68 i68Var = this.w;
            if (i68Var != null) {
                i68Var.h();
            }
            we6 we6Var = this.p;
            if (we6Var != null) {
                we6Var.e();
            }
            ax6 ax6Var = this.b;
            if (ax6Var != null) {
                ax6Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.g0);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.p0);
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.r0);
            MessageManager.getInstance().unRegisterListener(this.s0);
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
                fx6.a();
            }
            xy6 xy6Var = this.q;
            if (xy6Var != null && xy6Var.k() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
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
                        ug.b(new c(this));
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
                            xt4 k2 = xt4.k();
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
                    ug.b(new d(this));
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
            ug.b(new d(this));
        }
    }

    public void F0(int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            fi8 fi8Var = this.r;
            if ((fi8Var != null ? fi8Var.b(i2) : -1) >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.r.c(i2);
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            bx6.b(this.k);
            X(this.f0);
            k95 k95Var = this.s;
            if (k95Var != null) {
                k95Var.c();
            }
        }
    }

    public void H0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && z2) {
            this.n.l();
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (ListUtils.getCount(this.d) < this.q.e() - 40) {
                return;
            }
            List<nn> list = null;
            zy6 c2 = this.q.c(true, this.e, null, 1);
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
                this.n.z(new LinkedList(this.d), i2);
            }
        }
    }

    public final boolean J0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        List<nn> list;
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
            zy6 c2 = this.q.c(z2, this.e, builder, !z3 ? 1 : 0);
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
                        ty6 ty6Var = new ty6();
                        this.F = ty6Var;
                        ty6Var.c(dataRes.live_answer);
                        this.e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.F = null;
                        this.e.live_answer = null;
                    }
                    this.e.float_info = dataRes.float_info;
                }
                long m2 = xt4.k().m("key_maintab_banner_close_time", 0L);
                if (this.F != null && !StringHelper.isTaday(m2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.d.add(0, this.F);
                }
                LinkedList linkedList = new LinkedList(this.d);
                jy6 jy6Var = this.n;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                jy6Var.s(z5);
                this.n.z(linkedList, i2);
                i68 i68Var = this.w;
                if (i68Var != null && this.A) {
                    i68Var.n(this.x, this.y, this.v, true);
                }
                z5 = true;
            }
            ku6.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e2 = ku6.d().e(1);
            int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
            if (i3 > 0) {
                ku6.d().k(System.currentTimeMillis() - e2, 1);
                ku6.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                xo8.g(blockPopInfo);
            }
            aq4 aq4Var = new aq4();
            aq4Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, aq4Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                s95.b().D(System.currentTimeMillis() - e2);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public final void K0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, builder) == null) {
            he5.b(new l(this, builder), null);
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
            i68 i68Var = this.w;
            if (i68Var != null && !this.z && this.A) {
                i68Var.n(this.x, this.y, this.v, true);
            }
            if (this.B) {
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
                if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                    boolean z2 = this.C;
                    if (z2) {
                        pg8.g().h(this.H, false);
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
                vb8 vb8Var = this.P;
                if (vb8Var != null) {
                    vb8Var.d();
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
        CustomMessageListener customMessageListener = this.a0;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
        }
        CustomMessageListener customMessageListener2 = this.W;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
        }
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.c0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.c0);
        this.d0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.d0);
        MessageManager.getInstance().registerListener(2001336, this.d0);
        this.b0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.b0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        this.m0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m0);
        i68 i68Var = this.w;
        if (i68Var != null) {
            i68Var.u(bdUniqueId);
        }
        this.b.i(bdUniqueId);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.n0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.n0);
        this.o0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.o0);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
        this.Z.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Z);
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void P0(int i2, List<nn> list, int i3) {
        fi8 fi8Var;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) == null) || (fi8Var = this.r) == null) {
            return;
        }
        if (i2 == 0) {
            fi8Var.d();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = fi8.e;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
            if ((list.get(i7) instanceof ny5) && (i6 = i6 + 1) == i4 - 1) {
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
        he5.b(new j(this, builder2), null);
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            bx6.c(this.k);
        }
    }

    public void S0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.G = z2;
            we6 we6Var = this.p;
            if (we6Var == null || z2) {
                return;
            }
            we6Var.d();
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

    public final void V(List<nn> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, list, i2) == null) {
            Set<nn> a2 = w88.a(list, this.f, "HOME");
            if (a2.size() > 0) {
                pg8.g().c(this.H, ng8.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.A = z2;
        }
    }

    public final wc5 W(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z2)) == null) {
            String e2 = w88.e(this.d, z2);
            int Y = Y(z2);
            wc5 wc5Var = new wc5();
            wc5Var.b = e2;
            wc5Var.a = Y;
            return wc5Var;
        }
        return (wc5) invokeZ.objValue;
    }

    public void W0(mu6 mu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mu6Var) == null) {
            this.t = mu6Var;
            if (mu6Var == null) {
                return;
            }
            mu6Var.setOnTabSelectedListener(new k(this));
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            he5.b(new t(this, i2), null);
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
            List<nn> list = this.d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.d.size()) {
                    nn nnVar = (nn) gd7.d(this.d, i4);
                    if ((nnVar instanceof ny5) && (i3 = ((ny5) nnVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((nnVar instanceof my6) && nnVar.getType() != AdvertAppInfo.v) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    nn nnVar2 = (nn) gd7.d(this.d, size);
                    if ((nnVar2 instanceof ny5) && (i2 = ((ny5) nnVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((nnVar2 instanceof my6) && nnVar2.getType() != AdvertAppInfo.v) {
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
            String q2 = xt4.k().q("activity_prize_feed_text_time", "");
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
                xt4.k().y("activity_prize_feed_text_time", str);
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
                int b2 = x88.b(next);
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
        mu6 mu6Var = this.t;
        if (mu6Var != null && mu6Var.getCurrentTabType() != 1) {
            this.p.d();
        } else if (!this.G) {
            this.p.d();
        } else {
            String str = null;
            if (i2 == 2) {
                if (i3 > 0) {
                    str = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f85), Integer.valueOf(i3));
                } else {
                    str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f84);
                }
            } else if (i2 == 3) {
                str = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f83);
            } else if (i2 == 4) {
                str = TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText();
            }
            if (TextUtils.isEmpty(str) || !ni.z()) {
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
            mu6 mu6Var2 = this.t;
            if (mu6Var2 != null) {
                FrameLayout frameLayout = mu6Var2.getFrameLayout();
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
            if (app != null && str.equals(x88.a(app))) {
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

    public final void c0(String str, List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048611, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<nn> it = list.iterator();
        while (true) {
            AdvertAppInfo advertAppInfo = null;
            while (it.hasNext()) {
                nn next = it.next();
                if (next instanceof my6) {
                    advertAppInfo = ((my6) next).c();
                } else if (next instanceof dp4) {
                    dp4 dp4Var = (dp4) next;
                    if (dp4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) dp4Var.c()).getAdvertAppInfo();
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
        he5.b(new r(this, updateAttentionMessage.getData().c, updateAttentionMessage.getData().d), new s(this));
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            Iterator<nn> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof sy6) {
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
                this.k.E(intValue, intValue2);
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
                nn B = this.k.B(i2);
                if (B instanceof uy5) {
                    uy5 uy5Var = (uy5) B;
                    if (uy5Var.getThreadData() != null && uy5Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(uy5Var.getThreadData().getThreadAlaInfo().live_id))) {
                        optString = uy5Var.getThreadData().getTid();
                        break;
                    }
                }
                i2++;
            }
            if (StringUtils.isNull(optString)) {
                return;
            }
        }
        Iterator<nn> it = this.d.iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            nn next = it.next();
            if (next instanceof ny5) {
                ny5 ny5Var = (ny5) next;
                if (ny5Var.getThreadData() != null && ny5Var.getThreadData().getTid() != null) {
                    if (ny5Var.getThreadData().getTid().equals(optString)) {
                        it.remove();
                        z2 = true;
                    } else if (z2) {
                        yy6.b(this.d);
                        break;
                    }
                }
            }
        }
        DataRes.Builder builder2 = this.e;
        if (builder2 == null || builder2.thread_list == null) {
            return;
        }
        long g2 = ng.g(optString, 0L);
        int i3 = 0;
        while (true) {
            if (i3 < this.e.thread_list.size()) {
                ThreadInfo threadInfo = this.e.thread_list.get(i3);
                if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                    gz6.d(threadInfo.tid.longValue(), i3, this.e.thread_list, this.d);
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
            this.k.E(intValue, intValue2);
        }
    }

    public void g0(cx6 cx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, cx6Var) == null) {
            he5.b(new w(this), new x(this, cx6Var));
        }
    }

    public final ThreadCardViewHolder h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            i68 i68Var = this.w;
            if (i68Var == null || i68Var.j() == null || !(this.w.j().getTag() instanceof ThreadCardViewHolder)) {
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
                nn B = bdTypeRecyclerView.B(i4);
                if (B instanceof sy6) {
                    sy6 sy6Var = (sy6) B;
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
    public final fu4.i k0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        mu6 mu6Var;
        String feedText;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048621, this)) != null) {
            return (fu4.i) invokeV.objValue;
        }
        if (!this.B || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || t0()) {
            return null;
        }
        int i2 = this.i;
        boolean z2 = this.C;
        if (z2) {
            pg8.g().h(this.H, false);
            if (q0(false)) {
                c2 = 3;
            } else if (this.D <= 0) {
                c2 = 0;
            }
            if (this.t != null) {
                this.p.f();
            }
            mu6Var = this.t;
            if (mu6Var == null && mu6Var.getCurrentTabType() != 1) {
                this.p.d();
                return null;
            } else if (this.G) {
                this.p.d();
                return null;
            } else {
                if (c2 == 2) {
                    if (i2 > 0) {
                        feedText = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f85), Integer.valueOf(i2));
                    } else {
                        feedText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f84);
                    }
                } else if (c2 == 3) {
                    feedText = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f83);
                } else {
                    feedText = c2 == 4 ? TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText() : null;
                }
                if (TextUtils.isEmpty(feedText) || !ni.z()) {
                    return null;
                }
                if (c2 == 4) {
                    this.o = 1000;
                } else {
                    this.o = 0;
                }
                return new fu4.i(feedText, this.o);
            }
        } else if (z2 || i2 != 0) {
            return null;
        } else {
            i2 = 0;
        }
        c2 = 2;
        if (this.t != null) {
        }
        mu6Var = this.t;
        if (mu6Var == null) {
        }
        if (this.G) {
        }
    }

    public i68 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.w : (i68) invokeV.objValue;
    }

    public vb8 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.P : (vb8) invokeV.objValue;
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
                nn B = bdTypeRecyclerView.B(i4);
                if (B instanceof ny5) {
                    ny5 ny5Var = (ny5) B;
                    if (ny5Var.getThreadData() != null && ny5Var.getThreadData().getTid().equals(str)) {
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
            fi8 fi8Var = new fi8("new_index", null);
            this.r = fi8Var;
            fi8Var.d();
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
            xt4 k2 = xt4.k();
            long m2 = k2.m("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            return m2 == 0 ? z2 : Math.abs(System.currentTimeMillis() - m2) > this.a;
        }
        return invokeZ.booleanValue;
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? xt4.k().h(i0(), true) : invokeV.booleanValue;
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
            g0(this.h0);
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            ku6.d().j(System.currentTimeMillis(), 1);
            this.f = 1;
            this.E = true;
            vb8 vb8Var = this.P;
            if (vb8Var != null) {
                vb8Var.e();
            }
            if (TbSingleton.getInstance().getIsNeedRemindLiveRoom()) {
                LiveRemindModel liveRemindModel = new LiveRemindModel(this.n.i(), this.M);
                this.Q = liveRemindModel;
                liveRemindModel.B();
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
            he5.b(new h(this), new i(this));
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (MainTabDataSwitch.isCacheOpen()) {
                dz6.c().b(new e(this));
            } else {
                he5.b(new f(this), new g(this));
            }
        }
    }

    public void x0() {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (s0()) {
                ku6.d().j(0L, 1);
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
            s95.b().q(System.currentTimeMillis() - s95.b().c());
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            xt4.k().u(i0(), false);
        }
    }
}
