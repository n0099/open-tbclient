package d.a.o0.r.m;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.h;
import d.a.o0.r.s.j;
import d.a.o0.r.s.l;
import d.a.p0.h3.y;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f52510a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f52511e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52511e = jVar;
        }

        @Override // d.a.o0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (i2 == 0) {
                    b.e(true, true);
                    TiebaStatic.log(new StatisticItem("c14201").param("obj_locate", "1"));
                } else if (i2 == 1) {
                    b.e(true, false);
                    TiebaStatic.log(new StatisticItem("c14201").param("obj_locate", "2"));
                }
                j jVar = this.f52511e;
                if (jVar != null) {
                    jVar.dismiss();
                }
            }
        }
    }

    /* renamed from: d.a.o0.r.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1211b implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f52512a;

        public C1211b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52512a = jVar;
        }

        @Override // d.a.o0.r.s.l.c
        public void onClick() {
            j jVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (jVar = this.f52512a) == null) {
                return;
            }
            jVar.dismiss();
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f52510a : (String) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                TbPageContext pageContext = ((TbPageContextSupport) currentActivity).getPageContext();
                String string = pageContext.getString(R.string.work_publish_open_dialog_title);
                j jVar = new j(pageContext);
                l lVar = new l(currentActivity);
                lVar.q(string);
                ArrayList arrayList = new ArrayList();
                h hVar = new h(0, pageContext.getString(R.string.work_publish_open_dialog_load_draft), lVar);
                hVar.o(R.color.CAM_X0105);
                arrayList.add(hVar);
                h hVar2 = new h(1, pageContext.getString(R.string.work_publish_open_dialog_add_new), lVar);
                hVar2.o(R.color.CAM_X0105);
                arrayList.add(hVar2);
                a aVar = new a(jVar);
                C1211b c1211b = new C1211b(jVar);
                lVar.k(arrayList);
                lVar.n(aVar);
                lVar.m(c1211b);
                jVar.setCanceledOnTouchOutside(true);
                jVar.h(lVar);
                jVar.l();
                TiebaStatic.log(new StatisticItem("c14200"));
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        f52510a = str;
        if (!TextUtils.isEmpty(y.w())) {
            c();
        } else {
            e(false, false);
        }
    }

    public static void e(boolean z, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                i2 = 0;
            } else if (z2) {
                i2 = 2;
            } else {
                y.r("");
                i2 = 1;
            }
            c.f52515c.c(i2, TbadkCoreApplication.getInst().getCurrentActivity());
        }
    }
}
