package d.a.s0.u0.e2;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.ILiveNPSPlugin;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.s0.u0.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f65869a;

    /* renamed from: b  reason: collision with root package name */
    public b2 f65870b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f65871c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f65872d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f65873e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f65874f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f65875g;

    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f65876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65877b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f65878c;

        public a(e eVar, View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65878c = eVar;
            this.f65876a = view;
            this.f65877b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f65878c.f65869a == null || this.f65878c.f65869a.B0() == null || this.f65878c.f65869a.B0().a0() == null || this.f65878c.f65869a.B0().V() == null) {
                return;
            }
            this.f65878c.f65869a.B0().a0().removeView(this.f65876a);
            this.f65878c.j(this.f65877b);
            this.f65878c.f65869a.B0().V().notifyDataSetChanged();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f65879a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f65881c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f65882d;

        public b(e eVar, String str, String str2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str, str2, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65882d = eVar;
            this.f65879a = str;
            this.f65880b = str2;
            this.f65881c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f65882d.k(this.f65879a, this.f65880b);
                this.f65881c.setVisibility(8);
                if (this.f65882d.f65869a.B0() == null || this.f65882d.f65869a.B0().V() == null) {
                    return;
                }
                this.f65882d.f65869a.B0().V().notifyDataSetChanged();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f65883a;

        /* renamed from: b  reason: collision with root package name */
        public String f65884b;

        /* renamed from: c  reason: collision with root package name */
        public String f65885c;

        /* renamed from: d  reason: collision with root package name */
        public String f65886d;

        /* renamed from: e  reason: collision with root package name */
        public String f65887e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f65888f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f65888f = eVar;
            this.f65883a = "";
            this.f65884b = "";
            this.f65885c = "";
            this.f65886d = "";
            this.f65887e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f65883a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f65884b = jSONObject.optString("tid", "");
                    this.f65885c = jSONObject.optString("fid", "");
                    this.f65886d = jSONObject.optString("liveId", "");
                    this.f65887e = jSONObject.optString("sid", "");
                } else if ((this.f65883a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f65883a)) && ((this.f65886d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f65886d)) && (this.f65887e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f65887e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f65884b);
                        jSONObject.put("fid", this.f65885c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f65888f.t(customResponsedMessage, false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65889a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f65889a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f65889a.n(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.a.s0.u0.e2.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1712e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65890a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1712e(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f65890a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f65890a.t(customResponsedMessage, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65891a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f65891a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f65891a.j(this.f65891a.u(customResponsedMessage));
                this.f65891a.f65869a.B0().V().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f65892e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f65893f;

        public g(e eVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65892e = i2;
            this.f65893f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                int i2 = this.f65892e;
                this.f65893f.getLayoutParams().height = i2 - ((int) (i2 * f2));
                this.f65893f.requestLayout();
            }
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f65894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
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
            this.f65894a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f65894a.f65869a == null || this.f65894a.f65869a.d0() == null || this.f65894a.f65869a.d0().d0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f65894a.m(str, this.f65894a.f65869a.d0().d0().getForum().getBannerListData().getAllAdvertList());
            e eVar = this.f65894a;
            eVar.l(str, eVar.f65869a.B0().a0().getData());
            e eVar2 = this.f65894a;
            eVar2.l(str, eVar2.f65869a.q0().f().z());
            this.f65894a.f65869a.d0().I(str);
            if (this.f65894a.f65869a.B0() == null || this.f65894a.f65869a.B0().V() == null) {
                return;
            }
            this.f65894a.f65869a.B0().V().notifyDataSetChanged();
        }
    }

    public e(l lVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65871c = new c(this, 2921547);
        this.f65872d = new d(this, 2921324);
        this.f65873e = new C1712e(this, 2016488);
        this.f65874f = new f(this, 2016553);
        this.f65875g = new h(this, 2016331);
        this.f65869a = lVar;
        this.f65873e.setTag(bdUniqueId);
        this.f65875g.setTag(bdUniqueId);
        this.f65872d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f65872d);
        MessageManager.getInstance().registerListener(this.f65873e);
        MessageManager.getInstance().registerListener(this.f65875g);
        this.f65874f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f65874f);
        this.f65871c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f65871c);
    }

    public final void i() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b2Var = this.f65870b) != null && b2Var.S1) {
            TbPageTag tbPageTag = null;
            l lVar = this.f65869a;
            if (lVar != null && lVar.B0() != null) {
                tbPageTag = d.a.r0.j0.c.k(this.f65869a.B0().U());
            }
            d.a.s0.u0.j2.a.i(this.f65870b, tbPageTag);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.f65869a.d0().d0().getThreadList();
        p(str, threadList);
        p(str, this.f65869a.B0().a0().getData());
        p(str, this.f65869a.q0().e());
        this.f65869a.d0().K(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f65869a.loadMore();
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ArrayList<d.a.c.k.e.n> threadList = this.f65869a.d0().d0().getThreadList();
            q(str, str2, threadList);
            q(str, str2, this.f65869a.B0().a0().getData());
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                this.f65869a.d0().J(str2);
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                this.f65869a.d0().K(str2);
            }
            if (threadList == null || threadList.size() >= 5) {
                return;
            }
            this.f65869a.loadMore();
        }
    }

    public final void l(String str, List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<d.a.c.k.e.n> it = list.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if (next instanceof d.a.s0.e.c) {
                Object b2 = ((d.a.s0.e.c) next).b();
                if ((b2 instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) b2).L3)) {
                    it.remove();
                }
            }
        }
    }

    public final void m(String str, List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, list) == null) || list == null || list.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null && str.equals(next.L3)) {
                it.remove();
            }
        }
    }

    public final void n(CustomResponsedMessage<?> customResponsedMessage) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f65869a) == null || lVar.d0() == null || this.f65869a.d0().d0() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f65869a.B0() == null || this.f65869a.B0().V() == null) {
            return;
        }
        View childAt = this.f65869a.B0().a0().getChildAt(s(optString, optString2, this.f65869a.B0().a0()));
        if (childAt != null) {
            o(childAt, new b(this, optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f65869a.B0().V().notifyDataSetChanged();
    }

    public final void o(View view, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, animationListener) == null) {
            g gVar = new g(this, view.getMeasuredHeight(), view);
            gVar.setAnimationListener(animationListener);
            gVar.setDuration(300L);
            view.startAnimation(gVar);
        }
    }

    public final void p(String str, List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.c.k.e.n nVar : list) {
            if (nVar instanceof a2) {
                b2 b2Var = ((a2) nVar).w;
                if (b2Var.n1() != null && b2Var.n1().equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        list.removeAll(arrayList);
        d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof u) {
            list.remove(nVar2);
        }
    }

    public final void q(String str, String str2, List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (d.a.c.k.e.n nVar : list) {
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                if (nVar instanceof d.a.s0.h3.h) {
                    arrayList.add((d.a.s0.h3.h) nVar);
                }
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type") && (nVar instanceof a2)) {
                b2 b2Var = ((a2) nVar).w;
                if (b2Var.n1() != null && b2Var.n1().equals(str2)) {
                    arrayList.add(b2Var);
                }
            }
        }
        list.removeAll(arrayList);
        d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(list, 0);
        if (nVar2 instanceof u) {
            list.remove(nVar2);
        }
    }

    public final int r(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i2 = 0;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getAdapter().getItemCount(); i3++) {
                d.a.c.k.e.n B = bdTypeRecyclerView.B(i3);
                if (B instanceof a2) {
                    b2 b2Var = ((a2) B).w;
                    if (b2Var.n1() != null && b2Var.n1().equals(str)) {
                        this.f65870b = b2Var;
                        i2 = i3;
                    }
                }
            }
            return (i2 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLL.intValue;
    }

    public final int s(String str, String str2, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, str2, bdTypeRecyclerView)) == null) {
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int i3 = 0;
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                i2 = 0;
                while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                    if (bdTypeRecyclerView.B(i3) instanceof d.a.s0.h3.h) {
                        i2 = i3;
                    }
                    i3++;
                }
            } else {
                if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                    i2 = 0;
                    while (i3 < bdTypeRecyclerView.getAdapter().getItemCount()) {
                        d.a.c.k.e.n B = bdTypeRecyclerView.B(i3);
                        if (B instanceof a2) {
                            b2 b2Var = ((a2) B).w;
                            if (b2Var.n1() != null && b2Var.n1().equals(str2)) {
                                i2 = i3;
                            }
                        }
                        i3++;
                    }
                }
                return (i3 + headerViewsCount) - firstVisiblePosition;
            }
            i3 = i2;
            return (i3 + headerViewsCount) - firstVisiblePosition;
        }
        return invokeLLL.intValue;
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage, boolean z) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, customResponsedMessage, z) == null) || (lVar = this.f65869a) == null || lVar.d0() == null || this.f65869a.d0().d0() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f65869a.B0() == null || this.f65869a.B0().V() == null) {
            return;
        }
        View childAt = this.f65869a.B0().a0().getChildAt(r(u, this.f65869a.B0().a0()));
        if (childAt != null) {
            o(childAt, new a(this, childAt, u));
        } else {
            j(u);
            this.f65869a.B0().V().notifyDataSetChanged();
        }
        if (z) {
            i();
        }
    }

    public final String u(CustomResponsedMessage customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, customResponsedMessage)) == null) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return null;
            }
            return ((JSONObject) customResponsedMessage.getData()).optString("tid");
        }
        return (String) invokeL.objValue;
    }
}
