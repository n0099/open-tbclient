package d.a.p0.u0.e2;

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
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.p0.u0.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public l f62650a;

    /* renamed from: b  reason: collision with root package name */
    public b2 f62651b;

    /* renamed from: c  reason: collision with root package name */
    public CustomMessageListener f62652c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f62653d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f62654e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f62655f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f62656g;

    /* loaded from: classes8.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f62657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62658b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f62659c;

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
            this.f62659c = eVar;
            this.f62657a = view;
            this.f62658b = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f62659c.f62650a == null || this.f62659c.f62650a.B0() == null || this.f62659c.f62650a.B0().b0() == null || this.f62659c.f62650a.B0().W() == null) {
                return;
            }
            this.f62659c.f62650a.B0().b0().removeView(this.f62657a);
            this.f62659c.j(this.f62658b);
            this.f62659c.f62650a.B0().W().notifyDataSetChanged();
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

    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f62660a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62661b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f62662c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f62663d;

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
            this.f62663d = eVar;
            this.f62660a = str;
            this.f62661b = str2;
            this.f62662c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f62663d.k(this.f62660a, this.f62661b);
                this.f62662c.setVisibility(8);
                if (this.f62663d.f62650a.B0() == null || this.f62663d.f62650a.B0().W() == null) {
                    return;
                }
                this.f62663d.f62650a.B0().W().notifyDataSetChanged();
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

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f62664a;

        /* renamed from: b  reason: collision with root package name */
        public String f62665b;

        /* renamed from: c  reason: collision with root package name */
        public String f62666c;

        /* renamed from: d  reason: collision with root package name */
        public String f62667d;

        /* renamed from: e  reason: collision with root package name */
        public String f62668e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f62669f;

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
            this.f62669f = eVar;
            this.f62664a = "";
            this.f62665b = "";
            this.f62666c = "";
            this.f62667d = "";
            this.f62668e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.f62664a = jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID, "");
                    this.f62665b = jSONObject.optString("tid", "");
                    this.f62666c = jSONObject.optString("fid", "");
                    this.f62667d = jSONObject.optString("liveId", "");
                    this.f62668e = jSONObject.optString("sid", "");
                } else if ((this.f62664a == null || !TextUtils.equals(jSONObject.optString(ILiveNPSPlugin.PARAMS_ROOM_ID), this.f62664a)) && ((this.f62667d == null || !TextUtils.equals(jSONObject.optString("liveId"), this.f62667d)) && (this.f62668e == null || !TextUtils.equals(jSONObject.optString("sid"), this.f62668e)))) {
                } else {
                    try {
                        jSONObject.put("tid", this.f62665b);
                        jSONObject.put("fid", this.f62666c);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f62669f.t(customResponsedMessage, false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62670a;

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
            this.f62670a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f62670a.n(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.a.p0.u0.e2.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1671e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62671a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1671e(e eVar, int i2) {
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
            this.f62671a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f62671a.t(customResponsedMessage, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62672a;

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
            this.f62672a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f62672a.j(this.f62672a.u(customResponsedMessage));
                this.f62672a.f62650a.B0().W().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends Animation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f62673e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f62674f;

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
            this.f62673e = i2;
            this.f62674f = view;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
                int i2 = this.f62673e;
                this.f62674f.getLayoutParams().height = i2 - ((int) (i2 * f2));
                this.f62674f.requestLayout();
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

    /* loaded from: classes8.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f62675a;

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
            this.f62675a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f62675a.f62650a == null || this.f62675a.f62650a.d0() == null || this.f62675a.f62650a.d0().d0() == null) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            this.f62675a.m(str, this.f62675a.f62650a.d0().d0().getForum().getBannerListData().getAllAdvertList());
            e eVar = this.f62675a;
            eVar.l(str, eVar.f62650a.B0().b0().getData());
            e eVar2 = this.f62675a;
            eVar2.l(str, eVar2.f62650a.q0().f().z());
            this.f62675a.f62650a.d0().I(str);
            if (this.f62675a.f62650a.B0() == null || this.f62675a.f62650a.B0().W() == null) {
                return;
            }
            this.f62675a.f62650a.B0().W().notifyDataSetChanged();
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
        this.f62652c = new c(this, 2921547);
        this.f62653d = new d(this, 2921324);
        this.f62654e = new C1671e(this, 2016488);
        this.f62655f = new f(this, 2016553);
        this.f62656g = new h(this, 2016331);
        this.f62650a = lVar;
        this.f62654e.setTag(bdUniqueId);
        this.f62656g.setTag(bdUniqueId);
        this.f62653d.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62653d);
        MessageManager.getInstance().registerListener(this.f62654e);
        MessageManager.getInstance().registerListener(this.f62656g);
        this.f62655f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62655f);
        this.f62652c.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62652c);
    }

    public final void i() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (b2Var = this.f62651b) != null && b2Var.S1) {
            TbPageTag tbPageTag = null;
            l lVar = this.f62650a;
            if (lVar != null && lVar.B0() != null) {
                tbPageTag = d.a.o0.j0.c.k(this.f62650a.B0().V());
            }
            d.a.p0.u0.j2.a.i(this.f62651b, tbPageTag);
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        ArrayList<d.a.c.k.e.n> threadList = this.f62650a.d0().d0().getThreadList();
        p(str, threadList);
        p(str, this.f62650a.B0().b0().getData());
        p(str, this.f62650a.q0().e());
        this.f62650a.d0().K(str);
        if (threadList == null || threadList.size() >= 5) {
            return;
        }
        this.f62650a.loadMore();
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            ArrayList<d.a.c.k.e.n> threadList = this.f62650a.d0().d0().getThreadList();
            q(str, str2, threadList);
            q(str, str2, this.f62650a.B0().b0().getData());
            if (str.equals("ala_frs_stage_live_feed_back_type")) {
                this.f62650a.d0().J(str2);
            } else if (str.equals("ala_frs_demo_hell_live_feed_back_type")) {
                this.f62650a.d0().K(str2);
            }
            if (threadList == null || threadList.size() >= 5) {
                return;
            }
            this.f62650a.loadMore();
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
            if (next instanceof d.a.p0.e.c) {
                Object b2 = ((d.a.p0.e.c) next).b();
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject) || (lVar = this.f62650a) == null || lVar.d0() == null || this.f62650a.d0().d0() == null) {
            return;
        }
        JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
        String optString = jSONObject.optString("type");
        if (StringUtils.isNull(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("tid");
        if (this.f62650a.B0() == null || this.f62650a.B0().W() == null) {
            return;
        }
        View childAt = this.f62650a.B0().b0().getChildAt(s(optString, optString2, this.f62650a.B0().b0()));
        if (childAt != null) {
            o(childAt, new b(this, optString, optString2, childAt));
            return;
        }
        k(optString, optString2);
        this.f62650a.B0().W().notifyDataSetChanged();
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
                if (nVar instanceof d.a.p0.h3.h) {
                    arrayList.add((d.a.p0.h3.h) nVar);
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
                        this.f62651b = b2Var;
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
                    if (bdTypeRecyclerView.B(i3) instanceof d.a.p0.h3.h) {
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
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, customResponsedMessage, z) == null) || (lVar = this.f62650a) == null || lVar.d0() == null || this.f62650a.d0().d0() == null) {
            return;
        }
        String u = u(customResponsedMessage);
        if (StringUtils.isNull(u) || this.f62650a.B0() == null || this.f62650a.B0().W() == null) {
            return;
        }
        View childAt = this.f62650a.B0().b0().getChildAt(r(u, this.f62650a.B0().b0()));
        if (childAt != null) {
            o(childAt, new a(this, childAt, u));
        } else {
            j(u);
            this.f62650a.B0().W().notifyDataSetChanged();
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
