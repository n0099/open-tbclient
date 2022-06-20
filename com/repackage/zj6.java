package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.frs.headercomponent.HeaderComponentMultiView;
import com.baidu.tieba.frs.headercomponent.HeaderComponentSingleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsPage.LiveFuseForumData;
/* loaded from: classes7.dex */
public class zj6 implements ak6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbPageContext b;
    public List<LiveFuseForumData> c;
    public String d;

    public zj6(TbPageContext tbPageContext) {
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
        this.b = tbPageContext;
    }

    @Override // com.repackage.ak6
    public void a(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, liveFuseForumData) == null) {
            TiebaStatic.log(new StatisticItem("c14701").param("obj_type", f(i, liveFuseForumData)).param("fid", this.d));
            String str = liveFuseForumData.schema;
            if (str == null || !str.startsWith("bdtiebalive")) {
                return;
            }
            k("c14708", liveFuseForumData.yyext);
        }
    }

    @Override // com.repackage.ak6
    public void b(int i, LiveFuseForumData liveFuseForumData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), liveFuseForumData, Integer.valueOf(i2)}) == null) {
            UrlManager.getInstance().dealOneLink(this.b, new String[]{liveFuseForumData.schema});
        }
    }

    @Override // com.repackage.ak6
    public void c(int i, LiveFuseForumData liveFuseForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, liveFuseForumData) == null) || liveFuseForumData == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(this.b, new String[]{liveFuseForumData.schema});
        TiebaStatic.log(new StatisticItem("c14702").param("obj_type", f(i, liveFuseForumData)).param("fid", this.d));
        String str = liveFuseForumData.schema;
        if (str == null || !str.startsWith("bdtiebalive")) {
            return;
        }
        k("c14709", liveFuseForumData.yyext);
    }

    public void d() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (view2 = this.a) == null) {
            return;
        }
        ((bk6) view2).b(this.c, this);
    }

    public void e(List<LiveFuseForumData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.c = list;
        if (list.size() == 1) {
            this.a = new HeaderComponentSingleView(this.b.getPageActivity());
        } else {
            this.a = new HeaderComponentMultiView(this.b.getPageActivity());
        }
    }

    public final int f(int i, LiveFuseForumData liveFuseForumData) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, liveFuseForumData)) == null) {
            if (i == 1) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 1;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 3;
                }
            } else if (i == 2) {
                if (liveFuseForumData.type.intValue() == 1) {
                    return 2;
                }
                if (liveFuseForumData.type.intValue() == 2) {
                    return 4;
                }
            }
            return 0;
        }
        return invokeIL.intValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public final JSONObject h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public void i() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view2 = this.a) == null) {
            return;
        }
        ((bk6) view2).a();
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.d = str;
        }
    }

    public final void k(String str, String str2) {
        JSONObject h;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) || (h = h(str2)) == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("fid", this.d).param("liveid", h.optString("liveid")).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, h.optString(TiebaStatic.YYParams.YYSID)).param(TiebaStatic.YYParams.YYSSID, h.optString(TiebaStatic.YYParams.YYSSID)).param(TiebaStatic.YYParams.YYUID, h.optString(TiebaStatic.YYParams.YYUID)).param("template_id", h.optString("template_id")).param(TiebaStatic.YYParams.YYLIVEID, h.optString(TiebaStatic.YYParams.YYLIVEID)).param(TiebaStatic.Params.VID, h.optString(TiebaStatic.Params.VID)));
    }
}
