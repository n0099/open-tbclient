package com.repackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class es6 {
    public static /* synthetic */ Interceptable $ic;
    public static es6 b;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* loaded from: classes6.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(es6 es6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.es6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
            }
        }

        @Override // com.repackage.es6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public b(es6 es6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.repackage.es6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.a, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", gs6.c("a006")).eventStat();
            }
        }

        @Override // com.repackage.es6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.a, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", gs6.c("a006")).eventStat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;

        public c(es6 es6Var, h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es6Var, hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
            this.b = str;
        }

        @Override // com.repackage.es6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, i);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.b).param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i));
            }
        }

        @Override // com.repackage.es6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.b).param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ String b;
        public final /* synthetic */ es6 c;

        public d(es6 es6Var, h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es6Var, hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = es6Var;
            this.a = hVar;
            this.b = str;
        }

        @Override // com.repackage.es6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.a(str, i);
                }
                this.c.B(0, this.b, String.valueOf(1));
            }
        }

        @Override // com.repackage.es6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                h hVar = this.a;
                if (hVar != null) {
                    hVar.onError(str);
                }
                this.c.B(1, this.b, String.valueOf(0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(es6 es6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {es6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // com.repackage.es6.h
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "0", this.a, this.b, null);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 0));
            }
        }

        @Override // com.repackage.es6.h
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a005", "1", this.a, this.b, "0");
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a005").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(String str);

        void b(Activity activity, String str, int i, h hVar, g gVar);

        void c(ImageView imageView, Object obj);

        void d(Activity activity, @NonNull Object obj, i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, g gVar);

        void destroyAd(String str);

        void e(Context context, String str, int i, int i2, h hVar, g gVar);

        ViewGroup f(@NonNull Context context);

        View g(Object obj);

        boolean h(Activity activity);

        void i(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar);

        boolean isAdReady(String str);

        boolean j(Object obj);

        Object k(@NonNull Activity activity, @NonNull String str);

        void l(Object obj, j jVar);

        void m(Application application, l lVar);

        @NonNull
        List<ds6> n(String str);

        void o(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar);

        zs8 p(Object obj);

        void removeMiniWindow();
    }

    /* loaded from: classes6.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface h {
        void a(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes6.dex */
    public interface i {
        void onAdClicked(String str, String str2, String str3);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str, String str2, String str3);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes6.dex */
    public interface j {
        void a(long j, long j2);
    }

    /* loaded from: classes6.dex */
    public static abstract class k implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.es6.i
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface l {
        void initComplete();
    }

    public es6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h();
    }

    public static g b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            g gVar = new g();
            gVar.a = str;
            gVar.b = str2;
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public static es6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (b == null) {
                synchronized (es6.class) {
                    if (b == null) {
                        b = new es6();
                    }
                }
            }
            if (b.a == null && PermissionUtil.isAgreePrivacyPolicy()) {
                b = new es6();
            }
            return b;
        }
        return (es6) invokeV.objValue;
    }

    public void A(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048576, this, activity, str, viewGroup, iVar, gVar) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.i(activity, str, viewGroup, iVar, gVar);
    }

    public final void B(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", i2).param("tid", "").param("fid", "").param("obj_type", str).param(TiebaStatic.Params.RESOURCE_ID, str2));
        }
    }

    public zs8 C(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? this.a.p(obj) : (zs8) invokeL.objValue;
    }

    public boolean D(Activity activity, String str, g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, activity, str, gVar)) == null) {
            if (this.a == null || TextUtils.isEmpty(str) || gVar == null) {
                return false;
            }
            boolean isAdReady = this.a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
            System.currentTimeMillis();
            FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
            this.a.b(activity, str, 1, new a(this), gVar);
            return isAdReady;
        }
        return invokeLLL.booleanValue;
    }

    public boolean E(Activity activity, String str, g gVar, String str2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{activity, str, gVar, str2, Integer.valueOf(i2)})) == null) {
            if (this.a == null || TextUtils.isEmpty(str) || gVar == null) {
                return false;
            }
            boolean isAdReady = this.a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_source", 6).param("fid", str2).param(TiebaStatic.Params.OBJ_PARAM2, i2).param("obj_type", "a006").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", gs6.c("a006")).eventStat();
            FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
            this.a.b(activity, str, i2, new b(this, str2), gVar);
            return isAdReady;
        }
        return invokeCommon.booleanValue;
    }

    public boolean F(Activity activity, String str, g gVar, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, activity, str, gVar, str2, str3)) == null) {
            if (this.a == null || TextUtils.isEmpty(str) || gVar == null) {
                return false;
            }
            boolean isAdReady = this.a.isAdReady(str);
            FunAdRecordHttpMessage.uploadRequestRecord("a005", null, str2, str3, null);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str2).param("fid", str3).param("obj_type", "a005").param("obj_param1", "2"));
            this.a.b(activity, str, 1, new e(this, str2, str3), gVar);
            return isAdReady;
        }
        return invokeLLLLL.booleanValue;
    }

    public void c(String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.a(str);
    }

    public void d(String str) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.destroyAd(str);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? iw4.g() : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? iw4.h() : invokeV.intValue;
    }

    public List<ds6> g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            f fVar = this.a;
            if (fVar != null) {
                return fVar.n(str);
            }
            return new ArrayList(0);
        }
        return (List) invokeL.objValue;
    }

    public final f h() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy() && (runTask = MessageManager.getInstance().runTask(2921525, f.class)) != null) {
                return (f) runTask.getData();
            }
            return null;
        }
        return (f) invokeV.objValue;
    }

    public ViewGroup i(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            f fVar = this.a;
            if (fVar != null) {
                return fVar.f(context);
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public Object k(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, activity, str)) == null) {
            f fVar = this.a;
            if (fVar != null) {
                return fVar.k(activity, str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public View l(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) ? this.a.g(obj) : (View) invokeL.objValue;
    }

    public void m() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.m(TbadkCoreApplication.getInst(), null);
    }

    public void n(l lVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, lVar) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.m(TbadkCoreApplication.getInst(), lVar);
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            f fVar = this.a;
            return fVar != null && fVar.isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    public void p(Context context, String str, int i2, h hVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{context, str, Integer.valueOf(i2), hVar, gVar}) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.e(context, str, 1, i2, hVar, gVar);
    }

    public void q(Activity activity, String str, h hVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048595, this, activity, str, hVar, gVar) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.b(activity, str, 1, hVar, gVar);
    }

    public void r(Activity activity, h hVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048596, this, activity, hVar, str) == null) || this.a == null) {
            return;
        }
        B(2, str, "");
        this.a.b(activity, "6061002410-390177882", 1, new d(this, hVar, str), b(str, (VideoMiddleAdSwitch.isOn() && UbsABTestHelper.isVideoAdDrawABTestB()) ? "1" : "0"));
    }

    public void s(Activity activity, h hVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048597, this, activity, hVar, str) == null) || this.a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", 2).param("tid", "").param("fid", "").param("obj_type", str));
        this.a.b(activity, "6061002332-203360688", 1, new c(this, hVar, str), b(PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE, VideoMiddleAdSwitch.isOn() ? "1" : "0"));
    }

    public void t() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.removeMiniWindow();
    }

    public void u(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, imageView, obj) == null) {
            this.a.c(imageView, obj);
        }
    }

    public void v(Object obj, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, obj, jVar) == null) {
            this.a.l(obj, jVar);
        }
    }

    public boolean w(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) ? this.a.j(obj) : invokeL.booleanValue;
    }

    public void x(Activity activity, String str, ViewGroup viewGroup, i iVar, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048602, this, activity, str, viewGroup, iVar, gVar) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.o(activity, str, viewGroup, iVar, gVar);
    }

    public boolean y(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, activity)) == null) {
            f fVar = this.a;
            return fVar != null && fVar.h(activity);
        }
        return invokeL.booleanValue;
    }

    public void z(Activity activity, @NonNull Object obj, i iVar, ViewGroup viewGroup, List<View> list, List<View> list2, g gVar) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{activity, obj, iVar, viewGroup, list, list2, gVar}) == null) || (fVar = this.a) == null) {
            return;
        }
        fVar.d(activity, obj, iVar, viewGroup, list, list2, gVar);
    }
}
