package com.repackage;

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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class hw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public zs7 b;
    public v36 c;
    public View.OnTouchListener d;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hw7 a;

        public a(hw7 hw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hw7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.c != null) {
                    this.a.c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends sg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(hw7 hw7Var, int i, String str, ny5 ny5Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw7Var, Integer.valueOf(i), str, ny5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ny5Var;
        }

        @Override // com.repackage.sg5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                ny5 ny5Var = this.h;
                if (ny5Var instanceof vy5) {
                    statisticItem = ((vy5) ny5Var).S();
                } else if (ny5Var instanceof wy5) {
                    statisticItem = ((wy5) ny5Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public hw7(BdTypeRecyclerView bdTypeRecyclerView, zs7 zs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, zs7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.d = aVar;
        this.a = bdTypeRecyclerView;
        this.b = zs7Var;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.c = new v36();
    }

    public final void b(List<ThreadInfo> list, List<nn> list2, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i2 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null) {
                        threadData2.getForumData().j = str;
                    }
                    if ((vy5.W(threadData2) || wy5.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        vy5 d = d(threadData2);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        ny5 c = c(threadData2);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i;
                            if (c instanceof vy5) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof wy5) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a3), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        vy5 d2 = d(threadData2);
                        if (d2 != null) {
                            d2.g = threadData2.getTid();
                            d2.position = i;
                            e(d2);
                        }
                        if (d2 != null && d2.isValid()) {
                            list2.add(d2);
                        }
                    }
                    i++;
                }
            }
        }
    }

    public final ny5 c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (vy5.W(threadData)) {
                vy5 vy5Var = new vy5();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                vy5Var.a = threadData;
                return vy5Var;
            } else if (wy5.R(threadData)) {
                return new wy5(threadData);
            } else {
                return null;
            }
        }
        return (ny5) invokeL.objValue;
    }

    public final vy5 d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            vy5 vy5Var = new vy5();
            vy5Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return vy5Var;
        }
        return (vy5) invokeL.objValue;
    }

    public final void e(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ny5Var) == null) {
            if (ny5Var instanceof vy5) {
                ((vy5) ny5Var).A = true;
            } else if (ny5Var instanceof wy5) {
                ((wy5) ny5Var).A = true;
            } else if (ny5Var instanceof uy5) {
                ((uy5) ny5Var).A = true;
            }
            ny5Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ny5Var) == null) {
            ny5Var.n = true;
            ny5Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ny5Var) == null) {
            ((vy5) ny5Var).q = true;
            ny5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ny5Var) == null) {
            ((vy5) ny5Var).p = true;
            ny5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ny5Var) == null) {
            ((vy5) ny5Var).r = true;
            ny5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(ny5 ny5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ny5Var) == null) {
            ((wy5) ny5Var).s = true;
            ny5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        String first_class = jr7Var.l() != null ? jr7Var.l().getFirst_class() : "";
        List<ThreadInfo> I = jr7Var.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.b.h(linkedList);
    }
}
