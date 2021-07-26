package d.a.q0.h2.k.e.b1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.a0.e0.j;
import d.a.q0.a0.e0.k;
import d.a.q0.a0.e0.l;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdTypeRecyclerView f57685a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.h2.k.c.b f57686b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.i0.a f57687c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f57688d;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f57689e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57689e = hVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f57689e.f57687c != null) {
                    this.f57689e.f57687c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends d.a.p0.d1.m.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.a.q0.a0.e0.b l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2, String str, d.a.q0.a0.e0.b bVar) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2), str, bVar};
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

        @Override // d.a.p0.d1.m.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                d.a.q0.a0.e0.b bVar = this.l;
                if (bVar instanceof k) {
                    statisticItem = ((k) bVar).S();
                } else if (bVar instanceof l) {
                    statisticItem = ((l) bVar).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public h(BdTypeRecyclerView bdTypeRecyclerView, d.a.q0.h2.k.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.f57688d = aVar;
        this.f57685a = bdTypeRecyclerView;
        this.f57686b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f57687c = new d.a.q0.i0.a();
    }

    public final void b(List<ThreadInfo> list, List<n> list2, String str) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null) {
                    b2 b2Var2 = new b2();
                    b2Var2.F2 = i3 + 1;
                    b2Var2.K2(threadInfo);
                    if (b2Var2.W() != null) {
                        b2Var2.W().j = str;
                    }
                    if ((k.W(b2Var2) || l.R(b2Var2)) && b2Var2.getType() != b2.w3) {
                        k d2 = d(b2Var2);
                        if (d2 != null && (b2Var = d2.f54338e) != null && b2Var.W() != null && !StringUtils.isNull(b2Var.W().f53479b)) {
                            d2.l = b2Var2.o1();
                            d2.position = i2;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] e0 = b2Var2.e0();
                        d.a.q0.a0.e0.b c2 = c(b2Var2);
                        if (c2 != null) {
                            c2.l = b2Var2.o1();
                            c2.position = i2;
                            if (c2 instanceof k) {
                                if (b2Var2.P2() == 1) {
                                    h(c2);
                                    c2.o = e0[0];
                                    c2.p = e0[1];
                                } else if (b2Var2.P2() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.f54338e.A1();
                            if (!b2Var2.r2() && b2Var2.H() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.at_username), b2Var2.H().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, b2Var2.H().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.f54338e.B1(spannableString);
                            }
                            list2.add(c2);
                        }
                        k d3 = d(b2Var2);
                        if (d3 != null) {
                            d3.l = b2Var2.o1();
                            d3.position = i2;
                            e(d3);
                        }
                        if (d3 != null && d3.isValid()) {
                            list2.add(d3);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public final d.a.q0.a0.e0.b c(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var)) == null) {
            if (b2Var == null) {
                return null;
            }
            if (k.W(b2Var)) {
                k kVar = new k();
                b2Var.W1();
                b2Var.k2();
                if (!b2Var.W1() && !b2Var.k2()) {
                    b2Var.R1();
                }
                kVar.f54338e = b2Var;
                return kVar;
            } else if (l.R(b2Var)) {
                return new l(b2Var);
            } else {
                return null;
            }
        }
        return (d.a.q0.a0.e0.b) invokeL.objValue;
    }

    public final k d(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var)) == null) {
            k kVar = new k();
            kVar.f54338e = b2Var;
            b2Var.W1();
            if (!b2Var.W1()) {
                b2Var.R1();
            }
            return kVar;
        }
        return (k) invokeL.objValue;
    }

    public final void e(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
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

    public final void f(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ((k) bVar).v = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ((k) bVar).u = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            ((k) bVar).w = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(d.a.q0.a0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            ((l) bVar).x = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        String first_class = eVar.m() != null ? eVar.m().getFirst_class() : "";
        List<ThreadInfo> H = eVar.H();
        LinkedList linkedList = new LinkedList();
        b(H, linkedList, first_class);
        this.f57686b.h(linkedList);
    }
}
