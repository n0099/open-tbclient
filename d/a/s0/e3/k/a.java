package d.a.s0.e3.k;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.y1;
import d.a.r0.r.w.b.d;
import d.a.r0.r.w.b.e;
import d.a.s0.e3.j.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f59338e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<g> f59339f;

    /* renamed from: g  reason: collision with root package name */
    public CoverFlowView<g> f59340g;

    /* renamed from: h  reason: collision with root package name */
    public d<g> f59341h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f59342i;

    /* renamed from: d.a.s0.e3.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1414a implements d<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59343a;

        public C1414a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59343a = aVar;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i2));
                g gVar = (g) ListUtils.getItem(this.f59343a.f59339f, i2);
                String c2 = gVar != null ? gVar.c() : null;
                if (UrlManager.getInstance().dealOneLink(this.f59343a.f59342i, new String[]{str, null, makeStatisticsParam}) && i2 == 2 && !TextUtils.isEmpty(c2)) {
                    TiebaStatic.eventStat(this.f59343a.f59342i.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK", "task", "tbanner", "obj_id", String.valueOf(c2), "obj_name", String.valueOf(c2), "obj_cpid", 0, TiebaStatic.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), IAdRequestParam.OS, "android", HttpConstants.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
                }
                Activity pageActivity = this.f59343a.f59342i.getPageActivity();
                TiebaStatic.eventStat(pageActivity, "square_banner_picture", PrefetchEvent.STATE_CLICK, 1, "loc", (i2 - 1) + "");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, gVar) == null) || gVar == null) {
                return;
            }
            String c2 = gVar.c();
            if (i2 == 2 && !TextUtils.isEmpty(c2) && this.f59343a.f59338e.add(c2)) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(c2), "obj_name", String.valueOf(c2), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), IAdRequestParam.OS, "android", HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends d.a.r0.r.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59344a;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59344a = tbPageContext;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public d.a.r0.r.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.r0.r.w.b.c a2 = super.a();
                if (a2 != null) {
                    a2.d(85);
                    a2.e(R.dimen.ds20);
                    a2.f(R.dimen.ds30);
                }
                return a2;
            }
            return (d.a.r0.r.w.b.c) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a(this.f59344a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds330));
                return eVar;
            }
            return (e) invokeV.objValue;
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59338e = new HashSet<>();
        this.f59339f = new ArrayList<>();
        this.f59340g = null;
        this.f59341h = new C1414a(this);
        this.f59342i = tbPageContext;
        this.f59340g = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.f59340g.setCoverFlowFactory(new b(this, tbPageContext));
        this.f59340g.setCallback(this.f59341h);
    }

    public CoverFlowView<g> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59340g : (CoverFlowView) invokeV.objValue;
    }

    public void e(int i2) {
        CoverFlowView<g> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (coverFlowView = this.f59340g) == null) {
            return;
        }
        coverFlowView.s();
    }

    public void f(ArrayList<y1> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            ArrayList<g> arrayList2 = new ArrayList<>();
            Iterator<y1> it = arrayList.iterator();
            while (it.hasNext()) {
                y1 next = it.next();
                if (next != null) {
                    arrayList2.add(new g(next));
                }
            }
            this.f59339f = arrayList2;
            this.f59340g.setData(arrayList2);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<g> arrayList = this.f59339f;
            return (arrayList != null ? arrayList.size() + 0 : 0) > 0 ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? Integer.valueOf(i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) ? this.f59340g : (View) invokeILL.objValue;
    }
}
