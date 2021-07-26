package d.a.q0.u0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.ForumToolPerm;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static UserData f63581a;
    public transient /* synthetic */ FieldHolder $fh;

    public static UserData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f63581a : (UserData) invokeV.objValue;
    }

    public static UserData b(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsViewData)) == null) {
            UserData userData = frsViewData != null ? frsViewData.getUserData() : null;
            f63581a = userData;
            return userData;
        }
        return (UserData) invokeL.objValue;
    }

    public static boolean c(UserData userData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, userData)) == null) {
            if (userData == null) {
                return false;
            }
            int is_manager = userData.getIs_manager();
            return is_manager == 1 || is_manager == 2 || is_manager == 3 || is_manager == 4;
        }
        return invokeL.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            UserData a2 = a();
            return a2 != null && a2.getIs_manager() == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            UserData a2 = a();
            return a2 != null && a2.getIs_manager() == 3;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            UserData a2 = a();
            if (a2 != null && (forumToolAuth = a2.getForumToolAuth()) != null) {
                for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void g(d.a.k.a aVar, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, aVar, frsViewData) == null) || aVar == null) {
            return;
        }
        if (frsViewData != null && (c(b(frsViewData)) || f())) {
            aVar.b(4);
        } else {
            aVar.c(4);
        }
    }

    public static void h(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, threadCommentAndPraiseInfoLayout, frsViewData) == null) || threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        if (frsViewData != null && c(b(frsViewData))) {
            threadCommentAndPraiseInfoLayout.setManageVisible(true);
        } else {
            threadCommentAndPraiseInfoLayout.setManageVisible(false);
        }
    }
}
