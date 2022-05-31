package com.repackage;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes5.dex */
public class dv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends se5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw5 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, String str, rw5 rw5Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, rw5Var};
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
            this.h = rw5Var;
        }

        @Override // com.repackage.se5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                rw5 rw5Var = this.h;
                if (rw5Var instanceof zw5) {
                    statisticItem = ((zw5) rw5Var).S();
                } else if (rw5Var instanceof ax5) {
                    statisticItem = ((ax5) rw5Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public static void a(List<ThreadInfo> list, List<jn> list2, String str, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65536, null, list, list2, str, i) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i3 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null && !TextUtils.isEmpty(str)) {
                        threadData2.getForumData().j = str;
                    }
                    if ((zw5.W(threadData2) || ax5.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        zw5 d = d(threadData2, i);
                        if (d != null && (threadData = d.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                            d.g = threadData2.getTid();
                            d.position = i2;
                            f(d);
                            list2.add(d);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        rw5 c = c(threadData2, i);
                        if (c != null) {
                            c.g = threadData2.getTid();
                            c.position = i2;
                            if (c instanceof zw5) {
                                if (threadData2.picCount() == 1) {
                                    h(c);
                                    c.j = imageWidthAndHeight[0];
                                    c.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c);
                                } else {
                                    i(c);
                                }
                            } else if (c instanceof ax5) {
                                j(c);
                            }
                        }
                        if (c != null && c.isValid()) {
                            c.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a0), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new a(16, threadData2.getAuthor().getUserId(), c), 0, format.length() - 1, 33);
                                c.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c);
                        }
                        zw5 d2 = d(threadData2, i);
                        if (d2 != null) {
                            d2.g = threadData2.getTid();
                            d2.position = i2;
                            e(d2);
                        }
                        if (d2 != null && d2.isValid()) {
                            list2.add(d2);
                        }
                    }
                    i2++;
                }
            }
        }
    }

    public static List<jn> b(List<ThreadInfo> list, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, list, str, i)) == null) {
            LinkedList linkedList = new LinkedList();
            a(list, linkedList, str, i);
            return linkedList;
        }
        return (List) invokeLLI.objValue;
    }

    public static rw5 c(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, threadData, i)) == null) {
            if (threadData == null) {
                return null;
            }
            if (zw5.W(threadData)) {
                zw5 zw5Var = new zw5();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                zw5Var.a = threadData;
                zw5Var.C = i;
                return zw5Var;
            } else if (ax5.R(threadData)) {
                ax5 ax5Var = new ax5(threadData);
                ax5Var.C = i;
                return ax5Var;
            } else {
                return null;
            }
        }
        return (rw5) invokeLI.objValue;
    }

    public static zw5 d(ThreadData threadData, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) {
            zw5 zw5Var = new zw5();
            zw5Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            zw5Var.C = i;
            return zw5Var;
        }
        return (zw5) invokeLI.objValue;
    }

    public static void e(rw5 rw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, rw5Var) == null) {
            if (rw5Var instanceof zw5) {
                ((zw5) rw5Var).A = true;
            } else if (rw5Var instanceof ax5) {
                ((ax5) rw5Var).A = true;
            } else if (rw5Var instanceof yw5) {
                ((yw5) rw5Var).A = true;
            }
            rw5Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void f(rw5 rw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, rw5Var) == null) {
            rw5Var.n = true;
            rw5Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void g(rw5 rw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, rw5Var) == null) {
            ((zw5) rw5Var).q = true;
            rw5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void h(rw5 rw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, rw5Var) == null) {
            ((zw5) rw5Var).p = true;
            rw5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void i(rw5 rw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, rw5Var) == null) {
            ((zw5) rw5Var).r = true;
            rw5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void j(rw5 rw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, rw5Var) == null) {
            ((ax5) rw5Var).s = true;
            rw5Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
