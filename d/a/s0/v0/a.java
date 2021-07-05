package d.a.s0.v0;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f68202b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f68203a;

    /* renamed from: d.a.s0.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1832a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1832a(a aVar) {
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
                }
            }
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f68204a;

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68204a = str;
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.f68204a, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.f68204a, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f68205a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f68206b;

        public c(a aVar, f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68205a = fVar;
            this.f68206b = str;
        }

        @Override // d.a.s0.v0.a.f
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                f fVar = this.f68205a;
                if (fVar != null) {
                    fVar.a(str, i2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f68206b).param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2));
            }
        }

        @Override // d.a.s0.v0.a.f
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                f fVar = this.f68205a;
                if (fVar != null) {
                    fVar.onError(str);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f68206b).param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(Activity activity, String str, f fVar, e eVar);

        void b(String str);

        void c(Activity activity, @NonNull Object obj, g gVar, ViewGroup viewGroup, List<View> list, List<View> list2, e eVar);

        ViewGroup d(Activity activity, String str);

        void destroyAd(String str);

        Object e(@NonNull Activity activity, @NonNull String str);

        void f(Application application, i iVar);

        void g(Activity activity, String str, f fVar, e eVar);

        void h(Activity activity, String str, ViewGroup viewGroup, g gVar, e eVar);

        boolean isAdReady(String str);
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f68207a;

        /* renamed from: b  reason: collision with root package name */
        public String f68208b;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a(String str, int i2);

        void onError(String str);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void onAdClicked(String str);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes9.dex */
    public static abstract class h implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.s0.v0.a.g
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface i {
        void a();
    }

    public a() {
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
        this.f68203a = f();
    }

    public static e a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            e eVar = new e();
            eVar.f68207a = str;
            eVar.f68208b = str2;
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68202b == null) {
                synchronized (a.class) {
                    if (f68202b == null) {
                        f68202b = new a();
                    }
                }
            }
            if (f68202b.f68203a == null && PermissionUtil.isAgreePrivacyPolicy()) {
                f68202b = new a();
            }
            return f68202b;
        }
        return (a) invokeV.objValue;
    }

    public void b(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.b(str);
    }

    public void c(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.destroyAd(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.r0.s.c.e.d() : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.r0.s.c.e.e() : invokeV.intValue;
    }

    public final d f() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy() && (runTask = MessageManager.getInstance().runTask(2921525, d.class)) != null) {
                return (d) runTask.getData();
            }
            return null;
        }
        return (d) invokeV.objValue;
    }

    public ViewGroup g(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, str)) == null) {
            d dVar = this.f68203a;
            if (dVar != null) {
                return dVar.d(activity, str);
            }
            return null;
        }
        return (ViewGroup) invokeLL.objValue;
    }

    public Object i(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, activity, str)) == null) {
            d dVar = this.f68203a;
            if (dVar != null) {
                return dVar.e(activity, str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public void j() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.f(TbadkCoreApplication.getInst(), null);
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            d dVar = this.f68203a;
            return dVar != null && dVar.isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    public void l(Activity activity, String str, f fVar, e eVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048585, this, activity, str, fVar, eVar) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.a(activity, str, fVar, eVar);
    }

    public void m(Activity activity, String str, f fVar, e eVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048586, this, activity, str, fVar, eVar) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.g(activity, str, fVar, eVar);
    }

    public void n(Activity activity, f fVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, activity, fVar, str) == null) || this.f68203a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", 2).param("tid", "").param("fid", "").param("obj_type", str));
        this.f68203a.g(activity, "6061002332-203360688", new c(this, fVar, str), a("video_middle", VideoMiddleAdSwitch.isOn() ? "1" : "0"));
    }

    public void o(Activity activity, String str, ViewGroup viewGroup, g gVar, e eVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048588, this, activity, str, viewGroup, gVar, eVar) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.h(activity, str, viewGroup, gVar, eVar);
    }

    public void p(Activity activity, @NonNull Object obj, g gVar, ViewGroup viewGroup, List<View> list, List<View> list2, e eVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{activity, obj, gVar, viewGroup, list, list2, eVar}) == null) || (dVar = this.f68203a) == null) {
            return;
        }
        dVar.c(activity, obj, gVar, viewGroup, list, list2, eVar);
    }

    public boolean q(Activity activity, String str, e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, activity, str, eVar)) == null) {
            if (this.f68203a == null || TextUtils.isEmpty(str) || eVar == null) {
                return false;
            }
            boolean isAdReady = this.f68203a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
            System.currentTimeMillis();
            FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
            this.f68203a.g(activity, str, new C1832a(this), eVar);
            return isAdReady;
        }
        return invokeLLL.booleanValue;
    }

    public boolean r(Activity activity, String str, e eVar, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, activity, str, eVar, str2)) == null) {
            if (this.f68203a == null || TextUtils.isEmpty(str) || eVar == null) {
                return false;
            }
            boolean isAdReady = this.f68203a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("fid", str2).param("obj_type", "a006").eventStat();
            FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
            this.f68203a.g(activity, str, new b(this, str2), eVar);
            return isAdReady;
        }
        return invokeLLLL.booleanValue;
    }
}
