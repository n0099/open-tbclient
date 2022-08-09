package com.repackage;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ki8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<String> a;
    public ArrayList<ii8> b;
    public CoverFlowView<ii8> c;
    public us4<ii8> d;
    public TbPageContext<?> e;

    /* loaded from: classes6.dex */
    public class a implements us4<ii8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ki8 a;

        public a(ki8 ki8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ki8Var;
        }

        @Override // com.repackage.us4
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
                ii8 ii8Var = (ii8) ListUtils.getItem(this.a.b, i);
                String c = ii8Var != null ? ii8Var.c() : null;
                if (UrlManager.getInstance().dealOneLink(this.a.e, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(c)) {
                    TiebaStatic.eventStat(this.a.e.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "CLICK", "task", "tbanner", "obj_id", String.valueOf(c), "obj_name", String.valueOf(c), "obj_cpid", 0, TiebaStatic.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", HttpConstants.OS_VERSION, Build.VERSION.RELEASE, "log_ver", "1.1");
                }
                Activity pageActivity = this.a.e.getPageActivity();
                TiebaStatic.eventStat(pageActivity, "square_banner_picture", "click", 1, "loc", (i - 1) + "");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.us4
        /* renamed from: c */
        public void a(int i, ii8 ii8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ii8Var) == null) || ii8Var == null) {
                return;
            }
            String c = ii8Var.c();
            if (i == 2 && !TextUtils.isEmpty(c) && this.a.a.add(c)) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "VIEW_TRUE", "task", "tbanner", "obj_id", String.valueOf(c), "obj_name", String.valueOf(c), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), "os", "android", HttpConstants.OS_VERSION, Build.VERSION.RELEASE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ss4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(ki8 ki8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.repackage.ss4, com.repackage.qs4
        public ts4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ts4 a = super.a();
                if (a != null) {
                    a.d(85);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                    a.f(R.dimen.obfuscated_res_0x7f070201);
                }
                return a;
            }
            return (ts4) invokeV.objValue;
        }

        @Override // com.repackage.ss4, com.repackage.qs4
        public vs4 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                vs4 vs4Var = new vs4();
                vs4Var.a(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a2));
                return vs4Var;
            }
            return (vs4) invokeV.objValue;
        }
    }

    public ki8(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashSet<>();
        this.b = new ArrayList<>();
        this.c = null;
        this.d = new a(this);
        this.e = tbPageContext;
        this.c = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.c.setCoverFlowFactory(new b(this, tbPageContext));
        this.c.setCallback(this.d);
    }

    public CoverFlowView<ii8> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (CoverFlowView) invokeV.objValue;
    }

    public void e(int i) {
        CoverFlowView<ii8> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (coverFlowView = this.c) == null) {
            return;
        }
        coverFlowView.s();
    }

    public void f(ArrayList<fr4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            ArrayList<ii8> arrayList2 = new ArrayList<>();
            Iterator<fr4> it = arrayList.iterator();
            while (it.hasNext()) {
                fr4 next = it.next();
                if (next != null) {
                    arrayList2.add(new ii8(next));
                }
            }
            this.b = arrayList2;
            this.c.setData(arrayList2);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<ii8> arrayList = this.b;
            return (arrayList != null ? arrayList.size() + 0 : 0) > 0 ? 1 : 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? Integer.valueOf(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) ? this.c : (View) invokeILL.objValue;
    }
}
