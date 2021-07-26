package d.a.q0.v0;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f65629b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f65630a;

    /* renamed from: d.a.q0.v0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1793a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1793a(a aVar) {
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

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "0", null, null, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 0).eventStat();
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a002", "1", null, null, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f65631a;

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
            this.f65631a = str;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "0", null, this.f65631a, null);
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 0).eventStat();
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                FunAdRecordHttpMessage.uploadRequestRecord("a006", "1", null, this.f65631a, "0");
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a006").param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0).eventStat();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65632a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65633b;

        public c(a aVar, g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65632a = gVar;
            this.f65633b = str;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                g gVar = this.f65632a;
                if (gVar != null) {
                    gVar.a(str, i2);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f65633b).param("obj_locate", 0).param(TiebaStatic.Params.RESOURCE_ID, i2));
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                g gVar = this.f65632a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", this.f65633b).param("obj_locate", 1).param(TiebaStatic.Params.RESOURCE_ID, 0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f65634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f65635b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f65636c;

        public d(a aVar, g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65636c = aVar;
            this.f65634a = gVar;
            this.f65635b = str;
        }

        @Override // d.a.q0.v0.a.g
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                g gVar = this.f65634a;
                if (gVar != null) {
                    gVar.a(str, i2);
                }
                this.f65636c.w(0, this.f65635b, String.valueOf(1));
            }
        }

        @Override // d.a.q0.v0.a.g
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                g gVar = this.f65634a;
                if (gVar != null) {
                    gVar.onError(str);
                }
                this.f65636c.w(1, this.f65635b, String.valueOf(0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(Activity activity, String str, g gVar, f fVar);

        void b(String str);

        void c(ImageView imageView, Object obj);

        void d(Activity activity, @NonNull Object obj, h hVar, ViewGroup viewGroup, List<View> list, List<View> list2, f fVar);

        void destroyAd(String str);

        View e(Object obj);

        ViewGroup f(Activity activity, String str);

        boolean g(Object obj);

        Object h(@NonNull Activity activity, @NonNull String str);

        void i(Object obj, i iVar);

        boolean isAdReady(String str);

        void j(Application application, k kVar);

        void k(Activity activity, String str, g gVar, f fVar);

        void l(Activity activity, String str, ViewGroup viewGroup, h hVar, f fVar);

        d.a.q0.v3.g m(Object obj);
    }

    /* loaded from: classes8.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f65637a;

        /* renamed from: b  reason: collision with root package name */
        public String f65638b;

        public f() {
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

    /* loaded from: classes8.dex */
    public interface g {
        void a(String str, int i2);

        void onError(String str);
    }

    /* loaded from: classes8.dex */
    public interface h {
        void onAdClicked(String str, String str2, String str3);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str, String str2, String str3);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a(long j, long j2);
    }

    /* loaded from: classes8.dex */
    public static abstract class j implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
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

        @Override // d.a.q0.v0.a.h
        public void onRewardedVideo(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface k {
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
        this.f65630a = g();
    }

    public static f b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            f fVar = new f();
            fVar.f65637a = str;
            fVar.f65638b = str2;
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f65629b == null) {
                synchronized (a.class) {
                    if (f65629b == null) {
                        f65629b = new a();
                    }
                }
            }
            if (f65629b.f65630a == null && PermissionUtil.isAgreePrivacyPolicy()) {
                f65629b = new a();
            }
            return f65629b;
        }
        return (a) invokeV.objValue;
    }

    public void c(String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.b(str);
    }

    public void d(String str) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.destroyAd(str);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.p0.t.c.e.d() : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.p0.t.c.e.e() : invokeV.intValue;
    }

    public final e g() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (PermissionUtil.isAgreePrivacyPolicy() && (runTask = MessageManager.getInstance().runTask(2921525, e.class)) != null) {
                return (e) runTask.getData();
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    public ViewGroup h(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, activity, str)) == null) {
            e eVar = this.f65630a;
            if (eVar != null) {
                return eVar.f(activity, str);
            }
            return null;
        }
        return (ViewGroup) invokeLL.objValue;
    }

    public Object j(@NonNull Activity activity, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, activity, str)) == null) {
            e eVar = this.f65630a;
            if (eVar != null) {
                return eVar.h(activity, str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public View k(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? this.f65630a.e(obj) : (View) invokeL.objValue;
    }

    public void l() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.j(TbadkCoreApplication.getInst(), null);
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            e eVar = this.f65630a;
            return eVar != null && eVar.isAdReady(str);
        }
        return invokeL.booleanValue;
    }

    public void n(Activity activity, String str, g gVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048586, this, activity, str, gVar, fVar) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.a(activity, str, gVar, fVar);
    }

    public void o(Activity activity, String str, g gVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048587, this, activity, str, gVar, fVar) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.k(activity, str, gVar, fVar);
    }

    public void p(Activity activity, g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, activity, gVar, str) == null) || this.f65630a == null) {
            return;
        }
        w(2, str, "");
        this.f65630a.k(activity, "6061002410-390177882", new d(this, gVar, str), b(str, (VideoMiddleAdSwitch.isOn() && d.a.p0.b.d.b0()) ? "1" : "0"));
    }

    public void q(Activity activity, g gVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048589, this, activity, gVar, str) == null) || this.f65630a == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", 2).param("tid", "").param("fid", "").param("obj_type", str));
        this.f65630a.k(activity, "6061002332-203360688", new c(this, gVar, str), b("video_middle", VideoMiddleAdSwitch.isOn() ? "1" : "0"));
    }

    public void r(ImageView imageView, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, imageView, obj) == null) {
            this.f65630a.c(imageView, obj);
        }
    }

    public void s(Object obj, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, obj, iVar) == null) {
            this.f65630a.i(obj, iVar);
        }
    }

    public boolean t(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) ? this.f65630a.g(obj) : invokeL.booleanValue;
    }

    public void u(Activity activity, String str, ViewGroup viewGroup, h hVar, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048593, this, activity, str, viewGroup, hVar, fVar) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.l(activity, str, viewGroup, hVar, fVar);
    }

    public void v(Activity activity, @NonNull Object obj, h hVar, ViewGroup viewGroup, List<View> list, List<View> list2, f fVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{activity, obj, hVar, viewGroup, list, list2, fVar}) == null) || (eVar = this.f65630a) == null) {
            return;
        }
        eVar.d(activity, obj, hVar, viewGroup, list, list2, fVar);
    }

    public final void w(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, str, str2) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_locate", i2).param("tid", "").param("fid", "").param("obj_type", str).param(TiebaStatic.Params.RESOURCE_ID, str2));
        }
    }

    public d.a.q0.v3.g x(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) ? this.f65630a.m(obj) : (d.a.q0.v3.g) invokeL.objValue;
    }

    public boolean y(Activity activity, String str, f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, activity, str, fVar)) == null) {
            if (this.f65630a == null || TextUtils.isEmpty(str) || fVar == null) {
                return false;
            }
            boolean isAdReady = this.f65630a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a002").eventStat();
            System.currentTimeMillis();
            FunAdRecordHttpMessage.uploadRequestRecord("a002", null, null, null, null);
            this.f65630a.k(activity, str, new C1793a(this), fVar);
            return isAdReady;
        }
        return invokeLLL.booleanValue;
    }

    public boolean z(Activity activity, String str, f fVar, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048598, this, activity, str, fVar, str2)) == null) {
            if (this.f65630a == null || TextUtils.isEmpty(str) || fVar == null) {
                return false;
            }
            boolean isAdReady = this.f65630a.isAdReady(str);
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("fid", str2).param("obj_type", "a006").eventStat();
            FunAdRecordHttpMessage.uploadRequestRecord("a006", null, null, str2, null);
            this.f65630a.k(activity, str, new b(this, str2), fVar);
            return isAdReady;
        }
        return invokeLLLL.booleanValue;
    }
}
