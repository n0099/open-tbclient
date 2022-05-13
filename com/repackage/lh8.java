package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.stampmission.model.StampMissionModel;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nh8;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class lh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lh8 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<StampMission.Type, StampMission> a;
    public StampMissionModel b;
    public nh8 c;
    public boolean d;
    public boolean e;
    public final String f;
    public final String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public oh8 k;
    public final StampMissionModel.b l;

    /* loaded from: classes6.dex */
    public class a implements StampMissionModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lh8 a;

        public a(lh8 lh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lh8Var;
        }

        @Override // com.baidu.tieba.stampmission.model.StampMissionModel.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
            if (r0.equals(com.baidu.tieba.stampmission.message.StampMissionHttpRequestMessage.TASK_FOLLOW) == false) goto L41;
         */
        @Override // com.baidu.tieba.stampmission.model.StampMissionModel.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(nh8 nh8Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nh8Var) == null) {
                char c = 0;
                if ("start".equals(nh8Var.c)) {
                    iu4.k().y(this.a.f, nh8Var.i);
                    this.a.c = nh8Var;
                    lh8 lh8Var = this.a;
                    lh8Var.I(lh8Var.c);
                    if (!this.a.u() && this.a.h) {
                        xh8.e(nh8Var, this.a.g, this.a.k);
                        this.a.h = false;
                    }
                    this.a.e = true;
                    this.a.d = true;
                } else if ("sync".equals(nh8Var.c)) {
                    String str2 = nh8Var.d;
                    int hashCode = str2.hashCode();
                    if (hashCode == -549184070) {
                        if (str2.equals(StampMissionHttpRequestMessage.TASK_REPLY)) {
                            c = 2;
                        }
                        c = 65535;
                    } else if (hashCode != -163617491) {
                        if (hashCode == 1596610899) {
                        }
                        c = 65535;
                    } else {
                        if (str2.equals(StampMissionHttpRequestMessage.TASK_LIKE)) {
                            c = 1;
                        }
                        c = 65535;
                    }
                    if (c == 0) {
                        this.a.F(StampMission.Type.FOLLOW_FORUM, StampMission.a.a);
                        nh8.b bVar = nh8Var.h;
                        if (bVar != null) {
                            str = bVar.a.a;
                        }
                        str = "";
                    } else if (c != 1) {
                        if (c == 2) {
                            this.a.F(StampMission.Type.REPLAY_THREAD, StampMission.a.c);
                            nh8.b bVar2 = nh8Var.h;
                            if (bVar2 != null) {
                                str = bVar2.c.a;
                            }
                        }
                        str = "";
                    } else {
                        this.a.F(StampMission.Type.LIKE_THREAD, StampMission.a.b);
                        nh8.b bVar3 = nh8Var.h;
                        if (bVar3 != null) {
                            str = bVar3.b.a;
                        }
                        str = "";
                    }
                    this.a.H(str);
                    if (this.a.t()) {
                        this.a.delete();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-213887113, "Lcom/repackage/lh8$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-213887113, "Lcom/repackage/lh8$b;");
                    return;
                }
            }
            int[] iArr = new int[StampMission.Type.values().length];
            a = iArr;
            try {
                iArr[StampMission.Type.FOLLOW_FORUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[StampMission.Type.LIKE_THREAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[StampMission.Type.REPLAY_THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public lh8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.l = new a(this);
        B();
        w();
        this.f = "key_stamp_mission_dialog_data_" + TbadkCoreApplication.getCurrentAccount();
        this.g = "key_stamp_mission_dialog_last_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            for (StampMission stampMission : this.a.values()) {
                stampMission.delete();
            }
            iu4.k().D(this.f);
            this.e = false;
        }
    }

    public static lh8 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (m == null) {
                synchronized (lh8.class) {
                    if (m == null) {
                        m = new lh8();
                    }
                }
            }
            return m;
        }
        return (lh8) invokeV.objValue;
    }

    public void A(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && p()) {
            if (this.k == null) {
                this.k = new oh8();
            }
            oh8 oh8Var = this.k;
            oh8Var.a = i;
            oh8Var.b = i2;
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            C(new qh8());
            C(new rh8());
            C(new sh8());
        }
    }

    public final void C(StampMission stampMission) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, stampMission) == null) {
            if (this.a == null) {
                this.a = new HashMap();
            }
            if (stampMission == null || stampMission.getType() == null) {
                return;
            }
            this.a.put(stampMission.getType(), stampMission);
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.j = z;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.i = z;
        }
    }

    public final void F(StampMission.Type type, int i) {
        Map<StampMission.Type, StampMission> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, type, i) == null) || (map = this.a) == null || map.get(type) == null) {
            return;
        }
        this.a.get(type).d(i);
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && p() && !u()) {
            String q = iu4.k().q(this.f, null);
            if (!TextUtils.isEmpty(q)) {
                this.c = nh8.a(q);
                if (x()) {
                    xh8.e(this.c, this.g, this.k);
                    this.h = false;
                    return;
                }
                return;
            }
            this.h = true;
            this.b.D();
        }
    }

    public final void H(final String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || TbadkCoreApplication.getInst().getCurrentActivity() == null) {
            return;
        }
        ScreenTopToast screenTopToast = new ScreenTopToast(TbadkCoreApplication.getInst());
        screenTopToast.m(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11e5));
        screenTopToast.k(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11e4));
        screenTopToast.j(new View.OnClickListener() { // from class: com.repackage.kh8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    fm4.m(TbadkCoreApplication.getInst(), "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount() + "&icon_name=" + str);
                }
            }
        });
        screenTopToast.n((ViewGroup) TbadkCoreApplication.getInst().getCurrentActivity().findViewById(16908290));
    }

    public final void I(nh8 nh8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nh8Var) == null) || nh8Var == null) {
            return;
        }
        if (nh8Var.e == 1) {
            this.a.get(StampMission.Type.FOLLOW_FORUM).d(StampMission.a.a);
        }
        if (nh8Var.f == 1) {
            this.a.get(StampMission.Type.LIKE_THREAD).d(StampMission.a.b);
        }
        if (nh8Var.g == 1) {
            this.a.get(StampMission.Type.REPLAY_THREAD).d(StampMission.a.c);
        }
    }

    public final void J(StampMission.Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, type) == null) {
            int i = b.a[type.ordinal()];
            if (i == 1) {
                this.b.B(StampMissionHttpRequestMessage.TASK_FOLLOW);
            } else if (i == 2) {
                this.b.B(StampMissionHttpRequestMessage.TASK_LIKE);
            } else if (i != 3) {
            } else {
                this.b.B(StampMissionHttpRequestMessage.TASK_REPLY);
            }
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? !this.i && !this.j && TbadkCoreApplication.isLogin() && TbSingleton.getInstance().showStampMissionDialog && (UbsABTestHelper.isStampMissionDialogABTestB() || UbsABTestHelper.isStampMissionDialogABTestA()) : invokeV.booleanValue;
    }

    public int q(StampMission.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, type)) == null) {
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null || map.get(type) == null) {
                return 0;
            }
            return this.a.get(type).a();
        }
        return invokeL.intValue;
    }

    public int s(StampMission.Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, type)) == null) {
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null || map.get(type) == null) {
                return 0;
            }
            return this.a.get(type).b();
        }
        return invokeL.intValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null) {
                return false;
            }
            for (StampMission stampMission : map.values()) {
                if (stampMission.a() != stampMission.b()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? TimeHelper.isSameDay(iu4.k().m(this.g, 0L), System.currentTimeMillis()) : invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String q = iu4.k().q(this.f, null);
            if (!TextUtils.isEmpty(q)) {
                this.c = nh8.a(q);
                this.e = true;
                this.d = true;
                return;
            }
            this.b.D();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            StampMissionModel stampMissionModel = new StampMissionModel();
            this.b = stampMissionModel;
            stampMissionModel.C(this.l);
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            nh8 nh8Var = this.c;
            return currentTimeMillis >= nh8Var.a && currentTimeMillis <= nh8Var.b;
        }
        return invokeV.booleanValue;
    }

    public void z(StampMission.Type type) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, type) == null) || !p() || this.h || iu4.k().m(this.g, 0L) == 0) {
            return;
        }
        if (!this.d) {
            v();
        }
        if (this.e) {
            if (!x()) {
                delete();
                return;
            }
            Map<StampMission.Type, StampMission> map = this.a;
            if (map == null || map.get(type) == null || this.a.get(type).c()) {
                return;
            }
            J(type);
        }
    }
}
