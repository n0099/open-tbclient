package d.a.p0.h2.k.e.e1;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.b1.m.f;
import d.a.o0.r.q.b2;
import d.a.p0.a0.e0.j;
import d.a.p0.a0.e0.k;
import d.a.p0.a0.e0.l;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.a.p0.a0.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, String str, d.a.p0.a0.e0.b bVar) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = bVar;
        }

        @Override // d.a.o0.b1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                d.a.p0.a0.e0.b bVar = this.l;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).S();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<n> list2, String str, int i2) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, list, list2, str, i2) == null) {
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ThreadInfo threadInfo = list.get(i4);
                if (threadInfo != null) {
                    b2 b2Var2 = new b2();
                    b2Var2.F2 = i4 + 1;
                    b2Var2.I2(threadInfo);
                    if (b2Var2.V() != null && !TextUtils.isEmpty(str)) {
                        b2Var2.V().j = str;
                    }
                    if ((k.W(b2Var2) || l.R(b2Var2)) && b2Var2.getType() != b2.q3) {
                        k d2 = d(b2Var2, i2);
                        if (d2 != null && (b2Var = d2.f53795e) != null && b2Var.V() != null && !StringUtils.isNull(b2Var.V().f52815b)) {
                            d2.l = b2Var2.n1();
                            d2.position = i3;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] d0 = b2Var2.d0();
                        d.a.p0.a0.e0.b c2 = c(b2Var2, i2);
                        if (c2 != null) {
                            c2.l = b2Var2.n1();
                            c2.position = i3;
                            if (c2 instanceof k) {
                                if (b2Var2.N2() == 1) {
                                    h(c2);
                                    c2.o = d0[0];
                                    c2.p = d0[1];
                                } else if (b2Var2.N2() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f53795e.z1();
                            if (!b2Var2.p2() && b2Var2.H() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), b2Var2.H().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new a(16, b2Var2.H().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f53795e.A1(spannableString);
                            }
                            list2.add(c2);
                        }
                        k d3 = d(b2Var2, i2);
                        if (d3 != null) {
                            d3.l = b2Var2.n1();
                            d3.position = i3;
                            e(d3);
                        }
                        if (d3 != null && d3.isValid()) {
                            list2.add(d3);
                        }
                    }
                    i3++;
                }
            }
        }
    }

    public static List<n> b(List<ThreadInfo> list, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, list, str, i2)) == null) {
            LinkedList linkedList = new LinkedList();
            a(list, linkedList, str, i2);
            return linkedList;
        }
        return (List) invokeLLI.objValue;
    }

    public static d.a.p0.a0.e0.b c(b2 b2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, b2Var, i2)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (k.W(b2Var)) {
                k kVar = new k();
                b2Var.V1();
                b2Var.j2();
                if (!b2Var.V1() && !b2Var.j2()) {
                    b2Var.Q1();
                }
                kVar.f53795e = b2Var;
                kVar.G = i2;
                return kVar;
            } else if (l.R(b2Var)) {
                l lVar = new l(b2Var);
                lVar.G = i2;
                return lVar;
            } else {
                return null;
            }
        }
        return (d.a.p0.a0.e0.b) invokeLI.objValue;
    }

    public static k d(b2 b2Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, b2Var, i2)) == null) {
            k kVar = new k();
            kVar.f53795e = b2Var;
            b2Var.V1();
            if (!b2Var.V1()) {
                b2Var.Q1();
            }
            kVar.G = i2;
            return kVar;
        }
        return (k) invokeLI.objValue;
    }

    public static void e(d.a.p0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            if (bVar instanceof k) {
                ((k) bVar).E = true;
            } else if (bVar instanceof l) {
                ((l) bVar).E = true;
            } else if (bVar instanceof j) {
                ((j) bVar).E = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void f(d.a.p0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(d.a.p0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bVar) == null) {
            ((k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(d.a.p0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bVar) == null) {
            ((k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(d.a.p0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, bVar) == null) {
            ((k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(d.a.p0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bVar) == null) {
            ((l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
