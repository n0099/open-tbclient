package com.repackage;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DiscoverHotForum;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes5.dex */
public class bt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public o a;
    public final LinkedList<ro> b;
    public DataRes.Builder c;
    public DataRes.Builder d;
    public DataRes.Builder e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final BdTypeRecyclerView k;
    public final ys6 l;
    public m36 m;
    public boolean n;
    public final hu6 o;
    public int p;
    public BigdaySwipeRefreshLayout q;
    public int r;
    public List<np4> s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public RecyclerView.OnScrollListener v;
    public CustomMessageListener w;
    public View.OnTouchListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class a extends sd5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ bt6 b;

        public a(bt6 bt6Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bt6Var;
            this.a = builder;
        }

        @Override // com.repackage.sd5
        public Object doInBackground() {
            InterceptResult invokeV;
            DataRes build;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                mr4.f();
                qe<byte[]> e = mr4.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                try {
                    build = builder.build(true);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                    e.g("0", build.toByteArray());
                    bt6.T(this.b.f);
                    bt6.U(System.currentTimeMillis());
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ bt6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.f = bt6Var;
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
                    this.f.t(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.t(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.t(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                if (data.l != null) {
                    return;
                }
                if (!data.a) {
                    BdToast.h(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().b, R.drawable.obfuscated_res_0x7f0809be, 3000, true).q();
                } else if (data.d) {
                } else {
                    Iterator it = this.a.b.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if ((next instanceof yx5) && ThreadCardUtils.isTargetUser(((yx5) next).getThreadData(), data.c)) {
                            it.remove();
                        }
                    }
                    n98.c(this.a.b);
                    this.a.s.clear();
                    if (this.a.b.size() < 9) {
                        this.a.E();
                    } else {
                        bt6 bt6Var = this.a;
                        bt6Var.W(bt6Var.b);
                        this.a.l.d();
                        if (this.a.a != null) {
                            this.a.a.c(false, false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long) || this.a.c == null || this.a.c.hot_recomforum == null || ListUtils.isEmpty(this.a.c.hot_recomforum.tab_list)) {
                return;
            }
            long longValue = ((Long) customResponsedMessage.getData()).longValue();
            DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.a.c.hot_recomforum);
            if (at6.c(builder, longValue, customResponsedMessage.getCmd() == 2001335)) {
                this.a.c.hot_recomforum = builder.build(true);
                this.a.O(new DataRes.Builder(this.a.c.build(true)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        public h(bt6 bt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt6Var;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) && i == 0) {
                nx5.b().c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
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
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(bt6 bt6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var, Integer.valueOf(i)};
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
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.c == null || pd7.e(this.a.b)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            n98.d(str, this.a.b);
            n98.d(str, this.a.c.app_list);
            n98.d(str, this.a.s);
            n98.p(this.a.b);
            if (this.a.l != null) {
                this.a.l.j(new ArrayList(this.a.b));
            }
            bt6 bt6Var = this.a;
            bt6Var.r(bt6Var.b);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        public j(bt6 bt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.m != null) {
                    this.a.m.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends sd5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(bt6 bt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var};
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
        @Override // com.repackage.sd5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                mr4.f();
                mr4.a("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements zc5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        public l(bt6 bt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zc5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.a.J(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends sd5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(bt6 bt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var};
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
        @Override // com.repackage.sd5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                mr4.f();
                qe<byte[]> e = mr4.e("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                if (e != null && (bArr = e.get("0")) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e2) {
                        BdLog.e(e2);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements zc5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt6 a;

        public n(bt6 bt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zc5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.a.J(dataRes);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface o {
        void a(mc5 mc5Var);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, mc5 mc5Var);

        void onError(int i, String str);
    }

    public bt6(b9<?> b9Var, BdTypeRecyclerView bdTypeRecyclerView, ys6 ys6Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, bdTypeRecyclerView, ys6Var, bigdaySwipeRefreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new LinkedList<>();
        this.h = false;
        this.i = false;
        this.j = false;
        this.n = false;
        this.r = 0;
        this.s = new ArrayList();
        this.t = new f(this, 2001115);
        this.u = new g(this, 0);
        this.v = new h(this);
        this.w = new i(this, 2016331);
        this.x = new j(this);
        this.y = new b(this, 2921547);
        this.z = new c(this, 2016488);
        this.A = new d(this, 2016553);
        this.B = new e(this, 2921425);
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.x);
        this.m = new m36();
        this.o = new hu6();
        this.l = ys6Var;
        bdTypeRecyclerView.setOnScrollListener(this.v);
        this.q = bigdaySwipeRefreshLayout;
        R(false);
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? iu4.k().h(iu4.o("key_home_concern_all_status_cache_loaded"), false) : invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? UbsABTestHelper.isConcernForumCardShow() && iu4.k().l("key_home_concern_all_status", 0) == 0 : invokeV.booleanValue;
    }

    public static void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            iu4.k().u(iu4.o("key_home_concern_all_status_cache_loaded"), z);
        }
    }

    public static void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            iu4.k().y(iu4.o("key_home_concern_all_status_cache_nextpage_key"), str);
        }
    }

    public static void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            iu4.k().y(iu4.o("key_home_concern_all_status_cache_nextpage_update_key"), str);
        }
    }

    public static void U(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j2) == null) {
            iu4.k().x(iu4.o("key_home_concern_all_status_cache_time"), j2);
        }
    }

    public static String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? iu4.k().q(iu4.o("key_home_concern_all_status_cache_nextpage_key"), "") : (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? iu4.k().q(iu4.o("key_home_concern_all_status_cache_nextpage_update_key"), "") : (String) invokeV.objValue;
    }

    public static long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? iu4.k().m(iu4.o("key_home_concern_all_status_cache_time"), 0L) : invokeV.longValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h : invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long w = w();
            long j2 = currentTimeMillis - w;
            if (w != 0 && j2 <= 86400000) {
                vd5.b(new m(this), new n(this));
            } else {
                vd5.b(new k(this), new l(this));
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            mc5 q = q(true);
            o oVar = this.a;
            if (oVar != null) {
                oVar.a(q);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !B() && this.g) {
            mc5 q = q(false);
            if (this.a != null) {
                V(true);
                this.a.d(this.f, q);
            }
        }
    }

    public final List<ro> G(boolean z, DataRes.Builder builder, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), builder, Boolean.valueOf(z2)})) == null) {
            if (this.c == null) {
                this.c = new DataRes.Builder();
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            xy6 b2 = this.o.b(z, this.c, builder, !z2 ? 1 : 0);
            if (b2 != null) {
                return b2.a;
            }
            return null;
        }
        return (List) invokeCommon.objValue;
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public final void J(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            this.i = true;
            R(true);
            if (dataRes != null) {
                if (N(false, true, dataRes)) {
                    o oVar = this.a;
                    if (oVar != null) {
                        oVar.c(false, true);
                        return;
                    }
                    return;
                }
                E();
                return;
            }
            E();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.l.f();
        }
    }

    public void L(boolean z, DataRes dataRes, int i2, String str) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i2), str}) == null) {
            V(false);
            if (i2 == 0 && dataRes != null && N(true, z, dataRes)) {
                o oVar2 = this.a;
                if (oVar2 != null) {
                    oVar2.c(z, false);
                }
                if (z) {
                    a0();
                }
            } else if (i2 == 0 && ListUtils.getCount(this.b) == 0 && (oVar = this.a) != null) {
                oVar.b();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.q;
                if (bigdaySwipeRefreshLayout != null) {
                    bigdaySwipeRefreshLayout.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.b.size() > 0) {
                o oVar3 = this.a;
                if (oVar3 != null) {
                    oVar3.onError(1, str);
                }
            } else {
                o oVar4 = this.a;
                if (oVar4 != null) {
                    oVar4.onError(2, str);
                }
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.q;
            if (bigdaySwipeRefreshLayout2 != null) {
                bigdaySwipeRefreshLayout2.setRefreshing(false);
            }
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z) {
            this.l.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean N(boolean z, boolean z2, DataRes dataRes) {
        InterceptResult invokeCommon;
        boolean z3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dataRes})) == null) {
            if (dataRes == null) {
                return false;
            }
            int i3 = z2 ? 1 : this.r + 1;
            this.r = i3;
            int i4 = i3 == 1 ? 0 : pd7.i(this.b);
            this.f = dataRes.page_tag;
            this.e = new DataRes.Builder(dataRes);
            if (H()) {
                S(this.f);
            }
            LinkedList linkedList = new LinkedList();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.p = builder.user_tips_type.intValue();
            if (dataRes.req_unix != null) {
                iu4.k().x(iu4.o("concern_data_res_request_time"), dataRes.req_unix.longValue());
            }
            List<ro> G = G(z, builder, z2);
            x(G, builder, i4);
            this.j = false;
            if (G != null && TbadkCoreApplication.isLogin()) {
                if (ListUtils.isEmpty(G) || (ListUtils.getCount(G) == 1 && (ListUtils.getItem(G, 0) instanceof du6))) {
                    int i5 = this.p;
                    if (3 == i5) {
                        eu6 eu6Var = new eu6();
                        eu6Var.e = eu6.f;
                        eu6Var.a = 3;
                        G.add(eu6Var);
                        this.j = true;
                    } else if (2 == i5) {
                        eu6 eu6Var2 = new eu6();
                        eu6Var2.a = builder.user_tips_type.intValue();
                        eu6Var2.b = builder.user_tips;
                        if (builder.user_tips_type.intValue() == 4) {
                            eu6Var2.c = true;
                        } else {
                            eu6Var2.d = true;
                        }
                        if (H() && ((i2 = eu6Var2.a) == 2 || i2 == 3)) {
                            if (linkedList.size() > 0) {
                                eu6Var2.a = 0;
                                z3 = false;
                                if (z3) {
                                    linkedList.add(eu6Var2);
                                }
                            } else {
                                eu6Var2.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0420);
                            }
                        }
                        z3 = true;
                        if (z3) {
                        }
                    }
                }
                linkedList.addAll(G);
            }
            this.g = builder.has_more.intValue() == 1;
            if (ListUtils.isEmpty(linkedList)) {
                if (!this.b.isEmpty()) {
                    ro roVar = null;
                    Iterator<ro> it = this.b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ro next = it.next();
                        if (next instanceof wz4) {
                            roVar = next;
                            break;
                        }
                    }
                    if (roVar != null) {
                        this.b.remove(roVar);
                    }
                    this.l.j(this.b);
                }
                return false;
            }
            this.b.clear();
            this.b.addAll(linkedList);
            if (z2) {
                DataRes.Builder builder2 = this.c;
                builder2.page_tag = dataRes.page_tag;
                builder2.has_more = dataRes.has_more;
                builder2.user_list = dataRes.user_list;
                builder2.user_tips_type = dataRes.user_tips_type;
                builder2.user_tips = dataRes.user_tips;
                builder2.last_tips = dataRes.last_tips;
            }
            DataRes.Builder builder3 = this.c;
            builder3.banner_user_story = dataRes.banner_user_story;
            builder3.banner_follow_live = dataRes.banner_follow_live;
            builder3.hot_recomforum = dataRes.hot_recomforum;
            builder3.top_tips = dataRes.top_tips;
            builder3.top_user_info = dataRes.top_user_info;
            int i6 = this.p;
            if (i6 == 2 || i6 == 3) {
                DataRes.Builder builder4 = this.c;
                builder4.user_tips_type = dataRes.user_tips_type;
                builder4.user_tips = dataRes.user_tips;
            }
            this.l.j(this.b);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void O(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, builder) == null) && H()) {
            vd5.b(new a(this, builder), null);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            E();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.c = new DataRes.Builder(this.d.build(true));
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.h = z;
        }
    }

    public final void W(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.l.j(list);
        }
    }

    public void X(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, oVar) == null) {
            this.a = oVar;
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public void Z(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            this.z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.z);
            this.A.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.A);
            this.B.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.B);
            this.t.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.t);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
            this.u.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(2001335, this.u);
            MessageManager.getInstance().registerListener(2001336, this.u);
            this.w.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.w);
        }
    }

    public final void a0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (builder = this.e) == null) {
            return;
        }
        O(builder);
    }

    public final List<np4> b0(List<np4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (np4 np4Var : list) {
                if (np4Var instanceof AdvertAppInfo) {
                    arrayList.add(new ay5((AdvertAppInfo) np4Var));
                } else if (np4Var instanceof ay5) {
                    arrayList.add((ay5) np4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.d = new DataRes.Builder(this.c.build(true));
        }
    }

    public final mc5 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            String e2 = n98.e(this.b, z);
            mc5 mc5Var = new mc5();
            mc5Var.b = e2;
            return mc5Var;
        }
        return (mc5) invokeZ.objValue;
    }

    public final void r(List<ro> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            ub8.f().i("CONCERN", n98.b(list));
        }
    }

    public final void s() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (builder = this.c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.b) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.b.size()) {
                break;
            } else if (this.b.get(i2) instanceof du6) {
                this.b.remove(i2);
                ys6 ys6Var = this.l;
                if (ys6Var != null) {
                    ys6Var.j(this.b);
                }
            } else {
                i2++;
            }
        }
        for (int i3 = 0; i3 < this.c.thread_info.size(); i3++) {
            if (du6.k(this.c.thread_info.get(i3))) {
                this.c.thread_info.remove(i3);
                a0();
                return;
            }
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (builder = this.c) == null || ListUtils.getCount(builder.thread_info) == 0 || ListUtils.getCount(this.b) == 0) {
            return;
        }
        String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
        if (StringUtils.isNull(optString)) {
            return;
        }
        Iterator<ro> it = this.b.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ro next = it.next();
            if (next instanceof yx5) {
                yx5 yx5Var = (yx5) next;
                if (yx5Var.getThreadData() != null && yx5Var.getThreadData().getTid() != null) {
                    if (yx5Var.getThreadData().getTid().equals(optString)) {
                        it.remove();
                        z = true;
                    } else if (z) {
                        ys6 ys6Var = this.l;
                        if (ys6Var != null) {
                            ys6Var.j(this.b);
                        }
                    }
                }
            }
        }
        long g2 = kg.g(optString, 0L);
        for (int i2 = 0; i2 < this.c.thread_info.size(); i2++) {
            ConcernData concernData = this.c.thread_info.get(i2);
            if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                this.c.thread_info.remove(i2);
                a0();
                return;
            }
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (H() && !this.i) {
                D();
            } else {
                E();
            }
        }
    }

    public final void x(List<ro> list, DataRes.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, list, builder, i2) == null) {
            List<np4> b0 = b0(n98.h(builder.app_list, "CONCERN"));
            if (this.c == null) {
                this.c = new DataRes.Builder();
            }
            if (pd7.e(this.c.app_list)) {
                this.c.app_list = new ArrayList();
            }
            this.c.app_list.addAll(builder.app_list);
            if (this.r == 1 || i2 == 0) {
                this.s.clear();
            }
            b0.addAll(this.s);
            if (!pd7.e(b0)) {
                this.s = n98.i(b0, list, i2);
            }
            n98.p(list);
            n98.a(list, this.r, "CONCERN");
            r(list);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public void z(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, threadData) == null) {
            threadData.setFromConcern(true);
            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
            List<ro> e2 = this.o.e(threadData, -1, null);
            DataRes.Builder builder = this.c;
            if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.b) <= 1) {
                this.b.clear();
            }
            this.b.addAll(0, e2);
            this.l.j(this.b);
        }
    }
}
