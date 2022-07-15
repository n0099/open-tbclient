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
public class gt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FoldCommentActivity a;
    public BdTypeListView b;
    public rw7 c;
    public tw7 d;
    public View.OnClickListener e;
    public View.OnClickListener f;
    public TbRichTextView.y g;
    public ls7 h;
    public View.OnLongClickListener i;
    public SubPbReplyAdapter j;
    public ht7 k;
    public List<an> l;
    public jr7 m;
    public ArrayList<nn> n;

    public gt7(FoldCommentActivity foldCommentActivity, BdTypeListView bdTypeListView) {
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
            SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.a, wx7.b);
            this.j = subPbReplyAdapter;
            subPbReplyAdapter.b0(false);
            this.l.add(this.j);
            FoldCommentActivity foldCommentActivity = this.a;
            ht7 ht7Var = new ht7(foldCommentActivity, PostData.A0, foldCommentActivity.getPageContext());
            this.k = ht7Var;
            ht7Var.J0(this.c);
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
        ht7 ht7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (ht7Var = this.k) == null) {
            return;
        }
        ht7Var.setFromCDN(z);
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

    public void h(jr7 jr7Var) {
        ht7 ht7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jr7Var) == null) {
            this.m = jr7Var;
            ht7 ht7Var2 = this.k;
            if (ht7Var2 != null) {
                ht7Var2.s(jr7Var);
            }
            this.n.clear();
            jr7 jr7Var2 = this.m;
            if (jr7Var2 != null && jr7Var2.F() != null && this.m.F().size() > 0) {
                wx7 wx7Var = new wx7();
                wx7Var.b(jr7Var.F().size());
                this.n.add(wx7Var);
                Iterator<PostData> it = this.m.F().iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next.getType() != PostData.z0) {
                        this.n.add(next);
                    }
                }
            }
            if (jr7Var.O() != null && jr7Var.O().getAuthor() != null && (ht7Var = this.k) != null) {
                ht7Var.p(jr7Var.O().getAuthor().getUserId());
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

    public void i(rw7 rw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rw7Var) == null) {
            this.c = rw7Var;
        }
    }

    public void j(tw7 tw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tw7Var) == null) {
            this.d = tw7Var;
        }
    }

    public void k(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ls7Var) == null) {
            this.h = ls7Var;
        }
    }
}
