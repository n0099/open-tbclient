package d.a.q0.p3;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.ueg.UEGCancelModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.g;
import d.a.d.e.p.k;
import d.a.p0.s.s.a;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f62007d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UEGCancelModel f62008a;

    /* renamed from: b  reason: collision with root package name */
    public UEGCancelModel.b f62009b;

    /* renamed from: c  reason: collision with root package name */
    public int f62010c;

    /* loaded from: classes8.dex */
    public class a implements UEGCancelModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62011a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62011a = bVar;
        }

        @Override // com.baidu.tieba.ueg.UEGCancelModel.b
        public void a(BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, blockPopInfoData) == null) || blockPopInfoData == null || b.f62007d) {
                return;
            }
            this.f62011a.d(blockPopInfoData);
        }
    }

    /* renamed from: d.a.q0.p3.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1597b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f62012e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62013f;

        public C1597b(b bVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62013f = bVar;
            this.f62012e = blockPopInfoData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", this.f62013f.f62010c).param("obj_type", this.f62012e.win_type));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BlockPopInfoData f62014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f62015f;

        public c(b bVar, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62015f = bVar;
            this.f62014e = blockPopInfoData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f62015f.e(this.f62014e);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", this.f62015f.f62010c).param("obj_type", this.f62014e.win_type));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(179403386, "Ld/a/q0/p3/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(179403386, "Ld/a/q0/p3/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62010c = TbadkCoreStatisticKey.AntiLocateValue.LOCATE_COLD_BOOT;
        this.f62008a = new UEGCancelModel();
        if (this.f62009b == null) {
            this.f62009b = new a(this);
        }
        this.f62008a.y(this.f62009b);
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f62010c = i2;
            this.f62008a.x();
        }
    }

    public final void d(BlockPopInfoData blockPopInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, blockPopInfoData) == null) || blockPopInfoData == null || d.a.d.a.b.f().b() == null) {
            return;
        }
        String str = blockPopInfoData.block_id_code;
        int i2 = blockPopInfoData.win_type;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str2 = blockPopInfoData.ahead_url;
        String str3 = blockPopInfoData.ok_info;
        String str4 = blockPopInfoData.ahead_info;
        String str5 = blockPopInfoData.block_info;
        if ((i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) || k.isEmpty(currentAccount) || k.isEmpty(str)) {
            return;
        }
        d.a.p0.s.d0.b j = d.a.p0.s.d0.b.j();
        boolean z = false;
        boolean g2 = j.g(str + i2 + currentAccount, false);
        if ((!k.isEmpty(str2) || i2 == 4) && !k.isEmpty(str3) && ((!k.isEmpty(str4) || i2 == 4) && !k.isEmpty(str5))) {
            z = true;
        }
        if (g2 || !z) {
            return;
        }
        d.a.p0.s.d0.b j2 = d.a.p0.s.d0.b.j();
        j2.t(str + i2 + currentAccount, true);
        h(blockPopInfoData);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", this.f62010c).param("obj_type", i2));
    }

    public final void e(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, blockPopInfoData) == null) || blockPopInfoData == null || (b2 = d.a.d.a.b.f().b()) == null) {
            return;
        }
        AntiHelper.p(b2, blockPopInfoData.ahead_url);
    }

    public void f() {
        UEGCancelModel uEGCancelModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (uEGCancelModel = this.f62008a) == null) {
            return;
        }
        uEGCancelModel.onDestroy();
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            f62007d = z;
        }
    }

    public final void h(BlockPopInfoData blockPopInfoData) {
        Activity b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, blockPopInfoData) == null) || blockPopInfoData == null || (b2 = d.a.d.a.b.f().b()) == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(b2);
        aVar.setMessage(blockPopInfoData.block_info);
        aVar.setNegativeButton(blockPopInfoData.ok_info, new C1597b(this, blockPopInfoData));
        aVar.setPositiveButton(blockPopInfoData.ahead_info, new c(this, blockPopInfoData));
        aVar.create(((g) b2).getPageContext());
        aVar.show();
    }
}
