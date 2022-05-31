package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class hr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public qu7 c;
    public su7 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.y g;
    public mq7 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public ir7 k;
    public List<wm> l;
    public kp7 m;
    public ArrayList<jn> n;

    public hr7(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {foldCommentActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.n = new ArrayList<>();
        this.a = foldCommentActivity;
        this.b = bdTypeListView;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, vv7.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.b0(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            ir7 ir7Var = new ir7(foldCommentActivity, PostData.x0, foldCommentActivity.getPageContext());
            this.k = ir7Var;
            ir7Var.J0(this.c);
            this.k.K0(this.d);
            this.k.M0(this.a);
            this.k.l(this.e);
            this.k.e(this.f);
            this.k.o(this.g);
            this.k.L0(this.h);
            this.k.d(this.i);
            this.l.add(this.k);
            this.b.a(this.l);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.b.getAdapter2() == null) {
            return;
        }
        this.b.getAdapter2().notifyDataSetChanged();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f = onClickListener;
        }
    }

    public void d(boolean z) {
        ir7 ir7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (ir7Var = this.k) == null) {
            return;
        }
        ir7Var.setFromCDN(z);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            this.g = yVar;
        }
    }

    public void g(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onLongClickListener) == null) {
            this.i = onLongClickListener;
        }
    }

    public void h(kp7 kp7Var) {
        ir7 ir7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kp7Var) == null) {
            this.m = kp7Var;
            ir7 ir7Var2 = this.k;
            if (ir7Var2 != null) {
                ir7Var2.t(kp7Var);
            }
            this.n.clear();
            kp7 kp7Var2 = this.m;
            if (kp7Var2 != null && kp7Var2.F() != null && this.m.F().size() > 0) {
                vv7 vv7Var = new vv7();
                vv7Var.b(kp7Var.F().size());
                this.n.add(vv7Var);
                Iterator<PostData> it = this.m.F().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.w0) {
                        this.n.add(next);
                    }
                }
            }
            if (kp7Var.O() != null && kp7Var.O().getAuthor() != null && (ir7Var = this.k) != null) {
                ir7Var.q(kp7Var.O().getAuthor().getUserId());
            }
            if (this.m != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_HAS_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.m.m());
                statisticItem.param("fname", this.m.n());
                statisticItem.param("tid", this.m.Q());
                TiebaStatic.log(statisticItem);
            }
            this.b.setData(this.n);
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void i(qu7 qu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qu7Var) == null) {
            this.c = qu7Var;
        }
    }

    public void j(su7 su7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, su7Var) == null) {
            this.d = su7Var;
        }
    }

    public void k(mq7 mq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mq7Var) == null) {
            this.h = mq7Var;
        }
    }
}
